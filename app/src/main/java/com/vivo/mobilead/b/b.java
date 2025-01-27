package com.vivo.mobilead.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.vivo.mobilead.util.x0;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: f */
    private static volatile b f28647f;

    /* renamed from: a */
    private AtomicInteger f28648a = new AtomicInteger();

    /* renamed from: b */
    private com.vivo.mobilead.b.a f28649b;

    /* renamed from: c */
    private SQLiteDatabase f28650c;

    /* renamed from: d */
    private HandlerThread f28651d;

    /* renamed from: e */
    private Handler f28652e;

    class a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.b.c f28653a;

        a(com.vivo.mobilead.b.c cVar) {
            this.f28653a = cVar;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            x0.e(com.vivo.mobilead.util.f1.b.TAG, "start :" + System.currentTimeMillis());
            if (this.f28653a == null) {
                return;
            }
            try {
                try {
                    x0.e(com.vivo.mobilead.util.f1.b.TAG, "insertReportData, url: " + this.f28653a.p() + " acCoop: " + this.f28653a.a() + " detail:" + this.f28653a.l());
                    this.f28653a.a(b.this.d().insert("vivo_report_url", null, b.this.d(this.f28653a)));
                    x0.e(com.vivo.mobilead.util.f1.b.TAG, "end :" + System.currentTimeMillis());
                } catch (Exception e2) {
                    x0.b(com.vivo.mobilead.util.f1.b.TAG, "insertReportData Exception : " + e2);
                }
            } finally {
                b.this.b();
            }
        }
    }

    /* renamed from: com.vivo.mobilead.b.b$b */
    class C0572b extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.b.c f28655a;

        C0572b(com.vivo.mobilead.b.c cVar) {
            this.f28655a = cVar;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (this.f28655a == null) {
                return;
            }
            try {
                try {
                    x0.a(com.vivo.mobilead.util.f1.b.TAG, "updateRetryTimes, url: " + this.f28655a.p() + " acCoop: " + this.f28655a.a() + " rowID: " + this.f28655a.n() + " retryTimes: " + this.f28655a.m());
                    SQLiteDatabase d2 = b.this.d();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("retry_time", Integer.valueOf(this.f28655a.m()));
                    int update = d2.update("vivo_report_url", contentValues, "id = " + this.f28655a.n(), null);
                    StringBuilder sb = new StringBuilder();
                    sb.append("updateRetryTimes, ad row id = ");
                    sb.append(this.f28655a.n());
                    sb.append(" result: ");
                    sb.append(update > 0);
                    x0.a(com.vivo.mobilead.util.f1.b.TAG, sb.toString());
                } catch (Exception e2) {
                    x0.b(com.vivo.mobilead.util.f1.b.TAG, "updateRetryTimes Exception : " + e2);
                }
            } finally {
                b.this.b();
            }
        }
    }

    class c extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.b.c f28657a;

        c(com.vivo.mobilead.b.c cVar) {
            this.f28657a = cVar;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                if (this.f28657a == null) {
                    return;
                }
                try {
                    x0.a(com.vivo.mobilead.util.f1.b.TAG, "deleteReportData, url: " + this.f28657a.p() + " acCoop: " + this.f28657a.a() + " rowID: " + this.f28657a.n() + " retryTimes: " + this.f28657a.m());
                    SQLiteDatabase d2 = b.this.d();
                    new ContentValues().put("report_flag", (Integer) 2);
                    int delete = d2.delete("vivo_report_url", "id = " + this.f28657a.n(), null);
                    StringBuilder sb = new StringBuilder();
                    sb.append("markReportSuccess, ad row id = ");
                    sb.append(this.f28657a.n());
                    sb.append(" result: ");
                    sb.append(delete > 0);
                    x0.a(com.vivo.mobilead.util.f1.b.TAG, sb.toString());
                } catch (Exception e2) {
                    x0.b(com.vivo.mobilead.util.f1.b.TAG, "deleteReportData Exception : " + e2);
                }
            } finally {
                b.this.b();
            }
        }
    }

    public static b c() {
        if (f28647f == null) {
            synchronized (b.class) {
                if (f28647f == null) {
                    f28647f = new b();
                }
            }
        }
        return f28647f;
    }

    public ContentValues d(com.vivo.mobilead.b.c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", cVar.p());
        contentValues.put("report_flag", Integer.valueOf(cVar.i()));
        contentValues.put("create_time", Long.valueOf(cVar.d()));
        contentValues.put("retry_time", Integer.valueOf(cVar.m()));
        contentValues.put("coop", cVar.a());
        contentValues.put("reqId", cVar.k());
        contentValues.put("posId", cVar.h());
        contentValues.put("level", Integer.valueOf(cVar.f()));
        contentValues.put("third_report", Integer.valueOf(cVar.e()));
        if (!TextUtils.isEmpty(cVar.l())) {
            contentValues.put("reason", cVar.l());
        }
        return contentValues;
    }

    public void b(com.vivo.mobilead.b.c cVar) {
        Handler handler = this.f28652e;
        if (handler == null) {
            return;
        }
        handler.post(new a(cVar));
    }

    public synchronized void a(Context context) {
        this.f28649b = new com.vivo.mobilead.b.a(context.getApplicationContext());
        HandlerThread handlerThread = new HandlerThread("DBManger");
        this.f28651d = handlerThread;
        handlerThread.start();
        this.f28652e = new Handler(this.f28651d.getLooper());
    }

    public synchronized void b() {
        if (this.f28649b == null) {
            x0.e("DBManager", "not call DBManager init method!!");
        } else {
            if (this.f28650c == null) {
                x0.e("DBManager", "database has not opened!!");
                return;
            }
            try {
                if (this.f28648a.decrementAndGet() == 0) {
                    this.f28650c.close();
                    this.f28650c = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a(com.vivo.mobilead.b.c cVar) {
        Handler handler = this.f28652e;
        if (handler == null) {
            return;
        }
        handler.post(new c(cVar));
    }

    public void c(com.vivo.mobilead.b.c cVar) {
        Handler handler = this.f28652e;
        if (handler == null) {
            return;
        }
        handler.post(new C0572b(cVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x011d A[Catch: Exception -> 0x00f3, TRY_ENTER, TRY_LEAVE, TryCatch #10 {Exception -> 0x00f3, blocks: (B:23:0x011d, B:11:0x00ef), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0146 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.vivo.mobilead.b.c> a() {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.b.b.a():java.util.List");
    }

    public synchronized SQLiteDatabase d() {
        if (this.f28649b == null) {
            x0.e("DBManager", "not call DBManager init method!!");
            return null;
        }
        if (this.f28648a.incrementAndGet() == 1) {
            this.f28650c = this.f28649b.getWritableDatabase();
        }
        return this.f28650c;
    }

    private Cursor a(SQLiteDatabase sQLiteDatabase) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("report_flag");
        stringBuffer.append(" =1");
        stringBuffer.append(" limit 100");
        return sQLiteDatabase.query("vivo_report_url", null, stringBuffer.toString(), null, null, null, null);
    }
}
