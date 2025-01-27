package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.constants.BoundType;
import com.ss.android.socialbase.downloader.model.DownloadTask;

/* loaded from: classes4.dex */
public interface IDownloadTaskExecuteListener {
    void onFinish(DownloadTask downloadTask, @BoundType int i2);

    void onStart(DownloadTask downloadTask, @BoundType int i2);
}
