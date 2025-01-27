package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import com.martian.mibook.activity.appwall.AppwallTaskDetailActivity;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class at {

    /* renamed from: a */
    private JSONObject f10778a;

    /* renamed from: b */
    private boolean f10779b;

    /* renamed from: c */
    private boolean f10780c;

    public at(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f10911g).intValue(), 0, 100, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f10778a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f10778a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f10778a;
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
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                hashSet.add(jSONArray.getString(i10));
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

    public Set c(String str) {
        JSONObject jSONObject = this.f10778a;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(optString) && optString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        Integer valueOf = Integer.valueOf((String) jSONArray.get(i10), 16);
                        valueOf.intValue();
                        hashSet.add(valueOf);
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONArray d(String str) {
        JSONObject jSONObject = this.f10778a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            int i10 = 0;
            if (TextUtils.equals(str, AppwallTaskDetailActivity.f13149a0)) {
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                JSONArray jSONArray2 = new JSONArray();
                while (i10 < jSONArray.length()) {
                    jSONArray2.put(jSONArray.getString(i10).replaceAll(" ", "").replace("\n", "").replace(">", ""));
                    i10++;
                }
                return jSONArray2;
            }
            if (!TextUtils.equals(str, "45")) {
                return null;
            }
            String a10 = i.a("aae31bed33c490b6613a", "0701");
            String a11 = i.a("99e111e83fc4d0a7662b", "0701");
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray3 = new JSONArray(string);
            HashSet hashSet = new HashSet();
            while (i10 < jSONArray3.length()) {
                hashSet.add(jSONArray3.getString(i10).replaceAll(" ", "").replace("\n", ""));
                i10++;
            }
            JSONArray jSONArray4 = new JSONArray();
            for (Object obj : hashSet) {
                jSONArray4.put(obj);
                String str2 = (String) obj;
                if (str2.contains(a10)) {
                    this.f10779b = true;
                }
                if (str2.contains(a11)) {
                    this.f10780c = true;
                }
            }
            return jSONArray4;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set a(int i10) {
        HashSet hashSet = new HashSet();
        if (i10 == 0) {
            hashSet.add("/preas/chi");
        }
        return hashSet;
    }

    public Set a(Context context, String str, int i10) {
        JSONObject jSONObject = this.f10778a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            Set a10 = a(i10);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String replace = jSONArray.getString(i11).replaceAll(" ", "").replace("\n", "").replace("\t", "").replace("\u200b", "");
                boolean startsWith = replace.startsWith(":");
                String str2 = replace;
                if (startsWith) {
                    str2 = replace.substring(1);
                }
                String substring = str2.length() > 10 ? str2.substring(0, 10) : str2;
                String packageName = context.getPackageName();
                if (!str2.contains(packageName) && !packageName.contains(str2) && !a10.contains(substring)) {
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

    public boolean b() {
        return this.f10780c;
    }

    public boolean a() {
        return this.f10779b;
    }
}
