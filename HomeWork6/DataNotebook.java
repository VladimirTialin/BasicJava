package org.example;

import java.util.*;

public class DataNotebook extends InterfaceMenu {
    public static boolean exit;
    public static TreeSet<String> sortPosition = new TreeSet<>();

    public static List<String> filterObject;

    public static int UserInput(){
        Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
    }
    public static void Menu(Map<Integer, Laptop> data, int count) {
        startMenu.put(11,"Выход");
        Map<Integer,Laptop> result = new HashMap<>();
        int number=UserInput();
        switch (number) {
            case 1: {
                sortPosition = SortMenu(data, number);
                List<String> positionMenu = new ArrayList<>(FilterMenu(sortPosition, "Выберите модель: "));
                int temp=0;
                while (true) {
                    count = 0;
                    PrintPositionMenu(positionMenu, count);
                    int userinfo = UserInput();
                    if (userinfo == positionMenu.size()) {
                        startMenu.remove(number);
                        PrintHeadMenu(startMenu);
                        if(!result.isEmpty())  data=result;
                        Menu(data, count);
                        result.clear();
                        break;
                    }
                    filterObject = Filters(positionMenu, userinfo);
                    for (Map.Entry<Integer, Laptop> i : data.entrySet()) {
                        if (i.getValue().getModel().equals(filterObject.get(0))) result.put(++temp,i.getValue());
                    }
                }
                break;
            }
            case 2:{
                System.out.println(result);
                sortPosition = SortMenu(data, number);
                List<String> positionMenu = new ArrayList<>(FilterMenu(sortPosition, "Выберите модель: "));
                int temp=0;
                while (true) {
                    count = 0;
                    PrintPositionMenu(positionMenu, count);
                    int userinfo = UserInput();
                    if (userinfo == positionMenu.size()) {
                        startMenu.remove(number);
                        PrintHeadMenu(startMenu);
                        if(!result.isEmpty()) data=result;
                        Menu(data, count);
                        result.clear();
                        break;
                    }
                    filterObject = Filters(positionMenu, userinfo);

                        for (Map.Entry<Integer, Laptop> i : data.entrySet()) {
                        if (i.getValue().getCPU().equals(filterObject.get(0))) result.put(++temp,i.getValue());
                    }
                }
                break;
            }
            case 3:{
                        sortPosition = SortMenu(data, number);
                List<String> positionMenu = new ArrayList<>(FilterMenu(sortPosition, "Выберите модель: "));
                int temp=0;
                while (true) {
                    count = 0;
                    PrintPositionMenu(positionMenu, count);
                    int userinfo = UserInput();
                    if (userinfo == positionMenu.size()) {
                        startMenu.remove(number);
                        PrintHeadMenu(startMenu);
                        if(!result.isEmpty())  data=result;
                        Menu(data, count);
                        result.clear();
                        break;
                    }
                    filterObject = Filters(positionMenu, userinfo);

                    for (Map.Entry<Integer, Laptop> i : data.entrySet()) {
                        if (String.valueOf(i.getValue().getRAM()).equals(filterObject.get(0))) result.put(++temp,i.getValue());
                    }
                }
                break;
            }
            case 4:{
                        sortPosition = SortMenu(data, number);
                List<String> positionMenu = new ArrayList<>(FilterMenu(sortPosition, "Выберите модель: "));
                int temp=0;
                while (true) {
                    count = 0;
                    PrintPositionMenu(positionMenu, count);
                    int userinfo = UserInput();
                    if (userinfo == positionMenu.size()) {
                        startMenu.remove(number);
                        PrintHeadMenu(startMenu);
                        if(!result.isEmpty())  data=result;
                        Menu(data, count);
                        result.clear();
                        break;
                    };
                    filterObject = Filters(positionMenu, userinfo);

                    for (Map.Entry<Integer,Laptop> i : data.entrySet()) {
                        if (String.valueOf(i.getValue().getDisk()).equals(filterObject.get(0))) result.put(++temp,i.getValue());
                    }
                }
                break;
            }
            case 5:{
                sortPosition = SortMenu(data, number);
                List<String> positionMenu = new ArrayList<>(FilterMenu(sortPosition, "Выберите модель: "));
                int temp=0;
                while (true) {
                    count = 0;
                    PrintPositionMenu(positionMenu, count);
                    int userinfo = UserInput();
                    if (userinfo == positionMenu.size()) {
                        startMenu.remove(number);
                        PrintHeadMenu(startMenu);
                        if(!result.isEmpty())  data=result;
                        Menu(data, count);
                        result.clear();
                        break;
                    }
                    filterObject = Filters(positionMenu, userinfo);

                    for (Map.Entry<Integer, Laptop> i : data.entrySet()) {
                        if (i.getValue().getGPU().equals(filterObject.get(0))) result.put(++temp,i.getValue());
                    }
                }
                break;
            }
            case 6:{
                        sortPosition = SortMenu(data, number);
                List<String> positionMenu = new ArrayList<>(FilterMenu(sortPosition, "Выберите модель: "));
                int temp=0;
                while (true) {
                    count = 0;
                    PrintPositionMenu(positionMenu, count);
                    int userinfo = UserInput();
                    if (userinfo == positionMenu.size()) {
                        startMenu.remove(number);
                        PrintHeadMenu(startMenu);
                        if(!result.isEmpty())  data=result;
                        Menu(data, count);
                        result.clear();
                        break;
                    }
                    filterObject = Filters(positionMenu, userinfo);

                    for (Map.Entry<Integer, Laptop> i : data.entrySet()) {
                        if (String.valueOf(i.getValue().getScreen()).equals(filterObject.get(0))) result.put(++temp,i.getValue());
                    }
                }
                break;
            }
            case 7:{
                        sortPosition = SortMenu(data, number);
                List<String> positionMenu = new ArrayList<>(FilterMenu(sortPosition, "Выберите модель: "));
                int temp=0;
                while (true) {
                    count = 0;
                    PrintPositionMenu(positionMenu, count);
                    int userinfo = UserInput();
                    if (userinfo == positionMenu.size()) {
                        startMenu.remove(number);
                        PrintHeadMenu(startMenu);
                        if(!result.isEmpty())  data=result;
                        Menu(data, count);
                        result.clear();
                        break;
                    }
                    filterObject = Filters(positionMenu, userinfo);

                    for (Map.Entry<Integer, Laptop> i : data.entrySet()) {
                        if (i.getValue().getOS().equals(filterObject.get(0))) result.put(++temp,i.getValue());
                    }
                }
                break;
            }
            case 8:{
                sortPosition = SortMenu(data, number);
                List<String> positionMenu = new ArrayList<>(FilterMenu(sortPosition, "Выберите модель: "));
                int temp=0;
                while (true) {
                    count = 0;
                    PrintPositionMenu(positionMenu, count);
                    int userinfo = UserInput();
                    if (userinfo == positionMenu.size()) {
                        startMenu.remove(number);
                        PrintHeadMenu(startMenu);
                        if(!result.isEmpty())  data=result;
                        Menu(data, count);
                        result.clear();
                        break;
                    }
                    filterObject = Filters(positionMenu, userinfo);;
                    for (Map.Entry<Integer, Laptop> i : data.entrySet()) {
                        if (i.getValue().getColor().equals(filterObject.get(0))) result.put(++temp,i.getValue());
                    }
                }
                break;
            }
            case 9:{
                sortPosition = SortMenu(data, number);
                List<String> positionMenu = new ArrayList<>(FilterMenu(sortPosition, "Выберите модель: "));
                int temp=0;
                while (true) {
                    count = 0;
                    PrintPositionMenu(positionMenu, count);
                    int userinfo = UserInput();
                    if (userinfo == positionMenu.size()) {
                        startMenu.remove(number);
                        PrintHeadMenu(startMenu);
                        if(!result.isEmpty())  data=result;
                        Menu(data, count);
                        result.clear();
                        break;
                    }
                    filterObject = Filters(positionMenu, userinfo);

                    for (Map.Entry<Integer, Laptop> i : data.entrySet()) {
                        if (String.valueOf(i.getValue().getPrice()).equals(filterObject.get(0))) result.put(++temp,i.getValue());
                    }
                }
                break;
            }
            case 10: {
                for (Map.Entry<Integer, Laptop> item : data.entrySet()) {
                    System.out.println(item);
                }
                System.out.println();
                PrintHeadMenu(startMenu);
                break;
            }
            case 11: {
                exit=false;
                break;
            }
        }
    }
    public static void main(String[] args) {
        exit=true;
        startMenu.put(11,"Выход");
        PrintHeadMenu(startMenu);
        System.out.println("Выберите критерий сортировки:");
        Map<Integer, Laptop> data=new HashMap<>(Laptops());
        int count = 0;
        while (exit) {
            Menu(data, count);
        }
    }
}
