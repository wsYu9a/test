package com.wbl.ad.yzz.informationad;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.informationad.a;
import com.wbl.ad.yzz.network.b.b.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d extends com.wbl.ad.yzz.informationad.a {

    /* renamed from: f */
    public final com.wbl.ad.yzz.informationad.c f32770f;

    /* renamed from: g */
    public final com.wbl.ad.yzz.bean.b f32771g;

    /* renamed from: h */
    public final int f32772h;

    /* renamed from: i */
    public final View f32773i;

    /* renamed from: j */
    public final View f32774j;
    public final NativeAdContainer k;
    public final FrameLayout l;
    public final ImageView m;
    public final ImageView n;
    public final ImageView o;
    public final TextView p;
    public final ImageView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final ImageView u;
    public final com.wbl.ad.yzz.innerconfig.d.d v;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\u001f¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0005\u0010\u000fR$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0019\u0010#\u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"com/wbl/ad/yzz/informationad/d$a", "", "Lcom/wbl/ad/yzz/network/b/b/m;", "detailAd", "Lcom/wbl/ad/yzz/informationad/d$a;", "a", "(Lcom/wbl/ad/yzz/network/b/b/m;)Lcom/wbl/ad/yzz/informationad/d$a;", "Lcom/wbl/ad/yzz/bean/b;", "adDataBean", "(Lcom/wbl/ad/yzz/bean/b;)Lcom/wbl/ad/yzz/informationad/d$a;", "Lcom/wbl/ad/yzz/informationad/a$a;", "onInformationAdWrapListener", "(Lcom/wbl/ad/yzz/informationad/a$a;)Lcom/wbl/ad/yzz/informationad/d$a;", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "sceneCache", "(Lcom/wbl/ad/yzz/innerconfig/d/d;)Lcom/wbl/ad/yzz/informationad/d$a;", "c", "Lcom/wbl/ad/yzz/bean/b;", "()Lcom/wbl/ad/yzz/bean/b;", "setAdDataBean", "(Lcom/wbl/ad/yzz/bean/b;)V", com.kwad.sdk.ranger.e.TAG, "Lcom/wbl/ad/yzz/informationad/a$a;", "()Lcom/wbl/ad/yzz/informationad/a$a;", "setOnInformationAdWrapListener", "(Lcom/wbl/ad/yzz/informationad/a$a;)V", "d", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "()Lcom/wbl/ad/yzz/innerconfig/d/d;", "setSceneCache", "(Lcom/wbl/ad/yzz/innerconfig/d/d;)V", "Landroid/app/Activity;", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "context", "b", "Lcom/wbl/ad/yzz/network/b/b/m;", "()Lcom/wbl/ad/yzz/network/b/b/m;", "setDetailAd", "(Lcom/wbl/ad/yzz/network/b/b/m;)V", "<init>", "(Landroid/app/Activity;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* renamed from: a, reason: from kotlin metadata */
        @f.b.a.d
        public final Activity context;

        /* renamed from: b, reason: from kotlin metadata */
        @f.b.a.e
        public m detailAd;

        /* renamed from: c, reason: from kotlin metadata */
        @f.b.a.e
        public com.wbl.ad.yzz.bean.b adDataBean;

        /* renamed from: d, reason: from kotlin metadata */
        @f.b.a.e
        public com.wbl.ad.yzz.innerconfig.d.d sceneCache;

        /* renamed from: e */
        @f.b.a.e
        public a.InterfaceC0750a onInformationAdWrapListener;

        public a(@f.b.a.d Activity context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        public final com.wbl.ad.yzz.bean.b a() {
            return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12960, this, null);
        }

        public final a a(com.wbl.ad.yzz.bean.b adDataBean) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12959, this, adDataBean);
        }

        public final a a(a.InterfaceC0750a onInformationAdWrapListener) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12954, this, onInformationAdWrapListener);
        }

        public final a a(com.wbl.ad.yzz.innerconfig.d.d sceneCache) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12953, this, sceneCache);
        }

        public final a a(m detailAd) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12956, this, detailAd);
        }

        public final m b() {
            return (m) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12955, this, null);
        }

        public final a.InterfaceC0750a c() {
            return (a.InterfaceC0750a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12950, this, null);
        }

        public final com.wbl.ad.yzz.innerconfig.d.d d() {
            return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12949, this, null);
        }

        public final Activity getContext() {
            return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12952, this, null);
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12951, this, view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32782b;

        public c(com.wbl.ad.yzz.bean.b bVar) {
            this.f32782b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12946, this, view);
        }
    }

    /* renamed from: com.wbl.ad.yzz.informationad.d$d */
    public static final class ViewOnClickListenerC0751d implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32784b;

        public ViewOnClickListenerC0751d(com.wbl.ad.yzz.bean.b bVar) {
            this.f32784b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12945, this, view);
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12948, this, view);
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12947, this, view);
        }
    }

    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13038, this, view);
        }
    }

    public static final class h implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.e f32789b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32790c;

        public h(com.wbl.ad.yzz.bean.e eVar, com.wbl.ad.yzz.bean.b bVar) {
            this.f32790c = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13037, this, view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@f.b.a.d a builder, @f.b.a.e View view) {
        super(builder.getContext(), builder.c());
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f32770f = new com.wbl.ad.yzz.informationad.c();
        builder.b();
        this.f32771g = builder.a();
        this.v = builder.d();
        this.f32773i = view != null ? view.findViewById(R.id.cl_default_container) : null;
        if (view != null) {
            view.findViewById(R.id.fl_poster_or_video_container);
        }
        this.f32774j = view != null ? view.findViewById(R.id.cl_poster_or_video_container) : null;
        this.k = view != null ? (NativeAdContainer) view.findViewById(R.id.na_tencent_container) : null;
        this.l = view != null ? (FrameLayout) view.findViewById(R.id.fl_tencent_video_poster_container) : null;
        this.m = view != null ? (ImageView) view.findViewById(R.id.iv_poster_tencent) : null;
        this.n = view != null ? (ImageView) view.findViewById(R.id.iv_default_poster) : null;
        this.o = view != null ? (ImageView) view.findViewById(R.id.iv_logo) : null;
        this.p = view != null ? (TextView) view.findViewById(R.id.tv_logo) : null;
        if (view != null) {
        }
        if (view != null) {
        }
        this.q = view != null ? (ImageView) view.findViewById(R.id.image_icon) : null;
        this.r = view != null ? (TextView) view.findViewById(R.id.tv_app_name) : null;
        this.s = view != null ? (TextView) view.findViewById(R.id.tv_title) : null;
        this.t = view != null ? (TextView) view.findViewById(R.id.tv_button_now_view) : null;
        this.u = view != null ? (ImageView) view.findViewById(R.id.image_close) : null;
        int a2 = com.wbl.ad.yzz.util.h.a(a(), 8.0f);
        if (a2 <= 0) {
            this.f32772h = 16;
        } else {
            this.f32772h = a2;
        }
        i();
        f();
    }

    public static final /* synthetic */ FrameLayout a(d dVar) {
        return (FrameLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13040, null, dVar);
    }

    public static final /* synthetic */ ImageView b(d dVar) {
        return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13039, null, dVar);
    }

    public final void a(int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13034, this, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final void a(View.OnClickListener onClickListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13033, this, onClickListener);
    }

    public final void a(ImageView imageView, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13036, this, imageView, str);
    }

    public final void a(ImageView imageView, String str, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13035, this, imageView, str, bVar);
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13030, this, bVar);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13029, this, str);
    }

    public final void a(String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13032, this, str, str2);
    }

    public final void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13031, this, Boolean.valueOf(z));
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13026, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13025, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13028, this, null);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13027, this, null);
    }

    public final void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13054, this, null);
    }

    public final void i() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13053, this, null);
    }
}
