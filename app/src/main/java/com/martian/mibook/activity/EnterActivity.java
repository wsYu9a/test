package com.martian.mibook.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import b8.e;
import ba.h;
import ba.m;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.activity.MartianActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.account.MiCompoundUserManager;
import com.martian.mibook.activity.EnterActivity;
import com.martian.mibook.activity.book.TeenagerBookmallActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.SplashAdManager;
import com.martian.mibook.databinding.ActivityEnterBinding;
import com.martian.mibook.databinding.ActivityGenderGuideBinding;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.mvvm.home.activity.HomeActivity;
import com.sntech.ads.SNAdSdk;
import com.umeng.commonsdk.UMConfigure;
import je.i;
import ke.d;
import l9.i0;
import l9.m0;
import org.threeten.bp.LocalTime;
import ya.i1;

/* loaded from: classes3.dex */
public class EnterActivity extends MartianActivity {
    public static final int G = 6200;
    public static final String H = "SN_PRIVACY_ENABLE";
    public boolean C;
    public Handler D;

    /* renamed from: w */
    public ActivityEnterBinding f13104w;

    /* renamed from: x */
    public ActivityGenderGuideBinding f13105x;

    /* renamed from: y */
    public boolean f13106y;

    /* renamed from: z */
    public boolean f13107z;
    public int A = 0;
    public int B = 0;
    public final Runnable E = new b();
    public d8.b F = new c();

    public class a implements i0.m {
        public a() {
        }

        @Override // l9.i0.m
        public void a() {
            lb.c.n(EnterActivity.this);
        }

        @Override // l9.i0.m
        public void b() {
            lb.c.q(EnterActivity.this);
        }

        @Override // l9.i0.m
        public void c() {
        }

        @Override // l9.i0.m
        public void d() {
            EnterActivity.this.W2();
        }

        @Override // l9.i0.m
        public void e() {
            i.h(EnterActivity.this, true);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SetTextI18n"})
        public void run() {
            EnterActivity.this.A += 1000;
            if (EnterActivity.this.A < 6200) {
                EnterActivity.this.D.postDelayed(EnterActivity.this.E, 1000L);
            } else {
                ac.a.T(EnterActivity.this, "开屏-超时");
                EnterActivity.this.X2();
            }
        }
    }

    public class c extends d8.b {
        public c() {
        }

        @Override // d8.b, d8.a
        public void a() {
            EnterActivity enterActivity = EnterActivity.this;
            enterActivity.f13106y = true;
            enterActivity.X2();
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            EnterActivity.this.f13104w.splashContainer.setBackgroundColor(ConfigSingleton.D().n());
            EnterActivity.this.f13104w.iconLogo.setVisibility(0);
            if (EnterActivity.this.D != null) {
                EnterActivity.this.A = -4000;
                EnterActivity.this.a3();
            }
            ac.a.T(EnterActivity.this, "开屏-曝光");
            if (adConfig == null || !adConfig.isHwAd()) {
                return;
            }
            EnterActivity.this.f13107z = true;
        }

        @Override // d8.b, d8.a
        public void d(AdConfig adConfig) {
            EnterActivity enterActivity = EnterActivity.this;
            enterActivity.f13106y = true;
            enterActivity.X2();
        }

        @Override // d8.b, d8.a
        public void g(AdConfig adConfig) {
            EnterActivity enterActivity = EnterActivity.this;
            enterActivity.f13106y = true;
            enterActivity.X2();
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            if (EnterActivity.this.D != null) {
                EnterActivity.this.A = TTAdConstant.INIT_FAILED_LOAD_PLUGIN_FAILED;
                EnterActivity.this.a3();
            }
            SplashAdManager o22 = MiConfigSingleton.b2().o2();
            EnterActivity enterActivity = EnterActivity.this;
            o22.j(enterActivity, enterActivity.f13104w.splashContainer);
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            EnterActivity.this.f13107z = true;
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void a3() {
        if (this.D == null) {
            this.D = new Handler();
        } else {
            b3();
        }
        this.D.postDelayed(this.E, 1000L);
    }

    public final void L2(boolean z10) {
        if (!MiConfigSingleton.b2().F2()) {
            MiConfigSingleton.b2().u2().o(this, new MiCompoundUserManager.g() { // from class: qa.e
                public /* synthetic */ e() {
                }

                @Override // com.martian.mibook.account.MiCompoundUserManager.g
                public final void a(MiUser miUser) {
                    EnterActivity.this.O2(miUser);
                }
            });
        }
        MiConfigSingleton.b2().f2().e();
        MiConfigSingleton.b2().f2().d(new i1.c() { // from class: qa.f

            /* renamed from: b */
            public final /* synthetic */ boolean f29975b;

            public /* synthetic */ f(boolean z102) {
                z10 = z102;
            }

            @Override // ya.i1.c
            public final void a() {
                EnterActivity.this.P2(z10);
            }
        });
        if (!z102) {
            ab.a.a().d();
            if (MiConfigSingleton.b2().S1() < 0) {
                Y2();
                return;
            }
            MiConfigSingleton.b2().e2().S(this);
        }
        M2();
    }

    public void M2() {
        if (!MiConfigSingleton.b2().H2()) {
            MiConfigSingleton.b2().h3();
            ac.a.I(this, h.e(this) ? "通知开启" : "通知关闭");
            d.h().r(true);
            MiConfigSingleton.b2().M1().M2(MiConfigSingleton.b2().p(), null);
        }
        if (getIntent() == null || getIntent().getData() == null) {
            return;
        }
        X2();
    }

    public final boolean N2() {
        if (MiConfigSingleton.b2().G2()) {
            return false;
        }
        if (ConfigSingleton.D().w0()) {
            return true;
        }
        LocalTime now = LocalTime.now();
        return now.isAfter(LocalTime.of(20, 0)) || now.isBefore(LocalTime.of(7, 0));
    }

    public final /* synthetic */ void O2(MiUser miUser) {
        if (miUser == null) {
            return;
        }
        if ((miUser.isMale() && this.B == 2) || (miUser.isFemale() && this.B == 1)) {
            MiConfigSingleton.b2().g3(true);
        }
    }

    public final /* synthetic */ void P2(boolean z10) {
        MiConfigSingleton.b2().H1().Z();
        if (z10 || MiConfigSingleton.b2().S1() < 0) {
            return;
        }
        T2();
        a3();
    }

    public final /* synthetic */ void Q2() {
        U2(0);
    }

    public final /* synthetic */ void R2(MiUser miUser) {
        ac.a.v(this, "投放引流-进入");
        if (miUser == null) {
            Y2();
            return;
        }
        if (!miUser.isMale() && !miUser.isFemale()) {
            Y2();
            return;
        }
        ac.a.v(this, "投放引流-性别匹配");
        this.B = miUser.isFemale() ? 2 : 1;
        this.C = true;
        MiConfigSingleton.b2().g3(true);
        U2(this.B);
    }

    public final /* synthetic */ void S2() {
        MiConfigSingleton.b2().u2().o(this, new MiCompoundUserManager.g() { // from class: qa.c
            public /* synthetic */ c() {
            }

            @Override // com.martian.mibook.account.MiCompoundUserManager.g
            public final void a(MiUser miUser) {
                EnterActivity.this.R2(miUser);
            }
        });
    }

    public final void T2() {
        if (MiConfigSingleton.b2().C1()) {
            X2();
        } else {
            ac.a.T(this, "开屏-请求");
            MiConfigSingleton.b2().o2().h(this, this.F);
        }
    }

    public final void U2(int i10) {
        if (!this.C) {
            P1(getString(R.string.enter_wait));
            return;
        }
        this.C = false;
        this.B = i10;
        MiConfigSingleton.b2().b3(i10);
        MiConfigSingleton.b2().G1().z(true);
        ActivityGenderGuideBinding activityGenderGuideBinding = this.f13105x;
        if (activityGenderGuideBinding != null) {
            activityGenderGuideBinding.enterHint.setVisibility(0);
        }
        V2();
    }

    public final void V2() {
        ActivityGenderGuideBinding activityGenderGuideBinding = this.f13105x;
        if (activityGenderGuideBinding != null) {
            activityGenderGuideBinding.permissionGuide.setVisibility(8);
        }
        UMConfigure.submitPolicyGrantResult(getApplicationContext(), true);
        MiConfigSingleton.b2().A2(false);
        L2(true);
        this.f13106y = true;
        X2();
    }

    public final void W2() {
        ConfigSingleton.D().v0(ConfigSingleton.f12096z);
        if (MiConfigSingleton.b2().F2()) {
            X2();
            return;
        }
        UMConfigure.init(this, 1, "");
        ConfigSingleton.D().N(new ConfigSingleton.b() { // from class: qa.d
            public /* synthetic */ d() {
            }

            @Override // com.martian.libmars.common.ConfigSingleton.b
            public final void a() {
                EnterActivity.this.S2();
            }
        });
        ConfigSingleton.D().v0(H);
        if (e.s().q()) {
            SNAdSdk.updatePrivacyAgreed(getApplicationContext(), true);
        }
    }

    public void X2() {
        if (!this.f13106y) {
            this.f13106y = true;
            return;
        }
        if (m0.C(this)) {
            Intent intent = new Intent(this, (Class<?>) HomeActivity.class);
            Intent intent2 = getIntent();
            if (intent2 != null && intent2.getData() != null) {
                intent.setData(getIntent().getData());
            }
            startActivity(intent);
            finish();
        }
    }

    public void Y2() {
        int i10;
        if (this.f13105x == null) {
            this.C = true;
            this.f13104w.genderGuide.setLayoutResource(R.layout.activity_gender_guide);
            ActivityGenderGuideBinding bind = ActivityGenderGuideBinding.bind(this.f13104w.genderGuide.inflate());
            this.f13105x = bind;
            bind.enterSkip.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.f13105x.enterSkip.getLayoutParams()).topMargin = p1() + ConfigSingleton.i(12.0f);
            int i11 = ConfigSingleton.i(28.0f);
            if (j1() > 0 && (i10 = (int) ((((r1 / 2) - ConfigSingleton.i(230.0f)) - p1()) * 0.4f)) > i11) {
                i11 = i10;
            }
            ((RelativeLayout.LayoutParams) this.f13105x.genderGuideTitleView.getLayoutParams()).bottomMargin = i11;
            MiConfigSingleton.b2().H1().B(this, this.f13105x.guideTitle);
        }
    }

    public final void Z2() {
        if (N2()) {
            W2();
        } else {
            i0.J0(this, getString(R.string.app_name_bak), false, new a());
        }
    }

    public final void b3() {
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacks(this.E);
        }
    }

    public void onBoyClick(View view) {
        U2(1);
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityEnterBinding inflate = ActivityEnterBinding.inflate(LayoutInflater.from(this));
        this.f13104w = inflate;
        setContentView(inflate.getRoot());
        g(false);
        if (ConfigSingleton.D().V0()) {
            if (m.q(this)) {
                ((RelativeLayout.LayoutParams) this.f13104w.iconLogo.getLayoutParams()).topMargin = p1() + ConfigSingleton.i(4.0f);
            }
            if (!ConfigSingleton.D().F(H)) {
                if (e.s().q()) {
                    SNAdSdk.updatePrivacyAgreed(this, true);
                }
                ConfigSingleton.D().v0(H);
            }
            L2(false);
            return;
        }
        if (MiConfigSingleton.b2().y0()) {
            TeenagerBookmallActivity.N2(this, false);
            finish();
            return;
        }
        Z2();
        if (ConfigSingleton.D().Y() == 0 && m.N(this)) {
            MiConfigSingleton.b2().e1(true);
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f13104w.splashContainer.removeAllViews();
        MiConfigSingleton.b2().o2().f();
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.F = null;
    }

    public void onGenderSkipClick(View view) {
        i0.z0(this, getString(R.string.confirm_message), getString(R.string.gender_skip_hint), new i0.l() { // from class: qa.g
            public /* synthetic */ g() {
            }

            @Override // l9.i0.l
            public final void a() {
                EnterActivity.this.Q2();
            }
        });
    }

    public void onGirlClick(View view) {
        U2(2);
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4 || i10 == 3) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f13106y = false;
        b3();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (this.f13107z) {
            this.f13106y = true;
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.C) {
            X2();
        }
        if (this.D != null) {
            a3();
        }
    }
}
