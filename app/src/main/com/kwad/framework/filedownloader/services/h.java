package com.kwad.framework.filedownloader.services;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes3.dex */
final class h {
    private ThreadPoolExecutor alk;
    private int alm;
    private SparseArray<DownloadLaunchRunnable> alj = new SparseArray<>();
    private final String all = "Network";
    private int aln = 0;

    public h(int i10) {
        this.alk = com.kwad.framework.filedownloader.f.b.r(i10, "Network");
        this.alm = i10;
    }

    private synchronized void xN() {
        try {
            SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
            int size = this.alj.size();
            for (int i10 = 0; i10 < size; i10++) {
                int keyAt = this.alj.keyAt(i10);
                DownloadLaunchRunnable downloadLaunchRunnable = this.alj.get(keyAt);
                if (downloadLaunchRunnable.isAlive()) {
                    sparseArray.put(keyAt, downloadLaunchRunnable);
                }
            }
            this.alj = sparseArray;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.wG();
        synchronized (this) {
            this.alj.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.alk.execute(downloadLaunchRunnable);
        int i10 = this.aln;
        if (i10 < 600) {
            this.aln = i10 + 1;
        } else {
            xN();
            this.aln = 0;
        }
    }

    public final boolean bL(int i10) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.alj.get(i10);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive();
    }

    public final synchronized boolean by(int i10) {
        if (xO() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int bM = com.kwad.framework.filedownloader.f.e.bM(i10);
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.alm), Integer.valueOf(bM));
        }
        List<Runnable> shutdownNow = this.alk.shutdownNow();
        this.alk = com.kwad.framework.filedownloader.f.b.r(bM, "Network");
        if (shutdownNow.size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.alm = bM;
        return true;
    }

    public final void cancel(int i10) {
        xN();
        synchronized (this) {
            try {
                DownloadLaunchRunnable downloadLaunchRunnable = this.alj.get(i10);
                if (downloadLaunchRunnable != null) {
                    downloadLaunchRunnable.pause();
                    boolean remove = this.alk.remove(downloadLaunchRunnable);
                    if (com.kwad.framework.filedownloader.f.d.alt) {
                        com.kwad.framework.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i10), Boolean.valueOf(remove));
                    }
                }
                this.alj.remove(i10);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final int o(String str, int i10) {
        if (str == null) {
            return 0;
        }
        int size = this.alj.size();
        for (int i11 = 0; i11 < size; i11++) {
            DownloadLaunchRunnable valueAt = this.alj.valueAt(i11);
            if (valueAt != null && valueAt.isAlive() && valueAt.getId() != i10 && str.equals(valueAt.wL())) {
                return valueAt.getId();
            }
        }
        return 0;
    }

    public final synchronized int xO() {
        xN();
        return this.alj.size();
    }

    public final synchronized List<Integer> xP() {
        ArrayList arrayList;
        xN();
        arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.alj.size(); i10++) {
            SparseArray<DownloadLaunchRunnable> sparseArray = this.alj;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i10)).getId()));
        }
        return arrayList;
    }
}
