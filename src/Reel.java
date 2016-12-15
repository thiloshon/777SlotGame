import java.util.ArrayList;

/**
 * Created by Thiloshon on 13-Dec-16.
 */
public class Reel {

    ArrayList<Symbol> symbols = new ArrayList<>();


    public Reel(ArrayList<String> paths, ArrayList<Integer> values) {


        int count = paths.size();

        while (count > 1) {

            int no = (int) (Math.random() * 10 % 6);

            if (values.get(no) != -1) {
                symbols.add(new Symbol());
                symbols.get(symbols.size() - 1).setImage(paths.get(no));
                symbols.get(symbols.size() - 1).setValue(values.get(no));
                values.set(no, -1);
                count--;
                System.out.println(count);
            }
        }


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
