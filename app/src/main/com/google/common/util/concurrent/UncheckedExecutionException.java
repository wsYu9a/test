package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

@a5.b
@p5.m
/* loaded from: classes2.dex */
public class UncheckedExecutionException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedExecutionException() {
    }

    public UncheckedExecutionException(@CheckForNull String str) {
        super(str);
    }

    public UncheckedExecutionException(@CheckForNull String str, @CheckForNull Throwable th2) {
        super(str, th2);
    }

    public UncheckedExecutionException(@CheckForNull Throwable th2) {
        super(th2);
    }
}
