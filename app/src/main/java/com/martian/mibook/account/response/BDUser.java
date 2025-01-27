package com.martian.mibook.account.response;

import com.martian.libsupport.h;

/* loaded from: classes3.dex */
public class BDUser {

    @h.a
    private Integer collectCount;

    @h.a
    private Integer consumeCount;

    @h.a
    private Integer userTotalCoin;

    @h.a
    private Integer vipLevel;

    public Integer getCollectCount() {
        return this.collectCount;
    }

    public Integer getConsumeCount() {
        return this.consumeCount;
    }

    public Integer getTotalCoin() {
        return this.userTotalCoin;
    }

    public Integer getVipLevel() {
        return this.vipLevel;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public void setConsumeCount(Integer consumeCount) {
        this.consumeCount = consumeCount;
    }

    public void setTotalCoin(Integer userTotalCoin) {
        this.userTotalCoin = userTotalCoin;
    }

    public void setVipLevel(Integer vipLevel) {
        this.vipLevel = vipLevel;
    }
}
