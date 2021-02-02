import java.util.*;

public class Exercise2 {

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Злая кошка", "911");
        phonebook.add("Злая кошка", "112");
        phonebook.add("Сбербанк", "900");

        System.out.println(phonebook.get("Злая кошка"));
        System.out.println(phonebook.get("Не злая кошка"));
        System.out.println(phonebook.get("Сбербанк"));
    }


    public static class Phonebook {
        private Map<String, Set<String>> contacts = new HashMap<>();

        public void add(String name, String number) {
            if (contacts.containsKey(name)) {
                Set<String> phoneNumbers = contacts.get(name);
                phoneNumbers.add(number);
            } else {
                Set<String> phoneNumbers = new HashSet<>();
                phoneNumbers.add(number);
                contacts.put(name, phoneNumbers);
            }
        }

        public String get(String name) {
            if (contacts.containsKey(name))
                return contacts.get(name).toString();
            return null;
        }
    }


}
