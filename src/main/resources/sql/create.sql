CREATE DATABASE IF NOT EXISTS AcademicERP;

-- Use the AcademicERP database
USE AcademicERP;

-- Table: course
CREATE TABLE IF NOT EXISTS course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    year INT NOT NULL,
    term VARCHAR(20) NOT NULL,
    credits INT NOT NULL,
    capacity INT NOT NULL
);

-- Table: employee
CREATE TABLE IF NOT EXISTS employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    photograph_path VARCHAR(255),
    department VARCHAR(100)
);


-- Table: faculty_course
CREATE TABLE IF NOT EXISTS faculty_course (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   faculty_id BIGINT NOT NULL,
   course_id BIGINT NOT NULL
);


-- Table: course_schedule
CREATE TABLE IF NOT EXISTS course_schedule (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   course_id BIGINT NOT NULL,
   day VARCHAR(20),
   time VARCHAR(50),
   building VARCHAR(100),
   room VARCHAR(50)
);

