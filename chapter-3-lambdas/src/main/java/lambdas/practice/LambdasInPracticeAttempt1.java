package lambdas.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdasInPracticeAttempt1 {

    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }
}
