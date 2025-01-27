package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class ae {
    private static String azV;
    private static boolean azW;

    public static String bY(Context context) {
        if (!TextUtils.isEmpty(azV) || azW || !as.DR()) {
            return azV;
        }
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
            azV = i(cursor);
        } catch (Throwable unused) {
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        azW = TextUtils.isEmpty(azV);
        return azV;
    }

    private static String i(Cursor cursor) {
        int columnIndex;
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.b.i("MiMarketHelper", "cursor is null");
            return "";
        }
        cursor.moveToFirst();
        int columnIndex2 = cursor.getColumnIndex("support");
        return ((columnIndex2 <= 0 || cursor.getInt(columnIndex2) != 0) && (columnIndex = cursor.getColumnIndex("detailStyle")) > 0) ? cursor.getString(columnIndex) : "";
    }
}
