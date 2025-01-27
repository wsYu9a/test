package com.alimm.tanx.core.net;

import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener;
import com.alimm.tanx.core.net.okhttp.callback.OnUploadListener;
import java.io.File;

/* loaded from: classes.dex */
public interface INetWork<T> {
    void cancelOkHttpTag(String str);

    void sendHttpDownload(RequestBean requestBean, OnDownloadListener onDownloadListener);

    void sendHttpGet(RequestBean requestBean, Class<T> cls, NetWorkCallBack netWorkCallBack);

    void sendHttpGet(RequestBean requestBean, Class<T> cls, boolean z10, boolean z11, NetWorkCallBack netWorkCallBack);

    void sendHttpPost(RequestBean requestBean, Class<T> cls, NetWorkCallBack netWorkCallBack);

    void sendHttpPost(RequestBean requestBean, Class<T> cls, boolean z10, NetWorkCallBack netWorkCallBack);

    T sendSyncHttpPost2Gzip(RequestBean requestBean, Class<T> cls);

    void uploadFile(RequestBean requestBean, File file, OnUploadListener onUploadListener);
}
