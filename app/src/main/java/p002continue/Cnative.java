package p002continue;

import androidx.annotation.NonNull;
import h3.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p3.i;

/* renamed from: continue.native */
/* loaded from: classes4.dex */
public final class Cnative implements Serializable {

    /* renamed from: do */
    public final int f31do;

    /* renamed from: if */
    public final List<Cimport> f32if;

    public Cnative(int i10, List<Cimport> list) {
        ArrayList arrayList = new ArrayList();
        this.f32if = arrayList;
        this.f31do = i10;
        arrayList.addAll(list);
    }

    @NonNull
    /* renamed from: do */
    public static Cnative m53do(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(e.f26408m);
            if (optJSONObject == null) {
                throw new RuntimeException("data is null");
            }
            int optInt = optJSONObject.optInt(i.f29758c);
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("plugins");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    arrayList.add(Cimport.m49do(optJSONArray.getJSONObject(i10)));
                }
            }
            return new Cnative(optInt, arrayList);
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<continue.import>] */
    public final String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(i.f29758c, this.f31do);
            JSONArray jSONArray = new JSONArray();
            ?? r22 = this.f32if;
            if (r22 != 0) {
                Iterator it = r22.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((Cimport) it.next()).m50do());
                }
            }
            jSONObject.put(e.f26408m, jSONArray);
            return jSONObject.toString();
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }
}
