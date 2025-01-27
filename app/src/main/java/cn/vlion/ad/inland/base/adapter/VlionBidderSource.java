package cn.vlion.ad.inland.base.adapter;

import ke.e;

/* loaded from: classes.dex */
public enum VlionBidderSource {
    ChuanShanJia("穿山甲"),
    YouLiangHui("优量汇"),
    KuaiShou("快手"),
    BaiDu("百度"),
    Sigmob("sigmob"),
    QuMeng("趣盟"),
    Oppo("oppo"),
    Vivo(e.f27807e),
    HuaWei("huawei"),
    SelfSale("自售"),
    Tanx("淘宝"),
    Topon("topon"),
    Pdd("拼多多"),
    Jd("京东"),
    OtherReason("其他");

    private String value;

    VlionBidderSource(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
