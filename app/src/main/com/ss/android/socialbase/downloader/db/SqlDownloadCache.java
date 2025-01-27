package com.ss.android.socialbase.downloader.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public class SqlDownloadCache extends ISqlDownloadCacheAidl.Stub implements ISqlDownloadCache {
    private static volatile SQLiteDatabase database;
    private volatile boolean cacheSynced;
    ISqlCacheLoadCompleteCallbackAidl callback;
    private TableStatements chunkTableStatements;
    private TableStatements downloadTableStatements;
    private TableStatements segmentTableStatements;

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ SqlCacheLoadCompleteCallback val$callback;
        final /* synthetic */ SparseArray val$copyChunkListMap;
        final /* synthetic */ SparseArray val$copyDownloadInfoMap;

        public AnonymousClass1(SparseArray sparseArray, SparseArray sparseArray2, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
            sparseArray = sparseArray;
            sparseArray2 = sparseArray2;
            sqlCacheLoadCompleteCallback = sqlCacheLoadCompleteCallback;
        }

        /* JADX WARN: Code restructure failed: missing block: B:140:0x027e, code lost:
        
            if (r0 == null) goto L506;
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x0287, code lost:
        
            if (r0 == null) goto L506;
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x0343, code lost:
        
            if (r0 == null) goto L590;
         */
        /* JADX WARN: Code restructure failed: missing block: B:186:0x0345, code lost:
        
            r0.callback();
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.cacheSynced = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x034d, code lost:
        
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.onInitFinish(r2, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:188:0x035f, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:194:0x035c, code lost:
        
            if (r0 == null) goto L590;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x01a9, code lost:
        
            if (r0 != null) goto L505;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x01ab, code lost:
        
            r0.callback();
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.cacheSynced = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x01b3, code lost:
        
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.onInitFinish(r2, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x028b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x01c3, code lost:
        
            if (r0 == null) goto L506;
         */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00dd A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00cd A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 890
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass1.run():void");
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$10 */
    public class AnonymousClass10 implements Runnable {
        public AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCache.this.clearDataInSubThread();
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$11 */
    public class AnonymousClass11 implements Runnable {
        final /* synthetic */ ContentValues val$cv;
        final /* synthetic */ int val$id;

        public AnonymousClass11(int i10, ContentValues contentValues) {
            i10 = i10;
            contentValues = contentValues;
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCache.this.updateInner(i10, contentValues);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ int val$id;

        public AnonymousClass2(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SqlDownloadCache.this.deleteInner(i10, SqlDownloadCache.this.chunkTableStatements.getDeleteStatement());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ DownloadChunk val$chunk;

        public AnonymousClass3(DownloadChunk downloadChunk) {
            downloadChunk = downloadChunk;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SqlDownloadCache.this.insertDownloadChunkInner(downloadChunk, SqlDownloadCache.this.chunkTableStatements.getInsertStatement());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ int val$chunkIndex;
        final /* synthetic */ long val$currentOffset;
        final /* synthetic */ int val$id;

        public AnonymousClass4(int i10, int i11, long j10) {
            i10 = i10;
            i11 = i11;
            j10 = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SqlDownloadCache.this.updateDownloadChunkInner(i10, i11, j10, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$5 */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ int val$chunkIndex;
        final /* synthetic */ long val$currentOffset;
        final /* synthetic */ int val$hostChunkIndex;
        final /* synthetic */ int val$id;

        public AnonymousClass5(int i10, int i11, int i12, long j10) {
            i10 = i10;
            i11 = i11;
            i12 = i12;
            j10 = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SqlDownloadCache.this.updateSubDownloadChunkInner(i10, i11, i12, j10, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$6 */
    public class AnonymousClass6 implements Runnable {
        final /* synthetic */ int val$chunkIndex;
        final /* synthetic */ int val$hostChunkIndex;
        final /* synthetic */ int val$id;
        final /* synthetic */ int val$newChunkIndex;

        public AnonymousClass6(int i10, int i11, int i12, int i13) {
            i10 = i10;
            i11 = i11;
            i12 = i12;
            i13 = i13;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SqlDownloadCache.this.updateSubDownloadChunkIndexInner(i10, i11, i12, i13, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$7 */
    public class AnonymousClass7 implements Runnable {
        final /* synthetic */ DownloadInfo val$downloadInfo;

        public AnonymousClass7(DownloadInfo downloadInfo) {
            downloadInfo = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SqlDownloadCache sqlDownloadCache = SqlDownloadCache.this;
                sqlDownloadCache.insertDownloadInfoInner(downloadInfo, sqlDownloadCache.downloadTableStatements.getInsertStatement());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$8 */
    public class AnonymousClass8 implements Runnable {
        final /* synthetic */ DownloadInfo val$downloadInfo;

        public AnonymousClass8(DownloadInfo downloadInfo) {
            downloadInfo = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCache.this.updateDownloadInfoForCurrentThread(downloadInfo);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$9 */
    public class AnonymousClass9 implements Runnable {
        final /* synthetic */ int val$id;

        public AnonymousClass9(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCache.this.removeDownloadInfo(i10);
            SqlDownloadCache.this.removeAllDownloadChunk(i10);
            SqlDownloadCache.this.removeSegments(i10);
        }
    }

    public SqlDownloadCache() {
        this(false);
    }

    private void addDownloadInfo(DownloadInfo downloadInfo) {
        ensureDataBaseInit();
        if (database == null || this.downloadTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.7
            final /* synthetic */ DownloadInfo val$downloadInfo;

            public AnonymousClass7(DownloadInfo downloadInfo2) {
                downloadInfo = downloadInfo2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache sqlDownloadCache = SqlDownloadCache.this;
                    sqlDownloadCache.insertDownloadInfoInner(downloadInfo, sqlDownloadCache.downloadTableStatements.getInsertStatement());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    public void clearAntiHijackDirIfNeeded(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    DownloadUtils.clearAntiHijackDir(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void clearDataInSubThread() {
        try {
            safeBeginTransaction();
            database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, null, null);
            database.delete(DBDefinition.CHUNK_TABLE_NAME, null, null);
            database.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    public void deleteInner(int i10, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i10);
                sQLiteStatement.execute();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void ensureDataBaseInit() {
        if (database == null) {
            synchronized (SqlDownloadCache.class) {
                try {
                    if (database == null) {
                        database = DownloadDBHelper.getInstance().getWritableDatabase();
                        this.downloadTableStatements = new TableStatements(database, DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.DOWNLOAD_ALL_COLUMNS, DBDefinition.DOWNLOAD_PK_COLUMNS);
                        this.chunkTableStatements = new TableStatements(database, DBDefinition.CHUNK_TABLE_NAME, DBDefinition.CHUNK_ALL_COLUMNS, DBDefinition.CHUNK_PK_COLUMNS);
                        this.segmentTableStatements = new TableStatements(database, DBDefinition.SEGMENT_TABLE_NAME, DBDefinition.SEGMENT_ALL_COLUMNS, DBDefinition.SEGMENT_PK_COLUMNS);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                } finally {
                }
            }
        }
    }

    public void insertDownloadChunkInner(DownloadChunk downloadChunk, SQLiteStatement sQLiteStatement) {
        if (downloadChunk == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadChunk.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void insertDownloadInfoInner(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void loadCacheFromDB(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<DownloadChunk>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || database == null) {
            return;
        }
        synchronized (database) {
            try {
                safeBeginTransaction();
                if (!list.isEmpty()) {
                    if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_CLEAR_INVALID_TASK_ERROR)) {
                        String[] strArr = new String[list.size()];
                        for (int i10 = 0; i10 < list.size(); i10++) {
                            strArr[i10] = String.valueOf(list.get(i10));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, str, strArr);
                        database.delete(DBDefinition.CHUNK_TABLE_NAME, str, strArr);
                    } else {
                        String join = TextUtils.join(", ", list2);
                        database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, "_id IN (?)", new String[]{join});
                        database.delete(DBDefinition.CHUNK_TABLE_NAME, "_id IN (?)", new String[]{join});
                    }
                }
                for (int i11 = 0; i11 < size; i11++) {
                    int keyAt = sparseArray.keyAt(i11);
                    DownloadInfo downloadInfo = sparseArray.get(keyAt);
                    database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, "_id = ?", new String[]{String.valueOf(keyAt)});
                    database.insert(DBDefinition.DOWNLOAD_TABLE_NAME, null, downloadInfo.toContentValues());
                    if (downloadInfo.getChunkCount() > 1) {
                        List<DownloadChunk> downloadChunk = getDownloadChunk(keyAt);
                        if (downloadChunk.size() > 0) {
                            database.delete(DBDefinition.CHUNK_TABLE_NAME, "_id = ?", new String[]{String.valueOf(keyAt)});
                            for (DownloadChunk downloadChunk2 : downloadChunk) {
                                downloadChunk2.setId(downloadInfo.getId());
                                database.insert(DBDefinition.CHUNK_TABLE_NAME, null, downloadChunk2.toContentValues());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i12 = 0; i12 < size2; i12++) {
                        int id2 = sparseArray2.valueAt(i12).getId();
                        List<DownloadChunk> parseHostChunkList = DownloadUtils.parseHostChunkList(getDownloadChunk(id2));
                        if (parseHostChunkList != null && parseHostChunkList.size() > 0) {
                            sparseArray3.put(id2, parseHostChunkList);
                        }
                    }
                }
                database.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    private void safeBeginTransaction() {
        database.beginTransaction();
    }

    private void safeEndTransaction() {
        try {
            if (database == null || !database.inTransaction()) {
                return;
            }
            database.endTransaction();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void update(int i10, ContentValues contentValues) {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.11
            final /* synthetic */ ContentValues val$cv;
            final /* synthetic */ int val$id;

            public AnonymousClass11(int i102, ContentValues contentValues2) {
                i10 = i102;
                contentValues = contentValues2;
            }

            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.updateInner(i10, contentValues);
            }
        });
    }

    public void updateDownloadChunkInner(int i10, int i11, long j10, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBDefinition.CUR_OFFSET, Long.valueOf(j10));
                database.update(DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i10), Integer.toString(i11)});
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public synchronized void updateDownloadInfoForCurrentThread(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (cacheExist(downloadInfo.getId())) {
                TableStatements tableStatements = this.downloadTableStatements;
                if (tableStatements == null) {
                    return;
                }
                try {
                    updateDownloadInfoInner(downloadInfo, tableStatements.getUpdateStatement());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } else {
                addDownloadInfo(downloadInfo);
            }
        } finally {
        }
    }

    private void updateDownloadInfoInner(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void updateInner(int i10, ContentValues contentValues) {
        int i11 = 10;
        while (database.isDbLockedByCurrentThread() && i11 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
                return;
            }
        }
        try {
            database.update(DBDefinition.DOWNLOAD_TABLE_NAME, contentValues, "_id = ? ", new String[]{String.valueOf(i10)});
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
    }

    public void updateSubDownloadChunkIndexInner(int i10, int i11, int i12, int i13, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBDefinition.CHUNK_INDEX, Integer.valueOf(i13));
                database.update(DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i10), Integer.toString(i11), Integer.toString(i12)});
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void updateSubDownloadChunkInner(int i10, int i11, int i12, long j10, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBDefinition.CUR_OFFSET, Long.valueOf(j10));
                database.update(DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i10), Integer.toString(i11), Integer.toString(i12)});
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskCancel(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j10));
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskCompleted(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j10));
        contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        contentValues.put(DBDefinition.FIRST_SUCCESS, (Integer) 0);
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskConnected(int i10, long j10, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put(DBDefinition.TOTAL_BYTES, Long.valueOf(j10));
        contentValues.put(DBDefinition.ETAG, str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskError(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j10));
        if (j10 > 0) {
            contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        }
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskIntercept(int i10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskPause(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j10));
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskPrepare(int i10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskProgress(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j10));
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskRetry(int i10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void addDownloadChunk(DownloadChunk downloadChunk) {
        ensureDataBaseInit();
        if (database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.3
            final /* synthetic */ DownloadChunk val$chunk;

            public AnonymousClass3(DownloadChunk downloadChunk2) {
                downloadChunk = downloadChunk2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.insertDownloadChunkInner(downloadChunk, SqlDownloadCache.this.chunkTableStatements.getInsertStatement());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void addSubDownloadChunk(DownloadChunk downloadChunk) {
        addDownloadChunk(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean cacheExist(int i10) {
        try {
            return getDownloadInfo(i10) != null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void clearData() {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.10
            public AnonymousClass10() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.clearDataInSubThread();
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getAllDownloadInfo() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadChunk> getDownloadChunk(int i10) {
        ArrayList arrayList = new ArrayList();
        ensureDataBaseInit();
        if (database != null) {
            Cursor cursor = null;
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.CHUNK_TABLE_NAME, "_id"), new String[]{Integer.toString(i10)});
                while (cursor.moveToNext()) {
                    arrayList.add(new DownloadChunk(cursor));
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th3) {
                    DownloadUtils.safeClose(cursor);
                    throw th3;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo getDownloadInfo(int i10) {
        Cursor cursor;
        ensureDataBaseInit();
        if (database != null) {
            try {
                try {
                    cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.DOWNLOAD_TABLE_NAME, "_id"), new String[]{Integer.toString(i10)});
                    try {
                        if (cursor.moveToNext()) {
                            DownloadInfo downloadInfo = new DownloadInfo(cursor);
                            DownloadUtils.safeClose(cursor);
                            return downloadInfo;
                        }
                        DownloadUtils.safeClose(cursor);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            DownloadUtils.safeClose(cursor);
                            return null;
                        } catch (Throwable th3) {
                            DownloadUtils.safeClose(cursor);
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor = null;
                    th.printStackTrace();
                    DownloadUtils.safeClose(cursor);
                    return null;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getDownloadInfoList(String str) {
        ensureDataBaseInit();
        ArrayList arrayList = new ArrayList();
        if (database != null) {
            Cursor cursor = null;
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.DOWNLOAD_TABLE_NAME, "url"), new String[]{str});
                if (cursor.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursor));
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th3) {
                    DownloadUtils.safeClose(cursor);
                    throw th3;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i10) {
        Cursor cursor;
        ensureDataBaseInit();
        if (database != null) {
            try {
                try {
                    cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.SEGMENT_TABLE_NAME, "_id"), new String[]{Integer.toString(i10)});
                    try {
                        if (cursor.moveToNext()) {
                            int columnIndex = cursor.getColumnIndex(DBDefinition.SEGMENT_INFO);
                            String string = columnIndex >= 0 ? cursor.getString(columnIndex) : null;
                            HashMap hashMap = new HashMap();
                            JSONArray jSONArray = new JSONArray(string);
                            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                                Segment segment = new Segment(jSONArray.getJSONObject(i11));
                                hashMap.put(Long.valueOf(segment.getStartOffset()), segment);
                            }
                            DownloadUtils.safeClose(cursor);
                            return hashMap;
                        }
                        DownloadUtils.safeClose(cursor);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            DownloadUtils.safeClose(cursor);
                            return null;
                        } catch (Throwable th3) {
                            DownloadUtils.safeClose(cursor);
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor = null;
                    th.printStackTrace();
                    DownloadUtils.safeClose(cursor);
                    return null;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void init() {
        init(new SparseArray<>(), new SparseArray<>(), null);
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean isDownloadCacheSyncSuccess() {
        return this.cacheSynced;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo onDownloadTaskStart(int i10) {
        return null;
    }

    public void onInitFinish(SparseArray<DownloadInfo> sparseArray, SparseArray<List<DownloadChunk>> sparseArray2) {
        try {
            HashMap sparseArrayToHashMap = DownloadUtils.sparseArrayToHashMap(sparseArray);
            HashMap sparseArrayToHashMap2 = DownloadUtils.sparseArrayToHashMap(sparseArray2);
            ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl = this.callback;
            if (iSqlCacheLoadCompleteCallbackAidl != null) {
                iSqlCacheLoadCompleteCallbackAidl.callback(sparseArrayToHashMap, sparseArrayToHashMap2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void removeAllDownloadChunk(int i10) {
        ensureDataBaseInit();
        if (database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.2
            final /* synthetic */ int val$id;

            public AnonymousClass2(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.deleteInner(i10, SqlDownloadCache.this.chunkTableStatements.getDeleteStatement());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean removeDownloadInfo(int i10) {
        TableStatements tableStatements;
        ensureDataBaseInit();
        if (database != null && (tableStatements = this.downloadTableStatements) != null) {
            try {
                deleteInner(i10, tableStatements.getDeleteStatement());
                return true;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean removeDownloadTaskData(int i10) {
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.9
            final /* synthetic */ int val$id;

            public AnonymousClass9(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.removeDownloadInfo(i10);
                SqlDownloadCache.this.removeAllDownloadChunk(i10);
                SqlDownloadCache.this.removeSegments(i10);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i10) {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        try {
            deleteInner(i10, this.segmentTableStatements.getDeleteStatement());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) {
        this.callback = iSqlCacheLoadCompleteCallbackAidl;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadChunks(int i10, List<DownloadChunk> list) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadInfoFromOtherCache(int i10, List<DownloadChunk> list) {
        try {
            removeAllDownloadChunk(i10);
            if (list != null) {
                for (DownloadChunk downloadChunk : list) {
                    if (downloadChunk != null) {
                        addDownloadChunk(downloadChunk);
                        if (downloadChunk.hasChunkDivided()) {
                            Iterator<DownloadChunk> it = downloadChunk.getSubChunkList().iterator();
                            while (it.hasNext()) {
                                addDownloadChunk(it.next());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo updateChunkCount(int i10, int i11) {
        ensureDataBaseInit();
        if (database == null) {
            return null;
        }
        int i12 = 10;
        while (database.isDbLockedByCurrentThread() && i12 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBDefinition.CHUNK_COUNT, Integer.valueOf(i11));
        database.update(DBDefinition.DOWNLOAD_TABLE_NAME, contentValues, "_id = ? ", new String[]{Integer.toString(i10)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateDownloadChunk(int i10, int i11, long j10) {
        ensureDataBaseInit();
        if (i10 == 0 || i11 < 0 || j10 < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.4
            final /* synthetic */ int val$chunkIndex;
            final /* synthetic */ long val$currentOffset;
            final /* synthetic */ int val$id;

            public AnonymousClass4(int i102, int i112, long j102) {
                i10 = i102;
                i11 = i112;
                j10 = j102;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.updateDownloadChunkInner(i10, i11, j10, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        ensureDataBaseInit();
        if (downloadInfo == null || database == null) {
            return false;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.8
            final /* synthetic */ DownloadInfo val$downloadInfo;

            public AnonymousClass8(DownloadInfo downloadInfo2) {
                downloadInfo = downloadInfo2;
            }

            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.updateDownloadInfoForCurrentThread(downloadInfo);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i10, Map<Long, Segment> map) {
        long currentTimeMillis = System.currentTimeMillis();
        ensureDataBaseInit();
        if (database == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Long l10 : map.keySet()) {
                l10.longValue();
                jSONArray.put(map.get(l10).toJson());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Log.d("SqlDownloadCache", "json=" + jSONArray);
        SQLiteStatement insertOrReplaceStatement = this.segmentTableStatements.getInsertOrReplaceStatement();
        synchronized (insertOrReplaceStatement) {
            insertOrReplaceStatement.clearBindings();
            insertOrReplaceStatement.bindLong(1, i10);
            insertOrReplaceStatement.bindString(2, jSONArray.toString());
            insertOrReplaceStatement.execute();
        }
        Logger.d("SqlDownloadCache", "updateSegments cost=" + DownloadUtils.cost(currentTimeMillis));
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateSubDownloadChunk(int i10, int i11, int i12, long j10) {
        ensureDataBaseInit();
        if (i10 == 0 || i11 < 0 || i12 < 0 || j10 < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.5
            final /* synthetic */ int val$chunkIndex;
            final /* synthetic */ long val$currentOffset;
            final /* synthetic */ int val$hostChunkIndex;
            final /* synthetic */ int val$id;

            public AnonymousClass5(int i102, int i112, int i122, long j102) {
                i10 = i102;
                i11 = i112;
                i12 = i122;
                j10 = j102;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.updateSubDownloadChunkInner(i10, i11, i12, j10, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateSubDownloadChunkIndex(int i10, int i11, int i12, int i13) {
        ensureDataBaseInit();
        if (i10 == 0 || i12 < 0 || i13 == i11 || i13 < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.6
            final /* synthetic */ int val$chunkIndex;
            final /* synthetic */ int val$hostChunkIndex;
            final /* synthetic */ int val$id;
            final /* synthetic */ int val$newChunkIndex;

            public AnonymousClass6(int i102, int i112, int i122, int i132) {
                i10 = i102;
                i11 = i112;
                i12 = i122;
                i13 = i132;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.updateSubDownloadChunkIndexInner(i10, i11, i12, i13, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    public SqlDownloadCache(boolean z10) {
        this.callback = null;
        if (z10) {
            this.cacheSynced = false;
            init();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public ArrayList<Segment> getSegments(int i10) {
        Map<Long, Segment> segmentMap = getSegmentMap(i10);
        if (segmentMap == null || segmentMap.isEmpty()) {
            return null;
        }
        return new ArrayList<>(segmentMap.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void init(SparseArray<DownloadInfo> sparseArray, SparseArray<List<DownloadChunk>> sparseArray2, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
        try {
            AnonymousClass1 anonymousClass1 = new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.1
                final /* synthetic */ SqlCacheLoadCompleteCallback val$callback;
                final /* synthetic */ SparseArray val$copyChunkListMap;
                final /* synthetic */ SparseArray val$copyDownloadInfoMap;

                public AnonymousClass1(SparseArray sparseArray3, SparseArray sparseArray22, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback2) {
                    sparseArray = sparseArray3;
                    sparseArray2 = sparseArray22;
                    sqlCacheLoadCompleteCallback = sqlCacheLoadCompleteCallback2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    /*
                        Method dump skipped, instructions count: 890
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass1.run():void");
                }
            };
            ExecutorService dBThreadExecutorService = DownloadComponentManager.getDBThreadExecutorService();
            if (dBThreadExecutorService != null) {
                dBThreadExecutorService.execute(anonymousClass1);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
