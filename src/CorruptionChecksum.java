import java.util.Collections;
import java.util.List;

public class CorruptionChecksum {

    private Integer sum;

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public int calculateSum(List<Integer> input) {
        setSum(Collections.max(input) - Collections.min(input));
        return getSum();
    }

    public int calculateDividedSum(List<Integer> input) {
        for (Integer i : input) {
            for (Integer j : input) {
                if (i != j && i % j == 0)
                    return i / j;
            }
        }
        return 2;
    }

    @Override
    public String toString() {
        return "CorruptionChecksum{" +
                ", sum=" + sum +
                '}';
    }
}
