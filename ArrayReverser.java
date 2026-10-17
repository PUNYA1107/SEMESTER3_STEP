import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayReverser {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(11, 22, 33, 44));
        
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
        
        System.out.println(list);
    }
}