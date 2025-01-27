package com.vivo.mobilead.e.a.h;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes4.dex */
class j implements com.vivo.mobilead.e.a.c {

    /* renamed from: a */
    private final Context f28794a;

    public j(Context context) {
        this.f28794a = context;
    }

    @Override // com.vivo.mobilead.e.a.c
    public boolean a() {
        return com.vivo.mobilead.e.a.f.a("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // com.vivo.mobilead.e.a.c
    public void a(com.vivo.mobilead.e.a.b bVar) {
        if (this.f28794a == null || bVar == null) {
            return;
        }
        try {
            Cursor query = this.f28794a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                query.getClass();
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex(Downloads.RequestHeaders.COLUMN_VALUE));
                if (string == null || string.length() == 0) {
                    throw new com.vivo.mobilead.e.a.d("OAID query failed");
                }
                com.vivo.mobilead.e.a.e.a("OAID query success: " + string);
                bVar.a(string);
                query.close();
            } finally {
            }
        } catch (Exception e2) {
            com.vivo.mobilead.e.a.e.a(e2);
            bVar.a(e2);
        }
    }
}
