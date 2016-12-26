import java.util.ArrayList;

/**
 * Created by Thiloshon on 13-Dec-16.
 *
 * Modal Class
 * The Reel Model class contains 6 instances of Symbols and related methods.
 */
public class Reel {

    private ArrayList<Symbol> symbols = new ArrayList<>(); // contains the 6 Symbols of the Reel

    /**
     *  Creates 6 instances of symbols and stores in a Arraylist
     * @param paths  The String paths of the images
     * @param values The int values of the value of symbol
     */
    public Reel(ArrayList<String> paths, ArrayList<Integer> values) {

        int count = paths.size();

        while (count > 0) {
            int no = (int) (Math.random() * 10 % 6); // To randomly populate the symbols

            if (!isInTheArray(values.get(no))) {
                symbols.add(new Symbol());
                symbols.get(symbols.size() - 1).setImage(paths.get(no));
                symbols.get(symbols.size() - 1).setValue(values.get(no));
                count--;
            }
        }


    }

    /**
     *  When populating randomly checking if a symbol is already in the Arraylist
     * @param num the value of the symbol that need validation
     * @return boolean value if its there in the reel or not.
     */
    private boolean isInTheArray(int num){
        for(Symbol s : symbols){
            if (s.getValue()==num){
                return true;
            }
        }
        return false;
    }

    /**
     *  Getting random ordering of the symbols in the reel
     * @return The arraylist with all six symbols in random indexes.
     */
    public ArrayList<Symbol> spin() {
        ArrayList<Symbol> returnArray = new ArrayList<>();
        int no = (int) (Math.random() * 10 % 6);

        for (int x = 0; x < symbols.size(); x++) {
            no = no % 5;
            returnArray.add(symbols.get(no));
            no++;
        }
        return returnArray;
    }

    // Getters and Setters.

    public ArrayList<Symbol> getSymbols() {
        return symbols;
    }
}
