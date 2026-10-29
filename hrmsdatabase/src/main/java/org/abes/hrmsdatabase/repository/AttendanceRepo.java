package org.abes.hrmsdatabase.repository;

import org.abes.hrmsdatabase.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance,Long> {

    boolean existsByEmployee_EmpidAndAttendancedate(long empid, LocalDate date);

    List<Attendance> findByEmployee_EmpidOrderByAttendancedateDesc(long empid);
}
