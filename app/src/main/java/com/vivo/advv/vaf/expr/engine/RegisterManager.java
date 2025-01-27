package com.vivo.advv.vaf.expr.engine;

import com.vivo.advv.vaf.expr.engine.data.Data;

/* loaded from: classes4.dex */
public class RegisterManager {
    public static final int MAX_REGISTER_COUNT = 20;
    private static final String TAG = "RegisterManager_TMTEST";
    private Data[] mRegisters = new Data[20];

    public RegisterManager() {
        for (int i2 = 0; i2 < 20; i2++) {
            this.mRegisters[i2] = new Data();
        }
    }

    public void destroy() {
        this.mRegisters = null;
    }

    public Data get(int i2) {
        if (i2 < 0 || i2 >= 20) {
            return null;
        }
        return this.mRegisters[i2];
    }
}
