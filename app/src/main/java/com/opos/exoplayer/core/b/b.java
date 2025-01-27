package com.opos.exoplayer.core.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public byte[] f17717a;

    /* renamed from: b */
    public byte[] f17718b;

    /* renamed from: c */
    public int f17719c;

    /* renamed from: d */
    public int[] f17720d;

    /* renamed from: e */
    public int[] f17721e;

    /* renamed from: f */
    public int f17722f;

    /* renamed from: g */
    public int f17723g;

    /* renamed from: h */
    public int f17724h;

    /* renamed from: i */
    private final MediaCodec.CryptoInfo f17725i;

    /* renamed from: j */
    private final a f17726j;

    @TargetApi(24)
    private static final class a {

        /* renamed from: a */
        private final MediaCodec.CryptoInfo f17727a;

        /* renamed from: b */
        private final MediaCodec.CryptoInfo.Pattern f17728b;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.f17727a = cryptoInfo;
            this.f17728b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* synthetic */ a(MediaCodec.CryptoInfo cryptoInfo, AnonymousClass1 anonymousClass1) {
            this(cryptoInfo);
        }

        public void a(int i2, int i3) {
            this.f17728b.set(i2, i3);
            this.f17727a.setPattern(this.f17728b);
        }
    }

    public b() {
        int i2 = u.f19078a;
        MediaCodec.CryptoInfo b2 = i2 >= 16 ? b() : null;
        this.f17725i = b2;
        this.f17726j = i2 >= 24 ? new a(b2) : null;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo b() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void c() {
        MediaCodec.CryptoInfo cryptoInfo = this.f17725i;
        cryptoInfo.numSubSamples = this.f17722f;
        cryptoInfo.numBytesOfClearData = this.f17720d;
        cryptoInfo.numBytesOfEncryptedData = this.f17721e;
        cryptoInfo.key = this.f17718b;
        cryptoInfo.iv = this.f17717a;
        cryptoInfo.mode = this.f17719c;
        if (u.f19078a >= 24) {
            this.f17726j.a(this.f17723g, this.f17724h);
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo a() {
        return this.f17725i;
    }

    public void a(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        this.f17722f = i2;
        this.f17720d = iArr;
        this.f17721e = iArr2;
        this.f17718b = bArr;
        this.f17717a = bArr2;
        this.f17719c = i3;
        this.f17723g = i4;
        this.f17724h = i5;
        if (u.f19078a >= 16) {
            c();
        }
    }
}
