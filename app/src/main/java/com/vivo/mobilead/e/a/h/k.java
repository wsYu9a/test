package com.vivo.mobilead.e.a.h;

import android.annotation.SuppressLint;
import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
class k implements com.vivo.mobilead.e.a.c {

    /* renamed from: a */
    private final Context f28795a;

    /* renamed from: b */
    private Class<?> f28796b;

    /* renamed from: c */
    private Object f28797c;

    @SuppressLint({"PrivateApi"})
    public k(Context context) {
        this.f28795a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f28796b = cls;
            this.f28797c = cls.newInstance();
        } catch (Exception e2) {
            com.vivo.mobilead.e.a.e.a(e2);
        }
    }

    private String b() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.f28796b.getMethod("getOAID", Context.class).invoke(this.f28797c, this.f28795a);
    }

    @Override // com.vivo.mobilead.e.a.c
    public boolean a() {
        return this.f28797c != null;
    }

    @Override // com.vivo.mobilead.e.a.c
    public void a(com.vivo.mobilead.e.a.b bVar) {
        if (this.f28795a == null || bVar == null) {
            return;
        }
        if (this.f28796b == null || this.f28797c == null) {
            bVar.a(new com.vivo.mobilead.e.a.d("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String b2 = b();
            if (b2 == null || b2.length() == 0) {
                throw new com.vivo.mobilead.e.a.d("OAID query failed");
            }
            com.vivo.mobilead.e.a.e.a("OAID query success: " + b2);
            bVar.a(b2);
        } catch (Exception e2) {
            com.vivo.mobilead.e.a.e.a(e2);
            bVar.a(e2);
        }
    }
}
