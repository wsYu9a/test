package com.bytedance.sdk.openadsdk.live.core;

import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;

/* loaded from: classes.dex */
public class j implements ILiveHostActionParam {

    /* renamed from: j */
    private ITTLiveHostAction f6479j;

    public j(ITTLiveHostAction iTTLiveHostAction) {
        this.f6479j = iTTLiveHostAction;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z, String str, String str2, Map<String, String> map) {
        ITTLiveHostAction iTTLiveHostAction = this.f6479j;
        if (iTTLiveHostAction != null) {
            iTTLiveHostAction.logEvent(z, str, str2, map);
        }
    }
}
