import java.util.ArrayList;

/**
 * Created by Thiloshon on 13-Dec-16.
 */
public class Reel {

    ArrayList<Symbol> symbols = new ArrayList<>();


    public Reel(ArrayList<String> paths, ArrayList<Integer> values) {


        int count = paths.size();

        while (count > 0) {

            int no = (int) (Math.random() * 10 % 6);

            if (!isInTheArray(values.get(no))) {
                symbols.add(new Symbol());
                symbols.get(symbols.size() - 1).setImage(paths.get(no));
                symbols.get(symbols.size() - 1).setValue(values.get(no));
                count--;
                //System.out.println(count);
            }
        }


    }

    boolean isInTheArray(int num){
        for(Symbol s : symbols){
            if (s.value==num){
                return true;
            }
        }
        return false;
    }

    ArrayList<Symbol> spin() {

        ArrayList<Symbol> returnArray = new ArrayList<>();
        int no = (int) (Math.random() * 10 % 6);

        for (int x = 0; x < symbols.size(); x++) {
            no = no % 5;
            returnArray.add(symbols.get(no));
            no++;
        }


        return returnArray;
    }
}
