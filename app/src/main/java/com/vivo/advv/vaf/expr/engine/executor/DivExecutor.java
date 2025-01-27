package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.vaf.expr.engine.data.Data;
import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public class DivExecutor extends BinExecutor {
    private static final String TAG = "DivExecutor_TMTEST";

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcFloatFloat(Data data, float f2, float f3) {
        data.setFloat(f2 / f3);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcFloatInt(Data data, float f2, int i2) {
        if (i2 == 0) {
            VVLog.e(TAG, "div zero");
            return 2;
        }
        data.setFloat(f2 / i2);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcIntFloat(Data data, int i2, float f2) {
        data.setFloat(i2 / f2);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcIntInt(Data data, int i2, int i3) {
        if (i3 == 0) {
            VVLog.e(TAG, "div zero");
            return 2;
        }
        data.setInt(i2 / i3);
        return 1;
    }
}
