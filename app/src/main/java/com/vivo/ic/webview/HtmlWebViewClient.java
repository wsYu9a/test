package com.vivo.ic.webview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebBackForwardList;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.PopupWindow;
import com.vivo.mobilead.web.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class HtmlWebViewClient extends WebViewClient {
    private static final String TAG = "HtmlWebViewClient";
    private IBridge mBridge;
    private Context mContext;
    private CommonJsBridge mInterface;
    private WebCallBack mWebCallBack;
    static final HashMap<String, String> SCHEME_MAPS = new HashMap<String, String>() { // from class: com.vivo.ic.webview.HtmlWebViewClient.1
        AnonymousClass1() {
            put("space", "com.vivo.space");
            put("vivospace", "com.vivo.space");
            put("vivomarket", "com.bbk.appstore");
            put("vivogame", "com.vivo.game");
        }
    };
    public static final Pattern ACCEPTED_URI_SCHEMA = Pattern.compile("(?i)((?:http|https|file):\\/\\/|(?:inline|data|about|javascript):)(.*)");

    /* renamed from: com.vivo.ic.webview.HtmlWebViewClient$1 */
    static class AnonymousClass1 extends HashMap<String, String> {
        AnonymousClass1() {
            put("space", "com.vivo.space");
            put("vivospace", "com.vivo.space");
            put("vivomarket", "com.bbk.appstore");
            put("vivogame", "com.vivo.game");
        }
    }

    /* renamed from: com.vivo.ic.webview.HtmlWebViewClient$2 */
    class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ d val$dialog;
        final /* synthetic */ SslError val$error;
        final /* synthetic */ SslErrorHandler val$handler;
        final /* synthetic */ WebView val$view;

        AnonymousClass2(Activity activity, WebView webView, SslErrorHandler sslErrorHandler, SslError sslError, d dVar) {
            activity = activity;
            webView = webView;
            sslErrorHandler = sslErrorHandler;
            sslError = sslError;
            dVar = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HtmlWebViewClient.this.goClose(activity, webView, sslErrorHandler, sslError, dVar);
        }
    }

    /* renamed from: com.vivo.ic.webview.HtmlWebViewClient$3 */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ d val$dialog;
        final /* synthetic */ SslErrorHandler val$handler;

        AnonymousClass3(SslErrorHandler sslErrorHandler, d dVar) {
            sslErrorHandler = sslErrorHandler;
            dVar = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SslErrorHandler sslErrorHandler = sslErrorHandler;
            if (sslErrorHandler != null) {
                sslErrorHandler.proceed();
            }
            dVar.a();
        }
    }

    /* renamed from: com.vivo.ic.webview.HtmlWebViewClient$4 */
    class AnonymousClass4 implements PopupWindow.OnDismissListener {
        final /* synthetic */ SslErrorHandler val$handler;

        AnonymousClass4(SslErrorHandler sslErrorHandler) {
            sslErrorHandler = sslErrorHandler;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            SslErrorHandler sslErrorHandler = sslErrorHandler;
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }
    }

    /* renamed from: com.vivo.ic.webview.HtmlWebViewClient$5 */
    class AnonymousClass5 extends CommonJsBridge {
        AnonymousClass5() {
        }

        @Override // com.vivo.ic.webview.JsInterface
        public void login(String str, String str2) {
        }

        @Override // com.vivo.ic.webview.JsInterface
        public void share(String str, String str2) {
        }
    }

    public HtmlWebViewClient(Context context, IBridge iBridge, CommonWebView commonWebView) {
        this.mContext = context;
        this.mBridge = iBridge;
        CommonJsBridge buildJsInterface = buildJsInterface();
        this.mInterface = buildJsInterface;
        buildJsInterface.setContext(context, commonWebView);
        this.mInterface.setBridgeImpl(this.mBridge);
    }

    private InputStream bitmap2InputStream(Bitmap bitmap, int i2, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(bitmapFormat(str), i2, byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArrayInputStream;
    }

    public void goClose(Activity activity, WebView webView, SslErrorHandler sslErrorHandler, SslError sslError, d dVar) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Exception unused) {
                return;
            }
        }
        WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
        if (copyBackForwardList != null) {
            if (copyBackForwardList.getSize() == 0) {
                if (dVar != null) {
                    dVar.a();
                }
                activity.finish();
                return;
            } else if (copyBackForwardList.getSize() == 1) {
                String url = copyBackForwardList.getItemAtIndex(0).getUrl();
                if (!TextUtils.isEmpty(url) && !url.equals(sslError.getUrl())) {
                    if (dVar != null) {
                        dVar.a();
                    }
                    WebView.HitTestResult hitTestResult = webView.getHitTestResult();
                    if (hitTestResult == null || !TextUtils.isEmpty(hitTestResult.getExtra())) {
                        return;
                    }
                    activity.finish();
                    return;
                }
            }
        }
        if (dVar != null) {
            dVar.a();
        }
    }

    private void handlerReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            Context context = webView.getContext();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    d dVar = new d((Activity) context);
                    dVar.a(new View.OnClickListener() { // from class: com.vivo.ic.webview.HtmlWebViewClient.2
                        final /* synthetic */ Activity val$activity;
                        final /* synthetic */ d val$dialog;
                        final /* synthetic */ SslError val$error;
                        final /* synthetic */ SslErrorHandler val$handler;
                        final /* synthetic */ WebView val$view;

                        AnonymousClass2(Activity activity2, WebView webView2, SslErrorHandler sslErrorHandler2, SslError sslError2, d dVar2) {
                            activity = activity2;
                            webView = webView2;
                            sslErrorHandler = sslErrorHandler2;
                            sslError = sslError2;
                            dVar = dVar2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HtmlWebViewClient.this.goClose(activity, webView, sslErrorHandler, sslError, dVar);
                        }
                    });
                    dVar2.b(new View.OnClickListener() { // from class: com.vivo.ic.webview.HtmlWebViewClient.3
                        final /* synthetic */ d val$dialog;
                        final /* synthetic */ SslErrorHandler val$handler;

                        AnonymousClass3(SslErrorHandler sslErrorHandler2, d dVar2) {
                            sslErrorHandler = sslErrorHandler2;
                            dVar = dVar2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            SslErrorHandler sslErrorHandler2 = sslErrorHandler;
                            if (sslErrorHandler2 != null) {
                                sslErrorHandler2.proceed();
                            }
                            dVar.a();
                        }
                    });
                    dVar2.a(new PopupWindow.OnDismissListener() { // from class: com.vivo.ic.webview.HtmlWebViewClient.4
                        final /* synthetic */ SslErrorHandler val$handler;

                        AnonymousClass4(SslErrorHandler sslErrorHandler2) {
                            sslErrorHandler = sslErrorHandler2;
                        }

                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            SslErrorHandler sslErrorHandler2 = sslErrorHandler;
                            if (sslErrorHandler2 != null) {
                                sslErrorHandler2.cancel();
                            }
                        }
                    });
                    dVar2.b();
                }
                return;
            }
            if (sslErrorHandler2 != null) {
                sslErrorHandler2.cancel();
            }
        } catch (Exception unused) {
            if (sslErrorHandler2 != null) {
                sslErrorHandler2.cancel();
            }
        }
    }

    private boolean isSpecializedHandlerAvailable(Intent intent) {
        List<ResolveInfo> queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(intent, 64);
        if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
            return false;
        }
        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
        while (it.hasNext()) {
            IntentFilter intentFilter = it.next().filter;
            if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0) {
                return true;
            }
        }
        return false;
    }

    final boolean backToJs() {
        return this.mInterface.backToJs();
    }

    protected Bitmap.CompressFormat bitmapFormat(String str) {
        return Bitmap.CompressFormat.JPEG;
    }

    protected CommonJsBridge buildJsInterface() {
        return new CommonJsBridge() { // from class: com.vivo.ic.webview.HtmlWebViewClient.5
            AnonymousClass5() {
            }

            @Override // com.vivo.ic.webview.JsInterface
            public void login(String str, String str2) {
            }

            @Override // com.vivo.ic.webview.JsInterface
            public void share(String str, String str2) {
            }
        };
    }

    protected Bitmap createBitmap(String str, String str2, Map<String, String> map) {
        return null;
    }

    final Object executeCommonInterface(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            return this.mInterface.getClass().getMethod(str, String.class, String.class).invoke(this.mInterface, str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.mInterface.callJs(false, e2.getMessage(), null);
            return null;
        }
    }

    protected String getEncode(String str, String str2, Map<String, String> map) {
        return "utf-8";
    }

    protected String getMimeType(String str, String str2, Map<String, String> map) {
        return "image/*";
    }

    protected HashMap<String, String> getSchemeMaps() {
        return SCHEME_MAPS;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        WebCallBack webCallBack = this.mWebCallBack;
        if (webCallBack != null) {
            webCallBack.onPageFinished(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        WebCallBack webCallBack = this.mWebCallBack;
        if (webCallBack != null) {
            webCallBack.onPageStarted(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        Log.d(TAG, "onReceivedError, errorCode = " + i2);
        WebCallBack webCallBack = this.mWebCallBack;
        if (webCallBack != null) {
            webCallBack.onReceiverdError(str2);
        }
        super.onReceivedError(webView, i2, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        handlerReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            if (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && !renderProcessGoneDetail.didCrash()) {
                if (webView == null) {
                    return true;
                }
                ViewParent parent = webView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(webView);
                }
                webView.destroy();
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    final String queryPackage(String str) {
        try {
            String scheme = Uri.parse(str).getScheme();
            HashMap<String, String> schemeMaps = getSchemeMaps();
            if (schemeMaps.containsKey(scheme)) {
                return schemeMaps.get(scheme);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void setWebCallBack(WebCallBack webCallBack) {
        this.mWebCallBack = webCallBack;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Bitmap createBitmap = createBitmap(webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
        return createBitmap != null ? new WebResourceResponse(getMimeType(webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()), getEncode(webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()), bitmap2InputStream(createBitmap, 100, webResourceRequest.getUrl().toString())) : super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Log.d(TAG, "commonWebView shouldOverrideUrlLoading " + str);
        if (this.mBridge != null && BridgeUtils.isJsBridge(str)) {
            try {
                this.mBridge.execute(URLDecoder.decode(str, "utf-8"));
                this.mBridge.fetchJsMsgQueue();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        WebCallBack webCallBack = this.mWebCallBack;
        if (webCallBack != null && webCallBack.shouldHandleUrl(str)) {
            return true;
        }
        WebCallBack webCallBack2 = this.mWebCallBack;
        if (webCallBack2 != null && webCallBack2.shouldOverrideUrlLoading(webView, str)) {
            return true;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            if (ACCEPTED_URI_SCHEMA.matcher(str).matches() && !isSpecializedHandlerAvailable(parseUri)) {
                return false;
            }
            if (this.mContext.getPackageManager().resolveActivity(parseUri, 0) == null) {
                return true;
            }
            try {
                String queryPackage = queryPackage(str);
                if (parseUri != null && !TextUtils.isEmpty(queryPackage)) {
                    parseUri.setPackage(queryPackage);
                }
            } catch (Exception unused) {
                Log.i(TAG, "cannot start activity");
            }
            return ((Activity) this.mContext).startActivityIfNeeded(parseUri, -1);
        } catch (Exception e3) {
            Log.e(TAG, "Bad URI " + str + ": " + e3.getMessage());
            return false;
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Bitmap createBitmap = createBitmap(str, null, null);
        if (createBitmap != null) {
            return new WebResourceResponse(getMimeType(str, null, null), getEncode(str, null, null), bitmap2InputStream(createBitmap, 100, str));
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public HtmlWebViewClient(Context context, IBridge iBridge, CommonWebView commonWebView, CommonJsBridge commonJsBridge) {
        this.mContext = context;
        this.mBridge = iBridge;
        this.mInterface = commonJsBridge;
        commonJsBridge.setContext(context, commonWebView);
        this.mInterface.setBridgeImpl(this.mBridge);
    }

    public HtmlWebViewClient(Context context) {
        this.mContext = context;
    }
}
