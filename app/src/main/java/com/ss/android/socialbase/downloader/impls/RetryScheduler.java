package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class RetryScheduler implements Handler.Callback, AppStatusManager.AppStatusChangeListener {
    private static final int MIN_INTERVAL_MS = 3000;
    private static final int MIN_INTERVAL_MS_ACCELERATION = 5000;
    public static final int NET_TYPE_COMMON = 1;
    public static final int NET_TYPE_NONE = 0;
    public static final int NET_TYPE_WIFI = 2;
    public static final int RETRY_SCHEDULE_NORMAL = 1;
    public static final int RETRY_SCHEDULE_WHEN_APP_BACKGROUND = 3;
    public static final int RETRY_SCHEDULE_WHEN_APP_FOREGROUND = 4;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_CONNECTED = 5;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_SUCCEED = 2;
    private static final int SCHEDULE_ALL_TASK_RETRY_DELAY = 2000;
    private static final int SCHEDULE_ALL_TASK_RETRY_MIN_INTERVAL = 10000;
    private static final String TAG = "RetryScheduler";
    private static volatile RetryScheduler sInstance;
    private static RetryScheduleHandler sRetryScheduleHandler;
    private ConnectivityManager mConnectivityManager;
    private final boolean mIsDownloaderProcess;
    private long mLastHandleAllTaskTime;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), this);
    private final SparseArray<RetryInfo> mRetryInfoList = new SparseArray<>();
    private int mWaitingRetryTasksCount = 0;
    private final Context mContext = DownloadComponentManager.getAppContext();

    /* renamed from: com.ss.android.socialbase.downloader.impls.RetryScheduler$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: com.ss.android.socialbase.downloader.impls.RetryScheduler$1$1 */
        class C05121 extends ConnectivityManager.NetworkCallback {
            C05121() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                Logger.d(RetryScheduler.TAG, "network onAvailable: ");
                RetryScheduler.this.scheduleAllTaskRetry(1, true);
            }
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (RetryScheduler.this.mContext == null || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                RetryScheduler retryScheduler = RetryScheduler.this;
                retryScheduler.mConnectivityManager = (ConnectivityManager) retryScheduler.mContext.getApplicationContext().getSystemService("connectivity");
                RetryScheduler.this.mConnectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.1.1
                    C05121() {
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        Logger.d(RetryScheduler.TAG, "network onAvailable: ");
                        RetryScheduler.this.scheduleAllTaskRetry(1, true);
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.RetryScheduler$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ boolean val$force;
        final /* synthetic */ int val$level;

        AnonymousClass2(int i2, boolean z) {
            i2 = i2;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int netWorkType;
            try {
                if (RetryScheduler.this.mWaitingRetryTasksCount > 0 && (netWorkType = RetryScheduler.this.getNetWorkType()) != 0) {
                    Logger.i(RetryScheduler.TAG, "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + RetryScheduler.this.mWaitingRetryTasksCount);
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    synchronized (RetryScheduler.this.mRetryInfoList) {
                        for (int i2 = 0; i2 < RetryScheduler.this.mRetryInfoList.size(); i2++) {
                            RetryInfo retryInfo = (RetryInfo) RetryScheduler.this.mRetryInfoList.valueAt(i2);
                            if (retryInfo != null && retryInfo.canRetry(currentTimeMillis, i2, netWorkType, z)) {
                                if (z) {
                                    retryInfo.resetRetryInterval();
                                }
                                arrayList.add(retryInfo);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            RetryScheduler.this.doSchedulerRetryInSubThread(((RetryInfo) it.next()).id, netWorkType, false);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.RetryScheduler$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ int val$downloadId;

        AnonymousClass3(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                RetryScheduler retryScheduler = RetryScheduler.this;
                retryScheduler.doSchedulerRetryInSubThread(i2, retryScheduler.getNetWorkType(), true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static class RetryInfo {
        final int[] allowErrorCode;
        final int id;
        final int intervalMs;
        final int intervalMsAcceleration;
        final int level;
        private int mCurrentIntervalMs;
        private boolean mIsWaitingRetry;
        private long mLastRetryTime;
        private boolean mNeedWifi;
        private int mRetryCount;
        final int maxCount;
        final boolean useJobScheduler;

        RetryInfo(int i2, int i3, int i4, int i5, int i6, boolean z, int[] iArr) {
            i5 = i5 < 3000 ? 3000 : i5;
            i6 = i6 < 5000 ? 5000 : i6;
            this.id = i2;
            this.level = i3;
            this.maxCount = i4;
            this.intervalMs = i5;
            this.intervalMsAcceleration = i6;
            this.useJobScheduler = z;
            this.allowErrorCode = iArr;
            this.mCurrentIntervalMs = i5;
        }

        boolean canRetry(long j2, int i2, int i3, boolean z) {
            if (!this.mIsWaitingRetry) {
                Logger.i(RetryScheduler.TAG, "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.level < i2 || this.mRetryCount >= this.maxCount) {
                return false;
            }
            if (!this.mNeedWifi || i3 == 2) {
                return z || j2 - this.mLastRetryTime >= ((long) this.intervalMs);
            }
            return false;
        }

        int getCurrentRetryIntervalMs() {
            return this.mCurrentIntervalMs;
        }

        synchronized void increaseRetryCount() {
            this.mRetryCount++;
        }

        synchronized void increaseRetryInterval() {
            this.mCurrentIntervalMs += this.intervalMsAcceleration;
        }

        void resetRetryInterval() {
            this.mCurrentIntervalMs = this.intervalMs;
        }

        synchronized void updateRetryTimeStamp(long j2) {
            this.mLastRetryTime = j2;
        }
    }

    public interface RetryScheduleHandler {
        void cancelRetry(int i2);

        void scheduleRetry(DownloadInfo downloadInfo, long j2, boolean z, int i2);
    }

    private RetryScheduler() {
        registerNetworkCallback();
        this.mIsDownloaderProcess = DownloadUtils.isDownloaderProcess();
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    private boolean canRetryForAllowErrorCode(RetryInfo retryInfo, int i2) {
        int[] iArr = retryInfo.allowErrorCode;
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canRetryWhenInsufficientSpace(DownloadInfo downloadInfo, BaseException baseException) {
        long j2;
        try {
            j2 = DownloadUtils.getAvailableSpaceBytes(downloadInfo.getTempPath());
        } catch (BaseException e2) {
            e2.printStackTrace();
            j2 = 0;
        }
        if (j2 < (baseException instanceof DownloadOutOfSpaceException ? ((DownloadOutOfSpaceException) baseException).getRequiredSpaceBytes() : downloadInfo.getTotalBytes() - downloadInfo.getCurBytes())) {
            DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
            if (obtain.optInt(DownloadSettingKeys.SPACE_FILL_PART_DOWNLOAD, 0) == 1) {
                if (j2 > 0) {
                    int optInt = obtain.optInt(DownloadSettingKeys.SPACE_FILL_MIN_KEEP_MB, 100);
                    if (optInt > 0) {
                        long j3 = j2 - (optInt * 1048576);
                        Logger.i(TAG, "retry schedule: available = " + DownloadUtils.byteToMb(j2) + "MB, minKeep = " + optInt + "MB, canDownload = " + DownloadUtils.byteToMb(j3) + "MB");
                        if (j3 <= 0) {
                            Logger.w(TAG, "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (obtain.optInt(DownloadSettingKeys.DOWNLOAD_WHEN_SPACE_NEGATIVE, 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }

    private RetryInfo createRetryInfo(int i2) {
        int[] iArr;
        int i3;
        int i4;
        boolean z;
        DownloadSetting obtain = DownloadSetting.obtain(i2);
        boolean z2 = false;
        int optInt = obtain.optInt(DownloadSettingKeys.RETRY_SCHEDULE, 0);
        JSONObject optJSONObject = obtain.optJSONObject(DownloadSettingKeys.RETRY_SCHEDULE_CONFIG);
        int i5 = 60;
        if (optJSONObject != null) {
            int optInt2 = optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT, 60);
            int optInt3 = optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC, 60);
            int optInt4 = optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC_ACCELERATION, 60);
            if (Build.VERSION.SDK_INT >= 21 && sRetryScheduleHandler != null && optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.USE_JOB_SCHEDULER, 0) == 1) {
                z2 = true;
            }
            iArr = parserAllowErrorCode(optJSONObject.optString(DownloadSettingKeys.RetryScheduleConfig.ALLOW_ERROR_CODE));
            i3 = optInt4;
            z = z2;
            i4 = optInt2;
            i5 = optInt3;
        } else {
            iArr = null;
            i3 = 60;
            i4 = 60;
            z = false;
        }
        return new RetryInfo(i2, optInt, i4, i5 * 1000, i3 * 1000, z, iArr);
    }

    private void doScheduleAllTaskRetry(int i2, boolean z) {
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.2
            final /* synthetic */ boolean val$force;
            final /* synthetic */ int val$level;

            AnonymousClass2(int i22, boolean z2) {
                i2 = i22;
                z = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int netWorkType;
                try {
                    if (RetryScheduler.this.mWaitingRetryTasksCount > 0 && (netWorkType = RetryScheduler.this.getNetWorkType()) != 0) {
                        Logger.i(RetryScheduler.TAG, "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + RetryScheduler.this.mWaitingRetryTasksCount);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (RetryScheduler.this.mRetryInfoList) {
                            for (int i22 = 0; i22 < RetryScheduler.this.mRetryInfoList.size(); i22++) {
                                RetryInfo retryInfo = (RetryInfo) RetryScheduler.this.mRetryInfoList.valueAt(i22);
                                if (retryInfo != null && retryInfo.canRetry(currentTimeMillis, i2, netWorkType, z)) {
                                    if (z) {
                                        retryInfo.resetRetryInterval();
                                    }
                                    arrayList.add(retryInfo);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                RetryScheduler.this.doSchedulerRetryInSubThread(((RetryInfo) it.next()).id, netWorkType, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void doSchedulerRetryInSubThread(int i2, int i3, boolean z) {
        IReserveWifiStatusListener reserveWifiStatusListener;
        boolean z2;
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        synchronized (this.mRetryInfoList) {
            RetryInfo retryInfo = this.mRetryInfoList.get(i2);
            if (retryInfo == null) {
                return;
            }
            boolean z3 = true;
            if (retryInfo.mIsWaitingRetry) {
                retryInfo.mIsWaitingRetry = false;
                int i4 = this.mWaitingRetryTasksCount - 1;
                this.mWaitingRetryTasksCount = i4;
                if (i4 < 0) {
                    this.mWaitingRetryTasksCount = 0;
                }
            }
            Logger.i(TAG, "doSchedulerRetryInSubThread: downloadId = " + i2 + ", retryCount = " + retryInfo.mRetryCount + ", mWaitingRetryTasksCount = " + this.mWaitingRetryTasksCount);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
            if (downloadInfo == null) {
                removeRetryInfo(i2);
                return;
            }
            Logger.e(TAG, "doSchedulerRetryInSubThread，id:" + i2);
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus == -3 || realStatus == -4) {
                removeRetryInfo(i2);
                return;
            }
            if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
                    reserveWifiStatusListener.onStatusChanged(downloadInfo, 4, 3);
                }
                IDownloadLaunchHandler downloadLaunchHandler = DownloadComponentManager.getDownloadLaunchHandler();
                if (downloadLaunchHandler != null) {
                    downloadLaunchHandler.onLaunchResume(Collections.singletonList(downloadInfo), 3);
                }
                removeRetryInfo(i2);
                return;
            }
            if (realStatus != -1) {
                return;
            }
            if (i3 != 0) {
                z2 = true;
            } else if (!retryInfo.useJobScheduler) {
                return;
            } else {
                z2 = false;
            }
            BaseException failedException = downloadInfo.getFailedException();
            if (z2 && DownloadUtils.isInsufficientSpaceError(failedException)) {
                z2 = canRetryWhenInsufficientSpace(downloadInfo, failedException);
            }
            retryInfo.increaseRetryCount();
            if (!z2) {
                if (z) {
                    retryInfo.increaseRetryInterval();
                }
                if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                    z3 = false;
                }
                tryStartScheduleRetry(downloadInfo, z3, i3);
                return;
            }
            Logger.i(TAG, "doSchedulerRetry: restart task, ****** id = " + retryInfo.id);
            retryInfo.updateRetryTimeStamp(System.currentTimeMillis());
            if (z) {
                retryInfo.increaseRetryInterval();
            }
            downloadInfo.setRetryScheduleCount(retryInfo.mRetryCount);
            if (downloadInfo.getStatus() == -1) {
                Downloader.getInstance(context).restart(downloadInfo.getId());
            }
        }
    }

    public static RetryScheduler getInstance() {
        if (sInstance == null) {
            synchronized (RetryScheduler.class) {
                if (sInstance == null) {
                    sInstance = new RetryScheduler();
                }
            }
        }
        return sInstance;
    }

    public int getNetWorkType() {
        try {
            if (this.mConnectivityManager == null) {
                this.mConnectivityManager = (ConnectivityManager) this.mContext.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private RetryInfo obtainRetryInfo(int i2) {
        RetryInfo retryInfo = this.mRetryInfoList.get(i2);
        if (retryInfo == null) {
            synchronized (this.mRetryInfoList) {
                retryInfo = this.mRetryInfoList.get(i2);
                if (retryInfo == null) {
                    retryInfo = createRetryInfo(i2);
                }
                this.mRetryInfoList.put(i2, retryInfo);
            }
        }
        return retryInfo;
    }

    private int[] parserAllowErrorCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length <= 0) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                iArr[i2] = Integer.parseInt(split[i2]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void registerNetworkCallback() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.USE_NETWORK_CALLBACK, 0) != 1) {
            return;
        }
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.1

            /* renamed from: com.ss.android.socialbase.downloader.impls.RetryScheduler$1$1 */
            class C05121 extends ConnectivityManager.NetworkCallback {
                C05121() {
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    Logger.d(RetryScheduler.TAG, "network onAvailable: ");
                    RetryScheduler.this.scheduleAllTaskRetry(1, true);
                }
            }

            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (RetryScheduler.this.mContext == null || Build.VERSION.SDK_INT < 21) {
                        return;
                    }
                    RetryScheduler retryScheduler = RetryScheduler.this;
                    retryScheduler.mConnectivityManager = (ConnectivityManager) retryScheduler.mContext.getApplicationContext().getSystemService("connectivity");
                    RetryScheduler.this.mConnectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.1.1
                        C05121() {
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            Logger.d(RetryScheduler.TAG, "network onAvailable: ");
                            RetryScheduler.this.scheduleAllTaskRetry(1, true);
                        }
                    });
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private void removeRetryInfo(int i2) {
        synchronized (this.mRetryInfoList) {
            this.mRetryInfoList.remove(i2);
        }
    }

    public void scheduleAllTaskRetry(int i2, boolean z) {
        if (this.mWaitingRetryTasksCount <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (currentTimeMillis - this.mLastHandleAllTaskTime < 10000) {
                    return;
                }
            }
            this.mLastHandleAllTaskTime = currentTimeMillis;
            Logger.i(TAG, "scheduleAllTaskRetry, level = [" + i2 + "], force = [" + z + "]");
            if (z) {
                this.mHandler.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i2;
            obtain.arg2 = z ? 1 : 0;
            this.mHandler.sendMessageDelayed(obtain, 2000L);
        }
    }

    public static void setRetryScheduleHandler(RetryScheduleHandler retryScheduleHandler) {
        sRetryScheduleHandler = retryScheduleHandler;
    }

    public void doSchedulerRetry(int i2) {
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.3
            final /* synthetic */ int val$downloadId;

            AnonymousClass3(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    RetryScheduler retryScheduler = RetryScheduler.this;
                    retryScheduler.doSchedulerRetryInSubThread(i2, retryScheduler.getNetWorkType(), true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            doScheduleAllTaskRetry(message.arg1, message.arg2 == 1);
        } else {
            Logger.i(TAG, "handleMessage, doSchedulerRetry, id = " + message.what);
            doSchedulerRetry(message.what);
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        scheduleAllTaskRetry(3, false);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        scheduleAllTaskRetry(4, false);
    }

    public void scheduleRetryWhenHasTaskConnected() {
        scheduleAllTaskRetry(5, false);
    }

    public void scheduleRetryWhenHasTaskSucceed() {
        scheduleAllTaskRetry(2, true);
    }

    public void tryCancelScheduleRetry(int i2) {
        synchronized (this.mRetryInfoList) {
            RetryInfo retryInfo = this.mRetryInfoList.get(i2);
            if (retryInfo == null) {
                return;
            }
            if (retryInfo.mIsWaitingRetry) {
                retryInfo.mIsWaitingRetry = false;
                int i3 = this.mWaitingRetryTasksCount - 1;
                this.mWaitingRetryTasksCount = i3;
                if (i3 < 0) {
                    this.mWaitingRetryTasksCount = 0;
                }
            }
            if (!retryInfo.useJobScheduler) {
                this.mHandler.removeMessages(i2);
                return;
            }
            RetryScheduleHandler retryScheduleHandler = sRetryScheduleHandler;
            if (retryScheduleHandler != null) {
                retryScheduleHandler.cancelRetry(i2);
            }
        }
    }

    public void tryStartScheduleRetry(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(DownloadConstants.MIME_APK) || !DownloadConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
            return;
        }
        tryStartScheduleRetry(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), getNetWorkType());
    }

    private void tryStartScheduleRetry(DownloadInfo downloadInfo, boolean z, int i2) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        RetryInfo obtainRetryInfo = obtainRetryInfo(downloadInfo.getId());
        if (obtainRetryInfo.mRetryCount > obtainRetryInfo.maxCount) {
            Logger.w(TAG, "tryStartScheduleRetry, id = " + obtainRetryInfo.id + ", mRetryCount = " + obtainRetryInfo.mRetryCount + ", maxCount = " + obtainRetryInfo.maxCount);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!DownloadUtils.isInsufficientSpaceError(failedException) && !DownloadUtils.isNetworkError(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!canRetryForAllowErrorCode(obtainRetryInfo, errorCode)) {
                return;
            }
            Logger.i(TAG, "allow error code, id = " + obtainRetryInfo.id + ", error code = " + errorCode);
        }
        obtainRetryInfo.mNeedWifi = z;
        synchronized (this.mRetryInfoList) {
            if (!obtainRetryInfo.mIsWaitingRetry) {
                obtainRetryInfo.mIsWaitingRetry = true;
                this.mWaitingRetryTasksCount++;
            }
        }
        int currentRetryIntervalMs = obtainRetryInfo.getCurrentRetryIntervalMs();
        Logger.i(TAG, "tryStartScheduleRetry: id = " + obtainRetryInfo.id + ", delayTimeMills = " + currentRetryIntervalMs + ", mWaitingRetryTasks = " + this.mWaitingRetryTasksCount);
        if (!obtainRetryInfo.useJobScheduler) {
            if (z) {
                return;
            }
            this.mHandler.removeMessages(downloadInfo.getId());
            this.mHandler.sendEmptyMessageDelayed(downloadInfo.getId(), currentRetryIntervalMs);
            return;
        }
        if (i2 == 0) {
            obtainRetryInfo.resetRetryInterval();
        }
        RetryScheduleHandler retryScheduleHandler = sRetryScheduleHandler;
        if (retryScheduleHandler != null) {
            retryScheduleHandler.scheduleRetry(downloadInfo, currentRetryIntervalMs, z, i2);
        }
        if (this.mIsDownloaderProcess) {
            obtainRetryInfo.updateRetryTimeStamp(System.currentTimeMillis());
            obtainRetryInfo.increaseRetryCount();
            obtainRetryInfo.increaseRetryInterval();
        }
    }
}
