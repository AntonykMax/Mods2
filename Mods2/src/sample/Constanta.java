package sample;

/**
 * Created by Max on 30.03.2017.
 */
public class Constanta {
    public static final float L = 10;
    public static final float T = 5;
    public static final float M = 12;
    public static final float N = 10;
    public static final float TAU = T / N;
    public static final float H = L / M;

    public static float r(int a) {
        return Math.abs(a * TAU / H);
    }

    public static void initU0Linear(float[][] u){
        for (float m = 0; m < M / 3; m++) {
            u[0][(int) m] = 0;
        }
        for (float m = M / 3; m < M / 2; m++) {
            u[0][(int) m] = (m - M / 3) / (M / 2 - M / 3);
        }
        for (float m = M / 2; m < 2 * M / 3; m++) {
            u[0][(int) m] = 1 - (1 / (2 * M / 3 - M / 2) * (m - M / 2));
        }
        for (float m = 2 * M / 3; m < 2 * M / 3; m++) {
            u[0][(int) m] = 0;
        }
    }

    public static void initU0Unlinear(float[][] u){
        for(int i = 0; i < M; i++)
            u[0][i] = 0;
        for(int i = (int) M /3; i < 2 * M / 3; i++)
            u[0][i] = (float)(Math.sin((i - M/3)/(2*M/3 - M/3) * Math.PI));
    }
}
