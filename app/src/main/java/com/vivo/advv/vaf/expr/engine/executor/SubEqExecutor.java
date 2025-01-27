package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.vaf.expr.engine.data.Data;

/* loaded from: classes4.dex */
public class SubEqExecutor extends CompositeEqExecutor {
    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcFloatFloat(Data data, float f2, float f3) {
        data.setFloat(f2 - f3);
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcFloatInt(Data data, float f2, int i2) {
        data.setFloat(f2 - i2);
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcIntFloat(Data data, int i2, float f2) {
        data.setFloat(i2 - f2);
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcIntInt(Data data, int i2, int i3) {
        data.setInt(i2 - i3);
    }
}
