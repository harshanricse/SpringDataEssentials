DROP SCHEMA IF EXISTS customer_db; 

  

CREATE SCHEMA customer_db; 

USE customer_db; 

  

create table customer( 

   phone_no BIGINT, 

   name VARCHAR(20) not null, 

   age INT not null, 

   gender CHAR(10), 

   address VARCHAR(40), 

   plan_id INT not null, 

   CONSTRAINT ps_customer_id_pk PRIMARY KEY (phone_no) 

  

); 