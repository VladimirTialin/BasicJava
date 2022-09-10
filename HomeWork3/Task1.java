import java.util.ArrayList;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        ArrayList <Integer> numbers=FillList();
        System.out.println("Список случайных чисел: "+numbers);
        OddList(numbers);
        }
    
    static ArrayList <Integer> FillList(){
        Random rnd=new Random();
        ArrayList <Integer> numbers=new ArrayList<>();
        for (int i = 0; i < rnd.nextInt(1,20); i++)
        numbers.add(rnd.nextInt(1,100));
        return numbers;
    }

    static void OddList(ArrayList <Integer> list){
        for (int j = 0; j < list.size(); j++) {
            int even=list.get(j);
            if (even % 2==0){
                if(even==list.get(0)) j=0;
                list.remove(j);
                j--;
            }
        }
        if(list.isEmpty()) System.out.println("Список пустой");
        else System.out.println("Список нечетных чисел: "+list);
    }
}