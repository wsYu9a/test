package com.alimm.tanx.core.web.webview;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.WebConfigBean;
import com.alimm.tanx.core.utils.LogUtils;
import java.lang.ref.WeakReference;
import java.util.Stack;

/* loaded from: classes.dex */
public class PreloadWebView {
    private static final int CACHED_WEB_VIEW_MAX_NUM = 3;
    private static String TAG = "PreloadWebView";
    private static final Stack<WeakReference<TanxAdWebView>> mCachedWebViewStack = new Stack<>();
    private Handler mainHandler;

    /* renamed from: com.alimm.tanx.core.web.webview.PreloadWebView$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PreloadWebView.this.pushCachedWebViewStack();
        }
    }

    /* renamed from: com.alimm.tanx.core.web.webview.PreloadWebView$2 */
    public class AnonymousClass2 implements MessageQueue.IdleHandler {
        public AnonymousClass2() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            LogUtils.d("PreloadWebView", "-->queueIdle");
            PreloadWebView.mCachedWebViewStack.push(PreloadWebView.this.createWebView());
            return false;
        }
    }

    public static class Holder {
        private static final PreloadWebView INSTANCE = new PreloadWebView();

        private Holder() {
        }
    }

    public /* synthetic */ PreloadWebView(AnonymousClass1 anonymousClass1) {
        this();
    }

    public WeakReference<TanxAdWebView> createWebView() {
        TanxAdWebView tanxAdWebView = new TanxAdWebView(new MutableContextWrapper(TanxCoreSdk.getApplication()));
        tanxAdWebView.getSettings().setJavaScriptEnabled(true);
        tanxAdWebView.loadDataWithBaseURL("file:///android_asset/article/?item_id=0&token=0", getHtml(), "text/html", "utf-8", "file:///android_asset/article/?item_id=0&token=0");
        return new WeakReference<>(tanxAdWebView);
    }

    private static String getHtml() {
        return "<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"utf-8\">\n<meta name=\"viewport\" content=\"initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/article/css/android.css\">\n</head>\n<body class=\"font_m\"><header></header><article></article><footer></footer><script type=\"text/javascript\" src=\"file:///android_asset/article/js/lib.js\"></script><script type=\"text/javascript\" src=\"file:///android_asset/article/js/android.js\" ></script>\n</body>\n</html>\n";
    }

    private long getInitDelayTime(boolean z10) {
        if (!z10) {
            return 0L;
        }
        WebConfigBean webConfigBean = OrangeManager.getInstance().getWebConfigBean();
        if (webConfigBean == null) {
            webConfigBean = new WebConfigBean();
        }
        long j10 = webConfigBean.sdkInitWebViewPreloadDelayed;
        if (j10 < 0) {
            return 0L;
        }
        return j10;
    }

    public static PreloadWebView getInstance() {
        return Holder.INSTANCE;
    }

    private void initSettings(TanxAdWebView tanxAdWebView) {
        WebSettings settings = tanxAdWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setDefaultTextEncodingName("UTF-8");
        CookieManager.getInstance();
        settings.setMixedContentMode(2);
    }

    private boolean isPreload(boolean z10) {
        WebConfigBean webConfigBean = OrangeManager.getInstance().getWebConfigBean();
        if (webConfigBean == null) {
            webConfigBean = new WebConfigBean();
        }
        LogUtils.d(TAG, "isPreload webConfigBean:" + webConfigBean.toString());
        if (z10) {
            boolean z11 = webConfigBean.closeInitWebPreload;
            LogUtils.d(TAG, "isPreload initSwitch:" + z11);
            return !z11;
        }
        boolean z12 = webConfigBean.closeNextWebPreload;
        LogUtils.d(TAG, "isPreload nextWebSwitch:" + z12);
        return !z12;
    }

    public static void loadBaseHtml(TanxAdWebView tanxAdWebView) {
        if (tanxAdWebView == null) {
            return;
        }
        tanxAdWebView.loadDataWithBaseURL("file:///android_asset/article/?item_id=0&token=0", getHtml(), "text/html", "utf-8", "file:///android_asset/article/?item_id=0&token=0");
    }

    public void pushCachedWebViewStack() {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.alimm.tanx.core.web.webview.PreloadWebView.2
            public AnonymousClass2() {
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                LogUtils.d("PreloadWebView", "-->queueIdle");
                PreloadWebView.mCachedWebViewStack.push(PreloadWebView.this.createWebView());
                return false;
            }
        });
    }

    public void destroy() {
        Stack<WeakReference<TanxAdWebView>> stack = mCachedWebViewStack;
        if (stack != null) {
            stack.clear();
        }
    }

    public TanxAdWebView getWebView(Context context) {
        TanxAdWebView tanxAdWebView;
        Stack<WeakReference<TanxAdWebView>> stack = mCachedWebViewStack;
        if (stack == null || stack.isEmpty() || (tanxAdWebView = stack.pop().get()) == null) {
            WeakReference<TanxAdWebView> createWebView = createWebView();
            ((MutableContextWrapper) createWebView.get().getContext()).setBaseContext(context);
            tanxAdWebView = createWebView.get();
        } else {
            ((MutableContextWrapper) tanxAdWebView.getContext()).setBaseContext(context);
        }
        tanxAdWebView.setWebClickable(true);
        initSettings(tanxAdWebView);
        return tanxAdWebView;
    }

    public void preload(boolean z10) {
        LogUtils.d(TAG, "webView preload formSdkInit :" + z10);
        if (!isPreload(z10)) {
            LogUtils.d(TAG, "preload取消");
            return;
        }
        LogUtils.d(TAG, "webView preload开始");
        if (mCachedWebViewStack.size() >= 3) {
            LogUtils.d(TAG, "webView preload mCachedWebViewStack已满，取消");
            return;
        }
        LogUtils.d(TAG, "webView preload 通过mainHandler pushCachedWebViewStack");
        if (this.mainHandler == null) {
            this.mainHandler = new Handler(Looper.getMainLooper());
        }
        long initDelayTime = getInitDelayTime(z10);
        LogUtils.d(TAG, "webView preload delayTime毫秒 :" + initDelayTime);
        this.mainHandler.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.web.webview.PreloadWebView.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PreloadWebView.this.pushCachedWebViewStack();
            }
        }, initDelayTime);
    }

    private PreloadWebView() {
    }
}
