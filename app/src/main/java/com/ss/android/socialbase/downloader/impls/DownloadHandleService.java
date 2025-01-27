package com.ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;

/* loaded from: classes4.dex */
public class DownloadHandleService extends Service {
    private static final String TAG = DownloadHandleService.class.getSimpleName();

    /* renamed from: com.ss.android.socialbase.downloader.impls.DownloadHandleService$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int val$id;

        AnonymousClass1(int i2) {
            intExtra = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DownloadProcessDispatcher.getInstance().retryDelayStart(intExtra);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void handleIntent(Intent intent) {
        int intExtra;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (intExtra = intent.getIntExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, 0)) == 0) {
            return;
        }
        if (action.equals(DownloadConstants.ACTION_RETRY)) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DownloadHandleService.1
                final /* synthetic */ int val$id;

                AnonymousClass1(int intExtra2) {
                    intExtra = intExtra2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DownloadProcessDispatcher.getInstance().retryDelayStart(intExtra);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else if (action.equals(DownloadConstants.ACTION_DOWNLOAD_PROCESS_NOTIFY)) {
            DownloadProcessDispatcher.getInstance().recordTaskProcessIndependent(intExtra2);
        } else if (action.equals(DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY)) {
            DownloadComponentManager.setDownloadInMultiProcess();
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
        handleIntent(intent);
        return 2;
    }
}
