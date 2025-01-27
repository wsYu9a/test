package com.vivo.google.android.exoplayer3;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import com.vivo.google.android.exoplayer3.audio.AudioRendererEventListener;
import com.vivo.google.android.exoplayer3.l;
import com.vivo.google.android.exoplayer3.util.Util;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
/* loaded from: classes4.dex */
public class p extends c3 implements k6 {
    public final AudioRendererEventListener.EventDispatcher N;
    public final l O;
    public boolean P;
    public boolean Q;
    public MediaFormat R;
    public int S;
    public int T;
    public long U;
    public boolean V;

    public final class b implements l.f {
        public b() {
        }

        public /* synthetic */ b(p pVar, a aVar) {
            this();
        }
    }

    public p(d3 d3Var, a0<b0> a0Var, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener, j jVar, k... kVarArr) {
        super(1, d3Var, a0Var, z);
        this.O = new l(jVar, kVarArr, new b());
        this.N = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
    }

    @Override // com.vivo.google.android.exoplayer3.c3
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int[] iArr;
        int i2;
        MediaFormat mediaFormat2 = this.R;
        boolean z = mediaFormat2 != null;
        String string = z ? mediaFormat2.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.R;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.Q && integer == 6 && (i2 = this.T) < 6) {
            iArr = new int[i2];
            for (int i3 = 0; i3 < this.T; i3++) {
                iArr[i3] = i3;
            }
        } else {
            iArr = null;
        }
        try {
            this.O.a(string, integer, integer2, this.S, 0, iArr);
        } catch (l.d e2) {
            throw ExoPlaybackException.createForRenderer(e2, getIndex());
        }
    }

    @Override // com.vivo.google.android.exoplayer3.c3
    public void a(Format format) {
        super.a(format);
        this.N.inputFormatChanged(format);
        this.S = "audio/raw".equals(format.sampleMimeType) ? format.pcmEncoding : 2;
        this.T = format.channelCount;
    }

    @Override // com.vivo.google.android.exoplayer3.c3
    public void a(String str, long j2, long j3) {
        this.N.decoderInitialized(str, j2, j3);
    }

    public boolean a(String str) {
        j jVar = this.O.f27577a;
        if (jVar != null) {
            if (Arrays.binarySearch(jVar.f27518a, l.a(str)) >= 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.vivo.google.android.exoplayer3.c3
    public void e() {
        try {
            l lVar = this.O;
            if (!lVar.Z && lVar.e() && lVar.a()) {
                l.b bVar = lVar.f27584h;
                long c2 = lVar.c();
                bVar.f27596h = bVar.a();
                bVar.f27595g = SystemClock.elapsedRealtime() * 1000;
                bVar.f27597i = c2;
                bVar.f27589a.stop();
                lVar.y = 0;
                lVar.Z = true;
            }
        } catch (l.h e2) {
            throw ExoPlaybackException.createForRenderer(e2, getIndex());
        }
    }

    @Override // com.vivo.google.android.exoplayer3.a, com.vivo.google.android.exoplayer3.Renderer
    public k6 getMediaClock() {
        return this;
    }

    @Override // com.vivo.google.android.exoplayer3.k6
    public PlaybackParameters getPlaybackParameters() {
        return this.O.u;
    }

    @Override // com.vivo.google.android.exoplayer3.a, com.vivo.google.android.exoplayer3.ExoPlayer.ExoPlayerComponent
    public void handleMessage(int i2, Object obj) {
        if (i2 == 2) {
            l lVar = this.O;
            float floatValue = ((Float) obj).floatValue();
            if (lVar.R != floatValue) {
                lVar.R = floatValue;
                lVar.k();
                return;
            }
            return;
        }
        if (i2 != 3) {
            super.handleMessage(i2, obj);
            return;
        }
        int intValue = ((Integer) obj).intValue();
        l lVar2 = this.O;
        if (lVar2.p == intValue) {
            return;
        }
        lVar2.p = intValue;
        if (lVar2.c0) {
            return;
        }
        lVar2.h();
        lVar2.b0 = 0;
    }

    @Override // com.vivo.google.android.exoplayer3.c3, com.vivo.google.android.exoplayer3.Renderer
    public boolean isEnded() {
        if (this.I) {
            l lVar = this.O;
            if (!lVar.e() || (lVar.Z && !lVar.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.vivo.google.android.exoplayer3.c3, com.vivo.google.android.exoplayer3.Renderer
    public boolean isReady() {
        return this.O.d() || super.isReady();
    }

    @Override // com.vivo.google.android.exoplayer3.c3, com.vivo.google.android.exoplayer3.a
    public void onDisabled() {
        try {
            l lVar = this.O;
            lVar.h();
            AudioTrack audioTrack = lVar.f27586j;
            if (audioTrack != null) {
                lVar.f27586j = null;
                new m(lVar, audioTrack).start();
            }
            for (k kVar : lVar.f27580d) {
                kVar.f();
            }
            lVar.b0 = 0;
            lVar.a0 = false;
            try {
                super.onDisabled();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.onDisabled();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.c3, com.vivo.google.android.exoplayer3.a
    public void onEnabled(boolean z) {
        super.onEnabled(z);
        this.N.enabled(this.L);
        int i2 = getConfiguration().f27449a;
        if (i2 == 0) {
            l lVar = this.O;
            if (lVar.c0) {
                lVar.c0 = false;
                lVar.b0 = 0;
                lVar.h();
                return;
            }
            return;
        }
        l lVar2 = this.O;
        lVar2.getClass();
        g1.b(Util.SDK_INT >= 21);
        if (lVar2.c0 && lVar2.b0 == i2) {
            return;
        }
        lVar2.c0 = true;
        lVar2.b0 = i2;
        lVar2.h();
    }

    @Override // com.vivo.google.android.exoplayer3.c3, com.vivo.google.android.exoplayer3.a
    public void onPositionReset(long j2, boolean z) {
        super.onPositionReset(j2, z);
        this.O.h();
        this.U = j2;
        this.V = true;
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onStarted() {
        this.O.g();
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onStopped() {
        l lVar = this.O;
        lVar.a0 = false;
        if (lVar.e()) {
            lVar.j();
            l.b bVar = lVar.f27584h;
            if (bVar.f27595g != C.TIME_UNSET) {
                return;
            }
            bVar.f27589a.pause();
        }
    }

    @Override // com.vivo.google.android.exoplayer3.k6
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        return this.O.a(playbackParameters);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    @Override // com.vivo.google.android.exoplayer3.c3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.vivo.google.android.exoplayer3.b3 r5, android.media.MediaCodec r6, com.vivo.google.android.exoplayer3.Format r7, android.media.MediaCrypto r8) {
        /*
            r4 = this;
            java.lang.String r5 = r5.f27211a
            int r0 = com.vivo.google.android.exoplayer3.util.Util.SDK_INT
            r1 = 0
            r2 = 24
            if (r0 >= r2) goto L37
            java.lang.String r0 = "OMX.SEC.aac.dec"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L37
            java.lang.String r5 = com.vivo.google.android.exoplayer3.util.Util.MANUFACTURER
            java.lang.String r0 = "samsung"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L37
            java.lang.String r5 = com.vivo.google.android.exoplayer3.util.Util.DEVICE
            java.lang.String r0 = "zeroflte"
            boolean r0 = r5.startsWith(r0)
            if (r0 != 0) goto L35
            java.lang.String r0 = "herolte"
            boolean r0 = r5.startsWith(r0)
            if (r0 != 0) goto L35
            java.lang.String r0 = "heroqlte"
            boolean r5 = r5.startsWith(r0)
            if (r5 == 0) goto L37
        L35:
            r5 = 1
            goto L38
        L37:
            r5 = 0
        L38:
            r4.Q = r5
            boolean r5 = r4.P
            r0 = 0
            if (r5 == 0) goto L59
            android.media.MediaFormat r5 = r7.getFrameworkMediaFormatV16()
            r4.R = r5
            java.lang.String r2 = "mime"
            java.lang.String r3 = "audio/raw"
            r5.setString(r2, r3)
            android.media.MediaFormat r5 = r4.R
            r6.configure(r5, r0, r8, r1)
            android.media.MediaFormat r5 = r4.R
            java.lang.String r6 = r7.sampleMimeType
            r5.setString(r2, r6)
            goto L62
        L59:
            android.media.MediaFormat r5 = r7.getFrameworkMediaFormatV16()
            r6.configure(r5, r0, r8, r1)
            r4.R = r0
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.p.a(com.vivo.google.android.exoplayer3.b3, android.media.MediaCodec, com.vivo.google.android.exoplayer3.Format, android.media.MediaCrypto):void");
    }

    @Override // com.vivo.google.android.exoplayer3.c3
    public b3 a(d3 d3Var, Format format, boolean z) {
        b3 a2;
        if (!a(format.sampleMimeType) || (a2 = d3Var.a()) == null) {
            this.P = false;
            return d3Var.a(format.sampleMimeType, z);
        }
        this.P = true;
        return a2;
    }

    @Override // com.vivo.google.android.exoplayer3.k6
    public long a() {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        StringBuilder sb;
        String str;
        l lVar = this.O;
        boolean isEnded = isEnded();
        if (lVar.e() && lVar.N != 0) {
            if (lVar.k.getPlayState() == 3) {
                long a2 = (lVar.f27584h.a() * C.MICROS_PER_SECOND) / r3.f27591c;
                if (a2 != 0) {
                    long nanoTime = System.nanoTime() / 1000;
                    if (nanoTime - lVar.C >= 30000) {
                        long[] jArr = lVar.f27583g;
                        int i2 = lVar.z;
                        jArr[i2] = a2 - nanoTime;
                        lVar.z = (i2 + 1) % 10;
                        int i3 = lVar.A;
                        if (i3 < 10) {
                            lVar.A = i3 + 1;
                        }
                        lVar.C = nanoTime;
                        lVar.B = 0L;
                        int i4 = 0;
                        while (true) {
                            int i5 = lVar.A;
                            if (i4 >= i5) {
                                break;
                            }
                            lVar.B += lVar.f27583g[i4] / i5;
                            i4++;
                        }
                    }
                    if (!lVar.f() && nanoTime - lVar.E >= 500000) {
                        boolean d2 = lVar.f27584h.d();
                        lVar.D = d2;
                        if (d2) {
                            long c2 = lVar.f27584h.c() / 1000;
                            long b2 = lVar.f27584h.b();
                            if (c2 >= lVar.P) {
                                if (Math.abs(c2 - nanoTime) > 5000000) {
                                    sb = new StringBuilder();
                                    str = "Spurious audio timestamp (system clock mismatch): ";
                                } else if (Math.abs(lVar.b(b2) - a2) > 5000000) {
                                    sb = new StringBuilder();
                                    str = "Spurious audio timestamp (frame position mismatch): ";
                                }
                                sb.append(str);
                                sb.append(b2);
                                sb.append(", ");
                                sb.append(c2);
                                sb.append(", ");
                                sb.append(nanoTime);
                                sb.append(", ");
                                sb.append(a2);
                                sb.append(", ");
                                sb.append(lVar.b());
                                sb.append(", ");
                                sb.append(lVar.c());
                                sb.toString();
                            }
                            lVar.D = false;
                        }
                        if (lVar.F != null && !lVar.q) {
                            try {
                                long intValue = (((Integer) r3.invoke(lVar.k, null)).intValue() * 1000) - lVar.s;
                                lVar.Q = intValue;
                                long max = Math.max(intValue, 0L);
                                lVar.Q = max;
                                if (max > 5000000) {
                                    String str2 = "Ignoring impossibly large audio latency: " + lVar.Q;
                                    lVar.Q = 0L;
                                }
                            } catch (Exception unused) {
                                lVar.F = null;
                            }
                        }
                        lVar.E = nanoTime;
                    }
                }
            }
            long nanoTime2 = System.nanoTime() / 1000;
            if (lVar.D) {
                j3 = lVar.b(lVar.f27584h.b() + lVar.a(nanoTime2 - (lVar.f27584h.c() / 1000)));
            } else {
                if (lVar.A == 0) {
                    j2 = (lVar.f27584h.a() * C.MICROS_PER_SECOND) / r3.f27591c;
                } else {
                    j2 = nanoTime2 + lVar.B;
                }
                if (!isEnded) {
                    j2 -= lVar.Q;
                }
                j3 = j2;
            }
            long j9 = lVar.O;
            while (!lVar.f27585i.isEmpty() && j3 >= lVar.f27585i.getFirst().f27601c) {
                l.g remove = lVar.f27585i.remove();
                lVar.u = remove.f27599a;
                lVar.w = remove.f27601c;
                lVar.v = remove.f27600b - lVar.O;
            }
            if (lVar.u.speed == 1.0f) {
                j6 = (j3 + lVar.v) - lVar.w;
            } else {
                if (lVar.f27585i.isEmpty()) {
                    s sVar = lVar.f27579c;
                    long j10 = sVar.k;
                    if (j10 >= 1024) {
                        long j11 = lVar.v;
                        long j12 = j3 - lVar.w;
                        long j13 = sVar.f28033j;
                        j4 = j11;
                        j5 = Util.scaleLargeTimestamp(j12, j13, j10);
                        j6 = j5 + j4;
                    }
                }
                j4 = lVar.v;
                double d3 = lVar.u.speed;
                double d4 = j3 - lVar.w;
                Double.isNaN(d3);
                Double.isNaN(d4);
                j5 = (long) (d3 * d4);
                j6 = j5 + j4;
            }
            j7 = j9 + j6;
            j8 = Long.MIN_VALUE;
        } else {
            j8 = Long.MIN_VALUE;
            j7 = Long.MIN_VALUE;
        }
        if (j7 != j8) {
            if (!this.V) {
                j7 = Math.max(this.U, j7);
            }
            this.U = j7;
            this.V = false;
        }
        return this.U;
    }

    @Override // com.vivo.google.android.exoplayer3.c3
    public boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) {
        if (this.P && (i3 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i2, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i2, false);
            this.L.skippedOutputBufferCount++;
            l lVar = this.O;
            if (lVar.N == 1) {
                lVar.N = 2;
            }
            return true;
        }
        try {
            if (!this.O.a(byteBuffer, j4)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i2, false);
            this.L.renderedOutputBufferCount++;
            return true;
        } catch (l.e | l.h e2) {
            throw ExoPlaybackException.createForRenderer(e2, getIndex());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        if (r4 == false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x013d, code lost:
    
        if (r11 != false) goto L174;
     */
    @Override // com.vivo.google.android.exoplayer3.c3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.vivo.google.android.exoplayer3.d3 r11, com.vivo.google.android.exoplayer3.Format r12) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.p.a(com.vivo.google.android.exoplayer3.d3, com.vivo.google.android.exoplayer3.Format):int");
    }
}
