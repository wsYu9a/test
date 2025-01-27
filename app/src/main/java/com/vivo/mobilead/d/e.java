package com.vivo.mobilead.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.vivo.advv.vaf.virtualview.core.IView;
import com.vivo.google.android.exoplayer3.extend.VideoConstant;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.h0;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.x0;
import com.vivo.mobilead.util.z;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class e extends RelativeLayout implements IView {
    private static final String O = e.class.getSimpleName();
    private Field A;
    private SurfaceTexture.OnFrameAvailableListener B;
    private ScheduledExecutorService C;
    private long D;
    private long E;
    private boolean F;
    private List<Long> G;
    private boolean H;
    private long I;
    protected long J;
    private float K;
    private com.vivo.mobilead.d.c L;
    private com.vivo.ad.d.a.a M;
    private BroadcastReceiver N;

    /* renamed from: a */
    private com.vivo.mobilead.d.d f28729a;

    /* renamed from: b */
    private com.vivo.ad.c.e f28730b;

    /* renamed from: c */
    private String f28731c;

    /* renamed from: d */
    private VideoConstant.PlayerType f28732d;

    /* renamed from: e */
    private RelativeLayout.LayoutParams f28733e;

    /* renamed from: f */
    private int f28734f;

    /* renamed from: g */
    private long f28735g;

    /* renamed from: h */
    private int f28736h;

    /* renamed from: i */
    private int f28737i;

    /* renamed from: j */
    private int f28738j;
    private int k;
    private Surface l;
    private SurfaceTexture m;
    private volatile boolean n;
    private volatile boolean o;
    private volatile boolean p;
    private volatile boolean q;
    private volatile boolean r;
    private com.vivo.mobilead.d.b s;
    private com.vivo.mobilead.d.a t;
    private View u;
    private Handler v;
    private ScheduledExecutorService w;
    private boolean x;
    private boolean y;
    private boolean z;

    class a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ int f28739a;

        /* renamed from: b */
        final /* synthetic */ int f28740b;

        /* renamed from: com.vivo.mobilead.d.e$a$a */
        class C0577a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: com.vivo.mobilead.d.e$a$a$a */
            class C0578a extends com.vivo.mobilead.util.f1.b {
                C0578a() {
                }

                @Override // com.vivo.mobilead.util.f1.b
                public void safelyRun() {
                    com.vivo.mobilead.d.a aVar = e.this.t;
                    a aVar2 = a.this;
                    aVar.a(aVar2.f28739a, aVar2.f28740b, "");
                }
            }

            C0577a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (e.this.t != null) {
                    z.b().a(new C0578a());
                }
                e.this.s.f28719f = "" + e.this.f28735g;
                e.this.s.f28718e = 0;
            }
        }

        a(int i2, int i3) {
            this.f28739a = i2;
            this.f28740b = i3;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                if (e.this.f28730b.a() != 0) {
                    e eVar = e.this;
                    eVar.f28735g = eVar.f28730b.a();
                }
                if (h0.K().l() == 0) {
                    e.this.s.f28717d = "" + e.this.f28735g;
                    e.this.p();
                    e.this.n();
                    e.this.v.postDelayed(new C0577a(), 4000L);
                    return;
                }
                e.this.M.onLoading();
                if (!e.this.p) {
                    long a2 = e.this.f28730b.a() + 1500;
                    String str = e.this.f28732d.name() + ":" + e.this.f28730b.a() + ":" + a2 + ":" + h0.K().l();
                    if (TextUtils.isEmpty(e.this.s.f28716c)) {
                        e.this.s.f28716c = str;
                    } else {
                        e.this.s.f28716c = e.this.s.f28716c + ";" + str;
                    }
                    if (a2 >= e.this.f28730b.b()) {
                        e.this.b(this.f28739a, this.f28740b);
                        return;
                    } else {
                        e.this.f28730b.a(a2);
                        e.this.p = true;
                        return;
                    }
                }
                if (e.this.q) {
                    e.this.b(this.f28739a, this.f28740b);
                    return;
                }
                String name = e.this.f28732d.name();
                VideoConstant.PlayerType playerType = e.this.f28732d;
                VideoConstant.PlayerType playerType2 = VideoConstant.PlayerType.ANDROID;
                if (playerType == playerType2) {
                    e.this.setPlayerType(VideoConstant.PlayerType.EXO);
                } else {
                    e.this.setPlayerType(playerType2);
                }
                String str2 = name + ":" + e.this.f28732d.name() + ":" + e.this.f28730b.a() + ":" + h0.K().l();
                if (TextUtils.isEmpty(e.this.s.f28715b)) {
                    e.this.s.f28715b = str2;
                } else {
                    e.this.s.f28715b = e.this.s.f28715b + ";" + str2;
                }
                e.this.p();
                e.this.e();
                e.this.q = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class b extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ int f28744a;

        /* renamed from: b */
        final /* synthetic */ int f28745b;

        b(int i2, int i3) {
            this.f28744a = i2;
            this.f28745b = i3;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            e.this.t.a(this.f28744a, this.f28745b, "");
        }
    }

    class c extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ int f28747a;

        /* renamed from: b */
        final /* synthetic */ int f28748b;

        c(int i2, int i3) {
            this.f28747a = i2;
            this.f28748b = i3;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (e.this.f28733e == null) {
                e.this.f28733e = new RelativeLayout.LayoutParams(-1, -1);
                e.this.f28733e.addRule(13);
            }
            int measuredWidth = e.this.getMeasuredWidth();
            if (measuredWidth <= 0) {
                measuredWidth = e.this.getContext().getResources().getDisplayMetrics().widthPixels;
            }
            int measuredHeight = e.this.getMeasuredHeight();
            if (measuredHeight <= 0) {
                measuredHeight = e.this.getContext().getResources().getDisplayMetrics().heightPixels;
            }
            float min = Math.min(measuredHeight / this.f28748b, measuredWidth / this.f28747a);
            e.this.f28733e.width = (int) (this.f28747a * min);
            e.this.f28733e.height = (int) (min * this.f28748b);
            e.this.f28729a.a().setLayoutParams(e.this.f28733e);
            e.this.f28738j = measuredWidth;
            e.this.k = measuredHeight;
        }
    }

    class d extends com.vivo.mobilead.util.f1.b {
        d() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (e.this.o || e.this.f28730b == null) {
                return;
            }
            e.this.o = true;
            e.this.f28730b.a(e.this.l);
        }
    }

    /* renamed from: com.vivo.mobilead.d.e$e */
    class C0579e extends BroadcastReceiver {
        C0579e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int l = h0.K().l();
            if (l != 0) {
                e.this.s.f28717d = e.this.s.f28717d + ":" + l + ":" + e.this.f28735g + ";";
                e.this.v.removeCallbacksAndMessages(null);
                if (e.this.t != null) {
                    e.this.t.a(l);
                }
            }
        }
    }

    class f implements View.OnTouchListener {

        /* renamed from: a */
        final /* synthetic */ int f28752a;

        /* renamed from: b */
        final /* synthetic */ int f28753b;

        f(int i2, int i3) {
            this.f28752a = i2;
            this.f28753b = i3;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                e.this.K = motionEvent.getY();
                return false;
            }
            if (action != 1) {
                return false;
            }
            return this.f28752a == 0 && this.f28753b > 0 && e.this.K != motionEvent.getY() && e.this.K < ((float) com.vivo.mobilead.util.m.a(e.this.getContext(), (float) this.f28753b));
        }
    }

    class g implements SurfaceTexture.OnFrameAvailableListener {
        g() {
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            e.this.B.onFrameAvailable(surfaceTexture);
            e.this.j();
        }
    }

    class h extends com.vivo.mobilead.util.f1.b {
        h() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (e.this.E == e.this.D && e.this.c()) {
                e.this.F = true;
                return;
            }
            e.this.F = false;
            e eVar = e.this;
            eVar.E = eVar.D;
        }
    }

    class i extends com.vivo.mobilead.util.f1.b {
        i() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                if (e.this.f28734f == 5) {
                    if (e.this.f28730b != null) {
                        e.this.f28730b.f();
                    }
                    if (e.this.t != null) {
                        e.this.t.onVideoResume();
                    }
                    e.this.u.setVisibility(8);
                    e.this.f28734f = 6;
                    e.this.r();
                    e.this.f28729a.a().setKeepScreenOn(true);
                    e.this.t();
                }
            } catch (Exception e2) {
                x0.b(com.vivo.mobilead.util.f1.b.TAG, "" + e2.getMessage());
            }
        }
    }

    class j extends com.vivo.mobilead.util.f1.b {
        j() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                if (e.this.f28730b != null) {
                    e.this.f28730b.a(e.this.f28735g);
                }
                e.this.J = System.currentTimeMillis() - e.this.I;
                if (e.this.t != null) {
                    e.this.t.onVideoStart();
                }
                e.this.f28734f = 4;
                e.this.u.setVisibility(8);
                e.this.r();
                e.this.q = false;
                e.this.p = false;
                e.this.f28729a.a().setKeepScreenOn(true);
                e.this.t();
            } catch (Exception e2) {
                x0.b(com.vivo.mobilead.util.f1.b.TAG, "" + e2.getMessage());
            }
        }
    }

    class k extends com.vivo.mobilead.util.f1.b {
        k() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                if (e.this.f28734f == 4 || e.this.f28734f == 6) {
                    if (e.this.f28730b != null) {
                        e.this.f28730b.c();
                    }
                    if (e.this.t != null) {
                        e.this.t.onVideoPause();
                    }
                    e.this.u.setVisibility(8);
                    e.this.f28734f = 5;
                    e.this.q();
                    e.this.f28729a.a().setKeepScreenOn(false);
                    e.this.u();
                    e.this.j();
                }
            } catch (Exception e2) {
                x0.b(com.vivo.mobilead.util.f1.b.TAG, "" + e2.getMessage());
            }
        }
    }

    class l extends com.vivo.mobilead.util.f1.b {
        l() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            e.this.u.setVisibility(8);
            e.this.f28729a.a().setKeepScreenOn(false);
        }
    }

    class m implements com.vivo.mobilead.d.c {
        m() {
        }

        @Override // com.vivo.mobilead.d.c
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            if (e.this.m != surfaceTexture) {
                e.this.m = surfaceTexture;
                e.this.l = new Surface(surfaceTexture);
                e.this.w();
            }
        }

        @Override // com.vivo.mobilead.d.c
        public void onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            e.this.o = false;
        }

        @Override // com.vivo.mobilead.d.c
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (e.this.l != surfaceHolder.getSurface()) {
                e.this.l = surfaceHolder.getSurface();
                e.this.w();
            }
        }

        @Override // com.vivo.mobilead.d.c
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (e.this.f28730b != null) {
                e.this.f28730b.a((Surface) null);
            }
            e.this.l = null;
            e.this.o = false;
        }
    }

    class n extends com.vivo.mobilead.util.f1.b {

        class a extends com.vivo.mobilead.util.f1.b {
            a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (e.this.t == null || e.this.f28730b == null) {
                    return;
                }
                e.this.t.a(e.this.f28730b.a(), e.this.f28730b.b());
            }
        }

        n() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            e.this.v.post(new a());
        }
    }

    class o implements com.vivo.ad.d.a.a {

        class a extends com.vivo.mobilead.util.f1.b {
            a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                e.this.t.b();
            }
        }

        class b extends com.vivo.mobilead.util.f1.b {
            b() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                e.this.u.setVisibility(0);
            }
        }

        class c extends com.vivo.mobilead.util.f1.b {
            c() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                e.this.u.setVisibility(8);
            }
        }

        class d extends com.vivo.mobilead.util.f1.b {
            d() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                e.this.t.onVideoCompletion();
            }
        }

        o() {
        }

        @Override // com.vivo.ad.d.a.a
        public void a() {
            if (e.this.t != null) {
                e.this.t.a();
            }
        }

        @Override // com.vivo.ad.d.a.a
        public void onCompletion() {
            e.this.y = true;
            e.this.f28734f = 10;
            if (e.this.t != null) {
                e.this.v.post(new d());
            }
            e.this.s.f28718e = 1;
            k0.a(e.this.s.f28714a, e.this.s.f28715b, e.this.s.f28716c, e.this.s.f28717d, e.this.s.f28718e, e.this.s.f28719f, e.this.s.f28720g, e.this.s.f28721h, (List<Long>) (e.this.H ? e.this.G : null));
            e.this.g();
        }

        @Override // com.vivo.ad.d.a.a
        public void onError(int i2, int i3) {
            e.this.y = false;
            e.this.f28734f = 8;
            e.this.c(i2, i3);
            e.this.u();
        }

        @Override // com.vivo.ad.d.a.a
        public void onInfo(int i2, int i3) {
            e.this.f28736h = i2;
            e.this.f28737i = i3;
            if (e.this.r) {
                return;
            }
            e.this.r = true;
            e.this.d(i2, i3);
        }

        @Override // com.vivo.ad.d.a.a
        public void onLoadEnd() {
            e.this.y = false;
            e.this.v.post(new c());
        }

        @Override // com.vivo.ad.d.a.a
        public void onLoading() {
            e.this.y = false;
            e.this.v.post(new b());
        }

        @Override // com.vivo.ad.d.a.a
        public void onPause() {
            e.this.y = false;
            e.this.f28734f = 5;
        }

        @Override // com.vivo.ad.d.a.a
        public void onPrepared() {
            e.this.y = false;
            if (e.this.t != null) {
                e.this.v.post(new a());
            }
            e.this.i();
            e.this.t();
        }

        @Override // com.vivo.ad.d.a.a
        public void onRelease() {
            e.this.y = false;
            e.this.f28734f = 11;
        }

        @Override // com.vivo.ad.d.a.a
        public void onStart() {
            e.this.y = false;
            e.this.f28734f = 4;
        }
    }

    public e(Context context) {
        this(context, null);
    }

    private boolean a(Surface surface) {
        return surface != null;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        layout(i2, i3, i4, i5);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    public int getCurrentPosition() {
        com.vivo.ad.c.e eVar = this.f28730b;
        if (eVar != null) {
            return (int) eVar.a();
        }
        return 0;
    }

    public int getDuration() {
        com.vivo.ad.c.e eVar = this.f28730b;
        if (eVar != null) {
            return (int) eVar.b();
        }
        return 0;
    }

    public int getErrorCurrentPosition() {
        return (int) this.f28735g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public long getStartPlayDuration() {
        return this.J;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        measure(i2, i3);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        onLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        onMeasure(i2, i3);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        super.onLayout(z, i2, i3, i4, i5);
        if (!((this.f28738j == getMeasuredWidth() && this.k == getMeasuredHeight()) ? false : true) || (i6 = this.f28736h) <= 0 || (i7 = this.f28737i) <= 0) {
            return;
        }
        d(i6, i7);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            this.z = c();
            d();
        } else if (this.z) {
            h();
        }
    }

    public void setEnableStuckSwitch(boolean z) {
        this.H = z;
        a();
    }

    public void setLoadingViewVisible(boolean z) {
        View view = this.u;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setMediaCallback(com.vivo.mobilead.d.a aVar) {
        this.t = aVar;
    }

    public void setMute(boolean z) {
        com.vivo.ad.c.e eVar = this.f28730b;
        if (eVar != null) {
            if (z) {
                eVar.a(0.0f);
            } else {
                eVar.a(1.0f);
            }
        }
    }

    public void setNeedLooper(boolean z) {
        this.x = z;
    }

    public void setPlayerType(VideoConstant.PlayerType playerType) {
        this.f28732d = playerType;
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void j() {
        if (this.H) {
            if (this.D != 0 && this.F) {
                this.G.add(Long.valueOf(System.currentTimeMillis() - this.D));
                this.F = false;
            }
            this.D = System.currentTimeMillis();
            s();
        }
    }

    private void k() {
        this.u = new ProgressBar(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.u.setLayoutParams(layoutParams);
        this.u.setVisibility(8);
        addView(this.u);
    }

    private void l() {
        com.vivo.mobilead.d.d dVar = new com.vivo.mobilead.d.d(getContext(), 1);
        this.f28729a = dVar;
        dVar.a(this.L);
        addView(this.f28729a.a());
        setBackgroundColor(-16777216);
    }

    private void m() {
        if (TextUtils.isEmpty(this.f28731c)) {
            return;
        }
        if (this.f28730b != null) {
            g();
        }
        if (this.f28730b == null) {
            com.vivo.ad.c.e eVar = new com.vivo.ad.c.e(getContext(), this.f28732d);
            this.f28730b = eVar;
            eVar.a(this.f28731c);
            this.f28730b.d();
            this.u.setVisibility(0);
        } else {
            com.vivo.ad.d.a.a aVar = this.M;
            if (aVar != null) {
                aVar.onPrepared();
            }
        }
        this.f28730b.a(this.M);
    }

    public void n() {
        if (this.n) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (Build.VERSION.SDK_INT >= 26) {
            getContext().registerReceiver(this.N, intentFilter, 2);
        } else {
            getContext().registerReceiver(this.N, intentFilter);
        }
        this.n = true;
    }

    private void o() {
        ScheduledExecutorService scheduledExecutorService = this.C;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            this.C = null;
        }
    }

    public void p() {
        try {
            com.vivo.ad.c.e eVar = this.f28730b;
            if (eVar != null) {
                eVar.e();
                this.f28730b = null;
            }
            this.o = false;
            this.r = false;
            this.f28734f = 11;
            this.v.post(new l());
            q();
        } catch (Exception e2) {
            x0.b(O, "" + e2.getMessage());
        }
    }

    public void q() {
        try {
            ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
        } catch (Exception unused) {
        }
    }

    public void r() {
        try {
            ((AudioManager) getContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
        } catch (Exception unused) {
        }
    }

    private void s() {
        if (this.C == null) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.C = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.scheduleAtFixedRate(new h(), 0L, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    public void t() {
        if (this.x && this.w == null) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.w = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.scheduleAtFixedRate(new n(), 1000L, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    public void u() {
        try {
            ScheduledExecutorService scheduledExecutorService = this.w;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                this.w = null;
            }
        } catch (Exception unused) {
        }
    }

    private void v() {
        if (this.n) {
            getContext().unregisterReceiver(this.N);
            this.n = false;
        }
    }

    public void w() {
        this.v.post(new d());
    }

    public void g() {
        this.f28735g = 0L;
        u();
        o();
        p();
        v();
    }

    public void h() {
        this.v.post(new i());
    }

    public void i() {
        this.v.post(new j());
    }

    public e(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f28732d = VideoConstant.PlayerType.EXO;
        this.f28734f = 1;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.v = new Handler(Looper.getMainLooper());
        this.x = false;
        this.y = false;
        this.z = true;
        this.G = new ArrayList();
        this.L = new m();
        this.M = new o();
        this.N = new C0579e();
        this.s = new com.vivo.mobilead.d.b();
        l();
        k();
    }

    public void f() {
        j();
    }

    public void d() {
        this.v.post(new k());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x001c A[Catch: Exception -> 0x003b, TryCatch #0 {Exception -> 0x003b, blocks: (B:2:0x0000, B:17:0x001c, B:19:0x0029, B:21:0x0031), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            r4 = this;
            int r0 = r4.f28734f     // Catch: java.lang.Exception -> L3b
            r1 = 2
            r2 = 1
            if (r0 == r1) goto L19
            r1 = 4
            if (r0 == r1) goto L19
            r1 = 5
            if (r0 == r1) goto L19
            r1 = 6
            if (r0 == r1) goto L19
            r1 = 7
            if (r0 == r1) goto L19
            r1 = 9
            if (r0 != r1) goto L17
            goto L19
        L17:
            r0 = 0
            goto L1a
        L19:
            r0 = 1
        L1a:
            if (r0 != 0) goto L56
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L3b
            r4.I = r0     // Catch: java.lang.Exception -> L3b
            r4.m()     // Catch: java.lang.Exception -> L3b
            boolean r0 = r4.o     // Catch: java.lang.Exception -> L3b
            if (r0 != 0) goto L56
            android.view.Surface r0 = r4.l     // Catch: java.lang.Exception -> L3b
            boolean r0 = r4.a(r0)     // Catch: java.lang.Exception -> L3b
            if (r0 == 0) goto L56
            r4.o = r2     // Catch: java.lang.Exception -> L3b
            com.vivo.ad.c.e r0 = r4.f28730b     // Catch: java.lang.Exception -> L3b
            android.view.Surface r1 = r4.l     // Catch: java.lang.Exception -> L3b
            r0.a(r1)     // Catch: java.lang.Exception -> L3b
            goto L56
        L3b:
            r0 = move-exception
            java.lang.String r1 = com.vivo.mobilead.d.e.O
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ""
            r2.append(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.vivo.mobilead.util.x0.b(r1, r0)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.d.e.e():void");
    }

    public void d(int i2, int i3) {
        this.v.post(new c(i2, i3));
    }

    public boolean c() {
        int i2 = this.f28734f;
        return i2 == 4 || i2 == 6;
    }

    public void c(int i2, int i3) {
        a1.e(new a(i2, i3));
    }

    public boolean b() {
        return this.y;
    }

    public void b(int i2, int i3) {
        if (this.t != null) {
            z.b().a(new b(i2, i3));
        }
        if (this.F && this.D != 0) {
            this.G.add(Long.valueOf(System.currentTimeMillis() - this.D));
        }
        this.s.f28719f = "" + this.f28735g;
        com.vivo.mobilead.d.b bVar = this.s;
        bVar.f28718e = 0;
        k0.a(bVar.f28714a, bVar.f28715b, bVar.f28716c, bVar.f28717d, 0, bVar.f28719f, bVar.f28720g, bVar.f28721h, this.H ? this.G : null);
        g();
    }

    public void a() {
        if (this.H) {
            View a2 = this.f28729a.a();
            try {
                if (this.A == null) {
                    Field declaredField = TextureView.class.getDeclaredField("mUpdateListener");
                    declaredField.setAccessible(true);
                    this.A = declaredField;
                }
                if (this.B == null) {
                    this.B = (SurfaceTexture.OnFrameAvailableListener) this.A.get(a2);
                    this.A.set(a2, new g());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(long j2) {
        this.f28735g = j2;
        e();
    }

    public void a(String str, String str2, String str3) {
        this.f28731c = str;
        com.vivo.mobilead.d.b bVar = this.s;
        bVar.f28714a = str;
        bVar.f28720g = str2;
        bVar.f28721h = str3;
    }

    public void a(int i2, int i3) {
        setOnTouchListener(new f(i2, i3));
    }
}
