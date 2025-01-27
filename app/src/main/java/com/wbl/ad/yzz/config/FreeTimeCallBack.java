package com.wbl.ad.yzz.config;

/* loaded from: classes5.dex */
public interface FreeTimeCallBack {
    public static final int CALL_STATUS_ACTIVE = 1;
    public static final int CALL_STATUS_INACTIVE = 0;
    public static final int OPEN_FAIL_ACTIVITY_START_ERROR = 1007;
    public static final int OPEN_FAIL_BUS_CONTEXT_ERROR = 1005;
    public static final int OPEN_FAIL_CONTEXT_ERROR = 1006;
    public static final int OPEN_FAIL_INIT_ERROR = 10001;
    public static final int OPEN_FAIL_IN_DATA_LOADING = 10003;
    public static final int OPEN_FAIL_LOAD_ERROR = 10002;
    public static final int OPEN_FAIL_SCENE_PARAMS_ERROR = 1008;
    public static final int OPEN_FAIL_WHEN_LOADING_DATA = 1010;
    public static final int OPEN_FAIL_WHEN_SHOWING = 1009;
    public static final int OPEN_FAIL_WILL_SHOW_NEXT_SECTION = 1004;
    public static final int OUT_PARAMA_CLOSE_AD = 1;

    void getTotalFreeTime(int i2);

    void openPageFail(int i2, String str);

    void openPageSuccess();

    void pageExit();
}
