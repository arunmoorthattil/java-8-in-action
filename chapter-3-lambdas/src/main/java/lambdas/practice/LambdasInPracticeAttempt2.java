package lambdas.practice;

import lambdas.practice.functional.BufferedReaderProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdasInPracticeAttempt2 {

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
}
