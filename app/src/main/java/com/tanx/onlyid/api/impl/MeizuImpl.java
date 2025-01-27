package com.tanx.onlyid.api.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.shu.priory.config.AdKeys;
import com.tanx.onlyid.api.OAIDException;
import java.util.Objects;
import ug.c;
import ug.d;
import ug.e;

/* loaded from: classes4.dex */
class MeizuImpl implements d {

    /* renamed from: a */
    public final Context f22020a;

    public MeizuImpl(Context context) {
        this.f22020a = context;
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f22020a == null || cVar == null) {
            return;
        }
        try {
            Cursor query = this.f22020a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{AdKeys.OAID}, null);
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
        Context context = this.f22020a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e10) {
            e.b(e10);
            return false;
        }
    }
}
