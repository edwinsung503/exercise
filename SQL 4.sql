create database org;
show databases;
use org;

create table worker(
	worker_id integer not null primary key auto_increment,
    first_name char(25),
    last_name char(25),
    salary numeric(15),
    joining_date datetime,
    department char(25)    
);

insert into worker (first_name,last_name, salary,joining_date, department ) 
values 
('Monika','Arora',100000,'21-02-20 09:00:00','HR'),
('Niharika','Verma',80000,'21-06-11 09:00:00','Admin'),
('Vishal','Singhal',300000,'21-02-20 09:00:00','HR'),
('Mohan','Sarah',300000,'12-03-19 09:00:00','Admin'),
('Amitabh','Singh',500000,'21-02-20 09:00:00','Admin'),
('Vivek','Bhati',490000,'21-06-11 09:00:00','Admin'),
('Vipul','Diwan',200000,'21-06-11 09:00:00','Account'),
('Satish','Kumar',75000,'21-01-20 09:00:00','Account'),
('Geetika','Chauhan',90000,'21-04-11 09:00:00','Admin');

select * from worker;

create table bonus (
	worker_ref_id integer,
    bonus_amount integer,
    bonus_date datetime,
    foreign key(worker_ref_id) references worker(worker_id)
);

-- Task 1
-- insert data into table bonus

insert into bonus (worker_ref_id,bonus_amount, bonus_date)
values 
(6,32000,'21-11-02 09:00:00'),
(6,20000,'22-11-02 09:00:00'),
(5,21000,'21-11-02 09:00:00'),
(9,30000,'21-11-02 09:00:00'),
(8,30000,'22-11-02 09:00:00');

select * from bonus;

-- task 2
-- write an SQL query to show the second highest salary among all workers
with 
	max_salary as (
		select max(salary) as max_salary
		from worker w
	)
select max( w1.salary) as salary
from worker w1
left join max_salary ms
on w1.salary = ms.max_salary
where ms.max_salary is null;

-- task 3
-- write an SQL query to print the name of employees having the hightest salary in each department

with 
	max_salary_table as (
		select max(w.salary) as salary, w.department
		from worker w
		group by w.department
    )
select w1.first_name, w1.last_name,mst.salary
from worker w1
left join max_salary_table mst
on w1.salary = mst.salary and w1.department = mst.department
where w1.salary = mst.salary;

-- task 4 
-- write an SQL query to fetch the list of employees with the same salary

select w1.first_name, w1.last_name
from worker w1
join worker w2
on w1.salary = w2.salary
where w1.salary = w2.salary and w1.first_name <> w2.first_name;

-- task  5
-- write an SQL query to find the worker names with salaries +  bonuse in 2021
with 
	bonus_table as (
		select b.worker_ref_id, b.bonus_amount,DATE_FORMAT(b.bonus_date, "%Y") as bouns_date
		from bonus b
	)
select w.first_name, w.last_name,bt.bonus_amount
from worker w
left join bonus_table bt
on w.worker_id = bt.worker_ref_id
where bouns_date = 2021;


-- task 6 (Please complete task 1-5 first)
-- Try to delete all the records in table worker
delete from worker;
-- study the reason why the data cannot be deleted
-- we are trying to delete a row from the 'worker' table that is associated with a row in the 'bonus' table through a foreign key. 
-- The foreign key constraint is in place to prevent operations that would destroy links between tables. 
-- A foreign key constraint requires that a group of one or more columns of the 'bonus' table match the primary key of some row of the 'worker' table.


-- task 7 (Please complete task 6 first)
-- try to drop table worker
drop table worker;
-- Study the reason why the table cannot be deleted
--  'worker' table cannot be dropped because it is referenced by a foreign key constraint in the 'bonus' table. 
-- Before we can drop the 'worker' table, we must first remove or alter the foreign key constraint in the 'bonus' table that references the 'worker' table.