#include<iostream>
#include<vector>

using namespace std;

//Two pointer type=================================================//

void print(vector<int>& arr){
    for(int ele : arr){
       cout<<ele<<" "; 
    }
    cout<<endl;
} 

void print2D(vector<vector<int>>& arr){
    for(vector<int> ar : arr){
        print(ar);
    }
    cout<<endl;
}


int fibo1(int n, vector<int>& dp) {
    if( n == 0 || n == 1){
        return dp[n] = n;
    }
    if(dp[n] != 0) return dp[n]; //This is memoization
    return dp[n] = fibo1(n-1, dp) + fibo1(n-2, dp);
}

int fibo1_DP(int N, vector<int>& dp) {
    for(int n = 0; n <= N; ++n){
        if( n == 0 || n == 1){
            dp[n] = n;
            continue;
        }
        dp[n] = dp[n-1] + dp[n-2];
    }
    return dp[N];
}


int fibo(){
    int n = 7;
    vector<int> dp(n + 1, 0);
    cout<<fibo1_DP(n, dp)<<endl;
    print(dp);

}

void twoPointer(){
    fibo();
}

int main(){
    //g++ file.cpp -o out | ./out
    twoPointer();
    return 0;
}                                   