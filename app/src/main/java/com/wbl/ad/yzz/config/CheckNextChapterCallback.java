package com.wbl.ad.yzz.config;

/* loaded from: classes5.dex */
public interface CheckNextChapterCallback {
    public static final int GENDER_EMPTY = 0;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_MALE_AND_FEMALE = 4;
    public static final int GENDER_UNKNOWN = 3;
    public static final int PARAM_ERROR = 1;
    public static final int PARAM_ERROR_SHOWING = 1009;

    void checkFailed(int i2, String str);

    void checkResult(boolean z);
}
