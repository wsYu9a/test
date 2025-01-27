package com.shu.priory.request;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.shu.priory.bean.DownloadDialogInfo;
import com.shu.priory.bridge.DSBridgeWebView;
import com.shu.priory.c.a;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.download.DialogListener;
import com.shu.priory.download.DownLoadDialogCallback;
import com.shu.priory.utils.h;
import com.shu.priory.utils.j;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class IFLYBrowser extends Activity {

    /* renamed from: a */
    com.shu.priory.bridge.d f17187a = new com.shu.priory.bridge.d() { // from class: com.shu.priory.request.IFLYBrowser.3

        /* renamed from: com.shu.priory.request.IFLYBrowser$3$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SystemClock.sleep(1000L);
                    IFLYBrowser iFLYBrowser = IFLYBrowser.this;
                    iFLYBrowser.a(iFLYBrowser.f17201o, true);
                    IFLYBrowser.this.f17201o = null;
                } catch (Throwable unused) {
                }
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.shu.priory.bridge.d
        public void a() {
            if (IFLYBrowser.this.f17200n <= 0 || IFLYBrowser.this.f17200n >= 4) {
                return;
            }
            IFLYBrowser.this.f17203q.removeMessages(1);
            if (TextUtils.isEmpty(IFLYBrowser.this.f17201o) || IFLYBrowser.this.f17202p) {
                return;
            }
            new Thread(new Runnable() { // from class: com.shu.priory.request.IFLYBrowser.3.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        SystemClock.sleep(1000L);
                        IFLYBrowser iFLYBrowser = IFLYBrowser.this;
                        iFLYBrowser.a(iFLYBrowser.f17201o, true);
                        IFLYBrowser.this.f17201o = null;
                    } catch (Throwable unused) {
                    }
                }
            }).start();
        }

        @Override // com.shu.priory.bridge.d
        public void b() {
            IFLYBrowser iFLYBrowser = IFLYBrowser.this;
            iFLYBrowser.a(iFLYBrowser.f17196j);
            if (IFLYBrowser.this.f17202p || IFLYBrowser.this.f17200n != 0) {
                return;
            }
            IFLYBrowser.this.a();
        }

        @Override // com.shu.priory.bridge.d
        public void a(int i10, String str) {
        }

        @Override // com.shu.priory.bridge.d
        public boolean a(WebView webView, String str) {
            if (!com.shu.priory.utils.b.a(str)) {
                return false;
            }
            IFLYBrowser.this.f17201o = str;
            if (IFLYBrowser.this.f17197k) {
                return true;
            }
            IFLYBrowser.this.a(str, false);
            return true;
        }
    };

    /* renamed from: b */
    WebChromeClient f17188b = new WebChromeClient() { // from class: com.shu.priory.request.IFLYBrowser.4
        public AnonymousClass4() {
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            permissionRequest.grant(permissionRequest.getResources());
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            if (i10 != 100) {
                IFLYBrowser.this.f17191e.setVisibility(0);
                IFLYBrowser.this.f17191e.setProgress(i10);
            } else if (IFLYBrowser.this.f17191e != null) {
                IFLYBrowser.this.f17191e.setVisibility(8);
            }
        }
    };

    /* renamed from: c */
    DialogListener f17189c = new DialogListener() { // from class: com.shu.priory.request.IFLYBrowser.5
        public AnonymousClass5() {
        }

        @Override // com.shu.priory.download.DialogListener
        public void onCancel() {
            IFLYBrowser.this.finish();
        }

        @Override // com.shu.priory.download.DialogListener
        public void onConfirm() {
            IFLYBrowser.this.finish();
        }

        @Override // com.shu.priory.download.DialogListener
        public void onDownloading() {
        }

        @Override // com.shu.priory.download.DialogListener
        public boolean onShowDownloadDialog(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
            return false;
        }
    };

    /* renamed from: d */
    private DSBridgeWebView f17190d;

    /* renamed from: e */
    private ProgressBar f17191e;

    /* renamed from: f */
    private ImageView f17192f;

    /* renamed from: g */
    private RelativeLayout f17193g;

    /* renamed from: h */
    private com.shu.priory.bridge.b f17194h;

    /* renamed from: i */
    private String f17195i;

    /* renamed from: j */
    private String f17196j;

    /* renamed from: k */
    private boolean f17197k;

    /* renamed from: l */
    private JSONArray f17198l;

    /* renamed from: m */
    private JSONObject f17199m;

    /* renamed from: n */
    private int f17200n;

    /* renamed from: o */
    private String f17201o;

    /* renamed from: p */
    private boolean f17202p;

    /* renamed from: q */
    private Handler f17203q;

    /* renamed from: r */
    private HandlerThread f17204r;

    /* renamed from: s */
    private boolean f17205s;

    /* renamed from: com.shu.priory.request.IFLYBrowser$1 */
    public class AnonymousClass1 extends Handler {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            IFLYBrowser.this.a();
        }
    }

    /* renamed from: com.shu.priory.request.IFLYBrowser$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IFLYBrowser.this.finish();
        }
    }

    /* renamed from: com.shu.priory.request.IFLYBrowser$3 */
    public class AnonymousClass3 implements com.shu.priory.bridge.d {

        /* renamed from: com.shu.priory.request.IFLYBrowser$3$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SystemClock.sleep(1000L);
                    IFLYBrowser iFLYBrowser = IFLYBrowser.this;
                    iFLYBrowser.a(iFLYBrowser.f17201o, true);
                    IFLYBrowser.this.f17201o = null;
                } catch (Throwable unused) {
                }
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.shu.priory.bridge.d
        public void a() {
            if (IFLYBrowser.this.f17200n <= 0 || IFLYBrowser.this.f17200n >= 4) {
                return;
            }
            IFLYBrowser.this.f17203q.removeMessages(1);
            if (TextUtils.isEmpty(IFLYBrowser.this.f17201o) || IFLYBrowser.this.f17202p) {
                return;
            }
            new Thread(new Runnable() { // from class: com.shu.priory.request.IFLYBrowser.3.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        SystemClock.sleep(1000L);
                        IFLYBrowser iFLYBrowser = IFLYBrowser.this;
                        iFLYBrowser.a(iFLYBrowser.f17201o, true);
                        IFLYBrowser.this.f17201o = null;
                    } catch (Throwable unused) {
                    }
                }
            }).start();
        }

        @Override // com.shu.priory.bridge.d
        public void b() {
            IFLYBrowser iFLYBrowser = IFLYBrowser.this;
            iFLYBrowser.a(iFLYBrowser.f17196j);
            if (IFLYBrowser.this.f17202p || IFLYBrowser.this.f17200n != 0) {
                return;
            }
            IFLYBrowser.this.a();
        }

        @Override // com.shu.priory.bridge.d
        public void a(int i10, String str) {
        }

        @Override // com.shu.priory.bridge.d
        public boolean a(WebView webView, String str) {
            if (!com.shu.priory.utils.b.a(str)) {
                return false;
            }
            IFLYBrowser.this.f17201o = str;
            if (IFLYBrowser.this.f17197k) {
                return true;
            }
            IFLYBrowser.this.a(str, false);
            return true;
        }
    }

    /* renamed from: com.shu.priory.request.IFLYBrowser$4 */
    public class AnonymousClass4 extends WebChromeClient {
        public AnonymousClass4() {
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            permissionRequest.grant(permissionRequest.getResources());
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            if (i10 != 100) {
                IFLYBrowser.this.f17191e.setVisibility(0);
                IFLYBrowser.this.f17191e.setProgress(i10);
            } else if (IFLYBrowser.this.f17191e != null) {
                IFLYBrowser.this.f17191e.setVisibility(8);
            }
        }
    }

    /* renamed from: com.shu.priory.request.IFLYBrowser$5 */
    public class AnonymousClass5 implements DialogListener {
        public AnonymousClass5() {
        }

        @Override // com.shu.priory.download.DialogListener
        public void onCancel() {
            IFLYBrowser.this.finish();
        }

        @Override // com.shu.priory.download.DialogListener
        public void onConfirm() {
            IFLYBrowser.this.finish();
        }

        @Override // com.shu.priory.download.DialogListener
        public void onDownloading() {
        }

        @Override // com.shu.priory.download.DialogListener
        public boolean onShowDownloadDialog(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
            return false;
        }
    }

    /* renamed from: com.shu.priory.request.IFLYBrowser$6 */
    public class AnonymousClass6 implements a.InterfaceC0551a {
        public AnonymousClass6() {
        }

        @Override // com.shu.priory.c.a.InterfaceC0551a
        public void imageLoad(Bitmap bitmap) {
            if (IFLYBrowser.this.f17192f != null) {
                IFLYBrowser.this.f17192f.setImageBitmap(bitmap);
            }
        }
    }

    public class a implements DownloadListener {
        public a() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            com.shu.priory.download.c a10 = com.shu.priory.download.c.a(IFLYBrowser.this.getApplicationContext());
            a10.a(IFLYBrowser.this.f17189c);
            a10.a(IFLYBrowser.this.getIntent().getBooleanExtra("is_show", false));
            a10.a((Context) IFLYBrowser.this, str);
        }
    }

    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        this.f17193g = new RelativeLayout(getApplicationContext());
        ProgressBar progressBar = new ProgressBar(getApplicationContext(), null, R.attr.progressBarStyleHorizontal);
        this.f17191e = progressBar;
        progressBar.setId(16715776);
        this.f17191e.setMax(100);
        this.f17191e.setProgress(0);
        this.f17200n = 0;
        this.f17202p = false;
        try {
            this.f17197k = false;
            Intent intent = getIntent();
            if (intent != null) {
                this.f17198l = new JSONArray(intent.getStringExtra("general_monitor_urls"));
                String stringExtra = intent.getStringExtra("sjc");
                if (!TextUtils.isEmpty(stringExtra)) {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    this.f17199m = jSONObject;
                    this.f17197k = jSONObject.optBoolean("j");
                }
            }
        } catch (Exception unused) {
        }
        HandlerThread handlerThread = new HandlerThread("hh");
        this.f17204r = handlerThread;
        handlerThread.start();
        this.f17203q = new Handler(this.f17204r.getLooper()) { // from class: com.shu.priory.request.IFLYBrowser.1
            public AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                IFLYBrowser.this.a();
            }
        };
        DSBridgeWebView dSBridgeWebView = new DSBridgeWebView(this);
        this.f17190d = dSBridgeWebView;
        dSBridgeWebView.getSettings().setDomStorageEnabled(true);
        this.f17190d.getSettings().setSavePassword(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 16715776);
        this.f17192f = new ImageView(getApplicationContext());
        this.f17196j = getIntent().getStringExtra("close_url");
        int a10 = a(getApplicationContext(), 27.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a10, a10);
        int a11 = a(getApplicationContext(), 20.0f);
        layoutParams2.setMargins(a11, a11, a11, a11);
        this.f17192f.setOnClickListener(new View.OnClickListener() { // from class: com.shu.priory.request.IFLYBrowser.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IFLYBrowser.this.finish();
            }
        });
        this.f17193g.addView(this.f17191e, -1, 7);
        this.f17193g.addView(this.f17190d, layoutParams);
        this.f17193g.addView(this.f17192f, layoutParams2);
        setContentView(this.f17193g);
        this.f17195i = getIntent().getStringExtra("ad_session_id");
        this.f17190d.setWebViewClientCallback(this.f17187a);
        this.f17190d.setWebChromeClient(this.f17188b);
        this.f17190d.setDownloadListener(new a());
        com.shu.priory.bridge.b bVar = new com.shu.priory.bridge.b(getApplicationContext(), this.f17190d);
        this.f17194h = bVar;
        this.f17190d.a(bVar, (String) null);
        this.f17190d.loadUrl(getIntent().getStringExtra("url_ad"));
    }

    @Override // android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onDestroy() {
        h.a(SDKConstants.TAG, "IFLYBrowser onDestroy");
        try {
            com.shu.priory.bridge.b bVar = this.f17194h;
            if (bVar != null) {
                bVar.a();
            }
            DSBridgeWebView dSBridgeWebView = this.f17190d;
            if (dSBridgeWebView != null) {
                this.f17193g.removeView(dSBridgeWebView);
                this.f17190d.stopLoading();
                this.f17190d.getSettings().setJavaScriptEnabled(false);
                this.f17190d.clearHistory();
                this.f17190d.loadUrl("about:blank");
                this.f17190d.removeAllViews();
                this.f17190d.destroy();
                this.f17190d = null;
            }
            HandlerThread handlerThread = this.f17204r;
            if (handlerThread != null && handlerThread.isAlive()) {
                this.f17204r.quit();
            }
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "IFLYBrowser onDestroy " + th2.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.shu.priory.bridge.b bVar = this.f17194h;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0092, code lost:
    
        if (r3 != 2) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.request.IFLYBrowser.a():void");
    }

    public void a(String str) {
        try {
            new com.shu.priory.c.a(getApplicationContext(), str).a(new a.InterfaceC0551a() { // from class: com.shu.priory.request.IFLYBrowser.6
                public AnonymousClass6() {
                }

                @Override // com.shu.priory.c.a.InterfaceC0551a
                public void imageLoad(Bitmap bitmap) {
                    if (IFLYBrowser.this.f17192f != null) {
                        IFLYBrowser.this.f17192f.setImageBitmap(bitmap);
                    }
                }
            });
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, "loadCloseImg:" + e10.getMessage());
        }
    }

    public void a(String str, boolean z10) {
        JSONArray jSONArray;
        String str2;
        JSONArray jSONArray2;
        String str3;
        boolean z11;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (!com.shu.priory.utils.b.a(getApplicationContext(), intent)) {
            j.a(this.f17198l, z10 ? "20001" : "10001", this.f17197k);
            return;
        }
        try {
            this.f17202p = true;
            intent.addFlags(32768);
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            startActivity(intent);
            if (z10) {
                jSONArray2 = this.f17198l;
                str3 = "20000";
                z11 = this.f17197k;
            } else {
                jSONArray2 = this.f17198l;
                str3 = "10000";
                z11 = this.f17197k;
            }
            j.a(jSONArray2, str3, z11);
        } catch (Exception e10) {
            if (z10) {
                jSONArray = this.f17198l;
                str2 = "20002";
            } else {
                jSONArray = this.f17198l;
                str2 = "10002";
            }
            j.a(jSONArray, str2, this.f17197k);
            h.d(SDKConstants.TAG, e10.getMessage());
        }
    }
}
