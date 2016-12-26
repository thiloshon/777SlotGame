/**
 * Created by Thiloshon on 13-Dec-16.
 * Modal class
 */
public class Symbol implements ISymbol {

    private String path; // to store string paths
    private int value; // to store values

    /**
     * The method to set image path
     *
     * @param path The string path of the image
     */
    @Override
    public void setImage(String path) {
        this.path = path;
    }


    /**
     * The method to return the image
     *
     * @return the path of the image called
     */
    @Override
    public String getImage() {
        return path;
    }


    /**
     * The method to assign a value to the Symbol
     *
     * @param v The value of the symbol
     */
    @Override
    public void setValue(int v) {
        this.value = v;
    }


    /**
     * The method to return the value associated with the symbol
     *
     * @return value of the symbol
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * the method compares if two symbols are of same sort by checking its underlying value
     *
     * @param symbol The symbol which needs to be compared with
     * @return The boolean value if the symbol is same or not.
     */
    public boolean compare(Symbol symbol) {
        if (symbol.value == value) {
            return true;
        }
        return false;
    }


}
