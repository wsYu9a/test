package com.martian.libvideoplayer;

import android.annotation.SuppressLint;
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
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.k;
import ja.i;
import ja.j;
import ja.l;
import ja.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public abstract class JCVideoPlayer extends FrameLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    public static final String J = "JieCaoVideoPlayer";
    public static boolean K = true;
    public static boolean L = true;
    public static int M = 4;
    public static int N = 1;
    public static boolean O = true;
    public static boolean P = false;
    public static final int Q = 33797;
    public static final int R = 33798;
    public static final int S = 80;
    public static final int T = 300;
    public static long U = 0;
    public static final int V = 0;
    public static final int W = 1;

    /* renamed from: a0 */
    public static final int f13017a0 = 2;

    /* renamed from: b0 */
    public static final int f13018b0 = 3;

    /* renamed from: c0 */
    public static final int f13019c0 = 0;

    /* renamed from: d0 */
    public static final int f13020d0 = 1;

    /* renamed from: e0 */
    public static final int f13021e0 = 2;

    /* renamed from: f0 */
    public static final int f13022f0 = 3;

    /* renamed from: g0 */
    public static final int f13023g0 = 4;

    /* renamed from: h0 */
    public static final int f13024h0 = 5;

    /* renamed from: i0 */
    public static final int f13025i0 = 6;

    /* renamed from: j0 */
    public static final int f13026j0 = 7;

    /* renamed from: k0 */
    public static int f13027k0 = -1;

    /* renamed from: l0 */
    public static j f13028l0 = null;

    /* renamed from: m0 */
    public static Timer f13029m0 = null;

    /* renamed from: n0 */
    public static final String f13030n0 = "URL_KEY_DEFAULT";

    /* renamed from: o0 */
    public static long f13031o0;

    /* renamed from: p0 */
    public static AudioManager.OnAudioFocusChangeListener f13032p0 = new AudioManager.OnAudioFocusChangeListener() { // from class: ja.m
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i10) {
            JCVideoPlayer.q(i10);
        }
    };
    public int A;
    public int B;
    public float C;
    public int D;
    public boolean E;
    public LinkedHashMap F;
    public int G;
    public int H;
    public int I;

    /* renamed from: b */
    public int f13033b;

    /* renamed from: c */
    public int f13034c;

    /* renamed from: d */
    public boolean f13035d;

    /* renamed from: e */
    public Map<String, String> f13036e;

    /* renamed from: f */
    public Object[] f13037f;

    /* renamed from: g */
    public int f13038g;

    /* renamed from: h */
    public ImageView f13039h;

    /* renamed from: i */
    public SeekBar f13040i;

    /* renamed from: j */
    public ImageView f13041j;

    /* renamed from: k */
    public TextView f13042k;

    /* renamed from: l */
    public TextView f13043l;

    /* renamed from: m */
    public ViewGroup f13044m;

    /* renamed from: n */
    public ViewGroup f13045n;

    /* renamed from: o */
    public ViewGroup f13046o;

    /* renamed from: p */
    public int f13047p;

    /* renamed from: q */
    public int f13048q;

    /* renamed from: r */
    public AudioManager f13049r;

    /* renamed from: s */
    public Handler f13050s;

    /* renamed from: t */
    public b f13051t;

    /* renamed from: u */
    public boolean f13052u;

    /* renamed from: v */
    public float f13053v;

    /* renamed from: w */
    public float f13054w;

    /* renamed from: x */
    public boolean f13055x;

    /* renamed from: y */
    public boolean f13056y;

    /* renamed from: z */
    public boolean f13057z;

    public static class a implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            if (((f10 <= -15.0f || f10 >= -10.0f) && (f10 >= 15.0f || f10 <= 10.0f)) || Math.abs(f11) >= 1.5d || System.currentTimeMillis() - JCVideoPlayer.f13031o0 <= y.f.f18076n) {
                return;
            }
            if (o.b() != null) {
                o.b().c(f10);
            }
            JCVideoPlayer.f13031o0 = System.currentTimeMillis();
        }
    }

    public class b extends TimerTask {
        public b() {
        }

        public final /* synthetic */ void b() {
            int currentPositionWhenPlaying = JCVideoPlayer.this.getCurrentPositionWhenPlaying();
            int duration = JCVideoPlayer.this.getDuration();
            JCVideoPlayer.this.M((currentPositionWhenPlaying * 100) / (duration == 0 ? 1 : duration), currentPositionWhenPlaying, duration);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            JCVideoPlayer jCVideoPlayer = JCVideoPlayer.this;
            int i10 = jCVideoPlayer.f13033b;
            if (i10 == 3 || i10 == 5 || i10 == 4) {
                jCVideoPlayer.f13050s.post(new Runnable() { // from class: ja.n
                    public /* synthetic */ n() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        JCVideoPlayer.b.this.b();
                    }
                });
            }
        }
    }

    public JCVideoPlayer(Context context) {
        super(context);
        this.f13033b = -1;
        this.f13034c = -1;
        this.f13035d = false;
        this.f13037f = null;
        this.f13038g = 0;
        this.E = true;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        n(context);
    }

    public static void J() {
        Log.d(J, "releaseAllVideos");
        o.a();
        i.i().r();
    }

    @SuppressLint({"RestrictedApi"})
    public static void S(Context context) {
        ActionBar supportActionBar;
        if (K && (supportActionBar = l.c(context).getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.show();
        }
        if (L) {
            l.c(context).getWindow().clearFlags(1024);
        }
    }

    public static void V(Context context, Class cls, String str, Object... objArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("URL_KEY_DEFAULT", str);
        W(context, cls, linkedHashMap, 0, objArr);
    }

    public static void W(Context context, Class cls, LinkedHashMap linkedHashMap, int i10, Object... objArr) {
        m(context);
        l.c(context).setRequestedOrientation(M);
        ViewGroup viewGroup = (ViewGroup) l.j(context).findViewById(android.R.id.content);
        View findViewById = viewGroup.findViewById(Q);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        try {
            JCVideoPlayer jCVideoPlayer = (JCVideoPlayer) cls.getConstructor(Context.class).newInstance(context);
            jCVideoPlayer.setId(Q);
            viewGroup.addView(jCVideoPlayer, new FrameLayout.LayoutParams(-1, -1));
            jCVideoPlayer.P(linkedHashMap, i10, 2, objArr);
            U = System.currentTimeMillis();
            jCVideoPlayer.f13039h.performClick();
        } catch (InstantiationException e10) {
            e10.printStackTrace();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static boolean e() {
        Log.i(J, "backPress");
        if (System.currentTimeMillis() - U < 300) {
            return false;
        }
        if (o.d() != null) {
            U = System.currentTimeMillis();
            JCVideoPlayer d10 = o.d();
            d10.u(d10.f13034c == 2 ? 8 : 10);
            o.c().H();
            return true;
        }
        if (o.c() == null || !(o.c().f13034c == 2 || o.c().f13034c == 3)) {
            return false;
        }
        U = System.currentTimeMillis();
        o.b().f13033b = 0;
        o.c().g();
        i.i().r();
        o.e(null);
        return true;
    }

    public static void i(Context context, String str) {
        l.a(context, str);
    }

    @SuppressLint({"RestrictedApi"})
    public static void m(Context context) {
        ActionBar supportActionBar;
        if (K && (supportActionBar = l.c(context).getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.hide();
        }
        if (L) {
            l.c(context).getWindow().setFlags(1024, 1024);
        }
    }

    public static /* synthetic */ void q(int i10) {
        if (i10 != -2) {
            if (i10 != -1) {
                return;
            }
            J();
            return;
        }
        try {
            if (i.i().f27272b == null || !i.i().f27272b.isPlaying()) {
                return;
            }
            i.i().f27272b.pause();
        } catch (IllegalStateException e10) {
            e10.printStackTrace();
        }
    }

    public static void setJcUserAction(j jVar) {
        f13028l0 = jVar;
    }

    public void A() {
        Log.i(J, "onStateNormal  [" + hashCode() + "] ");
        this.f13033b = 0;
        f();
        if (p()) {
            i.i().r();
        }
    }

    public void B() {
        Log.i(J, "onStatePause  [" + hashCode() + "] ");
        this.f13033b = 5;
        X();
    }

    public void C() {
        Log.i(J, "onStatePlaybackBufferingStart  [" + hashCode() + "] ");
        this.f13033b = 4;
        X();
    }

    public void D() {
        Log.i(J, "onStatePlaying  [" + hashCode() + "] ");
        this.f13033b = 3;
        X();
    }

    public void E() {
        Log.i(J, "onStatePreparing  [" + hashCode() + "] ");
        this.f13033b = 1;
        L();
    }

    public void F(int i10, int i11) {
        this.f13033b = 2;
        this.G = i10;
        this.f13038g = i11;
        i.f27267l = l.d(this.F, i10);
        i.f27268m = this.f13035d;
        i.f27269n = this.f13036e;
        i.i().q();
    }

    public void G() {
        Log.i(J, "onVideoSizeChanged  [" + hashCode() + "] ");
        JCResizeTextureView jCResizeTextureView = i.f27265j;
        if (jCResizeTextureView != null) {
            jCResizeTextureView.setVideoSize(i.i().h());
        }
    }

    public void H() {
        Log.i(J, "playOnThisJcvd  [" + hashCode() + "] ");
        this.f13033b = o.d().f13033b;
        g();
        setState(this.f13033b);
        b();
    }

    public void I() {
        if (!l.d(this.F, this.G).equals(i.f27267l) || System.currentTimeMillis() - U <= 300) {
            return;
        }
        if (o.d() == null || o.d().f13034c != 2) {
            if (o.d() == null && o.c() != null && o.c().f13034c == 2) {
                return;
            }
            Log.d(J, "release [" + hashCode() + "]");
            J();
        }
    }

    public void K() {
        i.f27266k = null;
        JCResizeTextureView jCResizeTextureView = i.f27265j;
        if (jCResizeTextureView == null || jCResizeTextureView.getParent() == null) {
            return;
        }
        ((ViewGroup) i.f27265j.getParent()).removeView(i.f27265j);
    }

    public void L() {
        this.f13040i.setProgress(0);
        this.f13040i.setSecondaryProgress(0);
        this.f13042k.setText(l.k(0));
        this.f13043l.setText(l.k(0));
    }

    public void M(int i10, int i11, int i12) {
        if (!this.f13052u && i10 != 0) {
            this.f13040i.setProgress(i10);
        }
        if (i11 != 0) {
            this.f13042k.setText(l.k(i11));
        }
        this.f13043l.setText(l.k(i12));
    }

    public void N(int i10, int i11, int i12) {
        switch (i10) {
            case 0:
                A();
                break;
            case 1:
                E();
                break;
            case 2:
                F(i11, i12);
                break;
            case 3:
                D();
                break;
            case 4:
                C();
                break;
            case 5:
                B();
                break;
            case 6:
                y();
                break;
            case 7:
                z();
                break;
        }
    }

    public void O(String str, int i10, Object... objArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("URL_KEY_DEFAULT", str);
        P(linkedHashMap, 0, i10, objArr);
    }

    public void P(LinkedHashMap linkedHashMap, int i10, int i11, Object... objArr) {
        this.F = linkedHashMap;
        this.G = i10;
        this.f13034c = i11;
        this.f13037f = objArr;
        this.f13036e = null;
        A();
    }

    public void Q(int i10) {
    }

    public void R(float f10, String str, int i10, String str2, int i11) {
    }

    public void T(float f10, int i10) {
    }

    public void U(int i10) {
    }

    public void X() {
        f();
        f13029m0 = new Timer();
        b bVar = new b();
        this.f13051t = bVar;
        f13029m0.schedule(bVar, 0L, 300L);
    }

    public void Y() {
        o.a();
        Log.d(J, "startVideo [" + hashCode() + "] ");
        o();
        b();
        ((AudioManager) getContext().getSystemService("audio")).requestAudioFocus(f13032p0, 3, 2);
        l.j(getContext()).getWindow().addFlags(128);
        i.f27267l = l.d(this.F, this.G);
        i.f27268m = this.f13035d;
        i.f27269n = this.f13036e;
        E();
        o.e(this);
    }

    public void Z() {
        Log.i(J, "startWindowFullscreen  [" + hashCode() + "] ");
        m(getContext());
        l.c(getContext()).setRequestedOrientation(M);
        ViewGroup viewGroup = (ViewGroup) l.j(getContext()).findViewById(android.R.id.content);
        View findViewById = viewGroup.findViewById(Q);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        this.f13044m.removeView(i.f27265j);
        try {
            JCVideoPlayer jCVideoPlayer = (JCVideoPlayer) getClass().getConstructor(Context.class).newInstance(getContext());
            jCVideoPlayer.setId(Q);
            viewGroup.addView(jCVideoPlayer, new FrameLayout.LayoutParams(-1, -1));
            jCVideoPlayer.P(this.F, this.G, 2, this.f13037f);
            jCVideoPlayer.setState(this.f13033b);
            jCVideoPlayer.b();
            o.f(jCVideoPlayer);
            A();
            U = System.currentTimeMillis();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void a0() {
        Log.i(J, "startWindowTiny  [" + hashCode() + "] ");
        u(9);
        int i10 = this.f13033b;
        if (i10 == 0 || i10 == 7) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) l.j(getContext()).findViewById(android.R.id.content);
        View findViewById = viewGroup.findViewById(R);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        this.f13044m.removeView(i.f27265j);
        try {
            JCVideoPlayer jCVideoPlayer = (JCVideoPlayer) getClass().getConstructor(Context.class).newInstance(getContext());
            jCVideoPlayer.setId(R);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(400, 400);
            layoutParams.gravity = 85;
            viewGroup.addView(jCVideoPlayer, layoutParams);
            jCVideoPlayer.P(this.F, this.G, 3, this.f13037f);
            jCVideoPlayer.setState(this.f13033b);
            jCVideoPlayer.b();
            o.f(jCVideoPlayer);
            A();
        } catch (InstantiationException e10) {
            e10.printStackTrace();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void b() {
        Log.d(J, "addTextureView [" + hashCode() + "] ");
        this.f13044m.addView(i.f27265j, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void c(float f10) {
        int i10;
        if (!p() || this.f13033b != 3 || (i10 = this.f13034c) == 2 || i10 == 3) {
            return;
        }
        if (f10 > 0.0f) {
            l.c(getContext()).setRequestedOrientation(0);
        } else {
            l.c(getContext()).setRequestedOrientation(8);
        }
        u(7);
        Z();
    }

    public void d() {
        if (System.currentTimeMillis() - f13031o0 > y.f.f18076n && p() && this.f13033b == 3 && this.f13034c == 2) {
            f13031o0 = System.currentTimeMillis();
            e();
        }
    }

    public void f() {
        Timer timer = f13029m0;
        if (timer != null) {
            timer.cancel();
        }
        b bVar = this.f13051t;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public void g() {
        l.c(getContext()).setRequestedOrientation(N);
        S(getContext());
        JCVideoPlayer b10 = o.b();
        b10.f13044m.removeView(i.f27265j);
        ((ViewGroup) l.j(getContext()).findViewById(android.R.id.content)).removeView(b10);
        o.f(null);
    }

    public int getCurrentPositionWhenPlaying() {
        if (i.i().f27272b == null) {
            return 0;
        }
        int i10 = this.f13033b;
        if (i10 != 3 && i10 != 5 && i10 != 4) {
            return 0;
        }
        try {
            return i.i().f27272b.getCurrentPosition();
        } catch (IllegalStateException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public int getDuration() {
        if (i.i().f27272b == null) {
            return 0;
        }
        try {
            return i.i().f27272b.getDuration();
        } catch (IllegalStateException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public abstract int getLayoutId();

    public void h() {
        if (this.E) {
            ViewGroup viewGroup = (ViewGroup) l.j(getContext()).findViewById(android.R.id.content);
            View findViewById = viewGroup.findViewById(Q);
            View findViewById2 = viewGroup.findViewById(R);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
            S(getContext());
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }

    public void n(Context context) {
        View.inflate(context, getLayoutId(), this);
        this.f13039h = (ImageView) findViewById(R.id.start);
        this.f13041j = (ImageView) findViewById(R.id.fullscreen);
        this.f13040i = (SeekBar) findViewById(R.id.bottom_seek_progress);
        this.f13042k = (TextView) findViewById(R.id.current);
        this.f13043l = (TextView) findViewById(R.id.total);
        this.f13046o = (ViewGroup) findViewById(R.id.layout_bottom);
        this.f13044m = (ViewGroup) findViewById(R.id.surface_container);
        this.f13045n = (ViewGroup) findViewById(R.id.layout_top);
        this.f13039h.setOnClickListener(this);
        this.f13041j.setOnClickListener(this);
        this.f13040i.setOnSeekBarChangeListener(this);
        this.f13046o.setOnClickListener(this);
        this.f13044m.setOnClickListener(this);
        this.f13044m.setOnTouchListener(this);
        this.f13047p = getContext().getResources().getDisplayMetrics().widthPixels;
        this.f13048q = getContext().getResources().getDisplayMetrics().heightPixels;
        this.f13049r = (AudioManager) getContext().getSystemService("audio");
        this.f13050s = new Handler();
        try {
            if (p()) {
                N = ((AppCompatActivity) context).getRequestedOrientation();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void o() {
        K();
        JCResizeTextureView jCResizeTextureView = new JCResizeTextureView(getContext());
        i.f27265j = jCResizeTextureView;
        jCResizeTextureView.setSurfaceTextureListener(i.i());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 != R.id.start) {
            if (id2 != R.id.fullscreen) {
                if (id2 == R.id.surface_container && this.f13033b == 7) {
                    Log.i(J, "onClick surfaceContainer State=Error [" + hashCode() + "] ");
                    Y();
                    return;
                }
                return;
            }
            Log.i(J, "onClick fullscreen [" + hashCode() + "] ");
            if (this.f13033b == 6) {
                return;
            }
            if (this.f13034c == 2) {
                e();
                return;
            }
            Log.d(J, "toFullscreenActivity [" + hashCode() + "] ");
            u(7);
            Z();
            return;
        }
        Log.i(J, "onClick start [" + hashCode() + "] ");
        if (TextUtils.isEmpty(l.d(this.F, this.G))) {
            Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
            return;
        }
        int i10 = this.f13033b;
        if (i10 == 0 || i10 == 7) {
            if (!l.d(this.F, this.G).startsWith(k.f18193y) && !l.d(this.F, this.G).startsWith("/") && !l.h(getContext()) && !P) {
                U(0);
                return;
            } else {
                Y();
                u(this.f13033b == 7 ? 1 : 0);
                return;
            }
        }
        if (i10 == 3) {
            u(3);
            Log.d(J, "pauseVideo [" + hashCode() + "] ");
            i.i().f27272b.pause();
            B();
            return;
        }
        if (i10 == 5) {
            u(4);
            i.i().f27272b.start();
            D();
        } else if (i10 == 6) {
            u(2);
            Y();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.f13034c;
        if (i12 == 2 || i12 == 3) {
            super.onMeasure(i10, i11);
            return;
        }
        if (this.H == 0 || this.I == 0) {
            try {
                super.onMeasure(i10, i11);
                return;
            } catch (ClassCastException unused) {
                return;
            }
        }
        int size = View.MeasureSpec.getSize(i10);
        int i13 = (int) ((size * this.I) / this.H);
        setMeasuredDimension(size, i13);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Log.i(J, "bottomProgress onStartTrackingTouch [" + hashCode() + "] ");
        f();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.i(J, "bottomProgress onStopTrackingTouch [" + hashCode() + "] ");
        u(5);
        X();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i10 = this.f13033b;
        if (i10 == 3 || i10 == 5) {
            int progress = (seekBar.getProgress() * getDuration()) / 100;
            i.i().f27272b.seekTo(progress);
            Log.i(J, "seekTo " + progress + " [" + hashCode() + "] ");
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (view.getId() == R.id.surface_container) {
            int action = motionEvent.getAction();
            if (action == 0) {
                Log.i(J, "onTouch surfaceContainer actionDown [" + hashCode() + "] ");
                this.f13052u = true;
                this.f13053v = x10;
                this.f13054w = y10;
                this.f13055x = false;
                this.f13056y = false;
                this.f13057z = false;
            } else if (action == 1) {
                Log.i(J, "onTouch surfaceContainer actionUp [" + hashCode() + "] ");
                this.f13052u = false;
                k();
                l();
                j();
                if (this.f13056y) {
                    u(12);
                    i.i().f27272b.seekTo(this.D);
                    int duration = getDuration();
                    this.f13040i.setProgress((this.D * 100) / (duration != 0 ? duration : 1));
                }
                if (this.f13055x) {
                    u(11);
                }
                X();
            } else if (action == 2) {
                Log.i(J, "onTouch surfaceContainer actionMove [" + hashCode() + "] ");
                float f10 = x10 - this.f13053v;
                float f11 = y10 - this.f13054w;
                float abs = Math.abs(f10);
                float abs2 = Math.abs(f11);
                if (this.f13034c == 2 && !this.f13056y && !this.f13055x && !this.f13057z && (abs > 80.0f || abs2 > 80.0f)) {
                    f();
                    if (abs >= 80.0f) {
                        if (this.f13033b != 7) {
                            this.f13056y = true;
                            this.A = getCurrentPositionWhenPlaying();
                        }
                    } else if (this.f13053v < this.f13047p * 0.5f) {
                        this.f13057z = true;
                        float f12 = l.c(getContext()).getWindow().getAttributes().screenBrightness;
                        if (f12 < 0.0f) {
                            try {
                                this.C = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness");
                                Log.i(J, "current system brightness: " + this.C);
                            } catch (Settings.SettingNotFoundException e10) {
                                e10.printStackTrace();
                            }
                        } else {
                            this.C = f12 * 255.0f;
                            Log.i(J, "current activity brightness: " + this.C);
                        }
                    } else {
                        this.f13055x = true;
                        this.B = this.f13049r.getStreamVolume(3);
                    }
                }
                if (this.f13056y) {
                    int duration2 = getDuration();
                    int i10 = (int) (this.A + ((duration2 * f10) / this.f13047p));
                    this.D = i10;
                    if (i10 > duration2) {
                        this.D = duration2;
                    }
                    R(f10, l.k(this.D), this.D, l.k(duration2), duration2);
                }
                if (this.f13055x) {
                    f11 = -f11;
                    this.f13049r.setStreamVolume(3, this.B + ((int) (((this.f13049r.getStreamMaxVolume(3) * f11) * 3.0f) / this.f13048q)), 0);
                    T(-f11, (int) (((this.B * 100) / r0) + (((f11 * 3.0f) * 100.0f) / this.f13048q)));
                }
                if (this.f13057z) {
                    float f13 = -f11;
                    WindowManager.LayoutParams attributes = l.c(getContext()).getWindow().getAttributes();
                    float f14 = this.C;
                    float f15 = (int) (((f13 * 255.0f) * 3.0f) / this.f13048q);
                    if ((f14 + f15) / 255.0f >= 1.0f) {
                        attributes.screenBrightness = 1.0f;
                    } else if ((f14 + f15) / 255.0f <= 0.0f) {
                        attributes.screenBrightness = 0.01f;
                    } else {
                        attributes.screenBrightness = (f14 + f15) / 255.0f;
                    }
                    l.c(getContext()).getWindow().setAttributes(attributes);
                    Q((int) (((this.C * 100.0f) / 255.0f) + (((f13 * 3.0f) * 100.0f) / this.f13048q)));
                }
            }
        }
        return false;
    }

    public boolean p() {
        return o.b() != null && o.b() == this;
    }

    public void r() {
        Runtime.getRuntime().gc();
        Log.i(J, "onAutoCompletion  [" + hashCode() + "] ");
        u(6);
        l();
        k();
        j();
        f();
        y();
        if (this.f13034c == 2) {
            e();
        }
        l.i(getContext(), l.d(this.F, this.G), 0);
    }

    public void s() {
        Log.i(J, "onCompletion  [" + hashCode() + "] ");
        int i10 = this.f13033b;
        if (i10 == 3 || i10 == 5) {
            l.i(getContext(), l.d(this.F, this.G), getCurrentPositionWhenPlaying());
        }
        f();
        A();
        this.f13044m.removeView(i.f27265j);
        i.i().f27273c = 0;
        i.i().f27274d = 0;
        ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(f13032p0);
        l.j(getContext()).getWindow().clearFlags(128);
        h();
        l.c(getContext()).setRequestedOrientation(N);
        i.f27265j = null;
        i.f27266k = null;
    }

    public void setBufferProgress(int i10) {
        if (i10 != 0) {
            this.f13040i.setSecondaryProgress(i10);
        }
    }

    public void setClearFullScreenStatus(boolean z10) {
        this.E = z10;
    }

    public void setState(int i10) {
        N(i10, 0, 0);
    }

    public void t(int i10, int i11) {
        Log.e(J, "onError " + i10 + " - " + i11 + " [" + hashCode() + "] ");
        if (i10 == 38 || i10 == -38 || i11 == -38) {
            return;
        }
        z();
        if (p()) {
            i.i().r();
        }
    }

    public void u(int i10) {
        LinkedHashMap linkedHashMap;
        if (f13028l0 == null || !p() || (linkedHashMap = this.F) == null) {
            return;
        }
        f13028l0.a(i10, l.d(linkedHashMap, this.G), this.f13034c, this.f13037f);
    }

    public void v(int i10, int i11) {
        Log.d(J, "onInfo what - " + i10 + " extra - " + i11);
        if (i10 == 701) {
            int i12 = this.f13033b;
            if (i12 == 4) {
                return;
            }
            f13027k0 = i12;
            C();
            Log.d(J, "MEDIA_INFO_BUFFERING_START");
            return;
        }
        if (i10 == 702) {
            int i13 = f13027k0;
            if (i13 != -1) {
                if (this.f13033b == 4) {
                    setState(i13);
                }
                f13027k0 = -1;
            }
            Log.d(J, "MEDIA_INFO_BUFFERING_END");
        }
    }

    public void w() {
        Log.i(J, "onPrepared  [" + hashCode() + "] ");
        int i10 = this.f13033b;
        if (i10 == 1 || i10 == 2 || i10 == 4) {
            if (this.f13038g != 0) {
                i.i().f27272b.seekTo(this.f13038g);
                this.f13038g = 0;
            } else {
                int f10 = l.f(getContext(), l.d(this.F, this.G));
                if (f10 != 0) {
                    i.i().f27272b.seekTo(f10);
                }
            }
            X();
            D();
        }
    }

    public void x() {
    }

    public void y() {
        Log.i(J, "onStateAutoComplete  [" + hashCode() + "] ");
        this.f13033b = 6;
        f();
        this.f13040i.setProgress(100);
        this.f13042k.setText(this.f13043l.getText());
    }

    public void z() {
        Log.i(J, "onStateError  [" + hashCode() + "] ");
        this.f13033b = 7;
        f();
    }

    public JCVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13033b = -1;
        this.f13034c = -1;
        this.f13035d = false;
        this.f13037f = null;
        this.f13038g = 0;
        this.E = true;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        n(context);
    }
}
