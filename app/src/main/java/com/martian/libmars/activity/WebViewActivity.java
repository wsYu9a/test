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
import android.text.TextUtils;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ba.g;
import ba.l;
import ba.m;
import com.gyf.immersionbar.BarHide;
import com.martian.libmars.R;
import com.martian.libmars.activity.BaseActivity;
import com.martian.libmars.activity.WebViewActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.databinding.LayoutWebviewActionbarBinding;
import com.martian.libmars.ui.theme.VerticalSwipeRefreshLayout;
import com.martian.libmars.widget.MTWebView;
import com.martian.libsupport.data.HeightChangeParams;
import com.martian.libxianplay.util.XianWanSystemUtil;
import com.martian.libxianplay.view.DownLoadService;
import com.martian.libxianplay.wowan.WowanDetailActivity;
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
import java.util.Objects;
import l9.i0;
import l9.k0;
import l9.t0;

/* loaded from: classes3.dex */
public class WebViewActivity extends RetryLoadingActivity implements MTWebView.c {
    public static final String V = "LIBMARS_INTENT_WEBVIEW_URL";
    public static final String W = "INTENT_WEBVIEW_FINISH_AFTER_LOAD";
    public static final String X = "INTENT_WEBVIEW_SHARE_URL";
    public static final String Y = "LIBMARS_INTENT_DOWNLOAD_HINT";
    public static final String Z = "INTENT_SHAREABLE";

    /* renamed from: a0 */
    public static final String f12064a0 = "INTENT_FULLSCREEN";

    /* renamed from: b0 */
    public static final String f12065b0 = "INTENT_SHARE_IMAGE_URL";

    /* renamed from: c0 */
    public static final String f12066c0 = "INTENT_WEBVIEW_URL_REFERER";
    public MTWebView L;
    public VerticalSwipeRefreshLayout M;
    public String N;
    public boolean O;
    public boolean P = false;
    public String Q;
    public LayoutWebviewActionbarBinding R;
    public FrameLayout S;
    public boolean T;
    public String U;

    public class a implements BaseActivity.a {

        /* renamed from: a */
        public final /* synthetic */ ValueCallback f12067a;

        public a(ValueCallback valueCallback) {
            this.f12067a = valueCallback;
        }

        @Override // com.martian.libmars.activity.BaseActivity.a
        public void a(Uri uri, String str) {
            this.f12067a.onReceiveValue(uri);
        }

        @Override // com.martian.libmars.activity.BaseActivity.a
        public void onCancelled() {
            this.f12067a.onReceiveValue(null);
        }
    }

    public class b implements i0.o {

        /* renamed from: a */
        public final /* synthetic */ ValueCallback f12069a;

        public b(ValueCallback valueCallback) {
            this.f12069a = valueCallback;
        }

        @Override // l9.i0.o
        public void a() {
        }

        @Override // l9.i0.o
        public void b() {
            WebViewActivity.this.x1(ba.b.d(), this.f12069a);
        }

        @Override // l9.i0.o
        public void c() {
            WebViewActivity.this.y1(this.f12069a);
        }
    }

    public class c implements BaseActivity.a {

        /* renamed from: a */
        public final /* synthetic */ ValueCallback f12071a;

        public c(ValueCallback valueCallback) {
            this.f12071a = valueCallback;
        }

        @Override // com.martian.libmars.activity.BaseActivity.a
        public void a(Uri uri, String str) {
            this.f12071a.onReceiveValue(new Uri[]{uri});
        }

        @Override // com.martian.libmars.activity.BaseActivity.a
        public void onCancelled() {
            this.f12071a.onReceiveValue(null);
        }
    }

    public static class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b */
        public final MTWebView f12073b;

        /* renamed from: c */
        public int f12074c;

        public d(MTWebView mTWebView) {
            this.f12073b = mTWebView;
            mTWebView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.f12073b.getWindowVisibleDisplayFrame(rect);
            int i10 = rect.bottom - rect.top;
            if (this.f12074c == i10) {
                return;
            }
            Rect rect2 = new Rect();
            this.f12073b.getHitRect(rect2);
            int i11 = rect2.bottom - rect2.top;
            int i12 = this.f12074c;
            float f10 = (i12 <= 0 || i12 <= i10) ? 0.0f : ((i12 - i10) * 100.0f) / i11;
            this.f12074c = i10;
            MTWebView mTWebView = this.f12073b;
            mTWebView.loadUrl(mTWebView.d(new HeightChangeParams().setRatio(f10)));
        }
    }

    public class e {
        public e() {
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public void Browser(String str) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.c0

                /* renamed from: c */
                public final /* synthetic */ String f25301c;

                public /* synthetic */ c0(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.H(str);
                }
            });
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public void CheckInstall(String str) {
            if (XianWanSystemUtil.isApkInstalled(WebViewActivity.this, str)) {
                WebViewActivity.this.L.post(new Runnable() { // from class: d9.b1
                    public /* synthetic */ b1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewActivity.e.this.I();
                    }
                });
            } else {
                WebViewActivity.this.L.post(new Runnable() { // from class: d9.c1
                    public /* synthetic */ c1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewActivity.e.this.J();
                    }
                });
            }
        }

        public final /* synthetic */ void H(String str) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            WebViewActivity.this.startActivity(intent);
        }

        public final /* synthetic */ void I() {
            WebViewActivity.this.L.loadUrl("javascript:CheckInstall_Return(1)");
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public void InstallAPP(String str) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.x0

                /* renamed from: c */
                public final /* synthetic */ String f25395c;

                public /* synthetic */ x0(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.K(str);
                }
            });
        }

        public final /* synthetic */ void J() {
            WebViewActivity.this.L.loadUrl("javascript:CheckInstall_Return(0)");
        }

        public final /* synthetic */ void K(String str) {
            int lastIndexOf = str.lastIndexOf("/") + 1;
            WebViewActivity.this.U = str.substring(lastIndexOf);
            if (!WebViewActivity.this.U.contains(".apk")) {
                if (WebViewActivity.this.U.length() > 10) {
                    WebViewActivity webViewActivity = WebViewActivity.this;
                    webViewActivity.U = webViewActivity.U.substring(WebViewActivity.this.U.length() - 10);
                }
                StringBuilder sb2 = new StringBuilder();
                WebViewActivity webViewActivity2 = WebViewActivity.this;
                sb2.append(webViewActivity2.U);
                sb2.append(".apk");
                webViewActivity2.U = sb2.toString();
            }
            WebViewActivity webViewActivity3 = WebViewActivity.this;
            webViewActivity3.y3(str, webViewActivity3.U);
        }

        public final /* synthetic */ void L(String str) {
            WebViewActivity.this.z4(str);
        }

        public final /* synthetic */ void M(String str, String str2, String str3, String str4) {
            WebViewActivity.this.E3(str, str2, str3, str4);
        }

        public final /* synthetic */ void N(boolean z10) {
            WebViewActivity.this.G3(z10);
        }

        public final /* synthetic */ void O(String str, String str2, int i10, String str3, String str4) {
            WebViewActivity.this.H3(str, str2, i10, str3, str4);
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public void OpenAPP(String str) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.o0

                /* renamed from: c */
                public final /* synthetic */ String f25374c;

                public /* synthetic */ o0(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.L(str);
                }
            });
        }

        public final /* synthetic */ void P() {
            WebViewActivity.this.P3(false);
        }

        public final /* synthetic */ void Q(boolean z10) {
            WebViewActivity.this.P3(z10);
        }

        public final /* synthetic */ void R() {
            WebViewActivity.this.setResult(-1);
        }

        public final /* synthetic */ void S() {
            WebViewActivity.this.onBackClick(null);
        }

        public final /* synthetic */ void T(String str, String str2) {
            WebViewActivity.this.R3(str, str2);
        }

        public final /* synthetic */ void U(String str) {
            if (l.q(str)) {
                return;
            }
            WowanDetailActivity.startWebViewActivity(WebViewActivity.this, str);
        }

        public final /* synthetic */ void V(String str, String str2, int i10, String str3, String str4) {
            WebViewActivity.this.S3(str, str2, i10, str3, str4);
        }

        public final /* synthetic */ void W() {
            WebViewActivity.this.T3("");
        }

        public final /* synthetic */ void X(String str) {
            WebViewActivity.this.T3(str);
        }

        public final /* synthetic */ void Y(String str) {
            WebViewActivity.this.U3(str);
        }

        public final /* synthetic */ void Z() {
            WebViewActivity.this.U3("");
        }

        public final /* synthetic */ void a0(String str, String str2) {
            WebViewActivity.this.V3(str, str2);
        }

        @JavascriptInterface
        public void addToBookStore(String str, String str2, String str3, String str4) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.g0

                /* renamed from: c */
                public final /* synthetic */ String f25325c;

                /* renamed from: d */
                public final /* synthetic */ String f25326d;

                /* renamed from: e */
                public final /* synthetic */ String f25327e;

                /* renamed from: f */
                public final /* synthetic */ String f25328f;

                public /* synthetic */ g0(String str5, String str22, String str32, String str42) {
                    str = str5;
                    str2 = str22;
                    str3 = str32;
                    str4 = str42;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.M(str, str2, str3, str4);
                }
            });
        }

        @JavascriptInterface
        public boolean appInstalled(String str) {
            return (l.q(str) || WebViewActivity.this.getPackageManager().getLaunchIntentForPackage(str) == null) ? false : true;
        }

        public final /* synthetic */ void b0() {
            WebViewActivity.this.setResult(-1);
        }

        @JavascriptInterface
        public void bonusMode(boolean z10) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.j0

                /* renamed from: c */
                public final /* synthetic */ boolean f25343c;

                public /* synthetic */ j0(boolean z102) {
                    z10 = z102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.N(z10);
                }
            });
        }

        public final /* synthetic */ void c0(int i10, String str, long j10, int i11) {
            WebViewActivity.this.X3(i10, str, j10, i11);
        }

        @JavascriptInterface
        public void cacheVideoAd(String str, String str2, int i10, String str3, String str4) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.e0

                /* renamed from: c */
                public final /* synthetic */ String f25309c;

                /* renamed from: d */
                public final /* synthetic */ String f25310d;

                /* renamed from: e */
                public final /* synthetic */ int f25311e;

                /* renamed from: f */
                public final /* synthetic */ String f25312f;

                /* renamed from: g */
                public final /* synthetic */ String f25313g;

                public /* synthetic */ e0(String str5, String str22, int i102, String str32, String str42) {
                    str = str5;
                    str2 = str22;
                    i10 = i102;
                    str3 = str32;
                    str4 = str42;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.O(str, str2, i10, str3, str4);
                }
            });
        }

        public final /* synthetic */ void d0() {
            InputMethodManager inputMethodManager = (InputMethodManager) WebViewActivity.this.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.toggleSoftInput(1, 2);
            }
        }

        public final /* synthetic */ void e0(String str, String str2) {
            WebViewActivity.this.Y3(str, str2);
        }

        @JavascriptInterface
        public void exitWeb() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: d9.a0
                public /* synthetic */ a0() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.finish();
                }
            });
        }

        public final /* synthetic */ void f0(String str, boolean z10) {
            WebViewActivity.this.Z3(str, z10);
        }

        public final /* synthetic */ void g0(int i10, int i11) {
            WebViewActivity.this.a4(i10, i11, null, "");
        }

        @JavascriptInterface
        public void goNotificationSetting() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: d9.k0
                public /* synthetic */ k0() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.I3();
                }
            });
        }

        public final /* synthetic */ void h0(int i10, int i11, String str) {
            WebViewActivity.this.a4(i10, i11, str, "");
        }

        public final /* synthetic */ void i0(String str) {
            WebViewActivity.this.b4(str);
        }

        @JavascriptInterface
        public void inviteQqfriend() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: d9.y0
                public /* synthetic */ y0() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.J3();
                }
            });
        }

        @JavascriptInterface
        public void inviteQrcode() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: d9.a1
                public /* synthetic */ a1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.K3();
                }
            });
        }

        @JavascriptInterface
        public void inviteQzone() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: d9.u0
                public /* synthetic */ u0() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.L3();
                }
            });
        }

        @JavascriptInterface
        public void inviteWxcircle() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: d9.s0
                public /* synthetic */ s0() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.M3();
                }
            });
        }

        @JavascriptInterface
        public void inviteWxfriend() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: d9.x
                public /* synthetic */ x() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.N3();
                }
            });
        }

        @JavascriptInterface
        public boolean isInBookStore(String str, String str2) {
            return WebViewActivity.this.O3(str, str2);
        }

        public final /* synthetic */ void j0(String str) {
            WebViewActivity.this.c4(str);
        }

        public final /* synthetic */ void k0(String str, String str2, String str3) {
            WebViewActivity.this.d4(str, str2, str3);
        }

        public final /* synthetic */ void l0(int i10) {
            WebViewActivity.this.C4(i10);
        }

        @JavascriptInterface
        public void loginClick() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.j1
                public /* synthetic */ j1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.P();
                }
            });
        }

        @JavascriptInterface
        public void loginClickV2(boolean z10) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.i0

                /* renamed from: c */
                public final /* synthetic */ boolean f25339c;

                public /* synthetic */ i0(boolean z102) {
                    z10 = z102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.Q(z10);
                }
            });
        }

        @JavascriptInterface
        public void logout() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.h1
                public /* synthetic */ h1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.R();
                }
            });
        }

        public final /* synthetic */ void m0() {
            WebViewActivity.this.f4();
        }

        @JavascriptInterface
        public void marketRate() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: d9.w0
                public /* synthetic */ w0() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.Q3();
                }
            });
        }

        public final /* synthetic */ void n0(String str) {
            WebViewActivity.this.g4(str);
        }

        @JavascriptInterface
        public void onBackClick() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.l0
                public /* synthetic */ l0() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.S();
                }
            });
        }

        @JavascriptInterface
        public void onEvent(String str, String str2) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.z0

                /* renamed from: c */
                public final /* synthetic */ String f25404c;

                /* renamed from: d */
                public final /* synthetic */ String f25405d;

                public /* synthetic */ z0(String str3, String str22) {
                    str = str3;
                    str2 = str22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.T(str, str2);
                }
            });
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public void openAdDetail(String str) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.g1

                /* renamed from: c */
                public final /* synthetic */ String f25330c;

                public /* synthetic */ g1(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.U(str);
                }
            });
        }

        @JavascriptInterface
        public void playCallbackRewardVideoAd(String str, String str2, int i10, String str3, String str4) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.m0

                /* renamed from: c */
                public final /* synthetic */ String f25360c;

                /* renamed from: d */
                public final /* synthetic */ String f25361d;

                /* renamed from: e */
                public final /* synthetic */ int f25362e;

                /* renamed from: f */
                public final /* synthetic */ String f25363f;

                /* renamed from: g */
                public final /* synthetic */ String f25364g;

                public /* synthetic */ m0(String str5, String str22, int i102, String str32, String str42) {
                    str = str5;
                    str2 = str22;
                    i10 = i102;
                    str3 = str32;
                    str4 = str42;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.V(str, str2, i10, str3, str4);
                }
            });
        }

        @JavascriptInterface
        public void playInteractionAd() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.d1
                public /* synthetic */ d1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.W();
                }
            });
        }

        @JavascriptInterface
        public void playRewardVideoAd() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.n1
                public /* synthetic */ n1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.Z();
                }
            });
        }

        @JavascriptInterface
        public void rewardDetail(String str, String str2) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.h0

                /* renamed from: c */
                public final /* synthetic */ String f25334c;

                /* renamed from: d */
                public final /* synthetic */ String f25335d;

                public /* synthetic */ h0(String str3, String str22) {
                    str = str3;
                    str2 = str22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.a0(str, str2);
                }
            });
        }

        @JavascriptInterface
        public void setResultOk() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.r0
                public /* synthetic */ r0() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.b0();
                }
            });
        }

        @JavascriptInterface
        public void shareClick() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: d9.i1
                public /* synthetic */ i1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.W3();
                }
            });
        }

        @JavascriptInterface
        public void showBonusDialog(int i10, String str, long j10, int i11) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.k1

                /* renamed from: c */
                public final /* synthetic */ int f25348c;

                /* renamed from: d */
                public final /* synthetic */ String f25349d;

                /* renamed from: e */
                public final /* synthetic */ long f25350e;

                /* renamed from: f */
                public final /* synthetic */ int f25351f;

                public /* synthetic */ k1(int i102, String str2, long j102, int i112) {
                    i10 = i102;
                    str = str2;
                    j10 = j102;
                    i11 = i112;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.c0(i10, str, j10, i11);
                }
            });
        }

        @JavascriptInterface
        public void showSoftKeyboard() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.p0
                public /* synthetic */ p0() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.d0();
                }
            });
        }

        @JavascriptInterface
        public void startBookDetailActivity(String str, String str2) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.d0

                /* renamed from: c */
                public final /* synthetic */ String f25304c;

                /* renamed from: d */
                public final /* synthetic */ String f25305d;

                public /* synthetic */ d0(String str3, String str22) {
                    str = str3;
                    str2 = str22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.e0(str, str2);
                }
            });
        }

        @JavascriptInterface
        public void startNewActivity(String str, boolean z10) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.b0

                /* renamed from: c */
                public final /* synthetic */ String f25296c;

                /* renamed from: d */
                public final /* synthetic */ boolean f25297d;

                public /* synthetic */ b0(String str2, boolean z102) {
                    str = str2;
                    z10 = z102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.f0(str, z10);
                }
            });
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public void startRecharge(int i10, int i11) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.l1

                /* renamed from: c */
                public final /* synthetic */ int f25355c;

                /* renamed from: d */
                public final /* synthetic */ int f25356d;

                public /* synthetic */ l1(int i102, int i112) {
                    i10 = i102;
                    i11 = i112;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.g0(i10, i11);
                }
            });
        }

        @JavascriptInterface
        public void startRechargeV2(int i10, int i11, String str) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.z

                /* renamed from: c */
                public final /* synthetic */ int f25400c;

                /* renamed from: d */
                public final /* synthetic */ int f25401d;

                /* renamed from: e */
                public final /* synthetic */ String f25402e;

                public /* synthetic */ z(int i102, int i112, String str2) {
                    i10 = i102;
                    i11 = i112;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.h0(i10, i11, str);
                }
            });
        }

        @JavascriptInterface
        public void startRechargeV3(String str) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.y

                /* renamed from: c */
                public final /* synthetic */ String f25397c;

                public /* synthetic */ y(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.i0(str);
                }
            });
        }

        @JavascriptInterface
        public void startShare(String str) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.f1

                /* renamed from: c */
                public final /* synthetic */ String f25322c;

                public /* synthetic */ f1(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.j0(str);
                }
            });
        }

        @JavascriptInterface
        public void startVipActivity(String str, String str2, String str3) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.e1

                /* renamed from: c */
                public final /* synthetic */ String f25315c;

                /* renamed from: d */
                public final /* synthetic */ String f25316d;

                /* renamed from: e */
                public final /* synthetic */ String f25317e;

                public /* synthetic */ e1(String str4, String str22, String str32) {
                    str = str4;
                    str2 = str22;
                    str3 = str32;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.k0(str, str2, str3);
                }
            });
        }

        @JavascriptInterface
        public void statusBarStyle(int i10) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.q0

                /* renamed from: c */
                public final /* synthetic */ int f25379c;

                public /* synthetic */ q0(int i102) {
                    i10 = i102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.l0(i10);
                }
            });
        }

        @JavascriptInterface
        @SuppressLint({"JavascriptInterface"})
        public String toString() {
            return "android";
        }

        @JavascriptInterface
        public void ttsSetting() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.runOnUiThread(new Runnable() { // from class: d9.t0
                public /* synthetic */ t0() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.e4();
                }
            });
        }

        @JavascriptInterface
        public void updateAccountInfo() {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.v0
                public /* synthetic */ v0() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.m0();
                }
            });
        }

        @JavascriptInterface
        public void wxBindV2(String str) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.m1

                /* renamed from: c */
                public final /* synthetic */ String f25366c;

                public /* synthetic */ m1(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.n0(str);
                }
            });
        }

        @JavascriptInterface
        public void playInteractionAd(String str) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.n0

                /* renamed from: c */
                public final /* synthetic */ String f25369c;

                public /* synthetic */ n0(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.X(str);
                }
            });
        }

        @JavascriptInterface
        public void playRewardVideoAd(String str) {
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: d9.f0

                /* renamed from: c */
                public final /* synthetic */ String f25320c;

                public /* synthetic */ f0(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.e.this.Y(str);
                }
            });
        }
    }

    public static String A3(String str) {
        String str2;
        if (str.isEmpty()) {
            return "";
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            str = "http://" + str;
        }
        try {
            str2 = new URI(str).getHost();
        } catch (Exception e10) {
            e10.printStackTrace();
            str2 = "";
        }
        return (str2.endsWith(".html") || str2.endsWith(".htm")) ? "" : str2;
    }

    public static void A4(Activity activity, String str, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putString("LIBMARS_INTENT_WEBVIEW_URL", str);
        bundle.putBoolean("LIBMARS_INTENT_DOWNLOAD_HINT", z10);
        Intent intent = new Intent(activity, (Class<?>) WebViewActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static /* synthetic */ void j4(DialogInterface dialogInterface, int i10) {
    }

    public /* synthetic */ boolean l4(View view) {
        if (ConfigSingleton.D().y0() || !ConfigSingleton.D().V0()) {
            return true;
        }
        WebView.HitTestResult hitTestResult = this.L.getHitTestResult();
        if (hitTestResult.getType() != 5) {
            return false;
        }
        u4(hitTestResult.getExtra());
        return false;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public void B3() {
        e eVar = new e();
        this.L.addJavascriptInterface(eVar, eVar.toString());
    }

    public void B4() {
        LayoutWebviewActionbarBinding layoutWebviewActionbarBinding = this.R;
        if (layoutWebviewActionbarBinding != null) {
            layoutWebviewActionbarBinding.getRoot().setVisibility((D3() || !this.L.canGoBack()) ? 8 : 0);
        }
    }

    public void C3(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri z10 = g.z(this, file);
        if (z10 == null) {
            return;
        }
        intent.setFlags(268435456);
        int i10 = getApplicationInfo().targetSdkVersion;
        if (m.o() && i10 >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(z10, "application/vnd.android.package-archive");
        startActivity(intent);
    }

    public final void C4(int i10) {
        if (i10 == 2 || (i10 < 0 && this.N.contains("statusBarStyle=2"))) {
            com.gyf.immersionbar.d.q3(this).W0(BarHide.FLAG_HIDE_STATUS_BAR).a1();
            return;
        }
        com.gyf.immersionbar.d q32 = com.gyf.immersionbar.d.q3(this);
        boolean z10 = true;
        if (i10 != 1 && (i10 >= 0 || !this.N.contains("statusBarStyle=1"))) {
            z10 = false;
        }
        q32.T2(z10).a1();
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void D(String str) {
        z3(str);
    }

    public boolean D3() {
        return this.P || this.N.contains("hideNaviBar=1");
    }

    /* renamed from: D4 */
    public void p4(String str) {
        new Thread(new Runnable() { // from class: d9.m

            /* renamed from: c */
            public final /* synthetic */ String f25358c;

            public /* synthetic */ m(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                WebViewActivity.this.q4(str);
            }
        }).start();
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void E(WebView webView, String str, boolean z10) {
    }

    public void E3(String str, String str2, String str3, String str4) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public boolean F(WebView webView, String str, String str2) {
        return false;
    }

    public void F3() {
        runOnUiThread(new Runnable() { // from class: d9.t
            public /* synthetic */ t() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                WebViewActivity.this.k4();
            }
        });
    }

    public void G3(boolean z10) {
    }

    public void H3(String str, String str2, int i10, String str3, String str4) {
    }

    public void I3() {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void J(String str, String str2, String str3) {
        k0.d(this, str, str2, str3, new k0.a() { // from class: d9.n
            public /* synthetic */ n() {
            }

            @Override // l9.k0.a
            public final void a(String str4, String str5) {
                WebViewActivity.this.o4(str4, str5);
            }
        }, this.O);
    }

    @Override // com.martian.libmars.activity.RetryLoadingActivity
    public void J2() {
    }

    public void J3() {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void K0(ValueCallback<Uri> valueCallback, String str, String str2) {
        G1(new a(valueCallback));
        i0.H0(this, "选择图片", "从相册选择", "拍照选择", false, new b(valueCallback));
    }

    public void K3() {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void L(int i10, String str, String str2) {
        this.M.setRefreshing(false);
    }

    public void L3() {
    }

    public void M3() {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void N0(String str) {
        this.M.setRefreshing(false);
        if (this.T) {
            finish();
        }
    }

    public void N3() {
    }

    public boolean O3(String str, String str2) {
        return false;
    }

    public void P3(boolean z10) {
    }

    public void Q3() {
    }

    public void R3(String str, String str2) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void S0(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        G1(new c(valueCallback));
        y1(valueCallback);
    }

    public void S3(String str, String str2, int i10, String str3, String str4) {
    }

    public void T3(String str) {
    }

    public void U3(String str) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void V(WebView webView, int i10) {
        if (i10 == 100) {
            B4();
        }
    }

    public void V3(String str, String str2) {
    }

    public void W3() {
    }

    public void X3(int i10, String str, long j10, int i11) {
    }

    public void Y3(String str, String str2) {
    }

    public void Z3(String str, boolean z10) {
    }

    public void a4(int i10, int i11, String str, String str2) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void b(WebView webView, String str) {
        t2(ConfigSingleton.D().s(str));
        if (this.R == null || B2() == null) {
            return;
        }
        if (D3()) {
            B2().setAlpha(0.0f);
        } else if (this.L.canGoBack()) {
            this.R.f12255c.setText(ConfigSingleton.D().s(str));
            B2().setAlpha(0.0f);
        } else {
            B2().setText(ConfigSingleton.D().s(str));
            B2().setAlpha(1.0f);
        }
    }

    public void b4(String str) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void c0(String str, Bitmap bitmap) {
        if (this.M.isRefreshing()) {
            return;
        }
        this.M.setRefreshing(true);
    }

    public void c4(String str) {
    }

    public void d4(String str, String str2, String str3) {
    }

    public void e4() {
    }

    public void f4() {
    }

    public void g4(String str) {
    }

    public final void h4() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:com.android.providers.downloads"));
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    public final /* synthetic */ void i4(String str, DialogInterface dialogInterface, int i10) {
        P1("开始下载");
        DownLoadService.startActionFoo(this, str);
    }

    public final /* synthetic */ void k4() {
        this.L.loadUrl("javascript:autoLotteryDraw()");
    }

    public final /* synthetic */ void m4() {
        MTWebView mTWebView = this.L;
        String url = mTWebView.getUrl();
        Objects.requireNonNull(url);
        mTWebView.loadUrl(url);
    }

    public final /* synthetic */ void n4() {
        d3(false);
        C4(-1);
    }

    public final /* synthetic */ void o4(String str, String str2) {
        P1("已开始下载" + str);
    }

    @Override // com.martian.libmars.activity.RetryLoadingActivity
    public void onBackClick(View view) {
        MTWebView mTWebView = this.L;
        if (mTWebView == null || !mTWebView.canGoBack()) {
            finish();
        } else {
            this.L.goBack();
        }
    }

    public void onCloseClick(View view) {
        finish();
    }

    @Override // com.martian.libmars.activity.RetryLoadingActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.libmars_webview_activity);
        Y2(false);
        c3(true);
        MTWebView mTWebView = (MTWebView) findViewById(R.id.libmars_webview);
        this.L = mTWebView;
        mTWebView.setOnPageStateChangedListener(this);
        this.L.setOnLongClickListener(new View.OnLongClickListener() { // from class: d9.q
            public /* synthetic */ q() {
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean l42;
                l42 = WebViewActivity.this.l4(view);
                return l42;
            }
        });
        new d(this.L);
        B3();
        VerticalSwipeRefreshLayout verticalSwipeRefreshLayout = (VerticalSwipeRefreshLayout) findViewById(R.id.swipe_container);
        this.M = verticalSwipeRefreshLayout;
        verticalSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        this.M.setRefreshing(true);
        this.M.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: d9.r
            public /* synthetic */ r() {
            }

            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                WebViewActivity.this.m4();
            }
        });
        this.S = (FrameLayout) findViewById(R.id.banner_ads);
        if (bundle != null) {
            this.N = bundle.getString("LIBMARS_INTENT_WEBVIEW_URL");
            this.O = bundle.getBoolean("LIBMARS_INTENT_DOWNLOAD_HINT", true);
            this.Q = bundle.getString("INTENT_WEBVIEW_URL_REFERER");
            this.P = bundle.getBoolean("INTENT_FULLSCREEN", false);
            this.T = bundle.getBoolean(W, false);
        } else {
            this.N = q1("LIBMARS_INTENT_WEBVIEW_URL");
            this.O = d1("LIBMARS_INTENT_DOWNLOAD_HINT", true);
            this.Q = q1("INTENT_WEBVIEW_URL_REFERER");
            this.P = d1("INTENT_FULLSCREEN", false);
            this.T = d1(W, false);
        }
        ViewStub A2 = A2();
        A2.setLayoutResource(R.layout.layout_webview_actionbar);
        this.R = LayoutWebviewActionbarBinding.a(A2.inflate());
        if (TextUtils.isEmpty(this.N)) {
            P1("无效的URL");
            finish();
            return;
        }
        if (l.q(this.Q)) {
            this.L.loadUrl(this.N);
        }
        if (D3()) {
            V2();
            this.L.post(new Runnable() { // from class: d9.s
                public /* synthetic */ s() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.n4();
                }
            });
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MTWebView mTWebView = this.L;
        if (mTWebView != null) {
            mTWebView.destroy();
        }
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || !this.L.canGoBack()) {
            return super.onKeyDown(i10, keyEvent);
        }
        this.L.goBack();
        return true;
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.L.saveState(bundle);
        bundle.putString("LIBMARS_INTENT_WEBVIEW_URL", this.N);
        bundle.putBoolean("LIBMARS_INTENT_DOWNLOAD_HINT", this.O);
        bundle.putString("INTENT_WEBVIEW_URL_REFERER", this.Q);
        bundle.putBoolean("INTENT_FULLSCREEN", this.P);
        bundle.putBoolean(W, this.T);
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        this.M.setEnabled(this.L.getScrollY() == 0);
    }

    public final /* synthetic */ void q4(String str) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            int contentLength = ((HttpURLConnection) openConnection).getContentLength();
            openConnection.connect();
            InputStream inputStream = openConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, contentLength);
            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream);
            bufferedInputStream.close();
            inputStream.close();
            if (decodeStream != null) {
                runOnUiThread(new Runnable() { // from class: d9.o

                    /* renamed from: c */
                    public final /* synthetic */ Bitmap f25372c;

                    public /* synthetic */ o(Bitmap decodeStream2) {
                        decodeStream = decodeStream2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewActivity.this.r4(decodeStream);
                    }
                });
            }
        } catch (Exception e10) {
            runOnUiThread(new Runnable() { // from class: d9.p
                public /* synthetic */ p() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.s4();
                }
            });
            e10.printStackTrace();
        }
    }

    public final /* synthetic */ void s4() {
        P1("保存失败");
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (l.q(str) || !str.contains("playmy") || !str.contains("Wall_Adinfo")) {
            return false;
        }
        WowanDetailActivity.startWebViewActivity(this, str);
        return true;
    }

    @Override // com.martian.libmars.activity.BaseActivity
    public void startActivityForResult(Class<? extends Activity> cls, Bundle bundle, int i10) {
        if (ConfigSingleton.D().V0()) {
            super.startActivityForResult(cls, bundle, i10);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i10, @Nullable Intent intent, int i11, int i12, int i13) throws IntentSender.SendIntentException {
        if (ConfigSingleton.D().V0()) {
            super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
        }
    }

    public final boolean t4(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return true;
        }
        String scheme = intent.getData().getScheme();
        if (l.q(scheme)) {
            return true;
        }
        return (scheme.equalsIgnoreCase("ttbook") || scheme.equalsIgnoreCase("tfbook") || scheme.equalsIgnoreCase("qmbook") || scheme.equalsIgnoreCase("qdbook")) ? false : true;
    }

    public final void u4(String str) {
        if (l.q(str)) {
            return;
        }
        i0.z0(this, "确认信息", "保存这张图片？", new i0.l() { // from class: d9.w

            /* renamed from: b */
            public final /* synthetic */ String f25391b;

            public /* synthetic */ w(String str2) {
                str = str2;
            }

            @Override // l9.i0.l
            public final void a() {
                WebViewActivity.this.p4(str);
            }
        });
    }

    /* renamed from: v4 */
    public void r4(Bitmap bitmap) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Boohee");
        if (file.exists() || file.mkdir()) {
            File file2 = new File(file, System.currentTimeMillis() + ".jpg");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                P1("图片已保存到相册");
            } catch (FileNotFoundException e10) {
                P1("保存失败");
                e10.printStackTrace();
            } catch (IOException e11) {
                P1("保存失败");
                e11.printStackTrace();
            }
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getAbsolutePath())));
        }
    }

    public void w4(int i10) {
        LayoutWebviewActionbarBinding layoutWebviewActionbarBinding = this.R;
        if (layoutWebviewActionbarBinding != null) {
            layoutWebviewActionbarBinding.f12254b.setColorFilter(ContextCompat.getColor(this, i10));
        }
    }

    public final boolean x3() {
        try {
            int applicationEnabledSetting = getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
            return (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) ? false : true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public void x4(int i10) {
        LayoutWebviewActionbarBinding layoutWebviewActionbarBinding = this.R;
        if (layoutWebviewActionbarBinding != null) {
            layoutWebviewActionbarBinding.f12255c.setBackgroundColor(ContextCompat.getColor(this, i10));
        }
    }

    public final void y3(String str, String str2) {
        boolean z10;
        int columnIndex;
        Cursor query = ((DownloadManager) getSystemService("download")).query(new DownloadManager.Query());
        while (true) {
            z10 = false;
            try {
                try {
                    if (!query.moveToNext()) {
                        break;
                    }
                    int columnIndex2 = query.getColumnIndex("uri");
                    if (columnIndex2 < 0) {
                        query.close();
                        return;
                    }
                    if (str.equals(query.getString(columnIndex2))) {
                        try {
                            columnIndex = query.getColumnIndex("status");
                        } catch (Exception unused) {
                        }
                        if (columnIndex < 0) {
                            query.close();
                            return;
                        }
                        int i10 = query.getInt(columnIndex);
                        if (i10 == 1 || i10 == 2 || i10 == 4) {
                            int columnIndex3 = query.getColumnIndex("bytes_so_far");
                            int columnIndex4 = query.getColumnIndex("total_size");
                            if (columnIndex3 >= 0 && columnIndex4 >= 0) {
                                t0.b(this, "正在下载，已完成" + ((int) ((query.getInt(columnIndex3) * 100) / query.getInt(columnIndex4))) + "%");
                            }
                            return;
                        }
                        if (i10 == 8) {
                            if (TextUtils.isEmpty(str2)) {
                                query.close();
                                return;
                            } else {
                                File file = new File(ba.b.i(), str2);
                                if (file.exists()) {
                                    C3(file);
                                }
                            }
                        }
                        z10 = true;
                    }
                } finally {
                    query.close();
                }
            } catch (Exception unused2) {
            }
        }
        query.close();
        if (z10) {
            return;
        }
        if (!x3()) {
            h4();
            return;
        }
        XianWanSystemUtil.NetState netWorkType = XianWanSystemUtil.getNetWorkType(getApplicationContext());
        if (netWorkType == XianWanSystemUtil.NetState.NET_NO) {
            P1("现在还没有网哦！");
            return;
        }
        if (netWorkType != XianWanSystemUtil.NetState.NET_MOBILE) {
            P1("开始下载");
            DownLoadService.startActionFoo(this, str);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("温馨提醒");
        builder.setMessage("您现在使用的是非WiFi流量,是否继续?");
        builder.setPositiveButton("继续下载", new DialogInterface.OnClickListener() { // from class: d9.u

            /* renamed from: c */
            public final /* synthetic */ String f25387c;

            public /* synthetic */ u(String str3) {
                str = str3;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                WebViewActivity.this.i4(str, dialogInterface, i11);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: d9.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                WebViewActivity.j4(dialogInterface, i11);
            }
        });
        builder.show();
    }

    public void y4(int i10) {
        LayoutWebviewActionbarBinding layoutWebviewActionbarBinding = this.R;
        if (layoutWebviewActionbarBinding != null) {
            layoutWebviewActionbarBinding.f12255c.setTextColor(ContextCompat.getColor(this, i10));
        }
    }

    public void z3(String str) {
    }

    public final void z4(String str) {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PackageManager packageManager = getPackageManager();
        try {
            packageInfo = getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            t0.b(this, "手机还未安装该应用");
            return;
        }
        launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        launchIntentForPackage.setFlags(270532608);
        startActivity(launchIntentForPackage);
    }

    @Override // com.martian.libmars.activity.BaseActivity
    public void startActivityForResult(Class<? extends Activity> cls, int i10) {
        if (ConfigSingleton.D().V0()) {
            super.startActivityForResult(cls, i10);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i10, @Nullable Intent intent, int i11, int i12, int i13, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        if (ConfigSingleton.D().V0()) {
            super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i10) {
        if (ConfigSingleton.D().V0() || !t4(intent)) {
            super.startActivityForResult(intent, i10);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i10, @Nullable Bundle bundle) {
        if (ConfigSingleton.D().V0() || !t4(intent)) {
            super.startActivityForResult(intent, i10, bundle);
        }
    }
}
