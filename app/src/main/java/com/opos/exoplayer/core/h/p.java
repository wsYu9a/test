package com.opos.exoplayer.core.h;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes4.dex */
public final class p implements g {

    /* renamed from: a */
    private final t<? super p> f18974a;

    /* renamed from: b */
    private RandomAccessFile f18975b;

    /* renamed from: c */
    private Uri f18976c;

    /* renamed from: d */
    private long f18977d;

    /* renamed from: e */
    private boolean f18978e;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public p() {
        this(null);
    }

    public p(t<? super p> tVar) {
        this.f18974a = tVar;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f18977d;
        if (j2 == 0) {
            return -1;
        }
        try {
            int read = this.f18975b.read(bArr, i2, (int) Math.min(j2, i3));
            if (read <= 0) {
                return read;
            }
            this.f18977d -= read;
            t<? super p> tVar = this.f18974a;
            if (tVar == null) {
                return read;
            }
            tVar.a((t<? super p>) this, read);
            return read;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        try {
            this.f18976c = iVar.f18918a;
            RandomAccessFile randomAccessFile = new RandomAccessFile(iVar.f18918a.getPath(), com.kuaishou.weapon.p0.t.k);
            this.f18975b = randomAccessFile;
            randomAccessFile.seek(iVar.f18921d);
            long j2 = iVar.f18922e;
            if (j2 == -1) {
                j2 = this.f18975b.length() - iVar.f18921d;
            }
            this.f18977d = j2;
            if (j2 < 0) {
                throw new EOFException();
            }
            this.f18978e = true;
            t<? super p> tVar = this.f18974a;
            if (tVar != null) {
                tVar.a((t<? super p>) this, iVar);
            }
            return this.f18977d;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        return this.f18976c;
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        this.f18976c = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f18975b;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e2) {
                throw new a(e2);
            }
        } finally {
            this.f18975b = null;
            if (this.f18978e) {
                this.f18978e = false;
                t<? super p> tVar = this.f18974a;
                if (tVar != null) {
                    tVar.a(this);
                }
            }
        }
    }
}
