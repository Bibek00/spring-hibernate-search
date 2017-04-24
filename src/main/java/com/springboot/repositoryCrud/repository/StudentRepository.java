package com.springboot.repositoryCrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.repositoryCrud.entity.Address;
import com.springboot.repositoryCrud.entity.Student;

import scala.native;

import scala.native;

import scala.native;

import scala.native;

import scala.native;

import scala.native;

import scala.native;

import scala.native;

import scala.native;

import scala.native;


@Transactional
public interface StudentRepository extends JpaRepository<Student,Integer> {


	@Query("Select s.fname from Student s where s.id = :id", native)
	List<Student> findStudentsByCountry(@Param("id") int id);
}
