import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Random;

class NameManipulator {

    private Hashtable<String, String> matchTable = new Hashtable<>();
    private ArrayList<String> nameList;

    NameManipulator(ArrayList<String> santaList) {

        nameList = new ArrayList<>(santaList);

    }

    public void match() {

        int numNames = nameList.size();
        Collections.shuffle(nameList);
        ArrayList<String> gifteeList = new ArrayList<>(nameList);
        Random randNumGen = new Random();
        String gifter;
        String giftee;
        String lastGifter = nameList.get(numNames-1);

        for (int i = 0; i < numNames; i++) {

            if (i == numNames - 2 && gifteeList.contains(lastGifter)) {

                gifter = nameList.get(i);
                giftee = gifteeList.get(gifteeList.indexOf(lastGifter));
                gifteeList.remove(giftee);
                matchTable.put(gifter, giftee);

            } else {

                gifter = nameList.get(i);

                if (gifteeList.contains(gifter)) {

                    gifteeList.remove(gifter);
                    giftee = gifteeList.get(randNumGen.nextInt((gifteeList.size() - 1)));
                    gifteeList.add(gifter);
                    gifteeList.remove(giftee);
                    matchTable.put(gifter, giftee);

                } else if (gifteeList.size() == 1) {

                    matchTable.put(gifter, gifteeList.get(0));

                } else {

                    giftee = gifteeList.get(randNumGen.nextInt((gifteeList.size() - 1)));
                    gifteeList.remove(giftee);
                    matchTable.put(gifter, giftee);

                }
            }
        }
    }

    public Hashtable<String, String> getMatches() {

        return matchTable;

    }
}
