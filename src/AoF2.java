import java.util.ArrayList;
import java.util.List;

public class AoF2 {

    private List<Integer> list;
    private List<Integer> outputCorruptionChecksum;
    private List<Integer> outputDividedChecksum;
    StringBuilder builder;
    CorruptionChecksum checksum;

    public AoF2() {
        this.list = new ArrayList<>();
        this.outputCorruptionChecksum = new ArrayList<>();
        this.outputDividedChecksum = new ArrayList<>();
        this.builder = new StringBuilder();
        this.checksum = new CorruptionChecksum();
    }

    public void corruptionChecksum(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '\n' || i == input.length()) {
                processLine();
            } else if (input.charAt(i) != '\t' && input.charAt(i) != '\n') {
                processChar(input.charAt(i));
            } else if (input.charAt(i) == '\t') {
                processNumber();
            }
        }
        processLine();
    }

    public void dividedChecksum(String input) {

    }

    public void processLine() {
        list.add(Integer.parseInt(builder.toString()));
        builder = new StringBuilder();
        outputCorruptionChecksum.add(checksum.calculateSum(list));
        outputDividedChecksum.add(checksum.calculateDividedSum(list));
        checksum = new CorruptionChecksum();
        list = new ArrayList<>();
        //System.out.println(outputCorruptionChecksum);
    }

    public void processNumber() {
        list.add(Integer.parseInt(builder.toString()));
        builder = new StringBuilder();
    }

    public void processChar(char k) {
        builder.append(k);
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Integer getTotalSum() {
        int sum = 0;
        for (Integer e : outputCorruptionChecksum) {
            sum += e;
        }
        return sum;
    }

    public Integer getTotalDividedSum() {
        int sum = 0;
        for (Integer e : outputDividedChecksum) {
            sum += e;
        }
        return sum;
    }

    @Override
    public String toString() {
        return "AoF2{" +
                "output=" + outputCorruptionChecksum +
                '}';
    }
}


