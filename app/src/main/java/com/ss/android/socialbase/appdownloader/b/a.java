package com.ss.android.socialbase.appdownloader.b;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static final String f21757a;

    static {
        StringBuilder sb2 = new StringBuilder();
        String str = Build.VERSION.RELEASE;
        boolean z10 = !TextUtils.isEmpty(str);
        String str2 = Build.ID;
        boolean z11 = !TextUtils.isEmpty(str2);
        boolean z12 = "REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL);
        sb2.append("AppDownloader");
        if (z10) {
            sb2.append("/");
            sb2.append(str);
        }
        sb2.append(" (Linux; U; Android");
        if (z10) {
            sb2.append(" ");
            sb2.append(str);
        }
        if (z12 || z11) {
            sb2.append(";");
            if (z12) {
                sb2.append(" ");
                sb2.append(Build.MODEL);
            }
            if (z11) {
                sb2.append(" Build/");
                sb2.append(str2);
            }
        }
        sb2.append(")");
        f21757a = sb2.toString();
    }
}
