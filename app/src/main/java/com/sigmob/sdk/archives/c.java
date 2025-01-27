package com.sigmob.sdk.archives;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class c extends InputStream {

    /* renamed from: c */
    public static final int f17508c = 255;

    /* renamed from: a */
    public byte[] f17509a = new byte[1];

    /* renamed from: b */
    public long f17510b = 0;

    public boolean a(a aVar) {
        return true;
    }

    @Deprecated
    public int b() {
        return (int) this.f17510b;
    }

    public abstract a c() throws IOException;

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f17509a, 0, 1) == -1) {
            return -1;
        }
        return this.f17509a[0] & 255;
    }

    public void a(int i10) {
        a(i10);
    }

    public void b(long j10) {
        this.f17510b -= j10;
    }

    public final void a(long j10) {
        if (j10 != -1) {
            this.f17510b += j10;
        }
    }

    public long a() {
        return this.f17510b;
    }
}
