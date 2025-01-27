package com.shu.priory.bridge;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;
import h3.e;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DSBridgeWebView extends WebView {

    /* renamed from: c */
    private static boolean f16830c = false;

    /* renamed from: a */
    Map<Integer, com.shu.priory.bridge.c> f16831a;

    /* renamed from: b */
    public WebViewClient f16832b;

    /* renamed from: d */
    private Map<String, Object> f16833d;

    /* renamed from: e */
    private String f16834e;

    /* renamed from: f */
    private int f16835f;

    /* renamed from: g */
    private WebChromeClient f16836g;

    /* renamed from: h */
    private d f16837h;

    /* renamed from: i */
    private volatile boolean f16838i;

    /* renamed from: j */
    private c f16839j;

    /* renamed from: k */
    private ArrayList<a> f16840k;

    /* renamed from: l */
    private b f16841l;

    /* renamed from: m */
    private Handler f16842m;

    /* renamed from: n */
    private WebChromeClient f16843n;

    /* renamed from: com.shu.priory.bridge.DSBridgeWebView$1 */
    public class AnonymousClass1 {

        /* renamed from: com.shu.priory.bridge.DSBridgeWebView$1$1 */
        public class RunnableC05501 implements Runnable {
            public RunnableC05501() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (DSBridgeWebView.this.f16839j == null || DSBridgeWebView.this.f16839j.a()) {
                    Context context = DSBridgeWebView.this.getContext();
                    if (context instanceof Activity) {
                        ((Activity) context).onBackPressed();
                    }
                }
            }
        }

        /* renamed from: com.shu.priory.bridge.DSBridgeWebView$1$2 */
        public class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Object f16846a;

            public AnonymousClass2(Object obj) {
                obj = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    int i10 = jSONObject.getInt("id");
                    boolean z10 = jSONObject.getBoolean("complete");
                    com.shu.priory.bridge.c cVar = DSBridgeWebView.this.f16831a.get(Integer.valueOf(i10));
                    Object obj = jSONObject.has(e.f26408m) ? jSONObject.get(e.f26408m) : null;
                    if (cVar != null) {
                        cVar.a(obj);
                        if (z10) {
                            DSBridgeWebView.this.f16831a.remove(Integer.valueOf(i10));
                        }
                    }
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
        }

        public AnonymousClass1() {
        }

        @JavascriptInterface
        public String closePage(Object obj) throws JSONException {
            DSBridgeWebView.this.a(new Runnable() { // from class: com.shu.priory.bridge.DSBridgeWebView.1.1
                public RunnableC05501() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (DSBridgeWebView.this.f16839j == null || DSBridgeWebView.this.f16839j.a()) {
                        Context context = DSBridgeWebView.this.getContext();
                        if (context instanceof Activity) {
                            ((Activity) context).onBackPressed();
                        }
                    }
                }
            });
            return null;
        }

        @JavascriptInterface
        public void disableJavascriptDialogBlock(Object obj) throws JSONException {
            DSBridgeWebView.this.f16838i = !((JSONObject) obj).getBoolean("disable");
        }

        @JavascriptInterface
        public void dsinit(Object obj) {
            DSBridgeWebView.this.d();
        }

        @JavascriptInterface
        public boolean hasNativeMethod(Object obj) throws JSONException {
            Method method;
            boolean z10;
            JSONObject jSONObject = (JSONObject) obj;
            String trim = jSONObject.getString("name").trim();
            String trim2 = jSONObject.getString("type").trim();
            String[] b10 = DSBridgeWebView.this.b(trim);
            Object obj2 = DSBridgeWebView.this.f16833d.get(b10[0]);
            if (obj2 != null) {
                Class<?> cls = obj2.getClass();
                try {
                    method = cls.getMethod(b10[1], Object.class, com.shu.priory.bridge.a.class);
                    z10 = true;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    try {
                        method = cls.getMethod(b10[1], Object.class);
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        method = null;
                    }
                    z10 = false;
                }
                if (method == null || ((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) == null) {
                    return false;
                }
                if ("all".equals(trim2) || ((z10 && "asyn".equals(trim2)) || (!z10 && "syn".equals(trim2)))) {
                    return true;
                }
            }
            return false;
        }

        @JavascriptInterface
        public void returnValue(Object obj) {
            DSBridgeWebView.this.a(new Runnable() { // from class: com.shu.priory.bridge.DSBridgeWebView.1.2

                /* renamed from: a */
                final /* synthetic */ Object f16846a;

                public AnonymousClass2(Object obj2) {
                    obj = obj2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = (JSONObject) obj;
                    try {
                        int i10 = jSONObject.getInt("id");
                        boolean z10 = jSONObject.getBoolean("complete");
                        com.shu.priory.bridge.c cVar = DSBridgeWebView.this.f16831a.get(Integer.valueOf(i10));
                        Object obj2 = jSONObject.has(e.f26408m) ? jSONObject.get(e.f26408m) : null;
                        if (cVar != null) {
                            cVar.a(obj2);
                            if (z10) {
                                DSBridgeWebView.this.f16831a.remove(Integer.valueOf(i10));
                            }
                        }
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                }
            });
        }
    }

    /* renamed from: com.shu.priory.bridge.DSBridgeWebView$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f16848a;

        public AnonymousClass2(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            DSBridgeWebView.this.c(str);
        }
    }

    /* renamed from: com.shu.priory.bridge.DSBridgeWebView$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f16850a;

        public AnonymousClass3(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = str;
            if (str != null && str.startsWith("javascript:")) {
                DSBridgeWebView.super.loadUrl(str);
                return;
            }
            DSBridgeWebView.this.f16840k = new ArrayList();
            DSBridgeWebView.super.loadUrl(str);
        }
    }

    /* renamed from: com.shu.priory.bridge.DSBridgeWebView$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f16852a;

        /* renamed from: b */
        final /* synthetic */ Map f16853b;

        public AnonymousClass4(String str, Map map) {
            str = str;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = str;
            if (str != null && str.startsWith("javascript:")) {
                DSBridgeWebView.super.loadUrl(str, map);
                return;
            }
            DSBridgeWebView.this.f16840k = new ArrayList();
            DSBridgeWebView.super.loadUrl(str, map);
        }
    }

    /* renamed from: com.shu.priory.bridge.DSBridgeWebView$5 */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DSBridgeWebView.this.f16840k = new ArrayList();
            DSBridgeWebView.super.reload();
        }
    }

    /* renamed from: com.shu.priory.bridge.DSBridgeWebView$6 */
    public class AnonymousClass6 extends WebChromeClient {

        /* renamed from: com.shu.priory.bridge.DSBridgeWebView$6$1 */
        public class AnonymousClass1 implements DialogInterface.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ JsResult f16857a;

            public AnonymousClass1(JsResult jsResult) {
                jsResult = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.dismiss();
                if (DSBridgeWebView.this.f16838i) {
                    jsResult.confirm();
                }
            }
        }

        /* renamed from: com.shu.priory.bridge.DSBridgeWebView$6$2 */
        public class AnonymousClass2 implements DialogInterface.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ JsResult f16859a;

            public AnonymousClass2(JsResult jsResult) {
                jsResult = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                if (DSBridgeWebView.this.f16838i) {
                    if (i10 == -1) {
                        jsResult.confirm();
                    } else {
                        jsResult.cancel();
                    }
                }
            }
        }

        /* renamed from: com.shu.priory.bridge.DSBridgeWebView$6$3 */
        public class AnonymousClass3 implements DialogInterface.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ JsPromptResult f16861a;

            /* renamed from: b */
            final /* synthetic */ EditText f16862b;

            public AnonymousClass3(JsPromptResult jsPromptResult, EditText editText) {
                jsPromptResult = jsPromptResult;
                editText = editText;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                if (DSBridgeWebView.this.f16838i) {
                    if (i10 == -1) {
                        jsPromptResult.confirm(editText.getText().toString());
                    } else {
                        jsPromptResult.cancel();
                    }
                }
            }
        }

        public AnonymousClass6() {
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.getDefaultVideoPoster() : super.getDefaultVideoPoster();
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
        }

        @Override // android.webkit.WebChromeClient
        public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.getVisitedHistory(valueCallback);
            } else {
                super.getVisitedHistory(valueCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onCloseWindow(webView);
            } else {
                super.onCloseWindow(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String str, int i10, String str2) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onConsoleMessage(str, i10, str2);
            } else {
                super.onConsoleMessage(str, i10, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
            return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onCreateWindow(webView, z10, z11, message) : super.onCreateWindow(webView, z10, z11, message);
        }

        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j10, long j11, long j12, WebStorage.QuotaUpdater quotaUpdater) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onExceededDatabaseQuota(str, str2, j10, j11, j12, quotaUpdater);
            } else {
                super.onExceededDatabaseQuota(str, str2, j10, j11, j12, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onGeolocationPermissionsHidePrompt();
            } else {
                super.onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onGeolocationPermissionsShowPrompt(str, callback);
            } else {
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onHideCustomView();
            } else {
                super.onHideCustomView();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (!DSBridgeWebView.this.f16838i) {
                jsResult.confirm();
            }
            if (DSBridgeWebView.this.f16836g != null && DSBridgeWebView.this.f16836g.onJsAlert(webView, str, str2, jsResult)) {
                return true;
            }
            try {
            } catch (Exception e10) {
                h.d(SDKConstants.TAG, "onJsAlert:" + e10.getMessage());
            }
            if ((DSBridgeWebView.this.getContext() instanceof Activity) && ((Activity) DSBridgeWebView.this.getContext()).isFinishing()) {
                return true;
            }
            new AlertDialog.Builder(DSBridgeWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.shu.priory.bridge.DSBridgeWebView.6.1

                /* renamed from: a */
                final /* synthetic */ JsResult f16857a;

                public AnonymousClass1(JsResult jsResult2) {
                    jsResult = jsResult2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    dialogInterface.dismiss();
                    if (DSBridgeWebView.this.f16838i) {
                        jsResult.confirm();
                    }
                }
            }).create().show();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if (!DSBridgeWebView.this.f16838i) {
                jsResult.confirm();
            }
            if (DSBridgeWebView.this.f16836g != null && DSBridgeWebView.this.f16836g.onJsConfirm(webView, str, str2, jsResult)) {
                return true;
            }
            AnonymousClass2 anonymousClass2 = new DialogInterface.OnClickListener() { // from class: com.shu.priory.bridge.DSBridgeWebView.6.2

                /* renamed from: a */
                final /* synthetic */ JsResult f16859a;

                public AnonymousClass2(JsResult jsResult2) {
                    jsResult = jsResult2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (DSBridgeWebView.this.f16838i) {
                        if (i10 == -1) {
                            jsResult.confirm();
                        } else {
                            jsResult.cancel();
                        }
                    }
                }
            };
            try {
            } catch (Exception e10) {
                h.d(SDKConstants.TAG, "onJsConfirm:" + e10.getMessage());
            }
            if ((DSBridgeWebView.this.getContext() instanceof Activity) && ((Activity) DSBridgeWebView.this.getContext()).isFinishing()) {
                return true;
            }
            new AlertDialog.Builder(DSBridgeWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, anonymousClass2).setNegativeButton(R.string.cancel, anonymousClass2).show();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (!DSBridgeWebView.this.f16838i) {
                jsPromptResult.confirm();
            }
            if (DSBridgeWebView.this.f16836g != null && DSBridgeWebView.this.f16836g.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                return true;
            }
            EditText editText = new EditText(DSBridgeWebView.this.getContext());
            editText.setText(str3);
            if (str3 != null) {
                editText.setSelection(str3.length());
            }
            float f10 = DSBridgeWebView.this.getContext().getResources().getDisplayMetrics().density;
            AnonymousClass3 anonymousClass3 = new DialogInterface.OnClickListener() { // from class: com.shu.priory.bridge.DSBridgeWebView.6.3

                /* renamed from: a */
                final /* synthetic */ JsPromptResult f16861a;

                /* renamed from: b */
                final /* synthetic */ EditText f16862b;

                public AnonymousClass3(JsPromptResult jsPromptResult2, EditText editText2) {
                    jsPromptResult = jsPromptResult2;
                    editText = editText2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (DSBridgeWebView.this.f16838i) {
                        if (i10 == -1) {
                            jsPromptResult.confirm(editText.getText().toString());
                        } else {
                            jsPromptResult.cancel();
                        }
                    }
                }
            };
            new AlertDialog.Builder(DSBridgeWebView.this.getContext()).setTitle(str2).setView(editText2).setCancelable(false).setPositiveButton(R.string.ok, anonymousClass3).setNegativeButton(R.string.cancel, anonymousClass3).show();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int i10 = (int) (16.0f * f10);
            layoutParams.setMargins(i10, 0, i10, 0);
            layoutParams.gravity = 1;
            editText2.setLayoutParams(layoutParams);
            int i11 = (int) (15.0f * f10);
            editText2.setPadding(i11 - ((int) (f10 * 5.0f)), i11, i11, i11);
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsTimeout() {
            return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onJsTimeout() : super.onJsTimeout();
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onPermissionRequest(permissionRequest);
            } else {
                super.onPermissionRequest(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onPermissionRequestCanceled(permissionRequest);
            } else {
                super.onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onProgressChanged(webView, i10);
            } else {
                super.onProgressChanged(webView, i10);
            }
        }

        public void onReachedMaxAppCacheSize(long j10, long j11, WebStorage.QuotaUpdater quotaUpdater) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onReachedMaxAppCacheSize(j10, j11, quotaUpdater);
            }
            super.onReachedMaxAppCacheSize(j10, j11, quotaUpdater);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onReceivedIcon(webView, bitmap);
            } else {
                super.onReceivedIcon(webView, bitmap);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onReceivedTitle(webView, str);
            } else {
                super.onReceivedTitle(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z10) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onReceivedTouchIconUrl(webView, str, z10);
            } else {
                super.onReceivedTouchIconUrl(webView, str, z10);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onRequestFocus(WebView webView) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onRequestFocus(webView);
            } else {
                super.onRequestFocus(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(14)
        public void onShowCustomView(View view, int i10, WebChromeClient.CustomViewCallback customViewCallback) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onShowCustomView(view, i10, customViewCallback);
            } else {
                super.onShowCustomView(view, i10, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (DSBridgeWebView.this.f16836g != null) {
                DSBridgeWebView.this.f16836g.onShowCustomView(view, customViewCallback);
            } else {
                super.onShowCustomView(view, customViewCallback);
            }
        }
    }

    /* renamed from: com.shu.priory.bridge.DSBridgeWebView$7 */
    public class AnonymousClass7 extends WebViewClient {
        public AnonymousClass7() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (DSBridgeWebView.this.f16837h != null) {
                DSBridgeWebView.this.f16837h.b();
            } else {
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (DSBridgeWebView.this.f16837h != null) {
                DSBridgeWebView.this.f16837h.a();
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            if (DSBridgeWebView.this.f16837h != null) {
                DSBridgeWebView.this.f16837h.a(i10, str);
            } else {
                super.onReceivedError(webView, i10, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError.getPrimaryError() == 5) {
                sslErrorHandler.proceed();
            } else {
                sslErrorHandler.cancel();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return DSBridgeWebView.this.f16837h != null ? DSBridgeWebView.this.f16837h.a(webView, str) : super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public static class a {

        /* renamed from: a */
        private String f16865a;

        /* renamed from: b */
        private int f16866b;

        /* renamed from: c */
        private String f16867c;

        public a(String str, int i10, Object[] objArr) {
            this.f16865a = new JSONArray((Collection) Arrays.asList(objArr == null ? new Object[0] : objArr)).toString();
            this.f16866b = i10;
            this.f16867c = str;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(e.f26414s, this.f16867c);
                jSONObject.put("callbackId", this.f16866b);
                jSONObject.put(e.f26408m, this.f16865a);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    public class b {

        /* renamed from: com.shu.priory.bridge.DSBridgeWebView$b$1 */
        public class AnonymousClass1 implements com.shu.priory.bridge.a {

            /* renamed from: a */
            final /* synthetic */ String f16869a;

            public AnonymousClass1(String str) {
                r2 = str;
            }

            @Override // com.shu.priory.bridge.a
            public void a(Object obj) {
                a(obj, true);
            }

            private void a(Object obj, boolean z10) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put(e.f26408m, obj);
                    String str = r2;
                    if (str != null) {
                        String format = String.format("%s(%s.data);", str, jSONObject.toString());
                        if (z10) {
                            format = format + "delete window." + r2;
                        }
                        DSBridgeWebView.this.a(format);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }

        private b() {
        }

        private void a(String str) {
            if (DSBridgeWebView.f16830c) {
                DSBridgeWebView.this.a(String.format("alert('%s')", "DEBUG ERR MSG:\\n" + str.replaceAll("\\'", "\\\\'")));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String call(java.lang.String r14, java.lang.String r15) {
            /*
                Method dump skipped, instructions count: 261
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.bridge.DSBridgeWebView.b.call(java.lang.String, java.lang.String):java.lang.String");
        }

        public /* synthetic */ b(DSBridgeWebView dSBridgeWebView, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public interface c {
        boolean a();
    }

    public DSBridgeWebView(Context context) {
        super(context);
        this.f16833d = new HashMap();
        this.f16835f = 0;
        this.f16838i = true;
        this.f16839j = null;
        this.f16841l = new b();
        this.f16842m = new Handler(Looper.getMainLooper());
        this.f16831a = new HashMap();
        this.f16843n = new WebChromeClient() { // from class: com.shu.priory.bridge.DSBridgeWebView.6

            /* renamed from: com.shu.priory.bridge.DSBridgeWebView$6$1 */
            public class AnonymousClass1 implements DialogInterface.OnClickListener {

                /* renamed from: a */
                final /* synthetic */ JsResult f16857a;

                public AnonymousClass1(JsResult jsResult2) {
                    jsResult = jsResult2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    dialogInterface.dismiss();
                    if (DSBridgeWebView.this.f16838i) {
                        jsResult.confirm();
                    }
                }
            }

            /* renamed from: com.shu.priory.bridge.DSBridgeWebView$6$2 */
            public class AnonymousClass2 implements DialogInterface.OnClickListener {

                /* renamed from: a */
                final /* synthetic */ JsResult f16859a;

                public AnonymousClass2(JsResult jsResult2) {
                    jsResult = jsResult2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (DSBridgeWebView.this.f16838i) {
                        if (i10 == -1) {
                            jsResult.confirm();
                        } else {
                            jsResult.cancel();
                        }
                    }
                }
            }

            /* renamed from: com.shu.priory.bridge.DSBridgeWebView$6$3 */
            public class AnonymousClass3 implements DialogInterface.OnClickListener {

                /* renamed from: a */
                final /* synthetic */ JsPromptResult f16861a;

                /* renamed from: b */
                final /* synthetic */ EditText f16862b;

                public AnonymousClass3(JsPromptResult jsPromptResult2, EditText editText2) {
                    jsPromptResult = jsPromptResult2;
                    editText = editText2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (DSBridgeWebView.this.f16838i) {
                        if (i10 == -1) {
                            jsPromptResult.confirm(editText.getText().toString());
                        } else {
                            jsPromptResult.cancel();
                        }
                    }
                }
            }

            public AnonymousClass6() {
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.getDefaultVideoPoster() : super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.getVisitedHistory(valueCallback);
                } else {
                    super.getVisitedHistory(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView webView) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onCloseWindow(webView);
                } else {
                    super.onCloseWindow(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i10, String str2) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onConsoleMessage(str, i10, str2);
                } else {
                    super.onConsoleMessage(str, i10, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onCreateWindow(webView, z10, z11, message) : super.onCreateWindow(webView, z10, z11, message);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j10, long j11, long j12, WebStorage.QuotaUpdater quotaUpdater) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onExceededDatabaseQuota(str, str2, j10, j11, j12, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(str, str2, j10, j11, j12, quotaUpdater);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onGeolocationPermissionsShowPrompt(str, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult2) {
                if (!DSBridgeWebView.this.f16838i) {
                    jsResult2.confirm();
                }
                if (DSBridgeWebView.this.f16836g != null && DSBridgeWebView.this.f16836g.onJsAlert(webView, str, str2, jsResult2)) {
                    return true;
                }
                try {
                } catch (Exception e10) {
                    h.d(SDKConstants.TAG, "onJsAlert:" + e10.getMessage());
                }
                if ((DSBridgeWebView.this.getContext() instanceof Activity) && ((Activity) DSBridgeWebView.this.getContext()).isFinishing()) {
                    return true;
                }
                new AlertDialog.Builder(DSBridgeWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.shu.priory.bridge.DSBridgeWebView.6.1

                    /* renamed from: a */
                    final /* synthetic */ JsResult f16857a;

                    public AnonymousClass1(JsResult jsResult22) {
                        jsResult = jsResult22;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i10) {
                        dialogInterface.dismiss();
                        if (DSBridgeWebView.this.f16838i) {
                            jsResult.confirm();
                        }
                    }
                }).create().show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult2) {
                if (!DSBridgeWebView.this.f16838i) {
                    jsResult2.confirm();
                }
                if (DSBridgeWebView.this.f16836g != null && DSBridgeWebView.this.f16836g.onJsConfirm(webView, str, str2, jsResult2)) {
                    return true;
                }
                AnonymousClass2 anonymousClass2 = new DialogInterface.OnClickListener() { // from class: com.shu.priory.bridge.DSBridgeWebView.6.2

                    /* renamed from: a */
                    final /* synthetic */ JsResult f16859a;

                    public AnonymousClass2(JsResult jsResult22) {
                        jsResult = jsResult22;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i10) {
                        if (DSBridgeWebView.this.f16838i) {
                            if (i10 == -1) {
                                jsResult.confirm();
                            } else {
                                jsResult.cancel();
                            }
                        }
                    }
                };
                try {
                } catch (Exception e10) {
                    h.d(SDKConstants.TAG, "onJsConfirm:" + e10.getMessage());
                }
                if ((DSBridgeWebView.this.getContext() instanceof Activity) && ((Activity) DSBridgeWebView.this.getContext()).isFinishing()) {
                    return true;
                }
                new AlertDialog.Builder(DSBridgeWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, anonymousClass2).setNegativeButton(R.string.cancel, anonymousClass2).show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult2) {
                if (!DSBridgeWebView.this.f16838i) {
                    jsPromptResult2.confirm();
                }
                if (DSBridgeWebView.this.f16836g != null && DSBridgeWebView.this.f16836g.onJsPrompt(webView, str, str2, str3, jsPromptResult2)) {
                    return true;
                }
                EditText editText2 = new EditText(DSBridgeWebView.this.getContext());
                editText2.setText(str3);
                if (str3 != null) {
                    editText2.setSelection(str3.length());
                }
                float f10 = DSBridgeWebView.this.getContext().getResources().getDisplayMetrics().density;
                AnonymousClass3 anonymousClass3 = new DialogInterface.OnClickListener() { // from class: com.shu.priory.bridge.DSBridgeWebView.6.3

                    /* renamed from: a */
                    final /* synthetic */ JsPromptResult f16861a;

                    /* renamed from: b */
                    final /* synthetic */ EditText f16862b;

                    public AnonymousClass3(JsPromptResult jsPromptResult22, EditText editText22) {
                        jsPromptResult = jsPromptResult22;
                        editText = editText22;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i10) {
                        if (DSBridgeWebView.this.f16838i) {
                            if (i10 == -1) {
                                jsPromptResult.confirm(editText.getText().toString());
                            } else {
                                jsPromptResult.cancel();
                            }
                        }
                    }
                };
                new AlertDialog.Builder(DSBridgeWebView.this.getContext()).setTitle(str2).setView(editText22).setCancelable(false).setPositiveButton(R.string.ok, anonymousClass3).setNegativeButton(R.string.cancel, anonymousClass3).show();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i10 = (int) (16.0f * f10);
                layoutParams.setMargins(i10, 0, i10, 0);
                layoutParams.gravity = 1;
                editText22.setLayoutParams(layoutParams);
                int i11 = (int) (15.0f * f10);
                editText22.setPadding(i11 - ((int) (f10 * 5.0f)), i11, i11, i11);
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onJsTimeout() : super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onPermissionRequest(permissionRequest);
                } else {
                    super.onPermissionRequest(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onPermissionRequestCanceled(permissionRequest);
                } else {
                    super.onPermissionRequestCanceled(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i10) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onProgressChanged(webView, i10);
                } else {
                    super.onProgressChanged(webView, i10);
                }
            }

            public void onReachedMaxAppCacheSize(long j10, long j11, WebStorage.QuotaUpdater quotaUpdater) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onReachedMaxAppCacheSize(j10, j11, quotaUpdater);
                }
                super.onReachedMaxAppCacheSize(j10, j11, quotaUpdater);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView webView, Bitmap bitmap) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onReceivedIcon(webView, bitmap);
                } else {
                    super.onReceivedIcon(webView, bitmap);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onReceivedTitle(webView, str);
                } else {
                    super.onReceivedTitle(webView, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView webView, String str, boolean z10) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onReceivedTouchIconUrl(webView, str, z10);
                } else {
                    super.onReceivedTouchIconUrl(webView, str, z10);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView webView) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onRequestFocus(webView);
                } else {
                    super.onRequestFocus(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(14)
            public void onShowCustomView(View view, int i10, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onShowCustomView(view, i10, customViewCallback);
                } else {
                    super.onShowCustomView(view, i10, customViewCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onShowCustomView(view, customViewCallback);
                } else {
                    super.onShowCustomView(view, customViewCallback);
                }
            }
        };
        this.f16832b = new WebViewClient() { // from class: com.shu.priory.bridge.DSBridgeWebView.7
            public AnonymousClass7() {
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (DSBridgeWebView.this.f16837h != null) {
                    DSBridgeWebView.this.f16837h.b();
                } else {
                    super.onPageFinished(webView, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (DSBridgeWebView.this.f16837h != null) {
                    DSBridgeWebView.this.f16837h.a();
                } else {
                    super.onPageStarted(webView, str, bitmap);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i10, String str, String str2) {
                if (DSBridgeWebView.this.f16837h != null) {
                    DSBridgeWebView.this.f16837h.a(i10, str);
                } else {
                    super.onReceivedError(webView, i10, str, str2);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError.getPrimaryError() == 5) {
                    sslErrorHandler.proceed();
                } else {
                    sslErrorHandler.cancel();
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return DSBridgeWebView.this.f16837h != null ? DSBridgeWebView.this.f16837h.a(webView, str) : super.shouldOverrideUrlLoading(webView, str);
            }
        };
        b();
    }

    private void c() {
        a(new Object() { // from class: com.shu.priory.bridge.DSBridgeWebView.1

            /* renamed from: com.shu.priory.bridge.DSBridgeWebView$1$1 */
            public class RunnableC05501 implements Runnable {
                public RunnableC05501() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (DSBridgeWebView.this.f16839j == null || DSBridgeWebView.this.f16839j.a()) {
                        Context context = DSBridgeWebView.this.getContext();
                        if (context instanceof Activity) {
                            ((Activity) context).onBackPressed();
                        }
                    }
                }
            }

            /* renamed from: com.shu.priory.bridge.DSBridgeWebView$1$2 */
            public class AnonymousClass2 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Object f16846a;

                public AnonymousClass2(Object obj2) {
                    obj = obj2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = (JSONObject) obj;
                    try {
                        int i10 = jSONObject.getInt("id");
                        boolean z10 = jSONObject.getBoolean("complete");
                        com.shu.priory.bridge.c cVar = DSBridgeWebView.this.f16831a.get(Integer.valueOf(i10));
                        Object obj2 = jSONObject.has(e.f26408m) ? jSONObject.get(e.f26408m) : null;
                        if (cVar != null) {
                            cVar.a(obj2);
                            if (z10) {
                                DSBridgeWebView.this.f16831a.remove(Integer.valueOf(i10));
                            }
                        }
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                }
            }

            public AnonymousClass1() {
            }

            @JavascriptInterface
            public String closePage(Object obj) throws JSONException {
                DSBridgeWebView.this.a(new Runnable() { // from class: com.shu.priory.bridge.DSBridgeWebView.1.1
                    public RunnableC05501() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (DSBridgeWebView.this.f16839j == null || DSBridgeWebView.this.f16839j.a()) {
                            Context context = DSBridgeWebView.this.getContext();
                            if (context instanceof Activity) {
                                ((Activity) context).onBackPressed();
                            }
                        }
                    }
                });
                return null;
            }

            @JavascriptInterface
            public void disableJavascriptDialogBlock(Object obj) throws JSONException {
                DSBridgeWebView.this.f16838i = !((JSONObject) obj).getBoolean("disable");
            }

            @JavascriptInterface
            public void dsinit(Object obj) {
                DSBridgeWebView.this.d();
            }

            @JavascriptInterface
            public boolean hasNativeMethod(Object obj) throws JSONException {
                Method method;
                boolean z10;
                JSONObject jSONObject = (JSONObject) obj;
                String trim = jSONObject.getString("name").trim();
                String trim2 = jSONObject.getString("type").trim();
                String[] b10 = DSBridgeWebView.this.b(trim);
                Object obj2 = DSBridgeWebView.this.f16833d.get(b10[0]);
                if (obj2 != null) {
                    Class<?> cls = obj2.getClass();
                    try {
                        method = cls.getMethod(b10[1], Object.class, com.shu.priory.bridge.a.class);
                        z10 = true;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        try {
                            method = cls.getMethod(b10[1], Object.class);
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            method = null;
                        }
                        z10 = false;
                    }
                    if (method == null || ((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) == null) {
                        return false;
                    }
                    if ("all".equals(trim2) || ((z10 && "asyn".equals(trim2)) || (!z10 && "syn".equals(trim2)))) {
                        return true;
                    }
                }
                return false;
            }

            @JavascriptInterface
            public void returnValue(Object obj2) {
                DSBridgeWebView.this.a(new Runnable() { // from class: com.shu.priory.bridge.DSBridgeWebView.1.2

                    /* renamed from: a */
                    final /* synthetic */ Object f16846a;

                    public AnonymousClass2(Object obj22) {
                        obj = obj22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject jSONObject = (JSONObject) obj;
                        try {
                            int i10 = jSONObject.getInt("id");
                            boolean z10 = jSONObject.getBoolean("complete");
                            com.shu.priory.bridge.c cVar = DSBridgeWebView.this.f16831a.get(Integer.valueOf(i10));
                            Object obj22 = jSONObject.has(e.f26408m) ? jSONObject.get(e.f26408m) : null;
                            if (cVar != null) {
                                cVar.a(obj22);
                                if (z10) {
                                    DSBridgeWebView.this.f16831a.remove(Integer.valueOf(i10));
                                }
                            }
                        } catch (JSONException e10) {
                            e10.printStackTrace();
                        }
                    }
                });
            }
        }, "_dsb");
    }

    public synchronized void d() {
        try {
            ArrayList<a> arrayList = this.f16840k;
            if (arrayList != null) {
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                this.f16840k = null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z10) {
        WebView.setWebContentsDebuggingEnabled(z10);
        f16830c = z10;
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z10) {
        super.clearCache(z10);
        CookieManager.getInstance().removeAllCookie();
        Context context = getContext();
        try {
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        File file = new File(this.f16834e);
        File file2 = new File(context.getCacheDir().getAbsolutePath() + "/webviewCache");
        if (file2.exists()) {
            a(file2);
        }
        if (file.exists()) {
            a(file);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        a(new Runnable() { // from class: com.shu.priory.bridge.DSBridgeWebView.3

            /* renamed from: a */
            final /* synthetic */ String f16850a;

            public AnonymousClass3(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 != null && str2.startsWith("javascript:")) {
                    DSBridgeWebView.super.loadUrl(str);
                    return;
                }
                DSBridgeWebView.this.f16840k = new ArrayList();
                DSBridgeWebView.super.loadUrl(str);
            }
        });
    }

    @Override // android.webkit.WebView
    public void reload() {
        a(new Runnable() { // from class: com.shu.priory.bridge.DSBridgeWebView.5
            public AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DSBridgeWebView.this.f16840k = new ArrayList();
                DSBridgeWebView.super.reload();
            }
        });
    }

    public void setJavascriptCloseWindowListener(c cVar) {
        this.f16839j = cVar;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f16836g = webChromeClient;
    }

    public void setWebViewClientCallback(d dVar) {
        this.f16837h = dVar;
    }

    public DSBridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16833d = new HashMap();
        this.f16835f = 0;
        this.f16838i = true;
        this.f16839j = null;
        this.f16841l = new b();
        this.f16842m = new Handler(Looper.getMainLooper());
        this.f16831a = new HashMap();
        this.f16843n = new WebChromeClient() { // from class: com.shu.priory.bridge.DSBridgeWebView.6

            /* renamed from: com.shu.priory.bridge.DSBridgeWebView$6$1 */
            public class AnonymousClass1 implements DialogInterface.OnClickListener {

                /* renamed from: a */
                final /* synthetic */ JsResult f16857a;

                public AnonymousClass1(JsResult jsResult22) {
                    jsResult = jsResult22;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    dialogInterface.dismiss();
                    if (DSBridgeWebView.this.f16838i) {
                        jsResult.confirm();
                    }
                }
            }

            /* renamed from: com.shu.priory.bridge.DSBridgeWebView$6$2 */
            public class AnonymousClass2 implements DialogInterface.OnClickListener {

                /* renamed from: a */
                final /* synthetic */ JsResult f16859a;

                public AnonymousClass2(JsResult jsResult22) {
                    jsResult = jsResult22;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (DSBridgeWebView.this.f16838i) {
                        if (i10 == -1) {
                            jsResult.confirm();
                        } else {
                            jsResult.cancel();
                        }
                    }
                }
            }

            /* renamed from: com.shu.priory.bridge.DSBridgeWebView$6$3 */
            public class AnonymousClass3 implements DialogInterface.OnClickListener {

                /* renamed from: a */
                final /* synthetic */ JsPromptResult f16861a;

                /* renamed from: b */
                final /* synthetic */ EditText f16862b;

                public AnonymousClass3(JsPromptResult jsPromptResult22, EditText editText22) {
                    jsPromptResult = jsPromptResult22;
                    editText = editText22;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (DSBridgeWebView.this.f16838i) {
                        if (i10 == -1) {
                            jsPromptResult.confirm(editText.getText().toString());
                        } else {
                            jsPromptResult.cancel();
                        }
                    }
                }
            }

            public AnonymousClass6() {
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.getDefaultVideoPoster() : super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.getVisitedHistory(valueCallback);
                } else {
                    super.getVisitedHistory(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView webView) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onCloseWindow(webView);
                } else {
                    super.onCloseWindow(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i10, String str2) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onConsoleMessage(str, i10, str2);
                } else {
                    super.onConsoleMessage(str, i10, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onCreateWindow(webView, z10, z11, message) : super.onCreateWindow(webView, z10, z11, message);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j10, long j11, long j12, WebStorage.QuotaUpdater quotaUpdater) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onExceededDatabaseQuota(str, str2, j10, j11, j12, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(str, str2, j10, j11, j12, quotaUpdater);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onGeolocationPermissionsShowPrompt(str, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult22) {
                if (!DSBridgeWebView.this.f16838i) {
                    jsResult22.confirm();
                }
                if (DSBridgeWebView.this.f16836g != null && DSBridgeWebView.this.f16836g.onJsAlert(webView, str, str2, jsResult22)) {
                    return true;
                }
                try {
                } catch (Exception e10) {
                    h.d(SDKConstants.TAG, "onJsAlert:" + e10.getMessage());
                }
                if ((DSBridgeWebView.this.getContext() instanceof Activity) && ((Activity) DSBridgeWebView.this.getContext()).isFinishing()) {
                    return true;
                }
                new AlertDialog.Builder(DSBridgeWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.shu.priory.bridge.DSBridgeWebView.6.1

                    /* renamed from: a */
                    final /* synthetic */ JsResult f16857a;

                    public AnonymousClass1(JsResult jsResult222) {
                        jsResult = jsResult222;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i10) {
                        dialogInterface.dismiss();
                        if (DSBridgeWebView.this.f16838i) {
                            jsResult.confirm();
                        }
                    }
                }).create().show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult22) {
                if (!DSBridgeWebView.this.f16838i) {
                    jsResult22.confirm();
                }
                if (DSBridgeWebView.this.f16836g != null && DSBridgeWebView.this.f16836g.onJsConfirm(webView, str, str2, jsResult22)) {
                    return true;
                }
                AnonymousClass2 anonymousClass2 = new DialogInterface.OnClickListener() { // from class: com.shu.priory.bridge.DSBridgeWebView.6.2

                    /* renamed from: a */
                    final /* synthetic */ JsResult f16859a;

                    public AnonymousClass2(JsResult jsResult222) {
                        jsResult = jsResult222;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i10) {
                        if (DSBridgeWebView.this.f16838i) {
                            if (i10 == -1) {
                                jsResult.confirm();
                            } else {
                                jsResult.cancel();
                            }
                        }
                    }
                };
                try {
                } catch (Exception e10) {
                    h.d(SDKConstants.TAG, "onJsConfirm:" + e10.getMessage());
                }
                if ((DSBridgeWebView.this.getContext() instanceof Activity) && ((Activity) DSBridgeWebView.this.getContext()).isFinishing()) {
                    return true;
                }
                new AlertDialog.Builder(DSBridgeWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, anonymousClass2).setNegativeButton(R.string.cancel, anonymousClass2).show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult22) {
                if (!DSBridgeWebView.this.f16838i) {
                    jsPromptResult22.confirm();
                }
                if (DSBridgeWebView.this.f16836g != null && DSBridgeWebView.this.f16836g.onJsPrompt(webView, str, str2, str3, jsPromptResult22)) {
                    return true;
                }
                EditText editText22 = new EditText(DSBridgeWebView.this.getContext());
                editText22.setText(str3);
                if (str3 != null) {
                    editText22.setSelection(str3.length());
                }
                float f10 = DSBridgeWebView.this.getContext().getResources().getDisplayMetrics().density;
                AnonymousClass3 anonymousClass3 = new DialogInterface.OnClickListener() { // from class: com.shu.priory.bridge.DSBridgeWebView.6.3

                    /* renamed from: a */
                    final /* synthetic */ JsPromptResult f16861a;

                    /* renamed from: b */
                    final /* synthetic */ EditText f16862b;

                    public AnonymousClass3(JsPromptResult jsPromptResult222, EditText editText222) {
                        jsPromptResult = jsPromptResult222;
                        editText = editText222;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i10) {
                        if (DSBridgeWebView.this.f16838i) {
                            if (i10 == -1) {
                                jsPromptResult.confirm(editText.getText().toString());
                            } else {
                                jsPromptResult.cancel();
                            }
                        }
                    }
                };
                new AlertDialog.Builder(DSBridgeWebView.this.getContext()).setTitle(str2).setView(editText222).setCancelable(false).setPositiveButton(R.string.ok, anonymousClass3).setNegativeButton(R.string.cancel, anonymousClass3).show();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i10 = (int) (16.0f * f10);
                layoutParams.setMargins(i10, 0, i10, 0);
                layoutParams.gravity = 1;
                editText222.setLayoutParams(layoutParams);
                int i11 = (int) (15.0f * f10);
                editText222.setPadding(i11 - ((int) (f10 * 5.0f)), i11, i11, i11);
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onJsTimeout() : super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onPermissionRequest(permissionRequest);
                } else {
                    super.onPermissionRequest(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onPermissionRequestCanceled(permissionRequest);
                } else {
                    super.onPermissionRequestCanceled(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i10) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onProgressChanged(webView, i10);
                } else {
                    super.onProgressChanged(webView, i10);
                }
            }

            public void onReachedMaxAppCacheSize(long j10, long j11, WebStorage.QuotaUpdater quotaUpdater) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onReachedMaxAppCacheSize(j10, j11, quotaUpdater);
                }
                super.onReachedMaxAppCacheSize(j10, j11, quotaUpdater);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView webView, Bitmap bitmap) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onReceivedIcon(webView, bitmap);
                } else {
                    super.onReceivedIcon(webView, bitmap);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onReceivedTitle(webView, str);
                } else {
                    super.onReceivedTitle(webView, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView webView, String str, boolean z10) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onReceivedTouchIconUrl(webView, str, z10);
                } else {
                    super.onReceivedTouchIconUrl(webView, str, z10);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView webView) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onRequestFocus(webView);
                } else {
                    super.onRequestFocus(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(14)
            public void onShowCustomView(View view, int i10, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onShowCustomView(view, i10, customViewCallback);
                } else {
                    super.onShowCustomView(view, i10, customViewCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return DSBridgeWebView.this.f16836g != null ? DSBridgeWebView.this.f16836g.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DSBridgeWebView.this.f16836g != null) {
                    DSBridgeWebView.this.f16836g.onShowCustomView(view, customViewCallback);
                } else {
                    super.onShowCustomView(view, customViewCallback);
                }
            }
        };
        this.f16832b = new WebViewClient() { // from class: com.shu.priory.bridge.DSBridgeWebView.7
            public AnonymousClass7() {
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (DSBridgeWebView.this.f16837h != null) {
                    DSBridgeWebView.this.f16837h.b();
                } else {
                    super.onPageFinished(webView, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (DSBridgeWebView.this.f16837h != null) {
                    DSBridgeWebView.this.f16837h.a();
                } else {
                    super.onPageStarted(webView, str, bitmap);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i10, String str, String str2) {
                if (DSBridgeWebView.this.f16837h != null) {
                    DSBridgeWebView.this.f16837h.a(i10, str);
                } else {
                    super.onReceivedError(webView, i10, str, str2);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (sslError.getPrimaryError() == 5) {
                    sslErrorHandler.proceed();
                } else {
                    sslErrorHandler.cancel();
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return DSBridgeWebView.this.f16837h != null ? DSBridgeWebView.this.f16837h.a(webView, str) : super.shouldOverrideUrlLoading(webView, str);
            }
        };
        b();
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void b() {
        this.f16834e = getContext().getFilesDir().getAbsolutePath() + "/webcache";
        WebSettings settings = getSettings();
        settings.setDomStorageEnabled(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        settings.setMixedContentMode(0);
        settings.setUserAgentString(settings.getUserAgentString());
        settings.setAllowFileAccess(false);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCachePath(this.f16834e);
        settings.setUseWideViewPort(true);
        super.setWebChromeClient(this.f16843n);
        super.setWebViewClient(this.f16832b);
        c();
        super.addJavascriptInterface(this.f16841l, "_dsbridge");
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        a(new Runnable() { // from class: com.shu.priory.bridge.DSBridgeWebView.4

            /* renamed from: a */
            final /* synthetic */ String f16852a;

            /* renamed from: b */
            final /* synthetic */ Map f16853b;

            public AnonymousClass4(String str2, Map map2) {
                str = str2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 != null && str2.startsWith("javascript:")) {
                    DSBridgeWebView.super.loadUrl(str, map);
                    return;
                }
                DSBridgeWebView.this.f16840k = new ArrayList();
                DSBridgeWebView.super.loadUrl(str, map);
            }
        });
    }

    private void a(a aVar) {
        a(String.format("window._handleMessageFromNative(%s)", aVar.toString()));
    }

    public void c(String str) {
        super.evaluateJavascript(str, null);
    }

    public String[] b(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
            str = str.substring(lastIndexOf + 1);
        } else {
            str2 = "";
        }
        return new String[]{str2, str};
    }

    public void a(File file) {
        if (!file.exists()) {
            h.d(SDKConstants.TAG, "delete file no exists " + file.getAbsolutePath());
            return;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                a(file2);
            }
        }
        file.delete();
    }

    public void a(Object obj, String str) {
        if (str == null) {
            str = "";
        }
        if (obj != null) {
            this.f16833d.put(str, obj);
        }
    }

    public void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f16842m.post(runnable);
        }
    }

    public void a(String str) {
        a(new Runnable() { // from class: com.shu.priory.bridge.DSBridgeWebView.2

            /* renamed from: a */
            final /* synthetic */ String f16848a;

            public AnonymousClass2(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DSBridgeWebView.this.c(str);
            }
        });
    }

    public synchronized <T> void a(String str, Object[] objArr, com.shu.priory.bridge.c<T> cVar) {
        try {
            int i10 = this.f16835f + 1;
            this.f16835f = i10;
            a aVar = new a(str, i10, objArr);
            if (cVar != null) {
                this.f16831a.put(Integer.valueOf(aVar.f16866b), cVar);
            }
            ArrayList<a> arrayList = this.f16840k;
            if (arrayList != null) {
                arrayList.add(aVar);
            } else {
                a(aVar);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
