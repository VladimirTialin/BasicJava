
import java.util.*;

class PhoneBook {

    public static String UserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static int UserInputNumber(){
        int count;
        Scanner scanner = new Scanner(System.in);
        try {
            count = scanner.nextInt();
            if (count > 0 && count < 5) return count;
            else{
                System.out.printf("Повторите ввод: ");
                return UserInputNumber();}
        }catch (Exception e){
            System.out.printf("Ошибка! Повторите ввод: ");
            return UserInputNumber();
        }
    }
    public static Map<Integer,String> Phones(String name, Directory directory){
        int i = 0;
        Map<Integer, String> listNumber = new HashMap<>();
        for (String s : directory.get(name)) listNumber.put(++i, s);
        return listNumber;
    }
    public  static void PrintPhones(Map<Integer,String> list){
        for (Map.Entry<Integer, String> ls : list.entrySet()) {
            System.out.printf("%d: %s%n", ls.getKey(), ls.getValue());
        }
    }

    public static boolean RemovePhone(Directory directory,String name,
                                     String phone,Map<Integer,String> list){
        String tel=null;
        if (list.containsKey(Integer.parseInt(phone))){
            for (Map.Entry<Integer, String> item : list.entrySet()) {
                tel=item.getValue();
            }
            return directory.get(name).remove(tel);
        }
        else return false;
    }

    public static void main(String[] args) {
        Directory directory = new Directory();
        String name, phone;
        boolean exit = true;
        while (exit) {
            System.out.printf("1. Добавить\n2. Удалить\n3. Просмотр\n4. Выход\n>>> ");
            switch (UserInputNumber()) {
                case 1: {
                    System.out.printf("Введите имя: ");
                    name = UserInput();
                    System.out.printf("Введите номер телефона: ");
                    phone = UserInput();
                    directory.add(name, phone);
                    break;
                }
                case 2: {
                    System.out.println("Удалить:\n1. Контакт\n2. Номер");
                    switch (UserInputNumber()) {
                        case 1: {
                            directory.setTelephoneBook();
                            System.out.printf("Введите имя: ");
                            name = UserInput();
                            directory.removeName(name);
                            break;
                        }
                        case 2: {
                            directory.setTelephoneBook();
                            System.out.printf("Введите имя: ");
                            name = UserInput();
                            Map<Integer,String> list= Phones(name,directory);
                            PrintPhones(list);
                            System.out.printf("Введите номер: ");
                            phone = UserInput();
                            RemovePhone(directory,name,phone,list);
                            if(directory.setPhone().isEmpty()) directory.removeName(name);
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("---------------------------");
                    if(directory.empty()){
                        System.out.println("Телефонный справочник пуст");
                    }
                    else directory.setTelephoneBook();
                    System.out.println("---------------------------");
                    break;
                }
                case 4:{
                    exit = false;
                }
            }
        }
    }
}
