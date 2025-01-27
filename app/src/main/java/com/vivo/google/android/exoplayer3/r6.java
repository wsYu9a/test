package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.util.Util;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class r6 extends BufferedOutputStream {

    /* renamed from: a */
    public boolean f28024a;

    public r6(OutputStream outputStream) {
        super(outputStream);
    }

    public r6(OutputStream outputStream, int i2) {
        super(outputStream, i2);
    }

    public void a(OutputStream outputStream) {
        g1.b(this.f28024a);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f28024a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f28024a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            Util.sneakyThrow(th);
        }
    }
}
