package x6;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public class c {
    public static void a(Context context, b7.b bVar, a7.c cVar) {
        if (context == null) {
            c7.e.d("context is null , please check param of parseCommandMessage()");
        }
        if (bVar == null) {
            c7.e.d("message is null , please check param of parseCommandMessage()");
            return;
        }
        if (cVar == null) {
            c7.e.d("callback is null , please check param of parseCommandMessage()");
            return;
        }
        switch (bVar.j()) {
            case b7.b.f1308e0 /* 12289 */:
                if (bVar.n() == 0) {
                    b.c0().M(bVar.k());
                }
                cVar.n(bVar.n(), bVar.k());
                break;
            case b7.b.f1309f0 /* 12290 */:
                cVar.b(bVar.n());
                break;
            case b7.b.f1311h0 /* 12292 */:
                cVar.a(bVar.n(), b7.b.r(bVar.k(), b7.b.U, "aliasId", "aliasName"));
                break;
            case b7.b.f1312i0 /* 12293 */:
                cVar.j(bVar.n(), b7.b.r(bVar.k(), b7.b.U, "aliasId", "aliasName"));
                break;
            case b7.b.f1313j0 /* 12294 */:
                cVar.k(bVar.n(), b7.b.r(bVar.k(), b7.b.U, "aliasId", "aliasName"));
                break;
            case b7.b.f1314k0 /* 12295 */:
                cVar.f(bVar.n(), b7.b.r(bVar.k(), "tags", "tagId", "tagName"));
                break;
            case b7.b.f1315l0 /* 12296 */:
                cVar.m(bVar.n(), b7.b.r(bVar.k(), "tags", "tagId", "tagName"));
                break;
            case b7.b.f1316m0 /* 12297 */:
                cVar.g(bVar.n(), b7.b.r(bVar.k(), "tags", "tagId", "tagName"));
                break;
            case b7.b.f1317n0 /* 12298 */:
                cVar.l(bVar.n(), bVar.k());
                break;
            case b7.b.f1320q0 /* 12301 */:
                cVar.i(bVar.n(), b7.b.r(bVar.k(), "tags", "accountId", "accountName"));
                break;
            case b7.b.f1321r0 /* 12302 */:
                cVar.e(bVar.n(), b7.b.r(bVar.k(), "tags", "accountId", "accountName"));
                break;
            case b7.b.f1322s0 /* 12303 */:
                cVar.h(bVar.n(), b7.b.r(bVar.k(), "tags", "accountId", "accountName"));
                break;
            case b7.b.f1325v0 /* 12306 */:
                cVar.d(bVar.n(), c7.i.k(bVar.k()));
                break;
            case b7.b.f1328y0 /* 12309 */:
                cVar.c(bVar.n(), c7.i.k(bVar.k()));
                break;
        }
    }

    public static void b(Context context, b7.b bVar, b bVar2) {
        if (context == null) {
            c7.e.d("context is null , please check param of parseCommandMessage(2)");
        }
        if (bVar == null) {
            c7.e.d("message is null , please check param of parseCommandMessage(2)");
            return;
        }
        if (bVar2 == null) {
            c7.e.d("pushManager is null , please check param of parseCommandMessage(2)");
            return;
        }
        if (bVar2.i0() == null) {
            c7.e.d("pushManager.getPushCallback() is null , please check param of parseCommandMessage(2)");
            return;
        }
        switch (bVar.j()) {
            case b7.b.f1308e0 /* 12289 */:
                if (bVar.n() == 0) {
                    bVar2.M(bVar.k());
                }
                bVar2.i0().n(bVar.n(), bVar.k());
                break;
            case b7.b.f1309f0 /* 12290 */:
                bVar2.i0().b(bVar.n());
                break;
            case b7.b.f1311h0 /* 12292 */:
                bVar2.i0().a(bVar.n(), b7.b.r(bVar.k(), b7.b.U, "aliasId", "aliasName"));
                break;
            case b7.b.f1312i0 /* 12293 */:
                bVar2.i0().j(bVar.n(), b7.b.r(bVar.k(), b7.b.U, "aliasId", "aliasName"));
                break;
            case b7.b.f1313j0 /* 12294 */:
                bVar2.i0().k(bVar.n(), b7.b.r(bVar.k(), b7.b.U, "aliasId", "aliasName"));
                break;
            case b7.b.f1314k0 /* 12295 */:
                bVar2.i0().f(bVar.n(), b7.b.r(bVar.k(), "tags", "tagId", "tagName"));
                break;
            case b7.b.f1315l0 /* 12296 */:
                bVar2.i0().m(bVar.n(), b7.b.r(bVar.k(), "tags", "tagId", "tagName"));
                break;
            case b7.b.f1316m0 /* 12297 */:
                bVar2.i0().g(bVar.n(), b7.b.r(bVar.k(), "tags", "tagId", "tagName"));
                break;
            case b7.b.f1317n0 /* 12298 */:
                bVar2.i0().l(bVar.n(), bVar.k());
                break;
            case b7.b.f1320q0 /* 12301 */:
                bVar2.i0().i(bVar.n(), b7.b.r(bVar.k(), "tags", "accountId", "accountName"));
                break;
            case b7.b.f1321r0 /* 12302 */:
                bVar2.i0().e(bVar.n(), b7.b.r(bVar.k(), "tags", "accountId", "accountName"));
                break;
            case b7.b.f1322s0 /* 12303 */:
                bVar2.i0().h(bVar.n(), b7.b.r(bVar.k(), "tags", "accountId", "accountName"));
                break;
            case b7.b.f1325v0 /* 12306 */:
                bVar2.i0().d(bVar.n(), c7.i.k(bVar.k()));
                break;
            case b7.b.f1328y0 /* 12309 */:
                bVar2.i0().c(bVar.n(), c7.i.k(bVar.k()));
                break;
        }
    }

    public static void c(Context context, Intent intent, a7.a aVar) {
        String str;
        if (context == null) {
            str = "context is null , please check param of parseIntent()";
        } else if (intent == null) {
            str = "intent is null , please check param of parseIntent()";
        } else {
            if (aVar != null) {
                for (b7.d dVar : y6.c.c(context, intent)) {
                    if (dVar != null) {
                        for (z6.c cVar : b.c0().h0()) {
                            if (cVar != null) {
                                cVar.a(context, dVar, aVar);
                            }
                        }
                    }
                }
                return;
            }
            str = "callback is null , please check param of parseIntent()";
        }
        c7.e.d(str);
    }
}
