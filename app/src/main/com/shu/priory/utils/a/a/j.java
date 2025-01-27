package com.shu.priory.utils.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.a.a;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes3.dex */
public class j {

    /* renamed from: a */
    private Context f17285a;

    public j(Context context) {
        this.f17285a = context;
    }

    private String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e10) {
            e10.printStackTrace();
            return str2;
        }
    }

    public void a(a.InterfaceC0558a interfaceC0558a) {
        try {
            if (Build.VERSION.SDK_INT >= 29 && a()) {
                Cursor query = this.f17285a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                if (query != null) {
                    r1 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                    query.close();
                }
                if (interfaceC0558a != null) {
                    interfaceC0558a.a(r1);
                }
            }
        } catch (Throwable unused) {
            com.shu.priory.utils.h.a(SDKConstants.TAG, "not support oaid");
        }
    }

    private boolean a() {
        return a(i3.b.f26849c, "0").equals("1");
    }
}
