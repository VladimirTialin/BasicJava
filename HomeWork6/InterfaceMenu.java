package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public abstract class InterfaceMenu {
    public static Map<Integer, String> startMenu = new TreeMap<>(Map.of(1, "Модель ноутбука",
                                                                           2, "Процессор",
                                                                           3, "Оперативная память",
                                                                           4, "Объем жесткого диска",
                                                                           5, "Видеокарта",
                                                                           6,"Размер экрана",
                                                                           7, "Операционная система",
                                                                           8, "Цвет",
                                                                           9,"Цена",
                                                                           10, "Просмотр"));
    public static List<String> FilterMenu(TreeSet<String> object, String msg) {
        System.out.println(msg);
        List<String> menu = new ArrayList<>(object);
        menu.add("Назад");
        return menu;
    }
    public static void PrintPositionMenu(List<String> positionMenu, int count) {
        for (String position : positionMenu) {
            System.out.printf("%d. %s%n", ++count, position);
        }
    }
    public static void PrintHeadMenu(Map<Integer, String> object) {
        for (Map.Entry<Integer, String> o : object.entrySet()) {
            System.out.printf("%d. %s%n", o.getKey(), o.getValue());
        }
    }
    public static List<Laptop> ParseFile() {
        List<Laptop> data = new ArrayList<>();
        try {
            Path path = Paths.get("C:/Users/Владимир/IdeaProjects/HomeWork6/src/main/java/org/example/DataLaptop.txt");
            Scanner scanner = new Scanner(path);
            String[] line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine().split(",");
                data.add(new Laptop(line[0], line[1], Integer.parseInt(line[2]),
                        Integer.parseInt(line[3]),
                        line[4], Double.parseDouble(line[5]),
                        line[6], line[7], Integer.parseInt(line[8])));
            }
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<Integer, Laptop> Laptops() {
        Map<Integer, Laptop> dataLaptop = new HashMap<>();
        List<Laptop> data = ParseFile();
        int count = 0;
        for (Laptop datum : data) {
            dataLaptop.put(++count, datum);
        }
        return dataLaptop;
    }
    public static TreeSet<String> SortMenu(Map<Integer, Laptop> data, int number) {
        TreeSet<String> set = new TreeSet<>();
        switch (number) {
            case 1: {
                for (Map.Entry<Integer, Laptop> item : data.entrySet()) {
                    set.add(item.getValue().getModel());
                }
                break;
            }
            case 2: {
                for (Map.Entry<Integer, Laptop> item : data.entrySet()) {
                    set.add(item.getValue().getCPU());
                }
                break;
            }
            case 3: {
                for (Map.Entry<Integer, Laptop> item : data.entrySet()) {
                    set.add(String.valueOf(item.getValue().getRAM()));
                }
                break;
            }
            case 4: {
                for (Map.Entry<Integer, Laptop> item : data.entrySet()) {
                    set.add(String.valueOf(item.getValue().getDisk()));
                }
                break;
            }
            case 5: {
                for (Map.Entry<Integer, Laptop> item : data.entrySet()) {
                    set.add(String.valueOf(item.getValue().getGPU()));
                }
                break;
            }
            case 6: {
                for (Map.Entry<Integer, Laptop> item : data.entrySet()) {
                    set.add(String.valueOf(item.getValue().getScreen()));
                }
                break;
            }
            case 7: {
                for (Map.Entry<Integer, Laptop> item : data.entrySet()) {
                    set.add(item.getValue().getOS());
                }
                break;
            }
            case 8: {
                for (Map.Entry<Integer, Laptop> item : data.entrySet()) {
                    set.add(item.getValue().getColor());
                }
                break;
            }
            case 9: {
                for (Map.Entry<Integer, Laptop> item : data.entrySet()) {
                    set.add(String.valueOf(item.getValue().getPrice()));
                }
                break;
            }
        }
        return set;
    }
    public static List<String> Filters(List<String> object,int number){
        List<String> filter=new ArrayList<>();
            filter.add(object.get(number-1));
            object.remove(number-1);
        return filter;
    }
}