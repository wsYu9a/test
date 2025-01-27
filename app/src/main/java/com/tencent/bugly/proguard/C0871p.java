package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import com.umeng.analytics.pro.bx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.p */
/* loaded from: classes4.dex */
public class C0871p {

    /* renamed from: a */
    public static C0871p f22799a = new C0871p();

    public synchronized int a(DownloadTask downloadTask) {
        return J.a().a("dl_1002", "_dUrl = ?", new String[]{downloadTask.getDownloadUrl()}, (I) null, true);
    }

    public synchronized boolean b(DownloadTask downloadTask) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("_dUrl", downloadTask.getDownloadUrl());
        contentValues.put("_sFile", downloadTask.getSaveFile().getAbsolutePath());
        contentValues.put("_sLen", Long.valueOf(downloadTask.getSavedLength()));
        contentValues.put("_tLen", Long.valueOf(downloadTask.getTotalLength()));
        contentValues.put("_MD5", downloadTask.getMD5());
        contentValues.put("_DLTIME", Long.valueOf(downloadTask.getCostTime()));
        return J.a().a("dl_1002", contentValues, (I) null, true) >= 0;
    }

    public synchronized ContentValues c(String str) {
        try {
            ContentValues contentValues = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Cursor a10 = J.a().a("dl_1002", null, "_dUrl=?", new String[]{str}, null, true);
            if (a10 != null && a10.moveToFirst()) {
                contentValues = new ContentValues();
                contentValues.put("_dUrl", a10.getString(a10.getColumnIndex("_dUrl")));
                contentValues.put("_sFile", a10.getString(a10.getColumnIndex("_sFile")));
                contentValues.put("_sLen", Long.valueOf(a10.getLong(a10.getColumnIndex("_sLen"))));
                contentValues.put("_tLen", Long.valueOf(a10.getLong(a10.getColumnIndex("_tLen"))));
                contentValues.put("_MD5", a10.getString(a10.getColumnIndex("_MD5")));
                contentValues.put("_DLTIME", Long.valueOf(a10.getLong(a10.getColumnIndex("_DLTIME"))));
            }
            if (a10 != null) {
                a10.close();
            }
            return contentValues;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean a(C0880z c0880z) {
        if (c0880z == null) {
            return false;
        }
        byte[] a10 = M.a((AbstractC0868m) c0880z);
        if (a10 != null && a10.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_time", Long.valueOf(c0880z.f22910e));
            contentValues.put("_datas", a10);
            return J.a().a("ge_1002", contentValues, (I) null, true) >= 0;
        }
        return false;
    }

    public synchronized int a(long j10) {
        return J.a().a("ge_1002", "_time = ?", new String[]{String.valueOf(j10)}, (I) null, true);
    }

    public synchronized int a() {
        return J.a().a("ge_1002", (String) null, (String[]) null, (I) null, true);
    }

    public synchronized int b(String str) {
        return J.a().a("dl_1002", "_sFile = ?", new String[]{str}, (I) null, true);
    }

    public synchronized boolean a(int i10, String str, byte[] bArr) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(i10));
        contentValues.put("_tm", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(bx.f23687e, str);
        contentValues.put("_dt", bArr);
        return J.a().a("st_1002", contentValues, (I) null, true) >= 0;
    }

    public synchronized List<C0880z> b() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Cursor a10 = J.a().a("ge_1002", null, null, null, null, true);
            while (a10 != null && a10.moveToNext()) {
                C0880z c0880z = (C0880z) M.a(a10.getBlob(a10.getColumnIndex("_datas")), C0880z.class);
                if (c0880z != null) {
                    arrayList.add(c0880z);
                }
            }
            if (a10 != null) {
                a10.close();
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return arrayList;
    }

    public synchronized Map<String, byte[]> c() {
        Throwable th2;
        Cursor cursor;
        try {
            cursor = J.a().a("st_1002", null, "_id = 1002", null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                HashMap hashMap = new HashMap();
                while (cursor.moveToNext()) {
                    hashMap.put(cursor.getString(cursor.getColumnIndex(bx.f23687e)), cursor.getBlob(cursor.getColumnIndex("_dt")));
                }
                cursor.close();
                return hashMap;
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    if (!X.b(th2)) {
                        th2.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th4) {
            th2 = th4;
            cursor = null;
        }
    }

    public synchronized boolean a(String str) {
        return J.a().a("st_1002", "_id = ? and _tp = ? ", new String[]{"1002", str}, (I) null, true) > 0;
    }
}
