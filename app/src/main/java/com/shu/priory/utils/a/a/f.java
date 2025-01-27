package com.shu.priory.utils.a.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.shu.priory.config.AdKeys;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.a.a;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a */
    private Context f17283a;

    public f(Context context) {
        this.f17283a = context;
    }

    private String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex > 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }

    public void a(a.InterfaceC0558a interfaceC0558a) {
        try {
            if (a()) {
                Uri parse = Uri.parse("content://com.meizu.flyme.openidsdk/");
                Cursor cursor = null;
                try {
                    cursor = this.f17283a.getContentResolver().query(parse, null, null, new String[]{AdKeys.OAID}, null);
                    String a10 = a(cursor);
                    if (interfaceC0558a != null) {
                        interfaceC0558a.a(a10);
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Throwable unused) {
                    if (cursor == null) {
                        return;
                    }
                }
                cursor.close();
            }
        } catch (Throwable unused2) {
            com.shu.priory.utils.h.a(SDKConstants.TAG, "not support meizu oaid");
        }
    }

    private boolean a() {
        PackageManager packageManager;
        try {
            if (Build.VERSION.SDK_INT >= 29 && (packageManager = this.f17283a.getPackageManager()) != null) {
                return packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
