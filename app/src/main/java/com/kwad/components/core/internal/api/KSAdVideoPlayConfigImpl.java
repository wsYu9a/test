package com.kwad.components.core.internal.api;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class KSAdVideoPlayConfigImpl implements KsAdVideoPlayConfig, Serializable {
    private static final long serialVersionUID = -154151744722615768L;
    public boolean dataFlowAutoStart;
    public boolean hasNoCache;
    public int videoAutoPlayType;
    public boolean videoSoundEnable;
    private int videoSoundValue = 0;
    private int dataFlowAutoStartValue = 0;

    @InvokeBy(invokerClass = com.kwad.sdk.service.a.class, methodId = "initModeImplForInvoker")
    public static void register() {
        com.kwad.sdk.service.a.b(KsAdVideoPlayConfig.class, KSAdVideoPlayConfigImpl.class);
    }

    public int getDataFlowAutoStartValue() {
        return this.dataFlowAutoStartValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public int getVideoAutoPlayType() {
        return this.videoAutoPlayType;
    }

    public int getVideoSoundValue() {
        return this.videoSoundValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isDataFlowAutoStart() {
        return this.dataFlowAutoStart;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isNoCache() {
        return this.hasNoCache;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isVideoSoundEnable() {
        return this.videoSoundEnable;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setDataFlowAutoStart(boolean z) {
        this.dataFlowAutoStart = z;
        this.dataFlowAutoStartValue = 1;
        this.videoAutoPlayType = 0;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setNoCache() {
        this.hasNoCache = true;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setVideoAutoPlayType(int i2) {
        this.videoAutoPlayType = i2;
        this.dataFlowAutoStartValue = 0;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setVideoSoundEnable(boolean z) {
        this.videoSoundEnable = z;
        this.videoSoundValue = 1;
    }
}
