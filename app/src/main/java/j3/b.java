package j3;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends h3.e {
    @Override // h3.e
    public String h(n3.a aVar, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        if (hashMap2 == null) {
            hashMap2 = new HashMap<>();
        }
        hashMap2.putAll(p3.a.a(aVar));
        p3.d.i(z2.a.A, "cf " + hashMap2);
        return super.h(aVar, hashMap, hashMap2);
    }

    @Override // h3.e
    public JSONObject j() throws JSONException {
        return h3.e.k("sdkConfig", "obtain");
    }

    @Override // h3.e
    public String n() {
        return "5.0.0";
    }

    @Override // h3.e
    public boolean o() {
        return true;
    }
}
