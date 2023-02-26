import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        FrequencyCounter counter = new FrequencyCounter("War and piece.txt");
        counter.printStat();    //печать статистики на экран
        counter.maxCountEncounteredWord(); // добавил метод

    }
}
