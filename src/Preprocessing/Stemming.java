package Preprocessing;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import jsastrawi.morphology.DefaultLemmatizer;
import jsastrawi.morphology.Lemmatizer;

public class Stemming {
    public ArrayList<String> resultStemming = new ArrayList<>();
    public Stemming() throws IOException {
        CaseFolding caseFolding = new CaseFolding();
        Set<String> dictionary = new HashSet<String>();
        InputStream in = Lemmatizer.class.getResourceAsStream("/root-words.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = br.readLine()) != null) {
            dictionary.add(line);
        }
        Lemmatizer lemmatizer = new DefaultLemmatizer(dictionary);
         String completeWord ="";
        for (int a = 0; a < caseFolding.caseFoldingResult.size(); a++) {
            String kalimat = caseFolding.caseFoldingResult.get(a);
            String[] splitKalimat = kalimat.split(" ");
            for (int b = 0; b < splitKalimat.length; b++) {
                String stemWord = lemmatizer.lemmatize(splitKalimat[b]);
                completeWord += stemWord+" ";
            }
            resultStemming.add(completeWord);
            completeWord ="";
        }

    }
}
