package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
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
public class d {

    /* renamed from: a */
    private ExecutorService f21587a;

    /* renamed from: b */
    private ExecutorService f21588b;

    /* renamed from: c */
    private ScheduledExecutorService f21589c;

    /* renamed from: d */
    private ExecutorService f21590d;

    /* renamed from: com.ss.android.downloadlib.d$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IDownloadCache downloadCache;
            synchronized (d.class) {
                try {
                    String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", DownloadConstants.SP_ANTI_HIJACK_CONFIG, DownloadConstants.SP_DOWNLOAD_INFO, "sp_appdownloader"};
                    for (int i10 = 0; i10 < 13; i10++) {
                        SharedPreferences sharedPreferences = k.a().getSharedPreferences(strArr[i10], 0);
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
                            Downloader.getInstance(k.a()).clearDownloadData(downloadInfo.getId());
                        }
                    }
                }
            }
        }
    }

    public static class a {

        /* renamed from: a */
        private static d f21592a = new d();
    }

    public /* synthetic */ d(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static d a() {
        return a.f21592a;
    }

    public void b(Runnable runnable) {
        b(runnable, false);
    }

    public void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        e().execute(runnable);
    }

    public ScheduledExecutorService d() {
        if (this.f21589c == null) {
            synchronized (d.class) {
                try {
                    if (this.f21589c == null) {
                        this.f21589c = new ScheduledThreadPoolExecutor(0, new DefaultThreadFactory(i.class.getName() + "-ScheduledThreadPool"));
                    }
                } finally {
                }
            }
        }
        return this.f21589c;
    }

    public ExecutorService e() {
        if (this.f21590d == null) {
            synchronized (d.class) {
                try {
                    if (this.f21590d == null) {
                        this.f21590d = new ThreadPoolExecutor(5, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(i.class.getName() + "-InstallFinishCheckCPUThreadPool"));
                    }
                } finally {
                }
            }
        }
        return this.f21590d;
    }

    public void f() {
        a(new Runnable() { // from class: com.ss.android.downloadlib.d.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadCache downloadCache;
                synchronized (d.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", DownloadConstants.SP_ANTI_HIJACK_CONFIG, DownloadConstants.SP_DOWNLOAD_INFO, "sp_appdownloader"};
                        for (int i10 = 0; i10 < 13; i10++) {
                            SharedPreferences sharedPreferences = k.a().getSharedPreferences(strArr[i10], 0);
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
                                Downloader.getInstance(k.a()).clearDownloadData(downloadInfo.getId());
                            }
                        }
                    }
                }
            }
        });
    }

    private d() {
    }

    public void a(Runnable runnable) {
        a(runnable, false);
    }

    public void b(Runnable runnable, boolean z10) {
        if (runnable == null) {
            return;
        }
        if (!z10 || m.b()) {
            c().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public ExecutorService c() {
        if (this.f21588b == null) {
            synchronized (d.class) {
                try {
                    if (this.f21588b == null) {
                        this.f21588b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(i.class.getName() + "-IOThreadPool"));
                    }
                } finally {
                }
            }
        }
        return this.f21588b;
    }

    public void a(Runnable runnable, boolean z10) {
        if (runnable == null) {
            return;
        }
        if (z10 && !m.b()) {
            runnable.run();
        } else {
            b().execute(runnable);
        }
    }

    public ExecutorService b() {
        if (this.f21587a == null) {
            synchronized (d.class) {
                try {
                    if (this.f21587a == null) {
                        this.f21587a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(i.class.getName() + "-CPUThreadPool"));
                    }
                } finally {
                }
            }
        }
        return this.f21587a;
    }

    public void a(Runnable runnable, long j10) {
        try {
            d().schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
