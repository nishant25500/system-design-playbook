package ATM.factory;

import ATM.states.*;

public class AtmStateFactory {
    AtmState state;

    public AtmStateFactory() {

    }

    public AtmState create(String state) {
        if (state.equalsIgnoreCase("CardReading"))
            return new ReadCardState();
        else if (state.equalsIgnoreCase("VerifyPin"))
            return new VerifyPinState();
        else if (state.equalsIgnoreCase("SelectTxn"))
            return new SelectTxnState();
        else if (state.equalsIgnoreCase("Process"))
            return new ProcessState();
        else if (state.equalsIgnoreCase("Dispense"))
            return new DispenseState();
        else if (state.equalsIgnoreCase("EjectCard"))
            return new EjectCardState();
        else if (state.equalsIgnoreCase("Idle"))
            return new IdleState();

        throw new IllegalArgumentException("Atm State doesn't exist!");
    }
}
