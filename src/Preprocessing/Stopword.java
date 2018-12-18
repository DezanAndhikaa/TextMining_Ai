package Preprocessing;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Stopword {

    public static void main(String[] args) throws IOException {
        Stemming stem = new Stemming();
        ArrayList<String> temp = new ArrayList<>();
        PrintWriter pw = new PrintWriter("Hasil Preprocessing.csv");
        File fr = new File("src/stopWord.txt");
        Scanner br = new Scanner(fr);
        while (br.hasNext()) {
            temp.add(br.next());
        }
        for (int x = 0; x < stem.resultStemming.size(); x++) {
            String raw = stem.resultStemming.get(x);
            String[] split = raw.split(" ");
            String text;
            for (int a = 0; a < split.length; a++) {
                String kata = split[a];
                for (int z = 0; z < temp.size(); z++) {
                    if (kata.equals(temp.get(z))) {
                        split[a] = "";
                    }
                }
            }
            String kata = "";
            for (int y = 0; y < split.length; y++) {
                if (split[y].isEmpty()) {

                } else {

                    kata += split[y] + " ";
                }
            }

//            FileWritter fw = new FileWritter(pw,true);
            pw.println(kata.trim());
//            System.out.println(kata.trim());
//            pw.close();
        }
        pw.close();
    }

}
