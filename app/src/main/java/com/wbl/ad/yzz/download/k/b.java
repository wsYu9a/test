package com.wbl.ad.yzz.download.k;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.network.b.b.k;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.util.h;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a */
    public final Context f32120a;

    /* renamed from: b */
    public final View f32121b;

    /* renamed from: c */
    public final ImageView f32122c;

    /* renamed from: d */
    public final TextView f32123d;

    /* renamed from: e */
    public final TextView f32124e;

    /* renamed from: f */
    public final ImageView f32125f;

    /* renamed from: g */
    public final ImageView f32126g;

    /* renamed from: h */
    public final TextView f32127h;

    /* renamed from: i */
    public final TextView f32128i;

    /* renamed from: j */
    public final ImageView f32129j;
    public final View k;
    public final int l;
    public final com.wbl.ad.yzz.bean.b m;
    public final InterfaceC0720b n;
    public final u o;

    @e
    public Handler p;
    public boolean q;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0015¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0005\u0010\u000fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0019\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0010\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001a\u0010!\"\u0004\b\"\u0010#R$\u0010)\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"com/wbl/ad/yzz/download/k/b$a", "", "Lcom/wbl/ad/yzz/bean/b;", "bean", "Lcom/wbl/ad/yzz/download/k/b$a;", "a", "(Lcom/wbl/ad/yzz/bean/b;)Lcom/wbl/ad/yzz/download/k/b$a;", "Lcom/wbl/ad/yzz/download/k/b$b;", "installationFailListener", "(Lcom/wbl/ad/yzz/download/k/b$b;)Lcom/wbl/ad/yzz/download/k/b$a;", "Lcom/wbl/ad/yzz/network/b/b/u;", "getPageMsgRes", "(Lcom/wbl/ad/yzz/network/b/b/u;)Lcom/wbl/ad/yzz/download/k/b$a;", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "sceneCache", "(Lcom/wbl/ad/yzz/innerconfig/d/d;)Lcom/wbl/ad/yzz/download/k/b$a;", "b", "Lcom/wbl/ad/yzz/bean/b;", "()Lcom/wbl/ad/yzz/bean/b;", "setBean", "(Lcom/wbl/ad/yzz/bean/b;)V", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "d", "Lcom/wbl/ad/yzz/network/b/b/u;", "()Lcom/wbl/ad/yzz/network/b/b/u;", "setGetPageMsgRes", "(Lcom/wbl/ad/yzz/network/b/b/u;)V", com.kwad.sdk.ranger.e.TAG, "Lcom/wbl/ad/yzz/innerconfig/d/d;", "()Lcom/wbl/ad/yzz/innerconfig/d/d;", "setSceneCache", "(Lcom/wbl/ad/yzz/innerconfig/d/d;)V", "c", "Lcom/wbl/ad/yzz/download/k/b$b;", "()Lcom/wbl/ad/yzz/download/k/b$b;", "setMInstallationFailListener", "(Lcom/wbl/ad/yzz/download/k/b$b;)V", "mInstallationFailListener", "<init>", "(Landroid/content/Context;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* renamed from: a, reason: from kotlin metadata */
        @f.b.a.d
        public final Context context;

        /* renamed from: b, reason: from kotlin metadata */
        @e
        public com.wbl.ad.yzz.bean.b bean;

        /* renamed from: c, reason: from kotlin metadata */
        @e
        public InterfaceC0720b mInstallationFailListener;

        /* renamed from: d, reason: from kotlin metadata */
        @e
        public u getPageMsgRes;

        /* renamed from: e */
        @e
        public com.wbl.ad.yzz.innerconfig.d.d sceneCache;

        public a(@f.b.a.d Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        public final com.wbl.ad.yzz.bean.b a() {
            return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13955, this, null);
        }

        public final a a(com.wbl.ad.yzz.bean.b bean) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13982, this, bean);
        }

        public final a a(InterfaceC0720b installationFailListener) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13981, this, installationFailListener);
        }

        public final a a(com.wbl.ad.yzz.innerconfig.d.d sceneCache) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13984, this, sceneCache);
        }

        public final a a(u getPageMsgRes) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13983, this, getPageMsgRes);
        }

        public final u b() {
            return (u) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13978, this, null);
        }

        public final InterfaceC0720b c() {
            return (InterfaceC0720b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13977, this, null);
        }

        public final com.wbl.ad.yzz.innerconfig.d.d d() {
            return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13980, this, null);
        }

        public final Context getContext() {
            return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13979, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.download.k.b$b */
    public interface InterfaceC0720b {
        void a();

        void a(@f.b.a.d View view);
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13974, this, view);
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13973, this, view);
        }
    }

    public b(@f.b.a.d a builder, @e View view) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.q = true;
        Context context = builder.getContext();
        this.f32120a = context;
        this.m = builder.a();
        this.o = builder.b();
        this.n = builder.c();
        this.f32121b = view != null ? view.findViewById(R.id.root_container_install_fail) : null;
        this.k = view != null ? view.findViewById(R.id.cl_ad_container_install_fail) : null;
        this.f32122c = view != null ? (ImageView) view.findViewById(R.id.iv_poster_install_fail) : null;
        this.f32123d = view != null ? (TextView) view.findViewById(R.id.tv_top_title) : null;
        this.f32124e = view != null ? (TextView) view.findViewById(R.id.tv_middle_title) : null;
        this.f32125f = view != null ? (ImageView) view.findViewById(R.id.tv_middle_title_right_icon) : null;
        this.f32126g = view != null ? (ImageView) view.findViewById(R.id.iv_close_install_fail) : null;
        this.f32127h = view != null ? (TextView) view.findViewById(R.id.tv_des_install_fail) : null;
        this.f32128i = view != null ? (TextView) view.findViewById(R.id.tv_button_bg_install_fail) : null;
        this.f32129j = view != null ? (ImageView) view.findViewById(R.id.iv_hand) : null;
        int a2 = h.a(context, 8.0f);
        if (a2 <= 0) {
            this.l = 16;
        } else {
            this.l = a2;
        }
        d();
        c();
        a(builder);
    }

    public static final /* synthetic */ InterfaceC0720b a(b bVar) {
        return (InterfaceC0720b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13976, null, bVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13975, this, null);
    }

    public final void a(View view, int i2, float f2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13970, this, view, Integer.valueOf(i2), Float.valueOf(f2));
    }

    public final void a(a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13969, this, aVar);
    }

    public final void a(CharSequence charSequence, k kVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13972, this, charSequence, kVar);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13971, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14062, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14061, this, null);
    }
}
