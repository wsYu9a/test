package com.oplus.quickgame.sdk.hall.exception;

/* loaded from: classes4.dex */
public class HallRouterException extends Exception {
    private ErrorEnum errorEnum;

    public enum ErrorEnum {
        NULL_ERROR(99, "the url is null", "链接为空"),
        SCHEME_ERROR(100, "the scheme is not oaps", "链接不是以oaps://开头"),
        HOST_ERROR(101, "the host is not qg", "oaps://后面接的不是qg/"),
        VERSION_ERROR(102, "the version of apk doesn't support this oaps url", "小游戏大厅版本过低不支持该链接"),
        NO_ACTIVITY_SUPPORT_ERROR(103, "no activity supports this url", "找不到支持该链接的页面"),
        MISS_KEY_ERROR(104, "miss key: ", "缺少参数");

        private int code;
        private String description;
        private String tips;

        ErrorEnum(int i2, String str, String str2) {
            this.code = i2;
            this.description = str;
            this.tips = str2;
        }

        public int getCode() {
            return this.code;
        }

        public String getDescription() {
            return this.description;
        }

        public String getTips() {
            return this.tips;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "OAPS_Error//code=" + this.code + ", description='" + this.description;
        }
    }

    public HallRouterException(ErrorEnum errorEnum) {
        super(errorEnum.toString());
        this.errorEnum = errorEnum;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HallRouterException(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.oplus.quickgame.sdk.hall.exception.HallRouterException$ErrorEnum r1 = com.oplus.quickgame.sdk.hall.exception.HallRouterException.ErrorEnum.MISS_KEY_ERROR
            java.lang.String r2 = r1.toString()
            r0.append(r2)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            r3.errorEnum = r1
            com.oplus.quickgame.sdk.hall.exception.HallRouterException.ErrorEnum.access$002(r1, r4)
            com.oplus.quickgame.sdk.hall.exception.HallRouterException$ErrorEnum r0 = r3.errorEnum
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = com.oplus.quickgame.sdk.hall.exception.HallRouterException.ErrorEnum.access$100(r0)
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            com.oplus.quickgame.sdk.hall.exception.HallRouterException.ErrorEnum.access$102(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.quickgame.sdk.hall.exception.HallRouterException.<init>(java.lang.String):void");
    }

    public ErrorEnum getErrorEnum() {
        return this.errorEnum;
    }
}
