package com.opos.exoplayer.core.h;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public final class c implements g {

    /* renamed from: a */
    private final AssetManager f18901a;

    /* renamed from: b */
    private final t<? super c> f18902b;

    /* renamed from: c */
    private Uri f18903c;

    /* renamed from: d */
    private InputStream f18904d;

    /* renamed from: e */
    private long f18905e;

    /* renamed from: f */
    private boolean f18906f;

    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public c(Context context, t<? super c> tVar) {
        this.f18901a = context.getAssets();
        this.f18902b = tVar;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f18905e;
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
        int read = this.f18904d.read(bArr, i2, i3);
        if (read == -1) {
            if (this.f18905e == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j3 = this.f18905e;
        if (j3 != -1) {
            this.f18905e = j3 - read;
        }
        t<? super c> tVar = this.f18902b;
        if (tVar != null) {
            tVar.a((t<? super c>) this, read);
        }
        return read;
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        try {
            Uri uri = iVar.f18918a;
            this.f18903c = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            InputStream open = this.f18901a.open(path, 1);
            this.f18904d = open;
            if (open.skip(iVar.f18921d) < iVar.f18921d) {
                throw new EOFException();
            }
            long j2 = iVar.f18922e;
            if (j2 != -1) {
                this.f18905e = j2;
            } else {
                long available = this.f18904d.available();
                this.f18905e = available;
                if (available == 2147483647L) {
                    this.f18905e = -1L;
                }
            }
            this.f18906f = true;
            t<? super c> tVar = this.f18902b;
            if (tVar != null) {
                tVar.a((t<? super c>) this, iVar);
            }
            return this.f18905e;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        return this.f18903c;
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        this.f18903c = null;
        try {
            try {
                InputStream inputStream = this.f18904d;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e2) {
                throw new a(e2);
            }
        } finally {
            this.f18904d = null;
            if (this.f18906f) {
                this.f18906f = false;
                t<? super c> tVar = this.f18902b;
                if (tVar != null) {
                    tVar.a(this);
                }
            }
        }
    }
}
