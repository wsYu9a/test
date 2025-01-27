package com.vivo.ic.dm;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.vivo.ic.BaseLib;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.dm.impl.DownloadLifeListener;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class DownloadManager {
    private static final String TAG = Constants.PRE_TAG + "DownloadManager";
    private static final DownloadManager sInstance = new DownloadManager();
    private ContentResolver mContentResolver;
    private Context mContext;
    private Handler mDownloadHandler;
    private HandlerThread mDownloadThread;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DownloadManager.this.getDownloadingCount() > 0) {
                com.vivo.ic.dm.util.e.b(DownloadManager.this.mContext, "DownloadManager init");
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f28343a;

        /* renamed from: b */
        final /* synthetic */ String[] f28344b;

        b(String str, String[] strArr) {
            this.f28343a = str;
            this.f28344b = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadManager.this.pauseDownload(this.f28343a, this.f28344b);
        }
    }

    class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f28346a;

        /* renamed from: b */
        final /* synthetic */ String[] f28347b;

        c(String str, String[] strArr) {
            this.f28346a = str;
            this.f28347b = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadManager.this.continueDownload(this.f28346a, this.f28347b);
        }
    }

    class d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ContentValues f28349a;

        d(ContentValues contentValues) {
            this.f28349a = contentValues;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadManager.this.startDownload(this.f28349a);
        }
    }

    class e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f28351a;

        /* renamed from: b */
        final /* synthetic */ String[] f28352b;

        e(String str, String[] strArr) {
            this.f28351a = str;
            this.f28352b = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadManager.this.cancelDownload(this.f28351a, this.f28352b);
        }
    }

    private DownloadManager() {
        HandlerThread handlerThread = new HandlerThread("download_queue");
        this.mDownloadThread = handlerThread;
        handlerThread.start();
        this.mDownloadHandler = new Handler(this.mDownloadThread.getLooper());
        VLog.i(TAG, "************* lib_dm_multi version : v3.4.8.1 *************");
    }

    private String appendStatusFilter(String str) {
        if (TextUtils.isEmpty(str)) {
            return "status != 200";
        }
        return str + " and status != 200";
    }

    private boolean checkParams(ContentValues contentValues) {
        if (contentValues == null || contentValues.size() <= 0) {
            return false;
        }
        return !TextUtils.isEmpty(contentValues.getAsString("uri"));
    }

    private void encodeHttpHeaders(ContentValues contentValues, ContentValues contentValues2) {
        int i2 = 0;
        for (Map.Entry<String, Object> entry : contentValues2.valueSet()) {
            contentValues.put(Downloads.RequestHeaders.INSERT_KEY_PREFIX + i2, entry.getKey() + ": " + entry.getValue().toString());
            i2++;
        }
    }

    public int getDownloadingCount() {
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContentResolver.query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "control = ? and status != ?", new String[]{String.valueOf(0), String.valueOf(200)}, null);
            } catch (Exception e2) {
                VLog.w(TAG, "getDownloadingCount error ", e2);
                if (cursor == null) {
                    return -1;
                }
            }
            if (cursor != null) {
                int count = cursor.getCount();
                cursor.close();
                return count;
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private List<Long> getIdsByArgs(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = 0;
        for (String str2 : str.split("\\sand\\s|\\sor\\s")) {
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split("=");
                if (split.length < 2) {
                    continue;
                } else {
                    String str3 = split[1];
                    String str4 = split[0];
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        if ("_id".equals(str4.trim())) {
                            String str5 = !str3.trim().equals("?") ? str3 : i2 < strArr.length ? strArr[i2] : null;
                            if (!TextUtils.isEmpty(str5)) {
                                ArrayList arrayList = new ArrayList(1);
                                try {
                                    arrayList.add(Long.valueOf(Long.parseLong(str5.trim())));
                                    return arrayList;
                                } catch (Exception unused) {
                                    return null;
                                }
                            }
                        }
                        if (str3.trim().equals("?")) {
                            i2++;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static DownloadManager getInstance() {
        return sInstance;
    }

    public void addDownloadListener(DownloadLifeListener downloadLifeListener) {
        f.b().a(downloadLifeListener);
    }

    public int cancel(long j2) {
        if (j2 < 0) {
            return -1;
        }
        return cancel("_id", Long.toString(j2));
    }

    public int cancelDownload(String str, String[] strArr) {
        int i2;
        try {
            i2 = this.mContentResolver.delete(Downloads.Impl.CONTENT_URI, str, strArr);
        } catch (Exception e2) {
            VLog.w(TAG, " error", e2);
            i2 = -1;
        }
        if (i2 > 0) {
            com.vivo.ic.dm.datareport.a.a().b(getIdsByArgs(str, strArr), i2);
        }
        return i2;
    }

    public void cancelDownloadInQueue(String str, String[] strArr) {
        this.mDownloadHandler.post(new e(str, strArr));
    }

    public void clear() {
        f.b().a();
    }

    @Deprecated
    public void continueDownload(String str, String[] strArr) {
        continueDownload(str, strArr, null);
    }

    @Deprecated
    public void continueDownloadInQueue(String str, String[] strArr) {
        this.mDownloadHandler.post(new c(str, strArr));
    }

    public String getDataAnalyticsAppId() {
        return com.vivo.ic.dm.b.f28400d;
    }

    public Handler getDownloadQueue() {
        return this.mDownloadHandler;
    }

    public int getDualWifiInfoType() {
        return com.vivo.ic.dm.network.h.a().a(this.mContext);
    }

    public String getSDKVersion() {
        return com.vivo.ic.dm.b.f28402f;
    }

    public void hideAllNotification(int i2) {
        DownloadNotifier m = l.j().m();
        if (m != null) {
            m.cancelAllNotification(i2);
        }
    }

    public void hideNetPauseNotification() {
        DownloadNotifier m = l.j().m();
        if (m != null) {
            m.hideNetPauseNotification();
        }
    }

    public void init(DownloadConfig downloadConfig) {
        if (downloadConfig == null) {
            throw new NullPointerException("config can not be null");
        }
        Constants.PRE_TAG += BaseLib.getContext().getPackageName() + "-";
        Context context = BaseLib.getContext();
        this.mContext = context;
        if (context == null) {
            throw new RuntimeException("初始化异常，请优先执行CommonLib初始化（BaseLib.init）");
        }
        com.vivo.ic.dm.p.b.b().a(this.mContext);
        String str = TAG;
        VLog.i(str, "init config:" + downloadConfig);
        l.j().a(downloadConfig);
        Downloads.Impl.setAuthor(this.mContext.getPackageName() + ".ICDM");
        this.mContentResolver = this.mContext.getContentResolver();
        if (l.j().p()) {
            this.mDownloadHandler.post(new a());
        } else {
            VLog.w(str, "abort auto start up download service");
        }
    }

    @Deprecated
    public void initBaseLib(Application application, String str) {
        BaseLib.init(application, str);
        Downloads.Impl.setAuthor(application.getPackageName() + ".ICDM");
    }

    public int pause(long j2) {
        if (j2 < 0) {
            return -1;
        }
        return pause("_id", Long.toString(j2));
    }

    public int pauseDownload(String str, String[] strArr) {
        int i2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(Downloads.Impl.STATUS_PAUSED_BY_APP));
        contentValues.put(Downloads.Column.CONTROL, (Integer) 1);
        try {
            i2 = this.mContext.getContentResolver().update(Downloads.Impl.CONTENT_URI, contentValues, str, strArr);
        } catch (Exception e2) {
            VLog.w(TAG, "pauseDownload error", e2);
            i2 = -1;
        }
        if (i2 > 0) {
            com.vivo.ic.dm.datareport.a.a().c(getIdsByArgs(str, strArr), 2);
        }
        return i2;
    }

    public void pauseDownloadInqueue(String str, String[] strArr) {
        this.mDownloadHandler.post(new b(str, strArr));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
    
        if (r1 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0058, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
    
        if (r1 == null) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.vivo.ic.dm.DownloadInfo> queryDownloads(java.lang.String r9, java.lang.String[] r10, java.lang.String r11) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.ContentResolver r2 = r8.mContentResolver     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            android.net.Uri r3 = com.vivo.ic.dm.Downloads.Impl.CONTENT_URI     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r4 = 0
            r5 = r9
            r6 = r10
            r7 = r11
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r1 == 0) goto L2b
            com.vivo.ic.dm.DownloadInfo$Reader r11 = new com.vivo.ic.dm.DownloadInfo$Reader     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            android.content.ContentResolver r2 = r8.mContentResolver     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r11.<init>(r2, r1)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
        L1b:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r2 == 0) goto L2b
            android.content.Context r2 = r8.mContext     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            com.vivo.ic.dm.DownloadInfo r2 = r11.newDownloadInfo(r2)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r0.add(r2)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            goto L1b
        L2b:
            if (r1 == 0) goto L58
            goto L55
        L2e:
            r9 = move-exception
            goto L59
        L30:
            r11 = move-exception
            java.lang.String r2 = com.vivo.ic.dm.DownloadManager.TAG     // Catch: java.lang.Throwable -> L2e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r3.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = "queryAllDownloads error by ["
            r3.append(r4)     // Catch: java.lang.Throwable -> L2e
            r3.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = "], "
            r3.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = java.util.Arrays.toString(r10)     // Catch: java.lang.Throwable -> L2e
            r3.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = r3.toString()     // Catch: java.lang.Throwable -> L2e
            com.vivo.ic.VLog.w(r2, r9, r11)     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L58
        L55:
            r1.close()
        L58:
            return r0
        L59:
            if (r1 == 0) goto L5e
            r1.close()
        L5e:
            goto L60
        L5f:
            throw r9
        L60:
            goto L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.DownloadManager.queryDownloads(java.lang.String, java.lang.String[], java.lang.String):java.util.List");
    }

    public void removeDownloadListener(DownloadLifeListener downloadLifeListener) {
        f.b().b(downloadLifeListener);
    }

    public int resume(long j2) {
        if (j2 < 0) {
            return -1;
        }
        return resume("_id", Long.toString(j2));
    }

    public int resumeWithConditions(String str, String str2, ContentValues contentValues) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        ContentValues contentValues2 = new ContentValues();
        m.a(Downloads.Column.COLUMN_ALLOWED_NETWORK_TYPES, contentValues, contentValues2);
        m.a(Downloads.Column.IGNORE_HTTPS_VERIFY, contentValues, contentValues2);
        m.a(Downloads.Column.VISIBILITY, contentValues, contentValues2);
        return resume(str, str2, contentValues2);
    }

    public int resumeWithNetWork(String str, String str2, Integer num) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        if (num != null) {
            contentValues.put(Downloads.Column.COLUMN_ALLOWED_NETWORK_TYPES, num);
        }
        return resume(str, str2, contentValues);
    }

    public void setNetProxy(Proxy proxy) {
        l.j().a(proxy);
    }

    public void setProxyAuth(DownloadInfo downloadInfo, String str) {
        downloadInfo.setProxyAuth(str);
    }

    public void showNetPauseNotification() {
        DownloadNotifier m = l.j().m();
        if (m != null) {
            m.showNetPauseNotification();
        }
    }

    public long start(ContentValues contentValues) {
        return start(contentValues, null);
    }

    public void startDownload(ContentValues contentValues) {
        contentValues.put(Downloads.Column.CONTROL, (Integer) 0);
        try {
            this.mContentResolver.insert(Downloads.Impl.CONTENT_URI, contentValues);
        } catch (Exception e2) {
            VLog.w(TAG, " error", e2);
        }
    }

    public void startDownloadInQueue(ContentValues contentValues) {
        this.mDownloadHandler.post(new d(contentValues));
    }

    public int updateDownloads(long j2, ContentValues contentValues) {
        try {
            return this.mContentResolver.update(Downloads.Impl.CONTENT_URI, contentValues, "_id=?", new String[]{String.valueOf(j2)});
        } catch (Exception e2) {
            VLog.w(TAG, " error", e2);
            return -1;
        }
    }

    public int cancel(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        return cancel(str + "=?", new String[]{str2});
    }

    @Deprecated
    public int continueDownload(String str, String[] strArr, ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        }
        contentValues.put("status", Integer.valueOf(Downloads.Impl.STATUS_PENDING));
        contentValues.put(Downloads.Column.CONTROL, (Integer) 0);
        int i2 = -1;
        try {
            i2 = this.mContentResolver.update(Downloads.Impl.CONTENT_URI, contentValues, appendStatusFilter(str), strArr);
        } catch (Exception e2) {
            VLog.w(TAG, " error", e2);
        }
        if (i2 > 0) {
            com.vivo.ic.dm.datareport.a.a().a(getIdsByArgs(str, strArr), 1);
        }
        return i2;
    }

    public int pause(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        return pause(str + "=?", new String[]{str2});
    }

    public int resume(String str, String str2) {
        return resume(str, str2, (ContentValues) null);
    }

    public long start(ContentValues contentValues, ContentValues contentValues2) {
        if (!checkParams(contentValues)) {
            return -1L;
        }
        if (contentValues2 != null && contentValues2.size() > 0) {
            encodeHttpHeaders(contentValues, contentValues2);
        }
        contentValues.put(Downloads.Column.CONTROL, (Integer) 0);
        Uri uri = null;
        try {
            uri = this.mContentResolver.insert(Downloads.Impl.CONTENT_URI, contentValues);
        } catch (Exception e2) {
            VLog.w(TAG, " error", e2);
        }
        if (uri == null) {
            return -1L;
        }
        return ContentUris.parseId(uri);
    }

    public int resume(String str, String str2, ContentValues contentValues) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        return resume(str + "=?", new String[]{str2}, contentValues);
    }

    public int cancel(String str, String[] strArr) {
        int i2;
        try {
            i2 = this.mContentResolver.delete(Downloads.Impl.CONTENT_URI, str, strArr);
        } catch (Exception e2) {
            VLog.w(TAG, " error", e2);
            i2 = -1;
        }
        if (i2 > 0) {
            com.vivo.ic.dm.datareport.a.a().b(getIdsByArgs(str, strArr), i2);
        }
        return i2;
    }

    public int pause(String str, String[] strArr) {
        int i2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(Downloads.Impl.STATUS_PAUSED_BY_APP));
        contentValues.put(Downloads.Column.CONTROL, (Integer) 1);
        try {
            i2 = this.mContext.getContentResolver().update(Downloads.Impl.CONTENT_URI, contentValues, str, strArr);
        } catch (Exception e2) {
            VLog.w(TAG, " error", e2);
            i2 = -1;
        }
        if (i2 > 0) {
            com.vivo.ic.dm.datareport.a.a().c(getIdsByArgs(str, strArr), 2);
        }
        return i2;
    }

    public int resume(String str, String[] strArr, ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        }
        contentValues.put("status", Integer.valueOf(Downloads.Impl.STATUS_PENDING));
        contentValues.put(Downloads.Column.CONTROL, (Integer) 0);
        int i2 = -1;
        try {
            i2 = this.mContentResolver.update(Downloads.Impl.CONTENT_URI, contentValues, appendStatusFilter(str), strArr);
        } catch (Exception e2) {
            VLog.w(TAG, " error", e2);
        }
        if (i2 > 0) {
            com.vivo.ic.dm.datareport.a.a().a(getIdsByArgs(str, strArr), 1);
        }
        return i2;
    }

    public long start(ContentValues contentValues, ContentValues contentValues2, String str, String str2) {
        if (contentValues2 == null) {
            contentValues2 = new ContentValues();
        }
        if (!TextUtils.isEmpty(str)) {
            contentValues2.put(com.vivo.ic.dm.network.d.f28529b, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            contentValues2.put(com.vivo.ic.dm.network.d.f28530c, str2);
        }
        return start(contentValues, contentValues2);
    }
}
