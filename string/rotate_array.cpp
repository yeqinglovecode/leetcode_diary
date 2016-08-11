#include <iostream>
using namespace std;

/*
	Pass an array pointer as an argument 
	to change the content of an array
*/

void RotateArray(int *a, int k, int n){
	int b[n];
	for(int i=0; i<n; i++){
		b[i] = a[i];
	}
	for(int i=1; i<=k; ++i){
		a[i-1] = b[n+i-4];
	}
	for(int i=0; i<n-k; ++i){
		a[k+i] = b[i];
	}

}

int main(){
	int arr[7] = {0,1,2,3,4,5,6};
	int size = sizeof(arr)/sizeof(arr[0]);
	//cout<<size;
	RotateArray(arr, 3, size);
	for(int i=0; i<size; ++i){
		cout<<arr[i]<<" ";
	}
	return 0;
}
