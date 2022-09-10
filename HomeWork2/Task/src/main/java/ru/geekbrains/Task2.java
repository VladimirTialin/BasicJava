package ru.geekbrains;

import java.util.Scanner;

public class Task2 {
    public static String[] userField={"name","country","city","age"};
        public static StringBuilder builber= new StringBuilder("SELECT * FROM students WHERE ");
        
    public static void main(String[] args) {
        for (int i = 0; i < userField.length; i++) {
            String userData=InputStr(userField[i].substring(0,1).
                                    toUpperCase()+userField[i].substring(1)+": ");
            if(userData==null) continue;
            else{
            builber.append(userField[i]+" = \""+userData+"\" ");
            if(i!=userField.length-1 & userData==null ) builber.append("AND ");
            }
        }
        System.out.println(builber);
    }

    static String InputStr(String msg){
        Scanner scanner = new Scanner(System.in);
        System.out.printf(msg);
        String str=scanner.nextLine();
        if (str=="" | str==" ") return null;
        else  return str;
    }  
}

