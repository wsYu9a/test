package com.vivo.mobilead.unified;

/* loaded from: classes4.dex */
public interface IBidding {

    public interface BidPriceCode {
        public static final int ERR_AD_NOT_BID_MODE = -2;
        public static final int ERR_AD_NOT_READY = -1;
        public static final int ERR_GDT_NOT_SUPPORT = -5;
        public static final int ERR_KS_NOT_SUPPORT = -6;
        public static final int ERR_OTHER = -3;
        public static final int ERR_TT_NOT_SUPPORT = -4;
    }

    int getPrice();

    String getPriceLevel();

    void sendLossNotification(int i2, int i3);

    void sendWinNotification(int i2);
}
