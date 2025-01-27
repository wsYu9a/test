package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.vaf.expr.engine.data.Data;

/* loaded from: classes4.dex */
public class AndExecutor extends BinExecutor {
    private static final String TAG = "AndExecutor_TMTEST";

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcIntInt(Data data, int i2, int i3) {
        data.setInt((1 == i2 && 1 == i3) ? 1 : 0);
        return 1;
    }
}
