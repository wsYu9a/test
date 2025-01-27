package com.ss.android.socialbase.downloader.db;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl;
import com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class SqlDownloadCacheAidlWrapper implements ServiceConnection, ISqlDownloadCache {
    private static final int BIND_MAIN_PROCESS_MAX_TIME = 5;
    private static final int BIND_MAIN_PROCESS_MIN_INTERVAL = 15000;
    private static final int MAIN_PROCESS_BIND_DELAY = 1000;
    private static final String TAG = "SqlDownloadCacheAidlWra";
    private static int sBindMainProcessTimes;
    private static boolean sIsMainProcessAlive;
    private static long sLastBindMainProcessTimeMills;

    @Nullable
    private ISqlDownloadCacheAidl mISqlDownloadCache;
    private DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener mRebindErrorListener;
    private Future<?> mSetInitCallbackFuture;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ISqlCacheLoadCompleteCallbackAidl mPengingCallback = null;
    private Runnable mCheckAliveRunnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SqlDownloadCacheAidlWrapper.sIsMainProcessAlive || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                return;
            }
            SqlDownloadCacheAidlWrapper.this.mRebindErrorListener.onRebindError();
        }
    };
    private CountDownLatch mInitLock = new CountDownLatch(1);

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SqlDownloadCacheAidlWrapper.sIsMainProcessAlive || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                return;
            }
            SqlDownloadCacheAidlWrapper.this.mRebindErrorListener.onRebindError();
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ IBinder val$service;

        /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$2$1 */
        class AnonymousClass1 implements IBinder.DeathRecipient {
            AnonymousClass1() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                    return;
                }
                SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, 2000L);
            }
        }

        AnonymousClass2(IBinder iBinder) {
            iBinder = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            IBinder iBinder;
            AnonymousClass1 anonymousClass1;
            synchronized (this) {
                try {
                    try {
                        if (SqlDownloadCacheAidlWrapper.this.mPengingCallback != null && SqlDownloadCacheAidlWrapper.this.mISqlDownloadCache != null) {
                            SqlDownloadCacheAidlWrapper.this.mISqlDownloadCache.setInitCallback(SqlDownloadCacheAidlWrapper.this.mPengingCallback);
                        }
                        iBinder = iBinder;
                        anonymousClass1 = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                            AnonymousClass1() {
                            }

                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                    return;
                                }
                                SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, 2000L);
                            }
                        };
                    } catch (Throwable th) {
                        try {
                            Logger.e(SqlDownloadCacheAidlWrapper.TAG, "onServiceConnected fail", th);
                            if (SqlDownloadCacheAidlWrapper.this.mRebindErrorListener != null) {
                                SqlDownloadCacheAidlWrapper.this.mRebindErrorListener.onRebindError();
                            }
                            SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                            iBinder = iBinder;
                            anonymousClass1 = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                AnonymousClass1() {
                                }

                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                    if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                        return;
                                    }
                                    SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, 2000L);
                                }
                            };
                        } finally {
                            SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                            try {
                                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                    AnonymousClass1() {
                                    }

                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                        if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                            return;
                                        }
                                        SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, 2000L);
                                    }
                                }, 0);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    iBinder.linkToDeath(anonymousClass1, 0);
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCacheService.startServiceAndBind(DownloadComponentManager.getAppContext(), SqlDownloadCacheAidlWrapper.this);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ SqlCacheLoadCompleteCallback val$callback;
        final /* synthetic */ SparseArray val$chunkListSparseArray;
        final /* synthetic */ SparseArray val$downloadInfoSparseArray;

        /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$4$1 */
        class AnonymousClass1 extends ISqlCacheLoadCompleteCallbackAidl.Stub {
            AnonymousClass1() {
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
            public void callback(Map map, Map map2) {
                DownloadUtils.sparseArrayPutAll(sparseArray, map);
                DownloadUtils.sparseArrayPutAll(sparseArray2, map2);
                sqlCacheLoadCompleteCallback.callback();
                SqlDownloadCacheAidlWrapper.this.setInitCallback(null);
            }
        }

        AnonymousClass4(SparseArray sparseArray, SparseArray sparseArray2, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
            sparseArray = sparseArray;
            sparseArray2 = sparseArray2;
            sqlCacheLoadCompleteCallback = sqlCacheLoadCompleteCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback;
            Future future;
            SqlDownloadCacheAidlWrapper.this.setInitCallback(new ISqlCacheLoadCompleteCallbackAidl.Stub() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.4.1
                AnonymousClass1() {
                }

                @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
                public void callback(Map map, Map map2) {
                    DownloadUtils.sparseArrayPutAll(sparseArray, map);
                    DownloadUtils.sparseArrayPutAll(sparseArray2, map2);
                    sqlCacheLoadCompleteCallback.callback();
                    SqlDownloadCacheAidlWrapper.this.setInitCallback(null);
                }
            });
            try {
                z = !SqlDownloadCacheAidlWrapper.this.mInitLock.await(5000L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                z = false;
            }
            if (z && (future = SqlDownloadCacheAidlWrapper.this.mSetInitCallbackFuture) != null) {
                future.cancel(true);
            }
            SqlDownloadCacheAidlWrapper.this.init();
            if (!z || (sqlCacheLoadCompleteCallback = sqlCacheLoadCompleteCallback) == null) {
                return;
            }
            sqlCacheLoadCompleteCallback.callback();
        }
    }

    public interface OnMainProcessRebindErrorListener {
        void onRebindError();
    }

    public SqlDownloadCacheAidlWrapper() {
        SqlDownloadCacheService.startServiceAndBind(DownloadComponentManager.getAppContext(), this);
    }

    public boolean bindMainProcessDelayed() {
        if (Build.VERSION.SDK_INT >= 26 || sIsMainProcessAlive) {
            return false;
        }
        if (sBindMainProcessTimes > 5) {
            Logger.w(TAG, "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - sLastBindMainProcessTimeMills < 15000) {
            Logger.w(TAG, "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        sBindMainProcessTimes++;
        sLastBindMainProcessTimeMills = currentTimeMillis;
        this.mHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.startServiceAndBind(DownloadComponentManager.getAppContext(), SqlDownloadCacheAidlWrapper.this);
            }
        }, 1000L);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int i2, long j2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskCancel(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int i2, long j2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskCompleted(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int i2, long j2, String str, String str2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskConnected(i2, j2, str, str2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int i2, long j2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskError(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int i2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskIntercept(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int i2, long j2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskPause(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int i2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskPrepare(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int i2, long j2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskProgress(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int i2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskRetry(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addDownloadChunk(DownloadChunk downloadChunk) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.addDownloadChunk(downloadChunk);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addSubDownloadChunk(DownloadChunk downloadChunk) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.addSubDownloadChunk(downloadChunk);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.cacheExist(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.clearData();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.ensureDownloadCacheSyncSuccess();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getAllDownloadInfo();
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadChunk> getDownloadChunk(int i2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getDownloadChunk(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int i2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getDownloadInfo(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String str) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getDownloadInfoList(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getFailedDownloadInfosWithMimeType(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public ArrayList<Segment> getSegments(int i2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getSuccessedDownloadInfosWithMimeType(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getUnCompletedDownloadInfosWithMimeType(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void init(SparseArray<DownloadInfo> sparseArray, SparseArray<List<DownloadChunk>> sparseArray2, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
        DownloadComponentManager.getCPUThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.4
            final /* synthetic */ SqlCacheLoadCompleteCallback val$callback;
            final /* synthetic */ SparseArray val$chunkListSparseArray;
            final /* synthetic */ SparseArray val$downloadInfoSparseArray;

            /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$4$1 */
            class AnonymousClass1 extends ISqlCacheLoadCompleteCallbackAidl.Stub {
                AnonymousClass1() {
                }

                @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
                public void callback(Map map, Map map2) {
                    DownloadUtils.sparseArrayPutAll(sparseArray, map);
                    DownloadUtils.sparseArrayPutAll(sparseArray2, map2);
                    sqlCacheLoadCompleteCallback.callback();
                    SqlDownloadCacheAidlWrapper.this.setInitCallback(null);
                }
            }

            AnonymousClass4(SparseArray sparseArray3, SparseArray sparseArray22, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback2) {
                sparseArray = sparseArray3;
                sparseArray2 = sparseArray22;
                sqlCacheLoadCompleteCallback = sqlCacheLoadCompleteCallback2;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback2;
                Future future;
                SqlDownloadCacheAidlWrapper.this.setInitCallback(new ISqlCacheLoadCompleteCallbackAidl.Stub() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.4.1
                    AnonymousClass1() {
                    }

                    @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
                    public void callback(Map map, Map map2) {
                        DownloadUtils.sparseArrayPutAll(sparseArray, map);
                        DownloadUtils.sparseArrayPutAll(sparseArray2, map2);
                        sqlCacheLoadCompleteCallback.callback();
                        SqlDownloadCacheAidlWrapper.this.setInitCallback(null);
                    }
                });
                try {
                    z = !SqlDownloadCacheAidlWrapper.this.mInitLock.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                    z = false;
                }
                if (z && (future = SqlDownloadCacheAidlWrapper.this.mSetInitCallbackFuture) != null) {
                    future.cancel(true);
                }
                SqlDownloadCacheAidlWrapper.this.init();
                if (!z || (sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback) == null) {
                    return;
                }
                sqlCacheLoadCompleteCallback2.callback();
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.isDownloadCacheSyncSuccess();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int i2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.onDownloadTaskStart(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        sIsMainProcessAlive = true;
        this.mHandler.removeCallbacks(this.mCheckAliveRunnable);
        try {
            this.mISqlDownloadCache = ISqlDownloadCacheAidl.Stub.asInterface(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mSetInitCallbackFuture = DownloadComponentManager.getCPUThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2
            final /* synthetic */ IBinder val$service;

            /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$2$1 */
            class AnonymousClass1 implements IBinder.DeathRecipient {
                AnonymousClass1() {
                }

                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                    if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                        return;
                    }
                    SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, 2000L);
                }
            }

            AnonymousClass2(IBinder iBinder2) {
                iBinder = iBinder2;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder2;
                AnonymousClass1 anonymousClass1;
                synchronized (this) {
                    try {
                        try {
                            if (SqlDownloadCacheAidlWrapper.this.mPengingCallback != null && SqlDownloadCacheAidlWrapper.this.mISqlDownloadCache != null) {
                                SqlDownloadCacheAidlWrapper.this.mISqlDownloadCache.setInitCallback(SqlDownloadCacheAidlWrapper.this.mPengingCallback);
                            }
                            iBinder2 = iBinder;
                            anonymousClass1 = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                AnonymousClass1() {
                                }

                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                    if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                        return;
                                    }
                                    SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, 2000L);
                                }
                            };
                        } catch (Throwable th2) {
                            try {
                                Logger.e(SqlDownloadCacheAidlWrapper.TAG, "onServiceConnected fail", th2);
                                if (SqlDownloadCacheAidlWrapper.this.mRebindErrorListener != null) {
                                    SqlDownloadCacheAidlWrapper.this.mRebindErrorListener.onRebindError();
                                }
                                SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                                iBinder2 = iBinder;
                                anonymousClass1 = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                    AnonymousClass1() {
                                    }

                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                        if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                            return;
                                        }
                                        SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, 2000L);
                                    }
                                };
                            } finally {
                                SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                                try {
                                    iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                        AnonymousClass1() {
                                        }

                                        @Override // android.os.IBinder.DeathRecipient
                                        public void binderDied() {
                                            boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                            if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                                return;
                                            }
                                            SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, 2000L);
                                        }
                                    }, 0);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        iBinder2.linkToDeath(anonymousClass1, 0);
                    } catch (Throwable unused2) {
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.mISqlDownloadCache = null;
        sIsMainProcessAlive = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeAllDownloadChunk(int i2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.removeAllDownloadChunk(i2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int i2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.removeDownloadInfo(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.removeDownloadTaskData(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) {
        synchronized (this) {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                try {
                    iSqlDownloadCacheAidl.setInitCallback(iSqlCacheLoadCompleteCallbackAidl);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else {
                this.mPengingCallback = iSqlCacheLoadCompleteCallbackAidl;
            }
        }
    }

    public void setOnMainProcessRebindErrorCallback(DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener onMainProcessRebindErrorListener) {
        this.mRebindErrorListener = onMainProcessRebindErrorListener;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadChunks(int i2, List<DownloadChunk> list) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.syncDownloadChunks(i2, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.syncDownloadInfo(downloadInfo);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i2, List<DownloadChunk> list) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.syncDownloadInfoFromOtherCache(i2, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo updateChunkCount(int i2, int i3) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.updateChunkCount(i2, i3);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateDownloadChunk(int i2, int i3, long j2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.updateDownloadChunk(i2, i3, j2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.updateDownloadInfo(downloadInfo);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i2, Map<Long, Segment> map) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunk(int i2, int i3, int i4, long j2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.updateSubDownloadChunk(i2, i3, i4, j2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunkIndex(int i2, int i3, int i4, int i5) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.updateSubDownloadChunkIndex(i2, i3, i4, i5);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init() {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.init();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
