package com.wbl.ad.yzz.cashhongbao;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.network.b.b.f;
import f.b.a.e;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a */
    public final View f31782a;

    /* renamed from: b */
    public final TextView f31783b;

    /* renamed from: c */
    public a f31784c;

    /* renamed from: e */
    public Handler f31786e;

    /* renamed from: f */
    public boolean f31787f;

    /* renamed from: d */
    public boolean f31785d = true;

    /* renamed from: g */
    public final Runnable f31788g = new b();

    public interface a {
        void a();

        void b();
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15332, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.cashhongbao.c$c */
    public static final class ViewOnClickListenerC0699c implements View.OnClickListener {
        public ViewOnClickListenerC0699c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15331, this, view);
        }
    }

    public c(@e Activity activity, @e View view) {
        if (view != null) {
            this.f31782a = view.findViewById(R.id.cl_cash_suspension_red_packet_container);
            this.f31783b = (TextView) view.findViewById(R.id.tv_cash_suspension_red_packet_value);
        } else {
            this.f31782a = null;
            this.f31783b = null;
        }
        e();
    }

    public static final /* synthetic */ Handler a(c cVar) {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15358, null, cVar);
    }

    public static final /* synthetic */ a b(c cVar) {
        return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15360, null, cVar);
    }

    public static final /* synthetic */ Runnable e(c cVar) {
        return (Runnable) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15353, null, cVar);
    }

    public final Handler a() {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15356, this, null);
    }

    public final void a(a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15355, this, aVar);
    }

    public final void a(f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15350, this, fVar);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15349, this, str);
    }

    public final void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15352, this, Boolean.valueOf(z));
    }

    public final boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15351, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15346, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15345, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15348, this, null);
    }
}
