public class floydTriangle {
    public static void main(String args[]) {
        int n = 5;
        int z = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++){
                System.out.print(z + " ");
                z++;
            }
            System.out.println();
        }
    }
}
