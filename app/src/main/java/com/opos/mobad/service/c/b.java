package com.opos.mobad.service.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static volatile b f23548a;

    /* renamed from: b */
    private Context f23549b;

    /* renamed from: c */
    private d f23550c;

    /* renamed from: d */
    private a f23551d;

    public static b a() {
        b bVar = f23548a;
        if (bVar == null) {
            synchronized (b.class) {
                bVar = f23548a;
                if (bVar == null) {
                    bVar = new b();
                    f23548a = bVar;
                }
            }
        }
        return bVar;
    }

    private void b() {
        com.opos.cmn.an.f.a.a("Dynamic-Controller", "start to pre load mat");
        if (this.f23551d.a()) {
            this.f23550c.a(this.f23551d.b());
        } else {
            com.opos.cmn.an.f.a.a("Dynamic-Controller", "preload dynamic material but null map");
        }
    }

    public void a(int i2) {
        StringBuilder sb;
        String str;
        if (this.f23551d == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("Dynamic-Controller", "loadMaterial template id = " + i2);
        if (!this.f23551d.a() || !this.f23551d.a(i2)) {
            sb = new StringBuilder();
            str = "no need load template id = ";
        } else {
            if (com.opos.cmn.an.h.c.a.e(this.f23549b)) {
                String b2 = this.f23551d.b(i2);
                if (!TextUtils.isEmpty(b2)) {
                    this.f23550c.c(b2);
                    return;
                }
                sb = new StringBuilder();
                sb.append("loadMaterial template id = ");
                sb.append(i2);
                sb.append(", but null url");
                com.opos.cmn.an.f.a.b("Dynamic-Controller", sb.toString());
            }
            sb = new StringBuilder();
            str = "is not wifi do not download zip ";
        }
        sb.append(str);
        sb.append(i2);
        com.opos.cmn.an.f.a.b("Dynamic-Controller", sb.toString());
    }

    public void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f23549b = applicationContext;
        this.f23550c = new d(applicationContext);
        this.f23551d = new a();
    }

    public void a(Map<Integer, String> map) {
        a aVar = this.f23551d;
        if (aVar == null) {
            return;
        }
        aVar.a(map);
        b();
    }

    public void b(Context context) {
        d.a(context);
    }

    public boolean b(int i2) {
        a aVar = this.f23551d;
        if (aVar == null) {
            return false;
        }
        return aVar.a(i2);
    }

    public int c(int i2) {
        if (this.f23551d == null || !b(i2)) {
            return 1;
        }
        String b2 = this.f23551d.b(i2);
        if (TextUtils.isEmpty(b2)) {
            com.opos.cmn.an.f.a.b("Dynamic-Controller", "checkDyTemplateFileExist = " + i2 + ", but null url");
            return 2;
        }
        if (!this.f23550c.a(b2)) {
            return 3;
        }
        com.opos.cmn.an.f.a.b("Dynamic-Controller", "check select template = " + i2);
        return 0;
    }

    public String d(int i2) {
        if (this.f23551d == null || !b(i2)) {
            return "";
        }
        String b2 = this.f23551d.b(i2);
        if (!TextUtils.isEmpty(b2)) {
            return this.f23550c.b(b2);
        }
        com.opos.cmn.an.f.a.b("Dynamic-Controller", "getFilePath = " + i2 + ", but null url");
        return "";
    }
}
