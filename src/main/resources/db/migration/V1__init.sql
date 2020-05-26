DROP TABLE if EXISTS departments;
DROP TABLE if EXISTS employees;

CREATE TABLE departments (
    id  smallserial PRIMARY KEY,
    dep_name varchar(255) UNIQUE
);

CREATE TABLE employees (
    id bigserial PRIMARY KEY,
    first_name varchar(30) NOT NULL,
    last_name varchar(30) NOT NULL,
    patronymic varchar(30),
    age int8 NOT NULL,
    birthdate date NOT NULL,
    position varchar(30) NOT NULL,
    is_remote boolean,
    address varchar(255) NOT NULL,
    department_id int8 NOT NULL
);

CREATE TABLE work_status_code (
    id smallserial PRIMARY KEY,
    code varchar(2),
    description varchar(255)
);

CREATE TABLE employee_date_record (
    calendar_date date,
    employee_id bigserial,
    code_id int8,
    PRIMARY KEY (calendar_date, employee_id)
);

ALTER TABLE employees
    ADD CONSTRAINT dep_constraint
    FOREIGN KEY (department_id)
    REFERENCES departments(id);

ALTER TABLE employee_date_record
    ADD CONSTRAINT work_status_code_constaint
    FOREIGN KEY (code_id)
    REFERENCES work_status_code(id);

ALTER TABLE employee_date_record
    ADD CONSTRAINT employee_constraint
    FOREIGN KEY (employee_id)
    REFERENCES employees(id);