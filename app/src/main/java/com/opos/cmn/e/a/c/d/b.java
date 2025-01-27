package com.opos.cmn.e.a.c.d;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private Context f17000a;

    /* renamed from: b */
    private com.opos.cmn.e.a.c.b.a f17001b;

    /* renamed from: c */
    private Toast f17002c;

    public b(Context context, com.opos.cmn.e.a.c.b.a aVar) {
        this.f17000a = context.getApplicationContext();
        this.f17001b = aVar;
        this.f17002c = new Toast(this.f17000a);
    }

    private Object a(Object obj, String str) {
        Field declaredField;
        if (obj != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str) && (declaredField = obj.getClass().getDeclaredField(str)) != null) {
                    declaredField.setAccessible(true);
                    return declaredField.get(obj);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("CustomToast", "", (Throwable) e2);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.WindowManager.LayoutParams a() {
        /*
            r4 = this;
            java.lang.String r0 = "CustomToast"
            android.widget.Toast r1 = r4.f17002c     // Catch: java.lang.Exception -> L1b
            java.lang.String r2 = "mTN"
            java.lang.Object r1 = r4.a(r1, r2)     // Catch: java.lang.Exception -> L1b
            if (r1 == 0) goto L21
            java.lang.String r2 = "mParams"
            java.lang.Object r1 = r4.a(r1, r2)     // Catch: java.lang.Exception -> L1b
            if (r1 == 0) goto L21
            boolean r2 = r1 instanceof android.view.WindowManager.LayoutParams     // Catch: java.lang.Exception -> L1b
            if (r2 == 0) goto L21
            android.view.WindowManager$LayoutParams r1 = (android.view.WindowManager.LayoutParams) r1     // Catch: java.lang.Exception -> L1b
            goto L22
        L1b:
            r1 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.a(r0, r2, r1)
        L21:
            r1 = 0
        L22:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getWindowLayoutParams="
            r2.append(r3)
            if (r1 == 0) goto L30
            r3 = r1
            goto L32
        L30:
            java.lang.String r3 = "null"
        L32:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.opos.cmn.an.f.a.b(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.e.a.c.d.b.a():android.view.WindowManager$LayoutParams");
    }

    public void a(int i2) {
        com.opos.cmn.an.f.a.b("CustomToast", "setDuration duration=" + i2);
        this.f17002c.setDuration(i2);
    }

    public void a(int i2, int i3, int i4) {
        com.opos.cmn.an.f.a.b("CustomToast", "setGravity gravity=" + i2 + ",xOffset=" + i3 + ",yOffset=" + i4);
        this.f17002c.setGravity(i2, i3, i4);
    }

    public void a(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append("setView view=");
        sb.append(view != null ? view : "null");
        com.opos.cmn.an.f.a.b("CustomToast", sb.toString());
        if (view != null) {
            this.f17002c.setView(view);
        }
    }

    public void b() {
        com.opos.cmn.an.f.a.b("CustomToast", "show");
        this.f17002c.show();
    }

    public void c() {
        com.opos.cmn.an.f.a.b("CustomToast", "cancel");
        this.f17002c.cancel();
    }
}
