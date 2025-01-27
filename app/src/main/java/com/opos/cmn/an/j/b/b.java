package com.opos.cmn.an.j.b;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class b implements Executor {
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
