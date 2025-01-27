package com.martian.ttbook.b.c.a.a;

import android.os.Bundle;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private final Bundle f15204a;

    /* renamed from: b */
    private final LinkedHashMap<String, Object> f15205b;

    public a(Bundle bundle, LinkedHashMap<String, Object> linkedHashMap) {
        Bundle bundle2 = new Bundle();
        this.f15204a = bundle2;
        LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<>();
        this.f15205b = linkedHashMap2;
        bundle2.putAll(bundle);
        linkedHashMap2.putAll(linkedHashMap);
    }

    public int a(String str, int i2) {
        return this.f15204a.getInt(str, i2);
    }

    public boolean b(String str) {
        return this.f15204a.containsKey(str) || this.f15205b.containsKey(str);
    }
}
