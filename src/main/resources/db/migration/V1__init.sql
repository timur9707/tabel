drop table if exists departments;
drop table if exists employees;

create table departments (
    id  serial primary key,
    dep_name varchar(255) unique
);

create table employees (
    id bigserial primary key,
    first_name varchar(30) not null,
    last_name varchar(30) not null,
    patronymic varchar(30),
    age int8 not null,
    birthdate date not null,
    position varchar(30) not null,
    is_remote boolean,
    address varchar(255) not null,
    department_id int8 not null
);

create table calendar (
    full_date date primary key,
    month_name varchar,
    day_of_week varchar(12),
    is_working_day boolean
);

create table work_status_code (
    id serial primary key,
    code varchar(2),
    description varchar(255)
);

create table employee_date_record (
    calendar_date date,
    employee_id bigserial,
    code_id int8,
    primary key (calendar_date, employee_id)
);

alter table employees
    add constraint dep_constraint
    foreign key (department_id)
    references departments(id);

ALTER TABLE employee_date_record
    add constraint work_status_code_constaint
    foreign key (code_id)
    references work_status_code(id);

/*alter table employee_date_record
    add constraint date_constraint
    foreign key (calendar_date)
    references calendar(full_date);*/

alter table employee_date_record
    add constraint employee_constraint
    foreign key (employee_id)
    references employees(id);