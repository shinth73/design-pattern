package pattern02.visitor.e1a;

public class GroupSumResult {
    public int lineSum = 0;
    public int rectangleSum = 0;
    public int groupSum = 0;

    @Override
    public String toString() {
        return String.format("line=%d rectangle=%d group=%d\n",
                lineSum, rectangleSum, groupSum);
    }
}
