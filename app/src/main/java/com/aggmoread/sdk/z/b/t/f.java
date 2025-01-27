package com.aggmoread.sdk.z.b.t;

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
import com.aggmoread.sdk.z.b.t.a;
import com.aggmoread.sdk.z.b.t.h;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class f extends SurfaceView implements a.g, h.c {
    private boolean A;
    private int B;
    private int C;
    private i D;
    private com.aggmoread.sdk.z.b.t.h E;
    private j F;
    private float G;
    MediaPlayer.OnVideoSizeChangedListener H;
    MediaPlayer.OnPreparedListener I;
    private MediaPlayer.OnCompletionListener J;
    private MediaPlayer.OnInfoListener K;
    private MediaPlayer.OnErrorListener L;
    private MediaPlayer.OnBufferingUpdateListener M;
    SurfaceHolder.Callback N;

    /* renamed from: a */
    private String f4979a;

    /* renamed from: b */
    private Uri f4980b;

    /* renamed from: c */
    private int f4981c;

    /* renamed from: d */
    private int f4982d;

    /* renamed from: e */
    private SurfaceHolder f4983e;

    /* renamed from: f */
    private MediaPlayer f4984f;

    /* renamed from: g */
    private int f4985g;

    /* renamed from: h */
    private int f4986h;

    /* renamed from: i */
    private int f4987i;

    /* renamed from: j */
    private int f4988j;

    /* renamed from: k */
    private int f4989k;

    /* renamed from: l */
    private com.aggmoread.sdk.z.b.t.a f4990l;

    /* renamed from: m */
    private MediaPlayer.OnCompletionListener f4991m;

    /* renamed from: n */
    private MediaPlayer.OnPreparedListener f4992n;

    /* renamed from: o */
    private int f4993o;

    /* renamed from: p */
    private MediaPlayer.OnErrorListener f4994p;

    /* renamed from: q */
    private MediaPlayer.OnInfoListener f4995q;

    /* renamed from: r */
    private int f4996r;

    /* renamed from: s */
    private int f4997s;

    /* renamed from: t */
    private AtomicBoolean f4998t;

    /* renamed from: u */
    private boolean f4999u;

    /* renamed from: v */
    private boolean f5000v;

    /* renamed from: w */
    private boolean f5001w;

    /* renamed from: x */
    private boolean f5002x;

    /* renamed from: y */
    private Context f5003y;

    /* renamed from: z */
    private boolean f5004z;

    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            f.this.f4986h = mediaPlayer.getVideoWidth();
            f.this.f4987i = mediaPlayer.getVideoHeight();
            Log.d(f.this.f4979a, String.format("onVideoSizeChanged width=%d,height=%d", Integer.valueOf(f.this.f4986h), Integer.valueOf(f.this.f4987i)));
            if (f.this.f4986h == 0 || f.this.f4987i == 0) {
                return;
            }
            f.this.i();
            f.this.requestLayout();
        }
    }

    public class b implements MediaPlayer.OnPreparedListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Log.e(f.this.f4979a, "onPrepared enter");
            f.this.f4981c = 2;
            f fVar = f.this;
            fVar.f4999u = fVar.f5000v = fVar.f5001w = true;
            f.this.f5002x = true;
            if (f.this.f4990l != null) {
                f.this.f4990l.g();
            }
            if (f.this.f4998t.compareAndSet(true, false) && f.this.f4992n != null) {
                f.this.f4992n.onPrepared(f.this.f4984f);
            }
            if (f.this.f4990l != null) {
                f.this.f4990l.setEnabled(true);
            }
            f.this.f4986h = mediaPlayer.getVideoWidth();
            f.this.f4987i = mediaPlayer.getVideoHeight();
            int i10 = f.this.f4996r;
            if (i10 != 0) {
                f.this.a(i10);
            }
            if (f.this.f4986h == 0 || f.this.f4987i == 0) {
                if (f.this.f4982d == 3) {
                    f.this.d();
                    return;
                }
                return;
            }
            f.this.i();
            if (f.this.l()) {
                if (f.this.f4982d == 3) {
                    f.this.d();
                    if (f.this.f4990l != null) {
                        f.this.f4990l.l();
                        return;
                    }
                    return;
                }
                if (f.this.a()) {
                    return;
                }
                if ((i10 != 0 || f.this.f() > 0) && f.this.f4990l != null) {
                    f.this.f4990l.b(0);
                }
            }
        }
    }

    public class c implements MediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            f.this.f4981c = 5;
            f.this.f4982d = 5;
            if (f.this.f4990l != null) {
                boolean isPlaying = f.this.f4984f.isPlaying();
                int i10 = f.this.f4981c;
                f.this.f4990l.m();
                Log.d(f.this.f4979a, String.format("a=%s,b=%d", Boolean.valueOf(isPlaying), Integer.valueOf(i10)));
            }
            if (f.this.f4991m != null) {
                f.this.f4991m.onCompletion(f.this.f4984f);
            }
        }
    }

    public class d implements MediaPlayer.OnInfoListener {
        public d() {
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
                r0 = 701(0x2bd, float:9.82E-43)
                r1 = 1
                r2 = 0
                if (r6 == r0) goto L40
                r0 = 702(0x2be, float:9.84E-43)
                if (r6 == r0) goto Lc
                r0 = 0
                goto L74
            Lc:
                com.aggmoread.sdk.z.b.t.f r0 = com.aggmoread.sdk.z.b.t.f.this
                java.lang.String r0 = com.aggmoread.sdk.z.b.t.f.m(r0)
                java.lang.String r3 = "onInfo MediaPlayer.MEDIA_INFO_BUFFERING_END"
                android.util.Log.d(r0, r3)
                com.aggmoread.sdk.z.b.t.f r0 = com.aggmoread.sdk.z.b.t.f.this
                com.aggmoread.sdk.z.b.t.f$j r0 = com.aggmoread.sdk.z.b.t.f.j(r0)
                if (r0 == 0) goto L2e
                com.aggmoread.sdk.z.b.t.f r0 = com.aggmoread.sdk.z.b.t.f.this
                com.aggmoread.sdk.z.b.t.f$j r0 = com.aggmoread.sdk.z.b.t.f.j(r0)
                com.aggmoread.sdk.z.b.t.f r3 = com.aggmoread.sdk.z.b.t.f.this
                android.media.MediaPlayer r3 = com.aggmoread.sdk.z.b.t.f.e(r3)
                r0.b(r3)
            L2e:
                com.aggmoread.sdk.z.b.t.f r0 = com.aggmoread.sdk.z.b.t.f.this
                com.aggmoread.sdk.z.b.t.a r0 = com.aggmoread.sdk.z.b.t.f.u(r0)
                if (r0 == 0) goto L73
                com.aggmoread.sdk.z.b.t.f r0 = com.aggmoread.sdk.z.b.t.f.this
                com.aggmoread.sdk.z.b.t.a r0 = com.aggmoread.sdk.z.b.t.f.u(r0)
                r0.g()
                goto L73
            L40:
                com.aggmoread.sdk.z.b.t.f r0 = com.aggmoread.sdk.z.b.t.f.this
                java.lang.String r0 = com.aggmoread.sdk.z.b.t.f.m(r0)
                java.lang.String r3 = "onInfo MediaPlayer.MEDIA_INFO_BUFFERING_START"
                android.util.Log.d(r0, r3)
                com.aggmoread.sdk.z.b.t.f r0 = com.aggmoread.sdk.z.b.t.f.this
                com.aggmoread.sdk.z.b.t.f$j r0 = com.aggmoread.sdk.z.b.t.f.j(r0)
                if (r0 == 0) goto L62
                com.aggmoread.sdk.z.b.t.f r0 = com.aggmoread.sdk.z.b.t.f.this
                com.aggmoread.sdk.z.b.t.f$j r0 = com.aggmoread.sdk.z.b.t.f.j(r0)
                com.aggmoread.sdk.z.b.t.f r3 = com.aggmoread.sdk.z.b.t.f.this
                android.media.MediaPlayer r3 = com.aggmoread.sdk.z.b.t.f.e(r3)
                r0.c(r3)
            L62:
                com.aggmoread.sdk.z.b.t.f r0 = com.aggmoread.sdk.z.b.t.f.this
                com.aggmoread.sdk.z.b.t.a r0 = com.aggmoread.sdk.z.b.t.f.u(r0)
                if (r0 == 0) goto L73
                com.aggmoread.sdk.z.b.t.f r0 = com.aggmoread.sdk.z.b.t.f.this
                com.aggmoread.sdk.z.b.t.a r0 = com.aggmoread.sdk.z.b.t.f.u(r0)
                r0.o()
            L73:
                r0 = 1
            L74:
                com.aggmoread.sdk.z.b.t.f r3 = com.aggmoread.sdk.z.b.t.f.this
                android.media.MediaPlayer$OnInfoListener r3 = com.aggmoread.sdk.z.b.t.f.k(r3)
                if (r3 == 0) goto L8d
                com.aggmoread.sdk.z.b.t.f r3 = com.aggmoread.sdk.z.b.t.f.this
                android.media.MediaPlayer$OnInfoListener r3 = com.aggmoread.sdk.z.b.t.f.k(r3)
                boolean r5 = r3.onInfo(r5, r6, r7)
                if (r5 != 0) goto L8c
                if (r0 == 0) goto L8b
                goto L8c
            L8b:
                r1 = 0
            L8c:
                return r1
            L8d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.z.b.t.f.d.onInfo(android.media.MediaPlayer, int, int):boolean");
        }
    }

    public class e implements MediaPlayer.OnErrorListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            Log.d(f.this.f4979a, "Error: " + i10 + "," + i11);
            f.this.f4981c = -1;
            f.this.f4982d = -1;
            if (f.this.f4990l != null) {
                f.this.f4990l.n();
            }
            if (f.this.f4994p != null) {
                f.this.f4994p.onError(f.this.f4984f, i10, i11);
            }
            return true;
        }
    }

    /* renamed from: com.aggmoread.sdk.z.b.t.f$f */
    public class C0099f implements MediaPlayer.OnBufferingUpdateListener {
        public C0099f() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
            if (f.this.F != null && i10 == 100) {
                f.this.F.g(mediaPlayer);
            }
            f.this.f4993o = i10;
        }
    }

    public class g implements SurfaceHolder.Callback {
        public g() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            com.aggmoread.sdk.z.b.d.c(f.this.f4979a, "surfaceChanged w " + i11 + ", h " + i12 + ", mVideoWidth " + f.this.f4986h + ", mVideoHeight " + f.this.f4987i);
            f.this.f4988j = i11;
            f.this.f4989k = i12;
            boolean z10 = f.this.f4982d == 3;
            boolean l10 = f.this.l();
            if (f.this.f4984f != null && z10 && l10) {
                if (f.this.f4996r != 0) {
                    f fVar = f.this;
                    fVar.a(fVar.f4996r);
                }
                f.this.d();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            com.aggmoread.sdk.z.b.d.c(f.this.f4979a, "surfaceCreated mSeekWhenDestroyed " + f.this.f4997s);
            f.this.f4983e = surfaceHolder;
            if (f.this.f4981c != 4 || f.this.f4984f == null) {
                f.this.o();
            } else {
                f.this.f4984f.setDisplay(f.this.f4983e);
            }
            f.this.k();
            if (f.this.f4997s > 0) {
                f fVar = f.this;
                fVar.a(fVar.f4997s);
                f.this.f4997s = 0;
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            com.aggmoread.sdk.z.b.d.c(f.this.f4979a, "surfaceDestroyed");
            f.this.f4983e = null;
            if (f.this.F != null && f.this.f4981c != 4) {
                f.this.F.f(f.this.f4984f);
            }
            f fVar = f.this;
            fVar.f4997s = fVar.f();
            if (f.this.f4990l != null) {
                f.this.f4990l.e();
            }
            if (f.this.f4981c != 4) {
                f.this.c(true);
            }
            f.this.j();
        }
    }

    public static /* synthetic */ class h {

        /* renamed from: a */
        static final /* synthetic */ int[] f5012a;

        static {
            int[] iArr = new int[i.values().length];
            f5012a = iArr;
            try {
                iArr[i.TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5012a[i.TYPE_SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5012a[i.TYPE_CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5012a[i.TYPE9_16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5012a[i.TYPE3_4.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5012a[i.TYPE5.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5012a[i.TYPE_CLIP_VIDEO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum i {
        TYPE,
        TYPE_SCALE,
        TYPE_CENTER_INSIDE,
        TYPE9_16,
        TYPE3_4,
        TYPE5,
        TYPE_CLIP_VIDEO
    }

    public interface j {
        void a(MediaPlayer mediaPlayer);

        void a(boolean z10);

        void b(MediaPlayer mediaPlayer);

        void c(MediaPlayer mediaPlayer);

        void d(MediaPlayer mediaPlayer);

        void e(MediaPlayer mediaPlayer);

        void f(MediaPlayer mediaPlayer);

        void g(MediaPlayer mediaPlayer);
    }

    public f(Context context) {
        this(context, null);
    }

    private void r() {
        com.aggmoread.sdk.z.b.t.a aVar = this.f4990l;
        if (aVar == null || aVar.c() == a.i.f4939d) {
            if (this.f4990l.i()) {
                this.f4990l.e();
            } else {
                this.f4990l.l();
            }
        }
    }

    @Override // com.aggmoread.sdk.z.b.t.a.g
    public int e() {
        if (n()) {
            return this.f4984f.getDuration();
        }
        return -1;
    }

    @Override // com.aggmoread.sdk.z.b.t.a.g
    public int f() {
        if (n()) {
            return this.f4984f.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.aggmoread.sdk.z.b.t.a.g
    public int g() {
        if (this.f4984f != null) {
            return this.f4993o;
        }
        return 0;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(f.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(f.class.getName());
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        boolean z10 = (i10 == 4 || i10 == 24 || i10 == 25 || i10 == 164 || i10 == 82 || i10 == 5 || i10 == 6) ? false : true;
        if (n() && z10 && this.f4990l != null) {
            if (i10 == 79 || i10 == 85) {
                if (this.f4984f.isPlaying()) {
                    b();
                    this.f4990l.l();
                } else {
                    d();
                    this.f4990l.e();
                }
                return true;
            }
            if (i10 == 126) {
                if (!this.f4984f.isPlaying()) {
                    d();
                    this.f4990l.e();
                }
                return true;
            }
            if (i10 == 86 || i10 == 127) {
                if (this.f4984f.isPlaying()) {
                    b();
                    this.f4990l.l();
                }
                return true;
            }
            r();
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f5004z) {
            a(i10, i11, i.TYPE_CLIP_VIDEO);
        } else {
            a(i10, i11);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!n() || this.f4990l == null) {
            return false;
        }
        r();
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!n() || this.f4990l == null) {
            return false;
        }
        r();
        return false;
    }

    public void p() {
        if (n()) {
            this.f4982d = 3;
        }
    }

    public void q() {
        MediaPlayer mediaPlayer = this.f4984f;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f4984f.release();
            this.f4984f = null;
            this.f4981c = 0;
            this.f4982d = 0;
        }
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void i() {
        if (!this.f5004z || this.D == null) {
            int i10 = this.f4986h;
            int i11 = this.f4987i;
            Log.e(this.f4979a, "videoWidth = " + i10 + ", videoHeight = " + i11);
            getHolder().setFixedSize(i10, i11);
        }
    }

    public void j() {
        com.aggmoread.sdk.z.b.t.h hVar = this.E;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void k() {
        if (this.A && this.E == null) {
            com.aggmoread.sdk.z.b.t.h hVar = new com.aggmoread.sdk.z.b.t.h(this.f5003y);
            this.E = hVar;
            hVar.a(this);
            this.E.c();
        }
    }

    public boolean l() {
        return this.f4986h > 0 && this.f4987i > 0 && this.f4988j > 0 && this.f4989k > 0;
    }

    private void m() {
        this.f4986h = 0;
        this.f4987i = 0;
        getHolder().addCallback(this.N);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f4981c = 0;
        this.f4982d = 0;
    }

    private boolean n() {
        int i10;
        return (this.f4984f == null || (i10 = this.f4981c) == -1 || i10 == 0 || i10 == 1) ? false : true;
    }

    public void o() {
        j jVar;
        Log.e(this.f4979a, "openVideo ");
        if (this.f4980b == null || this.f4983e == null) {
            return;
        }
        ((AudioManager) this.f5003y.getSystemService("audio")).requestAudioFocus(null, 3, 1);
        c(false);
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f4984f = mediaPlayer;
            int i10 = this.f4985g;
            if (i10 != 0) {
                mediaPlayer.setAudioSessionId(i10);
            } else {
                this.f4985g = mediaPlayer.getAudioSessionId();
            }
            this.f4984f.setOnPreparedListener(this.I);
            this.f4984f.setOnVideoSizeChangedListener(this.H);
            this.f4984f.setOnCompletionListener(this.J);
            this.f4984f.setOnErrorListener(this.L);
            this.f4984f.setOnInfoListener(this.K);
            this.f4984f.setOnBufferingUpdateListener(this.M);
            this.f4993o = 0;
            MediaPlayer mediaPlayer2 = this.f4984f;
            float f10 = this.G;
            mediaPlayer2.setVolume(f10, f10);
            this.f4984f.setDataSource(this.f5003y, this.f4980b);
            this.f4984f.setDisplay(this.f4983e);
            this.f4984f.setAudioStreamType(3);
            this.f4984f.setScreenOnWhilePlaying(true);
            this.f4984f.prepareAsync();
            if (this.f4998t.get() && (jVar = this.F) != null) {
                jVar.d(this.f4984f);
            }
            this.f4981c = 1;
            h();
            Log.e(this.f4979a, "openVideo end");
        } catch (IOException e10) {
            Log.w(this.f4979a, "Unable to open content: " + this.f4980b, e10);
            this.f4981c = -1;
            this.f4982d = -1;
            this.L.onError(this.f4984f, 1, 0);
        }
    }

    public f(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4979a = "ApiVideoViewTAG";
        this.f4981c = 0;
        this.f4982d = 0;
        this.f4983e = null;
        this.f4984f = null;
        this.f4998t = new AtomicBoolean();
        this.f5004z = false;
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = null;
        this.G = 1.0f;
        this.H = new a();
        this.I = new b();
        this.J = new c();
        this.K = new d();
        this.L = new e();
        this.M = new C0099f();
        this.N = new g();
        this.f5003y = context;
        m();
    }

    public void c(boolean z10) {
        MediaPlayer mediaPlayer = this.f4984f;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f4984f.reset();
            this.f4984f.release();
            this.f4984f = null;
            this.f4981c = 0;
            if (z10) {
                this.f4982d = 0;
            }
        }
    }

    private void h() {
        com.aggmoread.sdk.z.b.t.a aVar;
        if (this.f4984f == null || (aVar = this.f4990l) == null) {
            return;
        }
        aVar.a(this);
        this.f4990l.setEnabled(n());
        this.f4990l.e();
    }

    @Override // com.aggmoread.sdk.z.b.t.a.g
    public void b() {
        com.aggmoread.sdk.z.b.d.c(this.f4979a, "pause");
        if (n() && this.f4984f.isPlaying()) {
            this.f4984f.pause();
            this.f4981c = 4;
            j jVar = this.F;
            if (jVar != null) {
                jVar.f(this.f4984f);
            }
        }
        this.f4982d = 4;
    }

    @Override // com.aggmoread.sdk.z.b.t.a.g
    public void d() {
        com.aggmoread.sdk.z.b.t.a aVar;
        Log.e(this.f4979a, "start " + this.f4981c);
        if (!this.f5002x && (aVar = this.f4990l) != null) {
            aVar.o();
        }
        if (n()) {
            com.aggmoread.sdk.z.b.t.a aVar2 = this.f4990l;
            if (aVar2 != null && aVar2.c() == a.i.f4938c) {
                this.f4990l.l();
            }
            this.f4984f.start();
            j jVar = this.F;
            if (jVar != null) {
                if (this.f4981c == 4) {
                    jVar.e(this.f4984f);
                } else {
                    jVar.a(this.f4984f);
                }
            }
            this.f4981c = 3;
        }
        this.f4982d = 3;
    }

    public void a(float f10) {
        this.G = f10;
    }

    public void b(boolean z10) {
        MediaPlayer mediaPlayer = this.f4984f;
        if (mediaPlayer != null) {
            float f10 = z10 ? 0.0f : 1.0f;
            mediaPlayer.setVolume(f10, f10);
        }
    }

    @Override // com.aggmoread.sdk.z.b.t.a.g
    public boolean c() {
        return this.f4999u;
    }

    public void d(boolean z10) {
        this.A = z10;
    }

    public void e(boolean z10) {
        this.f5004z = z10;
        invalidate();
    }

    public void a(int i10) {
        if (n()) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f4984f.seekTo(i10, 3);
            } else {
                this.f4984f.seekTo(i10);
            }
            i10 = 0;
        }
        this.f4996r = i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0062, code lost:
    
        if (r1 > r6) goto L105;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = r5.f4979a
            java.lang.String r1 = "onMeasureKeepAspectRatio "
            android.util.Log.e(r0, r1)
            int r0 = r5.f4986h
            int r0 = android.view.View.getDefaultSize(r0, r6)
            int r1 = r5.f4987i
            int r1 = android.view.View.getDefaultSize(r1, r7)
            int r2 = r5.f4986h
            if (r2 <= 0) goto L7f
            int r2 = r5.f4987i
            if (r2 <= 0) goto L7f
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L45
            if (r1 != r2) goto L45
            int r0 = r5.f4986h
            int r1 = r0 * r7
            int r2 = r5.f4987i
            int r3 = r6 * r2
            if (r1 >= r3) goto L3f
            int r0 = r1 / r2
        L3d:
            r1 = r7
            goto L7f
        L3f:
            if (r1 <= r3) goto L64
            int r1 = r3 / r0
        L43:
            r0 = r6
            goto L7f
        L45:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L57
            int r0 = r5.f4987i
            int r0 = r0 * r6
            int r2 = r5.f4986h
            int r0 = r0 / r2
            if (r1 != r3) goto L55
            if (r0 <= r7) goto L55
            goto L64
        L55:
            r1 = r0
            goto L43
        L57:
            if (r1 != r2) goto L68
            int r1 = r5.f4986h
            int r1 = r1 * r7
            int r2 = r5.f4987i
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
            int r2 = r5.f4986h
            int r4 = r5.f4987i
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
            goto L43
        L7f:
            r5.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.z.b.t.f.a(int, int):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        if (r8 < r9) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0041, code lost:
    
        if (r8 < r9) goto L106;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0036. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r8, int r9, com.aggmoread.sdk.z.b.t.f.i r10) {
        /*
            r7 = this;
            int r0 = r7.f4986h
            int r1 = r7.f4987i
            int r2 = android.view.View.getDefaultSize(r0, r8)
            int r3 = android.view.View.getDefaultSize(r1, r9)
            java.lang.String r4 = r7.f4979a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "onMeasureFitXY before width "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r6 = ", height = "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r4, r5)
            if (r0 <= 0) goto L82
            if (r1 <= 0) goto L82
            int[] r4 = com.aggmoread.sdk.z.b.t.f.h.f5012a
            int r10 = r10.ordinal()
            r10 = r4[r10]
            switch(r10) {
                case 1: goto L74;
                case 2: goto L66;
                case 3: goto L84;
                case 4: goto L58;
                case 5: goto L49;
                case 6: goto L44;
                case 7: goto L3a;
                default: goto L39;
            }
        L39:
            goto L82
        L3a:
            int r8 = r0 * r3
            int r9 = r1 * r2
            if (r8 <= r9) goto L41
            goto L71
        L41:
            if (r8 >= r9) goto L82
            goto L6c
        L44:
            int r0 = r0 * r3
            int r0 = r0 / r1
        L47:
            r1 = r3
            goto L84
        L49:
            int r8 = r2 * 3
            int r9 = r3 * 4
            if (r8 >= r9) goto L53
            int r1 = r8 / 4
        L51:
            r0 = r2
            goto L84
        L53:
            if (r8 <= r9) goto L82
            int r0 = r9 / 3
            goto L47
        L58:
            int r8 = r2 * 9
            int r9 = r3 * 16
            if (r8 >= r9) goto L61
            int r1 = r8 / 16
            goto L51
        L61:
            if (r8 <= r9) goto L82
            int r0 = r9 / 9
            goto L47
        L66:
            int r8 = r0 * r3
            int r9 = r1 * r2
            if (r8 <= r9) goto L6f
        L6c:
            int r1 = r9 / r0
            goto L51
        L6f:
            if (r8 >= r9) goto L82
        L71:
            int r0 = r8 / r1
            goto L47
        L74:
            int r9 = r9 * r0
            int r8 = r8 * r1
            if (r9 <= r8) goto L82
            int r8 = r0 * r3
            int r1 = r1 * r2
            if (r8 <= r1) goto L82
            int r1 = r1 / r0
            goto L51
        L82:
            r0 = r2
            goto L47
        L84:
            java.lang.String r8 = r7.f4979a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "onMeasureFitXY final  width "
            r9.append(r10)
            r9.append(r0)
            r9.append(r6)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            android.util.Log.e(r8, r9)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.z.b.t.f.a(int, int, com.aggmoread.sdk.z.b.t.f$i):void");
    }

    @Override // com.aggmoread.sdk.z.b.t.h.c
    public void a(int i10, h.b bVar) {
        if (this.A) {
            if (bVar == h.b.f5036b) {
                a(false, 1);
                return;
            }
            if (bVar == h.b.f5037c) {
                a(false, 7);
            } else if (bVar == h.b.f5038d) {
                a(true, 0);
            } else if (bVar == h.b.f5039e) {
                a(true, 8);
            }
        }
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f4991m = onCompletionListener;
    }

    public void a(MediaPlayer.OnErrorListener onErrorListener) {
        this.f4994p = onErrorListener;
    }

    public void a(MediaPlayer.OnInfoListener onInfoListener) {
        this.f4995q = onInfoListener;
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f4992n = onPreparedListener;
    }

    public void a(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    public void a(Uri uri, Map<String, String> map) {
        com.aggmoread.sdk.z.b.d.c(this.f4979a, "setVideoURI ");
        this.f4980b = uri;
        this.f4996r = 0;
        this.f4997s = 0;
        this.f4998t.set(true);
        o();
        requestLayout();
        invalidate();
    }

    public void a(com.aggmoread.sdk.z.b.t.a aVar) {
        com.aggmoread.sdk.z.b.t.a aVar2 = this.f4990l;
        if (aVar2 != null) {
            aVar2.e();
        }
        this.f4990l = aVar;
        h();
    }

    public void a(i iVar) {
        this.D = iVar;
    }

    public void a(j jVar) {
        this.F = jVar;
    }

    public void a(String str) {
        a(Uri.parse(str));
    }

    @Override // com.aggmoread.sdk.z.b.t.a.g
    public void a(boolean z10) {
        a(z10, !z10 ? 1 : 0);
    }

    public void a(boolean z10, int i10) {
        Activity activity = (Activity) this.f5003y;
        if (z10) {
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
        activity.setRequestedOrientation(i10);
        this.f4990l.a(z10);
        j jVar = this.F;
        if (jVar != null) {
            jVar.a(z10);
        }
    }

    @Override // com.aggmoread.sdk.z.b.t.a.g
    public boolean a() {
        return n() && this.f4984f.isPlaying();
    }
}
