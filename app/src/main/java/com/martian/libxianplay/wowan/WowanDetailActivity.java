package com.martian.libxianplay.wowan;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.martian.libxianplay.R;
import com.martian.libxianplay.util.StatusBarUtil;
import com.martian.libxianplay.wowan.WowanDetailActivity;
import la.c;

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
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        public /* synthetic */ void lambda$run$0(int i10) {
            X5JavaScriptInterface.mWebView.loadUrl("javascript:downloadApkFileProcessListener(" + WowanDetailActivity.this.mStringAdid + "," + i10 + ")");
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] bytesAndStatus = PlayMeUtils.getBytesAndStatus(WowanDetailActivity.this.mLongDownLoadId.longValue(), WowanDetailActivity.this.downloadManager);
            int i10 = bytesAndStatus[0];
            int i11 = bytesAndStatus[1];
            if (WowanDetailActivity.this.mWebView == null || i10 <= 0 || i11 <= 0) {
                WowanDetailActivity.this.mHandler.postDelayed(this, 3000L);
                return;
            }
            WowanDetailActivity.this.mWebView.post(new Runnable() { // from class: com.martian.libxianplay.wowan.a

                /* renamed from: c */
                public final /* synthetic */ int f13067c;

                public /* synthetic */ a(int i12) {
                    parseFloat = i12;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WowanDetailActivity.AnonymousClass1.this.lambda$run$0(parseFloat);
                }
            });
            WowanDetailActivity.this.mHandler.postDelayed(this, 1000L);
        }
    }

    /* renamed from: com.martian.libxianplay.wowan.WowanDetailActivity$2 */
    public class AnonymousClass2 extends WebViewClient {
        public AnonymousClass2() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (WowanDetailActivity.this.mRefreshLayout != null) {
                WowanDetailActivity.this.mRefreshLayout.setRefreshing(false);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str) || str.contains("Wall_Adinfo.aspx")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(parse);
                if (WowanDetailActivity.this.getPackageManager().resolveActivity(intent, 65536) == null) {
                    return true;
                }
                WowanDetailActivity.this.startActivity(intent);
                return true;
            } catch (Exception e10) {
                e10.printStackTrace();
                return true;
            }
        }
    }

    public class DownLoadBroadcast extends BroadcastReceiver {
        public /* synthetic */ DownLoadBroadcast(WowanDetailActivity wowanDetailActivity, c cVar) {
            this();
        }

        public static /* synthetic */ void lambda$onReceive$0(String str, String str2) {
            X5JavaScriptInterface.mWebView.loadUrl("javascript:downloadApkFileFinishListener(" + str + ",'" + str2 + "')");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.martian.libxianplay.wowan.b.<init>(java.lang.String, java.lang.String):void, class status: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
            	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
            */
        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context r5, android.content.Intent r6) {
            /*
                r4 = this;
                java.lang.String r5 = ""
                java.lang.String r0 = "extra_download_id"
                r1 = -1
                long r0 = r6.getLongExtra(r0, r1)
                java.lang.String r2 = r6.getAction()
                if (r2 != 0) goto L11
                return
            L11:
                java.lang.String r6 = r6.getAction()
                int r2 = r6.hashCode()
                r3 = -1828181659(0xffffffff93082965, float:-1.7186022E-27)
                if (r2 == r3) goto Lb3
                r3 = 1248865515(0x4a702ceb, float:3935034.8)
                if (r2 == r3) goto L25
                goto Lb8
            L25:
                java.lang.String r2 = "android.intent.action.DOWNLOAD_COMPLETE"
                boolean r6 = r6.equals(r2)
                if (r6 == 0) goto Lb8
                com.martian.libxianplay.wowan.WowanDetailActivity r6 = com.martian.libxianplay.wowan.WowanDetailActivity.this     // Catch: java.lang.Exception -> L53
                java.lang.Long r6 = com.martian.libxianplay.wowan.WowanDetailActivity.d1(r6)     // Catch: java.lang.Exception -> L53
                long r2 = r6.longValue()     // Catch: java.lang.Exception -> L53
                int r6 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r6 != 0) goto L55
                com.martian.libxianplay.wowan.WowanDetailActivity r6 = com.martian.libxianplay.wowan.WowanDetailActivity.this     // Catch: java.lang.Exception -> L53
                android.os.Handler r6 = com.martian.libxianplay.wowan.WowanDetailActivity.c1(r6)     // Catch: java.lang.Exception -> L53
                if (r6 == 0) goto L55
                com.martian.libxianplay.wowan.WowanDetailActivity r6 = com.martian.libxianplay.wowan.WowanDetailActivity.this     // Catch: java.lang.Exception -> L53
                android.os.Handler r6 = com.martian.libxianplay.wowan.WowanDetailActivity.c1(r6)     // Catch: java.lang.Exception -> L53
                com.martian.libxianplay.wowan.WowanDetailActivity r2 = com.martian.libxianplay.wowan.WowanDetailActivity.this     // Catch: java.lang.Exception -> L53
                java.lang.Runnable r2 = com.martian.libxianplay.wowan.WowanDetailActivity.h1(r2)     // Catch: java.lang.Exception -> L53
                r6.removeCallbacks(r2)     // Catch: java.lang.Exception -> L53
                goto L55
            L53:
                r5 = move-exception
                goto Laf
            L55:
                com.martian.libxianplay.wowan.WowanDetailActivity r6 = com.martian.libxianplay.wowan.WowanDetailActivity.this     // Catch: java.lang.Exception -> L53
                android.webkit.WebView r6 = com.martian.libxianplay.wowan.WowanDetailActivity.g1(r6)     // Catch: java.lang.Exception -> L53
                if (r6 == 0) goto Lb8
                com.martian.libxianplay.wowan.WowanDetailActivity r6 = com.martian.libxianplay.wowan.WowanDetailActivity.this     // Catch: java.lang.Exception -> L53
                java.lang.String r2 = "wowan"
                r3 = 0
                android.content.SharedPreferences r6 = r6.getSharedPreferences(r2, r3)     // Catch: java.lang.Exception -> L53
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L53
                r2.<init>()     // Catch: java.lang.Exception -> L53
                r2.append(r0)     // Catch: java.lang.Exception -> L53
                java.lang.String r3 = "path"
                r2.append(r3)     // Catch: java.lang.Exception -> L53
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L53
                java.lang.String r2 = r6.getString(r2, r5)     // Catch: java.lang.Exception -> L53
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L53
                r3.<init>()     // Catch: java.lang.Exception -> L53
                r3.append(r0)     // Catch: java.lang.Exception -> L53
                java.lang.String r0 = "adid"
                r3.append(r0)     // Catch: java.lang.Exception -> L53
                java.lang.String r0 = r3.toString()     // Catch: java.lang.Exception -> L53
                java.lang.String r5 = r6.getString(r0, r5)     // Catch: java.lang.Exception -> L53
                java.io.File r6 = new java.io.File     // Catch: java.lang.Exception -> L53
                r6.<init>(r2)     // Catch: java.lang.Exception -> L53
                boolean r0 = r6.exists()     // Catch: java.lang.Exception -> L53
                if (r0 == 0) goto La0
                com.martian.libxianplay.wowan.WowanDetailActivity r0 = com.martian.libxianplay.wowan.WowanDetailActivity.this     // Catch: java.lang.Exception -> L53
                com.martian.libxianplay.wowan.PlayMeUtils.installThroughUri(r0, r6)     // Catch: java.lang.Exception -> L53
            La0:
                com.martian.libxianplay.wowan.WowanDetailActivity r6 = com.martian.libxianplay.wowan.WowanDetailActivity.this     // Catch: java.lang.Exception -> L53
                android.webkit.WebView r6 = com.martian.libxianplay.wowan.WowanDetailActivity.g1(r6)     // Catch: java.lang.Exception -> L53
                com.martian.libxianplay.wowan.b r0 = new com.martian.libxianplay.wowan.b     // Catch: java.lang.Exception -> L53
                r0.<init>()     // Catch: java.lang.Exception -> L53
                r6.post(r0)     // Catch: java.lang.Exception -> L53
                goto Lb8
            Laf:
                r5.printStackTrace()
                goto Lb8
            Lb3:
                java.lang.String r5 = "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED"
                r6.equals(r5)
            Lb8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.martian.libxianplay.wowan.WowanDetailActivity.DownLoadBroadcast.onReceive(android.content.Context, android.content.Intent):void");
        }

        private DownLoadBroadcast() {
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
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.main_srl_detail);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#FA6B24"));
        View findViewById = findViewById(R.id.frameLayoutId_detail);
        findViewById.setBackgroundColor(Color.parseColor("#FA6B24"));
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, findViewById);
        StatusBarUtil.setPaddingSmart(this, this.mWebView);
        settings.setMixedContentMode(0);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setCacheMode(2);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setTextZoom(100);
        this.mWebView.setWebChromeClient(new WebChromeClient());
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.martian.libxianplay.wowan.WowanDetailActivity.2
            public AnonymousClass2() {
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                if (WowanDetailActivity.this.mRefreshLayout != null) {
                    WowanDetailActivity.this.mRefreshLayout.setRefreshing(false);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                if (TextUtils.isEmpty(str) || str.contains("Wall_Adinfo.aspx")) {
                    return super.shouldOverrideUrlLoading(webView2, str);
                }
                try {
                    Uri parse = Uri.parse(str);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(parse);
                    if (WowanDetailActivity.this.getPackageManager().resolveActivity(intent, 65536) == null) {
                        return true;
                    }
                    WowanDetailActivity.this.startActivity(intent);
                    return true;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return true;
                }
            }
        });
        WebView webView2 = this.mWebView;
        webView2.addJavascriptInterface(new X5JavaScriptInterface(this, webView2), "android");
        if (!TextUtils.isEmpty(this.mStringUrl)) {
            this.mWebView.loadUrl(this.mStringUrl);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: la.b
            public /* synthetic */ b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WowanDetailActivity.this.lambda$initView$0(view);
            }
        });
        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) findViewById(R.id.main_srl_detail);
        this.mRefreshLayout = swipeRefreshLayout2;
        swipeRefreshLayout2.setOnRefreshListener(this);
        this.downloadManager = (DownloadManager) getSystemService("download");
        this.mHandler = new Handler(Looper.getMainLooper());
        registerBroadcast();
        int i10 = PlayMeUtils.getBytesAndStatus(this.mLongDownLoadId.longValue(), this.downloadManager)[2];
        if (i10 == 2 || i10 == 1) {
            this.mHandler.postDelayed(this.runnable, 1000L);
        }
    }

    public /* synthetic */ void lambda$initView$0(View view) {
        finish();
    }

    public /* synthetic */ void lambda$onResume$1() {
        this.mWebView.loadUrl("javascript:pageViewDidAppear()");
    }

    private void registerBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        intentFilter.addAction("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
        DownLoadBroadcast downLoadBroadcast = new DownLoadBroadcast();
        this.downLoadBroadcast = downLoadBroadcast;
        registerReceiver(downLoadBroadcast, intentFilter);
    }

    public static void startWebViewActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) WowanDetailActivity.class);
        intent.putExtra(INTENT_WEBVIEW_URL, str + "&issdk=1&&sdkver=1.0");
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
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wowan_detail);
        this.mBooleanPageNeedLoad = false;
        if (bundle != null) {
            this.mStringUrl = bundle.getString(INTENT_WEBVIEW_URL);
        } else {
            this.mStringUrl = getIntent().getStringExtra(INTENT_WEBVIEW_URL);
        }
        try {
            this.mStringAdid = Uri.parse(this.mStringUrl).getQueryParameter("adid");
            this.mLongDownLoadId = Long.valueOf(getSharedPreferences("wowan", 0).getLong(this.mStringAdid, 0L));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        initView();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
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
    public void onResume() {
        super.onResume();
        WebView webView = this.mWebView;
        X5JavaScriptInterface.mWebView = webView;
        if (!this.mBooleanPageNeedLoad) {
            this.mBooleanPageNeedLoad = true;
        } else if (webView != null) {
            webView.post(new Runnable() { // from class: la.a
                public /* synthetic */ a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WowanDetailActivity.this.lambda$onResume$1();
                }
            });
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(INTENT_WEBVIEW_URL, this.mStringUrl);
    }

    public void startCheckProgressStates() {
        if (this.mHandler == null) {
            return;
        }
        this.mLongDownLoadId = Long.valueOf(getSharedPreferences("wowan", 0).getLong(this.mStringAdid, 0L));
        this.mHandler.postDelayed(this.runnable, 1000L);
    }
}
