package com.vivo.google.android.exoplayer3;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.vivo.google.android.exoplayer3.upstream.DataSource;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public final class n5 implements DataSource {

    /* renamed from: a */
    public final ContentResolver f27867a;

    /* renamed from: b */
    public final x5<? super n5> f27868b;

    /* renamed from: c */
    public Uri f27869c;

    /* renamed from: d */
    public AssetFileDescriptor f27870d;

    /* renamed from: e */
    public InputStream f27871e;

    /* renamed from: f */
    public long f27872f;

    /* renamed from: g */
    public boolean f27873g;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public n5(Context context, x5<? super n5> x5Var) {
        this.f27867a = context.getContentResolver();
        this.f27868b = x5Var;
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public void close() {
        this.f27869c = null;
        try {
            try {
                InputStream inputStream = this.f27871e;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f27871e = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f27870d;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e2) {
                        throw new a(e2);
                    }
                } finally {
                    this.f27870d = null;
                    if (this.f27873g) {
                        this.f27873g = false;
                        x5<? super n5> x5Var = this.f27868b;
                        if (x5Var != null) {
                            x5Var.onTransferEnd(this);
                        }
                    }
                }
            } catch (IOException e3) {
                throw new a(e3);
            }
        } catch (Throwable th) {
            this.f27871e = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f27870d;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f27870d = null;
                    if (this.f27873g) {
                        this.f27873g = false;
                        x5<? super n5> x5Var2 = this.f27868b;
                        if (x5Var2 != null) {
                            x5Var2.onTransferEnd(this);
                        }
                    }
                    throw th;
                } finally {
                    this.f27870d = null;
                    if (this.f27873g) {
                        this.f27873g = false;
                        x5<? super n5> x5Var3 = this.f27868b;
                        if (x5Var3 != null) {
                            x5Var3.onTransferEnd(this);
                        }
                    }
                }
            } catch (IOException e4) {
                throw new a(e4);
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public Uri getUri() {
        return this.f27869c;
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public long open(q5 q5Var) {
        try {
            Uri uri = q5Var.f27969a;
            this.f27869c = uri;
            AssetFileDescriptor openAssetFileDescriptor = this.f27867a.openAssetFileDescriptor(uri, com.kuaishou.weapon.p0.t.k);
            this.f27870d = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.f27869c);
            }
            this.f27871e = new FileInputStream(this.f27870d.getFileDescriptor());
            long startOffset = this.f27870d.getStartOffset();
            if (this.f27871e.skip(q5Var.f27972d + startOffset) - startOffset != q5Var.f27972d) {
                throw new EOFException();
            }
            long j2 = q5Var.f27973e;
            if (j2 != -1) {
                this.f27872f = j2;
            } else {
                long length = this.f27870d.getLength();
                this.f27872f = length;
                if (length == -1) {
                    long available = this.f27871e.available();
                    this.f27872f = available;
                    if (available == 0) {
                        this.f27872f = -1L;
                    }
                }
            }
            this.f27873g = true;
            x5<? super n5> x5Var = this.f27868b;
            if (x5Var != null) {
                x5Var.onTransferStart(this, q5Var);
            }
            return this.f27872f;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f27872f;
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
        int read = this.f27871e.read(bArr, i2, i3);
        if (read == -1) {
            if (this.f27872f == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j3 = this.f27872f;
        if (j3 != -1) {
            this.f27872f = j3 - read;
        }
        x5<? super n5> x5Var = this.f27868b;
        if (x5Var != null) {
            x5Var.onBytesTransferred(this, read);
        }
        return read;
    }
}
