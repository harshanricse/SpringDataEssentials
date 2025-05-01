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

INSERT INTO Customer VALUES(9898765434,'Ross',34,'M','90 Bedford St,New York, NY',1001);
INSERT INTO Customer VALUES(9898765437,'Rachel',34,'F','700 Oak St,Brockton MA 2301',1005);

commit;
select * from customer;