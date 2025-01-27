package com.ss.android.socialbase.appdownloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class b implements IDownloadLaunchHandler {

    /* renamed from: a */
    private List<Integer> f21816a;

    /* renamed from: b */
    private BroadcastReceiver f21817b;

    /* renamed from: com.ss.android.socialbase.appdownloader.d.b$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f21818a;

        /* renamed from: b */
        final /* synthetic */ int f21819b;

        public AnonymousClass1(List list, int i10) {
            list = list;
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a((List<DownloadInfo>) list, i10);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.d.b$2 */
    public class AnonymousClass2 extends BroadcastReceiver {

        /* renamed from: com.ss.android.socialbase.appdownloader.d.b$2$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Context f21822a;

            public AnonymousClass1(Context context) {
                applicationContext = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (b.this.f21816a != null && !b.this.f21816a.isEmpty()) {
                        int size = b.this.f21816a.size();
                        Integer[] numArr = new Integer[size];
                        b.this.f21816a.toArray(numArr);
                        b.this.f21816a.clear();
                        for (int i10 = 0; i10 < size; i10++) {
                            DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i10].intValue());
                            if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                b.this.a(applicationContext, downloadInfo, true, 2);
                            }
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Context applicationContext = context.getApplicationContext();
            if (DownloadUtils.isWifi(applicationContext)) {
                Logger.d("LaunchResume", "onReceive : wifi connected !!!");
                DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1

                    /* renamed from: a */
                    final /* synthetic */ Context f21822a;

                    public AnonymousClass1(Context applicationContext2) {
                        applicationContext = applicationContext2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (b.this.f21816a != null && !b.this.f21816a.isEmpty()) {
                                int size = b.this.f21816a.size();
                                Integer[] numArr = new Integer[size];
                                b.this.f21816a.toArray(numArr);
                                b.this.f21816a.clear();
                                for (int i10 = 0; i10 < size; i10++) {
                                    DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i10].intValue());
                                    if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                        b.this.a(applicationContext, downloadInfo, true, 2);
                                    }
                                }
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                });
                try {
                    applicationContext2.unregisterReceiver(b.this.f21817b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                b.this.f21817b = null;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler
    public List<String> getResumeMimeTypes() {
        return c.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler
    public void onLaunchResume(List<DownloadInfo> list, int i10) {
        if (DownloadUtils.isMainThread()) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.1

                /* renamed from: a */
                final /* synthetic */ List f21818a;

                /* renamed from: b */
                final /* synthetic */ int f21819b;

                public AnonymousClass1(List list2, int i102) {
                    list = list2;
                    i10 = i102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.a((List<DownloadInfo>) list, i10);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
        } else {
            a(list2, i102);
        }
    }

    public void a(List<DownloadInfo> list, int i10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g n10 = d.j().n();
        if (n10 != null) {
            n10.a(list);
        }
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null) {
            return;
        }
        boolean isWifi = DownloadUtils.isWifi(appContext);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            a(appContext, it.next(), isWifi, i10);
        }
        List<Integer> list2 = this.f21816a;
        if (list2 == null || list2.isEmpty() || this.f21817b != null) {
            return;
        }
        this.f21817b = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.b.2

            /* renamed from: com.ss.android.socialbase.appdownloader.d.b$2$1 */
            public class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Context f21822a;

                public AnonymousClass1(Context applicationContext2) {
                    applicationContext = applicationContext2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.f21816a != null && !b.this.f21816a.isEmpty()) {
                            int size = b.this.f21816a.size();
                            Integer[] numArr = new Integer[size];
                            b.this.f21816a.toArray(numArr);
                            b.this.f21816a.clear();
                            for (int i10 = 0; i10 < size; i10++) {
                                DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i10].intValue());
                                if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                    b.this.a(applicationContext, downloadInfo, true, 2);
                                }
                            }
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }

            public AnonymousClass2() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Context applicationContext2 = context.getApplicationContext();
                if (DownloadUtils.isWifi(applicationContext2)) {
                    Logger.d("LaunchResume", "onReceive : wifi connected !!!");
                    DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1

                        /* renamed from: a */
                        final /* synthetic */ Context f21822a;

                        public AnonymousClass1(Context applicationContext22) {
                            applicationContext = applicationContext22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (b.this.f21816a != null && !b.this.f21816a.isEmpty()) {
                                    int size = b.this.f21816a.size();
                                    Integer[] numArr = new Integer[size];
                                    b.this.f21816a.toArray(numArr);
                                    b.this.f21816a.clear();
                                    for (int i102 = 0; i102 < size; i102++) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i102].intValue());
                                        if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                            b.this.a(applicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                        }
                    });
                    try {
                        applicationContext22.unregisterReceiver(b.this.f21817b);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    b.this.f21817b = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            appContext.registerReceiver(this.f21817b, intentFilter);
        } catch (Throwable th2) {
            th2.printStackTrace();
            this.f21817b = null;
        }
    }

    public void a(Context context, DownloadInfo downloadInfo, boolean z10, int i10) {
        int i11;
        if (downloadInfo == null || !downloadInfo.isShowNotification()) {
            return;
        }
        int realStatus = downloadInfo.getRealStatus();
        boolean z11 = false;
        if (realStatus == -5 && ("application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) || !downloadInfo.isDownloaded())) {
            DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
            int optInt = obtain.optInt("failed_resume_max_count", 0);
            double optDouble = obtain.optDouble("failed_resume_max_hours", 72.0d);
            double optDouble2 = obtain.optDouble("failed_resume_min_hours", 12.0d);
            long currentTimeMillis = System.currentTimeMillis();
            boolean z12 = downloadInfo.getFailedResumeCount() < optInt && ((double) (currentTimeMillis - downloadInfo.getLastDownloadTime())) < optDouble * 3600000.0d && ((double) (currentTimeMillis - downloadInfo.getLastFailedResumeTime())) > optDouble2 * 3600000.0d;
            if (downloadInfo.isPauseReserveOnWifi() && z10) {
                z12 = true;
            }
            if (z12) {
                boolean z13 = obtain.optInt("failed_resume_need_wifi", 1) == 1;
                boolean z14 = obtain.optInt("failed_resume_need_wait_wifi", 0) == 1;
                if (!z10 && z13 && z14) {
                    if (this.f21816a == null) {
                        this.f21816a = new ArrayList();
                    }
                    int id2 = downloadInfo.getId();
                    if (!this.f21816a.contains(Integer.valueOf(id2))) {
                        this.f21816a.add(Integer.valueOf(id2));
                    }
                    downloadInfo.setOnlyWifi(true);
                    RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo);
                } else {
                    c.a(downloadInfo, true, z13);
                    downloadInfo.setLastFailedResumeTime(currentTimeMillis);
                    downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                    downloadInfo.updateSpData();
                    if (downloadInfo.isPauseReserveOnWifi() && z10) {
                        downloadInfo.setDownloadFromReserveWifi(true);
                        IReserveWifiStatusListener o10 = d.j().o();
                        if (o10 != null) {
                            o10.onStatusChanged(downloadInfo, 5, i10);
                        }
                    }
                    z11 = true;
                }
            }
            Logger.i("LaunchResume", "launchResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z12 + ", downloadResumed = " + z11);
            g n10 = d.j().n();
            if (n10 != null) {
                n10.a(downloadInfo, z11);
                return;
            }
            return;
        }
        if (realStatus != -3 || !a(downloadInfo)) {
            if (realStatus == -2) {
                if (!downloadInfo.isPauseReserveOnWifi()) {
                    a(downloadInfo, context);
                    return;
                }
                if (z10) {
                    c.a(downloadInfo, true, true);
                    downloadInfo.updateSpData();
                    downloadInfo.setDownloadFromReserveWifi(true);
                    g n11 = d.j().n();
                    if (n11 != null) {
                        n11.a(downloadInfo, true);
                    }
                    IReserveWifiStatusListener o11 = d.j().o();
                    if (o11 != null) {
                        o11.onStatusChanged(downloadInfo, 5, i10);
                        return;
                    }
                    return;
                }
                if (this.f21816a == null) {
                    this.f21816a = new ArrayList();
                }
                int id3 = downloadInfo.getId();
                if (!this.f21816a.contains(Integer.valueOf(id3))) {
                    this.f21816a.add(Integer.valueOf(id3));
                }
                RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo);
                a(downloadInfo, context);
                return;
            }
            return;
        }
        DownloadSetting obtain2 = DownloadSetting.obtain(downloadInfo.getId());
        if (c.a(context, downloadInfo)) {
            return;
        }
        int optInt2 = obtain2.optInt("uninstall_resume_max_count", 0);
        double optDouble3 = obtain2.optDouble("uninstall_resume_max_hours", 72.0d);
        double optDouble4 = obtain2.optDouble("uninstall_resume_min_hours", 12.0d);
        long currentTimeMillis2 = System.currentTimeMillis();
        boolean z15 = downloadInfo.getUninstallResumeCount() < optInt2 && ((double) (currentTimeMillis2 - downloadInfo.getLastDownloadTime())) < optDouble3 * 3600000.0d && ((double) (currentTimeMillis2 - downloadInfo.getLastUninstallResumeTime())) > optDouble4 * 3600000.0d;
        Logger.i("LaunchResume", "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z15);
        if (z15) {
            AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
            if (notificationItem == null) {
                i11 = 1;
                com.ss.android.socialbase.appdownloader.e.a aVar = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                DownloadNotificationManager.getInstance().addNotification(aVar);
                notificationItem = aVar;
            } else {
                i11 = 1;
                notificationItem.updateNotificationItem(downloadInfo);
            }
            notificationItem.setTotalBytes(downloadInfo.getTotalBytes());
            notificationItem.setCurBytes(downloadInfo.getTotalBytes());
            notificationItem.refreshStatus(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setLastUninstallResumeTime(currentTimeMillis2);
            downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + i11);
            downloadInfo.updateSpData();
        }
    }

    private void a(DownloadInfo downloadInfo, Context context) {
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
        int optInt = obtain.optInt("paused_resume_max_count", 0);
        double optDouble = obtain.optDouble("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount >= optInt || System.currentTimeMillis() - downloadInfo.getLastDownloadTime() >= optDouble * 3600000.0d) {
            return;
        }
        AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
        if (notificationItem == null) {
            notificationItem = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
            DownloadNotificationManager.getInstance().addNotification(notificationItem);
        } else {
            notificationItem.updateNotificationItem(downloadInfo);
        }
        notificationItem.setTotalBytes(downloadInfo.getTotalBytes());
        notificationItem.setCurBytes(downloadInfo.getCurBytes());
        notificationItem.refreshStatus(downloadInfo.getStatus(), null, false, false);
        downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
        downloadInfo.updateSpData();
    }

    private boolean a(DownloadInfo downloadInfo) {
        if (DownloadSetting.obtain(downloadInfo.getId()).optBugFix("uninstall_can_not_resume_for_force_task", false)) {
            return DownloadUtils.isFileDownloaded(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
