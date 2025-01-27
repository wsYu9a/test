package com.sigmob.sdk.base.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.utils.d;

/* loaded from: classes4.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final String f18088a = "ads";

    /* renamed from: b */
    public static final String f18089b = "file_reference";

    /* renamed from: c */
    public static final String f18090c = "trigger_insert";

    /* renamed from: d */
    public static final String f18091d = "trigger_delete";

    /* renamed from: e */
    public static final String f18092e = "tracks";

    /* renamed from: f */
    public static final String f18093f = "adload_event";

    /* renamed from: g */
    public static final String f18094g = "wind.db";

    /* renamed from: h */
    public static final int f18095h = 10;

    /* renamed from: i */
    public static String f18096i = "CREATE TABLE ads ( endcard_md5 text  ,video_md5 text  ,ad blob  ,ad_source_channel text  ,ad_type integer  ,create_time integer  ,crid text  ,load_id text  ,adTrackersMap blob  ,adslot_id text  ,camp_id text  ,request_id text , primary key ( crid ,adslot_id) ); \n";

    /* renamed from: j */
    public static String f18097j = "CREATE TRIGGER trigger_insert after insert on ads begin insert or replace into file_reference (crid,adslot_id,video_md5,endcard_md5) values(new.crid,new.adslot_id,new.video_md5,new.endcard_md5) ; end; \n";

    /* renamed from: k */
    public static String f18098k = "CREATE TRIGGER trigger_delete after delete on ads begin delete from file_reference where crid = old.crid  and adslot_id == old.adslot_id; end;\n";

    /* renamed from: l */
    public static String f18099l = "CREATE TABLE file_reference ( endcard_md5 blob  ,video_md5 blob  ,crid text  ,adslot_id text  , primary key ( crid ,adslot_id ) );\n";

    /* renamed from: m */
    public static String f18100m = "CREATE TABLE tracks ( id integer primary key AUTOINCREMENT ,retryNum integer   ,source text   ,event text   ,request_id text   ,url text   ,timestamp integer   );\n";

    /* renamed from: n */
    public static String f18101n = "CREATE TABLE adload_event ( id integer primary key AUTOINCREMENT , adslot_id text  , error_code integer ,timestamp integer  );\n";

    /* renamed from: o */
    public static final long f18102o = -6;

    /* renamed from: p */
    public static final long f18103p = -5;

    /* renamed from: q */
    public static final long f18104q = -4;

    /* renamed from: r */
    public static final long f18105r = -2;

    /* renamed from: s */
    public static final long f18106s = -1;

    /* renamed from: t */
    public static final long f18107t = 0;

    /* renamed from: u */
    public static a f18108u;

    /* renamed from: v */
    public static SQLiteDatabase f18109v;

    /* renamed from: com.sigmob.sdk.base.db.a$a */
    public interface InterfaceC0569a {
        void onFailed(Throwable th2);

        void onSuccess();
    }

    public a(Context context) {
        super(context, f18094g, (SQLiteDatabase.CursorFactory) null, 10);
    }

    public static a b() {
        return f18108u;
    }

    public final void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("alter table " + str3 + " add " + str + " " + str2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f18096i);
        sQLiteDatabase.execSQL(f18097j);
        sQLiteDatabase.execSQL(f18098k);
        sQLiteDatabase.execSQL(f18099l);
        sQLiteDatabase.execSQL(f18100m);
        sQLiteDatabase.execSQL(f18101n);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        Log.w(a.class.getName(), "Downgrading database from version " + i10 + " to " + i11 + ", which will destroy all old data");
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        setWriteAheadLoggingEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        Log.w(a.class.getName(), "Upgrading database from version " + i10 + " to " + i11 + ", which will destroy all old data");
        b(sQLiteDatabase);
    }

    public void a() {
        b(getWritableDatabase());
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS file_reference");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tracks");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adload_event");
        sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trigger_insert");
        sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trigger_delete");
        d.a();
        onCreate(sQLiteDatabase);
    }

    public final void a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        sQLiteDatabase.execSQL("alter table " + str2 + " drop column " + str);
    }

    public static long a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return -6L;
        }
        if (sQLiteDatabase.isOpen()) {
            return sQLiteDatabase.isReadOnly() ? -4L : 0L;
        }
        return -5L;
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (f18108u == null) {
                f18108u = new a(context);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0078, code lost:
    
        if (r8 == null) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0099, code lost:
    
        r8.onFailed(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0097, code lost:
    
        if (r8 == null) goto L193;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.database.sqlite.SQLiteDatabase r6, com.czhj.sdk.common.Database.SQLiteBuider.Insert r7, com.sigmob.sdk.base.db.a.InterfaceC0569a r8) {
        /*
            r5 = this;
            r6.beginTransaction()
            java.lang.String r0 = r7.getSql()     // Catch: java.lang.Throwable -> L38
            android.database.sqlite.SQLiteStatement r0 = r6.compileStatement(r0)     // Catch: java.lang.Throwable -> L38
            r1 = 1
            r2 = 1
        Ld:
            java.util.List r3 = r7.getColumns()     // Catch: java.lang.Throwable -> L38
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L38
            if (r2 > r3) goto L66
            java.util.List r3 = r7.getColumns()     // Catch: java.lang.Throwable -> L38
            int r4 = r2 + (-1)
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L38
            java.util.Map r4 = r7.getValues()     // Catch: java.lang.Throwable -> L38
            java.lang.Object r3 = r4.get(r3)     // Catch: java.lang.Throwable -> L38
            if (r3 != 0) goto L2e
            goto L60
        L2e:
            boolean r4 = r3 instanceof java.lang.String     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L3a
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L38
            r0.bindString(r2, r3)     // Catch: java.lang.Throwable -> L38
            goto L63
        L38:
            r7 = move-exception
            goto L7b
        L3a:
            boolean r4 = r3 instanceof java.lang.Double     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L48
            java.lang.Double r3 = (java.lang.Double) r3     // Catch: java.lang.Throwable -> L38
            double r3 = r3.doubleValue()     // Catch: java.lang.Throwable -> L38
            r0.bindDouble(r2, r3)     // Catch: java.lang.Throwable -> L38
            goto L63
        L48:
            boolean r4 = r3 instanceof java.lang.Number     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L56
            java.lang.Number r3 = (java.lang.Number) r3     // Catch: java.lang.Throwable -> L38
            long r3 = r3.longValue()     // Catch: java.lang.Throwable -> L38
            r0.bindLong(r2, r3)     // Catch: java.lang.Throwable -> L38
            goto L63
        L56:
            boolean r4 = r3 instanceof byte[]     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L60
            byte[] r3 = (byte[]) r3     // Catch: java.lang.Throwable -> L38
            r0.bindBlob(r2, r3)     // Catch: java.lang.Throwable -> L38
            goto L63
        L60:
            r0.bindNull(r2)     // Catch: java.lang.Throwable -> L38
        L63:
            int r2 = r2 + 1
            goto Ld
        L66:
            r0.execute()     // Catch: java.lang.Throwable -> L38
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L38
            r6.endTransaction()     // Catch: java.lang.Throwable -> L70
            goto L9c
        L70:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r7)
            if (r8 == 0) goto L9c
            goto L99
        L7b:
            java.lang.String r0 = r7.getMessage()     // Catch: java.lang.Throwable -> L88
            com.czhj.sdk.logger.SigmobLog.e(r0)     // Catch: java.lang.Throwable -> L88
            if (r8 == 0) goto L8a
            r8.onFailed(r7)     // Catch: java.lang.Throwable -> L88
            goto L8a
        L88:
            r7 = move-exception
            goto La4
        L8a:
            r1 = 0
            r6.endTransaction()     // Catch: java.lang.Throwable -> L8f
            goto L9c
        L8f:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r7)
            if (r8 == 0) goto L9c
        L99:
            r8.onFailed(r6)
        L9c:
            if (r1 == 0) goto La3
            if (r8 == 0) goto La3
            r8.onSuccess()
        La3:
            return
        La4:
            r6.endTransaction()     // Catch: java.lang.Throwable -> La8
            goto Lb5
        La8:
            r6 = move-exception
            java.lang.String r0 = r6.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r0)
            if (r8 == 0) goto Lb5
            r8.onFailed(r6)
        Lb5:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.db.a.a(android.database.sqlite.SQLiteDatabase, com.czhj.sdk.common.Database.SQLiteBuider$Insert, com.sigmob.sdk.base.db.a$a):void");
    }

    public void a(SQLiteDatabase sQLiteDatabase, String str, InterfaceC0569a interfaceC0569a) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(str, new Object[0]);
            sQLiteDatabase.setTransactionSuccessful();
            if (interfaceC0569a != null) {
                interfaceC0569a.onSuccess();
            }
        } catch (Throwable th2) {
            try {
                SigmobLog.e(th2.getMessage());
                if (interfaceC0569a != null) {
                    interfaceC0569a.onFailed(th2);
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }
}
