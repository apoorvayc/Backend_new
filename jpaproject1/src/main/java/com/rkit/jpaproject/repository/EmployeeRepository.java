package com.rkit.jpaproject.repository;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.rkit.jpaproject.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByNameIgnoreCase(String name);
}
