
import java.util.*;

public class Directory {
    private Map<String, List<String>> telephoneBook = new HashMap<>();
    private List<String> listPhoneNumber;
    private int index;

    public void add(String userName, String phoneNumber) {
        if (telephoneBook.containsKey(userName)) {
            listPhoneNumber = telephoneBook.get(userName);
            listPhoneNumber.add(phoneNumber);
            telephoneBook.put(userName, listPhoneNumber);
        } else {
            listPhoneNumber = new ArrayList<>();
            listPhoneNumber.add(phoneNumber);
            telephoneBook.put(userName, listPhoneNumber);
        }
        index++;
    }
    public int size(){
        return this.index;
    }
    public boolean empty(){
        return this.size()==0;
    }
    public void setTelephoneBook() {
        for (Map.Entry<String, List<String>> item : telephoneBook.entrySet()) {
            System.out.printf("Contact: %s tel: %s%n",item.getKey(),item.getValue());
        }
    }
    public List<String> setPhone() {
        List<String> name = null;
        for (Map.Entry<String, List<String>> item : telephoneBook.entrySet()) {
            name=item.getValue();
        }
        return name;
    }
    public String setName() {
        String name = null;
        for (Map.Entry<String, List<String>> item : telephoneBook.entrySet()) {
            name=item.getKey();
        }
        return name;
    }
    public boolean removeName(String name) {
            if(telephoneBook.containsKey(name))
            {
                telephoneBook.remove(name);
                index--;
                return true;
            }else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory = (Directory) o;
        return Objects.equals(telephoneBook, directory.telephoneBook)&& Objects.equals(listPhoneNumber, directory.listPhoneNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(telephoneBook, listPhoneNumber);
    }

    public List<String> get(String surname) {
        return telephoneBook.get(surname);
    }
}
