package hg;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d extends JSONObject {

    public static class a {

        /* renamed from: a */
        public JSONObject f26726a;

        /* renamed from: b */
        public JSONObject f26727b;

        /* renamed from: c */
        public String f26728c;

        /* renamed from: d */
        public String f26729d;

        public a a(String str) {
            this.f26728c = str;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.f26726a = jSONObject;
            return this;
        }

        public d c() {
            return new d(this);
        }

        public a f(String str) {
            this.f26729d = str;
            return this;
        }
    }

    public d(a aVar) {
        try {
            put(ExposeManager.UtArgsNames.pid, aVar.f26729d);
            put("nameSpace", aVar.f26728c);
            put("macroArgs", aVar.f26727b);
            put("utArgs", aVar.f26726a);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public JSONObject a() {
        return optJSONObject("utArgs");
    }

    public JSONObject b() {
        return optJSONObject("macroArgs");
    }

    public d(String str) throws JSONException {
        super(str);
    }
}
