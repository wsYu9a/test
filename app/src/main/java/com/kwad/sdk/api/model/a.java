package com.kwad.sdk.api.model;

/* loaded from: classes2.dex */
public final class a implements IKsAdLabel {
    public int aaM;
    public int aaN;
    public String aaO;
    public String aaP;
    public String aaQ;
    public String aaR;
    public String aaS;
    public long aaT;

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getChannel() {
        return this.aaS;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final long getCpmBidFloor() {
        return this.aaT;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getHistoryTitle() {
        return this.aaR;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getPostTitle() {
        return this.aaQ;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getPrevTitle() {
        return this.aaP;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final int getThirdAge() {
        return this.aaM;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final int getThirdGender() {
        return this.aaN;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getThirdInterest() {
        return this.aaO;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setChannel(String str) {
        this.aaS = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setCpmBidFloor(long j2) {
        this.aaT = j2;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setHistoryTitle(String str) {
        this.aaR = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setPostTitle(String str) {
        this.aaQ = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setPrevTitle(String str) {
        this.aaP = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setThirdAge(int i2) {
        this.aaM = i2;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setThirdGender(int i2) {
        this.aaN = i2;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setThirdInterest(String str) {
        this.aaO = str;
    }
}
