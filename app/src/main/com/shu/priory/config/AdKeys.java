package com.shu.priory.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class AdKeys {
    public static final String APP_VER = "app_ver";
    public static final String AUCTION_PRICE = "auction_price";
    public static final String BACK_KEY_ENABLE = "back_key_enable";
    public static final String BANNER_INTERVAL = "banner_interval";
    public static final String BANNER_RECYCLE = "banner_recycle";
    public static final String BID_FLOOR = "bid_floor";
    public static final String COUNT_DOWN = "count_down";
    public static final String CURRENCY = "currency";
    public static final String CUSTOM_PARAM = "custom_param";
    public static final String DEBUG_MODE = "debug_mode";
    public static final String DEBUG_OBJ = "debug";
    public static final String DEEPLINK_CONTORL = "deeplink_control";
    public static final String DOWNLOAD_ALERT = "download_alert";
    public static final String DOWNLOAD_CONTROL = "download_control";
    public static final String EXT = "ext";
    public static final String HTTP_DNS_ENABLE = "httpdns_enable";
    public static final String HTTP_REQUEST_TIMEOUT = "http_request_timeout";
    public static final String IS_ANDROID_ID_ALLOWED = "is_android_id_allowed";
    public static final String IS_IMEI_ALLOWED = "is_imei_allowed";
    public static final String IS_LOCATION_ALLOWED = "is_location_allowed";
    public static final String IS_SHAKING_ALLOWED = "is_shaking_allowed";
    public static final String LOCK_SCREEN_AD = "lock_screen_ad";
    public static final String MAIN_PROCESS_NAME = "main_process_name";
    public static final String OAID = "oaid";
    public static final String PMP = "pmp";
    public static final String REQUEST_ID = "request_id";
    public static final String SETTLE_TYPE = "settle_type";
    public static final String SPLASH_INTERACTION_DISABLE = "splash_interaction_disable";
    public static final int TYPE_INTO_PAGE = 0;
    public static final int TYPE_PERMISSION_PAGE = 1;
    public static final int TYPE_PRIVACY_PAGE = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BiddingFailureType {
        public static final int TYPE_LOW_PRICE = 101;
        public static final int TYPE_LOW_PRIORITY = 104;
        public static final int TYPE_MATERIAL_REJECTED = 103;
        public static final int TYPE_MATERIAL_UNREVIEWED = 102;
        public static final int TYPE_RSP_ERROR = 105;
        public static final int TYPE_RSP_TIMEOUT = 106;
    }
}
