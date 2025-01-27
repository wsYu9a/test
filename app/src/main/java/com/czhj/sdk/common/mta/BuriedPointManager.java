package com.czhj.sdk.common.mta;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Base64;
import b5.a;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.common.network.BuriedPointRequest;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.DeflaterOutputStream;

/* loaded from: classes2.dex */
public class BuriedPointManager {

    /* renamed from: i */
    public static final int f8471i = 500000;

    /* renamed from: j */
    public static BuriedPointManager f8472j;

    /* renamed from: d */
    public volatile boolean f8476d;

    /* renamed from: f */
    public SQLiteDatabase f8478f;

    /* renamed from: g */
    public int f8479g;

    /* renamed from: h */
    public RepeatingHandlerRunnable f8480h;

    /* renamed from: a */
    public final ReadWriteLock f8473a = new ReentrantReadWriteLock();

    /* renamed from: b */
    public HashMap<Integer, String> f8474b = null;

    /* renamed from: c */
    public List<String> f8475c = null;

    /* renamed from: e */
    public Set<Integer> f8477e = new HashSet();

    /* renamed from: com.czhj.sdk.common.mta.BuriedPointManager$1 */
    public class AnonymousClass1 extends RepeatingHandlerRunnable {
        public AnonymousClass1(Handler handler) {
            super(handler);
        }

        @Override // com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable
        public void doWork() {
            try {
                BuriedPointManager.this.sendPoint();
                BuriedPointManager.this.f8480h.startRepeating(Config.sharedInstance().getSend_log_interval() * 1000);
            } catch (Throwable th2) {
                SigmobLog.e("retryFaildTracking error " + th2.getMessage());
            }
        }
    }

    /* renamed from: com.czhj.sdk.common.mta.BuriedPointManager$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BuriedPointManager.this.c();
            BuriedPointManager.this.a();
        }
    }

    /* renamed from: com.czhj.sdk.common.mta.BuriedPointManager$3 */
    public class AnonymousClass3 implements BuriedPointRequest.RequestListener {

        /* renamed from: a */
        public final /* synthetic */ boolean f8483a;

        /* renamed from: com.czhj.sdk.common.mta.BuriedPointManager$3$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BuriedPointManager.this.b();
            }
        }

        public AnonymousClass3(boolean z10) {
            z10 = z10;
        }

        @Override // com.czhj.sdk.common.network.BuriedPointRequest.RequestListener
        public void onErrorResponse(VolleyError volleyError) {
            BuriedPointManager.this.f8476d = false;
            BuriedPointManager.this.f8474b = null;
            SigmobLog.e(volleyError.getMessage());
        }

        @Override // com.czhj.sdk.common.network.BuriedPointRequest.RequestListener
        public void onSuccess() {
            if (z10) {
                ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.mta.BuriedPointManager.3.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        BuriedPointManager.this.b();
                    }
                });
            }
        }
    }

    public static String deflateAndBase64(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        deflaterOutputStream.write(str.getBytes(Charset.forName("UTF-8")));
        deflaterOutputStream.flush();
        deflaterOutputStream.close();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    public static BuriedPointManager getInstance() {
        BuriedPointManager buriedPointManager;
        synchronized (BuriedPointManager.class) {
            try {
                if (f8472j == null) {
                    f8472j = new BuriedPointManager();
                }
                buriedPointManager = f8472j;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return buriedPointManager;
    }

    public void addWaitSend(String str) {
        if (this.f8475c == null) {
            this.f8475c = new LinkedList();
        }
        this.f8475c.add(str);
    }

    public void clearLogDB() {
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.mta.BuriedPointManager.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BuriedPointManager.this.c();
                BuriedPointManager.this.a();
            }
        });
    }

    public final String e() {
        StringBuilder sb2 = new StringBuilder();
        List<String> list = this.f8475c;
        if (list != null && list.size() > 0) {
            this.f8479g = this.f8475c.size();
            Iterator<String> it = this.f8475c.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                if (it.hasNext()) {
                    sb2.append(",");
                }
            }
        }
        return sb2.toString();
    }

    public Set<Integer> getLogBlackList() {
        return this.f8477e;
    }

    public String sendPoint() {
        HashMap<Integer, String> hashMap;
        String str = null;
        try {
            this.f8473a.readLock().lock();
        } finally {
            try {
                return str;
            } finally {
            }
        }
        if (!this.f8476d && ((hashMap = this.f8474b) == null || hashMap.size() <= 0)) {
            StringBuilder sb2 = new StringBuilder();
            HashMap<Integer, String> a10 = a(Config.sharedInstance().getMax_send_log_records());
            this.f8474b = a10;
            if (a10.size() != 0) {
                sb2.append("[");
                Iterator<String> it = this.f8474b.values().iterator();
                while (it.hasNext()) {
                    sb2.append(it.next());
                    if (it.hasNext()) {
                        sb2.append(",");
                    }
                }
                sb2.append("]");
                String sb3 = sb2.toString();
                String str2 = "_batch_value=" + sb3;
                try {
                    SigmobLog.d("_batch_value: " + sb3);
                    SigmobLog.d("BPLog_Count: " + this.f8474b.size());
                    str = PointEntitySuper.toURLEncoded(deflateAndBase64(str2));
                    a(str, true);
                } catch (IOException e10) {
                    SigmobLog.e(e10.getMessage());
                }
                return str;
            }
        }
        return null;
    }

    public void start() {
        if (this.f8478f == null || this.f8480h == null) {
            this.f8478f = SQLiteMTAHelper.getInstance().getWritableDatabase();
            clearLogDB();
            HandlerThread handlerThread = new HandlerThread("sendLog");
            handlerThread.start();
            AnonymousClass1 anonymousClass1 = new RepeatingHandlerRunnable(new Handler(handlerThread.getLooper())) { // from class: com.czhj.sdk.common.mta.BuriedPointManager.1
                public AnonymousClass1(Handler handler) {
                    super(handler);
                }

                @Override // com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable
                public void doWork() {
                    try {
                        BuriedPointManager.this.sendPoint();
                        BuriedPointManager.this.f8480h.startRepeating(Config.sharedInstance().getSend_log_interval() * 1000);
                    } catch (Throwable th2) {
                        SigmobLog.e("retryFaildTracking error " + th2.getMessage());
                    }
                }
            };
            this.f8480h = anonymousClass1;
            anonymousClass1.startRepeating(Config.sharedInstance().getSend_log_interval() * 1000);
        }
    }

    public final void b() {
        this.f8473a.writeLock().lock();
        HashMap<Integer, String> hashMap = this.f8474b;
        if (hashMap != null && hashMap.size() != 0) {
            a(this.f8474b.keySet());
            this.f8476d = false;
            this.f8474b = null;
        }
        this.f8473a.writeLock().unlock();
    }

    public final void c() {
        try {
            this.f8478f.execSQL("delete from " + SQLiteMTAHelper.TABLE_POINT + " where item is null");
        } catch (Throwable th2) {
            SigmobLog.e("clearLogDB fail", th2);
        }
    }

    public final void d() {
        List<String> list = this.f8475c;
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = this.f8475c.size();
        int i10 = this.f8479g;
        if (size > i10) {
            this.f8475c = this.f8475c.subList(i10, r0.size() - 1);
        } else {
            this.f8475c.clear();
        }
        this.f8479g = 0;
    }

    public final void a() {
        try {
            long queryNumEntries = DatabaseUtils.queryNumEntries(this.f8478f, SQLiteMTAHelper.TABLE_POINT);
            if (queryNumEntries <= 500000) {
                return;
            }
            a(queryNumEntries - 500000);
        } catch (Throwable th2) {
            SigmobLog.e("clearLogDB fail", th2);
        }
    }

    public final void a(long j10) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("delete from ");
            sb2.append(SQLiteMTAHelper.TABLE_POINT);
            sb2.append(" where point_id in ( ");
            sb2.append(" select point_id from ");
            sb2.append(SQLiteMTAHelper.TABLE_POINT);
            sb2.append(" order by point_id ");
            sb2.append(" limit " + j10);
            sb2.append(" )");
            this.f8478f.execSQL(sb2.toString());
        } catch (Throwable th2) {
            SigmobLog.e("clearLogDB fail", th2);
        }
    }

    public final void a(Set<Integer> set) {
        try {
            Iterator<Integer> it = set.iterator();
            if (!it.hasNext()) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("delete from ");
            sb2.append(SQLiteMTAHelper.TABLE_POINT);
            sb2.append(" where point_id in ( ");
            while (true) {
                sb2.append(it.next());
                if (!it.hasNext()) {
                    sb2.append(" )");
                    this.f8478f.execSQL(sb2.toString());
                    return;
                } else {
                    sb2.append(',');
                    sb2.append(a.O);
                }
            }
        } catch (Throwable th2) {
            SigmobLog.e("clearLogDB fail", th2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (r1 != null) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.HashMap<java.lang.Integer, java.lang.String> a(int r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> L75
            r0.<init>()     // Catch: java.lang.Throwable -> L75
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f8478f     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = "select * from point where item not null order by point_id"
            android.database.Cursor r1 = r2.rawQuery(r3, r1)     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L67
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L67
            java.lang.String r2 = "item"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = "point_id"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "encryption"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L5b
            r5 = 0
        L2a:
            if (r5 >= r11) goto L67
            java.lang.String r6 = r1.getString(r2)     // Catch: java.lang.Throwable -> L5b
            int r7 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L5b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L5b
            int r8 = r1.getInt(r4)     // Catch: java.lang.Throwable -> L5b
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L5b
            if (r9 != 0) goto L5d
            r9 = 1
            if (r8 != r9) goto L57
            java.lang.String r8 = "sigandroid_mtadb"
            java.lang.String r8 = com.czhj.sdk.common.utils.AESUtil.DecryptString(r6, r8)     // Catch: java.lang.Throwable -> L5b
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L5b
            if (r8 != 0) goto L5d
            java.lang.String r8 = "sigandroid_mtadb"
            java.lang.String r6 = com.czhj.sdk.common.utils.AESUtil.DecryptString(r6, r8)     // Catch: java.lang.Throwable -> L5b
        L57:
            r0.put(r7, r6)     // Catch: java.lang.Throwable -> L5b
            goto L5d
        L5b:
            r11 = move-exception
            goto L6a
        L5d:
            boolean r6 = r1.moveToNext()     // Catch: java.lang.Throwable -> L5b
            if (r6 != 0) goto L64
            goto L67
        L64:
            int r5 = r5 + 1
            goto L2a
        L67:
            if (r1 == 0) goto L77
            goto L71
        L6a:
            java.lang.String r2 = "getlogs fail"
            com.czhj.sdk.logger.SigmobLog.e(r2, r11)     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto L77
        L71:
            r1.close()     // Catch: java.lang.Throwable -> L75
            goto L77
        L75:
            r11 = move-exception
            goto L80
        L77:
            monitor-exit(r10)
            return r0
        L79:
            r11 = move-exception
            if (r1 == 0) goto L7f
            r1.close()     // Catch: java.lang.Throwable -> L75
        L7f:
            throw r11     // Catch: java.lang.Throwable -> L75
        L80:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.mta.BuriedPointManager.a(int):java.util.HashMap");
    }

    public final void a(String str, boolean z10) {
        this.f8476d = true;
        BuriedPointRequest.BuriedPointSend(str, new BuriedPointRequest.RequestListener() { // from class: com.czhj.sdk.common.mta.BuriedPointManager.3

            /* renamed from: a */
            public final /* synthetic */ boolean f8483a;

            /* renamed from: com.czhj.sdk.common.mta.BuriedPointManager$3$1 */
            public class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    BuriedPointManager.this.b();
                }
            }

            public AnonymousClass3(boolean z102) {
                z10 = z102;
            }

            @Override // com.czhj.sdk.common.network.BuriedPointRequest.RequestListener
            public void onErrorResponse(VolleyError volleyError) {
                BuriedPointManager.this.f8476d = false;
                BuriedPointManager.this.f8474b = null;
                SigmobLog.e(volleyError.getMessage());
            }

            @Override // com.czhj.sdk.common.network.BuriedPointRequest.RequestListener
            public void onSuccess() {
                if (z10) {
                    ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.mta.BuriedPointManager.3.1
                        public AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            BuriedPointManager.this.b();
                        }
                    });
                }
            }
        });
    }
}
