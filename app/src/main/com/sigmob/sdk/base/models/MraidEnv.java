package com.sigmob.sdk.base.models;

import com.czhj.sdk.common.ClientMetadata;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.f;
import com.sigmob.sdk.base.k;

/* loaded from: classes4.dex */
public class MraidEnv {
    public final Boolean coppa;
    public final String version = "2.0";
    public final String sdk = StringUtil.decode(StringUtil.f8837s);
    public final String sdkVersion = k.f18179k;
    public final String appId = ClientMetadata.getInstance().getAppPackageName();
    public final String ifa = ClientMetadata.getInstance().getAdvertisingId();
    public final Boolean limitAdTracking = Boolean.valueOf(ClientMetadata.getInstance().getLimitAdTrackingEnabled());

    public MraidEnv() {
        this.coppa = Boolean.valueOf(f.f().d() == 1);
    }
}
