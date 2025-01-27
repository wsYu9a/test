package com.martian.mibook.application;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.activity.j1;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.k0;
import com.martian.mibook.activity.BonusDetailActivity;
import com.martian.mibook.application.m0;
import com.martian.mibook.e.j2;
import com.martian.mibook.j.v2;
import com.martian.mibook.lib.account.request.auth.FinishExtraBonusParams;
import com.martian.mibook.lib.account.request.auth.StartExtraBonusParams;
import com.martian.mibook.lib.account.response.ExtraBonus;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class m0 {

    /* renamed from: a */
    private static m0 f11494a;

    /* renamed from: b */
    private AppTask f11495b;

    /* renamed from: c */
    private boolean f11496c = false;

    class a extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ j2 f11497a;

        /* renamed from: b */
        final /* synthetic */ j1 f11498b;

        /* renamed from: c */
        final /* synthetic */ com.martian.mibook.b.b f11499c;

        a(final j2 val$adsFetcher, final j1 val$activity, final com.martian.mibook.b.b val$detailBinding) {
            this.f11497a = val$adsFetcher;
            this.f11498b = val$activity;
            this.f11499c = val$detailBinding;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void b(AdConfig config) {
            this.f11497a.f12168b.setVisibility(8);
            this.f11497a.f12169c.setPadding(0, 0, 0, com.martian.libmars.d.h.b(20.0f));
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, final AppTaskList appTaskList) {
            super.d(config, appTaskList);
            if (appTaskList == null || appTaskList.getApps() == null || appTaskList.getApps().size() <= 0) {
                return;
            }
            m0.this.f11495b = appTaskList.getApps().get(0);
            if (m0.this.f11495b == null) {
                this.f11497a.f12168b.setVisibility(8);
                return;
            }
            this.f11497a.f12168b.setVisibility(0);
            this.f11497a.f12168b.removeAllViews();
            LinearLayout linearLayout = this.f11497a.f12168b;
            if (m0.this.f11495b.customView == null) {
                v2.f(this.f11498b, this.f11497a.f12168b, this.f11499c, m0.this.f11495b);
            } else {
                this.f11499c.f(this.f11498b, m0.this.f11495b, this.f11497a.f12168b, linearLayout);
            }
        }
    }

    class b extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ j1 f11501a;

        /* renamed from: b */
        final /* synthetic */ BonusDetailActivity.h f11502b;

        /* renamed from: c */
        final /* synthetic */ j2 f11503c;

        b(final j1 val$detailBinding, final BonusDetailActivity.h val$bonusPollData, final j2 val$activity) {
            this.f11501a = val$detailBinding;
            this.f11502b = val$bonusPollData;
            this.f11503c = val$activity;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            m0.this.e(this.f11501a, this.f11502b, this.f11503c);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            this.f11501a.k1("领取失败");
            m0.this.m(this.f11503c);
        }
    }

    class c extends com.martian.mibook.lib.account.d.q.l0 {

        /* renamed from: j */
        final /* synthetic */ j1 f11505j;
        final /* synthetic */ BonusDetailActivity.h k;
        final /* synthetic */ j2 l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(j1 x0, final j1 val$detailBinding, final BonusDetailActivity.h val$bonusPollData, final j2 val$activity) {
            super(x0);
            this.f11505j = val$detailBinding;
            this.k = val$bonusPollData;
            this.l = val$activity;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            this.f11505j.k1(errorResult.d());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(Boolean success) {
            if (success == null || !success.booleanValue()) {
                return;
            }
            m0.this.p(this.f11505j, this.k, this.l);
        }
    }

    class d extends com.martian.mibook.lib.account.d.q.l {

        /* renamed from: j */
        final /* synthetic */ j2 f11506j;
        final /* synthetic */ BonusDetailActivity.h k;
        final /* synthetic */ j1 l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(j1 x0, final j2 val$activity, final BonusDetailActivity.h val$bonusPollData, final j1 val$detailBinding) {
            super(x0);
            this.f11506j = val$activity;
            this.k = val$bonusPollData;
            this.l = val$detailBinding;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            this.l.k1(errorResult.d());
            m0.this.m(this.f11506j);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(ExtraBonus extraBonus) {
            if (extraBonus == null || extraBonus.getCoins().intValue() <= 0) {
                this.l.k1("领取失败");
            } else {
                MiConfigSingleton.V3().V8(0, extraBonus.getCoins().intValue());
                this.f11506j.f12173g.k(this.k.d().intValue(), this.k.d().intValue() + extraBonus.getCoins().intValue(), "+");
            }
            m0.this.m(this.f11506j);
        }
    }

    class e extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ k0.j f11507a;

        /* renamed from: b */
        final /* synthetic */ j1 f11508b;

        /* renamed from: c */
        final /* synthetic */ boolean f11509c;

        e(final k0.j val$fallback, final j1 val$activity, final boolean val$negativeClickListener) {
            this.f11507a = val$fallback;
            this.f11508b = val$activity;
            this.f11509c = val$negativeClickListener;
        }

        /* renamed from: k */
        public /* synthetic */ void l(final boolean fallback, final j1 activity, final k0.j negativeClickListener) {
            if (fallback) {
                m0.this.n(activity, new BonusDetailActivity.h().l(0).n("本次未中奖"), negativeClickListener);
            } else if (negativeClickListener != null) {
                negativeClickListener.a();
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void c(AdConfig config) {
            k0.j jVar = this.f11507a;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            final j1 j1Var = this.f11508b;
            final boolean z = this.f11509c;
            final k0.j jVar = this.f11507a;
            j1Var.runOnUiThread(new Runnable() { // from class: com.martian.mibook.application.m
                @Override // java.lang.Runnable
                public final void run() {
                    m0.e.this.l(z, j1Var, jVar);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e(final j1 activity, final BonusDetailActivity.h bonusPollData, final j2 detailBinding) {
        d dVar = new d(activity, detailBinding, bonusPollData, activity);
        ((FinishExtraBonusParams) dVar.k()).setExtraId(Long.valueOf(bonusPollData.h()));
        dVar.j();
    }

    public static m0 f() {
        if (f11494a == null) {
            f11494a = new m0();
        }
        return f11494a;
    }

    /* renamed from: g */
    public /* synthetic */ void h(final BonusDetailActivity.h bonusPollData, final j1 activity, final j2 detailBinding, final AlertDialog alertDialog, View view13) {
        if (bonusPollData.h() <= 0 || bonusPollData.g().intValue() <= 0) {
            alertDialog.dismiss();
        } else {
            q(activity, bonusPollData, detailBinding);
        }
    }

    static /* synthetic */ void i(final k0.j negativeClickListener, final AlertDialog alertDialog, View view12) {
        if (negativeClickListener != null) {
            negativeClickListener.a();
        }
        alertDialog.dismiss();
    }

    static /* synthetic */ void j(final k0.j negativeClickListener, final AlertDialog alertDialog, View view1) {
        if (negativeClickListener != null) {
            negativeClickListener.a();
        }
        alertDialog.dismiss();
    }

    /* renamed from: k */
    public /* synthetic */ void l(DialogInterface dialogInterface) {
        this.f11496c = false;
        g0.p(this.f11495b);
    }

    public void m(j2 detailBinding) {
        if (detailBinding == null) {
            return;
        }
        detailBinding.f12171e.setVisibility(8);
        ((LinearLayout.LayoutParams) detailBinding.f12172f.getLayoutParams()).setMargins(com.martian.libmars.d.h.b(20.0f), com.martian.libmars.d.h.b(14.0f), com.martian.libmars.d.h.b(20.0f), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void q(final j1 activity, final BonusDetailActivity.h bonusPollData, final j2 detailBinding) {
        c cVar = new c(activity, activity, bonusPollData, detailBinding);
        ((StartExtraBonusParams) cVar.k()).setExtraId(Long.valueOf(bonusPollData.h()));
        cVar.j();
    }

    @SuppressLint({"SetTextI18n"})
    public void n(final j1 activity, final BonusDetailActivity.h bonusPollData, final k0.j negativeClickListener) {
        String str;
        if (com.martian.libmars.utils.n0.c(activity)) {
            return;
        }
        View inflate = View.inflate(activity, R.layout.dialog_bonus_detail, null);
        final j2 a2 = j2.a(inflate);
        final AlertDialog b2 = com.martian.libmars.utils.k0.b(activity, inflate, false);
        if (b2 == null) {
            return;
        }
        WindowManager.LayoutParams attributes = b2.getWindow().getAttributes();
        attributes.dimAmount = 0.75f;
        b2.getWindow().setAttributes(attributes);
        b2.getWindow().addFlags(2);
        if (bonusPollData.d().intValue() > 0) {
            a2.f12175i.setImageResource(R.drawable.icon_bonus_detail_box_open);
            a2.f12173g.setTextSize(36.0f);
            a2.f12173g.setText("+" + bonusPollData.d());
            a2.f12174h.setVisibility(0);
            a2.f12172f.setVisibility(0);
            if (bonusPollData.h() <= 0 || bonusPollData.g().intValue() <= 0) {
                a2.f12171e.setVisibility(8);
            } else {
                a2.f12171e.setVisibility(0);
                int intValue = bonusPollData.g().intValue() / bonusPollData.d().intValue();
                ThemeTextView themeTextView = a2.f12171e;
                if (intValue > 1) {
                    str = "点我赚" + (intValue + 1) + "倍奖励";
                } else {
                    str = "点我奖励翻倍";
                }
                themeTextView.setText(str);
            }
        } else {
            a2.f12175i.setImageResource(R.drawable.icon_bonus_detail_box_close);
            a2.f12173g.setTextSize(20.0f);
            a2.f12173g.setText(bonusPollData.f());
            a2.f12174h.setVisibility(8);
            a2.f12172f.setVisibility(8);
            a2.f12171e.setVisibility(0);
            a2.f12171e.setText(activity.getString(R.string.known));
        }
        com.martian.mibook.b.b f0 = com.martian.mibook.b.b.f0(activity);
        f0.T0(new a(a2, activity, f0));
        f0.F();
        a2.f12171e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.application.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m0.this.h(bonusPollData, activity, a2, b2, view);
            }
        });
        a2.f12172f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.application.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m0.i(k0.j.this, b2, view);
            }
        });
        a2.f12176j.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.application.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m0.j(k0.j.this, b2, view);
            }
        });
        b2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.martian.mibook.application.n
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                m0.this.l(dialogInterface);
            }
        });
    }

    public void o(final j1 activity, final boolean fallback, final k0.j negativeClickListener) {
        MiConfigSingleton.V3().N4.s(activity, b.d.a.j.b.r, new e(negativeClickListener, activity, fallback));
    }

    public void p(final j1 activity, final BonusDetailActivity.h bonusPollData, final j2 detailBinding) {
        if (this.f11496c) {
            activity.k1("视频加载中,请稍候");
            return;
        }
        activity.k1("视频加载中");
        this.f11496c = true;
        MiConfigSingleton.V3().N4.t(activity, b.d.a.j.b.f4373f, new b(activity, bonusPollData, detailBinding));
    }
}
