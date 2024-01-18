create database bootcamp_exercise3;
show databases;
use bootcamp_exercise3;

create table city (
	id integer primary key,
	city_name varchar(255)
);

create table product (
	id integer primary key,
    sku varchar(32),
    product_name varchar(128),
    product_description text(255),
    current_price decimal(8,2),
    quantity_in_stock integer
);

create table customer (
	id integer primary key,
    customer_name varchar(25),
    city_id integer,
    customer_address varchar(255),
    contact_person varchar(255),
    email varchar(128),
    phone varchar(128),
    foreign key (city_id) references city (id)
);

create table invoice(
	id integer primary key,
    invoice_number varchar(255),
    customer_id integer ,
    user_account_id integer,
    total_price decimal(8,2),
    time_issued varchar(32),
    time_due varchar(32),
    time_paid varchar(32),
    time_canceled varchar(32),
    time_refunded varchar(32),
    foreign key (customer_id) references  customer(id)   
);
create table invoice_item (
	id integer primary key,
    invoice_id integer,
    product_id integer,
    quantity integer,
    price decimal (8,2),
    line_total_price decimal(8,2),
    foreign key (invoice_id) references invoice (id),
    foreign key (product_id) references product (id)
);

-- alter table customer drop foreign key customer_ibfk_1;


-- 1b.insert sample data to all of the created tables 

delete from city;
insert into city values 
(1,'15A'),
(4,'1A'),
(8,'18A');

delete from product;
insert into product values 
(1,'330120','9UP PRODUCT','COMPLETELY 9UP',60,122),
(2,'330121','9UPPER PRODUCT','COMPLETELY 9UPPER',50,50),
(3,'330122','9UPPER PRODUCTS','SUPER 9UPPER',40,600),
(4,'330123','9UPPER PRODUCTSS','SUPER COMPLETELY 9UPPER',30,500);

delete from customer;
insert into customer values 
(1,'Drogerie Wien',1,'Deckergasse 15A','Emil Steinbach', 'abc@gamil.com',12345),
(2,'John',4,'Deckergasse 1A','9upper', 'abck@gamil.com',1234567),
(3,'Mary',8,'Deckergasse 18A','9upper', 'abcd@gamil.com',123456789);

delete from invoice;
insert into invoice values 
(1,123456780,2,41,1423,NULL,NULL,NULL,NULL,NULL),
(2,123456780,3,42,1400,NULL,NULL,NULL,NULL,NULL),
(3,123456780,2,43,17000,NULL,NULL,NULL,NULL,NULL);

delete from invoice_item;
insert into invoice_item values
(1,1,1,40,23,920),
(2,1,2,4,20,80),
(3,1,3,4,10,40),
(4,1,2,4,30,120);

-- 1C List Customer and Product without Sale
-- using the union operator, in one list return all customers who do not have an invoice and all products that were not sold
-- for each customer without an invoice , return 
-- the string customer
-- the customer id 
-- the custemer_name

-- for each product without an invoice , return 
-- the string product
-- the product id 
-- the product_name

select 'customer' as string , c.id, c.customer_name as name
from customer c
left join invoice i
on c.id = i.customer_id
where i.customer_id is null
union
select 'product' as string , p.id, p.product_name as name
from product p
left join invoice_item ii
on p.id = ii.product_id
where ii.product_id is null;

-- Q.2 
-- drop table employee;
create table employee (
	id integer not null auto_increment primary key,
    employee_name varchar(30) not null,
    salary numeric(8,2),
    phone numeric(15),
    email varchar(50),
	dept_id integer not null
);
-- drop table department;
create table department(
	id integer not null auto_increment primary key,
    dept_code varchar(3) not null,
    dept_name varchar(200) not null
);

-- 2a.Find the num of employees in each department
delete from employee;
insert into employee values (1,'John', 20000,90234567,'john@gmail.com',1);
insert into employee values (2,'Mary', 10000,90234561,'mary@gmail.com',1);
insert into employee values (3,'Steve', 30000,90234562,'steve@gmail.com',3);
insert into employee values (4,'Sunny', 40000,90234563,'sunny@gmail.com',4);

delete from department;
insert into department values (1,'HR','Human Resources');
insert into department values (2,'9UP','9Up Department');
insert into department values (3,'SA','Sales Department');
insert into department values (4,'IT','Information Technology Department');

-- 2a find the number of employees in each department
with 
	nums_of_employees as (
		select e.dept_id,count(e.dept_id)  as total
		from Employee e
		group by e.dept_id
    )
select d.dept_code, ifnull(noe.total,0) as number_of_employee
from department d
left join nums_of_employees noe
on d.id = noe.dept_id
order by number_of_employee desc, d.dept_code asc;


-- 2b is your SQL in 2a still working after inserting the following data? 
-- Please insert the following data into department. Yes, the dept_code 'IT' is duplicated

delete from department where id = 5;
insert into department values (5,'IT','Information Technology Department');

-- If not, why?
-- No,because it's asking to insert a duplicate dept_code into the department table.
-- Unique 'dept_code' is crucial for data integrity. 
-- Using the same 'dept_code' for different departments can cause errors when linking 'employee' and 'department' tables, 
-- affecting the accuracy of subsequent SQL operations. 
-- Hence, inserting duplicate data as in question 2b might disrupt SQL in 2a.



															



