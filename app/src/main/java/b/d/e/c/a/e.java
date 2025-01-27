package b.d.e.c.a;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e extends b implements c {

    /* renamed from: a */
    final JSONObject f4558a = new JSONObject();

    public e() {
        new HashMap();
    }

    public c c(c cVar) {
        return d(cVar.getJSONAppender());
    }

    public c d(JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.f4558a.put(next, jSONObject.getString(next));
                } catch (JSONException e2) {
                    d.f("PATAG", "ERR %s", e2);
                }
            }
        }
        return this;
    }

    @Override // b.d.e.c.a.c
    public JSONObject getJSONAppender() {
        return this.f4558a;
    }
}
