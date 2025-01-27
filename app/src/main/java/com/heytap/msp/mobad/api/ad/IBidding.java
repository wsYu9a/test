package com.heytap.msp.mobad.api.ad;

/* loaded from: classes.dex */
public interface IBidding {
    public static final int CODE_RANK_LOSE_OTHER = 4;
    public static final int CODE_RANK_LOSS_AD_FAIL = 3;
    public static final int CODE_RANK_LOSS_LOW_PRICE = 1;
    public static final int CODE_RANK_LOSS_TIMEOUT = 2;

    int getECPM();

    void notifyRankLoss(int i2, String str, int i3);

    void notifyRankWin(int i2);

    void setBidECPM(int i2);
}
