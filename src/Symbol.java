/**
 * Created by Thiloshon on 13-Dec-16.
 */
public class Symbol implements ISymbol {

    String path;
    int value;


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
}
