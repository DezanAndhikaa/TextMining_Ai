package Preprocessing;

import java.util.ArrayList;

public class CaseFolding {

    public ArrayList<String> caseFoldingResult = new ArrayList();

    public CaseFolding() {
        Cleansing cleansing = new Cleansing();
        for (int a = 0; a < cleansing.cleansingResult.size(); a++) {
            String toLower = cleansing.cleansingResult.get(a).toLowerCase();
            caseFoldingResult.add(toLower);
        }
    }
}
