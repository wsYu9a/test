package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ua extends AbstractC0909m implements Cloneable {

    /* renamed from: a */
    static ArrayList<ta> f25166a;

    /* renamed from: b */
    static Map<String, String> f25167b;

    /* renamed from: c */
    public byte f25168c = 0;

    /* renamed from: d */
    public String f25169d = "";

    /* renamed from: e */
    public String f25170e = "";

    /* renamed from: f */
    public ArrayList<ta> f25171f = null;

    /* renamed from: g */
    public Map<String, String> f25172g = null;

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f25168c, 0);
        String str = this.f25169d;
        if (str != null) {
            c0908l.a(str, 1);
        }
        String str2 = this.f25170e;
        if (str2 != null) {
            c0908l.a(str2, 2);
        }
        ArrayList<ta> arrayList = this.f25171f;
        if (arrayList != null) {
            c0908l.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f25172g;
        if (map != null) {
            c0908l.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f25168c = c0907k.a(this.f25168c, 0, true);
        this.f25169d = c0907k.a(1, false);
        this.f25170e = c0907k.a(2, false);
        if (f25166a == null) {
            f25166a = new ArrayList<>();
            f25166a.add(new ta());
        }
        this.f25171f = (ArrayList) c0907k.a((C0907k) f25166a, 3, false);
        if (f25167b == null) {
            HashMap hashMap = new HashMap();
            f25167b = hashMap;
            hashMap.put("", "");
        }
        this.f25172g = (Map) c0907k.a((C0907k) f25167b, 4, false);
    }
}
