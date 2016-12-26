/**
 * Created by Thiloshon on 12-Dec-16.
 *
 * Main Class : Execution of Application
 */
public class Main {

    public static void main(String[] args) {
        GUInterface guInterface = new GUInterface();
        Controller controller = new Controller(guInterface);
        controller.run();
    }
}
