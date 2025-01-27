package jg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "tanx_ad_expose_sdk.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public synchronized List<ig.b> a(String str) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Cursor query = getReadableDatabase().query("retry_monitor_info", null, "date = ?", new String[]{str}, null, null, null, null);
            while (query != null) {
                try {
                    try {
                        if (!query.moveToNext()) {
                            break;
                        }
                        ig.b bVar = new ig.b(query);
                        arrayList.add(bVar);
                        if (sg.a.f30663a) {
                            sg.a.a("RetryMonitorDbHelper", "query: add retryMonitorInfo = " + bVar);
                        }
                    } catch (Exception e10) {
                        sg.a.b("RetryMonitorDbHelper", "query exception, date = " + str, e10);
                    }
                } catch (Throwable th2) {
                    query.close();
                    throw th2;
                }
            }
            if (query != null) {
                query.close();
            }
            if (sg.a.f30663a) {
                sg.a.a("RetryMonitorDbHelper", "query: exposeDate = " + str + ", retryMonitorInfoList = " + arrayList);
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return arrayList;
    }

    public synchronized void b(long j10) {
        if (j10 < 0) {
            return;
        }
        try {
            long delete = getWritableDatabase().delete("retry_monitor_info", "id = ?", new String[]{String.valueOf(j10)});
            if (sg.a.f30663a) {
                sg.a.a("RetryMonitorDbHelper", "delete: id = " + j10 + ", deleteRows = " + delete);
            }
        } finally {
        }
    }

    public synchronized void c(ig.b bVar) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("monitor_type", bVar.l().name());
            contentValues.put("monitor_url", bVar.k());
            contentValues.put("monitor_original_url", bVar.i());
            contentValues.put("monitor_url_host", bVar.o());
            contentValues.put("monitor_url_hash", bVar.n());
            if (bVar.j() != null) {
                contentValues.put("monitor_extra_params", bVar.j().toString());
            }
            contentValues.put("retry_times", Integer.valueOf(bVar.h().intValue()));
            contentValues.put("max_retry_times", Integer.valueOf(bVar.c()));
            contentValues.put("date", bVar.b());
            contentValues.put("expire_time", Long.valueOf(bVar.a()));
            long insert = writableDatabase.insert("retry_monitor_info", null, contentValues);
            bVar.e(insert);
            if (sg.a.f30663a) {
                sg.a.a("RetryMonitorDbHelper", "insert: index = " + insert + ", exposeDate = " + bVar.b());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void d(String str, int i10) {
        try {
            long delete = getWritableDatabase().delete("retry_monitor_info", "date != ? or retry_times >= ?", new String[]{str, String.valueOf(i10)});
            if (sg.a.f30663a) {
                sg.a.a("RetryMonitorDbHelper", "delete: deletedRows = " + delete + ", date = " + str + ", maxRetryTimes = " + i10);
            }
        } catch (Throwable th2) {
            sg.a.b("RetryMonitorDbHelper", "delete by date exception.", th2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (sg.a.f30663a) {
            sg.a.a("RetryMonitorDbHelper", "onCreate: createRetryTableSql = CREATE TABLE IF NOT EXISTS retry_monitor_info ( id INTEGER PRIMARY KEY AUTOINCREMENT, monitor_type VARCHAR(10), monitor_url TEXT, monitor_original_url TEXT, monitor_url_hash TEXT, monitor_url_host TEXT, monitor_extra_params TEXT, retry_times INTEGER, max_retry_times INTEGER, date VARCHAR(12),expire_time INTEGER)");
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS retry_monitor_info ( id INTEGER PRIMARY KEY AUTOINCREMENT, monitor_type VARCHAR(10), monitor_url TEXT, monitor_original_url TEXT, monitor_url_hash TEXT, monitor_url_host TEXT, monitor_extra_params TEXT, retry_times INTEGER, max_retry_times INTEGER, date VARCHAR(12),expire_time INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (sg.a.f30663a) {
            sg.a.a("RetryMonitorDbHelper", "onUpgrade: oldVer = " + i10 + ", newVer = " + i11);
        }
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS retry_monitor_info");
        onCreate(sQLiteDatabase);
    }
}
