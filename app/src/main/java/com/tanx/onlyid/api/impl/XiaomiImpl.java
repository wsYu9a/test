package com.tanx.onlyid.api.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tanx.onlyid.api.OAIDException;
import java.lang.reflect.InvocationTargetException;
import ug.c;
import ug.d;
import ug.e;

/* loaded from: classes4.dex */
class XiaomiImpl implements d {

    /* renamed from: a */
    public final Context f22030a;

    /* renamed from: b */
    public Class<?> f22031b;

    /* renamed from: c */
    public Object f22032c;

    @SuppressLint({"PrivateApi"})
    public XiaomiImpl(Context context) {
        this.f22030a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f22031b = cls;
            this.f22032c = cls.newInstance();
        } catch (Exception e10) {
            e.b(e10);
        }
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f22030a == null || cVar == null) {
            return;
        }
        if (this.f22031b == null || this.f22032c == null) {
            cVar.oaidError(new OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String c10 = c();
            if (c10 == null || c10.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            e.b("OAID query success: " + c10);
            cVar.oaidSucc(c10);
        } catch (Exception e10) {
            e.b(e10);
            cVar.oaidError(e10);
        }
    }

    @Override // ug.d
    public boolean b() {
        return this.f22032c != null;
    }

    public final String c() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.f22031b.getMethod("getOAID", Context.class).invoke(this.f22032c, this.f22030a);
    }
}
