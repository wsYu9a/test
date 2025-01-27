package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.n.a;
import com.vivo.ic.BuildConfig;

/* loaded from: classes4.dex */
public class n {
    private static final com.opos.mobad.n.a a(Activity activity, AdItemData adItemData, MaterialData materialData, a.InterfaceC0458a interfaceC0458a) {
        com.opos.mobad.n.a iVar;
        int P = adItemData.P();
        Context applicationContext = activity.getApplicationContext();
        int b2 = materialData.b();
        if (b2 != 6) {
            switch (b2) {
                case 214:
                    iVar = new h(activity, 214, interfaceC0458a);
                    break;
                case 215:
                    iVar = new g(activity, 215, interfaceC0458a);
                    break;
                case 216:
                    iVar = new f(activity, 216, interfaceC0458a);
                    break;
                case 217:
                    iVar = new e(activity, 217, interfaceC0458a);
                    break;
                case 218:
                    iVar = com.opos.mobad.n.f.j.a(applicationContext, 218, com.opos.mobad.r.a.d.a(P).a(applicationContext));
                    iVar.a(interfaceC0458a);
                    break;
                case BuildConfig.VERSION_CODE /* 219 */:
                    iVar = com.opos.mobad.n.f.j.b(applicationContext, BuildConfig.VERSION_CODE, com.opos.mobad.r.a.d.a(P).a(applicationContext));
                    iVar.a(interfaceC0458a);
                    break;
                default:
                    iVar = null;
                    break;
            }
        } else {
            iVar = new i(activity, 6, interfaceC0458a);
        }
        if (iVar == null) {
            iVar = a(activity, materialData, interfaceC0458a, P);
        }
        return new m(activity, adItemData, iVar);
    }

    public static final com.opos.mobad.n.a a(Activity activity, AdItemData adItemData, MaterialData materialData, a.InterfaceC0458a interfaceC0458a, com.opos.mobad.activity.webview.b bVar) {
        com.opos.mobad.n.a b2 = b(activity, adItemData, materialData, interfaceC0458a, bVar);
        return b2 == null ? a(activity, adItemData, materialData, interfaceC0458a) : b2;
    }

    private static final com.opos.mobad.n.a a(Activity activity, MaterialData materialData, a.InterfaceC0458a interfaceC0458a, int i2) {
        int d2 = materialData.d();
        com.opos.mobad.n.a eVar = d2 != 2 ? d2 != 3 ? d2 != 6 ? d2 != 7 ? d2 != 8 ? null : new e(activity, 217, interfaceC0458a) : new f(activity, 216, interfaceC0458a) : new g(activity, 215, interfaceC0458a) : new h(activity, 214, interfaceC0458a) : new i(activity, 6, interfaceC0458a);
        if (eVar == null) {
            Context applicationContext = activity.getApplicationContext();
            int ae = materialData.ae();
            if (ae == 60) {
                eVar = com.opos.mobad.n.f.j.a(applicationContext, 218, com.opos.mobad.r.a.d.a(i2).a(applicationContext));
            } else if (ae == 63) {
                eVar = com.opos.mobad.n.f.j.b(applicationContext, BuildConfig.VERSION_CODE, com.opos.mobad.r.a.d.a(i2).a(applicationContext));
            }
            eVar.a(interfaceC0458a);
        }
        return eVar;
    }

    private static final com.opos.mobad.n.a b(Activity activity, AdItemData adItemData, MaterialData materialData, a.InterfaceC0458a interfaceC0458a, com.opos.mobad.activity.webview.b bVar) {
        com.opos.mobad.n.a a2 = com.opos.mobad.o.e.b.a().a(activity.getApplicationContext(), materialData.b(), adItemData.P(), interfaceC0458a);
        if (a2 == null) {
            return null;
        }
        return com.opos.mobad.service.c.b.a().c(adItemData.i().get(0).b()) == 0 ? a2 : new k(activity, adItemData, bVar, a2);
    }
}
