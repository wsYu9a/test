package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;

/* loaded from: classes4.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: j */
    private static final String f24410j = DownloadReceiver.class.getSimpleName();
    private Handler zx = new Handler(Looper.getMainLooper());

    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ Intent f24412j;
        final /* synthetic */ Context zx;

        /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1 */
        class RunnableC05061 implements Runnable {

            /* renamed from: j */
            final /* synthetic */ DownloadInfo f24413j;

            /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1$1 */
            class RunnableC05071 implements Runnable {
                RunnableC05071() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (downloadInfo.isSavePathRedirected()) {
                            DownloadUtils.clearAntiHijackDir(downloadInfo);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }

            RunnableC05061(DownloadInfo downloadInfo) {
                downloadInfo = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                    RunnableC05071() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (downloadInfo.isSavePathRedirected()) {
                                DownloadUtils.clearAntiHijackDir(downloadInfo);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        }

        AnonymousClass1(Intent intent, Context context) {
            intent = intent;
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uri data = intent.getData();
            if (data == null) {
                return;
            }
            String schemeSpecificPart = data.getSchemeSpecificPart();
            com.ss.android.socialbase.appdownloader.i.g zx = g.pa().zx();
            if (zx != null) {
                zx.j(context, schemeSpecificPart);
            }
            List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
            if (successedDownloadInfosWithMimeType != null) {
                for (DownloadInfo downloadInfo : successedDownloadInfosWithMimeType) {
                    if (downloadInfo != null && i.j(downloadInfo, schemeSpecificPart)) {
                        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
                        if (downloadNotificationEventListener != null && DownloadUtils.isProcessNameSame(downloadNotificationEventListener.getNotifyProcessName())) {
                            downloadNotificationEventListener.onNotificationEvent(9, downloadInfo, schemeSpecificPart, "");
                        }
                        AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
                        if (notificationItem != null) {
                            notificationItem.updateNotification(null, false);
                        }
                        if (DownloadSetting.obtain(downloadInfo.getId()).optInt("install_queue_enable", 0) == 1) {
                            y.j().j(downloadInfo, schemeSpecificPart);
                        }
                        DownloadReceiver.this.zx.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1

                            /* renamed from: j */
                            final /* synthetic */ DownloadInfo f24413j;

                            /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1$1 */
                            class RunnableC05071 implements Runnable {
                                RunnableC05071() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        if (downloadInfo.isSavePathRedirected()) {
                                            DownloadUtils.clearAntiHijackDir(downloadInfo);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }

                            RunnableC05061(DownloadInfo downloadInfo2) {
                                downloadInfo = downloadInfo2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                    RunnableC05071() {
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (downloadInfo.isSavePathRedirected()) {
                                                DownloadUtils.clearAntiHijackDir(downloadInfo);
                                            }
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                });
                            }
                        }, 1000L);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ Context f24416j;
        final /* synthetic */ String zx;

        AnonymousClass2(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent(context, (Class<?>) DownloadHandlerService.class);
                intent.setAction(str);
                context.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        com.ss.android.socialbase.appdownloader.i.i j2 = g.pa().j();
        if (action.equals("android.intent.action.BOOT_COMPLETED") && (j2 == null || j2.j())) {
            if (Logger.debug()) {
                Logger.v(f24410j, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
            }
            j(context, action);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (Logger.debug()) {
                Logger.v(f24410j, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            j(context, action);
        } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1

                /* renamed from: j */
                final /* synthetic */ Intent f24412j;
                final /* synthetic */ Context zx;

                /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1 */
                class RunnableC05061 implements Runnable {

                    /* renamed from: j */
                    final /* synthetic */ DownloadInfo f24413j;

                    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1$1 */
                    class RunnableC05071 implements Runnable {
                        RunnableC05071() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (downloadInfo.isSavePathRedirected()) {
                                    DownloadUtils.clearAntiHijackDir(downloadInfo);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }

                    RunnableC05061(DownloadInfo downloadInfo2) {
                        downloadInfo = downloadInfo2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                            RunnableC05071() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (downloadInfo.isSavePathRedirected()) {
                                        DownloadUtils.clearAntiHijackDir(downloadInfo);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        });
                    }
                }

                AnonymousClass1(Intent intent2, Context context2) {
                    intent = intent2;
                    context = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Uri data = intent.getData();
                    if (data == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    com.ss.android.socialbase.appdownloader.i.g zx = g.pa().zx();
                    if (zx != null) {
                        zx.j(context, schemeSpecificPart);
                    }
                    List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
                    if (successedDownloadInfosWithMimeType != null) {
                        for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                            if (downloadInfo2 != null && i.j(downloadInfo2, schemeSpecificPart)) {
                                IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo2.getId());
                                if (downloadNotificationEventListener != null && DownloadUtils.isProcessNameSame(downloadNotificationEventListener.getNotifyProcessName())) {
                                    downloadNotificationEventListener.onNotificationEvent(9, downloadInfo2, schemeSpecificPart, "");
                                }
                                AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo2.getId());
                                if (notificationItem != null) {
                                    notificationItem.updateNotification(null, false);
                                }
                                if (DownloadSetting.obtain(downloadInfo2.getId()).optInt("install_queue_enable", 0) == 1) {
                                    y.j().j(downloadInfo2, schemeSpecificPart);
                                }
                                DownloadReceiver.this.zx.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1

                                    /* renamed from: j */
                                    final /* synthetic */ DownloadInfo f24413j;

                                    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1$1 */
                                    class RunnableC05071 implements Runnable {
                                        RunnableC05071() {
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            try {
                                                if (downloadInfo.isSavePathRedirected()) {
                                                    DownloadUtils.clearAntiHijackDir(downloadInfo);
                                                }
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                            }
                                        }
                                    }

                                    RunnableC05061(DownloadInfo downloadInfo22) {
                                        downloadInfo = downloadInfo22;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                            RunnableC05071() {
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                try {
                                                    if (downloadInfo.isSavePathRedirected()) {
                                                        DownloadUtils.clearAntiHijackDir(downloadInfo);
                                                    }
                                                } catch (Throwable th) {
                                                    th.printStackTrace();
                                                }
                                            }
                                        });
                                    }
                                }, 1000L);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    private void j(Context context, String str) {
        if (DownloadComponentManager.needAutoRefreshUnSuccessTask()) {
            this.zx.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.2

                /* renamed from: j */
                final /* synthetic */ Context f24416j;
                final /* synthetic */ String zx;

                AnonymousClass2(Context context2, String str2) {
                    context = context2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadHandlerService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, 2000L);
        }
    }
}
