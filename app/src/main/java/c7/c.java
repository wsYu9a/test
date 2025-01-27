package c7;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a */
    public static final String f1708a = "type";

    public void a(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(x6.b.m0(context));
            intent.setPackage(x6.b.e0(context));
            intent.putExtra("appPackage", context.getPackageName());
            intent.putExtra("messageID", str);
            intent.putExtra("type", b7.b.B0);
            context.startService(intent);
        } catch (Exception e10) {
            e.d("statisticMessage--Exception" + e10.getMessage());
        }
    }
}
