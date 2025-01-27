package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class IndependentProcessDownloadService extends DownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
        if (DownloadComponentManager.getIndependentHolderCreator() == null) {
            DownloadComponentManager.setIndependentServiceCreator(new MultiProcCreater());
        }
        IDownloadServiceHandler independentDownloadServiceHandler = DownloadComponentManager.getIndependentDownloadServiceHandler();
        this.downloadServiceHandler = independentDownloadServiceHandler;
        independentDownloadServiceHandler.setDownloadService(new WeakReference(this));
    }
}
