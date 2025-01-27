package com.martian.ttbook.b.a.p;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.martian.ttbook.b.a.p.a;
import com.martian.ttbook.b.a.p.e;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class d extends SurfaceView implements a.g, e.c {
    private boolean A;
    private int B;
    private int C;
    private com.martian.ttbook.b.a.p.e D;
    private h E;
    MediaPlayer.OnVideoSizeChangedListener F;
    MediaPlayer.OnPreparedListener G;
    private MediaPlayer.OnCompletionListener H;
    private MediaPlayer.OnInfoListener I;
    private MediaPlayer.OnErrorListener J;
    private MediaPlayer.OnBufferingUpdateListener K;
    SurfaceHolder.Callback L;

    /* renamed from: a */
    private String f15114a;

    /* renamed from: b */
    private Uri f15115b;

    /* renamed from: c */
    private int f15116c;

    /* renamed from: d */
    private int f15117d;

    /* renamed from: e */
    private SurfaceHolder f15118e;

    /* renamed from: f */
    private MediaPlayer f15119f;

    /* renamed from: g */
    private int f15120g;

    /* renamed from: h */
    private int f15121h;

    /* renamed from: i */
    private int f15122i;

    /* renamed from: j */
    private int f15123j;
    private int k;
    private com.martian.ttbook.b.a.p.a l;
    private MediaPlayer.OnCompletionListener m;
    private MediaPlayer.OnPreparedListener n;
    private int o;
    private MediaPlayer.OnErrorListener p;
    private MediaPlayer.OnInfoListener q;
    private int r;
    private int s;
    private AtomicBoolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private Context y;
    private boolean z;

    class a implements MediaPlayer.OnVideoSizeChangedListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            d.this.f15121h = mediaPlayer.getVideoWidth();
            d.this.f15122i = mediaPlayer.getVideoHeight();
            Log.d(d.this.f15114a, String.format("onVideoSizeChanged width=%d,height=%d", Integer.valueOf(d.this.f15121h), Integer.valueOf(d.this.f15122i)));
            if (d.this.f15121h == 0 || d.this.f15122i == 0) {
                return;
            }
            d.this.N();
            d.this.requestLayout();
        }
    }

    class b implements MediaPlayer.OnPreparedListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Log.e(d.this.f15114a, "onPrepared enter");
            d.this.f15116c = 2;
            d dVar = d.this;
            dVar.u = dVar.v = dVar.w = true;
            d.this.x = true;
            if (d.this.l != null) {
                d.this.l.C();
            }
            if (d.this.t.compareAndSet(true, false) && d.this.n != null) {
                d.this.n.onPrepared(d.this.f15119f);
            }
            if (d.this.l != null) {
                d.this.l.setEnabled(true);
            }
            d.this.f15121h = mediaPlayer.getVideoWidth();
            d.this.f15122i = mediaPlayer.getVideoHeight();
            int i2 = d.this.r;
            if (i2 != 0) {
                d.this.e(i2);
            }
            if (d.this.f15121h == 0 || d.this.f15122i == 0) {
                if (d.this.f15117d == 3) {
                    d.this.d();
                    return;
                }
                return;
            }
            d.this.N();
            if (d.this.f15123j == d.this.f15121h && d.this.k == d.this.f15122i) {
                if (d.this.f15117d == 3) {
                    d.this.d();
                    if (d.this.l != null) {
                        d.this.l.L();
                        return;
                    }
                    return;
                }
                if (d.this.a()) {
                    return;
                }
                if ((i2 != 0 || d.this.f() > 0) && d.this.l != null) {
                    d.this.l.c(0);
                }
            }
        }
    }

    class c implements MediaPlayer.OnCompletionListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            d.this.f15116c = 5;
            d.this.f15117d = 5;
            if (d.this.l != null) {
                boolean isPlaying = d.this.f15119f.isPlaying();
                int i2 = d.this.f15116c;
                d.this.l.M();
                Log.d(d.this.f15114a, String.format("a=%s,b=%d", Boolean.valueOf(isPlaying), Integer.valueOf(i2)));
            }
            if (d.this.m != null) {
                d.this.m.onCompletion(d.this.f15119f);
            }
        }
    }

    /* renamed from: com.martian.ttbook.b.a.p.d$d */
    class C0285d implements MediaPlayer.OnInfoListener {
        C0285d() {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x008d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x007c  */
        @Override // android.media.MediaPlayer.OnInfoListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onInfo(android.media.MediaPlayer r5, int r6, int r7) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                r2 = 701(0x2bd, float:9.82E-43)
                if (r6 == r2) goto L40
                r2 = 702(0x2be, float:9.84E-43)
                if (r6 == r2) goto Lc
                r2 = 0
                goto L74
            Lc:
                com.martian.ttbook.b.a.p.d r2 = com.martian.ttbook.b.a.p.d.this
                java.lang.String r2 = com.martian.ttbook.b.a.p.d.U(r2)
                java.lang.String r3 = "onInfo MediaPlayer.MEDIA_INFO_BUFFERING_END"
                android.util.Log.d(r2, r3)
                com.martian.ttbook.b.a.p.d r2 = com.martian.ttbook.b.a.p.d.this
                com.martian.ttbook.b.a.p.d$h r2 = com.martian.ttbook.b.a.p.d.Q(r2)
                if (r2 == 0) goto L2e
                com.martian.ttbook.b.a.p.d r2 = com.martian.ttbook.b.a.p.d.this
                com.martian.ttbook.b.a.p.d$h r2 = com.martian.ttbook.b.a.p.d.Q(r2)
                com.martian.ttbook.b.a.p.d r3 = com.martian.ttbook.b.a.p.d.this
                android.media.MediaPlayer r3 = com.martian.ttbook.b.a.p.d.D(r3)
                r2.f(r3)
            L2e:
                com.martian.ttbook.b.a.p.d r2 = com.martian.ttbook.b.a.p.d.this
                com.martian.ttbook.b.a.p.a r2 = com.martian.ttbook.b.a.p.d.g0(r2)
                if (r2 == 0) goto L73
                com.martian.ttbook.b.a.p.d r2 = com.martian.ttbook.b.a.p.d.this
                com.martian.ttbook.b.a.p.a r2 = com.martian.ttbook.b.a.p.d.g0(r2)
                r2.C()
                goto L73
            L40:
                com.martian.ttbook.b.a.p.d r2 = com.martian.ttbook.b.a.p.d.this
                java.lang.String r2 = com.martian.ttbook.b.a.p.d.U(r2)
                java.lang.String r3 = "onInfo MediaPlayer.MEDIA_INFO_BUFFERING_START"
                android.util.Log.d(r2, r3)
                com.martian.ttbook.b.a.p.d r2 = com.martian.ttbook.b.a.p.d.this
                com.martian.ttbook.b.a.p.d$h r2 = com.martian.ttbook.b.a.p.d.Q(r2)
                if (r2 == 0) goto L62
                com.martian.ttbook.b.a.p.d r2 = com.martian.ttbook.b.a.p.d.this
                com.martian.ttbook.b.a.p.d$h r2 = com.martian.ttbook.b.a.p.d.Q(r2)
                com.martian.ttbook.b.a.p.d r3 = com.martian.ttbook.b.a.p.d.this
                android.media.MediaPlayer r3 = com.martian.ttbook.b.a.p.d.D(r3)
                r2.e(r3)
            L62:
                com.martian.ttbook.b.a.p.d r2 = com.martian.ttbook.b.a.p.d.this
                com.martian.ttbook.b.a.p.a r2 = com.martian.ttbook.b.a.p.d.g0(r2)
                if (r2 == 0) goto L73
                com.martian.ttbook.b.a.p.d r2 = com.martian.ttbook.b.a.p.d.this
                com.martian.ttbook.b.a.p.a r2 = com.martian.ttbook.b.a.p.d.g0(r2)
                r2.O()
            L73:
                r2 = 1
            L74:
                com.martian.ttbook.b.a.p.d r3 = com.martian.ttbook.b.a.p.d.this
                android.media.MediaPlayer$OnInfoListener r3 = com.martian.ttbook.b.a.p.d.S(r3)
                if (r3 == 0) goto L8d
                com.martian.ttbook.b.a.p.d r3 = com.martian.ttbook.b.a.p.d.this
                android.media.MediaPlayer$OnInfoListener r3 = com.martian.ttbook.b.a.p.d.S(r3)
                boolean r5 = r3.onInfo(r5, r6, r7)
                if (r5 != 0) goto L8c
                if (r2 == 0) goto L8b
                goto L8c
            L8b:
                r0 = 0
            L8c:
                return r0
            L8d:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.a.p.d.C0285d.onInfo(android.media.MediaPlayer, int, int):boolean");
        }
    }

    class e implements MediaPlayer.OnErrorListener {
        e() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Log.d(d.this.f15114a, "Error: " + i2 + "," + i3);
            d.this.f15116c = -1;
            d.this.f15117d = -1;
            if (d.this.l != null) {
                d.this.l.N();
            }
            if (d.this.p == null || d.this.p.onError(d.this.f15119f, i2, i3)) {
            }
            return true;
        }
    }

    class f implements MediaPlayer.OnBufferingUpdateListener {
        f() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            if (d.this.E != null && i2 == 100) {
                d.this.E.a(mediaPlayer);
            }
            d.this.o = i2;
        }
    }

    class g implements SurfaceHolder.Callback {
        g() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            b.d.e.c.a.d.k(d.this.f15114a, "surfaceChanged");
            d.this.f15123j = i3;
            d.this.k = i4;
            boolean z = d.this.f15117d == 3;
            boolean z2 = d.this.f15121h == i3 && d.this.f15122i == i4;
            if (d.this.f15119f != null && z && z2) {
                if (d.this.r != 0) {
                    d dVar = d.this;
                    dVar.e(dVar.r);
                }
                d.this.d();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            b.d.e.c.a.d.k(d.this.f15114a, "surfaceCreated mSeekWhenDestroyed " + d.this.s);
            d.this.f15118e = surfaceHolder;
            d.this.X();
            d.this.R();
            if (d.this.s > 0) {
                d dVar = d.this;
                dVar.e(dVar.s);
                d.this.s = 0;
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            b.d.e.c.a.d.k(d.this.f15114a, "surfaceDestroyed");
            d.this.f15118e = null;
            if (d.this.E != null) {
                d.this.E.b(d.this.f15119f);
            }
            d dVar = d.this;
            dVar.s = dVar.f();
            if (d.this.l != null) {
                d.this.l.w();
            }
            d.this.t(true);
            d.this.P();
        }
    }

    public interface h {
        void a(MediaPlayer mediaPlayer);

        void a(boolean z);

        void b(MediaPlayer mediaPlayer);

        void c(MediaPlayer mediaPlayer);

        void d(MediaPlayer mediaPlayer);

        void e(MediaPlayer mediaPlayer);

        void f(MediaPlayer mediaPlayer);

        void g(MediaPlayer mediaPlayer);
    }

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15114a = "ApiVideoViewTAG";
        this.f15116c = 0;
        this.f15117d = 0;
        this.f15118e = null;
        this.f15119f = null;
        this.t = new AtomicBoolean();
        this.z = false;
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.F = new a();
        this.G = new b();
        this.H = new c();
        this.I = new C0285d();
        this.J = new e();
        this.K = new f();
        this.L = new g();
        this.y = context;
        T();
    }

    private void L() {
        com.martian.ttbook.b.a.p.a aVar;
        if (this.f15119f == null || (aVar = this.l) == null) {
            return;
        }
        aVar.g(this);
        this.l.setEnabled(V());
        this.l.w();
    }

    public void N() {
        getHolder().setFixedSize(this.f15121h, this.f15122i);
    }

    public void P() {
        com.martian.ttbook.b.a.p.e eVar = this.D;
        if (eVar != null) {
            eVar.h();
        }
    }

    public void R() {
        if (this.A && this.D == null) {
            com.martian.ttbook.b.a.p.e eVar = new com.martian.ttbook.b.a.p.e(this.y);
            this.D = eVar;
            eVar.f(this);
            this.D.j();
        }
    }

    private void T() {
        this.f15121h = 0;
        this.f15122i = 0;
        getHolder().addCallback(this.L);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f15116c = 0;
        this.f15117d = 0;
    }

    private boolean V() {
        int i2;
        return (this.f15119f == null || (i2 = this.f15116c) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public void X() {
        h hVar;
        Log.e(this.f15114a, "openVideo ");
        if (this.f15115b == null || this.f15118e == null) {
            return;
        }
        ((AudioManager) this.y.getSystemService("audio")).requestAudioFocus(null, 3, 1);
        t(false);
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f15119f = mediaPlayer;
            int i2 = this.f15120g;
            if (i2 != 0) {
                mediaPlayer.setAudioSessionId(i2);
            } else {
                this.f15120g = mediaPlayer.getAudioSessionId();
            }
            this.f15119f.setOnPreparedListener(this.G);
            this.f15119f.setOnVideoSizeChangedListener(this.F);
            this.f15119f.setOnCompletionListener(this.H);
            this.f15119f.setOnErrorListener(this.J);
            this.f15119f.setOnInfoListener(this.I);
            this.f15119f.setOnBufferingUpdateListener(this.K);
            this.o = 0;
            this.f15119f.setDataSource(this.y, this.f15115b);
            this.f15119f.setDisplay(this.f15118e);
            this.f15119f.setAudioStreamType(3);
            this.f15119f.setScreenOnWhilePlaying(true);
            this.f15119f.prepareAsync();
            if (this.t.get() && (hVar = this.E) != null) {
                hVar.d(this.f15119f);
            }
            this.f15116c = 1;
            L();
            Log.e(this.f15114a, "openVideo end");
        } catch (IOException e2) {
            Log.w(this.f15114a, "Unable to open content: " + this.f15115b, e2);
            this.f15116c = -1;
            this.f15117d = -1;
            this.J.onError(this.f15119f, 1, 0);
        }
    }

    private void a0() {
        com.martian.ttbook.b.a.p.a aVar = this.l;
        if (aVar == null || aVar.o() == a.h.f15093d) {
            if (this.l.G()) {
                this.l.w();
            } else {
                this.l.L();
            }
        }
    }

    private void f(int i2, int i3) {
        setMeasuredDimension(SurfaceView.getDefaultSize(this.f15121h, i2), SurfaceView.getDefaultSize(this.f15122i, i3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0062, code lost:
    
        if (r1 > r6) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void s(int r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = r5.f15114a
            java.lang.String r1 = "onMeasureKeepAspectRatio "
            android.util.Log.e(r0, r1)
            int r0 = r5.f15121h
            int r0 = android.view.SurfaceView.getDefaultSize(r0, r6)
            int r1 = r5.f15122i
            int r1 = android.view.SurfaceView.getDefaultSize(r1, r7)
            int r2 = r5.f15121h
            if (r2 <= 0) goto L7f
            int r2 = r5.f15122i
            if (r2 <= 0) goto L7f
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L44
            if (r1 != r2) goto L44
            int r0 = r5.f15121h
            int r1 = r0 * r7
            int r2 = r5.f15122i
            int r3 = r6 * r2
            if (r1 >= r3) goto L3f
            int r0 = r1 / r2
        L3d:
            r1 = r7
            goto L7f
        L3f:
            if (r1 <= r3) goto L64
            int r1 = r3 / r0
            goto L55
        L44:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L57
            int r0 = r5.f15122i
            int r0 = r0 * r6
            int r2 = r5.f15121h
            int r0 = r0 / r2
            if (r1 != r3) goto L54
            if (r0 <= r7) goto L54
            goto L64
        L54:
            r1 = r0
        L55:
            r0 = r6
            goto L7f
        L57:
            if (r1 != r2) goto L68
            int r1 = r5.f15121h
            int r1 = r1 * r7
            int r2 = r5.f15122i
            int r1 = r1 / r2
            if (r0 != r3) goto L66
            if (r1 <= r6) goto L66
        L64:
            r0 = r6
            goto L3d
        L66:
            r0 = r1
            goto L3d
        L68:
            int r2 = r5.f15121h
            int r4 = r5.f15122i
            if (r1 != r3) goto L74
            if (r4 <= r7) goto L74
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L76
        L74:
            r1 = r2
            r7 = r4
        L76:
            if (r0 != r3) goto L66
            if (r1 <= r6) goto L66
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L55
        L7f:
            r5.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.a.p.d.s(int, int):void");
    }

    public void t(boolean z) {
        MediaPlayer mediaPlayer = this.f15119f;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f15119f.release();
            this.f15119f = null;
            this.f15116c = 0;
            if (z) {
                this.f15117d = 0;
            }
        }
    }

    public void Z() {
        MediaPlayer mediaPlayer = this.f15119f;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f15119f.release();
            this.f15119f = null;
            this.f15116c = 0;
            this.f15117d = 0;
        }
    }

    @Override // com.martian.ttbook.b.a.p.e.c
    public void a(int i2, e.b bVar) {
        if (this.A) {
            if (bVar == e.b.f15140b) {
                p(false, 1);
                return;
            }
            if (bVar == e.b.f15141c) {
                p(false, 7);
            } else if (bVar == e.b.f15142d) {
                p(true, 0);
            } else if (bVar == e.b.f15143e) {
                p(true, 8);
            }
        }
    }

    @Override // com.martian.ttbook.b.a.p.a.g
    public void a(boolean z) {
        p(z, !z ? 1 : 0);
    }

    @Override // com.martian.ttbook.b.a.p.a.g
    public boolean a() {
        return V() && this.f15119f.isPlaying();
    }

    @Override // com.martian.ttbook.b.a.p.a.g
    public void b() {
        if (V() && this.f15119f.isPlaying()) {
            this.f15119f.pause();
            this.f15116c = 4;
            h hVar = this.E;
            if (hVar != null) {
                hVar.b(this.f15119f);
            }
        }
        this.f15117d = 4;
    }

    @Override // com.martian.ttbook.b.a.p.a.g
    public boolean c() {
        return this.u;
    }

    @Override // com.martian.ttbook.b.a.p.a.g
    public void d() {
        com.martian.ttbook.b.a.p.a aVar;
        Log.e(this.f15114a, "start ");
        if (!this.x && (aVar = this.l) != null) {
            aVar.O();
        }
        if (V()) {
            com.martian.ttbook.b.a.p.a aVar2 = this.l;
            if (aVar2 != null && aVar2.o() == a.h.f15092c) {
                this.l.L();
            }
            this.f15119f.start();
            h hVar = this.E;
            if (hVar != null) {
                if (this.f15116c == 4) {
                    hVar.c(this.f15119f);
                } else {
                    hVar.g(this.f15119f);
                }
            }
            this.f15116c = 3;
        }
        this.f15117d = 3;
    }

    @Override // com.martian.ttbook.b.a.p.a.g
    public int e() {
        if (V()) {
            return this.f15119f.getDuration();
        }
        return -1;
    }

    public void e(int i2) {
        if (V()) {
            this.f15119f.seekTo(i2);
            i2 = 0;
        }
        this.r = i2;
    }

    @Override // com.martian.ttbook.b.a.p.a.g
    public int f() {
        if (V()) {
            return this.f15119f.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.martian.ttbook.b.a.p.a.g
    public int g() {
        if (this.f15119f != null) {
            return this.o;
        }
        return 0;
    }

    public void g(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.m = onCompletionListener;
    }

    public void h(MediaPlayer.OnErrorListener onErrorListener) {
        this.p = onErrorListener;
    }

    public void i(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.n = onPreparedListener;
    }

    public void j(Uri uri) {
        k(uri, null);
    }

    public void k(Uri uri, Map<String, String> map) {
        b.d.e.c.a.d.k(this.f15114a, "setVideoURI ");
        this.f15115b = uri;
        this.r = 0;
        this.s = 0;
        this.t.set(true);
        X();
        requestLayout();
        invalidate();
    }

    public void l(com.martian.ttbook.b.a.p.a aVar) {
        com.martian.ttbook.b.a.p.a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.w();
        }
        this.l = aVar;
        L();
    }

    public void m(h hVar) {
        this.E = hVar;
    }

    public void o(String str) {
        j(Uri.parse(str));
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(d.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(d.class.getName());
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z = (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 == 5 || i2 == 6) ? false : true;
        if (V() && z && this.l != null) {
            if (i2 == 79 || i2 == 85) {
                if (this.f15119f.isPlaying()) {
                    b();
                    this.l.L();
                } else {
                    d();
                    this.l.w();
                }
                return true;
            }
            if (i2 == 126) {
                if (!this.f15119f.isPlaying()) {
                    d();
                    this.l.w();
                }
                return true;
            }
            if (i2 == 86 || i2 == 127) {
                if (this.f15119f.isPlaying()) {
                    b();
                    this.l.L();
                }
                return true;
            }
            a0();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.z) {
            f(i2, i3);
        } else {
            s(i2, i3);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!V() || this.l == null) {
            return false;
        }
        a0();
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!V() || this.l == null) {
            return false;
        }
        a0();
        return false;
    }

    public void p(boolean z, int i2) {
        Activity activity = (Activity) this.y;
        if (z) {
            if (this.B == 0 && this.C == 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                this.B = layoutParams.width;
                this.C = layoutParams.height;
            }
            activity.getWindow().addFlags(1024);
        } else {
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            layoutParams2.width = this.B;
            layoutParams2.height = this.C;
            setLayoutParams(layoutParams2);
            activity.getWindow().clearFlags(1024);
        }
        activity.setRequestedOrientation(i2);
        this.l.i(z);
        h hVar = this.E;
        if (hVar != null) {
            hVar.a(z);
        }
    }

    public void x(boolean z) {
        this.A = z;
    }
}
