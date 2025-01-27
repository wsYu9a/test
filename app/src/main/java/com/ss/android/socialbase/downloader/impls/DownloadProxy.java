package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;

/* loaded from: classes4.dex */
public class DownloadProxy {
    private static volatile IDownloadProxy downloadIndependentProxy;
    private static volatile IDownloadProxy downloadProxy;

    public static IDownloadProxy get(boolean z10) {
        if (z10 && DownloadComponentManager.supportMultiProc()) {
            if (downloadIndependentProxy == null) {
                synchronized (DownloadProxy.class) {
                    try {
                        if (downloadIndependentProxy == null) {
                            downloadIndependentProxy = DownloadComponentManager.getIndependentHolderCreator().createProxy();
                        }
                    } finally {
                    }
                }
            }
            return downloadIndependentProxy;
        }
        if (downloadProxy == null) {
            synchronized (DownloadProxy.class) {
                try {
                    if (downloadProxy == null) {
                        downloadProxy = new ProcessDownloadHandler();
                    }
                } finally {
                }
            }
        }
        return downloadProxy;
    }
}
