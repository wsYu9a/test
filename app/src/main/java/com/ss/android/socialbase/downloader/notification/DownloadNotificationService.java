package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.NotificationConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.ThreadWithHandler;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class DownloadNotificationService extends Service {
    private static boolean sBugfixNotifyTooFast;
    private static volatile long sLastImportantNotifyTimestamp;
    private static volatile long sLastNotifyTimestamp;
    private ThreadWithHandler mNotifyThreadHandler;
    private final SparseArray<Notification> pendingImportantNotify = new SparseArray<>(2);
    private static final String TAG = DownloadNotificationService.class.getSimpleName();
    private static int sForegroundId = -1;
    private static int sIndependentProcessForegroundId = -1;
    private static boolean sAllowStartForeground = true;
    private static boolean sBugFixNonOngoing = false;
    private static final long NOTIFY_TIME_WINDOW = 900;
    private static long sNotifyTimeWindow = NOTIFY_TIME_WINDOW;

    /* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$action;
        final /* synthetic */ Intent val$intent;

        /* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService$1$1 */
        class RunnableC05131 implements Runnable {
            final /* synthetic */ Notification val$notification;
            final /* synthetic */ int val$notificationId;
            final /* synthetic */ NotificationManager val$notificationManager;

            RunnableC05131(NotificationManager notificationManager, int i2, Notification notification) {
                notificationManager = notificationManager;
                intExtra = i2;
                notification = notification;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
            }
        }

        AnonymousClass1(Intent intent, String str) {
            intent = intent;
            action = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConnectivityManager connectivityManager;
            NetworkInfo activeNetworkInfo;
            NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
            int intExtra = intent.getIntExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, 0);
            if (!action.equals(NotificationConstants.ACTION_NOTIFICATION_NOTIFY)) {
                if (action.equals(NotificationConstants.ACTION_NOTIFICATION_CANCEL)) {
                    if (intExtra != 0) {
                        DownloadNotificationService.this.doCancel(notificationManager, intExtra);
                        return;
                    }
                    return;
                }
                if (!action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                        try {
                            Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                try {
                    if (DownloadUtils.checkPermission(DownloadNotificationService.this, g.f9317b) && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                        ArrayList arrayList = new ArrayList();
                        if (!TextUtils.isEmpty(DownloadConstants.MIME_APK)) {
                            arrayList.add(DownloadConstants.MIME_APK);
                        }
                        arrayList.add(DownloadConstants.MIME_PLG);
                        Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                        if (applicationContext != null) {
                            Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                            Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            Notification notification = (Notification) intent.getParcelableExtra(NotificationConstants.EXTRA_NOTIFICATION);
            int intExtra2 = intent.getIntExtra(NotificationConstants.EXTRA_NOTIFICATION_STATUS, 0);
            if (intExtra == 0 || notification == null || notificationManager == null) {
                return;
            }
            if (intExtra2 != 4) {
                if (intExtra2 != -2 && intExtra2 != -3) {
                    if (DownloadNotificationService.sBugfixNotifyTooFast) {
                        DownloadNotificationService.this.doImportantNotify(notificationManager, intExtra, notification);
                        return;
                    } else {
                        DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
                        return;
                    }
                }
                if (DownloadNotificationService.sBugfixNotifyTooFast) {
                    DownloadNotificationService.this.doImportantNotify(notificationManager, intExtra, notification);
                    return;
                } else {
                    if (DownloadNotificationService.this.mNotifyThreadHandler != null) {
                        DownloadNotificationService.this.mNotifyThreadHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                            final /* synthetic */ Notification val$notification;
                            final /* synthetic */ int val$notificationId;
                            final /* synthetic */ NotificationManager val$notificationManager;

                            RunnableC05131(NotificationManager notificationManager2, int intExtra3, Notification notification2) {
                                notificationManager = notificationManager2;
                                intExtra = intExtra3;
                                notification = notification2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
                            }
                        }, intExtra2 == -2 ? 50L : 200L);
                        return;
                    }
                    return;
                }
            }
            if (Downloader.getInstance(DownloadComponentManager.getAppContext()).isDownloading(intExtra3)) {
                DownloadInfo downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(intExtra3);
                if (!DownloadNotificationService.sBugfixNotifyTooFast) {
                    if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                        return;
                    }
                    DownloadNotificationService.this.doNotify(notificationManager2, intExtra3, notification2);
                    downloadInfo.setLastNotifyProgressTime();
                    return;
                }
                if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.sLastImportantNotifyTimestamp <= DownloadNotificationService.sNotifyTimeWindow) {
                    return;
                }
                DownloadNotificationService.this.doNotify(notificationManager2, intExtra3, notification2);
                downloadInfo.setLastNotifyProgressTime();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int val$notificationId;
        final /* synthetic */ NotificationManager val$notificationManager;

        AnonymousClass2(NotificationManager notificationManager, int i2) {
            notificationManager = notificationManager;
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadNotificationService.this.performImportantNotify(notificationManager, i2);
        }
    }

    private void createNotifyHandlerThread() {
        if (this.mNotifyThreadHandler == null) {
            ThreadWithHandler threadWithHandler = new ThreadWithHandler("DownloaderNotifyThread");
            this.mNotifyThreadHandler = threadWithHandler;
            threadWithHandler.start();
        }
    }

    public void doCancel(NotificationManager notificationManager, int i2) {
        boolean z;
        AbsNotificationItem absNotificationItem;
        int id;
        int i3 = sForegroundId;
        if (i3 != i2 && sIndependentProcessForegroundId != i2) {
            try {
                notificationManager.cancel(i2);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z2 = true;
        if (i3 == i2) {
            sForegroundId = 0;
            z = false;
        } else {
            sIndependentProcessForegroundId = 0;
            z = true;
        }
        try {
            IDownloadProxy downloadHandler = DownloadProcessDispatcher.getInstance().getDownloadHandler(i2);
            if (!downloadHandler.isServiceForeground()) {
                sAllowStartForeground = false;
                Logger.w(TAG, "try to stopForeground when is not Foreground, id = " + i2 + ", isIndependentProcess = " + z);
            }
            Logger.i(TAG, "doCancel, ========== stopForeground id = " + i2 + ", isIndependentProcess = " + z);
            downloadHandler.stopForeground(false, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            notificationManager.cancel(i2);
        } catch (Throwable unused2) {
        }
        if (sAllowStartForeground) {
            try {
                SparseArray<AbsNotificationItem> allNotificationItems = DownloadNotificationManager.getInstance().getAllNotificationItems();
                if (allNotificationItems != null) {
                    for (int size = allNotificationItems.size() - 1; size >= 0; size--) {
                        absNotificationItem = allNotificationItems.valueAt(size);
                        if (absNotificationItem != null && (id = absNotificationItem.getId()) != i2 && id != sForegroundId && id != sIndependentProcessForegroundId && absNotificationItem.isOngoing()) {
                            if ((DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(absNotificationItem.getId()) == 1 && !DownloadUtils.isDownloaderProcess()) == z) {
                                break;
                            }
                        }
                    }
                }
                absNotificationItem = null;
                if (absNotificationItem != null) {
                    int id2 = absNotificationItem.getId();
                    try {
                        notificationManager.cancel(id2);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    if (Downloader.getInstance(this).getStatus(id2) != 1) {
                        z2 = false;
                    }
                    Logger.i(TAG, "doCancel, updateNotification id = " + id2);
                    absNotificationItem.updateNotification(null, z2);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    public void doImportantNotify(NotificationManager notificationManager, int i2, Notification notification) {
        synchronized (this.pendingImportantNotify) {
            int indexOfKey = this.pendingImportantNotify.indexOfKey(i2);
            if (indexOfKey >= 0 && indexOfKey < this.pendingImportantNotify.size()) {
                this.pendingImportantNotify.setValueAt(indexOfKey, notification);
                return;
            }
            long currentTimeMillis = sNotifyTimeWindow - (System.currentTimeMillis() - sLastNotifyTimestamp);
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 0;
            }
            if (currentTimeMillis > 20000) {
                currentTimeMillis = 20000;
            }
            long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
            sLastImportantNotifyTimestamp = currentTimeMillis2;
            sLastNotifyTimestamp = currentTimeMillis2;
            if (currentTimeMillis <= 0) {
                doNotify(notificationManager, i2, notification);
            } else if (this.mNotifyThreadHandler != null) {
                synchronized (this.pendingImportantNotify) {
                    this.pendingImportantNotify.put(i2, notification);
                }
                this.mNotifyThreadHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                    final /* synthetic */ int val$notificationId;
                    final /* synthetic */ NotificationManager val$notificationManager;

                    AnonymousClass2(NotificationManager notificationManager2, int i22) {
                        notificationManager = notificationManager2;
                        i2 = i22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.performImportantNotify(notificationManager, i2);
                    }
                }, currentTimeMillis);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x001f, code lost:
    
        if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sForegroundId == 0) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doNotify(android.app.NotificationManager r6, int r7, android.app.Notification r8) {
        /*
            r5 = this;
            boolean r0 = r5.needStartForeground(r7, r8)
            if (r0 == 0) goto L85
            com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher r0 = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance()     // Catch: java.lang.Throwable -> L80
            int r0 = r0.getDownloadWithIndependentProcessStatus(r7)     // Catch: java.lang.Throwable -> L80
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L1a
            boolean r0 = com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess()     // Catch: java.lang.Throwable -> L80
            if (r0 != 0) goto L1a
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            if (r0 != 0) goto L23
            int r3 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sForegroundId     // Catch: java.lang.Throwable -> L80
            if (r3 != 0) goto L23
        L21:
            r1 = 1
            goto L2a
        L23:
            if (r0 == 0) goto L2a
            int r3 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sIndependentProcessForegroundId     // Catch: java.lang.Throwable -> L80
            if (r3 != 0) goto L2a
            goto L21
        L2a:
            if (r1 == 0) goto L9a
            com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher r1 = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance()     // Catch: java.lang.Throwable -> L80
            com.ss.android.socialbase.downloader.downloader.IDownloadProxy r1 = r1.getDownloadHandler(r7)     // Catch: java.lang.Throwable -> L80
            boolean r2 = r1.isServiceAlive()     // Catch: java.lang.Throwable -> L80
            if (r2 == 0) goto L69
            boolean r2 = r1.isServiceForeground()     // Catch: java.lang.Throwable -> L80
            if (r2 != 0) goto L69
            java.lang.String r2 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.TAG     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r3.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "doNotify, startForeground, ======== id = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L80
            r3.append(r7)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = ", isIndependentProcess = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L80
            r3.append(r0)     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L80
            com.ss.android.socialbase.downloader.logger.Logger.i(r2, r3)     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L63
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sIndependentProcessForegroundId = r7     // Catch: java.lang.Throwable -> L80
            goto L65
        L63:
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sForegroundId = r7     // Catch: java.lang.Throwable -> L80
        L65:
            r1.startForeground(r7, r8)     // Catch: java.lang.Throwable -> L80
            goto L9a
        L69:
            java.lang.String r1 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.TAG     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r2.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L80
            r2.append(r0)     // Catch: java.lang.Throwable -> L80
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L80
            com.ss.android.socialbase.downloader.logger.Logger.i(r1, r0)     // Catch: java.lang.Throwable -> L80
            goto L9a
        L80:
            r0 = move-exception
            r0.printStackTrace()
            goto L9a
        L85:
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sForegroundId
            if (r0 == r7) goto L8d
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sIndependentProcessForegroundId
            if (r0 != r7) goto L9a
        L8d:
            boolean r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sBugFixNonOngoing
            if (r0 == 0) goto L9a
            int r0 = r8.flags
            r0 = r0 & 2
            if (r0 != 0) goto L9a
            r5.doCancel(r6, r7)
        L9a:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La9
            long r2 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sLastNotifyTimestamp     // Catch: java.lang.Throwable -> La9
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto La6
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sLastNotifyTimestamp = r0     // Catch: java.lang.Throwable -> La9
        La6:
            r6.notify(r7, r8)     // Catch: java.lang.Throwable -> La9
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.doNotify(android.app.NotificationManager, int, android.app.Notification):void");
    }

    private void handleIntent(Intent intent) {
        ThreadWithHandler threadWithHandler;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (threadWithHandler = this.mNotifyThreadHandler) == null) {
            return;
        }
        threadWithHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
            final /* synthetic */ String val$action;
            final /* synthetic */ Intent val$intent;

            /* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService$1$1 */
            class RunnableC05131 implements Runnable {
                final /* synthetic */ Notification val$notification;
                final /* synthetic */ int val$notificationId;
                final /* synthetic */ NotificationManager val$notificationManager;

                RunnableC05131(NotificationManager notificationManager2, int intExtra3, Notification notification2) {
                    notificationManager = notificationManager2;
                    intExtra = intExtra3;
                    notification = notification2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
                }
            }

            AnonymousClass1(Intent intent2, String action2) {
                intent = intent2;
                action = action2;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                NotificationManager notificationManager2 = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                int intExtra3 = intent.getIntExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, 0);
                if (!action.equals(NotificationConstants.ACTION_NOTIFICATION_NOTIFY)) {
                    if (action.equals(NotificationConstants.ACTION_NOTIFICATION_CANCEL)) {
                        if (intExtra3 != 0) {
                            DownloadNotificationService.this.doCancel(notificationManager2, intExtra3);
                            return;
                        }
                        return;
                    }
                    if (!action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                            try {
                                Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        if (DownloadUtils.checkPermission(DownloadNotificationService.this, g.f9317b) && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(DownloadConstants.MIME_APK)) {
                                arrayList.add(DownloadConstants.MIME_APK);
                            }
                            arrayList.add(DownloadConstants.MIME_PLG);
                            Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                            if (applicationContext != null) {
                                Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                                Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                Notification notification2 = (Notification) intent.getParcelableExtra(NotificationConstants.EXTRA_NOTIFICATION);
                int intExtra2 = intent.getIntExtra(NotificationConstants.EXTRA_NOTIFICATION_STATUS, 0);
                if (intExtra3 == 0 || notification2 == null || notificationManager2 == null) {
                    return;
                }
                if (intExtra2 != 4) {
                    if (intExtra2 != -2 && intExtra2 != -3) {
                        if (DownloadNotificationService.sBugfixNotifyTooFast) {
                            DownloadNotificationService.this.doImportantNotify(notificationManager2, intExtra3, notification2);
                            return;
                        } else {
                            DownloadNotificationService.this.doNotify(notificationManager2, intExtra3, notification2);
                            return;
                        }
                    }
                    if (DownloadNotificationService.sBugfixNotifyTooFast) {
                        DownloadNotificationService.this.doImportantNotify(notificationManager2, intExtra3, notification2);
                        return;
                    } else {
                        if (DownloadNotificationService.this.mNotifyThreadHandler != null) {
                            DownloadNotificationService.this.mNotifyThreadHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                final /* synthetic */ Notification val$notification;
                                final /* synthetic */ int val$notificationId;
                                final /* synthetic */ NotificationManager val$notificationManager;

                                RunnableC05131(NotificationManager notificationManager22, int intExtra32, Notification notification22) {
                                    notificationManager = notificationManager22;
                                    intExtra = intExtra32;
                                    notification = notification22;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
                                }
                            }, intExtra2 == -2 ? 50L : 200L);
                            return;
                        }
                        return;
                    }
                }
                if (Downloader.getInstance(DownloadComponentManager.getAppContext()).isDownloading(intExtra32)) {
                    DownloadInfo downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(intExtra32);
                    if (!DownloadNotificationService.sBugfixNotifyTooFast) {
                        if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                            return;
                        }
                        DownloadNotificationService.this.doNotify(notificationManager22, intExtra32, notification22);
                        downloadInfo.setLastNotifyProgressTime();
                        return;
                    }
                    if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.sLastImportantNotifyTimestamp <= DownloadNotificationService.sNotifyTimeWindow) {
                        return;
                    }
                    DownloadNotificationService.this.doNotify(notificationManager22, intExtra32, notification22);
                    downloadInfo.setLastNotifyProgressTime();
                }
            }
        });
    }

    private boolean needStartForeground(int i2, Notification notification) {
        int i3;
        int i4;
        if (!sAllowStartForeground || (i3 = sForegroundId) == i2 || (i4 = sIndependentProcessForegroundId) == i2) {
            return false;
        }
        if (i3 != 0 && i4 != 0) {
            return false;
        }
        if (sBugFixNonOngoing && (notification.flags & 2) == 0) {
            return false;
        }
        return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
    }

    public void performImportantNotify(NotificationManager notificationManager, int i2) {
        Notification notification;
        synchronized (this.pendingImportantNotify) {
            notification = this.pendingImportantNotify.get(i2);
            this.pendingImportantNotify.remove(i2);
        }
        if (notification != null) {
            doNotify(notificationManager, i2, notification);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        createNotifyHandlerThread();
        DownloadComponentManager.setAppContext(this);
        DownloadSetting obtainGlobal = DownloadSetting.obtainGlobal();
        int optInt = obtainGlobal.optInt(DownloadSettingKeys.DOWNLOAD_SERVICE_FOREGROUND, 0);
        if ((optInt == 1 || optInt == 3) && sForegroundId == -1) {
            sForegroundId = 0;
        }
        if ((optInt == 2 || optInt == 3) && sIndependentProcessForegroundId == -1) {
            sIndependentProcessForegroundId = 0;
        }
        sBugFixNonOngoing = obtainGlobal.optBugFix(DownloadSettingKeys.BugFix.NON_GOING_NOTIFICATION_FOREGROUND, false);
        sBugfixNotifyTooFast = obtainGlobal.optBugFix(DownloadSettingKeys.BugFix.FIX_NOTIFY_TOO_FAST, false);
        long optLong = obtainGlobal.optLong(DownloadSettingKeys.NOTIFICATION_TIME_WINDOW, NOTIFY_TIME_WINDOW);
        sNotifyTimeWindow = optLong;
        if (optLong < 0 || optLong > 1200) {
            sNotifyTimeWindow = NOTIFY_TIME_WINDOW;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ThreadWithHandler threadWithHandler = this.mNotifyThreadHandler;
        if (threadWithHandler != null) {
            try {
                threadWithHandler.quit();
            } catch (Throwable unused) {
            }
            this.mNotifyThreadHandler = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        handleIntent(intent);
        return 2;
    }
}
