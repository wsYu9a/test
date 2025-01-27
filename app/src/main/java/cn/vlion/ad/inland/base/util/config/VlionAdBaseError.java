package cn.vlion.ad.inland.base.util.config;

import android.text.TextUtils;
import cn.vlion.ad.inland.base.l1;
import java.util.Locale;

/* loaded from: classes.dex */
public class VlionAdBaseError {
    public static final int AD_APP_KEY_IS_EMPTY_CODE = 10025;
    private static final int AD_IS_NOT_FILL_CODE = 10009;
    private static final int AD_IS_REQUEST_LIMIT_CODE = 10029;
    private static final int AD_RENDER_ERROR_CODE = 10010;
    private static final int AD_RESPONSE_IS_NULL_CODE = 10008;
    private static final int AD_REWARD_VIDEO_PLAY_ERROR_CODE = 10011;
    public static final int AD_Show_ERROR_CODE = 10027;
    public static final int AD_VIDEO_LOAD_DATA_EMPTY_CODE = 10029;
    public static final int AD_VIDEO_LOAD_ERROR_CODE = 10028;
    public static final int LOAD_BODY_NULL_CODE = 10007;
    public static final int LOAD_IMAGE_ERROR_CODE = 10006;
    private static final int NO_FILL_BODY_ERROR_CODE = 10001;
    public static final int SERVER_DATA_Exception_CODE = 10005;
    public static final int SERVER_DATA_JSON_NULL = 10003;
    public static final int SERVER_DATA_JSON_SYNTAX_EXCEPTION = 10002;
    public static final int SERVER_ERROR_CODE = 10004;
    public static final int SERVER_URL_IS_EMPTY_CODE = 10024;
    public static final int SERVICE_ERROR_CODE = 10000;
    private final int errorCode;
    private final String errorMessage;
    public static final VlionAdBaseError NO_FILL_BODY = new VlionAdBaseError(10001, "No Fill body");
    public static final VlionAdBaseError SERVER_DATA_JSON_IS_NULL = new VlionAdBaseError(10003, "json parse is null");
    public static final VlionAdBaseError LOAD_BODY_NULL = new VlionAdBaseError(10007, "Load Body Null");
    public static final VlionAdBaseError AD_RESPONSE_IS_NULL = new VlionAdBaseError(10008, "ad Response is null");
    public static final VlionAdBaseError AD_IS_NOT_FILL = new VlionAdBaseError(10009, "ad is not fill");
    public static final VlionAdBaseError AD_RENDER_ERROR = new VlionAdBaseError(10010, "ad render Fail");
    public static final VlionAdBaseError AD_REWARD_VIDEO_PLAY_ERROR = new VlionAdBaseError(10011, "ad reward video play fail");
    public static final int LOAD_AD_CONTEXT_IS_NULL_CODE = 10013;
    public static final VlionAdBaseError LOAD_AD_CONTEXT_IS_NULL = new VlionAdBaseError(LOAD_AD_CONTEXT_IS_NULL_CODE, "context is null");
    public static final int LOAD_AD_SLOT_IS_NULL_CODE = 10014;
    public static final VlionAdBaseError LOAD_AD_SLOT_IS_NULL = new VlionAdBaseError(LOAD_AD_SLOT_IS_NULL_CODE, "SlotConfig is null");
    public static final int AD_APP_ID_IS_EMPTY_CODE = 10015;
    public static final VlionAdBaseError AD_APP_ID_IS_EMPTY = new VlionAdBaseError(AD_APP_ID_IS_EMPTY_CODE, "AppId is empty");
    public static final int AD_TAG_ID_IS_EMPTY_CODE = 10016;
    public static final VlionAdBaseError AD_TAG_ID_IS_EMPTY = new VlionAdBaseError(AD_TAG_ID_IS_EMPTY_CODE, "TagId is empty");
    public static final int AD_NOT_LOAD_WIN_PRICE_ERROR_CODE = 10017;
    public static final VlionAdBaseError AD_NOT_LOAD_WIN_PRICE_ERROR = new VlionAdBaseError(AD_NOT_LOAD_WIN_PRICE_ERROR_CODE, "ad not load win price fail");
    public static final int AD_NOT_READY_WIN_PRICE_FAIL_CODE = 10018;
    public static final VlionAdBaseError AD_NOT_READY_WIN_PRICE_FAIL = new VlionAdBaseError(AD_NOT_READY_WIN_PRICE_FAIL_CODE, "ad not ready win price fail");
    public static final int AD_NOT_LOAD_ERROR_CODE = 10019;
    public static final VlionAdBaseError AD_NOT_LOAD_ERROR = new VlionAdBaseError(AD_NOT_LOAD_ERROR_CODE, "ad not load ,show fail");
    public static final int AD_NOT_READY_ERROR_CODE = 10020;
    public static final VlionAdBaseError AD_NOT_READY_ERROR = new VlionAdBaseError(AD_NOT_READY_ERROR_CODE, "ad not ready ,show fail");
    public static final int AD_AD_CONFIG_ERROR_CODE = 10021;
    public static final VlionAdBaseError AD_AD_CONFIG_ERROR = new VlionAdBaseError(AD_AD_CONFIG_ERROR_CODE, "ad config is null");
    public static final int AD_AD_CONFIG_EMPTY_CODE = 10022;
    public static final VlionAdBaseError AD_AD_CONFIG_EMPTY = new VlionAdBaseError(AD_AD_CONFIG_EMPTY_CODE, "ad config is empty");
    private static final int AD_IS_NOT_FILL_TIME_OUT_CODE = 100023;
    public static final VlionAdBaseError AD_IS_NOT_FILL_TIME_OUT = new VlionAdBaseError(AD_IS_NOT_FILL_TIME_OUT_CODE, "ad load timeout");
    public static final VlionAdBaseError SERVER_URL_IS_EMPTY = new VlionAdBaseError(10024, "service url is empty");
    public static final VlionAdBaseError AD_APP_KEY_IS_EMPTY = new VlionAdBaseError(10025, "AppKey is empty");
    public static final int Exception_CODE = 10026;
    public static final VlionAdBaseError Exception_CODE_ERROR = new VlionAdBaseError(Exception_CODE, "unknown error");
    public static final VlionAdBaseError AD_VIDEO_LOAD_DATA_EMPTY = new VlionAdBaseError(10029, "config data is empty");
    public static final VlionAdBaseError AD_APP_REQUEST_LIMIT = new VlionAdBaseError(10029, "request limit");
    private static final int AD_IS_IMAGE_LIST_EMPTY_CODE = 10030;
    public static final VlionAdBaseError AD_IS_IMAGE_LIST_EMPTY = new VlionAdBaseError(AD_IS_IMAGE_LIST_EMPTY_CODE, "image list is empty");
    private static final int AD_IS_IMAGE_LIST_BITMAP_EMPTY_CODE = 10031;
    public static final VlionAdBaseError AD_IS_IMAGE_LIST_BITMAP_EMPTY = new VlionAdBaseError(AD_IS_IMAGE_LIST_BITMAP_EMPTY_CODE, "image bitmap list is empty");
    public static final VlionAdBaseError OTHER_AD_IS_DESTROY = new VlionAdBaseError(300001, "ad is already destroy,try load again");
    public static final VlionAdBaseError OTHER_AD_SHOW_ERROR = new VlionAdBaseError(300002, "ad is not already ,try load first");
    public static final VlionAdBaseError OTHER_AD_IS_EMPTY = new VlionAdBaseError(300003, "ad list is empty ,try load first");
    public static final VlionAdBaseError OTHER_AD_RENDER_ERROR = new VlionAdBaseError(300004, "ad is null,render failed");

    public VlionAdBaseError(int i10, String str) {
        str = TextUtils.isEmpty(str) ? "unknown error" : str;
        this.errorCode = i10;
        this.errorMessage = str;
    }

    public static VlionAdBaseError internalError(int i10) {
        return new VlionAdBaseError(i10, String.format(Locale.US, "Internal error %d", Integer.valueOf(i10)));
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String toString() {
        StringBuilder a10 = l1.a("VlionAdError{errorCode=");
        a10.append(this.errorCode);
        a10.append(", errorMessage='");
        a10.append(this.errorMessage);
        a10.append('\'');
        a10.append('}');
        return a10.toString();
    }
}
