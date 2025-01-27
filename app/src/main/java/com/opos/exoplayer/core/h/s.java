package com.opos.exoplayer.core.h;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public final class s implements g {

    /* renamed from: a */
    private final Resources f19001a;

    /* renamed from: b */
    private final t<? super s> f19002b;

    /* renamed from: c */
    private Uri f19003c;

    /* renamed from: d */
    private AssetFileDescriptor f19004d;

    /* renamed from: e */
    private InputStream f19005e;

    /* renamed from: f */
    private long f19006f;

    /* renamed from: g */
    private boolean f19007g;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }

        public a(String str) {
            super(str);
        }
    }

    public s(Context context, t<? super s> tVar) {
        this.f19001a = context.getResources();
        this.f19002b = tVar;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f19006f;
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
        int read = this.f19005e.read(bArr, i2, i3);
        if (read == -1) {
            if (this.f19006f == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j3 = this.f19006f;
        if (j3 != -1) {
            this.f19006f = j3 - read;
        }
        t<? super s> tVar = this.f19002b;
        if (tVar != null) {
            tVar.a((t<? super s>) this, read);
        }
        return read;
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        try {
            Uri uri = iVar.f18918a;
            this.f19003c = uri;
            if (!TextUtils.equals("rawresource", uri.getScheme())) {
                throw new a("URI must use scheme rawresource");
            }
            try {
                this.f19004d = this.f19001a.openRawResourceFd(Integer.parseInt(this.f19003c.getLastPathSegment()));
                FileInputStream fileInputStream = new FileInputStream(this.f19004d.getFileDescriptor());
                this.f19005e = fileInputStream;
                fileInputStream.skip(this.f19004d.getStartOffset());
                if (this.f19005e.skip(iVar.f18921d) < iVar.f18921d) {
                    throw new EOFException();
                }
                long j2 = iVar.f18922e;
                long j3 = -1;
                if (j2 != -1) {
                    this.f19006f = j2;
                } else {
                    long length = this.f19004d.getLength();
                    if (length != -1) {
                        j3 = length - iVar.f18921d;
                    }
                    this.f19006f = j3;
                }
                this.f19007g = true;
                t<? super s> tVar = this.f19002b;
                if (tVar != null) {
                    tVar.a((t<? super s>) this, iVar);
                }
                return this.f19006f;
            } catch (NumberFormatException unused) {
                throw new a("Resource identifier must be an integer.");
            }
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        return this.f19003c;
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        this.f19003c = null;
        try {
            try {
                InputStream inputStream = this.f19005e;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f19005e = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f19004d;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e2) {
                        throw new a(e2);
                    }
                } finally {
                    this.f19004d = null;
                    if (this.f19007g) {
                        this.f19007g = false;
                        t<? super s> tVar = this.f19002b;
                        if (tVar != null) {
                            tVar.a(this);
                        }
                    }
                }
            } catch (IOException e3) {
                throw new a(e3);
            }
        } catch (Throwable th) {
            this.f19005e = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f19004d;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f19004d = null;
                    if (this.f19007g) {
                        this.f19007g = false;
                        t<? super s> tVar2 = this.f19002b;
                        if (tVar2 != null) {
                            tVar2.a(this);
                        }
                    }
                    throw th;
                } finally {
                    this.f19004d = null;
                    if (this.f19007g) {
                        this.f19007g = false;
                        t<? super s> tVar3 = this.f19002b;
                        if (tVar3 != null) {
                            tVar3.a(this);
                        }
                    }
                }
            } catch (IOException e4) {
                throw new a(e4);
            }
        }
    }
}
