drop table if exists student;
create table if not exists student
(
    id int generated by default as identity primary key,
    name varchar(80),
    surname varchar(100),
    course_name varchar(100)
);

insert into student (name, surname, course_name) VALUES ('Alex', 'Marshal', 'Java');