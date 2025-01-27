package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class at {

    /* renamed from: a */
    private JSONObject f9082a;

    /* renamed from: b */
    private boolean f9083b;

    /* renamed from: c */
    private boolean f9084c;

    public at(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f9194g).intValue(), 0, 100, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f9082a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f9082a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public Set a(int i2) {
        HashSet hashSet = new HashSet();
        if (i2 == 0) {
            hashSet.add("/preas/chi");
        }
        return hashSet;
    }

    public Set a(Context context, String str, int i2) {
        JSONObject jSONObject = this.f9082a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            Set a2 = a(i2);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String replace = jSONArray.getString(i3).replaceAll(" ", "").replace("\n", "").replace("\t", "").replace("\u200b", "");
                boolean startsWith = replace.startsWith(":");
                String str2 = replace;
                if (startsWith) {
                    str2 = replace.substring(1);
                }
                String substring = str2.length() > 10 ? str2.substring(0, 10) : str2;
                String packageName = context.getPackageName();
                if (!str2.contains(packageName) && !packageName.contains(str2) && !a2.contains(substring)) {
                    hashSet.add(str2);
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean a() {
        return this.f9083b;
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f9082a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add(jSONArray.getString(i2));
            }
            JSONArray jSONArray2 = new JSONArray();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                jSONArray2.put(it.next());
            }
            return jSONArray2;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b() {
        return this.f9084c;
    }

    public Set c(String str) {
        JSONObject jSONObject = this.f9082a;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(optString) && optString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        hashSet.add(Integer.valueOf(Integer.valueOf((String) jSONArray.get(i2), 16).intValue()));
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONArray d(String str) {
        JSONObject jSONObject = this.f9082a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            int i2 = 0;
            if (TextUtils.equals(str, BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP)) {
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                JSONArray jSONArray2 = new JSONArray();
                while (i2 < jSONArray.length()) {
                    jSONArray2.put(jSONArray.getString(i2).replaceAll(" ", "").replace("\n", "").replace(">", ""));
                    i2++;
                }
                return jSONArray2;
            }
            if (!TextUtils.equals(str, BaseWrapper.ENTER_ID_OAPS_RECENTS)) {
                return null;
            }
            String a2 = i.a("aae31bed33c490b6613a", "0701");
            String a3 = i.a("99e111e83fc4d0a7662b", "0701");
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray3 = new JSONArray(string);
            HashSet hashSet = new HashSet();
            while (i2 < jSONArray3.length()) {
                hashSet.add(jSONArray3.getString(i2).replaceAll(" ", "").replace("\n", ""));
                i2++;
            }
            JSONArray jSONArray4 = new JSONArray();
            for (Object obj : hashSet) {
                jSONArray4.put(obj);
                String str2 = (String) obj;
                if (str2.contains(a2)) {
                    this.f9083b = true;
                }
                if (str2.contains(a3)) {
                    this.f9084c = true;
                }
            }
            return jSONArray4;
        } catch (Exception unused) {
            return null;
        }
    }
}
