package com.vivo.ic.dm;

import com.vivo.ic.VLog;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.dm.impl.DownloadLifeListener;
import com.vivo.ic.dm.network.IHttpDownload;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
class f {

    /* renamed from: a */
    public static final f f28457a = new f();

    /* renamed from: b */
    private static final String f28458b = Constants.PRE_TAG + "DownloadEventManager";

    /* renamed from: c */
    private CopyOnWriteArrayList<DownloadLifeListener> f28459c = new CopyOnWriteArrayList<>();

    /* renamed from: d */
    private long f28460d;

    /* renamed from: e */
    private long f28461e;

    private f() {
    }

    public static f b() {
        return f28457a;
    }

    public void a(DownloadLifeListener downloadLifeListener) {
        if (this.f28459c.contains(downloadLifeListener)) {
            return;
        }
        this.f28459c.add(downloadLifeListener);
    }

    void c(DownloadInfo downloadInfo) throws StopRequestException {
        Iterator<DownloadLifeListener> it = this.f28459c.iterator();
        while (it.hasNext()) {
            DownloadLifeListener next = it.next();
            VLog.i(f28458b, "dispatchBeforeRequest url");
            next.onBeforeRequest(downloadInfo);
        }
    }

    public void d(DownloadInfo downloadInfo) {
        long currentBytes = downloadInfo.getCurrentBytes();
        long currentTimeMillis = System.currentTimeMillis();
        int status = downloadInfo.getStatus();
        com.vivo.ic.dm.datareport.a.a().a(downloadInfo, this.f28460d, currentBytes, this.f28461e, currentTimeMillis, status);
        if (Downloads.Impl.isStatusSuccess(status)) {
            d(downloadInfo, status);
            return;
        }
        if (Downloads.Impl.isCancle(status)) {
            VLog.i(f28458b, "cancle : " + downloadInfo.getId());
            return;
        }
        if (Downloads.Impl.isStatusError(status)) {
            a(downloadInfo, status);
        } else if (Downloads.Impl.isStatusPause(status)) {
            b(downloadInfo, status);
        } else {
            c(downloadInfo, status);
        }
    }

    public void b(DownloadLifeListener downloadLifeListener) {
        this.f28459c.remove(downloadLifeListener);
    }

    public void a() {
        this.f28459c.clear();
    }

    void b(DownloadInfo downloadInfo) throws StopRequestException {
        this.f28460d = downloadInfo.getCurrentBytes();
        this.f28461e = System.currentTimeMillis();
        Iterator<DownloadLifeListener> it = this.f28459c.iterator();
        while (it.hasNext()) {
            DownloadLifeListener next = it.next();
            VLog.i(f28458b, "dispatchBeforeDownload ");
            next.onBeforeDownload(downloadInfo);
        }
    }

    private void c(DownloadInfo downloadInfo, int i2) {
        Iterator<DownloadLifeListener> it = this.f28459c.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDownloadStatusChanged(downloadInfo, i2);
            } catch (Throwable th) {
                VLog.w(f28458b, "onDownloadStatusChanged error " + th, th);
            }
        }
    }

    void a(DownloadInfo downloadInfo) throws StopRequestException {
        Iterator<DownloadLifeListener> it = this.f28459c.iterator();
        while (it.hasNext()) {
            DownloadLifeListener next = it.next();
            VLog.i(f28458b, "dispatchAfterRequest url");
            next.onAfterRequest(downloadInfo);
        }
    }

    void a(DownloadInfo downloadInfo, IHttpDownload iHttpDownload) throws StopRequestException {
        Iterator<DownloadLifeListener> it = this.f28459c.iterator();
        while (it.hasNext()) {
            it.next().onRequestFailed(downloadInfo, iHttpDownload);
        }
    }

    void b(long[] jArr) {
        Iterator<DownloadLifeListener> it = this.f28459c.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDownloadStartByNetChange(jArr);
            } catch (Throwable th) {
                VLog.w(f28458b, "onDownloadStartByNetChange error " + th, th);
            }
        }
    }

    void a(DownloadInfo downloadInfo, long j2, long j3, long j4) {
        int status = downloadInfo.getStatus();
        if (!Downloads.Impl.isStatusPause(status) && !Downloads.Impl.isCancle(status)) {
            Iterator<DownloadLifeListener> it = this.f28459c.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onDownloadSizeChange(downloadInfo, j2, j3, j4);
                } catch (Throwable th) {
                    VLog.w(f28458b, " error " + th, th);
                }
            }
            return;
        }
        VLog.i(f28458b, "dispatchDownloadSize ignore by status " + status);
    }

    private void b(DownloadInfo downloadInfo, int i2) {
        com.vivo.ic.dm.datareport.a.a().a(downloadInfo, this.f28460d, downloadInfo.getCurrentBytes(), this.f28461e, System.currentTimeMillis(), downloadInfo, i2);
        Iterator<DownloadLifeListener> it = this.f28459c.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDownloadPaused(downloadInfo, i2);
            } catch (Throwable th) {
                VLog.w(f28458b, "onDownloadPaused error " + th, th);
            }
        }
    }

    private void d(DownloadInfo downloadInfo, int i2) {
        com.vivo.ic.dm.datareport.a.a().b(downloadInfo, i2);
        Iterator<DownloadLifeListener> it = this.f28459c.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDownloadSucceed(downloadInfo, i2);
            } catch (Throwable th) {
                VLog.w(f28458b, "onDownloadSucceed error " + th, th);
            }
        }
    }

    void a(long[] jArr) {
        Iterator<DownloadLifeListener> it = this.f28459c.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDownloadPausedByNetChange(jArr);
            } catch (Throwable th) {
                VLog.w(f28458b, "onDownloadPausedByNetChange error " + th, th);
            }
        }
    }

    private void a(DownloadInfo downloadInfo, int i2) {
        com.vivo.ic.dm.datareport.a.a().a(downloadInfo, i2);
        Iterator<DownloadLifeListener> it = this.f28459c.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDownloadFailed(downloadInfo, i2);
            } catch (Throwable th) {
                VLog.w(f28458b, "onDownloadFailed error " + th, th);
            }
        }
    }
}
