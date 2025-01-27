package com.aggmoread.sdk.client;

/* loaded from: classes.dex */
public interface AMConst {
    public static final String REWARD_ERROR_CODE = "reward.ERROR_CODE";

    public interface AdBidFailReason {
        public static final int AD_DATA_ERROR = 4;
        public static final int LOW_PRICE = 1;
        public static final int NO_AD = 3;
        public static final int OTHER = 10001;
        public static final int TIME_OUT = 2;
    }

    public interface ExtrasKey {
        public static final String AD_ID = "EXTRA_network_ad_ID";
        public static final String AD_NETWORK_NAME = "EXTRA_KEY_network_name";
        public static final String AD_PLACEMENT_ID = "EXTRA_network_placementId";
        public static final String AD_PRICE = "EXTRA_KEY_ad_ecpm";
        public static final String AD_PRIORITY = "EXTRA_KEY_ad_priority";
        public static final String AD_TITLE_INFO = "EXTRA_KEY_ad_title_info";
    }
}
