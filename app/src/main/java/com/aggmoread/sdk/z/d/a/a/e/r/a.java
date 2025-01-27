package com.aggmoread.sdk.z.d.a.a.e.r;

import android.content.ContextWrapper;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    static Map<String, i> f6131a = new HashMap();

    public static boolean a(ContextWrapper contextWrapper, String str, String str2, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        i iVar;
        try {
            if (f6131a.containsKey(str)) {
                iVar = f6131a.get(str);
                iVar.a();
            } else {
                iVar = new i(contextWrapper.getApplicationContext(), str, str2);
            }
            Field declaredField = ContextWrapper.class.getDeclaredField("mBase");
            declaredField.setAccessible(true);
            declaredField.set(contextWrapper, iVar);
            a(eVar, str, iVar);
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, String str, i iVar) {
        return true;
    }
}
