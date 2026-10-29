package org.abes.hrmsdatabase.controller;

import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.service.AttendanceService;
import org.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user/attendance")
@CrossOrigin(origins = "http://localhost:5173")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceSer;

    @PostMapping("/markAttendance")
    public String markAttendance(@RequestBody Attendance attendance){
        return attendanceSer.markAttendance(attendance);
    }
    @GetMapping("/{empid}")
    public List<Attendance> getAttendance(@PathVariable long empid) {
        return attendanceSer.getAttendanceByEmployee(empid);
    }

    @PutMapping("/checkOut/{attendanceId}")
    public String checkOut(@PathVariable long attendanceId) {
        return attendanceSer.checkOut(attendanceId);
    }
}
