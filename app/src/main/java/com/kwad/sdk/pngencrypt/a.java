package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class a implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int auu;
    private boolean auv;
    private long auw;
    private byte[] buf;
    private boolean eof;
    private int offset;
    private InputStream stream;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    private a(InputStream inputStream, int i2) {
        this.eof = false;
        this.auv = true;
        this.auw = 0L;
        this.stream = inputStream;
        this.buf = new byte[16384];
    }

    private void Bi() {
        if (this.auu > 0 || this.eof) {
            return;
        }
        try {
            this.offset = 0;
            int read = this.stream.read(this.buf);
            this.auu = read;
            if (read == 0) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.auw += read;
            }
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException(e2));
        }
    }

    private int a(f fVar, int i2) {
        Bi();
        if (i2 <= 0 || i2 >= this.auu) {
            i2 = this.auu;
        }
        if (i2 <= 0) {
            if (!this.eof) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("This should not happen"));
            }
            return fVar.isDone() ? -1 : 0;
        }
        int b2 = fVar.b(this.buf, this.offset, i2);
        if (b2 > 0) {
            this.offset += b2;
            this.auu -= b2;
        }
        if (b2 > 0) {
            return b2;
        }
        if (!fVar.isDone()) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("This should not happen!"));
        }
        return -1;
    }

    public final int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public final int b(f fVar, int i2) {
        int i3 = 36;
        while (i3 > 0) {
            int a2 = a(fVar, i3);
            if (a2 <= 0) {
                return a2;
            }
            i3 -= a2;
        }
        return 36;
    }

    public final void bl(boolean z) {
        this.auv = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = true;
        this.buf = null;
        this.auu = 0;
        this.offset = 0;
        InputStream inputStream = this.stream;
        if (inputStream != null && this.auv) {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
        this.stream = null;
    }
}
