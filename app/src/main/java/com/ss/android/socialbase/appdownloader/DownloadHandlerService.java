package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class DownloadHandlerService extends Service {

    /* renamed from: a */
    private static final String f21724a = "DownloadHandlerService";

    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadHandlerService$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add("application/vnd.android.package-archive");
                arrayList.add(DownloadConstants.MIME_PLG);
                Downloader.getInstance(DownloadComponentManager.getAppContext()).restartAllFailedDownloadTasks(arrayList);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadHandlerService$2 */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.ss.android.socialbase.appdownloader.c.d f21727b;

        /* renamed from: c */
        final /* synthetic */ IDownloadNotificationEventListener f21728c;

        public AnonymousClass2(com.ss.android.socialbase.appdownloader.c.d dVar, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
            dVar = dVar;
            downloadNotificationEventListener = iDownloadNotificationEventListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            PackageInfo a10;
            try {
                File file = new File(DownloadInfo.this.getSavePath(), DownloadInfo.this.getName());
                if (file.exists()) {
                    try {
                        String str = (DownloadComponentManager.getAppContext() == null || (a10 = c.a(DownloadInfo.this, file)) == null) ? "" : a10.packageName;
                        com.ss.android.socialbase.appdownloader.c.d dVar = dVar;
                        if (dVar != null) {
                            dVar.a(DownloadInfo.this.getId(), 3, str, -3, DownloadInfo.this.getDownloadTime());
                        }
                        IDownloadNotificationEventListener iDownloadNotificationEventListener = downloadNotificationEventListener;
                        if (iDownloadNotificationEventListener != null) {
                            iDownloadNotificationEventListener.onNotificationEvent(3, DownloadInfo.this, str, "");
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    private boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.c.d b10 = d.j().b();
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && DownloadSetting.obtain(intExtra).optInt("notification_opt_2") == 1) {
            DownloadNotificationManager.getInstance().cancelNotification(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            a(downloadInfo, b10, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            a(this, downloadInfo, b10, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            a(this, downloadInfo, b10, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && DownloadSetting.obtain(intExtra).optInt(DownloadSettingKeys.NO_HIDE_NOTIFICATION, 0) == 0 && (DownloadSetting.obtain(intExtra).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) < 2 || downloadInfo.getStatus() != -1)) {
                DownloadNotificationManager.getInstance().hideNotification(intExtra);
                DownloadNotificationManager.getInstance().cancelNotification(intExtra);
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            b(downloadInfo, b10, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            DownloadNotificationManager.getInstance().hideNotification(intExtra);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("application/vnd.android.package-archive");
                        arrayList.add(DownloadConstants.MIME_PLG);
                        Downloader.getInstance(DownloadComponentManager.getAppContext()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            return true;
        }
        return false;
    }

    private void b(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c.d dVar, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        int id2 = downloadInfo.getId();
        Intent intent = new Intent(this, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id2);
        intent.addFlags(268435456);
        startActivity(intent);
        DownloadNotificationManager.getInstance().hideNotification(id2);
        downloadInfo.updateDownloadTime();
        if (dVar != null) {
            dVar.a(id2, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (iDownloadNotificationEventListener != null) {
            iDownloadNotificationEventListener.onNotificationEvent(7, downloadInfo, "", "");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (Logger.debug()) {
            Logger.d(f21724a, "onStartCommand");
        }
        a(intent);
        stopSelf();
        return 2;
    }

    private static void a(Context context, DownloadInfo downloadInfo) {
        if (DownloadUtils.isWifi(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void a(Context context, com.ss.android.socialbase.appdownloader.c.d dVar, DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (dVar == null && downloadNotificationEventListener == null) {
            return;
        }
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2

            /* renamed from: b */
            final /* synthetic */ com.ss.android.socialbase.appdownloader.c.d f21727b;

            /* renamed from: c */
            final /* synthetic */ IDownloadNotificationEventListener f21728c;

            public AnonymousClass2(com.ss.android.socialbase.appdownloader.c.d dVar2, IDownloadNotificationEventListener downloadNotificationEventListener2) {
                dVar = dVar2;
                downloadNotificationEventListener = downloadNotificationEventListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                PackageInfo a10;
                try {
                    File file = new File(DownloadInfo.this.getSavePath(), DownloadInfo.this.getName());
                    if (file.exists()) {
                        try {
                            String str = (DownloadComponentManager.getAppContext() == null || (a10 = c.a(DownloadInfo.this, file)) == null) ? "" : a10.packageName;
                            com.ss.android.socialbase.appdownloader.c.d dVar2 = dVar;
                            if (dVar2 != null) {
                                dVar2.a(DownloadInfo.this.getId(), 3, str, -3, DownloadInfo.this.getDownloadTime());
                            }
                            IDownloadNotificationEventListener iDownloadNotificationEventListener = downloadNotificationEventListener;
                            if (iDownloadNotificationEventListener != null) {
                                iDownloadNotificationEventListener.onNotificationEvent(3, DownloadInfo.this, str, "");
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo r8, com.ss.android.socialbase.appdownloader.c.d r9, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener r10) {
        /*
            r7 = this;
            int r1 = r8.getId()
            com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher r0 = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance()
            com.ss.android.socialbase.downloader.depend.INotificationClickCallback r0 = r0.getNotificationClickCallback(r1)
            if (r0 == 0) goto L17
            boolean r0 = r0.onClickWhenUnSuccess(r8)     // Catch: java.lang.Throwable -> L13
            goto L18
        L13:
            r0 = move-exception
            r0.printStackTrace()
        L17:
            r0 = 0
        L18:
            if (r0 != 0) goto L51
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity> r2 = com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.class
            r0.<init>(r7, r2)
            java.lang.String r2 = "extra_click_download_ids"
            r0.putExtra(r2, r1)
            r2 = 268435456(0x10000000, float:2.524355E-29)
            r0.addFlags(r2)
            r7.startActivity(r0)
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance()
            r0.hideNotification(r1)
            r8.updateDownloadTime()
            if (r9 == 0) goto L49
            int r4 = r8.getStatus()
            long r5 = r8.getDownloadTime()
            r2 = 7
            java.lang.String r3 = ""
            r0 = r9
            r0.a(r1, r2, r3, r4, r5)
        L49:
            if (r10 == 0) goto L51
            r9 = 7
            java.lang.String r0 = ""
            r10.onNotificationEvent(r9, r8, r0, r0)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.DownloadHandlerService.a(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.appdownloader.c.d, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener):void");
    }

    private static void a(Context context, int i10, boolean z10) {
        boolean z11;
        INotificationClickCallback notificationClickCallback;
        DownloadInfo downloadInfo;
        if (z10 && (notificationClickCallback = DownloadProcessDispatcher.getInstance().getNotificationClickCallback(i10)) != null) {
            try {
                downloadInfo = Downloader.getInstance(context).getDownloadInfo(i10);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (downloadInfo != null) {
                z11 = notificationClickCallback.onClickWhenSuccess(downloadInfo);
                if (z11 && c.a(context, i10, true) == 0) {
                    Toast.makeText(context, "Open Fail!", 0).show();
                }
                return;
            }
        }
        z11 = false;
        if (z11) {
            return;
        }
        Toast.makeText(context, "Open Fail!", 0).show();
    }

    public static void a(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c.d dVar, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        AbsNotificationItem notificationItem;
        int id2 = downloadInfo.getId();
        INotificationClickCallback notificationClickCallback = DownloadProcessDispatcher.getInstance().getNotificationClickCallback(id2);
        if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && notificationClickCallback != null && c.a(context, downloadInfo) && notificationClickCallback.onClickWhenInstalled(downloadInfo)) {
        }
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (DownloadSetting.obtain(id2).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id2);
                break;
            case -3:
                a(DownloadComponentManager.getAppContext(), id2, true);
                a(context, dVar, downloadInfo);
                if (DownloadSetting.obtain(id2).optInt("notification_click_install_auto_cancel", 1) == 0 && (notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(id2)) != null) {
                    notificationItem.recordClickInstall();
                    notificationItem.refreshStatus(-3, null, false, true);
                    break;
                } else {
                    DownloadNotificationManager.getInstance().hideNotification(id2);
                    break;
                }
                break;
            case -2:
                if (DownloadProcessDispatcher.getInstance().canResume(id2)) {
                    Downloader.getInstance(context).resume(id2);
                } else {
                    c.a(downloadInfo, true, false);
                }
                if (dVar != null) {
                    dVar.a(id2, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(6, downloadInfo, "", "");
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id2);
                a(context, downloadInfo);
                if (dVar != null) {
                    dVar.a(id2, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(5, downloadInfo, "", "");
                    break;
                }
                break;
        }
    }
}
