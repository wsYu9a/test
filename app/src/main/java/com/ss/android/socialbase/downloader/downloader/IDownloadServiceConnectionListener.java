package com.ss.android.socialbase.downloader.downloader;

import android.os.IBinder;

/* loaded from: classes4.dex */
public interface IDownloadServiceConnectionListener {
    void onServiceConnection(IBinder iBinder);

    void onServiceDisConnection();
}
