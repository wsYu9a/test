package com.sigmob.sdk.videoplayer;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: f */
    public static final String f20795f = "URL_KEY_DEFAULT";

    /* renamed from: a */
    public int f20796a;

    /* renamed from: b */
    public LinkedHashMap f20797b;

    /* renamed from: c */
    public HashMap<String, String> f20798c;

    /* renamed from: d */
    public boolean f20799d;

    /* renamed from: e */
    public Object[] f20800e;
    public String title;

    public h(Object obj) {
        this.f20797b = new LinkedHashMap();
        this.title = "";
        this.f20798c = new HashMap<>();
        this.f20799d = false;
        this.f20797b.put("URL_KEY_DEFAULT", obj);
        this.f20796a = 0;
    }

    public h a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.f20797b);
        return new h(linkedHashMap, this.title);
    }

    public Object b() {
        return a(this.f20796a);
    }

    public Object c() {
        return b(this.f20796a);
    }

    public h(String str) {
        this.f20797b = new LinkedHashMap();
        this.title = "";
        this.f20798c = new HashMap<>();
        this.f20799d = false;
        this.f20797b.put("URL_KEY_DEFAULT", str);
        this.f20796a = 0;
    }

    public boolean a(Object obj) {
        if (obj != null) {
            return this.f20797b.containsValue(obj);
        }
        return false;
    }

    public Object b(int i10) {
        int i11 = 0;
        for (Object obj : this.f20797b.keySet()) {
            if (i11 == i10) {
                return this.f20797b.get(obj);
            }
            i11++;
        }
        return null;
    }

    public h(String str, String str2) {
        this.f20797b = new LinkedHashMap();
        this.title = "";
        this.f20798c = new HashMap<>();
        this.f20799d = false;
        this.f20797b.put("URL_KEY_DEFAULT", str);
        this.title = str2;
        this.f20796a = 0;
    }

    public String a(int i10) {
        int i11 = 0;
        for (Object obj : this.f20797b.keySet()) {
            if (i11 == i10) {
                return obj.toString();
            }
            i11++;
        }
        return null;
    }

    public h(LinkedHashMap linkedHashMap) {
        this.f20797b = new LinkedHashMap();
        this.title = "";
        this.f20798c = new HashMap<>();
        this.f20799d = false;
        this.f20797b.clear();
        this.f20797b.putAll(linkedHashMap);
        this.f20796a = 0;
    }

    public h(LinkedHashMap linkedHashMap, String str) {
        this.f20797b = new LinkedHashMap();
        this.title = "";
        this.f20798c = new HashMap<>();
        this.f20799d = false;
        this.f20797b.clear();
        this.f20797b.putAll(linkedHashMap);
        this.title = str;
        this.f20796a = 0;
    }
}
