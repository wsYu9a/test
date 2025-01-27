package com.bytedance.sdk.openadsdk.c.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.Map;

/* loaded from: classes2.dex */
public class i extends TTCustomController {

    /* renamed from: a */
    private final Bridge f8107a;

    public i(Bridge bridge) {
        this.f8107a = bridge == null ? com.bykv.a.a.a.a.b.f7417b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean alist() {
        return ((Boolean) this.f8107a.call(262103, com.bykv.a.a.a.a.b.a(0).b(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getAndroidId() {
        return (String) this.f8107a.call(262112, com.bykv.a.a.a.a.b.a(0).b(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevImei() {
        return (String) this.f8107a.call(262105, com.bykv.a.a.a.a.b.a(0).b(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevOaid() {
        return (String) this.f8107a.call(262109, com.bykv.a.a.a.a.b.a(0).b(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getMacAddress() {
        return (String) this.f8107a.call(262107, com.bykv.a.a.a.a.b.a(0).b(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public LocationProvider getTTLocation() {
        return (LocationProvider) this.f8107a.call(262102, com.bykv.a.a.a.a.b.a(0).b(), LocationProvider.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseAndroidId() {
        return ((Boolean) this.f8107a.call(262110, com.bykv.a.a.a.a.b.a(0).b(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseLocation() {
        return ((Boolean) this.f8107a.call(262101, com.bykv.a.a.a.a.b.a(0).b(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePermissionRecordAudio() {
        return ((Boolean) this.f8107a.call(262111, com.bykv.a.a.a.a.b.a(0).b(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePhoneState() {
        return ((Boolean) this.f8107a.call(262104, com.bykv.a.a.a.a.b.a(0).b(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWifiState() {
        return ((Boolean) this.f8107a.call(262106, com.bykv.a.a.a.a.b.a(0).b(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWriteExternal() {
        return ((Boolean) this.f8107a.call(262108, com.bykv.a.a.a.a.b.a(0).b(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public Map<String, Object> userPrivacyConfig() {
        return (Map) this.f8107a.call(262119, com.bykv.a.a.a.a.b.a(0).b(), Map.class);
    }
}
