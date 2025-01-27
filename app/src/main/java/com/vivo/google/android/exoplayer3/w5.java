package com.vivo.google.android.exoplayer3;

import android.net.Uri;
import com.vivo.google.android.exoplayer3.upstream.DataSource;

/* loaded from: classes4.dex */
public final class w5 implements DataSource {

    /* renamed from: a */
    public final DataSource f28248a;

    /* renamed from: b */
    public final o5 f28249b;

    public w5(DataSource dataSource, o5 o5Var) {
        this.f28248a = (DataSource) g1.a(dataSource);
        this.f28249b = (o5) g1.a(o5Var);
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public void close() {
        try {
            this.f28248a.close();
        } finally {
            this.f28249b.close();
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public Uri getUri() {
        return this.f28248a.getUri();
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public long open(q5 q5Var) {
        long open = this.f28248a.open(q5Var);
        if (q5Var.f27973e == -1 && open != -1) {
            q5Var = new q5(q5Var.f27969a, null, q5Var.f27971c, q5Var.f27972d, open, q5Var.f27974f, q5Var.f27975g);
        }
        this.f28249b.open(q5Var);
        return open;
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public int read(byte[] bArr, int i2, int i3) {
        int read = this.f28248a.read(bArr, i2, i3);
        if (read > 0) {
            this.f28249b.write(bArr, i2, read);
        }
        return read;
    }
}
