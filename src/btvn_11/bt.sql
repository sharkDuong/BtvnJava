create database quanlysinhvienvakhoahoc;
use quanlysinhvienvakhoahoc;
create table Student (
                         id integer primary key auto_increment,
                         first_name varchar(50),
                         last_name varchar(50),
                         birth_date date,
                         email varchar(100)
)
create table Courses(
                        id integer primary key auto_increment,
                        course_name varchar(100),
                        course_description text
)
create table Enrollments(
                            id integer primary key auto_increment,
                            student_id integer,
                            course_id integer,
                            enrollment_date date
)
    insert into Student(id, first_name, last_name, birth_date, email)
    value
    (1,'pham','duong','2002-07-29','d@gmail.com'),
    (2,'bui','tung','2002-07-28','t@gmail.com'),
    (3,'nguyen','linh','2002-07-27','l@gmail.com'),
    (4,'le','khang','2002-07-26','k@gmail.com'),
    (5,'pham','manh','2002-07-25','m@gmail.com');
insert into Courses(id, course_name, course_description)
    value
    (1,'lap trinh java','hoc java'),
    (2,'lap trinh C','hoc C'),
    (3,'lap trinh python','hoc python');
insert into enrollments(student_id, course_id, enrollment_date)
    value
    (2,3,'2023-12-29'),
    (3,1,'2023-12-29'),
    (1,3,'2023-12-29'),
    (1,2,'2023-12-29'),
    (3,2,'2023-12-29');
--truy vấn tên,họ,mail
SELECT first_name, last_name, email FROM Student;
--truy vấn tên khóa học,mô tả
SELECT course_name, course_description FROM Courses;