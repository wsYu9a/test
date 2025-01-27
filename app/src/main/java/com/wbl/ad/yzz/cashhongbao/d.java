package com.wbl.ad.yzz.cashhongbao;

import android.app.Activity;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.network.b.b.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a */
    public final View f31791a;

    /* renamed from: b */
    public final View f31792b;

    /* renamed from: c */
    public final ImageView f31793c;

    /* renamed from: d */
    public final TextView f31794d;

    /* renamed from: e */
    public final TextView f31795e;

    /* renamed from: f */
    public final ImageView f31796f;

    /* renamed from: g */
    public final TextView f31797g;

    /* renamed from: h */
    public final ImageView f31798h;

    /* renamed from: i */
    public final Activity f31799i;

    /* renamed from: j */
    public final com.wbl.ad.yzz.network.b.b.e f31800j;
    public b k;
    public String l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020\u001d¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\fR$\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u0013\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0019\u0010!\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"com/wbl/ad/yzz/cashhongbao/d$a", "", "Lcom/wbl/ad/yzz/cashhongbao/d$b;", "onCashHongBaoListener", "Lcom/wbl/ad/yzz/cashhongbao/d$a;", "a", "(Lcom/wbl/ad/yzz/cashhongbao/d$b;)Lcom/wbl/ad/yzz/cashhongbao/d$a;", "Lcom/wbl/ad/yzz/network/b/b/e;", "businessPosition", "(Lcom/wbl/ad/yzz/network/b/b/e;)Lcom/wbl/ad/yzz/cashhongbao/d$a;", "", "url", "(Ljava/lang/String;)Lcom/wbl/ad/yzz/cashhongbao/d$a;", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "setBg_url", "(Ljava/lang/String;)V", "bg_url", "b", "Lcom/wbl/ad/yzz/cashhongbao/d$b;", "c", "()Lcom/wbl/ad/yzz/cashhongbao/d$b;", "setOnCashHongBaoListener", "(Lcom/wbl/ad/yzz/cashhongbao/d$b;)V", "Lcom/wbl/ad/yzz/network/b/b/e;", "()Lcom/wbl/ad/yzz/network/b/b/e;", "setBusinessPosition", "(Lcom/wbl/ad/yzz/network/b/b/e;)V", "Landroid/app/Activity;", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "context", "<init>", "(Landroid/app/Activity;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* renamed from: a, reason: from kotlin metadata */
        @f.b.a.d
        public final Activity context;

        /* renamed from: b, reason: from kotlin metadata */
        @f.b.a.e
        public b onCashHongBaoListener;

        /* renamed from: c, reason: from kotlin metadata */
        @f.b.a.e
        public com.wbl.ad.yzz.network.b.b.e businessPosition;

        /* renamed from: d, reason: from kotlin metadata */
        @f.b.a.e
        public String bg_url;

        public a(@f.b.a.d Activity context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        public final a a(b onCashHongBaoListener) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15347, this, onCashHongBaoListener);
        }

        public final a a(com.wbl.ad.yzz.network.b.b.e businessPosition) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15310, this, businessPosition);
        }

        public final a a(String url) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15309, this, url);
        }

        public final String a() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15312, this, null);
        }

        public final com.wbl.ad.yzz.network.b.b.e b() {
            return (com.wbl.ad.yzz.network.b.b.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15311, this, null);
        }

        public final b c() {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15306, this, null);
        }

        public final Activity getContext() {
            return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15305, this, null);
        }
    }

    public interface b {
        void a();

        void a(@f.b.a.e e.b bVar);

        void a(@f.b.a.e com.wbl.ad.yzz.network.b.b.e eVar);
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15308, this, view);
        }
    }

    /* renamed from: com.wbl.ad.yzz.cashhongbao.d$d */
    public static final class ViewOnClickListenerC0700d implements View.OnClickListener {
        public ViewOnClickListenerC0700d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15307, this, view);
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15302, this, view);
        }
    }

    public d(@f.b.a.d a builder, @f.b.a.e View view) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f31799i = builder.getContext();
        this.f31800j = builder.b();
        this.k = builder.c();
        this.l = builder.a();
        TextPaint textPaint = null;
        if (view != null) {
            this.f31791a = view.findViewById(R.id.root_container_cash_hongbao);
            this.f31792b = view.findViewById(R.id.cl_bg_cash_hongbao);
            this.f31794d = (TextView) view.findViewById(R.id.tv_top_title_cash_hongbao);
            this.f31795e = (TextView) view.findViewById(R.id.tv_amount_of_money_cash_hongbao);
            this.f31796f = (ImageView) view.findViewById(R.id.iv_close_cash_hongbao);
            TextView textView = (TextView) view.findViewById(R.id.tv_activity_rules);
            this.f31797g = textView;
            this.f31798h = (ImageView) view.findViewById(R.id.iv_withdrawal_tips);
            this.f31793c = (ImageView) view.findViewById(R.id.iv_bg_cash_hongbao);
            if (textView != null) {
                try {
                    textPaint = textView.getPaint();
                } catch (Exception e2) {
                    Log.e("CashHongBaoWrap", String.valueOf(e2.getMessage()));
                }
            }
            if (textPaint != null) {
                textPaint.setFlags(8);
                textPaint.setAntiAlias(true);
            }
        } else {
            this.f31791a = null;
            this.f31792b = null;
            this.f31793c = null;
            this.f31794d = null;
            this.f31795e = null;
            this.f31796f = null;
            this.f31797g = null;
            this.f31798h = null;
        }
        d();
        c();
    }

    public static final /* synthetic */ com.wbl.ad.yzz.network.b.b.e a(d dVar) {
        return (com.wbl.ad.yzz.network.b.b.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15301, null, dVar);
    }

    public static final /* synthetic */ b b(d dVar) {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15304, null, dVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15303, this, null);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15298, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15297, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15300, this, null);
    }
}
