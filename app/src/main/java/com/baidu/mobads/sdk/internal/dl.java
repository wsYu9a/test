package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

/* loaded from: classes.dex */
public class dl {

    /* renamed from: a, reason: collision with root package name */
    private Boolean f5796a;

    public dl(Context context, Activity activity, Boolean bool) {
        this.f5796a = bool;
        a().booleanValue();
    }

    public Boolean a() {
        return this.f5796a;
    }

    protected HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    public String c() {
        return null;
    }
}
