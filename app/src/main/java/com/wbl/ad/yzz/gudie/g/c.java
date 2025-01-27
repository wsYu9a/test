package com.wbl.ad.yzz.gudie.g;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.c.c.a;
import com.wbl.ad.yzz.counttimer.b;
import com.wbl.ad.yzz.dialog.d;
import com.wbl.ad.yzz.feedback.b;
import com.wbl.ad.yzz.gudie.b;
import com.wbl.ad.yzz.gudie.g.d;
import com.wbl.ad.yzz.network.b.b.u;
import java.util.List;

/* loaded from: classes5.dex */
public final class c implements com.wbl.ad.yzz.gudie.g.d {
    public com.wbl.ad.yzz.buryingpoint.c.a A;
    public final com.wbl.ad.yzz.adapter.c.b B;
    public int C;
    public com.wbl.ad.yzz.wigdet.k.d E;
    public com.wbl.ad.yzz.gudie.g.b F;
    public final com.wbl.ad.yzz.innerconfig.d.j I;
    public GestureDetector J;

    /* renamed from: a */
    public final int f32588a;

    /* renamed from: b */
    public final com.wbl.ad.yzz.gudie.g.a f32589b;

    /* renamed from: c */
    public final com.wbl.ad.yzz.gudie.f.b f32590c;

    /* renamed from: d */
    public View f32591d;

    /* renamed from: e */
    public final RecyclerView f32592e;

    /* renamed from: f */
    public com.wbl.ad.yzz.gudie.b f32593f;

    /* renamed from: g */
    public final d f32594g;

    /* renamed from: h */
    public final C0743c f32595h;

    /* renamed from: i */
    public final Activity f32596i;

    /* renamed from: j */
    public com.wbl.ad.yzz.adapter.c.b f32597j;
    public u k;
    public com.wbl.ad.yzz.network.b.b.k l;
    public final b.g m;
    public com.wbl.ad.yzz.feedback.a n;
    public final com.wbl.ad.yzz.network.b.b.o o;
    public final b.a p;
    public final d.a q;
    public com.wbl.ad.yzz.counttimer.b r;
    public final LinearLayout s;
    public final ImageView t;
    public final ImageView u;
    public final ImageView v;
    public final ImageView w;
    public GestureDetector x;
    public boolean y;
    public final com.wbl.ad.yzz.buryingpoint.c.a z;
    public boolean D = true;
    public final com.wbl.ad.yzz.c.c.a G = new com.wbl.ad.yzz.c.c.a();
    public final Handler H = new Handler(Looper.getMainLooper());
    public final Runnable K = new i();

    public static final class a implements b.g {

        /* renamed from: com.wbl.ad.yzz.gudie.g.c$a$a */
        public static final class C0742a implements a.InterfaceC0697a {

            /* renamed from: b */
            public final /* synthetic */ int f32600b;

            /* renamed from: c */
            public final /* synthetic */ com.wbl.ad.yzz.bean.b f32601c;

            public C0742a(int i2, com.wbl.ad.yzz.bean.b bVar) {
                this.f32600b = i2;
                this.f32601c = bVar;
            }

            @Override // com.wbl.ad.yzz.c.c.a.InterfaceC0697a
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13454, this, null);
            }

            @Override // com.wbl.ad.yzz.c.c.a.InterfaceC0697a
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13453, this, null);
            }

            @Override // com.wbl.ad.yzz.c.c.a.InterfaceC0697a
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13456, this, null);
            }
        }

        public a() {
        }

        @Override // com.wbl.ad.yzz.gudie.b.g
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13455, this, null);
        }

        @Override // com.wbl.ad.yzz.gudie.b.g
        public void a(View view, com.wbl.ad.yzz.bean.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13450, this, view, bVar, Integer.valueOf(i2));
        }
    }

    public static final class b implements com.wbl.ad.yzz.adapter.c.b {
        public b() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13449, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13452, this, bVar, str, str2, str3, str4);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13451, this, bVar, str, str2, str3, str4, str5);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13446, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13445, this, str, str2, bVar);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(boolean z, boolean z2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13448, this, Boolean.valueOf(z), Boolean.valueOf(z2), str);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13447, this, str, str2, bVar);
        }
    }

    /* renamed from: com.wbl.ad.yzz.gudie.g.c$c */
    public static final class C0743c {

        /* renamed from: a */
        @f.b.a.e
        public final ImageView f32603a;

        /* renamed from: b */
        @f.b.a.e
        public final ImageView f32604b;

        /* renamed from: c */
        @f.b.a.e
        public final LinearLayout f32605c;

        /* renamed from: d */
        @f.b.a.e
        public final TextView f32606d;

        /* renamed from: e */
        @f.b.a.e
        public final TextView f32607e;

        /* renamed from: f */
        @f.b.a.e
        public final TextView f32608f;

        /* renamed from: com.wbl.ad.yzz.gudie.g.c$c$a */
        public static final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13442, this, null);
            }
        }

        public C0743c(@f.b.a.e View view) {
            this.f32603a = view != null ? (ImageView) view.findViewById(R.id.iv_footer_hint_1) : null;
            this.f32604b = view != null ? (ImageView) view.findViewById(R.id.iv_footer_hint_2) : null;
            this.f32605c = view != null ? (LinearLayout) view.findViewById(R.id.ll_need_help_container) : null;
            this.f32606d = view != null ? (TextView) view.findViewById(R.id.tv_footer_hint_2) : null;
            this.f32607e = view != null ? (TextView) view.findViewById(R.id.tv_footer_hint_3) : null;
            this.f32608f = view != null ? (TextView) view.findViewById(R.id.tv_member_tip) : null;
        }

        public final TextView a() {
            return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13441, this, null);
        }

        public final void a(Context context, com.wbl.ad.yzz.network.b.b.k kVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13444, this, context, kVar);
        }

        public final void a(View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13443, this, onClickListener);
        }

        public final void b(View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13470, this, onClickListener);
        }

        public final void c(View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13469, this, onClickListener);
        }

        public final void d(View.OnClickListener onClickListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13472, this, onClickListener);
        }
    }

    public static final class d {

        /* renamed from: a */
        @f.b.a.e
        public final TextView f32610a;

        /* renamed from: b */
        @f.b.a.e
        public final TextView f32611b;

        public d(@f.b.a.e View view) {
            this.f32610a = view != null ? (TextView) view.findViewById(R.id.tv_header_hint_1) : null;
            if (view != null) {
            }
            this.f32611b = view != null ? (TextView) view.findViewById(R.id.tv_header_hint_2_1) : null;
        }

        public final void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13471, this, str, str2);
        }
    }

    public static final class e implements b.a {
        public e() {
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void a(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13466, this, Long.valueOf(j2));
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13465, this, null);
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13468, this, null);
        }
    }

    public static final class f implements GestureDetector.OnGestureListener {
        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13467, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13462, this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3));
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13461, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13464, this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3));
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13463, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13458, this, motionEvent);
        }
    }

    public static final class g implements GestureDetector.OnGestureListener {
        public g() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13457, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13460, this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3));
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13459, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13550, this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3));
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13549, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13552, this, motionEvent);
        }
    }

    public static final class h extends com.wbl.ad.yzz.adapter.c.a {

        /* renamed from: b */
        public final /* synthetic */ LinearLayoutManager f32615b;

        /* renamed from: c */
        public final /* synthetic */ Activity f32616c;

        public h(LinearLayoutManager linearLayoutManager, Activity activity) {
            this.f32615b = linearLayoutManager;
            this.f32616c = activity;
        }

        @Override // com.wbl.ad.yzz.adapter.c.a
        public void a(int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13551, this, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // com.wbl.ad.yzz.adapter.c.a
        public void a(int[] iArr) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13546, this, iArr);
        }
    }

    public static final class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13545, this, null);
        }
    }

    public static final class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13548, this, view);
        }
    }

    public static final class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13547, this, view);
        }
    }

    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13542, this, view);
        }
    }

    public static final class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13541, this, view);
        }
    }

    public static final class n implements RecyclerView.OnItemTouchListener {
        public n() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13544, this, recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13543, this, Boolean.valueOf(z));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13538, this, recyclerView, motionEvent);
        }
    }

    public static final class o implements d.b {
        public o() {
        }

        @Override // com.wbl.ad.yzz.dialog.d.b
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13537, this, null);
        }
    }

    public static final class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13540, this, null);
        }
    }

    public c(int i2, @f.b.a.e Activity activity, @f.b.a.e View view, @f.b.a.e u uVar, @f.b.a.e com.wbl.ad.yzz.network.b.b.k kVar, int i3, @f.b.a.e com.wbl.ad.yzz.network.b.b.o oVar, @f.b.a.e com.wbl.ad.yzz.innerconfig.d.j jVar, @f.b.a.e b.a aVar, @f.b.a.e d.a aVar2) {
        this.f32591d = view;
        this.k = uVar;
        this.l = kVar;
        this.o = oVar;
        this.p = aVar;
        this.q = aVar2;
        this.f32588a = i2;
        this.f32596i = activity;
        this.C = i3;
        this.f32592e = view != null ? (RecyclerView) view.findViewById(R.id.recyclerview_guide) : null;
        View view2 = this.f32591d;
        if (view2 != null) {
        }
        View view3 = this.f32591d;
        this.s = view3 != null ? (LinearLayout) view3.findViewById(R.id.ll_moreInfo_container) : null;
        View view4 = this.f32591d;
        if (view4 != null) {
        }
        View view5 = this.f32591d;
        this.t = view5 != null ? (ImageView) view5.findViewById(R.id.moreInfoPopupTip_iv) : null;
        View view6 = this.f32591d;
        this.v = view6 != null ? (ImageView) view6.findViewById(R.id.iv_ad_guide_animation_1) : null;
        View view7 = this.f32591d;
        this.w = view7 != null ? (ImageView) view7.findViewById(R.id.iv_ad_guide_animation_2) : null;
        View view8 = this.f32591d;
        this.u = view8 != null ? (ImageView) view8.findViewById(R.id.iv_guide_loading) : null;
        this.f32594g = new d(this.f32591d);
        this.f32595h = new C0743c(this.f32591d);
        this.I = jVar;
        try {
            this.F = new com.wbl.ad.yzz.gudie.g.b(this.f32591d, activity, jVar != null ? jVar.j() : null);
        } catch (Throwable th) {
            com.wbl.ad.yzz.network.f.f.a(th);
        }
        this.m = new a();
        o();
        this.B = new b();
        p();
        m();
        this.y = true;
        com.wbl.ad.yzz.gudie.g.a aVar3 = new com.wbl.ad.yzz.gudie.g.a(this);
        this.f32589b = aVar3;
        com.wbl.ad.yzz.gudie.f.a aVar4 = new com.wbl.ad.yzz.gudie.f.a(this.f32596i, jVar);
        this.f32590c = aVar4;
        aVar4.a(aVar3);
        this.z = new com.wbl.ad.yzz.buryingpoint.c.a(this.f32596i);
        u();
        n();
        c(4);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.bean.b a(c cVar, int i2) {
        return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13539, null, cVar, Integer.valueOf(i2));
    }

    public static final /* synthetic */ com.wbl.ad.yzz.gudie.b b(c cVar) {
        return (com.wbl.ad.yzz.gudie.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13562, null, cVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.network.b.b.k c(c cVar) {
        return (com.wbl.ad.yzz.network.b.b.k) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13564, null, cVar);
    }

    public static final /* synthetic */ Activity d(c cVar) {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13563, null, cVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.adapter.c.b f(c cVar) {
        return (com.wbl.ad.yzz.adapter.c.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13557, null, cVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.adapter.c.b g(c cVar) {
        return (com.wbl.ad.yzz.adapter.c.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13560, null, cVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.buryingpoint.c.a h(c cVar) {
        return (com.wbl.ad.yzz.buryingpoint.c.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13559, null, cVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.c.c.a i(c cVar) {
        return (com.wbl.ad.yzz.c.c.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13554, null, cVar);
    }

    public static final /* synthetic */ d.a j(c cVar) {
        return (d.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13553, null, cVar);
    }

    public static final /* synthetic */ RecyclerView k(c cVar) {
        return (RecyclerView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13556, null, cVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.j l(c cVar) {
        return (com.wbl.ad.yzz.innerconfig.d.j) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13555, null, cVar);
    }

    public static final /* synthetic */ GestureDetector m(c cVar) {
        return (GestureDetector) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13518, null, cVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.wigdet.k.d o(c cVar) {
        return (com.wbl.ad.yzz.wigdet.k.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13520, null, cVar);
    }

    public final com.wbl.ad.yzz.bean.b a(int i2) {
        return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13509, this, Integer.valueOf(i2));
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13512, this, null);
    }

    public final void a(com.wbl.ad.yzz.adapter.c.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13511, this, bVar);
    }

    @Override // com.wbl.ad.yzz.gudie.g.d
    public void a(com.wbl.ad.yzz.adrequest.c.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13506, this, bVar);
    }

    @Override // com.wbl.ad.yzz.gudie.g.d
    public void a(List<com.wbl.ad.yzz.network.b.b.d> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13505, this, list);
    }

    @Override // com.wbl.ad.yzz.gudie.g.d
    public void a(List<com.wbl.ad.yzz.adapter.d.b> list, com.wbl.ad.yzz.adrequest.c.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13508, this, list, bVar);
    }

    public final boolean a(MotionEvent motionEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13507, this, motionEvent);
    }

    public final boolean a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13534, this, dVar);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13533, this, null);
    }

    public final void b(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13536, this, Integer.valueOf(i2));
    }

    public final void c(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13535, this, Integer.valueOf(i2));
    }

    public final boolean c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13530, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13529, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13532, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13531, this, null);
    }

    public final String g() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13526, this, null);
    }

    public Context h() {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13525, this, null);
    }

    public final int i() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13528, this, null);
    }

    public final void j() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13527, this, null);
    }

    public final void k() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13522, this, null);
    }

    public final void l() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13521, this, null);
    }

    public final void m() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13524, this, null);
    }

    public final void n() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13523, this, null);
    }

    public final void o() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13614, this, null);
    }

    public final void p() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13613, this, null);
    }

    public final void q() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13616, this, null);
    }

    public final void r() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13615, this, null);
    }

    public final boolean s() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13610, this, null);
    }

    public final void t() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13609, this, null);
    }

    public final void u() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13612, this, null);
    }

    public final void v() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13611, this, null);
    }

    public final void w() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13606, this, null);
    }

    public final void x() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13605, this, null);
    }

    public final void y() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13608, this, null);
    }

    public final void z() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13607, this, null);
    }
}
