package com.martian.mibook.application;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import cn.vlion.ad.inland.base.util.init.VlionPrivateController;
import cn.vlion.ad.inland.base.util.init.VlionSdkConfig;
import cn.vlion.ad.inland.core.init.VlionSDk;
import cn.vlion.ad.inland.core.interstitial.VlionInterstitialAd;
import cn.vlion.ad.inland.core.reward.VlionRewardedVideoAd;
import com.aggmoread.sdk.client.AMAdConfig;
import com.aggmoread.sdk.client.AMSdk;
import com.aggmoread.sdk.client.interstitial.AMInterstitialAd;
import com.aggmoread.sdk.client.reward.AMRewardAd;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.SdkConfig;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.ApiAd;
import com.martian.ads.ad.BaeAd;
import com.martian.ads.ad.DXAd;
import com.martian.ads.ad.DefaultAd;
import com.martian.ads.ad.GDTAd;
import com.martian.ads.ad.GroMoreAd;
import com.martian.ads.ad.KsAd;
import com.martian.ads.ad.MentaAd;
import com.martian.ads.ad.SigmobAd;
import com.martian.ads.ad.TTAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.apptask.data.ViewWrapper;
import com.martian.libmars.activity.MartianActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.account.MiCompoundUserManager;
import com.martian.mibook.application.a;
import com.martian.mibook.client.SplashSwitchClient;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.read.activity.ReadingNewActivity;
import com.martian.mibook.mvvm.utils.SensorHook;
import com.martian.rpauth.MartianRPUserManager;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l9.i0;
import l9.m0;
import l9.p0;
import l9.t0;
import ya.e0;
import ya.l1;

/* loaded from: classes3.dex */
public class a {
    public static final String A = "TestTTAd";
    public static final String B = "TestGDTAd";
    public static final String C = "TestBaeAd";
    public static final String D = "TestDxAd";
    public static final String E = "TestMiAd";
    public static final String F = "TestHwAd";
    public static final String G = "TestKsAd";
    public static final String H = "TestApiAd";
    public static final String I = "TestDefaultAd";
    public static final String J = "TestVivoAd";
    public static final String K = "TestOppoAd";
    public static final String L = "TestMentaAd";
    public static final String M = "TestSigmobAd";
    public static final String N = "pref_bad_article_books";
    public static final String O = "ADS_VIDEO_CLOSE_TIMES";

    /* renamed from: a */
    public final Application f13420a;

    /* renamed from: b */
    public AdConfig.AdInfo f13421b;

    /* renamed from: c */
    public Map<String, AppTask> f13422c;

    /* renamed from: d */
    public boolean f13423d;

    /* renamed from: e */
    public long f13424e;

    /* renamed from: f */
    public AppTask f13425f;

    /* renamed from: g */
    public d8.b f13426g;

    /* renamed from: h */
    public boolean f13427h;

    /* renamed from: i */
    public WeakReference<Activity> f13428i;

    /* renamed from: k */
    public AdConfig.AdInfo f13430k;

    /* renamed from: l */
    public boolean f13431l;

    /* renamed from: m */
    public boolean f13432m;

    /* renamed from: n */
    public boolean f13433n;

    /* renamed from: o */
    public boolean f13434o;

    /* renamed from: p */
    public boolean f13435p;

    /* renamed from: q */
    public boolean f13436q;

    /* renamed from: r */
    public boolean f13437r;

    /* renamed from: s */
    public String f13438s;

    /* renamed from: t */
    public boolean f13439t;

    /* renamed from: u */
    public boolean f13440u;

    /* renamed from: v */
    public boolean f13441v;

    /* renamed from: w */
    public boolean f13442w;

    /* renamed from: x */
    public boolean f13443x;

    /* renamed from: j */
    public final d8.b f13429j = new i();

    /* renamed from: y */
    public int f13444y = 0;

    /* renamed from: z */
    public long f13445z = -1;

    /* renamed from: com.martian.mibook.application.a$a */
    public class C0525a implements o {
        public C0525a() {
        }

        @Override // com.martian.mibook.application.a.o
        public void onFailed(String str) {
            a.this.f13440u = false;
        }

        @Override // com.martian.mibook.application.a.o
        public void onSuccess() {
        }
    }

    public class b implements o {
        public b() {
        }

        @Override // com.martian.mibook.application.a.o
        public void onFailed(String str) {
            a.this.f13441v = false;
        }

        @Override // com.martian.mibook.application.a.o
        public void onSuccess() {
        }
    }

    public class c extends VlionPrivateController {
        public c() {
        }

        @Override // cn.vlion.ad.inland.base.util.init.VlionPrivateController
        public String getOaid() {
            return ConfigSingleton.D().M();
        }

        @Override // cn.vlion.ad.inland.base.util.init.VlionPrivateController
        public boolean isCanReadAppList() {
            return true;
        }

        @Override // cn.vlion.ad.inland.base.util.init.VlionPrivateController
        public boolean isCanUseGaid() {
            return false;
        }

        @Override // cn.vlion.ad.inland.base.util.init.VlionPrivateController
        public boolean isCanUsePhoneState() {
            return ea.c.d(a.this.f13420a, com.kuaishou.weapon.p0.g.f11102c);
        }
    }

    public class d extends SplashSwitchClient {
        public d(Context context) {
            super(context);
        }
    }

    public class e extends d8.b {

        /* renamed from: a */
        public final /* synthetic */ d8.b f13450a;

        public e(d8.b bVar) {
            this.f13450a = bVar;
        }

        @Override // d8.b, d8.a
        public void a() {
            b8.e.A(null, "onFallbackFailed");
            d8.b bVar = this.f13450a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            d8.b bVar = this.f13450a;
            if (bVar != null) {
                bVar.i(adConfig, appTaskList);
            }
        }
    }

    public class f extends d8.b {

        /* renamed from: a */
        public boolean f13452a = false;

        /* renamed from: b */
        public boolean f13453b = false;

        /* renamed from: c */
        public final /* synthetic */ d8.b f13454c;

        public f(d8.b bVar) {
            this.f13454c = bVar;
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            if (this.f13452a) {
                return;
            }
            this.f13452a = true;
            MiConfigSingleton.b2().V1().l(EventManager.f13208k, adConfig.getAdNameInfo(), adConfig.getEcpm());
            a.this.y(adConfig);
            d8.b bVar = this.f13454c;
            if (bVar != null) {
                bVar.b(adConfig);
            }
        }

        @Override // d8.b, d8.a
        public void d(AdConfig adConfig) {
            b8.e.A(adConfig, "close");
            d8.b bVar = this.f13454c;
            if (bVar != null) {
                bVar.d(adConfig);
            }
        }

        @Override // d8.b, d8.a
        public void j(x8.c cVar) {
            b8.e.A(null, "onAdExposeFailed：" + cVar.c() + hf.e.f26694a + cVar.d());
            d8.b bVar = this.f13454c;
            if (bVar != null) {
                bVar.j(cVar);
            }
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            if (this.f13453b) {
                return;
            }
            this.f13453b = true;
            MiConfigSingleton.b2().V1().l(EventManager.f13209l, adConfig.getAdNameInfo(), adConfig.getEcpm());
            a.this.x(adConfig);
            d8.b bVar = this.f13454c;
            if (bVar != null) {
                bVar.l(adConfig);
            }
        }
    }

    public class g implements g8.a {
        public g() {
        }

        @Override // g8.a
        public void a(AppTask appTask) {
        }

        @Override // g8.a
        public void b(AppTask appTask) {
        }

        @Override // g8.a
        public void c(AppTask appTask) {
        }

        @Override // g8.a
        public void d(AppTask appTask) {
        }
    }

    public class h extends d8.b {

        /* renamed from: a */
        public boolean f13457a = false;

        /* renamed from: b */
        public boolean f13458b = false;

        /* renamed from: c */
        public final /* synthetic */ Activity f13459c;

        /* renamed from: d */
        public final /* synthetic */ d8.b f13460d;

        public h(Activity activity, d8.b bVar) {
            this.f13459c = activity;
            this.f13460d = bVar;
        }

        @Override // d8.b, d8.a
        public void a() {
            b8.e.A(null, "onFallbackFailed");
            d8.b bVar = this.f13460d;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            if (this.f13457a) {
                return;
            }
            this.f13457a = true;
            a.this.y(adConfig);
            SensorHook.INSTANCE.getInstance().enableSensor();
            d8.b bVar = this.f13460d;
            if (bVar != null) {
                bVar.b(adConfig);
            }
        }

        @Override // d8.b, d8.a
        public void d(AdConfig adConfig) {
            b8.e.A(adConfig, "close");
            d8.b bVar = this.f13460d;
            if (bVar != null) {
                bVar.d(adConfig);
            }
        }

        @Override // d8.b, d8.a
        public void g(AdConfig adConfig) {
            b8.e.A(adConfig, "onAdDismiss");
            d8.b bVar = this.f13460d;
            if (bVar != null) {
                bVar.g(adConfig);
            }
        }

        @Override // d8.b, d8.a
        public void h(AppTask appTask) {
            a.this.C(appTask);
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            a.this.S0(this.f13459c, appTaskList.getApps().get(0), this.f13460d, this);
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            if (this.f13458b) {
                return;
            }
            this.f13458b = true;
            a.this.x(adConfig);
            d8.b bVar = this.f13460d;
            if (bVar != null) {
                bVar.l(adConfig);
            }
        }
    }

    public class i extends d8.b {

        /* renamed from: a */
        public boolean f13462a = false;

        /* renamed from: b */
        public boolean f13463b = false;

        public i() {
        }

        @Override // d8.b, d8.a
        public void a() {
            b8.e.A(null, "onFallbackFailed");
            if (a.this.f13426g != null) {
                a.this.f13426g.a();
            }
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            if (this.f13462a) {
                return;
            }
            this.f13462a = true;
            a.this.y(adConfig);
            SensorHook.INSTANCE.getInstance().enableSensor();
            if (a.this.f13426g != null) {
                a.this.f13426g.b(adConfig);
            }
        }

        @Override // d8.b, d8.a
        public void d(AdConfig adConfig) {
            this.f13462a = false;
            this.f13463b = false;
            b8.e.A(adConfig, "close");
            if (a.this.f13426g != null) {
                a.this.f13426g.d(adConfig);
            }
        }

        @Override // d8.b, d8.a
        public void g(AdConfig adConfig) {
            this.f13462a = false;
            this.f13463b = false;
            b8.e.A(adConfig, "onAdDismiss");
            if (a.this.f13426g != null) {
                a.this.f13426g.g(adConfig);
            }
        }

        @Override // d8.b, d8.a
        public void h(AppTask appTask) {
            a.this.C(appTask);
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            AppTask appTask = appTaskList.getApps().get(0);
            if (a.this.f13427h) {
                a.this.f13425f = appTask;
                return;
            }
            Activity activity = (Activity) a.this.f13428i.get();
            if (activity != null) {
                a aVar = a.this;
                aVar.S0(activity, appTask, aVar.f13426g, this);
                if (a.this.f13426g != null) {
                    a.this.f13426g.i(adConfig, appTaskList);
                }
            }
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            if (this.f13463b) {
                return;
            }
            this.f13463b = true;
            a.this.x(adConfig);
            if (a.this.f13426g != null) {
                a.this.f13426g.l(adConfig);
            }
        }
    }

    public class j extends d8.b {

        /* renamed from: a */
        public boolean f13465a = false;

        /* renamed from: b */
        public boolean f13466b = false;

        /* renamed from: c */
        public final /* synthetic */ Activity f13467c;

        /* renamed from: d */
        public final /* synthetic */ boolean f13468d;

        /* renamed from: e */
        public final /* synthetic */ d8.b f13469e;

        public j(Activity activity, boolean z10, d8.b bVar) {
            this.f13467c = activity;
            this.f13468d = z10;
            this.f13469e = bVar;
        }

        @Override // d8.b, d8.a
        public void a() {
            if (this.f13467c.isFinishing()) {
                return;
            }
            if (this.f13468d) {
                a.this.T0(this.f13467c, false);
            }
            b8.e.A(null, "onFallbackFailed");
            this.f13469e.a();
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            if (this.f13465a) {
                return;
            }
            this.f13465a = true;
            a.this.y(adConfig);
            this.f13469e.b(adConfig);
        }

        @Override // d8.b, d8.a
        public void d(AdConfig adConfig) {
            b8.e.A(adConfig, "close");
            this.f13469e.d(adConfig);
        }

        @Override // d8.b, d8.a
        public void g(AdConfig adConfig) {
            b8.e.A(adConfig, "onAdDismiss");
            this.f13469e.g(adConfig);
        }

        @Override // d8.b, d8.a
        public void h(AppTask appTask) {
            a.this.C(appTask);
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            if (this.f13467c.isFinishing()) {
                return;
            }
            if (this.f13468d) {
                a.this.U0(this.f13467c, appTaskList.getApps().get(0), this.f13469e, this);
            } else {
                this.f13469e.i(adConfig, appTaskList);
            }
        }

        @Override // d8.b, d8.a
        public void k(AdConfig adConfig, boolean z10) {
            b8.e.A(null, "onRewardVerify:" + z10);
            this.f13469e.k(adConfig, z10);
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            if (this.f13466b) {
                return;
            }
            this.f13466b = true;
            a.this.x(adConfig);
            this.f13469e.l(adConfig);
        }
    }

    public class k implements TTAdSdk.Callback {
        public k() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i10, String str) {
            a.this.f13431l = false;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
        }
    }

    public class l implements BDAdConfig.BDAdInitListener {
        public l() {
        }

        @Override // com.baidu.mobads.sdk.api.BDAdConfig.BDAdInitListener
        public void fail() {
            a.this.f13432m = false;
        }

        @Override // com.baidu.mobads.sdk.api.BDAdConfig.BDAdInitListener
        public void success() {
        }
    }

    public class m implements KsInitCallback {
        public m() {
        }

        @Override // com.kwad.sdk.api.KsInitCallback
        public void onFail(int i10, String str) {
        }

        @Override // com.kwad.sdk.api.KsInitCallback
        public void onSuccess() {
            a.this.f13437r = true;
        }
    }

    public interface n {
        void a();
    }

    public interface o {
        void onFailed(String str);

        void onSuccess();
    }

    public static class p {

        /* renamed from: a */
        public int f13474a;

        /* renamed from: b */
        public int f13475b;

        /* renamed from: c */
        public int f13476c;

        /* renamed from: d */
        public final int f13477d;

        /* renamed from: e */
        public int f13478e;

        /* renamed from: f */
        public final int f13479f;

        /* JADX WARN: Multi-variable type inference failed */
        public p(Activity activity, boolean z10) {
            boolean O = ReadingInstance.z().O(activity);
            int l02 = activity instanceof gd.a ? ((gd.a) activity).l0() : 0;
            int i10 = O ? ConfigSingleton.i(50.0f) + l02 : 0;
            this.f13479f = i10;
            int i11 = z10 ? 0 : ConfigSingleton.i(28.0f);
            int i12 = activity.getResources().getDisplayMetrics().widthPixels;
            int i13 = activity.getResources().getDisplayMetrics().heightPixels;
            this.f13477d = ((i13 <= 0 ? i13 + l02 : i13) - i10) - i11;
            int i14 = i12 - ConfigSingleton.i(48.0f);
            j(O ? i14 : i14 / 2);
        }

        public int a() {
            return this.f13475b;
        }

        public int b(boolean z10) {
            return (z10 ? 0 : this.f13479f) + g();
        }

        public int c() {
            return this.f13476c;
        }

        public int d() {
            return this.f13474a;
        }

        public int e() {
            return this.f13477d - this.f13478e;
        }

        public int f() {
            return g() + this.f13478e;
        }

        public final int g() {
            int e10 = e();
            int i10 = this.f13475b;
            if (e10 > i10) {
                return (e10 - i10) / 2;
            }
            return 0;
        }

        public void h(int i10) {
            this.f13475b = i10;
        }

        public void i(int i10) {
            this.f13476c = i10;
        }

        public void j(int i10) {
            this.f13474a = i10;
        }

        public void k(int i10) {
            this.f13478e = i10;
        }
    }

    public a(Application application) {
        this.f13420a = application;
    }

    public static /* synthetic */ boolean A0(View view) {
        if (!ConfigSingleton.D().J0() || !MiConfigSingleton.b2().F2()) {
            return false;
        }
        MiUser p10 = MiConfigSingleton.b2().G1().p();
        p10.setUid(Long.valueOf(MartianRPUserManager.a()));
        MiConfigSingleton.b2().U2(p10);
        return false;
    }

    public static /* synthetic */ void B0(String str) {
        ConfigSingleton.D().a1(str);
    }

    public static /* synthetic */ void C0(String str) {
        ConfigSingleton.D().a1(str);
    }

    public static /* synthetic */ void E0(n nVar, MiUser miUser) {
        if (nVar != null) {
            nVar.a();
        }
    }

    public static void F(AppTask appTask) {
        if (appTask != null) {
            appTask.destroyNativeAd();
        }
    }

    public static void G(AppTaskList appTaskList) {
        if (appTaskList == null || appTaskList.getApps() == null || appTaskList.getApps().isEmpty()) {
            return;
        }
        Iterator<AppTask> it = appTaskList.getApps().iterator();
        while (it.hasNext()) {
            F(it.next());
        }
    }

    public static boolean z(AppTask appTask) {
        return appTask == null || appTask.exposed || System.currentTimeMillis() - appTask.createdOn >= 1800000;
    }

    public void A(Activity activity, AppTask appTask, ViewGroup viewGroup, View view, GroMoreAd.AdViewHolder adViewHolder, d8.b bVar) {
        Button button;
        ViewGroup viewGroup2;
        if (appTask == null || appTask.exposed) {
            return;
        }
        appTask.exposed = true;
        b8.e.s().j(appTask);
        f fVar = new f(bVar);
        ViewWrapper viewWrapper = appTask.customView;
        if (viewWrapper != null) {
            if (viewGroup == null || viewWrapper.getView() == null) {
                return;
            }
            viewWrapper.init();
            if (TTAd.isTTFlowTempAd(appTask)) {
                TTAd.bindFlowTempAd(activity, appTask, fVar);
            }
            if (viewWrapper.getView().getParent() != null && (viewGroup2 = (ViewGroup) viewWrapper.getView().getParent()) != null) {
                viewGroup2.removeAllViews();
            }
            if (viewGroup.getChildCount() <= 0) {
                viewGroup.addView(viewWrapper.getView());
                return;
            } else {
                if (viewGroup.getChildAt(0) != viewWrapper.getView()) {
                    viewGroup.removeAllViews();
                    viewGroup.addView(viewWrapper.getView());
                    return;
                }
                return;
            }
        }
        boolean C2 = MiConfigSingleton.b2().C2();
        ArrayList arrayList = new ArrayList();
        if (adViewHolder != null) {
            Button button2 = adViewHolder.mCreativeButton;
            if (button2 != null) {
                arrayList.add(button2);
            }
            View view2 = adViewHolder.mCreativeButtonView;
            if (view2 != null) {
                arrayList.add(view2);
            }
        }
        if (TTAd.isTTFlowAd(appTask)) {
            TTAd.bindFlowAd(activity, appTask, viewGroup, view, adViewHolder, fVar, C2);
            return;
        }
        if (TTAd.isTTBannerAd(appTask)) {
            TTAd.bindBannerAd(activity, appTask, viewGroup, arrayList, fVar);
            return;
        }
        if (BaeAd.isBaeFlowAd(appTask)) {
            BaeAd.bindFlowAd(activity, appTask, viewGroup, view, adViewHolder, C2, fVar);
            return;
        }
        if (GDTAd.isGdtFlowAd(appTask)) {
            GDTAd.bindFlowAd(activity, appTask, viewGroup, view, adViewHolder, C2, fVar);
            return;
        }
        if (DXAd.isDxFlowAd(appTask)) {
            DXAd.bindFlowAd(activity, appTask, viewGroup, view, adViewHolder, fVar);
            return;
        }
        if (KsAd.isKsFlowAd(appTask)) {
            KsAd.bindFlowAd(activity, appTask, viewGroup, view, adViewHolder, C2, fVar);
            return;
        }
        if (KsAd.isKsDrawAd(appTask)) {
            KsAd.bindDrawAd(activity, appTask, adViewHolder, fVar);
            return;
        }
        if (MentaAd.isMentaFlowAd(appTask)) {
            MentaAd.bindFlowAd(activity, appTask, viewGroup, view, adViewHolder, fVar);
            return;
        }
        if (SigmobAd.isSigmobFlowAd(appTask)) {
            SigmobAd.bindFlowAd(appTask, viewGroup, view, adViewHolder, fVar);
            return;
        }
        if (MiBookManager.V1(appTask)) {
            appTask.rendered = true;
            TYBookItem tYBookItem = (TYBookItem) appTask.origin;
            MiConfigSingleton.b2().V1().g(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
            ac.a.s(activity, appTask.pid + "-曝光");
            return;
        }
        if (b8.h.l(appTask)) {
            b8.h.e(activity, appTask, viewGroup, view, adViewHolder, fVar);
            return;
        }
        if (b8.h.k(appTask)) {
            b8.h.d(viewGroup, appTask, fVar);
            return;
        }
        if (b8.h.g(appTask)) {
            b8.h.c(activity, appTask, viewGroup, view, adViewHolder);
            return;
        }
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: ya.k

                /* renamed from: c */
                public final /* synthetic */ Activity f33287c;

                /* renamed from: d */
                public final /* synthetic */ AppTask f33288d;

                public /* synthetic */ k(Activity activity2, AppTask appTask2) {
                    activity = activity2;
                    appTask = appTask2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    com.martian.mibook.application.a.this.w0(activity, appTask, view3);
                }
            });
        }
        if (adViewHolder != null && (button = adViewHolder.mCreativeButton) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: ya.l

                /* renamed from: c */
                public final /* synthetic */ Activity f33295c;

                /* renamed from: d */
                public final /* synthetic */ AppTask f33296d;

                public /* synthetic */ l(Activity activity2, AppTask appTask2) {
                    activity = activity2;
                    appTask = appTask2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    com.martian.mibook.application.a.this.x0(activity, appTask, view3);
                }
            });
            View view3 = adViewHolder.mCreativeButtonView;
            if (view3 != null) {
                view3.setOnClickListener(new View.OnClickListener() { // from class: ya.m

                    /* renamed from: c */
                    public final /* synthetic */ Activity f33304c;

                    /* renamed from: d */
                    public final /* synthetic */ AppTask f33305d;

                    public /* synthetic */ m(Activity activity2, AppTask appTask2) {
                        activity = activity2;
                        appTask = appTask2;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        com.martian.mibook.application.a.this.y0(activity, appTask, view4);
                    }
                });
            }
        }
        if (ApiAd.isApiFlowAd(appTask2)) {
            fVar.b(AdConfig.toAdConfig(appTask2));
            i8.h.b(appTask2.exposeReportUrls);
        }
    }

    public void B(Activity activity, View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: ya.c

            /* renamed from: c */
            public final /* synthetic */ Activity f33128c;

            public /* synthetic */ c(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.martian.mibook.application.a.this.z0(activity, view2);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: ya.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean A0;
                A0 = com.martian.mibook.application.a.A0(view2);
                return A0;
            }
        });
    }

    public final void C(AppTask appTask) {
        if (this.f13422c == null) {
            this.f13422c = new HashMap();
        }
        if (z(this.f13422c.get(appTask.f12000id))) {
            this.f13422c.put(appTask.f12000id, appTask);
        }
    }

    public void D(Activity activity, n nVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        String str = ConfigSingleton.D().J0() ? "TEST" : ConfigSingleton.D().z0() ? "BETA" : ConfigSingleton.D().w0() ? "AD_TEST" : "RELEASE";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("环境:");
        sb2.append(str);
        sb2.append(" 渠道：");
        sb2.append(ConfigSingleton.D().r());
        sb2.append(MiConfigSingleton.b2().C2() ? " Clean" : "");
        builder.setTitle(sb2.toString()).setCancelable(true).setItems(new String[]{"TEST", "BETA", "RELEASE", "AD_TEST", AdConfig.UnionType.CSJ, AdConfig.UnionType.GDT, "BAE", "KS", AdConfig.UnionType.DX, AdConfig.UnionType.MI, AdConfig.UnionType.HW, AdConfig.UnionType.API, AdConfig.UnionType.BOOK, AdConfig.UnionType.VIVO, "OPPO", "瑞狮", AdConfig.UnionType.SIGMOB, "取消"}, new DialogInterface.OnClickListener() { // from class: ya.h

            /* renamed from: c */
            public final /* synthetic */ Activity f33222c;

            /* renamed from: d */
            public final /* synthetic */ a.n f33223d;

            public /* synthetic */ h(Activity activity2, a.n nVar2) {
                activity = activity2;
                nVar = nVar2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                com.martian.mibook.application.a.this.D0(activity, nVar, dialogInterface, i10);
            }
        }).show();
    }

    public final /* synthetic */ void D0(Activity activity, n nVar, DialogInterface dialogInterface, int i10) {
        boolean J0 = ConfigSingleton.D().J0();
        if (i10 == 0) {
            ConfigSingleton.D().c1(2);
            M0();
            t0.b(activity, "切换到test模式");
            if (J0) {
                return;
            }
            J0(activity, nVar);
            return;
        }
        if (i10 == 1) {
            String J2 = ConfigSingleton.D().J();
            if (!J2.equalsIgnoreCase(ConfigSingleton.D().r())) {
                i0.z0(activity, this.f13420a.getString(R.string.confirm_message), "是否重置渠道号？", new i0.l() { // from class: ya.f

                    /* renamed from: a */
                    public final /* synthetic */ String f33207a;

                    public /* synthetic */ f(String J22) {
                        J2 = J22;
                    }

                    @Override // l9.i0.l
                    public final void a() {
                        com.martian.mibook.application.a.B0(J2);
                    }
                });
            }
            ConfigSingleton.D().c1(1);
            M0();
            t0.b(activity, "切换到beta模式");
            if (J0) {
                J0(activity, nVar);
                return;
            }
            return;
        }
        if (i10 == 2) {
            String J3 = ConfigSingleton.D().J();
            if (!J3.equalsIgnoreCase(ConfigSingleton.D().r())) {
                i0.z0(activity, this.f13420a.getString(R.string.confirm_message), "是否重置渠道号？", new i0.l() { // from class: ya.g

                    /* renamed from: a */
                    public final /* synthetic */ String f33211a;

                    public /* synthetic */ g(String J32) {
                        J3 = J32;
                    }

                    @Override // l9.i0.l
                    public final void a() {
                        com.martian.mibook.application.a.C0(J3);
                    }
                });
            }
            ConfigSingleton.D().c1(0);
            M0();
            t0.b(activity, "切换到release模式");
            if (J0) {
                J0(activity, nVar);
                return;
            }
            return;
        }
        if (i10 == 3) {
            ConfigSingleton.D().c1(3);
            M0();
            t0.b(activity, "切换到ad test模式");
            return;
        }
        if (i10 == 4) {
            ConfigSingleton.D().a1(A);
            t0.b(activity, "切换到CSJ模式");
            return;
        }
        if (i10 == 5) {
            ConfigSingleton.D().a1(B);
            t0.b(activity, "切换到GDT模式");
            return;
        }
        if (i10 == 6) {
            ConfigSingleton.D().a1(C);
            t0.b(activity, "切换到BAE模式");
            return;
        }
        if (i10 == 7) {
            ConfigSingleton.D().a1(G);
            t0.b(activity, "切换到KS模式");
            return;
        }
        if (i10 == 8) {
            ConfigSingleton.D().a1(D);
            t0.b(activity, "切换到DX模式");
            return;
        }
        if (i10 == 9) {
            ConfigSingleton.D().a1(E);
            t0.b(activity, "切换到MI模式");
            return;
        }
        if (i10 == 10) {
            ConfigSingleton.D().a1(F);
            t0.b(activity, "切换到Hw模式");
            return;
        }
        if (i10 == 11) {
            ConfigSingleton.D().a1(H);
            t0.b(activity, "切换到API模式");
            return;
        }
        if (i10 == 12) {
            ConfigSingleton.D().a1(I);
            t0.b(activity, "切换到Book模式");
            return;
        }
        if (i10 == 13) {
            ConfigSingleton.D().a1(J);
            t0.b(activity, "切换到Vivo模式");
            return;
        }
        if (i10 == 14) {
            ConfigSingleton.D().a1(K);
            t0.b(activity, "切换到Oppo模式");
        } else if (i10 == 15) {
            ConfigSingleton.D().a1(L);
            t0.b(activity, "切换到瑞狮模式");
        } else if (i10 == 16) {
            ConfigSingleton.D().a1(M);
            t0.b(activity, "切换到SIGMOB模式");
        }
    }

    public void E(Activity activity, int i10, boolean z10, d8.b bVar) {
        if (!z10 && U()) {
            this.f13427h = false;
            this.f13426g = bVar;
            this.f13428i = new WeakReference<>(activity);
            S0(activity, this.f13425f, bVar, bVar);
            if (bVar != null) {
                bVar.i(null, new AppTaskList().addAppTask(this.f13425f));
                return;
            }
            return;
        }
        if (System.currentTimeMillis() - this.f13424e < (ConfigSingleton.D().B0() ? 10000 : 180000)) {
            if (bVar != null) {
                bVar.a();
                return;
            }
            return;
        }
        this.f13427h = z10;
        if (!z10) {
            this.f13426g = bVar;
            this.f13428i = new WeakReference<>(activity);
        }
        this.f13424e = System.currentTimeMillis();
        xa.p pVar = new xa.p(activity, e0.V, this.f13422c, i10);
        pVar.a1(this.f13429j);
        pVar.F0();
    }

    public final /* synthetic */ void F0(AppTask appTask, Activity activity, d8.b bVar, d8.b bVar2) {
        if (appTask == null || m0.c(activity)) {
            if (bVar != null) {
                bVar.a();
                return;
            }
            return;
        }
        b8.e.s().j(appTask);
        appTask.exposed = true;
        Object obj = appTask.origin;
        if (obj instanceof ExpressInterstitialAd) {
            P0(true);
            BaeAd.showInterstitialAd(activity, appTask);
        } else if (obj instanceof UnifiedInterstitialAD) {
            GDTAd.showInterstitialAd(activity, (UnifiedInterstitialAD) obj, appTask.isBidding());
        } else if (obj instanceof AMInterstitialAd) {
            DXAd.showInterstitialAd(activity, appTask, bVar2);
        } else if (obj instanceof KsInterstitialAd) {
            KsAd.showInterstitialAd(activity, appTask);
        } else if (obj instanceof TTFullScreenVideoAd) {
            P0(true);
            TTAd.showFullScreenVideoAd(activity, (TTFullScreenVideoAd) appTask.origin);
        } else if (obj instanceof VlionInterstitialAd) {
            P0(true);
            MentaAd.showInterstitialAd(activity, appTask);
        } else if (SigmobAd.isSigmobInterstitialAd(appTask)) {
            SigmobAd.showInterstitialAd(appTask, bVar2);
        } else if (b8.h.q(appTask)) {
            b8.h.K(activity, appTask);
        } else if (b8.h.m(appTask)) {
            b8.h.H(appTask);
        } else if (!b8.h.h(appTask)) {
            return;
        } else {
            b8.h.E(activity, appTask, bVar2);
        }
        if (MiConfigSingleton.b2().c2().getEnableBaeAdInfo()) {
            if (this.f13421b == null) {
                this.f13421b = new AdConfig.AdInfo();
            }
            this.f13421b.setSource(appTask.source);
            this.f13421b.setEcpm(appTask.getEcpm());
        }
    }

    public final /* synthetic */ void G0(Activity activity, d8.b bVar, AppTask appTask, d8.b bVar2) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        T0(activity, false);
        if (!m0.B(activity)) {
            if (bVar != null) {
                bVar.k(null, false);
                return;
            }
            return;
        }
        appTask.exposed = true;
        b8.e.s().j(appTask);
        Object obj = appTask.origin;
        if (obj instanceof TTRewardVideoAd) {
            TTAd.showVideoAd(activity, appTask, bVar2);
        } else if (obj instanceof ExpressInterstitialAd) {
            P0(true);
            BaeAd.showInterstitialAd(activity, appTask);
        } else if (obj instanceof RewardVideoAd) {
            BaeAd.showVideoAd(appTask);
        } else if (obj instanceof RewardVideoAD) {
            GDTAd.showVideoAd((RewardVideoAD) obj, appTask.isBidding());
        } else if (obj instanceof UnifiedInterstitialAD) {
            GDTAd.showInterstitialAd(activity, (UnifiedInterstitialAD) obj, appTask.isBidding());
        } else if (obj instanceof AMRewardAd) {
            DXAd.showVideoAd(activity, appTask, bVar2);
        } else if (obj instanceof AMInterstitialAd) {
            DXAd.showInterstitialAd(activity, appTask, bVar2);
        } else if (obj instanceof KsRewardVideoAd) {
            KsAd.showVideoAd(activity, (KsRewardVideoAd) obj, appTask.isBidding());
        } else if (obj instanceof KsInterstitialAd) {
            KsAd.showInterstitialAd(activity, appTask);
        } else if (obj instanceof TTFullScreenVideoAd) {
            P0(true);
            TTAd.showFullScreenVideoAd(activity, (TTFullScreenVideoAd) appTask.origin);
        } else if (obj instanceof VlionRewardedVideoAd) {
            MentaAd.showVideoAd(activity, appTask);
        } else if (SigmobAd.isSigmobInterstitialAd(appTask)) {
            SigmobAd.showInterstitialAd(appTask, bVar2);
        } else if (SigmobAd.isSigmobVideoAd(appTask)) {
            SigmobAd.showVideoAd(appTask, bVar2);
        } else if (appTask.origin instanceof VlionInterstitialAd) {
            P0(true);
            MentaAd.showInterstitialAd(activity, appTask);
        } else if (b8.h.o(appTask)) {
            b8.h.J(appTask);
        } else {
            if (!b8.h.i(appTask)) {
                bVar2.k(null, false);
                return;
            }
            b8.h.F(activity, appTask, bVar2);
        }
        if (MiConfigSingleton.b2().c2().getEnableBaeAdInfo()) {
            if (this.f13430k == null) {
                this.f13430k = new AdConfig.AdInfo();
            }
            this.f13430k.setSource(appTask.source);
            this.f13430k.setEcpm(appTask.getEcpm());
        }
    }

    public void H() {
        Map<String, AppTask> map = this.f13422c;
        if (map == null || map.isEmpty()) {
            return;
        }
        Iterator<AppTask> it = this.f13422c.values().iterator();
        while (it.hasNext()) {
            it.next().origin = null;
        }
        this.f13422c.clear();
    }

    public void H0(Activity activity, String str, d8.b bVar) {
        xa.p pVar = new xa.p(activity, str, this.f13422c, this.f13421b);
        pVar.a1(new h(activity, bVar));
        pVar.F0();
    }

    public boolean I() {
        return !MiConfigSingleton.b2().C2();
    }

    public void I0(Activity activity, boolean z10, @NonNull d8.b bVar) {
        if (activity == null || activity.isFinishing() || MiConfigSingleton.b2().C2()) {
            return;
        }
        if (z10) {
            T0(activity, true);
        }
        xa.p pVar = new xa.p(activity, e0.W, this.f13422c, this.f13430k);
        pVar.a1(new j(activity, z10, bVar));
        pVar.F0();
    }

    public boolean J() {
        return ke.e.c() && !MiConfigSingleton.b2().C2();
    }

    public final void J0(Activity activity, n nVar) {
        MiConfigSingleton.b2().P2(activity, new MiCompoundUserManager.g() { // from class: ya.d
            public /* synthetic */ d() {
            }

            @Override // com.martian.mibook.account.MiCompoundUserManager.g
            public final void a(MiUser miUser) {
                com.martian.mibook.application.a.E0(a.n.this, miUser);
            }
        });
    }

    public boolean K() {
        return !MiConfigSingleton.b2().C2();
    }

    public final void K0(Activity activity, AppTask appTask) {
        if (MiBookManager.V1(appTask)) {
            TYBookItem tYBookItem = (TYBookItem) appTask.origin;
            ac.a.s(activity, "信息流-书籍详情");
            je.i.H(activity, tYBookItem);
        } else if (DefaultAd.isDefaultAd(appTask)) {
            je.i.e0(activity, appTask.pid, "", "");
        } else {
            je.i.x(activity, appTask, new g());
        }
    }

    public boolean L() {
        return !MiConfigSingleton.b2().C2();
    }

    public void L0() {
        c0();
        e0();
    }

    public boolean M() {
        return ke.e.e() && !MiConfigSingleton.b2().C2();
    }

    public void M0() {
        uc.f.f().k();
    }

    public boolean N() {
        return !MiConfigSingleton.b2().C2();
    }

    public void N0(Context context, int i10) {
        ba.j.m(context, O, i10);
    }

    public boolean O() {
        return !MiConfigSingleton.b2().C2();
    }

    public void O0(Context context, String str) {
        if (ba.l.q(str)) {
            return;
        }
        ba.j.o(context, N, str);
    }

    public boolean P() {
        return !MiConfigSingleton.b2().C2();
    }

    public void P0(boolean z10) {
        this.f13423d = z10;
    }

    public int Q(Context context) {
        return ba.j.f(context, O, 0);
    }

    public void Q0(Activity activity, ImageView imageView, ImageView imageView2, AppTask appTask) {
        R0(activity, imageView, imageView2, appTask, 4);
    }

    public String R(Context context) {
        return ba.j.j(context, N);
    }

    public void R0(Activity activity, ImageView imageView, ImageView imageView2, AppTask appTask, int i10) {
        if (DefaultAd.isDefaultAd(appTask)) {
            if (imageView != null) {
                imageView.setImageResource(R.drawable.bg_vip_ad);
            }
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.icon_vip_ad);
                return;
            }
            return;
        }
        if (imageView != null) {
            m0.l(activity, appTask.getPosterUrl(), imageView, R.drawable.bg_ad_placeholder);
        }
        if (imageView2 != null) {
            if (TextUtils.isEmpty(appTask.getIconUrl())) {
                imageView2.setVisibility(8);
            } else {
                m0.d(activity, appTask.getIconUrl(), imageView2, i10);
            }
        }
    }

    public AppTask S(String str) {
        AppTask appTask = new AppTask();
        appTask.title = "开通" + e0.f33138a + "会员";
        appTask.desc = "成为会员，尊享免广告听读书、离线阅读、尊贵标识等八大特权";
        appTask.source = AdConfig.UnionType.DEFAULT;
        appTask.pid = str;
        appTask.buttonText = "优惠开通";
        appTask.setPicWidth(DownloadErrorCode.ERROR_FILE_NAME_EMPTY);
        appTask.setPicHeight(579);
        if (MiConfigSingleton.b2().N2()) {
            appTask.iconUrl = MiConfigSingleton.b2().G1().p().getHeader();
        }
        return appTask;
    }

    public void S0(Activity activity, AppTask appTask, d8.b bVar, d8.b bVar2) {
        if (MiConfigSingleton.b2().K2()) {
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: ya.i

            /* renamed from: c */
            public final /* synthetic */ AppTask f33231c;

            /* renamed from: d */
            public final /* synthetic */ Activity f33232d;

            /* renamed from: e */
            public final /* synthetic */ d8.b f33233e;

            /* renamed from: f */
            public final /* synthetic */ d8.b f33234f;

            public /* synthetic */ i(AppTask appTask2, Activity activity2, d8.b bVar3, d8.b bVar22) {
                appTask = appTask2;
                activity = activity2;
                bVar = bVar3;
                bVar2 = bVar22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.martian.mibook.application.a.this.F0(appTask, activity, bVar, bVar2);
            }
        }, 200L);
    }

    public void T(Activity activity, String str, d8.b bVar) {
        xa.p pVar = new xa.p(activity, str, (Map<String, AppTask>) null, (AdConfig.AdInfo) null);
        pVar.a1(new e(bVar));
        pVar.F0();
    }

    public final void T0(Activity activity, boolean z10) {
        if (activity instanceof MartianActivity) {
            ((MartianActivity) activity).y(z10, activity.getString(R.string.reward_video_loading));
        } else if (activity instanceof ReadingNewActivity) {
            ((ReadingNewActivity) activity).y(z10, activity.getString(R.string.reward_video_loading));
        }
    }

    public boolean U() {
        return !z(this.f13425f);
    }

    public void U0(Activity activity, AppTask appTask, d8.b bVar, d8.b bVar2) {
        new Handler().postDelayed(new Runnable() { // from class: ya.j

            /* renamed from: c */
            public final /* synthetic */ Activity f33252c;

            /* renamed from: d */
            public final /* synthetic */ d8.b f33253d;

            /* renamed from: e */
            public final /* synthetic */ AppTask f33254e;

            /* renamed from: f */
            public final /* synthetic */ d8.b f33255f;

            public /* synthetic */ j(Activity activity2, d8.b bVar3, AppTask appTask2, d8.b bVar22) {
                activity = activity2;
                bVar = bVar3;
                appTask = appTask2;
                bVar2 = bVar22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.martian.mibook.application.a.this.G0(activity, bVar, appTask, bVar2);
            }
        }, 200L);
    }

    public void V() {
        if (this.f13432m) {
            return;
        }
        this.f13432m = true;
        MobadsPermissionSettings.setPermissionReadDeviceID(false);
        MobadsPermissionSettings.setPermissionStorage(ea.c.f(this.f13420a));
        MobadsPermissionSettings.setPermissionAppList(true ^ MiConfigSingleton.b2().C2());
        new BDAdConfig.Builder().setAppName(e0.f33138a).setAppsid(MiConfigSingleton.b2().f2().g(AdConfig.UnionType.BQT, e0.f33168p)).setWXAppid(e0.f33146e).setBDAdInitListener(new l()).build(this.f13420a).init();
    }

    public final void V0(Activity activity) {
        if (this.f13444y <= 0 || System.currentTimeMillis() - this.f13445z <= y.f.f18076n) {
            this.f13444y++;
        } else {
            this.f13444y = 1;
        }
        this.f13445z = System.currentTimeMillis();
        int i10 = this.f13444y;
        if (i10 == 8) {
            t0.b(activity, "再点两次");
        } else if (i10 == 10) {
            this.f13444y = 0;
            D(activity, null);
        }
    }

    public void W() {
        if (this.f13434o || !I()) {
            return;
        }
        try {
            this.f13434o = true;
            AMSdk.init(this.f13420a, new AMAdConfig.Builder().setAppName(this.f13420a.getPackageName()).build());
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
    }

    public void W0(Context context, List<BookWrapper> list) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (BookWrapper bookWrapper : list) {
            if (bookWrapper != null && bookWrapper.item != null && !bookWrapper.notBookItem()) {
                if (i10 > 0) {
                    sb2.append("/");
                }
                sb2.append(bookWrapper.getBookName());
                i10++;
                if (i10 >= 5) {
                    break;
                }
            }
        }
        O0(context, sb2.toString());
    }

    public void X() {
        if (this.f13433n) {
            return;
        }
        this.f13433n = true;
        boolean C2 = MiConfigSingleton.b2().C2();
        HashMap hashMap = new HashMap();
        hashMap.put("android_id", Boolean.valueOf(!C2));
        hashMap.put("mac_address", Boolean.valueOf(!C2));
        GlobalSetting.setAgreeReadPrivacyInfo(hashMap);
        GlobalSetting.setEnableCollectAppInstallStatus(true ^ C2);
        GDTAdSdk.init(this.f13420a, MiConfigSingleton.b2().f2().g(AdConfig.UnionType.GDT, e0.f33170q));
    }

    public void Y() {
        if (this.f13439t || !J()) {
            return;
        }
        try {
            this.f13439t = true;
            Class<?> cls = Class.forName("com.huawei.hms.ads.HwAds");
            cls.getDeclaredMethod(PointCategory.INIT, Context.class).invoke(cls, this.f13420a);
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
    }

    public boolean Z() {
        if (K()) {
            try {
                if (TextUtils.isEmpty(this.f13438s)) {
                    this.f13438s = MiConfigSingleton.b2().f2().g("KS", e0.f33172r);
                }
                if (this.f13436q && !this.f13438s.equalsIgnoreCase(KsAdSDK.getAppId())) {
                    this.f13436q = false;
                    this.f13437r = false;
                }
                if (!this.f13436q) {
                    this.f13436q = true;
                    KsAdSDK.init(this.f13420a, new SdkConfig.Builder().appId(this.f13438s).appName(e0.f33138a).showNotification(true).debug(ConfigSingleton.D().B0()).setStartCallback(new m()).build());
                    KsAdSDK.start();
                }
            } catch (Exception e10) {
                p0.b(e10.getMessage());
            }
        }
        return this.f13437r;
    }

    public void a0() {
        if (this.f13442w || !L()) {
            return;
        }
        try {
            this.f13442w = true;
            VlionSdkConfig build = new VlionSdkConfig.Builder().setAppId(e0.f33178u).setAppKey(e0.f33180v).setEnableLog(ConfigSingleton.D().B0()).setPrivateController(new c()).build();
            VlionSDk.setPersonalizedAdState(true);
            VlionSDk.init(this.f13420a, build);
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
    }

    public void b0() {
        if (this.f13435p || !M()) {
            return;
        }
        try {
            this.f13435p = true;
            Class<?> cls = Class.forName("com.miui.zeus.mimo.sdk.MimoSdk");
            cls.getDeclaredMethod(PointCategory.INIT, Context.class).invoke(cls, this.f13420a);
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
    }

    public void c0() {
        try {
            if (ke.e.e() && !MiConfigSingleton.b2().K2()) {
                Uri parse = Uri.parse("content://com.miui.systemAdSolution.adSwitch/adPrivacySwitch");
                ContentValues contentValues = new ContentValues();
                contentValues.put("adPackage", this.f13420a.getPackageName());
                contentValues.put("adPrivacyStatus", Boolean.valueOf(!MiConfigSingleton.b2().C2()));
                ContentProviderClient acquireContentProviderClient = this.f13420a.getContentResolver().acquireContentProviderClient(parse);
                if (acquireContentProviderClient == null) {
                    return;
                }
                acquireContentProviderClient.update(parse, contentValues, null, null);
                acquireContentProviderClient.release();
            }
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
    }

    public void d0() {
        if (this.f13441v || !N()) {
            return;
        }
        this.f13441v = true;
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("initialOppoAdSdk", Context.class, o.class).invoke(cls, this.f13420a, new b());
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
    }

    public void e0() {
        if (ke.e.g() && SplashSwitchClient.d(this.f13420a)) {
            new d(this.f13420a).bindService((MiConfigSingleton.b2().C2() || MiConfigSingleton.b2().K2()) ? false : true);
        }
    }

    public void f0() {
        if (this.f13443x || !O()) {
            return;
        }
        try {
            this.f13443x = true;
            WindAds.sharedAds().startWithOptions(this.f13420a, new WindAdOptions(e0.f33182w, e0.f33184x));
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
    }

    public void g0() {
        if (this.f13431l) {
            return;
        }
        this.f13431l = true;
        try {
            l1.e(this.f13420a, new k());
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
    }

    public void h0() {
        if (this.f13440u || !P()) {
            return;
        }
        this.f13440u = true;
        try {
            Class<?> cls = Class.forName("ad.VivoAd");
            cls.getDeclaredMethod("initialVivoAdSdk", Application.class, o.class).invoke(cls, this.f13420a, new C0525a());
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
    }

    public boolean i0() {
        return this.f13423d;
    }

    public boolean j0() {
        return !ba.l.q(ConfigSingleton.D().r()) && ConfigSingleton.D().r().startsWith("Test");
    }

    public boolean k0() {
        return !H.equalsIgnoreCase(ConfigSingleton.D().r());
    }

    public boolean l0() {
        return !C.equalsIgnoreCase(ConfigSingleton.D().r());
    }

    public boolean m0() {
        return (I() && D.equalsIgnoreCase(ConfigSingleton.D().r())) ? false : true;
    }

    public boolean n0() {
        return !B.equalsIgnoreCase(ConfigSingleton.D().r());
    }

    public boolean o0() {
        return (J() && F.equalsIgnoreCase(ConfigSingleton.D().r())) ? false : true;
    }

    public boolean p0() {
        return (K() && G.equalsIgnoreCase(ConfigSingleton.D().r())) ? false : true;
    }

    public boolean q0() {
        return (L() && L.equalsIgnoreCase(ConfigSingleton.D().r())) ? false : true;
    }

    public boolean r0() {
        return (M() && E.equalsIgnoreCase(ConfigSingleton.D().r())) ? false : true;
    }

    public boolean s0() {
        return (N() && K.equalsIgnoreCase(ConfigSingleton.D().r())) ? false : true;
    }

    public boolean t0() {
        return !M.equalsIgnoreCase(ConfigSingleton.D().r());
    }

    public boolean u0() {
        return !A.equalsIgnoreCase(ConfigSingleton.D().r());
    }

    public boolean v0() {
        return (P() && J.equalsIgnoreCase(ConfigSingleton.D().r())) ? false : true;
    }

    public final /* synthetic */ void w0(Activity activity, AppTask appTask, View view) {
        K0(activity, appTask);
    }

    public void x(AdConfig adConfig) {
        b8.e.s().i(adConfig);
        SensorHook.INSTANCE.getInstance().disableSensor();
    }

    public final /* synthetic */ void x0(Activity activity, AppTask appTask, View view) {
        K0(activity, appTask);
    }

    public void y(AdConfig adConfig) {
        b8.e.s().n(adConfig);
    }

    public final /* synthetic */ void y0(Activity activity, AppTask appTask, View view) {
        K0(activity, appTask);
    }

    public final /* synthetic */ void z0(Activity activity, View view) {
        V0(activity);
    }
}
