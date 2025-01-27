package com.martian.libvideoplayer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.martian.libvideoplayer.JCVideoPlayer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public abstract class JCVideoPlayer extends FrameLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    protected static Timer A = null;
    public static final String B = "URL_KEY_DEFAULT";
    public static long C = 0;
    public static AudioManager.OnAudioFocusChangeListener D = new AudioManager.OnAudioFocusChangeListener() { // from class: com.martian.libvideoplayer.h
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i2) {
            JCVideoPlayer.p(i2);
        }
    };

    /* renamed from: a */
    public static final String f10679a = "JieCaoVideoPlayer";

    /* renamed from: b */
    public static boolean f10680b = true;

    /* renamed from: c */
    public static boolean f10681c = true;

    /* renamed from: d */
    public static int f10682d = 4;

    /* renamed from: e */
    public static int f10683e = 1;

    /* renamed from: f */
    public static boolean f10684f = true;

    /* renamed from: g */
    public static boolean f10685g = false;

    /* renamed from: h */
    public static final int f10686h = 33797;

    /* renamed from: i */
    public static final int f10687i = 33798;

    /* renamed from: j */
    public static final int f10688j = 80;
    public static final int k = 300;
    public static long l = 0;
    public static final int m = 0;
    public static final int n = 1;
    public static final int o = 2;
    public static final int p = 3;
    public static final int q = 0;
    public static final int r = 1;
    public static final int s = 2;
    public static final int t = 3;
    public static final int u = 4;
    public static final int v = 5;
    public static final int w = 6;
    public static final int x = 7;
    public static int y = -1;
    protected static q z;
    public int E;
    public int F;
    public boolean G;
    public Map<String, String> H;
    public Object[] I;
    public int J;
    public ImageView K;
    public SeekBar L;
    public ImageView M;
    public TextView N;
    public TextView O;
    public ViewGroup P;
    public ViewGroup Q;
    public ViewGroup R;
    protected int S;
    protected int T;
    protected AudioManager U;
    protected Handler V;
    protected b W;
    protected boolean a0;
    protected float b0;
    protected float c0;
    protected boolean d0;
    protected boolean e0;
    protected boolean f0;
    protected int g0;
    protected int h0;
    protected float i0;
    protected int j0;
    private boolean k0;
    LinkedHashMap l0;
    int m0;
    public int n0;
    public int o0;

    public static class a implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            float[] fArr = event.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            if (((f2 <= -15.0f || f2 >= -10.0f) && (f2 >= 15.0f || f2 <= 10.0f)) || Math.abs(f3) >= 1.5d || System.currentTimeMillis() - JCVideoPlayer.C <= 2000) {
                return;
            }
            if (u.b() != null) {
                u.b().b(f2);
            }
            JCVideoPlayer.C = System.currentTimeMillis();
        }
    }

    public class b extends TimerTask {
        public b() {
        }

        /* renamed from: c */
        public /* synthetic */ void d() {
            int currentPositionWhenPlaying = JCVideoPlayer.this.getCurrentPositionWhenPlaying();
            int duration = JCVideoPlayer.this.getDuration();
            JCVideoPlayer.this.L((currentPositionWhenPlaying * 100) / (duration == 0 ? 1 : duration), currentPositionWhenPlaying, duration);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            JCVideoPlayer jCVideoPlayer = JCVideoPlayer.this;
            int i2 = jCVideoPlayer.E;
            if (i2 == 3 || i2 == 5 || i2 == 4) {
                jCVideoPlayer.V.post(new Runnable() { // from class: com.martian.libvideoplayer.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        JCVideoPlayer.b.this.d();
                    }
                });
            }
        }
    }

    public JCVideoPlayer(Context context) {
        super(context);
        this.E = -1;
        this.F = -1;
        this.G = false;
        this.I = null;
        this.J = 0;
        this.k0 = true;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = 0;
        m(context);
    }

    public static void I() {
        Log.d(f10679a, "releaseAllVideos");
        u.a();
        p.b().k();
    }

    public static void R(Context context) {
        ActionBar supportActionBar;
        if (f10680b && (supportActionBar = t.c(context).getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.show();
        }
        if (f10681c) {
            t.c(context).getWindow().clearFlags(1024);
        }
    }

    public static void U(Context context, Class _class, String url, Object... objects) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(B, url);
        V(context, _class, linkedHashMap, 0, objects);
    }

    public static void V(Context context, Class _class, LinkedHashMap urlMap, int defaultUrlMapIndex, Object... objects) {
        l(context);
        t.c(context).setRequestedOrientation(f10682d);
        ViewGroup viewGroup = (ViewGroup) t.j(context).findViewById(android.R.id.content);
        View findViewById = viewGroup.findViewById(f10686h);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        try {
            JCVideoPlayer jCVideoPlayer = (JCVideoPlayer) _class.getConstructor(Context.class).newInstance(context);
            jCVideoPlayer.setId(f10686h);
            viewGroup.addView(jCVideoPlayer, new FrameLayout.LayoutParams(-1, -1));
            jCVideoPlayer.O(urlMap, defaultUrlMapIndex, 2, objects);
            l = System.currentTimeMillis();
            jCVideoPlayer.K.performClick();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static boolean d() {
        Log.i(f10679a, "backPress");
        if (System.currentTimeMillis() - l < 300) {
            return false;
        }
        if (u.d() != null) {
            l = System.currentTimeMillis();
            JCVideoPlayer d2 = u.d();
            d2.t(d2.F == 2 ? 8 : 10);
            u.c().G();
            return true;
        }
        if (u.c() == null || !(u.c().F == 2 || u.c().F == 3)) {
            return false;
        }
        l = System.currentTimeMillis();
        u.b().E = 0;
        u.c().f();
        p.b().k();
        u.e(null);
        return true;
    }

    public static void h(Context context, String url) {
        t.a(context, url);
    }

    public static void l(Context context) {
        ActionBar supportActionBar;
        if (f10680b && (supportActionBar = t.c(context).getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.hide();
        }
        if (f10681c) {
            t.c(context).getWindow().setFlags(1024, 1024);
        }
    }

    static /* synthetic */ void p(int focusChange) {
        if (focusChange != -2) {
            if (focusChange != -1) {
                return;
            }
            I();
            return;
        }
        try {
            if (p.b().f10721j == null || !p.b().f10721j.isPlaying()) {
                return;
            }
            p.b().f10721j.pause();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    public static void setJcUserAction(q jcUserEvent) {
        z = jcUserEvent;
    }

    public void A() {
        Log.i(f10679a, "onStatePause  [" + hashCode() + "] ");
        this.E = 5;
        W();
    }

    public void B() {
        Log.i(f10679a, "onStatePlaybackBufferingStart  [" + hashCode() + "] ");
        this.E = 4;
        W();
    }

    public void C() {
        Log.i(f10679a, "onStatePlaying  [" + hashCode() + "] ");
        this.E = 3;
        W();
    }

    public void D() {
        Log.i(f10679a, "onStatePreparing  [" + hashCode() + "] ");
        this.E = 1;
        K();
    }

    public void E(int urlMapIndex, int seekToInAdvance) {
        this.E = 2;
        this.m0 = urlMapIndex;
        this.J = seekToInAdvance;
        p.f10716e = t.d(this.l0, urlMapIndex);
        p.f10717f = this.G;
        p.f10718g = this.H;
        p.b().j();
    }

    public void F() {
        Log.i(f10679a, "onVideoSizeChanged  [" + hashCode() + "] ");
        JCResizeTextureView jCResizeTextureView = p.f10714c;
        if (jCResizeTextureView != null) {
            jCResizeTextureView.setVideoSize(p.b().a());
        }
    }

    public void G() {
        Log.i(f10679a, "playOnThisJcvd  [" + hashCode() + "] ");
        this.E = u.d().E;
        f();
        setState(this.E);
        a();
    }

    public void H() {
        if (!t.d(this.l0, this.m0).equals(p.f10716e) || System.currentTimeMillis() - l <= 300) {
            return;
        }
        if (u.d() == null || u.d().F != 2) {
            if (u.d() == null && u.c() != null && u.c().F == 2) {
                return;
            }
            Log.d(f10679a, "release [" + hashCode() + "]");
            I();
        }
    }

    public void J() {
        p.f10715d = null;
        JCResizeTextureView jCResizeTextureView = p.f10714c;
        if (jCResizeTextureView == null || jCResizeTextureView.getParent() == null) {
            return;
        }
        ((ViewGroup) p.f10714c.getParent()).removeView(p.f10714c);
    }

    public void K() {
        this.L.setProgress(0);
        this.L.setSecondaryProgress(0);
        this.N.setText(t.k(0));
        this.O.setText(t.k(0));
    }

    public void L(int progress, int position, int duration) {
        if (!this.a0 && progress != 0) {
            this.L.setProgress(progress);
        }
        if (position != 0) {
            this.N.setText(t.k(position));
        }
        this.O.setText(t.k(duration));
    }

    public void M(int state, int urlMapIndex, int seekToInAdvance) {
        switch (state) {
            case 0:
                z();
                break;
            case 1:
                D();
                break;
            case 2:
                E(urlMapIndex, seekToInAdvance);
                break;
            case 3:
                C();
                break;
            case 4:
                B();
                break;
            case 5:
                A();
                break;
            case 6:
                x();
                break;
            case 7:
                y();
                break;
        }
    }

    public void N(String url, int screen, Object... objects) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(B, url);
        O(linkedHashMap, 0, screen, objects);
    }

    public void O(LinkedHashMap urlMap, int defaultUrlMapIndex, int screen, Object... objects) {
        this.l0 = urlMap;
        this.m0 = defaultUrlMapIndex;
        this.F = screen;
        this.I = objects;
        this.H = null;
        z();
    }

    public void P(int brightnessPercent) {
    }

    public void Q(float deltaX, String seekTime, int seekTimePosition, String totalTime, int totalTimeDuration) {
    }

    public void S(float deltaY, int volumePercent) {
    }

    public void T(int event) {
    }

    public void W() {
        e();
        A = new Timer();
        b bVar = new b();
        this.W = bVar;
        A.schedule(bVar, 0L, 300L);
    }

    public void X() {
        u.a();
        Log.d(f10679a, "startVideo [" + hashCode() + "] ");
        n();
        a();
        ((AudioManager) getContext().getSystemService("audio")).requestAudioFocus(D, 3, 2);
        t.j(getContext()).getWindow().addFlags(128);
        p.f10716e = t.d(this.l0, this.m0);
        p.f10717f = this.G;
        p.f10718g = this.H;
        D();
        u.e(this);
    }

    public void Y() {
        Log.i(f10679a, "startWindowFullscreen  [" + hashCode() + "] ");
        l(getContext());
        t.c(getContext()).setRequestedOrientation(f10682d);
        ViewGroup viewGroup = (ViewGroup) t.j(getContext()).findViewById(android.R.id.content);
        View findViewById = viewGroup.findViewById(f10686h);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        this.P.removeView(p.f10714c);
        try {
            JCVideoPlayer jCVideoPlayer = (JCVideoPlayer) getClass().getConstructor(Context.class).newInstance(getContext());
            jCVideoPlayer.setId(f10686h);
            viewGroup.addView(jCVideoPlayer, new FrameLayout.LayoutParams(-1, -1));
            jCVideoPlayer.O(this.l0, this.m0, 2, this.I);
            jCVideoPlayer.setState(this.E);
            jCVideoPlayer.a();
            u.f(jCVideoPlayer);
            z();
            l = System.currentTimeMillis();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void Z() {
        Log.i(f10679a, "startWindowTiny  [" + hashCode() + "] ");
        t(9);
        int i2 = this.E;
        if (i2 == 0 || i2 == 7) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) t.j(getContext()).findViewById(android.R.id.content);
        View findViewById = viewGroup.findViewById(f10687i);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        this.P.removeView(p.f10714c);
        try {
            JCVideoPlayer jCVideoPlayer = (JCVideoPlayer) getClass().getConstructor(Context.class).newInstance(getContext());
            jCVideoPlayer.setId(f10687i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(400, 400);
            layoutParams.gravity = 85;
            viewGroup.addView(jCVideoPlayer, layoutParams);
            jCVideoPlayer.O(this.l0, this.m0, 3, this.I);
            jCVideoPlayer.setState(this.E);
            jCVideoPlayer.a();
            u.f(jCVideoPlayer);
            z();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void a() {
        Log.d(f10679a, "addTextureView [" + hashCode() + "] ");
        this.P.addView(p.f10714c, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void b(float x2) {
        int i2;
        if (!o() || this.E != 3 || (i2 = this.F) == 2 || i2 == 3) {
            return;
        }
        if (x2 > 0.0f) {
            t.c(getContext()).setRequestedOrientation(0);
        } else {
            t.c(getContext()).setRequestedOrientation(8);
        }
        t(7);
        Y();
    }

    public void c() {
        if (System.currentTimeMillis() - C > 2000 && o() && this.E == 3 && this.F == 2) {
            C = System.currentTimeMillis();
            d();
        }
    }

    public void e() {
        Timer timer = A;
        if (timer != null) {
            timer.cancel();
        }
        b bVar = this.W;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public void f() {
        t.c(getContext()).setRequestedOrientation(f10683e);
        R(getContext());
        JCVideoPlayer b2 = u.b();
        b2.P.removeView(p.f10714c);
        ((ViewGroup) t.j(getContext()).findViewById(android.R.id.content)).removeView(b2);
        u.f(null);
    }

    public void g() {
        if (this.k0) {
            ViewGroup viewGroup = (ViewGroup) t.j(getContext()).findViewById(android.R.id.content);
            View findViewById = viewGroup.findViewById(f10686h);
            View findViewById2 = viewGroup.findViewById(f10687i);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
            R(getContext());
        }
    }

    public int getCurrentPositionWhenPlaying() {
        if (p.b().f10721j == null) {
            return 0;
        }
        int i2 = this.E;
        if (i2 != 3 && i2 != 5 && i2 != 4) {
            return 0;
        }
        try {
            return p.b().f10721j.getCurrentPosition();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public int getDuration() {
        if (p.b().f10721j == null) {
            return 0;
        }
        try {
            return p.b().f10721j.getDuration();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public abstract int getLayoutId();

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public void m(Context context) {
        View.inflate(context, getLayoutId(), this);
        this.K = (ImageView) findViewById(R.id.start);
        this.M = (ImageView) findViewById(R.id.fullscreen);
        this.L = (SeekBar) findViewById(R.id.bottom_seek_progress);
        this.N = (TextView) findViewById(R.id.current);
        this.O = (TextView) findViewById(R.id.total);
        this.R = (ViewGroup) findViewById(R.id.layout_bottom);
        this.P = (ViewGroup) findViewById(R.id.surface_container);
        this.Q = (ViewGroup) findViewById(R.id.layout_top);
        this.K.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.L.setOnSeekBarChangeListener(this);
        this.R.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.P.setOnTouchListener(this);
        this.S = getContext().getResources().getDisplayMetrics().widthPixels;
        this.T = getContext().getResources().getDisplayMetrics().heightPixels;
        this.U = (AudioManager) getContext().getSystemService("audio");
        this.V = new Handler();
        try {
            if (o()) {
                f10683e = ((AppCompatActivity) context).getRequestedOrientation();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void n() {
        J();
        JCResizeTextureView jCResizeTextureView = new JCResizeTextureView(getContext());
        p.f10714c = jCResizeTextureView;
        jCResizeTextureView.setSurfaceTextureListener(p.b());
    }

    public boolean o() {
        return u.b() != null && u.b() == this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v2) {
        int id = v2.getId();
        if (id != R.id.start) {
            if (id != R.id.fullscreen) {
                if (id == R.id.surface_container && this.E == 7) {
                    Log.i(f10679a, "onClick surfaceContainer State=Error [" + hashCode() + "] ");
                    X();
                    return;
                }
                return;
            }
            Log.i(f10679a, "onClick fullscreen [" + hashCode() + "] ");
            if (this.E == 6) {
                return;
            }
            if (this.F == 2) {
                d();
                return;
            }
            Log.d(f10679a, "toFullscreenActivity [" + hashCode() + "] ");
            t(7);
            Y();
            return;
        }
        Log.i(f10679a, "onClick start [" + hashCode() + "] ");
        if (TextUtils.isEmpty(t.d(this.l0, this.m0))) {
            Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
            return;
        }
        int i2 = this.E;
        if (i2 == 0 || i2 == 7) {
            if (!t.d(this.l0, this.m0).startsWith("file") && !t.d(this.l0, this.m0).startsWith("/") && !t.h(getContext()) && !f10685g) {
                T(0);
                return;
            } else {
                X();
                t(this.E == 7 ? 1 : 0);
                return;
            }
        }
        if (i2 == 3) {
            t(3);
            Log.d(f10679a, "pauseVideo [" + hashCode() + "] ");
            p.b().f10721j.pause();
            A();
            return;
        }
        if (i2 == 5) {
            t(4);
            p.b().f10721j.start();
            C();
        } else if (i2 == 6) {
            t(2);
            X();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i2 = this.F;
        if (i2 == 2 || i2 == 3) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        if (this.n0 == 0 || this.o0 == 0) {
            try {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                return;
            } catch (ClassCastException unused) {
                return;
            }
        }
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int i3 = (int) ((size * this.o0) / this.n0);
        setMeasuredDimension(size, i3);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Log.i(f10679a, "bottomProgress onStartTrackingTouch [" + hashCode() + "] ");
        e();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.i(f10679a, "bottomProgress onStopTrackingTouch [" + hashCode() + "] ");
        t(5);
        W();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i2 = this.E;
        if (i2 == 3 || i2 == 5) {
            int progress = (seekBar.getProgress() * getDuration()) / 100;
            p.b().f10721j.seekTo(progress);
            Log.i(f10679a, "seekTo " + progress + " [" + hashCode() + "] ");
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v2, MotionEvent event) {
        float x2 = event.getX();
        float y2 = event.getY();
        if (v2.getId() == R.id.surface_container) {
            int action = event.getAction();
            if (action == 0) {
                Log.i(f10679a, "onTouch surfaceContainer actionDown [" + hashCode() + "] ");
                this.a0 = true;
                this.b0 = x2;
                this.c0 = y2;
                this.d0 = false;
                this.e0 = false;
                this.f0 = false;
            } else if (action == 1) {
                Log.i(f10679a, "onTouch surfaceContainer actionUp [" + hashCode() + "] ");
                this.a0 = false;
                j();
                k();
                i();
                if (this.e0) {
                    t(12);
                    p.b().f10721j.seekTo(this.j0);
                    int duration = getDuration();
                    this.L.setProgress((this.j0 * 100) / (duration != 0 ? duration : 1));
                }
                if (this.d0) {
                    t(11);
                }
                W();
            } else if (action == 2) {
                Log.i(f10679a, "onTouch surfaceContainer actionMove [" + hashCode() + "] ");
                float f2 = x2 - this.b0;
                float f3 = y2 - this.c0;
                float abs = Math.abs(f2);
                float abs2 = Math.abs(f3);
                if (this.F == 2 && !this.e0 && !this.d0 && !this.f0 && (abs > 80.0f || abs2 > 80.0f)) {
                    e();
                    if (abs >= 80.0f) {
                        if (this.E != 7) {
                            this.e0 = true;
                            this.g0 = getCurrentPositionWhenPlaying();
                        }
                    } else if (this.b0 < this.S * 0.5f) {
                        this.f0 = true;
                        float f4 = t.c(getContext()).getWindow().getAttributes().screenBrightness;
                        if (f4 < 0.0f) {
                            try {
                                this.i0 = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness");
                                Log.i(f10679a, "current system brightness: " + this.i0);
                            } catch (Settings.SettingNotFoundException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            this.i0 = f4 * 255.0f;
                            Log.i(f10679a, "current activity brightness: " + this.i0);
                        }
                    } else {
                        this.d0 = true;
                        this.h0 = this.U.getStreamVolume(3);
                    }
                }
                if (this.e0) {
                    int duration2 = getDuration();
                    int i2 = (int) (this.g0 + ((duration2 * f2) / this.S));
                    this.j0 = i2;
                    if (i2 > duration2) {
                        this.j0 = duration2;
                    }
                    Q(f2, t.k(this.j0), this.j0, t.k(duration2), duration2);
                }
                if (this.d0) {
                    f3 = -f3;
                    this.U.setStreamVolume(3, this.h0 + ((int) (((this.U.getStreamMaxVolume(3) * f3) * 3.0f) / this.T)), 0);
                    S(-f3, (int) (((this.h0 * 100) / r0) + (((f3 * 3.0f) * 100.0f) / this.T)));
                }
                if (this.f0) {
                    float f5 = -f3;
                    WindowManager.LayoutParams attributes = t.c(getContext()).getWindow().getAttributes();
                    float f6 = this.i0;
                    float f7 = (int) (((f5 * 255.0f) * 3.0f) / this.T);
                    if ((f6 + f7) / 255.0f >= 1.0f) {
                        attributes.screenBrightness = 1.0f;
                    } else if ((f6 + f7) / 255.0f <= 0.0f) {
                        attributes.screenBrightness = 0.01f;
                    } else {
                        attributes.screenBrightness = (f6 + f7) / 255.0f;
                    }
                    t.c(getContext()).getWindow().setAttributes(attributes);
                    P((int) (((this.i0 * 100.0f) / 255.0f) + (((f5 * 3.0f) * 100.0f) / this.T)));
                }
            }
        }
        return false;
    }

    public void q() {
        Runtime.getRuntime().gc();
        Log.i(f10679a, "onAutoCompletion  [" + hashCode() + "] ");
        t(6);
        k();
        j();
        i();
        e();
        x();
        if (this.F == 2) {
            d();
        }
        t.i(getContext(), t.d(this.l0, this.m0), 0);
    }

    public void r() {
        Log.i(f10679a, "onCompletion  [" + hashCode() + "] ");
        int i2 = this.E;
        if (i2 == 3 || i2 == 5) {
            t.i(getContext(), t.d(this.l0, this.m0), getCurrentPositionWhenPlaying());
        }
        e();
        z();
        this.P.removeView(p.f10714c);
        p.b().k = 0;
        p.b().l = 0;
        ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(D);
        t.j(getContext()).getWindow().clearFlags(128);
        g();
        t.c(getContext()).setRequestedOrientation(f10683e);
        p.f10714c = null;
        p.f10715d = null;
    }

    public void s(int what, int extra) {
        Log.e(f10679a, "onError " + what + " - " + extra + " [" + hashCode() + "] ");
        if (what == 38 || what == -38 || extra == -38) {
            return;
        }
        y();
        if (o()) {
            p.b().k();
        }
    }

    public void setBufferProgress(int bufferProgress) {
        if (bufferProgress != 0) {
            this.L.setSecondaryProgress(bufferProgress);
        }
    }

    public void setClearFullScreenStatus(boolean clearFullScreenStatus) {
        this.k0 = clearFullScreenStatus;
    }

    public void setState(int state) {
        M(state, 0, 0);
    }

    public void t(int type) {
        LinkedHashMap linkedHashMap;
        if (z == null || !o() || (linkedHashMap = this.l0) == null) {
            return;
        }
        z.a(type, t.d(linkedHashMap, this.m0), this.F, this.I);
    }

    public void u(int what, int extra) {
        Log.d(f10679a, "onInfo what - " + what + " extra - " + extra);
        if (what == 701) {
            int i2 = this.E;
            if (i2 == 4) {
                return;
            }
            y = i2;
            B();
            Log.d(f10679a, "MEDIA_INFO_BUFFERING_START");
            return;
        }
        if (what == 702) {
            int i3 = y;
            if (i3 != -1) {
                if (this.E == 4) {
                    setState(i3);
                }
                y = -1;
            }
            Log.d(f10679a, "MEDIA_INFO_BUFFERING_END");
        }
    }

    public void v() {
        Log.i(f10679a, "onPrepared  [" + hashCode() + "] ");
        int i2 = this.E;
        if (i2 == 1 || i2 == 2 || i2 == 4) {
            if (this.J != 0) {
                p.b().f10721j.seekTo(this.J);
                this.J = 0;
            } else {
                int f2 = t.f(getContext(), t.d(this.l0, this.m0));
                if (f2 != 0) {
                    p.b().f10721j.seekTo(f2);
                }
            }
            W();
            C();
        }
    }

    public void w() {
    }

    public void x() {
        Log.i(f10679a, "onStateAutoComplete  [" + hashCode() + "] ");
        this.E = 6;
        e();
        this.L.setProgress(100);
        this.N.setText(this.O.getText());
    }

    public void y() {
        Log.i(f10679a, "onStateError  [" + hashCode() + "] ");
        this.E = 7;
        e();
    }

    public void z() {
        Log.i(f10679a, "onStateNormal  [" + hashCode() + "] ");
        this.E = 0;
        e();
        if (o()) {
            p.b().k();
        }
    }

    public JCVideoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.E = -1;
        this.F = -1;
        this.G = false;
        this.I = null;
        this.J = 0;
        this.k0 = true;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = 0;
        m(context);
    }
}
