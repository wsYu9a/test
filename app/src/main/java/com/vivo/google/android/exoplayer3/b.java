package com.vivo.google.android.exoplayer3;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.vivo.google.android.exoplayer3.ExoPlayer;
import com.vivo.google.android.exoplayer3.Timeline;
import com.vivo.google.android.exoplayer3.o3;
import com.vivo.google.android.exoplayer3.source.MediaSource;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelection;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelectionArray;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelector;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class b implements Handler.Callback, o3.a, TrackSelector.InvalidationListener, MediaSource.Listener {
    public int A;
    public c B;
    public long C;
    public a D;
    public a E;
    public a F;
    public Timeline G;

    /* renamed from: a */
    public final Renderer[] f27171a;

    /* renamed from: b */
    public final g[] f27172b;

    /* renamed from: c */
    public final TrackSelector f27173c;

    /* renamed from: d */
    public final e f27174d;

    /* renamed from: e */
    public final t6 f27175e;

    /* renamed from: f */
    public final Handler f27176f;

    /* renamed from: g */
    public final HandlerThread f27177g;

    /* renamed from: h */
    public final Handler f27178h;

    /* renamed from: i */
    public final ExoPlayer f27179i;

    /* renamed from: j */
    public final Timeline.Window f27180j;
    public final Timeline.Period k;
    public C0566b l;
    public PlaybackParameters m;
    public Renderer n;
    public k6 o;
    public MediaSource p;
    public Renderer[] q;
    public boolean r;
    public boolean t;
    public boolean u;
    public boolean v;
    public int x;
    public int y;
    public long z;
    public boolean s = false;
    public int w = 1;

    public static final class a {

        /* renamed from: a */
        public final o3 f27181a;

        /* renamed from: b */
        public final Object f27182b;

        /* renamed from: c */
        public final p3[] f27183c;

        /* renamed from: d */
        public final boolean[] f27184d;

        /* renamed from: e */
        public final long f27185e;

        /* renamed from: f */
        public int f27186f;

        /* renamed from: g */
        public long f27187g;

        /* renamed from: h */
        public boolean f27188h;

        /* renamed from: i */
        public boolean f27189i;

        /* renamed from: j */
        public boolean f27190j;
        public a k;
        public boolean l;
        public i5 m;
        public final Renderer[] n;
        public final g[] o;
        public final TrackSelector p;
        public final e q;
        public final MediaSource r;
        public i5 s;

        public a(Renderer[] rendererArr, g[] gVarArr, long j2, TrackSelector trackSelector, e eVar, MediaSource mediaSource, Object obj, int i2, boolean z, long j3) {
            this.n = rendererArr;
            this.o = gVarArr;
            this.f27185e = j2;
            this.p = trackSelector;
            this.q = eVar;
            this.r = mediaSource;
            this.f27182b = g1.a(obj);
            this.f27186f = i2;
            this.f27188h = z;
            this.f27187g = j3;
            this.f27183c = new p3[rendererArr.length];
            this.f27184d = new boolean[rendererArr.length];
            this.f27181a = mediaSource.createPeriod(i2, eVar.getAllocator(), j3);
        }

        public long a() {
            return this.f27185e - this.f27187g;
        }

        public long a(long j2, boolean z, boolean[] zArr) {
            TrackSelectionArray trackSelectionArray = this.m.f27510b;
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 >= trackSelectionArray.length) {
                    break;
                }
                boolean[] zArr2 = this.f27184d;
                if (z || !this.m.a(this.s, i2)) {
                    z2 = false;
                }
                zArr2[i2] = z2;
                i2++;
            }
            long a2 = this.f27181a.a(trackSelectionArray.getAll(), this.f27184d, this.f27183c, zArr, j2);
            this.s = this.m;
            this.f27190j = false;
            int i3 = 0;
            while (true) {
                p3[] p3VarArr = this.f27183c;
                if (i3 >= p3VarArr.length) {
                    this.q.onTracksSelected(this.n, this.m.f27509a, trackSelectionArray);
                    return a2;
                }
                if (p3VarArr[i3] != null) {
                    g1.b(trackSelectionArray.get(i3) != null);
                    this.f27190j = true;
                } else {
                    g1.b(trackSelectionArray.get(i3) == null);
                }
                i3++;
            }
        }

        public boolean b() {
            return this.f27189i && (!this.f27190j || this.f27181a.d() == Long.MIN_VALUE);
        }

        public void c() {
            try {
                this.r.releasePeriod(this.f27181a);
            } catch (RuntimeException unused) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean d() {
            /*
                r6 = this;
                com.vivo.google.android.exoplayer3.trackselection.TrackSelector r0 = r6.p
                com.vivo.google.android.exoplayer3.g[] r1 = r6.o
                com.vivo.google.android.exoplayer3.o3 r2 = r6.f27181a
                com.vivo.google.android.exoplayer3.source.TrackGroupArray r2 = r2.c()
                com.vivo.google.android.exoplayer3.i5 r0 = r0.selectTracks(r1, r2)
                com.vivo.google.android.exoplayer3.i5 r1 = r6.s
                r0.getClass()
                r2 = 1
                r3 = 0
                if (r1 != 0) goto L18
                goto L25
            L18:
                r4 = 0
            L19:
                com.vivo.google.android.exoplayer3.trackselection.TrackSelectionArray r5 = r0.f27510b
                int r5 = r5.length
                if (r4 >= r5) goto L2a
                boolean r5 = r0.a(r1, r4)
                if (r5 != 0) goto L27
            L25:
                r1 = 0
                goto L2b
            L27:
                int r4 = r4 + 1
                goto L19
            L2a:
                r1 = 1
            L2b:
                if (r1 == 0) goto L2e
                return r3
            L2e:
                r6.m = r0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.b.a.d():boolean");
        }
    }

    /* renamed from: com.vivo.google.android.exoplayer3.b$b */
    public static final class C0566b {

        /* renamed from: a */
        public final int f27191a;

        /* renamed from: b */
        public final long f27192b;

        /* renamed from: c */
        public volatile long f27193c;

        /* renamed from: d */
        public volatile long f27194d;

        public C0566b(int i2, long j2) {
            this.f27191a = i2;
            this.f27192b = j2;
            this.f27193c = j2;
            this.f27194d = j2;
        }
    }

    public static final class c {

        /* renamed from: a */
        public final Timeline f27195a;

        /* renamed from: b */
        public final int f27196b;

        /* renamed from: c */
        public final long f27197c;

        public c(Timeline timeline, int i2, long j2) {
            this.f27195a = timeline;
            this.f27196b = i2;
            this.f27197c = j2;
        }
    }

    public static final class d {

        /* renamed from: a */
        public final Timeline f27198a;

        /* renamed from: b */
        public final Object f27199b;

        /* renamed from: c */
        public final C0566b f27200c;

        /* renamed from: d */
        public final int f27201d;

        public d(Timeline timeline, Object obj, C0566b c0566b, int i2) {
            this.f27198a = timeline;
            this.f27199b = obj;
            this.f27200c = c0566b;
            this.f27201d = i2;
        }
    }

    public b(Renderer[] rendererArr, TrackSelector trackSelector, e eVar, boolean z, Handler handler, C0566b c0566b, ExoPlayer exoPlayer) {
        this.f27171a = rendererArr;
        this.f27173c = trackSelector;
        this.f27174d = eVar;
        this.t = z;
        this.f27178h = handler;
        this.l = c0566b;
        this.f27179i = exoPlayer;
        this.f27172b = new g[rendererArr.length];
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].setIndex(i2);
            this.f27172b[i2] = rendererArr[i2].getCapabilities();
        }
        this.f27175e = new t6();
        this.q = new Renderer[0];
        this.f27180j = new Timeline.Window();
        this.k = new Timeline.Period();
        trackSelector.init(this);
        this.m = PlaybackParameters.DEFAULT;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f27177g = handlerThread;
        handlerThread.start();
        this.f27176f = new Handler(handlerThread.getLooper(), this);
    }

    public final int a(int i2, Timeline timeline, Timeline timeline2) {
        int i3 = -1;
        while (i3 == -1 && i2 < timeline.getPeriodCount() - 1) {
            i2++;
            i3 = timeline2.getIndexOfPeriod(timeline.getPeriod(i2, this.k, true).uid);
        }
        return i3;
    }

    public final Pair<Integer, Long> a(Timeline timeline, int i2, long j2, long j3) {
        g1.a(i2, 0, timeline.getWindowCount());
        timeline.getWindow(i2, this.f27180j, false, j3);
        if (j2 == C.TIME_UNSET) {
            j2 = this.f27180j.getDefaultPositionUs();
            if (j2 == C.TIME_UNSET) {
                return null;
            }
        }
        Timeline.Window window = this.f27180j;
        int i3 = window.firstPeriodIndex;
        long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + j2;
        while (true) {
            long durationUs = timeline.getPeriod(i3, this.k).getDurationUs();
            if (durationUs == C.TIME_UNSET || positionInFirstPeriodUs < durationUs || i3 >= this.f27180j.lastPeriodIndex) {
                break;
            }
            positionInFirstPeriodUs -= durationUs;
            i3++;
        }
        return Pair.create(Integer.valueOf(i3), Long.valueOf(positionInFirstPeriodUs));
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0160 A[LOOP:2: B:112:0x0160->B:116:0x0170, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0351  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 939
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.b.a():void");
    }

    public final void a(int i2) {
        if (this.w != i2) {
            this.w = i2;
            this.f27178h.obtainMessage(1, i2, 0).sendToTarget();
        }
    }

    public final void a(long j2, long j3) {
        this.f27176f.removeMessages(2);
        long elapsedRealtime = (j2 + j3) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f27176f.sendEmptyMessage(2);
        } else {
            this.f27176f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    public final void a(Renderer renderer) {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    public final void a(a aVar) {
        while (aVar != null) {
            aVar.c();
            aVar = aVar.k;
        }
    }

    public final void a(MediaSource mediaSource, boolean z) {
        this.f27178h.sendEmptyMessage(0);
        a(true);
        this.f27174d.onPrepared();
        if (z) {
            this.l = new C0566b(0, C.TIME_UNSET);
        }
        this.p = mediaSource;
        mediaSource.prepareSource(this.f27179i, true, this);
        a(2);
        this.f27176f.sendEmptyMessage(2);
    }

    public final void a(Object obj, int i2) {
        this.l = new C0566b(0, 0L);
        b(obj, i2);
        this.l = new C0566b(0, C.TIME_UNSET);
        a(4);
        a(false);
    }

    public synchronized void a(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        if (!this.r && !this.s) {
            int i2 = this.x;
            this.x = i2 + 1;
            this.f27176f.obtainMessage(11, exoPlayerMessageArr).sendToTarget();
            while (this.y <= i2) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public final void a(boolean[] zArr, int i2) {
        this.q = new Renderer[i2];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            Renderer[] rendererArr = this.f27171a;
            if (i3 >= rendererArr.length) {
                return;
            }
            Renderer renderer = rendererArr[i3];
            TrackSelection trackSelection = this.F.m.f27510b.get(i3);
            if (trackSelection != null) {
                int i5 = i4 + 1;
                this.q[i4] = renderer;
                if (renderer.getState() == 0) {
                    h hVar = this.F.m.f27512d[i3];
                    boolean z = this.t && this.w == 3;
                    boolean z2 = !zArr[i3] && z;
                    int length = trackSelection.length();
                    Format[] formatArr = new Format[length];
                    for (int i6 = 0; i6 < length; i6++) {
                        formatArr[i6] = trackSelection.getFormat(i6);
                    }
                    a aVar = this.F;
                    renderer.enable(hVar, formatArr, aVar.f27183c[i3], this.C, z2, aVar.a());
                    k6 mediaClock = renderer.getMediaClock();
                    if (mediaClock != null) {
                        if (this.o != null) {
                            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.o = mediaClock;
                        this.n = renderer;
                        mediaClock.setPlaybackParameters(this.m);
                    }
                    if (z) {
                        renderer.start();
                    }
                }
                i4 = i5;
            }
            i3++;
        }
    }

    public final boolean a(long j2) {
        a aVar;
        return j2 == C.TIME_UNSET || this.l.f27193c < j2 || ((aVar = this.F.k) != null && aVar.f27189i);
    }

    public final long b(int i2, long j2) {
        a aVar;
        i();
        this.u = false;
        a(2);
        a aVar2 = this.F;
        if (aVar2 == null) {
            a aVar3 = this.D;
            if (aVar3 != null) {
                aVar3.c();
            }
            aVar = null;
        } else {
            aVar = null;
            while (aVar2 != null) {
                if (aVar2.f27186f == i2 && aVar2.f27189i) {
                    aVar = aVar2;
                } else {
                    aVar2.c();
                }
                aVar2 = aVar2.k;
            }
        }
        a aVar4 = this.F;
        if (aVar4 != aVar || aVar4 != this.E) {
            for (Renderer renderer : this.q) {
                renderer.disable();
            }
            this.q = new Renderer[0];
            this.o = null;
            this.n = null;
            this.F = null;
        }
        if (aVar != null) {
            aVar.k = null;
            this.D = aVar;
            this.E = aVar;
            b(aVar);
            a aVar5 = this.F;
            if (aVar5.f27190j) {
                j2 = aVar5.f27181a.b(j2);
            }
            b(j2);
            b();
        } else {
            this.D = null;
            this.E = null;
            this.F = null;
            b(j2);
        }
        this.f27176f.sendEmptyMessage(2);
        return j2;
    }

    public final void b() {
        a aVar = this.D;
        long a2 = !aVar.f27189i ? 0L : aVar.f27181a.a();
        if (a2 == Long.MIN_VALUE) {
            b(false);
            return;
        }
        long a3 = this.C - this.D.a();
        boolean shouldContinueLoading = this.f27174d.shouldContinueLoading(a2 - a3);
        b(shouldContinueLoading);
        if (!shouldContinueLoading) {
            this.D.l = true;
            return;
        }
        a aVar2 = this.D;
        aVar2.l = false;
        aVar2.f27181a.a(a3);
    }

    public final void b(a aVar) {
        if (this.F == aVar) {
            return;
        }
        boolean[] zArr = new boolean[this.f27171a.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            Renderer[] rendererArr = this.f27171a;
            if (i2 >= rendererArr.length) {
                this.F = aVar;
                this.f27178h.obtainMessage(3, aVar.m).sendToTarget();
                a(zArr, i3);
                return;
            }
            Renderer renderer = rendererArr[i2];
            zArr[i2] = renderer.getState() != 0;
            TrackSelection trackSelection = aVar.m.f27510b.get(i2);
            if (trackSelection != null) {
                i3++;
            }
            if (zArr[i2] && (trackSelection == null || (renderer.isCurrentStreamFinal() && renderer.getStream() == this.F.f27183c[i2]))) {
                if (renderer == this.n) {
                    this.f27175e.a(this.o);
                    this.o = null;
                    this.n = null;
                }
                a(renderer);
                renderer.disable();
            }
            i2++;
        }
    }

    public final void b(c cVar) {
        if (this.G == null) {
            this.A++;
            this.B = cVar;
            return;
        }
        Pair<Integer, Long> a2 = a(cVar);
        if (a2 == null) {
            C0566b c0566b = new C0566b(0, 0L);
            this.l = c0566b;
            this.f27178h.obtainMessage(4, 1, 0, c0566b).sendToTarget();
            this.l = new C0566b(0, C.TIME_UNSET);
            a(4);
            a(false);
            return;
        }
        int i2 = cVar.f27197c == C.TIME_UNSET ? 1 : 0;
        int intValue = ((Integer) a2.first).intValue();
        long longValue = ((Long) a2.second).longValue();
        try {
            C0566b c0566b2 = this.l;
            if (intValue == c0566b2.f27191a && longValue / 1000 == c0566b2.f27193c / 1000) {
                return;
            }
            long b2 = b(intValue, longValue);
            int i3 = i2 | (longValue == b2 ? 0 : 1);
            C0566b c0566b3 = new C0566b(intValue, b2);
            this.l = c0566b3;
            this.f27178h.obtainMessage(4, i3, 0, c0566b3).sendToTarget();
        } finally {
            C0566b c0566b4 = new C0566b(intValue, longValue);
            this.l = c0566b4;
            this.f27178h.obtainMessage(4, i2, 0, c0566b4).sendToTarget();
        }
    }

    public final void b(Object obj, int i2) {
        this.f27178h.obtainMessage(6, new d(this.G, obj, this.l, i2)).sendToTarget();
    }

    public final void b(boolean z) {
        if (this.v != z) {
            this.v = z;
            this.f27178h.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    public final void b(ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr) {
        try {
            for (ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
                exoPlayerMessage.target.handleMessage(exoPlayerMessage.messageType, exoPlayerMessage.message);
            }
            if (this.p != null) {
                this.f27176f.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.y++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.y++;
                notifyAll();
                throw th;
            }
        }
    }

    public final void c() {
        a aVar = this.D;
        if (aVar == null || aVar.f27189i) {
            return;
        }
        a aVar2 = this.E;
        if (aVar2 == null || aVar2.k == aVar) {
            for (Renderer renderer : this.q) {
                if (!renderer.hasReadStreamToEnd()) {
                    return;
                }
            }
            this.D.f27181a.e();
        }
    }

    public final void c(boolean z) {
        this.u = false;
        this.t = z;
        if (!z) {
            i();
            j();
            return;
        }
        int i2 = this.w;
        if (i2 == 3) {
            g();
        } else if (i2 != 2) {
            return;
        }
        this.f27176f.sendEmptyMessage(2);
    }

    public synchronized void d() {
        if (this.r) {
            return;
        }
        this.s = true;
        this.f27176f.sendEmptyMessage(6);
    }

    public final void e() {
        a(true);
        this.f27174d.onReleased();
        a(1);
        synchronized (this) {
            this.r = true;
            this.s = false;
            notifyAll();
            this.f27177g.quit();
        }
    }

    public final void f() {
        a aVar = this.F;
        if (aVar == null) {
            return;
        }
        boolean z = true;
        while (aVar != null && aVar.f27189i) {
            if (aVar.d()) {
                if (z) {
                    a aVar2 = this.E;
                    a aVar3 = this.F;
                    boolean z2 = aVar2 != aVar3;
                    a(aVar3.k);
                    a aVar4 = this.F;
                    aVar4.k = null;
                    this.D = aVar4;
                    this.E = aVar4;
                    boolean[] zArr = new boolean[this.f27171a.length];
                    long a2 = aVar4.a(this.l.f27193c, z2, zArr);
                    if (a2 != this.l.f27193c) {
                        this.l.f27193c = a2;
                        b(a2);
                    }
                    boolean[] zArr2 = new boolean[this.f27171a.length];
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        Renderer[] rendererArr = this.f27171a;
                        if (i2 >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i2];
                        zArr2[i2] = renderer.getState() != 0;
                        p3 p3Var = this.F.f27183c[i2];
                        if (p3Var != null) {
                            i3++;
                        }
                        if (zArr2[i2]) {
                            if (p3Var != renderer.getStream()) {
                                if (renderer == this.n) {
                                    if (p3Var == null) {
                                        this.f27175e.a(this.o);
                                    }
                                    this.o = null;
                                    this.n = null;
                                }
                                a(renderer);
                                renderer.disable();
                            } else if (zArr[i2]) {
                                renderer.resetPosition(this.C);
                            }
                        }
                        i2++;
                    }
                    this.f27178h.obtainMessage(3, aVar.m).sendToTarget();
                    a(zArr2, i3);
                } else {
                    this.D = aVar;
                    while (true) {
                        aVar = aVar.k;
                        if (aVar == null) {
                            break;
                        } else {
                            aVar.c();
                        }
                    }
                    a aVar5 = this.D;
                    aVar5.k = null;
                    if (aVar5.f27189i) {
                        long max = Math.max(aVar5.f27187g, this.C - aVar5.a());
                        a aVar6 = this.D;
                        aVar6.a(max, false, new boolean[aVar6.n.length]);
                    }
                }
                b();
                j();
                this.f27176f.sendEmptyMessage(2);
                return;
            }
            if (aVar == this.E) {
                z = false;
            }
            aVar = aVar.k;
        }
    }

    public final void g() {
        this.u = false;
        t6 t6Var = this.f27175e;
        if (!t6Var.f28113a) {
            t6Var.f28115c = SystemClock.elapsedRealtime();
            t6Var.f28113a = true;
        }
        for (Renderer renderer : this.q) {
            renderer.start();
        }
    }

    public final void h() {
        a(true);
        this.f27174d.onStopped();
        a(1);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        ExoPlaybackException e2;
        try {
            switch (message.what) {
                case 0:
                    a((MediaSource) message.obj, message.arg1 != 0);
                    return true;
                case 1:
                    c(message.arg1 != 0);
                    return true;
                case 2:
                    a();
                    return true;
                case 3:
                    b((c) message.obj);
                    return true;
                case 4:
                    a((PlaybackParameters) message.obj);
                    return true;
                case 5:
                    h();
                    return true;
                case 6:
                    e();
                    return true;
                case 7:
                    a((Pair<Timeline, Object>) message.obj);
                    return true;
                case 8:
                    a((o3) message.obj);
                    return true;
                case 9:
                    o3 o3Var = (o3) message.obj;
                    a aVar = this.D;
                    if (aVar != null && aVar.f27181a == o3Var) {
                        b();
                    }
                    return true;
                case 10:
                    f();
                    return true;
                case 11:
                    b((ExoPlayer.ExoPlayerMessage[]) message.obj);
                    return true;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e3) {
            e2 = e3;
            handler = this.f27178h;
            handler.obtainMessage(8, e2).sendToTarget();
            h();
            return true;
        } catch (IOException e4) {
            handler = this.f27178h;
            e2 = ExoPlaybackException.createForSource(e4);
            handler.obtainMessage(8, e2).sendToTarget();
            h();
            return true;
        } catch (RuntimeException e5) {
            handler = this.f27178h;
            e2 = ExoPlaybackException.createForUnexpected(e5);
            handler.obtainMessage(8, e2).sendToTarget();
            h();
            return true;
        }
    }

    public final void i() {
        t6 t6Var = this.f27175e;
        if (t6Var.f28113a) {
            t6Var.a(t6Var.a());
            t6Var.f28113a = false;
        }
        for (Renderer renderer : this.q) {
            a(renderer);
        }
    }

    public final void j() {
        a aVar = this.F;
        if (aVar == null) {
            return;
        }
        long b2 = aVar.f27181a.b();
        if (b2 != C.TIME_UNSET) {
            b(b2);
        } else {
            Renderer renderer = this.n;
            if (renderer == null || renderer.isEnded()) {
                this.C = this.f27175e.a();
            } else {
                long a2 = this.o.a();
                this.C = a2;
                this.f27175e.a(a2);
            }
            b2 = this.C - this.F.a();
        }
        this.l.f27193c = b2;
        this.z = SystemClock.elapsedRealtime() * 1000;
        long d2 = this.q.length == 0 ? Long.MIN_VALUE : this.F.f27181a.d();
        C0566b c0566b = this.l;
        if (d2 == Long.MIN_VALUE) {
            d2 = this.G.getPeriod(this.F.f27186f, this.k).getDurationUs();
        }
        c0566b.f27194d = d2;
    }

    @Override // com.vivo.google.android.exoplayer3.source.MediaSource.Listener
    public void onSourceInfoRefreshed(Timeline timeline, Object obj) {
        this.f27176f.obtainMessage(7, Pair.create(timeline, obj)).sendToTarget();
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.f27176f.sendEmptyMessage(10);
    }

    public final void b(long j2) {
        a aVar = this.F;
        long a2 = j2 + (aVar == null ? 60000000L : aVar.a());
        this.C = a2;
        this.f27175e.a(a2);
        for (Renderer renderer : this.q) {
            renderer.resetPosition(this.C);
        }
    }

    public final Pair<Integer, Long> a(int i2, long j2) {
        return a(this.G, i2, j2, 0L);
    }

    public final void a(o3 o3Var) {
        a aVar = this.D;
        if (aVar == null || aVar.f27181a != o3Var) {
            return;
        }
        aVar.f27189i = true;
        aVar.d();
        aVar.f27187g = aVar.a(aVar.f27187g, false, new boolean[aVar.n.length]);
        if (this.F == null) {
            a aVar2 = this.D;
            this.E = aVar2;
            b(aVar2.f27187g);
            b(this.E);
        }
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.util.Pair<com.vivo.google.android.exoplayer3.Timeline, java.lang.Object> r13) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.b.a(android.util.Pair):void");
    }

    public void a(q3 q3Var) {
        this.f27176f.obtainMessage(9, (o3) q3Var).sendToTarget();
    }

    public final void a(boolean z) {
        this.f27176f.removeMessages(2);
        this.u = false;
        t6 t6Var = this.f27175e;
        if (t6Var.f28113a) {
            t6Var.a(t6Var.a());
            t6Var.f28113a = false;
        }
        this.o = null;
        this.n = null;
        this.C = 60000000L;
        for (Renderer renderer : this.q) {
            try {
                a(renderer);
                renderer.disable();
            } catch (ExoPlaybackException | RuntimeException unused) {
            }
        }
        this.q = new Renderer[0];
        a aVar = this.F;
        if (aVar == null) {
            aVar = this.D;
        }
        a(aVar);
        this.D = null;
        this.E = null;
        this.F = null;
        b(false);
        if (z) {
            MediaSource mediaSource = this.p;
            if (mediaSource != null) {
                mediaSource.releaseSource();
                this.p = null;
            }
            this.G = null;
        }
    }

    public final Pair<Integer, Long> a(c cVar) {
        Timeline timeline = cVar.f27195a;
        if (timeline.isEmpty()) {
            timeline = this.G;
        }
        try {
            Pair<Integer, Long> a2 = a(timeline, cVar.f27196b, cVar.f27197c, 0L);
            Timeline timeline2 = this.G;
            if (timeline2 == timeline) {
                return a2;
            }
            int indexOfPeriod = timeline2.getIndexOfPeriod(timeline.getPeriod(((Integer) a2.first).intValue(), this.k, true).uid);
            if (indexOfPeriod != -1) {
                return Pair.create(Integer.valueOf(indexOfPeriod), a2.second);
            }
            int a3 = a(((Integer) a2.first).intValue(), timeline, this.G);
            if (a3 != -1) {
                return a(this.G.getPeriod(a3, this.k).windowIndex, C.TIME_UNSET);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
            throw new com.vivo.google.android.exoplayer3.d(this.G, cVar.f27196b, cVar.f27197c);
        }
    }

    public final void a(PlaybackParameters playbackParameters) {
        k6 k6Var = this.o;
        if (k6Var != null) {
            playbackParameters = k6Var.setPlaybackParameters(playbackParameters);
        } else {
            t6 t6Var = this.f27175e;
            if (t6Var.f28113a) {
                t6Var.a(t6Var.a());
            }
            t6Var.f28116d = playbackParameters;
        }
        this.m = playbackParameters;
        this.f27178h.obtainMessage(7, playbackParameters).sendToTarget();
    }
}
