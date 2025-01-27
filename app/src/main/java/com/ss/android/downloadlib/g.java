package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: i */
    private ScheduledExecutorService f24245i;

    /* renamed from: j */
    private ExecutorService f24246j;
    private ExecutorService zx;

    /* renamed from: com.ss.android.downloadlib.g$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IDownloadCache downloadCache;
            synchronized (g.class) {
                try {
                    String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", DownloadConstants.SP_ANTI_HIJACK_CONFIG, DownloadConstants.SP_DOWNLOAD_INFO, "sp_appdownloader"};
                    for (int i2 = 0; i2 < 13; i2++) {
                        SharedPreferences sharedPreferences = pa.getContext().getSharedPreferences(strArr[i2], 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().clear().apply();
                        }
                    }
                    downloadCache = DownloadComponentManager.getDownloadCache();
                } catch (Throwable unused) {
                }
                if (downloadCache instanceof DefaultDownloadCache) {
                    SparseArray<DownloadInfo> downloadInfoMap = ((DefaultDownloadCache) downloadCache).getDownloadCache().getDownloadInfoMap();
                    for (int size = downloadInfoMap.size() - 1; size >= 0; size--) {
                        DownloadInfo downloadInfo = downloadInfoMap.get(downloadInfoMap.keyAt(size));
                        if (downloadInfo != null) {
                            Downloader.getInstance(pa.getContext()).clearDownloadData(downloadInfo.getId());
                        }
                    }
                }
            }
        }
    }

    private static class j {

        /* renamed from: j */
        private static g f24249j = new g();
    }

    /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static g j() {
        return j.f24249j;
    }

    public ScheduledExecutorService g() {
        if (this.f24245i == null) {
            synchronized (g.class) {
                if (this.f24245i == null) {
                    this.f24245i = new ScheduledThreadPoolExecutor(0, new DefaultThreadFactory(y.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.f24245i;
    }

    public ExecutorService i() {
        if (this.zx == null) {
            synchronized (g.class) {
                if (this.zx == null) {
                    this.zx = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(y.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.zx;
    }

    public void q() {
        j(new Runnable() { // from class: com.ss.android.downloadlib.g.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadCache downloadCache;
                synchronized (g.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", DownloadConstants.SP_ANTI_HIJACK_CONFIG, DownloadConstants.SP_DOWNLOAD_INFO, "sp_appdownloader"};
                        for (int i2 = 0; i2 < 13; i2++) {
                            SharedPreferences sharedPreferences = pa.getContext().getSharedPreferences(strArr[i2], 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        downloadCache = DownloadComponentManager.getDownloadCache();
                    } catch (Throwable unused) {
                    }
                    if (downloadCache instanceof DefaultDownloadCache) {
                        SparseArray<DownloadInfo> downloadInfoMap = ((DefaultDownloadCache) downloadCache).getDownloadCache().getDownloadInfoMap();
                        for (int size = downloadInfoMap.size() - 1; size >= 0; size--) {
                            DownloadInfo downloadInfo = downloadInfoMap.get(downloadInfoMap.keyAt(size));
                            if (downloadInfo != null) {
                                Downloader.getInstance(pa.getContext()).clearDownloadData(downloadInfo.getId());
                            }
                        }
                    }
                }
            }
        });
    }

    public void zx(Runnable runnable) {
        zx(runnable, false);
    }

    private g() {
    }

    public void j(Runnable runnable) {
        j(runnable, false);
    }

    public void zx(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || nt.j()) {
            i().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public void j(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !nt.j()) {
            runnable.run();
        } else {
            zx().execute(runnable);
        }
    }

    public ExecutorService zx() {
        if (this.f24246j == null) {
            synchronized (g.class) {
                if (this.f24246j == null) {
                    this.f24246j = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(y.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.f24246j;
    }

    public void j(Runnable runnable, long j2) {
        try {
            g().schedule(runnable, j2, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
