package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.repository.AttendanceRepo;
import org.abes.hrmsdatabase.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRep;

    @Autowired
    private EmployeeRepo employee;

    public String markAttendance(Attendance attendance) {

        long emp_id = attendance.getEmployee().getEmpid();

        if (employee.existsById(emp_id)) {

            if (!attendanceRep.existsByEmployee_EmpidAndAttendancedate(
                    emp_id, LocalDate.now())) {

                attendance.setAttendancedate(LocalDate.now());
                attendance.setInTime(LocalDateTime.now());
                attendance.setOutTime(null);
                attendanceRep.save(attendance);

                return "Attendance marked successfully";
            } else {
                return "Attendance already marked for today";
            }

        } else {
            return "Attendance not marked because employee is not found";
        }
    }

    public List<Attendance> getAttendanceByEmployee(long empid) {
        return attendanceRep
                .findByEmployee_EmpidOrderByAttendancedateDesc(empid);
    }

    public String checkOut(long attendanceId) {

        Optional<Attendance> optionalAttendance =
                attendanceRep.findById(attendanceId);

        if (optionalAttendance.isEmpty()) {
            return "Attendance record not found";
        }

        Attendance attendance = optionalAttendance.get();

        if (attendance.getOutTime() != null) {
            return "Attendance already checked out";
        }

        attendance.setOutTime(LocalDateTime.now());

        attendanceRep.save(attendance);

        return "Checkout marked successfully";
    }
}
