package com.kwad.sdk.core.e.kwai;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes2.dex */
public final class d {
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    private static String d(Cursor cursor) {
        String str;
        str = "";
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(Downloads.RequestHeaders.COLUMN_VALUE);
            str = columnIndex > 0 ? cursor.getString(columnIndex) : "";
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 > 0) {
                cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 > 0) {
                cursor.getLong(columnIndex3);
            }
        }
        return str;
    }

    public final String getOAID() {
        String str = "";
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
                str = d(cursor);
                new StringBuilder("getOAID oaid:").append(str);
            } finally {
                try {
                    return str;
                } finally {
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }
}
