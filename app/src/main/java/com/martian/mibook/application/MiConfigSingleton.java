package com.martian.mibook.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import b8.e;
import ba.g;
import ba.h;
import ba.j;
import ba.l;
import ba.m;
import ba.o;
import com.bytedance.hume.readapk.HumeSDK;
import com.google.gson.GsonBuilder;
import com.martian.libmars.common.ActivityHooker;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libqq.QQAPIInstance;
import com.martian.mibook.R;
import com.martian.mibook.account.MiCompoundUserManager;
import com.martian.mibook.activity.EnterActivity;
import com.martian.mibook.activity.EnterRestartActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.MiOptions;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.model.BaseConfigSingleton;
import com.martian.mibook.lib.model.InterfaceAdapter;
import com.martian.mibook.lib.model.data.BookWrapperList;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.MiTheme;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.payment.activity.VipPayActivity;
import com.martian.mibook.mvvm.tts.TtsTimeController;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.utils.SensorHook;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import com.sntech.ads.SNAdConfig;
import com.sntech.ads.SNAdSdk;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import g9.i;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import ke.d;
import l9.m0;
import uc.f;
import ya.b1;
import ya.d1;
import ya.e0;
import ya.i1;
import ya.j1;
import ya.m1;
import ya.n0;

/* loaded from: classes3.dex */
public class MiConfigSingleton extends BaseConfigSingleton {
    public static final String P0 = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String Q0 = "backup";
    public static final String R0;
    public static final String S0;
    public static final String T0 = "BookId";
    public static final String U0 = "BookName";
    public static final String V0 = "intent_author";
    public static final String W0 = "intent_seed";
    public static final String X0 = "intent_yw_category";
    public static final String Y0 = "intent_yw_category_title";
    public static final String Z0 = "intent_yw_channel_mcid";

    /* renamed from: a1 */
    public static final String f13315a1 = "intent_yw_channel_seed";

    /* renamed from: b1 */
    public static final String f13316b1 = "intent_yw_channel_title";

    /* renamed from: c1 */
    public static final String f13317c1 = "intent_yw_channel_page_index";

    /* renamed from: d1 */
    public static final String f13318d1 = "intent_yw_channel_ext";

    /* renamed from: e1 */
    public static final String f13319e1 = "pref_teenager_mode";

    /* renamed from: f1 */
    public static final String f13320f1 = "pref_checkin_notify";

    /* renamed from: g1 */
    public static final String f13321g1 = "DIRECTORY_RECORE";

    /* renamed from: h1 */
    public static final String f13322h1 = "BOOK_VIEW_MODE";

    /* renamed from: i1 */
    public static final String f13323i1 = "PREF_HAS_INVITER";

    /* renamed from: j1 */
    public static final String f13324j1 = "pref_gender";

    /* renamed from: k1 */
    public static final int f13325k1 = 1;

    /* renamed from: l1 */
    public static final int f13326l1 = 2;

    /* renamed from: m1 */
    public static final String f13327m1 = "pref_gender_confirm";

    /* renamed from: n1 */
    public static final String f13328n1 = "pref_gender_guide";

    /* renamed from: o1 */
    public static final int f13329o1 = 0;

    /* renamed from: p1 */
    public static final int f13330p1 = 1;

    /* renamed from: q1 */
    public static final String f13331q1 = "PREF_RECHARGE_TYPE";

    /* renamed from: r1 */
    public static final String f13332r1 = "NOTIFICATION_STATUS";
    public ReaderTypefaceManager C0;
    public i1 D0;
    public c E0;
    public MiCompoundUserManager F0;
    public EventManager G0;
    public com.martian.mibook.application.a H0;
    public SplashAdManager I0;
    public ya.a J0;
    public AppViewModel L0;
    public Boolean N0;

    /* renamed from: p0 */
    public MiBookManager f13333p0;

    /* renamed from: q0 */
    public MiSearchManager f13334q0;

    /* renamed from: r0 */
    public b1 f13335r0;

    /* renamed from: s0 */
    public j1 f13336s0;

    /* renamed from: t0 */
    public m1 f13337t0;

    /* renamed from: u0 */
    public ReaderThemeManager f13338u0;
    public boolean K0 = false;
    public int M0 = -1;
    public int O0 = -1;

    public class ApplicationLifecycleObserver implements DefaultLifecycleObserver {
        public /* synthetic */ ApplicationLifecycleObserver(MiConfigSingleton miConfigSingleton, d1 d1Var) {
            this();
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
        public void onCreate(@NonNull LifecycleOwner lifecycleOwner) {
            k0.a.a(this, lifecycleOwner);
            MiConfigSingleton.this.registerActivityLifecycleCallbacks(n0.f33313a);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
        public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
            k0.a.b(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            k0.a.c(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            k0.a.d(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
        public void onStart(@NonNull LifecycleOwner lifecycleOwner) {
            k0.a.e(this, lifecycleOwner);
            MiConfigSingleton.this.S2();
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
        public void onStop(@NonNull LifecycleOwner lifecycleOwner) {
            k0.a.f(this, lifecycleOwner);
            MiConfigSingleton.this.R2();
        }

        public ApplicationLifecycleObserver() {
        }
    }

    public class a implements d.c {
        public a() {
        }

        @Override // ke.d.c
        public void a(Context context, String str) {
        }

        @Override // ke.d.c
        public void b(Context context, String str) {
        }

        @Override // ke.d.c
        public void c(Context context, String str) {
        }
    }

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(p1.b.f29697h);
        String str = File.separator;
        sb2.append(str);
        sb2.append("martian");
        sb2.append(str);
        sb2.append("tfbook");
        sb2.append(str);
        String sb3 = sb2.toString();
        R0 = sb3;
        S0 = sb3 + Q0 + str;
    }

    public static MiConfigSingleton b2() {
        return (MiConfigSingleton) ConfigSingleton.R;
    }

    public boolean A1(String str) {
        return K0(Z1(str));
    }

    public void A2(boolean z10) {
        if (z10) {
            UMConfigure.init(this, 1, "");
        }
        x2();
        o.d(new Runnable() { // from class: ya.c1
            public /* synthetic */ c1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MiConfigSingleton.this.O2();
            }
        });
        z2();
    }

    public final String[] B1() {
        return c2().getCommentKeywords();
    }

    public boolean B2() {
        MartianRPAccount m22 = m2();
        return m22 != null && m22.isChargeUser();
    }

    public boolean C1() {
        return K2() || C2();
    }

    public boolean C2() {
        if (this.O0 < 0) {
            if (B0()) {
                e3(0);
            } else if (b2().y0()) {
                e3(1);
            } else if (!c2().isAdCompliance()) {
                e3(0);
                b2().v0("PREF_MARKET_AD_COMPLIANCE");
            } else if (c2().getAdComplianceControlable()) {
                e3(1);
            } else {
                e3(!b2().F("PREF_MARKET_AD_COMPLIANCE") ? 1 : 0);
            }
        }
        return this.O0 > 0;
    }

    public boolean D1() {
        return R1() && h.e(this);
    }

    public boolean D2() {
        return u2().v() && u2().f13078a.u();
    }

    public boolean E1() {
        return (C2() || e2().e0()) ? false : true;
    }

    public boolean E2() {
        return this.K0 && C2();
    }

    public boolean F1() {
        return !C2() && c2().getEnablexianPlay().booleanValue();
    }

    public boolean F2() {
        return u2().v();
    }

    public ya.a G1() {
        if (this.J0 == null) {
            this.J0 = new ya.a();
        }
        return this.J0;
    }

    public boolean G2() {
        return true;
    }

    public com.martian.mibook.application.a H1() {
        if (this.H0 == null) {
            this.H0 = new com.martian.mibook.application.a(this);
        }
        return this.H0;
    }

    public boolean H2() {
        return K0(j.h(this, f13332r1, -1L));
    }

    public int I1(boolean z10) {
        if (B0()) {
            return z10 ? 2 : 1;
        }
        return (z10 ? c2().getAdsHideSecondIntervalMinutes() : c2().getAdsHideIntervalMinutes()).intValue();
    }

    public boolean I2() {
        MartianRPAccount m22 = m2();
        return m22 != null && m22.isPaymentUser();
    }

    public String J1() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
    }

    public boolean J2() {
        return !l.q(q2());
    }

    public String K1() {
        return z() + File.separator + S0;
    }

    public boolean K2() {
        MartianRPAccount m22 = m2();
        return m22 != null && m22.getIsVip() > 0;
    }

    public int L1() {
        return A0() ? R.drawable.cover_loading_default_night : R.drawable.cover_loading_default_day;
    }

    public boolean L2() {
        MartianRPAccount m22 = m2();
        return m22 != null && m22.getVipEnd() != null && m22.getVipEnd().longValue() > 0 && MartianRPUserManager.a() > m22.getVipEnd().longValue();
    }

    public MiBookManager M1() {
        if (this.f13333p0 == null) {
            this.f13333p0 = new MiBookManager(getApplicationContext());
        }
        return this.f13333p0;
    }

    public boolean M2() {
        MartianRPAccount m22 = m2();
        return m22 != null && m22.getIsVip() <= 0 && m22.getVipEnd() == null;
    }

    public String N1(Activity activity, int i10) {
        if (!m0.C(activity)) {
            return "";
        }
        if (i10 >= 10) {
            i10 /= 10;
        }
        switch (i10) {
            case 1:
                return activity.getString(R.string.category_hot);
            case 2:
                return activity.getString(R.string.category_favorite);
            case 3:
                return activity.getString(R.string.category_read);
            case 4:
                return activity.getString(R.string.category_clicked);
            case 5:
                return activity.getString(R.string.category_potential);
            case 6:
            case 10:
                return activity.getString(R.string.category_recommend);
            case 7:
                return activity.getString(R.string.category_up);
            case 8:
                return activity.getString(R.string.category_search);
            case 9:
            default:
                return activity.getString(R.string.category_sell_well);
            case 11:
                return activity.getString(R.string.category_finished);
        }
    }

    public boolean N2() {
        return u2().v() && !u2().f13078a.u();
    }

    public int O1() {
        if (this.M0 < 0) {
            this.M0 = j.f(getApplicationContext(), f13322h1, 1);
        }
        return this.M0;
    }

    public final /* synthetic */ void O2() {
        ab.a.a().b();
        z7.b.d().f(this, q0());
        QQAPIInstance.getInstance().init(W(), this);
        H1().L0();
        if (!e.s().q() || TextUtils.isEmpty(b2().M())) {
            return;
        }
        SNAdSdk.getAdManager().setUserId(M());
    }

    public b1 P1() {
        if (this.f13335r0 == null) {
            this.f13335r0 = new b1(M1());
        }
        return this.f13335r0;
    }

    public void P2(Activity activity, MiCompoundUserManager.g gVar) {
        u2().K();
        e2().x0(-1L);
        u2().o(activity, gVar);
    }

    public int Q1() {
        String j10 = j.j(this, getString(R.string.check_update_push_pref_key));
        if (TextUtils.isEmpty(j10)) {
            return 2;
        }
        return Integer.parseInt(j10);
    }

    public boolean Q2() {
        if (S1() <= 0) {
            return true;
        }
        return j.d(this, f13328n1, false);
    }

    public boolean R1() {
        return j.d(this, f13320f1, true);
    }

    public final void R2() {
        Activity c10 = n0.f33313a.c();
        if (c10 != null) {
            Z0(false);
            if (V0()) {
                b2().V1().s(this);
                d2().b(this);
                MobclickAgent.onKillProcess(this);
                M1().U2(c10);
                if (!b2().C1() && !(c10 instanceof EnterActivity)) {
                    o2().h(this, null);
                }
            }
        }
        TtsTimeController.u(this);
    }

    public int S1() {
        return j.f(this, f13327m1, -1);
    }

    public final void S2() {
        Activity c10 = n0.f33313a.c();
        if (c10 != null) {
            Z0(true);
            z1(c10);
            NotificationManagerCompat.from(c10).cancel(j1.f33256a);
        }
    }

    public String T1() {
        return e0.f33140b + hf.e.f26694a + t2();
    }

    public boolean T2() {
        return j.d(this, getString(R.string.record_bookrack_category_pref_key), false);
    }

    public String U1() {
        String j10 = j.j(getApplicationContext(), f13321g1);
        return l.q(j10) ? P0 : !new File(j10).exists() ? P0 : j.j(getApplicationContext(), f13321g1);
    }

    public void U2(me.b bVar) {
        u2().M(bVar);
    }

    public EventManager V1() {
        if (this.G0 == null) {
            this.G0 = new EventManager(this);
        }
        return this.G0;
    }

    public boolean V2() {
        return j.d(this, getString(R.string.send_book_info_pref_key), true);
    }

    @Override // com.martian.libmars.common.ConfigSingleton
    public i W() {
        return new i(e0.f33150g);
    }

    public int W1() {
        MiTaskAccount p22 = p2();
        if (p22 != null) {
            return p22.getExpLevel();
        }
        return 0;
    }

    public boolean W2() {
        if (this.N0 == null) {
            this.N0 = Boolean.valueOf(j.d(this, getString(R.string.send_ad_info_pref_key), true));
        }
        return this.N0.booleanValue();
    }

    @Override // com.martian.libmars.common.ConfigSingleton
    public String X() {
        String channel = HumeSDK.getChannel(this);
        return l.q(channel) ? J() : channel;
    }

    public boolean X1() {
        return j.d(this, f13324j1, false);
    }

    public void X2(int i10) {
        this.M0 = i10;
        j.m(getApplicationContext(), f13322h1, i10);
    }

    public String Y1() {
        return F2() ? u2().s().getHeader() : "";
    }

    public void Y2(boolean z10) {
        j.p(this, getString(R.string.show_image_pref_key), z10);
    }

    public long Z1(String str) {
        return j.h(this, str, -1L);
    }

    public void Z2(int i10) {
        j.o(this, getString(R.string.check_update_push_pref_key), String.valueOf(i10));
    }

    public MiReadingRecord a2() {
        List<MiReadingRecord> miReadingRecords = M1().r0().getMiReadingRecords();
        if (miReadingRecords == null || miReadingRecords.isEmpty()) {
            return null;
        }
        return miReadingRecords.get(0);
    }

    public void a3(boolean z10) {
        j.p(this, f13320f1, z10);
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        e.s().u(this, !"YWT2".equalsIgnoreCase(r()));
        if (e.s().q()) {
            SNAdSdk.onApplicationAttachBaseContext(this, SNAdConfig.Builder.newBuilder().withAppId(e0.f33176t).withChannel(r()).withDebug(B0()).build());
        }
    }

    public void b3(int i10) {
        j.m(this, f13327m1, i10);
    }

    public synchronized MiOptions c2() {
        return f2().l();
    }

    public void c3(String str) {
        j.o(getApplicationContext(), f13321g1, str);
    }

    public j1 d2() {
        if (this.f13336s0 == null) {
            this.f13336s0 = new j1();
        }
        return this.f13336s0;
    }

    public void d3(boolean z10) {
        j.p(this, f13323i1, z10);
    }

    public c e2() {
        if (this.E0 == null) {
            this.E0 = new c(this);
        }
        return this.E0;
    }

    public void e3(int i10) {
        this.O0 = i10;
    }

    public i1 f2() {
        if (this.D0 == null) {
            this.D0 = new i1(getApplicationContext());
        }
        return this.D0;
    }

    public void f3(String str, boolean z10) {
        if (z10 && !K0(Z1(str))) {
            Y0(str);
        }
        t0(str);
        j.n(this, str, MartianRPUserManager.a());
    }

    public int g2() {
        String j10 = j.j(this, getString(R.string.pref_push_interval_time));
        if (TextUtils.isEmpty(j10)) {
            return 7200;
        }
        return Integer.parseInt(j10) / 1000;
    }

    public void g3(boolean z10) {
        j.p(this, f13328n1, z10);
    }

    public ReaderThemeManager h2() {
        if (this.f13338u0 == null) {
            this.f13338u0 = new ReaderThemeManager(this);
        }
        return this.f13338u0;
    }

    public void h3() {
        j.n(this, f13332r1, MartianRPUserManager.a());
    }

    public ReaderTypefaceManager i2() {
        if (this.C0 == null) {
            this.C0 = new ReaderTypefaceManager(this);
        }
        return this.C0;
    }

    public void i3(String str) {
        j.o(this, f13319e1, str);
    }

    public int j2() {
        return j.f(this, f13331q1, 0);
    }

    public void j3(int i10) {
        j.o(this, getString(R.string.pref_push_interval_time), String.valueOf(i10));
    }

    public int k2() {
        return p() == 2 ? 1 : 2;
    }

    public void k3(int i10) {
        j.m(this, f13331q1, i10);
    }

    @Override // com.martian.libmars.common.ConfigSingleton
    public g9.a l() {
        return new g9.a(e0.f33140b, e0.f33142c);
    }

    @Override // com.martian.libmars.common.ConfigSingleton
    public int l0() {
        return com.martian.libmars.R.color.theme_default;
    }

    public int l2() {
        MiTaskAccount p22 = p2();
        if (p22 != null) {
            return p22.getReward();
        }
        return 0;
    }

    public void l3(boolean z10) {
        j.p(this, getString(R.string.record_bookrack_category_pref_key), z10);
    }

    public MartianRPAccount m2() {
        return (MartianRPAccount) u2().q();
    }

    public void m3(boolean z10) {
        j.p(this, getString(R.string.send_book_info_pref_key), z10);
    }

    public MiSearchManager n2() {
        if (this.f13334q0 == null) {
            this.f13334q0 = new MiSearchManager(getApplicationContext());
        }
        return this.f13334q0;
    }

    public void n3(boolean z10) {
        this.N0 = Boolean.valueOf(z10);
        j.p(this, getString(R.string.send_ad_info_pref_key), z10);
    }

    public SplashAdManager o2() {
        if (this.I0 == null) {
            this.I0 = new SplashAdManager(this);
        }
        return this.I0;
    }

    public boolean o3(Activity activity) {
        return K2() || (activity instanceof EnterActivity) || (activity instanceof VipPayActivity) || System.currentTimeMillis() - this.f12114s <= ((long) c2().getSplashRestartDelay().intValue());
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i10 = configuration.uiMode & 48;
        if (i10 == 16 || i10 == 32) {
            ConfigSingleton.D().b1(i10 == 32);
            AppViewModel appViewModel = this.L0;
            if (appViewModel != null) {
                appViewModel.v0(true);
            }
        }
    }

    @Override // com.martian.libmars.common.ConfigSingleton, android.app.Application
    public void onCreate() {
        String processName;
        super.onCreate();
        if (m.w()) {
            processName = Application.getProcessName();
            if (!getPackageName().equals(processName)) {
                WebView.setDataDirectorySuffix(processName);
            }
        }
        ActivityHooker.a();
        if (e.s().q()) {
            SNAdSdk.onApplicationCreate(this);
        }
        if (F0()) {
            y2();
            UMConfigure.preInit(this, e0.f33188z, r());
            ProcessLifecycleOwner.get().getLifecycle().addObserver(new ApplicationLifecycleObserver());
            if (V0()) {
                A2(true);
            }
            f.f().k();
            if (B0()) {
                n1.a.r();
                n1.a.q();
            }
            n1.a.k(this);
            this.L0 = lc.b.a(this);
            y1();
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (e.s().q()) {
            SNAdSdk.onApplicationLowMemory(this);
        }
    }

    @Override // com.martian.libmars.common.ConfigSingleton
    public int p() {
        int S1 = S1();
        if (S1 != 0) {
            return S1;
        }
        if (!F2() || s2() == null) {
            return X1() ? 2 : 1;
        }
        if (s2().getGender().charValue() == 'M') {
            return 1;
        }
        return (s2().getGender().charValue() == 'F' || X1()) ? 2 : 1;
    }

    public MiTaskAccount p2() {
        return (MiTaskAccount) u2().r();
    }

    public boolean p3() {
        if (B0()) {
            return true;
        }
        return c2().getShowComments() && !b2().y0();
    }

    @Override // com.martian.libmars.common.ConfigSingleton
    public z7.c q0() {
        return new z7.c(e0.f33146e, e0.f33148f, null);
    }

    public String q2() {
        return j.j(this, f13319e1);
    }

    public void q3(MiOptions miOptions) {
        if (miOptions.getAdComplianceControlable()) {
            e3(miOptions.isAdCompliance() ? 1 : 0);
        } else {
            if (!C2() || miOptions.isAdCompliance()) {
                return;
            }
            e3(0);
            SensorHook.INSTANCE.getInstance().setParams(false, c2().getSensorEnableSeconds());
        }
    }

    public m1 r2() {
        if (this.f13337t0 == null) {
            this.f13337t0 = new m1();
        }
        return this.f13337t0;
    }

    public String r3() {
        return c2().getVerifyPhoneHint();
    }

    @Override // com.martian.mibook.lib.model.BaseConfigSingleton
    public MiTheme s1() {
        return r2().e();
    }

    public MiUser s2() {
        return (MiUser) u2().s();
    }

    public String t2() {
        if (u2().s() == null || u2().s().getUid() == null) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
        }
        return u2().s().getUid() + "";
    }

    public MiCompoundUserManager u2() {
        if (this.F0 == null) {
            this.F0 = new MiCompoundUserManager(this);
        }
        return this.F0;
    }

    public long v2() {
        MartianRPAccount m22 = m2();
        if (m22 == null || m22.getVipEnd() == null) {
            return -1L;
        }
        return m22.getVipEnd().longValue();
    }

    public boolean w1(String str) {
        BookWrapperList bookWrapperList = new BookWrapperList();
        bookWrapperList.bookWrappers = new ArrayList(M1().T().p());
        bookWrapperList.archiveBooks = new ArrayList(M1().m0());
        try {
            g.E(K1() + str, new GsonBuilder().registerTypeAdapter(Book.class, new InterfaceAdapter()).create().toJson(bookWrapperList));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean w2() {
        return j.d(this, f13323i1, false);
    }

    public boolean x1() {
        return N0() || j.d(this, getString(R.string.show_image_pref_key), true);
    }

    public final void x2() {
        try {
            BuglyStrategy buglyStrategy = new BuglyStrategy();
            buglyStrategy.setAppChannel(b2().r());
            buglyStrategy.setAppVersion(b2().p0());
            Beta.initDelay = 1000L;
            Beta.autoDownloadOnWifi = true;
            Bugly.init(getApplicationContext(), e0.f33156j, b2().J0(), buglyStrategy);
            if (b2().F2()) {
                CrashReport.setUserId(b2().t2());
            }
            CrashReport.setDeviceId(this, b2().y());
        } catch (Exception unused) {
        }
    }

    public void y1() {
        boolean z10 = (getResources().getConfiguration().uiMode & 48) == 32;
        if (ConfigSingleton.D().A0() != z10) {
            ConfigSingleton.D().b1(z10);
        }
    }

    public void y2() {
        String r10 = r();
        this.K0 = "HuaWei".equalsIgnoreCase(r10) || "Honor".equalsIgnoreCase(r10);
    }

    public void z1(Activity activity) {
        if (o3(activity)) {
            return;
        }
        activity.startActivity(new Intent(activity, (Class<?>) EnterRestartActivity.class));
    }

    public void z2() {
        ke.d.h().j(this, e0.f33152h, e0.f33154i, e0.f33158k, e0.f33160l, e0.f33162m, new a());
    }
}
