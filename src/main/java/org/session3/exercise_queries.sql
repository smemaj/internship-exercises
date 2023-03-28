/*Question 1*/
select customerNumber
from orders group by customerNumber having count(*)=(select max(Temp.cnt) from (
select count(orderNumber) as cnt 
from orders
group by customerNumber
) as Temp);

/*Question 2*/
select * from (customers as A inner join orders as B on A.customerNumber=B.customerNumber) 
inner join orderdetails as C on C.orderNumber=B.orderNumber 
where country like 'Germany';

/*Question 3*/
select employeeNumber, sum(amount) from (customers as A inner join employees as B 
on A.salesRepEmployeeNumber=B.employeeNumber) 
inner join payments as C on A.customerNumber=C.customerNumber 
group by employeeNumber;


/*Question 4*/
select A.productCode, productName, productDescription, orderDate 
from (products as A inner join orderdetails as B on A.productCode=B.productCode) 
inner join orders as C on B.orderNumber=C.orderNumber 
 where orderDate<'2005-01-01' and orderDate>'2004-11-30' group by A.productCode;

/*Question 5*/
CREATE TABLE `employeedetails` (
  `employeeDetailId` int(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `personalEmail` varchar(50) NOT NULL,
  PRIMARY KEY (`employeeDetailId`),
  CONSTRAINT `fk_emp_details` FOREIGN KEY (`employeeDetailId`) REFERENCES `employees` (`employeeNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



