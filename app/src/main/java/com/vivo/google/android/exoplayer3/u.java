package com.vivo.google.android.exoplayer3;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class u {

    /* renamed from: a */
    public byte[] f28120a;

    /* renamed from: b */
    public byte[] f28121b;

    /* renamed from: c */
    public int f28122c;

    /* renamed from: d */
    public int[] f28123d;

    /* renamed from: e */
    public int[] f28124e;

    /* renamed from: f */
    public int f28125f;

    /* renamed from: g */
    public int f28126g;

    /* renamed from: h */
    public int f28127h;

    /* renamed from: i */
    public final MediaCodec.CryptoInfo f28128i;

    /* renamed from: j */
    public final b f28129j;

    @TargetApi(24)
    public static final class b {

        /* renamed from: a */
        public final MediaCodec.CryptoInfo f28130a;

        /* renamed from: b */
        public final MediaCodec.CryptoInfo.Pattern f28131b;

        public b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f28130a = cryptoInfo;
            this.f28131b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        public /* synthetic */ b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this(cryptoInfo);
        }
    }

    public u() {
        int i2 = Util.SDK_INT;
        MediaCodec.CryptoInfo a2 = i2 >= 16 ? a() : null;
        this.f28128i = a2;
        this.f28129j = i2 >= 24 ? new b(a2) : null;
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo a() {
        return new MediaCodec.CryptoInfo();
    }
}
