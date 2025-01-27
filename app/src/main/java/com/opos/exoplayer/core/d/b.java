package com.opos.exoplayer.core.d;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.b.e;
import com.opos.exoplayer.core.d.d;
import com.opos.exoplayer.core.h;
import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.t;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.l;
import com.vivo.google.android.exoplayer3.C;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* loaded from: classes4.dex */
public abstract class b extends com.opos.exoplayer.core.a {

    /* renamed from: b */
    private static final byte[] f18341b = u.g("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private long A;
    private int B;
    private int C;
    private ByteBuffer D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;

    /* renamed from: a */
    protected com.opos.exoplayer.core.b.d f18342a;

    /* renamed from: c */
    private final c f18343c;

    /* renamed from: d */
    @Nullable
    private final com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> f18344d;

    /* renamed from: e */
    private final boolean f18345e;

    /* renamed from: f */
    private final e f18346f;

    /* renamed from: g */
    private final e f18347g;

    /* renamed from: h */
    private final l f18348h;

    /* renamed from: i */
    private final List<Long> f18349i;

    /* renamed from: j */
    private final MediaCodec.BufferInfo f18350j;
    private Format k;
    private com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> l;
    private com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> m;
    private MediaCodec n;
    private com.opos.exoplayer.core.d.a o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private ByteBuffer[] y;
    private ByteBuffer[] z;

    public static class a extends Exception {

        /* renamed from: a */
        public final String f18351a;

        /* renamed from: b */
        public final boolean f18352b;

        /* renamed from: c */
        public final String f18353c;

        /* renamed from: d */
        public final String f18354d;

        public a(Format format, Throwable th, boolean z, int i2) {
            super("Decoder init failed: [" + i2 + "], " + format, th);
            this.f18351a = format.f17496f;
            this.f18352b = z;
            this.f18353c = null;
            this.f18354d = a(i2);
        }

        public a(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            this.f18351a = format.f17496f;
            this.f18352b = z;
            this.f18353c = str;
            this.f18354d = u.f19078a >= 21 ? a(th) : null;
        }

        private static String a(int i2) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i2 < 0 ? "neg_" : "") + Math.abs(i2);
        }

        @TargetApi(21)
        private static String a(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }
    }

    public b(int i2, c cVar, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, boolean z) {
        super(i2);
        com.opos.exoplayer.core.i.a.b(u.f19078a >= 16);
        this.f18343c = (c) com.opos.exoplayer.core.i.a.a(cVar);
        this.f18344d = bVar;
        this.f18345e = z;
        this.f18346f = new e(0);
        this.f18347g = e.e();
        this.f18348h = new l();
        this.f18349i = new ArrayList();
        this.f18350j = new MediaCodec.BufferInfo();
        this.G = 0;
        this.H = 0;
    }

    private void D() {
        if (u.f19078a < 21) {
            this.y = this.n.getInputBuffers();
            this.z = this.n.getOutputBuffers();
        }
    }

    private void E() {
        if (u.f19078a < 21) {
            this.y = null;
            this.z = null;
        }
    }

    private boolean F() {
        return this.C >= 0;
    }

    private void G() {
        this.B = -1;
        this.f18346f.f17739b = null;
    }

    private void H() {
        this.C = -1;
        this.D = null;
    }

    private void I() {
        MediaFormat outputFormat = this.n.getOutputFormat();
        if (this.p != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.x = true;
            return;
        }
        if (this.v) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.n, outputFormat);
    }

    private void J() {
        if (u.f19078a < 21) {
            this.z = this.n.getOutputBuffers();
        }
    }

    private void K() {
        if (this.H == 2) {
            A();
            x();
        } else {
            this.L = true;
            w();
        }
    }

    private static MediaCodec.CryptoInfo a(e eVar, int i2) {
        MediaCodec.CryptoInfo a2 = eVar.f17738a.a();
        if (i2 != 0) {
            if (a2.numBytesOfClearData == null) {
                a2.numBytesOfClearData = new int[1];
            }
            int[] iArr = a2.numBytesOfClearData;
            iArr[0] = iArr[0] + i2;
        }
        return a2;
    }

    @TargetApi(23)
    private static void a(MediaFormat mediaFormat) {
        mediaFormat.setInteger(com.heytap.mcssdk.n.d.A, 0);
    }

    private void a(a aVar) {
        throw h.a(aVar, r());
    }

    private static boolean a(String str) {
        int i2 = u.f19078a;
        return i2 < 18 || (i2 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i2 == 19 && u.f19081d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean a(String str, Format format) {
        return u.f19078a < 21 && format.f17498h.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private int b(String str) {
        int i2 = u.f19078a;
        if (i2 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = u.f19081d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i2 < 24 && ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str))) {
            String str3 = u.f19079b;
            if ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) {
                return 1;
            }
        }
        return 0;
    }

    private ByteBuffer b(int i2) {
        return u.f19078a >= 21 ? this.n.getInputBuffer(i2) : this.y[i2];
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
    
        if (r15.H == 2) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0024, code lost:
    
        if (r15.L == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0026, code lost:
    
        A();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00be, code lost:
    
        if (r15.L == false) goto L110;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(long r16, long r18) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.d.b.b(long, long):boolean");
    }

    private static boolean b(String str, Format format) {
        return u.f19078a <= 18 && format.r == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private boolean b(boolean z) {
        com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar = this.l;
        if (aVar == null) {
            return false;
        }
        if (!z && this.f18345e) {
            return false;
        }
        int a2 = aVar.a();
        if (a2 != 1) {
            return a2 != 4;
        }
        throw h.a(this.l.b(), r());
    }

    private ByteBuffer c(int i2) {
        return u.f19078a >= 21 ? this.n.getOutputBuffer(i2) : this.z[i2];
    }

    private static boolean c(String str) {
        return u.f19078a <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private boolean d(long j2) {
        int size = this.f18349i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f18349i.get(i2).longValue() == j2) {
                this.f18349i.remove(i2);
                return true;
            }
        }
        return false;
    }

    private static boolean d(String str) {
        int i2 = u.f19078a;
        return (i2 <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (i2 <= 19 && "hb2000".equals(u.f19079b) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean e(String str) {
        return u.f19078a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private boolean v() {
        int position;
        int a2;
        MediaCodec mediaCodec = this.n;
        if (mediaCodec == null || this.H == 2 || this.K) {
            return false;
        }
        if (this.B < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.B = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            this.f18346f.f17739b = b(dequeueInputBuffer);
            this.f18346f.a();
        }
        if (this.H == 1) {
            if (!this.s) {
                this.J = true;
                this.n.queueInputBuffer(this.B, 0, 0, 0L, 4);
                G();
            }
            this.H = 2;
            return false;
        }
        if (this.w) {
            this.w = false;
            ByteBuffer byteBuffer = this.f18346f.f17739b;
            byte[] bArr = f18341b;
            byteBuffer.put(bArr);
            this.n.queueInputBuffer(this.B, 0, bArr.length, 0L, 0);
            G();
            this.I = true;
        } else {
            if (this.M) {
                a2 = -4;
                position = 0;
            } else {
                if (this.G == 1) {
                    for (int i2 = 0; i2 < this.k.f17498h.size(); i2++) {
                        this.f18346f.f17739b.put(this.k.f17498h.get(i2));
                    }
                    this.G = 2;
                }
                position = this.f18346f.f17739b.position();
                a2 = a(this.f18348h, this.f18346f, false);
            }
            if (a2 == -3) {
                return false;
            }
            if (a2 == -5) {
                if (this.G == 2) {
                    this.f18346f.a();
                    this.G = 1;
                }
                b(this.f18348h.f19091a);
            } else {
                if (this.f18346f.c()) {
                    if (this.G == 2) {
                        this.f18346f.a();
                        this.G = 1;
                    }
                    this.K = true;
                    if (!this.I) {
                        K();
                        return false;
                    }
                    try {
                        if (this.s) {
                            return false;
                        }
                        this.J = true;
                        this.n.queueInputBuffer(this.B, 0, 0, 0L, 4);
                        G();
                        return false;
                    } catch (MediaCodec.CryptoException e2) {
                        throw h.a(e2, r());
                    }
                }
                if (!this.N || this.f18346f.d()) {
                    this.N = false;
                    boolean g2 = this.f18346f.g();
                    boolean b2 = b(g2);
                    this.M = b2;
                    if (b2) {
                        return false;
                    }
                    if (this.q && !g2) {
                        k.a(this.f18346f.f17739b);
                        if (this.f18346f.f17739b.position() != 0) {
                            this.q = false;
                        }
                    }
                    try {
                        e eVar = this.f18346f;
                        long j2 = eVar.f17740c;
                        if (eVar.d_()) {
                            this.f18349i.add(Long.valueOf(j2));
                        }
                        this.f18346f.h();
                        a(this.f18346f);
                        if (g2) {
                            this.n.queueSecureInputBuffer(this.B, 0, a(this.f18346f, position), j2, 0);
                        } else {
                            this.n.queueInputBuffer(this.B, 0, this.f18346f.f17739b.limit(), j2, 0);
                        }
                        G();
                        this.I = true;
                        this.G = 0;
                        this.f18342a.f17731c++;
                    } catch (MediaCodec.CryptoException e3) {
                        throw h.a(e3, r());
                    }
                } else {
                    this.f18346f.a();
                    if (this.G == 2) {
                        this.G = 1;
                    }
                }
            }
        }
        return true;
    }

    protected void A() {
        this.A = C.TIME_UNSET;
        G();
        H();
        this.M = false;
        this.E = false;
        this.f18349i.clear();
        E();
        this.o = null;
        this.F = false;
        this.I = false;
        this.q = false;
        this.r = false;
        this.p = 0;
        this.s = false;
        this.t = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.J = false;
        this.G = 0;
        this.H = 0;
        MediaCodec mediaCodec = this.n;
        if (mediaCodec != null) {
            this.f18342a.f17730b++;
            try {
                mediaCodec.stop();
                try {
                    this.n.release();
                    this.n = null;
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar = this.l;
                    if (aVar == null || this.m == aVar) {
                        return;
                    }
                    try {
                        this.f18344d.a(aVar);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.n = null;
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar2 = this.l;
                    if (aVar2 != null && this.m != aVar2) {
                        try {
                            this.f18344d.a(aVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.n.release();
                    this.n = null;
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar3 = this.l;
                    if (aVar3 != null && this.m != aVar3) {
                        try {
                            this.f18344d.a(aVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.n = null;
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar4 = this.l;
                    if (aVar4 != null && this.m != aVar4) {
                        try {
                            this.f18344d.a(aVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    protected void B() {
        this.A = C.TIME_UNSET;
        G();
        H();
        this.N = true;
        this.M = false;
        this.E = false;
        this.f18349i.clear();
        this.w = false;
        this.x = false;
        if (this.r || ((this.t && this.J) || this.H != 0)) {
            A();
            x();
        } else {
            this.n.flush();
            this.I = false;
        }
        if (!this.F || this.k == null) {
            return;
        }
        this.G = 1;
    }

    protected long C() {
        return 0L;
    }

    @Override // com.opos.exoplayer.core.t
    public final int a(Format format) {
        try {
            return a(this.f18343c, this.f18344d, format);
        } catch (d.a e2) {
            throw h.a(e2, r());
        }
    }

    protected abstract int a(c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, Format format);

    protected com.opos.exoplayer.core.d.a a(c cVar, Format format, boolean z) {
        return cVar.a(format.f17496f, z);
    }

    @Override // com.opos.exoplayer.core.s
    public void a(long j2, long j3) {
        if (this.L) {
            w();
            return;
        }
        if (this.k == null) {
            this.f18347g.a();
            int a2 = a(this.f18348h, this.f18347g, true);
            if (a2 != -5) {
                if (a2 == -4) {
                    com.opos.exoplayer.core.i.a.b(this.f18347g.c());
                    this.K = true;
                    K();
                    return;
                }
                return;
            }
            b(this.f18348h.f19091a);
        }
        x();
        if (this.n != null) {
            t.a("drainAndFeed");
            while (b(j2, j3)) {
            }
            while (v()) {
            }
            t.a();
        } else {
            this.f18342a.f17732d += b(j2);
            this.f18347g.a();
            int a3 = a(this.f18348h, this.f18347g, false);
            if (a3 == -5) {
                b(this.f18348h.f19091a);
            } else if (a3 == -4) {
                com.opos.exoplayer.core.i.a.b(this.f18347g.c());
                this.K = true;
                K();
            }
        }
        this.f18342a.a();
    }

    @Override // com.opos.exoplayer.core.a
    protected void a(long j2, boolean z) {
        this.K = false;
        this.L = false;
        if (this.n != null) {
            B();
        }
    }

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    protected void a(e eVar) {
    }

    protected abstract void a(com.opos.exoplayer.core.d.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    protected void a(String str, long j2, long j3) {
    }

    @Override // com.opos.exoplayer.core.a
    protected void a(boolean z) {
        this.f18342a = new com.opos.exoplayer.core.b.d();
    }

    protected abstract boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z);

    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    protected boolean a(com.opos.exoplayer.core.d.a aVar) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        if (r5.k == r0.k) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void b(com.opos.exoplayer.core.Format r5) {
        /*
            r4 = this;
            com.opos.exoplayer.core.Format r0 = r4.k
            r4.k = r5
            com.opos.exoplayer.core.drm.DrmInitData r5 = r5.f17499i
            r1 = 0
            if (r0 != 0) goto Lb
            r2 = r1
            goto Ld
        Lb:
            com.opos.exoplayer.core.drm.DrmInitData r2 = r0.f17499i
        Ld:
            boolean r5 = com.opos.exoplayer.core.i.u.a(r5, r2)
            r2 = 1
            r5 = r5 ^ r2
            if (r5 == 0) goto L49
            com.opos.exoplayer.core.Format r5 = r4.k
            com.opos.exoplayer.core.drm.DrmInitData r5 = r5.f17499i
            if (r5 == 0) goto L47
            com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> r5 = r4.f18344d
            if (r5 == 0) goto L37
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.opos.exoplayer.core.Format r3 = r4.k
            com.opos.exoplayer.core.drm.DrmInitData r3 = r3.f17499i
            com.opos.exoplayer.core.drm.a r5 = r5.a(r1, r3)
            r4.m = r5
            com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> r1 = r4.l
            if (r5 != r1) goto L49
            com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> r1 = r4.f18344d
            r1.a(r5)
            goto L49
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            int r0 = r4.r()
            com.opos.exoplayer.core.h r5 = com.opos.exoplayer.core.h.a(r5, r0)
            throw r5
        L47:
            r4.m = r1
        L49:
            com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> r5 = r4.m
            com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> r1 = r4.l
            if (r5 != r1) goto L7d
            android.media.MediaCodec r5 = r4.n
            if (r5 == 0) goto L7d
            com.opos.exoplayer.core.d.a r1 = r4.o
            boolean r1 = r1.f18336b
            com.opos.exoplayer.core.Format r3 = r4.k
            boolean r5 = r4.a(r5, r1, r0, r3)
            if (r5 == 0) goto L7d
            r4.F = r2
            r4.G = r2
            int r5 = r4.p
            r1 = 2
            if (r5 == r1) goto L7a
            if (r5 != r2) goto L79
            com.opos.exoplayer.core.Format r5 = r4.k
            int r1 = r5.f17500j
            int r3 = r0.f17500j
            if (r1 != r3) goto L79
            int r5 = r5.k
            int r0 = r0.k
            if (r5 != r0) goto L79
            goto L7a
        L79:
            r2 = 0
        L7a:
            r4.w = r2
            goto L8a
        L7d:
            boolean r5 = r4.I
            if (r5 == 0) goto L84
            r4.H = r2
            goto L8a
        L84:
            r4.A()
            r4.x()
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.d.b.b(com.opos.exoplayer.core.Format):void");
    }

    protected final MediaFormat c(Format format) {
        MediaFormat b2 = format.b();
        if (u.f19078a >= 23) {
            a(b2);
        }
        return b2;
    }

    protected void c(long j2) {
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.t
    public final int m() {
        return 8;
    }

    @Override // com.opos.exoplayer.core.a
    protected void n() {
    }

    @Override // com.opos.exoplayer.core.a
    protected void o() {
    }

    @Override // com.opos.exoplayer.core.a
    protected void p() {
        this.k = null;
        try {
            A();
            try {
                com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar = this.l;
                if (aVar != null) {
                    this.f18344d.a(aVar);
                }
                try {
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar2 = this.m;
                    if (aVar2 != null && aVar2 != this.l) {
                        this.f18344d.a(aVar2);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar3 = this.m;
                    if (aVar3 != null && aVar3 != this.l) {
                        this.f18344d.a(aVar3);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.l != null) {
                    this.f18344d.a(this.l);
                }
                try {
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar4 = this.m;
                    if (aVar4 != null && aVar4 != this.l) {
                        this.f18344d.a(aVar4);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar5 = this.m;
                    if (aVar5 != null && aVar5 != this.l) {
                        this.f18344d.a(aVar5);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.s
    public boolean t() {
        return (this.k == null || this.M || (!s() && !F() && (this.A == C.TIME_UNSET || SystemClock.elapsedRealtime() >= this.A))) ? false : true;
    }

    @Override // com.opos.exoplayer.core.s
    public boolean u() {
        return this.L;
    }

    protected void w() {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void x() {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.d.b.x():void");
    }

    protected final MediaCodec y() {
        return this.n;
    }

    protected final com.opos.exoplayer.core.d.a z() {
        return this.o;
    }
}
