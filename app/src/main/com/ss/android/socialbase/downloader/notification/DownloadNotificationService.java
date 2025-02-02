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
    private static final long NOTIFY_TIME_WINDOW = 900;
    private static final String TAG = "DownloadNotificationService";
    private static boolean sAllowStartForeground = true;
    private static boolean sBugFixNonOngoing = false;
    private static boolean sBugfixNotifyTooFast = false;
    private static int sForegroundId = -1;
    private static int sIndependentProcessForegroundId = -1;
    private static volatile long sLastImportantNotifyTimestamp = 0;
    private static volatile long sLastNotifyTimestamp = 0;
    private static long sNotifyTimeWindow = 900;
    private ThreadWithHandler mNotifyThreadHandler;
    private final SparseArray<Notification> pendingImportantNotify = new SparseArray<>(2);

    /* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$action;
        final /* synthetic */ Intent val$intent;

        /* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService$1$1 */
        public class RunnableC06511 implements Runnable {
            final /* synthetic */ Notification val$notification;
            final /* synthetic */ int val$notificationId;
            final /* synthetic */ NotificationManager val$notificationManager;

            public RunnableC06511(NotificationManager notificationManager, int i10, Notification notification) {
                notificationManager = notificationManager;
                intExtra = i10;
                notification = notification;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
            }
        }

        public AnonymousClass1(Intent intent, String str) {
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
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                try {
                    if (DownloadUtils.checkPermission(DownloadNotificationService.this, g.f11101b) && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
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
                } catch (Exception e11) {
                    e11.printStackTrace();
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

                            public RunnableC06511(NotificationManager notificationManager2, int intExtra3, Notification notification2) {
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
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ int val$notificationId;
        final /* synthetic */ NotificationManager val$notificationManager;

        public AnonymousClass2(NotificationManager notificationManager, int i10) {
            notificationManager = notificationManager;
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadNotificationService.this.performImportantNotify(notificationManager, i10);
        }
    }

    private void createNotifyHandlerThread() {
        if (this.mNotifyThreadHandler == null) {
            ThreadWithHandler threadWithHandler = new ThreadWithHandler("DownloaderNotifyThread");
            this.mNotifyThreadHandler = threadWithHandler;
            threadWithHandler.start();
        }
    }

    public void doCancel(NotificationManager notificationManager, int i10) {
        boolean z10;
        AbsNotificationItem absNotificationItem;
        int id2;
        int i11 = sForegroundId;
        if (i11 != i10 && sIndependentProcessForegroundId != i10) {
            try {
                notificationManager.cancel(i10);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z11 = true;
        if (i11 == i10) {
            sForegroundId = 0;
            z10 = false;
        } else {
            sIndependentProcessForegroundId = 0;
            z10 = true;
        }
        try {
            IDownloadProxy downloadHandler = DownloadProcessDispatcher.getInstance().getDownloadHandler(i10);
            if (!downloadHandler.isServiceForeground()) {
                sAllowStartForeground = false;
                Logger.w(TAG, "try to stopForeground when is not Foreground, id = " + i10 + ", isIndependentProcess = " + z10);
            }
            Logger.i(TAG, "doCancel, ========== stopForeground id = " + i10 + ", isIndependentProcess = " + z10);
            downloadHandler.stopForeground(false, true);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            notificationManager.cancel(i10);
        } catch (Throwable unused2) {
        }
        if (sAllowStartForeground) {
            try {
                SparseArray<AbsNotificationItem> allNotificationItems = DownloadNotificationManager.getInstance().getAllNotificationItems();
                if (allNotificationItems != null) {
                    for (int size = allNotificationItems.size() - 1; size >= 0; size--) {
                        absNotificationItem = allNotificationItems.valueAt(size);
                        if (absNotificationItem != null && (id2 = absNotificationItem.getId()) != i10 && id2 != sForegroundId && id2 != sIndependentProcessForegroundId && absNotificationItem.isOngoing()) {
                            if ((DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(absNotificationItem.getId()) == 1 && !DownloadUtils.isDownloaderProcess()) == z10) {
                                break;
                            }
                        }
                    }
                }
                absNotificationItem = null;
                if (absNotificationItem != null) {
                    int id3 = absNotificationItem.getId();
                    try {
                        notificationManager.cancel(id3);
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    if (Downloader.getInstance(this).getStatus(id3) != 1) {
                        z11 = false;
                    }
                    Logger.i(TAG, "doCancel, updateNotification id = " + id3);
                    absNotificationItem.updateNotification(null, z11);
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        }
    }

    public void doImportantNotify(NotificationManager notificationManager, int i10, Notification notification) {
        synchronized (this.pendingImportantNotify) {
            try {
                int indexOfKey = this.pendingImportantNotify.indexOfKey(i10);
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
                    doNotify(notificationManager, i10, notification);
                } else if (this.mNotifyThreadHandler != null) {
                    synchronized (this.pendingImportantNotify) {
                        this.pendingImportantNotify.put(i10, notification);
                    }
                    this.mNotifyThreadHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                        final /* synthetic */ int val$notificationId;
                        final /* synthetic */ NotificationManager val$notificationManager;

                        public AnonymousClass2(NotificationManager notificationManager2, int i102) {
                            notificationManager = notificationManager2;
                            i10 = i102;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            DownloadNotificationService.this.performImportantNotify(notificationManager, i10);
                        }
                    }, currentTimeMillis);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0026, code lost:
    
        if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sIndependentProcessForegroundId == 0) goto L119;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doNotify(android.app.NotificationManager r6, int r7, android.app.Notification r8) {
        /*
            r5 = this;
            boolean r0 = r5.needStartForeground(r7, r8)
            if (r0 == 0) goto L80
            com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher r0 = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance()     // Catch: java.lang.Throwable -> L18
            int r0 = r0.getDownloadWithIndependentProcessStatus(r7)     // Catch: java.lang.Throwable -> L18
            r1 = 1
            if (r0 != r1) goto L1a
            boolean r0 = com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1a
            goto L1b
        L18:
            r0 = move-exception
            goto L7c
        L1a:
            r1 = 0
        L1b:
            if (r1 != 0) goto L22
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sForegroundId     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L22
            goto L28
        L22:
            if (r1 == 0) goto L95
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sIndependentProcessForegroundId     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L95
        L28:
            com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher r0 = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance()     // Catch: java.lang.Throwable -> L18
            com.ss.android.socialbase.downloader.downloader.IDownloadProxy r0 = r0.getDownloadHandler(r7)     // Catch: java.lang.Throwable -> L18
            boolean r2 = r0.isServiceAlive()     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L65
            boolean r2 = r0.isServiceForeground()     // Catch: java.lang.Throwable -> L18
            if (r2 != 0) goto L65
            java.lang.String r2 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.TAG     // Catch: java.lang.Throwable -> L18
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            r3.<init>()     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = "doNotify, startForeground, ======== id = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L18
            r3.append(r7)     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = ", isIndependentProcess = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L18
            r3.append(r1)     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L18
            com.ss.android.socialbase.downloader.logger.Logger.i(r2, r3)     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L5f
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sIndependentProcessForegroundId = r7     // Catch: java.lang.Throwable -> L18
            goto L61
        L5f:
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sForegroundId = r7     // Catch: java.lang.Throwable -> L18
        L61:
            r0.startForeground(r7, r8)     // Catch: java.lang.Throwable -> L18
            goto L95
        L65:
            java.lang.String r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.TAG     // Catch: java.lang.Throwable -> L18
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            r2.<init>()     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L18
            r2.append(r1)     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L18
            com.ss.android.socialbase.downloader.logger.Logger.i(r0, r1)     // Catch: java.lang.Throwable -> L18
            goto L95
        L7c:
            r0.printStackTrace()
            goto L95
        L80:
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sForegroundId
            if (r0 == r7) goto L88
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sIndependentProcessForegroundId
            if (r0 != r7) goto L95
        L88:
            boolean r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sBugFixNonOngoing
            if (r0 == 0) goto L95
            int r0 = r8.flags
            r0 = r0 & 2
            if (r0 != 0) goto L95
            r5.doCancel(r6, r7)
        L95:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La4
            long r2 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sLastNotifyTimestamp     // Catch: java.lang.Throwable -> La4
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto La1
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sLastNotifyTimestamp = r0     // Catch: java.lang.Throwable -> La4
        La1:
            r6.notify(r7, r8)     // Catch: java.lang.Throwable -> La4
        La4:
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
            public class RunnableC06511 implements Runnable {
                final /* synthetic */ Notification val$notification;
                final /* synthetic */ int val$notificationId;
                final /* synthetic */ NotificationManager val$notificationManager;

                public RunnableC06511(NotificationManager notificationManager2, int intExtra3, Notification notification2) {
                    notificationManager = notificationManager2;
                    intExtra = intExtra3;
                    notification = notification2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
                }
            }

            public AnonymousClass1(Intent intent2, String action2) {
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
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        if (DownloadUtils.checkPermission(DownloadNotificationService.this, g.f11101b) && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
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
                    } catch (Exception e11) {
                        e11.printStackTrace();
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

                                public RunnableC06511(NotificationManager notificationManager22, int intExtra32, Notification notification22) {
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

    private boolean needStartForeground(int i10, Notification notification) {
        int i11;
        int i12;
        String channelId;
        if (!sAllowStartForeground || (i11 = sForegroundId) == i10 || (i12 = sIndependentProcessForegroundId) == i10) {
            return false;
        }
        if (i11 != 0 && i12 != 0) {
            return false;
        }
        if (sBugFixNonOngoing && (notification.flags & 2) == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        channelId = notification.getChannelId();
        return !TextUtils.isEmpty(channelId);
    }

    public void performImportantNotify(NotificationManager notificationManager, int i10) {
        Notification notification;
        synchronized (this.pendingImportantNotify) {
            notification = this.pendingImportantNotify.get(i10);
            this.pendingImportantNotify.remove(i10);
        }
        if (notification != null) {
            doNotify(notificationManager, i10, notification);
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
    public int onStartCommand(Intent intent, int i10, int i11) {
        handleIntent(intent);
        return 2;
    }
}
