import java.util.*;

public class Exercise1 {

    private static final String[] words = {
            "Кошка", "Собака", "Песик", "Катя", "Света",
            "Кошка", "Катя", "Володя", "Сергей",
            "Мышка Джери"
    };

    public static void main(String[] args) {
        System.out.println("Array words: " + Arrays.toString(words));

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Set uniqueWords: " + uniqueWords.toString());

        Map<String, Integer> wordsCount = new HashMap<>();

        for (String word: words) {
            if (wordsCount.containsKey(word)){
                int oldValue = wordsCount.get(word);
                wordsCount.put(word, ++oldValue);
            } else {
                wordsCount.put(word, 1);
            }
        }

        System.out.println("Map wordsCount: " + wordsCount.toString());
    }
}
