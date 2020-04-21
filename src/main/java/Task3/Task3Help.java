package Task3;

import org.apache.commons.math3.linear.*;

import java.util.ArrayList;

public class Task3Help {
    private ArrayList<Double> probalityState0inT = new ArrayList<Double>();
    private ArrayList<Double> probalityState1inT = new ArrayList<Double>();
    private ArrayList<Double> probalityState2inT = new ArrayList<Double>();
    private ArrayList<Double> probalityState0TeorInT = new ArrayList<Double>();
    private ArrayList<Double> probalityState1TeorInT = new ArrayList<Double>();
    private ArrayList<Double> probalityState2TeorInT = new ArrayList<Double>();
    private int startState;
    private double[] probState0;
    private double[] probState1;
    private double[] probState2;
    public Task3Help(int start, double[] p0, double[] p1, double [] p2)
    {
        startState = start;
        probState0 = p0;
        probState1 = p1;
        probState2 = p2;
    }
    public double simulation()
    {
            int count = 0;
            int experiment = 1000000;
            for(int i  = 0;i < experiment; i++) {
                int state = startState;
                for (int j = 1; ; j++) {
                    double tmp = Math.random();
                    state = getCurrentState(state,tmp);
                    if (state == 2) {
                        count += j;
                        break;
                    }

                }
            }
            double result = (double) count / experiment;
        return result;
    }
    public double[] theoreticalСalculation()
    {
        RealMatrix a = new Array2DRowRealMatrix(
                new double[][]{ { probState0[0] - 1, probState0[1]},{ probState1[0], probState1[1] - 1}},
                false);
        RealVector b = new ArrayRealVector(new double[]{ -1, -1},
                false);
        DecompositionSolver solver = new SingularValueDecomposition(a).getSolver();
        RealVector solution = solver.solve(b);
        return solution.toArray();
    }

    public ArrayList<Double> getProbalityState0TeorInT() {
        return probalityState0TeorInT;
    }

    public ArrayList<Double> getProbalityState1TeorInT() {
        return probalityState1TeorInT;
    }

    public ArrayList<Double> getProbalityState2inT() {
        return probalityState2inT;
    }

    public ArrayList<Double> getProbalityState2TeorInT() {
        return probalityState2TeorInT;
    }

    public ArrayList<Double> getProbalityState0inT() {
        return probalityState0inT;
    }

    public ArrayList<Double> getProbalityState1inT() {
        return probalityState1inT;
    }

    private int getStateT(int t)
    {
        int state = startState;
        for(int i = 0; i < t; i++)
        {
            double tmp = Math.random();
            state = getCurrentState(state,tmp);
        }
        return state;
    }
    private int getCurrentState(int state,double prob)
    {
        if(state == 0)
        {
            if(prob < probState0[0])
                return 0;
            else if(probState0[0] <= prob  && prob < (probState0[0] + probState0[1]))
                return 1;
            else
                return 2;
        }
        else if (state == 1)
        {
            if(prob < probState1[0])
                return 0;
            else if(probState1[0] <= prob  && prob < (probState1[0] + probState1[1]))
                return 1;
            else
                return 2;
        }
        else {
            if(prob < probState2[0])
                return 0;
            else if(probState2[0] <= prob  && prob < (probState2[0] + probState2[1]))
                return 1;
            else
                return 2;

        }
    }
}
