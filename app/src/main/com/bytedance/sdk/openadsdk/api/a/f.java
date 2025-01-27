package com.bytedance.sdk.openadsdk.api.a;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.config.IDownloadButtonClickListener;

/* loaded from: classes2.dex */
public class f extends com.bytedance.sdk.openadsdk.api.b implements IDownloadButtonClickListener {
    public f(EventListener eventListener) {
        this.f8037a = eventListener;
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleComplianceDialog(boolean z10) {
        a(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG, a() ? null : com.bykv.a.a.a.a.a.a().a(com.bykv.a.a.a.a.b.a().a(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG_SHOULD_SHOW, z10).b()).b());
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleMarketFailedComplianceDialog() {
        a(ValueSetConstants.VALUE_HANDLE_MARKET_FAILED_COMPLIANCE_DIALOG);
    }
}
