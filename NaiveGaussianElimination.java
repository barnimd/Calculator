public class NaiveGaussianElimination {

    public static void gaussianElimination(double[][] a, double[] b) {
        int n = b.length;

        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double factor = a[i][k] / a[k][k];
                for (int j = k + 1; j < n; j++) {
                    a[i][j] -= factor * a[k][j];
                }
                b[i] -= factor * b[k];
            }
        }

        double[] x = new double[n];
        x[n - 1] = b[n - 1] / a[n - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            double sum = b[i];
            for (int j = i + 1; j < n; j++) {
                sum -= a[i][j] * x[j];
            }
            x[i] = sum / a[i][i];
        }

        System.out.println("Solution: ");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + x[i]);
        }
    }

    public static void main(String[] args) {

        double[][] a = {
            {1, -1, 2, 1},
            {3, 2, 1, 4},
            {5, 8, 6, 3},
            {4, 2, 5, 3}
        };

        double[] b = {1, 1, 1, -1};

        gaussianElimination(a, b);
    }
}
