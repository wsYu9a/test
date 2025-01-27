package com.ss.android.socialbase.appdownloader.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.appdownloader.i.lg;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class zx implements IDownloadLaunchHandler {

    /* renamed from: j */
    private List<Integer> f24428j;
    private BroadcastReceiver zx;

    /* renamed from: com.ss.android.socialbase.appdownloader.g.zx$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ List f24430j;
        final /* synthetic */ int zx;

        AnonymousClass1(List list, int i2) {
            list = list;
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zx.this.j((List<DownloadInfo>) list, i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.g.zx$2 */
    class AnonymousClass2 extends BroadcastReceiver {

        /* renamed from: com.ss.android.socialbase.appdownloader.g.zx$2$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: j */
            final /* synthetic */ Context f24432j;

            AnonymousClass1(Context context) {
                applicationContext = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (zx.this.f24428j != null && !zx.this.f24428j.isEmpty()) {
                        int size = zx.this.f24428j.size();
                        Integer[] numArr = new Integer[size];
                        zx.this.f24428j.toArray(numArr);
                        zx.this.f24428j.clear();
                        for (int i2 = 0; i2 < size; i2++) {
                            DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                            if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                zx.this.j(applicationContext, downloadInfo, true, 2);
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Context applicationContext = context.getApplicationContext();
            if (DownloadUtils.isWifi(applicationContext)) {
                Logger.d("LaunchResume", "onReceive : wifi connected !!!");
                DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.g.zx.2.1

                    /* renamed from: j */
                    final /* synthetic */ Context f24432j;

                    AnonymousClass1(Context applicationContext2) {
                        applicationContext = applicationContext2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (zx.this.f24428j != null && !zx.this.f24428j.isEmpty()) {
                                int size = zx.this.f24428j.size();
                                Integer[] numArr = new Integer[size];
                                zx.this.f24428j.toArray(numArr);
                                zx.this.f24428j.clear();
                                for (int i2 = 0; i2 < size; i2++) {
                                    DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                                    if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                        zx.this.j(applicationContext, downloadInfo, true, 2);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
                try {
                    applicationContext2.unregisterReceiver(zx.this.zx);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                zx.this.zx = null;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler
    public List<String> getResumeMimeTypes() {
        return i.i();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler
    public void onLaunchResume(List<DownloadInfo> list, int i2) {
        if (DownloadUtils.isMainThread()) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.g.zx.1

                /* renamed from: j */
                final /* synthetic */ List f24430j;
                final /* synthetic */ int zx;

                AnonymousClass1(List list2, int i22) {
                    list = list2;
                    i2 = i22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zx.this.j((List<DownloadInfo>) list, i2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else {
            j(list2, i22);
        }
    }

    public void j(List<DownloadInfo> list, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        lg nt = g.pa().nt();
        if (nt != null) {
            nt.j(list);
        }
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null) {
            return;
        }
        boolean isWifi = DownloadUtils.isWifi(appContext);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            j(appContext, it.next(), isWifi, i2);
        }
        List<Integer> list2 = this.f24428j;
        if (list2 == null || list2.isEmpty() || this.zx != null) {
            return;
        }
        this.zx = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.g.zx.2

            /* renamed from: com.ss.android.socialbase.appdownloader.g.zx$2$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: j */
                final /* synthetic */ Context f24432j;

                AnonymousClass1(Context applicationContext2) {
                    applicationContext = applicationContext2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (zx.this.f24428j != null && !zx.this.f24428j.isEmpty()) {
                            int size = zx.this.f24428j.size();
                            Integer[] numArr = new Integer[size];
                            zx.this.f24428j.toArray(numArr);
                            zx.this.f24428j.clear();
                            for (int i2 = 0; i2 < size; i2++) {
                                DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                                if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                    zx.this.j(applicationContext, downloadInfo, true, 2);
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }

            AnonymousClass2() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Context applicationContext2 = context.getApplicationContext();
                if (DownloadUtils.isWifi(applicationContext2)) {
                    Logger.d("LaunchResume", "onReceive : wifi connected !!!");
                    DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.g.zx.2.1

                        /* renamed from: j */
                        final /* synthetic */ Context f24432j;

                        AnonymousClass1(Context applicationContext22) {
                            applicationContext = applicationContext22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (zx.this.f24428j != null && !zx.this.f24428j.isEmpty()) {
                                    int size = zx.this.f24428j.size();
                                    Integer[] numArr = new Integer[size];
                                    zx.this.f24428j.toArray(numArr);
                                    zx.this.f24428j.clear();
                                    for (int i22 = 0; i22 < size; i22++) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i22].intValue());
                                        if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                            zx.this.j(applicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                    try {
                        applicationContext22.unregisterReceiver(zx.this.zx);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    zx.this.zx = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            appContext.registerReceiver(this.zx, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.zx = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(android.content.Context r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22, boolean r23, int r24) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.g.zx.j(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, boolean, int):void");
    }

    private void j(DownloadInfo downloadInfo, Context context) {
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
        int optInt = obtain.optInt("paused_resume_max_count", 0);
        double optDouble = obtain.optDouble("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < optInt && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < optDouble * 3600000.0d) {
            AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
            if (notificationItem == null) {
                notificationItem = new com.ss.android.socialbase.appdownloader.q.j(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
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
    }

    private boolean j(DownloadInfo downloadInfo) {
        if (DownloadSetting.obtain(downloadInfo.getId()).optBugFix("uninstall_can_not_resume_for_force_task", false)) {
            return DownloadUtils.isFileDownloaded(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
