import java.util.ArrayList;
import java.util.Random;

public class Task2 {
   public static void main(String[] args) {
    ArrayList <Integer> numbers=FillList();
    int max=MaxNumberOfList(numbers);
    int min=MinNumberOfList(numbers);
    double average=AverageNumberOfList(numbers);
    System.out.printf("List:"+numbers+"\nMax = %d\nMin = %d\nAverage = %.2f\n",max,min,average);
   }
   static ArrayList <Integer> FillList(){
    Random rnd=new Random();
    ArrayList <Integer> numbers=new ArrayList<>();
    for (int i = 0; i < rnd.nextInt(1,20); i++)
        numbers.add(rnd.nextInt(-50,100));
        return numbers;
    }

    static int MaxNumberOfList(ArrayList<Integer> list){
        if (list.isEmpty()) return 0;
        int max=list.get(0);
        for (int item  : list) {
            if (item>max) max=item;
        }
        return max;
    }

    static int MinNumberOfList(ArrayList<Integer> list){
        if(list.isEmpty()) return 0;
        int min=list.get(0);
            for (int item : list) {
                if(item<min) min=item;
            }
            return min;       
    }
    static double AverageNumberOfList(ArrayList<Integer> list){
        if (list.isEmpty()) return 0;
        int size=list.size();
        double average=(list.stream().mapToInt((Integer::intValue)).sum());

            return average/size;
        }

}

