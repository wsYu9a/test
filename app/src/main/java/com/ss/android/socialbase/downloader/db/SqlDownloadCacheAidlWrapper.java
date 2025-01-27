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
import androidx.media3.common.C;
import com.sigmob.sdk.base.common.y;
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
        public AnonymousClass1() {
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
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
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
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ IBinder val$service;

        /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$2$1 */
        public class AnonymousClass1 implements IBinder.DeathRecipient {
            public AnonymousClass1() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                    return;
                }
                SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, y.f.f18076n);
            }
        }

        public AnonymousClass2(IBinder iBinder) {
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
                            public AnonymousClass1() {
                            }

                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                    return;
                                }
                                SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, y.f.f18076n);
                            }
                        };
                    } catch (Throwable unused) {
                    }
                } catch (Throwable th2) {
                    try {
                        Logger.e(SqlDownloadCacheAidlWrapper.TAG, "onServiceConnected fail", th2);
                        if (SqlDownloadCacheAidlWrapper.this.mRebindErrorListener != null) {
                            SqlDownloadCacheAidlWrapper.this.mRebindErrorListener.onRebindError();
                        }
                        SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                        iBinder = iBinder;
                        anonymousClass1 = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                            public AnonymousClass1() {
                            }

                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                boolean unused2 = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                    return;
                                }
                                SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, y.f.f18076n);
                            }
                        };
                    } finally {
                        SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                        try {
                            iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                public AnonymousClass1() {
                                }

                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused2 = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                    if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                        return;
                                    }
                                    SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, y.f.f18076n);
                                }
                            }, 0);
                        } catch (Throwable unused2) {
                        }
                    }
                }
                iBinder.linkToDeath(anonymousClass1, 0);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$3 */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCacheService.startServiceAndBind(DownloadComponentManager.getAppContext(), SqlDownloadCacheAidlWrapper.this);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ SqlCacheLoadCompleteCallback val$callback;
        final /* synthetic */ SparseArray val$chunkListSparseArray;
        final /* synthetic */ SparseArray val$downloadInfoSparseArray;

        /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$4$1 */
        public class AnonymousClass1 extends ISqlCacheLoadCompleteCallbackAidl.Stub {
            public AnonymousClass1() {
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
            public void callback(Map map, Map map2) {
                DownloadUtils.sparseArrayPutAll(sparseArray, map);
                DownloadUtils.sparseArrayPutAll(sparseArray2, map2);
                sqlCacheLoadCompleteCallback.callback();
                SqlDownloadCacheAidlWrapper.this.setInitCallback(null);
            }
        }

        public AnonymousClass4(SparseArray sparseArray, SparseArray sparseArray2, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
            sparseArray = sparseArray;
            sparseArray2 = sparseArray2;
            sqlCacheLoadCompleteCallback = sqlCacheLoadCompleteCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback;
            Future future;
            SqlDownloadCacheAidlWrapper.this.setInitCallback(new ISqlCacheLoadCompleteCallbackAidl.Stub() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.4.1
                public AnonymousClass1() {
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
                z10 = !SqlDownloadCacheAidlWrapper.this.mInitLock.await(5000L, TimeUnit.MILLISECONDS);
            } catch (Throwable th2) {
                th2.printStackTrace();
                z10 = false;
            }
            if (z10 && (future = SqlDownloadCacheAidlWrapper.this.mSetInitCallbackFuture) != null) {
                future.cancel(true);
            }
            SqlDownloadCacheAidlWrapper.this.init();
            if (!z10 || (sqlCacheLoadCompleteCallback = sqlCacheLoadCompleteCallback) == null) {
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
        if (currentTimeMillis - sLastBindMainProcessTimeMills < C.DEFAULT_SEEK_FORWARD_INCREMENT_MS) {
            Logger.w(TAG, "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        sBindMainProcessTimes++;
        sLastBindMainProcessTimeMills = currentTimeMillis;
        this.mHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.3
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.startServiceAndBind(DownloadComponentManager.getAppContext(), SqlDownloadCacheAidlWrapper.this);
            }
        }, 1000L);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int i10, long j10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskCancel(i10, j10);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int i10, long j10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskCompleted(i10, j10);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int i10, long j10, String str, String str2) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskConnected(i10, j10, str, str2);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int i10, long j10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskError(i10, j10);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int i10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskIntercept(i10);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int i10, long j10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskPause(i10, j10);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int i10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskPrepare(i10);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int i10, long j10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskProgress(i10, j10);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int i10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.OnDownloadTaskRetry(i10);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
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
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addSubDownloadChunk(DownloadChunk downloadChunk) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.addSubDownloadChunk(downloadChunk);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.cacheExist(i10);
            }
            return false;
        } catch (RemoteException e10) {
            e10.printStackTrace();
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
        } catch (RemoteException e10) {
            e10.printStackTrace();
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
        } catch (RemoteException e10) {
            e10.printStackTrace();
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
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadChunk> getDownloadChunk(int i10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getDownloadChunk(i10);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int i10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.getDownloadInfo(i10);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
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
        } catch (RemoteException e10) {
            e10.printStackTrace();
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
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i10) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public ArrayList<Segment> getSegments(int i10) {
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
        } catch (RemoteException e10) {
            e10.printStackTrace();
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
        } catch (RemoteException e10) {
            e10.printStackTrace();
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
            public class AnonymousClass1 extends ISqlCacheLoadCompleteCallbackAidl.Stub {
                public AnonymousClass1() {
                }

                @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
                public void callback(Map map, Map map2) {
                    DownloadUtils.sparseArrayPutAll(sparseArray, map);
                    DownloadUtils.sparseArrayPutAll(sparseArray2, map2);
                    sqlCacheLoadCompleteCallback.callback();
                    SqlDownloadCacheAidlWrapper.this.setInitCallback(null);
                }
            }

            public AnonymousClass4(SparseArray sparseArray3, SparseArray sparseArray22, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback2) {
                sparseArray = sparseArray3;
                sparseArray2 = sparseArray22;
                sqlCacheLoadCompleteCallback = sqlCacheLoadCompleteCallback2;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z10;
                SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback2;
                Future future;
                SqlDownloadCacheAidlWrapper.this.setInitCallback(new ISqlCacheLoadCompleteCallbackAidl.Stub() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.4.1
                    public AnonymousClass1() {
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
                    z10 = !SqlDownloadCacheAidlWrapper.this.mInitLock.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    z10 = false;
                }
                if (z10 && (future = SqlDownloadCacheAidlWrapper.this.mSetInitCallbackFuture) != null) {
                    future.cancel(true);
                }
                SqlDownloadCacheAidlWrapper.this.init();
                if (!z10 || (sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback) == null) {
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
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int i10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.onDownloadTaskStart(i10);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        sIsMainProcessAlive = true;
        this.mHandler.removeCallbacks(this.mCheckAliveRunnable);
        try {
            this.mISqlDownloadCache = ISqlDownloadCacheAidl.Stub.asInterface(iBinder);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.mSetInitCallbackFuture = DownloadComponentManager.getCPUThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2
            final /* synthetic */ IBinder val$service;

            /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$2$1 */
            public class AnonymousClass1 implements IBinder.DeathRecipient {
                public AnonymousClass1() {
                }

                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    boolean unused2 = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                    if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                        return;
                    }
                    SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, y.f.f18076n);
                }
            }

            public AnonymousClass2(IBinder iBinder2) {
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
                                public AnonymousClass1() {
                                }

                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused2 = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                    if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                        return;
                                    }
                                    SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, y.f.f18076n);
                                }
                            };
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th22) {
                        try {
                            Logger.e(SqlDownloadCacheAidlWrapper.TAG, "onServiceConnected fail", th22);
                            if (SqlDownloadCacheAidlWrapper.this.mRebindErrorListener != null) {
                                SqlDownloadCacheAidlWrapper.this.mRebindErrorListener.onRebindError();
                            }
                            SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                            iBinder2 = iBinder;
                            anonymousClass1 = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                public AnonymousClass1() {
                                }

                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused2 = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                    if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                        return;
                                    }
                                    SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, y.f.f18076n);
                                }
                            };
                        } finally {
                            SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                            try {
                                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                    public AnonymousClass1() {
                                    }

                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused2 = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                        if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                            return;
                                        }
                                        SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, y.f.f18076n);
                                    }
                                }, 0);
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                    iBinder2.linkToDeath(anonymousClass1, 0);
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
    public void removeAllDownloadChunk(int i10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.removeAllDownloadChunk(i10);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int i10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.removeDownloadInfo(i10);
            }
            return false;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.removeDownloadTaskData(i10);
            }
            return false;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i10) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) {
        synchronized (this) {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                try {
                    iSqlDownloadCacheAidl.setInitCallback(iSqlCacheLoadCompleteCallbackAidl);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
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
    public void syncDownloadChunks(int i10, List<DownloadChunk> list) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.syncDownloadChunks(i10, list);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.syncDownloadInfo(downloadInfo);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i10, List<DownloadChunk> list) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.syncDownloadInfoFromOtherCache(i10, list);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo updateChunkCount(int i10, int i11) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                return iSqlDownloadCacheAidl.updateChunkCount(i10, i11);
            }
            return null;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateDownloadChunk(int i10, int i11, long j10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.updateDownloadChunk(i10, i11, j10);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
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
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i10, Map<Long, Segment> map) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunk(int i10, int i11, int i12, long j10) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.updateSubDownloadChunk(i10, i11, i12, j10);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunkIndex(int i10, int i11, int i12, int i13) {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.updateSubDownloadChunkIndex(i10, i11, i12, i13);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init() {
        try {
            ISqlDownloadCacheAidl iSqlDownloadCacheAidl = this.mISqlDownloadCache;
            if (iSqlDownloadCacheAidl != null) {
                iSqlDownloadCacheAidl.init();
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }
}
