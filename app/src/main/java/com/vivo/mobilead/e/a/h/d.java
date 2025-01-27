package com.vivo.mobilead.e.a.h;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes4.dex */
class d implements com.vivo.mobilead.e.a.c {

    /* renamed from: a */
    private final Context f28784a;

    public d(Context context) {
        this.f28784a = context;
    }

    @Override // com.vivo.mobilead.e.a.c
    public boolean a() {
        Context context = this.f28784a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e2) {
            com.vivo.mobilead.e.a.e.a(e2);
            return false;
        }
    }

    @Override // com.vivo.mobilead.e.a.c
    public void a(com.vivo.mobilead.e.a.b bVar) {
        if (this.f28784a == null || bVar == null) {
            return;
        }
        try {
            Cursor query = this.f28784a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            try {
                query.getClass();
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex(Downloads.RequestHeaders.COLUMN_VALUE));
                if (string != null && string.length() != 0) {
                    com.vivo.mobilead.e.a.e.a("OAID query success: " + string);
                    bVar.a(string);
                    query.close();
                    return;
                }
                throw new com.vivo.mobilead.e.a.d("OAID query failed");
            } finally {
            }
        } catch (Exception e2) {
            com.vivo.mobilead.e.a.e.a(e2);
            bVar.a(e2);
        }
    }
}
