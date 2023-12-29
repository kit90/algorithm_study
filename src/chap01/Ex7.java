package chap01;

public class Ex7 {
    public static void main(String[] args) {
        gaussAddition(5);
        gaussAddition(10);
    }   

    static void gaussAddition(int n) {
        int sum = 0;
        
        if(n % 2 == 0) {
            sum = (1 + n) * (n / 2) ;
        } 
        else if(n % 2 == 1) {
            sum = (1 + (n-1)) * ((n-1) / 2);
            sum += n;
        }
        //sum =+ n; 즉 sum = +n; 양수 n을 새로 할당
        //sum += n; 즉 sum = sum + n 
        System.out.println("1부터 " + n + "까지의 합은: " + sum);
    }
}