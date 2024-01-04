CREATE DATABASE BOOTCAMP_EXERCISE1;
use BOOTCAMP_EXERCISE1;

create table regions(
	region_id integer primary key,
    region_name varchar(25)
);
insert into regions (region_id,region_name) values(1,'Europe');
insert into regions (region_id,region_name) values(2,'North America');
insert into regions (region_id,region_name) values(3,'Asia');
insert into regions (region_id,region_name) values(4,'Africa');
insert into regions (region_id,region_name) values(5,'South America');
insert into regions (region_id,region_name) values(6,'Antarctica');
insert into regions (region_id,region_name) values(7,'Australia');
select * from regions;

create table countries (
	country_id char(2) primary key,
    country_name varchar(40),
    region_id integer,
    foreign key (region_id) references regions(region_id)
);

insert into countries(country_id,country_name,region_id) values ('DE','Gremany',1);
insert into countries(country_id,country_name,region_id) values ('IT','Italy',1);
insert into countries(country_id,country_name,region_id) values ('JP','Japan',3);
insert into countries(country_id,country_name,region_id) values ('US','United State',2);
select * from countries;


create table locations (
	location_id integer primary key,
    street_address varchar(25),
    postal_code varchar(12),
    city varchar(30),
    state_province varchar(12),
    country_id char(2),
    foreign key (country_id) references countries(country_id)
);
insert into locations(location_id,street_address,postal_code,city,state_province,country_id) values(1000,'1297 Via Cola di Rie','989','Roma',null,'IT');
insert into locations(location_id,street_address,postal_code,city,state_province,country_id) values(1100,'93091 Calle della Te','10934','Venice',null,'IT');
insert into locations(location_id,street_address,postal_code,city,state_province,country_id) values(1200,'2017 Shinjuku-ku','1689','Tokyo','Tokyo JP',null);
insert into locations(location_id,street_address,postal_code,city,state_province,country_id) values(1400,'2014 Jabberwocky Rd','26192','Southlake','Texas','US');
update locations set country_id ='JP' where city = 'Tokyo';
select * from locations;

create table departments(
	department_id integer primary key,
    department_name varchar(30),
    manager_id integer,
    location_id integer,
    foreign key (location_id) references locations(location_id)
);
insert into departments(department_id,department_name,manager_id,location_id) values (10,'Administration',200,1100);
insert into departments(department_id,department_name,manager_id,location_id) values (20,'Marketing',201,1200);
insert into departments(department_id,department_name,manager_id,location_id) values (30,'Purchasing',202,1400);
select * from departments;

create table jobs(
	job_id varchar(10) primary key,
    job_title varchar(35),
    min_salary integer,
    max_salary integer
);
insert into jobs(job_id,job_title,min_salary,max_salary) values ('IT_PROG','Programmer',15000,22000);
insert into jobs(job_id,job_title,min_salary,max_salary) values ('MK_REP','Representive',8000,20000);
insert into jobs(job_id,job_title,min_salary,max_salary) values ('ST_CLERK','Clerk',15000,25000);
select * from jobs;

create table job_history(
	employee_id integer,
    start_date date not null,
    end_date date not null,
    job_id varchar(10),
    department_id integer,
    foreign key (department_id) references departments(department_id),
    foreign key (job_id) references jobs(job_id)
);
alter table job_history
ADD primary key (employee_id,start_date);
insert into job_history(employee_id,start_date,end_date,job_id,department_id) values (102,'1993-01-13','1998-07-24','IT_PROG',20);
insert into job_history(employee_id,start_date,end_date,job_id,department_id) values (101,'1989-09-21','1993-10-27','MK_REP',10);
insert into job_history(employee_id,start_date,end_date,job_id,department_id) values (101,'1993-10-28','1997-03-15','MK_REP',30);
insert into job_history(employee_id,start_date,end_date,job_id,department_id) values (100,'1996-02-17','1999-12-19','ST_CLERK',30);
insert into job_history(employee_id,start_date,end_date,job_id,department_id) values (103,'1998-03-24','1999-12-31','MK_REP',20);
select * from job_history;


create table employees (
	employee_id integer,
    first_name varchar(20),
    last_name varchar(25),
    email varchar(25),
    phone_number varchar(20),
    hire_date date not null,
    job_id varchar(10),
    salary integer,
    commission_pct integer,
    manager_id integer,
    department_id integer,
    foreign key (department_id) references departments(department_id),
    foreign key (job_id) references jobs(job_id),
    foreign key (employee_id) references job_history(employee_id)
);
insert into employees(employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id) values (100,'Steven','King','SKING','515-1234567','1987-06-17','ST_CLERK',24000,0.00,109,10);
insert into employees(employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id) values (101,'Neena','Kochhar','NKOCHHAR','515-1234568','1987-06-18','MK_REP',17000,0.00,103,20);
insert into employees(employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id) values (102,'Lex','De Haan','LDEHAAN','515-1234569','1987-06-19','IT_PROG',17000,0.00,108,30);
insert into employees(employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id) values (103,'Alexander','Hunold','AHUNOLD','590-4234567','1987-06-20','MK_REP',9000,0.00,105,20);
select * from employees;

-- 3.write a query to find the location_id, street_address, city, state_province, country_name of locations
select l.location_id,l.street_address,l.city,l.state_province,c.country_name
from locations l
left join countries c
on l.country_id = c.country_id;

-- 4.write a query to find the first_name, last_name, department id of all the employees
select e.first_name, e.last_name, e.department_id
from employees e;

-- 5.write a query to find the first_name, last_name, job_id, department_id of the employees who works in Japan
with 
	employee_department_table as (
		select e.first_name,e.last_name,e.job_id,e.department_id,d.location_id
		from employees e
		left join departments d
		on e.department_id = d.department_id
    ), employee_location_table as (
		select ed.first_name,ed.last_name,ed.job_id,ed.department_id,l.country_id
		from employee_department_table ed
		left join locations l
		on ed.location_id = l.location_id
    )
select el.first_name,el.last_name,el.job_id,el.department_id
from employee_location_table el
left join countries c
on el.country_id = c.country_id
where c.country_name = 'Japan';

-- 6.write a query to find the employee_id, last_name along with their manager_id and last_name
select e.employee_id, e.last_name, m.manager_id , m.last_name 
from Employees e
inner join Employees m on e.manager_id = m.employee_id;

-- 7.write a query to find the first_name, last_name and hire date of the employees who was hired after employee 'Lex De Haan'
with 
	Lex_De_Hann_hire_date_table as (
		select e.hire_date
		from employees e
		where concat(e.first_name,' ',e.last_name) = 'Lex De Haan'
	)
select e.first_name, e.last_name, e.hire_date
from employees e, Lex_De_Hann_hire_date_table ld
where e.hire_date > ld.hire_date;

-- 8.write a query to get the department name and number of employees of each the department.
select d.department_name, count(e.employee_id) as num_of_employees
from departments d
left join employees e
on d.department_id = e.department_id
group by d.department_name;

-- 9.write a query to find the employee_id ,job title, number of days between ending date and starting date for all jobs in departement id 30.
with 
	employee_days_table as (
		select jh.employee_id, jh.job_id,DATEDIFF(jh.end_date,jh.start_date) as num_of_days
		from job_history jh
		where jh.department_id = 30
    )
select ed.employee_id,j.job_title, ed.num_of_days
from employee_days_table ed
left join jobs j
on ed.job_id = j.job_id;

-- 10.write a query to display all department name, manager name, city and country name
with 
	city_country_table as (
		select l.city, c.country_name, l.location_id
		from locations l
		left join countries c
		on l.country_id = c.country_id
    ), department_locations_table as (
		select d.department_name,d.department_id,cct.city,cct.country_name
		from departments d
		left join city_country_table cct
		on d.location_id = cct.location_id
    )
select dlt.department_name,concat(e.first_name,' ',e.last_name) as manager_name, dlt.city, dlt.country_name
from department_locations_table dlt
left join employees e
on dlt.department_id = e.department_id;


-- 11.write a query to display the average salary of each department.
select avg(e.salary) as average_salary
from employees e
left join departments d
on e.department_id = d.department_id
group by e.department_id;

-- 12.Now, we try to perform normalization on table 'jobs'.
-- a.How do you re-design the table 'jobs'? and adding table 'job grades'?

create table job_grades(
	grade_level varchar(2) primary key,
    lowest_sal integer not null,
    highest_sal integer not null
);

select * from job_grades;

select * from jobs;

alter table jobs drop column min_salary;
alter table jobs drop column max_salary;
alter table jobs add column grade_level varchar(2);
alter table jobs add foreign key (grade_level) references job_grades(grade_level);
