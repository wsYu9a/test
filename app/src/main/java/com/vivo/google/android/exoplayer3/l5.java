package com.vivo.google.android.exoplayer3;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.vivo.google.android.exoplayer3.upstream.DataSource;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public final class l5 implements DataSource {

    /* renamed from: a */
    public final AssetManager f27720a;

    /* renamed from: b */
    public final x5<? super l5> f27721b;

    /* renamed from: c */
    public Uri f27722c;

    /* renamed from: d */
    public InputStream f27723d;

    /* renamed from: e */
    public long f27724e;

    /* renamed from: f */
    public boolean f27725f;

    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public l5(Context context, x5<? super l5> x5Var) {
        this.f27720a = context.getAssets();
        this.f27721b = x5Var;
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public void close() {
        this.f27722c = null;
        try {
            try {
                InputStream inputStream = this.f27723d;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e2) {
                throw new a(e2);
            }
        } finally {
            this.f27723d = null;
            if (this.f27725f) {
                this.f27725f = false;
                x5<? super l5> x5Var = this.f27721b;
                if (x5Var != null) {
                    x5Var.onTransferEnd(this);
                }
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public Uri getUri() {
        return this.f27722c;
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public long open(q5 q5Var) {
        try {
            Uri uri = q5Var.f27969a;
            this.f27722c = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            InputStream open = this.f27720a.open(path, 1);
            this.f27723d = open;
            if (open.skip(q5Var.f27972d) < q5Var.f27972d) {
                throw new EOFException();
            }
            long j2 = q5Var.f27973e;
            if (j2 != -1) {
                this.f27724e = j2;
            } else {
                long available = this.f27723d.available();
                this.f27724e = available;
                if (available == 2147483647L) {
                    this.f27724e = -1L;
                }
            }
            this.f27725f = true;
            x5<? super l5> x5Var = this.f27721b;
            if (x5Var != null) {
                x5Var.onTransferStart(this, q5Var);
            }
            return this.f27724e;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f27724e;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, i3);
            } catch (IOException e2) {
                throw new a(e2);
            }
        }
        int read = this.f27723d.read(bArr, i2, i3);
        if (read == -1) {
            if (this.f27724e == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j3 = this.f27724e;
        if (j3 != -1) {
            this.f27724e = j3 - read;
        }
        x5<? super l5> x5Var = this.f27721b;
        if (x5Var != null) {
            x5Var.onBytesTransferred(this, read);
        }
        return read;
    }
}
