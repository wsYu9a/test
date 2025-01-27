package com.ss.android.socialbase.downloader.network.connectionpool;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.alipay.mobilesecuritysdk.constant.a;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class DownloadPreconnecter {
    private static final long DEFAULT_CONNECTION_OUTDATE_TIME = 300000;
    private static final long DEFAULT_HEAD_INFO_OUTDATE_TIME = 300000;
    private static Runnable sCancelRunnable;
    static long sConnectionOutdatedTime;
    private static final Handler sHandler;
    static long sHeadInfoOutdatedTime;
    private static final HandlerThread sPreconnectThread;

    /* renamed from: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter$1 */
    static class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.setThreadPriority(10);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ IFetchHttpHeadInfoListener val$listener;
        final /* synthetic */ String val$url;

        AnonymousClass2(String str, IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener) {
            str = str;
            iFetchHttpHeadInfoListener = iFetchHttpHeadInfoListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(str)) {
                IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener = iFetchHttpHeadInfoListener;
                if (iFetchHttpHeadInfoListener != null) {
                    iFetchHttpHeadInfoListener.onFetchFinished(null);
                    return;
                }
                return;
            }
            try {
                try {
                    List<HttpHeader> extraHeaders = DownloadPreconnecter.getExtraHeaders(0L, null, null);
                    r1 = DownloadConnectionPool.getInstance().isHeadConnectionExist(str) ? DownloadConnectionPool.getInstance().getCachedHeadConnection(str, extraHeaders) : null;
                    if (r1 == null) {
                        FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = new FakeDownloadHeadHttpConnection(str, extraHeaders, 0L);
                        try {
                            fakeDownloadHeadHttpConnection.execute();
                            if (fakeDownloadHeadHttpConnection.isSuccessful()) {
                                DownloadConnectionPool.getInstance().putCachedHeadConnections(str, fakeDownloadHeadHttpConnection);
                            }
                            r1 = fakeDownloadHeadHttpConnection;
                        } catch (Exception e2) {
                            e = e2;
                            r1 = fakeDownloadHeadHttpConnection;
                            e.printStackTrace();
                            r1.cancel();
                        } catch (Throwable th) {
                            th = th;
                            r1 = fakeDownloadHeadHttpConnection;
                            try {
                                r1.cancel();
                            } catch (Throwable unused) {
                            }
                            throw th;
                        }
                    }
                    Map<String, String> responseHeaders = r1.getResponseHeaders();
                    IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener2 = iFetchHttpHeadInfoListener;
                    if (iFetchHttpHeadInfoListener2 != null) {
                        iFetchHttpHeadInfoListener2.onFetchFinished(responseHeaders);
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            try {
                r1.cancel();
            } catch (Throwable unused2) {
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter$3 */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ List val$extra_headers;
        final /* synthetic */ boolean val$holdConnection;
        final /* synthetic */ boolean val$isHeadMethodAvailable;
        final /* synthetic */ int val$maxLength;
        final /* synthetic */ long val$startOffset;
        final /* synthetic */ String val$url;

        AnonymousClass3(boolean z, String str, List list, long j2, boolean z2, int i2) {
            z2 = z;
            str = str;
            list = list;
            j2 = j2;
            z = z2;
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (z2) {
                    DownloadPreconnecter.fetchHeadInfo(str, list, j2);
                }
                if (z) {
                    DownloadPreconnecter.createConnection(i2, str, list, j2);
                    Runnable unused = DownloadPreconnecter.sCancelRunnable = new CancelRunnable(str);
                    DownloadPreconnecter.sHandler.postDelayed(DownloadPreconnecter.sCancelRunnable, DownloadPreconnecter.sConnectionOutdatedTime);
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private static class CancelRunnable implements Runnable {
        private final String mUrl;

        public CancelRunnable(String str) {
            this.mUrl = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DownloadConnectionPool.getInstance().releaseDownloadConnection(this.mUrl);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        sPreconnectThread = handlerThread;
        init();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        sHandler = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void asyncFetchHttpHeadInfo(String str, IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener) {
        sHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.2
            final /* synthetic */ IFetchHttpHeadInfoListener val$listener;
            final /* synthetic */ String val$url;

            AnonymousClass2(String str2, IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener2) {
                str = str2;
                iFetchHttpHeadInfoListener = iFetchHttpHeadInfoListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener2 = iFetchHttpHeadInfoListener;
                    if (iFetchHttpHeadInfoListener2 != null) {
                        iFetchHttpHeadInfoListener2.onFetchFinished(null);
                        return;
                    }
                    return;
                }
                try {
                    try {
                        List<HttpHeader> extraHeaders = DownloadPreconnecter.getExtraHeaders(0L, null, null);
                        r1 = DownloadConnectionPool.getInstance().isHeadConnectionExist(str) ? DownloadConnectionPool.getInstance().getCachedHeadConnection(str, extraHeaders) : null;
                        if (r1 == null) {
                            FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = new FakeDownloadHeadHttpConnection(str, extraHeaders, 0L);
                            try {
                                fakeDownloadHeadHttpConnection.execute();
                                if (fakeDownloadHeadHttpConnection.isSuccessful()) {
                                    DownloadConnectionPool.getInstance().putCachedHeadConnections(str, fakeDownloadHeadHttpConnection);
                                }
                                r1 = fakeDownloadHeadHttpConnection;
                            } catch (Exception e2) {
                                e = e2;
                                r1 = fakeDownloadHeadHttpConnection;
                                e.printStackTrace();
                                r1.cancel();
                            } catch (Throwable th) {
                                th = th;
                                r1 = fakeDownloadHeadHttpConnection;
                                try {
                                    r1.cancel();
                                } catch (Throwable unused) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> responseHeaders = r1.getResponseHeaders();
                        IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener22 = iFetchHttpHeadInfoListener;
                        if (iFetchHttpHeadInfoListener22 != null) {
                            iFetchHttpHeadInfoListener22.onFetchFinished(responseHeaders);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    r1.cancel();
                } catch (Throwable unused2) {
                }
            }
        });
    }

    private static void asyncPreconnect(int i2, String str, List<HttpHeader> list, long j2, boolean z, boolean z2) {
        sHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.3
            final /* synthetic */ List val$extra_headers;
            final /* synthetic */ boolean val$holdConnection;
            final /* synthetic */ boolean val$isHeadMethodAvailable;
            final /* synthetic */ int val$maxLength;
            final /* synthetic */ long val$startOffset;
            final /* synthetic */ String val$url;

            AnonymousClass3(boolean z22, String str2, List list2, long j22, boolean z3, int i22) {
                z2 = z22;
                str = str2;
                list = list2;
                j2 = j22;
                z = z3;
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (z2) {
                        DownloadPreconnecter.fetchHeadInfo(str, list, j2);
                    }
                    if (z) {
                        DownloadPreconnecter.createConnection(i2, str, list, j2);
                        Runnable unused = DownloadPreconnecter.sCancelRunnable = new CancelRunnable(str);
                        DownloadPreconnecter.sHandler.postDelayed(DownloadPreconnecter.sCancelRunnable, DownloadPreconnecter.sConnectionOutdatedTime);
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }

    public static void createConnection(int i2, String str, List<HttpHeader> list, long j2) {
        if (DownloadConnectionPool.getInstance().isDownloadConnectionExist(str)) {
            return;
        }
        FakeDownloadHttpConnection fakeDownloadHttpConnection = new FakeDownloadHttpConnection(i2, str, list, j2);
        DownloadConnectionPool.getInstance().putCachedDownloadConnections(str, fakeDownloadHttpConnection);
        try {
            fakeDownloadHttpConnection.execute();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void fetchHeadInfo(String str, List<HttpHeader> list, long j2) {
        if (DownloadConnectionPool.getInstance().isHeadConnectionExist(str)) {
            return;
        }
        FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = new FakeDownloadHeadHttpConnection(str, list, j2);
        DownloadConnectionPool.getInstance().putCachedHeadConnections(str, fakeDownloadHeadHttpConnection);
        try {
            try {
                fakeDownloadHeadHttpConnection.execute();
            } catch (Throwable th) {
                try {
                    fakeDownloadHeadHttpConnection.cancel();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            fakeDownloadHeadHttpConnection.cancel();
        } catch (Throwable unused2) {
        }
    }

    public static List<HttpHeader> getExtraHeaders(long j2, DownloadInfo downloadInfo, List<HttpHeader> list) {
        return DownloadUtils.addRangeHeader(list, downloadInfo == null ? null : downloadInfo.geteTag(), j2, 0L);
    }

    public static Looper getLooper() {
        return sPreconnectThread.getLooper();
    }

    private static void init() {
        sConnectionOutdatedTime = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_CONNECTION_OUTDATE_TIME, a.k);
        sHeadInfoOutdatedTime = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_HEAD_INFO_OUTDATE_TIME, a.k);
        DownloadConnectionPool.getInstance().setMaxCachedDownloadConnectionSize(DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_MAX_CACHE_SIZE, 3));
    }

    public static void preconnect(String str, String str2, boolean z) {
        preconnect(-1, str, str2, null, z, true);
    }

    public static void preconnect(int i2, String str, String str2, List<HttpHeader> list, boolean z, boolean z2) {
        long j2;
        DownloadInfo downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(str, str2);
        if (downloadInfo == null) {
            j2 = 0;
        } else if (downloadInfo.isDownloadingStatus() || downloadInfo.isDownloaded() || downloadInfo.getChunkCount() > 1) {
            return;
        } else {
            j2 = DownloadUtils.getFirstOffset(downloadInfo);
        }
        long j3 = j2;
        asyncPreconnect(i2, str, getExtraHeaders(j3, downloadInfo, list), j3, z, z2);
    }
}
