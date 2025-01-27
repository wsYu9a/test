package com.wbl.ad.yzz.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: h */
    public String f32219h;

    /* renamed from: a */
    public com.wbl.ad.yzz.gson.t.c f32212a = com.wbl.ad.yzz.gson.t.c.f32279g;

    /* renamed from: b */
    public LongSerializationPolicy f32213b = LongSerializationPolicy.DEFAULT;

    /* renamed from: c */
    public d f32214c = FieldNamingPolicy.IDENTITY;

    /* renamed from: d */
    public final Map<Type, g<?>> f32215d = new HashMap();

    /* renamed from: e */
    public final List<r> f32216e = new ArrayList();

    /* renamed from: f */
    public final List<r> f32217f = new ArrayList();

    /* renamed from: g */
    public boolean f32218g = false;

    /* renamed from: i */
    public int f32220i = 2;

    /* renamed from: j */
    public int f32221j = 2;
    public boolean k = false;
    public boolean l = false;
    public boolean m = true;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;

    public e a() {
        List<r> arrayList = new ArrayList<>(this.f32216e.size() + this.f32217f.size() + 3);
        arrayList.addAll(this.f32216e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f32217f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f32219h, this.f32220i, this.f32221j, arrayList);
        return new e(this.f32212a, this.f32214c, this.f32215d, this.f32218g, this.k, this.o, this.m, this.n, this.p, this.l, this.f32213b, this.f32219h, this.f32220i, this.f32221j, this.f32216e, this.f32217f, arrayList);
    }

    public f b() {
        this.m = false;
        return this;
    }

    public f c() {
        this.f32218g = true;
        return this;
    }

    public final void a(String str, int i2, int i3, List<r> list) {
        a aVar;
        a aVar2;
        a aVar3;
        if (str != null && !"".equals(str.trim())) {
            aVar = new a(Date.class, str);
            aVar2 = new a(Timestamp.class, str);
            aVar3 = new a(java.sql.Date.class, str);
        } else {
            if (i2 == 2 || i3 == 2) {
                return;
            }
            a aVar4 = new a(Date.class, i2, i3);
            a aVar5 = new a(Timestamp.class, i2, i3);
            a aVar6 = new a(java.sql.Date.class, i2, i3);
            aVar = aVar4;
            aVar2 = aVar5;
            aVar3 = aVar6;
        }
        list.add(com.wbl.ad.yzz.gson.t.k.n.a(Date.class, aVar));
        list.add(com.wbl.ad.yzz.gson.t.k.n.a(Timestamp.class, aVar2));
        list.add(com.wbl.ad.yzz.gson.t.k.n.a(java.sql.Date.class, aVar3));
    }
}
