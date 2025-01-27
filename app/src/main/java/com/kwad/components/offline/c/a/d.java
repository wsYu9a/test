package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener;
import com.kwad.components.offline.api.tk.IOfflineApkLoader;
import com.kwad.sdk.components.j;

/* loaded from: classes3.dex */
public final class d implements IOfflineApkLoader {
    j agv;

    /* renamed from: com.kwad.components.offline.c.a.d$1 */
    public class AnonymousClass1 implements com.kwad.sdk.components.i {
        final /* synthetic */ IOfflineApkLoadStatusListener agw;

        public AnonymousClass1(IOfflineApkLoadStatusListener iOfflineApkLoadStatusListener) {
            iOfflineApkLoadStatusListener = iOfflineApkLoadStatusListener;
        }

        @Override // com.kwad.sdk.components.i
        public final void onDownloadFailed() {
            iOfflineApkLoadStatusListener.onDownloadFailed();
        }

        @Override // com.kwad.sdk.components.i
        public final void onDownloadFinished() {
            iOfflineApkLoadStatusListener.onDownloadFinished();
        }

        @Override // com.kwad.sdk.components.i
        public final void onDownloadStarted() {
            iOfflineApkLoadStatusListener.onDownloadStarted();
        }

        @Override // com.kwad.sdk.components.i
        public final void onIdle() {
            iOfflineApkLoadStatusListener.onIdle();
        }

        @Override // com.kwad.sdk.components.i
        public final void onInstalled() {
            iOfflineApkLoadStatusListener.onInstalled();
        }

        @Override // com.kwad.sdk.components.i
        public final void onPaused(int i10, long j10, long j11) {
            iOfflineApkLoadStatusListener.onPaused(i10, j10, j11);
        }

        @Override // com.kwad.sdk.components.i
        public final void onProgressUpdate(int i10, long j10, long j11) {
            iOfflineApkLoadStatusListener.onProgressUpdate(i10, j10, j11);
        }
    }

    public d(j jVar) {
        this.agv = jVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void addLoadStatusListener(IOfflineApkLoadStatusListener iOfflineApkLoadStatusListener) {
        this.agv.a(new com.kwad.sdk.components.i() { // from class: com.kwad.components.offline.c.a.d.1
            final /* synthetic */ IOfflineApkLoadStatusListener agw;

            public AnonymousClass1(IOfflineApkLoadStatusListener iOfflineApkLoadStatusListener2) {
                iOfflineApkLoadStatusListener = iOfflineApkLoadStatusListener2;
            }

            @Override // com.kwad.sdk.components.i
            public final void onDownloadFailed() {
                iOfflineApkLoadStatusListener.onDownloadFailed();
            }

            @Override // com.kwad.sdk.components.i
            public final void onDownloadFinished() {
                iOfflineApkLoadStatusListener.onDownloadFinished();
            }

            @Override // com.kwad.sdk.components.i
            public final void onDownloadStarted() {
                iOfflineApkLoadStatusListener.onDownloadStarted();
            }

            @Override // com.kwad.sdk.components.i
            public final void onIdle() {
                iOfflineApkLoadStatusListener.onIdle();
            }

            @Override // com.kwad.sdk.components.i
            public final void onInstalled() {
                iOfflineApkLoadStatusListener.onInstalled();
            }

            @Override // com.kwad.sdk.components.i
            public final void onPaused(int i10, long j10, long j11) {
                iOfflineApkLoadStatusListener.onPaused(i10, j10, j11);
            }

            @Override // com.kwad.sdk.components.i
            public final void onProgressUpdate(int i10, long j10, long j11) {
                iOfflineApkLoadStatusListener.onProgressUpdate(i10, j10, j11);
            }
        });
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void cancelDownload() {
        this.agv.cancelDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void clearFileCache() {
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void installApp() {
        this.agv.installApp();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void openApp() {
        this.agv.openApp();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void pauseDownload() {
        this.agv.pauseDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void resumeDownload() {
        this.agv.resumeDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void setCustomReportParam(String str) {
        this.agv.setCustomReportParam(str);
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void startDownload() {
        this.agv.startDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void stopDownload() {
        this.agv.stopDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void uninstallApp() {
    }
}
