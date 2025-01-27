package com.tencent.open.b;

/* loaded from: classes4.dex */
public class e {
    public static int a(String str) {
        int a2 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), str).a("Common_BusinessReportFrequency");
        if (a2 == 0) {
            return 100;
        }
        return a2;
    }

    public static int a() {
        int a2 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Common_HttpRetryCount");
        if (a2 == 0) {
            return 2;
        }
        return a2;
    }
}
