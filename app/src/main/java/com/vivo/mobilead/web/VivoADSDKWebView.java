package com.vivo.mobilead.web;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.vivo.ad.a;
import com.vivo.ad.model.q;
import com.vivo.ad.model.r;
import com.vivo.ad.model.v;
import com.vivo.ic.SystemUtils;
import com.vivo.ic.webview.CommonWebView;
import com.vivo.ic.webview.HtmlWebChromeClient;
import com.vivo.ic.webview.IBridge;
import com.vivo.ic.webview.WebViewDownloadListener;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.f0;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.u;
import com.vivo.mobilead.util.u0;
import com.vivo.mobilead.util.w;
import com.vivo.mobilead.util.x0;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class VivoADSDKWebView extends Activity {
    private static final int CLICK_TYPE_APPOINTMENT = 3;
    private static final int CLICK_TYPE_DETAIL = 1;
    private static final int CLICK_TYPE_INSTALL = 2;
    private static final int CLICK_TYPE_OPEN = 0;
    private static final String TAG = "VivoADSDKWebView";
    private BackUrlInfo backUrlInfo;
    private boolean isH5;
    private boolean isHaveReport;
    private boolean isMid;
    private boolean isMidPageClickedReported;
    private com.vivo.ad.model.b mAdItemData;
    private TextView mCloseView;
    private CommonWebView mWebview;
    private String pageSrc;
    private int renderType;
    private String sourceAppend;
    private TextView titleTextView;
    private int uiVersion;
    public static HashMap<String, String> PTYPE_MAPS = new c();
    private static Handler mainHandler = new Handler();
    private boolean mIsRemoveHeaderFooter = false;
    private boolean mNeedReportClose = false;
    private String mPlaysStatus = "";
    private int mBroadcastTime = 0;
    private int clickResponse = -1;
    private Handler mUiHandler = new Handler(Looper.getMainLooper());
    private long mH5CloseBtnDelayShowTime = 0;
    private boolean mLoadError = false;
    private boolean mLinkOpt = false;
    private boolean mIsClicked = false;
    private int clickH5MaxInterval = 200;
    private boolean allowJumpNonClick = true;

    class a extends com.vivo.mobilead.util.f1.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            VivoADSDKWebView.this.mWebview.loadUrl(VivoADSDKWebView.this.mAdItemData.v());
        }
    }

    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f30817a;

        /* renamed from: b */
        final /* synthetic */ int f30818b;

        /* renamed from: c */
        final /* synthetic */ String f30819c;

        /* renamed from: d */
        final /* synthetic */ int f30820d;

        b(com.vivo.ad.model.b bVar, int i2, String str, int i3) {
            this.f30817a = bVar;
            this.f30818b = i2;
            this.f30819c = str;
            this.f30820d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f30817a == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "215");
            hashMap.put("ptype", VivoADSDKWebView.PTYPE_MAPS.get(String.valueOf(VivoADSDKWebView.this.mAdItemData.l())));
            hashMap.put("id", this.f30817a.d());
            hashMap.put(OapsKey.KEY_TOKEN, this.f30817a.P());
            hashMap.put("renderType", String.valueOf(this.f30817a.a().a()));
            if (VivoADSDKWebView.this.mAdItemData.l() == 9 && VivoADSDKWebView.this.isMid) {
                hashMap.put("scene", String.valueOf(2));
                hashMap.put("dfrom", String.valueOf(1));
            }
            if (this.f30817a.Q() != null) {
                hashMap.put("materialids", this.f30817a.Q().f());
            } else {
                hashMap.put("materialids", this.f30817a.f().f());
            }
            hashMap.put("status", String.valueOf(this.f30818b));
            hashMap.put("dspid", String.valueOf(this.f30817a.q()));
            if (!SystemUtils.isVivoPhone() && this.f30817a.y() != null && !TextUtils.isEmpty(this.f30817a.y().a())) {
                hashMap.put("install_status", String.valueOf(f0.a(com.vivo.mobilead.manager.f.j().c(), this.f30817a.y().a())));
            }
            if (1 == this.f30818b) {
                hashMap.put("reason", this.f30819c);
                hashMap.put("errCode", String.valueOf(this.f30820d));
                r z = this.f30817a.z();
                hashMap.put("deeplinkUrl", z != null ? z.b() : "");
            }
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.c(this.f30817a.G());
            cVar.e(VivoADSDKWebView.this.sourceAppend);
            VivoADSDKWebView.this.reportEvent(cVar);
        }
    }

    static class c extends HashMap<String, String> {
        c() {
            put(String.valueOf(2), "3");
            put(String.valueOf(3), "2");
            put(String.valueOf(4), "1");
            put(String.valueOf(5), "4");
            put(String.valueOf(9), BaseWrapper.ENTER_ID_MESSAGE);
        }
    }

    class d extends com.vivo.mobilead.web.b {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (VivoADSDKWebView.this.mCloseView != null) {
                    VivoADSDKWebView.this.mCloseView.setVisibility(0);
                }
            }
        }

        d(Context context, IBridge iBridge, CommonWebView commonWebView, boolean z, com.vivo.mobilead.web.c cVar, long j2, boolean z2) {
            super(context, iBridge, commonWebView, z, cVar, j2, z2);
        }

        @Override // com.vivo.mobilead.web.b, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (VivoADSDKWebView.this.mLoadError) {
                VivoADSDKWebView.this.mUiHandler.post(new a());
            }
            if (VivoADSDKWebView.this.isMid || VivoADSDKWebView.this.isHaveReport || !VivoADSDKWebView.this.isH5) {
                return;
            }
            VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
            vivoADSDKWebView.reportAD(vivoADSDKWebView.mAdItemData);
            VivoADSDKWebView.this.isHaveReport = true;
        }

        @Override // com.vivo.mobilead.web.b, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            VivoADSDKWebView.this.mLoadError = true;
            w.g(VivoADSDKWebView.this.mAdItemData, "3007002", String.valueOf(VivoADSDKWebView.this.uiVersion));
        }

        @Override // com.vivo.mobilead.web.b, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            VivoADSDKWebView.this.mLoadError = true;
            w.g(VivoADSDKWebView.this.mAdItemData, "3007003", String.valueOf(VivoADSDKWebView.this.uiVersion));
        }
    }

    class e extends com.vivo.mobilead.util.f1.b {
        e() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (VivoADSDKWebView.this.mCloseView != null) {
                VivoADSDKWebView.this.mCloseView.setVisibility(0);
            }
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int j2 = VivoADSDKWebView.this.mAdItemData.j();
            if (j2 == 5 || j2 == 6) {
                VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
                vivoADSDKWebView.reportAdH5(vivoADSDKWebView.mAdItemData, 2);
            }
            VivoADSDKWebView.this.onBackPressed();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VivoADSDKWebView.this.finish();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VivoADSDKWebView.this.mNeedReportClose && VivoADSDKWebView.this.mAdItemData != null) {
                k0.a(VivoADSDKWebView.this.mAdItemData, VivoADSDKWebView.this.sourceAppend, VivoADSDKWebView.this.mAdItemData.i(), -1, VivoADSDKWebView.this.mBroadcastTime, 16, VivoADSDKWebView.this.mPlaysStatus);
            }
            VivoADSDKWebView.this.finish();
        }
    }

    private class l implements View.OnClickListener {

        /* renamed from: a */
        private int f30831a;

        l(int i2) {
            this.f30831a = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            VivoADSDKWebView.this.clickResponse = -1;
            boolean j2 = com.vivo.mobilead.util.e.j(VivoADSDKWebView.this.mAdItemData);
            int i3 = this.f30831a;
            if (i3 == 0) {
                VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
                com.vivo.mobilead.util.j.a(vivoADSDKWebView, com.vivo.mobilead.util.d.b(vivoADSDKWebView.mAdItemData), VivoADSDKWebView.this.mAdItemData, VivoADSDKWebView.this.sourceAppend, String.valueOf(VivoADSDKWebView.this.renderType), String.valueOf(VivoADSDKWebView.this.uiVersion));
                VivoADSDKWebView.this.clickResponse = 1;
            } else if (i3 == 1) {
                VivoADSDKWebView vivoADSDKWebView2 = VivoADSDKWebView.this;
                com.vivo.mobilead.util.j.a(vivoADSDKWebView2, vivoADSDKWebView2.mAdItemData, VivoADSDKWebView.this.backUrlInfo, new a(j2), VivoADSDKWebView.this.uiVersion);
            } else if (i3 != 2) {
                if (i3 == 3) {
                    VivoADSDKWebView.this.dealAppointmentAdClick();
                }
            } else if (SystemUtils.isVivoPhone()) {
                VivoADSDKWebView vivoADSDKWebView3 = VivoADSDKWebView.this;
                com.vivo.mobilead.util.j.a(vivoADSDKWebView3, vivoADSDKWebView3.mAdItemData, j2, VivoADSDKWebView.this.sourceAppend, VivoADSDKWebView.this.uiVersion);
                VivoADSDKWebView.this.clickResponse = 2;
            } else {
                try {
                    i2 = Integer.parseInt(VivoADSDKWebView.this.pageSrc);
                } catch (Exception unused) {
                    i2 = -1;
                }
                VivoADSDKWebView vivoADSDKWebView4 = VivoADSDKWebView.this;
                vivoADSDKWebView4.clickResponse = u.a((Context) vivoADSDKWebView4, vivoADSDKWebView4.mAdItemData, VivoADSDKWebView.this.sourceAppend, VivoADSDKWebView.this.renderType, VivoADSDKWebView.this.uiVersion, i2, VivoADSDKWebView.this.clickResponse, VivoADSDKWebView.this.backUrlInfo, false);
            }
            VivoADSDKWebView vivoADSDKWebView5 = VivoADSDKWebView.this;
            vivoADSDKWebView5.reportAdH5(vivoADSDKWebView5.mAdItemData, 1);
        }

        class a implements a.g {

            /* renamed from: a */
            final /* synthetic */ boolean f30833a;

            a(boolean z) {
                this.f30833a = z;
            }

            @Override // com.vivo.ad.a.g
            public void a() {
                VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
                vivoADSDKWebView.reportAdDeepLink(vivoADSDKWebView.mAdItemData, 0, 0, "");
                VivoADSDKWebView.this.clickResponse = 1;
            }

            @Override // com.vivo.ad.a.g
            public void a(int i2, String str) {
                int i3;
                VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
                vivoADSDKWebView.reportAdDeepLink(vivoADSDKWebView.mAdItemData, 1, i2, str);
                v I = VivoADSDKWebView.this.mAdItemData.I();
                if (I == null || 1 != I.a()) {
                    w.f(VivoADSDKWebView.this.mAdItemData, "3006000", String.valueOf(VivoADSDKWebView.this.uiVersion));
                    if (!SystemUtils.isVivoPhone()) {
                        try {
                            i3 = Integer.parseInt(VivoADSDKWebView.this.pageSrc);
                        } catch (Exception unused) {
                            i3 = -1;
                        }
                        VivoADSDKWebView vivoADSDKWebView2 = VivoADSDKWebView.this;
                        vivoADSDKWebView2.clickResponse = u.a((Context) vivoADSDKWebView2, vivoADSDKWebView2.mAdItemData, VivoADSDKWebView.this.sourceAppend, VivoADSDKWebView.this.renderType, VivoADSDKWebView.this.uiVersion, i3, VivoADSDKWebView.this.clickResponse, VivoADSDKWebView.this.backUrlInfo, false);
                        return;
                    }
                    VivoADSDKWebView vivoADSDKWebView3 = VivoADSDKWebView.this;
                    com.vivo.mobilead.util.j.a(vivoADSDKWebView3, vivoADSDKWebView3.mAdItemData, this.f30833a, VivoADSDKWebView.this.sourceAppend, VivoADSDKWebView.this.uiVersion);
                    VivoADSDKWebView.this.clickResponse = 2;
                    return;
                }
                VivoADSDKWebView.this.dealRpkDeeplink();
            }
        }
    }

    private final class m {

        /* renamed from: a */
        private com.vivo.mobilead.web.c f30835a;

        /* renamed from: b */
        private boolean f30836b;

        /* renamed from: c */
        private long f30837c;

        public m(com.vivo.mobilead.web.c cVar, boolean z, long j2) {
            this.f30836b = true;
            this.f30837c = 200L;
            this.f30835a = cVar;
            this.f30836b = z;
            this.f30837c = j2;
        }

        @JavascriptInterface
        public void commonClick() {
            if (this.f30835a == null || this.f30836b || Math.abs(System.currentTimeMillis() - this.f30835a.getDispatchTouchTime()) <= this.f30837c) {
                VivoADSDKWebView.this.clickResponse = -1;
                if (VivoADSDKWebView.this.mAdItemData == null || !VivoADSDKWebView.this.isMid) {
                    return;
                }
                int j2 = VivoADSDKWebView.this.mAdItemData.j();
                if (j2 == 1) {
                    VivoADSDKWebView.this.dealWebAdClick();
                } else if (j2 == 2) {
                    VivoADSDKWebView.this.dealAppAdClick();
                } else if (j2 == 8) {
                    VivoADSDKWebView.this.dealRpkAdClick();
                } else if (j2 == 9) {
                    VivoADSDKWebView.this.dealAppointmentAdClick();
                }
                if (VivoADSDKWebView.this.mAdItemData.l() == 9 || (VivoADSDKWebView.this.mAdItemData.l() == 4 && VivoADSDKWebView.this.mAdItemData.Q() != null)) {
                    boolean j3 = com.vivo.mobilead.util.e.j(VivoADSDKWebView.this.mAdItemData);
                    VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
                    vivoADSDKWebView.reportVideoADClick(vivoADSDKWebView.mAdItemData, 2, -999, -999, -999, -999, j3);
                    if (VivoADSDKWebView.this.isMidPageClickedReported) {
                        return;
                    }
                    VivoADSDKWebView.this.isMidPageClickedReported = true;
                    if (com.vivo.mobilead.manager.b.l().getBoolean("is_click", false)) {
                        return;
                    }
                    VivoADSDKWebView vivoADSDKWebView2 = VivoADSDKWebView.this;
                    vivoADSDKWebView2.reportAdThirdPartyEvent(vivoADSDKWebView2.mAdItemData, a.EnumC0603a.CLICK, -999.0f, -999.0f, -999.0f, -999.0f, -999.0f, -999.0f, -999.0f, -999.0f);
                    com.vivo.mobilead.manager.b.l().putBoolean("is_click", true);
                }
            }
        }

        @JavascriptInterface
        public void streamDownloadApp() {
            if (this.f30835a == null || this.f30836b || Math.abs(System.currentTimeMillis() - this.f30835a.getDispatchTouchTime()) <= this.f30837c) {
                VivoADSDKWebView.this.clickResponse = -1;
                boolean j2 = com.vivo.mobilead.util.e.j(VivoADSDKWebView.this.mAdItemData);
                VivoADSDKWebView.this.goApp(j2);
                if (!VivoADSDKWebView.this.mLinkOpt) {
                    VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
                    vivoADSDKWebView.reportAdH5(vivoADSDKWebView.mAdItemData, 1);
                } else if (com.vivo.mobilead.util.f.c(VivoADSDKWebView.this.mAdItemData)) {
                    VivoADSDKWebView.this.reportClickEvent(-1, 2, "2", j2);
                } else {
                    VivoADSDKWebView.this.reportClickEvent(-1, 2, "1", j2);
                }
            }
        }
    }

    public void dealAppAdClick() {
        int i2;
        r z = this.mAdItemData.z();
        if (z != null && 1 == z.a()) {
            com.vivo.mobilead.util.j.a(this, this.mAdItemData, this.backUrlInfo, new j(), this.uiVersion);
        } else {
            if (SystemUtils.isVivoPhone()) {
                goApp();
                return;
            }
            try {
                i2 = Integer.parseInt(this.pageSrc);
            } catch (Exception unused) {
                i2 = -1;
            }
            this.clickResponse = u.a((Context) this, this.mAdItemData, this.sourceAppend, this.renderType, this.uiVersion, i2, this.clickResponse, this.backUrlInfo, false);
        }
    }

    public void dealAppointmentAdClick() {
        q y = this.mAdItemData.y();
        if (y != null && com.vivo.mobilead.util.j.b(this, y.e())) {
            com.vivo.mobilead.util.j.a(this, y.e(), this.mAdItemData, this.sourceAppend, String.valueOf(this.renderType), String.valueOf(this.uiVersion));
            this.clickResponse = 1;
            return;
        }
        com.vivo.mobilead.util.l b2 = com.vivo.mobilead.util.j.b(this, this.mAdItemData, (BackUrlInfo) null, this.uiVersion);
        if (b2 == null || !b2.f30720b) {
            k0.a(this.mAdItemData, 2, 2, b2.f30719a, this.sourceAppend);
        } else {
            this.clickResponse = 3;
            k0.a(this.mAdItemData, 2, 1, "", this.sourceAppend);
        }
    }

    public void dealRpkAdClick() {
        r z = this.mAdItemData.z();
        this.mAdItemData.I();
        if (z == null || 1 != z.a()) {
            dealRpkDeeplink();
        } else {
            com.vivo.mobilead.util.j.a(this, this.mAdItemData, this.backUrlInfo, new i(), this.uiVersion);
        }
    }

    public void dealRpkDeeplink() {
        String str;
        v I = this.mAdItemData.I();
        if (I == null || 1 != I.a()) {
            str = "3006000";
        } else {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                intent.setData(Uri.parse(I.b()));
                com.vivo.mobilead.util.j.a(intent, this.mAdItemData);
                startActivity(intent);
                reportRpkAdDeepLink(this.mAdItemData, 0);
                this.clickResponse = 1;
                str = "";
            } catch (Exception e2) {
                reportRpkAdDeepLink(this.mAdItemData, 1);
                x0.b(TAG, "deepRpkDeeplink error : ", e2);
                str = "3006001";
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        w.f(this.mAdItemData, str, String.valueOf(this.uiVersion));
    }

    public void dealWebAdClick() {
        r z = this.mAdItemData.z();
        if (z != null && 1 == z.a()) {
            com.vivo.mobilead.util.j.a(this, this.mAdItemData, this.backUrlInfo, new k(), this.uiVersion);
        } else {
            this.clickResponse = 0;
            mainHandler.post(new a());
        }
    }

    public void goApp() {
        goApp(com.vivo.mobilead.util.e.j(this.mAdItemData));
    }

    public void reportAD(com.vivo.ad.model.b bVar) {
        k0.a(bVar, "1", this.sourceAppend, this.pageSrc);
    }

    private void setBottomBtnStyle(TextView textView) {
        q y = this.mAdItemData.y();
        boolean z = false;
        if (y != null) {
            if (this.mAdItemData.U()) {
                if (com.vivo.mobilead.util.j.b(this, y.e())) {
                    textView.setText("立即打开");
                    textView.setBackgroundDrawable(com.vivo.mobilead.util.g.a(this, com.vivo.mobilead.util.g.b(this, "webview_btn_bg_normal.png"), com.vivo.mobilead.util.g.b(this, "webview_btn_bg_pressed.png")));
                    textView.setOnClickListener(new l(0));
                } else {
                    textView.setText("立即预约");
                    textView.setBackgroundDrawable(com.vivo.mobilead.util.g.a(this, com.vivo.mobilead.util.g.b(this, "webview_btn_bg_normal.png"), com.vivo.mobilead.util.g.b(this, "webview_btn_bg_pressed.png")));
                    textView.setOnClickListener(new l(3));
                }
            } else if (com.vivo.mobilead.util.j.b(this, y.a())) {
                r z2 = this.mAdItemData.z();
                if (z2 == null || 1 != z2.a()) {
                    textView.setText("立即预约");
                    textView.setBackgroundDrawable(com.vivo.mobilead.util.g.a(this, com.vivo.mobilead.util.g.b(this, "webview_btn_bg_normal.png"), com.vivo.mobilead.util.g.b(this, "webview_btn_bg_pressed.png")));
                    textView.setOnClickListener(new l(0));
                } else {
                    textView.setText("查看详情");
                    textView.setBackgroundDrawable(com.vivo.mobilead.util.g.a(this, com.vivo.mobilead.util.g.b(this, "webview_btn_bg_normal.png"), com.vivo.mobilead.util.g.b(this, "webview_btn_bg_pressed.png")));
                    textView.setOnClickListener(new l(1));
                }
            } else {
                textView.setText("立即下载");
                textView.setBackgroundDrawable(com.vivo.mobilead.util.g.a(this, com.vivo.mobilead.util.g.b(this, "webview_btn_bg_normal.png"), com.vivo.mobilead.util.g.b(this, "webview_btn_bg_pressed.png")));
                textView.setOnClickListener(new l(2));
            }
        }
        v I = this.mAdItemData.I();
        if (I != null && 1 == I.a()) {
            z = true;
        }
        if (this.mAdItemData.Z() && z) {
            textView.setText("查看详情");
            textView.setBackgroundDrawable(com.vivo.mobilead.util.g.a(this, com.vivo.mobilead.util.g.b(this, "webview_btn_bg_normal.png"), com.vivo.mobilead.util.g.b(this, "webview_btn_bg_pressed.png")));
            textView.setOnClickListener(new l(1));
        }
    }

    private void setTopOfPage(LinearLayout linearLayout) {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.vivo.mobilead.util.m.b(this, 46.0f)));
        relativeLayout.setBackgroundColor(getResources().getColor(R.color.white));
        TextView textView = new TextView(this);
        this.titleTextView = textView;
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(13);
        this.titleTextView.setLayoutParams(layoutParams);
        q y = this.mAdItemData.y();
        if (this.isH5 && y != null) {
            this.titleTextView.setText(y.d());
        }
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(com.vivo.mobilead.util.g.b(this, "vivo_module_biz_webview_backbt.png"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.vivo.mobilead.util.m.b(this, 32.0f), com.vivo.mobilead.util.m.b(this, 32.0f));
        layoutParams2.leftMargin = com.vivo.mobilead.util.m.b(this, 10.0f);
        layoutParams2.addRule(15);
        imageView.setLayoutParams(layoutParams2);
        imageView.setOnClickListener(new f());
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageDrawable(com.vivo.mobilead.util.g.b(this, "vivo_module_biz_webview_closebt.png"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.vivo.mobilead.util.m.b(this, 32.0f), com.vivo.mobilead.util.m.b(this, 32.0f));
        layoutParams3.leftMargin = com.vivo.mobilead.util.m.b(this, 62.0f);
        layoutParams3.addRule(15);
        imageView2.setLayoutParams(layoutParams3);
        imageView2.setOnClickListener(new g());
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        relativeLayout.addView(this.titleTextView);
        linearLayout.addView(relativeLayout);
        TextView textView2 = new TextView(this);
        textView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, 1));
        textView2.setBackgroundColor(getResources().getColor(R.color.darker_gray));
        linearLayout.addView(textView2);
    }

    private void setTopOfPage4H5(Context context, RelativeLayout relativeLayout) {
        this.mCloseView = new TextView(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#80333333"));
        gradientDrawable.setStroke(1, Color.parseColor("#80FFFFFF"));
        gradientDrawable.setCornerRadius(com.vivo.mobilead.util.m.b(context, 12.67f));
        this.mCloseView.setText("关闭");
        this.mCloseView.setTextSize(1, 12.0f);
        this.mCloseView.setGravity(17);
        this.mCloseView.setTextColor(Color.parseColor("#FFFFFF"));
        this.mCloseView.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.vivo.mobilead.util.m.b(context, 54.67f), com.vivo.mobilead.util.m.b(context, 25.33f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        if (com.vivo.mobilead.util.m.c(context) == 1) {
            layoutParams.rightMargin = com.vivo.mobilead.util.m.b(context, 20.0f);
        } else {
            layoutParams.rightMargin = com.vivo.mobilead.util.m.b(context, 24.66f);
        }
        layoutParams.topMargin = com.vivo.mobilead.util.m.a(context, 19.33f);
        this.mCloseView.setLayoutParams(layoutParams);
        this.mCloseView.setVisibility(8);
        relativeLayout.addView(this.mCloseView);
        this.mCloseView.setOnClickListener(new h());
        com.vivo.ad.view.c cVar = new com.vivo.ad.view.c(context);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(Color.parseColor("#80333333"));
        gradientDrawable2.setStroke(1, Color.parseColor("#80FFFFFF"));
        gradientDrawable2.setCornerRadius(com.vivo.mobilead.util.m.b(context, 3.0f));
        cVar.setTagBackground(gradientDrawable2);
        cVar.a(10, -1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(10);
        layoutParams2.addRule(9);
        layoutParams2.leftMargin = com.vivo.mobilead.util.m.a(context, 20.0f);
        layoutParams2.topMargin = com.vivo.mobilead.util.m.a(context, 25.0f);
        cVar.setLayoutParams(layoutParams2);
        relativeLayout.addView(cVar);
        if (this.mAdItemData != null) {
            cVar.a(com.vivo.mobilead.h.b.a().a(this.mAdItemData.e()), this.mAdItemData.k(), this.mAdItemData.O());
        }
    }

    public String getRequestUrl(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String E = this.isMid ? this.mAdItemData.E() : this.mAdItemData.v();
        this.mIsRemoveHeaderFooter = bundle.getBoolean("com.vivo.adsdk.ikey.REMOVE_HEADER_FOOTER");
        return E;
    }

    public TextView getTitleTextView() {
        return this.titleTextView;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.isH5) {
            return;
        }
        if (this.mWebview.canGoBack()) {
            this.mWebview.goBack();
            return;
        }
        this.isHaveReport = false;
        try {
            super.onBackPressed();
        } catch (Exception e2) {
            VOpenLog.e(TAG, "back failed: " + e2.getMessage());
        }
    }

    @Override // android.app.Activity
    @SuppressLint({"JavascriptInterface"})
    protected void onCreate(Bundle bundle) {
        com.vivo.ad.model.e c2;
        x0.a(TAG, "onCreate");
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || intent.getExtras() == null || intent.getExtras().getSerializable("ad_item") == null) {
            finish();
            return;
        }
        this.backUrlInfo = (BackUrlInfo) intent.getSerializableExtra("backurl_info");
        this.sourceAppend = intent.getStringExtra("sourceAppend");
        this.pageSrc = intent.getStringExtra("pageSrc");
        this.uiVersion = intent.getIntExtra("uiVersion", 0);
        this.renderType = intent.getIntExtra("renderType", 1);
        x0.b(TAG, "落地页来源pageSrc:" + this.pageSrc);
        if (this.backUrlInfo != null) {
            x0.d(TAG, "mBackUrlInfo ::" + this.backUrlInfo.toString());
        }
        try {
            requestWindowFeature(1);
        } catch (Exception unused) {
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.white));
        Bundle extras = getIntent().getExtras();
        com.vivo.ad.model.b bVar = (com.vivo.ad.model.b) extras.getSerializable("ad_item");
        this.mAdItemData = bVar;
        if (bVar != null && (c2 = bVar.c()) != null) {
            this.mH5CloseBtnDelayShowTime = c2.i();
        }
        this.isMid = extras.getBoolean("ad_mid_page");
        this.mNeedReportClose = extras.getBoolean("need_report_close", false);
        this.mPlaysStatus = extras.getString("playsstatus", "");
        this.mBroadcastTime = extras.getInt("broadcasttime");
        this.mLinkOpt = extras.getBoolean("link_opt");
        this.allowJumpNonClick = extras.getBoolean("allowJumpNonClick", true);
        boolean z = extras.getBoolean("ad_h5_with_bt");
        String requestUrl = getRequestUrl(extras);
        com.vivo.ad.model.b bVar2 = this.mAdItemData;
        if (bVar2 != null && (bVar2.j() == 5 || this.mAdItemData.j() == 6)) {
            this.isH5 = true;
        }
        if (!this.isH5) {
            setTopOfPage(linearLayout);
        }
        com.vivo.mobilead.web.e eVar = new com.vivo.mobilead.web.e(this);
        try {
            com.vivo.ad.model.e c3 = this.mAdItemData.c();
            if (c3 != null) {
                this.clickH5MaxInterval = c3.g();
            }
            CommonWebView commonWebView = new CommonWebView(this);
            this.mWebview = commonWebView;
            commonWebView.setWebChromeClient(new HtmlWebChromeClient(this));
            this.mWebview.setDownloadListener(new WebViewDownloadListener(this, eVar, this.clickH5MaxInterval, this.allowJumpNonClick));
            CommonWebView commonWebView2 = this.mWebview;
            CommonWebView commonWebView3 = this.mWebview;
            commonWebView2.setWebViewClient(new d(this, commonWebView3, commonWebView3, this.isH5, eVar, this.clickH5MaxInterval, this.allowJumpNonClick));
            this.mWebview.addJavascriptInterface(new m(eVar, this.allowJumpNonClick, this.clickH5MaxInterval), "downloadAdScript");
            this.mWebview.addJavascriptInterface(new m(eVar, this.allowJumpNonClick, this.clickH5MaxInterval), "adScript");
            eVar.addView(this.mWebview, new ViewGroup.LayoutParams(-1, -1));
            if (!this.isH5) {
                linearLayout.addView(eVar, new ViewGroup.LayoutParams(-1, -1));
            }
            if (TextUtils.isEmpty(requestUrl)) {
                x0.b(TAG, "get request url is empty!");
                finish();
                return;
            }
            x0.a(TAG, "The Url:" + requestUrl);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            if (this.isH5) {
                relativeLayout.addView(eVar, new ViewGroup.LayoutParams(-1, -1));
                setTopOfPage4H5(this, relativeLayout);
            } else {
                relativeLayout.addView(linearLayout);
            }
            this.mWebview.loadUrl(requestUrl);
            LinearLayout linearLayout2 = new LinearLayout(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.vivo.mobilead.util.m.b(this, 49.0f));
            layoutParams.addRule(12);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(17);
            linearLayout2.setBackgroundColor(getResources().getColor(R.color.white));
            TextView textView = new TextView(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.b(this, 270.0f), com.vivo.mobilead.util.m.b(this, 45.0f)));
            textView.setTextSize(1, 16.0f);
            textView.setTextColor(-1);
            textView.setGravity(17);
            setBottomBtnStyle(textView);
            linearLayout2.addView(textView);
            relativeLayout.addView(linearLayout2);
            TextView textView2 = new TextView(this);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 1);
            layoutParams2.bottomMargin = com.vivo.mobilead.util.m.b(this, 49.0f);
            layoutParams2.addRule(12);
            textView2.setLayoutParams(layoutParams2);
            textView2.setBackgroundColor(getResources().getColor(R.color.darker_gray));
            relativeLayout.addView(textView2);
            if (z) {
                textView2.setVisibility(0);
                linearLayout2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
                linearLayout2.setVisibility(8);
            }
            setContentView(relativeLayout);
            this.mUiHandler.postDelayed(new e(), this.mH5CloseBtnDelayShowTime * 1000);
        } catch (Exception e2) {
            x0.b(TAG, "init webview error", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CommonWebView commonWebView = this.mWebview;
        if (commonWebView != null) {
            commonWebView.removeJavascriptInterface("downloadAdScript");
            if (this.mWebview.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mWebview.getParent()).removeView(this.mWebview);
            }
            this.mWebview.removeAllViews();
            this.mWebview.destroy();
        }
    }

    protected void reportAdDeepLink(com.vivo.ad.model.b bVar, int i2, int i3, String str) {
        a1.e(new b(bVar, i2, str, i3));
    }

    protected void reportAdH5(com.vivo.ad.model.b bVar, int i2) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "222");
        hashMap.put("ptype", PTYPE_MAPS.get(String.valueOf(this.mAdItemData.l())));
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("renderType", String.valueOf(bVar.a().a()));
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("clickArea", String.valueOf(i2));
        hashMap.put("preturn", String.valueOf(this.clickResponse));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn/clickinh5", hashMap), "vivo");
        cVar.c(bVar.G());
        cVar.e(this.sourceAppend);
        reportEvent(cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        if (1 == r2.a()) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void reportAdThirdPartyEvent(com.vivo.ad.model.b r20, com.vivo.mobilead.model.a.EnumC0603a r21, float r22, float r23, float r24, float r25, float r26, float r27, float r28, float r29) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            if (r20 == 0) goto Ld9
            java.util.List r2 = r20.h()
            if (r2 == 0) goto Ld9
            java.util.List r2 = r20.h()
            int r2 = r2.size()
            if (r2 <= 0) goto Ld9
            r2 = 0
            com.vivo.mobilead.model.a$a r3 = com.vivo.mobilead.model.a.EnumC0603a.CLICK
            r4 = 2
            r5 = 3
            r6 = 1
            if (r3 != r1) goto L62
            com.vivo.ad.model.b r3 = r0.mAdItemData
            boolean r3 = r3.T()
            if (r3 == 0) goto L45
            com.vivo.ad.model.q r3 = r20.y()
            if (r3 == 0) goto L62
            java.lang.String r2 = r3.a()
            boolean r2 = com.vivo.mobilead.util.j.b(r0, r2)
            if (r2 == 0) goto L43
            com.vivo.ad.model.r r2 = r20.z()
            if (r2 == 0) goto L5d
            int r2 = r2.a()
            if (r6 != r2) goto L5d
            goto L61
        L43:
            r2 = 1
            goto L62
        L45:
            com.vivo.ad.model.b r3 = r0.mAdItemData
            boolean r3 = r3.U()
            if (r3 == 0) goto L61
            com.vivo.ad.model.q r3 = r20.y()
            if (r3 == 0) goto L62
            java.lang.String r2 = r3.a()
            boolean r2 = com.vivo.mobilead.util.j.b(r0, r2)
            if (r2 == 0) goto L5f
        L5d:
            r2 = 2
            goto L62
        L5f:
            r2 = 4
            goto L62
        L61:
            r2 = 3
        L62:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r4 = r20.h()
            java.util.Iterator r4 = r4.iterator()
        L6f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L89
            java.lang.Object r5 = r4.next()
            com.vivo.ad.model.h r5 = (com.vivo.ad.model.h) r5
            int r7 = r5.b()
            int r8 = r21.a()
            if (r7 != r8) goto L6f
            r3.add(r5)
            goto L6f
        L89:
            java.util.Iterator r3 = r3.iterator()
        L8d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Ld9
            java.lang.Object r4 = r3.next()
            com.vivo.ad.model.h r4 = (com.vivo.ad.model.h) r4
            com.vivo.mobilead.b.c r5 = new com.vivo.mobilead.b.c
            java.lang.String r7 = r4.c()
            long r8 = java.lang.System.currentTimeMillis()
            r10 = r2
            r11 = r22
            r12 = r23
            r13 = r24
            r14 = r25
            r15 = r26
            r16 = r27
            r17 = r28
            r18 = r29
            java.lang.String r7 = com.vivo.mobilead.i.g.a(r7, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            java.lang.String r8 = "vivo"
            r5.<init>(r7, r8)
            int r4 = r4.a()
            r5.c(r4)
            r5.b(r6)
            r5.a(r1)
            com.vivo.mobilead.b.b r4 = com.vivo.mobilead.b.b.c()
            r4.b(r5)
            com.vivo.mobilead.manager.c r4 = com.vivo.mobilead.manager.c.d()
            r4.a(r5)
            goto L8d
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.web.VivoADSDKWebView.reportAdThirdPartyEvent(com.vivo.ad.model.b, com.vivo.mobilead.model.a$a, float, float, float, float, float, float, float, float):void");
    }

    protected void reportClickEvent(int i2, int i3, String str, boolean z) {
        com.vivo.ad.model.b bVar = this.mAdItemData;
        if (bVar == null) {
            return;
        }
        if (!this.mIsClicked && !com.vivo.mobilead.manager.b.l().getBoolean("is_click", false)) {
            this.mIsClicked = true;
            u0.a(bVar, a.EnumC0603a.CLICK, -999, -999, -999, -999, -999, -999, -999, -999, this.sourceAppend);
            com.vivo.mobilead.manager.b.l().putBoolean("is_click", this.mIsClicked);
        }
        k0.a(bVar, com.vivo.mobilead.util.f.b(this, bVar), i2, i3, -999, -999, -999, -999, this.clickResponse, this.sourceAppend, bVar.i(), c.a.f28912a + "", 1, false, str, z);
    }

    protected void reportEvent(com.vivo.mobilead.b.c cVar) {
        if (cVar != null) {
            cVar.b(this.mAdItemData.C());
            com.vivo.mobilead.b.b.c().b(cVar);
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }

    protected void reportRpkAdDeepLink(com.vivo.ad.model.b bVar, int i2) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "218");
        hashMap.put("ptype", this.mAdItemData.i());
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("renderType", String.valueOf(bVar.a().a()));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
            if (this.isMid) {
                hashMap.put("scene", String.valueOf(2));
                hashMap.put("dfrom", String.valueOf(1));
            }
        } else {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("status", String.valueOf(i2));
        hashMap.put("dspid", String.valueOf(bVar.q()));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.c(bVar.G());
        cVar.e(this.sourceAppend);
        reportEvent(cVar);
    }

    protected void reportVideoADClick(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, int i6, boolean z) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "212");
        hashMap.put("ptype", this.mAdItemData.i());
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("uiVersion", this.uiVersion + "");
        hashMap.put("renderType", String.valueOf(bVar.a().a()));
        hashMap.put("dlCfg", z ? "2" : "1");
        if (this.mAdItemData.l() == 9) {
            hashMap.put("dfrom", String.valueOf(1));
        }
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("ad_sdk", c.a.f28912a + "");
        hashMap.put("realX", String.valueOf(i3));
        hashMap.put("realY", String.valueOf(i4));
        hashMap.put("x", String.valueOf(i5));
        hashMap.put("y", String.valueOf(i6));
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("scene", String.valueOf(i2));
        hashMap.put("preturn", String.valueOf(this.clickResponse));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.c(bVar.G());
        cVar.e(this.sourceAppend);
        reportEvent(cVar);
    }

    class i implements a.g {
        i() {
        }

        @Override // com.vivo.ad.a.g
        public void a() {
            VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
            vivoADSDKWebView.reportAdDeepLink(vivoADSDKWebView.mAdItemData, 0, 0, "");
            VivoADSDKWebView.this.clickResponse = 1;
        }

        @Override // com.vivo.ad.a.g
        public void a(int i2, String str) {
            VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
            vivoADSDKWebView.reportAdDeepLink(vivoADSDKWebView.mAdItemData, 1, i2, str);
            VivoADSDKWebView.this.dealRpkDeeplink();
        }
    }

    class j implements a.g {
        j() {
        }

        @Override // com.vivo.ad.a.g
        public void a() {
            VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
            vivoADSDKWebView.reportAdDeepLink(vivoADSDKWebView.mAdItemData, 0, 0, "");
            VivoADSDKWebView.this.clickResponse = 1;
        }

        @Override // com.vivo.ad.a.g
        public void a(int i2, String str) {
            int i3;
            VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
            vivoADSDKWebView.reportAdDeepLink(vivoADSDKWebView.mAdItemData, 1, i2, str);
            if (SystemUtils.isVivoPhone()) {
                VivoADSDKWebView.this.goApp();
                return;
            }
            try {
                i3 = Integer.parseInt(VivoADSDKWebView.this.pageSrc);
            } catch (Exception unused) {
                i3 = -1;
            }
            VivoADSDKWebView vivoADSDKWebView2 = VivoADSDKWebView.this;
            vivoADSDKWebView2.clickResponse = u.a((Context) vivoADSDKWebView2, vivoADSDKWebView2.mAdItemData, VivoADSDKWebView.this.sourceAppend, VivoADSDKWebView.this.renderType, VivoADSDKWebView.this.uiVersion, i3, VivoADSDKWebView.this.clickResponse, VivoADSDKWebView.this.backUrlInfo, false);
        }
    }

    class k implements a.g {

        class a extends com.vivo.mobilead.util.f1.b {
            a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                VivoADSDKWebView.this.mWebview.loadUrl(VivoADSDKWebView.this.mAdItemData.v());
            }
        }

        k() {
        }

        @Override // com.vivo.ad.a.g
        public void a() {
            VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
            vivoADSDKWebView.reportAdDeepLink(vivoADSDKWebView.mAdItemData, 0, 0, "");
            VivoADSDKWebView.this.clickResponse = 1;
        }

        @Override // com.vivo.ad.a.g
        public void a(int i2, String str) {
            VivoADSDKWebView vivoADSDKWebView = VivoADSDKWebView.this;
            vivoADSDKWebView.reportAdDeepLink(vivoADSDKWebView.mAdItemData, 1, i2, str);
            VivoADSDKWebView.this.clickResponse = 0;
            VivoADSDKWebView.mainHandler.post(new a());
        }
    }

    public void goApp(boolean z) {
        q y = this.mAdItemData.y();
        if (y != null) {
            if (com.vivo.mobilead.util.j.b(this, y.a())) {
                w.b(this.mAdItemData, "3005002", String.valueOf(this.uiVersion));
                com.vivo.mobilead.util.j.a(this, y.a(), this.mAdItemData, this.sourceAppend, String.valueOf(this.renderType), String.valueOf(this.uiVersion));
                this.clickResponse = 1;
            } else {
                com.vivo.mobilead.util.j.a(this, this.mAdItemData, z, this.sourceAppend, this.uiVersion);
                this.clickResponse = 2;
            }
        }
    }
}
