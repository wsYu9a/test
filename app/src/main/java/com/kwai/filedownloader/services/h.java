package com.kwai.filedownloader.services;

import android.util.SparseArray;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes2.dex */
final class h {
    private ThreadPoolExecutor aJh;
    private int aJj;
    private SparseArray<DownloadLaunchRunnable> aJg = new SparseArray<>();
    private final String aJi = "Network";
    private int aJk = 0;

    h(int i2) {
        this.aJh = com.kwai.filedownloader.e.b.n(i2, "Network");
        this.aJj = i2;
    }

    private synchronized void IU() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.aJg.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = this.aJg.keyAt(i2);
            DownloadLaunchRunnable downloadLaunchRunnable = this.aJg.get(keyAt);
            if (downloadLaunchRunnable.isAlive()) {
                sparseArray.put(keyAt, downloadLaunchRunnable);
            }
        }
        this.aJg = sparseArray;
    }

    public final synchronized int IV() {
        IU();
        return this.aJg.size();
    }

    public final synchronized List<Integer> IW() {
        ArrayList arrayList;
        IU();
        arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.aJg.size(); i2++) {
            SparseArray<DownloadLaunchRunnable> sparseArray = this.aJg;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i2)).getId()));
        }
        return arrayList;
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        int i2;
        downloadLaunchRunnable.HO();
        synchronized (this) {
            this.aJg.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.aJh.execute(downloadLaunchRunnable);
        int i3 = this.aJk;
        if (i3 >= 600) {
            IU();
            i2 = 0;
        } else {
            i2 = i3 + 1;
        }
        this.aJk = i2;
    }

    public final synchronized boolean cV(int i2) {
        if (IV() > 0) {
            com.kwai.filedownloader.e.d.h(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int dj = com.kwai.filedownloader.e.e.dj(i2);
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.aJj), Integer.valueOf(dj));
        }
        List<Runnable> shutdownNow = this.aJh.shutdownNow();
        this.aJh = com.kwai.filedownloader.e.b.n(dj, "Network");
        if (shutdownNow.size() > 0) {
            com.kwai.filedownloader.e.d.h(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.aJj = dj;
        return true;
    }

    public final void cancel(int i2) {
        IU();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.aJg.get(i2);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.pause();
                boolean remove = this.aJh.remove(downloadLaunchRunnable);
                if (com.kwai.filedownloader.e.d.aJq) {
                    com.kwai.filedownloader.e.d.g(this, "successful cancel %d %B", Integer.valueOf(i2), Boolean.valueOf(remove));
                }
            }
            this.aJg.remove(i2);
        }
    }

    public final boolean di(int i2) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.aJg.get(i2);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive();
    }

    public final int r(String str, int i2) {
        if (str == null) {
            return 0;
        }
        int size = this.aJg.size();
        for (int i3 = 0; i3 < size; i3++) {
            DownloadLaunchRunnable valueAt = this.aJg.valueAt(i3);
            if (valueAt != null && valueAt.isAlive() && valueAt.getId() != i2 && str.equals(valueAt.HT())) {
                return valueAt.getId();
            }
        }
        return 0;
    }
}
