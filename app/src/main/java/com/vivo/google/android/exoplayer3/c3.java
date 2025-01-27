package com.vivo.google.android.exoplayer3;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.vivo.google.android.exoplayer3.decoder.DecoderCounters;
import com.vivo.google.android.exoplayer3.e3;
import com.vivo.google.android.exoplayer3.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* loaded from: classes4.dex */
public abstract class c3 extends com.vivo.google.android.exoplayer3.a {
    public static final byte[] M = Util.getBytesFromHexString("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    public int A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public DecoderCounters L;

    /* renamed from: a */
    public final d3 f27247a;

    /* renamed from: b */
    public final a0<b0> f27248b;

    /* renamed from: c */
    public final boolean f27249c;

    /* renamed from: d */
    public final w f27250d;

    /* renamed from: e */
    public final w f27251e;

    /* renamed from: f */
    public final C0922c f27252f;

    /* renamed from: g */
    public final List<Long> f27253g;

    /* renamed from: h */
    public final MediaCodec.BufferInfo f27254h;

    /* renamed from: i */
    public Format f27255i;

    /* renamed from: j */
    public MediaCodec f27256j;
    public z<b0> k;
    public z<b0> l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public ByteBuffer[] w;
    public ByteBuffer[] x;
    public long y;
    public int z;

    public static class a extends Exception {
        public a(Format format, Throwable th, boolean z, int i2) {
            super("Decoder init failed: [" + i2 + "], " + format, th);
            String str = format.sampleMimeType;
            a(i2);
        }

        public a(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            String str2 = format.sampleMimeType;
            if (Util.SDK_INT >= 21) {
                a(th);
            }
        }

        public static String a(int i2) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i2 < 0 ? "neg_" : "") + Math.abs(i2);
        }

        @TargetApi(21)
        public static String a(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }
    }

    public c3(int i2, d3 d3Var, a0<b0> a0Var, boolean z) {
        super(i2);
        g1.b(Util.SDK_INT >= 16);
        this.f27247a = (d3) g1.a(d3Var);
        this.f27248b = a0Var;
        this.f27249c = z;
        this.f27250d = new w(0);
        this.f27251e = w.c();
        this.f27252f = new C0922c();
        this.f27253g = new ArrayList();
        this.f27254h = new MediaCodec.BufferInfo();
        this.D = 0;
        this.E = 0;
    }

    public abstract int a(d3 d3Var, Format format);

    public b3 a(d3 d3Var, Format format, boolean z) {
        return d3Var.a(format.sampleMimeType, z);
    }

    public abstract void a(MediaCodec mediaCodec, MediaFormat mediaFormat);

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        if (r5.height == r0.height) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.vivo.google.android.exoplayer3.Format r5) {
        /*
            r4 = this;
            com.vivo.google.android.exoplayer3.Format r0 = r4.f27255i
            r4.f27255i = r5
            com.vivo.google.android.exoplayer3.drm.DrmInitData r5 = r5.drmInitData
            r1 = 0
            if (r0 != 0) goto Lb
            r2 = r1
            goto Ld
        Lb:
            com.vivo.google.android.exoplayer3.drm.DrmInitData r2 = r0.drmInitData
        Ld:
            boolean r5 = com.vivo.google.android.exoplayer3.util.Util.areEqual(r5, r2)
            r2 = 1
            r5 = r5 ^ r2
            if (r5 == 0) goto L49
            com.vivo.google.android.exoplayer3.Format r5 = r4.f27255i
            com.vivo.google.android.exoplayer3.drm.DrmInitData r5 = r5.drmInitData
            if (r5 == 0) goto L47
            com.vivo.google.android.exoplayer3.a0<com.vivo.google.android.exoplayer3.b0> r5 = r4.f27248b
            if (r5 == 0) goto L37
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.vivo.google.android.exoplayer3.Format r3 = r4.f27255i
            com.vivo.google.android.exoplayer3.drm.DrmInitData r3 = r3.drmInitData
            com.vivo.google.android.exoplayer3.z r5 = r5.a(r1, r3)
            r4.l = r5
            com.vivo.google.android.exoplayer3.z<com.vivo.google.android.exoplayer3.b0> r1 = r4.k
            if (r5 != r1) goto L49
            com.vivo.google.android.exoplayer3.a0<com.vivo.google.android.exoplayer3.b0> r1 = r4.f27248b
            r1.a(r5)
            goto L49
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            int r0 = r4.getIndex()
            com.vivo.google.android.exoplayer3.ExoPlaybackException r5 = com.vivo.google.android.exoplayer3.ExoPlaybackException.createForRenderer(r5, r0)
            throw r5
        L47:
            r4.l = r1
        L49:
            com.vivo.google.android.exoplayer3.z<com.vivo.google.android.exoplayer3.b0> r5 = r4.l
            com.vivo.google.android.exoplayer3.z<com.vivo.google.android.exoplayer3.b0> r1 = r4.k
            if (r5 != r1) goto L78
            android.media.MediaCodec r5 = r4.f27256j
            if (r5 == 0) goto L78
            boolean r1 = r4.m
            com.vivo.google.android.exoplayer3.Format r3 = r4.f27255i
            boolean r5 = r4.a(r5, r1, r0, r3)
            if (r5 == 0) goto L78
            r4.C = r2
            r4.D = r2
            boolean r5 = r4.p
            if (r5 == 0) goto L74
            com.vivo.google.android.exoplayer3.Format r5 = r4.f27255i
            int r1 = r5.width
            int r3 = r0.width
            if (r1 != r3) goto L74
            int r5 = r5.height
            int r0 = r0.height
            if (r5 != r0) goto L74
            goto L75
        L74:
            r2 = 0
        L75:
            r4.u = r2
            goto L85
        L78:
            boolean r5 = r4.F
            if (r5 == 0) goto L7f
            r4.E = r2
            goto L85
        L7f:
            r4.d()
            r4.b()
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.c3.a(com.vivo.google.android.exoplayer3.Format):void");
    }

    public abstract void a(b3 b3Var, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    public void a(w wVar) {
    }

    public abstract void a(String str, long j2, long j3);

    public abstract boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z);

    public boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.c3.b():void");
    }

    public final void c() {
        if (this.E == 2) {
            d();
            b();
        } else {
            this.I = true;
            e();
        }
    }

    public void d() {
        if (this.f27256j != null) {
            this.y = C.TIME_UNSET;
            this.z = -1;
            this.A = -1;
            this.J = false;
            this.B = false;
            this.f27253g.clear();
            this.w = null;
            this.x = null;
            this.C = false;
            this.F = false;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = false;
            this.t = false;
            this.u = false;
            this.v = false;
            this.G = false;
            this.D = 0;
            this.E = 0;
            this.L.decoderReleaseCount++;
            this.f27250d.f28192c = null;
            try {
                this.f27256j.stop();
                try {
                    this.f27256j.release();
                    this.f27256j = null;
                    z<b0> zVar = this.k;
                    if (zVar == null || this.l == zVar) {
                        return;
                    }
                    try {
                        this.f27248b.a(zVar);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.f27256j = null;
                    z<b0> zVar2 = this.k;
                    if (zVar2 != null && this.l != zVar2) {
                        try {
                            this.f27248b.a(zVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.f27256j.release();
                    this.f27256j = null;
                    z<b0> zVar3 = this.k;
                    if (zVar3 != null && this.l != zVar3) {
                        try {
                            this.f27248b.a(zVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.f27256j = null;
                    z<b0> zVar4 = this.k;
                    if (zVar4 != null && this.l != zVar4) {
                        try {
                            this.f27248b.a(zVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    public void e() {
    }

    public boolean f() {
        return this.f27256j == null && this.f27255i != null;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public boolean isEnded() {
        return this.I;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public boolean isReady() {
        return (this.f27255i == null || this.J || (!isSourceReady() && this.A < 0 && (this.y == C.TIME_UNSET || SystemClock.elapsedRealtime() >= this.y))) ? false : true;
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onDisabled() {
        this.f27255i = null;
        try {
            d();
            try {
                z<b0> zVar = this.k;
                if (zVar != null) {
                    this.f27248b.a(zVar);
                }
                try {
                    z<b0> zVar2 = this.l;
                    if (zVar2 != null && zVar2 != this.k) {
                        this.f27248b.a(zVar2);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    z<b0> zVar3 = this.l;
                    if (zVar3 != null && zVar3 != this.k) {
                        this.f27248b.a(zVar3);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.k != null) {
                    this.f27248b.a(this.k);
                }
                try {
                    z<b0> zVar4 = this.l;
                    if (zVar4 != null && zVar4 != this.k) {
                        this.f27248b.a(zVar4);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    z<b0> zVar5 = this.l;
                    if (zVar5 != null && zVar5 != this.k) {
                        this.f27248b.a(zVar5);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onEnabled(boolean z) {
        this.L = new DecoderCounters();
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onPositionReset(long j2, boolean z) {
        this.H = false;
        this.I = false;
        if (this.f27256j != null) {
            this.y = C.TIME_UNSET;
            this.z = -1;
            this.A = -1;
            this.K = true;
            this.J = false;
            this.B = false;
            this.f27253g.clear();
            this.u = false;
            this.v = false;
            if (this.o || ((this.r && this.G) || this.E != 0)) {
                d();
                b();
            } else {
                this.f27256j.flush();
                this.F = false;
            }
            if (!this.C || this.f27255i == null) {
                return;
            }
            this.D = 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:216:0x0173, code lost:
    
        if (r28.I == false) goto L326;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01a3 A[LOOP:0: B:18:0x0047->B:34:0x01a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01aa A[EDGE_INSN: B:35:0x01aa->B:36:0x01aa BREAK  A[LOOP:0: B:18:0x0047->B:34:0x01a3], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v65 */
    @Override // com.vivo.google.android.exoplayer3.Renderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void render(long r29, long r31) {
        /*
            Method dump skipped, instructions count: 1002
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.c3.render(long, long):void");
    }

    @Override // com.vivo.google.android.exoplayer3.g
    public final int supportsFormat(Format format) {
        try {
            return a(this.f27247a, format);
        } catch (e3.b e2) {
            throw ExoPlaybackException.createForRenderer(e2, getIndex());
        }
    }

    @Override // com.vivo.google.android.exoplayer3.a, com.vivo.google.android.exoplayer3.g
    public final int supportsMixedMimeTypeAdaptation() {
        return 4;
    }
}
