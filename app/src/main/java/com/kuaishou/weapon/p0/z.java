package com.kuaishou.weapon.p0;

import com.tencent.bugly.beta.tinker.TinkerManager;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class z {

    /* renamed from: e */
    private Set<String> f9531e = new HashSet();

    /* renamed from: f */
    private Set<String> f9532f = new HashSet();

    /* renamed from: g */
    private Set<String> f9533g = new HashSet();

    /* renamed from: h */
    private Set<String> f9534h = new HashSet();

    /* renamed from: a */
    private String f9527a = i.a("f118f1f9431de3a626df48d7302911", "0820");

    /* renamed from: b */
    private String f9528b = i.a("f118f1ef4616f3fc27d1", "0820");

    /* renamed from: c */
    private String f9529c = i.a("f118f1e84f0bf5ba3bd1579c6d35", "0820");

    /* renamed from: d */
    private String f9530d = i.a("fc03e7a44510", "0820");

    public int a() {
        try {
            Set<String> set = this.f9532f;
            if (set == null || set.size() <= 0) {
                return 0;
            }
            return this.f9532f.size();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:179:0x01ea, code lost:
    
        if (r1 == null) goto L316;
     */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0122 A[Catch: all -> 0x01dd, Exception -> 0x01e0, TryCatch #8 {Exception -> 0x01e0, all -> 0x01dd, blocks: (B:5:0x000d, B:7:0x0048, B:8:0x005c, B:10:0x0062, B:12:0x006b, B:14:0x0073, B:16:0x007b, B:18:0x0083, B:24:0x0091, B:27:0x0099, B:30:0x00a1, B:33:0x00a9, B:36:0x00b1, B:38:0x00bd, B:40:0x00c5, B:42:0x00cf, B:44:0x00d7, B:46:0x00df, B:48:0x00e7, B:49:0x00ec, B:52:0x00f4, B:55:0x00fc, B:58:0x0104, B:60:0x010a, B:62:0x0112, B:65:0x011a, B:67:0x0122, B:68:0x0128, B:71:0x0130, B:74:0x0138, B:77:0x0140, B:80:0x0148, B:83:0x0150, B:86:0x0158, B:88:0x0160, B:90:0x0169, B:92:0x0171, B:94:0x0179, B:96:0x0181, B:105:0x018a, B:107:0x0192, B:110:0x0198, B:112:0x01a3, B:114:0x01ab, B:116:0x01b3, B:100:0x01bd, B:101:0x01bf, B:146:0x01c4, B:163:0x01c7, B:121:0x01ca, B:123:0x01d0), top: B:4:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONArray a(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.z.a(android.content.Context):org.json.JSONArray");
    }

    public Set<String> b() {
        try {
            Set<String> set = this.f9533g;
            if (set == null || set.size() <= 0) {
                return null;
            }
            return this.f9533g;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set<String> c() {
        try {
            Set<String> set = this.f9534h;
            if (set == null || set.size() <= 0) {
                return null;
            }
            return this.f9534h;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d() {
        String str;
        try {
            Set<String> set = this.f9531e;
            if (set == null || set.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (String str2 : this.f9531e) {
                if (str2.contains(this.f9527a)) {
                    str = "0";
                } else if (str2.contains(this.f9528b)) {
                    str = "1";
                } else if (str2.contains(this.f9529c)) {
                    str = "2";
                }
                jSONObject.put(str, 1);
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
            Set<String> set = this.f9531e;
            if (set == null || set.size() <= 0) {
                return null;
            }
            for (String str : this.f9531e) {
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
}
