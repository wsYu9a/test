package mj;

import bh.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p002continue.f;

/* loaded from: classes4.dex */
public final class f {
    public static JSONArray a() {
        p002continue.f fVar = f.b.f25213a;
        fVar.getClass();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = (HashMap) fVar.t();
        for (String str : hashMap2.keySet()) {
            hashMap.put(str, Integer.valueOf(((bh.h) hashMap2.get(str)).f1622f));
        }
        JSONArray jSONArray = new JSONArray();
        for (String str2 : hashMap.keySet()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str2);
                jSONObject.put("version", hashMap.get(str2));
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
            }
        }
        return jSONArray;
    }

    public static boolean b(Throwable th2, Set<String> set) {
        b.a.f1608a.a(yk.c.f33566b, th2, "check self: keywords = " + set);
        String a10 = i.a(th2);
        if (a10 == null) {
            return false;
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (a10.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean c() {
        return j.a().getBoolean("handle_self_crash", false);
    }
}
