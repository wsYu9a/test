package com.opos.exoplayer.core.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.j;
import com.opos.exoplayer.core.i.t;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.video.f;
import com.vivo.google.android.exoplayer3.C;

@TargetApi(16)
/* loaded from: classes4.dex */
public class c extends com.opos.exoplayer.core.d.b {

    /* renamed from: c */
    private static final int[] f19226c = {1920, 1600, 1440, TTAdConstant.EXT_PLUGIN_UNINSTALL, 960, 854, 640, 540, 480};
    private int A;
    private int B;
    private float C;
    private int D;
    private int E;
    private int F;
    private float G;
    private boolean H;
    private int I;
    private long J;
    private int K;

    /* renamed from: b */
    b f19227b;

    /* renamed from: d */
    private final Context f19228d;

    /* renamed from: e */
    private final d f19229e;

    /* renamed from: f */
    private final f.a f19230f;

    /* renamed from: g */
    private final long f19231g;

    /* renamed from: h */
    private final int f19232h;

    /* renamed from: i */
    private final boolean f19233i;

    /* renamed from: j */
    private final long[] f19234j;
    private Format[] k;
    private a l;
    private boolean m;
    private Surface n;
    private Surface o;
    private int p;
    private boolean q;
    private long r;
    private long s;
    private int t;
    private int u;
    private int v;
    private long w;
    private int x;
    private float y;
    private int z;

    protected static final class a {

        /* renamed from: a */
        public final int f19235a;

        /* renamed from: b */
        public final int f19236b;

        /* renamed from: c */
        public final int f19237c;

        public a(int i2, int i3, int i4) {
            this.f19235a = i2;
            this.f19236b = i3;
            this.f19237c = i4;
        }
    }

    @TargetApi(23)
    private final class b implements MediaCodec.OnFrameRenderedListener {
        private b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        /* synthetic */ b(c cVar, MediaCodec mediaCodec, AnonymousClass1 anonymousClass1) {
            this(mediaCodec);
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(@NonNull MediaCodec mediaCodec, long j2, long j3) {
            c cVar = c.this;
            if (this != cVar.f19227b) {
                return;
            }
            cVar.v();
        }
    }

    public c(Context context, com.opos.exoplayer.core.d.c cVar, long j2, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, boolean z, @Nullable Handler handler, @Nullable f fVar, int i2) {
        super(2, cVar, bVar, z);
        this.f19231g = j2;
        this.f19232h = i2;
        this.f19228d = context.getApplicationContext();
        this.f19229e = new d(context);
        this.f19230f = new f.a(handler, fVar);
        this.f19233i = K();
        this.f19234j = new long[10];
        this.J = C.TIME_UNSET;
        this.r = C.TIME_UNSET;
        this.z = -1;
        this.A = -1;
        this.C = -1.0f;
        this.y = -1.0f;
        this.p = 1;
        G();
    }

    private void D() {
        this.r = this.f19231g > 0 ? SystemClock.elapsedRealtime() + this.f19231g : C.TIME_UNSET;
    }

    private void E() {
        MediaCodec y;
        this.q = false;
        if (u.f19078a < 23 || !this.H || (y = y()) == null) {
            return;
        }
        this.f19227b = new b(y);
    }

    private void F() {
        if (this.q) {
            this.f19230f.a(this.n);
        }
    }

    private void G() {
        this.D = -1;
        this.E = -1;
        this.G = -1.0f;
        this.F = -1;
    }

    private void H() {
        int i2 = this.z;
        if (i2 == -1 && this.A == -1) {
            return;
        }
        if (this.D == i2 && this.E == this.A && this.F == this.B && this.G == this.C) {
            return;
        }
        this.f19230f.a(i2, this.A, this.B, this.C);
        this.D = this.z;
        this.E = this.A;
        this.F = this.B;
        this.G = this.C;
    }

    private void I() {
        int i2 = this.D;
        if (i2 == -1 && this.E == -1) {
            return;
        }
        this.f19230f.a(i2, this.E, this.F, this.G);
    }

    private void J() {
        if (this.t > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f19230f.a(this.t, elapsedRealtime - this.s);
            this.t = 0;
            this.s = elapsedRealtime;
        }
    }

    private static boolean K() {
        return u.f19078a <= 22 && "foster".equals(u.f19079b) && "NVIDIA".equals(u.f19080c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int a(String str, int i2, int i3) {
        char c2;
        int i4;
        if (i2 == -1 || i3 == -1) {
            return -1;
        }
        int i5 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0 && c2 != 1) {
            if (c2 == 2) {
                if ("BRAVIA 4K 2015".equals(u.f19081d)) {
                    return -1;
                }
                i4 = u.a(i2, 16) * u.a(i3, 16) * 16 * 16;
                i5 = 2;
                return (i4 * 3) / (i5 * 2);
            }
            if (c2 != 3) {
                if (c2 != 4 && c2 != 5) {
                    return -1;
                }
                i4 = i2 * i3;
                return (i4 * 3) / (i5 * 2);
            }
        }
        i4 = i2 * i3;
        i5 = 2;
        return (i4 * 3) / (i5 * 2);
    }

    private static Point a(com.opos.exoplayer.core.d.a aVar, Format format) {
        int i2 = format.k;
        int i3 = format.f17500j;
        boolean z = i2 > i3;
        int i4 = z ? i2 : i3;
        if (z) {
            i2 = i3;
        }
        float f2 = i2 / i4;
        for (int i5 : f19226c) {
            int i6 = (int) (i5 * f2);
            if (i5 <= i4 || i6 <= i2) {
                return null;
            }
            if (u.f19078a >= 21) {
                int i7 = z ? i6 : i5;
                if (!z) {
                    i5 = i6;
                }
                Point a2 = aVar.a(i7, i5);
                if (aVar.a(a2.x, a2.y, format.l)) {
                    return a2;
                }
            } else {
                int a3 = u.a(i5, 16) * 16;
                int a4 = u.a(i6, 16) * 16;
                if (a3 * a4 <= com.opos.exoplayer.core.d.d.b()) {
                    int i8 = z ? a4 : a3;
                    if (!z) {
                        a3 = a4;
                    }
                    return new Point(i8, a3);
                }
            }
        }
        return null;
    }

    private static void a(MediaCodec mediaCodec, int i2) {
        mediaCodec.setVideoScalingMode(i2);
    }

    @TargetApi(23)
    private static void a(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    @TargetApi(21)
    private static void a(MediaFormat mediaFormat, int i2) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i2);
    }

    private void a(Surface surface) {
        if (surface == null) {
            Surface surface2 = this.o;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.opos.exoplayer.core.d.a z = z();
                if (z != null && b(z)) {
                    surface = DummySurface.a(this.f19228d, z.f18338d);
                    this.o = surface;
                }
            }
        }
        if (this.n == surface) {
            if (surface == null || surface == this.o) {
                return;
            }
            I();
            F();
            return;
        }
        this.n = surface;
        int a_ = a_();
        if (a_ == 1 || a_ == 2) {
            MediaCodec y = y();
            if (u.f19078a < 23 || y == null || surface == null || this.m) {
                A();
                x();
            } else {
                a(y, surface);
            }
        }
        if (surface == null || surface == this.o) {
            G();
            E();
            return;
        }
        I();
        E();
        if (a_ == 2) {
            D();
        }
    }

    private static boolean a(String str) {
        String str2 = u.f19079b;
        if (((!"deb".equals(str2) && !"flo".equals(str2) && !"mido".equals(str2) && !"santoni".equals(str2)) || !"OMX.qcom.video.decoder.avc".equals(str)) && ((!"tcl_eu".equals(str2) && !"SVP-DTV15".equals(str2) && !"BRAVIA_ATV2".equals(str2) && !str2.startsWith("panell_") && !"F3311".equals(str2) && !"M5c".equals(str2) && !"A7010a48".equals(str2)) || !"OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
            String str3 = u.f19081d;
            if ((!"ALE-L21".equals(str3) && !"CAM-L21".equals(str3)) || !"OMX.k3.video.decoder.avc".equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(boolean z, Format format, Format format2) {
        return format.f17496f.equals(format2.f17496f) && f(format) == f(format2) && (z || (format.f17500j == format2.f17500j && format.k == format2.k));
    }

    private boolean b(com.opos.exoplayer.core.d.a aVar) {
        return u.f19078a >= 23 && !this.H && !a(aVar.f18335a) && (!aVar.f18338d || DummySurface.a(this.f19228d));
    }

    private static int d(Format format) {
        if (format.f17497g == -1) {
            return a(format.f17496f, format.f17500j, format.k);
        }
        int size = format.f17498h.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += format.f17498h.get(i3).length;
        }
        return format.f17497g + i2;
    }

    private static boolean d(long j2) {
        return j2 < -30000;
    }

    private static float e(Format format) {
        float f2 = format.n;
        if (f2 == -1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private static boolean e(long j2) {
        return j2 < -500000;
    }

    private static int f(Format format) {
        int i2 = format.m;
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    @Override // com.opos.exoplayer.core.d.b
    @CallSuper
    protected void A() {
        try {
            super.A();
            this.v = 0;
            Surface surface = this.o;
            if (surface != null) {
                if (this.n == surface) {
                    this.n = null;
                }
                surface.release();
                this.o = null;
            }
        } catch (Throwable th) {
            this.v = 0;
            if (this.o != null) {
                Surface surface2 = this.n;
                Surface surface3 = this.o;
                if (surface2 == surface3) {
                    this.n = null;
                }
                surface3.release();
                this.o = null;
            }
            throw th;
        }
    }

    @Override // com.opos.exoplayer.core.d.b
    @CallSuper
    protected void B() {
        super.B();
        this.v = 0;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected int a(com.opos.exoplayer.core.d.c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, Format format) {
        int i2;
        int i3;
        String str = format.f17496f;
        if (!j.b(str)) {
            return 0;
        }
        DrmInitData drmInitData = format.f17499i;
        boolean z = false;
        if (drmInitData != null) {
            for (int i4 = 0; i4 < drmInitData.f18368b; i4++) {
                z |= drmInitData.a(i4).f18373c;
            }
        }
        com.opos.exoplayer.core.d.a a2 = cVar.a(str, z);
        if (a2 == null) {
            return (!z || cVar.a(str, false) == null) ? 1 : 2;
        }
        if (!com.opos.exoplayer.core.a.a(bVar, drmInitData)) {
            return 2;
        }
        boolean b2 = a2.b(format.f17493c);
        if (b2 && (i2 = format.f17500j) > 0 && (i3 = format.k) > 0) {
            if (u.f19078a >= 21) {
                b2 = a2.a(i2, i3, format.l);
            } else {
                boolean z2 = i2 * i3 <= com.opos.exoplayer.core.d.d.b();
                if (!z2) {
                    com.opos.cmn.an.f.a.b("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.f17500j + "x" + format.k + "] [" + u.f19082e + "]");
                }
                b2 = z2;
            }
        }
        return (a2.f18336b ? 16 : 8) | (a2.f18337c ? 32 : 0) | (b2 ? 4 : 3);
    }

    @SuppressLint({"InlinedApi"})
    protected MediaFormat a(Format format, a aVar, boolean z, int i2) {
        MediaFormat c2 = c(format);
        c2.setInteger("max-width", aVar.f19235a);
        c2.setInteger("max-height", aVar.f19236b);
        int i3 = aVar.f19237c;
        if (i3 != -1) {
            c2.setInteger("max-input-size", i3);
        }
        if (z) {
            c2.setInteger("auto-frc", 0);
        }
        if (i2 != 0) {
            a(c2, i2);
        }
        return c2;
    }

    protected a a(com.opos.exoplayer.core.d.a aVar, Format format, Format[] formatArr) {
        int i2 = format.f17500j;
        int i3 = format.k;
        int d2 = d(format);
        if (formatArr.length == 1) {
            return new a(i2, i3, d2);
        }
        boolean z = false;
        for (Format format2 : formatArr) {
            if (a(aVar.f18336b, format, format2)) {
                int i4 = format2.f17500j;
                z |= i4 == -1 || format2.k == -1;
                i2 = Math.max(i2, i4);
                i3 = Math.max(i3, format2.k);
                d2 = Math.max(d2, d(format2));
            }
        }
        if (z) {
            com.opos.cmn.an.f.a.c("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i2 + "x" + i3);
            Point a2 = a(aVar, format);
            if (a2 != null) {
                i2 = Math.max(i2, a2.x);
                i3 = Math.max(i3, a2.y);
                d2 = Math.max(d2, a(format.f17496f, i2, i3));
                com.opos.cmn.an.f.a.c("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i2 + "x" + i3);
            }
        }
        return new a(i2, i3, d2);
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.r.b
    public void a(int i2, Object obj) {
        if (i2 == 1) {
            a((Surface) obj);
            return;
        }
        if (i2 != 4) {
            super.a(i2, obj);
            return;
        }
        this.p = ((Integer) obj).intValue();
        MediaCodec y = y();
        if (y != null) {
            a(y, this.p);
        }
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void a(long j2, boolean z) {
        super.a(j2, z);
        E();
        this.u = 0;
        int i2 = this.K;
        if (i2 != 0) {
            this.J = this.f19234j[i2 - 1];
            this.K = 0;
        }
        if (z) {
            D();
        } else {
            this.r = C.TIME_UNSET;
        }
    }

    protected void a(MediaCodec mediaCodec, int i2, long j2) {
        t.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        t.a();
        ((com.opos.exoplayer.core.d.b) this).f18342a.f17734f++;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        this.z = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        this.A = integer;
        float f2 = this.y;
        this.C = f2;
        if (u.f19078a >= 21) {
            int i2 = this.x;
            if (i2 == 90 || i2 == 270) {
                int i3 = this.z;
                this.z = integer;
                this.A = i3;
                this.C = 1.0f / f2;
            }
        } else {
            this.B = this.x;
        }
        a(mediaCodec, this.p);
    }

    @Override // com.opos.exoplayer.core.d.b
    @CallSuper
    protected void a(com.opos.exoplayer.core.b.e eVar) {
        this.v++;
        if (u.f19078a >= 23 || !this.H) {
            return;
        }
        v();
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(com.opos.exoplayer.core.d.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        a a2 = a(aVar, format, this.k);
        this.l = a2;
        MediaFormat a3 = a(format, a2, this.f19233i, this.I);
        if (this.n == null) {
            com.opos.exoplayer.core.i.a.b(b(aVar));
            if (this.o == null) {
                this.o = DummySurface.a(this.f19228d, aVar.f18338d);
            }
            this.n = this.o;
        }
        mediaCodec.configure(a3, this.n, mediaCrypto, 0);
        if (u.f19078a < 23 || !this.H) {
            return;
        }
        this.f19227b = new b(mediaCodec);
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(String str, long j2, long j3) {
        this.f19230f.a(str, j2, j3);
        this.m = a(str);
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void a(boolean z) {
        super.a(z);
        int i2 = q().f19199b;
        this.I = i2;
        this.H = i2 != 0;
        this.f19230f.a(((com.opos.exoplayer.core.d.b) this).f18342a);
        this.f19229e.a();
    }

    @Override // com.opos.exoplayer.core.a
    protected void a(Format[] formatArr, long j2) {
        this.k = formatArr;
        if (this.J == C.TIME_UNSET) {
            this.J = j2;
        } else {
            int i2 = this.K;
            if (i2 == this.f19234j.length) {
                com.opos.cmn.an.f.a.c("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.f19234j[this.K - 1]);
            } else {
                this.K = i2 + 1;
            }
            this.f19234j[this.K - 1] = j2;
        }
        super.a(formatArr, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
    
        if (d(r2) != false) goto L75;
     */
    @Override // com.opos.exoplayer.core.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(long r21, long r23, android.media.MediaCodec r25, java.nio.ByteBuffer r26, int r27, int r28, long r29, boolean r31) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.video.c.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    protected boolean a(MediaCodec mediaCodec, int i2, long j2, long j3) {
        int b2 = b(j3);
        if (b2 == 0) {
            return false;
        }
        ((com.opos.exoplayer.core.d.b) this).f18342a.f17737i++;
        b(b2 + this.v);
        B();
        return true;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        if (a(z, format, format2)) {
            int i2 = format2.f17500j;
            a aVar = this.l;
            if (i2 <= aVar.f19235a && format2.k <= aVar.f19236b && d(format2) <= this.l.f19237c) {
                return true;
            }
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected boolean a(com.opos.exoplayer.core.d.a aVar) {
        return this.n != null || b(aVar);
    }

    protected void b(int i2) {
        com.opos.exoplayer.core.b.d dVar = ((com.opos.exoplayer.core.d.b) this).f18342a;
        dVar.f17735g += i2;
        this.t += i2;
        int i3 = this.u + i2;
        this.u = i3;
        dVar.f17736h = Math.max(i3, dVar.f17736h);
        if (this.t >= this.f19232h) {
            J();
        }
    }

    protected void b(MediaCodec mediaCodec, int i2, long j2) {
        t.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        t.a();
        b(1);
    }

    @TargetApi(21)
    protected void b(MediaCodec mediaCodec, int i2, long j2, long j3) {
        H();
        t.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, j3);
        t.a();
        this.w = SystemClock.elapsedRealtime() * 1000;
        ((com.opos.exoplayer.core.d.b) this).f18342a.f17733e++;
        this.u = 0;
        v();
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void b(Format format) {
        super.b(format);
        this.f19230f.a(format);
        this.y = e(format);
        this.x = f(format);
    }

    protected boolean b(long j2, long j3) {
        return d(j2);
    }

    @Override // com.opos.exoplayer.core.d.b
    @CallSuper
    protected void c(long j2) {
        this.v--;
    }

    protected void c(MediaCodec mediaCodec, int i2, long j2) {
        H();
        t.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, true);
        t.a();
        this.w = SystemClock.elapsedRealtime() * 1000;
        ((com.opos.exoplayer.core.d.b) this).f18342a.f17733e++;
        this.u = 0;
        v();
    }

    protected boolean c(long j2, long j3) {
        return e(j2);
    }

    protected boolean d(long j2, long j3) {
        return d(j2) && j3 > 100000;
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void n() {
        super.n();
        this.t = 0;
        this.s = SystemClock.elapsedRealtime();
        this.w = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void o() {
        this.r = C.TIME_UNSET;
        J();
        super.o();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void p() {
        this.z = -1;
        this.A = -1;
        this.C = -1.0f;
        this.y = -1.0f;
        this.J = C.TIME_UNSET;
        this.K = 0;
        G();
        E();
        this.f19229e.b();
        this.f19227b = null;
        this.H = false;
        try {
            super.p();
        } finally {
            ((com.opos.exoplayer.core.d.b) this).f18342a.a();
            this.f19230f.b(((com.opos.exoplayer.core.d.b) this).f18342a);
        }
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.s
    public boolean t() {
        Surface surface;
        if (super.t() && (this.q || (((surface = this.o) != null && this.n == surface) || y() == null || this.H))) {
            this.r = C.TIME_UNSET;
        } else {
            if (this.r == C.TIME_UNSET) {
                return false;
            }
            if (SystemClock.elapsedRealtime() >= this.r) {
                this.r = C.TIME_UNSET;
                return false;
            }
        }
        return true;
    }

    void v() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.f19230f.a(this.n);
    }
}
