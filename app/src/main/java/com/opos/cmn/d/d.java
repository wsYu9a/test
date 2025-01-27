package com.opos.cmn.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.kuaishou.weapon.p0.g;
import com.opos.cmn.i.i;
import java.io.File;

/* loaded from: classes4.dex */
public class d {
    public static String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(com.opos.cmn.an.d.b.a.b());
        String str = File.separator;
        sb.append(str);
        sb.append(".mob_ad");
        sb.append(str);
        sb.append(".material");
        sb.append(str);
        sb.append(".video");
        return sb.toString();
    }

    public static String a(Context context, String str) {
        if (!com.opos.cmn.an.d.b.a.a()) {
            return "";
        }
        if (a(context)) {
            String a2 = a(str);
            if (com.opos.cmn.an.d.b.a.a(a2)) {
                return a2;
            }
        }
        String c2 = c(context, str);
        return !com.opos.cmn.an.d.b.a.a(c2) ? "" : c2;
    }

    public static String a(Context context, String str, String str2) {
        if (!com.opos.cmn.an.d.b.a.a()) {
            return "";
        }
        if (a(context)) {
            String a2 = a(str);
            if (b.a(a2, str2)) {
                return a2;
            }
        }
        String c2 = c(context, str);
        return !b.a(c2, str2) ? "" : c2;
    }

    private static String a(String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(com.opos.cmn.an.d.b.a.b());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(".mob_ad");
        sb.append(str2);
        sb.append(".material");
        sb.append(str2);
        sb.append(".video");
        sb.append(str2);
        sb.append(b.a(str));
        return sb.toString();
    }

    public static boolean a(Context context) {
        int i2;
        return i.a(context, new String[]{g.f9325j}) && (i2 = Build.VERSION.SDK_INT) < 33 && (i2 < 29 || Environment.isExternalStorageLegacy());
    }

    public static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getExternalFilesDir(".mob_ad").getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(".material");
        sb.append(str);
        sb.append(".video");
        return sb.toString();
    }

    @TargetApi(29)
    public static String b(Context context, String str) {
        return (!com.opos.cmn.an.d.b.a.a() || com.opos.cmn.an.c.a.a(str)) ? "" : c(context, str);
    }

    private static String c(Context context, String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getExternalFilesDir(".mob_ad").getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(".material");
        sb.append(str2);
        sb.append(".video");
        sb.append(str2);
        sb.append(b.a(str));
        return sb.toString();
    }
}
