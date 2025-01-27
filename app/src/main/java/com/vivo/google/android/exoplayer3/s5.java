package com.vivo.google.android.exoplayer3;

import android.content.Context;
import android.net.Uri;
import com.vivo.google.android.exoplayer3.upstream.DataSource;
import com.vivo.google.android.exoplayer3.upstream.FileDataSource;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class s5 implements DataSource {

    /* renamed from: a */
    public final DataSource f28057a;

    /* renamed from: b */
    public final DataSource f28058b;

    /* renamed from: c */
    public final DataSource f28059c;

    /* renamed from: d */
    public final DataSource f28060d;

    /* renamed from: e */
    public DataSource f28061e;

    public s5(Context context, x5<? super DataSource> x5Var, DataSource dataSource) {
        this.f28057a = (DataSource) g1.a(dataSource);
        this.f28058b = new FileDataSource(x5Var);
        this.f28059c = new l5(context, x5Var);
        this.f28060d = new n5(context, x5Var);
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public void close() {
        DataSource dataSource = this.f28061e;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.f28061e = null;
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public Uri getUri() {
        DataSource dataSource = this.f28061e;
        if (dataSource == null) {
            return null;
        }
        return dataSource.getUri();
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public long open(q5 q5Var) {
        DataSource dataSource;
        g1.b(this.f28061e == null);
        String scheme = q5Var.f27969a.getScheme();
        if (Util.isLocalFileUri(q5Var.f27969a)) {
            if (!q5Var.f27969a.getPath().startsWith("/android_asset/")) {
                dataSource = this.f28058b;
            }
            dataSource = this.f28059c;
        } else {
            if (!"asset".equals(scheme)) {
                dataSource = "content".equals(scheme) ? this.f28060d : this.f28057a;
            }
            dataSource = this.f28059c;
        }
        this.f28061e = dataSource;
        return this.f28061e.open(q5Var);
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public int read(byte[] bArr, int i2, int i3) {
        return this.f28061e.read(bArr, i2, i3);
    }
}
