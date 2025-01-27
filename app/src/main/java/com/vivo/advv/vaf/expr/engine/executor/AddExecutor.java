package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.vaf.expr.engine.data.Data;

/* loaded from: classes4.dex */
public class AddExecutor extends BinExecutor {
    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcFloatFloat(Data data, float f2, float f3) {
        data.setFloat(f2 + f3);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcFloatInt(Data data, float f2, int i2) {
        data.setFloat(f2 + i2);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcFloatString(Data data, float f2, String str) {
        data.setString(f2 + str);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcIntFloat(Data data, int i2, float f2) {
        data.setFloat(i2 + f2);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcIntInt(Data data, int i2, int i3) {
        data.setInt(i2 + i3);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcIntString(Data data, int i2, String str) {
        data.setString(i2 + str);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcStringFloat(Data data, String str, float f2) {
        data.setString(str + f2);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcStringInt(Data data, String str, int i2) {
        data.setString(str + i2);
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.BinExecutor
    protected int calcStringString(Data data, String str, String str2) {
        data.setString(str + str2);
        return 1;
    }
}
