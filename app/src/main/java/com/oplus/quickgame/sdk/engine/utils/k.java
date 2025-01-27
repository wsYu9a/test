package com.oplus.quickgame.sdk.engine.utils;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class k {
    private static Map<String, Object> a(Cursor cursor) throws Throwable {
        HashMap hashMap = new HashMap();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                hashMap.putAll(c(cursor));
            } while (cursor.moveToNext());
        }
        return hashMap;
    }

    public static Map<String, Object> b(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            try {
                Map<String, Object> a2 = a(cursor);
                try {
                    cursor.close();
                    return a2;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return a2;
                }
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                } finally {
                    try {
                        cursor.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    private static Map<String, Object> c(Cursor cursor) {
        Object valueOf;
        HashMap hashMap = new HashMap();
        for (String str : cursor.getColumnNames()) {
            int columnIndex = cursor.getColumnIndex(str);
            int type = cursor.getType(columnIndex);
            if (type == 1) {
                valueOf = Long.valueOf(cursor.getLong(columnIndex));
            } else if (type == 2) {
                valueOf = Double.valueOf(cursor.getDouble(columnIndex));
            } else if (type != 3) {
                if (type == 4) {
                    hashMap.put(str, cursor.getBlob(columnIndex));
                }
            } else {
                valueOf = cursor.getString(columnIndex);
            }
            hashMap.put(str, valueOf);
        }
        return hashMap;
    }
}
