package com.google.common.base;

import b5.g;
import javax.annotation.CheckForNull;

@a5.b
@g
/* loaded from: classes2.dex */
public class VerifyException extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(@CheckForNull String str) {
        super(str);
    }

    public VerifyException(@CheckForNull Throwable th2) {
        super(th2);
    }

    public VerifyException(@CheckForNull String str, @CheckForNull Throwable th2) {
        super(str, th2);
    }
}
