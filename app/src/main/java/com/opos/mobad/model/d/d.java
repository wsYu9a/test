package com.opos.mobad.model.d;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.b.a.b;
import com.opos.mobad.b.a.x;
import com.opos.mobad.b.a.y;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.data.PendantData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static final int f21567a = y.e.APP_INSTALLED.a();

    /* renamed from: b */
    private static final int f21568b = y.e.APP_UNINSTALLED.a();

    private static com.opos.mobad.model.b.e a(Context context, x xVar) {
        if (com.opos.cmn.d.b.a(com.opos.cmn.d.c.a(context, xVar.f19904d), xVar.f19905e)) {
            return null;
        }
        com.opos.mobad.model.b.e eVar = new com.opos.mobad.model.b.e();
        eVar.a(xVar.f19904d);
        eVar.b(xVar.f19905e);
        eVar.c(com.opos.cmn.d.c.a(context, xVar.f19904d));
        return eVar;
    }

    static MaterialFileData a(Context context, com.opos.mobad.b.a.b bVar, Set<com.opos.mobad.model.b.e> set, boolean z, q qVar) {
        x xVar = bVar.D;
        if (z) {
            set = null;
        }
        return a(context, xVar, true, set, qVar);
    }

    private static MaterialFileData a(Context context, x xVar, boolean z) {
        if (xVar == null) {
            return null;
        }
        MaterialFileData materialFileData = new MaterialFileData();
        materialFileData.a(z ? xVar.f19904d : com.opos.cmn.d.c.a(context, xVar.f19904d));
        materialFileData.b(xVar.f19905e);
        return materialFileData;
    }

    private static MaterialFileData a(Context context, x xVar, boolean z, Set<com.opos.mobad.model.b.e> set, q qVar) {
        if (xVar == null || com.opos.cmn.an.c.a.a(xVar.f19904d)) {
            return null;
        }
        if (set == null) {
            return a(context, xVar, true);
        }
        com.opos.mobad.model.b.e a2 = a(context, xVar);
        if (a2 != null) {
            set.add(a2);
            if (!z) {
                com.opos.mobad.service.j.n.a().a(false);
            }
        } else {
            if (!z) {
                com.opos.mobad.service.j.n.a().a(true);
            }
            if (qVar != null) {
                qVar.a(xVar.f19904d, 2);
            }
            com.opos.cmn.an.f.a.b("AdLoader", "material File " + xVar.toString() + " exists,don't need download again!!!");
        }
        return a(context, xVar, false);
    }

    static List<MaterialData> a(Context context, y yVar, Set<com.opos.mobad.model.b.e> set, Set<com.opos.mobad.model.b.e> set2, boolean z, q qVar) {
        List<MaterialFileData> a2;
        List<MaterialFileData> a3;
        List<MaterialFileData> a4;
        List<x> list = yVar.V;
        if (z) {
            a2 = a(context, list, null, qVar);
            a3 = a(context, yVar.ba, null, qVar);
            a4 = yVar.Q == y.b.RAW_VIDEO ? a(context, yVar.S, set2, qVar) : a(context, yVar.S, null, qVar);
        } else {
            a2 = a(context, list, set, qVar);
            a3 = a(context, yVar.ba, set2, qVar);
            a4 = a(context, yVar.S, set, qVar);
        }
        List<MaterialFileData> a5 = a(context, yVar.aq, null, qVar);
        com.opos.mobad.b.a.r rVar = yVar.aH;
        MaterialData materialData = new MaterialData(yVar, a4, a2, a5, a3, rVar != null ? new FloatLayerData(yVar.aH, a(context, rVar.f19857d, false, set, qVar), a(context, yVar.aH.f19860g, set2, qVar), a(context, yVar.aH.f19861h, set2, qVar)) : null, yVar.aY != null ? new PendantData(a(context, yVar.aY.f19980g, false, set2, qVar), yVar.aY) : null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(materialData);
        return arrayList;
    }

    private static List<MaterialFileData> a(Context context, List<x> list, Set<com.opos.mobad.model.b.e> set, q qVar) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator<x> it = list.iterator();
            while (it.hasNext()) {
                MaterialFileData a2 = a(context, it.next(), false, set, qVar);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    static boolean a(Context context, com.opos.mobad.b.a.b bVar, List<x> list) {
        if (bVar.M == b.c.PLAY_CACHE) {
            x xVar = list.get(0);
            if (TextUtils.isEmpty(com.opos.cmn.d.d.a(context, xVar.f19904d, xVar.f19905e))) {
                com.opos.mobad.service.j.n.a().b(false);
                com.opos.cmn.an.f.a.b("AdLoader", "isVideoEnableMaterial but not cache video");
                return false;
            }
            com.opos.mobad.service.j.n.a().b(true);
        }
        com.opos.cmn.an.f.a.b("AdLoader", "isVideoEnableMaterial");
        return true;
    }

    static boolean a(Context context, y yVar, q qVar) {
        boolean z = yVar == null || !b(context, yVar, qVar);
        com.opos.cmn.an.f.a.b("AdLoader", "isValidMaterialEntity materialEntity=", yVar, "result=", Boolean.valueOf(z));
        return z;
    }

    static boolean a(y yVar) {
        y.b bVar = yVar.Q;
        return bVar == y.b.VIDEO || bVar == y.b.FULL_VIDEO || bVar == y.b.POP_WINDOW_VIDEO || bVar == y.b.RAW_VIDEO || bVar == y.b.VIDEO_HTML || bVar == y.b.VIDEO_TIP_BAR;
    }

    static boolean b(Context context, y yVar, q qVar) {
        Integer num = yVar.aL;
        if (num != null) {
            int intValue = num.intValue();
            int i2 = f21567a;
            if (i2 == (i2 & intValue) && !TextUtils.isEmpty(yVar.X) && com.opos.cmn.an.h.d.a.d(context, yVar.X)) {
                com.opos.cmn.an.f.a.b("AdLoader", "filter install");
                if (qVar == null) {
                    return true;
                }
                qVar.a(yVar);
                return true;
            }
            int i3 = f21568b;
            if (i3 == (intValue & i3) && !TextUtils.isEmpty(yVar.X) && !com.opos.cmn.an.h.d.a.d(context, yVar.X)) {
                com.opos.cmn.an.f.a.b("AdLoader", "filter uninstall");
                if (qVar == null) {
                    return true;
                }
                qVar.g(yVar);
                return true;
            }
        }
        return false;
    }

    public static boolean b(y yVar) {
        if (yVar != null) {
            y.h hVar = yVar.R;
            y.h hVar2 = y.h.OPEN_MINI_PROGRAM;
            if (hVar == hVar2 || yVar.aI == hVar2 || yVar.aJ == hVar2 || yVar.au == hVar2 || yVar.av == hVar2) {
                return true;
            }
        }
        return false;
    }
}
