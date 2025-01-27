package com.shu.priory.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.shu.priory.config.AdError;
import com.shu.priory.config.AdKeys;
import com.shu.priory.config.ErrorCode;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.listener.IFLYAdListener;
import com.shu.priory.param.AdParam;
import com.shu.priory.request.c;
import com.shu.priory.request.e;
import com.shu.priory.utils.a;
import com.shu.priory.utils.h;
import com.shu.priory.utils.j;
import com.shu.priory.view.b;
import com.shu.priory.webclient.d;
import com.umeng.analytics.pro.by;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class AdView extends WebView implements b.a {

    /* renamed from: a */
    protected Context f17408a;

    /* renamed from: b */
    protected Context f17409b;

    /* renamed from: c */
    protected RelativeLayout f17410c;

    /* renamed from: d */
    protected com.shu.priory.webclient.b f17411d;

    /* renamed from: e */
    protected com.shu.priory.webclient.a f17412e;

    /* renamed from: f */
    protected AdParam f17413f;

    /* renamed from: g */
    protected com.shu.priory.g.b f17414g;

    /* renamed from: h */
    protected com.shu.priory.g.a f17415h;

    /* renamed from: i */
    protected a.EnumC0557a f17416i;

    /* renamed from: j */
    protected a.b f17417j;

    /* renamed from: k */
    protected IFLYAdListener f17418k;

    /* renamed from: l */
    protected com.shu.priory.listener.a f17419l;

    /* renamed from: m */
    protected b f17420m;

    /* renamed from: n */
    protected HandlerThread f17421n;

    /* renamed from: o */
    protected com.shu.priory.view.a f17422o;

    /* renamed from: p */
    protected a f17423p;

    /* renamed from: q */
    protected int f17424q;

    /* renamed from: r */
    c f17425r;

    /* renamed from: s */
    d f17426s;

    /* renamed from: t */
    com.shu.priory.webclient.c f17427t;

    /* renamed from: u */
    private int f17428u;

    /* renamed from: v */
    private volatile String f17429v;

    /* renamed from: w */
    private boolean f17430w;

    /* renamed from: x */
    private final int f17431x;

    /* renamed from: y */
    private final int f17432y;

    /* renamed from: z */
    private final int f17433z;

    /* renamed from: com.shu.priory.view.AdView$1 */
    public class AnonymousClass1 implements c {
        public AnonymousClass1() {
        }

        @Override // com.shu.priory.request.c
        public void a(int i10) {
            try {
                AdView.this.f17420m.a(5, i10);
            } catch (Throwable unused) {
                h.d(SDKConstants.TAG, "web ad request onError " + i10);
            }
        }

        @Override // com.shu.priory.request.c
        public void a(byte[] bArr) {
            try {
                if (bArr != null) {
                    AdView.this.a(bArr);
                } else {
                    h.d(SDKConstants.TAG, "Invalid response data!");
                }
            } catch (AdError e10) {
                AdView.this.f17420m.a(5, e10.getErrorCode());
            } catch (Throwable th2) {
                AdView.this.f17420m.a(5, ErrorCode.ERROR_NETWORK);
                h.d(SDKConstants.TAG, "html parse1:" + th2.getMessage());
            }
        }
    }

    /* renamed from: com.shu.priory.view.AdView$2 */
    public class AnonymousClass2 implements d {
        public AnonymousClass2() {
        }

        @Override // com.shu.priory.webclient.d
        public void a() {
            h.a(SDKConstants.TAG, "onPageStarted");
            AdView.this.f17420m.a(AdView.this.f17420m.obtainMessage(4), by.f23697b);
        }

        @Override // com.shu.priory.webclient.d
        public void b() {
            h.a(SDKConstants.TAG, "onPageFinished： height:" + AdView.this.getContentHeight() + ", progress:" + AdView.this.f17412e.a());
            AdView.this.l();
        }

        @Override // com.shu.priory.webclient.d
        public void a(int i10, String str) {
            h.a(SDKConstants.TAG, "WebViewClientCallback onLoadError");
            AdView.this.f17420m.a(5, ErrorCode.ERROR_PAGE_LOAD_TIMEOUT);
        }

        @Override // com.shu.priory.webclient.d
        public void a(WebView webView, String str) {
            h.a(SDKConstants.TAG, "shouldOverrideUrlLoading： height:" + AdView.this.getContentHeight() + ", progress:" + AdView.this.f17412e.a());
            AdView.this.a(str);
        }
    }

    /* renamed from: com.shu.priory.view.AdView$3 */
    public class AnonymousClass3 implements com.shu.priory.webclient.c {
        public AnonymousClass3() {
        }

        @Override // com.shu.priory.webclient.c
        public void a(int i10) {
        }

        @Override // com.shu.priory.webclient.c
        public boolean a(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return false;
        }
    }

    public class a extends Handler {
        private a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 == 1) {
                h.a(SDKConstants.TAG, "procMsgShow");
                AdView.this.setAllVisibility(0);
                AdView.this.d();
                AdView.this.i();
                ViewGroup viewGroup = (ViewGroup) AdView.this.f17410c.getParent();
                if (viewGroup != null && viewGroup.getVisibility() == 0) {
                    if (AdView.this.f17413f.getBooleanParam(AdKeys.BANNER_RECYCLE)) {
                        AdView.this.g();
                    }
                    AdView.this.f17418k.onAdExposure();
                    return;
                }
                AdView.this.f17418k.onAdFailed(new AdError(ErrorCode.ERROR_INVALID_REQUEST));
                str = "Ad is invisible, invalid exposure!";
            } else {
                if (i10 == 2) {
                    h.a(SDKConstants.TAG, "procMsgTimeout:" + AdView.this.getProgress() + "% , " + AdView.this.getContentHeight());
                    if (AdView.this.getContentHeight() > 0 || AdView.this.getLoadStatus() == a.b.success) {
                        return;
                    }
                    if (AdView.this.f17428u >= 2) {
                        AdView.this.f17428u = 0;
                        AdView.this.f17420m.a(5, ErrorCode.ERROR_PAGE_LOAD_TIMEOUT);
                        return;
                    } else {
                        AdView.c(AdView.this);
                        AdView.this.n();
                        h.a(SDKConstants.TAG, "Loading ad timeout, reload again!");
                        return;
                    }
                }
                if (i10 != 3) {
                    return;
                }
                try {
                    String optString = AdView.this.f17415h.f17078e.optString("adm");
                    if (TextUtils.isEmpty(optString)) {
                        AdView.this.f17420m.a(5, ErrorCode.ERROR_INVALID_REQUEST);
                        return;
                    }
                    try {
                        AdView.this.loadDataWithBaseURL(null, optString, "text/html", "utf-8", null);
                        AdView.this.j();
                        return;
                    } catch (Throwable unused) {
                        AdView.this.f17420m.a(5, ErrorCode.ERROR_PAGE_LOAD_ERROR);
                        AdView.this.f17419l.a();
                        return;
                    }
                } catch (Throwable th2) {
                    AdView.this.f17420m.a(5, ErrorCode.ERROR_PAGE_LOAD_ERROR);
                    str = "html load:" + th2.getMessage();
                }
            }
            h.d(SDKConstants.TAG, str);
        }

        public /* synthetic */ a(AdView adView, Looper looper, AnonymousClass1 anonymousClass1) {
            this(looper);
        }
    }

    public AdView(Context context) {
        super(context);
        this.f17417j = a.b.init;
        this.f17424q = 0;
        this.f17428u = 0;
        this.f17425r = new c() { // from class: com.shu.priory.view.AdView.1
            public AnonymousClass1() {
            }

            @Override // com.shu.priory.request.c
            public void a(int i10) {
                try {
                    AdView.this.f17420m.a(5, i10);
                } catch (Throwable unused) {
                    h.d(SDKConstants.TAG, "web ad request onError " + i10);
                }
            }

            @Override // com.shu.priory.request.c
            public void a(byte[] bArr) {
                try {
                    if (bArr != null) {
                        AdView.this.a(bArr);
                    } else {
                        h.d(SDKConstants.TAG, "Invalid response data!");
                    }
                } catch (AdError e10) {
                    AdView.this.f17420m.a(5, e10.getErrorCode());
                } catch (Throwable th2) {
                    AdView.this.f17420m.a(5, ErrorCode.ERROR_NETWORK);
                    h.d(SDKConstants.TAG, "html parse1:" + th2.getMessage());
                }
            }
        };
        this.f17430w = false;
        this.f17426s = new d() { // from class: com.shu.priory.view.AdView.2
            public AnonymousClass2() {
            }

            @Override // com.shu.priory.webclient.d
            public void a() {
                h.a(SDKConstants.TAG, "onPageStarted");
                AdView.this.f17420m.a(AdView.this.f17420m.obtainMessage(4), by.f23697b);
            }

            @Override // com.shu.priory.webclient.d
            public void b() {
                h.a(SDKConstants.TAG, "onPageFinished： height:" + AdView.this.getContentHeight() + ", progress:" + AdView.this.f17412e.a());
                AdView.this.l();
            }

            @Override // com.shu.priory.webclient.d
            public void a(int i10, String str) {
                h.a(SDKConstants.TAG, "WebViewClientCallback onLoadError");
                AdView.this.f17420m.a(5, ErrorCode.ERROR_PAGE_LOAD_TIMEOUT);
            }

            @Override // com.shu.priory.webclient.d
            public void a(WebView webView, String str) {
                h.a(SDKConstants.TAG, "shouldOverrideUrlLoading： height:" + AdView.this.getContentHeight() + ", progress:" + AdView.this.f17412e.a());
                AdView.this.a(str);
            }
        };
        this.f17427t = new com.shu.priory.webclient.c() { // from class: com.shu.priory.view.AdView.3
            public AnonymousClass3() {
            }

            @Override // com.shu.priory.webclient.c
            public void a(int i10) {
            }

            @Override // com.shu.priory.webclient.c
            public boolean a(String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return false;
            }
        };
        this.f17431x = 1;
        this.f17432y = 2;
        this.f17433z = 3;
    }

    public static /* synthetic */ int c(AdView adView) {
        int i10 = adView.f17428u;
        adView.f17428u = i10 + 1;
        return i10;
    }

    private HandlerThread getHandlerThread() {
        HandlerThread handlerThread = new HandlerThread("" + this.f17416i);
        this.f17421n = handlerThread;
        handlerThread.start();
        return this.f17421n;
    }

    public synchronized a.b getLoadStatus() {
        return this.f17417j;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void m() {
        setScrollContainer(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        getSettings().setJavaScriptEnabled(true);
        this.f17420m = new b(getHandlerThread().getLooper(), this);
        com.shu.priory.view.a aVar = new com.shu.priory.view.a();
        this.f17422o = aVar;
        aVar.a(this.f17419l);
        setBackgroundColor(0);
        getSettings().setCacheMode(2);
        getSettings().setAllowUniversalAccessFromFileURLs(true);
        getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        setAllVisibility(8);
        com.shu.priory.webclient.b bVar = new com.shu.priory.webclient.b(this.f17426s);
        this.f17411d = bVar;
        setWebViewClient(bVar);
        com.shu.priory.webclient.a aVar2 = new com.shu.priory.webclient.a(this.f17427t);
        this.f17412e = aVar2;
        setWebChromeClient(aVar2);
    }

    public synchronized void n() {
        try {
            setLoadStatus(a.b.start);
            Message message = new Message();
            message.obj = this.f17414g;
            message.what = 3;
            this.f17423p.sendMessage(message);
        } finally {
        }
    }

    private void o() {
        if (this.f17422o.hasMessages(4)) {
            h.a(SDKConstants.TAG, "移除关闭广告msg");
            this.f17422o.removeMessages(4);
            this.f17430w = true;
        }
    }

    private void p() {
        if (this.f17430w) {
            h.a(SDKConstants.TAG, "添加关闭广告msg");
            this.f17422o.a(4, 2000);
        }
    }

    private synchronized void setLoadStatus(a.b bVar) {
        this.f17417j = bVar;
    }

    public void d() {
        if (a.EnumC0557a.BANNER != this.f17416i) {
            requestFocus();
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public boolean e() {
        return this.f17413f.getBooleanParam(AdKeys.BANNER_RECYCLE);
    }

    public synchronized void f() {
        this.f17420m.a(3, ErrorCode.SUCCESS);
    }

    public synchronized void g() {
    }

    public double getPrice() {
        return this.f17415h.f17076c;
    }

    public int getRecycleInterval() {
        int intParam = this.f17413f.getIntParam(AdKeys.BANNER_INTERVAL);
        if (intParam < 15 || intParam > 40) {
            return 30000;
        }
        return intParam * 1000;
    }

    public void h() {
        this.f17420m.removeCallbacksAndMessages(null);
        this.f17421n.quit();
    }

    public void i() {
    }

    public abstract void j();

    public void k() {
        c();
    }

    public void l() {
        a.b loadStatus = getLoadStatus();
        a.b bVar = a.b.success;
        if (loadStatus != bVar) {
            int visibility = getVisibility();
            setLoadStatus(bVar);
            this.f17418k.onAdReceive();
            h.a(SDKConstants.TAG, "onAdPageFinished:" + visibility);
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || !a.EnumC0557a.INTERSTITIAL.equals(this.f17416i) || !this.f17413f.getBooleanParam(AdKeys.BACK_KEY_ENABLE)) {
            return super.onKeyDown(i10, keyEvent);
        }
        this.f17419l.a();
        this.f17418k.onAdClose();
        return true;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f17429v = motionEvent.getX() + "-" + motionEvent.getY();
            this.f17411d.a(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        this.f17424q = i10;
        h.a(SDKConstants.TAG, "ad view visibility=" + this.f17424q);
        int i11 = this.f17424q;
        if (i11 == 8 || i11 == 4) {
            o();
        }
        if (this.f17424q == 0) {
            p();
        }
    }

    public void setAllVisibility(int i10) {
        if (this.f17410c == null) {
            return;
        }
        setVisibility(i10);
        this.f17410c.setVisibility(i10);
        for (int i11 = 0; i11 < this.f17410c.getChildCount(); i11++) {
            this.f17410c.getChildAt(i11).setVisibility(i10);
        }
    }

    public AdView(Context context, RelativeLayout relativeLayout, String str, a.EnumC0557a enumC0557a, com.shu.priory.listener.a aVar) {
        super(context.getApplicationContext());
        this.f17417j = a.b.init;
        this.f17424q = 0;
        this.f17428u = 0;
        this.f17425r = new c() { // from class: com.shu.priory.view.AdView.1
            public AnonymousClass1() {
            }

            @Override // com.shu.priory.request.c
            public void a(int i10) {
                try {
                    AdView.this.f17420m.a(5, i10);
                } catch (Throwable unused) {
                    h.d(SDKConstants.TAG, "web ad request onError " + i10);
                }
            }

            @Override // com.shu.priory.request.c
            public void a(byte[] bArr) {
                try {
                    if (bArr != null) {
                        AdView.this.a(bArr);
                    } else {
                        h.d(SDKConstants.TAG, "Invalid response data!");
                    }
                } catch (AdError e10) {
                    AdView.this.f17420m.a(5, e10.getErrorCode());
                } catch (Throwable th2) {
                    AdView.this.f17420m.a(5, ErrorCode.ERROR_NETWORK);
                    h.d(SDKConstants.TAG, "html parse1:" + th2.getMessage());
                }
            }
        };
        this.f17430w = false;
        this.f17426s = new d() { // from class: com.shu.priory.view.AdView.2
            public AnonymousClass2() {
            }

            @Override // com.shu.priory.webclient.d
            public void a() {
                h.a(SDKConstants.TAG, "onPageStarted");
                AdView.this.f17420m.a(AdView.this.f17420m.obtainMessage(4), by.f23697b);
            }

            @Override // com.shu.priory.webclient.d
            public void b() {
                h.a(SDKConstants.TAG, "onPageFinished： height:" + AdView.this.getContentHeight() + ", progress:" + AdView.this.f17412e.a());
                AdView.this.l();
            }

            @Override // com.shu.priory.webclient.d
            public void a(int i10, String str2) {
                h.a(SDKConstants.TAG, "WebViewClientCallback onLoadError");
                AdView.this.f17420m.a(5, ErrorCode.ERROR_PAGE_LOAD_TIMEOUT);
            }

            @Override // com.shu.priory.webclient.d
            public void a(WebView webView, String str2) {
                h.a(SDKConstants.TAG, "shouldOverrideUrlLoading： height:" + AdView.this.getContentHeight() + ", progress:" + AdView.this.f17412e.a());
                AdView.this.a(str2);
            }
        };
        this.f17427t = new com.shu.priory.webclient.c() { // from class: com.shu.priory.view.AdView.3
            public AnonymousClass3() {
            }

            @Override // com.shu.priory.webclient.c
            public void a(int i10) {
            }

            @Override // com.shu.priory.webclient.c
            public boolean a(String str2, String str22, String str3, JsPromptResult jsPromptResult) {
                return false;
            }
        };
        this.f17431x = 1;
        this.f17432y = 2;
        this.f17433z = 3;
        this.f17408a = context;
        this.f17409b = context.getApplicationContext();
        this.f17410c = relativeLayout;
        this.f17416i = enumC0557a;
        this.f17419l = aVar;
        this.f17423p = new a(context.getMainLooper());
        this.f17414g = new com.shu.priory.g.b(this.f17409b);
        this.f17413f = new AdParam(str);
        m();
    }

    public RelativeLayout.LayoutParams b(int i10, int i11) {
        return new RelativeLayout.LayoutParams(i10, i11);
    }

    @Override // com.shu.priory.view.b.a
    public void c() {
        this.f17418k.onAdClose();
        h();
        this.f17408a = null;
        this.f17409b = null;
    }

    public synchronized void d(Message message) throws Exception {
        e.a(this.f17409b, this.f17413f, this.f17425r);
    }

    @Override // com.shu.priory.view.b.a
    public void a() {
        n();
    }

    @Override // com.shu.priory.view.b.a
    public void b() {
        this.f17423p.sendEmptyMessage(1);
        this.f17420m.a(a.c.end);
        try {
            JSONObject jSONObject = this.f17415h.J;
            if (jSONObject != null && jSONObject.has("impress_urls")) {
                JSONArray a10 = j.a(this.f17413f.getDoubleParam(AdKeys.AUCTION_PRICE), this.f17415h.J.optJSONArray("impress_urls"));
                String g10 = com.shu.priory.param.d.g();
                if (!TextUtils.isEmpty(g10)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("show_page", g10);
                    a10 = j.a(jSONObject2.toString(), this.f17415h.J.optJSONArray("impress_urls"));
                }
                if (a10 != null) {
                    j.a(a10, this.f17409b, 1);
                } else {
                    h.d(SDKConstants.TAG, "impArray null");
                }
            }
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "Show:" + th2.getMessage());
        }
        h.a(SDKConstants.TAG, "procMsgShow successfully!");
    }

    @Override // com.shu.priory.view.b.a
    public void c(Message message) {
        int i10;
        h.a(SDKConstants.TAG, "procMsgEnd:" + message.obj);
        Object obj = message.obj;
        if (obj != null) {
            AdError adError = new AdError(((Integer) obj).intValue());
            i10 = adError.getErrorCode();
            this.f17422o.a(1, adError);
        } else {
            i10 = 0;
        }
        if (70403 == i10 || !this.f17413f.getBooleanParam(AdKeys.BANNER_RECYCLE)) {
            return;
        }
        g();
    }

    public void a(int i10, int i11) {
        h.a(SDKConstants.TAG, "AdView setLayoutParam()");
        RelativeLayout.LayoutParams b10 = b(i10, i11);
        if (getParent() == null) {
            this.f17410c.removeAllViews();
            this.f17410c.addView(this, b10);
        }
    }

    @Override // com.shu.priory.view.b.a
    public void b(Message message) {
        this.f17423p.sendEmptyMessage(2);
        h.a(SDKConstants.TAG, "procMsgTimeout " + message.obj);
    }

    private void b(String str) {
        int i10 = this.f17415h.M;
        h.a(SDKConstants.TAG, "clickAd: actionType=" + i10);
        if (!URLUtil.isValidUrl(str) || str.equals("about:blank")) {
            h.a(SDKConstants.TAG, "Invalid click url: " + str);
            return;
        }
        if (i10 != 3) {
            JSONObject jSONObject = this.f17415h.J;
            String jSONArray = (jSONObject == null || !jSONObject.has("general_monitor_urls")) ? null : this.f17415h.J.optJSONArray("general_monitor_urls").toString();
            JSONObject jSONObject2 = this.f17414g.f17108i;
            com.shu.priory.request.d.a(this.f17409b, str, this.f17413f, this.f17414g.f17102c, this.f17415h.I, jSONArray, jSONObject2 != null ? jSONObject2.toString() : null);
            return;
        }
        com.shu.priory.download.c a10 = com.shu.priory.download.c.a(this.f17409b);
        a10.a(this.f17418k);
        a10.a(this.f17413f.getBooleanParam(AdKeys.DOWNLOAD_ALERT));
        a10.a(this.f17408a, this.f17414g.f17105f, str);
        h.a(SDKConstants.TAG, "AdView startDownload");
    }

    @Override // com.shu.priory.view.b.a
    public void a(Message message) {
        try {
            d(message);
        } catch (AdError e10) {
            this.f17420m.a(5, e10.getErrorCode());
        } catch (Throwable th2) {
            this.f17420m.a(5, ErrorCode.ERROR_NETWORK);
            h.d(SDKConstants.TAG, "Request:" + th2.getMessage());
        }
    }

    public synchronized void a(IFLYAdListener iFLYAdListener) {
        if (iFLYAdListener == null) {
            h.d(SDKConstants.TAG, "invalid IFLYAdListener!");
            return;
        }
        if (a.c.exit == this.f17420m.a()) {
            h.a(SDKConstants.TAG, "ad is exited!");
            return;
        }
        if (a.c.init != this.f17420m.a() && a.c.end != this.f17420m.a()) {
            h.a(SDKConstants.TAG, "ad is requesting, please retry a little later!");
            return;
        }
        if (this.f17413f.getBooleanParam(AdKeys.DEBUG_MODE)) {
            h.a(true);
        } else {
            h.a(false);
        }
        this.f17418k = iFLYAdListener;
        this.f17422o.a(iFLYAdListener);
        this.f17420m.a(1);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(1:38)(1:5)|6|(2:9|(1:36)(9:13|14|15|16|17|18|(3:22|(1:24)|25)|27|28))|37|16|17|18|(4:20|22|(0)|25)|27|28) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0110, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0125, code lost:
    
        com.shu.priory.utils.h.d(com.shu.priory.config.SDKConstants.TAG, "html click:" + r11.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f8 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:18:0x00dc, B:20:0x00e2, B:22:0x00e8, B:24:0x00f8, B:25:0x0112), top: B:17:0x00dc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.view.AdView.a(java.lang.String):void");
    }

    public void a(String str, Object obj) {
        this.f17413f.setParameter(str, obj);
    }

    public void a(byte[] bArr) throws AdError {
        int optInt;
        int optInt2;
        this.f17414g.a(bArr, false);
        com.shu.priory.g.b bVar = this.f17414g;
        com.shu.priory.g.a aVar = bVar.f17105f;
        this.f17415h = aVar;
        int i10 = bVar.f17100a;
        if (70200 != i10) {
            this.f17420m.a(5, i10);
            return;
        }
        try {
            optInt = aVar.f17078e.optInt("width");
            optInt2 = this.f17415h.f17078e.optInt("height");
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "html parse2:" + th2.getMessage());
        }
        if (optInt > 0 && optInt2 > 0) {
            this.f17413f.setAdWidth(optInt);
            this.f17413f.setAdHeight(optInt2);
            this.f17420m.a(2, this.f17414g.f17100a);
            return;
        }
        this.f17420m.a(5, ErrorCode.ERROR_PAGE_LOAD_ERROR);
    }
}
