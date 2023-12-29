package chap01;

public class Ex15 {
    public static void main(String[] args) {
        spira(4);
    }

    static void spira(int n) {
        int max = (n-1) * 2 + 1;

        for (int i = 1; i <= n; i++) {
            int star = (i-1) * 2 + 1;

            for (int j = 1; j <= (max-star)/2; j++) {
                System.out.print(" "); 
            }

            for (int j = 1; j <= star; j++) {
                System.out.print("*"); 
            }

            System.out.println();
        }
    }
}
