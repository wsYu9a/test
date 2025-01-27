package com.martian.mibook.lib.account.request;

import com.martian.libugrowth.adx.request.AdxHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class AdSlotsParams extends AdxHttpGetParams {

    @a
    private Integer count;

    @a
    private Boolean cp;

    @a
    private Long seed;

    public Integer getCount() {
        return this.count;
    }

    public boolean getCp() {
        Boolean bool = this.cp;
        return bool != null && bool.booleanValue();
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "mediation/positions";
    }

    public Long getSeed() {
        return this.seed;
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public void setCp(Boolean bool) {
        this.cp = bool;
    }

    public void setSeed(Long l10) {
        this.seed = l10;
    }
}
