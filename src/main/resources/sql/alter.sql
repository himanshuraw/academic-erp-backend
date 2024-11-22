-- Add foreign keys to FacultyCourse
ALTER TABLE faculty_course
    ADD CONSTRAINT fk_faculty_id FOREIGN KEY (faculty_id)
        REFERENCES employee(id);

ALTER TABLE faculty_course
    ADD CONSTRAINT fk_course_id_faculty FOREIGN KEY (course_id)
        REFERENCES course(id);

-- Add foreign key to CourseSchedule
ALTER TABLE course_schedule
    ADD CONSTRAINT fk_course_id_schedule FOREIGN KEY (course_id)
        REFERENCES course(id);
