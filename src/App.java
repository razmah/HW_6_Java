/* Задание: Реализуйте структуру телефонной книги с помощью
HashMap. Программа также должна учитывать, что во входной структуре будут
повторяющиеся имена с разными телефонами, их необходимо считать, как одного
человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов. */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("11111", "Игнатов");
        phoneBook.add("22222", "Борисов");
        phoneBook.add("33333", "Кузьмин");
        phoneBook.add("44444", "Петров");
        phoneBook.add("22222", "Петров");
        phoneBook.add("33333", "Игнатов");
        phoneBook.add("55555", "Марков");
        phoneBook.add("66666", "Силаков");

        System.out.println(phoneBook.getAll());
    }
}

class PhoneBook {

    private Map<String, List<String>> map = new HashMap<>();

    void add(String phoneNum, String lastName) {
        if (map.containsKey(lastName)) {
            List<String> phoneNumbers = map.get(lastName);
            phoneNumbers.add(phoneNum);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNum);
            map.put(lastName, phoneNumbers);
        }
    }
    
    String getAll() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(map.entrySet());
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        for (Map.Entry<String, List<String>> entry : entries) {
            List<String> phoneNumbers = entry.getValue();
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" : ");
            stringBuilder.append(phoneNumbers);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
