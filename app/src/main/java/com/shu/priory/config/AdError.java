package com.shu.priory.config;

/* loaded from: classes3.dex */
public class AdError extends Exception {
    private static final int TIP_ACTIVITY_FINISH = 12;
    private static final int TIP_INVALID_AD_UNIT_ID = 5;
    private static final int TIP_INVALID_REQUEST = 3;
    private static final int TIP_NETWORK_ERROR = 1;
    private static final int TIP_NO_FILL = 4;
    private static final int TIP_OVER_REQUEST_NUM = 8;
    private static final int TIP_PAGE_LOAD_ERROR = 10;
    private static final int TIP_PAGE_LOAD_TIMEOUT = 9;
    private static final int TIP_PARAM = 13;
    private static final int TIP_PERMISSION_ERROR = 6;
    private static final int TIP_SERVER_ERROR = 2;
    private static final int TIP_SUCCESS = 0;
    private static final int TIP_UNKNOWN_ERROR = 7;
    private static final int TIP_VIDEO_CACHE = 11;
    private String mDescription;
    private int mErrorCode;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AdError(int r2) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = ""
            r1.mDescription = r0
            r1.mErrorCode = r2
            switch(r2) {
                case 70200: goto L2f;
                case 70204: goto L2d;
                case 70400: goto L2b;
                case 70403: goto L28;
                case 70500: goto L26;
                default: goto Lc;
            }
        Lc:
            switch(r2) {
                case 71002: goto L24;
                case 71003: goto L22;
                case 71004: goto L20;
                case 71005: goto L2b;
                case 71006: goto L1d;
                case 71007: goto L1a;
                case 71008: goto L17;
                case 71009: goto L14;
                case 71010: goto L11;
                default: goto Lf;
            }
        Lf:
            r2 = 7
            goto L30
        L11:
            r2 = 13
            goto L30
        L14:
            r2 = 12
            goto L30
        L17:
            r2 = 11
            goto L30
        L1a:
            r2 = 10
            goto L30
        L1d:
            r2 = 9
            goto L30
        L20:
            r2 = 6
            goto L30
        L22:
            r2 = 1
            goto L30
        L24:
            r2 = 3
            goto L30
        L26:
            r2 = 2
            goto L30
        L28:
            r2 = 8
            goto L30
        L2b:
            r2 = 5
            goto L30
        L2d:
            r2 = 4
            goto L30
        L2f:
            r2 = 0
        L30:
            java.lang.String r2 = com.shu.priory.h.a.a(r2)
            r1.mDescription = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.config.AdError.<init>(int):void");
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorDescription() {
        return this.mDescription;
    }

    public AdError(int i10, String str) {
        this.mErrorCode = i10;
        this.mDescription = str;
    }
}
