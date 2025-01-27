package com.bytedance.sdk.openadsdk.c.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.CSJAdError;

/* loaded from: classes2.dex */
public class a extends CSJAdError {

    /* renamed from: a */
    private final Bridge f8095a;

    public a(Bridge bridge) {
        this.f8095a = bridge == null ? com.bykv.a.a.a.a.b.f7417b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public int getCode() {
        return this.f8095a.values().intValue(263001);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public String getMsg() {
        return (String) this.f8095a.values().objectValue(263002, String.class);
    }
}
