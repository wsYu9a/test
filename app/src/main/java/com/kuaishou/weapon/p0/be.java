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

/* loaded from: classes.dex */
public class be {

    /* renamed from: a */
    private JSONObject f9103a;

    public be(Context context, int i2) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f9190c).intValue(), 5, i2, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f9103a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f9103a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
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

    public JSONObject a() {
        return this.f9103a;
    }

    public JSONObject a(JSONArray jSONArray) {
        String str;
        if (jSONArray != null && jSONArray.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getString(i2);
                    if (string.contains("data/data")) {
                        if (string.contains("libjnigraphics.so")) {
                            jSONObject.put("0", 1);
                            str = "0-p";
                        } else if (string.contains("libandroid.so")) {
                            jSONObject.put("1", 1);
                            str = "1-p";
                        } else if (string.contains("libjavacrypto.so")) {
                            jSONObject.put("2", 1);
                            str = "2-p";
                        } else if (string.contains("libRSCpuRef.so")) {
                            jSONObject.put("3", 1);
                            str = "3-p";
                        }
                        jSONObject.put(str, string);
                    }
                }
                if (jSONObject.length() > 0) {
                    return jSONObject;
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

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f9103a;
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
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add((String) jSONArray.get(i2));
            }
            Set a2 = a(hashSet);
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            return new JSONArray((Collection) a2);
        } catch (Exception unused) {
            return null;
        }
    }
}
