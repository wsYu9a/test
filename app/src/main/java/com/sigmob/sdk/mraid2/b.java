package com.sigmob.sdk.mraid2;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: b */
    public static final b f19695b = new b();

    /* renamed from: a */
    public HashMap<String, d> f19696a = new HashMap<>();

    public void a(String str, d dVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f19696a.put(str, dVar);
    }

    public d b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = this.f19696a.get(str);
        this.f19696a.remove(str);
        return dVar;
    }

    public d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f19696a.get(str);
    }

    public static b a() {
        return f19695b;
    }
}
