package com.google.zxing;

/* loaded from: classes2.dex */
public abstract class ReaderException extends Exception {
    protected static final StackTraceElement[] NO_TRACE;
    protected static final boolean isStackTrace;

    static {
        isStackTrace = System.getProperty("surefire.test.class.path") != null;
        NO_TRACE = new StackTraceElement[0];
    }

    public ReaderException() {
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    public ReaderException(Throwable th2) {
        super(th2);
    }
}
