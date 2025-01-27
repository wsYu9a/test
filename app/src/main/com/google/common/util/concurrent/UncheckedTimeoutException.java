package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

@a5.c
@p5.m
/* loaded from: classes2.dex */
public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(@CheckForNull String str) {
        super(str);
    }

    public UncheckedTimeoutException(@CheckForNull Throwable th2) {
        super(th2);
    }

    public UncheckedTimeoutException(@CheckForNull String str, @CheckForNull Throwable th2) {
        super(str, th2);
    }
}
