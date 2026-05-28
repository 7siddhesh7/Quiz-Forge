import java.io.*;
import java.util.*;

public class QuizLoader {
    public static List<Question> loadQuestions(String filename) throws IOException {
        List<Question> questions = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;

            String questionText = line.trim();
            String[] options = new String[4];
            for (int i = 0; i < 4; i++) {
                options[i] = br.readLine().trim();
            }
            int correctIndex = Integer.parseInt(br.readLine().trim());
            questions.add(new Question(questionText, options, correctIndex));
        }
        br.close();
        return questions;
    }
}
