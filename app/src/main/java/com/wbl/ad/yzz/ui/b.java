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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.adapter.d.a;
import com.wbl.ad.yzz.adapter.quick.ScrollLinearLayoutManager;
import com.wbl.ad.yzz.bean.AdPageNeedData;
import com.wbl.ad.yzz.cashhongbao.c;
import com.wbl.ad.yzz.cashhongbao.d;
import com.wbl.ad.yzz.config.PageOptions;
import com.wbl.ad.yzz.feedback.b;
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
public final class b extends com.wbl.ad.yzz.ui.a {
    public com.wbl.ad.yzz.wigdet.h.b D0;
    public AdPageNeedData F;
    public int G;
    public int H;
    public ImageView I;
    public ImageView J;
    public f0 M;
    public FrameLayout N;
    public FrameLayout O;
    public RelativeLayout P;
    public View Q;
    public com.wbl.ad.yzz.gudie.d T;
    public com.wbl.ad.yzz.wigdet.h.d V;
    public AutoVerticalScrollTextView Y;
    public TextView Z;
    public RCRelativeLayout a0;
    public RelativeLayout b0;
    public com.wbl.ad.yzz.network.b.b.k c0;

    /* renamed from: f */
    public View f33960f;
    public com.wbl.ad.yzz.wigdet.k.d f0;

    /* renamed from: g */
    public com.wbl.ad.yzz.adapter.d.f f33961g;
    public View h0;

    /* renamed from: i */
    public ScrollLinearLayoutManager f33963i;
    public TextView i0;

    /* renamed from: j */
    public CountDownTimer f33964j;
    public TextView j0;
    public CountDownTimer k;
    public ImageView k0;
    public CountDownTimer l;
    public TextView l0;
    public TextView m0;
    public ProgressBar n0;
    public boolean o;
    public ImageView p;
    public int s0;

    /* renamed from: h */
    public final com.wbl.ad.yzz.ui.f.h f33962h = new com.wbl.ad.yzz.ui.f.h();
    public int m = 0;
    public int n = 0;
    public final com.wbl.ad.yzz.ui.f.g q = new com.wbl.ad.yzz.ui.f.g();
    public final com.wbl.ad.yzz.ui.f.c r = new com.wbl.ad.yzz.ui.f.c();
    public int s = 0;
    public int t = 0;
    public final com.wbl.ad.yzz.ui.f.b u = new com.wbl.ad.yzz.ui.f.b();
    public volatile boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public boolean z = false;
    public volatile boolean A = false;
    public boolean B = true;
    public boolean C = false;
    public boolean D = false;
    public boolean E = true;
    public boolean K = false;
    public int L = 0;
    public boolean R = false;
    public final com.wbl.ad.yzz.innerconfig.a S = new com.wbl.ad.yzz.innerconfig.a();
    public Handler U = new Handler(Looper.getMainLooper());
    public final com.wbl.ad.yzz.adapter.a W = new com.wbl.ad.yzz.adapter.a();
    public int X = 10;
    public final com.wbl.ad.yzz.cashhongbao.b d0 = new com.wbl.ad.yzz.cashhongbao.b();
    public final com.wbl.ad.yzz.c.c.a e0 = new com.wbl.ad.yzz.c.c.a();
    public com.wbl.ad.yzz.help.k g0 = new com.wbl.ad.yzz.help.k();
    public boolean o0 = false;
    public int p0 = -1;
    public volatile boolean q0 = false;
    public boolean r0 = false;
    public Runnable t0 = new l();
    public long u0 = 0;
    public Runnable v0 = new m();
    public boolean w0 = false;
    public long x0 = 0;
    public com.wbl.ad.yzz.ui.f.j y0 = new com.wbl.ad.yzz.ui.f.j();
    public long z0 = 0;
    public b.a A0 = new o();
    public d.c B0 = new p();
    public Runnable C0 = new r();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9263, this, null);
        }
    }

    public class a0 extends CountDownTimer {
        public a0(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9261, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9264, this, Long.valueOf(j2));
        }
    }

    /* renamed from: com.wbl.ad.yzz.ui.b$b */
    public class C0786b implements com.wbl.ad.yzz.wigdet.d {

        /* renamed from: com.wbl.ad.yzz.ui.b$b$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9258, this, null);
            }
        }

        public C0786b() {
        }

        @Override // com.wbl.ad.yzz.wigdet.d
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9255, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.d
        public void a(boolean z, boolean z2, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9250, this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.wigdet.d
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9249, this, null);
        }
    }

    public class b0 implements GestureDetector.OnGestureListener {
        public b0(b bVar) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9257, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9260, this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3));
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9259, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9254, this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3));
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9253, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9256, this, motionEvent);
        }
    }

    public class c implements com.wbl.ad.yzz.adapter.c.b {
        public c() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9277, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9280, this, bVar, str, str2, str3, str4);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9279, this, bVar, str, str2, str3, str4, str5);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9274, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9273, this, str, str2, bVar);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(boolean z, boolean z2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9276, this, Boolean.valueOf(z), Boolean.valueOf(z2), str);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9275, this, str, str2, bVar);
        }
    }

    public class c0 implements RecyclerView.OnItemTouchListener {

        /* renamed from: a */
        public final /* synthetic */ GestureDetector f33970a;

        public c0(GestureDetector gestureDetector) {
            this.f33970a = gestureDetector;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9252, this, recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9251, this, Boolean.valueOf(z));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9278, this, recyclerView, motionEvent);
        }
    }

    public class d extends com.wbl.ad.yzz.adapter.c.a {
        public d() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.a
        public void a(int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9269, this, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // com.wbl.ad.yzz.adapter.c.a
        public void a(int[] iArr) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9272, this, iArr);
        }
    }

    public class d0 implements Runnable {
        public d0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9270, this, null);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9266, this, view);
        }
    }

    public class e0 implements a.InterfaceC0679a {
        public e0(b bVar) {
        }

        @Override // com.wbl.ad.yzz.adapter.d.a.InterfaceC0679a
        public void a(View view, com.wbl.ad.yzz.bean.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9271, this, view, bVar, Integer.valueOf(i2));
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9268, this, view);
        }
    }

    public static class f0 extends Handler {

        /* renamed from: a */
        public final WeakReference<ADActivity> f33976a;

        /* renamed from: b */
        public final WeakReference<b> f33977b;

        public f0(ADActivity aDActivity, b bVar) {
            this.f33976a = new WeakReference<>(aDActivity);
            this.f33977b = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9265, this, message);
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9267, this, view);
        }
    }

    public class h implements AutoVerticalScrollTextView.b {
        public h() {
        }

        @Override // com.wbl.ad.yzz.wigdet.AutoVerticalScrollTextView.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9230, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.wigdet.AutoVerticalScrollTextView.b
        public void b(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9229, this, Integer.valueOf(i2));
        }
    }

    public class i implements View.OnTouchListener {
        public i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9232, this, view, motionEvent);
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9231, this, view);
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9226, this, null);
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9225, this, null);
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9228, this, null);
        }
    }

    public class n implements d.b0<com.wbl.ad.yzz.network.b.b.n> {
        public n() {
        }

        public void a(String str, com.wbl.ad.yzz.network.b.b.n nVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9227, this, str, nVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9222, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, com.wbl.ad.yzz.network.b.b.n nVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9221, this, str, nVar);
        }
    }

    public class o implements b.a {
        public o() {
        }

        @Override // com.wbl.ad.yzz.feedback.b.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9224, this, null);
        }

        @Override // com.wbl.ad.yzz.feedback.b.a
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9223, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.feedback.b.a
        public void a(UploadFeedbackReq uploadFeedbackReq) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9218, this, uploadFeedbackReq);
        }
    }

    public class p implements d.c {
        public p() {
        }

        @Override // com.wbl.ad.yzz.wigdet.h.d.c
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9217, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.h.d.c
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9220, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.h.d.c
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9219, this, null);
        }
    }

    public class q implements a.j {
        public q() {
        }

        @Override // com.wbl.ad.yzz.util.a.j
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9246, this, null);
        }
    }

    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9245, this, null);
        }
    }

    public class s implements b.h {

        /* renamed from: a */
        public final /* synthetic */ k0.b f33990a;

        public s(k0.b bVar) {
            this.f33990a = bVar;
        }

        @Override // com.wbl.ad.yzz.wigdet.h.b.h
        public void dismiss() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9248, this, null);
        }
    }

    public class t implements a.j {
        public t() {
        }

        @Override // com.wbl.ad.yzz.util.a.j
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9247, this, null);
        }
    }

    public class u implements c.a {

        /* renamed from: a */
        public final /* synthetic */ Activity f33993a;

        public u(Activity activity) {
            this.f33993a = activity;
        }

        @Override // com.wbl.ad.yzz.cashhongbao.c.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9242, this, null);
        }

        @Override // com.wbl.ad.yzz.cashhongbao.c.a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9241, this, null);
        }
    }

    public class v implements j.a {
        public v() {
        }

        @Override // com.wbl.ad.yzz.ui.f.j.a
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9244, this, Integer.valueOf(i2));
        }
    }

    public class w implements d.b {
        public w() {
        }

        @Override // com.wbl.ad.yzz.cashhongbao.d.b
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9243, this, null);
        }

        @Override // com.wbl.ad.yzz.cashhongbao.d.b
        public void a(e.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9238, this, bVar);
        }

        @Override // com.wbl.ad.yzz.cashhongbao.d.b
        public void a(com.wbl.ad.yzz.network.b.b.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9237, this, eVar);
        }
    }

    public class x implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.e f33997a;

        /* renamed from: b */
        public final /* synthetic */ d.b f33998b;

        public x(com.wbl.ad.yzz.network.b.b.e eVar, d.b bVar) {
            this.f33997a = eVar;
            this.f33998b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9240, this, null);
        }
    }

    public class y extends CountDownTimer {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.u f34000a;

        /* renamed from: b */
        public final /* synthetic */ int f34001b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(long j2, long j3, com.wbl.ad.yzz.network.b.b.u uVar, int i2) {
            super(j2, j3);
            this.f34000a = uVar;
            this.f34001b = i2;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9239, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9234, this, Long.valueOf(j2));
        }
    }

    public class z extends CountDownTimer {
        public z(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9233, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9236, this, Long.valueOf(j2));
        }
    }

    public static /* synthetic */ View A(b bVar) {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9235, null, bVar);
    }

    public static /* synthetic */ Handler C(b bVar) {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9325, null, bVar);
    }

    public static /* synthetic */ TextView E(b bVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9327, null, bVar);
    }

    public static /* synthetic */ ScrollLinearLayoutManager G(b bVar) {
        return (ScrollLinearLayoutManager) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9321, null, bVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.wigdet.k.d H(b bVar) {
        return (com.wbl.ad.yzz.wigdet.k.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9324, null, bVar);
    }

    public static /* synthetic */ f0 K(b bVar) {
        return (f0) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9317, null, bVar);
    }

    public static /* synthetic */ View L(b bVar) {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9320, null, bVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.adapter.d.f R(b bVar) {
        return (com.wbl.ad.yzz.adapter.d.f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9342, null, bVar);
    }

    public static /* synthetic */ RCRelativeLayout T(b bVar) {
        return (RCRelativeLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9344, null, bVar);
    }

    public static /* synthetic */ Runnable V(b bVar) {
        return (Runnable) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9338, null, bVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.cashhongbao.b Y(b bVar) {
        return (com.wbl.ad.yzz.cashhongbao.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9339, null, bVar);
    }

    public static /* synthetic */ CountDownTimer c(b bVar) {
        return (CountDownTimer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9285, null, bVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.help.k s(b bVar) {
        return (com.wbl.ad.yzz.help.k) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9391, null, bVar);
    }

    public static /* synthetic */ AdPageNeedData t(b bVar) {
        return (AdPageNeedData) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9386, null, bVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.ui.f.b v(b bVar) {
        return (com.wbl.ad.yzz.ui.f.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9388, null, bVar);
    }

    public final void A() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9383, this, null);
    }

    public final void B() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9378, this, null);
    }

    public final void C() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9377, this, null);
    }

    public final void D() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9380, this, null);
    }

    public final void E() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9379, this, null);
    }

    public final void F() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9406, this, null);
    }

    public final boolean G() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9405, this, null);
    }

    public final void H() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9408, this, null);
    }

    public final boolean I() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9407, this, null);
    }

    public final void J() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9402, this, null);
    }

    public final void K() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9401, this, null);
    }

    public final void L() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9404, this, null);
    }

    public final void M() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9403, this, null);
    }

    public final void N() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9398, this, null);
    }

    public final void O() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9397, this, null);
    }

    public void P() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9400, this, null);
    }

    public final void Q() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9399, this, null);
    }

    public final void R() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9394, this, null);
    }

    public final void S() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9393, this, null);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9396, this, null);
    }

    public final void a(int i2, String str, String str2, String str3, String str4, String str5, String str6, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9395, this, Integer.valueOf(i2), str, str2, str3, str4, str5, str6, bVar);
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9358, this, bVar, str, str2, str3, str4, str5);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar, boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9357, this, dVar, Boolean.valueOf(z2));
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void a(com.wbl.ad.yzz.innerconfig.d.e eVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9360, this, eVar);
    }

    public final void a(j0 j0Var, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9359, this, j0Var, Integer.valueOf(i2));
    }

    public final void a(com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9354, this, uVar);
    }

    public void a(Object obj) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9353, this, obj);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9356, this, str);
    }

    public final void a(String str, ImageView imageView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9355, this, str, imageView);
    }

    public final void a(String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9350, this, str, str2);
    }

    public final void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9349, this, str, str2, bVar);
    }

    public final void a(String str, Map<String, String> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9352, this, str, map);
    }

    public final void a(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9351, this, Boolean.valueOf(z2));
    }

    public final void a(boolean z2, long j2, k0 k0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9346, this, Boolean.valueOf(z2), Long.valueOf(j2), k0Var);
    }

    public final void a(boolean z2, long j2, k0 k0Var, boolean z3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9345, this, Boolean.valueOf(z2), Long.valueOf(j2), k0Var, Boolean.valueOf(z3));
    }

    public final void a(boolean z2, String str, boolean z3, int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9348, this, Boolean.valueOf(z2), str, Boolean.valueOf(z3), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final void a(boolean z2, boolean z3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9347, this, Boolean.valueOf(z2), Boolean.valueOf(z3));
    }

    public final void a(boolean z2, boolean z3, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9374, this, Boolean.valueOf(z2), Boolean.valueOf(z3), str);
    }

    public void a(boolean z2, boolean z3, boolean z4, boolean z5) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9373, this, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5));
    }

    public final boolean a(k0 k0Var, k0.b bVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9376, this, k0Var, bVar);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9375, this, null);
    }

    public final void b(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9370, this, activity);
    }

    public final void b(com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9369, this, uVar);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void b(ADActivity aDActivity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9372, this, aDActivity);
    }

    public final void b(Object obj) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9371, this, obj);
    }

    public final void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9366, this, str, str2, bVar);
    }

    public final void b(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9365, this, Boolean.valueOf(z2));
    }

    public void b(boolean z2, boolean z3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9368, this, Boolean.valueOf(z2), Boolean.valueOf(z3));
    }

    public final int c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9367, this, null);
    }

    public final void c(com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9362, this, uVar);
    }

    public final void c(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9361, this, Boolean.valueOf(z2));
    }

    public final boolean c(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9364, this, Integer.valueOf(i2));
    }

    @Override // com.wbl.ad.yzz.ui.d
    public int d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9363, this, null);
    }

    public final void d(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9454, this, Integer.valueOf(i2));
    }

    public final void d(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9453, this, Boolean.valueOf(z2));
    }

    @Override // com.wbl.ad.yzz.ui.d
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9456, this, keyEvent);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9455, this, null);
    }

    public void e(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9450, this, Integer.valueOf(i2));
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9449, this, null);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void finish() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9452, this, null);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9451, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void getConfErr(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9446, this, str);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void getConfSucess(com.wbl.ad.yzz.network.b.b.k kVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9445, this, kVar);
    }

    public final void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9448, this, null);
    }

    public final void i() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9447, this, null);
    }

    public final void j() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9442, this, null);
    }

    public final void k() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9441, this, null);
    }

    public final void l() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9444, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadAdError(com.wbl.ad.yzz.d.c.a<Object> aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9443, this, aVar);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadAdSuccess(List<com.wbl.ad.yzz.adapter.d.b> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9470, this, list);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadLeaveError(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9469, this, str);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadLeaveSuccess(com.wbl.ad.yzz.network.b.b.a0 a0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9472, this, a0Var);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadPageMsgError(boolean z2, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9471, this, Boolean.valueOf(z2), str, str2);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadPageMsgSuccess(boolean z2, Object obj, com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9466, this, Boolean.valueOf(z2), obj, uVar);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadUpRpError(int i2, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9465, this, Integer.valueOf(i2), str, str2);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadUpRpSuccess(k0 k0Var, int i2, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9468, this, k0Var, Integer.valueOf(i2), bVar);
    }

    public final void m() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9467, this, null);
    }

    public final void n() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9462, this, null);
    }

    public final int o() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9461, this, null);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9464, this, null);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void onPause() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9463, this, null);
    }

    @Override // com.wbl.ad.yzz.ui.d
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9458, this, null);
    }

    public final void p() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9457, this, null);
    }

    public final void q() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9460, this, null);
    }

    public final void r() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9459, this, null);
    }

    public final PageOptions s() {
        return (PageOptions) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9422, this, null);
    }

    public com.wbl.ad.yzz.innerconfig.d.d t() {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9421, this, null);
    }

    public final boolean u() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9424, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void uploadFeedbackError(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9423, this, str);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void uploadFeedbackSuccess() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9418, this, null);
    }

    public final boolean v() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9417, this, null);
    }

    public final void w() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9420, this, null);
    }

    public final void x() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9419, this, null);
    }

    public final boolean y() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9414, this, null);
    }

    public final void z() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9413, this, null);
    }
}
