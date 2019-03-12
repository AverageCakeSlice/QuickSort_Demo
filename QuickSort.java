import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class QuickSort
{
    //Driver function
    public static void main(String[] args)
    {

        ArrayList<Integer> myArray = new ArrayList<>();
        Random populator = new Random();


        System.out.println("Randomized array values prior to sort:");
        for(int i = 0; i < 100000; i++)
        {
            myArray.add(populator.nextInt(100));
            //System.out.printf("Integer value at array index %d: %d%n", i, myArray.get(i));
        }
        //System.out.println("\n");

        long startTime = System.currentTimeMillis();
        myArray = QuickSort.sort(myArray);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        // System.out.println("Sorted array values after performing merge sort:");
        // for(int i = 0; i < myArray.size(); i++)
        // {
        //     System.out.printf("Integer value at array index %d: %d%n", i, myArray.get(i));
        // }
        System.out.printf("Execution time in milliseconds: %d%n", executionTime);
        System.out.println("\n");
    }

    //Sorting function
    public static ArrayList<Integer> sort(ArrayList<Integer> myArray)
    {   
        int pivot = myArray.get(myArray.size() - 1);
        ArrayList<Integer> myHigh = new ArrayList<>();
        ArrayList<Integer> myLow = new ArrayList<>();

        myHigh.add(pivot);
        for(int i = 0; i < myArray.size() - 1; i++)
        {
            if (myArray.get(i) > pivot)
            {
                myHigh.add(myArray.get(i));
            }
            else
            {
                myLow.add(myArray.get(i));
            }
        }

        //recursive branching
        if(myLow.size() > 2)
        {
            myLow = QuickSort.sort(myLow);
        }
        if(myHigh.size() > 2)
        {
            myHigh = QuickSort.sort(myHigh);
        }

        //swap operation
        if(myLow.size() == 2)
        {
            if(myLow.get(0) > myLow.get(1))
            {
                Collections.swap(myLow, 0, 1);
            }
        }
        if(myHigh.size() == 2)
        {
            if(myHigh.get(0) > myHigh.get(1))
            {
                Collections.swap(myHigh, 0, 1);
            }
        }
        myLow.addAll(myHigh);
        return myLow;
    }
}