package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
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
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class DownloadHandlerService extends Service {

    /* renamed from: j */
    private static final String f24406j = DownloadHandlerService.class.getSimpleName();

    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadHandlerService$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(AdBaseConstants.MIME_APK);
                arrayList.add(DownloadConstants.MIME_PLG);
                Downloader.getInstance(DownloadComponentManager.getAppContext()).restartAllFailedDownloadTasks(arrayList);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadHandlerService$2 */
    static class AnonymousClass2 implements Runnable {

        /* renamed from: i */
        final /* synthetic */ IDownloadNotificationEventListener f24408i;
        final /* synthetic */ com.ss.android.socialbase.appdownloader.i.g zx;

        AnonymousClass2(com.ss.android.socialbase.appdownloader.i.g gVar, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
            gVar = gVar;
            downloadNotificationEventListener = iDownloadNotificationEventListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            PackageInfo j2;
            try {
                File file = new File(DownloadInfo.this.getSavePath(), DownloadInfo.this.getName());
                if (file.exists()) {
                    try {
                        String str = (DownloadComponentManager.getAppContext() == null || (j2 = i.j(DownloadInfo.this, file)) == null) ? "" : j2.packageName;
                        com.ss.android.socialbase.appdownloader.i.g gVar = gVar;
                        if (gVar != null) {
                            gVar.j(DownloadInfo.this.getId(), 3, str, -3, DownloadInfo.this.getDownloadTime());
                        }
                        IDownloadNotificationEventListener iDownloadNotificationEventListener = downloadNotificationEventListener;
                        if (iDownloadNotificationEventListener != null) {
                            iDownloadNotificationEventListener.onNotificationEvent(3, DownloadInfo.this, str, "");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private boolean j(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.i.g zx = g.pa().zx();
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && DownloadSetting.obtain(intExtra).optInt("notification_opt_2") == 1) {
            DownloadNotificationManager.getInstance().cancelNotification(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            j(downloadInfo, zx, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            j(this, downloadInfo, zx, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            j(this, downloadInfo, zx, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && DownloadSetting.obtain(intExtra).optInt(DownloadSettingKeys.NO_HIDE_NOTIFICATION, 0) == 0) {
                if (!(DownloadSetting.obtain(intExtra).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 && downloadInfo.getStatus() == -1)) {
                    DownloadNotificationManager.getInstance().hideNotification(intExtra);
                    DownloadNotificationManager.getInstance().cancelNotification(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            zx(downloadInfo, zx, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            DownloadNotificationManager.getInstance().hideNotification(intExtra);
        } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(AdBaseConstants.MIME_APK);
                        arrayList.add(DownloadConstants.MIME_PLG);
                        Downloader.getInstance(DownloadComponentManager.getAppContext()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return true;
        }
        return false;
    }

    private void zx(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.i.g gVar, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(this, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        startActivity(intent);
        DownloadNotificationManager.getInstance().hideNotification(id);
        downloadInfo.updateDownloadTime();
        if (gVar != null) {
            gVar.j(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
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
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (Logger.debug()) {
            Logger.d(f24406j, "onStartCommand");
        }
        j(intent);
        stopSelf();
        return 2;
    }

    private static void j(Context context, DownloadInfo downloadInfo) {
        if (DownloadUtils.isWifi(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void j(Context context, com.ss.android.socialbase.appdownloader.i.g gVar, DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (gVar == null && downloadNotificationEventListener == null) {
            return;
        }
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2

            /* renamed from: i */
            final /* synthetic */ IDownloadNotificationEventListener f24408i;
            final /* synthetic */ com.ss.android.socialbase.appdownloader.i.g zx;

            AnonymousClass2(com.ss.android.socialbase.appdownloader.i.g gVar2, IDownloadNotificationEventListener downloadNotificationEventListener2) {
                gVar = gVar2;
                downloadNotificationEventListener = downloadNotificationEventListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                PackageInfo j2;
                try {
                    File file = new File(DownloadInfo.this.getSavePath(), DownloadInfo.this.getName());
                    if (file.exists()) {
                        try {
                            String str = (DownloadComponentManager.getAppContext() == null || (j2 = i.j(DownloadInfo.this, file)) == null) ? "" : j2.packageName;
                            com.ss.android.socialbase.appdownloader.i.g gVar2 = gVar;
                            if (gVar2 != null) {
                                gVar2.j(DownloadInfo.this.getId(), 3, str, -3, DownloadInfo.this.getDownloadTime());
                            }
                            IDownloadNotificationEventListener iDownloadNotificationEventListener = downloadNotificationEventListener;
                            if (iDownloadNotificationEventListener != null) {
                                iDownloadNotificationEventListener.onNotificationEvent(3, DownloadInfo.this, str, "");
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
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
    private void j(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo r8, com.ss.android.socialbase.appdownloader.i.g r9, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener r10) {
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
            r2 = 7
            int r4 = r8.getStatus()
            long r5 = r8.getDownloadTime()
            java.lang.String r3 = ""
            r0 = r9
            r0.j(r1, r2, r3, r4, r5)
        L49:
            if (r10 == 0) goto L51
            r9 = 7
            java.lang.String r0 = ""
            r10.onNotificationEvent(r9, r8, r0, r0)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.DownloadHandlerService.j(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.appdownloader.i.g, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener):void");
    }

    private static void j(Context context, int i2, boolean z) {
        boolean z2;
        INotificationClickCallback notificationClickCallback;
        DownloadInfo downloadInfo;
        if (z && (notificationClickCallback = DownloadProcessDispatcher.getInstance().getNotificationClickCallback(i2)) != null) {
            try {
                downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (downloadInfo != null) {
                z2 = notificationClickCallback.onClickWhenSuccess(downloadInfo);
                if (z2 && i.j(context, i2, true) == 0) {
                    Toast.makeText(context, "Open Fail!", 0).show();
                }
                return;
            }
        }
        z2 = false;
        if (z2) {
            return;
        }
        Toast.makeText(context, "Open Fail!", 0).show();
    }

    public static void j(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.i.g gVar, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        AbsNotificationItem notificationItem;
        int id = downloadInfo.getId();
        INotificationClickCallback notificationClickCallback = DownloadProcessDispatcher.getInstance().getNotificationClickCallback(id);
        if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && notificationClickCallback != null && i.j(context, downloadInfo) && notificationClickCallback.onClickWhenInstalled(downloadInfo)) {
        }
        boolean z = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (DownloadSetting.obtain(id).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                break;
            case -3:
                j(DownloadComponentManager.getAppContext(), id, true);
                j(context, gVar, downloadInfo);
                if (DownloadSetting.obtain(id).optInt("notification_click_install_auto_cancel", 1) != 0 || (notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(id)) == null) {
                    z = true;
                } else {
                    notificationItem.recordClickInstall();
                    notificationItem.refreshStatus(-3, null, false, true);
                }
                if (z) {
                    DownloadNotificationManager.getInstance().hideNotification(id);
                    break;
                }
                break;
            case -2:
                if (DownloadProcessDispatcher.getInstance().canResume(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    i.j(downloadInfo, true, false);
                }
                if (gVar != null) {
                    gVar.j(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
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
                Downloader.getInstance(context).pause(id);
                j(context, downloadInfo);
                if (gVar != null) {
                    gVar.j(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(5, downloadInfo, "", "");
                    break;
                }
                break;
        }
    }
}
