package ya;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.DialogBonusDetailBinding;
import com.martian.mibook.lib.account.request.auth.FinishExtraBonusParams;
import com.martian.mibook.lib.account.request.auth.StartExtraBonusParams;
import com.martian.mibook.lib.account.response.ExtraBonus;
import l9.i0;
import ya.s0;

/* loaded from: classes3.dex */
public class s0 {

    /* renamed from: c */
    public static s0 f33364c;

    /* renamed from: a */
    public AppTask f33365a;

    /* renamed from: b */
    public boolean f33366b = false;

    public class a extends d8.b {

        /* renamed from: a */
        public final /* synthetic */ DialogBonusDetailBinding f33367a;

        /* renamed from: b */
        public final /* synthetic */ Activity f33368b;

        public a(DialogBonusDetailBinding dialogBonusDetailBinding, Activity activity) {
            this.f33367a = dialogBonusDetailBinding;
            this.f33368b = activity;
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            if (appTaskList == null || appTaskList.getApps() == null || appTaskList.getApps().isEmpty()) {
                return;
            }
            s0.this.f33365a = appTaskList.getApps().get(0);
            if (s0.this.f33365a == null) {
                this.f33367a.dialogAdsContainers.setVisibility(8);
                return;
            }
            this.f33367a.dialogAdsContainers.setVisibility(0);
            this.f33367a.dialogAdsContainers.removeAllViews();
            je.v0.O(this.f33368b, this.f33367a.dialogAdsContainers, s0.this.f33365a);
        }
    }

    public class b extends d8.b {

        /* renamed from: a */
        public final /* synthetic */ Activity f33370a;

        /* renamed from: b */
        public final /* synthetic */ f f33371b;

        /* renamed from: c */
        public final /* synthetic */ DialogBonusDetailBinding f33372c;

        public b(Activity activity, f fVar, DialogBonusDetailBinding dialogBonusDetailBinding) {
            this.f33370a = activity;
            this.f33371b = fVar;
            this.f33372c = dialogBonusDetailBinding;
        }

        @Override // d8.b, d8.a
        public void c(AdConfig adConfig, x8.c cVar) {
            l9.t0.b(this.f33370a, "领取失败");
            s0.this.o(this.f33372c);
        }

        @Override // d8.b, d8.a
        public void k(AdConfig adConfig, boolean z10) {
            if (z10) {
                s0.this.i(this.f33370a, this.f33371b, this.f33372c);
            } else {
                l9.t0.b(this.f33370a, "领取失败");
                s0.this.o(this.f33372c);
            }
        }
    }

    public class e extends d8.b {

        /* renamed from: a */
        public final /* synthetic */ i0.k f33382a;

        /* renamed from: b */
        public final /* synthetic */ boolean f33383b;

        /* renamed from: c */
        public final /* synthetic */ Activity f33384c;

        public e(i0.k kVar, boolean z10, Activity activity) {
            this.f33382a = kVar;
            this.f33383b = z10;
            this.f33384c = activity;
        }

        @Override // d8.b, d8.a
        public void a() {
            ba.o.e(new Runnable() { // from class: ya.t0

                /* renamed from: c */
                public final /* synthetic */ boolean f33396c;

                /* renamed from: d */
                public final /* synthetic */ Activity f33397d;

                /* renamed from: e */
                public final /* synthetic */ i0.k f33398e;

                public /* synthetic */ t0(boolean z10, Activity activity, i0.k kVar) {
                    z10 = z10;
                    activity = activity;
                    kVar = kVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    s0.e.this.n(z10, activity, kVar);
                }
            });
        }

        @Override // d8.b, d8.a
        public void g(AdConfig adConfig) {
            i0.k kVar = this.f33382a;
            if (kVar != null) {
                kVar.a();
            }
        }

        public final /* synthetic */ void n(boolean z10, Activity activity, i0.k kVar) {
            if (z10) {
                s0.this.p(activity, new f().f(0).g("本次未中奖"), kVar);
            } else if (kVar != null) {
                kVar.a();
            }
        }
    }

    public static class f {

        /* renamed from: b */
        public Integer f33387b;

        /* renamed from: c */
        public Integer f33388c;

        /* renamed from: d */
        public Long f33389d;

        /* renamed from: e */
        public Integer f33390e;

        /* renamed from: a */
        public String f33386a = "";

        /* renamed from: f */
        public String f33391f = "";

        public Integer a() {
            Integer num = this.f33388c;
            return Integer.valueOf(num == null ? 0 : num.intValue());
        }

        public String b() {
            return ba.l.q(this.f33391f) ? "奖励好像被吃了~" : this.f33391f;
        }

        public Integer c() {
            Integer num = this.f33390e;
            return Integer.valueOf(num == null ? 0 : num.intValue());
        }

        public long d() {
            Long l10 = this.f33389d;
            if (l10 == null) {
                return 0L;
            }
            return l10.longValue();
        }

        public Integer e() {
            Integer num = this.f33387b;
            return Integer.valueOf(num == null ? 0 : num.intValue());
        }

        public f f(Integer num) {
            this.f33388c = num;
            return this;
        }

        public f g(String str) {
            this.f33391f = str;
            return this;
        }

        public String getType() {
            return this.f33386a;
        }

        public f h(Integer num) {
            this.f33390e = num;
            return this;
        }

        public f i(Long l10) {
            this.f33389d = l10;
            return this;
        }

        public f j(String str) {
            this.f33386a = str;
            return this;
        }
    }

    public static s0 j() {
        if (f33364c == null) {
            f33364c = new s0();
        }
        return f33364c;
    }

    public static /* synthetic */ void l(i0.k kVar, AlertDialog alertDialog, View view) {
        if (kVar != null) {
            kVar.a();
        }
        alertDialog.dismiss();
    }

    public static /* synthetic */ void m(i0.k kVar, AlertDialog alertDialog, View view) {
        if (kVar != null) {
            kVar.a();
        }
        alertDialog.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(Activity activity, f fVar, DialogBonusDetailBinding dialogBonusDetailBinding) {
        d dVar = new d(activity, dialogBonusDetailBinding, fVar, activity);
        ((FinishExtraBonusParams) dVar.k()).setExtraId(Long.valueOf(fVar.d()));
        dVar.j();
    }

    public final /* synthetic */ void k(f fVar, Activity activity, DialogBonusDetailBinding dialogBonusDetailBinding, AlertDialog alertDialog, View view) {
        if (fVar.d() <= 0 || fVar.c().intValue() <= 0) {
            alertDialog.dismiss();
        } else {
            s(activity, fVar, dialogBonusDetailBinding);
        }
    }

    public final /* synthetic */ void n(DialogInterface dialogInterface) {
        this.f33366b = false;
        com.martian.mibook.application.a.F(this.f33365a);
    }

    public final void o(DialogBonusDetailBinding dialogBonusDetailBinding) {
        if (dialogBonusDetailBinding == null) {
            return;
        }
        dialogBonusDetailBinding.dialogBonusAward.setVisibility(8);
        ((LinearLayout.LayoutParams) dialogBonusDetailBinding.dialogBonusContinue.getLayoutParams()).setMargins(ConfigSingleton.i(20.0f), ConfigSingleton.i(14.0f), ConfigSingleton.i(20.0f), 0);
    }

    @SuppressLint({"SetTextI18n"})
    public void p(Activity activity, f fVar, i0.k kVar) {
        String str;
        if (l9.m0.c(activity)) {
            return;
        }
        View inflate = View.inflate(activity, R.layout.dialog_bonus_detail, null);
        DialogBonusDetailBinding bind = DialogBonusDetailBinding.bind(inflate);
        AlertDialog G = l9.i0.G(activity, inflate, false);
        if (G == null) {
            return;
        }
        WindowManager.LayoutParams attributes = G.getWindow().getAttributes();
        attributes.dimAmount = 0.75f;
        G.getWindow().setAttributes(attributes);
        G.getWindow().addFlags(2);
        if (fVar.a().intValue() > 0) {
            bind.dialogIconBox.setImageResource(R.drawable.icon_bonus_detail_box_open);
            bind.dialogBonusMoney.setTextSize(36.0f);
            bind.dialogBonusMoney.setText("+" + fVar.a());
            bind.dialogBonusMoneyUnit.setVisibility(0);
            bind.dialogBonusContinue.setVisibility(0);
            if (fVar.d() <= 0 || fVar.c().intValue() <= 0) {
                bind.dialogBonusAward.setVisibility(8);
            } else {
                bind.dialogBonusAward.setVisibility(0);
                int intValue = fVar.c().intValue() / fVar.a().intValue();
                ThemeTextView themeTextView = bind.dialogBonusAward;
                if (intValue > 1) {
                    str = "点我赚" + (intValue + 1) + "倍奖励";
                } else {
                    str = "点我奖励翻倍";
                }
                themeTextView.setText(str);
            }
        } else {
            bind.dialogIconBox.setImageResource(R.drawable.icon_bonus_detail_box_close);
            bind.dialogBonusMoney.setTextSize(20.0f);
            bind.dialogBonusMoney.setText(fVar.b());
            bind.dialogBonusMoneyUnit.setVisibility(8);
            bind.dialogBonusContinue.setVisibility(8);
            bind.dialogBonusAward.setVisibility(0);
            bind.dialogBonusAward.setText(activity.getString(R.string.known));
        }
        MiConfigSingleton.b2().H1().T(activity, e0.S, new a(bind, activity));
        bind.dialogBonusAward.setOnClickListener(new View.OnClickListener() { // from class: ya.o0

            /* renamed from: c */
            public final /* synthetic */ s0.f f33322c;

            /* renamed from: d */
            public final /* synthetic */ Activity f33323d;

            /* renamed from: e */
            public final /* synthetic */ DialogBonusDetailBinding f33324e;

            /* renamed from: f */
            public final /* synthetic */ AlertDialog f33325f;

            public /* synthetic */ o0(s0.f fVar2, Activity activity2, DialogBonusDetailBinding bind2, AlertDialog G2) {
                fVar = fVar2;
                activity = activity2;
                bind = bind2;
                G = G2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.this.k(fVar, activity, bind, G, view);
            }
        });
        bind2.dialogBonusContinue.setOnClickListener(new View.OnClickListener() { // from class: ya.p0

            /* renamed from: c */
            public final /* synthetic */ AlertDialog f33331c;

            public /* synthetic */ p0(AlertDialog G2) {
                G = G2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.l(i0.k.this, G, view);
            }
        });
        bind2.dialogIconClose.setOnClickListener(new View.OnClickListener() { // from class: ya.q0

            /* renamed from: c */
            public final /* synthetic */ AlertDialog f33348c;

            public /* synthetic */ q0(AlertDialog G2) {
                G = G2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.m(i0.k.this, G, view);
            }
        });
        G2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ya.r0
            public /* synthetic */ r0() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                s0.this.n(dialogInterface);
            }
        });
    }

    public void q(Activity activity, boolean z10, i0.k kVar) {
        MiConfigSingleton.b2().H1().H0(activity, e0.U, new e(kVar, z10, activity));
    }

    public void r(Activity activity, f fVar, DialogBonusDetailBinding dialogBonusDetailBinding) {
        if (this.f33366b) {
            l9.t0.b(activity, "视频加载中，请稍候");
            return;
        }
        l9.t0.b(activity, "视频加载中");
        this.f33366b = true;
        MiConfigSingleton.b2().H1().I0(activity, true, new b(activity, fVar, dialogBonusDetailBinding));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(Activity activity, f fVar, DialogBonusDetailBinding dialogBonusDetailBinding) {
        c cVar = new c(activity, activity, fVar, dialogBonusDetailBinding);
        ((StartExtraBonusParams) cVar.k()).setExtraId(Long.valueOf(fVar.d()));
        cVar.j();
    }

    public class c extends kb.b0 {

        /* renamed from: k */
        public final /* synthetic */ Activity f33374k;

        /* renamed from: l */
        public final /* synthetic */ f f33375l;

        /* renamed from: m */
        public final /* synthetic */ DialogBonusDetailBinding f33376m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Activity activity, Activity activity2, f fVar, DialogBonusDetailBinding dialogBonusDetailBinding) {
            super(activity);
            this.f33374k = activity2;
            this.f33375l = fVar;
            this.f33376m = dialogBonusDetailBinding;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            l9.t0.b(this.f33374k, cVar.d());
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(Boolean bool) {
            if (bool == null || !bool.booleanValue()) {
                return;
            }
            s0.this.r(this.f33374k, this.f33375l, this.f33376m);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class d extends kb.i {

        /* renamed from: k */
        public final /* synthetic */ DialogBonusDetailBinding f33378k;

        /* renamed from: l */
        public final /* synthetic */ f f33379l;

        /* renamed from: m */
        public final /* synthetic */ Activity f33380m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Activity activity, DialogBonusDetailBinding dialogBonusDetailBinding, f fVar, Activity activity2) {
            super(activity);
            this.f33378k = dialogBonusDetailBinding;
            this.f33379l = fVar;
            this.f33380m = activity2;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            l9.t0.b(this.f33380m, cVar.d());
            s0.this.o(this.f33378k);
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(ExtraBonus extraBonus) {
            if (extraBonus == null || extraBonus.getCoins().intValue() <= 0) {
                l9.t0.b(this.f33380m, "领取失败");
            } else {
                MiConfigSingleton.b2().G1().B(0, extraBonus.getCoins().intValue());
                this.f33378k.dialogBonusMoney.i(this.f33379l.a().intValue(), this.f33379l.a().intValue() + extraBonus.getCoins().intValue(), "+");
            }
            s0.this.o(this.f33378k);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }
}
