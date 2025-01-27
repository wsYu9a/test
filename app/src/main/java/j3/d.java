package j3;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d extends h3.e {

    /* renamed from: t */
    public static final String f27161t = "log_v";

    @Override // h3.e
    public h3.b b(n3.a aVar, Context context, String str) throws Throwable {
        return d(aVar, context, str, z2.a.f33593d, true);
    }

    @Override // h3.e
    public String f(n3.a aVar) throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(h3.e.f26406k, "/sdk/log");
        hashMap.put(h3.e.f26407l, "1.0.0");
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(f27161t, "1.0");
        return h(aVar, hashMap, hashMap2);
    }

    @Override // h3.e
    public Map<String, String> i(boolean z10, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(h3.e.f26398c, String.valueOf(z10));
        hashMap.put(h3.e.f26401f, "application/octet-stream");
        hashMap.put(h3.e.f26404i, "CBC");
        return hashMap;
    }

    @Override // h3.e
    public JSONObject j() throws JSONException {
        return null;
    }

    @Override // h3.e
    public boolean o() {
        return false;
    }

    @Override // h3.e
    public String g(n3.a aVar, String str, JSONObject jSONObject) {
        return str;
    }
}
