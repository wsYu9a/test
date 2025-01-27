package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sigmob.sdk.base.common.y;
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
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f21729a = "DownloadReceiver";

    /* renamed from: b */
    private Handler f21730b = new Handler(Looper.getMainLooper());

    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Intent f21731a;

        /* renamed from: b */
        final /* synthetic */ Context f21732b;

        /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1 */
        public class RunnableC06441 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ DownloadInfo f21734a;

            /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1$1 */
            public class RunnableC06451 implements Runnable {
                public RunnableC06451() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (downloadInfo.isSavePathRedirected()) {
                            DownloadUtils.clearAntiHijackDir(downloadInfo);
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }

            public RunnableC06441(DownloadInfo downloadInfo) {
                downloadInfo = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                    public RunnableC06451() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (downloadInfo.isSavePathRedirected()) {
                                DownloadUtils.clearAntiHijackDir(downloadInfo);
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                });
            }
        }

        public AnonymousClass1(Intent intent, Context context) {
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
            com.ss.android.socialbase.appdownloader.c.d b10 = d.j().b();
            if (b10 != null) {
                b10.a(context, schemeSpecificPart);
            }
            List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
            if (successedDownloadInfosWithMimeType != null) {
                for (DownloadInfo downloadInfo : successedDownloadInfosWithMimeType) {
                    if (downloadInfo != null && c.a(downloadInfo, schemeSpecificPart)) {
                        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
                        if (downloadNotificationEventListener != null && DownloadUtils.isProcessNameSame(downloadNotificationEventListener.getNotifyProcessName())) {
                            downloadNotificationEventListener.onNotificationEvent(9, downloadInfo, schemeSpecificPart, "");
                        }
                        AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
                        if (notificationItem != null) {
                            notificationItem.updateNotification(null, false);
                        }
                        if (DownloadSetting.obtain(downloadInfo.getId()).optInt("install_queue_enable", 0) == 1) {
                            h.a().a(downloadInfo, schemeSpecificPart);
                        }
                        DownloadReceiver.this.f21730b.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1

                            /* renamed from: a */
                            final /* synthetic */ DownloadInfo f21734a;

                            /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1$1 */
                            public class RunnableC06451 implements Runnable {
                                public RunnableC06451() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        if (downloadInfo.isSavePathRedirected()) {
                                            DownloadUtils.clearAntiHijackDir(downloadInfo);
                                        }
                                    } catch (Throwable th2) {
                                        th2.printStackTrace();
                                    }
                                }
                            }

                            public RunnableC06441(DownloadInfo downloadInfo2) {
                                downloadInfo = downloadInfo2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                    public RunnableC06451() {
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (downloadInfo.isSavePathRedirected()) {
                                                DownloadUtils.clearAntiHijackDir(downloadInfo);
                                            }
                                        } catch (Throwable th2) {
                                            th2.printStackTrace();
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
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f21737a;

        /* renamed from: b */
        final /* synthetic */ String f21738b;

        public AnonymousClass2(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent(context, (Class<?>) DownloadHandlerService.class);
                intent.setAction(str);
                context.startService(intent);
            } catch (Throwable th2) {
                th2.printStackTrace();
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
        if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (Logger.debug()) {
                Logger.v(f21729a, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            a(context, action);
        } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1

                /* renamed from: a */
                final /* synthetic */ Intent f21731a;

                /* renamed from: b */
                final /* synthetic */ Context f21732b;

                /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1 */
                public class RunnableC06441 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ DownloadInfo f21734a;

                    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1$1 */
                    public class RunnableC06451 implements Runnable {
                        public RunnableC06451() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (downloadInfo.isSavePathRedirected()) {
                                    DownloadUtils.clearAntiHijackDir(downloadInfo);
                                }
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    }

                    public RunnableC06441(DownloadInfo downloadInfo2) {
                        downloadInfo = downloadInfo2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                            public RunnableC06451() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (downloadInfo.isSavePathRedirected()) {
                                        DownloadUtils.clearAntiHijackDir(downloadInfo);
                                    }
                                } catch (Throwable th2) {
                                    th2.printStackTrace();
                                }
                            }
                        });
                    }
                }

                public AnonymousClass1(Intent intent2, Context context2) {
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
                    com.ss.android.socialbase.appdownloader.c.d b10 = d.j().b();
                    if (b10 != null) {
                        b10.a(context, schemeSpecificPart);
                    }
                    List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
                    if (successedDownloadInfosWithMimeType != null) {
                        for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                            if (downloadInfo2 != null && c.a(downloadInfo2, schemeSpecificPart)) {
                                IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo2.getId());
                                if (downloadNotificationEventListener != null && DownloadUtils.isProcessNameSame(downloadNotificationEventListener.getNotifyProcessName())) {
                                    downloadNotificationEventListener.onNotificationEvent(9, downloadInfo2, schemeSpecificPart, "");
                                }
                                AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo2.getId());
                                if (notificationItem != null) {
                                    notificationItem.updateNotification(null, false);
                                }
                                if (DownloadSetting.obtain(downloadInfo2.getId()).optInt("install_queue_enable", 0) == 1) {
                                    h.a().a(downloadInfo2, schemeSpecificPart);
                                }
                                DownloadReceiver.this.f21730b.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1

                                    /* renamed from: a */
                                    final /* synthetic */ DownloadInfo f21734a;

                                    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1$1 */
                                    public class RunnableC06451 implements Runnable {
                                        public RunnableC06451() {
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            try {
                                                if (downloadInfo.isSavePathRedirected()) {
                                                    DownloadUtils.clearAntiHijackDir(downloadInfo);
                                                }
                                            } catch (Throwable th2) {
                                                th2.printStackTrace();
                                            }
                                        }
                                    }

                                    public RunnableC06441(DownloadInfo downloadInfo22) {
                                        downloadInfo = downloadInfo22;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                            public RunnableC06451() {
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                try {
                                                    if (downloadInfo.isSavePathRedirected()) {
                                                        DownloadUtils.clearAntiHijackDir(downloadInfo);
                                                    }
                                                } catch (Throwable th2) {
                                                    th2.printStackTrace();
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

    private void a(Context context, String str) {
        if (DownloadComponentManager.needAutoRefreshUnSuccessTask()) {
            DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.2

                /* renamed from: a */
                final /* synthetic */ Context f21737a;

                /* renamed from: b */
                final /* synthetic */ String f21738b;

                public AnonymousClass2(Context context2, String str2) {
                    context = context2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadHandlerService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }, y.f.f18076n, TimeUnit.MILLISECONDS);
        }
    }
}
