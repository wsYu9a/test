package com.martian.mibook.activity.account;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.n0;
import com.martian.mibook.activity.BonusDetailActivity;
import com.martian.mibook.activity.ShareImageUrlActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.XianWanGame;
import com.martian.mibook.e.e0;
import com.martian.mibook.e.k0;
import com.martian.mibook.e.l7;
import com.martian.mibook.e.m7;
import com.martian.mibook.j.v2;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.TYBonus;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class WithdrawSuccessActivity extends com.martian.mibook.lib.model.b.a {
    private com.martian.mibook.b.b H;
    private e0 I;
    private int F = 0;
    private boolean G = true;
    private boolean J = false;
    private long K = -1;

    class a extends com.martian.mibook.lib.account.d.q.m {
        a(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            WithdrawSuccessActivity.this.J = false;
            WithdrawSuccessActivity.this.k1(errorResult.d());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(TYBonus tyBonus) {
            WithdrawSuccessActivity.this.J = false;
            MiTaskAccount x4 = MiConfigSingleton.V3().x4();
            if (x4 != null) {
                x4.setFiveStar(Boolean.TRUE);
                MiConfigSingleton.V3().M4.f10762b.l(x4);
            }
            BonusDetailActivity.E3(WithdrawSuccessActivity.this, "好评", tyBonus.getMoney(), tyBonus.getCoins(), 0, 0L, 0);
        }
    }

    class b extends b.d.a.k.b {
        b() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            if (appTaskList == null || appTaskList.getApps() == null || appTaskList.getApps().size() <= 0) {
                return;
            }
            WithdrawSuccessActivity.this.K2(appTaskList.getApps().get(0));
        }
    }

    /* renamed from: B2 */
    public /* synthetic */ void C2(final XianWanGame xianWanGame, View view) {
        com.martian.mibook.lib.model.g.b.n0(this, "提现成功页-游戏-点击");
        if (MiConfigSingleton.V3().l2(this, 1015)) {
            if (com.martian.libsupport.k.p(xianWanGame.getUrl())) {
                k1("无效的游戏信息");
            } else {
                MiWebViewActivity.f5(this, xianWanGame.getUrl());
            }
        }
    }

    /* renamed from: D2 */
    public /* synthetic */ void E2() {
        com.martian.mibook.lib.model.g.b.N(this, "去好评");
        org.codechimp.apprater.b.m(new org.codechimp.apprater.e());
        org.codechimp.apprater.b.g(this);
        this.K = MartianRPUserManager.t();
        this.J = true;
    }

    /* renamed from: F2 */
    public /* synthetic */ void G2() {
        v2.b1(this, new v2.a0() { // from class: com.martian.mibook.activity.account.t
            @Override // com.martian.mibook.j.v2.a0
            public final void a() {
                WithdrawSuccessActivity.this.E2();
            }
        });
    }

    /* renamed from: H2 */
    public /* synthetic */ void I2() {
        if (this.G) {
            this.I.f11878f.setText(getString(R.string.withdraw_success_hint_1) + getString(R.string.withdraw_success_hint_2));
            this.I.f11875c.setText(getString(R.string.give_rate));
            return;
        }
        this.I.f11878f.setText(getString(R.string.withdraw_success_hint_1) + getString(R.string.withdraw_success_hint_3));
        this.I.f11875c.setText(getString(R.string.give_share));
    }

    public static void J2(j1 activity, int money) {
        Intent intent = new Intent(activity, (Class<?>) WithdrawSuccessActivity.class);
        intent.putExtra(MartianRPUserManager.H, money);
        activity.startActivity(intent);
    }

    public void K2(AppTask appTask) {
        if (appTask == null) {
            return;
        }
        this.I.f11874b.removeAllViews();
        View view = this.I.f11874b;
        if (appTask.customView == null) {
            view = AdConfig.UnionType.GAME.equalsIgnoreCase(appTask.source) ? t2() : u2(appTask);
        }
        this.H.f(this, appTask, this.I.f11874b, view);
    }

    @SuppressLint({"SetTextI18n"})
    private View v2(final XianWanGame xianWanGame) {
        View inflate = View.inflate(this, R.layout.xianwan_game_ads_item, null);
        m7 a2 = m7.a(inflate);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMargins(com.martian.libmars.d.h.b(10.0f), 0, com.martian.libmars.d.h.b(10.0f), 0);
        a2.f12387e.setLayoutParams(layoutParams);
        a2.f12386d.setText(xianWanGame.getGameName());
        n0.z(this, xianWanGame.getIcon(), a2.f12385c, 11, com.martian.libmars.d.h.F().C());
        if (xianWanGame.getMoney().intValue() > 0) {
            a2.f12384b.setText("+" + (xianWanGame.getMoney().intValue() / 100) + "元");
        }
        a2.f12387e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.account.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WithdrawSuccessActivity.this.C2(xianWanGame, view);
            }
        });
        return inflate;
    }

    public static boolean x2() {
        return Math.random() < 0.5d;
    }

    private void y2() {
        com.martian.mibook.b.b b0 = com.martian.mibook.b.b.b0(this);
        this.H = b0;
        b0.T0(new b());
        this.H.F();
    }

    /* renamed from: z2 */
    public /* synthetic */ void A2(final AppTask appTask, View v) {
        this.H.d(appTask);
    }

    @SuppressLint({"SetTextI18n"})
    public void L2() {
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.account.r
            @Override // java.lang.Runnable
            public final void run() {
                WithdrawSuccessActivity.this.I2();
            }
        });
    }

    public void onActionMenuClick(View view) {
        finish();
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_success);
        if (savedInstanceState != null) {
            this.F = savedInstanceState.getInt(MartianRPUserManager.H);
        } else {
            this.F = getIntent().getIntExtra(MartianRPUserManager.H, 0);
        }
        e0 a2 = e0.a(g2());
        this.I = a2;
        a2.f11879g.setText(com.martian.rpauth.d.i.n(Integer.valueOf(this.F)));
        l2("完成", true, R.color.theme_default);
        q2(false);
        this.G = x2();
        L2();
        y2();
        com.martian.mibook.lib.model.g.b.N(this, "进入提现成功界面");
        if (MiConfigSingleton.V3().L4.d0()) {
            return;
        }
        new Handler().post(new Runnable() { // from class: com.martian.mibook.activity.account.u
            @Override // java.lang.Runnable
            public final void run() {
                WithdrawSuccessActivity.this.G2();
            }
        });
    }

    public void onDetailClick(View view) {
        MartianWithdrawOrderListActivity.r2(this, 0, false);
    }

    public void onOpenXianWanGameClick(View view) {
        com.martian.mibook.lib.model.g.b.n0(this, "提现成功页-主页-点击");
        MiConfigSingleton.V3().L4.q0(this);
    }

    public void onRateClick(View view) {
        if (!this.G) {
            ShareImageUrlActivity.n(this, 1);
        } else {
            org.codechimp.apprater.b.m(new org.codechimp.apprater.e());
            org.codechimp.apprater.b.g(this);
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        w2();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MartianRPUserManager.H, this.F);
    }

    public View t2() {
        com.martian.mibook.lib.model.g.b.n0(this, "提现成功页-展示");
        l7 a2 = l7.a(View.inflate(this, R.layout.xianwan_game_ads, null));
        List<XianWanGame> S = MiConfigSingleton.V3().L4.S();
        this.I.f11874b.setVisibility(0);
        this.I.f11874b.addView(a2.getRoot());
        Collections.shuffle(S);
        Iterator<XianWanGame> it = S.iterator();
        while (it.hasNext()) {
            a2.f12318b.addView(v2(it.next()));
            if (a2.f12318b.getChildCount() > 2) {
                break;
            }
        }
        return a2.getRoot();
    }

    public View u2(final AppTask appTask) {
        View inflate = getLayoutInflater().inflate(R.layout.bonus_ads_item, (ViewGroup) null);
        k0 a2 = k0.a(inflate);
        n0.k(this, appTask.getPosterUrl(), a2.f12223b);
        a2.f12224c.setText(appTask.getDesc());
        a2.f12227f.setImageResource(appTask.adsIconRes());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.account.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WithdrawSuccessActivity.this.A2(appTask, view);
            }
        });
        this.I.f11874b.setVisibility(0);
        this.I.f11874b.addView(inflate);
        return inflate;
    }

    public void w2() {
        if (!this.J || MiConfigSingleton.V3().L4.d0()) {
            return;
        }
        if (MartianRPUserManager.t() - this.K >= 10000) {
            new a(this).j();
        } else {
            k1("未完成");
            this.J = false;
        }
    }
}
