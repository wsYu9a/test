package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

@a5.b
@p5.m
/* loaded from: classes2.dex */
enum DirectExecutor implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
