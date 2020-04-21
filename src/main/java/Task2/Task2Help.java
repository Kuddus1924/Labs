package Task2;

import org.apache.commons.math3.linear.*;
import java.util.ArrayList;

public class Task2Help {
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
    private double lymda;
    public Task2Help(int start, double[] p0, double[] p1, double [] p2, double lymda)
    {
        startState = start;
        probState0 = p0;
        probState1 = p1;
        probState2 = p2;
        this.lymda = lymda;
    }
    public double[] simulation()
    {
        double probalityState2inTnext,probalityState1inTnext,probalityState0inTnext;
        double probalityState2inTprev = 0;
        double probalityState0inTprev = 0;
        double probalityState1inTprev = 0;
        double count0 = 0;
        double count1 = 0;
        double count2 = 0;
        if(startState == 0)
            count0 = 1.0;
        else if (startState == 1)
            count1 = 1.0;
        else
            count2 = 1.0;
        int i = 1;
        int state = startState;
        while (true)
        {
                double tmp = Math.random();
                state = getCurrentState(state,tmp);
                if(state == 0)
                    count0++;
                else if(state == 1)
                    count1++;
                else
                    count2++;
            probalityState0inTnext = count0/(double)i;
            probalityState1inTnext = count1/(double)i;
            probalityState2inTnext = count2/(double)i;
            if((Math.abs(probalityState0inTnext - probalityState0inTprev) <= lymda) &&
                    (Math.abs(probalityState1inTnext - probalityState1inTprev) <= lymda) &&
                    (Math.abs(probalityState2inTnext - probalityState2inTprev) <= lymda) && i >100)
            {
                break;
            }
            probalityState0inTprev = probalityState0inTnext;
            probalityState1inTprev = probalityState1inTnext;
            probalityState2inTprev = probalityState2inTnext;
            i++;
        }
        double [] result = {probalityState0inTnext,probalityState1inTnext,probalityState2inTnext};
        return result;
    }
   public double[] theoreticalСalculation()
    {
        probState0[0] = probState0[0] - 1;
        probState1[1] = probState1[1] - 1;
        probState2[2] = probState2[2] - 1;
        RealMatrix a = new Array2DRowRealMatrix(
                new double[][]{ { probState0[0], probState1[0], probState2[0], 0}, {  probState0[1], probState1[1], probState2[1], 0},
                        {  probState0[2], probState1[2], probState2[2], 0}, {1,1,1,0} },
                false);
        RealVector b = new ArrayRealVector(new double[]{ 0, 0, 0, 1},
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

    /*private int getStateT(int t)
    {
        int state = startState;
        for(int i = 0; i < t; i++)
        {
            double tmp = Math.random();
            state = getCurrentState(state,tmp);
        }
        return state;
    }*/
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
