package com.martian.libxianplay.wowan;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.OapsWrapper;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.martian.libxianplay.R;
import com.martian.libxianplay.util.StatusBarUtil;
import com.martian.libxianplay.wowan.WowanDetailActivity;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;

/* loaded from: classes3.dex */
public class WowanDetailActivity extends FragmentActivity implements SwipeRefreshLayout.OnRefreshListener {
    private static final String INTENT_WEBVIEW_URL = "INTENT_WEBVIEW_URL";
    public static final String mStringVer = "1.0";
    private static final int seconds = 1000;
    private BroadcastReceiver downLoadBroadcast;
    private DownloadManager downloadManager;
    private boolean mBooleanPageNeedLoad;
    private Handler mHandler;
    private SwipeRefreshLayout mRefreshLayout;
    private String mStringAdid;
    private String mStringUrl;
    private WebView mWebView;
    private Long mLongDownLoadId = 0L;
    private final Runnable runnable = new AnonymousClass1();

    /* renamed from: com.martian.libxianplay.wowan.WowanDetailActivity$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* renamed from: lambda$run$0 */
        public /* synthetic */ void a(final int percent) {
            X5JavaScriptInterface.mWebView.loadUrl("javascript:downloadApkFileProcessListener(" + WowanDetailActivity.this.mStringAdid + "," + percent + ")");
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] bytesAndStatus = PlayMeUtils.getBytesAndStatus(WowanDetailActivity.this.mLongDownLoadId.longValue(), WowanDetailActivity.this.downloadManager);
            int i2 = bytesAndStatus[0];
            int i3 = bytesAndStatus[1];
            int i4 = bytesAndStatus[2];
            if (WowanDetailActivity.this.mWebView == null || i2 <= 0 || i3 <= 0) {
                return;
            }
            final int parseFloat = (int) ((Float.parseFloat(i2 + "") / Float.parseFloat(i3 + "")) * 100.0f);
            WowanDetailActivity.this.mWebView.post(new Runnable() { // from class: com.martian.libxianplay.wowan.a
                @Override // java.lang.Runnable
                public final void run() {
                    WowanDetailActivity.AnonymousClass1.this.a(parseFloat);
                }
            });
            WowanDetailActivity.this.mHandler.postDelayed(this, 1000L);
        }
    }

    /* renamed from: com.martian.libxianplay.wowan.WowanDetailActivity$2 */
    class AnonymousClass2 extends WebViewClient {
        AnonymousClass2() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (WowanDetailActivity.this.mRefreshLayout != null) {
                WowanDetailActivity.this.mRefreshLayout.setRefreshing(false);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (TextUtils.isEmpty(url) || url.contains("Wall_Adinfo.aspx")) {
                return super.shouldOverrideUrlLoading(view, url);
            }
            try {
                Uri parse = Uri.parse(url);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(parse);
                if (WowanDetailActivity.this.getPackageManager().resolveActivity(intent, 65536) == null) {
                    return true;
                }
                WowanDetailActivity.this.startActivity(intent);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }
    }

    class DownLoadBroadcast extends BroadcastReceiver {
        private DownLoadBroadcast() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, -1L);
            if (intent.getAction() == null) {
                return;
            }
            String action = intent.getAction();
            char c2 = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -1828181659) {
                if (hashCode == 1248865515 && action.equals("android.intent.action.DOWNLOAD_COMPLETE")) {
                    c2 = 0;
                }
            } else if (action.equals("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED")) {
                c2 = 1;
            }
            if (c2 != 0) {
                return;
            }
            try {
                if (WowanDetailActivity.this.mLongDownLoadId.longValue() == longExtra && WowanDetailActivity.this.mHandler != null) {
                    WowanDetailActivity.this.mHandler.removeCallbacks(WowanDetailActivity.this.runnable);
                }
                if (WowanDetailActivity.this.mWebView != null) {
                    SharedPreferences sharedPreferences = WowanDetailActivity.this.getSharedPreferences("wowan", 0);
                    final String string = sharedPreferences.getString(longExtra + OapsWrapper.KEY_PATH, "");
                    final String string2 = sharedPreferences.getString(longExtra + OapsKey.KEY_ADID, "");
                    File file = new File(string);
                    if (file.exists()) {
                        PlayMeUtils.installThroughUri(WowanDetailActivity.this, file);
                    }
                    WowanDetailActivity.this.mWebView.post(new Runnable() { // from class: com.martian.libxianplay.wowan.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            X5JavaScriptInterface.mWebView.loadUrl("javascript:downloadApkFileFinishListener(" + string2 + ",'" + string + "')");
                        }
                    });
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* synthetic */ DownLoadBroadcast(WowanDetailActivity wowanDetailActivity, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    @TargetApi(21)
    private void initView() {
        ImageView imageView = (ImageView) findViewById(R.id.top_back_detail);
        WebView webView = (WebView) findViewById(R.id.webview_detail);
        this.mWebView = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        int i2 = R.id.main_srl_detail;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(i2);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#FA6B24"));
        View findViewById = findViewById(R.id.frameLayoutId_detail);
        findViewById.setBackgroundColor(Color.parseColor("#FA6B24"));
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, findViewById);
        StatusBarUtil.setPaddingSmart(this, this.mWebView);
        if (com.martian.libsupport.l.r()) {
            settings.setMixedContentMode(0);
        }
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setCacheMode(2);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setTextZoom(100);
        this.mWebView.setWebChromeClient(new WebChromeClient());
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.martian.libxianplay.wowan.WowanDetailActivity.2
            AnonymousClass2() {
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (WowanDetailActivity.this.mRefreshLayout != null) {
                    WowanDetailActivity.this.mRefreshLayout.setRefreshing(false);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (TextUtils.isEmpty(url) || url.contains("Wall_Adinfo.aspx")) {
                    return super.shouldOverrideUrlLoading(view, url);
                }
                try {
                    Uri parse = Uri.parse(url);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(parse);
                    if (WowanDetailActivity.this.getPackageManager().resolveActivity(intent, 65536) == null) {
                        return true;
                    }
                    WowanDetailActivity.this.startActivity(intent);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return true;
                }
            }
        });
        if (com.martian.libsupport.l.n()) {
            WebView webView2 = this.mWebView;
            webView2.addJavascriptInterface(new X5JavaScriptInterface(this, webView2), BaseWrapper.BASE_PKG_SYSTEM);
        }
        if (!TextUtils.isEmpty(this.mStringUrl)) {
            this.mWebView.loadUrl(this.mStringUrl);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libxianplay.wowan.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WowanDetailActivity.this.v(view);
            }
        });
        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) findViewById(i2);
        this.mRefreshLayout = swipeRefreshLayout2;
        swipeRefreshLayout2.setOnRefreshListener(this);
        this.downloadManager = (DownloadManager) getSystemService("download");
        this.mHandler = new Handler(Looper.getMainLooper());
        registerBroadcast();
        int i3 = PlayMeUtils.getBytesAndStatus(this.mLongDownLoadId.longValue(), this.downloadManager)[2];
        if (i3 == 2 || i3 == 1) {
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    /* renamed from: lambda$initView$0 */
    public /* synthetic */ void v(View v) {
        finish();
    }

    /* renamed from: lambda$onResume$1 */
    public /* synthetic */ void p0() {
        this.mWebView.loadUrl("javascript:pageViewDidAppear()");
    }

    private void registerBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        intentFilter.addAction("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
        DownLoadBroadcast downLoadBroadcast = new DownLoadBroadcast(this, null);
        this.downLoadBroadcast = downLoadBroadcast;
        registerReceiver(downLoadBroadcast, intentFilter);
    }

    public static void startWebViewActivity(Activity activity, String url) {
        Intent intent = new Intent(activity, (Class<?>) WowanDetailActivity.class);
        intent.putExtra(INTENT_WEBVIEW_URL, url + "&issdk=1&&sdkver=1.0");
        activity.startActivity(intent);
    }

    private void unregisterBroadcast() {
        BroadcastReceiver broadcastReceiver = this.downLoadBroadcast;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.downLoadBroadcast = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wowan_detail);
        this.mBooleanPageNeedLoad = false;
        if (savedInstanceState != null) {
            this.mStringUrl = savedInstanceState.getString(INTENT_WEBVIEW_URL);
        } else {
            this.mStringUrl = getIntent().getStringExtra(INTENT_WEBVIEW_URL);
        }
        try {
            this.mStringAdid = Uri.parse(this.mStringUrl).getQueryParameter(OapsKey.KEY_ADID);
            this.mLongDownLoadId = Long.valueOf(getSharedPreferences("wowan", 0).getLong(this.mStringAdid, 0L));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        initView();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mBooleanPageNeedLoad = false;
        unregisterBroadcast();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.runnable);
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        if (TextUtils.isEmpty(this.mStringUrl)) {
            return;
        }
        this.mWebView.loadUrl(this.mStringUrl);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        WebView webView = this.mWebView;
        X5JavaScriptInterface.mWebView = webView;
        if (!this.mBooleanPageNeedLoad) {
            this.mBooleanPageNeedLoad = true;
        } else if (webView != null) {
            webView.post(new Runnable() { // from class: com.martian.libxianplay.wowan.d
                @Override // java.lang.Runnable
                public final void run() {
                    WowanDetailActivity.this.p0();
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INTENT_WEBVIEW_URL, this.mStringUrl);
    }

    public void startCheckProgressStates() {
        if (this.mHandler == null) {
            return;
        }
        this.mLongDownLoadId = Long.valueOf(getSharedPreferences("wowan", 0).getLong(this.mStringAdid, 0L));
        this.mHandler.postDelayed(this.runnable, 1000L);
    }
}
