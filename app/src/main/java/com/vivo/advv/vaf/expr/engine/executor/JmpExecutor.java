package com.vivo.advv.vaf.expr.engine.executor;

/* loaded from: classes4.dex */
public class JmpExecutor extends ArithExecutor {
    private static final String TAG = "JmpExecutor_TMTEST";

    @Override // com.vivo.advv.vaf.expr.engine.executor.Executor
    public int execute(Object obj) {
        super.execute(obj);
        this.mCodeReader.setPos(this.mCodeReader.readInt());
        return 1;
    }
}
