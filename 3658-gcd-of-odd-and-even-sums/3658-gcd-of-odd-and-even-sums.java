class Solution {
    public int GCD(int n, int m){
        while(n != 0 && m != 0){
            if(n > m){
                n = n - m;
            }else{
                m = m - n;
            }
        }
        return m == 0 ? n : m;
    }
    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0;
        int evenSum = 0;
        for(int i = 1; i < n * 2; i++){
            if(i % 2 ==0 ){
                evenSum += i;
            }else{
                oddSum += i;
            }
        }

        return GCD(oddSum, evenSum);
    }
}