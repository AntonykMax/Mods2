package sample;

/**
 * Created by Max on 30.03.2017.
 */
public class Linear {
    public static float[][] S1(int a) {
        float u[][] = new float[(int) Constanta.N][(int) Constanta.M];
        Constanta.initU0Linear(u);
        for (int i = 1; i < Constanta.N; i++) {
            for (float m = 0; m < Constanta.M - 1; m++) {
                u[i][(int) m] = u[i - 1][(int) m] - a * Constanta.TAU * (u[i - 1][(int) m + 1] - u[i - 1][(int) m]) / Constanta.H;
            }
            u[i][(int) Constanta.M - 1] = u[i - 1][(int) Constanta.M - 1];
        }
        return u;
    }

    public static float[][] S2(int a){
        float u[][] = new float[(int) Constanta.N][(int) Constanta.M];
        Constanta.initU0Linear(u);
        for (int i = 1; i < Constanta.N; i++) {
            for (float m = 1; m < Constanta.M; m++) {
                u[i][(int) m] = u[i - 1][(int) m] - a * Constanta.TAU * (u[i - 1][(int) m] - u[i - 1][(int) m - 1]) / Constanta.H;
            }
        }
        return u;
    }

    public static float[][] S3(int a){
        float u[][] = new float[(int) Constanta.N][(int) Constanta.M];
        Constanta.initU0Linear(u);
        for (int i = 1; i < Constanta.N; i++) {
            for (float m = 1; m < Constanta.M-1; m++) {
                u[i][(int) m] = u[i - 1][(int) m] - Constanta.TAU * (plusA(a)*(u[i - 1][(int) m] - u[i - 1][(int) m - 1]) / Constanta.H + minusA(a)*(u[i - 1][(int) m + 1] - u[i - 1][(int) m]) / Constanta.H);
            }
        }
        return u;
    }

    public static int plusA(int a) {
        return (a + Math.abs(a)) / 2;
    }

    public static int minusA(int a) {
        return (a - Math.abs(a)) / 2;
    }
}
