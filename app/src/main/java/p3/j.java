package p3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a */
    public static final String f29759a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static String a(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse(f29759a), null, null, null, null);
        if (query != null && query.getCount() > 0) {
            r0 = query.moveToFirst() ? query.getString(query.getColumnIndex("url")) : null;
            query.close();
        }
        return r0;
    }

    public static String b(Context context) {
        if (EnvUtils.c()) {
            return z2.a.f33591b;
        }
        if (EnvUtils.b()) {
            return z2.a.f33592c;
        }
        if (context == null) {
            return z2.a.f33590a;
        }
        String str = z2.a.f33590a;
        return TextUtils.isEmpty(str) ? z2.a.f33590a : str;
    }
}
