package com.alimm.tanx.core.net.okhttp.callback;

import java.io.File;

/* loaded from: classes.dex */
public interface OnDownloadListener {
    void onDownLoadTotal(long j10);

    void onDownloadFailed(int i10, String str);

    void onDownloadSuccess(File file);

    void onDownloading(int i10);
}
