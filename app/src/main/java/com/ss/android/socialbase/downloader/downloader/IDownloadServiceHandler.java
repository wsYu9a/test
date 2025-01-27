package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public interface IDownloadServiceHandler<T extends DownloadService> {
    boolean isServiceAlive();

    boolean isServiceForeground();

    IBinder onBind(Intent intent);

    void onDestroy();

    void onStartCommand(Intent intent, int i2, int i3);

    void onStartCommandOnMainThread();

    void pendDownloadTask(DownloadTask downloadTask);

    void setDownloadService(WeakReference<T> weakReference);

    void setLogLevel(int i2);

    void setServiceConnectionListener(IDownloadServiceConnectionListener iDownloadServiceConnectionListener);

    void startForeground(int i2, Notification notification);

    void startService();

    void stopForeground(boolean z);

    void tryDownload(DownloadTask downloadTask);

    void tryDownloadWithEngine(DownloadTask downloadTask);
}
