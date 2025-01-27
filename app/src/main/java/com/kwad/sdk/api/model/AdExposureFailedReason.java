package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes3.dex */
public class AdExposureFailedReason {
    public String adRequestId;
    public String adTitle;
    public String adUserName;
    public String adnName;
    public int adnType;
    public int isClick;
    public int isShow;
    public int winEcpm;

    public AdExposureFailedReason setAdRequestId(String str) {
        this.adRequestId = str;
        return this;
    }

    public AdExposureFailedReason setAdTitle(String str) {
        this.adTitle = str;
        return this;
    }

    public AdExposureFailedReason setAdUserName(String str) {
        this.adUserName = str;
        return this;
    }

    public AdExposureFailedReason setAdnName(String str) {
        this.adnName = str;
        return this;
    }

    public AdExposureFailedReason setAdnType(int i10) {
        this.adnType = i10;
        return this;
    }

    public AdExposureFailedReason setIsClick(int i10) {
        this.isClick = i10;
        return this;
    }

    public AdExposureFailedReason setIsShow(int i10) {
        this.isShow = i10;
        return this;
    }

    public AdExposureFailedReason setWinEcpm(int i10) {
        this.winEcpm = i10;
        return this;
    }
}
