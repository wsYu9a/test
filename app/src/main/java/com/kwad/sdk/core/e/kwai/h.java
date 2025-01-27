package com.kwad.sdk.core.e.kwai;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes2.dex */
public final class h {
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str = "";
        Cursor cursor = null;
        try {
            cursor = this.mContext.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                str = cursor.getString(cursor.getColumnIndex(Downloads.RequestHeaders.COLUMN_VALUE));
                new StringBuilder("getOAID oaid:").append(str);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        return str;
    }
}
