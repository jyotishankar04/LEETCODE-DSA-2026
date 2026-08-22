class Solution {
    public boolean checkDivisibility(int n) {
        int copy = n;   
        int sum = 0;
        int prod = 1;

        while(copy > 0){
            int ld = copy % 10;
            sum+= ld;
            prod *= ld;
            copy /=10;
        }
        return n % (sum + prod) == 0 ? true : false; 
    }
}