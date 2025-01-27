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
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ SqlCacheLoadCompleteCallback val$callback;
        final /* synthetic */ SparseArray val$copyChunkListMap;
        final /* synthetic */ SparseArray val$copyDownloadInfoMap;

        AnonymousClass1(SparseArray sparseArray, SparseArray sparseArray2, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
            sparseArray = sparseArray;
            sparseArray2 = sparseArray2;
            sqlCacheLoadCompleteCallback = sqlCacheLoadCompleteCallback;
        }

        /* JADX WARN: Code restructure failed: missing block: B:136:0x0271, code lost:
        
            if (r0 == null) goto L290;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x027b, code lost:
        
            if (r0 == null) goto L290;
         */
        /* JADX WARN: Code restructure failed: missing block: B:180:0x0336, code lost:
        
            if (r0 == null) goto L373;
         */
        /* JADX WARN: Code restructure failed: missing block: B:181:0x0349, code lost:
        
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.onInitFinish(r2, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:182:0x0352, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:183:0x0341, code lost:
        
            r0.callback();
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.cacheSynced = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:188:0x033f, code lost:
        
            if (r0 == null) goto L373;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x019b, code lost:
        
            if (r0 != null) goto L289;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x01ae, code lost:
        
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.onInitFinish(r2, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x027f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x01a6, code lost:
        
            r0.callback();
            com.ss.android.socialbase.downloader.db.SqlDownloadCache.this.cacheSynced = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x01a4, code lost:
        
            if (r0 == null) goto L290;
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00da A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00ca A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 879
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass1.run():void");
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$10 */
    class AnonymousClass10 implements Runnable {
        AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCache.this.clearDataInSubThread();
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ ContentValues val$cv;
        final /* synthetic */ int val$id;

        AnonymousClass11(int i2, ContentValues contentValues) {
            i2 = i2;
            contentValues = contentValues;
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCache.this.updateInner(i2, contentValues);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int val$id;

        AnonymousClass2(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SqlDownloadCache.this.deleteInner(i2, SqlDownloadCache.this.chunkTableStatements.getDeleteStatement());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ DownloadChunk val$chunk;

        AnonymousClass3(DownloadChunk downloadChunk) {
            downloadChunk = downloadChunk;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SqlDownloadCache.this.insertDownloadChunkInner(downloadChunk, SqlDownloadCache.this.chunkTableStatements.getInsertStatement());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ int val$chunkIndex;
        final /* synthetic */ long val$currentOffset;
        final /* synthetic */ int val$id;

        AnonymousClass4(int i2, int i3, long j2) {
            i2 = i2;
            i3 = i3;
            j2 = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SqlDownloadCache.this.updateDownloadChunkInner(i2, i3, j2, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ int val$chunkIndex;
        final /* synthetic */ long val$currentOffset;
        final /* synthetic */ int val$hostChunkIndex;
        final /* synthetic */ int val$id;

        AnonymousClass5(int i2, int i3, int i4, long j2) {
            i2 = i2;
            i3 = i3;
            i4 = i4;
            j2 = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SqlDownloadCache.this.updateSubDownloadChunkInner(i2, i3, i4, j2, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ int val$chunkIndex;
        final /* synthetic */ int val$hostChunkIndex;
        final /* synthetic */ int val$id;
        final /* synthetic */ int val$newChunkIndex;

        AnonymousClass6(int i2, int i3, int i4, int i5) {
            i2 = i2;
            i3 = i3;
            i4 = i4;
            i5 = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SqlDownloadCache.this.updateSubDownloadChunkIndexInner(i2, i3, i4, i5, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ DownloadInfo val$downloadInfo;

        AnonymousClass7(DownloadInfo downloadInfo) {
            downloadInfo = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SqlDownloadCache sqlDownloadCache = SqlDownloadCache.this;
                sqlDownloadCache.insertDownloadInfoInner(downloadInfo, sqlDownloadCache.downloadTableStatements.getInsertStatement());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ DownloadInfo val$downloadInfo;

        AnonymousClass8(DownloadInfo downloadInfo) {
            downloadInfo = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCache.this.updateDownloadInfoForCurrentThread(downloadInfo);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$9 */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ int val$id;

        AnonymousClass9(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCache.this.removeDownloadInfo(i2);
            SqlDownloadCache.this.removeAllDownloadChunk(i2);
            SqlDownloadCache.this.removeSegments(i2);
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

            AnonymousClass7(DownloadInfo downloadInfo2) {
                downloadInfo = downloadInfo2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache sqlDownloadCache = SqlDownloadCache.this;
                    sqlDownloadCache.insertDownloadInfoInner(downloadInfo, sqlDownloadCache.downloadTableStatements.getInsertStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
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

    public void deleteInner(int i2, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i2);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ensureDataBaseInit() {
        if (database == null) {
            synchronized (SqlDownloadCache.class) {
                if (database == null) {
                    try {
                        database = DownloadDBHelper.getInstance().getWritableDatabase();
                        this.downloadTableStatements = new TableStatements(database, DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.DOWNLOAD_ALL_COLUMNS, DBDefinition.DOWNLOAD_PK_COLUMNS);
                        this.chunkTableStatements = new TableStatements(database, DBDefinition.CHUNK_TABLE_NAME, DBDefinition.CHUNK_ALL_COLUMNS, DBDefinition.CHUNK_PK_COLUMNS);
                        this.segmentTableStatements = new TableStatements(database, DBDefinition.SEGMENT_TABLE_NAME, DBDefinition.SEGMENT_ALL_COLUMNS, DBDefinition.SEGMENT_PK_COLUMNS);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
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
        } catch (Throwable th) {
            th.printStackTrace();
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
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void loadCacheFromDB(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<DownloadChunk>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || database == null) {
            return;
        }
        synchronized (database) {
            try {
                try {
                    safeBeginTransaction();
                    if (!list.isEmpty()) {
                        if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_CLEAR_INVALID_TASK_ERROR)) {
                            String[] strArr = new String[list.size()];
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                strArr[i2] = String.valueOf(list.get(i2));
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
                    for (int i3 = 0; i3 < size; i3++) {
                        int keyAt = sparseArray.keyAt(i3);
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
                        for (int i4 = 0; i4 < size2; i4++) {
                            int id = sparseArray2.valueAt(i4).getId();
                            List<DownloadChunk> parseHostChunkList = DownloadUtils.parseHostChunkList(getDownloadChunk(id));
                            if (parseHostChunkList != null && parseHostChunkList.size() > 0) {
                                sparseArray3.put(id, parseHostChunkList);
                            }
                        }
                    }
                    database.setTransactionSuccessful();
                } finally {
                    try {
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
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
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void update(int i2, ContentValues contentValues) {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.11
            final /* synthetic */ ContentValues val$cv;
            final /* synthetic */ int val$id;

            AnonymousClass11(int i22, ContentValues contentValues2) {
                i2 = i22;
                contentValues = contentValues2;
            }

            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.updateInner(i2, contentValues);
            }
        });
    }

    public void updateDownloadChunkInner(int i2, int i3, long j2, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBDefinition.CUR_OFFSET, Long.valueOf(j2));
                database.update(DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
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
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                addDownloadInfo(downloadInfo);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
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
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void updateInner(int i2, ContentValues contentValues) {
        int i3 = 10;
        while (database.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        try {
            database.update(DBDefinition.DOWNLOAD_TABLE_NAME, contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public void updateSubDownloadChunkIndexInner(int i2, int i3, int i4, int i5, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBDefinition.CHUNK_INDEX, Integer.valueOf(i5));
                database.update(DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void updateSubDownloadChunkInner(int i2, int i3, int i4, long j2, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBDefinition.CUR_OFFSET, Long.valueOf(j2));
                database.update(DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskCancel(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j2));
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskCompleted(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j2));
        contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        contentValues.put(DBDefinition.FIRST_SUCCESS, (Integer) 0);
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskConnected(int i2, long j2, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put(DBDefinition.TOTAL_BYTES, Long.valueOf(j2));
        contentValues.put(DBDefinition.ETAG, str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskError(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j2));
        if (j2 > 0) {
            contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        }
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskIntercept(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskPause(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j2));
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskPrepare(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskProgress(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j2));
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskRetry(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        update(i2, contentValues);
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

            AnonymousClass3(DownloadChunk downloadChunk2) {
                downloadChunk = downloadChunk2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.insertDownloadChunkInner(downloadChunk, SqlDownloadCache.this.chunkTableStatements.getInsertStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void addSubDownloadChunk(DownloadChunk downloadChunk) {
        addDownloadChunk(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean cacheExist(int i2) {
        try {
            return getDownloadInfo(i2) != null;
        } catch (Throwable th) {
            th.printStackTrace();
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
            AnonymousClass10() {
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
    public List<DownloadChunk> getDownloadChunk(int i2) {
        ArrayList arrayList = new ArrayList();
        ensureDataBaseInit();
        if (database != null) {
            Cursor cursor = null;
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.CHUNK_TABLE_NAME, "_id"), new String[]{Integer.toString(i2)});
                while (cursor.moveToNext()) {
                    arrayList.add(new DownloadChunk(cursor));
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo getDownloadInfo(int i2) {
        Cursor cursor;
        ensureDataBaseInit();
        if (database != null) {
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.DOWNLOAD_TABLE_NAME, "_id"), new String[]{Integer.toString(i2)});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
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
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
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
    public Map<Long, Segment> getSegmentMap(int i2) {
        Cursor cursor;
        ensureDataBaseInit();
        if (database != null) {
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.SEGMENT_TABLE_NAME, "_id"), new String[]{Integer.toString(i2)});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    int columnIndex = cursor.getColumnIndex(DBDefinition.SEGMENT_INFO);
                    String string = columnIndex >= 0 ? cursor.getString(columnIndex) : null;
                    HashMap hashMap = new HashMap();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        Segment segment = new Segment(jSONArray.getJSONObject(i3));
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
    public DownloadInfo onDownloadTaskStart(int i2) {
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
    public void removeAllDownloadChunk(int i2) {
        ensureDataBaseInit();
        if (database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.2
            final /* synthetic */ int val$id;

            AnonymousClass2(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.deleteInner(i2, SqlDownloadCache.this.chunkTableStatements.getDeleteStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean removeDownloadInfo(int i2) {
        TableStatements tableStatements;
        ensureDataBaseInit();
        if (database != null && (tableStatements = this.downloadTableStatements) != null) {
            try {
                deleteInner(i2, tableStatements.getDeleteStatement());
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean removeDownloadTaskData(int i2) {
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.9
            final /* synthetic */ int val$id;

            AnonymousClass9(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.removeDownloadInfo(i2);
                SqlDownloadCache.this.removeAllDownloadChunk(i2);
                SqlDownloadCache.this.removeSegments(i2);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i2) {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        try {
            deleteInner(i2, this.segmentTableStatements.getDeleteStatement());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) {
        this.callback = iSqlCacheLoadCompleteCallbackAidl;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadChunks(int i2, List<DownloadChunk> list) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadInfoFromOtherCache(int i2, List<DownloadChunk> list) {
        try {
            removeAllDownloadChunk(i2);
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
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo updateChunkCount(int i2, int i3) {
        ensureDataBaseInit();
        if (database == null) {
            return null;
        }
        int i4 = 10;
        while (database.isDbLockedByCurrentThread() && i4 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBDefinition.CHUNK_COUNT, Integer.valueOf(i3));
        database.update(DBDefinition.DOWNLOAD_TABLE_NAME, contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateDownloadChunk(int i2, int i3, long j2) {
        ensureDataBaseInit();
        if (i2 == 0 || i3 < 0 || j2 < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.4
            final /* synthetic */ int val$chunkIndex;
            final /* synthetic */ long val$currentOffset;
            final /* synthetic */ int val$id;

            AnonymousClass4(int i22, int i32, long j22) {
                i2 = i22;
                i3 = i32;
                j2 = j22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.updateDownloadChunkInner(i2, i3, j2, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
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

            AnonymousClass8(DownloadInfo downloadInfo2) {
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
    public boolean updateSegments(int i2, Map<Long, Segment> map) {
        long currentTimeMillis = System.currentTimeMillis();
        ensureDataBaseInit();
        if (database == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.put(map.get(Long.valueOf(it.next().longValue())).toJson());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.d("SqlDownloadCache", "json=" + jSONArray);
        SQLiteStatement insertOrReplaceStatement = this.segmentTableStatements.getInsertOrReplaceStatement();
        synchronized (insertOrReplaceStatement) {
            insertOrReplaceStatement.clearBindings();
            insertOrReplaceStatement.bindLong(1, i2);
            insertOrReplaceStatement.bindString(2, jSONArray.toString());
            insertOrReplaceStatement.execute();
        }
        Logger.d("SqlDownloadCache", "updateSegments cost=" + DownloadUtils.cost(currentTimeMillis));
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateSubDownloadChunk(int i2, int i3, int i4, long j2) {
        ensureDataBaseInit();
        if (i2 == 0 || i3 < 0 || i4 < 0 || j2 < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.5
            final /* synthetic */ int val$chunkIndex;
            final /* synthetic */ long val$currentOffset;
            final /* synthetic */ int val$hostChunkIndex;
            final /* synthetic */ int val$id;

            AnonymousClass5(int i22, int i32, int i42, long j22) {
                i2 = i22;
                i3 = i32;
                i4 = i42;
                j2 = j22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.updateSubDownloadChunkInner(i2, i3, i4, j2, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateSubDownloadChunkIndex(int i2, int i3, int i4, int i5) {
        ensureDataBaseInit();
        if (i2 == 0 || i4 < 0 || i5 == i3 || i5 < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.6
            final /* synthetic */ int val$chunkIndex;
            final /* synthetic */ int val$hostChunkIndex;
            final /* synthetic */ int val$id;
            final /* synthetic */ int val$newChunkIndex;

            AnonymousClass6(int i22, int i32, int i42, int i52) {
                i2 = i22;
                i3 = i32;
                i4 = i42;
                i5 = i52;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.updateSubDownloadChunkIndexInner(i2, i3, i4, i5, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public SqlDownloadCache(boolean z) {
        this.callback = null;
        if (z) {
            this.cacheSynced = false;
            init();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public ArrayList<Segment> getSegments(int i2) {
        Map<Long, Segment> segmentMap = getSegmentMap(i2);
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

                AnonymousClass1(SparseArray sparseArray3, SparseArray sparseArray22, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback2) {
                    sparseArray = sparseArray3;
                    sparseArray2 = sparseArray22;
                    sqlCacheLoadCompleteCallback = sqlCacheLoadCompleteCallback2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    /*
                        Method dump skipped, instructions count: 879
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass1.run():void");
                }
            };
            ExecutorService dBThreadExecutorService = DownloadComponentManager.getDBThreadExecutorService();
            if (dBThreadExecutorService != null) {
                dBThreadExecutorService.execute(anonymousClass1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
