/**
 * Created by Thiloshon on 13-Dec-16.
 */
public interface ISymbol {

    /**
     * The method to set image path
     *
     * @param path The string path of the image
     */
    void setImage(String path);

    /**
     * The method to return the image
     *
     * @return the path of the image called
     */
    String getImage();

    /**
     * The method to assign a value to the Symbol
     *
     * @param v The value of the symbol
     */
    void setValue(int v);

    /**
     * The method to return the value associated with the symbol
     *
     * @return value of the symbol
     */
    int getValue();

}
