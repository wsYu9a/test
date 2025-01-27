package com.vivo.push.d;

import android.content.Context;
import com.kwai.sodler.lib.ext.PluginError;
import com.vivo.push.cache.ClientConfigManagerImpl;

/* loaded from: classes4.dex */
final class ah extends com.vivo.push.l {
    ah(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        Context context = this.f31028a;
        if (context == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; mContext is Null");
            return;
        }
        if (oVar == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask pushCommand is Null");
            return;
        }
        com.vivo.push.model.b a2 = com.vivo.push.util.t.a(context);
        int b2 = oVar.b();
        if (b2 == 2009) {
            com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f31028a).isDebug());
            if (com.vivo.push.util.p.a()) {
                com.vivo.push.e.a().i();
                com.vivo.push.util.b bVar = new com.vivo.push.util.b();
                bVar.a(this.f31028a, "com.vivo.push_preferences.hybridapptoken_v1");
                bVar.a();
                com.vivo.push.util.b bVar2 = new com.vivo.push.util.b();
                bVar2.a(this.f31028a, "com.vivo.push_preferences.appconfig_v1");
                bVar2.a();
                if (!com.vivo.push.e.a().e()) {
                    ClientConfigManagerImpl.getInstance(this.f31028a).clearPush();
                }
            }
        } else if (b2 != 2011) {
            switch (b2) {
                case 2002:
                case 2003:
                case PluginError.ERROR_UPD_EXTRACT /* 2004 */:
                case PluginError.ERROR_UPD_CAPACITY /* 2005 */:
                    if (a2 == null || a2.c()) {
                        com.vivo.push.e.a().a(((com.vivo.push.b.c) oVar).h(), 1005);
                        break;
                    } else {
                        com.vivo.push.b.c cVar = (com.vivo.push.b.c) oVar;
                        int a3 = com.vivo.push.util.s.a(cVar);
                        if (a3 != 0) {
                            com.vivo.push.e.a().a(cVar.h(), a3);
                            return;
                        }
                    }
                    break;
            }
        } else {
            com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f31028a).isDebug(((com.vivo.push.b.w) oVar).d()));
        }
        if (a2 == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; pushPkgInfo is Null");
            return;
        }
        String a4 = a2.a();
        if (a2.c()) {
            try {
                com.vivo.push.e.a().a(((com.vivo.push.b.c) oVar).h(), 1004);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            oVar = new com.vivo.push.b.e();
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; pkgName is InBlackList ");
        }
        com.vivo.push.a.a.a(this.f31028a, a4, oVar);
    }
}
