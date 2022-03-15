# Interval-based-constant-best-approximation
Given a set of  N  points  ( x_i , y_i )  with integer values for  x i between  1  and  M  and real values for  y_i ,  
find a partitioning of the interval  [ 1 , M ]  into contiguous intervals such that the error of approximating points in each interval element 
by the average value of  y  in the interval is minimized. 
You need to add a penalty factor proportional to the total number of intervals the solution has. 
For example, if you have  x ∈ [ 1 , 100 ]  and you partition the X dimension in intervals  [ 1 − 10 ] , [ 11 , 20 ] , . . , [ 91 , 100 ]  
the penalty is  10 ∗ δ . 
Hint: determine separately the formula for the error of approximating a set of values  y_i  by their average; 
think about how you can compute this quantity incrementally to reduce the running time of the algorithm. 
For this problem, experiment with both an array and a hash (memorization) version of the solution and compare the actual memory usage for both. 
