package com.wbl.ad.yzz.informationad;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.wbl.ad.yzz.informationad.a;
import com.wbl.ad.yzz.network.b.b.m;
import com.wbl.ad.yzz.util.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e extends com.wbl.ad.yzz.informationad.a {

    /* renamed from: f */
    public com.wbl.ad.yzz.bean.b f32791f;

    /* renamed from: g */
    public View f32792g;

    /* renamed from: h */
    public TextView f32793h;

    /* renamed from: i */
    public TextView f32794i;

    /* renamed from: j */
    public View f32795j;
    public ImageView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public NativeAdContainer o;
    public FrameLayout p;
    public ImageView q;
    public View r;
    public final int s;
    public final com.wbl.ad.yzz.innerconfig.d.d t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u0005\u0010\u000bR$\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0005\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010!\u001a\u0004\b\u0005\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"com/wbl/ad/yzz/informationad/e$a", "", "Lcom/wbl/ad/yzz/informationad/a$a;", "onInformationAdWrapListener", "Lcom/wbl/ad/yzz/informationad/e$a;", "a", "(Lcom/wbl/ad/yzz/informationad/a$a;)Lcom/wbl/ad/yzz/informationad/e$a;", "Landroid/app/Activity;", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "(Landroid/app/Activity;)V", "context", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "d", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "()Lcom/wbl/ad/yzz/innerconfig/d/d;", "(Lcom/wbl/ad/yzz/innerconfig/d/d;)V", "sceneCache", "Lcom/wbl/ad/yzz/network/b/b/m;", "b", "Lcom/wbl/ad/yzz/network/b/b/m;", "()Lcom/wbl/ad/yzz/network/b/b/m;", "setDetailAd", "(Lcom/wbl/ad/yzz/network/b/b/m;)V", "detailAd", com.kwad.sdk.ranger.e.TAG, "Lcom/wbl/ad/yzz/informationad/a$a;", "c", "()Lcom/wbl/ad/yzz/informationad/a$a;", "setOnInformationAdWrapListener", "(Lcom/wbl/ad/yzz/informationad/a$a;)V", "Lcom/wbl/ad/yzz/bean/b;", "Lcom/wbl/ad/yzz/bean/b;", "()Lcom/wbl/ad/yzz/bean/b;", "setAdDataBean", "(Lcom/wbl/ad/yzz/bean/b;)V", "adDataBean", "<init>", "()V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* renamed from: a, reason: from kotlin metadata */
        @f.b.a.e
        public Activity context;

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

        public final com.wbl.ad.yzz.bean.b a() {
            return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13056, this, null);
        }

        public final a a(a.InterfaceC0750a onInformationAdWrapListener) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13055, this, onInformationAdWrapListener);
        }

        public final void a(Activity activity) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13050, this, activity);
        }

        public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13049, this, dVar);
        }

        public final m b() {
            return (m) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13052, this, null);
        }

        public final a.InterfaceC0750a c() {
            return (a.InterfaceC0750a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13051, this, null);
        }

        public final com.wbl.ad.yzz.innerconfig.d.d d() {
            return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13046, this, null);
        }

        public final Activity getContext() {
            return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13045, this, null);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32802b;

        public b(com.wbl.ad.yzz.bean.b bVar) {
            this.f32802b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13048, this, view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32804b;

        public c(com.wbl.ad.yzz.bean.b bVar) {
            this.f32804b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13047, this, view);
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13042, this, view);
        }
    }

    /* renamed from: com.wbl.ad.yzz.informationad.e$e */
    public static final class ViewOnClickListenerC0752e implements View.OnClickListener {
        public ViewOnClickListenerC0752e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13041, this, view);
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13044, this, view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.e f32809b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32810c;

        public g(com.wbl.ad.yzz.bean.e eVar, com.wbl.ad.yzz.bean.b bVar) {
            this.f32810c = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13043, this, view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@f.b.a.d a builder, @f.b.a.e View view) {
        super(builder.getContext(), builder.c());
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.b();
        this.f32791f = builder.a();
        this.t = builder.d();
        a(view);
        int a2 = h.a(a(), 8.0f);
        if (a2 <= 0) {
            this.s = 16;
        } else {
            this.s = a2;
        }
        d();
        a(this.f32791f);
    }

    public static final /* synthetic */ View a(e eVar) {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13006, null, eVar);
    }

    public static final /* synthetic */ FrameLayout b(e eVar) {
        return (FrameLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13005, null, eVar);
    }

    public static final /* synthetic */ ImageView c(e eVar) {
        return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13008, null, eVar);
    }

    public final void a(int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13007, this, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final void a(View.OnClickListener onClickListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13002, this, onClickListener);
    }

    public final void a(View view) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13001, this, view);
    }

    public final void a(ImageView imageView, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13004, this, imageView, str);
    }

    public final void a(ImageView imageView, String str, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13003, this, imageView, str, bVar);
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12998, this, bVar);
    }

    public final void a(m mVar, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12997, this, mVar, bVar);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13000, this, str);
    }

    public final void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12999, this, Boolean.valueOf(z));
    }

    public final void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12994, this, str);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12993, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12996, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12995, this, null);
    }
}
