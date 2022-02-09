package com.example.apachecommonschainDemo;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.impl.ChainBase;

public class AtmWithdrawalChain extends ChainBase {
    public AtmWithdrawalChain() {
        super();
        addCommand(new HundredDenominationDispenser());
        addCommand(new FiftyDenominationDispenser());
        addCommand(new TenDenominationDispenser());
        addCommand(new AuditFilter());
    }
}
