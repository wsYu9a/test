package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sigmob.sdk.base.common.y;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class DownloadReceiver extends BroadcastReceiver {
    private static final String TAG = "DownloadReceiver";

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadReceiver$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$action;
        final /* synthetic */ Context val$context;

        public AnonymousClass1(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                intent.setAction(str);
                context.startService(intent);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadReceiver$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ String val$action;
        final /* synthetic */ Context val$context;

        public AnonymousClass2(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                intent.setAction(str);
                context.startService(intent);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private void autoRefreshUnsuccessDownloadTask(Context context, String str) {
        if (DownloadComponentManager.needAutoRefreshUnSuccessTask()) {
            DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.1
                final /* synthetic */ String val$action;
                final /* synthetic */ Context val$context;

                public AnonymousClass1(Context context2, String str2) {
                    context = context2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }, y.f.f18076n, TimeUnit.MILLISECONDS);
        }
    }

    private void forceStopAllDownloadTask(Context context, String str) {
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.2
            final /* synthetic */ String val$action;
            final /* synthetic */ Context val$context;

            public AnonymousClass2(Context context2, String str2) {
                context = context2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    context.startService(intent);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
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
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            if (Logger.debug()) {
                Logger.v(TAG, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            autoRefreshUnsuccessDownloadTask(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            forceStopAllDownloadTask(context, action);
        }
    }
}
