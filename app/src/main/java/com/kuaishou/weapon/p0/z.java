package com.kuaishou.weapon.p0;

import com.tencent.bugly.beta.tinker.TinkerManager;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class z {

    /* renamed from: e */
    private Set<String> f11392e = new HashSet();

    /* renamed from: f */
    private Set<String> f11393f = new HashSet();

    /* renamed from: g */
    private Set<String> f11394g = new HashSet();

    /* renamed from: h */
    private Set<String> f11395h = new HashSet();

    /* renamed from: a */
    private String f11388a = i.a("f118f1f9431de3a626df48d7302911", "0820");

    /* renamed from: b */
    private String f11389b = i.a("f118f1ef4616f3fc27d1", "0820");

    /* renamed from: c */
    private String f11390c = i.a("f118f1e84f0bf5ba3bd1579c6d35", "0820");

    /* renamed from: d */
    private String f11391d = i.a("fc03e7a44510", "0820");

    /* JADX WARN: Code restructure failed: missing block: B:183:0x01f2, code lost:
    
        if (r1 == null) goto L519;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONArray a(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.z.a(android.content.Context):org.json.JSONArray");
    }

    public Set<String> b() {
        try {
            Set<String> set = this.f11394g;
            if (set == null || set.size() <= 0) {
                return null;
            }
            return this.f11394g;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set<String> c() {
        try {
            Set<String> set = this.f11395h;
            if (set == null || set.size() <= 0) {
                return null;
            }
            return this.f11395h;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d() {
        try {
            Set<String> set = this.f11392e;
            if (set == null || set.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (String str : this.f11392e) {
                if (str.contains(this.f11388a)) {
                    jSONObject.put("0", 1);
                } else if (str.contains(this.f11389b)) {
                    jSONObject.put("1", 1);
                } else if (str.contains(this.f11390c)) {
                    jSONObject.put("2", 1);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set e() {
        try {
            HashSet hashSet = new HashSet();
            Set<String> set = this.f11392e;
            if (set == null || set.size() <= 0) {
                return null;
            }
            for (String str : this.f11392e) {
                if (str.endsWith(TinkerManager.PATCH_DIR)) {
                    hashSet.add(str);
                }
                if (hashSet.size() > 5) {
                    break;
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

    public int a() {
        try {
            Set<String> set = this.f11393f;
            if (set == null || set.size() <= 0) {
                return 0;
            }
            return this.f11393f.size();
        } catch (Exception unused) {
            return 0;
        }
    }
}
