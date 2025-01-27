package com.tanx.onlyid.api.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.tanx.onlyid.api.OAIDException;
import java.util.Objects;
import ug.c;
import ug.d;
import ug.e;
import ug.f;

/* loaded from: classes4.dex */
class VivoImpl implements d {

    /* renamed from: a */
    public final Context f22029a;

    public VivoImpl(Context context) {
        this.f22029a = context;
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f22029a == null || cVar == null) {
            return;
        }
        try {
            Cursor query = this.f22029a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                Objects.requireNonNull(query);
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("value"));
                if (string == null || string.length() == 0) {
                    throw new OAIDException("OAID query failed");
                }
                e.b("OAID query success: " + string);
                cVar.oaidSucc(string);
                query.close();
            } finally {
            }
        } catch (Exception e10) {
            e.b(e10);
            cVar.oaidError(e10);
        }
    }

    @Override // ug.d
    public boolean b() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return f.t(i3.b.f26849c, "0").equals("1");
    }
}
