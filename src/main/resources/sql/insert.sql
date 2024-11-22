INSERT INTO course (code, name, description, year, term, credits, capacity)
VALUES
    ('CS101', 'Introduction to Computer Science', 'Basic concepts of programming, algorithms, and problem-solving', 2024, 'Spring', 4, 50),
    ('CS102', 'Data Structures', 'Study of linear and non-linear data structures like arrays, stacks, and graphs', 2024, 'Spring', 4, 45),
    ('CS201', 'Operating Systems', 'Fundamentals of operating systems, processes, memory management', 2024, 'Fall', 4, 40),
    ('CS202', 'Database Systems', 'Concepts of relational databases, SQL, and normalization techniques', 2024, 'Fall', 4, 50),
    ('CS301', 'Computer Networks', 'Introduction to network protocols, TCP/IP, and network devices', 2024, 'Spring', 4, 45),
    ('CS302', 'Software Engineering', 'Software development methodologies, lifecycle, and design patterns', 2024, 'Spring', 4, 40),
    ('EC101', 'Analog Electronics', 'Fundamentals of analog circuits, amplifiers, and oscillators', 2024, 'Spring', 3, 60),
    ('EC102', 'Digital Electronics', 'Study of digital logic, gates, and combinational circuits', 2024, 'Fall', 3, 55),
    ('EC201', 'Microprocessors', 'Architecture and programming of microprocessors and microcontrollers', 2024, 'Spring', 4, 50),
    ('EC202', 'Signal Processing', 'Analysis and processing of analog and digital signals', 2024, 'Fall', 3, 60);

INSERT INTO course_schedule (course_id, day, time, building, room)
VALUES
    (1, 'Monday', '10:00 AM - 11:30 AM', 'Ramanujan', 'R101'),
    (1, 'Wednesday', '10:00 AM - 11:30 AM', 'Ramanujan', 'R101'),
    (2, 'Tuesday', '11:30 AM - 01:00 PM', 'Aryabhatta', 'A102'),
    (2, 'Thursday', '11:30 AM - 01:00 PM', 'Aryabhatta', 'A102'),
    (3, 'Monday', '02:00 PM - 03:30 PM', 'Ramanujan', 'R201'),
    (3, 'Wednesday', '02:00 PM - 03:30 PM', 'Ramanujan', 'R201'),
    (4, 'Monday', '02:00 PM - 03:30 PM', 'Aryabhatta', 'A201'),  -- Overlaps with CS101 on Monday
    (4, 'Thursday', '02:00 PM - 03:30 PM', 'Aryabhatta', 'A201'),
    (5, 'Tuesday', '02:00 PM - 03:30 PM', 'Ramanujan', 'R301'),  -- Overlaps with CS101 on Tuesday
    (5, 'Thursday', '02:00 PM - 03:30 PM', 'Ramanujan', 'R301'),
    (6, 'Monday', '03:45 PM - 05:15 PM', 'Aryabhatta', 'A301'),
    (6, 'Wednesday', '03:45 PM - 05:15 PM', 'Aryabhatta', 'A301'),
    (7, 'Tuesday', '09:00 AM - 10:30 AM', 'Ramanujan', 'R102'),
    (7, 'Thursday', '09:00 AM - 10:30 AM', 'Ramanujan', 'R102'),
    (8, 'Monday', '09:00 AM - 10:30 AM', 'Aryabhatta', 'A103'),  -- Overlaps with CS102 on Monday
    (8, 'Wednesday', '09:00 AM - 10:30 AM', 'Aryabhatta', 'A103'),
    (9, 'Tuesday', '11:30 AM - 01:00 PM', 'Ramanujan', 'R202'),
    (9, 'Thursday', '11:30 AM - 01:00 PM', 'Ramanujan', 'R202'),
    (10, 'Monday', '11:30 AM - 01:00 PM', 'Aryabhatta', 'A202'),  -- Overlaps with CS104 on Monday
    (10, 'Wednesday', '11:30 AM - 01:00 PM', 'Aryabhatta', 'A202');
