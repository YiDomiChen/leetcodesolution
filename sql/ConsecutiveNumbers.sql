# Write a SQL query to find all numbers that appear at least three times consecutively.

#+----+-----+
#| Id | Num |
#+----+-----+
#| 1  |  1  |
#| 2  |  1  |
#| 3  |  1  |
#| 4  |  2  |
#| 5  |  1  |
#| 6  |  2  |
#| 7  |  2  |
#+----+-----+

#For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.


#Solution

SELECT DISTINCT(l1.Num) AS ConsecutiveNums FROM Logs l1, Logs l2, Logs l3 
WHERE l1.Num = l2.Num AND l1.Num = l3.Num AND l1.Id = l2.Id AND l1.Id = l3.Id