package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.vaf.expr.engine.data.Data;

/* loaded from: classes4.dex */
public class AddEqExecutor extends CompositeEqExecutor {
    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcFloatFloat(Data data, float f2, float f3) {
        data.setFloat(f2 + f3);
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcFloatInt(Data data, float f2, int i2) {
        data.setFloat(f2 + i2);
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcFloatString(Data data, float f2, String str) {
        data.setString(f2 + str);
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcIntFloat(Data data, int i2, float f2) {
        data.setFloat(i2 + f2);
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcIntInt(Data data, int i2, int i3) {
        data.setInt(i2 + i3);
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcIntString(Data data, int i2, String str) {
        data.setString(i2 + str);
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcStringFloat(Data data, String str, float f2) {
        data.setString(str + f2);
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcStringInt(Data data, String str, int i2) {
        data.setString(str + i2);
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.CompositeEqExecutor
    protected void calcStringString(Data data, String str, String str2) {
        data.setString(str + str2);
    }
}
