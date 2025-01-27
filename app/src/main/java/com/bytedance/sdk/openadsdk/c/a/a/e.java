package com.bytedance.sdk.openadsdk.c.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DownloadStatusController;

/* loaded from: classes2.dex */
public class e implements DownloadStatusController {

    /* renamed from: a */
    private final Bridge f8102a;

    public e(Bridge bridge) {
        this.f8102a = bridge == null ? com.bykv.a.a.a.a.b.f7417b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        this.f8102a.call(222102, com.bykv.a.a.a.a.b.a(0).b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        this.f8102a.call(222101, com.bykv.a.a.a.a.b.a(0).b(), Void.class);
    }
}
