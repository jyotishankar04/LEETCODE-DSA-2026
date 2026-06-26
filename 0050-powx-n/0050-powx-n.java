class Solution {
    public double power(double x, long n){
        if( n == 0) return 1;
        if(n % 2 == 0){
            return power(x * x, n/2);
        }
        return x * power(x, --n);
    }

    public double myPow(double x, int n) {
        if(x == 1 || x == 0) return x;
        // long temp = n;
        // if(n < 0){
        //     x = 1 / x;
        //     temp = -1L * n;
        // } 
        // double mul = x;

        // for(long i = 1; i < temp; i++){
        //     mul *= x;
        // }
        // return mul;

        // Using recusion
        long num = n;
          if(num < 0){
            return (1.0 / power(x, -num));
          }

        return power(x,num);
    }
}