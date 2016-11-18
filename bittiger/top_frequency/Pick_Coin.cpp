#include <iostream>
#include <unordered_map>
#include <vector>
#include <string>
using namespace std;

int CalculateGap(vector<int>& nums, int depth, unordered_map<int, int>& bestGap){
	if(bestGap.find(depth)!= bestGap.end()){
		return bestGap[depth];
	}
	if(depth==nums.size()) return 0;

	int result = nums[depth]-CalculateGap(nums, depth+1, bestGap);

	if(depth+1<nums.size()){
		int temp = nums[depth]+nums[depth+1] - CalculateGap(nums, depth+2, bestGap);

	}
	if(temp>result){
		result = temp;
	}
	return bestGap[depth] = result;
}

string DecideWinner(vector<int>& nums){
	unordered_map<int, int> bestGap;
	if(CalculateGap(nums, 0, bestGap)>0) return "Yes";
	else return "NO";
}

int main(){
	int numSize;
	while(cin>>numSize, numSize!=-1){
		int temp;
		vector<int>nums;
		for(int i=0; i<numSize; ++i){
			int temp;
			cin>>temp;
			nums.push_back(temp);
		}
		cout<<DecideWinner(nums)<<endl;
	}
	return 0;
}
