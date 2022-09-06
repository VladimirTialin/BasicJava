import java.util.InputMismatchException;
import java.util.Scanner;

public final class Task1
{
    public static void main(String[] args)
    {
        int [] array= new int [6];
        array= FillArray(array);
        int leftIndex=array[0];
        int rightIndex=0;
        for (int i = 1; i < array.length; i++)
        {
            rightIndex=SumOfRightElements(array, i);
            if (leftIndex==rightIndex)
            {
                System.out.printf("Для данного массива i = %d,"
                + "где: сумма левой части: %d = %d : сумме правой части\n",
                i,leftIndex,rightIndex);
                break;
            }
            leftIndex+=array[i];
            rightIndex=0;
        }
        if (leftIndex!=rightIndex)
        {
            System.out.println("Для данного массива [i] - не найден!");
        }
    }
//Сумма правой части элементов
    static int SumOfRightElements(int[] array,int index)
    {
        int sum = 0;
        for (int i = index+1; i < array.length; i++)
            {
            sum+=array[i];
            }
        return sum;
    }
//Ввод данных в массив
    static int[] FillArray(int[] array)
    {
        try
        {
            Scanner iScanner = new Scanner(System.in);
            System.out.println("Заполните массив числами: ");
            for (int i = 0; i < array.length; i++)
            {
                array[i] = iScanner.nextInt();
            }
        }
        catch(InputMismatchException | NumberFormatException e)
        {
            System.out.printf("Ошибка ввода! Вы ввели не числовое значение.\n"); 
            return FillArray(array);
        }
        return array;
    }
} 