package com.opos.cmn.b.b;

import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private Class<?> f16612a;

    public a(Class<?> cls) {
        this.f16612a = cls;
    }

    public Field a(String str) {
        try {
            if (this.f16612a != null && !com.opos.cmn.an.c.a.a(str)) {
                return this.f16612a.getDeclaredField(str);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ReflectEngine", "getDeclareField", e2);
        }
        return null;
    }

    public void a(Field field, Object obj, Object obj2) {
        try {
            if (this.f16612a == null || field == null || obj == null) {
                return;
            }
            field.setAccessible(true);
            field.set(obj, obj2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ReflectEngine", "setFieldValue", e2);
        }
    }
}
