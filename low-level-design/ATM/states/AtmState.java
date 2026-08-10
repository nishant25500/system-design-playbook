package ATM.states;

import ATM.enums.AtmOperation;

public interface AtmState {
    public void insertCard();

    public void readingCard();

    public void enterPin(int pin);

    public AtmOperation selectOperation();

    public void processTxn(AtmOperation operation);

    public void collectCash();

    public void collectCard();

    public void cancelTxn();

}
