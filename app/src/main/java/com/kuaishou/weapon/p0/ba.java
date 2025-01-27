package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ba {

    /* renamed from: a */
    private JSONObject f10794a;

    public ba(Context context, int i10) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f10907c).intValue(), 2, i10 < 10 ? 10 : i10, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f10794a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f10794a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b(String str) {
        if (this.f10794a == null) {
            return null;
        }
        try {
            String a10 = a(str);
            if (TextUtils.isEmpty(a10) || a10.length() <= 3) {
                return null;
            }
            return new JSONObject(a10);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.f10794a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 2) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                hashSet.add((String) jSONArray.get(i10));
            }
            Set a10 = a(hashSet);
            if (a10 == null || a10.size() <= 0) {
                return null;
            }
            return new JSONArray((Collection) a10);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(String str) {
        if (this.f10794a == null) {
            return null;
        }
        try {
            String a10 = a(str);
            if (TextUtils.isEmpty(a10) || a10.length() <= 3) {
                return null;
            }
            return a(new JSONObject(a10));
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a(String str, boolean z10) {
        if (this.f10794a != null) {
            try {
                String a10 = a(str);
                if (!TextUtils.isEmpty(a10) && a10.length() > 3) {
                    JSONObject jSONObject = new JSONObject(a10);
                    if (!z10) {
                        return jSONObject;
                    }
                    Iterator<String> keys = jSONObject.keys();
                    boolean z11 = false;
                    while (keys.hasNext()) {
                        if (jSONObject.getInt(keys.next()) == 1) {
                            z11 = true;
                        }
                    }
                    if (z11) {
                        return jSONObject;
                    }
                    return null;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean a(Set set, String str) {
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!str2.equals(str) && str2.contains(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public Set a(Set set) {
        if (set != null) {
            try {
                if (set.size() > 0) {
                    HashSet hashSet = new HashSet();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!a(set, str)) {
                            hashSet.add(str);
                        }
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONObject a(JSONObject jSONObject) {
        try {
            String a10 = i.a("da4c6c97b9", "0702");
            String a11 = i.a("da4c709eb15f", "0702");
            JSONArray optJSONArray = jSONObject.optJSONArray(a10);
            JSONArray optJSONArray2 = jSONObject.optJSONArray(a11);
            JSONObject jSONObject2 = new JSONObject();
            if (optJSONArray != null && optJSONArray.length() == 3) {
                jSONObject2.put("0", optJSONArray.get(2));
            }
            if (optJSONArray2 != null && optJSONArray2.length() == 3) {
                jSONObject2.put("1", optJSONArray2.get(2));
            }
            if (jSONObject2.length() > 0) {
                return jSONObject2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
