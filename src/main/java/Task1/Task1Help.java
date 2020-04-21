package Task1;

import java.util.ArrayList;

public class Task1Help {
        private ArrayList<Double> probalityState0inT = new ArrayList<Double>();
        private ArrayList<Double> probalityState1inT = new ArrayList<Double>();
        private ArrayList<Double> probalityState0TeorInT = new ArrayList<Double>();
        private ArrayList<Double> probalityState1TeorInT = new ArrayList<Double>();
        private int startState;
        private int T;
        private double[] probState0;
        private double[] probState1;
        public Task1Help(int start, int n, double[] p0, double[] p1)
        {
            startState = start;
            T = n;
            probState0 = p0;
            probState1 = p1;
            simulation();
            theoreticalСalculation();
        }
        public void simulation()
        {
            if(startState == 0)
            {
                probalityState0inT.add(1.0);
                probalityState1inT.add(0.0);
            }
            else
            {
                probalityState0inT.add(0.0);
                probalityState1inT.add(1.0);
            }
            for(int i = 1; i <= T; i++)
            {
                int count = 100000;
                int count0 = 0;
                int count1 = 0;
                for(int j = 0; j < count;j++)
                {
                    int state = getStateT(i);
                    if(state == 0)
                        count0++;
                    if(state == 1)
                        count1++;
                }
                probalityState0inT.add((double)count0/(double)count);
                probalityState1inT.add((double)count1/(double)count);
            }
        }
        public void theoreticalСalculation()
        {
            if(startState == 0)
            {
                probalityState0TeorInT.add(1.0);
                probalityState1TeorInT.add(0.0);
            }
            else
            {
                probalityState0TeorInT.add(0.0);
                probalityState1TeorInT.add(1.0);
            }

            for(int i = 1; i <= T; i++)
            {
                probalityState0TeorInT.add(probState0[0] *  probalityState0TeorInT.get(i - 1) +  probState1[0] * probalityState1TeorInT.get(i - 1));
                probalityState1TeorInT.add(probState0[1] *  probalityState0TeorInT.get(i - 1) +  probState1[1] * probalityState1TeorInT.get(i - 1));
            }
        }

        public ArrayList<Double> getProbalityState0TeorInT() {
            return probalityState0TeorInT;
        }

        public ArrayList<Double> getProbalityState1TeorInT() {
            return probalityState1TeorInT;
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
                else
                    return 1;
            }
            else
            {
                if(prob < probState1[1])
                    return 1;
                else
                    return 0;
            }
        }


    }
