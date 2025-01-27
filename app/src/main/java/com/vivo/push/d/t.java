package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.d.r;
import java.util.HashMap;

/* loaded from: classes4.dex */
final class t implements r.a {

    /* renamed from: a */
    final /* synthetic */ s f30988a;

    t(s sVar) {
        this.f30988a = sVar;
    }

    @Override // com.vivo.push.d.r.a
    public final void a() {
        Context context;
        Context context2;
        long l = com.vivo.push.e.a().l();
        if (l < 1400 && l != 1340) {
            com.vivo.push.util.p.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(l)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", String.valueOf(this.f30988a.f30986b.f()));
        context = ((com.vivo.push.l) this.f30988a.f30987c).f31028a;
        context2 = ((com.vivo.push.l) this.f30988a.f30987c).f31028a;
        String b2 = com.vivo.push.util.z.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("app_id", b2);
        }
        hashMap.put("type", "1");
        hashMap.put("dtp", "1");
        com.vivo.push.util.e.a(6L, hashMap);
    }

    @Override // com.vivo.push.d.r.a
    public final void b() {
        Context context;
        Context context2;
        HashMap hashMap = new HashMap();
        hashMap.put(com.heytap.mcssdk.n.d.n, String.valueOf(this.f30988a.f30986b.f()));
        context = ((com.vivo.push.l) this.f30988a.f30987c).f31028a;
        context2 = ((com.vivo.push.l) this.f30988a.f30987c).f31028a;
        String b2 = com.vivo.push.util.z.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("remoteAppId", b2);
        }
        com.vivo.push.util.e.a(2122L, hashMap);
    }
}
