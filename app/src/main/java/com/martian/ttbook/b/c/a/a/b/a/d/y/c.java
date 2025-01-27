package com.martian.ttbook.b.c.a.a.b.a.d.y;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.martian.ttbook.b.c.a.a.d.b.g;
import com.martian.ttbook.b.c.a.a.d.b.j;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static volatile boolean f15486a;

    static class a implements TTAdSdk.InitCallback {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i2, String str) {
            boolean unused = c.f15486a = false;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
        }
    }

    private static TTAdConfig a(Context context, String str, String str2) {
        return new TTAdConfig.Builder().appId(str).useTextureView(g.b().h()).appName(str2).titleBarTheme(1).allowShowNotify(true).allowShowPageWhenScreenLock(true).debug(j.r.booleanValue()).supportMultiProcess(false).build();
    }

    public static TTAdManager b() {
        if (f15486a) {
            return TTAdSdk.getAdManager();
        }
        throw new RuntimeException("TTAdSdk is not init, please check.");
    }

    private static void d(Context context, String str, String str2) {
        if (f15486a) {
            return;
        }
        TTAdSdk.init(context, a(context, str, str2), new a());
        f15486a = true;
    }

    public static void e(Context context, String str, String str2) {
        d(context, str, str2);
    }
}
