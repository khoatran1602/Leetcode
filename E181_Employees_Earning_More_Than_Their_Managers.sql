# Write your MySQL query statement below
select e.Name as Employee
from Employee e, Employee m
where e.ManagerId = m.Id and e.Salary > m.Salary;
