package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ua extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    static ArrayList<ta> f22875a;

    /* renamed from: b */
    static Map<String, String> f22876b;

    /* renamed from: c */
    public byte f22877c = 0;

    /* renamed from: d */
    public String f22878d = "";

    /* renamed from: e */
    public String f22879e = "";

    /* renamed from: f */
    public ArrayList<ta> f22880f = null;

    /* renamed from: g */
    public Map<String, String> f22881g = null;

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22877c, 0);
        String str = this.f22878d;
        if (str != null) {
            c0867l.a(str, 1);
        }
        String str2 = this.f22879e;
        if (str2 != null) {
            c0867l.a(str2, 2);
        }
        ArrayList<ta> arrayList = this.f22880f;
        if (arrayList != null) {
            c0867l.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f22881g;
        if (map != null) {
            c0867l.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22877c = c0866k.a(this.f22877c, 0, true);
        this.f22878d = c0866k.a(1, false);
        this.f22879e = c0866k.a(2, false);
        if (f22875a == null) {
            f22875a = new ArrayList<>();
            f22875a.add(new ta());
        }
        this.f22880f = (ArrayList) c0866k.a((C0866k) f22875a, 3, false);
        if (f22876b == null) {
            HashMap hashMap = new HashMap();
            f22876b = hashMap;
            hashMap.put("", "");
        }
        this.f22881g = (Map) c0866k.a((C0866k) f22876b, 4, false);
    }
}
