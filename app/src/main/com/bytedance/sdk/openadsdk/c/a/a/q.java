package com.bytedance.sdk.openadsdk.c.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTWidgetManager;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class q extends TTWidgetManager {

    /* renamed from: a */
    private final Bridge f8115a;

    public q(Bridge bridge) {
        this.f8115a = bridge == null ? com.bykv.a.a.a.a.b.f7417b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTWidgetManager
    public boolean updateWidgetWithType(int i10, JSONObject jSONObject) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(2);
        a10.a(0, i10);
        a10.a(1, jSONObject);
        return ((Boolean) this.f8115a.call(264001, a10.b(), Boolean.TYPE)).booleanValue();
    }
}
