package com.example.apachecommonschainDemo;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;

public class AuditFilter implements Filter {
    @Override
    public boolean postprocess(Context context, Exception e) {
        //send notification to bank and user
        return false;
    }

    @Override
    public boolean execute(Context context) throws Exception {
        return false;
    }
}
