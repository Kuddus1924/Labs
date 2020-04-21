package Task2;


import dopfunction.Print;

public class Task2 {

    public static double[] probState0 = {0.3,0.6,0.1};
    public static double[] probState1 = {0.1,0.5,0.4};
    public static double[] probState2 = {0.2,0.3,0.5};
    public static int startState = 0;
    public static void main(String[] args)
    {
        Task2Help task = new Task2Help(startState,probState0,probState1,probState2,0.000001);
       double[] sim = task.simulation();
       double[] teor = task.theoreticalСalculation();
       System.out.println("State0: exp: " + Double.toString(sim[0]) + " " + " teor:" + Double.toString(teor[0]));
       System.out.println("State1: exp: " + Double.toString(sim[1]) + " " + " teor:" + Double.toString(teor[1]));
       System.out.println("State2: exp: " + Double.toString(sim[2]) + " " + " teor:" + Double.toString(teor[2]));
    }
}
