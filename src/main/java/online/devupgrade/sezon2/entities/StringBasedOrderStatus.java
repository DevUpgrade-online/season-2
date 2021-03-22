package online.devupgrade.sezon2.entities;

import online.devupgrade.sezon2.helper.IOrderStatus;

import java.util.stream.IntStream;

public class StringBasedOrderStatus implements IOrderStatus, CharSequence{

    private String implHelper; //kompozycja

    @Override
    public int length() {
        return implHelper.length();
    }

    @Override
    public char charAt(int i) {
        return implHelper.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return implHelper.subSequence(i, i1);
    }

    @Override
    public IntStream chars() {
        return null;
    }

    @Override
    public IntStream codePoints() {
        return null;
    }

    @Override
    public Integer getStatusSerializableValue() {
        return length();
    }
}
