// C program for insertion sort
#include <stdio.h>
#include <math.h>
 
/* Function to sort an array using insertion sort*/
void insertionSort(int arr[], int n)
{
   int i, key, j;
   for (i = 1; i < n; i++)
   {
       key = arr[i];
       j = i-1;
 
       /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
       while (j >= 0 && arr[j] > key)
       {
           arr[j+1] = arr[j];
           j = j-1;
       }
       arr[j+1] = key;
   }
}
//注意体会key在本题中的重要作用， 在inner for loop 里， key 值始终没变，用一个始终不变的容器承装
//要运输到指定位置的值（要insert 的值）是本算法的精妙之处

Time Complexity: O(n*n)
Auxiliary Space: O(1)
Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. 
And it takes minimum time (Order of n) when elements are already sorted.
Algorithmic Paradigm: Incremental Approach
Sorting In Place: Yes
Stable: Yes
Online: Yes
Uses: Insertion sort is uses when number of elements is small. It can also be useful when input array 
is almost sorted, only few elements are misplaced in complete big array.
