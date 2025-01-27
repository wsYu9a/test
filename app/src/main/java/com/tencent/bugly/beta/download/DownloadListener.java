package com.tencent.bugly.beta.download;

/* loaded from: classes4.dex */
public interface DownloadListener {
    void onCompleted(DownloadTask downloadTask);

    void onFailed(DownloadTask downloadTask, int i2, String str);

    void onReceive(DownloadTask downloadTask);
}
