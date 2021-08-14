package com.rkit.jpaproject.repository;

import com.rkit.jpaproject.entities.Pair;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rkit.jpaproject.entities.Emp_Rating;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpRatingRepository extends JpaRepository<Emp_Rating,Long>{


}
