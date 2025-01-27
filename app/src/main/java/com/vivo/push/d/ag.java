package com.vivo.push.d;

import com.kwai.sodler.lib.ext.PluginError;

/* loaded from: classes4.dex */
public final class ag {
    public static com.vivo.push.l a(com.vivo.push.o oVar) {
        com.vivo.push.l afVar;
        int b2 = oVar.b();
        if (b2 == 20) {
            afVar = new af(oVar);
        } else if (b2 == 100) {
            afVar = new b(oVar);
        } else if (b2 != 101) {
            switch (b2) {
                case 0:
                    break;
                case 1:
                    afVar = new aa(oVar);
                    break;
                case 2:
                    afVar = new h(oVar);
                    break;
                case 3:
                    afVar = new p(oVar);
                    break;
                case 4:
                    afVar = new r(oVar);
                    break;
                case 5:
                    afVar = new u(oVar);
                    break;
                case 6:
                    afVar = new x(oVar);
                    break;
                case 7:
                    afVar = new n(oVar);
                    break;
                case 8:
                    afVar = new l(oVar);
                    break;
                case 9:
                    afVar = new g(oVar);
                    break;
                case 10:
                    afVar = new d(oVar);
                    break;
                case 11:
                    afVar = new ad(oVar);
                    break;
                case 12:
                    afVar = new f(oVar);
                    break;
                default:
                    switch (b2) {
                        case 2000:
                        case 2001:
                        case 2002:
                        case 2003:
                        case PluginError.ERROR_UPD_EXTRACT /* 2004 */:
                        case PluginError.ERROR_UPD_CAPACITY /* 2005 */:
                        case 2008:
                        case 2009:
                        case 2010:
                        case 2011:
                        case 2012:
                        case 2013:
                        case 2014:
                        case 2015:
                            break;
                        case PluginError.ERROR_UPD_REQUEST /* 2006 */:
                            afVar = new a(oVar);
                            break;
                        case PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD /* 2007 */:
                            afVar = new ai(oVar);
                            break;
                        default:
                            return null;
                    }
            }
            afVar = new ah(oVar);
        } else {
            afVar = new c(oVar);
        }
        return afVar;
    }

    public static z b(com.vivo.push.o oVar) {
        z afVar;
        int b2 = oVar.b();
        if (b2 == 20) {
            afVar = new af(oVar);
        } else if (b2 != 2016) {
            switch (b2) {
                case 1:
                    afVar = new aa(oVar);
                    break;
                case 2:
                    afVar = new h(oVar);
                    break;
                case 3:
                    afVar = new p(oVar);
                    break;
                case 4:
                    afVar = new r(oVar);
                    break;
                case 5:
                    afVar = new u(oVar);
                    break;
                case 6:
                    afVar = new x(oVar);
                    break;
                case 7:
                    afVar = new n(oVar);
                    break;
                case 8:
                    afVar = new l(oVar);
                    break;
                case 9:
                    afVar = new g(oVar);
                    break;
                case 10:
                    afVar = new d(oVar);
                    break;
                case 11:
                    afVar = new ad(oVar);
                    break;
                default:
                    return null;
            }
        } else {
            afVar = new k(oVar);
        }
        return afVar;
    }
}
