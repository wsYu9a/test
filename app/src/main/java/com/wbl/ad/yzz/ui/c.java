package com.wbl.ad.yzz.ui;

import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.adapter.d.a;
import com.wbl.ad.yzz.adapter.quick.ScrollLinearLayoutManager;
import com.wbl.ad.yzz.bean.AdPageNeedData;
import com.wbl.ad.yzz.c.c.a;
import com.wbl.ad.yzz.cashhongbao.c;
import com.wbl.ad.yzz.cashhongbao.d;
import com.wbl.ad.yzz.config.PageOptions;
import com.wbl.ad.yzz.counttimer.b;
import com.wbl.ad.yzz.feedback.b;
import com.wbl.ad.yzz.gudie.g.d;
import com.wbl.ad.yzz.network.b.b.e;
import com.wbl.ad.yzz.network.b.b.j0;
import com.wbl.ad.yzz.network.b.b.k0;
import com.wbl.ad.yzz.network.bean.request.UploadFeedbackReq;
import com.wbl.ad.yzz.network.c.d;
import com.wbl.ad.yzz.ui.f.j;
import com.wbl.ad.yzz.util.a;
import com.wbl.ad.yzz.wigdet.AutoVerticalScrollTextView;
import com.wbl.ad.yzz.wigdet.h.b;
import com.wbl.ad.yzz.wigdet.h.d;
import com.wbl.ad.yzz.wigdet.rclay.RCRelativeLayout;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class c extends com.wbl.ad.yzz.ui.a {
    public AdPageNeedData N;
    public int O;
    public int P;
    public ImageView Q;
    public ImageView R;
    public g0 U;
    public FrameLayout V;
    public FrameLayout W;
    public RelativeLayout X;
    public View Y;
    public RelativeLayout Z;
    public ImageView a0;
    public com.wbl.ad.yzz.gudie.d d0;

    /* renamed from: f */
    public View f34004f;
    public com.wbl.ad.yzz.wigdet.h.d f0;

    /* renamed from: g */
    public com.wbl.ad.yzz.adapter.d.e f34005g;

    /* renamed from: i */
    public ScrollLinearLayoutManager f34007i;
    public AutoVerticalScrollTextView i0;

    /* renamed from: j */
    public CountDownTimer f34008j;
    public TextView j0;
    public CountDownTimer k;
    public RCRelativeLayout k0;
    public CountDownTimer l;
    public RelativeLayout l0;
    public com.wbl.ad.yzz.ui.f.e m0;
    public com.wbl.ad.yzz.network.b.b.k n0;
    public boolean o;
    public LinearLayout p;
    public TextView q;
    public com.wbl.ad.yzz.wigdet.k.d q0;
    public ImageView r;
    public com.wbl.ad.yzz.title.b s;
    public View v;
    public ImageView w;
    public ImageView x;
    public com.wbl.ad.yzz.wigdet.h.b x0;
    public com.wbl.ad.yzz.counttimer.b y;

    /* renamed from: h */
    public final com.wbl.ad.yzz.ui.f.h f34006h = new com.wbl.ad.yzz.ui.f.h();
    public int m = 0;
    public int n = 0;
    public final com.wbl.ad.yzz.ui.f.g t = new com.wbl.ad.yzz.ui.f.g();
    public final com.wbl.ad.yzz.ui.f.c u = new com.wbl.ad.yzz.ui.f.c();
    public int z = 0;
    public int A = 0;
    public final com.wbl.ad.yzz.ui.f.b B = new com.wbl.ad.yzz.ui.f.b();
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public boolean F = false;
    public boolean G = false;
    public boolean H = false;
    public boolean I = true;
    public boolean J = true;
    public boolean K = false;
    public boolean L = false;
    public boolean M = true;
    public boolean S = false;
    public int T = 0;
    public boolean b0 = false;
    public final com.wbl.ad.yzz.innerconfig.a c0 = new com.wbl.ad.yzz.innerconfig.a();
    public Handler e0 = new Handler(Looper.getMainLooper());
    public final com.wbl.ad.yzz.adapter.a g0 = new com.wbl.ad.yzz.adapter.a();
    public int h0 = 10;
    public final com.wbl.ad.yzz.cashhongbao.b o0 = new com.wbl.ad.yzz.cashhongbao.b();
    public final com.wbl.ad.yzz.c.c.a p0 = new com.wbl.ad.yzz.c.c.a();
    public com.wbl.ad.yzz.help.k r0 = new com.wbl.ad.yzz.help.k();
    public Runnable s0 = new j();
    public long t0 = 0;
    public com.wbl.ad.yzz.ui.f.j u0 = new com.wbl.ad.yzz.ui.f.j();
    public b.a v0 = new n();
    public d.c w0 = new q();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9410, this, view);
        }
    }

    public class a0 extends CountDownTimer {
        public a0(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9416, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9415, this, Long.valueOf(j2));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9411, this, view);
        }
    }

    public class b0 extends CountDownTimer {
        public b0(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9409, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9412, this, Long.valueOf(j2));
        }
    }

    /* renamed from: com.wbl.ad.yzz.ui.c$c */
    public class C0787c implements com.wbl.ad.yzz.adapter.c.b {
        public C0787c() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9436, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9435, this, bVar, str, str2, str3, str4);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9430, this, bVar, str, str2, str3, str4, str5);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9429, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9432, this, str, str2, bVar);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(boolean z, boolean z2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9431, this, Boolean.valueOf(z), Boolean.valueOf(z2), str);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9426, this, str, str2, bVar);
        }
    }

    public class c0 implements GestureDetector.OnGestureListener {
        public c0() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9438, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9437, this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3));
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9440, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9439, this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3));
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9434, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9433, this, motionEvent);
        }
    }

    public class d implements com.wbl.ad.yzz.adapter.b.d.f {
        public d() {
        }

        @Override // com.wbl.ad.yzz.adapter.b.d.f
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9518, this, null);
        }
    }

    public class d0 implements RecyclerView.OnItemTouchListener {

        /* renamed from: a */
        public final /* synthetic */ GestureDetector f34016a;

        public d0(GestureDetector gestureDetector) {
            this.f34016a = gestureDetector;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9425, this, recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9428, this, Boolean.valueOf(z));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9427, this, recyclerView, motionEvent);
        }
    }

    public class e extends com.wbl.ad.yzz.adapter.c.a {
        public e() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.a
        public void a(int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9513, this, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // com.wbl.ad.yzz.adapter.c.a
        public void a(int[] iArr) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9516, this, iArr);
        }
    }

    public class e0 implements a.InterfaceC0679a {

        public class a implements a.InterfaceC0697a {

            /* renamed from: a */
            public final /* synthetic */ int f34020a;

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.b f34021b;

            public a(int i2, com.wbl.ad.yzz.bean.b bVar) {
                this.f34020a = i2;
                this.f34021b = bVar;
            }

            @Override // com.wbl.ad.yzz.c.c.a.InterfaceC0697a
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9517, this, null);
            }

            @Override // com.wbl.ad.yzz.c.c.a.InterfaceC0697a
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9520, this, null);
            }

            @Override // com.wbl.ad.yzz.c.c.a.InterfaceC0697a
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9519, this, null);
            }
        }

        public e0() {
        }

        @Override // com.wbl.ad.yzz.adapter.d.a.InterfaceC0679a
        public void a(View view, com.wbl.ad.yzz.bean.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9514, this, view, bVar, Integer.valueOf(i2));
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9511, this, view);
        }
    }

    public class f0 implements com.wbl.ad.yzz.wigdet.d {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9515, this, null);
            }
        }

        public f0() {
        }

        @Override // com.wbl.ad.yzz.wigdet.d
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9510, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.d
        public void a(boolean z, boolean z2, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9509, this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.wigdet.d
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9512, this, null);
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9505, this, view);
        }
    }

    public static class g0 extends Handler {

        /* renamed from: a */
        public final WeakReference<ADActivity> f34027a;

        /* renamed from: b */
        public final WeakReference<c> f34028b;

        public g0(ADActivity aDActivity, c cVar) {
            this.f34027a = new WeakReference<>(aDActivity);
            this.f34028b = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9506, this, message);
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9508, this, view);
        }
    }

    public class i implements AutoVerticalScrollTextView.b {
        public i() {
        }

        @Override // com.wbl.ad.yzz.wigdet.AutoVerticalScrollTextView.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9507, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.wigdet.AutoVerticalScrollTextView.b
        public void b(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9534, this, Integer.valueOf(i2));
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9533, this, null);
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9536, this, null);
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9535, this, null);
        }
    }

    public class m implements d.b0<com.wbl.ad.yzz.network.b.b.n> {
        public m() {
        }

        public void a(String str, com.wbl.ad.yzz.network.b.b.n nVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9530, this, str, nVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9529, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, com.wbl.ad.yzz.network.b.b.n nVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9532, this, str, nVar);
        }
    }

    public class n implements b.a {
        public n() {
        }

        @Override // com.wbl.ad.yzz.feedback.b.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9531, this, null);
        }

        @Override // com.wbl.ad.yzz.feedback.b.a
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9526, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.feedback.b.a
        public void a(UploadFeedbackReq uploadFeedbackReq) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9525, this, uploadFeedbackReq);
        }
    }

    public class o implements d.a {
        public o() {
        }

        @Override // com.wbl.ad.yzz.gudie.g.d.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9528, this, null);
        }

        @Override // com.wbl.ad.yzz.gudie.g.d.a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9527, this, null);
        }

        @Override // com.wbl.ad.yzz.gudie.g.d.a
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9522, this, null);
        }
    }

    public class p implements com.wbl.ad.yzz.adapter.c.b {
        public p() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9521, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9524, this, bVar, str, str2, str3, str4);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9523, this, bVar, str, str2, str3, str4, str5);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9486, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9485, this, str, str2, bVar);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(boolean z, boolean z2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9488, this, Boolean.valueOf(z), Boolean.valueOf(z2), str);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9487, this, str, str2, bVar);
        }
    }

    public class q implements d.c {
        public q() {
        }

        @Override // com.wbl.ad.yzz.wigdet.h.d.c
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9482, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.h.d.c
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9481, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.h.d.c
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9484, this, null);
        }
    }

    public class r implements b.a {
        public r() {
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void a(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9483, this, Long.valueOf(j2));
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9478, this, null);
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9477, this, null);
        }
    }

    public class s implements a.j {
        public s() {
        }

        @Override // com.wbl.ad.yzz.util.a.j
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9480, this, null);
        }
    }

    public class t implements b.h {

        /* renamed from: a */
        public final /* synthetic */ k0.b f34041a;

        /* renamed from: b */
        public final /* synthetic */ k0 f34042b;

        public t(k0.b bVar, k0 k0Var) {
            this.f34041a = bVar;
            this.f34042b = k0Var;
        }

        @Override // com.wbl.ad.yzz.wigdet.h.b.h
        public void dismiss() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9479, this, null);
        }
    }

    public class u implements a.j {
        public u() {
        }

        @Override // com.wbl.ad.yzz.util.a.j
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9474, this, null);
        }
    }

    public class v implements j.a {
        public v() {
        }

        @Override // com.wbl.ad.yzz.ui.f.j.a
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9473, this, Integer.valueOf(i2));
        }
    }

    public class w implements c.a {

        /* renamed from: a */
        public final /* synthetic */ Activity f34046a;

        public w(Activity activity) {
            this.f34046a = activity;
        }

        @Override // com.wbl.ad.yzz.cashhongbao.c.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9476, this, null);
        }

        @Override // com.wbl.ad.yzz.cashhongbao.c.a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9475, this, null);
        }
    }

    public class x implements d.b {
        public x() {
        }

        @Override // com.wbl.ad.yzz.cashhongbao.d.b
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9502, this, null);
        }

        @Override // com.wbl.ad.yzz.cashhongbao.d.b
        public void a(e.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9501, this, bVar);
        }

        @Override // com.wbl.ad.yzz.cashhongbao.d.b
        public void a(com.wbl.ad.yzz.network.b.b.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9504, this, eVar);
        }
    }

    public class y implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.e f34049a;

        /* renamed from: b */
        public final /* synthetic */ d.b f34050b;

        public y(com.wbl.ad.yzz.network.b.b.e eVar, d.b bVar) {
            this.f34049a = eVar;
            this.f34050b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9503, this, null);
        }
    }

    public class z extends CountDownTimer {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.u f34052a;

        /* renamed from: b */
        public final /* synthetic */ int f34053b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(long j2, long j3, com.wbl.ad.yzz.network.b.b.u uVar, int i2) {
            super(j2, j3);
            this.f34052a = uVar;
            this.f34053b = i2;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9498, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9497, this, Long.valueOf(j2));
        }
    }

    public static /* synthetic */ com.wbl.ad.yzz.title.b B(c cVar) {
        return (com.wbl.ad.yzz.title.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9499, null, cVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.c.c.a E(c cVar) {
        return (com.wbl.ad.yzz.c.c.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9496, null, cVar);
    }

    public static /* synthetic */ Handler F(c cVar) {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9495, null, cVar);
    }

    public static /* synthetic */ ScrollLinearLayoutManager K(c cVar) {
        return (ScrollLinearLayoutManager) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9582, null, cVar);
    }

    public static /* synthetic */ View L(c cVar) {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9581, null, cVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.wigdet.k.d M(c cVar) {
        return (com.wbl.ad.yzz.wigdet.k.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9584, null, cVar);
    }

    public static /* synthetic */ TextView P(c cVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9577, null, cVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.ui.f.c T(c cVar) {
        return (com.wbl.ad.yzz.ui.f.c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9573, null, cVar);
    }

    public static /* synthetic */ RCRelativeLayout W(c cVar) {
        return (RCRelativeLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9570, null, cVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.cashhongbao.b a0(c cVar) {
        return (com.wbl.ad.yzz.cashhongbao.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9586, null, cVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.adapter.d.e b0(c cVar) {
        return (com.wbl.ad.yzz.adapter.d.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9552, null, cVar);
    }

    public static /* synthetic */ CountDownTimer d(c cVar) {
        return (CountDownTimer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9547, null, cVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.help.k u(c cVar) {
        return (com.wbl.ad.yzz.help.k) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9646, null, cVar);
    }

    public static /* synthetic */ AdPageNeedData v(c cVar) {
        return (AdPageNeedData) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9645, null, cVar);
    }

    public static /* synthetic */ g0 w(c cVar) {
        return (g0) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9648, null, cVar);
    }

    public static /* synthetic */ RelativeLayout x(c cVar) {
        return (RelativeLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9647, null, cVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.ui.f.b z(c cVar) {
        return (com.wbl.ad.yzz.ui.f.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9641, null, cVar);
    }

    public final void A() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9644, this, null);
    }

    public final void B() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9643, this, null);
    }

    public final void C() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9638, this, null);
    }

    public final void D() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9637, this, null);
    }

    public final void E() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9640, this, null);
    }

    public final void F() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9639, this, null);
    }

    public final void G() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9634, this, null);
    }

    public final void H() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9633, this, null);
    }

    public final void I() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9636, this, null);
    }

    public void J() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9635, this, null);
    }

    public final void K() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9662, this, null);
    }

    public final boolean L() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9661, this, null);
    }

    public final boolean M() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9664, this, null);
    }

    public final void N() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9663, this, null);
    }

    public final void O() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9658, this, null);
    }

    public final void P() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9657, this, null);
    }

    public final void Q() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9660, this, null);
    }

    public final void R() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9659, this, null);
    }

    public final void S() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9654, this, null);
    }

    public final void T() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9653, this, null);
    }

    public final void U() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9656, this, null);
    }

    public final void V() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9655, this, null);
    }

    public final void W() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9650, this, null);
    }

    public void X() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9649, this, null);
    }

    public final void Y() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9652, this, null);
    }

    public final void Z() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9651, this, null);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9614, this, null);
    }

    public final void a(int i2, com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9613, this, Integer.valueOf(i2), uVar);
    }

    public final void a(int i2, String str, String str2, String str3, String str4, String str5, String str6, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9616, this, Integer.valueOf(i2), str, str2, str3, str4, str5, str6, bVar);
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9615, this, bVar, str, str2, str3, str4, str5);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar, boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9610, this, dVar, Boolean.valueOf(z2));
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void a(com.wbl.ad.yzz.innerconfig.d.e eVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9609, this, eVar);
    }

    public final void a(j0 j0Var, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9612, this, j0Var, Integer.valueOf(i2));
    }

    public final void a(k0 k0Var, k0.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9611, this, k0Var, bVar);
    }

    public final void a(com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9606, this, uVar);
    }

    public void a(Object obj) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9605, this, obj);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9608, this, str);
    }

    public final void a(String str, ImageView imageView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9607, this, str, imageView);
    }

    public final void a(String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9602, this, str, str2);
    }

    public final void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9601, this, str, str2, bVar);
    }

    public final void a(String str, Map<String, String> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9604, this, str, map);
    }

    public final void a(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9603, this, Boolean.valueOf(z2));
    }

    public final void a(boolean z2, long j2, k0 k0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9630, this, Boolean.valueOf(z2), Long.valueOf(j2), k0Var);
    }

    public final void a(boolean z2, long j2, k0 k0Var, boolean z3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9629, this, Boolean.valueOf(z2), Long.valueOf(j2), k0Var, Boolean.valueOf(z3));
    }

    public final void a(boolean z2, String str, boolean z3, int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9632, this, Boolean.valueOf(z2), str, Boolean.valueOf(z3), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final void a(boolean z2, boolean z3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9631, this, Boolean.valueOf(z2), Boolean.valueOf(z3));
    }

    public final void a(boolean z2, boolean z3, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9626, this, Boolean.valueOf(z2), Boolean.valueOf(z3), str);
    }

    public void a(boolean z2, boolean z3, boolean z4, boolean z5) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9625, this, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5));
    }

    public final void a0() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9628, this, null);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9627, this, null);
    }

    public final void b(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9622, this, activity);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void b(ADActivity aDActivity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9621, this, aDActivity);
    }

    public final void b(Object obj) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9624, this, obj);
    }

    public final void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9623, this, str, str2, bVar);
    }

    public final void b(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9618, this, Boolean.valueOf(z2));
    }

    public void b(boolean z2, boolean z3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9617, this, Boolean.valueOf(z2), Boolean.valueOf(z3));
    }

    public final boolean b(com.wbl.ad.yzz.network.b.b.u uVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9620, this, uVar);
    }

    public final int c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9619, this, null);
    }

    public final void c(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9710, this, Integer.valueOf(i2));
    }

    public final void c(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9709, this, Boolean.valueOf(z2));
    }

    public final boolean c(com.wbl.ad.yzz.network.b.b.u uVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9712, this, uVar);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public int d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9711, this, null);
    }

    public void d(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9706, this, Integer.valueOf(i2));
    }

    public final void d(com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9705, this, uVar);
    }

    public final void d(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9708, this, Boolean.valueOf(z2));
    }

    @Override // com.wbl.ad.yzz.ui.d
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9707, this, keyEvent);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9702, this, null);
    }

    public final void e(com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9701, this, uVar);
    }

    public final void e(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9704, this, Boolean.valueOf(z2));
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9703, this, null);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void finish() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9698, this, null);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9697, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void getConfErr(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9700, this, str);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void getConfSucess(com.wbl.ad.yzz.network.b.b.k kVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9699, this, kVar);
    }

    public final void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9726, this, null);
    }

    public final void i() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9725, this, null);
    }

    public final void j() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9728, this, null);
    }

    public final void k() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9727, this, null);
    }

    public final void l() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9722, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadAdError(com.wbl.ad.yzz.d.c.a<Object> aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9721, this, aVar);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadAdSuccess(List<com.wbl.ad.yzz.adapter.d.b> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9724, this, list);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadLeaveError(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9723, this, str);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadLeaveSuccess(com.wbl.ad.yzz.network.b.b.a0 a0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9718, this, a0Var);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadPageMsgError(boolean z2, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9717, this, Boolean.valueOf(z2), str, str2);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadPageMsgSuccess(boolean z2, Object obj, com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9720, this, Boolean.valueOf(z2), obj, uVar);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadUpRpError(int i2, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9719, this, Integer.valueOf(i2), str, str2);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadUpRpSuccess(k0 k0Var, int i2, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9714, this, k0Var, Integer.valueOf(i2), bVar);
    }

    public final void m() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9713, this, null);
    }

    public final void n() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9716, this, null);
    }

    public final void o() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9715, this, null);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9678, this, null);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void onPause() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9677, this, null);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9680, this, null);
    }

    public final void p() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9679, this, null);
    }

    public final void q() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9674, this, null);
    }

    public final void r() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9673, this, null);
    }

    public final PageOptions s() {
        return (PageOptions) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9676, this, null);
    }

    public com.wbl.ad.yzz.innerconfig.d.d t() {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9675, this, null);
    }

    public final boolean u() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9670, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void uploadFeedbackError(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9669, this, str);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void uploadFeedbackSuccess() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9672, this, null);
    }

    public final boolean v() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9671, this, null);
    }

    public final void w() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9666, this, null);
    }

    public final void x() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9665, this, null);
    }

    public final boolean y() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9668, this, null);
    }

    public final void z() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9667, this, null);
    }
}
