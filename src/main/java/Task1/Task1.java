package Task1;
import dopfunction.Print;

import java.util.ArrayList;

public class Task1 {
    public static double[] probState0 = {0.3,0.7};
    public static double[] probState1 = {0.4,0.6};
    public static int startState = 1;
    public static int numberState = 50;
    public static void main(String[] args)
    {
        Task1Help task = new Task1Help(startState,numberState,probState0,probState1);
        /*Print.print4(task.getProbalityState0inT(),task.getProbalityState0TeorInT(),task.getProbalityState1inT(),task.getProbalityState1TeorInT()
        ,"probality",numberState)*/;
        Print.print(task.getProbalityState0TeorInT(),task.getProbalityState0inT(),"state0",numberState);
        Print.print(task.getProbalityState1TeorInT(),task.getProbalityState1inT(),"state1",numberState);
        ArrayList<Double> list = new ArrayList<>();
        for ( int i = 0;i < task.getProbalityState0TeorInT().size(); i++ )
        {
            list.add(Math.sqrt(Math.pow(task.getProbalityState0TeorInT().get(i) - task.getProbalityState0inT().get(i),2)));
        }
        System.out.println(list.toString());
    }

}
