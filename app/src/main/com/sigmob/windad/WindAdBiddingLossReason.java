package com.sigmob.windad;

/* loaded from: classes4.dex */
public enum WindAdBiddingLossReason {
    LOSS_REASON_LOW_PRICE(2, "出价过低"),
    LOSS_REASON_RETURN_TIMEOUT(2000, "返回超时"),
    LOSS_REASON_RETURN_ERROR(2001, "广告素材格式错误");


    /* renamed from: a */
    public int f20862a;
    private String message;

    WindAdBiddingLossReason(int i10, String str) {
        this.f20862a = i10;
        this.message = str;
    }

    public int getCode() {
        return this.f20862a;
    }

    public String getMessage() {
        return this.message;
    }
}
