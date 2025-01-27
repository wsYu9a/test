package com.martian.mibook.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.BaeAd;
import com.martian.ads.ad.BaseAd;
import com.martian.ads.ad.DXAd;
import com.martian.ads.ad.GDTAd;
import com.martian.ads.ad.KsAd;
import com.martian.ads.ad.TTAd;
import com.martian.ads.ad.VivoAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.k0;
import com.martian.mibook.account.MiCompoundUserManager;
import com.martian.mibook.activity.book.TeenagerBookmallActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.ttbook.sdk.client.AdController;
import com.martian.ttbookhd.R;
import com.qq.e.ads.splash.SplashAD;
import com.umeng.commonsdk.UMConfigure;
import com.vivo.mobilead.unified.splash.UnifiedVivoSplashAd;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class EnterActivity extends j1 {
    private static final long B = 6000;
    private com.martian.mibook.e.j C;
    private com.martian.mibook.e.k D;
    private int E;
    protected boolean F;
    private boolean G;
    private boolean J;
    private AppTask K;
    private d L;
    private Handler M;
    private int H = 0;
    private int I = 0;
    private final Runnable N = new c();
    private int O = 0;
    private long P = -1;

    /* loaded from: classes3.dex */
    class a implements k0.m {
        a() {
        }

        @Override // com.martian.libmars.utils.k0.m
        public void a() {
        }

        @Override // com.martian.libmars.utils.k0.m
        public void b() {
            com.martian.mibook.lib.account.e.c.f(EnterActivity.this);
        }

        @Override // com.martian.libmars.utils.k0.m
        public void c() {
            com.martian.mibook.lib.account.e.c.i(EnterActivity.this);
        }

        @Override // com.martian.libmars.utils.k0.m
        public void d() {
            com.martian.libmars.d.h.F().D0(com.martian.libmars.d.h.f9882a);
            com.martian.libmars.d.h.F().V();
            EnterActivity.this.E2();
            UMConfigure.init(EnterActivity.this, 1, "");
        }

        @Override // com.martian.libmars.utils.k0.m
        public void e() {
            EnterActivity.this.startActivity(BaseFunctionGuideActivity.class);
        }
    }

    /* loaded from: classes3.dex */
    class b implements com.martian.libsupport.permission.f {
        b() {
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionDenied() {
            EnterActivity.this.z2("权限被拒绝", true);
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionGranted() {
            EnterActivity.this.z2("权限被允许", true);
        }
    }

    /* loaded from: classes3.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SetTextI18n"})
        public void run() {
            EnterActivity.this.H += 1000;
            if (EnterActivity.this.H < EnterActivity.B) {
                EnterActivity.this.M.postDelayed(EnterActivity.this.N, 1000L);
            } else {
                com.martian.mibook.lib.model.g.b.o(EnterActivity.this, "开屏-超时");
                EnterActivity.this.C2();
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends b.d.a.k.b {

        /* renamed from: a */
        private final WeakReference<EnterActivity> f10823a;

        public d(EnterActivity activity) {
            this.f10823a = new WeakReference<>(activity);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void a(AdConfig config) {
            EnterActivity enterActivity = this.f10823a.get();
            if (enterActivity != null) {
                enterActivity.B2(config);
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void b(AdConfig config) {
            EnterActivity enterActivity = this.f10823a.get();
            if (enterActivity != null) {
                enterActivity.C2();
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void c(AdConfig config) {
            EnterActivity enterActivity = this.f10823a.get();
            if (enterActivity != null) {
                enterActivity.C2();
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            EnterActivity enterActivity = this.f10823a.get();
            if (enterActivity != null) {
                enterActivity.G2(appTaskList.getApps().get(0));
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            MiConfigSingleton.V3().L4.z0(true);
            EnterActivity enterActivity = this.f10823a.get();
            if (enterActivity != null) {
                enterActivity.C2();
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void j(AdConfig config) {
            EnterActivity enterActivity = this.f10823a.get();
            if (enterActivity != null) {
                enterActivity.A2(config);
            }
        }
    }

    private void D2() {
        if (!(com.martian.libsupport.l.t() && !com.martian.libsupport.l.D())) {
            z2("未请求权限", false);
            return;
        }
        com.martian.mibook.e.k kVar = this.D;
        if (kVar != null) {
            com.martian.libmars.utils.h0.a(this, kVar.l, true, com.martian.libmars.utils.h0.f10145b);
        }
        com.martian.libsupport.permission.g.h(this, new b(), new String[]{com.kuaishou.weapon.p0.g.f9318c}, false, null, true);
    }

    private void F2() {
        com.martian.libmars.utils.k0.a0(this, getString(R.string.app_name_bak), false, new a());
    }

    public void G2(final AppTask appTask) {
        if (appTask == null) {
            return;
        }
        if (isFinishing() || this.E == 1) {
            MiConfigSingleton.V3().N4.O(appTask);
        } else {
            com.martian.libugrowth.b.k().g(appTask.id, AdConfig.Action.ESHOW, appTask.source, appTask.getGid(), appTask.getEcpm());
            this.K = appTask;
            appTask.exposed = true;
            this.C.f12152d.post(new Runnable() { // from class: com.martian.mibook.activity.l
                @Override // java.lang.Runnable
                public final void run() {
                    EnterActivity.this.v2(appTask);
                }
            });
        }
        if (this.E == 0) {
            this.E = 1;
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void H2() {
        if (this.M == null) {
            this.M = new Handler();
        }
        this.M.postDelayed(this.N, 1000L);
    }

    private void I2() {
        Handler handler = this.M;
        if (handler != null) {
            handler.removeCallbacks(this.N);
        }
    }

    private void J2() {
        if (this.O <= 0 || System.currentTimeMillis() - this.P <= 2000) {
            this.O++;
        } else {
            this.O = 1;
        }
        this.P = System.currentTimeMillis();
        if (this.O >= 8) {
            this.O = 0;
            MiConfigSingleton.V3().S8(this);
        }
    }

    private void m2(final boolean isFirstIn) {
        if (!MiConfigSingleton.V3().x5()) {
            MiConfigSingleton.V3().M4.c(this, new MiCompoundUserManager.e() { // from class: com.martian.mibook.activity.m
                @Override // com.martian.mibook.account.MiCompoundUserManager.e
                public final void a() {
                    EnterActivity.this.p2(isFirstIn);
                }
            });
        }
        MiConfigSingleton.V3().e4().a();
        if (!isFirstIn) {
            if (MiConfigSingleton.V3().v3() < 0) {
                com.martian.mibook.lib.model.g.b.H(this, "性别弹窗-展示");
                E2();
                return;
            } else {
                w2();
                H2();
                MiConfigSingleton.V3().L4.R(this);
                MiConfigSingleton.V3().L4.o(this, null);
            }
        }
        n2();
    }

    /* renamed from: o2 */
    public /* synthetic */ void p2(final boolean isFirstIn) {
        MiUser C4;
        if (!isFirstIn || (C4 = MiConfigSingleton.V3().C4()) == null) {
            return;
        }
        if ((C4.isMale() && this.I == 2) || (C4.isFemale() && this.I == 1)) {
            MiConfigSingleton.V3().J7(true);
        }
    }

    /* renamed from: q2 */
    public /* synthetic */ void r2() {
        y2(this.I, "跳过");
    }

    /* renamed from: s2 */
    public /* synthetic */ void t2(View v) {
        J2();
    }

    /* renamed from: u2 */
    public /* synthetic */ void v2(final AppTask appTask) {
        Object obj = appTask.origin;
        if (obj instanceof CSJSplashAd) {
            TTAd.showSplashAd((CSJSplashAd) obj, this.C.f12152d);
            return;
        }
        if (obj instanceof KsSplashScreenAd) {
            KsAd.showSplashAd(this, appTask, this.C.f12152d, this.L);
            return;
        }
        if (obj instanceof SplashAd) {
            BaeAd.showSplashAd((SplashAd) obj, this.C.f12152d, appTask.isBidding());
            return;
        }
        if (obj instanceof AdController) {
            DXAd.showSplashAd((AdController) obj, this.C.f12152d);
            return;
        }
        if (obj instanceof SplashAD) {
            GDTAd.showSplashAd((SplashAD) obj, this.C.f12152d, appTask.isBidding());
        } else if (obj instanceof UnifiedVivoSplashAd) {
            VivoAd.showSplashAd(appTask, this.C.f12152d);
        } else if (BaseAd.isOppoSplashAd(appTask)) {
            BaseAd.showOppoSplashAd(this, appTask);
        }
    }

    private void w2() {
        if (MiConfigSingleton.V3().B2()) {
            C2();
            return;
        }
        if (this.L == null) {
            this.L = new d(this);
        }
        G2(MiConfigSingleton.V3().N4.y(this, this.L));
    }

    private void x2(AdConfig adConfig, String event) {
        if (adConfig == null || !adConfig.isKsAd()) {
            return;
        }
        com.martian.mibook.b.b.J0(adConfig, event);
    }

    private void y2(int gender, String event) {
        if (!this.J) {
            k1(getString(R.string.enter_wait));
            return;
        }
        this.J = false;
        this.I = gender;
        MiConfigSingleton.V3().q7(gender);
        MiConfigSingleton.V3().K7(true);
        this.D.f12213b.setVisibility(0);
        D2();
    }

    public void z2(String event, boolean fromPermission) {
        com.martian.mibook.e.k kVar = this.D;
        if (kVar != null) {
            kVar.l.setVisibility(8);
        }
        UMConfigure.submitPolicyGrantResult(getApplicationContext(), true);
        MiConfigSingleton.V3().a5(false);
        com.martian.mibook.lib.model.g.b.Z(this, event);
        m2(true);
        this.F = true;
        if (fromPermission) {
            new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.a
                @Override // java.lang.Runnable
                public final void run() {
                    EnterActivity.this.C2();
                }
            }, 1000L);
        } else {
            C2();
        }
    }

    public void A2(AdConfig config) {
        x2(config, AdConfig.ActionString.CLICK);
        this.G = true;
    }

    public void B2(AdConfig config) {
        x2(config, AdConfig.ActionString.SHOW);
        this.C.f12152d.setBackgroundColor(com.martian.libmars.d.h.F().g());
        this.E = 2;
        this.C.f12151c.setVisibility(0);
        if (this.M != null) {
            I2();
            this.H = 0;
            H2();
        }
    }

    public void C2() {
        if (!this.F) {
            this.F = true;
            return;
        }
        if (com.martian.libmars.utils.n0.C(this)) {
            Intent intent = new Intent(this, (Class<?>) Homepage.class);
            Intent intent2 = getIntent();
            if (intent2 != null && intent2.getData() != null) {
                intent.setData(getIntent().getData());
            }
            startActivity(intent);
            finish();
        }
    }

    public void E2() {
        int b2;
        if (this.D == null) {
            this.J = true;
            this.C.f12150b.setLayoutResource(R.layout.activity_gender_guide);
            com.martian.mibook.e.k a2 = com.martian.mibook.e.k.a(this.C.f12150b.inflate());
            this.D = a2;
            a2.f12214c.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.D.f12214c.getLayoutParams()).topMargin = F0() + com.martian.libmars.d.h.b(12.0f);
            int b3 = com.martian.libmars.d.h.b(28.0f);
            if (z0() > 0 && (b2 = (int) ((((r1 / 2) - com.martian.libmars.d.h.b(230.0f)) - F0()) * 0.4f)) > b3) {
                b3 = b2;
            }
            ((RelativeLayout.LayoutParams) this.D.f12219h.getLayoutParams()).bottomMargin = b3;
            this.D.k.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnterActivity.this.t2(view);
                }
            });
        }
    }

    protected void n2() {
        if (!MiConfigSingleton.V3().C5()) {
            MiConfigSingleton.V3().O7();
            com.martian.mibook.lib.model.g.b.P(this, com.martian.libsupport.f.d(this) ? "通知开启" : "通知关闭");
            com.martian.mipush.c.i().s(true);
        }
        if (getIntent() == null || getIntent().getData() == null) {
            return;
        }
        C2();
    }

    public void onBoyClick(View view) {
        y2(1, "男生");
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.martian.mibook.e.j c2 = com.martian.mibook.e.j.c(LayoutInflater.from(this));
        this.C = c2;
        setContentView(c2.getRoot());
        d(false);
        if (com.martian.libmars.d.h.F().h1()) {
            if (com.martian.libsupport.l.w(this)) {
                ((RelativeLayout.LayoutParams) this.C.f12151c.getLayoutParams()).topMargin = F0() + com.martian.libmars.d.h.b(4.0f);
            }
            m2(false);
            return;
        }
        if (!MiConfigSingleton.V3().F0()) {
            F2();
        } else {
            TeenagerBookmallActivity.t2(this, false);
            finish();
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        AppTask appTask = this.K;
        if (appTask != null && "OPPO".equalsIgnoreCase(appTask.source) && MiConfigSingleton.V3().B6()) {
            this.K.destroySplashAd();
        }
        this.C.f12152d.removeAllViews();
    }

    public void onGenderSkipClick(View view) {
        com.martian.libmars.utils.k0.P(this, getString(R.string.confirm_message), getString(R.string.gender_skip_hint), new k0.l() { // from class: com.martian.mibook.activity.k
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                EnterActivity.this.r2();
            }
        });
    }

    public void onGirlClick(View view) {
        y2(2, "女生");
    }

    @Override // com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4 || keyCode == 3) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.F = false;
        I2();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.G) {
            this.F = true;
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.J) {
            C2();
        }
        if (this.M != null) {
            H2();
        }
    }
}
