// A function to implement bubble sort
void bubbleSort(int arr[], int n)
{
   int i, j;
   for (i = 0; i < n-1; i++)      
       for (j = 0; j < n-i-1; j++) //Last i elements are already in place  
           if (arr[j] > arr[j+1])
              swap(&arr[j], &arr[j+1]);
}
