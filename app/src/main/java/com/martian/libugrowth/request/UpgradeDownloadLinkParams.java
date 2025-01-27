package com.martian.libugrowth.request;

/* loaded from: classes3.dex */
public class UpgradeDownloadLinkParams extends UGrowthHttpPostParams {
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "upgrade/" + getId() + "/download";
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
