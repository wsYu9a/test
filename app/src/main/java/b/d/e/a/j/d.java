package b.d.e.a.j;

import com.opos.acs.st.utils.ErrorContants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d implements b {
    private static final String TAG_P = "PATAG";
    final JSONObject parameters = new JSONObject();
    final HashMap<String, Object> valueObjectMapping = new HashMap<>();

    public b append(b bVar) {
        return append(bVar.getJSONAppender());
    }

    public b append(String str, int i2) {
        append(str, String.valueOf(i2));
        return this;
    }

    public b append(String str, long j2) {
        try {
            this.parameters.put(str, j2);
        } catch (JSONException e2) {
            c.e(TAG_P, "ERR %s", e2);
        }
        return this;
    }

    public b append(String str, Object obj) {
        this.valueObjectMapping.put(str, obj);
        return this;
    }

    public b append(String str, String str2) {
        try {
            this.parameters.put(str, str2);
        } catch (JSONException e2) {
            c.e(TAG_P, "ERR %s", e2);
        }
        return this;
    }

    public b append(String str, JSONArray jSONArray) {
        try {
            this.parameters.put(str, jSONArray);
        } catch (JSONException e2) {
            c.e(TAG_P, "ERR %s", e2);
        }
        return this;
    }

    public b append(String str, boolean z) {
        try {
            this.parameters.put(str, z);
        } catch (JSONException e2) {
            c.e(TAG_P, "ERR %s", e2);
        }
        return this;
    }

    public b append(JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.parameters.put(next, jSONObject.getString(next));
                } catch (JSONException e2) {
                    c.e(TAG_P, "ERR %s", e2);
                }
            }
        }
        return this;
    }

    public boolean getBoolean(String str, boolean z) {
        if (has(str)) {
            String string = getString(str, ErrorContants.NET_ERROR);
            if (ErrorContants.NET_ERROR.equals(string)) {
                return z;
            }
            try {
                return Boolean.valueOf(string).booleanValue();
            } catch (Exception unused) {
            }
        }
        return z;
    }

    public int getInt(String str, int i2) {
        if (has(str)) {
            String string = getString(str, ErrorContants.NET_ERROR);
            if (ErrorContants.NET_ERROR.equals(string)) {
                return i2;
            }
            try {
                return Integer.parseInt(string);
            } catch (Exception unused) {
            }
        }
        return i2;
    }

    @Override // b.d.e.a.j.b
    public JSONObject getJSONAppender() {
        return this.parameters;
    }

    public long getLong(String str, long j2) {
        if (has(str)) {
            String string = getString(str, ErrorContants.NET_ERROR);
            if (ErrorContants.NET_ERROR.equals(string)) {
                return j2;
            }
            try {
                return Long.valueOf(string).longValue();
            } catch (Exception unused) {
            }
        }
        return j2;
    }

    public <T> T getObject(String str) {
        return (T) this.valueObjectMapping.get(str);
    }

    public String getString(String str, String str2) {
        try {
            return this.parameters.getString(str);
        } catch (JSONException e2) {
            c.e(TAG_P, "ERR %s", e2);
            return str2;
        }
    }

    public boolean has(String str) {
        return this.parameters.has(str) || this.valueObjectMapping.containsKey(str);
    }

    public void remove(String str) {
        this.parameters.remove(str);
        if (this.valueObjectMapping.containsKey(str)) {
            this.valueObjectMapping.remove(str);
        }
    }
}
