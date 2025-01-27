package com.martian.libugrowth.request;

/* loaded from: classes3.dex */
public class UpgradeDownloadLinkParams extends UGrowthHttpPostParams {

    /* renamed from: id */
    private Integer f13014id;

    public Integer getId() {
        return this.f13014id;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "upgrade/" + getId() + "/download";
    }

    public void setId(Integer num) {
        this.f13014id = num;
    }
}
