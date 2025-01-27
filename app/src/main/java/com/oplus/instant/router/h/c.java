package com.oplus.instant.router.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.oplus.instant.router.callback.Callback;

/* loaded from: classes4.dex */
public class c {

    static final class a extends Callback {
        a() {
        }

        @Override // com.oplus.instant.router.callback.Callback
        public void onResponse(Callback.Response response) {
            d.b("GameUtil", "wrapCallback onResponse=" + response);
        }
    }

    private static class b extends Callback {

        /* renamed from: a */
        private Callback f16081a;

        /* renamed from: b */
        private Context f16082b;

        /* renamed from: c */
        private String f16083c;

        public b(Context context, String str, Callback callback) {
            this.f16081a = callback;
            this.f16082b = context;
            this.f16083c = str;
        }

        @Override // com.oplus.instant.router.callback.Callback
        public void onResponse(Callback.Response response) {
            if (response != null && response.getCode() == 1) {
                try {
                    d.f("GameUtil", "wrapper onResponse " + response);
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(h.j(this.f16082b), com.oplus.instant.router.h.a.a("Y29tLm5lYXJtZS5pbnN0YW50LnF1aWNrZ2FtZS5hY3Rpdml0eS5HYW1lVHJhbnNmZXJBY3Rpdml0eQ==")));
                    intent.putExtra("req_uri", this.f16083c);
                    this.f16082b.startActivity(intent);
                } catch (Exception e2) {
                    d.f("GameUtil", "wrapper onResponse ex:" + e2.getMessage());
                    response = new Callback.Response();
                    response.setCode(-4);
                    response.setMsg("start transform page failed");
                }
            }
            Callback callback = this.f16081a;
            if (callback != null) {
                callback.onResponse(response);
            }
        }
    }

    public static Callback a(Context context, String str, Callback callback) {
        if (callback == null) {
            callback = new a();
        }
        return new b(context, str, callback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
    
        if ("1".equals(android.net.Uri.parse(r6).getQueryParameter("in_one_task")) != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            java.lang.String r0 = "in_one_task"
            java.lang.String r1 = "1"
            r2 = 0
            r3 = 1
            if (r6 == 0) goto L3c
            java.lang.String r4 = "hap://game"
            boolean r4 = r6.startsWith(r4)
            if (r4 != 0) goto L11
            goto L3c
        L11:
            int r5 = com.oplus.instant.router.h.h.h(r5)
            r4 = 3100(0xc1c, float:4.344E-42)
            if (r5 < r4) goto L3c
            android.net.Uri r5 = android.net.Uri.parse(r6)     // Catch: java.lang.Exception -> L29
            java.lang.String r5 = r5.getQueryParameter(r0)     // Catch: java.lang.Exception -> L29
            boolean r5 = r1.equals(r5)     // Catch: java.lang.Exception -> L29
            if (r5 == 0) goto L2f
        L27:
            r2 = 1
            goto L3c
        L29:
            r5 = move-exception
            java.lang.String r6 = "GameUtil"
            com.oplus.instant.router.h.d.d(r6, r5)
        L2f:
            if (r7 == 0) goto L3c
            java.lang.Object r5 = r7.get(r0)
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L3c
            goto L27
        L3c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.instant.router.h.c.b(android.content.Context, java.lang.String, java.util.Map):boolean");
    }
}
