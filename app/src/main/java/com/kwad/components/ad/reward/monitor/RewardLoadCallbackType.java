package com.kwad.components.ad.reward.monitor;

/* loaded from: classes2.dex */
public enum RewardLoadCallbackType implements a {
    LOAD_SUCCESS_BEFORE("load_success_before"),
    LOAD_SUCCESS(com.sigmob.sdk.base.common.a.B),
    LOAD_ERROR("load_error"),
    LOAD_CACHE_SUCCESS_BEFORE("load_cache_success_before"),
    LOAD_CACHE_SUCCESS("load_cache_success");

    private String typeValue;

    RewardLoadCallbackType(String str) {
        this.typeValue = str;
    }

    @Override // com.kwad.components.ad.reward.monitor.a
    public final String getTypeValue() {
        return this.typeValue;
    }
}
