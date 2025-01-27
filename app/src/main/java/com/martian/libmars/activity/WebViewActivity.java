package com.martian.libmars.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.martian.libmars.R;
import com.martian.libmars.activity.WebViewActivity;
import com.martian.libmars.activity.h1;
import com.martian.libmars.ui.theme.VerticalSwipeRefreshLayout;
import com.martian.libmars.utils.k0;
import com.martian.libmars.utils.l0;
import com.martian.libmars.widget.MTWebView;
import com.martian.libsupport.data.HeightChangeParams;
import com.martian.libsupport.permission.TipInfo;
import com.martian.libxianplay.util.XianWanSystemUtil;
import com.martian.libxianplay.view.DownLoadService;
import com.martian.libxianplay.wowan.WowanDetailActivity;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes2.dex */
public class WebViewActivity extends k1 implements MTWebView.c {
    public static final String Q = "LIBMARS_INTENT_WEBVIEW_URL";
    public static final String R = "INTENT_WEBVIEW_SHARE_URL";
    public static final String S = "LIBMARS_INTENT_DOWNLOAD_HINT";
    public static final String T = "INTENT_SHAREABLE";
    public static final String U = "INTENT_FULLSCREEN";
    public static final String V = "INTENT_SHARE_IMAGE_URL";
    public static final String W = "INTENT_WEBVIEW_URL_REFERER";
    public MTWebView X;
    private VerticalSwipeRefreshLayout Y;
    public String Z;
    protected boolean a0;
    private boolean b0 = false;
    private String c0;
    protected ViewStub d0;
    protected ImageView e0;
    protected TextView f0;
    protected TextView g0;
    protected ImageView h0;
    public FrameLayout i0;
    private String j0;

    class a implements h1.a {

        /* renamed from: a */
        final /* synthetic */ ValueCallback f9736a;

        a(final ValueCallback val$callback) {
            this.f9736a = val$callback;
        }

        @Override // com.martian.libmars.activity.h1.a
        public void a(Uri imgUri, String filepath) {
            this.f9736a.onReceiveValue(imgUri);
        }

        @Override // com.martian.libmars.activity.h1.a
        public void onCancelled() {
            this.f9736a.onReceiveValue(null);
        }
    }

    class b implements k0.o {
        b() {
        }

        @Override // com.martian.libmars.utils.k0.o
        public void a() {
        }

        @Override // com.martian.libmars.utils.k0.o
        public void b() {
            WebViewActivity.this.R0(com.martian.libmars.d.h.F().w());
        }

        @Override // com.martian.libmars.utils.k0.o
        public void c() {
            WebViewActivity.this.S0();
        }
    }

    class c implements h1.a {

        /* renamed from: a */
        final /* synthetic */ ValueCallback f9739a;

        c(final ValueCallback val$uploadMsg) {
            this.f9739a = val$uploadMsg;
        }

        @Override // com.martian.libmars.activity.h1.a
        public void a(Uri imgUri, String filepath) {
            this.f9739a.onReceiveValue(new Uri[]{imgUri});
        }

        @Override // com.martian.libmars.activity.h1.a
        public void onCancelled() {
            this.f9739a.onReceiveValue(null);
        }
    }

    public static class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        private final MTWebView f9741a;

        /* renamed from: b */
        int f9742b;

        public d(MTWebView webView) {
            this.f9741a = webView;
            webView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.f9741a.getWindowVisibleDisplayFrame(rect);
            int i2 = rect.bottom - rect.top;
            if (this.f9742b == i2) {
                return;
            }
            Rect rect2 = new Rect();
            this.f9741a.getHitRect(rect2);
            int i3 = rect2.bottom - rect2.top;
            float f2 = 0.0f;
            int i4 = this.f9742b;
            if (i4 > 0 && i4 > i2) {
                f2 = ((i4 - i2) * 100.0f) / i3;
            }
            this.f9742b = i2;
            MTWebView mTWebView = this.f9741a;
            mTWebView.loadUrl(mTWebView.c(new HeightChangeParams().setRatio(f2)));
        }
    }

    public class e {

        class a implements com.martian.libsupport.permission.f {

            /* renamed from: a */
            final /* synthetic */ String f9744a;

            a(final String val$url) {
                this.f9744a = val$url;
            }

            @Override // com.martian.libsupport.permission.f
            public void permissionDenied() {
                WebViewActivity.this.k1("缺少存储权限");
            }

            @Override // com.martian.libsupport.permission.f
            public void permissionGranted() {
                WebViewActivity webViewActivity = WebViewActivity.this;
                webViewActivity.S2(this.f9744a, webViewActivity.j0);
            }
        }

        public e() {
        }

        /* renamed from: A */
        public /* synthetic */ void B(final String url) {
            if (com.martian.libsupport.k.p(url)) {
                return;
            }
            WowanDetailActivity.startWebViewActivity(WebViewActivity.this, url);
        }

        /* renamed from: C */
        public /* synthetic */ void D(final String position, final String adsId, final int reward, final String rewardName, final String rewardExtra) {
            WebViewActivity.this.p3(position, adsId, reward, rewardName, rewardExtra);
        }

        /* renamed from: E */
        public /* synthetic */ void F() {
            WebViewActivity.this.q3("");
        }

        /* renamed from: G */
        public /* synthetic */ void H(final String adsId) {
            WebViewActivity.this.q3(adsId);
        }

        /* renamed from: I */
        public /* synthetic */ void J(final String adsId) {
            WebViewActivity.this.r3(adsId);
        }

        /* renamed from: K */
        public /* synthetic */ void L() {
            WebViewActivity.this.r3("");
        }

        /* renamed from: M */
        public /* synthetic */ void N(final String title, final String extraBonus) {
            WebViewActivity.this.s3(title, extraBonus);
        }

        /* renamed from: O */
        public /* synthetic */ void P() {
            WebViewActivity.this.setResult(-1);
        }

        /* renamed from: Q */
        public /* synthetic */ void R(final int coins, final String errMsg, final long extraId, final int extraCoins) {
            WebViewActivity.this.u3(coins, errMsg, extraId, extraCoins);
        }

        /* renamed from: S */
        public /* synthetic */ void T() {
            InputMethodManager inputMethodManager = (InputMethodManager) WebViewActivity.this.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.toggleSoftInput(1, 2);
            }
        }

        /* renamed from: U */
        public /* synthetic */ void V(final String sourceName, final String sourceId) {
            WebViewActivity.this.v3(sourceName, sourceId);
        }

        /* renamed from: W */
        public /* synthetic */ void X(final String url, final boolean fullscreen) {
            WebViewActivity.this.w3(url, fullscreen);
        }

        /* renamed from: Y */
        public /* synthetic */ void Z(final int money, final int method) {
            WebViewActivity.this.x3(money, method, null, "");
        }

        /* renamed from: a */
        public /* synthetic */ void b(final String url) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            WebViewActivity.this.startActivity(intent);
        }

        /* renamed from: a0 */
        public /* synthetic */ void b0(final int money, final int method, final String productId) {
            WebViewActivity.this.x3(money, method, productId, "");
        }

        /* renamed from: c */
        public /* synthetic */ void d() {
            WebViewActivity.this.X.loadUrl("javascript:CheckInstall_Return(1)");
        }

        /* renamed from: c0 */
        public /* synthetic */ void d0(final String rechargeParams) {
            WebViewActivity.this.y3(rechargeParams);
        }

        /* renamed from: e */
        public /* synthetic */ void f() {
            WebViewActivity.this.X.loadUrl("javascript:CheckInstall_Return(0)");
        }

        /* renamed from: e0 */
        public /* synthetic */ void f0(final String info) {
            WebViewActivity.this.z3(info);
        }

        /* renamed from: g */
        public /* synthetic */ void h(final String url) {
            WebViewActivity.this.j0 = url.substring(url.lastIndexOf("/") + 1);
            if (!WebViewActivity.this.j0.contains(".apk")) {
                if (WebViewActivity.this.j0.length() > 10) {
                    WebViewActivity webViewActivity = WebViewActivity.this;
                    webViewActivity.j0 = webViewActivity.j0.substring(WebViewActivity.this.j0.length() - 10);
                }
                WebViewActivity.this.j0 = WebViewActivity.this.j0 + ".apk";
            }
            com.martian.libsupport.permission.g.h(WebViewActivity.this, new a(url), new String[]{com.kuaishou.weapon.p0.g.f9325j}, true, new TipInfo("权限申请", "需要存储权限才能正常使用下载功能\n \n 请点击 \"前往开启\"-\"权限管理\"-打开所需权限。", "取消", "前往开启"), true);
        }

        /* renamed from: g0 */
        public /* synthetic */ void h0(final int style) {
            WebViewActivity.this.f4(style);
        }

        /* renamed from: i */
        public /* synthetic */ void j(final String packageName) {
            WebViewActivity.this.b4(packageName);
        }

        /* renamed from: i0 */
        public /* synthetic */ void j0(final String wxAppid) {
            WebViewActivity.this.A3(wxAppid);
        }

        /* renamed from: k */
        public /* synthetic */ void l(final String sourceName, final String sourceId, final String recommendId, final String recommend) {
            WebViewActivity.this.b3(sourceName, sourceId, recommendId, recommend);
        }

        /* renamed from: m */
        public /* synthetic */ void n(final boolean open) {
            WebViewActivity.this.d3(open);
        }

        /* renamed from: o */
        public /* synthetic */ void p(final String position, final String adsId, final int reward, final String rewardName, final String rewardExtra) {
            WebViewActivity.this.e3(position, adsId, reward, rewardName, rewardExtra);
        }

        /* renamed from: q */
        public /* synthetic */ void r() {
            WebViewActivity.this.m3(false);
        }

        /* renamed from: s */
        public /* synthetic */ void t(final boolean loginDirectly) {
            WebViewActivity.this.m3(loginDirectly);
        }

        /* renamed from: u */
        public /* synthetic */ void v() {
            WebViewActivity.this.setResult(-1);
        }

        /* renamed from: w */
        public /* synthetic */ void x() {
            WebViewActivity.this.onBackClick(null);
        }

        /* renamed from: y */
        public /* synthetic */ void z(final String key, final String value) {
            WebViewActivity.this.o3(key, value);
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public void Browser(final String url) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.f0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.b(url);
                }
            });
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public void CheckInstall(String packageName) {
            if (XianWanSystemUtil.isApkInstalled(WebViewActivity.this, packageName)) {
                WebViewActivity.this.X.post(new Runnable() { // from class: com.martian.libmars.activity.k0
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewActivity.e.this.d();
                    }
                });
            } else {
                WebViewActivity.this.X.post(new Runnable() { // from class: com.martian.libmars.activity.q0
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewActivity.e.this.f();
                    }
                });
            }
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public void InstallAPP(final String url) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.g0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.h(url);
                }
            });
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public void OpenAPP(final String packageName) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.p0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.j(packageName);
                }
            });
        }

        @JavascriptInterface
        public void addToBookStore(final String sourceName, final String sourceId, final String recommendId, final String recommend) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.x
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.l(sourceName, sourceId, recommendId, recommend);
                }
            });
        }

        @JavascriptInterface
        public boolean appInstalled(String packageName) {
            return (com.martian.libsupport.k.p(packageName) || WebViewActivity.this.getPackageManager().getLaunchIntentForPackage(packageName) == null) ? false : true;
        }

        @JavascriptInterface
        public void bonusMode(final boolean open) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.e0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.n(open);
                }
            });
        }

        @JavascriptInterface
        public void cacheVideoAd(final String position, final String adsId, final int reward, final String rewardName, final String rewardExtra) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.b0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.p(position, adsId, reward, rewardName, rewardExtra);
                }
            });
        }

        @JavascriptInterface
        public void exitWeb() {
            final WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.z0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.finish();
                }
            });
        }

        @JavascriptInterface
        public void goNotificationSetting() {
            final WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.c1
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.f3();
                }
            });
        }

        @JavascriptInterface
        public void inviteQqfriend() {
            final WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.a
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.g3();
                }
            });
        }

        @JavascriptInterface
        public void inviteQrcode() {
            final WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.g
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.h3();
                }
            });
        }

        @JavascriptInterface
        public void inviteQzone() {
            final WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.b1
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.i3();
                }
            });
        }

        @JavascriptInterface
        public void inviteWxcircle() {
            final WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.d
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.j3();
                }
            });
        }

        @JavascriptInterface
        public void inviteWxfriend() {
            final WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.b
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.k3();
                }
            });
        }

        @JavascriptInterface
        public boolean isInBookStore(String sourceName, String sourceId) {
            return WebViewActivity.this.l3(sourceName, sourceId);
        }

        @JavascriptInterface
        public void loginClick() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.h0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.r();
                }
            });
        }

        @JavascriptInterface
        public void loginClickV2(final boolean loginDirectly) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.a0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.t(loginDirectly);
                }
            });
        }

        @JavascriptInterface
        public void logout() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.c0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.v();
                }
            });
        }

        @JavascriptInterface
        public void marketRate() {
            final WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.e1
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.n3();
                }
            });
        }

        @JavascriptInterface
        public void onBackClick() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.s
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.x();
                }
            });
        }

        @JavascriptInterface
        public void onEvent(final String key, final String value) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.n0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.z(key, value);
                }
            });
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public void openAdDetail(final String url) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.i0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.B(url);
                }
            });
        }

        @JavascriptInterface
        public void playCallbackRewardVideoAd(final String position, final String adsId, final int reward, final String rewardName, final String rewardExtra) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.m0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.D(position, adsId, reward, rewardName, rewardExtra);
                }
            });
        }

        @JavascriptInterface
        public void playInteractionAd() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.j0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.F();
                }
            });
        }

        @JavascriptInterface
        public void playRewardVideoAd() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.w
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.L();
                }
            });
        }

        @JavascriptInterface
        public void rewardDetail(final String title, final String extraBonus) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.o0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.N(title, extraBonus);
                }
            });
        }

        @JavascriptInterface
        public void setResultOk() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.q
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.P();
                }
            });
        }

        @JavascriptInterface
        public void shareClick() {
            final WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.a1
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.t3();
                }
            });
        }

        @JavascriptInterface
        public void showBonusDialog(final int coins, final String errMsg, final long extraId, final int extraCoins) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.l0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.R(coins, errMsg, extraId, extraCoins);
                }
            });
        }

        @JavascriptInterface
        public void showSoftKeyboard() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.y
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.T();
                }
            });
        }

        @JavascriptInterface
        public void startBookDetailActivity(final String sourceName, final String sourceId) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.t
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.V(sourceName, sourceId);
                }
            });
        }

        @JavascriptInterface
        public void startNewActivity(final String url, final boolean fullscreen) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.v
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.X(url, fullscreen);
                }
            });
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public void startRecharge(final int money, final int method) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.z
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.Z(money, method);
                }
            });
        }

        @JavascriptInterface
        public void startRechargeV2(final int money, final int method, final String productId) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.d0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.b0(money, method, productId);
                }
            });
        }

        @JavascriptInterface
        public void startRechargeV3(final String rechargeParams) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.u
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.d0(rechargeParams);
                }
            });
        }

        @JavascriptInterface
        public void startShare(final String info) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.u0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.f0(info);
                }
            });
        }

        @JavascriptInterface
        public void statusBarStyle(final int style) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.s0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.h0(style);
                }
            });
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public String toString() {
            return BaseWrapper.BASE_PKG_SYSTEM;
        }

        @JavascriptInterface
        public void wxBindV2(final String wxAppid) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.r
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.j0(wxAppid);
                }
            });
        }

        @JavascriptInterface
        public void playInteractionAd(final String adsId) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.r0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.H(adsId);
                }
            });
        }

        @JavascriptInterface
        public void playRewardVideoAd(final String adsId) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.t0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.J(adsId);
                }
            });
        }
    }

    private void B3() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:com.android.providers.downloads"));
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    /* renamed from: C3 */
    public /* synthetic */ void D3(final String url, DialogInterface dialog, int which) {
        k1("开始下载");
        DownLoadService.startActionFoo(this, url);
    }

    static /* synthetic */ void E3(DialogInterface dialog, int which) {
    }

    /* renamed from: F3 */
    public /* synthetic */ void G3() {
        this.X.loadUrl("javascript:autoLotteryDraw()");
    }

    /* renamed from: J3 */
    public /* synthetic */ void K3() {
        k1("保存失败");
    }

    /* renamed from: L3 */
    public /* synthetic */ boolean M3(View v) {
        if (com.martian.libmars.d.h.F().F0() || !com.martian.libmars.d.h.F().h1()) {
            return true;
        }
        WebView.HitTestResult hitTestResult = this.X.getHitTestResult();
        if (hitTestResult == null || hitTestResult.getType() != 5) {
            return false;
        }
        Y3(hitTestResult.getExtra());
        return false;
    }

    /* renamed from: N3 */
    public /* synthetic */ void O3() {
        MTWebView mTWebView = this.X;
        mTWebView.loadUrl(mTWebView.getUrl());
    }

    /* renamed from: P3 */
    public /* synthetic */ void Q3() {
        I2(false);
        f4(-1);
    }

    private boolean R2() {
        try {
            int applicationEnabledSetting = getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
            return (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) ? false : true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: R3 */
    public /* synthetic */ void S3(String name, String url1) {
        k1("已开始下载" + name);
    }

    public void S2(final String url, String apkName) {
        boolean z;
        Cursor query = ((DownloadManager) getSystemService("download")).query(new DownloadManager.Query());
        while (true) {
            z = false;
            if (!query.moveToNext()) {
                break;
            }
            if (url.equals(query.getString(query.getColumnIndex("uri")))) {
                int i2 = query.getInt(query.getColumnIndex("status"));
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 4) {
                            if (i2 == 8) {
                                com.martian.libmars.utils.q0.f("DownLoadService", ">>>下载完成");
                                StringBuilder sb = new StringBuilder();
                                sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                                String str = File.separator;
                                sb.append(str);
                                sb.append("51xianwan");
                                sb.append(str);
                                sb.append(apkName);
                                File file = new File(sb.toString());
                                if (file.exists()) {
                                    Z2(file, apkName);
                                }
                            } else if (i2 == 16) {
                                Log.i("DownLoadService", ">>>下载失败");
                            }
                            z = true;
                        } else {
                            com.martian.libmars.utils.q0.f("DownLoadService", ">>>下载暂停");
                        }
                    }
                    Toast.makeText(this, "正在下载，已完成" + ((int) ((query.getInt(query.getColumnIndex("bytes_so_far")) * 100) / query.getInt(query.getColumnIndex("total_size")))) + "%", 0).show();
                    com.martian.libmars.utils.q0.f("DownLoadService", ">>>正在下载");
                    z = true;
                }
                com.martian.libmars.utils.q0.f("DownLoadService", ">>>下载延迟");
                Toast.makeText(this, "正在下载，已完成" + ((int) ((query.getInt(query.getColumnIndex("bytes_so_far")) * 100) / query.getInt(query.getColumnIndex("total_size")))) + "%", 0).show();
                com.martian.libmars.utils.q0.f("DownLoadService", ">>>正在下载");
                z = true;
            }
        }
        query.close();
        if (z) {
            return;
        }
        if (!R2()) {
            B3();
            return;
        }
        XianWanSystemUtil.NetState netWorkType = XianWanSystemUtil.getNetWorkType(getApplicationContext());
        if (netWorkType == XianWanSystemUtil.NetState.NET_NO) {
            k1("现在还没有网哦！");
            return;
        }
        if (netWorkType == XianWanSystemUtil.NetState.NET_MOBILE) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("温馨提醒");
            builder.setMessage("您现在使用的是非WiFi流量,是否继续?");
            builder.setPositiveButton("继续下载", new DialogInterface.OnClickListener() { // from class: com.martian.libmars.activity.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    WebViewActivity.this.D3(url, dialogInterface, i3);
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.martian.libmars.activity.v0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    WebViewActivity.E3(dialogInterface, i3);
                }
            });
            builder.show();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("51xianwan");
        sb2.append(str2);
        sb2.append(apkName);
        new File(sb2.toString());
        k1("开始下载");
        DownLoadService.startActionFoo(this, url);
    }

    private void T2(String filePath, String apkName) {
        Z2(new File(filePath), apkName);
    }

    public static String V2(String url) {
        String str;
        if (url.isEmpty()) {
            return "";
        }
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        try {
            str = new URI(url).getHost();
        } catch (Exception unused) {
            str = "";
        }
        return (str.endsWith(".html") || str.endsWith(".htm")) ? "" : str;
    }

    /* renamed from: V3 */
    public /* synthetic */ void W3(final String url) {
        try {
            URLConnection openConnection = new URL(url).openConnection();
            int contentLength = ((HttpURLConnection) openConnection).getContentLength();
            openConnection.connect();
            InputStream inputStream = openConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, contentLength);
            final Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream);
            bufferedInputStream.close();
            inputStream.close();
            if (decodeStream != null) {
                runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewActivity.this.I3(decodeStream);
                    }
                });
            }
        } catch (Exception e2) {
            runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.n
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.K3();
                }
            });
            e2.printStackTrace();
        }
    }

    private boolean X3(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return true;
        }
        String scheme = intent.getData().getScheme();
        if (com.martian.libsupport.k.p(scheme)) {
            return true;
        }
        return (scheme.equalsIgnoreCase("ttbook") || scheme.equalsIgnoreCase("tfbook") || scheme.equalsIgnoreCase("qmbook")) ? false : true;
    }

    private void Y3(final String url) {
        if (com.martian.libsupport.k.p(url)) {
            return;
        }
        com.martian.libmars.utils.k0.P(this, "确认信息", "保存这张图片？", new k0.l() { // from class: com.martian.libmars.activity.l
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                WebViewActivity.this.U3(url);
            }
        });
    }

    public void b4(String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return;
        }
        PackageManager packageManager = getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        if (packageInfo == null) {
            return;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage == null) {
            Toast.makeText(this, "手机还未安装该应用", 0).show();
            return;
        }
        launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        launchIntentForPackage.setFlags(270532608);
        startActivity(launchIntentForPackage);
    }

    public static void c4(Activity activity, String url, boolean downloadHint) {
        com.martian.libmars.utils.q0.e(url);
        Bundle bundle = new Bundle();
        bundle.putString(Q, url);
        bundle.putBoolean(S, downloadHint);
        Intent intent = new Intent(activity, (Class<?>) WebViewActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void d4(j1 activity, String url, boolean downloadHint, int requestCode) {
        Bundle bundle = new Bundle();
        bundle.putString(Q, url);
        bundle.putBoolean(S, downloadHint);
        activity.startActivityForResult(WebViewActivity.class, bundle, requestCode);
    }

    public void f4(final int style) {
        if (style == 2 || (style < 0 && this.Z.contains("statusBarStyle=2"))) {
            ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_STATUS_BAR).init();
            return;
        }
        ImmersionBar with = ImmersionBar.with(this);
        boolean z = true;
        if (style != 1 && (style >= 0 || !this.Z.contains("statusBarStyle=1"))) {
            z = false;
        }
        with.statusBarDarkFont(z).init();
    }

    protected void A3(String wxAppid) {
    }

    public void U2(String url) {
    }

    public MTWebView W2() {
        return this.X;
    }

    public String X2() {
        return this.Z;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    protected void Y2() {
        e eVar = new e();
        if (com.martian.libsupport.l.n()) {
            this.X.addJavascriptInterface(eVar, eVar.toString());
        }
    }

    protected void Z2(File file, String apkName) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri z = com.martian.libsupport.e.z(this, file);
        if (z == null) {
            return;
        }
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        int i2 = getApplicationInfo().targetSdkVersion;
        if (com.martian.libsupport.l.u() && i2 >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(z, AdBaseConstants.MIME_APK);
        startActivity(intent);
    }

    /* renamed from: Z3, reason: merged with bridge method [inline-methods] */
    public void I3(Bitmap bmp) {
        File file = new File(Environment.getExternalStorageDirectory(), "Boohee");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, System.currentTimeMillis() + ".jpg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            k1("图片已保存到相册");
        } catch (FileNotFoundException e2) {
            k1("保存失败");
            e2.printStackTrace();
        } catch (IOException e3) {
            k1("保存失败");
            e3.printStackTrace();
        }
        sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getAbsolutePath())));
    }

    protected boolean a3() {
        return this.b0 || this.Z.contains("hideNaviBar=1");
    }

    public void a4(boolean enable) {
        this.Y.setEnabled(enable);
    }

    protected void b3(String sourceName, String sourceId, String recommendId, String recommend) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void c(WebView view, String title) {
        Z1(title);
        if (this.f0 == null || this.g0 == null) {
            return;
        }
        if (a3()) {
            this.g0.setAlpha(0.0f);
        } else if (this.X.canGoBack()) {
            this.f0.setText(title);
            this.g0.setAlpha(0.0f);
        } else {
            this.g0.setText(title);
            this.g0.setAlpha(1.0f);
        }
    }

    public void c3() {
        runOnUiThread(new Runnable() { // from class: com.martian.libmars.activity.k
            @Override // java.lang.Runnable
            public final void run() {
                WebViewActivity.this.G3();
            }
        });
    }

    protected void d3(final boolean open) {
    }

    protected void e3(String position, String adsId, int reward, String rewardName, String rewardExtra) {
    }

    protected void e4() {
        ViewStub viewStub = this.d0;
        if (viewStub != null) {
            viewStub.setVisibility((a3() || !this.X.canGoBack()) ? 8 : 0);
        }
    }

    protected void f3() {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void g(String url) {
        U2(url);
    }

    protected void g3() {
    }

    /* renamed from: g4, reason: merged with bridge method [inline-methods] */
    public void U3(final String url) {
        new Thread(new Runnable() { // from class: com.martian.libmars.activity.w0
            @Override // java.lang.Runnable
            public final void run() {
                WebViewActivity.this.W3(url);
            }
        }).start();
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void h(WebView view, String deeplink, boolean canHandle) {
    }

    protected void h3() {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public boolean i(WebView view, String url, String message) {
        return false;
    }

    protected void i3() {
    }

    protected void j3() {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void k(String url, String contentDisposition, String mimetype) {
        com.martian.libmars.utils.l0.f(this, url, contentDisposition, mimetype, new l0.a() { // from class: com.martian.libmars.activity.y0
            @Override // com.martian.libmars.utils.l0.a
            public final void a(String str, String str2) {
                WebViewActivity.this.S3(str, str2);
            }
        }, this.a0);
    }

    protected void k3() {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void l(int errorCode, String description, String failingUrl) {
        this.Y.setRefreshing(false);
    }

    protected boolean l3(String sourceName, String sourceId) {
        return false;
    }

    protected void m3(boolean loginDirectly) {
    }

    @Override // com.martian.libmars.activity.k1
    public void n2() {
    }

    protected void n3() {
    }

    protected void o3(String key, String value) {
    }

    @Override // com.martian.libmars.activity.k1
    public void onBackClick(View view) {
        MTWebView mTWebView = this.X;
        if (mTWebView == null || !mTWebView.canGoBack()) {
            finish();
        } else {
            this.X.goBack();
        }
    }

    public void onCloseClick(View view) {
        finish();
    }

    @Override // com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.libmars_webview_activity);
        C2(false);
        H2(true);
        MTWebView mTWebView = (MTWebView) findViewById(R.id.libmars_webview);
        this.X = mTWebView;
        mTWebView.setOnPageStateChangedListener(this);
        this.X.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.libmars.activity.m
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return WebViewActivity.this.M3(view);
            }
        });
        new d(this.X);
        Y2();
        VerticalSwipeRefreshLayout verticalSwipeRefreshLayout = (VerticalSwipeRefreshLayout) findViewById(R.id.swipe_container);
        this.Y = verticalSwipeRefreshLayout;
        verticalSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        this.Y.setRefreshing(true);
        this.Y.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.martian.libmars.activity.x0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                WebViewActivity.this.O3();
            }
        });
        this.i0 = (FrameLayout) findViewById(R.id.banner_ads);
        if (savedInstanceState != null) {
            this.Z = savedInstanceState.getString(Q);
            this.a0 = savedInstanceState.getBoolean(S, true);
            this.c0 = savedInstanceState.getString(W);
            this.b0 = savedInstanceState.getBoolean(U, false);
        } else {
            this.Z = G0(Q);
            this.a0 = r0(S, true);
            this.c0 = G0(W);
            this.b0 = r0(U, false);
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.actionbar_container);
        this.d0 = viewStub;
        viewStub.setLayoutResource(R.layout.layout_webview_actionbar);
        this.d0.setVisibility(0);
        this.d0.setVisibility(8);
        this.e0 = (ImageView) findViewById(R.id.actionbar_webview_close);
        this.f0 = (TextView) findViewById(R.id.actionbar_webview_title);
        this.g0 = (TextView) findViewById(R.id.actionbar_title);
        this.h0 = (ImageView) findViewById(R.id.actionbar_back);
        if (TextUtils.isEmpty(this.Z)) {
            k1("无效的URL");
            finish();
            return;
        }
        if (com.martian.libsupport.k.p(this.c0)) {
            this.X.loadUrl(this.Z);
        }
        if (a3()) {
            z2();
            new Handler().post(new Runnable() { // from class: com.martian.libmars.activity.p
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.Q3();
                }
            });
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MTWebView mTWebView = this.X;
        if (mTWebView != null) {
            mTWebView.destroy();
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !this.X.canGoBack()) {
            return super.onKeyDown(keyCode, event);
        }
        this.X.goBack();
        return true;
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void onPageFinished(String url) {
        this.Y.setRefreshing(false);
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.X.saveState(outState);
        outState.putString(Q, this.Z);
        outState.putBoolean(S, this.a0);
        outState.putString(W, this.c0);
        outState.putBoolean(U, this.b0);
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        this.Y.setEnabled(this.X.getScrollY() == 0);
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void p(WebView view, int newProgress) {
        if (newProgress == 100) {
            e4();
        }
    }

    protected void p3(String position, String adsId, int reward, String rewardName, String rewardExtra) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void q(String url, Bitmap favicon) {
        if (this.Y.isRefreshing()) {
            return;
        }
        this.Y.setRefreshing(true);
    }

    protected void q3(final String adsId) {
    }

    protected void r3(String adsId) {
    }

    protected void s3(String title, String extraBonus) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (com.martian.libsupport.k.p(url) || !url.contains("playmy") || !url.contains("Wall_Adinfo")) {
            return false;
        }
        WowanDetailActivity.startWebViewActivity(this, url);
        return true;
    }

    @Override // com.martian.libmars.activity.h1
    public void startActivityForResult(Class<? extends Activity> clazz, Bundle bundle, int requestCode) {
        if (com.martian.libmars.d.h.F().h1()) {
            super.startActivityForResult(clazz, bundle, requestCode);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        if (com.martian.libmars.d.h.F().h1()) {
            super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
        }
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void t(final ValueCallback<Uri> callback, String acceptType, String capture) {
        b1(new a(callback));
        com.martian.libmars.utils.k0.X(this, "选择图片", "从相册选择", "拍照选择", false, new b());
    }

    protected void t3() {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void u(WebView webView, final ValueCallback<Uri[]> uploadMsg, WebChromeClient.FileChooserParams fileChooserParams) {
        b1(new c(uploadMsg));
        S0();
    }

    protected void u3(int coins, String errMsg, long extraId, int extraCoins) {
    }

    protected void v3(String sourceName, String sourceId) {
    }

    protected void w3(String url, boolean fullscreen) {
    }

    protected void x3(int money, int method, String productId, String extra) {
    }

    protected void y3(String rechargeParams) {
    }

    protected void z3(String info) {
    }

    @Override // com.martian.libmars.activity.h1
    public void startActivityForResult(Class<? extends Activity> clazz, int requestCode) {
        if (com.martian.libmars.d.h.F().h1()) {
            super.startActivityForResult(clazz, requestCode);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {
        if (com.martian.libmars.d.h.F().h1()) {
            super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int requestCode) {
        if (com.martian.libmars.d.h.F().h1() || !X3(intent)) {
            super.startActivityForResult(intent, requestCode);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        if (com.martian.libmars.d.h.F().h1() || !X3(intent)) {
            super.startActivityForResult(intent, requestCode, options);
        }
    }
}
