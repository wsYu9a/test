package com.opos.exoplayer.core.a;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.a.f;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.p;
import com.vivo.google.android.exoplayer3.C;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class g implements f {

    /* renamed from: a */
    public static boolean f17553a = false;

    /* renamed from: b */
    public static boolean f17554b = false;
    private long A;
    private p B;
    private p C;
    private long D;
    private long E;
    private ByteBuffer F;
    private int G;
    private int H;
    private int I;
    private long J;
    private long K;
    private boolean L;
    private long M;
    private Method N;
    private int O;
    private long P;
    private long Q;
    private int R;
    private long S;
    private long T;
    private int U;
    private int V;
    private long W;
    private long X;
    private long Y;
    private float Z;
    private com.opos.exoplayer.core.a.d[] aa;
    private ByteBuffer[] ab;
    private ByteBuffer ac;

    /* renamed from: ad */
    private ByteBuffer f17555ad;
    private byte[] ae;
    private int af;
    private int ag;
    private boolean ah;
    private boolean ai;
    private int aj;
    private boolean ak;
    private boolean al;
    private long am;

    /* renamed from: c */
    @Nullable
    private final com.opos.exoplayer.core.a.c f17556c;

    /* renamed from: d */
    private final boolean f17557d;

    /* renamed from: e */
    private final k f17558e;

    /* renamed from: f */
    private final o f17559f;

    /* renamed from: g */
    private final j f17560g;

    /* renamed from: h */
    private final com.opos.exoplayer.core.a.d[] f17561h;

    /* renamed from: i */
    private final com.opos.exoplayer.core.a.d[] f17562i;

    /* renamed from: j */
    private final ConditionVariable f17563j;
    private final long[] k;
    private final b l;
    private final ArrayDeque<d> m;

    @Nullable
    private f.c n;
    private AudioTrack o;
    private AudioTrack p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private com.opos.exoplayer.core.a.b w;
    private boolean x;
    private boolean y;
    private int z;

    /* renamed from: com.opos.exoplayer.core.a.g$1 */
    class AnonymousClass1 extends Thread {

        /* renamed from: a */
        final /* synthetic */ AudioTrack f17564a;

        AnonymousClass1(AudioTrack audioTrack) {
            audioTrack = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                audioTrack.flush();
                audioTrack.release();
            } finally {
                g.this.f17563j.open();
            }
        }
    }

    /* renamed from: com.opos.exoplayer.core.a.g$2 */
    class AnonymousClass2 extends Thread {

        /* renamed from: a */
        final /* synthetic */ AudioTrack f17566a;

        AnonymousClass2(AudioTrack audioTrack) {
            audioTrack = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            audioTrack.release();
        }
    }

    public static final class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    private static class b {

        /* renamed from: a */
        protected AudioTrack f17568a;

        /* renamed from: b */
        private boolean f17569b;

        /* renamed from: c */
        private int f17570c;

        /* renamed from: d */
        private long f17571d;

        /* renamed from: e */
        private long f17572e;

        /* renamed from: f */
        private long f17573f;

        /* renamed from: g */
        private long f17574g;

        /* renamed from: h */
        private long f17575h;

        /* renamed from: i */
        private long f17576i;

        /* renamed from: j */
        private long f17577j;

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a() {
            if (this.f17574g != C.TIME_UNSET) {
                return;
            }
            this.f17568a.pause();
        }

        public void a(long j2) {
            this.f17576i = b();
            this.f17574g = SystemClock.elapsedRealtime() * 1000;
            this.f17577j = j2;
            this.f17568a.stop();
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.f17568a = audioTrack;
            this.f17569b = z;
            this.f17574g = C.TIME_UNSET;
            this.f17575h = C.TIME_UNSET;
            this.f17571d = 0L;
            this.f17572e = 0L;
            this.f17573f = 0L;
            if (audioTrack != null) {
                this.f17570c = audioTrack.getSampleRate();
            }
        }

        public long b() {
            if (this.f17574g != C.TIME_UNSET) {
                return Math.min(this.f17577j, ((((SystemClock.elapsedRealtime() * 1000) - this.f17574g) * this.f17570c) / C.MICROS_PER_SECOND) + this.f17576i);
            }
            int playState = this.f17568a.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = 4294967295L & this.f17568a.getPlaybackHeadPosition();
            if (this.f17569b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f17573f = this.f17571d;
                }
                playbackHeadPosition += this.f17573f;
            }
            if (u.f19078a <= 28) {
                if (playbackHeadPosition == 0 && this.f17571d > 0 && playState == 3) {
                    if (this.f17575h == C.TIME_UNSET) {
                        this.f17575h = SystemClock.elapsedRealtime();
                    }
                    return this.f17571d;
                }
                this.f17575h = C.TIME_UNSET;
            }
            if (this.f17571d > playbackHeadPosition) {
                this.f17572e++;
            }
            this.f17571d = playbackHeadPosition;
            return playbackHeadPosition + (this.f17572e << 32);
        }

        public boolean b(long j2) {
            return this.f17575h != C.TIME_UNSET && j2 > 0 && SystemClock.elapsedRealtime() - this.f17575h >= 200;
        }

        public long c() {
            return (b() * C.MICROS_PER_SECOND) / this.f17570c;
        }

        public boolean d() {
            return false;
        }

        public long e() {
            throw new UnsupportedOperationException();
        }

        public long f() {
            throw new UnsupportedOperationException();
        }
    }

    @TargetApi(19)
    private static class c extends b {

        /* renamed from: b */
        private final AudioTimestamp f17578b;

        /* renamed from: c */
        private long f17579c;

        /* renamed from: d */
        private long f17580d;

        /* renamed from: e */
        private long f17581e;

        public c() {
            super();
            this.f17578b = new AudioTimestamp();
        }

        @Override // com.opos.exoplayer.core.a.g.b
        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.f17579c = 0L;
            this.f17580d = 0L;
            this.f17581e = 0L;
        }

        @Override // com.opos.exoplayer.core.a.g.b
        public boolean d() {
            boolean timestamp = this.f17568a.getTimestamp(this.f17578b);
            if (timestamp) {
                long j2 = this.f17578b.framePosition;
                if (this.f17580d > j2) {
                    this.f17579c++;
                }
                this.f17580d = j2;
                this.f17581e = j2 + (this.f17579c << 32);
            }
            return timestamp;
        }

        @Override // com.opos.exoplayer.core.a.g.b
        public long e() {
            return this.f17578b.nanoTime;
        }

        @Override // com.opos.exoplayer.core.a.g.b
        public long f() {
            return this.f17581e;
        }
    }

    private static final class d {

        /* renamed from: a */
        private final p f17582a;

        /* renamed from: b */
        private final long f17583b;

        /* renamed from: c */
        private final long f17584c;

        private d(p pVar, long j2, long j3) {
            this.f17582a = pVar;
            this.f17583b = j2;
            this.f17584c = j3;
        }

        /* synthetic */ d(p pVar, long j2, long j3, AnonymousClass1 anonymousClass1) {
            this(pVar, j2, j3);
        }
    }

    public g(@Nullable com.opos.exoplayer.core.a.c cVar, com.opos.exoplayer.core.a.d[] dVarArr) {
        this(cVar, dVarArr, false);
    }

    public g(@Nullable com.opos.exoplayer.core.a.c cVar, com.opos.exoplayer.core.a.d[] dVarArr, boolean z) {
        this.f17556c = cVar;
        this.f17557d = z;
        this.f17563j = new ConditionVariable(true);
        if (u.f19078a >= 18) {
            try {
                this.N = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.l = u.f19078a >= 19 ? new c() : new b();
        k kVar = new k();
        this.f17558e = kVar;
        o oVar = new o();
        this.f17559f = oVar;
        j jVar = new j();
        this.f17560g = jVar;
        com.opos.exoplayer.core.a.d[] dVarArr2 = new com.opos.exoplayer.core.a.d[dVarArr.length + 4];
        this.f17561h = dVarArr2;
        dVarArr2[0] = new m();
        dVarArr2[1] = kVar;
        dVarArr2[2] = oVar;
        System.arraycopy(dVarArr, 0, dVarArr2, 3, dVarArr.length);
        dVarArr2[dVarArr.length + 3] = jVar;
        this.f17562i = new com.opos.exoplayer.core.a.d[]{new l()};
        this.k = new long[10];
        this.Z = 1.0f;
        this.V = 0;
        this.w = com.opos.exoplayer.core.a.b.f17521a;
        this.aj = 0;
        this.C = p.f19184a;
        this.ag = -1;
        this.aa = new com.opos.exoplayer.core.a.d[0];
        this.ab = new ByteBuffer[0];
        this.m = new ArrayDeque<>();
    }

    private static int a(int i2, ByteBuffer byteBuffer) {
        if (i2 == 7 || i2 == 8) {
            return h.a(byteBuffer);
        }
        if (i2 == 5) {
            return com.opos.exoplayer.core.a.a.a();
        }
        if (i2 == 6) {
            return com.opos.exoplayer.core.a.a.a(byteBuffer);
        }
        if (i2 == 14) {
            return com.opos.exoplayer.core.a.a.b(byteBuffer) * 8;
        }
        throw new IllegalStateException("Unexpected audio encoding: " + i2);
    }

    @TargetApi(21)
    private static int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    @TargetApi(21)
    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (this.F == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.F = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.F.putInt(1431633921);
        }
        if (this.G == 0) {
            this.F.putInt(4, i2);
            this.F.putLong(8, j2 * 1000);
            this.F.position(0);
            this.G = i2;
        }
        int remaining = this.F.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.F, remaining, 1);
            if (write < 0) {
                this.G = 0;
                return write;
            }
            if (write < remaining) {
                return 0;
            }
        }
        int a2 = a(audioTrack, byteBuffer, i2);
        if (a2 < 0) {
            this.G = 0;
        } else {
            this.G -= a2;
        }
        return a2;
    }

    private void a(long j2) {
        ByteBuffer byteBuffer;
        int length = this.aa.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.ab[i2 - 1];
            } else {
                byteBuffer = this.ac;
                if (byteBuffer == null) {
                    byteBuffer = com.opos.exoplayer.core.a.d.f17532a;
                }
            }
            if (i2 == length) {
                b(byteBuffer, j2);
            } else {
                com.opos.exoplayer.core.a.d dVar = this.aa[i2];
                dVar.a(byteBuffer);
                ByteBuffer f2 = dVar.f();
                this.ab[i2] = f2;
                if (f2.hasRemaining()) {
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

    @TargetApi(21)
    private static void a(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private long b(long j2) {
        long j3;
        long a2;
        while (!this.m.isEmpty() && j2 >= this.m.getFirst().f17584c) {
            d remove = this.m.remove();
            this.C = remove.f17582a;
            this.E = remove.f17584c;
            this.D = remove.f17583b - this.W;
        }
        if (this.C.f19185b == 1.0f) {
            return (this.D + j2) - this.E;
        }
        if (this.m.isEmpty()) {
            j3 = this.D;
            a2 = this.f17560g.a(j2 - this.E);
        } else {
            j3 = this.D;
            a2 = u.a(j2 - this.E, this.C.f19185b);
        }
        return j3 + a2;
    }

    private static void b(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void b(ByteBuffer byteBuffer, long j2) {
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.f17555ad;
            int i2 = 0;
            if (byteBuffer2 != null) {
                com.opos.exoplayer.core.i.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.f17555ad = byteBuffer;
                if (u.f19078a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.ae;
                    if (bArr == null || bArr.length < remaining) {
                        this.ae = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.ae, 0, remaining);
                    byteBuffer.position(position);
                    this.af = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (u.f19078a < 21) {
                int b2 = this.z - ((int) (this.S - (this.l.b() * this.R)));
                if (b2 > 0) {
                    i2 = this.p.write(this.ae, this.af, Math.min(remaining2, b2));
                    if (i2 > 0) {
                        this.af += i2;
                        byteBuffer.position(byteBuffer.position() + i2);
                    }
                }
            } else if (this.ak) {
                com.opos.exoplayer.core.i.a.b(j2 != C.TIME_UNSET);
                i2 = a(this.p, byteBuffer, remaining2, j2);
            } else {
                i2 = a(this.p, byteBuffer, remaining2);
            }
            this.am = SystemClock.elapsedRealtime();
            if (i2 < 0) {
                throw new f.d(i2);
            }
            boolean z = this.q;
            if (z) {
                this.S += i2;
            }
            if (i2 == remaining2) {
                if (!z) {
                    this.T += this.U;
                }
                this.f17555ad = null;
            }
        }
    }

    private long c(long j2) {
        return (j2 * C.MICROS_PER_SECOND) / this.s;
    }

    private AudioTrack c(int i2) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i2);
    }

    private long d(long j2) {
        return (j2 * C.MICROS_PER_SECOND) / this.t;
    }

    private static boolean d(int i2) {
        return i2 == 3 || i2 == 2 || i2 == Integer.MIN_VALUE || i2 == 1073741824 || i2 == 4;
    }

    private long e(long j2) {
        return (this.t * j2) / C.MICROS_PER_SECOND;
    }

    private void k() {
        ArrayList arrayList = new ArrayList();
        for (com.opos.exoplayer.core.a.d dVar : z()) {
            if (dVar.a()) {
                arrayList.add(dVar);
            } else {
                dVar.h();
            }
        }
        int size = arrayList.size();
        this.aa = (com.opos.exoplayer.core.a.d[]) arrayList.toArray(new com.opos.exoplayer.core.a.d[size]);
        this.ab = new ByteBuffer[size];
        for (int i2 = 0; i2 < size; i2++) {
            com.opos.exoplayer.core.a.d dVar2 = this.aa[i2];
            dVar2.h();
            this.ab[i2] = dVar2.f();
        }
    }

    private void l() {
        this.f17563j.block();
        this.p = x();
        a(this.C);
        k();
        int audioSessionId = this.p.getAudioSessionId();
        if (f17553a && u.f19078a < 21) {
            AudioTrack audioTrack = this.o;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                o();
            }
            if (this.o == null) {
                this.o = c(audioSessionId);
            }
        }
        if (this.aj != audioSessionId) {
            this.aj = audioSessionId;
            f.c cVar = this.n;
            if (cVar != null) {
                cVar.a(audioSessionId);
            }
        }
        this.l.a(this.p, v());
        n();
        this.al = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0032 -> B:6:0x0010). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m() {
        /*
            r9 = this;
            int r0 = r9.ag
            r1 = -1
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L14
            boolean r0 = r9.x
            if (r0 == 0) goto Ld
            r0 = 0
            goto L10
        Ld:
            com.opos.exoplayer.core.a.d[] r0 = r9.aa
            int r0 = r0.length
        L10:
            r9.ag = r0
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            int r4 = r9.ag
            com.opos.exoplayer.core.a.d[] r5 = r9.aa
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L36
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.e()
        L28:
            r9.a(r7)
            boolean r0 = r4.g()
            if (r0 != 0) goto L32
            goto L44
        L32:
            int r0 = r9.ag
            int r0 = r0 + r3
            goto L10
        L36:
            java.nio.ByteBuffer r0 = r9.f17555ad
            if (r0 == 0) goto L41
            r9.b(r0, r7)
            java.nio.ByteBuffer r0 = r9.f17555ad
            if (r0 != 0) goto L44
        L41:
            r9.ag = r1
            r2 = 1
        L44:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.a.g.m():boolean");
    }

    private void n() {
        if (r()) {
            if (u.f19078a >= 21) {
                a(this.p, this.Z);
            } else {
                b(this.p, this.Z);
            }
        }
    }

    private void o() {
        AudioTrack audioTrack = this.o;
        if (audioTrack == null) {
            return;
        }
        this.o = null;
        new Thread() { // from class: com.opos.exoplayer.core.a.g.2

            /* renamed from: a */
            final /* synthetic */ AudioTrack f17566a;

            AnonymousClass2(AudioTrack audioTrack2) {
                audioTrack = audioTrack2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                audioTrack.release();
            }
        }.start();
    }

    private boolean p() {
        return r() && this.V != 0;
    }

    private void q() {
        String str;
        long c2 = this.l.c();
        if (c2 == 0) {
            return;
        }
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.K >= 30000) {
            long[] jArr = this.k;
            int i2 = this.H;
            jArr[i2] = c2 - nanoTime;
            this.H = (i2 + 1) % 10;
            int i3 = this.I;
            if (i3 < 10) {
                this.I = i3 + 1;
            }
            this.K = nanoTime;
            this.J = 0L;
            int i4 = 0;
            while (true) {
                int i5 = this.I;
                if (i4 >= i5) {
                    break;
                }
                this.J += this.k[i4] / i5;
                i4++;
            }
        }
        if (v() || nanoTime - this.M < 500000) {
            return;
        }
        boolean d2 = this.l.d();
        this.L = d2;
        if (d2) {
            long e2 = this.l.e() / 1000;
            long f2 = this.l.f();
            if (e2 >= this.X) {
                if (Math.abs(e2 - nanoTime) > 5000000) {
                    str = "Spurious audio timestamp (system clock mismatch): " + f2 + ", " + e2 + ", " + nanoTime + ", " + c2 + ", " + s() + ", " + t();
                    if (f17554b) {
                        throw new a(str);
                    }
                } else if (Math.abs(d(f2) - c2) > 5000000) {
                    str = "Spurious audio timestamp (frame position mismatch): " + f2 + ", " + e2 + ", " + nanoTime + ", " + c2 + ", " + s() + ", " + t();
                    if (f17554b) {
                        throw new a(str);
                    }
                }
                com.opos.cmn.an.f.a.c("AudioTrack", str);
            }
            this.L = false;
        }
        if (this.N != null && this.q) {
            try {
                long intValue = (((Integer) r1.invoke(this.p, null)).intValue() * 1000) - this.A;
                this.Y = intValue;
                long max = Math.max(intValue, 0L);
                this.Y = max;
                if (max > 5000000) {
                    com.opos.cmn.an.f.a.c("AudioTrack", "Ignoring impossibly large audio latency: " + this.Y);
                    this.Y = 0L;
                }
            } catch (Exception unused) {
                this.N = null;
            }
        }
        this.M = nanoTime;
    }

    private boolean r() {
        return this.p != null;
    }

    private long s() {
        return this.q ? this.P / this.O : this.Q;
    }

    private long t() {
        return this.q ? this.S / this.R : this.T;
    }

    private void u() {
        this.J = 0L;
        this.I = 0;
        this.H = 0;
        this.K = 0L;
        this.L = false;
        this.M = 0L;
    }

    private boolean v() {
        int i2;
        return u.f19078a < 23 && ((i2 = this.v) == 5 || i2 == 6);
    }

    private boolean w() {
        return v() && this.p.getPlayState() == 2 && this.p.getPlaybackHeadPosition() == 0;
    }

    private AudioTrack x() {
        AudioTrack audioTrack;
        if (u.f19078a >= 21) {
            audioTrack = y();
        } else {
            int d2 = u.d(this.w.f17524d);
            audioTrack = this.aj == 0 ? new AudioTrack(d2, this.t, this.u, this.v, this.z, 1) : new AudioTrack(d2, this.t, this.u, this.v, this.z, 1, this.aj);
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception unused) {
        }
        throw new f.b(state, this.t, this.u, this.z);
    }

    @TargetApi(21)
    private AudioTrack y() {
        AudioAttributes build = this.ak ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : this.w.a();
        AudioFormat build2 = new AudioFormat.Builder().setChannelMask(this.u).setEncoding(this.v).setSampleRate(this.t).build();
        int i2 = this.aj;
        return new AudioTrack(build, build2, this.z, 1, i2 != 0 ? i2 : 0);
    }

    private com.opos.exoplayer.core.a.d[] z() {
        return this.r ? this.f17562i : this.f17561h;
    }

    @Override // com.opos.exoplayer.core.a.f
    public long a(boolean z) {
        long c2;
        if (!p()) {
            return Long.MIN_VALUE;
        }
        if (this.p.getPlayState() == 3) {
            q();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.L) {
            c2 = d(e(nanoTime - (this.l.e() / 1000)) + this.l.f());
        } else {
            c2 = this.I == 0 ? this.l.c() : nanoTime + this.J;
            if (!z) {
                c2 -= this.Y;
            }
        }
        return b(Math.min(c2, d(t()))) + this.W;
    }

    @Override // com.opos.exoplayer.core.a.f
    public p a(p pVar) {
        if (r() && !this.y) {
            p pVar2 = p.f19184a;
            this.C = pVar2;
            return pVar2;
        }
        p pVar3 = new p(this.f17560g.a(pVar.f19185b), this.f17560g.b(pVar.f19186c));
        p pVar4 = this.B;
        if (pVar4 == null) {
            pVar4 = !this.m.isEmpty() ? this.m.getLast().f17582a : this.C;
        }
        if (!pVar3.equals(pVar4)) {
            if (r()) {
                this.B = pVar3;
            } else {
                this.C = pVar3;
            }
        }
        return this.C;
    }

    @Override // com.opos.exoplayer.core.a.f
    public void a() {
        this.ai = true;
        if (r()) {
            this.X = System.nanoTime() / 1000;
            this.p.play();
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void a(float f2) {
        if (this.Z != f2) {
            this.Z = f2;
            n();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0134  */
    @Override // com.opos.exoplayer.core.a.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r18, int r19, int r20, int r21, @androidx.annotation.Nullable int[] r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.a.g.a(int, int, int, int, int[], int, int):void");
    }

    @Override // com.opos.exoplayer.core.a.f
    public void a(com.opos.exoplayer.core.a.b bVar) {
        if (this.w.equals(bVar)) {
            return;
        }
        this.w = bVar;
        if (this.ak) {
            return;
        }
        i();
        this.aj = 0;
    }

    @Override // com.opos.exoplayer.core.a.f
    public void a(f.c cVar) {
        this.n = cVar;
    }

    @Override // com.opos.exoplayer.core.a.f
    public boolean a(int i2) {
        if (!d(i2)) {
            com.opos.exoplayer.core.a.c cVar = this.f17556c;
            if (cVar == null || !cVar.a(i2)) {
                return false;
            }
        } else if (i2 == 4 && u.f19078a < 21) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x009b, code lost:
    
        if (r5 == 0) goto L119;
     */
    @Override // com.opos.exoplayer.core.a.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.nio.ByteBuffer r21, long r22) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.a.g.a(java.nio.ByteBuffer, long):boolean");
    }

    @Override // com.opos.exoplayer.core.a.f
    public void b() {
        if (this.V == 1) {
            this.V = 2;
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void b(int i2) {
        com.opos.exoplayer.core.i.a.b(u.f19078a >= 21);
        if (this.ak && this.aj == i2) {
            return;
        }
        this.ak = true;
        this.aj = i2;
        i();
    }

    @Override // com.opos.exoplayer.core.a.f
    public void c() {
        if (!this.ah && r() && m()) {
            this.l.a(t());
            this.G = 0;
            this.ah = true;
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public boolean d() {
        return !r() || (this.ah && !e());
    }

    @Override // com.opos.exoplayer.core.a.f
    public boolean e() {
        return r() && (t() > this.l.b() || w());
    }

    @Override // com.opos.exoplayer.core.a.f
    public p f() {
        return this.C;
    }

    @Override // com.opos.exoplayer.core.a.f
    public void g() {
        if (this.ak) {
            this.ak = false;
            this.aj = 0;
            i();
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void h() {
        this.ai = false;
        if (r()) {
            u();
            this.l.a();
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void i() {
        if (r()) {
            this.P = 0L;
            this.Q = 0L;
            this.S = 0L;
            this.T = 0L;
            this.U = 0;
            p pVar = this.B;
            if (pVar != null) {
                this.C = pVar;
                this.B = null;
            } else if (!this.m.isEmpty()) {
                this.C = this.m.getLast().f17582a;
            }
            this.m.clear();
            this.D = 0L;
            this.E = 0L;
            this.ac = null;
            this.f17555ad = null;
            int i2 = 0;
            while (true) {
                com.opos.exoplayer.core.a.d[] dVarArr = this.aa;
                if (i2 >= dVarArr.length) {
                    break;
                }
                com.opos.exoplayer.core.a.d dVar = dVarArr[i2];
                dVar.h();
                this.ab[i2] = dVar.f();
                i2++;
            }
            this.ah = false;
            this.ag = -1;
            this.F = null;
            this.G = 0;
            this.V = 0;
            this.Y = 0L;
            u();
            if (this.p.getPlayState() == 3) {
                this.p.pause();
            }
            AudioTrack audioTrack = this.p;
            this.p = null;
            this.l.a(null, false);
            this.f17563j.close();
            new Thread() { // from class: com.opos.exoplayer.core.a.g.1

                /* renamed from: a */
                final /* synthetic */ AudioTrack f17564a;

                AnonymousClass1(AudioTrack audioTrack2) {
                    audioTrack = audioTrack2;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        g.this.f17563j.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void j() {
        i();
        o();
        for (com.opos.exoplayer.core.a.d dVar : this.f17561h) {
            dVar.i();
        }
        for (com.opos.exoplayer.core.a.d dVar2 : this.f17562i) {
            dVar2.i();
        }
        this.aj = 0;
        this.ai = false;
    }
}
