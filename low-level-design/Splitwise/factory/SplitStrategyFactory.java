package Splitwise.factory;

import Splitwise.strategy.EqualSplitStrategyImpl;
import Splitwise.strategy.ExactSplitStrategyImpl;
import Splitwise.strategy.PercentageSplitStrategyImpl;
import Splitwise.strategy.SplitStrategy;

public class SplitStrategyFactory {
    String splitType;

    public SplitStrategyFactory(String splitType) {
        this.splitType = splitType;
    }

    public SplitStrategy getSplitTypeObject() {
        if (splitType.equalsIgnoreCase("Exact"))
            return new ExactSplitStrategyImpl();
        else if (splitType.equalsIgnoreCase("Equal")) {
            return new EqualSplitStrategyImpl();
        } else if (splitType.equalsIgnoreCase("Percentage")) {
            return new PercentageSplitStrategyImpl();
        }

        throw new IllegalArgumentException("SplitType doesn't exist!");
    }
}
