package com.vivo.ic.webview;

import android.webkit.JavascriptInterface;

/* loaded from: classes4.dex */
public interface JsInterface {
    @JavascriptInterface
    void copy(String str, String str2) throws Exception;

    @JavascriptInterface
    void download(String str, String str2) throws Exception;

    @JavascriptInterface
    void enableSoftInputHiden(String str, String str2) throws Exception;

    @JavascriptInterface
    void exit(String str, String str2) throws Exception;

    @JavascriptInterface
    void getNetType(String str, String str2);

    @JavascriptInterface
    void hideSoftKeyBoard(String str, String str2);

    @JavascriptInterface
    void isPackageInstall(String str, String str2) throws Exception;

    @JavascriptInterface
    void login(String str, String str2);

    @JavascriptInterface
    void openAppByDeepLink(String str, String str2) throws Exception;

    @JavascriptInterface
    void openAppByPackage(String str, String str2) throws Exception;

    @JavascriptInterface
    void registerBack(String str, String str2) throws Exception;

    @JavascriptInterface
    void requestedOrientation(String str, String str2) throws Exception;

    @JavascriptInterface
    void share(String str, String str2);

    @JavascriptInterface
    void toast(String str, String str2) throws Exception;

    @JavascriptInterface
    void unregisterBack(String str, String str2) throws Exception;

    @JavascriptInterface
    void webBackPress(String str, String str2);

    @JavascriptInterface
    void webViewFull(String str, String str2) throws Exception;
}
