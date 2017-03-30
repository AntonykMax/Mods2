package sample;

/**
 * Created by Max on 30.03.2017.
 */
public class Unlinear {
    public static float plusU(float u){
        return (u + Math.abs(u)) / 2;
    }

    public static float minusU(float u){
        return (u - Math.abs(u)) / 2;
    }

    public static float[][] S4(){
        float u[][] = new float[(int) Constanta.N][(int) Constanta.M];
        Constanta.initU0Unlinear(u);
        for (int i = 1; i < Constanta.N; i++) {
            for (float m = 1; m < Constanta.M-1; m++) {
                u[i][(int) m] = u[i - 1][(int) m] + Constanta.TAU * (u[i - 1][(int) m] * (u[i - 1][(int) m + 1] - u[i - 1][(int) m]) / Constanta.TAU);
            }
        }
//        for (float[] i : u) {
//            for (float j : i)
//                System.out.print(j + " ");
//            System.out.print('\n');
//        }
        return u;
    }

    public static float[][] S5(){
        float u[][] = new float[(int) Constanta.N][(int) Constanta.M];
        Constanta.initU0Unlinear(u);
        for (int i = 1; i < Constanta.N; i++) {
            for (float m = 1; m < Constanta.M-1; m++) {
                u[i][(int) m] = u[i - 1][(int) m] - Constanta.TAU * (minusU(u[i - 1][(int) m]) * (u[i - 1][(int) m + 1] - u[i - 1][(int) m]) / Constanta.TAU + plusU(u[i - 1][(int) m]) * (u[i - 1][(int) m] - u[i - 1][(int) m - 1]) / Constanta.TAU);
            }
        }
//        for (float[] i : u) {
//            for (float j : i)
//                System.out.print(j + " ");
//            System.out.print('\n');
//        }
        return u;
    }
}
