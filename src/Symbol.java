/**
 * Created by Thiloshon on 13-Dec-16.
 * Modal class
 *
 */
public class Symbol implements ISymbol {

    private String path;
    private int value;


    @Override
    public void setImage(String path) {
        this.path = path;
    }

    @Override
    public String getImage() {
        return path;
    }

    @Override
    public void setValue(int v) {
        this.value = v;
    }

    @Override
    public int getValue() {
        return value;
    }

    /**
     *
     * @param symbol
     * @return
     */
    public boolean compare(Symbol symbol){
        if(symbol.value == value){
            return true;
        }
        return false;
    }


}
