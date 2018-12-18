package Preprocessing;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Cleansing {

    public static ArrayList<String> cleansingResult = new ArrayList();

    public Cleansing() {
        String csvFile = "src/data.csv";
        BufferedReader br = null;
        String line = "";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int counter = 0;
            String rawSentence = "";
            while ((line = br.readLine()) != null) {
                if (counter == 0) {
                    counter++;
                } else {
                    String split[] = line.split(",");
                    int sisiKiri = split[0].length();
                    int sisiKanan = split[1].length();
                    int total = sisiKanan+sisiKiri+2;
                    StringBuilder sb = new StringBuilder(line);
                    sb.replace(0, total, "");
                    rawSentence = sb.toString();
                    StringTokenizer st = new StringTokenizer(rawSentence,"1234567890`~!@#$%^&*()_-+={}[]|;:'<>,.?/\"");
                    String completeSentence = "";
                    while(st.hasMoreElements()){
                        completeSentence += st.nextToken()+" ";
                    }
                    cleansingResult.add(completeSentence);
                    
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
