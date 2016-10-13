
	public static void merge(int[] array, int l, int m, int r){
		int i, j, k;
		int n1 = m-l+1;
		int n2 = r-m;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(i = 0; i<n1; i++){
			L[i] = array[l+i];
		}
		for(i=0; i<n2; i++){
			R[i] = array[m+1+i];
		}
		
		/*Merge the temp arrays back into arr[l...r]*/
		i = 0;//initial index of first subarray
		j = 0;//initial index of second subarray
		k = l;//initial index of merged subarray
		while(i<n1 && j<n2){
			if(L[i]<R[j]){
				array[k] = L[i];
				i++;
			}else{
				array[k]= R[j];
				j++;
			}
			
			k++;
		}
		while(i<n1){
			array[k] = L[i];
			i++;
			k++;
		}
		while(j<n2){
			array[k] = R[j];
			j++;
			k++;
		}
	}
	
	public static void mergeSort(int[] array, int l, int r){
		if(l<r){
			int m = l+(r-l)/2;
			mergeSort(array, l, m);
			mergeSort(array, m+1, r);
			merge(array, l, m, r);
		}
	}
	
	public static void main(String []args){
		int[] arr = {9,8,7,6,5,4,3,2,1,0};
		mergeSort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]+" ");
		}
		
		
		
	}
