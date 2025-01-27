package com.martian.mibook.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import ba.l;
import ba.m;
import com.maritan.libads.R;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.GroMoreAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.WebViewActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.MTWebView;
import com.martian.libsupport.data.NightModeChangeParams;
import com.martian.libxianplay.view.DownLoadReceiver;
import com.martian.mibook.activity.RechargeOrderDetailActivity;
import com.martian.mibook.activity.ShareImageUrlActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.c;
import com.martian.mibook.data.ShareInfo;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.activity.MiWebViewBaseActivity;
import com.martian.mibook.lib.account.request.auth.CreatAliPrepayParams;
import com.martian.mibook.lib.account.request.auth.CreateWxPrepayParams;
import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.IntervalBonus;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.mibook.lib.account.response.WebRechargeParams;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.rpauth.response.MartianRPAccount;
import com.tencent.mm.opensdk.modelpay.PayReq;
import e8.b;
import java.util.Random;
import je.i;
import kotlin.Unit;
import l9.i0;
import l9.m0;
import l9.t0;
import lb.c;
import ya.e0;
import ya.s0;
import z7.b;

/* loaded from: classes3.dex */
public class MiWebViewActivity extends MiWebViewBaseActivity {

    /* renamed from: d0 */
    public DownLoadReceiver f13156d0;

    /* renamed from: e0 */
    public Handler f13157e0;

    /* renamed from: f0 */
    public boolean f13158f0 = false;

    /* renamed from: g0 */
    public final Runnable f13159g0 = new Runnable() { // from class: ta.k
        public /* synthetic */ k() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MiWebViewActivity.this.u5();
        }
    };

    /* renamed from: h0 */
    public final String f13160h0 = ConfigSingleton.D().s("充值成功");

    /* renamed from: i0 */
    public final String f13161i0 = ConfigSingleton.D().s("充值取消了~~>_<~~");

    /* renamed from: j0 */
    public final String f13162j0 = ConfigSingleton.D().s("哎妈呀, 充值出错了 >_<¦¦¦, 客官再试一次呗~");

    /* renamed from: k0 */
    public final String f13163k0 = ConfigSingleton.D().s("充值处理中");

    public class a extends d8.b {

        /* renamed from: com.martian.mibook.activity.base.MiWebViewActivity$a$a */
        public class C0523a extends d8.b {
            public C0523a() {
            }
        }

        public a() {
        }

        @Override // d8.b, d8.a
        public void a() {
            if (m0.c(MiWebViewActivity.this)) {
                return;
            }
            MiWebViewActivity.this.S.setVisibility(8);
            MiWebViewActivity.this.b5();
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            if (m0.c(MiWebViewActivity.this) || appTaskList == null || appTaskList.getApps() == null || appTaskList.getApps().size() <= 0) {
                return;
            }
            AppTask appTask = appTaskList.getApps().get(0);
            MiWebViewActivity.this.S.removeAllViews();
            View inflate = MiWebViewActivity.this.getLayoutInflater().inflate(R.layout.native_banner_ad, (ViewGroup) null);
            GroMoreAd.AdViewHolder adViewHolder = new GroMoreAd.AdViewHolder();
            adViewHolder.mTitle = (TextView) inflate.findViewById(com.martian.mibook.R.id.tv_native_ad_title);
            adViewHolder.mDescription = (TextView) inflate.findViewById(com.martian.mibook.R.id.tv_native_ad_desc);
            adViewHolder.mPoster = (ImageView) inflate.findViewById(com.martian.mibook.R.id.iv_native_image);
            adViewHolder.videoView = (FrameLayout) inflate.findViewById(com.martian.mibook.R.id.iv_ads_video);
            adViewHolder.mCreativeButton = (Button) inflate.findViewById(com.martian.mibook.R.id.btn_native_creative);
            adViewHolder.mAdLogo = (ImageView) inflate.findViewById(com.martian.mibook.R.id.iv_native_logo);
            adViewHolder.mAdLogoDesc = (TextView) inflate.findViewById(com.martian.mibook.R.id.tv_ads_logo_desc);
            adViewHolder.mTitle.setText(appTask.getTitle());
            adViewHolder.mDescription.setText(appTask.getDesc());
            adViewHolder.mAdLogo.setImageResource(appTask.adsIconRes());
            if (!l.q(appTask.getButtonText())) {
                adViewHolder.mCreativeButton.setText(appTask.getButtonText());
            }
            MiConfigSingleton.b2().H1().Q0(MiWebViewActivity.this, adViewHolder.mPoster, null, appTask);
            MiWebViewActivity.this.S.addView(inflate);
            com.martian.mibook.application.a H1 = MiConfigSingleton.b2().H1();
            MiWebViewActivity miWebViewActivity = MiWebViewActivity.this;
            H1.A(miWebViewActivity, appTask, miWebViewActivity.S, inflate.findViewById(R.id.iv_ads_view), adViewHolder, new C0523a());
            MiWebViewActivity.this.b5();
        }
    }

    public class b implements xb.b {

        /* renamed from: a */
        public final /* synthetic */ String f13166a;

        /* renamed from: b */
        public final /* synthetic */ String f13167b;

        public b(String str, String str2) {
            this.f13166a = str;
            this.f13167b = str2;
        }

        @Override // xb.b
        public void a(Book book) {
            if (book == null) {
                MiWebViewActivity.this.P1("加入失败，请重试");
                return;
            }
            MiConfigSingleton.b2().M1().g(MiWebViewActivity.this, book);
            MiWebViewActivity.this.P1("已加入书架");
            MiConfigSingleton.b2().V1().g(3, book.getSourceName(), book.getSourceId(), this.f13166a, this.f13167b, "书单加书架");
        }

        @Override // xb.b
        public void onLoading(boolean z10) {
        }

        @Override // xb.b
        public void onResultError(x8.c cVar) {
            MiWebViewActivity.this.P1("加入失败，请重试");
        }
    }

    public class d extends d8.b {
        public d() {
        }

        @Override // d8.b, d8.a
        public void c(AdConfig adConfig, x8.c cVar) {
            MiWebViewActivity.this.M5(false);
        }

        @Override // d8.b, d8.a
        public void k(AdConfig adConfig, boolean z10) {
            MiWebViewActivity.this.M5(z10);
        }
    }

    public class e extends kb.g {

        /* renamed from: k */
        public final /* synthetic */ int f13171k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Activity activity, int i10) {
            super(activity);
            this.f13171k = i10;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            MiWebViewActivity.this.P1("充值请求失败" + cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(AliRechargeOrder aliRechargeOrder) {
            MiWebViewActivity.this.D5(this.f13171k, aliRechargeOrder);
        }
    }

    public class f implements b.c {

        /* renamed from: a */
        public final /* synthetic */ String f13173a;

        /* renamed from: b */
        public final /* synthetic */ AliRechargeOrder f13174b;

        public f(String str, AliRechargeOrder aliRechargeOrder) {
            this.f13173a = str;
            this.f13174b = aliRechargeOrder;
        }

        @Override // e8.b.c
        public void a(String str) {
        }

        @Override // e8.b.c
        public void b(String str, String str2) {
        }

        @Override // e8.b.c
        public void c(String str) {
        }

        @Override // e8.b.c
        public void d(String str) {
            MiWebViewActivity.this.y5(this.f13173a);
        }

        @Override // e8.b.c
        public void e() {
        }

        @Override // e8.b.c
        public void f(String str) {
            MiWebViewActivity.this.w5(this.f13173a);
        }

        @Override // e8.b.c
        public void onFailure(String str) {
            MiWebViewActivity.this.x5(this.f13173a, str);
        }

        @Override // e8.b.c
        public void onSuccess() {
            MiWebViewActivity.this.z5(this.f13173a, this.f13174b.getRechargeOrder() == null ? null : this.f13174b.getRechargeOrder().getRoid(), 1);
        }
    }

    public class g extends kb.h {

        /* renamed from: k */
        public final /* synthetic */ int f13176k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Activity activity, int i10) {
            super(activity);
            this.f13176k = i10;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            MiWebViewActivity.this.P1("充值请求失败" + cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(WXRechargeOrder wXRechargeOrder) {
            MiWebViewActivity.this.L5(wXRechargeOrder, String.valueOf(this.f13176k));
        }
    }

    public class h implements b.c {

        /* renamed from: a */
        public final /* synthetic */ String f13178a;

        /* renamed from: b */
        public final /* synthetic */ WXRechargeOrder f13179b;

        public h(String str, WXRechargeOrder wXRechargeOrder) {
            this.f13178a = str;
            this.f13179b = wXRechargeOrder;
        }

        @Override // z7.b.c
        public void a(String str) {
            MiWebViewActivity.this.x5(this.f13178a, str);
        }

        @Override // z7.b.c
        public void b(String str, String str2) {
            MiWebViewActivity.this.y5(this.f13178a);
        }

        @Override // z7.b.c
        public void c() {
            MiWebViewActivity.this.z5(this.f13178a, this.f13179b.getRechargeOrder() == null ? null : this.f13179b.getRechargeOrder().getRoid(), 0);
        }

        @Override // z7.b.c
        public void d() {
            MiWebViewActivity.this.w5(this.f13178a);
        }
    }

    public static void A4(Activity activity, String str, boolean z10) {
        H5(activity, str, z10, "", false, "");
    }

    public static void H5(Activity activity, String str, boolean z10, String str2, boolean z11, String str3) {
        I5(activity, str, z10, str2, z11, str3, false);
    }

    public static void I5(Activity activity, String str, boolean z10, String str2, boolean z11, String str3, boolean z12) {
        J5(activity, str, z10, str2, z11, str3, z12, false);
    }

    public static void J5(Activity activity, String str, boolean z10, String str2, boolean z11, String str3, boolean z12, boolean z13) {
        d5(activity, str);
        Bundle bundle = new Bundle();
        bundle.putString("LIBMARS_INTENT_WEBVIEW_URL", str);
        bundle.putBoolean(WebViewActivity.W, z13);
        if (!l.q(str2)) {
            bundle.putString("INTENT_WEBVIEW_SHARE_URL", str2);
        }
        bundle.putBoolean("LIBMARS_INTENT_DOWNLOAD_HINT", z10);
        bundle.putBoolean("INTENT_SHAREABLE", z11);
        if (!l.q(str3)) {
            bundle.putString("INTENT_SHARE_IMAGE_URL", str3);
        }
        bundle.putBoolean("INTENT_FULLSCREEN", z12);
        Intent intent = new Intent(activity, (Class<?>) MiWebViewActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void K5(Activity activity, String str, boolean z10, int i10) {
        d5(activity, str);
        Bundle bundle = new Bundle();
        bundle.putString("LIBMARS_INTENT_WEBVIEW_URL", str);
        bundle.putBoolean("LIBMARS_INTENT_DOWNLOAD_HINT", z10);
        Intent intent = new Intent(activity, (Class<?>) MiWebViewActivity.class);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i10);
    }

    private void Y4(boolean z10) {
        if (this.L != null) {
            NightModeChangeParams nightModeChangeParams = new NightModeChangeParams();
            nightModeChangeParams.setNightMode(z10);
            MTWebView mTWebView = this.L;
            mTWebView.loadUrl(mTWebView.d(nightModeChangeParams));
        }
    }

    public static void d5(Activity activity, String str) {
        if (MiConfigSingleton.b2().F2() && i8.g.q(str) && MiConfigSingleton.b2().V0()) {
            try {
                String t22 = MiConfigSingleton.b2().t2();
                String token = MiConfigSingleton.b2().u2().s().getToken();
                String str2 = MiConfigSingleton.b2().l().f26178a;
                String A3 = WebViewActivity.A3(str);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setCookie(A3, "uid=" + t22);
                if (!l.q(token)) {
                    cookieManager.setCookie(A3, "token=" + token);
                }
                if (!l.q(str2)) {
                    cookieManager.setCookie(A3, "appid=" + str2);
                }
                if (m.q(activity)) {
                    cookieManager.setCookie(A3, "notchHeight=" + ConfigSingleton.W0(com.gyf.immersionbar.d.H0(activity)));
                }
                cookieManager.setCookie(A3, "device_id=" + ConfigSingleton.D().y());
                cookieManager.setCookie(A3, "brand=" + ConfigSingleton.D().o());
                cookieManager.setCookie(A3, "osversion=" + ConfigSingleton.D().k());
                cookieManager.setCookie(A3, "screen_height=" + ConfigSingleton.D().a0());
                cookieManager.setCookie(A3, "screen_width=" + ConfigSingleton.D().b0());
                cookieManager.setCookie(A3, "wx_appid=" + ConfigSingleton.D().q0().f33705a);
                cookieManager.setCookie(A3, "version_code=" + ConfigSingleton.D().o0());
                cookieManager.setCookie(A3, "versionCode=" + ConfigSingleton.D().o0());
                cookieManager.setCookie(A3, "version_name=" + ConfigSingleton.D().p0());
                cookieManager.setCookie(A3, "package_name=" + ConfigSingleton.D().getPackageName());
                cookieManager.setCookie(A3, "channel=" + ConfigSingleton.D().r());
                cookieManager.setCookie(A3, "ostype=0");
                cookieManager.setCookie(A3, "optype=" + ConfigSingleton.D().P());
                cookieManager.setCookie(A3, "conntype=" + ConfigSingleton.D().u());
                cookieManager.setCookie(A3, "guest=" + MiConfigSingleton.b2().D2());
                cookieManager.setCookie(A3, "night_mode=" + ConfigSingleton.D().A0());
                cookieManager.setCookie(A3, "traditional=" + ConfigSingleton.D().M0());
                CookieManager.getInstance().flush();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void startWebViewActivity(Activity activity, String str) {
        A4(activity, str, false);
    }

    public void x5(String str, String str2) {
        runOnUiThread(new Runnable() { // from class: ta.d

            /* renamed from: c */
            public final /* synthetic */ String f30775c;

            /* renamed from: d */
            public final /* synthetic */ String f30776d;

            public /* synthetic */ d(String str22, String str3) {
                str2 = str22;
                str = str3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.n5(str2, str);
            }
        });
    }

    @Override // com.martian.libmars.activity.MartianActivity, k9.b
    public void A0() {
        k2();
        w2();
        Y4(ConfigSingleton.D().A0());
    }

    public final void A5() {
        this.f13156d0 = new DownLoadReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        intentFilter.addAction("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
        registerReceiver(this.f13156d0, intentFilter);
    }

    public final void B5(boolean z10) {
        s0.j().q(this, z10, new i0.k() { // from class: ta.j
            public /* synthetic */ j() {
            }

            @Override // l9.i0.k
            public final void a() {
                MiWebViewActivity.this.F3();
            }
        });
    }

    public final void C5() {
        MiConfigSingleton.b2().H1().H0(this, e0.U, null);
    }

    public void D5(int i10, AliRechargeOrder aliRechargeOrder) {
        e8.a o10 = MiUserManager.o(aliRechargeOrder, oe.f.n(Integer.valueOf(i10)));
        if (o10 == null) {
            return;
        }
        e8.b.b(this, o10, new f(GsonUtils.b().toJson(aliRechargeOrder), aliRechargeOrder));
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void E3(String str, String str2, String str3, String str4) {
        if (MiConfigSingleton.b2().M1().j0(str, str2)) {
            return;
        }
        MiConfigSingleton.b2().M1().k(new Source(str, str2), new b(str3, str4));
    }

    public final void E5() {
        MiConfigSingleton.b2().H1().I0(this, true, new d());
    }

    public final void F5(String str) {
        MiConfigSingleton.b2().e2().H0(this, e0.M.equalsIgnoreCase(str), new c.o() { // from class: ta.f
            public /* synthetic */ f() {
            }

            @Override // com.martian.mibook.application.c.o
            public final void a() {
                MiWebViewActivity.this.q5();
            }
        });
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void G3(boolean z10) {
    }

    public void G5(Integer num) {
        RechargeOrderDetailActivity.m3(this, num, 100);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void H3(String str, String str2, int i10, String str3, String str4) {
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void I3() {
        ba.h.b(this);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void J3() {
        if (MiConfigSingleton.b2().G1().i(this)) {
            i.Z(this, ShareImageUrlActivity.u(this, 3));
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void K3() {
        if (MiConfigSingleton.b2().G1().i(this)) {
            i.Z(this, ShareImageUrlActivity.u(this, 5));
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void L3() {
        if (MiConfigSingleton.b2().G1().i(this)) {
            i.Z(this, ShareImageUrlActivity.u(this, 4));
        }
    }

    public void L5(WXRechargeOrder wXRechargeOrder, String str) {
        PayReq p10 = MiUserManager.p(wXRechargeOrder);
        if (p10 == null) {
            P1("请求失败");
        } else {
            z7.b.d().x(this, MiConfigSingleton.b2().c2().getRechargeWxAppid(), str, p10, new h(GsonUtils.b().toJson(wXRechargeOrder), wXRechargeOrder));
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void M3() {
        if (MiConfigSingleton.b2().G1().i(this)) {
            i.Z(this, ShareImageUrlActivity.u(this, 2));
        }
    }

    public final void M5(boolean z10) {
        runOnUiThread(new Runnable() { // from class: ta.e

            /* renamed from: c */
            public final /* synthetic */ boolean f30778c;

            public /* synthetic */ e(boolean z102) {
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.s5(z10);
            }
        });
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void N3() {
        if (MiConfigSingleton.b2().G1().i(this)) {
            i.Z(this, ShareImageUrlActivity.u(this, 1));
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public boolean O3(String str, String str2) {
        return MiConfigSingleton.b2().M1().j0(str, str2);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void P3(boolean z10) {
        int i10 = z10 ? 200 : 202;
        if (MiConfigSingleton.b2().C2()) {
            t0.b(this, ConfigSingleton.D().s("请先登录"));
            i10 = 10001;
        }
        MiConfigSingleton.b2().G1().j(this, i10);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void Q3() {
        ac.a.a0(this, "", "去好评");
        org.codechimp.apprater.a.m(new vi.d());
        org.codechimp.apprater.a.g(this);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void R3(String str, String str2) {
        if (l.q(str) || l.q(str2)) {
            return;
        }
        ac.a.a0(this, str, str2);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void S3(String str, String str2, int i10, String str3, String str4) {
        F5(str2);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void T3(String str) {
        C5();
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void U3(String str) {
        E5();
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void V3(String str, String str2) {
        IntervalBonus intervalBonus;
        if (l.q(str2) || (intervalBonus = (IntervalBonus) GsonUtils.b().fromJson(str2, IntervalBonus.class)) == null) {
            return;
        }
        MiConfigSingleton.b2().u2().S(this, str, intervalBonus.getMoney(), intervalBonus.getCoins().intValue());
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void W3() {
        if (MiConfigSingleton.b2().G1().i(this)) {
            i.Z(this, ShareImageUrlActivity.u(this, 0));
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void X3(int i10, String str, long j10, int i11) {
        if (i10 > 0 || !l.q(str)) {
            s0.j().p(this, new s0.f().f(Integer.valueOf(i10)).g(str).i(Long.valueOf(j10)).h(Integer.valueOf(i11)), new i0.k() { // from class: ta.g

                /* renamed from: b */
                public final /* synthetic */ int f30781b;

                public /* synthetic */ g(int i102) {
                    i10 = i102;
                }

                @Override // l9.i0.k
                public final void a() {
                    MiWebViewActivity.this.i5(i10);
                }
            });
        } else {
            B5(true);
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void Y3(String str, String str2) {
        if (l.q(str) || l.q(str2)) {
            return;
        }
        i.G(this, str2, str, "deeplink", "");
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void Z3(String str, boolean z10) {
        I5(this, str, false, "", false, "", z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Z4(int i10, String str, String str2) {
        e eVar = new e(this, i10);
        ((CreatAliPrepayParams) eVar.k()).setMoney(Integer.valueOf(i10));
        if (!l.q(str)) {
            try {
                ((CreatAliPrepayParams) eVar.k()).setProductId(Integer.valueOf(Integer.parseInt(str)));
            } catch (Exception unused) {
            }
        }
        if (!l.q(str2)) {
            ((CreatAliPrepayParams) eVar.k()).setExtra(str2);
        }
        eVar.j();
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void a4(int i10, int i11, String str, String str2) {
        if (MiConfigSingleton.b2().G1().f(this)) {
            if (i11 == 1) {
                Z4(i10, str, str2);
            } else if (i8.g.p(this)) {
                a5(i10, str, str2);
            } else {
                P1("请先安装微信");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a5(int i10, String str, String str2) {
        g gVar = new g(this, i10);
        ((CreateWxPrepayParams) gVar.k()).setMoney(Integer.valueOf(i10));
        ((CreateWxPrepayParams) gVar.k()).setWx_appid(MiConfigSingleton.b2().c2().getRechargeWxAppid());
        if (!l.q(str)) {
            try {
                ((CreateWxPrepayParams) gVar.k()).setProductId(Integer.valueOf(Integer.parseInt(str)));
            } catch (Exception unused) {
            }
        }
        if (!l.q(str2)) {
            ((CreateWxPrepayParams) gVar.k()).setExtra(str2);
        }
        gVar.j();
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void b4(String str) {
        try {
            WebRechargeParams webRechargeParams = (WebRechargeParams) GsonUtils.b().fromJson(str, WebRechargeParams.class);
            if (webRechargeParams != null) {
                a4(webRechargeParams.getMoney().intValue(), webRechargeParams.getMethod(), webRechargeParams.getProductId(), webRechargeParams.getExtra());
            } else {
                P1("数据解析出错");
            }
        } catch (Exception e10) {
            P1("数据解析出错");
            e10.printStackTrace();
        }
    }

    public final void b5() {
        runOnUiThread(new Runnable() { // from class: ta.i
            public /* synthetic */ i() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.h5();
            }
        });
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void c4(String str) {
        if (!MiConfigSingleton.b2().G1().i(this) || l.q(str)) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: ta.a

            /* renamed from: c */
            public final /* synthetic */ ShareInfo f30767c;

            public /* synthetic */ a(ShareInfo shareInfo) {
                shareInfo = shareInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.j5(shareInfo);
            }
        });
    }

    public final String c5(String str, String str2) {
        return "if (typeof(nativeRewardVideoAdPlayComplete) === 'function') { nativeRewardVideoAdPlayComplete(ERRCODE, 'ERRMSG') }".replaceAll("ERRCODE", str).replaceAll("ERRMSG", str2);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void d4(String str, String str2, String str3) {
        i.e0(this, str3, str, str2);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void e4() {
        Intent m10 = i.m(this);
        try {
            m10.addFlags(268435456);
            startActivity(m10);
        } catch (Exception unused) {
            Intent intent = new Intent("android.settings.SETTINGS");
            m10.addFlags(268435456);
            startActivity(intent);
        }
    }

    public void e5() {
        if (l.q(this.N)) {
            return;
        }
        d5(this, this.N);
        MTWebView mTWebView = this.L;
        if (mTWebView != null) {
            mTWebView.reload();
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void f4() {
        lb.c.x(this, new c());
        MiConfigSingleton.b2().G1().C(this, true, null);
    }

    public final boolean f5() {
        return !l.q(this.N) && (this.N.contains("xianwan") || this.N.contains("wowan"));
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void g4(String str) {
        if (MiConfigSingleton.b2().G1().i(this)) {
            MiConfigSingleton.b2().u2().R(this, str, this.L);
        }
    }

    public final boolean g5() {
        return !l.q(this.N) && this.N.contains("xwgame=true");
    }

    public final /* synthetic */ void h5() {
        Handler handler = this.f13157e0;
        if (handler == null) {
            this.f13157e0 = new Handler();
        } else {
            handler.removeCallbacks(this.f13159g0);
        }
        this.f13157e0.postDelayed(this.f13159g0, MiConfigSingleton.b2().c2().getBannerAdInterval().intValue() * 1000);
    }

    public final /* synthetic */ void i5(int i10) {
        if (i10 > 0) {
            if (new Random().nextInt(10) % 2 == 0) {
                B5(false);
            } else {
                F3();
            }
        }
    }

    public final /* synthetic */ void j5(ShareInfo shareInfo) {
        i.Z(this, shareInfo);
    }

    public final /* synthetic */ void k5(Unit unit) {
        A0();
    }

    public final /* synthetic */ void l5(MartianRPAccount martianRPAccount) {
        if (martianRPAccount == null || martianRPAccount.getIsVip() <= 0) {
            return;
        }
        this.L.reload();
    }

    public final /* synthetic */ void m5(String str) {
        P1(this.f13161i0);
        ac.a.a0(this, "", "微信充值-取消");
        this.L.loadUrl("javascript:rechargeResult(0, " + str + ")");
    }

    public final /* synthetic */ void n5(String str, String str2) {
        P1(this.f13162j0 + " - " + str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("微信充值-失败：");
        sb2.append(str);
        ac.a.a0(this, "", sb2.toString());
        this.L.loadUrl("javascript:rechargeResult(-1, " + str2 + ")");
    }

    public final /* synthetic */ void o5(String str) {
        P1(this.f13163k0);
        this.L.loadUrl("javascript:rechargeResult(2, " + str + ")");
    }

    public void onActionMenuClick(View view) {
        if (f5()) {
            if (g5()) {
                MiConfigSingleton.b2().e2().X(this, 101, null);
                return;
            }
            ac.a.G(this, "网页-佣金提现");
            if (MiConfigSingleton.b2().G1().f(this)) {
                i.K(this);
            }
        }
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if ((i10 != 10001 && i10 != 200 && i10 != 1021 && i10 != 202 && i10 != 10025) || i11 != -1) {
            if (i10 == 2 && i11 == -1) {
                P1("分享成功");
                return;
            }
            return;
        }
        ac.a.D(this, "登录成功-网页内登录");
        e5();
        this.L.reload();
        lb.c.x(this, null);
        MiConfigSingleton.b2().G1().C(this, true, null);
    }

    @Override // com.martian.mibook.lib.account.activity.MiWebViewBaseActivity, com.martian.libmars.activity.WebViewActivity, com.martian.libmars.activity.RetryLoadingActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (f5()) {
            A5();
            if (g5()) {
                P2("首页");
            } else {
                P2("提现");
            }
        }
        AppViewModel a10 = lc.b.a(this);
        if (a10 != null) {
            a10.h0().observe(this, new Observer() { // from class: ta.m
                public /* synthetic */ m() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MiWebViewActivity.this.k5((Unit) obj);
                }
            });
            a10.Y().observe(this, new Observer() { // from class: ta.n
                public /* synthetic */ n() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MiWebViewActivity.this.l5((MartianRPAccount) obj);
                }
            });
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DownLoadReceiver downLoadReceiver = this.f13156d0;
        if (downLoadReceiver != null) {
            unregisterReceiver(downLoadReceiver);
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        v5();
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        t5();
    }

    public final /* synthetic */ void p5(int i10, String str, Integer num) {
        AppViewModel a10 = lc.b.a(this);
        if (a10 != null) {
            a10.F0(true);
            a10.l0(false);
        }
        P1(this.f13160h0);
        MiConfigSingleton.b2().k3(i10);
        ac.a.a0(this, "", "微信充值-成功");
        this.L.loadUrl("javascript:rechargeResult(1, " + str + ")");
        if (num != null) {
            G5(num);
        }
        this.L.reload();
        setResult(-1);
    }

    public final /* synthetic */ void q5() {
        M5(true);
    }

    public final /* synthetic */ void r5(boolean z10) {
        if (z10) {
            this.L.loadUrl("javascript:" + c5("0", ""));
            return;
        }
        this.L.loadUrl("javascript:" + c5("-1", "视频加载失败"));
    }

    public final /* synthetic */ void s5(boolean z10) {
        this.L.post(new Runnable() { // from class: ta.h

            /* renamed from: c */
            public final /* synthetic */ boolean f30783c;

            public /* synthetic */ h(boolean z102) {
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.r5(z10);
            }
        });
    }

    public void t5() {
        if (this.f13158f0 || this.L == null || this.S == null || l.q(this.N) || !this.N.contains("lucky_draw")) {
            return;
        }
        this.f13158f0 = true;
        this.S.setVisibility(0);
        this.L.setBackgroundColor(Color.parseColor("#FEDC70"));
        u5();
    }

    public final void u5() {
        MiConfigSingleton.b2().H1().T(this, e0.S, new a());
    }

    public final void v5() {
        Handler handler;
        if (!this.f13158f0 || (handler = this.f13157e0) == null) {
            return;
        }
        handler.removeCallbacks(this.f13159g0);
        this.f13158f0 = false;
    }

    public final void w5(String str) {
        runOnUiThread(new Runnable() { // from class: ta.b

            /* renamed from: c */
            public final /* synthetic */ String f30769c;

            public /* synthetic */ b(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.m5(str);
            }
        });
    }

    public final void y5(String str) {
        runOnUiThread(new Runnable() { // from class: ta.l

            /* renamed from: c */
            public final /* synthetic */ String f30788c;

            public /* synthetic */ l(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.o5(str);
            }
        });
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void z3(String str) {
        startWebViewActivity(this, str);
    }

    public final void z5(String str, Integer num, int i10) {
        runOnUiThread(new Runnable() { // from class: ta.c

            /* renamed from: c */
            public final /* synthetic */ int f30771c;

            /* renamed from: d */
            public final /* synthetic */ String f30772d;

            /* renamed from: e */
            public final /* synthetic */ Integer f30773e;

            public /* synthetic */ c(int i102, String str2, Integer num2) {
                i10 = i102;
                str = str2;
                num = num2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.p5(i10, str, num);
            }
        });
    }

    public class c implements c.g {
        public c() {
        }

        @Override // lb.c.g
        public void b(MiTaskAccount miTaskAccount) {
            MiWebViewActivity.this.e5();
            MiWebViewActivity.this.L.reload();
        }

        @Override // lb.c.g
        public void a(x8.c cVar) {
        }
    }
}
