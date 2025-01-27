package com.vivo.mobilead.unified.base.view.t;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.vivo.ad.h.b.a;
import com.vivo.ad.view.p;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.p;
import com.vivo.mobilead.util.u;
import com.vivo.mobilead.util.u0;
import com.vivo.mobilead.util.x0;
import com.vivo.mobilead.util.y0;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class i extends com.vivo.mobilead.unified.base.view.t.c implements com.vivo.mobilead.unified.base.view.u.b {
    protected BackUrlInfo A;
    protected String B;
    protected int C;
    private boolean D;
    protected int E;
    private String F;
    private boolean G;
    private boolean H;
    protected boolean I;
    private boolean J;
    private boolean K;
    protected boolean L;
    private boolean M;
    private boolean N;
    protected volatile boolean O;
    private ScheduledExecutorService P;
    private Bitmap Q;
    private long R;
    private boolean S;
    private boolean T;
    private int U;
    private int V;
    private Context W;

    /* renamed from: a */
    protected com.vivo.mobilead.d.e f30183a;
    private boolean a0;

    /* renamed from: b */
    protected com.vivo.ad.h.b.l f30184b;
    private boolean b0;

    /* renamed from: c */
    protected com.vivo.mobilead.unified.base.view.t.g f30185c;
    private boolean c0;

    /* renamed from: d */
    private com.vivo.ad.h.b.g f30186d;
    private com.vivo.mobilead.unified.base.view.t.j.c d0;

    /* renamed from: e */
    protected com.vivo.ad.h.b.b f30187e;
    private Handler e0;

    /* renamed from: f */
    protected com.vivo.ad.h.b.a f30188f;
    private long f0;

    /* renamed from: g */
    protected com.vivo.ad.view.c f30189g;
    protected View g0;

    /* renamed from: h */
    private int f30190h;
    protected com.vivo.mobilead.unified.base.view.p.a h0;

    /* renamed from: i */
    private int f30191i;
    protected com.vivo.mobilead.unified.base.view.t.a i0;

    /* renamed from: j */
    private int f30192j;
    private int j0;
    private int k;
    private boolean k0;
    private int l;
    private boolean l0;
    private int m;
    private boolean m0;
    private int n;
    protected com.vivo.ad.view.v n0;
    private int o;
    private boolean o0;
    private int p;
    private int p0;
    private int q;
    private boolean q0;
    private long r;
    private u.b r0;
    private int s;
    private final com.vivo.ad.view.k s0;
    protected MediaListener t;
    private com.vivo.mobilead.unified.base.callback.k t0;
    protected UnifiedVivoRewardVideoAdListener u;
    private p.h u0;
    private boolean v;
    protected boolean w;
    private boolean x;
    private int y;
    protected com.vivo.ad.model.b z;

    class a extends com.vivo.mobilead.util.b1.a.c.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, Bitmap bitmap) {
            i.this.a(bitmap);
        }
    }

    class a0 extends com.vivo.mobilead.util.f1.b {
        a0() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            i iVar = i.this;
            iVar.g0 = iVar.getActionView();
            View view = i.this.g0;
            if (view != null) {
                view.setId(y0.a());
                if (i.this.g0.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) i.this.g0.getLayoutParams()).addRule(2, i.this.h0.getId());
                }
                i iVar2 = i.this;
                iVar2.f30185c.addView(iVar2.g0);
            }
        }
    }

    class b0 extends com.vivo.ad.view.l {
        b0() {
        }

        @Override // com.vivo.ad.view.l
        public void a(View view, int i2, int i3, int i4, int i5, double d2, double d3, boolean z) {
            if (i.this.t0 != null) {
                i.this.t0.c(i4, i5, 0.0d, 0.0d);
            }
        }
    }

    class c implements a.InterfaceC0559a {
        c() {
        }

        @Override // com.vivo.ad.h.b.a.InterfaceC0559a
        public void a(View view, int i2, int i3, int i4, int i5) {
            if (i.this.t0 != null) {
                i.this.t0.f(i4, i5);
            }
        }
    }

    class c0 implements com.vivo.ad.view.k {
        c0() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (i.this.t0 == null || !i.this.m0) {
                return;
            }
            i.this.t0.c(i4, i5);
        }
    }

    class d implements com.vivo.ad.view.k {
        d() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (i.this.t0 != null) {
                i.this.t0.c(i4, i5, 0.0d, 0.0d);
            }
        }
    }

    class d0 implements View.OnClickListener {
        d0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.t0 == null || !i.this.m0) {
                return;
            }
            i.this.t0.c(i.this.f30192j, i.this.k);
        }
    }

    class e implements com.vivo.mobilead.unified.base.callback.i {

        /* renamed from: a */
        final /* synthetic */ boolean f30201a;

        e(boolean z) {
            this.f30201a = z;
        }

        @Override // com.vivo.mobilead.unified.base.callback.i
        public void a(View view, int i2, int i3) {
            if (i.this.t0 == null || !this.f30201a) {
                return;
            }
            i.this.t0.c(i2, i3);
        }
    }

    class e0 extends com.vivo.mobilead.util.f1.b {
        e0() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (i.this.K) {
                return;
            }
            i iVar = i.this;
            iVar.g0 = iVar.getActionView();
            View view = i.this.g0;
            if (view != null) {
                if (view.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) i.this.g0.getLayoutParams()).addRule(12);
                }
                i iVar2 = i.this;
                iVar2.f30185c.addView(iVar2.g0);
            }
        }
    }

    class f implements com.vivo.ad.view.k {

        /* renamed from: a */
        final /* synthetic */ boolean f30204a;

        /* renamed from: b */
        final /* synthetic */ com.vivo.ad.model.b f30205b;

        f(boolean z, com.vivo.ad.model.b bVar) {
            this.f30204a = z;
            this.f30205b = bVar;
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (i.this.t0 == null || !this.f30204a) {
                return;
            }
            if (com.vivo.mobilead.util.q.a(this.f30205b)) {
                i.this.t0.d(i4, i5);
            } else {
                i.this.t0.c(i4, i5);
            }
        }
    }

    class g extends com.vivo.mobilead.util.f1.b {
        g() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (i.this.K) {
                return;
            }
            i iVar = i.this;
            iVar.g0 = iVar.getActionView();
            View view = i.this.g0;
            if (view != null) {
                view.setId(y0.a());
                if (i.this.g0.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) i.this.g0.getLayoutParams()).addRule(2, i.this.f30184b.getId());
                }
                i iVar2 = i.this;
                iVar2.addView(iVar2.g0);
            }
        }
    }

    class h implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ boolean f30208a;

        h(boolean z) {
            this.f30208a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (this.f30208a) {
                    com.vivo.ad.view.v vVar = i.this.n0;
                    if (vVar != null) {
                        vVar.g();
                    }
                    i.this.a(true);
                    i iVar = i.this;
                    k0.d(iVar.z, iVar.B);
                    return;
                }
                com.vivo.ad.view.v vVar2 = i.this.n0;
                if (vVar2 != null) {
                    vVar2.h();
                }
                com.vivo.mobilead.d.e eVar = i.this.f30183a;
                if (eVar != null) {
                    eVar.h();
                }
                i.this.d0.a(i.this);
            } catch (Exception e2) {
                x0.e("RewardVideoAdView", "showSmartH5:onClick:-->" + e2.getMessage());
            }
        }
    }

    /* renamed from: com.vivo.mobilead.unified.base.view.t.i$i */
    class RunnableC0637i implements Runnable {
        RunnableC0637i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.d0.a(i.this, true);
        }
    }

    class j extends com.vivo.mobilead.util.b1.a.c.b {

        class a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f30212a;

            /* renamed from: b */
            final /* synthetic */ File f30213b;

            a(byte[] bArr, File file) {
                this.f30212a = bArr;
                this.f30213b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                i.this.f30186d.a(this.f30212a, this.f30213b);
            }
        }

        j() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            super.a(str, bArr, file);
            i.this.post(new a(bArr, file));
        }
    }

    class k implements u.b {
        k() {
        }

        @Override // com.vivo.mobilead.util.u.b
        public boolean a(com.vivo.ad.model.b bVar, boolean z) {
            if (!i.this.v) {
                if (!z) {
                    if (i.this.a0) {
                        i.this.c(false);
                        return true;
                    }
                    if (bVar.W()) {
                        i.this.l0 = true;
                        i.this.b(false);
                        return true;
                    }
                }
                com.vivo.ad.model.q y = bVar.y();
                if (z && i.this.a0 && y != null && y.m() == 1) {
                    i.this.c(false);
                    return true;
                }
                if (z && y != null && y.m() == 1 && bVar.W() && !com.vivo.mobilead.util.j.b(i.this.W, y.a())) {
                    i.this.l0 = true;
                    i.this.b(false);
                    return true;
                }
            }
            return false;
        }
    }

    class l implements com.vivo.ad.view.k {
        l() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (i.this.t0 != null) {
                i.this.t0.a(i4, i5);
            }
        }
    }

    class m implements com.vivo.mobilead.unified.base.callback.i {
        m() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.i
        public void a(View view, int i2, int i3) {
            if (i.this.t0 != null) {
                i.this.t0.b(i2, i3);
            }
        }
    }

    class n implements com.vivo.mobilead.unified.base.callback.i {
        n(i iVar) {
        }

        @Override // com.vivo.mobilead.unified.base.callback.i
        public void a(View view, int i2, int i3) {
        }
    }

    class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.t0 != null) {
                i.this.t0.d();
            }
        }
    }

    class p implements com.vivo.ad.view.k {
        p() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            i iVar = i.this;
            iVar.L = false;
            if (iVar.t0 != null) {
                i.this.t0.h();
            }
        }
    }

    class q implements com.vivo.ad.view.k {
        q() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            i iVar = i.this;
            iVar.L = false;
            if (iVar.t0 != null) {
                i.this.t0.e(i4, i5);
            }
        }
    }

    class r implements com.vivo.ad.view.k {
        r() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if ((view instanceof com.vivo.ad.view.h) && i.this.t0 != null) {
                i.this.t0.b(i4, i5, 0.0d, 0.0d);
                return;
            }
            i iVar = i.this;
            if ((view == iVar.i0 || view == iVar.h0) && iVar.t0 != null && i.this.m0) {
                if (com.vivo.mobilead.util.q.a(i.this.z)) {
                    i.this.t0.d(i4, i5);
                } else {
                    i.this.t0.c(i4, i5);
                }
            }
        }
    }

    class t extends com.vivo.mobilead.util.f1.b {
        t() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            com.vivo.mobilead.d.e eVar = i.this.f30183a;
            if ((eVar == null ? 0 : eVar.getCurrentPosition()) > 0) {
                i.this.x();
                i.this.P.shutdown();
            }
        }
    }

    class u implements DialogInterface.OnShowListener {
        u() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            i iVar = i.this;
            iVar.L = true;
            iVar.e();
        }
    }

    class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar = i.this;
            if (iVar.L || iVar.f30183a == null) {
                return;
            }
            iVar.t0.b(i.this.f30192j, i.this.k, 0.0d, 0.0d);
        }
    }

    class w implements DialogInterface.OnDismissListener {
        w() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            i iVar = i.this;
            iVar.L = false;
            iVar.f();
        }
    }

    class x implements p.h {
        x() {
        }

        @Override // com.vivo.ad.view.p.h
        public void dismiss() {
            i iVar = i.this;
            iVar.L = false;
            iVar.f();
        }

        @Override // com.vivo.ad.view.p.h
        public void onShow() {
            i iVar = i.this;
            iVar.L = true;
            iVar.e();
        }
    }

    class z implements com.vivo.mobilead.unified.base.callback.b {
        z() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.b
        public void a() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.b
        public void a(int i2, int i3, int i4, int i5) {
            if (i.this.t0 == null || !i.this.m0) {
                return;
            }
            i.this.t0.c(i4, i5);
        }

        @Override // com.vivo.mobilead.unified.base.callback.b
        public void b(int i2, int i3, int i4, int i5) {
            if (i.this.t0 != null) {
                i.this.t0.c(i4, i5, 0.0d, 0.0d);
            }
        }
    }

    public i(Context context) {
        this(context, null);
    }

    public View getActionView() {
        com.vivo.ad.view.v vVar = new com.vivo.ad.view.v(getContext(), this.z, this.s0, this);
        this.n0 = vVar;
        return vVar.a();
    }

    private String getBtnText() {
        if (this.z.b0() || this.z.Z()) {
            this.y = 3;
        } else {
            com.vivo.ad.model.q y2 = this.z.y();
            if (y2 == null) {
                return "";
            }
            if (this.z.U()) {
                if (com.vivo.mobilead.util.j.b(getContext(), y2.e())) {
                    this.y = 2;
                    return "立即打开";
                }
                this.y = 4;
                return "立即预约";
            }
            if (!com.vivo.mobilead.util.j.b(getContext(), y2.a())) {
                this.y = 1;
                return "立即下载";
            }
            com.vivo.ad.model.r z2 = this.z.z();
            if (z2 == null || 1 != z2.a()) {
                this.y = 2;
                return "立即打开";
            }
            this.y = 3;
        }
        return "查看详情";
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(int i2, double d2, View view, int i3, int i4, int i5, int i6) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f30190h = (int) motionEvent.getRawX();
            this.f30191i = (int) motionEvent.getRawY();
            this.f30192j = (int) motionEvent.getX();
            this.k = (int) motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        com.vivo.mobilead.d.e eVar;
        this.T = z2;
        if (z2 && this.S && (eVar = this.f30183a) != null) {
            eVar.e();
            this.S = false;
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void setMediaListener(MediaListener mediaListener) {
        this.t = mediaListener;
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void setRewardVideoAdListener(UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener) {
        this.u = unifiedVivoRewardVideoAdListener;
    }

    class s implements com.vivo.mobilead.unified.base.callback.k {
        s() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void a(int i2, int i3, double d2, double d3) {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = i.this.u;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClick();
            }
            boolean e2 = com.vivo.mobilead.util.e.e(i.this.z);
            i iVar = i.this;
            iVar.a(e2, 1, 3, i2, i3, d2, d3, false, iVar.r0);
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void b(int i2, int i3, double d2, double d3) {
            boolean d4 = com.vivo.mobilead.util.c.d(i.this.z);
            i iVar = i.this;
            if (iVar.u == null || !d4) {
                return;
            }
            boolean i4 = com.vivo.mobilead.util.e.i(iVar.z);
            i iVar2 = i.this;
            Context context = iVar2.getContext();
            i iVar3 = i.this;
            com.vivo.ad.model.b bVar = iVar3.z;
            String str = iVar3.B;
            String str2 = iVar3.F;
            i iVar4 = i.this;
            iVar2.E = com.vivo.mobilead.util.u.a(context, bVar, i4, false, str, str2, iVar4.A, 1, iVar4.C, iVar4.r0);
            i.this.u.onAdClick();
            i iVar5 = i.this;
            iVar5.a(iVar5.f30190h, i.this.f30191i, i2, i3, d2, d3, 1, 3, false, "", i4);
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void c(int i2, int i3, double d2, double d3) {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = i.this.u;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClick();
            }
            boolean e2 = com.vivo.mobilead.util.e.e(i.this.z);
            i iVar = i.this;
            iVar.a(e2, 1, 2, i2, i3, d2, d3, false, iVar.r0);
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void d(int i2, int i3) {
            boolean d2 = com.vivo.mobilead.util.e.d(i.this.z);
            i iVar = i.this;
            iVar.a(d2, 1, 1, i2, i3, 0.0d, 0.0d, true, iVar.r0);
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void e(int i2, int i3) {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = i.this.u;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClick();
            }
            i iVar = i.this;
            iVar.removeView(iVar.f30187e);
            i.this.a(com.vivo.mobilead.util.e.f(i.this.z), 4, 2, i2, i3, (u.b) null);
            i.this.t();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void f(int i2, int i3) {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = i.this.u;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClick();
            }
            boolean c2 = com.vivo.mobilead.util.e.c(i.this.z);
            i iVar = i.this;
            iVar.a(c2, 1, 2, i2, i3, iVar.r0);
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void g() {
            i iVar = i.this;
            iVar.L = false;
            iVar.f();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void h() {
            i.this.j();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void i() {
            i iVar = i.this;
            iVar.L = true;
            iVar.e();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void j() {
            i.this.h();
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoCompletion() {
            i.this.g();
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoPause() {
            MediaListener mediaListener = i.this.t;
            if (mediaListener != null) {
                mediaListener.onVideoPause();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoResume() {
            MediaListener mediaListener = i.this.t;
            if (mediaListener != null) {
                mediaListener.onVideoPlay();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoStart() {
            MediaListener mediaListener = i.this.t;
            if (mediaListener != null) {
                mediaListener.onVideoStart();
                i.this.t.onVideoPlay();
            }
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = i.this.u;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdShow();
            }
            if (!i.this.O && i.this.p == 0) {
                i.this.O = true;
                UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener2 = i.this.u;
                if (unifiedVivoRewardVideoAdListener2 != null) {
                    unifiedVivoRewardVideoAdListener2.onRewardVerify();
                }
                i.this.f30185c.c();
            }
            i iVar = i.this;
            k0.c(iVar.z, iVar.B, iVar.F, c.a.f28912a + "");
            if (!i.this.G) {
                i.this.G = true;
                i iVar2 = i.this;
                u0.a(iVar2.z, a.EnumC0603a.STARTPLAY, iVar2.B);
            }
            i.this.f30185c.h();
            i.this.s();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void d() {
            i.this.t();
            i iVar = i.this;
            k0.d(iVar.z, iVar.B);
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void a(int i2, int i3) {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = i.this.u;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClick();
            }
            i.this.a(com.vivo.mobilead.util.e.h(i.this.z), 4, 2, i2, i3);
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void c(int i2, int i3) {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = i.this.u;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClick();
            }
            boolean d2 = com.vivo.mobilead.util.e.d(i.this.z);
            i iVar = i.this;
            iVar.a(d2, 1, 1, i2, i3, iVar.r0);
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void f() {
            i.this.n();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void b(int i2, int i3) {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = i.this.u;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClick();
            }
            i.this.a(com.vivo.mobilead.util.e.g(i.this.z), 4, 1, i2, i3);
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void e() {
            i.this.f();
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2, int i3, String str) {
            i.this.N = true;
            i.this.M = true;
            i.this.k();
            i.this.f30185c.c();
            MediaListener mediaListener = i.this.t;
            if (mediaListener != null) {
                mediaListener.onVideoError(new VivoAdError(com.vivo.mobilead.unified.base.f.a.f(i2), str));
            }
            i iVar = i.this;
            if (iVar.f30183a != null) {
                iVar.R = r4.getErrorCurrentPosition();
            }
            if (!com.vivo.mobilead.util.c0.c(i.this.getContext())) {
                i.this.S = true;
            }
            i iVar2 = i.this;
            k0.a(iVar2.z, 1, iVar2.B, iVar2.F);
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void c() {
            i.this.i();
        }

        @Override // com.vivo.mobilead.d.a
        public void b() {
            i iVar = i.this;
            com.vivo.mobilead.d.e eVar = iVar.f30183a;
            if (eVar != null) {
                eVar.setMute(iVar.w);
            }
            i.this.M = false;
            i.this.k();
            i.this.r();
            if (i.this.O) {
                return;
            }
            i iVar2 = i.this;
            iVar2.f30185c.a(iVar2.s, 0);
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2) {
            i iVar = i.this;
            if (iVar.f30183a == null || iVar.J || i2 == 0) {
                return;
            }
            if (!i.this.T) {
                i.this.S = true;
            } else {
                i.this.f30183a.e();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void a() {
            if (i.this.k0) {
                return;
            }
            i.this.k0 = true;
            i iVar = i.this;
            k0.a(iVar.z, iVar.B, iVar.F, c.a.f28912a + "", i.this.f30183a.getStartPlayDuration());
        }

        @Override // com.vivo.mobilead.d.a
        public void a(long j2, long j3) {
            if (j3 - j2 <= 500) {
                i.this.p();
            }
            i.this.q++;
            if (i.this.q % i.this.o == 0) {
                if (Math.abs(i.this.r - j2) >= 1000) {
                    i.this.r = j2;
                } else {
                    i.this.l();
                    MediaListener mediaListener = i.this.t;
                    if (mediaListener != null) {
                        mediaListener.onVideoError(new VivoAdError(40221, "播放卡顿，请检查网络状况"));
                    }
                    i.this.f30183a.f();
                    i iVar = i.this;
                    iVar.d(iVar.z);
                    return;
                }
            }
            if (!i.this.O && j2 / 1000 >= i.this.p) {
                i.this.O = true;
                UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = i.this.u;
                if (unifiedVivoRewardVideoAdListener != null) {
                    unifiedVivoRewardVideoAdListener.onRewardVerify();
                }
                i.this.f30185c.c();
            }
            if (!i.this.O) {
                i iVar2 = i.this;
                iVar2.f30185c.a(iVar2.s, (int) (j2 / 1000));
            }
            if (i.this.N || (j2 + 1000) / j3 <= i.this.n / 100.0f) {
                return;
            }
            i.this.N = true;
            if (i.this.O) {
                i.this.f30185c.c();
            } else {
                i.this.f30185c.f();
            }
        }
    }

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A() {
        com.vivo.mobilead.unified.base.view.p.a aVar = new com.vivo.mobilead.unified.base.view.p.a(this.W, -1);
        this.h0 = aVar;
        aVar.b(this.z, this.p0);
        this.h0.setId(y0.a());
        this.h0.setBannerClickListener(new z());
        this.h0.setFiveElementDialogListener(this.u0);
        this.f30185c.a(getContext(), com.vivo.mobilead.util.m.b(getContext(), 146.3f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f30185c.addView(this.h0, layoutParams);
        postDelayed(new a0(), 100L);
    }

    private void q() {
        com.vivo.ad.view.c cVar = new com.vivo.ad.view.c(getContext());
        this.f30189g = cVar;
        cVar.a(Color.parseColor("#26000000"), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.f30189g.a(10, -1);
        this.f30189g.setId(y0.a());
        this.f30189g.a(com.vivo.mobilead.h.b.a().a(this.z.e()), this.z.k(), this.z.O());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.leftMargin = com.vivo.mobilead.util.m.a(getContext(), 15.0f);
        layoutParams.bottomMargin = com.vivo.mobilead.util.m.a(getContext(), 27.0f);
        addView(this.f30189g, layoutParams);
    }

    public void r() {
        com.vivo.mobilead.d.e eVar = this.f30183a;
        if (eVar != null) {
            this.s = Math.min(eVar.getDuration() / 1000, this.p);
        }
    }

    public void s() {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.P = newScheduledThreadPool;
        newScheduledThreadPool.scheduleAtFixedRate(new t(), 0L, 100L, TimeUnit.MILLISECONDS);
    }

    public void t() {
        a(false);
    }

    private boolean u() {
        return getContext().getResources().getConfiguration().orientation == 2;
    }

    private void v() {
        p();
        a(getBtnText());
    }

    private void w() {
        if (!TextUtils.isEmpty(this.z.E()) || this.v) {
            return;
        }
        c(this.z);
    }

    public void x() {
        if (this.H) {
            return;
        }
        this.H = true;
        k0.a(this.z, this.y, this.B, this.F, c.a.f28912a + "", 1, this.j0);
        u0.a(this.z, a.EnumC0603a.SHOW, this.B);
    }

    private void y() {
        com.vivo.mobilead.unified.base.view.t.a aVar = new com.vivo.mobilead.unified.base.view.t.a(this.W);
        this.i0 = aVar;
        aVar.a(this.z, this.B);
        this.i0.setBtnClick(new b0());
        this.i0.setBgClick(new c0());
        this.i0.setOnClickListener(new d0());
        this.i0.setFiveElementDialogListener(this.u0);
        this.f30185c.a(getContext(), com.vivo.mobilead.util.m.b(getContext(), 30.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(21);
        layoutParams.addRule(12);
        this.f30185c.addView(this.i0, layoutParams);
        postDelayed(new e0(), 100L);
    }

    private void z() {
        this.p0 = com.vivo.mobilead.util.i.a("#E6FFFFFF");
        a(false, this.z);
        this.f30184b.b();
        this.f30184b.setBackgroundColor(com.vivo.mobilead.util.i.a("#E6FFFFFF"));
    }

    public void l() {
        com.vivo.mobilead.unified.base.view.t.g gVar = this.f30185c;
        if (gVar != null) {
            gVar.setMuteClickable(false);
            this.f30185c.a();
        }
        com.vivo.mobilead.d.e eVar = this.f30183a;
        if (eVar != null) {
            eVar.g();
        }
        try {
            ScheduledExecutorService scheduledExecutorService = this.P;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
        } catch (Exception unused) {
        }
    }

    protected void m() {
        com.vivo.mobilead.d.e eVar = this.f30183a;
        if (eVar != null) {
            eVar.g();
            removeView(this.f30183a);
            this.f30183a = null;
        }
    }

    protected void n() {
        boolean z2 = !this.w;
        this.w = z2;
        com.vivo.mobilead.d.e eVar = this.f30183a;
        if (eVar != null) {
            eVar.setMute(z2);
        }
    }

    protected void o() {
        com.vivo.mobilead.unified.base.view.t.g gVar;
        if (this.v || this.q0 || getContext() == null || (gVar = this.f30185c) == null) {
            return;
        }
        this.f30185c.c(gVar.b() ? "请点击关闭按钮进行关闭" : "请待关闭按钮出现进行关闭");
    }

    protected void p() {
        com.vivo.mobilead.unified.base.view.t.g gVar = this.f30185c;
        if (gVar != null) {
            gVar.setUiClickable(false);
        }
        com.vivo.ad.h.b.l lVar = this.f30184b;
        if (lVar != null) {
            lVar.setClickable(false);
        }
        com.vivo.ad.h.b.a aVar = this.f30188f;
        if (aVar != null) {
            aVar.setClickable(false);
        }
    }

    class b implements p.b {
        b() {
        }

        @Override // com.vivo.mobilead.util.p.b
        public void a(Bitmap bitmap) {
            i iVar = i.this;
            if (iVar.b(iVar.getContext()) || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            i.this.Q = bitmap;
        }

        @Override // com.vivo.mobilead.util.p.b
        public void a() {
            x0.b("RewardVideoAdView", "fastBlur error");
        }
    }

    public i(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.n = 80;
        this.o = 5;
        this.p = 30;
        this.q = 0;
        this.r = 0L;
        this.s = 0;
        this.v = false;
        this.w = false;
        this.x = true;
        this.y = -1;
        this.D = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.a0 = false;
        this.b0 = false;
        this.c0 = false;
        this.e0 = new Handler(Looper.getMainLooper());
        this.f0 = 0L;
        this.p0 = 0;
        this.r0 = new k();
        this.s0 = new r();
        this.t0 = new s();
        new u();
        new w();
        this.u0 = new x();
        this.W = context;
        a(context);
        com.vivo.mobilead.manager.b.l().putBoolean("is_click", this.D);
    }

    private void c(Context context) {
        com.vivo.mobilead.unified.base.view.t.g gVar = new com.vivo.mobilead.unified.base.view.t.g(context);
        this.f30185c = gVar;
        gVar.a(this.z, this.t0);
        this.f30185c.a(getContext());
        addView(this.f30185c, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void d() {
        o();
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void e() {
        com.vivo.mobilead.d.e eVar = this.f30183a;
        if (eVar != null) {
            eVar.d();
        }
        com.vivo.mobilead.unified.base.view.t.j.c cVar = this.d0;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void f() {
        com.vivo.mobilead.d.e eVar;
        com.vivo.mobilead.d.e eVar2;
        if (this.L || this.M) {
            return;
        }
        if (this.S && (eVar2 = this.f30183a) != null) {
            this.S = false;
            eVar2.g();
            this.f30183a.a(this.R);
        }
        com.vivo.mobilead.unified.base.view.t.j.c cVar = this.d0;
        if ((cVar == null || !cVar.b(this)) && (eVar = this.f30183a) != null) {
            eVar.h();
        }
        com.vivo.mobilead.unified.base.view.t.j.c cVar2 = this.d0;
        if (cVar2 != null) {
            cVar2.c();
        }
    }

    protected void g() {
        if (!this.O) {
            this.O = true;
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.u;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onRewardVerify();
            }
            this.f30185c.c();
        }
        MediaListener mediaListener = this.t;
        if (mediaListener != null) {
            mediaListener.onVideoCompletion();
        }
        com.vivo.mobilead.d.e eVar = this.f30183a;
        k0.b(this.z, eVar == null ? 0 : eVar.getDuration(), -1, 1, this.B, this.F);
        if (!this.I) {
            this.I = true;
            u0.a(this.z, a.EnumC0603a.PLAYEND, this.B);
        }
        l();
        d(this.z);
    }

    protected void h() {
        if (this.O) {
            l();
            d(this.z);
        } else if (!this.N && !this.M) {
            l();
            d(this.z);
        } else {
            com.vivo.mobilead.d.e eVar = this.f30183a;
            if (eVar != null) {
                eVar.d();
            }
            this.f30185c.d();
        }
    }

    protected void i() {
        t();
    }

    protected void j() {
        removeView(this.f30187e);
        t();
        k0.d(this.z, this.B);
    }

    protected void k() {
        com.vivo.mobilead.unified.base.view.t.g gVar = this.f30185c;
        if (gVar != null) {
            gVar.setUiClickable(true);
        }
        com.vivo.ad.h.b.l lVar = this.f30184b;
        if (lVar != null) {
            lVar.setClickable(true);
        }
        com.vivo.ad.h.b.a aVar = this.f30188f;
        if (aVar != null) {
            aVar.setClickable(true);
        }
    }

    class y implements com.vivo.mobilead.unified.base.view.t.j.e {

        /* renamed from: a */
        private boolean f30228a = false;

        /* renamed from: b */
        final /* synthetic */ com.vivo.ad.model.b f30229b;

        y(com.vivo.ad.model.b bVar) {
            this.f30229b = bVar;
        }

        @Override // com.vivo.mobilead.unified.base.view.t.j.e
        public void a(String str) {
            i.this.b0 = true;
            if (this.f30228a) {
                return;
            }
            k0.a(this.f30229b, "2", i.this.B, "");
            this.f30228a = true;
        }

        @Override // com.vivo.mobilead.unified.base.view.t.j.e
        public void a() {
            i.this.c0 = true;
        }
    }

    public void d(com.vivo.ad.model.b bVar) {
        View view = this.g0;
        if (view instanceof com.vivo.ad.view.h) {
            ((com.vivo.ad.view.h) view).a();
        }
        this.q0 = true;
        if (TextUtils.isEmpty(bVar.E())) {
            if (this.v) {
                this.J = true;
                f(bVar);
                return;
            }
            m();
            if (this.a0) {
                c(true);
                return;
            } else if (bVar.W()) {
                b(true);
                a(true);
                return;
            } else {
                e(bVar);
                k0.a(bVar, "3", this.B, "");
                return;
            }
        }
        m();
        com.vivo.mobilead.util.j.a(getContext(), bVar, false, false, true, this.A, this.B, -1, 1, this.C, false, "", -1, false);
        t();
    }

    public void b(boolean z2) {
        boolean z3 = !z2 && (this.M || this.I);
        String str = (!this.I || this.M) ? "1" : "2";
        com.vivo.mobilead.d.e eVar = this.f30183a;
        com.vivo.mobilead.util.j.a(this.W, this.z, false, false, false, this.A, this.B, -1, 1, this.C, z3, str, eVar == null ? 0 : eVar.getCurrentPosition(), z2);
    }

    private void e(com.vivo.ad.model.b bVar) {
        String str;
        float f2;
        int i2;
        int j2 = bVar.j();
        com.vivo.ad.model.a0 Q = bVar.Q();
        if (Q == null) {
            return;
        }
        String e2 = Q.e();
        String a2 = Q.a();
        String d2 = Q.d();
        com.vivo.ad.model.q y2 = bVar.y();
        bVar.H();
        String b2 = com.vivo.mobilead.util.f.b(bVar);
        boolean c2 = com.vivo.mobilead.util.c.c(bVar);
        Bitmap a3 = com.vivo.mobilead.h.b.a().a(d2);
        if (a3 == null) {
            a3 = com.vivo.mobilead.util.g.a(this.W, "vivo_module_reward_preview.jpg");
        }
        getBtnText();
        if (j2 == 2 || j2 == 8 || j2 == 12) {
            if (y2 != null) {
                f2 = y2.p();
                i2 = y2.h();
                if (i2 == -1 && a3 != null) {
                    i2 = a3.getWidth() >= a3.getHeight() ? 0 : 1;
                }
                str = y2.j();
            } else {
                str = "";
                f2 = -1.0f;
                i2 = -1;
            }
            if (i2 == 1) {
                if (u()) {
                    Bitmap bitmap = this.Q;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        Bitmap bitmap2 = this.Q;
                        a3 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), (int) (this.Q.getHeight() / 3.0f));
                    }
                    this.f30186d = new com.vivo.ad.h.b.i(getContext());
                } else {
                    this.f30186d = new com.vivo.ad.h.b.k(getContext());
                }
            } else if (u()) {
                this.f30186d = new com.vivo.ad.h.b.h(getContext());
            } else {
                this.f30186d = new com.vivo.ad.h.b.j(getContext());
            }
        } else {
            this.f30186d = new com.vivo.ad.h.b.e(getContext());
            str = "";
            f2 = -1.0f;
            i2 = -1;
        }
        Bitmap bitmap3 = this.Q;
        if (bitmap3 != null && !bitmap3.isRecycled() && i2 == 1) {
            this.f30186d.setBg(this.Q);
        } else {
            this.f30186d.setBg(a3);
        }
        this.f30186d.a(bVar.e(), bVar.k(), bVar.O());
        Bitmap bitmap4 = null;
        if (!TextUtils.isEmpty(b2) && b2.endsWith(".gif")) {
            com.vivo.mobilead.util.b1.a.b.b().a(b2, new j());
        } else {
            bitmap4 = com.vivo.mobilead.h.b.a().a(b2);
        }
        this.f30186d.setIcon(bitmap4);
        this.f30186d.setTitle(e2);
        this.f30186d.setDesc(a2);
        if (f2 == -1.0f) {
            this.f30186d.setScoreState(false);
        } else {
            this.f30186d.setScoreState(true);
            this.f30186d.setScore(f2);
            this.f30186d.setDownloadCount(str);
        }
        this.f30186d.setBtnText(bVar);
        this.f30186d.setBtnClick(new l());
        if (c2) {
            this.f30186d.setBgClick(new m());
        } else {
            this.f30186d.setBgClick(new n(this));
        }
        this.f30186d.setCloseClick(new o());
        addView(this.f30186d.getView(), new RelativeLayout.LayoutParams(-1, -1));
    }

    private void c(com.vivo.ad.model.b bVar) {
        int j2 = bVar.j();
        com.vivo.ad.model.a0 Q = bVar.Q();
        if (Q == null) {
            return;
        }
        String d2 = Q.d();
        if (j2 == 2 || j2 == 8 || j2 == 12) {
            if (bVar.s()) {
                com.vivo.mobilead.util.b1.a.b.b().a(d2, new a());
            } else {
                a(com.vivo.mobilead.h.b.a().a(d2));
            }
        }
    }

    private void b(com.vivo.ad.model.b bVar) {
        com.vivo.mobilead.d.e eVar;
        com.vivo.ad.model.a0 Q = bVar.Q();
        if (Q != null) {
            String g2 = Q.g();
            if (TextUtils.isEmpty(g2) || (eVar = this.f30183a) == null) {
                return;
            }
            eVar.setNeedLooper(true);
            this.f30183a.a(g2, bVar.C(), bVar.G());
            this.f30183a.setMediaCallback(this.t0);
            this.f30183a.e();
        }
    }

    protected void a(Context context) {
        this.l = com.vivo.mobilead.util.m.a(context, 320.0f);
        this.m = com.vivo.mobilead.util.m.a(context, 165.0f);
        com.vivo.mobilead.d.e eVar = new com.vivo.mobilead.d.e(context);
        this.f30183a = eVar;
        eVar.setEnableStuckSwitch(true);
        this.f30183a.setOnClickListener(new v());
        addView(this.f30183a, new RelativeLayout.LayoutParams(-1, -1));
        c(context);
    }

    private void f(com.vivo.ad.model.b bVar) {
        com.vivo.ad.model.r z2 = bVar.z();
        boolean z3 = z2 != null && 1 == z2.a();
        if (bVar.b0() && !this.x && !z3) {
            this.E = com.vivo.mobilead.util.u.a(getContext(), bVar, true, false, 3, 1, this.B, this.F, this.A, 1, this.C);
            a(-999, -999, -999, -999, 0.0d, 0.0d, 3, 1, false, "", true);
            t();
            return;
        }
        v();
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void c() {
        double d2;
        double d3;
        double d4;
        this.K = true;
        com.vivo.ad.view.v vVar = this.n0;
        if (vVar != null) {
            d2 = vVar.b();
            d3 = this.n0.d();
            d4 = this.n0.c();
        } else {
            d2 = 0.0d;
            d3 = 0.0d;
            d4 = 0.0d;
        }
        k0.a(this.z, this.B, d2, d3, d4);
        l();
        com.vivo.mobilead.unified.base.view.t.j.c cVar = this.d0;
        if (cVar != null) {
            cVar.a();
        }
    }

    public boolean b(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isFinishing();
        }
        return false;
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void a(com.vivo.ad.model.b bVar, BackUrlInfo backUrlInfo, String str, int i2, int i3) {
        int i4;
        this.z = bVar;
        this.A = backUrlInfo;
        this.B = str;
        this.F = bVar.i();
        this.C = i2;
        this.a0 = com.vivo.mobilead.util.f.c(bVar);
        com.vivo.ad.model.e c2 = bVar.c();
        if (c2 != null) {
            this.U = c2.x();
            this.V = c2.y();
            this.n = c2.p();
            this.o = c2.A();
            i4 = c2.z();
            this.x = c2.o() == 2;
            this.p = c2.k();
            this.f0 = c2.i();
        } else {
            i4 = 0;
        }
        this.f30183a.a(this.V, this.U);
        this.f30185c.a(bVar, this.t0);
        this.v = a(bVar);
        p();
        b(bVar);
        this.j0 = -999;
        this.m0 = com.vivo.mobilead.util.c.b(bVar);
        int intValue = (bVar.x() != 45 || bVar.t() == null) ? -1 : bVar.t().b().intValue();
        if (intValue != -1) {
            this.o0 = 2 == intValue;
        } else {
            this.o0 = u();
        }
        if (this.o0) {
            if (bVar.u() == 101) {
                this.p0 = com.vivo.mobilead.util.i.a("#E6FFFFFF");
                y();
                this.j0 = 101;
            } else if (bVar.u() == 102) {
                z();
                this.j0 = 102;
            } else {
                this.p0 = -1;
                a(this.v || i4 == 0, bVar);
            }
        } else if (bVar.B() == 1) {
            this.p0 = com.vivo.mobilead.util.i.a("#E6FFFFFF");
            A();
            this.j0 = 1;
        } else {
            this.p0 = -1;
            a(this.v || i4 == 0, bVar);
        }
        this.f30185c.a(str);
        w();
        if (this.a0) {
            if (this.d0 == null) {
                com.vivo.mobilead.unified.base.view.t.j.c cVar = new com.vivo.mobilead.unified.base.view.t.j.c(getContext());
                this.d0 = cVar;
                cVar.a(new y(bVar));
            }
            this.d0.a(bVar, str, backUrlInfo, i3, i2);
        }
    }

    public void c(boolean z2) {
        if (!z2) {
            try {
                com.vivo.mobilead.d.e eVar = this.f30183a;
                if (eVar != null) {
                    eVar.d();
                }
            } catch (Exception e2) {
                x0.e("RewardVideoAdView", "showSmartH5:-->" + e2.getMessage());
                return;
            }
        }
        com.vivo.ad.view.v vVar = this.n0;
        if (vVar != null) {
            vVar.f();
        }
        com.vivo.mobilead.unified.base.view.t.j.c cVar = this.d0;
        if (cVar != null) {
            cVar.a(this.z.e(), this.z.k(), this.z.O());
            this.d0.a(new h(z2));
            boolean z3 = true;
            if (this.f0 > 0) {
                com.vivo.mobilead.unified.base.view.t.j.c cVar2 = this.d0;
                if (this.b0 || !this.c0) {
                    z3 = false;
                }
                cVar2.a(this, z3);
                this.e0.postDelayed(new RunnableC0637i(), this.f0 * 1000);
                return;
            }
            this.d0.a(this, true);
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || this.z.y() == null || this.z.y().h() == 0) {
            return;
        }
        boolean z2 = true;
        if (this.z.y().h() == -1 && bitmap.getWidth() >= bitmap.getHeight()) {
            z2 = false;
        }
        if (z2) {
            com.vivo.mobilead.util.p.a(bitmap, 0.4f, 20, new b());
        }
    }

    private void a(boolean z2, com.vivo.ad.model.b bVar) {
        String btnText = getBtnText();
        if (z2) {
            com.vivo.ad.h.b.a aVar = new com.vivo.ad.h.b.a(getContext());
            this.f30188f = aVar;
            aVar.setText(btnText);
            this.f30188f.setId(y0.a());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.vivo.mobilead.util.m.b(getContext(), 100.0f), com.vivo.mobilead.util.m.b(getContext(), 36.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            int a2 = com.vivo.mobilead.util.m.a(getContext(), 15.0f);
            layoutParams.setMargins(0, 0, a2, a2);
            this.f30188f.setOnAWClickListener(new c());
            addView(this.f30188f, layoutParams);
            q();
            this.f30185c.a(getContext(), com.vivo.mobilead.util.m.b(getContext(), 36.0f));
            return;
        }
        com.vivo.ad.h.b.l lVar = new com.vivo.ad.h.b.l(getContext(), this.o0);
        this.f30184b = lVar;
        lVar.a();
        this.f30184b.setId(y0.a());
        float f2 = (!com.vivo.mobilead.util.q.a(bVar) || this.o0) ? 75 : 90;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.vivo.mobilead.util.m.a(getContext(), f2));
        layoutParams2.addRule(12);
        this.f30184b.setLayoutParams(layoutParams2);
        addView(this.f30184b);
        this.f30184b.a(bVar, this.o0, this.p0);
        this.f30184b.a(bVar, this.u0, this.B);
        this.f30184b.setBtnClick(new d());
        boolean b2 = com.vivo.mobilead.util.c.b(bVar);
        this.f30184b.setBgClick(new e(b2));
        this.f30185c.a(getContext(), com.vivo.mobilead.util.m.b(getContext(), f2));
        this.f30184b.setFiveElementClickListener(new f(b2, bVar));
        postDelayed(new g(), 100L);
    }

    private void a(String str) {
        this.f30187e = new com.vivo.ad.h.b.b(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.l, this.m);
        layoutParams.addRule(13);
        this.f30187e.setText("视频观看完成是否继续");
        this.f30187e.setCloseButtonText("关闭视频");
        this.f30187e.setContinueButtonTextColor("#75E48E");
        this.f30187e.setContinueButtonText(str);
        this.f30187e.setCloseButtonClickListener(new p());
        this.f30187e.setContinueButtonClickListener(new q());
        this.L = true;
        addView(this.f30187e, layoutParams);
    }

    private boolean a(com.vivo.ad.model.b bVar) {
        String b2;
        int j2 = bVar.j();
        com.vivo.ad.model.a0 Q = bVar.Q();
        if (Q == null) {
            return true;
        }
        String e2 = Q.e();
        String a2 = Q.a();
        String d2 = Q.d();
        com.vivo.ad.model.q y2 = bVar.y();
        com.vivo.ad.model.u H = bVar.H();
        if (j2 == 2 || bVar.U() || bVar.W() || j2 == 12) {
            if (y2 != null) {
                b2 = y2.b();
            }
            b2 = "";
        } else if (j2 == 8) {
            if (H != null) {
                b2 = H.b();
            }
            b2 = "";
        } else {
            b2 = bVar.L();
        }
        return TextUtils.isEmpty(e2) || TextUtils.isEmpty(a2) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(d2);
    }

    public void a(boolean z2, int i2, int i3, int i4, int i5, u.b bVar) {
        a(z2, i2, i3, i4, i5, 0.0d, 0.0d, false, bVar);
    }

    public void a(boolean z2, int i2, int i3, int i4, int i5, double d2, double d3, boolean z3, u.b bVar) {
        Context context = getContext();
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        this.E = com.vivo.mobilead.util.u.a(context, this.z, z2, i3 == 2, i2, i3, this.B, this.F, this.A, 1, this.C, bVar);
        a(this.f30190h, this.f30191i, i4, i5, d2, d3, i2, i3, z3, "", z2);
    }

    public void a(boolean z2, int i2, int i3, int i4, int i5) {
        Context context = getContext();
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        this.E = com.vivo.mobilead.util.u.a(context, this.z, z2, i3 == 2, i2, i3, this.B, this.F, this.A, 1, this.C);
        a(this.f30190h, this.f30191i, i4, i5, 0.0d, 0.0d, i2, i3, false, "3", z2);
    }

    public void a(boolean z2) {
        UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.u;
        if (unifiedVivoRewardVideoAdListener != null) {
            unifiedVivoRewardVideoAdListener.onAdClose();
        }
        com.vivo.mobilead.d.e eVar = this.f30183a;
        int currentPosition = eVar == null ? 0 : eVar.getCurrentPosition();
        if (!z2) {
            k0.a(this.z, this.B, this.F, 1, currentPosition, 7);
        } else {
            k0.a(this.z, this.B, this.F, -1, currentPosition, 16, (!this.I || this.M) ? "1" : "2", this.j0);
        }
        l();
        Context context = getContext();
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    protected void a(int i2, int i3, int i4, int i5, double d2, double d3, int i6, int i7, boolean z2, String str, boolean z3) {
        if (!this.D && !com.vivo.mobilead.manager.b.l().getBoolean("is_click", false)) {
            this.D = true;
            com.vivo.ad.model.w wVar = new com.vivo.ad.model.w(this.z.b());
            wVar.a(d2);
            wVar.b(d3);
            u0.a(this.z, a.EnumC0603a.CLICK, i2, i3, i4, i5, -999, -999, -999, -999, wVar, this.B);
            com.vivo.mobilead.manager.b.l().putBoolean("is_click", this.D);
        }
        k0.a(this.z, this.y, i6, i7, i2, i3, i4, i5, this.E, this.B, this.F, c.a.f28912a + "", 1, z2, str, this.j0, z3);
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(double d2, double d3) {
        com.vivo.mobilead.unified.base.callback.k kVar = this.t0;
        if (kVar != null) {
            kVar.a(this.f30192j, this.k, d2, d3);
        }
    }
}
