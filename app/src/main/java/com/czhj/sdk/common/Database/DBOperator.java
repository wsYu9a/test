package com.czhj.sdk.common.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.czhj.sdk.common.ThreadPool.BackgroundThreadFactory;
import com.czhj.sdk.logger.SigmobLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DBOperator {

    /* renamed from: c */
    public static final DBOperator f8395c = new DBOperator();

    /* renamed from: b */
    public final Object f8397b = new Object();

    /* renamed from: a */
    public final ThreadPoolExecutor f8396a = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new BackgroundThreadFactory());

    public interface DataSQLiteLisenter {
        void onFailed(Error error);

        void onSuccess(List<Map> list);
    }

    public class SQLiteDeleteThread implements Runnable {

        /* renamed from: a */
        public final String f8398a;

        /* renamed from: b */
        public final String f8399b;

        /* renamed from: c */
        public final SQLiteLisenter f8400c;

        /* renamed from: d */
        public final SQLiteDatabase f8401d;

        public SQLiteDeleteThread(SQLiteDatabase sQLiteDatabase, String str, String str2, SQLiteLisenter sQLiteLisenter) {
            this.f8398a = str;
            this.f8401d = sQLiteDatabase;
            this.f8399b = str2;
            this.f8400c = sQLiteLisenter;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f8401d.delete(this.f8398a, this.f8399b, null);
                SQLiteLisenter sQLiteLisenter = this.f8400c;
                if (sQLiteLisenter != null) {
                    sQLiteLisenter.onSuccess(null);
                }
            } catch (Throwable th2) {
                SQLiteLisenter sQLiteLisenter2 = this.f8400c;
                if (sQLiteLisenter2 != null) {
                    sQLiteLisenter2.onFailed(new Error(th2.getMessage()));
                }
            }
        }
    }

    public class SQLiteThread implements Runnable {

        /* renamed from: a */
        public final String f8403a;

        /* renamed from: b */
        public final String[] f8404b;

        /* renamed from: c */
        public final String f8405c;

        /* renamed from: d */
        public final String[] f8406d;

        /* renamed from: e */
        public final String f8407e;

        /* renamed from: f */
        public final String f8408f;

        /* renamed from: g */
        public final String f8409g;

        /* renamed from: h */
        public final String f8410h;

        /* renamed from: i */
        public final SQLiteDatabase f8411i;

        /* renamed from: j */
        public final DataSQLiteLisenter f8412j;

        public SQLiteThread(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, DataSQLiteLisenter dataSQLiteLisenter) {
            this.f8403a = str;
            this.f8411i = sQLiteDatabase;
            this.f8404b = strArr;
            this.f8405c = str2;
            this.f8406d = strArr2;
            this.f8407e = str3;
            this.f8408f = str4;
            this.f8409g = str5;
            this.f8410h = str6;
            this.f8412j = dataSQLiteLisenter;
        }

        public final List<Map> a(Cursor cursor) {
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                String[] columnNames = cursor.getColumnNames();
                HashMap hashMap = new HashMap();
                for (String str : columnNames) {
                    int columnIndex = cursor.getColumnIndex(str);
                    if (columnIndex >= 0) {
                        int type = cursor.getType(columnIndex);
                        if (type == 1) {
                            hashMap.put(str, Long.valueOf(cursor.getLong(columnIndex)));
                        } else if (type == 2) {
                            hashMap.put(str, Double.valueOf(cursor.getDouble(columnIndex)));
                        } else if (type == 3) {
                            hashMap.put(str, cursor.getString(columnIndex));
                        } else if (type == 4) {
                            hashMap.put(str, cursor.getBlob(columnIndex));
                        }
                    }
                }
                arrayList.add(hashMap);
            }
            return arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Cursor cursor = null;
            try {
                cursor = this.f8411i.query(this.f8403a, this.f8404b, this.f8405c, this.f8406d, this.f8407e, this.f8408f, this.f8409g, this.f8410h);
                List<Map> a10 = a(cursor);
                DataSQLiteLisenter dataSQLiteLisenter = this.f8412j;
                if (dataSQLiteLisenter != null) {
                    dataSQLiteLisenter.onSuccess(a10);
                }
                if (cursor == null) {
                }
            } catch (Throwable th2) {
                try {
                    DataSQLiteLisenter dataSQLiteLisenter2 = this.f8412j;
                    if (dataSQLiteLisenter2 != null) {
                        dataSQLiteLisenter2.onFailed(new Error(th2.getMessage()));
                    }
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
    }

    public static synchronized DBOperator getInstance() {
        DBOperator dBOperator;
        synchronized (DBOperator.class) {
            dBOperator = f8395c;
        }
        return dBOperator;
    }

    public int count(SQLiteDatabase sQLiteDatabase, String str) {
        return count(sQLiteDatabase, str, null);
    }

    public void delete(SQLiteDatabase sQLiteDatabase, String str, String str2, SQLiteLisenter sQLiteLisenter) {
        try {
            this.f8396a.submit(new SQLiteDeleteThread(sQLiteDatabase, str, str2, sQLiteLisenter));
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            sQLiteLisenter.onFailed(new Error(th2.getMessage()));
        }
    }

    public void find(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, DataSQLiteLisenter dataSQLiteLisenter) {
        this.f8396a.submit(new SQLiteThread(sQLiteDatabase, str, strArr, str2, strArr2, str3, str4, str5, str6, dataSQLiteLisenter));
    }

    public int count(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query(str, null, str2, null, null, null, null, null);
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        try {
            int count = cursor.getCount();
            cursor.close();
            return count;
        } catch (Throwable th3) {
            th = th3;
            try {
                SigmobLog.e(th.getMessage());
                return 0;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }
}
