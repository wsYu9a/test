package com.vivo.ic.dm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Constants;
import com.vivo.ic.dm.database.DbMoverManager;
import com.vivo.ic.dm.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
class a {

    /* renamed from: a */
    private static final String f28431a = Constants.PRE_TAG + "DownloadDbMover";

    /* renamed from: b */
    private static final boolean f28432b = true;

    /* renamed from: c */
    private Context f28433c;

    /* renamed from: d */
    private String f28434d;

    /* renamed from: e */
    private String f28435e;

    /* renamed from: f */
    private Map<String, DbMoverManager.c> f28436f = new HashMap();

    /* renamed from: g */
    private Map<String, String> f28437g;

    /* renamed from: h */
    private List<HashMap<String, String>> f28438h;

    /* renamed from: i */
    private Set<String> f28439i;

    a(Context context, DbMoverManager.b bVar, Map<String, String> map, List<DbMoverManager.c> list) {
        this.f28433c = context;
        this.f28434d = bVar.f28426a;
        this.f28435e = bVar.f28427b;
        this.f28437g = map;
        for (DbMoverManager.c cVar : list) {
            this.f28436f.put(cVar.f28428a, cVar);
        }
        VLog.i(f28431a, "convert table:" + this.f28437g + " convert values:" + this.f28436f);
    }

    private HashMap<String, String> a(Cursor cursor) {
        HashMap<String, String> hashMap = new HashMap<>();
        int columnCount = cursor.getColumnCount();
        for (int i2 = 0; i2 < columnCount; i2++) {
            String columnName = cursor.getColumnName(i2);
            String string = cursor.getString(i2);
            if (!TextUtils.isEmpty(columnName)) {
                String str = this.f28437g.get(columnName);
                if (!TextUtils.isEmpty(str)) {
                    VLog.i(f28431a, "readRecordData colName:" + columnName + " convert to:" + str);
                    columnName = str;
                }
            }
            if (!TextUtils.isEmpty(columnName) && this.f28436f.containsKey(columnName)) {
                DbMoverManager.c cVar = this.f28436f.get(columnName);
                if ((string == null && cVar.f28429b == null) || (!TextUtils.isEmpty(cVar.f28429b) && cVar.f28429b.equals(string))) {
                    VLog.i(f28431a, "readRecordData colName:" + columnName + " original colValue:" + string + " convert value:" + cVar.f28430c);
                    string = cVar.f28430c;
                }
            }
            hashMap.put(columnName, string);
        }
        return hashMap;
    }

    private List<HashMap<String, String>> b() {
        SQLiteDatabase sQLiteDatabase;
        c cVar = new c(this.f28433c, this.f28434d);
        Cursor cursor = null;
        try {
            sQLiteDatabase = cVar.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            cursor = sQLiteDatabase.query(this.f28435e, null, null, null, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                this.f28438h = new ArrayList();
                do {
                    HashMap<String, String> a2 = a(cursor);
                    if (a2 != null) {
                        this.f28438h.add(a2);
                    }
                } while (cursor.moveToNext());
            }
            if (cursor != null) {
                cursor.close();
            }
            sQLiteDatabase.close();
            cVar.close();
            VLog.d(f28431a, "moveData mDbData:" + this.f28438h);
            return this.f28438h;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            cVar.close();
            throw th;
        }
    }

    private void c(j jVar) {
        b();
        List<HashMap<String, String>> list = this.f28438h;
        if (list == null || list.size() <= 0) {
            return;
        }
        b(jVar);
    }

    void d(j jVar) {
        if (jVar == null) {
            return;
        }
        jVar.getWritableDatabase().delete(jVar.b(), null, null);
        if (this.f28433c == null || TextUtils.isEmpty(this.f28434d)) {
            return;
        }
        this.f28433c.deleteDatabase(this.f28434d);
    }

    boolean e(j jVar) {
        if (jVar == null) {
            return false;
        }
        a(jVar);
        Set<String> set = this.f28439i;
        if (set == null || set.isEmpty()) {
            return false;
        }
        c(jVar);
        String str = f28431a;
        VLog.i(str, "moveData success....");
        this.f28433c.deleteDatabase(this.f28434d);
        VLog.i(str, "delete database:" + this.f28435e);
        return true;
    }

    private void a(j jVar) {
        Cursor cursor = null;
        try {
            try {
                cursor = jVar.getWritableDatabase().query(jVar.b(), null, null, null, null, null, null);
            } catch (Exception e2) {
                VLog.w(f28431a, "getNewDbCols error", e2);
                if (0 != 0) {
                    cursor.close();
                }
            }
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            }
            VLog.i(f28431a, "getNewDbCols corsor:" + cursor.getCount());
            String[] columnNames = cursor.getColumnNames();
            if (columnNames != null && columnNames.length > 0) {
                HashSet hashSet = new HashSet();
                this.f28439i = hashSet;
                hashSet.addAll(Arrays.asList(columnNames));
                cursor.close();
                return;
            }
            cursor.close();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private void b(j jVar) {
        List<ContentValues> a2 = a();
        if (a2 != null && a2.size() != 0) {
            String str = f28431a;
            VLog.i(str, "insertDataToNewDb values num:" + a2.size());
            SQLiteDatabase writableDatabase = jVar.getWritableDatabase();
            if (writableDatabase == null) {
                VLog.w(str, "insertDataToNewDb error : db null");
                return;
            }
            String b2 = jVar.b();
            writableDatabase.beginTransaction();
            try {
                Iterator<ContentValues> it = a2.iterator();
                while (it.hasNext()) {
                    writableDatabase.insert(b2, null, it.next());
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                writableDatabase.setTransactionSuccessful();
                return;
            } finally {
                writableDatabase.endTransaction();
            }
        }
        VLog.i(f28431a, "insertDataToNewDb is null");
    }

    private List<ContentValues> a() {
        ArrayList arrayList = new ArrayList();
        List<HashMap<String, String>> list = this.f28438h;
        if (list == null) {
            VLog.w(f28431a, "mapToNewDbValuesBat error");
            return arrayList;
        }
        Iterator<HashMap<String, String>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    private ContentValues a(HashMap<String, String> hashMap) {
        ContentValues contentValues = new ContentValues();
        if (this.f28439i == null) {
            VLog.w(f28431a, "mapToNewDbValue error : new db is null");
            return contentValues;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (this.f28439i.contains(entry.getKey())) {
                contentValues.put(entry.getKey(), entry.getValue());
            }
        }
        return contentValues;
    }
}
