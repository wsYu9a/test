package com.ss.android.socialbase.downloader.thread;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class DownloadThreadPool {
    private static ExecutorService executorService = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("Download_OP_Thread"));
    private int clearTimes = 0;
    private volatile SparseArray<DownloadRunnable> downloadRunnablePool = new SparseArray<>();

    private void clearRunnableNotAlive() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < this.downloadRunnablePool.size(); i10++) {
                int keyAt = this.downloadRunnablePool.keyAt(i10);
                if (!this.downloadRunnablePool.get(keyAt).isAlive()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                try {
                    Integer num = (Integer) arrayList.get(i11);
                    if (num != null) {
                        this.downloadRunnablePool.remove(num.intValue());
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static void executeOP(Runnable runnable) {
        executorService.execute(runnable);
    }

    private void removeFromThreadPool(DownloadRunnable downloadRunnable) {
        Future future;
        if (downloadRunnable == null) {
            return;
        }
        try {
            ExecutorService mixDefaultThreadExecutor = DownloadComponentManager.getMixDefaultThreadExecutor();
            DownloadTask downloadTask = downloadRunnable.getDownloadTask();
            if (downloadTask != null && downloadTask.getDownloadInfo() != null) {
                int executorGroup = downloadTask.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    mixDefaultThreadExecutor = DownloadComponentManager.getMixFrequentThreadExecutor();
                } else if (executorGroup == 4) {
                    mixDefaultThreadExecutor = DownloadComponentManager.getMixApkThreadExecutor();
                }
            }
            if (mixDefaultThreadExecutor == null || !(mixDefaultThreadExecutor instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) mixDefaultThreadExecutor).remove(downloadRunnable);
            if (!DownloadSetting.obtain(downloadRunnable.getDownloadId()).optBugFix(DownloadSettingKeys.BugFix.BUGFIX_PAUSE_WITH_INTERRUPT, false) || (future = downloadRunnable.getFuture()) == null) {
                return;
            }
            future.cancel(true);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public DownloadRunnable cancel(int i10) {
        synchronized (DownloadThreadPool.class) {
            try {
                clearRunnableNotAlive();
                DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(i10);
                if (downloadRunnable == null) {
                    return null;
                }
                downloadRunnable.cancel();
                removeFromThreadPool(downloadRunnable);
                this.downloadRunnablePool.remove(i10);
                return downloadRunnable;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean containsTask(int i10) {
        synchronized (DownloadThreadPool.class) {
            try {
                boolean z10 = false;
                if (this.downloadRunnablePool != null && this.downloadRunnablePool.size() > 0) {
                    DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(i10);
                    if (downloadRunnable != null && downloadRunnable.isAlive()) {
                        z10 = true;
                    }
                    return z10;
                }
                return false;
            } finally {
            }
        }
    }

    public void execute(DownloadRunnable downloadRunnable) {
        downloadRunnable.prepareDownload();
        synchronized (DownloadThreadPool.class) {
            try {
                int i10 = this.clearTimes;
                if (i10 >= 500) {
                    clearRunnableNotAlive();
                    this.clearTimes = 0;
                } else {
                    this.clearTimes = i10 + 1;
                }
                this.downloadRunnablePool.put(downloadRunnable.getDownloadId(), downloadRunnable);
            } finally {
            }
        }
        DownloadTask downloadTask = downloadRunnable.getDownloadTask();
        try {
            ExecutorService mixDefaultThreadExecutor = DownloadComponentManager.getMixDefaultThreadExecutor();
            if (downloadTask != null && downloadTask.getDownloadInfo() != null) {
                if (DownloadConstants.MIME_PLG.equals(downloadTask.getDownloadInfo().getMimeType()) && DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.DIVIDE_PLUGIN, 1) == 1) {
                    downloadTask.getDownloadInfo().safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_EXECUTOR, 3);
                }
                int executorGroup = downloadTask.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    mixDefaultThreadExecutor = DownloadComponentManager.getMixFrequentThreadExecutor();
                } else if (executorGroup == 4) {
                    mixDefaultThreadExecutor = DownloadComponentManager.getMixApkThreadExecutor();
                }
            }
            if (mixDefaultThreadExecutor == null) {
                DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            } else if (DownloadSetting.obtain(downloadRunnable.getDownloadId()).optBugFix(DownloadSettingKeys.BugFix.BUGFIX_PAUSE_WITH_INTERRUPT, false)) {
                downloadRunnable.setFuture(mixDefaultThreadExecutor.submit(downloadRunnable));
            } else {
                mixDefaultThreadExecutor.execute(downloadRunnable);
            }
        } catch (Exception e10) {
            if (downloadTask != null) {
                DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, DownloadUtils.getErrorMsgWithTagPrefix(e10, "DownloadThreadPoolExecute")), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
            e10.printStackTrace();
        } catch (OutOfMemoryError e11) {
            if (downloadTask != null) {
                DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "execute OOM"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
            e11.printStackTrace();
        }
    }

    public List<Integer> getAllAliveDownloadIds() {
        ArrayList arrayList;
        synchronized (DownloadThreadPool.class) {
            try {
                clearRunnableNotAlive();
                arrayList = new ArrayList();
                for (int i10 = 0; i10 < this.downloadRunnablePool.size(); i10++) {
                    DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(this.downloadRunnablePool.keyAt(i10));
                    if (downloadRunnable != null) {
                        arrayList.add(Integer.valueOf(downloadRunnable.getDownloadId()));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    public void pause(int i10) {
        synchronized (DownloadThreadPool.class) {
            try {
                clearRunnableNotAlive();
                DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(i10);
                if (downloadRunnable != null) {
                    downloadRunnable.pause();
                    removeFromThreadPool(downloadRunnable);
                    this.downloadRunnablePool.remove(i10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void removeUnAliveDownloadRunnable(DownloadRunnable downloadRunnable) {
        if (downloadRunnable == null) {
            return;
        }
        synchronized (DownloadThreadPool.class) {
            try {
                if (DownloadExpSwitchCode.isSwitchEnable(524288)) {
                    int indexOfValue = this.downloadRunnablePool.indexOfValue(downloadRunnable);
                    if (indexOfValue >= 0) {
                        this.downloadRunnablePool.removeAt(indexOfValue);
                    }
                } else {
                    this.downloadRunnablePool.remove(downloadRunnable.getDownloadId());
                }
            } finally {
            }
        }
    }

    public void setThrottleNetSpeed(int i10, long j10) {
        DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(i10);
        if (downloadRunnable != null) {
            downloadRunnable.setThrottleNetSpeed(j10);
        }
    }
}
