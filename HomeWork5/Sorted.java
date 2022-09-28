import java.util.*;
import java.util.stream.*;

public class Sorted {
    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();
        List<String> list = List.of("Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков",
                "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина", "Мария Рыкова",
                "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                "Петр Пети", "Иван Ежов");
        for (String s : list) {
            String name = s.substring(0, s.indexOf(" "));
            if (data.containsKey(name)) data.put(name, data.get(name) + 1);
            else data.put(name, 1);
        }
        Map<String, Integer> sortedMap = data.entrySet()
                .stream().sorted(Comparator.comparingInt(e -> -e.getValue())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new));

        sortedMap.entrySet().forEach(System.out::println);

        }
    }