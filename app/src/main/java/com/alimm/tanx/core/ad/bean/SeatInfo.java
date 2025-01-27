package com.alimm.tanx.core.ad.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class SeatInfo extends BaseBean {

    @JSONField(serialize = false)
    private List<BidInfo> bidList;

    /* renamed from: id */
    @JSONField(name = "id")
    private int f6314id;

    @JSONField(name = "ad")
    private List<String> rawBidList;

    public List<BidInfo> getBidList() {
        return Collections.synchronizedList(this.bidList);
    }

    public int getId() {
        return this.f6314id;
    }

    public List<String> getRawBidList() {
        return this.rawBidList;
    }

    public SeatInfo setBidList(List<BidInfo> list) {
        this.bidList = list;
        return this;
    }

    public void setId(int i10) {
        this.f6314id = i10;
    }

    public void setRawBidList(List<String> list) {
        this.rawBidList = list;
    }
}
