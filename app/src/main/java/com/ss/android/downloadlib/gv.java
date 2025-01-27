package com.ss.android.downloadlib;

/* loaded from: classes4.dex */
public class gv {

    /* renamed from: j */
    private static volatile gv f24255j;
    private com.ss.android.download.api.config.gv zx = null;

    private gv() {
    }

    public static gv j() {
        if (f24255j == null) {
            synchronized (gv.class) {
                if (f24255j == null) {
                    f24255j = new gv();
                }
            }
        }
        return f24255j;
    }

    public com.ss.android.download.api.config.gv zx() {
        return this.zx;
    }
}
