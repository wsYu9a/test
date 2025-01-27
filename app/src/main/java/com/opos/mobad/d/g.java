package com.opos.mobad.d;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes4.dex */
public class g implements f {

    /* renamed from: a */
    public Context f20479a;

    public g(Context context) {
        this.f20479a = context;
    }

    @Override // com.opos.mobad.d.f
    public File a(String str) {
        if (this.f20479a != null && !TextUtils.isEmpty(str) && com.opos.cmn.an.d.b.a.a()) {
            String b2 = com.opos.cmn.d.c.b(this.f20479a);
            if (!TextUtils.isEmpty(b2)) {
                File file = new File(b2);
                if (file.exists()) {
                    String a2 = com.opos.cmn.d.c.a(str);
                    if (!TextUtils.isEmpty(a2)) {
                        return new File(file, a2);
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
        if (this.f20479a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && com.opos.cmn.an.d.b.a.a()) {
            String b2 = com.opos.cmn.d.c.b(this.f20479a);
            if (!TextUtils.isEmpty(b2)) {
                File file = new File(b2 + File.separator + str2);
                if (file.exists()) {
                    String a2 = com.opos.cmn.d.c.a(str);
                    if (!TextUtils.isEmpty(a2)) {
                        return new File(file, a2);
                    }
                } else {
                    file.mkdirs();
                }
            }
        }
        return null;
    }
}
