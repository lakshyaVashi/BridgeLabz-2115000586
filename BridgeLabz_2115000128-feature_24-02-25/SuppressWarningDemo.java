import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class SuppressWarningDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Item 1");
        list.add("Item 2");
        for (Object item : list) {
            System.out.println(item);
        }
    }
}