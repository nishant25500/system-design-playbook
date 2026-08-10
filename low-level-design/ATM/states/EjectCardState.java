package ATM.states;

import ATM.enums.AtmOperation;

public class EjectCardState implements AtmState {
    @Override
    public void insertCard() {
        // can't perform this operation
        System.out.println("can't perform this operation at this state");
    }

    @Override
    public void readingCard() {
        // can't perform this operation
        System.out.println("can't perform this operation at this state");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("can't perform this operation at this state");
    }

    @Override
    public AtmOperation selectOperation() {
        System.out.println("can't perform this operation at this state");
        return null;
    }

    @Override
    public void processTxn(AtmOperation operation) {
        System.out.println("can't perform this operation at this state");
    }

    @Override
    public void collectCash() {
        System.out.println("can't perform this operation at this state");
    }

    @Override
    public void collectCard() {
        // collect your card
    }

    @Override
    public void cancelTxn() {
        System.out.println("can't perform this operation at this state");
    }

    @Override
    public void ejectCard() {
        System.out.println("can't perform this operation at this state");
    }
}
