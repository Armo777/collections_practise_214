/*
Данный класс считает частоты слов в тексте.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FrequencyCounter {
    private String fileName;
    private Map<String, Integer> frequencyMap;

    public FrequencyCounter(String fileName) {
        this.fileName = fileName;
        frequencyMap = new TreeMap<>();
        count();
    }

    private void count() {
        try(BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            String line = null;
            while((line = reader.readLine()) != null) {
                String[] words = line.split("[^А-Яа-я]+");      //разделяем строку по пробелу на массив слов.
                for (String word : words) {
                    if(word.equals("")) {
                        continue;
                    }
                    String preparedWord = word.toLowerCase();    //Переводим строку в нижний регистр,
                    // чтобы например слова "Hello" и "hello" не считались разными
                    if (frequencyMap.containsKey(preparedWord)) {
                        //Мы уже встречали это слово и у него есть какая-то текущая частота.
                        int currentFrequency = frequencyMap.get(preparedWord);
                        frequencyMap.replace(preparedWord, currentFrequency + 1);
                    } else {
                        //На данный момент частота данного слова равна 1, т.к мы встретили это слово в первый раз.
                        frequencyMap.put(preparedWord, 1);
                    }
                }
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void printStat() {
        for(Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.printf("Слово %s встречается %d раз\n", entry.getKey(), entry.getValue());
        }
    }

    public void maxCountEncounteredWord() {
        String mostFrequentWord = null;
        int maxCount = 0;
        for(Map.Entry<String, Integer> entry: frequencyMap.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount) {
                mostFrequentWord = word;
                maxCount = count;
            }
        }
        System.out.println("Самое встречаемое слово: " + mostFrequentWord + " - " + maxCount + " раз");
    }
}
