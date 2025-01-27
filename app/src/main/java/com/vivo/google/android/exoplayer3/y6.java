package com.vivo.google.android.exoplayer3;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.vivo.google.android.exoplayer3.util.Util;
import com.vivo.google.android.exoplayer3.video.VideoRendererEventListener;

@TargetApi(16)
/* loaded from: classes4.dex */
public class y6 extends c3 {
    public static final int[] o0 = {1920, 1600, 1440, TTAdConstant.EXT_PLUGIN_UNINSTALL, 960, 854, 640, 540, 480};
    public final z6 N;
    public final VideoRendererEventListener.EventDispatcher O;
    public final long P;
    public final int Q;
    public final boolean R;
    public Format[] S;
    public a T;
    public Surface U;
    public int V;
    public boolean W;
    public long X;
    public long Y;
    public int Z;
    public int a0;
    public int b0;
    public float c0;
    public int d0;
    public int e0;
    public int f0;
    public float g0;
    public int h0;
    public int i0;
    public int j0;
    public float k0;
    public boolean l0;
    public int m0;
    public b n0;

    public static final class a {

        /* renamed from: a */
        public final int f28301a;

        /* renamed from: b */
        public final int f28302b;

        /* renamed from: c */
        public final int f28303c;

        public a(int i2, int i3, int i4) {
            this.f28301a = i2;
            this.f28302b = i3;
            this.f28303c = i4;
        }
    }

    @TargetApi(23)
    public final class b implements MediaCodec.OnFrameRenderedListener {
        public b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(@NonNull MediaCodec mediaCodec, long j2, long j3) {
            y6 y6Var = y6.this;
            if (this != y6Var.n0) {
                return;
            }
            y6Var.j();
        }
    }

    public y6(Context context, d3 d3Var, long j2, a0<b0> a0Var, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i2) {
        super(2, d3Var, a0Var, z);
        this.P = j2;
        this.Q = i2;
        this.N = new z6(context);
        this.O = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.R = n();
        this.X = C.TIME_UNSET;
        this.d0 = -1;
        this.e0 = -1;
        this.g0 = -1.0f;
        this.c0 = -1.0f;
        this.V = 1;
        h();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str, int i2, int i3) {
        char c2;
        int i4;
        if (i2 == -1 || i3 == -1) {
            return -1;
        }
        str.hashCode();
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
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c2 = 4;
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
        switch (c2) {
            case 0:
            case 2:
            case 4:
                i4 = i2 * i3;
                i5 = 2;
                break;
            case 1:
            case 5:
                i4 = i2 * i3;
                break;
            case 3:
                if (!"BRAVIA 4K 2015".equals(Util.MODEL)) {
                    i4 = Util.ceilDivide(i2, 16) * Util.ceilDivide(i3, 16) * 16 * 16;
                    i5 = 2;
                    break;
                }
                break;
        }
        return -1;
    }

    public static boolean a(boolean z, Format format, Format format2) {
        if (!format.sampleMimeType.equals(format2.sampleMimeType)) {
            return false;
        }
        int i2 = format.rotationDegrees;
        if (i2 == -1) {
            i2 = 0;
        }
        int i3 = format2.rotationDegrees;
        if (i3 == -1) {
            i3 = 0;
        }
        if (i2 == i3) {
            return z || (format.width == format2.width && format.height == format2.height);
        }
        return false;
    }

    public static boolean n() {
        return Util.SDK_INT <= 22 && "foster".equals(Util.DEVICE) && "NVIDIA".equals(Util.MANUFACTURER);
    }

    public final void a(MediaCodec mediaCodec, int i2) {
        k();
        g1.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, true);
        g1.a();
        this.L.renderedOutputBufferCount++;
        this.a0 = 0;
        j();
    }

    @TargetApi(21)
    public final void a(MediaCodec mediaCodec, int i2, long j2) {
        k();
        g1.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, j2);
        g1.a();
        this.L.renderedOutputBufferCount++;
        this.a0 = 0;
        j();
    }

    @Override // com.vivo.google.android.exoplayer3.c3
    public void a(w wVar) {
        if (Util.SDK_INT >= 23 || !this.l0) {
            return;
        }
        j();
    }

    @Override // com.vivo.google.android.exoplayer3.c3
    public void a(String str, long j2, long j3) {
        this.O.decoderInitialized(str, j2, j3);
    }

    @Override // com.vivo.google.android.exoplayer3.c3
    public boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        if (a(z, format, format2)) {
            int i2 = format2.width;
            a aVar = this.T;
            if (i2 <= aVar.f28301a && format2.height <= aVar.f28302b && format2.maxInputSize <= aVar.f28303c) {
                return true;
            }
        }
        return false;
    }

    @Override // com.vivo.google.android.exoplayer3.c3
    public boolean f() {
        Surface surface;
        return super.f() && (surface = this.U) != null && surface.isValid();
    }

    public final void g() {
        MediaCodec mediaCodec;
        this.W = false;
        if (Util.SDK_INT < 23 || !this.l0 || (mediaCodec = this.f27256j) == null) {
            return;
        }
        this.n0 = new b(mediaCodec);
    }

    public final void h() {
        this.h0 = -1;
        this.i0 = -1;
        this.k0 = -1.0f;
        this.j0 = -1;
    }

    @Override // com.vivo.google.android.exoplayer3.a, com.vivo.google.android.exoplayer3.ExoPlayer.ExoPlayerComponent
    public void handleMessage(int i2, Object obj) {
        if (i2 != 1) {
            if (i2 != 4) {
                super.handleMessage(i2, obj);
                return;
            }
            int intValue = ((Integer) obj).intValue();
            this.V = intValue;
            MediaCodec mediaCodec = this.f27256j;
            if (mediaCodec != null) {
                mediaCodec.setVideoScalingMode(intValue);
                return;
            }
            return;
        }
        Surface surface = (Surface) obj;
        if (this.U == surface) {
            if (surface != null) {
                l();
                if (this.W) {
                    this.O.renderedFirstFrame(this.U);
                    return;
                }
                return;
            }
            return;
        }
        this.U = surface;
        int state = getState();
        if (state == 1 || state == 2) {
            MediaCodec mediaCodec2 = this.f27256j;
            if (Util.SDK_INT < 23 || mediaCodec2 == null || surface == null) {
                d();
                b();
            } else {
                mediaCodec2.setOutputSurface(surface);
            }
        }
        if (surface == null) {
            h();
            g();
            return;
        }
        l();
        g();
        if (state == 2) {
            m();
        }
    }

    public final void i() {
        if (this.Z > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.O.droppedFrames(this.Z, elapsedRealtime - this.Y);
            this.Z = 0;
            this.Y = elapsedRealtime;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.c3, com.vivo.google.android.exoplayer3.Renderer
    public boolean isReady() {
        if ((this.W || super.f()) && super.isReady()) {
            this.X = C.TIME_UNSET;
            return true;
        }
        if (this.X == C.TIME_UNSET) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.X) {
            return true;
        }
        this.X = C.TIME_UNSET;
        return false;
    }

    public void j() {
        if (this.W) {
            return;
        }
        this.W = true;
        this.O.renderedFirstFrame(this.U);
    }

    public final void k() {
        int i2 = this.d0;
        if (i2 == -1 && this.e0 == -1) {
            return;
        }
        if (this.h0 == i2 && this.i0 == this.e0 && this.j0 == this.f0 && this.k0 == this.g0) {
            return;
        }
        this.O.videoSizeChanged(i2, this.e0, this.f0, this.g0);
        this.h0 = this.d0;
        this.i0 = this.e0;
        this.j0 = this.f0;
        this.k0 = this.g0;
    }

    public final void l() {
        int i2 = this.h0;
        if (i2 == -1 && this.i0 == -1) {
            return;
        }
        this.O.videoSizeChanged(i2, this.i0, this.j0, this.k0);
    }

    public final void m() {
        this.X = this.P > 0 ? SystemClock.elapsedRealtime() + this.P : C.TIME_UNSET;
    }

    @Override // com.vivo.google.android.exoplayer3.c3, com.vivo.google.android.exoplayer3.a
    public void onDisabled() {
        this.d0 = -1;
        this.e0 = -1;
        this.g0 = -1.0f;
        this.c0 = -1.0f;
        h();
        g();
        z6 z6Var = this.N;
        if (z6Var.f28327b) {
            z6Var.f28326a.f28338b.sendEmptyMessage(2);
        }
        this.n0 = null;
        try {
            super.onDisabled();
        } finally {
            this.L.ensureUpdated();
            this.O.disabled(this.L);
        }
    }

    @Override // com.vivo.google.android.exoplayer3.c3, com.vivo.google.android.exoplayer3.a
    public void onEnabled(boolean z) {
        super.onEnabled(z);
        int i2 = getConfiguration().f27449a;
        this.m0 = i2;
        this.l0 = i2 != 0;
        this.O.enabled(this.L);
        z6 z6Var = this.N;
        z6Var.f28333h = false;
        if (z6Var.f28327b) {
            z6Var.f28326a.f28338b.sendEmptyMessage(1);
        }
    }

    @Override // com.vivo.google.android.exoplayer3.c3, com.vivo.google.android.exoplayer3.a
    public void onPositionReset(long j2, boolean z) {
        super.onPositionReset(j2, z);
        g();
        this.a0 = 0;
        if (z) {
            m();
        } else {
            this.X = C.TIME_UNSET;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onStarted() {
        this.Z = 0;
        this.Y = SystemClock.elapsedRealtime();
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onStopped() {
        this.X = C.TIME_UNSET;
        i();
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onStreamChanged(Format[] formatArr) {
        this.S = formatArr;
        super.onStreamChanged(formatArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x012f A[EDGE_INSN: B:68:0x012f->B:69:0x012f BREAK  A[LOOP:1: B:51:0x0094->B:73:0x0122], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0122 A[SYNTHETIC] */
    @Override // com.vivo.google.android.exoplayer3.c3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.vivo.google.android.exoplayer3.b3 r22, android.media.MediaCodec r23, com.vivo.google.android.exoplayer3.Format r24, android.media.MediaCrypto r25) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.y6.a(com.vivo.google.android.exoplayer3.b3, android.media.MediaCodec, com.vivo.google.android.exoplayer3.Format, android.media.MediaCrypto):void");
    }

    @Override // com.vivo.google.android.exoplayer3.c3
    public void a(Format format) {
        super.a(format);
        this.O.inputFormatChanged(format);
        float f2 = format.pixelWidthHeightRatio;
        if (f2 == -1.0f) {
            f2 = 1.0f;
        }
        this.c0 = f2;
        int i2 = format.rotationDegrees;
        if (i2 == -1) {
            i2 = 0;
        }
        this.b0 = i2;
    }

    @Override // com.vivo.google.android.exoplayer3.c3
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        this.d0 = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        this.e0 = integer;
        float f2 = this.c0;
        this.g0 = f2;
        if (Util.SDK_INT >= 21) {
            int i2 = this.b0;
            if (i2 == 90 || i2 == 270) {
                int i3 = this.d0;
                this.d0 = integer;
                this.e0 = i3;
                this.g0 = 1.0f / f2;
            }
        } else {
            this.f0 = this.b0;
        }
        mediaCodec.setVideoScalingMode(this.V);
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0096, code lost:
    
        if (r7.a(r8, r5) != false) goto L108;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f2  */
    @Override // com.vivo.google.android.exoplayer3.c3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(long r20, long r22, android.media.MediaCodec r24, java.nio.ByteBuffer r25, int r26, int r27, long r28, boolean r30) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.y6.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ba  */
    @Override // com.vivo.google.android.exoplayer3.c3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.vivo.google.android.exoplayer3.d3 r13, com.vivo.google.android.exoplayer3.Format r14) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.y6.a(com.vivo.google.android.exoplayer3.d3, com.vivo.google.android.exoplayer3.Format):int");
    }
}
