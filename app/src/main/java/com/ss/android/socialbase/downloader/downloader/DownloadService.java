package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public class DownloadService extends Service {
    private static final String TAG = DownloadService.class.getSimpleName();
    protected IDownloadServiceHandler downloadServiceHandler;

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadService$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int val$flags;
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ int val$startId;

        AnonymousClass1(Intent intent, int i2, int i3) {
            intent = intent;
            i2 = i2;
            i3 = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            IDownloadServiceHandler iDownloadServiceHandler = DownloadService.this.downloadServiceHandler;
            if (iDownloadServiceHandler != null) {
                iDownloadServiceHandler.onStartCommand(intent, i2, i3);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onBind downloadServiceHandler != null:");
        sb.append(this.downloadServiceHandler != null);
        Logger.d(str, sb.toString());
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            return iDownloadServiceHandler.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
        IDownloadServiceHandler downloadServiceHandler = DownloadComponentManager.getDownloadServiceHandler();
        this.downloadServiceHandler = downloadServiceHandler;
        downloadServiceHandler.setDownloadService(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (Logger.debug()) {
            Logger.d(TAG, "Service onDestroy");
        }
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.onDestroy();
            this.downloadServiceHandler = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (Logger.debug()) {
            Logger.d(TAG, "DownloadService onStartCommand");
        }
        this.downloadServiceHandler.onStartCommandOnMainThread();
        ExecutorService cPUThreadExecutor = DownloadComponentManager.getCPUThreadExecutor();
        if (cPUThreadExecutor != null) {
            cPUThreadExecutor.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                final /* synthetic */ int val$flags;
                final /* synthetic */ Intent val$intent;
                final /* synthetic */ int val$startId;

                AnonymousClass1(Intent intent2, int i22, int i32) {
                    intent = intent2;
                    i2 = i22;
                    i3 = i32;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IDownloadServiceHandler iDownloadServiceHandler = DownloadService.this.downloadServiceHandler;
                    if (iDownloadServiceHandler != null) {
                        iDownloadServiceHandler.onStartCommand(intent, i2, i3);
                    }
                }
            });
        }
        return DownloadComponentManager.notAutoRebootService() ? 2 : 3;
    }
}
