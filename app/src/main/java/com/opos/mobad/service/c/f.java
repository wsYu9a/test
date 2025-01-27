package com.opos.mobad.service.c;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes4.dex */
public class f implements com.opos.mobad.d.f {

    /* renamed from: a */
    public Context f23562a;

    public f(Context context) {
        this.f23562a = context;
    }

    public static final File a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        File file2 = new File(b(context));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return new File(file2, file.getName());
    }

    public static final String a(Context context) {
        if (context != null) {
            String b2 = com.opos.cmn.d.c.b(context);
            if (!TextUtils.isEmpty(b2)) {
                return b2 + File.separator + ".dynamic";
            }
        }
        return null;
    }

    public static final String b(Context context) {
        if (context == null) {
            return null;
        }
        return a(context) + File.separator + ".unzip";
    }

    @Override // com.opos.mobad.d.f
    public File a(String str) {
        if (this.f23562a != null && !TextUtils.isEmpty(str) && com.opos.cmn.an.d.b.a.a()) {
            String a2 = a(this.f23562a);
            if (!TextUtils.isEmpty(a2)) {
                File file = new File(a2);
                if (file.exists()) {
                    String a3 = com.opos.cmn.d.c.a(str);
                    if (!TextUtils.isEmpty(a3)) {
                        return new File(file, a3);
                    }
                } else {
                    file.mkdirs();
                }
            }
        }
        return null;
    }

    @Override // com.opos.mobad.d.f
    public File a(String str, String str2) {
        if (this.f23562a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && com.opos.cmn.an.d.b.a.a()) {
            String a2 = a(this.f23562a);
            if (!TextUtils.isEmpty(a2)) {
                File file = new File(a2 + File.separator + ".dynamic");
                if (file.exists()) {
                    String a3 = com.opos.cmn.d.c.a(str);
                    if (!TextUtils.isEmpty(a3)) {
                        return new File(file, a3);
                    }
                } else {
                    file.mkdirs();
                }
            }
        }
        return null;
    }

    public String b(String str) {
        File a2 = a(str);
        if (a2 != null) {
            return a2.getAbsolutePath();
        }
        return null;
    }
}
