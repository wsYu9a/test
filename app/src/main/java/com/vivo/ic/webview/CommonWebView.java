package com.vivo.ic.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewOverlay;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Scroller;
import com.vivo.mobilead.web.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class CommonWebView extends WebView implements IBridge {
    private static final int LOLLIPOP = 21;
    private static final String TAG = "HtmlWebView";
    private HtmlWebChromeClient mChromeClient;
    private Context mContext;
    private float mDownX;
    private float mDownY;
    private Handler mHandler;
    private boolean mHideInputEnable;
    private boolean mHideInputView;
    private boolean mHideKeyboard;
    private InputMethodManager mInputManager;
    private HashMap<String, CallBack> mJavaHandlers;
    private KeyboardStateListener mKeyboardStateListener;
    private float mMoveDistance;
    private NotCompatiblityHandler mNotCompatiblityHandler;
    private Map<String, CallBack> mResponseCallbacks;
    private Scroller mScroller;
    private WebCallBack mWebCallBack;
    private b mWebViewClient;

    /* renamed from: com.vivo.ic.webview.CommonWebView$1 */
    class AnonymousClass1 extends com.vivo.mobilead.util.f1.b {
        final /* synthetic */ String val$command;

        AnonymousClass1(String str) {
            format = str;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            CommonWebView.this.loadUrl(format);
        }
    }

    /* renamed from: com.vivo.ic.webview.CommonWebView$2 */
    class AnonymousClass2 extends com.vivo.mobilead.util.f1.b {
        final /* synthetic */ String val$command;

        AnonymousClass2(String str) {
            format = str;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            CommonWebView.this.loadUrl(format);
        }
    }

    public interface KeyboardStateListener {
        boolean onPreparedHideKeyboard();
    }

    public CommonWebView(Context context) {
        this(context, null);
    }

    private void checkEmptyPage(int i2) {
        if (i2 < 0) {
            if (!isCurrentEmptyPage()) {
                WebCallBack webCallBack = this.mWebCallBack;
                if (webCallBack != null) {
                    webCallBack.onGoBack();
                    return;
                }
                return;
            }
            if (canGoBack()) {
                goBack();
                return;
            }
            WebCallBack webCallBack2 = this.mWebCallBack;
            if (webCallBack2 != null) {
                webCallBack2.onBackToLastEmptyPage();
            }
        }
    }

    private void enableThirdCookies() {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        }
    }

    private boolean isCurrentEmptyPage() {
        WebHistoryItem currentItem;
        String originalUrl;
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        return (copyBackForwardList == null || (currentItem = copyBackForwardList.getCurrentItem()) == null || (originalUrl = currentItem.getOriginalUrl()) == null || !originalUrl.contains("text/html")) ? false : true;
    }

    public static boolean isWebViewResultCode(int i2) {
        return HTMLFileUploader.isWebViewCode(i2);
    }

    private void removeJs() {
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ic.webview.IBridge
    public void addJavaHandler(String str, CallBack callBack) {
        this.mJavaHandlers.put(str, callBack);
    }

    @Override // com.vivo.ic.webview.IBridge
    public void callJs(String str, CallBack callBack, String str2) {
        Log.d(TAG, "callJs " + str2);
        BridgeMsg bridgeMsg = new BridgeMsg();
        bridgeMsg.setJsHandler(str);
        bridgeMsg.setRequestData(str2);
        bridgeMsg.setRequestType(BridgeUtils.CALL_JS_RESPONSE);
        if (callBack != null) {
            this.mResponseCallbacks.put(str, callBack);
            bridgeMsg.setResponseCallback(str);
        }
        this.mHandler.post(new com.vivo.mobilead.util.f1.b() { // from class: com.vivo.ic.webview.CommonWebView.1
            final /* synthetic */ String val$command;

            AnonymousClass1(String str3) {
                format = str3;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                CommonWebView.this.loadUrl(format);
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(0, this.mScroller.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }

    public void enableHideSoftInputWhenScroll(boolean z) {
        this.mHideInputEnable = z;
    }

    @Override // com.vivo.ic.webview.IBridge
    public void execute(String str) {
        CallBack callBack;
        Log.d(TAG, "webView execute bridge " + str);
        String parseHandler = BridgeUtils.parseHandler(str);
        String callBack2 = BridgeUtils.getCallBack(str);
        String data = BridgeUtils.getData(str);
        int bridgeType = BridgeUtils.getBridgeType(str);
        if (1 == bridgeType) {
            callBack = this.mJavaHandlers.get(parseHandler);
        } else if (2 == bridgeType) {
            callBack = this.mResponseCallbacks.get(parseHandler);
        } else {
            if (3 == bridgeType) {
                this.mWebViewClient.a(parseHandler, data, callBack2);
                return;
            }
            callBack = null;
        }
        Log.d(TAG, "find javaHandler " + parseHandler + ", and callback is " + callBack);
        if (callBack != null) {
            callBack.onCallBack(data, callBack2);
            return;
        }
        if (this.mNotCompatiblityHandler != null) {
            String notCompatiblityJsCallBack = !TextUtils.isEmpty(data) ? BridgeUtils.getNotCompatiblityJsCallBack(data) : null;
            if (TextUtils.isEmpty(notCompatiblityJsCallBack)) {
                this.mNotCompatiblityHandler.catchNotCompatiblityByLocal(parseHandler, null);
            } else {
                this.mNotCompatiblityHandler.catchNotCompatiblityByWeb(parseHandler, notCompatiblityJsCallBack);
            }
        }
    }

    @Override // com.vivo.ic.webview.IBridge
    public void fetchJsMsgQueue() {
        loadUrl("javascript:window.WeiwoJSBridge._continueSendMsg();");
    }

    public IBridge getBridge() {
        return this;
    }

    @Override // com.vivo.ic.webview.IBridge
    public CallBack getJavaHandlerCallBack(String str) {
        return this.mJavaHandlers.get(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.webkit.WebView
    public void goBack() {
        super.goBack();
        checkEmptyPage(-1);
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int i2) {
        super.goBackOrForward(i2);
        checkEmptyPage(i2);
    }

    public boolean goBackToCorrectPage(int i2) {
        if (this.mWebViewClient.a()) {
            return true;
        }
        if (i2 < 0 && canGoBackOrForward(i2)) {
            goBackOrForward(i2);
            return true;
        }
        if (!canGoBack()) {
            return false;
        }
        goBack();
        return true;
    }

    public void grantePermission() {
        this.mChromeClient.onCameraPermissionGranted();
    }

    public void init(Context context) {
        try {
            this.mMoveDistance = context.getResources().getDisplayMetrics().density * 6.0f;
        } catch (Exception unused) {
            Log.e(TAG, "get Resource is null or getDisplaymetrics is null");
            this.mMoveDistance = 12.0f;
        }
        setDownloadListener(new WebViewDownloadListener(context));
        setWebChromeClient(new HtmlWebChromeClient(this.mContext));
        this.mScroller = new Scroller(context);
    }

    public void initWebSettings(String str) {
        WebSettings settings = getSettings();
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setBuiltInZoomControls(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setSavePassword(false);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        settings.setUserAgentString(str + " " + settings.getUserAgentString());
        settings.setAllowFileAccess(true);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        try {
            settings.getClass().getMethod("setMixedContentMode", Integer.TYPE).invoke(settings, 0);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        HtmlWebChromeClient htmlWebChromeClient = this.mChromeClient;
        if (htmlWebChromeClient != null && htmlWebChromeClient.shouldEnableThirdCookies(str)) {
            enableThirdCookies();
        }
        super.loadUrl(str);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        HtmlWebChromeClient htmlWebChromeClient = this.mChromeClient;
        if (htmlWebChromeClient != null) {
            htmlWebChromeClient.onActivityResult(i2, i3, intent);
        } else {
            Log.w(TAG, "onActivityResult mChromeClient type err");
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
    
        if (r0 != 3) goto L80;
     */
    @Override // android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.mHideInputEnable
            if (r0 != 0) goto L9
            boolean r5 = super.onTouchEvent(r5)
            return r5
        L9:
            int r0 = r5.getAction()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L76
            if (r0 == r1) goto L71
            r3 = 2
            if (r0 == r3) goto L1a
            r3 = 3
            if (r0 == r3) goto L71
            goto L86
        L1a:
            float r0 = r5.getX()
            float r0 = java.lang.Math.abs(r0)
            float r3 = r4.mDownX
            float r0 = r0 - r3
            float r3 = r4.mMoveDistance
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L3c
            float r0 = r5.getY()
            float r3 = r4.mDownY
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            float r3 = r4.mMoveDistance
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 < 0) goto L86
        L3c:
            android.view.inputmethod.InputMethodManager r0 = r4.mInputManager     // Catch: java.lang.Exception -> L6f
            if (r0 != 0) goto L4e
            android.content.Context r0 = r4.getContext()     // Catch: java.lang.Exception -> L6f
            java.lang.String r3 = "input_method"
            java.lang.Object r0 = r0.getSystemService(r3)     // Catch: java.lang.Exception -> L6f
            android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0     // Catch: java.lang.Exception -> L6f
            r4.mInputManager = r0     // Catch: java.lang.Exception -> L6f
        L4e:
            boolean r0 = r4.mHideKeyboard     // Catch: java.lang.Exception -> L6f
            if (r0 != 0) goto L5e
            android.view.inputmethod.InputMethodManager r0 = r4.mInputManager     // Catch: java.lang.Exception -> L6f
            android.os.IBinder r3 = r4.getWindowToken()     // Catch: java.lang.Exception -> L6f
            boolean r0 = r0.hideSoftInputFromWindow(r3, r2)     // Catch: java.lang.Exception -> L6f
            r4.mHideKeyboard = r0     // Catch: java.lang.Exception -> L6f
        L5e:
            boolean r0 = r4.mHideInputView     // Catch: java.lang.Exception -> L6f
            if (r0 != 0) goto L86
            com.vivo.ic.webview.CommonWebView$KeyboardStateListener r0 = r4.mKeyboardStateListener     // Catch: java.lang.Exception -> L6f
            if (r0 == 0) goto L86
            boolean r0 = r0.onPreparedHideKeyboard()     // Catch: java.lang.Exception -> L6f
            if (r0 == 0) goto L86
            r4.mHideInputView = r1     // Catch: java.lang.Exception -> L6f
            goto L86
        L6f:
            goto L86
        L71:
            r4.mHideKeyboard = r2
            r4.mHideInputView = r2
            goto L86
        L76:
            r4.mHideKeyboard = r2
            r4.mHideInputView = r2
            float r0 = r5.getX()
            r4.mDownX = r0
            float r0 = r5.getY()
            r4.mDownY = r0
        L86:
            boolean r0 = r4.mHideKeyboard
            if (r0 != 0) goto L92
            boolean r0 = r4.mHideInputView
            if (r0 != 0) goto L92
            boolean r1 = super.onTouchEvent(r5)
        L92:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.webview.CommonWebView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.vivo.ic.webview.IBridge
    public void requestJs(String str, CallBack callBack, String str2) {
        Log.d(TAG, "callJs " + str2);
        BridgeMsg bridgeMsg = new BridgeMsg();
        bridgeMsg.setJsHandler(str);
        bridgeMsg.setRequestData(str2);
        bridgeMsg.setRequestType("request");
        if (callBack != null) {
            this.mResponseCallbacks.put(str, callBack);
            bridgeMsg.setResponseCallback(str);
        }
        this.mHandler.post(new com.vivo.mobilead.util.f1.b() { // from class: com.vivo.ic.webview.CommonWebView.2
            final /* synthetic */ String val$command;

            AnonymousClass2(String str3) {
                format = str3;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                CommonWebView.this.loadUrl(format);
            }
        });
    }

    public void setChromeClient(HtmlWebChromeClient htmlWebChromeClient) {
        this.mChromeClient = htmlWebChromeClient;
    }

    public void setKeyboardStateListener(KeyboardStateListener keyboardStateListener) {
        this.mKeyboardStateListener = keyboardStateListener;
    }

    public void setNotCompatiblityHandler(NotCompatiblityHandler notCompatiblityHandler) {
        this.mNotCompatiblityHandler = notCompatiblityHandler;
    }

    public void setWebCallBack(WebCallBack webCallBack) {
        this.mWebCallBack = webCallBack;
        this.mWebViewClient.a(webCallBack);
        this.mChromeClient.setWebCallBack(webCallBack);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (webChromeClient instanceof HtmlWebChromeClient) {
            this.mChromeClient = (HtmlWebChromeClient) webChromeClient;
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof b) {
            this.mWebViewClient = (b) webViewClient;
        }
        super.setWebViewClient(webViewClient);
    }

    public void smoothscrollToTop() {
        if (getScrollY() > 0) {
            this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY());
            invalidate();
        }
    }

    public CommonWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CommonWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mMoveDistance = 0.0f;
        this.mHideKeyboard = false;
        this.mHideInputView = false;
        this.mJavaHandlers = new HashMap<>();
        this.mResponseCallbacks = new HashMap();
        this.mHandler = new Handler();
        this.mHideInputEnable = false;
        this.mContext = context;
        setFocusable(true);
        setFocusableInTouchMode(true);
        init(context);
        initWebSettings(null);
        removeJs();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        HtmlWebChromeClient htmlWebChromeClient = this.mChromeClient;
        if (htmlWebChromeClient != null && htmlWebChromeClient.shouldEnableThirdCookies(str)) {
            enableThirdCookies();
        }
        super.loadUrl(str, map);
    }
}
