package com.martian.mibook.application;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: classes.dex */
public class s0 extends b.d.a.g {

    /* renamed from: b */
    private static boolean f11587b;

    /* loaded from: classes3.dex */
    static class a implements TTAdSdk.InitCallback {

        /* renamed from: a */
        final /* synthetic */ TTAdSdk.InitCallback f11588a;

        a(final TTAdSdk.InitCallback val$callback) {
            this.f11588a = val$callback;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i2, String s) {
            this.f11588a.fail(i2, s);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            boolean unused = s0.f11587b = true;
            this.f11588a.success();
        }
    }

    private static TTAdConfig c() {
        return new TTAdConfig.Builder().appId(k0.o).useTextureView(false).appName(k0.f11473a).titleBarTheme(0).allowShowNotify(true).directDownloadNetworkType(4).debug(com.martian.libmars.d.h.F().Q0()).supportMultiProcess(false).build();
    }

    public static void d(Context context, TTAdSdk.InitCallback callback) {
        if (!f11587b) {
            synchronized (b.d.a.g.class) {
                if (!f11587b) {
                    TTAdSdk.init(context, c(), new a(callback));
                }
            }
        }
        b.d.a.g.f4360a = TTAdSdk.getAdManager();
    }
}
