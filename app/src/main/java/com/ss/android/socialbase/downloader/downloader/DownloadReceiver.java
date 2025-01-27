package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;

/* loaded from: classes4.dex */
public class DownloadReceiver extends BroadcastReceiver {
    private static final String TAG = DownloadReceiver.class.getSimpleName();

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadReceiver$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$action;
        final /* synthetic */ Context val$context;

        AnonymousClass1(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                intent.setAction(str);
                context.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void autoRefreshUnsuccessDownloadTask(Context context, String str) {
        if (DownloadComponentManager.needAutoRefreshUnSuccessTask()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.1
                final /* synthetic */ String val$action;
                final /* synthetic */ Context val$context;

                AnonymousClass1(Context context2, String str2) {
                    context = context2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, 2000L);
        }
    }

    private void forceStopAllDownloadTask(Context context, String str) {
        try {
            Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
            intent.setAction(str);
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
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
