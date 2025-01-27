package com.kwad.sdk.core.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes3.dex */
public final class j {
    private Context mContext;

    public j(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str = "";
        Cursor cursor = null;
        try {
            cursor = this.mContext.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                str = cursor.getString(cursor.getColumnIndex("value"));
            }
        } catch (Exception unused) {
        } catch (Throwable th2) {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            throw th2;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        return str;
    }
}
