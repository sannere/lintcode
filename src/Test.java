import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.sort;
class Interval implements Comparable<Interval> {
    int left, right;
    Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public int compareTo(Interval o) {
        return this.left - o.left;
    }
}
public class Test {
    public static void main(String args[]) {
        // Interval类如上
        List<Interval> A = new ArrayList<>();
        A.add(new Interval(1, 7));
        A.add(new Interval(5, 6));
        A.add(new Interval(3, 4));
        System.out.println("Before sort:");
        for (Interval i : A)
            System.out.println("(" + i.left + ", " + i.right + ")");

        sort(A);
        System.out.println("After sort:");
        for (Interval i : A)
            System.out.println("(" + i.left + ", " + i.right + ")");
    }
}



