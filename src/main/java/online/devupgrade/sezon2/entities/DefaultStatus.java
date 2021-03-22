package online.devupgrade.sezon2.entities;

import online.devupgrade.sezon2.helper.IOrderStatus;

public enum DefaultStatus implements IOrderStatus {
    W_Przygotowaniu(0), Zamowione(1), Anulowane(2), Anulowane_anulowanie(3);

    int i;
    DefaultStatus(int i) {
        this.i = i;
    }

    @Override
    public Integer getStatusSerializableValue() {
        return i;
    }
}
