package com.shu.priory.videolib;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.martian.ttbookhd.R;
import com.shu.priory.listener.IFLYVideoListener;
import com.shu.priory.utils.h;
import com.shu.priory.utils.j;
import com.sigmob.sdk.base.k;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class JZPlayer extends FrameLayout implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener {

    /* renamed from: a */
    public static int f17321a = 1;

    /* renamed from: b */
    public static int f17322b;

    /* renamed from: c */
    public static long f17323c;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public com.shu.priory.i.d H;
    public com.shu.priory.i.e I;
    public IFLYVideoListener J;
    public int K;
    public boolean L;
    protected int M;
    protected int N;
    protected AudioManager O;
    protected Handler P;
    protected ScheduledExecutorService Q;
    protected a R;
    protected boolean S;
    private final int T;

    /* renamed from: d */
    public com.shu.priory.videolib.a f17324d;

    /* renamed from: e */
    public Object[] f17325e;

    /* renamed from: f */
    public int f17326f;

    /* renamed from: g */
    public int f17327g;

    /* renamed from: h */
    public int f17328h;

    /* renamed from: i */
    public long f17329i;

    /* renamed from: j */
    public boolean f17330j;

    /* renamed from: k */
    public SeekBar f17331k;

    /* renamed from: l */
    public ImageView f17332l;

    /* renamed from: m */
    public ImageView f17333m;

    /* renamed from: n */
    public ImageView f17334n;

    /* renamed from: o */
    public TextView f17335o;

    /* renamed from: p */
    public TextView f17336p;

    /* renamed from: q */
    public ViewGroup f17337q;

    /* renamed from: r */
    public ViewGroup f17338r;

    /* renamed from: s */
    public AudioManager.OnAudioFocusChangeListener f17339s;

    /* renamed from: t */
    public int f17340t;

    /* renamed from: u */
    public int f17341u;

    /* renamed from: v */
    public int f17342v;

    /* renamed from: w */
    public int f17343w;

    /* renamed from: x */
    public int f17344x;

    /* renamed from: y */
    public int f17345y;

    /* renamed from: z */
    public int f17346z;

    /* renamed from: com.shu.priory.videolib.JZPlayer$1 */
    public class AnonymousClass1 implements AudioManager.OnAudioFocusChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i10) {
            if (i10 != -2) {
                if (i10 != -1) {
                    return;
                }
                JZPlayer.this.c();
                return;
            }
            try {
                JZPlayer c10 = f.c();
                if (c10 == null || c10.f17326f != 3) {
                    return;
                }
                c10.f17332l.performClick();
            } catch (Throwable th2) {
                h.d("JZVideoPlayer", "audio focus" + th2.getMessage());
            }
        }
    }

    public class a extends TimerTask {

        /* renamed from: com.shu.priory.videolib.JZPlayer$a$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                long currentPositionWhenPlaying = JZPlayer.this.getCurrentPositionWhenPlaying();
                long duration = JZPlayer.this.getDuration();
                JZPlayer.this.a((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
            }
        }

        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            JZPlayer jZPlayer = JZPlayer.this;
            int i10 = jZPlayer.f17326f;
            if (i10 == 3 || i10 == 5) {
                jZPlayer.P.post(new Runnable() { // from class: com.shu.priory.videolib.JZPlayer.a.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        long currentPositionWhenPlaying = JZPlayer.this.getCurrentPositionWhenPlaying();
                        long duration = JZPlayer.this.getDuration();
                        JZPlayer.this.a((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
                    }
                });
            }
        }
    }

    public JZPlayer(Context context) {
        super(context);
        this.T = R.animator.fragment_fade_enter;
        this.f17325e = null;
        this.f17326f = -1;
        this.f17327g = -1;
        this.f17328h = 0;
        this.f17329i = 0L;
        this.f17330j = false;
        this.f17339s = new AudioManager.OnAudioFocusChangeListener() { // from class: com.shu.priory.videolib.JZPlayer.1
            public AnonymousClass1() {
            }

            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i10) {
                if (i10 != -2) {
                    if (i10 != -1) {
                        return;
                    }
                    JZPlayer.this.c();
                    return;
                }
                try {
                    JZPlayer c10 = f.c();
                    if (c10 == null || c10.f17326f != 3) {
                        return;
                    }
                    c10.f17332l.performClick();
                } catch (Throwable th2) {
                    h.d("JZVideoPlayer", "audio focus" + th2.getMessage());
                }
            }
        };
        this.D = 0;
        this.E = 0;
        this.F = -1;
        this.G = 0;
        a(context);
    }

    public static void b() {
        f.a().y();
        c.a().g();
        f.d();
    }

    public void A() {
        h.a("JZVideoPlayer", "startProgressTimer");
        B();
        this.Q = Executors.newScheduledThreadPool(1);
        a aVar = new a();
        this.R = aVar;
        this.Q.scheduleAtFixedRate(aVar, 0L, 300L, TimeUnit.MILLISECONDS);
    }

    public void B() {
        h.a("JZVideoPlayer", "cancelProgressTimer");
        ScheduledExecutorService scheduledExecutorService = this.Q;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
        a aVar = this.R;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public void C() {
        this.f17331k.setProgress(0);
        this.f17331k.setSecondaryProgress(0);
        this.f17335o.setText(e.a(0L));
        this.f17336p.setText(e.a(0L));
    }

    public void D() {
        try {
            com.shu.priory.i.d dVar = this.H;
            if (dVar.f17133c > dVar.f17134d) {
                e.a(getContext(), 0);
            } else {
                e.a(getContext(), 1);
            }
            Activity a10 = e.a(getContext());
            if (a10 == null) {
                h.a("JZVideoPlayer", "startWindowFullscreen curActivity is null!");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) a10.findViewById(android.R.id.content);
            View findViewById = viewGroup.findViewById(R.animator.fragment_fade_enter);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            this.f17337q.removeView(c.f17376a);
            JZPlayer jZPlayer = (JZPlayer) getClass().getConstructor(Context.class).newInstance(getContext());
            jZPlayer.setId(R.animator.fragment_fade_enter);
            viewGroup.addView(jZPlayer, new FrameLayout.LayoutParams(-1, -1));
            int i10 = getContext().getApplicationInfo().targetSdkVersion;
            if (i10 >= 19) {
                jZPlayer.setSystemUiVisibility(2054);
            } else if (i10 < 16) {
                jZPlayer.setSystemUiVisibility(2);
            } else {
                jZPlayer.setSystemUiVisibility(6);
            }
            jZPlayer.setVideoInfo(this.H);
            jZPlayer.setVideoType(this.K);
            jZPlayer.setVideoOutListener(this.J);
            jZPlayer.setCurrentVolume(this.f17328h);
            jZPlayer.setVideoTraceState(this.I);
            jZPlayer.a(this.f17324d, 1, this.f17325e);
            jZPlayer.setState(this.f17326f);
            jZPlayer.v();
            f.b(jZPlayer);
            l();
            jZPlayer.f17331k.setSecondaryProgress(this.f17331k.getSecondaryProgress());
            jZPlayer.A();
            f17323c = System.currentTimeMillis();
        } catch (Throwable th2) {
            h.d("JZVideoPlayer", "window full" + th2.getMessage());
        }
    }

    public boolean E() {
        return F() && this.f17324d.a(c.b());
    }

    public boolean F() {
        return f.c() != null && f.c() == this;
    }

    public void G() {
        ImageView imageView;
        int i10;
        int i11 = f.b().f17328h;
        this.f17328h = i11;
        if (i11 != 0) {
            if (i11 == 1) {
                imageView = this.f17334n;
                i10 = this.B;
            }
            this.f17326f = f.b().f17326f;
            y();
            setState(this.f17326f);
            v();
        }
        imageView = this.f17334n;
        i10 = this.C;
        imageView.setImageResource(i10);
        this.f17326f = f.b().f17326f;
        y();
        setState(this.f17326f);
        v();
    }

    public void H() {
    }

    public void I() {
    }

    public void a(int i10, int i11) {
        h.a("JZVideoPlayer", "onError");
        if (i10 == 38 || i11 == -38 || i10 == -38 || i11 == 38 || i11 == -19) {
            return;
        }
        q();
        if (E()) {
            c.a().g();
        }
    }

    public void c() {
        if (System.currentTimeMillis() - f17323c > 300) {
            f.d();
            c.a().f17381f = -1;
            c.a().g();
        }
    }

    public void d() {
        com.shu.priory.i.d dVar;
        JZPlayer c10 = f.c();
        if (c10 == null || c10.f17326f != 5) {
            return;
        }
        c10.o();
        c.f();
        if (this.I.f17161g || (dVar = this.H) == null) {
            return;
        }
        j.a(dVar.f17145o);
        this.I.f17161g = true;
    }

    public void e() {
        int i10;
        com.shu.priory.i.d dVar;
        JZPlayer c10 = f.c();
        if (c10 == null || (i10 = c10.f17326f) == 6 || i10 == 0 || i10 == 7) {
            return;
        }
        c10.p();
        c.e();
        if (this.I.f17160f || (dVar = this.H) == null) {
            return;
        }
        j.a(dVar.f17144n);
        this.I.f17160f = true;
    }

    public void f() {
        JZPlayer c10 = f.c();
        if (c10 != null) {
            c10.H();
            c();
            if (this.I.f17166l) {
                return;
            }
            j.a(this.H.f17150t);
            this.I.f17166l = true;
        }
    }

    public void g() {
        a();
        if (this.I.f17162h) {
            return;
        }
        j.a(this.H.f17146p);
        this.I.f17162h = true;
    }

    public long getCurrentPositionWhenPlaying() {
        int i10 = this.f17326f;
        if (i10 == 3 || i10 == 5) {
            try {
                return c.c();
            } catch (Throwable th2) {
                h.d("JZVideoPlayer", "get position" + th2.getMessage());
            }
        }
        return 0L;
    }

    public long getDuration() {
        try {
            return c.d();
        } catch (Throwable th2) {
            h.d("JZVideoPlayer", "get dur" + th2.getMessage());
            return 0L;
        }
    }

    public abstract int getLayoutId();

    public void h() {
        if (this.I.f17169o) {
            return;
        }
        j.a(this.H.f17153w);
        this.I.f17169o = true;
    }

    public void i() {
        if (this.I.f17170p) {
            return;
        }
        j.a(this.H.f17154x);
        this.I.f17170p = true;
    }

    public void j() {
        f.d();
        u();
        v();
        ((AudioManager) getContext().getSystemService("audio")).requestAudioFocus(this.f17339s, 3, 2);
        Activity a10 = e.a(getContext());
        if (a10 != null) {
            a10.getWindow().addFlags(128);
        }
        c.a(this.f17324d);
        c.a().f17381f = this.F;
        m();
        f.a(this);
    }

    public void k() {
        n();
        o();
        IFLYVideoListener iFLYVideoListener = this.J;
        if (iFLYVideoListener != null) {
            iFLYVideoListener.onVideoStart();
        }
    }

    public void l() {
        h.a("JZVideoPlayer", "onStateNormal");
        this.f17326f = 0;
        B();
    }

    public void m() {
        h.a("JZVideoPlayer", "onStatePreparing");
        this.f17326f = 1;
        C();
    }

    public void n() {
        h.a("JZVideoPlayer", "onStatePrepared");
    }

    public void o() {
        h.a("JZVideoPlayer", "onStatePlaying");
        this.f17326f = 3;
        A();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 != this.f17340t) {
            if (id2 != this.f17341u) {
                if (id2 == this.f17342v) {
                    int i10 = this.f17328h;
                    if (i10 == 0) {
                        setVolume(false);
                        return;
                    } else {
                        if (i10 == 1) {
                            setVolume(true);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.f17326f == 6) {
                return;
            }
            if (this.f17327g == 1) {
                a();
                if (this.I.f17168n) {
                    return;
                }
                j.a(this.H.f17152v);
                this.I.f17168n = true;
                return;
            }
            D();
            if (this.I.f17167m) {
                return;
            }
            j.a(this.H.f17151u);
            this.I.f17167m = true;
            return;
        }
        com.shu.priory.videolib.a aVar = this.f17324d;
        if (aVar == null || aVar.f17370c.isEmpty() || this.f17324d.a() == null) {
            h.a("JZVideoPlayer", "播放地址无效");
            return;
        }
        int i11 = this.f17326f;
        if (i11 == 0) {
            if (this.f17324d.a().toString().startsWith(k.f18193y) || this.f17324d.a().toString().startsWith("/") || com.shu.priory.utils.k.b(getContext()) || !this.L) {
                j();
                return;
            } else {
                I();
                return;
            }
        }
        if (i11 == 3) {
            c.e();
            p();
            if (this.I.f17160f) {
                return;
            }
            j.a(this.H.f17144n);
            this.I.f17160f = true;
            return;
        }
        if (i11 == 5) {
            c.f();
            o();
            if (this.I.f17161g) {
                return;
            }
            j.a(this.H.f17145o);
            this.I.f17161g = true;
            return;
        }
        if (i11 == 6) {
            j();
            if (!this.I.f17165k) {
                j.a(this.H.f17149s);
                this.I.f17165k = true;
            }
            IFLYVideoListener iFLYVideoListener = this.J;
            if (iFLYVideoListener != null) {
                iFLYVideoListener.onVideoReplay();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f17327g == 1) {
            super.onMeasure(i10, i11);
            return;
        }
        if (this.D == 0 || this.E == 0) {
            super.onMeasure(i10, i11);
            return;
        }
        int size = View.MeasureSpec.getSize(i10);
        int i12 = (int) ((size * this.E) / this.D);
        setMeasuredDimension(size, i12);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        B();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        A();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i10 = this.f17326f;
        if (i10 == 3 || i10 == 5) {
            c.a((seekBar.getProgress() * getDuration()) / 100);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public void p() {
        h.a("JZVideoPlayer", "onStatePause");
        this.f17326f = 5;
        A();
    }

    public void q() {
        h.a("JZVideoPlayer", "onStateError");
        this.f17326f = 7;
        B();
    }

    public void r() {
        h.a("JZVideoPlayer", "onStateAutoComplete");
        this.f17326f = 6;
        if (this.K == 0) {
            B();
            this.f17331k.setProgress(100);
            this.f17335o.setText(this.f17336p.getText());
        }
    }

    public void s() {
        h.a("JZVideoPlayer", "onAutoCompletion");
        Runtime.getRuntime().gc();
        r();
        if (this.f17327g == 1 && this.K == 0) {
            a();
        }
        c.a().g();
        Activity a10 = e.a(getContext());
        if (a10 != null) {
            a10.getWindow().clearFlags(128);
        }
        IFLYVideoListener iFLYVideoListener = this.J;
        if (iFLYVideoListener != null) {
            iFLYVideoListener.onVideoComplete();
        }
    }

    public void setBufferProgress(int i10) {
        if (i10 != 0) {
            this.f17331k.setSecondaryProgress(i10);
        }
    }

    public void setCurrentVolume(int i10) {
        this.f17328h = i10;
    }

    public void setDirectJump(boolean z10) {
        this.f17330j = z10;
    }

    public void setShowWifiTip(boolean z10) {
        this.L = z10;
    }

    public void setState(int i10) {
        a(i10, 0, 0);
    }

    public void setVideoInfo(com.shu.priory.i.d dVar) {
        this.H = dVar;
    }

    public void setVideoOutListener(IFLYVideoListener iFLYVideoListener) {
        this.J = iFLYVideoListener;
    }

    public void setVideoTraceState(com.shu.priory.i.e eVar) {
        this.I = eVar;
    }

    public void setVideoType(int i10) {
        this.K = i10;
    }

    public void setVolume(boolean z10) {
        c.a(z10);
        if (z10) {
            this.f17328h = 0;
            this.f17334n.setImageResource(this.C);
            if (this.I.f17163i) {
                return;
            }
            j.a(this.H.f17147q);
            this.I.f17163i = true;
            return;
        }
        this.f17328h = 1;
        this.f17334n.setImageResource(this.B);
        if (this.I.f17164j) {
            return;
        }
        j.a(this.H.f17148r);
        this.I.f17164j = true;
    }

    public void t() {
        h.a("JZVideoPlayer", "onCompletion");
        B();
        l();
        this.f17337q.removeView(c.f17376a);
        c.a().f17382g = 0;
        c.a().f17383h = 0;
        ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(this.f17339s);
        Activity a10 = e.a(getContext());
        if (a10 != null) {
            a10.getWindow().clearFlags(128);
        }
        x();
        e.a(getContext(), f17321a);
        Surface surface = c.f17379d;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture = c.f17378c;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        c.f17376a = null;
        c.f17378c = null;
    }

    public void u() {
        h.a("JZVideoPlayer", "initTextureView");
        w();
        JZTextureView jZTextureView = new JZTextureView(getContext());
        c.f17376a = jZTextureView;
        jZTextureView.setSurfaceTextureListener(c.a());
    }

    public void v() {
        h.a("JZVideoPlayer", "addTextureView");
        this.f17337q.addView(c.f17376a, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void w() {
        h.a("JZVideoPlayer", "removeTextureView");
        c.f17378c = null;
        JZTextureView jZTextureView = c.f17376a;
        if (jZTextureView == null || jZTextureView.getParent() == null) {
            return;
        }
        ((ViewGroup) c.f17376a.getParent()).removeView(c.f17376a);
    }

    public void x() {
        ViewGroup viewGroup;
        View findViewById;
        h.a("JZVideoPlayer", "clearFullscreenLayout");
        Activity a10 = e.a(getContext());
        if (a10 == null || (findViewById = (viewGroup = (ViewGroup) a10.findViewById(android.R.id.content)).findViewById(R.animator.fragment_fade_enter)) == null) {
            return;
        }
        viewGroup.removeView(findViewById);
    }

    public void y() {
        h.a("JZVideoPlayer", "clearFloatScreen");
        e.a(getContext(), f17321a);
        JZPlayer c10 = f.c();
        c10.f17337q.removeView(c.f17376a);
        Activity a10 = e.a(getContext());
        if (a10 != null) {
            ((ViewGroup) a10.findViewById(android.R.id.content)).removeView(c10);
        }
        f.b(null);
    }

    public void z() {
        h.a("JZVideoPlayer", "onVideoSizeChanged");
        JZTextureView jZTextureView = c.f17376a;
        if (jZTextureView != null) {
            int i10 = this.G;
            if (i10 != 0) {
                jZTextureView.setRotation(i10);
            }
            c.f17376a.a(c.a().f17382g, c.a().f17383h);
        }
    }

    public JZPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.T = R.animator.fragment_fade_enter;
        this.f17325e = null;
        this.f17326f = -1;
        this.f17327g = -1;
        this.f17328h = 0;
        this.f17329i = 0L;
        this.f17330j = false;
        this.f17339s = new AudioManager.OnAudioFocusChangeListener() { // from class: com.shu.priory.videolib.JZPlayer.1
            public AnonymousClass1() {
            }

            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i10) {
                if (i10 != -2) {
                    if (i10 != -1) {
                        return;
                    }
                    JZPlayer.this.c();
                    return;
                }
                try {
                    JZPlayer c10 = f.c();
                    if (c10 == null || c10.f17326f != 3) {
                        return;
                    }
                    c10.f17332l.performClick();
                } catch (Throwable th2) {
                    h.d("JZVideoPlayer", "audio focus" + th2.getMessage());
                }
            }
        };
        this.D = 0;
        this.E = 0;
        this.F = -1;
        this.G = 0;
        a(context);
    }

    public void a(int i10, int i11, int i12) {
        if (i10 == 0) {
            l();
            return;
        }
        if (i10 == 1) {
            m();
            return;
        }
        if (i10 == 2) {
            a(i11, i12);
            return;
        }
        if (i10 == 3) {
            o();
            return;
        }
        if (i10 == 5) {
            p();
        } else if (i10 == 6) {
            r();
        } else {
            if (i10 != 7) {
                return;
            }
            q();
        }
    }

    public void b(Context context) {
        this.f17340t = com.shu.priory.R.id.ifly_ad_play_state_btn;
        this.f17341u = com.shu.priory.R.id.ifly_ad_fullscreen_btn;
        this.f17342v = com.shu.priory.R.id.ifly_ad_volume_btn;
        this.f17343w = com.shu.priory.R.id.ifly_ad_cur_time;
        this.f17344x = com.shu.priory.R.id.ifly_ad_bottom_seek_bar;
        this.f17345y = com.shu.priory.R.id.ifly_ad_total_time;
        this.f17346z = com.shu.priory.R.id.ifly_ad_surface_container;
        this.A = com.shu.priory.R.id.ifly_ad_layout_bottom;
        this.B = com.shu.priory.R.drawable.ifly_ad_jz_open_volume;
        this.C = com.shu.priory.R.drawable.ifly_ad_jz_close_volume;
    }

    public void a(int i10, long j10) {
        h.a("JZVideoPlayer", "onStatePreparingChangingUrl");
        this.f17326f = 2;
        this.f17329i = j10;
        com.shu.priory.videolib.a aVar = this.f17324d;
        aVar.f17369b = i10;
        c.a(aVar);
        c.a().h();
    }

    public void a(int i10, long j10, long j11) {
        if (!this.S && i10 != 0) {
            this.f17331k.setProgress(i10);
            if (21 < i10 && i10 < 29 && !this.I.f17156b) {
                j.a(this.H.f17140j);
                this.I.f17156b = true;
            }
            if (46 < i10 && i10 < 54 && !this.I.f17157c) {
                j.a(this.H.f17141k);
                this.I.f17157c = true;
            }
            if (71 < i10 && i10 < 79 && !this.I.f17158d) {
                j.a(this.H.f17142l);
                this.I.f17158d = true;
            }
        }
        if (j10 != 0) {
            this.f17335o.setText(e.a(j10));
        }
        this.f17336p.setText(e.a(j11));
    }

    public void a(Context context) {
        try {
            View.inflate(context, getLayoutId(), this);
            b(context);
            this.f17332l = (ImageView) findViewById(this.f17340t);
            this.f17333m = (ImageView) findViewById(this.f17341u);
            this.f17334n = (ImageView) findViewById(this.f17342v);
            this.f17331k = (SeekBar) findViewById(this.f17344x);
            this.f17335o = (TextView) findViewById(this.f17343w);
            this.f17336p = (TextView) findViewById(this.f17345y);
            this.f17338r = (ViewGroup) findViewById(this.A);
            this.f17337q = (ViewGroup) findViewById(this.f17346z);
            this.f17332l.setOnClickListener(this);
            this.f17333m.setOnClickListener(this);
            this.f17334n.setOnClickListener(this);
            this.f17331k.setOnSeekBarChangeListener(this);
            this.f17338r.setOnClickListener(this);
            this.f17337q.setOnClickListener(this);
            this.f17337q.setOnTouchListener(this);
            this.M = getContext().getResources().getDisplayMetrics().widthPixels;
            this.N = getContext().getResources().getDisplayMetrics().heightPixels;
            this.O = (AudioManager) getContext().getSystemService("audio");
            this.P = new Handler();
            this.I = new com.shu.priory.i.e();
            if (E() && (context instanceof Activity)) {
                f17321a = ((Activity) context).getRequestedOrientation();
            }
        } catch (Throwable th2) {
            h.d("JZVideoPlayer", "jz init" + th2.getMessage());
        }
    }

    public void a(com.shu.priory.videolib.a aVar, int i10, Object... objArr) {
        h.b("JZVideoPlayer", "setUpData " + aVar);
        if (this.f17324d != null && aVar.a() != null && this.f17324d.a(aVar.a())) {
            h.b("JZVideoPlayer", "already set video data");
            return;
        }
        if (F() && aVar.a(c.b())) {
            c.a().g();
        }
        this.f17327g = i10;
        this.f17324d = aVar;
        this.f17325e = objArr;
        aVar.f17374g = objArr;
        l();
    }

    public void a(String str, String str2, int i10, Object... objArr) {
        a(new com.shu.priory.videolib.a(str, str2), i10, objArr);
    }

    public static boolean a() {
        if (System.currentTimeMillis() - f17323c < 300) {
            return false;
        }
        if (f.b() != null) {
            f17323c = System.currentTimeMillis();
            if (f.a().f17324d.a(c.b())) {
                f.a().G();
            } else {
                b();
            }
            return true;
        }
        if (f.a() != null && f.a().f17327g == 1) {
            f17323c = System.currentTimeMillis();
            b();
        }
        return false;
    }
}
