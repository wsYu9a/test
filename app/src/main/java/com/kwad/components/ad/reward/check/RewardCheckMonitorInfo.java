package com.kwad.components.ad.reward.check;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

@KsJson
/* loaded from: classes.dex */
public class RewardCheckMonitorInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final int CHECK_TYPE_EXPOSURE = 1;
    public static final int CHECK_TYPE_REWARD = 2;
    public static final int ENVI_TYPE_NATIVE = 0;
    public static final int ENVI_TYPE_TK = 1;
    public static final int REQUEST_STATE_END = 2;
    public static final int REQUEST_STATE_START = 1;
    public static final long serialVersionUID = 1080394611500009098L;
    public int checkType;
    public int code;
    public long creativeId;
    public long dataLoadInterval;
    public int enviType;
    public String errorMsg;
    public long posId;
    public int requestStatus;

    public RewardCheckMonitorInfo(long j2) {
        this.posId = j2;
    }

    public RewardCheckMonitorInfo setCheckType(int i2) {
        this.checkType = i2;
        return this;
    }

    public RewardCheckMonitorInfo setCode(int i2) {
        this.code = i2;
        return this;
    }

    public RewardCheckMonitorInfo setCreativeId(long j2) {
        this.creativeId = j2;
        return this;
    }

    public RewardCheckMonitorInfo setDataLoadInterval(long j2) {
        this.dataLoadInterval = j2;
        return this;
    }

    public RewardCheckMonitorInfo setEnviType(int i2) {
        this.enviType = i2;
        return this;
    }

    public RewardCheckMonitorInfo setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public RewardCheckMonitorInfo setRequestStatus(int i2) {
        this.requestStatus = i2;
        return this;
    }
}
