package com.vivo.mobilead.unified.nativead;

import android.content.Context;
import android.view.View;
import com.vivo.ad.view.l;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.view.s.a;
import com.vivo.mobilead.unified.base.view.s.g;
import com.vivo.mobilead.unified.base.view.s.h;
import com.vivo.mobilead.unified.base.view.s.i;
import com.vivo.mobilead.unified.base.view.s.j;
import com.vivo.mobilead.unified.base.view.s.k;
import com.vivo.mobilead.unified.base.view.s.m;

/* loaded from: classes4.dex */
public class b {
    public static void a(Context context, com.vivo.ad.model.b bVar, AdParams adParams, View.OnClickListener onClickListener, l lVar, com.vivo.mobilead.unified.base.callback.d dVar, a.f fVar, com.vivo.mobilead.unified.base.view.u.b bVar2, com.vivo.mobilead.model.b bVar3) {
        com.vivo.mobilead.unified.base.view.s.a hVar;
        if (bVar == null) {
            if (fVar != null) {
                fVar.a(null);
                return;
            }
            return;
        }
        if (bVar3 == null) {
            switch (bVar.F()) {
                case 1:
                    hVar = new h(context);
                    break;
                case 2:
                    hVar = new k(context);
                    break;
                case 3:
                    hVar = new i(context);
                    break;
                case 4:
                    hVar = new j(context);
                    break;
                case 5:
                    hVar = new com.vivo.mobilead.unified.base.view.s.l(context);
                    break;
                case 6:
                    hVar = new g(context);
                    break;
                case 7:
                    hVar = new m(context);
                    break;
                default:
                    hVar = new com.vivo.mobilead.unified.base.view.s.l(context);
                    break;
            }
        } else {
            hVar = new com.vivo.mobilead.unified.base.view.s.b(bVar3, context, bVar, adParams);
        }
        com.vivo.mobilead.unified.base.view.s.a aVar = hVar;
        aVar.a(onClickListener, lVar, dVar, bVar2, fVar);
        try {
            aVar.b(bVar, adParams);
        } catch (Exception unused) {
            if (fVar != null) {
                fVar.a(null);
            }
        }
    }
}
