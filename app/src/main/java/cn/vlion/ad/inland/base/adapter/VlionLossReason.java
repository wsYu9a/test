package cn.vlion.ad.inland.base.adapter;

/* loaded from: classes.dex */
public enum VlionLossReason {
    TimeOut("返回超时"),
    CecheOut("缓存超时"),
    BidFailure("竞价失败"),
    LowerBidFloor("出价低于底价"),
    BlockFrequency("媒体屏蔽-频控"),
    BlockAdMaterial("媒体屏蔽-物料体验相关"),
    BlockCompetitiveProduct("媒体屏蔽-竞品相关"),
    OtherReason("其他原因");

    private String value;

    VlionLossReason(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
