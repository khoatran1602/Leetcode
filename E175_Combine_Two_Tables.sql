# Write your MySQL query statement below
select a.FirstName as firstname,
       a.LastName as lastname,
       b.City as city,
       b.State as state
from Person a 
left join Address b
on a.PersonId = b.PersonId;

========================================================
