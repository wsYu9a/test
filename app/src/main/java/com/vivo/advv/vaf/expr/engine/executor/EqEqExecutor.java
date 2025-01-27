package com.vivo.advv.vaf.expr.engine.executor;

import android.text.TextUtils;
import com.vivo.advv.vaf.expr.engine.data.Data;

/* loaded from: classes4.dex */
public class EqEqExecutor extends BinExecutor {
    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcFloatFloat(Data data, float f2, float f3) {
        data.setInt(f2 == f3 ? 1 : 0);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcFloatInt(Data data, float f2, int i2) {
        data.setInt(f2 == ((float) i2) ? 1 : 0);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcIntFloat(Data data, int i2, float f2) {
        data.setInt(((float) i2) == f2 ? 1 : 0);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcIntInt(Data data, int i2, int i3) {
        data.setInt(i2 == i3 ? 1 : 0);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcStringString(Data data, String str, String str2) {
        data.setInt(TextUtils.equals(str, str2) ? 1 : 0);
        return 1;
    }
}
