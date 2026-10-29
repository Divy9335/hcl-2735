
import React, { useCallback, useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";

const API = "http://localhost:8080/v1/user";

const Home = () => {
    const location = useLocation();
    const navigate = useNavigate();

    // Received from Login.jsx after successful login
    const empid = location.state?.empid;

    const [employee, setEmployee] = useState(null);
    const [attendance, setAttendance] = useState([]);
    const [loading, setLoading] = useState(true);
    const [busy, setBusy] = useState(false);
    const [error, setError] = useState("");
    const [message, setMessage] = useState("");
    const [showHistory, setShowHistory] = useState(true);

    const today = new Date().toLocaleDateString("en-CA");

    const loadDashboard = useCallback(async () => {
        if (!empid) return;

        setError("");

        try {
            const [employeeResponse, attendanceResponse] =
                await Promise.all([
                    fetch(`${API}/findById/${empid}`),
                    fetch(`${API}/attendance/${empid}`)
                ]);

            if (!employeeResponse.ok) {
                throw new Error("Could not load employee details.");
            }

            if (!attendanceResponse.ok) {
                throw new Error(
                    "Could not load attendance. Check your AttendanceController."
                );
            }

            const employeeData = await employeeResponse.json();
            const attendanceData = await attendanceResponse.json();

            setEmployee(employeeData);
            setAttendance(Array.isArray(attendanceData) ? attendanceData : []);
        } catch (err) {
            setError(err.message || "Unable to connect to the server.");
        } finally {
            setLoading(false);
        }
    }, [empid]);

    useEffect(() => {
        if (!empid) {
            navigate("/login", { replace: true });
            return;
        }

        loadDashboard();
    }, [empid, navigate, loadDashboard]);

    const todayRecord = attendance.find((record) => {
        const date = String(record.attendancedate || "").slice(0, 10);
        return date === today;
    });

    const checkedIn = Boolean(todayRecord?.inTime);
    const checkedOut = Boolean(todayRecord?.outTime);

    async function markAttendance() {
        if (todayRecord) {
            setMessage("Attendance is already marked for today.");
            return;
        }

        setBusy(true);
        setMessage("");

        try {
            const response = await fetch(
                `${API}/attendance/markAttendance`,
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        employee: {
                            empid: Number(empid)
                        }
                    })
                }
            );

            const result = await response.text();

            if (
                !response.ok ||
                result.toLowerCase().includes("not marked") ||
                result.toLowerCase().includes("not found") ||
                result.toLowerCase().includes("already")
            ) {
                setMessage(result || "Unable to mark attendance.");
                return;
            }

            setMessage(result || "Attendance marked successfully.");
            await loadDashboard();
        } catch (err) {
            setMessage("Unable to connect to the server.");
        } finally {
            setBusy(false);
        }
    }

    async function markCheckOut() {
        if (!todayRecord?.attendanceId || !checkedIn || checkedOut) {
            return;
        }

        setBusy(true);
        setMessage("");

        try {
            const response = await fetch(
                `${API}/attendance/checkOut/${todayRecord.attendanceId}`,
                { method: "PUT" }
            );

            const result = await response.text();

            if (!response.ok) {
                setMessage(result || "Unable to mark check-out.");
                return;
            }

            setMessage(result || "Check-out marked successfully.");
            await loadDashboard();
        } catch (err) {
            setMessage("Unable to connect to the server.");
        } finally {
            setBusy(false);
        }
    }

    function formatTime(value) {
        if (!value) return "--:--";

        // Handles ISO date-time values returned by Spring Boot
        const date = new Date(value);

        return Number.isNaN(date.getTime())
            ? String(value)
            : date.toLocaleTimeString([], {
                  hour: "2-digit",
                  minute: "2-digit",
                  hour12: true
              });
    }

    function logout() {
        navigate("/login", { replace: true });
    }

    if (loading) {
        return (
            <div className="flex min-h-screen items-center justify-center bg-slate-950 text-white">
                Loading your dashboard...
            </div>
        );
    }

    if (error || !employee) {
        return (
            <div className="flex min-h-screen flex-col items-center justify-center gap-4 bg-slate-950 px-6 text-white">
                <p className="text-center text-red-300">
                    {error || "Employee details not found."}
                </p>

                <button
                    onClick={() => navigate("/login")}
                    className="rounded-xl bg-indigo-600 px-5 py-3 font-semibold hover:bg-indigo-500"
                >
                    Back to Login
                </button>

                <button
                    onClick={() => {
                        setLoading(true);
                        loadDashboard();
                    }}
                    className="text-indigo-300 hover:underline"
                >
                    Retry
                </button>
            </div>
        );
    }

    return (
        <div className="min-h-screen bg-slate-950 text-white">
            {/* Navbar */}
            <nav className="border-b border-white/10 bg-slate-900">
                <div className="mx-auto flex max-w-7xl items-center justify-between px-5 py-4 sm:px-8">
                    <h1 className="text-2xl font-extrabold tracking-tight">
                        <span className="text-indigo-400">HR</span>MS
                    </h1>

                    <button
                        onClick={logout}
                        className="rounded-lg border border-red-400/30 px-4 py-2 text-sm font-semibold text-red-300 hover:bg-red-500/10"
                    >
                        Logout
                    </button>
                </div>
            </nav>

            <main className="mx-auto max-w-7xl px-5 py-10 sm:px-8">
                {/* Welcome */}
                <section className="mb-8">
                    <p className="text-sm font-semibold uppercase tracking-[0.2em] text-indigo-400">
                        Employee Portal
                    </p>

                    <h2 className="mt-3 text-3xl font-bold sm:text-4xl">
                        Welcome, {employee.name}!
                    </h2>

                    <p className="mt-3 text-slate-400">
                        Manage your profile and daily attendance in one place.
                    </p>
                </section>

                {/* Employee details */}
                <section className="mb-8 rounded-2xl border border-white/10 bg-slate-900 p-6 sm:p-8">
                    <div className="mb-6 flex items-center gap-4">
                        <div className="flex h-16 w-16 shrink-0 items-center justify-center rounded-2xl bg-indigo-600 text-2xl font-bold">
                            {employee.name?.charAt(0)?.toUpperCase() || "E"}
                        </div>

                        <div>
                            <h3 className="text-xl font-bold">
                                {employee.name}
                            </h3>
                            <p className="mt-1 text-sm text-slate-400">
                                {employee.designation || "Employee"}
                            </p>
                        </div>
                    </div>

                    <div className="grid gap-5 border-t border-white/10 pt-6 sm:grid-cols-2 lg:grid-cols-3">
                        {[
                            ["Employee ID", employee.empid],
                            ["Email", employee.email],
                            ["Designation", employee.designation],
                            ["Tech Stack", employee.techStack]
                        ].map(([label, value]) => (
                            <div key={label} className="min-w-0">
                                <p className="text-sm text-slate-400">
                                    {label}
                                </p>
                                <p className="mt-2 break-words font-medium">
                                    {value || "Not provided"}
                                </p>
                            </div>
                        ))}
                    </div>
                </section>

                {/* Attendance */}
                <section className="mb-8 rounded-2xl border border-white/10 bg-slate-900 p-6 sm:p-8">
                    <div className="flex flex-col justify-between gap-5 sm:flex-row sm:items-center">
                        <div>
                            <p className="text-sm font-semibold uppercase tracking-widest text-indigo-400">
                                Daily Attendance
                            </p>

                            <h3 className="mt-2 text-2xl font-bold">
                                {checkedOut
                                    ? "Your day is completed"
                                    : checkedIn
                                    ? "You're checked in"
                                    : "Mark your attendance"}
                            </h3>

                            <p className="mt-2 text-sm text-slate-400">
                                {new Date().toLocaleDateString(undefined, {
                                    weekday: "long",
                                    day: "numeric",
                                    month: "long",
                                    year: "numeric"
                                })}
                            </p>
                        </div>

                        <span
                            className={`w-fit rounded-full px-4 py-2 text-sm font-semibold ${
                                checkedOut
                                    ? "bg-emerald-500/10 text-emerald-300"
                                    : checkedIn
                                    ? "bg-amber-500/10 text-amber-300"
                                    : "bg-slate-800 text-slate-300"
                            }`}
                        >
                            {checkedOut
                                ? "Completed"
                                : checkedIn
                                ? "Checked In"
                                : "Not Marked"}
                        </span>
                    </div>

                    <div className="mt-6 grid gap-4 sm:grid-cols-2">
                        <div className="rounded-xl border border-white/5 bg-slate-800/70 p-5">
                            <p className="text-sm text-slate-400">
                                Check-in Time
                            </p>
                            <p className="mt-2 text-2xl font-bold">
                                {formatTime(todayRecord?.inTime)}
                            </p>
                        </div>

                        <div className="rounded-xl border border-white/5 bg-slate-800/70 p-5">
                            <p className="text-sm text-slate-400">
                                Check-out Time
                            </p>
                            <p className="mt-2 text-2xl font-bold">
                                {formatTime(todayRecord?.outTime)}
                            </p>
                        </div>
                    </div>

                    <div className="mt-6 flex flex-col gap-3 sm:flex-row">
                        <button
                            onClick={markAttendance}
                            disabled={busy || Boolean(todayRecord)}
                            className="rounded-xl bg-indigo-600 px-6 py-3 font-semibold transition hover:bg-indigo-500 disabled:cursor-not-allowed disabled:opacity-40"
                        >
                            {busy
                                ? "Processing..."
                                : todayRecord
                                ? "Attendance Marked"
                                : "Mark My Attendance"}
                        </button>

                        <button
                            onClick={markCheckOut}
                            disabled={busy || !checkedIn || checkedOut}
                            className="rounded-xl border border-emerald-400/30 bg-emerald-500/10 px-6 py-3 font-semibold text-emerald-300 transition hover:bg-emerald-500/20 disabled:cursor-not-allowed disabled:opacity-40"
                        >
                            Mark Check-Out
                        </button>

                        <button
                            onClick={loadDashboard}
                            disabled={busy}
                            className="rounded-xl border border-white/10 px-6 py-3 font-semibold text-slate-300 hover:bg-white/5 disabled:opacity-40"
                        >
                            Refresh Data
                        </button>
                    </div>

                    {message && (
                        <p
                            role="status"
                            className="mt-5 rounded-lg bg-slate-800 p-4 text-sm text-indigo-200"
                        >
                            {message}
                        </p>
                    )}
                </section>

                {/* Attendance history */}
                <section className="rounded-2xl border border-white/10 bg-slate-900 p-6 sm:p-8">
                    <div className="flex flex-col justify-between gap-4 sm:flex-row sm:items-center">
                        <div>
                            <h3 className="text-xl font-bold">
                                Attendance History
                            </h3>
                            <p className="mt-1 text-sm text-slate-400">
                                Your recorded attendance entries.
                            </p>
                        </div>

                        <button
                            onClick={() => setShowHistory((prev) => !prev)}
                            className="rounded-lg border border-white/10 px-4 py-2 text-sm hover:bg-white/5"
                        >
                            {showHistory ? "Hide History" : "View History"}
                        </button>
                    </div>

                    {showHistory && (
                        <div className="mt-6">
                            {attendance.length === 0 ? (
                                <p className="py-8 text-center text-slate-400">
                                    No attendance records found.
                                </p>
                            ) : (
                                <div className="overflow-x-auto">
                                    <table className="w-full min-w-[560px] text-left text-sm">
                                        <thead className="border-b border-white/10 text-slate-400">
                                            <tr>
                                                <th className="px-4 py-4">Date</th>
                                                <th className="px-4 py-4">In-Time</th>
                                                <th className="px-4 py-4">Out-Time</th>
                                                <th className="px-4 py-4">Status</th>
                                            </tr>
                                        </thead>

                                        <tbody className="divide-y divide-white/5">
                                            {attendance.map((record) => (
                                                <tr key={record.attendanceId}>
                                                    <td className="px-4 py-4">
                                                        {String(record.attendancedate || "").slice(0, 10)}
                                                    </td>

                                                    <td className="px-4 py-4 text-slate-300">
                                                        {formatTime(record.inTime)}
                                                    </td>

                                                    <td className="px-4 py-4 text-slate-300">
                                                        {formatTime(record.outTime)}
                                                    </td>

                                                    <td className="px-4 py-4">
                                                        <span className={`rounded-full px-3 py-1 text-xs font-semibold ${
                                                            record.outTime
                                                                ? "bg-emerald-500/10 text-emerald-300"
                                                                : record.inTime
                                                                ? "bg-amber-500/10 text-amber-300"
                                                                : "bg-slate-800 text-slate-300"
                                                        }`}>
                                                            {record.outTime
                                                                ? "Completed"
                                                                : record.inTime
                                                                ? "Checked In"
                                                                : "Not Marked"}
                                                        </span>
                                                    </td>
                                                </tr>
                                            ))}
                                        </tbody>
                                    </table>
                                </div>
                            )}
                        </div>
                    )}
                </section>

                <footer className="py-8 text-center text-sm text-slate-500">
                    HRMS · Employee Management System
                </footer>
            </main>
        </div>
    );
};

export default Home;
