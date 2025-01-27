package com.ss.android.socialbase.downloader.downloader;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.BoundType;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultChunkAdjustCalculator;
import com.ss.android.socialbase.downloader.impls.DefaultChunkCntCalculator;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadHeadHttpService;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadServiceHandler;
import com.ss.android.socialbase.downloader.impls.DefaultIdGenerator;
import com.ss.android.socialbase.downloader.impls.DefaultRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import com.ss.android.socialbase.downloader.network.IDownloadDns;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DownloadComponentManager {
    public static final int NET_LIB_DEFAULT = 0;
    public static final int NET_LIB_HOST = 1;
    private static volatile Context appContext;
    private static volatile IChunkAdjustCalculator chunkAdjustCalculator;
    private static volatile IChunkCntCalculator chunkCntCalculator;
    private static volatile ExecutorService chunkDownloadExecutor;
    private static volatile ExecutorService cpuThreadExecutor;
    private static volatile ExecutorService dbThreadExecutor;
    private static volatile IDownloadDns defaultDownloadDns;
    private static volatile IDownloadHeadHttpService defaultHeadHttpService;
    private static volatile IDownloadHttpService defaultHttpService;
    private static volatile IDownloadCache downloadCache;
    private static final List<IDownloadCacheSyncStatusListener> downloadCacheSyncStatusListeners;
    private static volatile IDownloadDns downloadDns;
    private static volatile AbsDownloadEngine downloadEngine;
    private static InnerEventListener downloadEventListener;
    private static int downloadExpSwitchCode;
    private static volatile IDownloadLaunchHandler downloadLaunchHandler;
    private static volatile IDownloadMonitorListener downloadMonitorListener;
    private static volatile DownloadReceiver downloadReceiver;
    private static volatile IDownloadServiceHandler downloadServiceHandler;
    private static volatile IDownloadSettings downloadSettings;
    private static final List<IDownloadTaskExecuteListener> downloadTaskExecuteListeners;
    private static final int fixedCPUPoolSize;
    private static final int fixedDBPoolSize;
    private static final int fixedIOPoolSize;
    private static final int fixedMIXPoolSize;
    private static volatile boolean hasInit;
    private static volatile IDownloadHeadHttpService headHttpService;
    private static volatile IDownloadHttpService httpService;
    private static boolean httpServiceInit;
    private static volatile ITTNetHandler iTTNetHandler;
    private static volatile IDownloadIdGenerator idGenerator;
    private static volatile IDownloadServiceHandler independentDownloadServiceHandler;
    private static volatile IndependentHolderCreator independentHolderCreator;
    private static volatile ExecutorService ioThreadExecutor;
    private static int maxDownloadPoolSize;
    private static volatile ExecutorService mixApkDownloadExecutor;
    private static volatile ExecutorService mixDefaultDownloadExecutor;
    private static volatile ExecutorService mixFrequentDownloadExecutor;
    private static volatile IMonitorConfig monitorConfig;
    private static boolean needAutoRefreshUnSuccessTask;
    private static boolean notAutoRebootService;
    private static volatile INotificationClickCallback notificationClickCallback;
    private static volatile ExecutorService okHttpDispatcherExecutor;
    private static IReserveWifiStatusListener reserveWifiStatusListener;
    private static volatile IRetryDelayTimeCalculator retryDelayTimeCalculator;
    private static volatile ScheduledExecutorService scheduledExecutor;
    private static int writeBufferSize;
    private static volatile List<ProcessCallback> processCallbacks = new ArrayList();
    private static volatile boolean downloadInMultiProcess = false;
    private static volatile OkHttpClient sOkHttpClient = null;
    private static final List<IDownloadCompleteHandler> downloadCompleteHandlers = new ArrayList();
    private static boolean isReceiverRegistered = false;

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager$1 */
    public static class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Context appContext = DownloadComponentManager.getAppContext();
            if (appContext != null) {
                DownloadUtils.getCurProcessName(appContext);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager$2 */
    public static class AnonymousClass2 implements IDownloadDns {
        @Override // com.ss.android.socialbase.downloader.network.IDownloadDns
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            return Dns.SYSTEM.lookup(str);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager$3 */
    public static class AnonymousClass3 implements InnerEventListener {
        @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
        public void onEvent(int i10, String str, JSONObject jSONObject) {
        }

        @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
        public void onUnityEvent(int i10, String str, JSONObject jSONObject) {
        }
    }

    public interface IndependentHolderCreator {

        public interface OnMainProcessRebindErrorListener {
            void onRebindError();
        }

        ISqlDownloadCache createCache(OnMainProcessRebindErrorListener onMainProcessRebindErrorListener);

        IDownloadProxy createProxy();

        IDownloadServiceHandler createServiceHandler();
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        fixedCPUPoolSize = availableProcessors;
        fixedIOPoolSize = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        fixedMIXPoolSize = availableProcessors;
        fixedDBPoolSize = availableProcessors;
        writeBufferSize = 8192;
        downloadCacheSyncStatusListeners = new ArrayList();
        downloadTaskExecuteListeners = new ArrayList();
        needAutoRefreshUnSuccessTask = true;
        notAutoRebootService = false;
        hasInit = false;
    }

    private DownloadComponentManager() {
    }

    public static void addDownloadCompleteHandler(IDownloadCompleteHandler iDownloadCompleteHandler) {
        List<IDownloadCompleteHandler> list = downloadCompleteHandlers;
        synchronized (list) {
            if (iDownloadCompleteHandler != null) {
                try {
                    if (!list.contains(iDownloadCompleteHandler)) {
                        list.add(iDownloadCompleteHandler);
                    }
                } finally {
                }
            }
        }
    }

    public static void addProcessCallback(ProcessCallback processCallback) {
        if (processCallback == null) {
            return;
        }
        synchronized (processCallbacks) {
            processCallbacks.add(processCallback);
        }
    }

    public static synchronized void coverComponent(DownloaderBuilder downloaderBuilder) {
        synchronized (DownloadComponentManager.class) {
            setDownloadBuilder(downloaderBuilder);
        }
    }

    public static OkHttpClient.Builder createDownloadClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(30000L, timeUnit).readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (okHttpDispatcherExecutor != null) {
            builder.dispatcher(new Dispatcher(okHttpDispatcherExecutor));
        }
        return builder;
    }

    public static IDownloadHttpConnection downloadWithConnection(boolean z10, int i10, String str, List<HttpHeader> list) throws Exception {
        return downloadWithConnection(z10, i10, str, null, list, 0, false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.network.IDownloadHttpConnection downloadWithConnection2(int r10, java.lang.String r11, java.lang.String r12, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> r13, int r14, boolean r15, com.ss.android.socialbase.downloader.model.DownloadInfo r16) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r7 = r14
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = getHttpService()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = getDefaultHttpService()
        Ld:
            if (r0 == 0) goto L58
            r8 = 0
            r1 = 0
            if (r15 == 0) goto L18
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L1f
        L18:
            r3 = r10
            r4 = r11
            r5 = r13
            goto L23
        L1c:
            r0 = move-exception
            r4 = r11
            goto L43
        L1f:
            r0 = move-exception
            r4 = r11
        L21:
            r3 = r0
            goto L40
        L23:
            com.ss.android.socialbase.downloader.network.IDownloadHttpConnection r0 = r0.downloadWithConnection(r10, r11, r13)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            if (r15 == 0) goto L3b
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r1
            java.lang.String r9 = "get"
            r1 = r0
            r2 = r11
            r3 = r12
            r4 = r5
            r6 = r9
            r7 = r14
            r9 = r16
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(r1, r2, r3, r4, r6, r7, r8, r9)
        L3b:
            return r0
        L3c:
            r0 = move-exception
            goto L43
        L3e:
            r0 = move-exception
            goto L21
        L40:
            throw r3     // Catch: java.lang.Throwable -> L41
        L41:
            r0 = move-exception
            r8 = r3
        L43:
            if (r15 == 0) goto L57
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r1
            java.lang.String r9 = "get"
            r1 = 0
            r2 = r11
            r3 = r12
            r4 = r5
            r6 = r9
            r7 = r14
            r9 = r16
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(r1, r2, r3, r4, r6, r7, r8, r9)
        L57:
            throw r0
        L58:
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "httpService not exist, netLib = "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = 1022(0x3fe, float:1.432E-42)
            r0.<init>(r2, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadWithConnection2(int, java.lang.String, java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.IDownloadHttpConnection");
    }

    public static IDownloadHeadHttpConnection downloadWithHeadConnection(String str, List<HttpHeader> list) throws Exception {
        return downloadWithHeadConnection(str, list, 0, false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection downloadWithHeadConnection2(java.lang.String r10, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> r11, int r12, boolean r13, com.ss.android.socialbase.downloader.model.DownloadInfo r14) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r0 = 1
            if (r12 != r0) goto L8
            com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService r0 = getHeadHttpService()
            goto Lc
        L8:
            com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService r0 = getDefaultHeadHttpService()
        Lc:
            if (r0 == 0) goto L4a
            r8 = 0
            r1 = 0
            if (r13 == 0) goto L1d
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L18 java.io.IOException -> L1a
            goto L1d
        L18:
            r0 = move-exception
            goto L37
        L1a:
            r0 = move-exception
            r4 = r0
            goto L34
        L1d:
            com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection r0 = r0.downloadWithConnection(r10, r11)     // Catch: java.lang.Throwable -> L18 java.io.IOException -> L1a
            if (r13 == 0) goto L33
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r1
            java.lang.String r6 = "head"
            r9 = 0
            r1 = r0
            r2 = r10
            r3 = r9
            r7 = r12
            r9 = r14
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(r1, r2, r3, r4, r6, r7, r8, r9)
        L33:
            return r0
        L34:
            throw r4     // Catch: java.lang.Throwable -> L35
        L35:
            r0 = move-exception
            r8 = r4
        L37:
            if (r13 == 0) goto L49
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r1
            java.lang.String r6 = "head"
            r1 = 0
            r9 = 0
            r2 = r10
            r3 = r9
            r7 = r12
            r9 = r14
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(r1, r2, r3, r4, r6, r7, r8, r9)
        L49:
            throw r0
        L4a:
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "httpService not exist, netLib = "
            r2.append(r3)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = 1022(0x3fe, float:1.432E-42)
            r0.<init>(r2, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadWithHeadConnection2(java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection");
    }

    public static void ensureOPPO() {
        if (TextUtils.isEmpty(DownloadConstants.LOWER_OPPO)) {
            DownloadConstants.LOWER_OPPO = "oppo";
            DownloadConstants.UPPER_OPPO = DownloadConstants.LOWER_OPPO.toUpperCase();
        }
    }

    public static AlarmManager getAlarmManager() {
        return null;
    }

    public static synchronized Context getAppContext() {
        Context context;
        synchronized (DownloadComponentManager.class) {
            context = appContext;
        }
        return context;
    }

    public static ExecutorService getCPUThreadExecutor() {
        if (cpuThreadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (cpuThreadExecutor == null) {
                        int i10 = fixedCPUPoolSize;
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i10, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-cpu-fixed", true));
                        try {
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        cpuThreadExecutor = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return cpuThreadExecutor;
    }

    public static IChunkAdjustCalculator getChunkAdjustCalculator() {
        if (chunkAdjustCalculator == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (chunkAdjustCalculator == null) {
                        chunkAdjustCalculator = new DefaultChunkAdjustCalculator();
                    }
                } finally {
                }
            }
        }
        return chunkAdjustCalculator;
    }

    public static IChunkCntCalculator getChunkCntCalculator() {
        if (chunkCntCalculator == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (chunkCntCalculator == null) {
                        chunkCntCalculator = new DefaultChunkCntCalculator();
                    }
                } finally {
                }
            }
        }
        return chunkCntCalculator;
    }

    public static ExecutorService getChunkDownloadThreadExecutorService() {
        if (chunkDownloadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (chunkDownloadExecutor == null) {
                        int i10 = fixedIOPoolSize;
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i10, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-chunk-fixed", true));
                        try {
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        chunkDownloadExecutor = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return chunkDownloadExecutor;
    }

    public static ExecutorService getDBThreadExecutorService() {
        if (dbThreadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (dbThreadExecutor == null) {
                        int i10 = fixedDBPoolSize;
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i10, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-db-fixed", true));
                        try {
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        dbThreadExecutor = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return dbThreadExecutor;
    }

    public static IDownloadDns getDefaultDownloadDns() {
        if (defaultDownloadDns == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (defaultDownloadDns == null) {
                        defaultDownloadDns = new IDownloadDns() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.2
                            @Override // com.ss.android.socialbase.downloader.network.IDownloadDns
                            public List<InetAddress> lookup(String str) throws UnknownHostException {
                                return Dns.SYSTEM.lookup(str);
                            }
                        };
                    }
                } finally {
                }
            }
        }
        return defaultDownloadDns;
    }

    public static IDownloadHeadHttpService getDefaultHeadHttpService() {
        if (defaultHeadHttpService == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (defaultHeadHttpService == null) {
                        defaultHeadHttpService = new DefaultDownloadHeadHttpService();
                    }
                } finally {
                }
            }
        }
        return defaultHeadHttpService;
    }

    public static IDownloadHttpService getDefaultHttpService() {
        if (defaultHttpService == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (defaultHttpService == null) {
                        defaultHttpService = new DefaultDownloadHttpService();
                    }
                } finally {
                }
            }
        }
        return defaultHttpService;
    }

    public static IDownloadCache getDownloadCache() {
        if (downloadCache == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (downloadCache == null) {
                        downloadCache = new DefaultDownloadCache();
                    }
                } finally {
                }
            }
        }
        return downloadCache;
    }

    public static OkHttpClient getDownloadClient() {
        if (sOkHttpClient == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (sOkHttpClient == null) {
                        sOkHttpClient = createDownloadClientBuilder().build();
                    }
                } finally {
                }
            }
        }
        return sOkHttpClient;
    }

    public static List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return downloadCompleteHandlers;
    }

    public static IDownloadDns getDownloadDns() {
        return downloadDns;
    }

    public static AbsDownloadEngine getDownloadEngine() {
        if (downloadEngine == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (downloadEngine == null) {
                        downloadEngine = new DefaultDownloadEngine();
                    }
                } finally {
                }
            }
        }
        return downloadEngine;
    }

    public static int getDownloadExpSwitchCode() {
        return downloadExpSwitchCode;
    }

    public static int getDownloadId(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        String taskKey = downloadInfo.getTaskKey();
        if (TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return getDownloadId(taskKey, downloadInfo.getSavePath());
    }

    public static synchronized IDownloadLaunchHandler getDownloadLaunchHandler() {
        IDownloadLaunchHandler iDownloadLaunchHandler;
        synchronized (DownloadComponentManager.class) {
            iDownloadLaunchHandler = downloadLaunchHandler;
        }
        return iDownloadLaunchHandler;
    }

    public static IDownloadMonitorListener getDownloadMonitorListener() {
        return downloadMonitorListener;
    }

    private static int[] getDownloadNetLibs(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    public static IDownloadServiceHandler getDownloadServiceHandler() {
        if (downloadServiceHandler == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (downloadServiceHandler == null) {
                        downloadServiceHandler = new DefaultDownloadServiceHandler();
                    }
                } finally {
                }
            }
        }
        return downloadServiceHandler;
    }

    @NonNull
    public static JSONObject getDownloadSetting() {
        return (downloadSettings == null || downloadSettings.get() == null) ? DownloadConstants.EMPTY_JSON : downloadSettings.get();
    }

    @NonNull
    public static InnerEventListener getEventListener() {
        if (downloadEventListener == null) {
            downloadEventListener = new InnerEventListener() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.3
                @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
                public void onEvent(int i10, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
                public void onUnityEvent(int i10, String str, JSONObject jSONObject) {
                }
            };
        }
        return downloadEventListener;
    }

    public static IDownloadHeadHttpService getHeadHttpService() {
        return headHttpService;
    }

    public static IDownloadHttpService getHttpService() {
        return httpService;
    }

    public static ExecutorService getIOThreadExecutor() {
        return ioThreadExecutor != null ? ioThreadExecutor : getCPUThreadExecutor();
    }

    public static IDownloadIdGenerator getIdGenerator() {
        if (idGenerator == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (idGenerator == null) {
                        idGenerator = new DefaultIdGenerator();
                    }
                } finally {
                }
            }
        }
        return idGenerator;
    }

    public static IDownloadServiceHandler getIndependentDownloadServiceHandler() {
        if (independentDownloadServiceHandler == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (independentDownloadServiceHandler == null) {
                        independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();
                    }
                } finally {
                }
            }
        }
        return independentDownloadServiceHandler;
    }

    public static IndependentHolderCreator getIndependentHolderCreator() {
        return independentHolderCreator;
    }

    private static int getMaxDownloadPoolSize() {
        int i10 = maxDownloadPoolSize;
        if (i10 <= 0 || i10 > fixedCPUPoolSize) {
            maxDownloadPoolSize = fixedCPUPoolSize;
        }
        return maxDownloadPoolSize;
    }

    public static ExecutorService getMixApkThreadExecutor() {
        return mixApkDownloadExecutor != null ? mixApkDownloadExecutor : getMixDefaultThreadExecutor();
    }

    public static ExecutorService getMixDefaultThreadExecutor() {
        if (mixDefaultDownloadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (mixDefaultDownloadExecutor == null) {
                        int i10 = fixedMIXPoolSize;
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i10, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-mix-fixed", true));
                        try {
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        mixDefaultDownloadExecutor = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return mixDefaultDownloadExecutor;
    }

    public static ExecutorService getMixFrequentThreadExecutor() {
        return mixFrequentDownloadExecutor != null ? mixFrequentDownloadExecutor : getMixDefaultThreadExecutor();
    }

    public static synchronized IMonitorConfig getMonitorConfig() {
        IMonitorConfig iMonitorConfig;
        synchronized (DownloadComponentManager.class) {
            iMonitorConfig = monitorConfig;
        }
        return iMonitorConfig;
    }

    public static INotificationClickCallback getNotificationClickCallback() {
        return notificationClickCallback;
    }

    public static List<ProcessCallback> getProcessCallbacks() {
        List<ProcessCallback> list;
        synchronized (processCallbacks) {
            list = processCallbacks;
        }
        return list;
    }

    public static IReserveWifiStatusListener getReserveWifiStatusListener() {
        return reserveWifiStatusListener;
    }

    public static IRetryDelayTimeCalculator getRetryDelayTimeCalculator() {
        if (retryDelayTimeCalculator == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (retryDelayTimeCalculator == null) {
                        retryDelayTimeCalculator = new DefaultRetryDelayTimeCalculator();
                    }
                } finally {
                }
            }
        }
        return retryDelayTimeCalculator;
    }

    public static ScheduledExecutorService getScheduledExecutorService() {
        if (scheduledExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (scheduledExecutor == null) {
                        scheduledExecutor = new ScheduledThreadPoolExecutor(1, new DefaultThreadFactory("DownloadThreadPool-Schedule", true));
                    }
                } finally {
                }
            }
        }
        return scheduledExecutor;
    }

    public static ITTNetHandler getTTNetHandler() {
        if (iTTNetHandler == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (iTTNetHandler == null) {
                        iTTNetHandler = new ITTNetHandler.DefaultTTNetHandler();
                    }
                } finally {
                }
            }
        }
        return iTTNetHandler;
    }

    public static synchronized int getWriteBufferSize() {
        int i10;
        synchronized (DownloadComponentManager.class) {
            i10 = writeBufferSize;
        }
        return i10;
    }

    public static synchronized void initComponent(DownloaderBuilder downloaderBuilder) {
        synchronized (DownloadComponentManager.class) {
            if (hasInit) {
                Logger.e("DownloadComponentManager", "component has init");
                return;
            }
            boolean z10 = downloadInMultiProcess;
            setDownloadBuilder(downloaderBuilder);
            if (downloadCache == null) {
                downloadCache = new DefaultDownloadCache();
            }
            if (downloadServiceHandler == null) {
                downloadServiceHandler = new DefaultDownloadServiceHandler();
            }
            if (independentDownloadServiceHandler == null && independentHolderCreator != null) {
                independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();
            }
            if (idGenerator == null) {
                idGenerator = new DefaultIdGenerator();
            }
            if (downloadEngine == null) {
                downloadEngine = new DefaultDownloadEngine();
            }
            if (chunkCntCalculator == null) {
                chunkCntCalculator = new DefaultChunkCntCalculator();
            }
            if (chunkAdjustCalculator == null) {
                chunkAdjustCalculator = new DefaultChunkAdjustCalculator();
            }
            if (retryDelayTimeCalculator == null) {
                retryDelayTimeCalculator = new DefaultRetryDelayTimeCalculator();
            }
            int i10 = maxDownloadPoolSize;
            if (i10 <= 0 || i10 > fixedCPUPoolSize) {
                maxDownloadPoolSize = fixedCPUPoolSize;
            }
            registerDownloadReceiver();
            if (downloadInMultiProcess && !z10 && !DownloadUtils.isDownloaderProcess()) {
                DownloadProxy.get(true).startService();
            } else if (DownloadUtils.isMainThread()) {
                ExecutorService iOThreadExecutor = getIOThreadExecutor();
                if (iOThreadExecutor != null) {
                    iOThreadExecutor.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context appContext2 = DownloadComponentManager.getAppContext();
                            if (appContext2 != null) {
                                DownloadUtils.getCurProcessName(appContext2);
                            }
                        }
                    });
                }
            } else {
                Context appContext2 = getAppContext();
                if (appContext2 != null) {
                    DownloadUtils.getCurProcessName(appContext2);
                }
            }
            ensureOPPO();
            hasInit = true;
        }
    }

    public static synchronized boolean isDownloadInMultiProcess() {
        boolean z10;
        synchronized (DownloadComponentManager.class) {
            z10 = downloadInMultiProcess;
        }
        return z10;
    }

    public static synchronized boolean isHttpServiceInit() {
        boolean z10;
        synchronized (DownloadComponentManager.class) {
            z10 = httpServiceInit;
        }
        return z10;
    }

    public static boolean isInit() {
        return hasInit;
    }

    private static void needAutoRefreshUnSuccessTask(boolean z10) {
        needAutoRefreshUnSuccessTask = z10;
    }

    public static boolean notAutoRebootService() {
        return DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.BugFix.NOT_AUTO_BOOT_SERVICE, notAutoRebootService ? 1 : 0) > 0;
    }

    public static void onDownloadCacheSyncCallback(DownloadCacheSyncStatus downloadCacheSyncStatus) {
        List<IDownloadCacheSyncStatusListener> list = downloadCacheSyncStatusListeners;
        synchronized (list) {
            try {
                for (IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener : list) {
                    if (iDownloadCacheSyncStatusListener != null) {
                        if (downloadCacheSyncStatus == DownloadCacheSyncStatus.SYNC_START) {
                            iDownloadCacheSyncStatusListener.onStart();
                        } else if (downloadCacheSyncStatus == DownloadCacheSyncStatus.SYNC_SUCCESS) {
                            iDownloadCacheSyncStatusListener.onSuccess();
                        }
                    }
                }
                if (downloadCacheSyncStatus == DownloadCacheSyncStatus.SYNC_SUCCESS) {
                    downloadCacheSyncStatusListeners.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void onDownloadTaskFinish(DownloadTask downloadTask, @BoundType int i10) {
        List<IDownloadTaskExecuteListener> list = downloadTaskExecuteListeners;
        synchronized (list) {
            try {
                for (IDownloadTaskExecuteListener iDownloadTaskExecuteListener : list) {
                    if (iDownloadTaskExecuteListener != null) {
                        iDownloadTaskExecuteListener.onFinish(downloadTask, i10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void onDownloadTaskStart(DownloadTask downloadTask, @BoundType int i10) {
        List<IDownloadTaskExecuteListener> list = downloadTaskExecuteListeners;
        synchronized (list) {
            try {
                for (IDownloadTaskExecuteListener iDownloadTaskExecuteListener : list) {
                    if (iDownloadTaskExecuteListener != null) {
                        iDownloadTaskExecuteListener.onStart(downloadTask, i10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        List<IDownloadCacheSyncStatusListener> list = downloadCacheSyncStatusListeners;
        synchronized (list) {
            if (iDownloadCacheSyncStatusListener != null) {
                try {
                    if (!list.contains(iDownloadCacheSyncStatusListener)) {
                        list.add(iDownloadCacheSyncStatusListener);
                    }
                } finally {
                }
            }
        }
    }

    private static void registerDownloadReceiver() {
        if (downloadReceiver == null) {
            downloadReceiver = new DownloadReceiver();
        }
        if (isReceiverRegistered) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            appContext.registerReceiver(downloadReceiver, intentFilter);
            isReceiverRegistered = true;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void registerDownloadTaskExecuteListener(IDownloadTaskExecuteListener iDownloadTaskExecuteListener) {
        List<IDownloadTaskExecuteListener> list = downloadTaskExecuteListeners;
        synchronized (list) {
            if (iDownloadTaskExecuteListener != null) {
                try {
                    if (!list.contains(iDownloadTaskExecuteListener)) {
                        list.add(iDownloadTaskExecuteListener);
                    }
                } finally {
                }
            }
        }
    }

    public static void removeDownloadCompleteHandler(IDownloadCompleteHandler iDownloadCompleteHandler) {
        List<IDownloadCompleteHandler> list = downloadCompleteHandlers;
        synchronized (list) {
            if (iDownloadCompleteHandler != null) {
                try {
                    if (list.contains(iDownloadCompleteHandler)) {
                        list.remove(iDownloadCompleteHandler);
                    }
                } finally {
                }
            }
        }
    }

    public static synchronized void setAppContext(Context context) {
        synchronized (DownloadComponentManager.class) {
            if (context != null) {
                if (appContext == null) {
                    appContext = context.getApplicationContext();
                    AppStatusManager.getInstance().init(appContext);
                }
            }
        }
    }

    private static void setCPUThreadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            cpuThreadExecutor = executorService;
        }
    }

    private static void setChunkAdjustCalculator(IChunkAdjustCalculator iChunkAdjustCalculator) {
        if (iChunkAdjustCalculator != null) {
            chunkAdjustCalculator = iChunkAdjustCalculator;
        }
    }

    private static void setChunkCntCalculator(IChunkCntCalculator iChunkCntCalculator) {
        if (iChunkCntCalculator != null) {
            chunkCntCalculator = iChunkCntCalculator;
        }
    }

    public static void setChunkDownloadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            chunkDownloadExecutor = executorService;
        }
    }

    private static void setDBThreadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            dbThreadExecutor = executorService;
        }
    }

    private static void setDownloadBuilder(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                setAppContext(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                setDownloadCache(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                setIdGenerator(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                setChunkCntCalculator(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                setNotificationClickCallback(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                setMaxDownloadPoolSize(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                setHttpService(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                setHeadHttpService(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                setDownloadLaunchHandler(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                setCPUThreadExecutor(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                setIOThreadExecutor(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                setMixDefaultDownloadExecutor(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                setMixFrequentDownloadExecutor(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                setMixApkDownloadExecutor(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                setDBThreadExecutor(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                setChunkDownloadExecutor(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                setOkHttpDispatcherExecutor(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                setDownloadCompleteHandlers(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                monitorConfig = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                writeBufferSize = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                setChunkAdjustCalculator(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                downloadInMultiProcess = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                downloadExpSwitchCode = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                setDownloadSetting(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                downloadDns = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                iTTNetHandler = downloaderBuilder.getTTNetHandler();
                if (iTTNetHandler.isTTNetEnable()) {
                    setHttpService(iTTNetHandler.getTTNetDownloadHttpService());
                    setHeadHttpService(iTTNetHandler.getTTNetDownloadHeadHttpService());
                } else {
                    setHttpService(getDefaultHttpService());
                    setHeadHttpService(getDefaultHeadHttpService());
                }
            }
            needAutoRefreshUnSuccessTask(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                setDownloadMonitorListener(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    private static void setDownloadCache(IDownloadCache iDownloadCache) {
        if (iDownloadCache != null) {
            downloadCache = iDownloadCache;
        }
    }

    private static void setDownloadCompleteHandlers(List<IDownloadCompleteHandler> list) {
        List<IDownloadCompleteHandler> list2 = downloadCompleteHandlers;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void setDownloadEventListener(InnerEventListener innerEventListener) {
        downloadEventListener = innerEventListener;
    }

    public static synchronized void setDownloadInMultiProcess() {
        synchronized (DownloadComponentManager.class) {
            if (downloadInMultiProcess) {
                return;
            }
            downloadInMultiProcess = true;
            try {
                Intent intent = new Intent(getAppContext(), (Class<?>) DownloadHandleService.class);
                intent.setAction(DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY);
                getAppContext().startService(intent);
                if (!DownloadUtils.isDownloaderProcess()) {
                    DownloadProxy.get(true).startService();
                }
            } catch (Throwable th2) {
                downloadInMultiProcess = false;
                th2.printStackTrace();
            }
        }
    }

    public static synchronized void setDownloadLaunchHandler(IDownloadLaunchHandler iDownloadLaunchHandler) {
        synchronized (DownloadComponentManager.class) {
            if (iDownloadLaunchHandler != null) {
                downloadLaunchHandler = iDownloadLaunchHandler;
                if (downloadCache instanceof DefaultDownloadCache) {
                    ((DefaultDownloadCache) downloadCache).resumeUnCompleteTaskMayDelayed();
                }
            }
        }
    }

    private static void setDownloadMonitorListener(IDownloadMonitorListener iDownloadMonitorListener) {
        if (iDownloadMonitorListener != null) {
            downloadMonitorListener = iDownloadMonitorListener;
        }
    }

    public static void setDownloadSetting(IDownloadSettings iDownloadSettings) {
        downloadSettings = iDownloadSettings;
        DownloadSetting.init();
    }

    public static void setHeadHttpService(IDownloadHeadHttpService iDownloadHeadHttpService) {
        if (iDownloadHeadHttpService != null) {
            headHttpService = iDownloadHeadHttpService;
        }
    }

    public static void setHttpService(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            httpService = iDownloadHttpService;
        }
        httpServiceInit = httpService != null;
    }

    private static void setIOThreadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            ioThreadExecutor = executorService;
        }
    }

    private static void setIdGenerator(IDownloadIdGenerator iDownloadIdGenerator) {
        if (iDownloadIdGenerator != null) {
            idGenerator = iDownloadIdGenerator;
        }
    }

    public static void setIndependentServiceCreator(IndependentHolderCreator independentHolderCreator2) {
        Logger.v("wjd", "setIndependentServiceCreator::creator=" + independentHolderCreator2);
        independentHolderCreator = independentHolderCreator2;
    }

    private static void setMaxDownloadPoolSize(int i10) {
        if (i10 > 0) {
            maxDownloadPoolSize = i10;
        }
    }

    private static void setMixApkDownloadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            mixApkDownloadExecutor = executorService;
        }
    }

    private static void setMixDefaultDownloadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            mixDefaultDownloadExecutor = executorService;
        }
    }

    private static void setMixFrequentDownloadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            mixFrequentDownloadExecutor = executorService;
        }
    }

    public static void setNotAutoRebootService(boolean z10) {
        notAutoRebootService = z10;
    }

    public static void setNotificationClickCallback(INotificationClickCallback iNotificationClickCallback) {
        if (iNotificationClickCallback != null) {
            notificationClickCallback = iNotificationClickCallback;
        }
    }

    public static void setOkHttpDispatcherExecutor(ExecutorService executorService) {
        if (executorService != null) {
            okHttpDispatcherExecutor = executorService;
        }
    }

    public static void setReserveWifiStatusListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
    }

    public static void submitCPUTask(Runnable runnable) {
        submitCPUTask(runnable, false);
    }

    public static void submitDBTask(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (DownloadUtils.isMainThread()) {
            getDBThreadExecutorService().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void submitIOTask(Runnable runnable) {
        submitIOTask(runnable, false);
    }

    public static Future submitScheduleTask(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return getScheduledExecutorService().schedule(runnable, j10, timeUnit);
    }

    public static boolean supportMultiProc() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("supportMultiProc::=");
        sb2.append(independentHolderCreator != null);
        Logger.v("wjd", sb2.toString());
        return independentHolderCreator != null;
    }

    public static void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        List<IDownloadCacheSyncStatusListener> list = downloadCacheSyncStatusListeners;
        synchronized (list) {
            if (iDownloadCacheSyncStatusListener != null) {
                try {
                    if (list.contains(iDownloadCacheSyncStatusListener)) {
                        list.remove(iDownloadCacheSyncStatusListener);
                    }
                } finally {
                }
            }
        }
    }

    public static synchronized void unRegisterDownloadReceiver() {
        synchronized (DownloadComponentManager.class) {
            try {
                if (isReceiverRegistered && downloadReceiver != null && appContext != null) {
                    appContext.unregisterReceiver(downloadReceiver);
                    isReceiverRegistered = false;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void unRegisterDownloadTaskExecuteListener(IDownloadTaskExecuteListener iDownloadTaskExecuteListener) {
        List<IDownloadTaskExecuteListener> list = downloadTaskExecuteListeners;
        synchronized (list) {
            if (iDownloadTaskExecuteListener != null) {
                try {
                    if (list.contains(iDownloadTaskExecuteListener)) {
                        list.remove(iDownloadTaskExecuteListener);
                    }
                } finally {
                }
            }
        }
    }

    public static IDownloadHttpConnection downloadWithConnection(boolean z10, int i10, String str, String str2, List<HttpHeader> list, int i11, boolean z11, DownloadInfo downloadInfo) throws Exception {
        List<HttpHeader> list2;
        int i12;
        IDownloadHttpConnection downloadWithConnection2;
        if (!TextUtils.isEmpty(str2)) {
            List<HttpHeader> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new HttpHeader(DownloadConstants.EXTRA_REQUEST_HOST_IP, str2));
            list2 = arrayList;
            i12 = 1;
        } else if (z10) {
            list2 = list;
            i12 = i11;
        } else {
            i12 = 2;
            list2 = list;
        }
        int[] downloadNetLibs = getDownloadNetLibs(i12);
        Exception exc = null;
        for (int i13 : downloadNetLibs) {
            try {
                downloadWithConnection2 = downloadWithConnection2(i10, str, str2, list2, i13, z11, downloadInfo);
            } catch (Exception e10) {
                if (downloadInfo.isExpiredRedownload() && DownloadUtils.isResponseCode304Error(e10) && DownloadUtils.hasDownloadCacheHeader(list2)) {
                    Logger.d("dcach::http exception 304, throw excepiton, not retry " + e10);
                    throw e10;
                }
                exc = e10;
            }
            if (downloadWithConnection2 != null) {
                return downloadWithConnection2;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    public static IDownloadHeadHttpConnection downloadWithHeadConnection(String str, List<HttpHeader> list, int i10, boolean z10, DownloadInfo downloadInfo) throws Exception {
        IDownloadHeadHttpConnection downloadWithHeadConnection2;
        Exception e10 = null;
        for (int i11 : getDownloadNetLibs(i10)) {
            try {
                downloadWithHeadConnection2 = downloadWithHeadConnection2(str, list, i11, z10, downloadInfo);
            } catch (Exception e11) {
                e10 = e11;
            }
            if (downloadWithHeadConnection2 != null) {
                return downloadWithHeadConnection2;
            }
        }
        if (e10 == null) {
            return null;
        }
        throw e10;
    }

    public static boolean needAutoRefreshUnSuccessTask() {
        return needAutoRefreshUnSuccessTask;
    }

    public static void submitCPUTask(Runnable runnable, boolean z10) {
        if (runnable == null) {
            return;
        }
        if (!z10 || DownloadUtils.isMainThread()) {
            getCPUThreadExecutor().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void submitIOTask(Runnable runnable, boolean z10) {
        if (runnable == null) {
            return;
        }
        if (!z10 || DownloadUtils.isMainThread()) {
            getIOThreadExecutor().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static int getDownloadId(String str, String str2) {
        IDownloadIdGenerator idGenerator2 = getIdGenerator();
        if (idGenerator2 == null) {
            return 0;
        }
        return idGenerator2.generate(str, str2);
    }
}
