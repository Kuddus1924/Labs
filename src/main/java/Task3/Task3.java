package Task3;

import Task2.Task2Help;

public class Task3 {
    public static double[] probState0 = {0.00,0.95,0.05};
    public static double[] probState1 = {0.05,0.0,0.95};
    public static double[] probState2 = {0.0,0.0,1.0};
    public static int startState = 0;
    public static void main(String[] args)
    {
        Task3Help task = new Task3Help(0,probState0,probState1,probState2);
        double sim = task.simulation();
        double[] teor = task.theoreticalСalculation();
        Task3Help task1 = new Task3Help(1,probState0,probState1,probState2);
        double sim2 = task1.simulation();
        System.out.println("State0: exp: " + Double.toString(sim) + " " + " teor:" + Double.toString(teor[0]));
        System.out.println("State1: exp: " + Double.toString(sim2) + " " + " teor:" + Double.toString(teor[1]));
    }
}

