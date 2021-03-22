package online.devupgrade.sezon2.utilshelpers;

public class SumProvider {
    static public Float sum = 0f;

    public void add(Float a) {
        sum = sum + a;
    }

    public void reset() {
        sum = 0f;
    }
}
