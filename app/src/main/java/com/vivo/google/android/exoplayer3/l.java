package com.vivo.google.android.exoplayer3;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.vivo.google.android.exoplayer3.p;
import com.vivo.google.android.exoplayer3.util.Util;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public final class l {
    public int A;
    public long B;
    public long C;
    public boolean D;
    public long E;
    public Method F;
    public int G;
    public long H;
    public long I;
    public int J;
    public long K;
    public long L;
    public int M;
    public int N;
    public long O;
    public long P;
    public long Q;
    public float R;
    public k[] S;
    public ByteBuffer[] T;
    public ByteBuffer U;
    public ByteBuffer V;
    public byte[] W;
    public int X;
    public int Y;
    public boolean Z;

    /* renamed from: a */
    public final j f27577a;
    public boolean a0;

    /* renamed from: b */
    public final n f27578b;
    public int b0;

    /* renamed from: c */
    public final s f27579c;
    public boolean c0;

    /* renamed from: d */
    public final k[] f27580d;
    public boolean d0;

    /* renamed from: e */
    public final f f27581e;
    public long e0;

    /* renamed from: f */
    public final ConditionVariable f27582f = new ConditionVariable(true);

    /* renamed from: g */
    public final long[] f27583g;

    /* renamed from: h */
    public final b f27584h;

    /* renamed from: i */
    public final LinkedList<g> f27585i;

    /* renamed from: j */
    public AudioTrack f27586j;
    public AudioTrack k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public int r;
    public long s;
    public PlaybackParameters t;
    public PlaybackParameters u;
    public long v;
    public long w;
    public ByteBuffer x;
    public int y;
    public int z;

    public class a extends Thread {

        /* renamed from: a */
        public final /* synthetic */ AudioTrack f27587a;

        public a(AudioTrack audioTrack) {
            this.f27587a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f27587a.flush();
                this.f27587a.release();
            } finally {
                l.this.f27582f.open();
            }
        }
    }

    public static class b {

        /* renamed from: a */
        public AudioTrack f27589a;

        /* renamed from: b */
        public boolean f27590b;

        /* renamed from: c */
        public int f27591c;

        /* renamed from: d */
        public long f27592d;

        /* renamed from: e */
        public long f27593e;

        /* renamed from: f */
        public long f27594f;

        /* renamed from: g */
        public long f27595g;

        /* renamed from: h */
        public long f27596h;

        /* renamed from: i */
        public long f27597i;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public long a() {
            if (this.f27595g != C.TIME_UNSET) {
                return Math.min(this.f27597i, this.f27596h + ((((SystemClock.elapsedRealtime() * 1000) - this.f27595g) * this.f27591c) / C.MICROS_PER_SECOND));
            }
            int playState = this.f27589a.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = this.f27589a.getPlaybackHeadPosition() & 4294967295L;
            if (this.f27590b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f27594f = this.f27592d;
                }
                playbackHeadPosition += this.f27594f;
            }
            if (this.f27592d > playbackHeadPosition) {
                this.f27593e++;
            }
            this.f27592d = playbackHeadPosition;
            return playbackHeadPosition + (this.f27593e << 32);
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.f27589a = audioTrack;
            this.f27590b = z;
            this.f27595g = C.TIME_UNSET;
            this.f27592d = 0L;
            this.f27593e = 0L;
            this.f27594f = 0L;
            if (audioTrack != null) {
                this.f27591c = audioTrack.getSampleRate();
            }
        }

        public long b() {
            throw new UnsupportedOperationException();
        }

        public long c() {
            throw new UnsupportedOperationException();
        }

        public boolean d() {
            return false;
        }
    }

    @TargetApi(19)
    public static class c extends b {

        /* renamed from: j */
        public final AudioTimestamp f27598j;
        public long k;
        public long l;
        public long m;

        public c() {
            super(null);
            this.f27598j = new AudioTimestamp();
        }

        @Override // com.vivo.google.android.exoplayer3.l.b
        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.k = 0L;
            this.l = 0L;
            this.m = 0L;
        }

        @Override // com.vivo.google.android.exoplayer3.l.b
        public long b() {
            return this.m;
        }

        @Override // com.vivo.google.android.exoplayer3.l.b
        public long c() {
            return this.f27598j.nanoTime;
        }

        @Override // com.vivo.google.android.exoplayer3.l.b
        public boolean d() {
            boolean timestamp = this.f27589a.getTimestamp(this.f27598j);
            if (timestamp) {
                long j2 = this.f27598j.framePosition;
                if (this.l > j2) {
                    this.k++;
                }
                this.l = j2;
                this.m = j2 + (this.k << 32);
            }
            return timestamp;
        }
    }

    public static final class d extends Exception {
        public d(String str) {
            super(str);
        }

        public d(Throwable th) {
            super(th);
        }
    }

    public static final class e extends Exception {
        public e(int i2, int i3, int i4, int i5) {
            super("AudioTrack init failed: " + i2 + ", Config(" + i3 + ", " + i4 + ", " + i5 + ")");
        }
    }

    public interface f {
    }

    public static final class g {

        /* renamed from: a */
        public final PlaybackParameters f27599a;

        /* renamed from: b */
        public final long f27600b;

        /* renamed from: c */
        public final long f27601c;

        public g(PlaybackParameters playbackParameters, long j2, long j3) {
            this.f27599a = playbackParameters;
            this.f27600b = j2;
            this.f27601c = j3;
        }
    }

    public static final class h extends Exception {
        public h(int i2) {
            super("AudioTrack write failed: " + i2);
        }
    }

    public l(j jVar, k[] kVarArr, f fVar) {
        this.f27577a = jVar;
        this.f27581e = fVar;
        if (Util.SDK_INT >= 18) {
            try {
                this.F = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f27584h = Util.SDK_INT >= 19 ? new c() : new b(null);
        n nVar = new n();
        this.f27578b = nVar;
        s sVar = new s();
        this.f27579c = sVar;
        k[] kVarArr2 = new k[kVarArr.length + 3];
        this.f27580d = kVarArr2;
        kVarArr2[0] = new q();
        kVarArr2[1] = nVar;
        System.arraycopy(kVarArr, 0, kVarArr2, 2, kVarArr.length);
        kVarArr2[kVarArr.length + 2] = sVar;
        this.f27583g = new long[10];
        this.R = 1.0f;
        this.N = 0;
        this.p = 3;
        this.b0 = 0;
        this.u = PlaybackParameters.DEFAULT;
        this.Y = -1;
        this.S = new k[0];
        this.T = new ByteBuffer[0];
        this.f27585i = new LinkedList<>();
    }

    public static int a(String str) {
        str.hashCode();
        switch (str) {
            case "audio/vnd.dts":
                return 7;
            case "audio/ac3":
                return 5;
            case "audio/eac3":
                return 6;
            case "audio/vnd.dts.hd":
                return 8;
            default:
                return 0;
        }
    }

    public final long a(long j2) {
        return (j2 * this.l) / C.MICROS_PER_SECOND;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r10, int r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.l.a(java.lang.String, int, int, int, int, int[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0032 -> B:6:0x0010). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a() {
        /*
            r9 = this;
            int r0 = r9.Y
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L14
            boolean r0 = r9.q
            if (r0 == 0) goto Lf
            com.vivo.google.android.exoplayer3.k[] r0 = r9.S
            int r0 = r0.length
            goto L10
        Lf:
            r0 = 0
        L10:
            r9.Y = r0
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            int r4 = r9.Y
            com.vivo.google.android.exoplayer3.k[] r5 = r9.S
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L36
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.d()
        L28:
            r9.c(r7)
            boolean r0 = r4.isEnded()
            if (r0 != 0) goto L32
            return r3
        L32:
            int r0 = r9.Y
            int r0 = r0 + r2
            goto L10
        L36:
            java.nio.ByteBuffer r0 = r9.V
            if (r0 == 0) goto L42
            r9.b(r0, r7)
            java.nio.ByteBuffer r0 = r9.V
            if (r0 == 0) goto L42
            return r3
        L42:
            r9.Y = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.l.a():boolean");
    }

    public final long b() {
        return this.q ? this.I : this.H / this.G;
    }

    public final long b(long j2) {
        return (j2 * C.MICROS_PER_SECOND) / this.l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d5, code lost:
    
        if (r11 < r10) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(java.nio.ByteBuffer r9, long r10) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.l.b(java.nio.ByteBuffer, long):boolean");
    }

    public final long c() {
        return this.q ? this.L : this.K / this.J;
    }

    public final void c(long j2) {
        ByteBuffer byteBuffer;
        int length = this.S.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.T[i2 - 1];
            } else {
                byteBuffer = this.U;
                if (byteBuffer == null) {
                    byteBuffer = k.f27548a;
                }
            }
            if (i2 == length) {
                b(byteBuffer, j2);
            } else {
                k kVar = this.S[i2];
                kVar.a(byteBuffer);
                ByteBuffer a2 = kVar.a();
                this.T[i2] = a2;
                if (a2.hasRemaining()) {
                    i2++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i2--;
            }
        }
    }

    public boolean d() {
        if (e()) {
            if (c() > this.f27584h.a()) {
                return true;
            }
            if (f() && this.k.getPlayState() == 2 && this.k.getPlaybackHeadPosition() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        return this.k != null;
    }

    public final boolean f() {
        int i2;
        return Util.SDK_INT < 23 && ((i2 = this.o) == 5 || i2 == 6);
    }

    public void g() {
        this.a0 = true;
        if (e()) {
            this.P = System.nanoTime() / 1000;
            this.k.play();
        }
    }

    public void h() {
        if (e()) {
            this.H = 0L;
            this.I = 0L;
            this.K = 0L;
            this.L = 0L;
            this.M = 0;
            PlaybackParameters playbackParameters = this.t;
            if (playbackParameters != null) {
                this.u = playbackParameters;
                this.t = null;
            } else if (!this.f27585i.isEmpty()) {
                this.u = this.f27585i.getLast().f27599a;
            }
            this.f27585i.clear();
            this.v = 0L;
            this.w = 0L;
            this.U = null;
            this.V = null;
            int i2 = 0;
            while (true) {
                k[] kVarArr = this.S;
                if (i2 >= kVarArr.length) {
                    break;
                }
                k kVar = kVarArr[i2];
                kVar.flush();
                this.T[i2] = kVar.a();
                i2++;
            }
            this.Z = false;
            this.Y = -1;
            this.x = null;
            this.y = 0;
            this.N = 0;
            this.Q = 0L;
            j();
            if (this.k.getPlayState() == 3) {
                this.k.pause();
            }
            AudioTrack audioTrack = this.k;
            this.k = null;
            this.f27584h.a(null, false);
            this.f27582f.close();
            new a(audioTrack).start();
        }
    }

    public final void i() {
        ArrayList arrayList = new ArrayList();
        for (k kVar : this.f27580d) {
            if (kVar.b()) {
                arrayList.add(kVar);
            } else {
                kVar.flush();
            }
        }
        int size = arrayList.size();
        this.S = (k[]) arrayList.toArray(new k[size]);
        this.T = new ByteBuffer[size];
        for (int i2 = 0; i2 < size; i2++) {
            k kVar2 = this.S[i2];
            kVar2.flush();
            this.T[i2] = kVar2.a();
        }
    }

    public final void j() {
        this.B = 0L;
        this.A = 0;
        this.z = 0;
        this.C = 0L;
        this.D = false;
        this.E = 0L;
    }

    public final void k() {
        if (e()) {
            if (Util.SDK_INT >= 21) {
                this.k.setVolume(this.R);
                return;
            }
            AudioTrack audioTrack = this.k;
            float f2 = this.R;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    public boolean a(ByteBuffer byteBuffer, long j2) {
        int i2;
        int i3;
        AudioTrack audioTrack;
        ByteBuffer byteBuffer2 = this.U;
        g1.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!e()) {
            this.f27582f.block();
            if (this.c0) {
                audioTrack = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.m).setEncoding(this.o).setSampleRate(this.l).build(), this.r, 1, this.b0);
            } else {
                audioTrack = this.b0 == 0 ? new AudioTrack(this.p, this.l, this.m, this.o, this.r, 1) : new AudioTrack(this.p, this.l, this.m, this.o, this.r, 1, this.b0);
            }
            this.k = audioTrack;
            int state = this.k.getState();
            if (state == 1) {
                int audioSessionId = this.k.getAudioSessionId();
                if (this.b0 != audioSessionId) {
                    this.b0 = audioSessionId;
                    p.b bVar = (p.b) this.f27581e;
                    p.this.N.audioSessionId(audioSessionId);
                    p.this.getClass();
                }
                this.f27584h.a(this.k, f());
                k();
                this.d0 = false;
                if (this.a0) {
                    g();
                }
            } else {
                try {
                    this.k.release();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.k = null;
                    throw th;
                }
                this.k = null;
                throw new e(state, this.l, this.m, this.r);
            }
        }
        if (f()) {
            if (this.k.getPlayState() == 2) {
                this.d0 = false;
                return false;
            }
            if (this.k.getPlayState() == 1 && this.f27584h.a() != 0) {
                return false;
            }
        }
        boolean z = this.d0;
        boolean d2 = d();
        this.d0 = d2;
        if (z && !d2 && this.k.getPlayState() != 1) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.e0;
            p.b bVar2 = (p.b) this.f27581e;
            p.this.N.audioTrackUnderrun(this.r, C.usToMs(this.s), elapsedRealtime);
            p.this.getClass();
        }
        if (this.U == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.q && this.M == 0) {
                int i4 = this.o;
                if (i4 == 7 || i4 == 8) {
                    int position = byteBuffer.position();
                    i3 = ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
                } else if (i4 == 5) {
                    i3 = 1536;
                } else if (i4 == 6) {
                    i3 = (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? i.f27486a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
                } else {
                    throw new IllegalStateException("Unexpected audio encoding: " + i4);
                }
                this.M = i3;
            }
            if (this.t != null) {
                if (!a()) {
                    return false;
                }
                this.f27585i.add(new g(this.t, Math.max(0L, j2), b(c())));
                this.t = null;
                i();
            }
            if (this.N == 0) {
                this.O = Math.max(0L, j2);
                this.N = 1;
            } else {
                long b2 = this.O + b(b());
                if (this.N != 1 || Math.abs(b2 - j2) <= 200000) {
                    i2 = 2;
                } else {
                    String str = "Discontinuity detected [expected " + b2 + ", got " + j2 + "]";
                    i2 = 2;
                    this.N = 2;
                }
                if (this.N == i2) {
                    this.O += j2 - b2;
                    this.N = 1;
                    p pVar = p.this;
                    pVar.getClass();
                    pVar.V = true;
                }
            }
            if (this.q) {
                this.I += this.M;
            } else {
                this.H += byteBuffer.remaining();
            }
            this.U = byteBuffer;
        }
        if (this.q) {
            b(this.U, j2);
        } else {
            c(j2);
        }
        if (this.U.hasRemaining()) {
            return false;
        }
        this.U = null;
        return true;
    }

    public PlaybackParameters a(PlaybackParameters playbackParameters) {
        if (this.q) {
            PlaybackParameters playbackParameters2 = PlaybackParameters.DEFAULT;
            this.u = playbackParameters2;
            return playbackParameters2;
        }
        s sVar = this.f27579c;
        float f2 = playbackParameters.speed;
        sVar.getClass();
        float constrainValue = Util.constrainValue(f2, 0.1f, 8.0f);
        sVar.f28028e = constrainValue;
        s sVar2 = this.f27579c;
        float f3 = playbackParameters.pitch;
        sVar2.getClass();
        sVar2.f28029f = Util.constrainValue(f3, 0.1f, 8.0f);
        PlaybackParameters playbackParameters3 = new PlaybackParameters(constrainValue, f3);
        PlaybackParameters playbackParameters4 = this.t;
        if (playbackParameters4 == null) {
            if (!this.f27585i.isEmpty()) {
                playbackParameters4 = this.f27585i.getLast().f27599a;
            } else {
                playbackParameters4 = this.u;
            }
        }
        if (!playbackParameters3.equals(playbackParameters4)) {
            if (e()) {
                this.t = playbackParameters3;
            } else {
                this.u = playbackParameters3;
            }
        }
        return this.u;
    }
}
