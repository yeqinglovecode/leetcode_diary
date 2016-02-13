// A function to implement bubble sort
void bubbleSort(int arr[], int n)
{
   int i, j;
   for (i = 0; i < n-1; i++)      
       for (j = 0; j < n-i-1; j++) //Last i elements are already in place  
           if (arr[j] > arr[j+1])
              swap(&arr[j], &arr[j+1]);
}

//optimized version
// An optimized version of Bubble Sort
void bubbleSort(int arr[], int n)
{
   int i, j;
   bool swapped;
   for (i = 0; i < n-1; i++)
   {
     swapped = false;
     for (j = 0; j < n-i-1; j++)
     {
        if (arr[j] > arr[j+1])
        {
           swap(&arr[j], &arr[j+1]);
           swapped = true;
        }
     }
 
     // IF no two elements were swapped by inner loop, then break
     if (swapped == false)
        break;///??? if the if statement in line 22 is not true, then the swapped is as default as fault???
   }
}

Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
Auxiliary Space: O(1)
Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
Sorting In Place: Yes
Stable: Yes
Due to its simplicity, bubble sort is often used to introduce the concept of a sorting algorithm.
In computer graphics it is popular for its capability to detect a very small error (like swap of just two elements) 
in almost-sorted arrays and fix it with just linear complexity (2n). For example, it is used in a polygon filling algorithm,
where bounding lines are sorted by their x coordinate at a specific scan line (a line parallel to x axis) and with incrementing
y their order changes (two elements are swapped) only at intersections of two lines 
