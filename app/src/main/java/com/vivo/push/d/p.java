package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.HashMap;

/* loaded from: classes4.dex */
final class p extends z {
    p(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.o oVar2 = (com.vivo.push.b.o) oVar;
        com.vivo.push.e.a().a(new com.vivo.push.b.h(String.valueOf(oVar2.f())));
        if (!ClientConfigManagerImpl.getInstance(this.f31028a).isEnablePush()) {
            com.vivo.push.util.p.d("OnMessageTask", "command  " + oVar + " is ignore by disable push ");
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1020L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(com.heytap.mcssdk.n.d.n, String.valueOf(oVar2.f()));
            Context context = this.f31028a;
            String b2 = com.vivo.push.util.z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            xVar.a(hashMap);
            com.vivo.push.e.a().a(xVar);
            return;
        }
        if (com.vivo.push.e.a().g() && !a(com.vivo.push.util.z.c(this.f31028a), oVar2.d(), oVar2.i())) {
            com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1021L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put(com.heytap.mcssdk.n.d.n, String.valueOf(oVar2.f()));
            Context context2 = this.f31028a;
            String b3 = com.vivo.push.util.z.b(context2, context2.getPackageName());
            if (!TextUtils.isEmpty(b3)) {
                hashMap2.put("remoteAppId", b3);
            }
            xVar2.a(hashMap2);
            com.vivo.push.e.a().a(xVar2);
            return;
        }
        UnvarnishedMessage e2 = oVar2.e();
        if (e2 == null) {
            com.vivo.push.util.p.a("OnMessageTask", " message is null");
            return;
        }
        com.vivo.push.util.p.d("OnMessageTask", "tragetType is " + e2.getTargetType() + " ; target is " + e2.getTragetContent());
        com.vivo.push.m.b(new q(this, e2));
    }
}
