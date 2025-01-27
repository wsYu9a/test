package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class a implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int aOi;
    private boolean aOj;
    private long aOk;
    private byte[] buf;
    private boolean eof;
    private int offset;
    private InputStream stream;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    private void Lk() {
        if (this.aOi > 0 || this.eof) {
            return;
        }
        try {
            this.offset = 0;
            int read = this.stream.read(this.buf);
            this.aOi = read;
            if (read == 0) {
                com.kwad.sdk.core.d.c.printStackTrace(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.aOk += read;
            }
        } catch (IOException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException(e10));
        }
    }

    public final int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public final int b(f fVar, int i10) {
        int i11 = 36;
        while (i11 > 0) {
            int a10 = a(fVar, i11);
            if (a10 <= 0) {
                return a10;
            }
            i11 -= a10;
        }
        return 36;
    }

    public final void bI(boolean z10) {
        this.aOj = z10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = true;
        this.buf = null;
        this.aOi = 0;
        this.offset = 0;
        InputStream inputStream = this.stream;
        if (inputStream != null && this.aOj) {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
        this.stream = null;
    }

    private a(InputStream inputStream, int i10) {
        this.eof = false;
        this.aOj = true;
        this.aOk = 0L;
        this.stream = inputStream;
        this.buf = new byte[16384];
    }

    private int a(f fVar, int i10) {
        Lk();
        if (i10 <= 0 || i10 >= this.aOi) {
            i10 = this.aOi;
        }
        if (i10 <= 0) {
            if (!this.eof) {
                com.kwad.sdk.core.d.c.printStackTrace(new PngjException("This should not happen"));
            }
            return fVar.isDone() ? -1 : 0;
        }
        int b10 = fVar.b(this.buf, this.offset, i10);
        if (b10 > 0) {
            this.offset += b10;
            this.aOi -= b10;
        }
        if (b10 > 0) {
            return b10;
        }
        if (!fVar.isDone()) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("This should not happen!"));
        }
        return -1;
    }
}
