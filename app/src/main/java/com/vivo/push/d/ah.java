package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.cache.ClientConfigManagerImpl;

/* loaded from: classes4.dex */
final class ah extends com.vivo.push.l {
    public ah(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        Context context = this.f25064a;
        if (context == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; mContext is Null");
            return;
        }
        if (oVar == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask pushCommand is Null");
            return;
        }
        com.vivo.push.model.b a10 = com.vivo.push.util.t.a(context);
        int b10 = oVar.b();
        if (b10 == 2009) {
            com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f25064a).isDebug());
            if (com.vivo.push.util.p.a()) {
                com.vivo.push.e.a().i();
                com.vivo.push.util.b bVar = new com.vivo.push.util.b();
                bVar.a(this.f25064a, "com.vivo.push_preferences.hybridapptoken_v1");
                bVar.a();
                com.vivo.push.util.b bVar2 = new com.vivo.push.util.b();
                bVar2.a(this.f25064a, "com.vivo.push_preferences.appconfig_v1");
                bVar2.a();
                if (!com.vivo.push.e.a().e()) {
                    ClientConfigManagerImpl.getInstance(this.f25064a).clearPush();
                }
            }
        } else if (b10 != 2011) {
            switch (b10) {
                case 2002:
                case 2003:
                case 2004:
                case 2005:
                    if (a10 == null || a10.c()) {
                        com.vivo.push.e.a().a(((com.vivo.push.b.c) oVar).h(), 1005);
                        break;
                    } else {
                        com.vivo.push.b.c cVar = (com.vivo.push.b.c) oVar;
                        int a11 = com.vivo.push.util.s.a(cVar);
                        if (a11 != 0) {
                            com.vivo.push.e.a().a(cVar.h(), a11);
                            return;
                        }
                    }
                    break;
            }
        } else {
            com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f25064a).isDebug(((com.vivo.push.b.w) oVar).d()));
        }
        if (a10 == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; pushPkgInfo is Null");
            return;
        }
        String a12 = a10.a();
        if (a10.c()) {
            try {
                com.vivo.push.e.a().a(((com.vivo.push.b.c) oVar).h(), 1004);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            oVar = new com.vivo.push.b.e();
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; pkgName is InBlackList ");
        }
        com.vivo.push.a.a.a(this.f25064a, a12, oVar);
    }
}
