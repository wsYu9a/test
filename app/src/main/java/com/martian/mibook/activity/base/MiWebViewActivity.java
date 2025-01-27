package com.martian.mibook.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import b.d.b.c;
import com.gyf.barlibrary.ImmersionBar;
import com.maritan.libweixin.c;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.appwall.request.auth.MartianPlayxianAppwallParams;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.WebViewActivity;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.k0;
import com.martian.libmars.utils.n0;
import com.martian.libmars.utils.q0;
import com.martian.libmars.widget.MTWebView;
import com.martian.libxianplay.view.DownLoadReceiver;
import com.martian.mibook.activity.BonusDetailActivity;
import com.martian.mibook.activity.RechargeOrderDetailActivity;
import com.martian.mibook.activity.ShareImageUrlActivity;
import com.martian.mibook.activity.account.IncomeActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.m0;
import com.martian.mibook.application.o0;
import com.martian.mibook.data.ShareInfo;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.activity.MiWebViewBaseActivity;
import com.martian.mibook.lib.account.request.auth.CreatAliPrepayParams;
import com.martian.mibook.lib.account.request.auth.CreateWxPrepayParams;
import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.IntervalBonus;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.mibook.lib.account.response.WebRechargeParams;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.ttbookhd.R;
import com.opos.acs.st.utils.ErrorContants;
import com.tencent.mm.opensdk.modelpay.PayReq;
import java.util.Random;

/* loaded from: classes3.dex */
public class MiWebViewActivity extends MiWebViewBaseActivity {
    private com.martian.mibook.b.b k0;
    private DownLoadReceiver l0;
    private com.martian.mibook.b.b m0;
    private Handler n0;
    private boolean o0 = false;
    private final Runnable p0 = new b();
    private final String q0 = "淘书币充值成功, 开心萌萌哒~@^_^@~";
    private final String r0 = "啊! 充值取消了, 撒油娜拉~~>_<~~";
    private final String s0 = "哎妈呀, 充值出错了 >_<¦¦¦, 客官再试一次呗~";
    private final String t0 = "充值处理中哦，客官稍等*^ο^*";

    class a extends b.d.a.k.b {
        a() {
        }

        /* renamed from: k */
        public /* synthetic */ void l(View v) {
            MiWebViewActivity.this.i0.removeAllViews();
        }

        /* renamed from: m */
        public /* synthetic */ void n(final AppTask mAppTask, View v) {
            MiWebViewActivity.this.m0.d(mAppTask);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            TextView textView;
            View view;
            final AppTask appTask = appTaskList.getApps().get(0);
            MiWebViewActivity.this.i0.removeAllViews();
            MiWebViewActivity miWebViewActivity = MiWebViewActivity.this;
            FrameLayout frameLayout = miWebViewActivity.i0;
            if (appTask.customView == null) {
                View inflate = miWebViewActivity.getLayoutInflater().inflate(R.layout.native_banner_ad, MiWebViewActivity.this.i0);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_native_image);
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_native_logo);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_native_ad_title);
                TextView textView3 = (TextView) inflate.findViewById(R.id.tv_native_ad_desc);
                ImageView imageView3 = (ImageView) inflate.findViewById(R.id.iv_native_close_icon);
                textView = (TextView) inflate.findViewById(R.id.btn_native_creative);
                if (!com.martian.libsupport.k.p(appTask.buttonText)) {
                    textView.setText(appTask.buttonText);
                }
                imageView3.setVisibility(0);
                imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.base.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        MiWebViewActivity.a.this.l(view2);
                    }
                });
                imageView2.setImageResource(appTask.adsIconRes());
                textView2.setText(appTask.title);
                textView3.setText(appTask.desc);
                n0.k(MiWebViewActivity.this, appTask.getPosterUrl(), imageView);
                inflate.setClickable(true);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.base.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        MiWebViewActivity.a.this.n(appTask, view2);
                    }
                });
                view = inflate;
            } else {
                textView = null;
                view = frameLayout;
            }
            com.martian.mibook.b.b bVar = MiWebViewActivity.this.m0;
            MiWebViewActivity miWebViewActivity2 = MiWebViewActivity.this;
            bVar.g(miWebViewActivity2, appTask, miWebViewActivity2.i0, view, null, textView, false);
            MiWebViewActivity.this.r4();
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            MiWebViewActivity.this.i0.setVisibility(8);
            MiWebViewActivity.this.r4();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MiWebViewActivity.this.m0 != null) {
                MiWebViewActivity.this.m0.F();
            }
        }
    }

    class c implements com.martian.mibook.lib.model.c.g {

        /* renamed from: a */
        final /* synthetic */ String f10915a;

        /* renamed from: b */
        final /* synthetic */ String f10916b;

        c(final String val$sourceId, final String val$sourceName) {
            this.f10915a = val$sourceId;
            this.f10916b = val$sourceName;
        }

        @Override // com.martian.mibook.lib.model.c.g
        public String getSourceId() {
            return this.f10916b;
        }

        @Override // com.martian.mibook.lib.model.c.g
        public String getSourceName() {
            return this.f10915a;
        }
    }

    class d implements com.martian.mibook.lib.model.d.b {

        /* renamed from: a */
        final /* synthetic */ String f10918a;

        /* renamed from: b */
        final /* synthetic */ String f10919b;

        d(final String val$recommend, final String val$recommendId) {
            this.f10918a = val$recommend;
            this.f10919b = val$recommendId;
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book) {
            if (book == null) {
                MiWebViewActivity.this.k1("加入失败，请重试");
                return;
            }
            MiConfigSingleton.V3().l3().d(MiWebViewActivity.this, book.buildMibook(), book);
            MiWebViewActivity.this.k1("已加入书架");
            MiConfigSingleton.V3().l3().I1(3, book.getSourceName(), book.getSourceId(), this.f10918a, this.f10919b, "书单加书架");
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
            MiWebViewActivity.this.k1("加入失败，请重试");
        }
    }

    class e extends b.d.a.k.b {
        e() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            MiWebViewActivity.this.k5(true);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            MiWebViewActivity.this.k5(false);
        }
    }

    class f extends com.martian.mibook.lib.account.d.q.i {

        /* renamed from: j */
        final /* synthetic */ int f10922j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(j1 x0, final int val$money) {
            super(x0);
            this.f10922j = val$money;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            MiWebViewActivity.this.k1("充值请求失败" + errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(AliRechargeOrder aliRechargeOrder) {
            MiWebViewActivity.this.b5(this.f10922j, aliRechargeOrder);
        }
    }

    class g implements c.InterfaceC0013c {

        /* renamed from: a */
        final /* synthetic */ String f10923a;

        /* renamed from: b */
        final /* synthetic */ AliRechargeOrder f10924b;

        g(final String val$aliRechargeOrder, final AliRechargeOrder val$orderJson) {
            this.f10923a = val$aliRechargeOrder;
            this.f10924b = val$orderJson;
        }

        @Override // b.d.b.c.InterfaceC0013c
        public void a(String out_trade_no, String fee_value) {
        }

        @Override // b.d.b.c.InterfaceC0013c
        public void b(String rawResult) {
        }

        @Override // b.d.b.c.InterfaceC0013c
        public void c(String message) {
            MiWebViewActivity.this.W4(this.f10923a);
        }

        @Override // b.d.b.c.InterfaceC0013c
        public void d(String message) {
            MiWebViewActivity.this.V4(this.f10923a, message);
        }

        @Override // b.d.b.c.InterfaceC0013c
        public void e(String message) {
            MiWebViewActivity.this.U4(this.f10923a);
        }

        @Override // b.d.b.c.InterfaceC0013c
        public void onSuccess() {
            MiWebViewActivity.this.X4(this.f10923a, this.f10924b.getRechargeOrder() == null ? null : this.f10924b.getRechargeOrder().getRoid(), 1);
        }
    }

    class h extends com.martian.mibook.lib.account.d.q.j {
        h(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            MiWebViewActivity.this.k1("充值请求失败" + errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(final WXRechargeOrder tyRechargeWeixinOrder) {
            MiWebViewActivity.this.j5(tyRechargeWeixinOrder);
        }
    }

    class i implements c.d {

        /* renamed from: a */
        final /* synthetic */ String f10927a;

        /* renamed from: b */
        final /* synthetic */ WXRechargeOrder f10928b;

        i(final String val$tyRechargeWeixinOrder, final WXRechargeOrder val$orderJson) {
            this.f10927a = val$tyRechargeWeixinOrder;
            this.f10928b = val$orderJson;
        }

        @Override // com.maritan.libweixin.c.d
        public void a(String errStr) {
            MiWebViewActivity.this.V4(this.f10927a, errStr);
        }

        @Override // com.maritan.libweixin.c.d
        public void b(String out_trade_no, String fee_value) {
            MiWebViewActivity.this.W4(this.f10927a);
        }

        @Override // com.maritan.libweixin.c.d
        public void c() {
            MiWebViewActivity.this.X4(this.f10927a, this.f10928b.getRechargeOrder() == null ? null : this.f10928b.getRechargeOrder().getRoid(), 0);
        }

        @Override // com.maritan.libweixin.c.d
        public void d() {
            MiWebViewActivity.this.U4(this.f10927a);
        }
    }

    /* renamed from: A4 */
    public /* synthetic */ void B4(final int coins) {
        if (coins > 0) {
            if (new Random().nextInt(10) % 2 == 0) {
                Z4(false);
            } else {
                c3();
            }
        }
    }

    /* renamed from: C4 */
    public /* synthetic */ void D4(final ShareInfo shareInfo) {
        s2.n0(this, shareInfo);
    }

    /* renamed from: E4 */
    public /* synthetic */ void F4(final boolean verify) {
        if (verify) {
            this.X.loadUrl("javascript:" + s4("0", ""));
            return;
        }
        this.X.loadUrl("javascript:" + s4(ErrorContants.NET_ERROR, "视频加载失败"));
    }

    /* renamed from: G4 */
    public /* synthetic */ void H4(final String orderJson) {
        k1("啊! 充值取消了, 撒油娜拉~~>_<~~");
        com.martian.mibook.lib.model.g.b.m0(this, "", "微信充值-取消");
        this.X.loadUrl("javascript:rechargeResult(0, " + orderJson + ")");
    }

    /* renamed from: I4 */
    public /* synthetic */ void J4(final String errStr, final String orderJson) {
        k1("哎妈呀, 充值出错了 >_<¦¦¦, 客官再试一次呗~ - " + errStr);
        com.martian.mibook.lib.model.g.b.m0(this, "", "微信充值-失败：" + errStr);
        this.X.loadUrl("javascript:rechargeResult(-1, " + orderJson + ")");
    }

    /* renamed from: K4 */
    public /* synthetic */ void L4(final String orderJson) {
        k1("充值处理中哦，客官稍等*^ο^*");
        this.X.loadUrl("javascript:rechargeResult(2, " + orderJson + ")");
    }

    /* renamed from: M4 */
    public /* synthetic */ void N4(final int method, final String orderJson, final Integer roid) {
        k1("淘书币充值成功, 开心萌萌哒~@^_^@~");
        MiConfigSingleton.V3().a8(method);
        com.martian.mibook.lib.model.g.b.m0(this, "", "微信充值-成功");
        this.X.loadUrl("javascript:rechargeResult(1, " + orderJson + ")");
        if (roid != null) {
            e5(roid);
        }
        this.X.reload();
        setResult(-1);
    }

    /* renamed from: O4 */
    public /* synthetic */ void P4() {
        k5(true);
    }

    /* renamed from: Q4 */
    public /* synthetic */ void R4(final boolean verify) {
        this.X.post(new Runnable() { // from class: com.martian.mibook.activity.base.j
            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.F4(verify);
            }
        });
    }

    private void T4() {
        Handler handler;
        if (!this.o0 || (handler = this.n0) == null) {
            return;
        }
        handler.removeCallbacks(this.p0);
        this.o0 = false;
    }

    public void U4(final String orderJson) {
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.base.h
            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.H4(orderJson);
            }
        });
    }

    public void V4(final String orderJson, final String errStr) {
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.base.l
            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.J4(errStr, orderJson);
            }
        });
    }

    public void W4(final String orderJson) {
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.base.d
            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.L4(orderJson);
            }
        });
    }

    public void X4(final String orderJson, final Integer roid, final int method) {
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.base.g
            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.N4(method, orderJson, roid);
            }
        });
    }

    private void Y4() {
        this.l0 = new DownLoadReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        intentFilter.addAction("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
        registerReceiver(this.l0, intentFilter);
    }

    private void Z4(boolean fallback) {
        m0.f().o(this, fallback, new k0.j() { // from class: com.martian.mibook.activity.base.a
            @Override // com.martian.libmars.utils.k0.j
            public final void a() {
                MiWebViewActivity.this.c3();
            }
        });
    }

    private void a5(final String adsId) {
        if (this.k0 == null) {
            this.k0 = com.martian.mibook.b.b.o0(this);
        }
        if (com.martian.libsupport.k.p(adsId)) {
            this.k0.H0(com.martian.mibook.b.b.F, com.martian.mibook.application.k0.g3);
        } else {
            this.k0.H0(com.martian.mibook.b.b.F, adsId);
        }
    }

    private void c5() {
        MiConfigSingleton.V3().N4.t(this, b.d.a.j.b.f4373f, new e());
    }

    public static void d4(j1 activity, String url, boolean downloadHint, int requestCode) {
        t4(activity, url);
        Bundle bundle = new Bundle();
        bundle.putString(WebViewActivity.Q, url);
        bundle.putBoolean(WebViewActivity.S, downloadHint);
        q0.e(url);
        activity.startActivityForResult(MiWebViewActivity.class, bundle, requestCode);
    }

    private void d5(final String adsId) {
        MiConfigSingleton.V3().L4.C0(this, com.martian.mibook.application.k0.f2.equalsIgnoreCase(adsId), new o0.t() { // from class: com.martian.mibook.activity.base.m
            @Override // com.martian.mibook.application.o0.t
            public final void a() {
                MiWebViewActivity.this.P4();
            }
        });
    }

    public static void f5(j1 activity, String url) {
        g5(activity, url, false);
    }

    public static void g5(j1 activity, String url, boolean downloadHint) {
        h5(activity, url, downloadHint, "", false, "");
    }

    public static void h5(j1 activity, String url, boolean downloadHint, String shareUrl, boolean shareable, String shareImageUrl) {
        i5(activity, url, downloadHint, shareUrl, shareable, shareImageUrl, false);
    }

    public static void i5(j1 activity, String url, boolean downloadHint, String shareUrl, boolean shareable, String shareImageUrl, boolean fullscreen) {
        t4(activity, url);
        q0.e(url);
        Bundle bundle = new Bundle();
        bundle.putString(WebViewActivity.Q, url);
        if (!com.martian.libsupport.k.p(shareUrl)) {
            bundle.putString(WebViewActivity.R, shareUrl);
        }
        bundle.putBoolean(WebViewActivity.S, downloadHint);
        bundle.putBoolean(WebViewActivity.T, shareable);
        if (!com.martian.libsupport.k.p(shareImageUrl)) {
            bundle.putString(WebViewActivity.V, shareImageUrl);
        }
        bundle.putBoolean(WebViewActivity.U, fullscreen);
        activity.startActivity(MiWebViewActivity.class, bundle);
    }

    public void k5(final boolean verify) {
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.base.i
            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.R4(verify);
            }
        });
    }

    public void r4() {
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.base.k
            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.z4();
            }
        });
    }

    private String s4(String errCode, String errMsg) {
        return "if (typeof(nativeRewardVideoAdPlayComplete) === 'function') { nativeRewardVideoAdPlayComplete(ERRCODE, 'ERRMSG') }".replaceAll("ERRCODE", errCode).replaceAll("ERRMSG", errMsg);
    }

    public static void t4(Activity activity, String url) {
        if (MiConfigSingleton.V3().x5() && com.martian.apptask.g.g.k(url) && MiConfigSingleton.V3().h1()) {
            try {
                String D4 = MiConfigSingleton.V3().D4();
                String token = MiConfigSingleton.V3().M4.h().getToken();
                String str = MiConfigSingleton.V3().f().f9879a;
                String V2 = WebViewActivity.V2(url);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setCookie(V2, "uid=" + D4);
                if (!com.martian.libsupport.k.p(token)) {
                    cookieManager.setCookie(V2, "token=" + token);
                }
                if (!com.martian.libsupport.k.p(str)) {
                    cookieManager.setCookie(V2, "appid=" + str);
                }
                if (com.martian.libsupport.l.w(activity)) {
                    cookieManager.setCookie(V2, "notchHeight=" + com.martian.libmars.d.h.i1(ImmersionBar.getStatusBarHeight(activity)));
                }
                cookieManager.setCookie(V2, "device_id=" + com.martian.libmars.d.h.F().t());
                cookieManager.setCookie(V2, "brand=" + com.martian.libmars.d.h.F().j());
                cookieManager.setCookie(V2, "osversion=" + com.martian.libmars.d.h.F().e());
                cookieManager.setCookie(V2, "screen_height=" + com.martian.libmars.d.h.F().i0());
                cookieManager.setCookie(V2, "screen_width=" + com.martian.libmars.d.h.F().j0());
                cookieManager.setCookie(V2, "wx_appid=" + com.martian.libmars.d.h.F().y0().f9577a);
                cookieManager.setCookie(V2, "qq_appid=" + com.martian.libmars.d.h.F().e0().f9892a);
                cookieManager.setCookie(V2, "version_code=" + com.martian.libmars.d.h.F().w0());
                cookieManager.setCookie(V2, "versionCode=" + com.martian.libmars.d.h.F().w0());
                cookieManager.setCookie(V2, "version_name=" + com.martian.libmars.d.h.F().x0());
                cookieManager.setCookie(V2, "package_name=" + com.martian.libmars.d.h.F().getPackageName());
                cookieManager.setCookie(V2, "channel=" + com.martian.libmars.d.h.F().m());
                cookieManager.setCookie(V2, "ostype=0");
                cookieManager.setCookie(V2, "optype=" + com.martian.libmars.d.h.F().X());
                cookieManager.setCookie(V2, "conntype=" + com.martian.libmars.d.h.F().p());
                cookieManager.setCookie(V2, "guest=" + MiConfigSingleton.V3().t5());
                cookieManager.setCookie(V2, "night_mode=" + com.martian.libmars.d.h.F().I0());
                cookieManager.setCookie(V2, "traditional=" + com.martian.libsupport.l.K());
                if (com.martian.libsupport.l.s()) {
                    CookieManager.getInstance().flush();
                } else {
                    CookieSyncManager.createInstance(activity);
                    CookieSyncManager.getInstance().sync();
                }
            } catch (Exception unused) {
            }
        }
    }

    private boolean v4() {
        return !com.martian.libsupport.k.p(this.Z) && (this.Z.contains("xianwan") || this.Z.contains("wowan"));
    }

    private boolean w4() {
        return !com.martian.libsupport.k.p(this.Z) && this.Z.contains("bonus_activity");
    }

    private boolean x4() {
        return !com.martian.libsupport.k.p(this.Z) && this.Z.contains("xwgame=true");
    }

    /* renamed from: y4 */
    public /* synthetic */ void z4() {
        Handler handler = this.n0;
        if (handler == null) {
            this.n0 = new Handler();
        } else {
            handler.removeCallbacks(this.p0);
        }
        this.n0.postDelayed(this.p0, MiConfigSingleton.V3().W3().getBannerAdInterval().intValue() * 1000);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void A3(String wxAppid) {
        if (MiConfigSingleton.V3().n2(this)) {
            MiConfigSingleton.V3().M4.F(this, wxAppid, this.X);
        }
    }

    protected void S4() {
        if (this.o0 || this.X == null || this.i0 == null || com.martian.libsupport.k.p(this.Z) || !this.Z.contains("lucky_draw")) {
            return;
        }
        this.o0 = true;
        this.i0.setVisibility(0);
        this.X.setBackgroundColor(Color.parseColor("#FEDC70"));
        if (this.m0 == null) {
            com.martian.mibook.b.b p0 = com.martian.mibook.b.b.p0(this);
            this.m0 = p0;
            p0.T0(new a());
        }
        this.m0.F();
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void U2(String url) {
        f5(this, url);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void b3(String sourceName, String sourceId, String recommendId, String recommend) {
        MiBook Q = MiConfigSingleton.V3().l3().Q(com.martian.mibook.lib.model.manager.d.a(new c(sourceName, sourceId)));
        if (Q == null || !MiConfigSingleton.V3().l3().v0(Q)) {
            MiConfigSingleton.V3().l3().m(new Source(sourceName, sourceId), new d(recommendId, recommend));
        }
    }

    public void b5(int money, final AliRechargeOrder aliRechargeOrder) {
        b.d.b.b q = MiUserManager.q(aliRechargeOrder, com.martian.rpauth.d.i.m(Integer.valueOf(money)));
        if (q == null) {
            return;
        }
        b.d.b.c.b(this, q, new g(GsonUtils.b().toJson(aliRechargeOrder), aliRechargeOrder));
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void d3(final boolean open) {
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void e3(String position, String adsId, int reward, String rewardName, String rewardExtra) {
    }

    protected void e5(Integer roid) {
        RechargeOrderDetailActivity.R2(this, roid, 100);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void f3() {
        com.martian.libsupport.f.a(this);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void g3() {
        if (MiConfigSingleton.V3().n2(this)) {
            s2.n0(this, ShareImageUrlActivity.u(this, 3));
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void h3() {
        if (MiConfigSingleton.V3().n2(this)) {
            s2.n0(this, ShareImageUrlActivity.u(this, 5));
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void i3() {
        if (MiConfigSingleton.V3().n2(this)) {
            s2.n0(this, ShareImageUrlActivity.u(this, 4));
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void j3() {
        if (MiConfigSingleton.V3().n2(this)) {
            s2.n0(this, ShareImageUrlActivity.u(this, 2));
        }
    }

    public void j5(final WXRechargeOrder tyRechargeWeixinOrder) {
        PayReq r = MiUserManager.r(tyRechargeWeixinOrder);
        if (r == null) {
            k1("请求失败");
        } else {
            com.maritan.libweixin.c.g().E(MiConfigSingleton.V3().W3().getRechargeWxAppid(), r, new i(GsonUtils.b().toJson(tyRechargeWeixinOrder), tyRechargeWeixinOrder));
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void k3() {
        if (MiConfigSingleton.V3().n2(this)) {
            s2.n0(this, ShareImageUrlActivity.u(this, 1));
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected boolean l3(String sourceName, String sourceId) {
        return MiConfigSingleton.V3().l3().w0(sourceName + "_" + sourceId);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void m3(boolean loginDirectly) {
        MiConfigSingleton.V3().o2(this, loginDirectly ? 200 : 202);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void n3() {
        com.martian.mibook.lib.model.g.b.m0(this, "", "去好评");
        org.codechimp.apprater.b.m(new org.codechimp.apprater.e());
        org.codechimp.apprater.b.g(this);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void o3(String key, String value) {
        if (com.martian.libsupport.k.p(key) || com.martian.libsupport.k.p(value)) {
            return;
        }
        com.martian.mibook.lib.model.g.b.m0(this, key, value);
    }

    public void onActionMenuClick(View view) {
        if (w4()) {
            startActivity(IncomeActivity.class);
            IncomeActivity.w2(this, 0, "网页");
            return;
        }
        if (v4() && MiConfigSingleton.V3().k2(this)) {
            if (!x4()) {
                com.martian.mibook.lib.model.g.b.N(this, "网页-佣金提现");
                s2.X(this);
                return;
            }
            com.martian.mibook.lib.model.g.b.N(this, "网页-闲玩首页");
            MartianPlayxianAppwallParams martianPlayxianAppwallParams = new MartianPlayxianAppwallParams();
            martianPlayxianAppwallParams.setUid(Long.valueOf(Long.parseLong(MiConfigSingleton.V3().D4())));
            martianPlayxianAppwallParams.setToken(MiConfigSingleton.V3().C4().getToken());
            martianPlayxianAppwallParams.setPlatform("XIANWAN");
            f5(this, martianPlayxianAppwallParams.toHttpUrl("UTF8"));
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode != 10001 && requestCode != 200 && requestCode != 1021 && requestCode != 202) || resultCode != -1) {
            if (requestCode == 2 && resultCode == -1) {
                k1("分享成功");
                return;
            }
            return;
        }
        if (requestCode == 1021) {
            com.martian.mibook.lib.model.g.b.K(this, MiConfigSingleton.V3().T3("登录成功", requestCode));
            this.X.loadUrl("javascript:bonusModeResult(true)");
            k1("广告已打开，开始赚钱吧");
        } else {
            com.martian.mibook.lib.model.g.b.K(this, "登录成功-网页内登录");
            u4();
            this.X.reload();
        }
        com.martian.mibook.lib.account.e.c.l(this, null);
        com.martian.mibook.lib.account.e.c.k(this, null);
    }

    @Override // com.martian.mibook.lib.account.activity.MiWebViewBaseActivity, com.martian.libmars.activity.WebViewActivity, com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (w4()) {
            t2("查看收益");
            return;
        }
        if (v4()) {
            if (!x4()) {
                t2("提现");
            } else {
                t2("首页");
                Y4();
            }
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        DownLoadReceiver downLoadReceiver = this.l0;
        if (downLoadReceiver != null) {
            unregisterReceiver(downLoadReceiver);
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        T4();
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        S4();
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void p3(String position, String adsId, int reward, String rewardName, String rewardExtra) {
        d5(adsId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void p4(final int money, String productId, String extra) {
        f fVar = new f(this, money);
        ((CreatAliPrepayParams) fVar.k()).setMoney(Integer.valueOf(money));
        if (!com.martian.libsupport.k.p(productId)) {
            try {
                ((CreatAliPrepayParams) fVar.k()).setProductId(Integer.valueOf(Integer.parseInt(productId)));
            } catch (Exception unused) {
            }
        }
        if (!com.martian.libsupport.k.p(extra)) {
            ((CreatAliPrepayParams) fVar.k()).setExtra(extra);
        }
        fVar.j();
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void q3(String adsId) {
        a5(adsId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void q4(final int fee_value, String productId, String extra) {
        h hVar = new h(this);
        ((CreateWxPrepayParams) hVar.k()).setMoney(Integer.valueOf(fee_value));
        ((CreateWxPrepayParams) hVar.k()).setWx_appid(MiConfigSingleton.V3().W3().getRechargeWxAppid());
        if (!com.martian.libsupport.k.p(productId)) {
            try {
                ((CreateWxPrepayParams) hVar.k()).setProductId(Integer.valueOf(Integer.parseInt(productId)));
            } catch (Exception unused) {
            }
        }
        if (!com.martian.libsupport.k.p(extra)) {
            ((CreateWxPrepayParams) hVar.k()).setExtra(extra);
        }
        hVar.j();
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void r3(String adsId) {
        c5();
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void s3(String title, String extraBonus) {
        IntervalBonus intervalBonus;
        if (com.martian.libsupport.k.p(extraBonus) || (intervalBonus = (IntervalBonus) GsonUtils.b().fromJson(extraBonus, IntervalBonus.class)) == null) {
            return;
        }
        BonusDetailActivity.E3(this, title, intervalBonus.getMoney(), intervalBonus.getCoins().intValue(), intervalBonus.getCommission().intValue(), intervalBonus.getExtraId().longValue(), intervalBonus.getExtraCoins().intValue());
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void t3() {
        if (MiConfigSingleton.V3().n2(this)) {
            s2.n0(this, ShareImageUrlActivity.u(this, 0));
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void u3(final int coins, final String errMsg, final long extraId, final int extraCoins) {
        if (coins > 0 || !com.martian.libsupport.k.p(errMsg)) {
            m0.f().n(this, new BonusDetailActivity.h().l(Integer.valueOf(coins)).n(errMsg).p(Long.valueOf(extraId)).o(Integer.valueOf(extraCoins)), new k0.j() { // from class: com.martian.mibook.activity.base.e
                @Override // com.martian.libmars.utils.k0.j
                public final void a() {
                    MiWebViewActivity.this.B4(coins);
                }
            });
        } else {
            Z4(true);
        }
    }

    public void u4() {
        if (com.martian.libsupport.k.p(this.Z)) {
            return;
        }
        t4(this, this.Z);
        MTWebView mTWebView = this.X;
        if (mTWebView != null) {
            mTWebView.reload();
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void v3(String sourceName, String sourceId) {
        if (com.martian.libsupport.k.p(sourceName) || com.martian.libsupport.k.p(sourceId)) {
            return;
        }
        s2.T(this, sourceId, sourceName, "deeplink", "");
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void w3(String url, boolean fullscreen) {
        i5(this, url, false, "", false, "", fullscreen);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void x3(int money, int method, String productId, String extra) {
        if (MiConfigSingleton.V3().k2(this)) {
            if (method == 1) {
                p4(money, productId, extra);
            } else {
                q4(money, productId, extra);
            }
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void y3(String rechargeParams) {
        try {
            WebRechargeParams webRechargeParams = (WebRechargeParams) GsonUtils.b().fromJson(rechargeParams, WebRechargeParams.class);
            if (webRechargeParams != null) {
                x3(webRechargeParams.getMoney().intValue(), webRechargeParams.getMethod(), webRechargeParams.getProductId(), webRechargeParams.getExtra());
            } else {
                k1("数据解析出错");
            }
        } catch (Exception unused) {
            k1("数据解析出错");
        }
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    protected void z3(String info) {
        if (!MiConfigSingleton.V3().n2(this) || com.martian.libsupport.k.p(info)) {
            return;
        }
        final ShareInfo shareInfo = (ShareInfo) GsonUtils.b().fromJson(info, ShareInfo.class);
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.base.f
            @Override // java.lang.Runnable
            public final void run() {
                MiWebViewActivity.this.D4(shareInfo);
            }
        });
    }
}
