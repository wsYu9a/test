package com.bytedance.sdk.openadsdk.api;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a */
    protected EventListener f8037a;

    public void a(int i10, Result result) {
        if (a()) {
            return;
        }
        this.f8037a.onEvent(i10, result);
    }

    public void a(int i10) {
        a(i10, null);
    }

    public boolean a() {
        return this.f8037a == null;
    }
}
