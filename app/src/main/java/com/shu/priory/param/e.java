package com.shu.priory.param;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    HashMap<String, Object> f17185a = new HashMap<>();

    public Object a(String str) {
        return this.f17185a.get(str);
    }

    public boolean b(String str) {
        return this.f17185a.containsKey(str);
    }

    public void a(String str, Object obj) {
        a(str, obj, true);
    }

    public void a(String str, Object obj, boolean z10) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if (z10 || !this.f17185a.containsKey(str)) {
            this.f17185a.put(str, obj);
        }
    }
}
