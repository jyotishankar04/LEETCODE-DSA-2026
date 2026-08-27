# Write your MySQL query statement below

-- select m.name from Employee  e join Employee m on e.managerId = e.id group by m.id having count(e.id) >= 5;

# Write your MySQL query statement below
SELECT m.name 
FROM Employee e 
JOIN Employee m ON e.managerId = m.id 
GROUP BY m.id, m.name 
HAVING COUNT(e.id) >= 5;
