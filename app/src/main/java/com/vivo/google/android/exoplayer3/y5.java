package com.vivo.google.android.exoplayer3;

import java.io.File;
import java.io.IOException;

/* loaded from: classes4.dex */
public interface y5 {

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }

        public a(String str) {
            super(str);
        }
    }

    public interface b {
        void onSpanAdded(y5 y5Var, a6 a6Var);

        void onSpanRemoved(y5 y5Var, a6 a6Var);

        void onSpanTouched(y5 y5Var, a6 a6Var, a6 a6Var2);
    }

    void commitFile(File file);

    long getCacheSpace();

    long getContentLength(String str);

    void releaseHoleSpan(a6 a6Var);

    void removeSpan(a6 a6Var);

    void setContentLength(String str, long j2);

    File startFile(String str, long j2, long j3);

    a6 startReadWrite(String str, long j2);

    a6 startReadWriteNonBlocking(String str, long j2);
}
