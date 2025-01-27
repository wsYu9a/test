package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.d.r;
import java.util.HashMap;

/* loaded from: classes4.dex */
final class t implements r.a {

    /* renamed from: a */
    final /* synthetic */ s f25015a;

    public t(s sVar) {
        this.f25015a = sVar;
    }

    @Override // com.vivo.push.d.r.a
    public final void a() {
        Context context;
        Context context2;
        long l10 = com.vivo.push.e.a().l();
        if (l10 < 1400 && l10 != 1340) {
            com.vivo.push.util.p.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(l10)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", String.valueOf(this.f25015a.f25013b.f()));
        context = ((com.vivo.push.l) this.f25015a.f25014c).f25064a;
        context2 = ((com.vivo.push.l) this.f25015a.f25014c).f25064a;
        String b10 = com.vivo.push.util.z.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b10)) {
            hashMap.put("app_id", b10);
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
        hashMap.put("messageID", String.valueOf(this.f25015a.f25013b.f()));
        context = ((com.vivo.push.l) this.f25015a.f25014c).f25064a;
        context2 = ((com.vivo.push.l) this.f25015a.f25014c).f25064a;
        String b10 = com.vivo.push.util.z.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b10)) {
            hashMap.put("remoteAppId", b10);
        }
        com.vivo.push.util.e.a(2122L, hashMap);
    }
}
