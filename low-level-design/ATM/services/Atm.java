package ATM.services;

import ATM.enums.AtmOperation;
import ATM.factory.AtmStateFactory;
import ATM.states.AtmState;

public class Atm {
    private AtmState state;

    public Atm(AtmState state) {
        this.state = state;
    }

    void setState(AtmState state) {
        this.state = state;
    }

    public void insertCard() {
        state.insertCard();
        setState(new AtmStateFactory().create("CardReading"));
    }

    public void readingCard() {
        state.readingCard();
        setState(new AtmStateFactory().create("VerifyPin"));
    }

    public void enterPin(int pin) {
        state.enterPin(pin);
        setState(new AtmStateFactory().create("SelectTxn"));
    }

    public void selectOperation() {
        AtmOperation operation = state.selectOperation();
        if (operation == AtmOperation.CASHWITHDRAW || operation == AtmOperation.TRANSFER)
            setState(new AtmStateFactory().create("Process"));
    }

    public void processTxn(AtmOperation operation) {
        state.processTxn(operation);
        if (operation == AtmOperation.CASHWITHDRAW)
            setState(new AtmStateFactory().create("Dispense"));
        else
            setState(new AtmStateFactory().create("SelectTxn"));
    }

    public void collectCash() {
        state.collectCash();
        setState(new AtmStateFactory().create("EjectCard"));
    }

    public void collectCard() {
        state.collectCard();
        setState(new AtmStateFactory().create("Idle"));
    }


    public void cancelTxn() {
        setState(new AtmStateFactory().create("EjectCard"));
    }

}
