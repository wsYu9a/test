package com.vivo.ic.webview;

/* loaded from: classes4.dex */
public interface IBridge {
    void addJavaHandler(String str, CallBack callBack);

    void callJs(String str, CallBack callBack, String str2);

    void execute(String str);

    void fetchJsMsgQueue();

    CallBack getJavaHandlerCallBack(String str);

    void requestJs(String str, CallBack callBack, String str2);
}
