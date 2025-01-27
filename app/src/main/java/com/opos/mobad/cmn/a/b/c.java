package com.opos.mobad.cmn.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.instant.router.Instant;
import com.oplus.instant.router.callback.Callback;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: com.opos.mobad.cmn.a.b.c$1 */
    static final class AnonymousClass1 extends Callback {
        AnonymousClass1() {
        }

        @Override // com.oplus.instant.router.callback.Callback
        public void onResponse(Callback.Response response) {
            com.opos.cmn.an.f.a.b("InstantTool", "prepare code:" + response.getCode() + ", msg:" + response.getMsg());
        }
    }

    public static String a() {
        return Instant.getSDKVersion();
    }

    public static String a(Context context) {
        if (context != null) {
            try {
                return Instant.getVersion(com.opos.mobad.service.b.b(context));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static void a(Context context, String str, String str2, String str3, Callback callback, String str4, String str5) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.c.a.a(str2) || com.opos.cmn.an.c.a.a(str3)) {
                    return;
                }
                Instant.Builder createBuilder = Instant.createBuilder(str, str2);
                createBuilder.setRequestUrl(str3);
                if (callback != null) {
                    createBuilder.setCallback(callback);
                }
                String build = Instant.createFromBuilder().setScene(str4).setTraceId(str5).build();
                if (!com.opos.cmn.an.c.a.a(build)) {
                    createBuilder.setFrom(build);
                }
                createBuilder.build().request(com.opos.mobad.service.b.b(context));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str5)) {
            return;
        }
        try {
            Instant.Builder callback = Instant.createBuilder(str, str2).setRequestUrl(str3).setCallback(new Callback() { // from class: com.opos.mobad.cmn.a.b.c.1
                AnonymousClass1() {
                }

                @Override // com.oplus.instant.router.callback.Callback
                public void onResponse(Callback.Response response) {
                    com.opos.cmn.an.f.a.b("InstantTool", "prepare code:" + response.getCode() + ", msg:" + response.getMsg());
                }
            });
            String build = Instant.createFromBuilder().setScene(str4).setTraceId(str5).build();
            if (!TextUtils.isEmpty(build)) {
                callback.setFrom(build);
            }
            callback.build().preload(com.opos.mobad.service.b.b(context));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("InstantTool", "prepare fail", e2);
        }
    }

    public static boolean b(Context context) {
        if (context != null) {
            try {
                return Instant.isInstantPlatformInstalled(com.opos.mobad.service.b.b(context));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
