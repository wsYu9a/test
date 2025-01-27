package com.shu.priory.videolib;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public int f17369b;

    /* renamed from: d, reason: collision with root package name */
    public String f17371d;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f17374g;

    /* renamed from: a, reason: collision with root package name */
    public final String f17368a = "URL_KEY_DEFAULT";

    /* renamed from: c, reason: collision with root package name */
    public LinkedHashMap f17370c = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public HashMap f17372e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public boolean f17373f = false;

    public a(String str, String str2) {
        this.f17371d = "";
        this.f17370c.put("URL_KEY_DEFAULT", str);
        this.f17371d = str2;
        this.f17369b = 0;
    }

    public Object a() {
        return a(this.f17369b);
    }

    public Object a(int i10) {
        int i11 = 0;
        for (Object obj : this.f17370c.keySet()) {
            if (i11 == i10) {
                return this.f17370c.get(obj);
            }
            i11++;
        }
        return null;
    }

    public boolean a(Object obj) {
        if (obj != null) {
            return this.f17370c.containsValue(obj);
        }
        return false;
    }
}
