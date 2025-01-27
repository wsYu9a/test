package com.opos.exoplayer.core.h;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes4.dex */
public final class e implements g {

    /* renamed from: a */
    private final ContentResolver f18907a;

    /* renamed from: b */
    private final t<? super e> f18908b;

    /* renamed from: c */
    private Uri f18909c;

    /* renamed from: d */
    private AssetFileDescriptor f18910d;

    /* renamed from: e */
    private FileInputStream f18911e;

    /* renamed from: f */
    private long f18912f;

    /* renamed from: g */
    private boolean f18913g;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public e(Context context, t<? super e> tVar) {
        this.f18907a = context.getContentResolver();
        this.f18908b = tVar;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f18912f;
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
        int read = this.f18911e.read(bArr, i2, i3);
        if (read == -1) {
            if (this.f18912f == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j3 = this.f18912f;
        if (j3 != -1) {
            this.f18912f = j3 - read;
        }
        t<? super e> tVar = this.f18908b;
        if (tVar != null) {
            tVar.a((t<? super e>) this, read);
        }
        return read;
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        try {
            Uri uri = iVar.f18918a;
            this.f18909c = uri;
            AssetFileDescriptor openAssetFileDescriptor = this.f18907a.openAssetFileDescriptor(uri, com.kuaishou.weapon.p0.t.k);
            this.f18910d = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.f18909c);
            }
            this.f18911e = new FileInputStream(this.f18910d.getFileDescriptor());
            long startOffset = this.f18910d.getStartOffset();
            long skip = this.f18911e.skip(iVar.f18921d + startOffset) - startOffset;
            if (skip != iVar.f18921d) {
                throw new EOFException();
            }
            long j2 = iVar.f18922e;
            long j3 = -1;
            if (j2 != -1) {
                this.f18912f = j2;
            } else {
                long length = this.f18910d.getLength();
                if (length == -1) {
                    FileChannel channel = this.f18911e.getChannel();
                    long size = channel.size();
                    if (size != 0) {
                        j3 = size - channel.position();
                    }
                    this.f18912f = j3;
                } else {
                    this.f18912f = length - skip;
                }
            }
            this.f18913g = true;
            t<? super e> tVar = this.f18908b;
            if (tVar != null) {
                tVar.a((t<? super e>) this, iVar);
            }
            return this.f18912f;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        return this.f18909c;
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        this.f18909c = null;
        try {
            try {
                FileInputStream fileInputStream = this.f18911e;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f18911e = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f18910d;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e2) {
                        throw new a(e2);
                    }
                } finally {
                    this.f18910d = null;
                    if (this.f18913g) {
                        this.f18913g = false;
                        t<? super e> tVar = this.f18908b;
                        if (tVar != null) {
                            tVar.a(this);
                        }
                    }
                }
            } catch (IOException e3) {
                throw new a(e3);
            }
        } catch (Throwable th) {
            this.f18911e = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f18910d;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f18910d = null;
                    if (this.f18913g) {
                        this.f18913g = false;
                        t<? super e> tVar2 = this.f18908b;
                        if (tVar2 != null) {
                            tVar2.a(this);
                        }
                    }
                    throw th;
                } finally {
                    this.f18910d = null;
                    if (this.f18913g) {
                        this.f18913g = false;
                        t<? super e> tVar3 = this.f18908b;
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
