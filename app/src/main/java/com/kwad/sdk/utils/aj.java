package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class aj {
    private static String aTU;
    private static boolean aTV;

    public static boolean cA(Context context) {
        Cursor cursor;
        boolean z10 = false;
        if (!ay.NY()) {
            return false;
        }
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
            try {
                z10 = l(cursor);
            } catch (Throwable unused) {
                try {
                    com.kwad.sdk.core.d.c.e("MiMarketHelper", "isSupportMiMarket2 failed");
                    if (!z10) {
                        com.kwad.sdk.core.d.c.i("MiMarketHelper", "is Miui but not support MiMarket2.0");
                    }
                    return z10;
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                }
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        if (!z10 && ay.NY()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "is Miui but not support MiMarket2.0");
        }
        return z10;
    }

    public static String cz(Context context) {
        Cursor cursor;
        if (!TextUtils.isEmpty(aTU) || aTV || !ay.NY()) {
            return aTU;
        }
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
            try {
                aTU = k(cursor);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        aTV = TextUtils.isEmpty(aTU);
        return aTU;
    }

    public static boolean gN(String str) {
        return str.startsWith("market://details") || str.startsWith("mimarket://details");
    }

    private static String k(Cursor cursor) {
        int columnIndex;
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "cursor is null");
            return "";
        }
        cursor.moveToFirst();
        int columnIndex2 = cursor.getColumnIndex("support");
        return ((columnIndex2 <= 0 || cursor.getInt(columnIndex2) != 0) && (columnIndex = cursor.getColumnIndex("detailStyle")) > 0) ? cursor.getString(columnIndex) : "";
    }

    private static boolean l(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "isSupportMiMarket2: cursor is null");
            return false;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("support");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex).equals("true");
        }
        return false;
    }
}
