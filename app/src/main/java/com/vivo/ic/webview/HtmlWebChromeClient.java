package com.vivo.ic.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import b.d.a.j.b;
import java.io.File;

/* loaded from: classes4.dex */
public class HtmlWebChromeClient extends WebChromeClient {
    private static final ViewGroup.LayoutParams COVER_SCREEN_PARAMS = new ViewGroup.LayoutParams(-1, -1);
    private static final String TAG = "HtmlWebChromeClient";
    private Context mContext;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private HTMLFileUploader mUploader;
    private WebCallBack mWebCallBack;

    /* renamed from: com.vivo.ic.webview.HtmlWebChromeClient$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$webkit$ConsoleMessage$MessageLevel;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.TIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public HtmlWebChromeClient(Context context) {
        this.mUploader = new HTMLFileUploader(context, this);
        this.mContext = context;
    }

    public static void fullScreen(Activity activity, boolean z, View view) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (view != null) {
            view.setSystemUiVisibility(z ? 5638 : 0);
        }
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        window.setAttributes(attributes);
    }

    private boolean isActivityFinished() {
        Context context = this.mContext;
        return (context instanceof Activity) && ((Activity) context).isFinishing();
    }

    protected boolean checkCameraPermission() {
        return false;
    }

    public File createCamerPhoto() {
        String str = Environment.getExternalStorageDirectory() + File.separator + b.r;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(str, String.format("IMG_%s.jpg", Long.valueOf(System.currentTimeMillis())));
    }

    protected Uri generateFileUri(File file) {
        return Uri.fromFile(file);
    }

    protected FrameLayout getCustomView() {
        return (FrameLayout) ((Activity) this.mContext).getWindow().getDecorView();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        this.mUploader.onActivityResult(i2, i3, intent);
    }

    public void onCameraPermissionGranted() {
        this.mUploader.launchCamera();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "Console: " + consoleMessage.message() + " " + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber();
        int i2 = AnonymousClass1.$SwitchMap$android$webkit$ConsoleMessage$MessageLevel[consoleMessage.messageLevel().ordinal()];
        if (i2 == 1) {
            Log.d(TAG, "javacript-console:TIP: " + str);
        } else if (i2 == 2) {
            Log.d(TAG, "javacript-console:LOG: " + str);
        } else if (i2 == 3) {
            Log.w(TAG, "javacript-console:WARNING: " + str);
        } else if (i2 == 4) {
            Log.e(TAG, "javacript-console:ERROR: " + str);
        } else if (i2 == 5) {
            Log.d(TAG, "javacript-console:DEBUG: " + str);
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        if (this.mCustomView != null) {
            Activity activity = (Activity) this.mContext;
            getCustomView().removeView(this.mCustomView);
            fullScreen(activity, false, this.mCustomView);
            this.mCustomView = null;
            WebChromeClient.CustomViewCallback customViewCallback = this.mCustomViewCallback;
            if (customViewCallback != null) {
                customViewCallback.onCustomViewHidden();
            }
            activity.setRequestedOrientation(1);
        }
        super.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (isActivityFinished()) {
            return true;
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (isActivityFinished()) {
            return true;
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (isActivityFinished()) {
            return true;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (isActivityFinished()) {
            return true;
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        WebCallBack webCallBack = this.mWebCallBack;
        if (webCallBack != null) {
            webCallBack.onProgressChanged(i2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        WebCallBack webCallBack = this.mWebCallBack;
        if (webCallBack != null) {
            webCallBack.onReceivedTitle(str);
        }
        super.onReceivedTitle(webView, str);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.mCustomView != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            getCustomView().addView(view, COVER_SCREEN_PARAMS);
            this.mCustomView = view;
            this.mCustomViewCallback = customViewCallback;
            fullScreen(activity, true, view);
            activity.setRequestedOrientation(0);
        }
        super.onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        this.mUploader.setUploadMsgs(valueCallback);
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        this.mUploader.startActivity(null, fileChooserParams.getAcceptTypes(), fileChooserParams.isCaptureEnabled());
        return true;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        this.mUploader.startActivity(valueCallback, new String[]{str}, false);
    }

    public void setWebCallBack(WebCallBack webCallBack) {
        this.mWebCallBack = webCallBack;
    }

    protected boolean shouldEnableThirdCookies(String str) {
        return true;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.mUploader.startActivity(valueCallback, new String[]{str}, HTMLFileUploader.getiIsCaptureEnabled(str, str2));
    }
}
