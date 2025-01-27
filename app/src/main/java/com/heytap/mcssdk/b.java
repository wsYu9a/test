package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.h.c;
import com.heytap.mcssdk.o.e;

/* loaded from: classes.dex */
public class b {
    public static void a(Context context, com.heytap.mcssdk.n.b bVar, a aVar) {
        if (context == null) {
            e.d("context is null , please check param of parseCommandMessage(2)");
        }
        if (bVar == null) {
            e.d("message is null , please check param of parseCommandMessage(2)");
            return;
        }
        if (aVar == null) {
            e.d("pushManager is null , please check param of parseCommandMessage(2)");
            return;
        }
        if (aVar.i0() == null) {
            e.d("pushManager.getPushCallback() is null , please check param of parseCommandMessage(2)");
            return;
        }
        switch (bVar.j()) {
            case com.heytap.mcssdk.n.b.W /* 12289 */:
                if (bVar.n() == 0) {
                    aVar.L(bVar.k());
                }
                aVar.i0().n(bVar.n(), bVar.k());
                break;
            case com.heytap.mcssdk.n.b.X /* 12290 */:
                aVar.i0().b(bVar.n());
                break;
            case com.heytap.mcssdk.n.b.Z /* 12292 */:
                aVar.i0().a(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), com.heytap.mcssdk.n.b.M, "aliasId", "aliasName"));
                break;
            case com.heytap.mcssdk.n.b.a0 /* 12293 */:
                aVar.i0().j(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), com.heytap.mcssdk.n.b.M, "aliasId", "aliasName"));
                break;
            case com.heytap.mcssdk.n.b.b0 /* 12294 */:
                aVar.i0().k(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), com.heytap.mcssdk.n.b.M, "aliasId", "aliasName"));
                break;
            case com.heytap.mcssdk.n.b.c0 /* 12295 */:
                aVar.i0().f(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), "tags", "tagId", "tagName"));
                break;
            case com.heytap.mcssdk.n.b.d0 /* 12296 */:
                aVar.i0().m(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), "tags", "tagId", "tagName"));
                break;
            case com.heytap.mcssdk.n.b.e0 /* 12297 */:
                aVar.i0().g(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), "tags", "tagId", "tagName"));
                break;
            case com.heytap.mcssdk.n.b.f0 /* 12298 */:
                aVar.i0().l(bVar.n(), bVar.k());
                break;
            case com.heytap.mcssdk.n.b.i0 /* 12301 */:
                aVar.i0().i(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), "tags", "accountId", "accountName"));
                break;
            case com.heytap.mcssdk.n.b.j0 /* 12302 */:
                aVar.i0().e(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), "tags", "accountId", "accountName"));
                break;
            case com.heytap.mcssdk.n.b.k0 /* 12303 */:
                aVar.i0().h(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), "tags", "accountId", "accountName"));
                break;
            case com.heytap.mcssdk.n.b.n0 /* 12306 */:
                aVar.i0().d(bVar.n(), com.heytap.mcssdk.o.i.k(bVar.k()));
                break;
            case com.heytap.mcssdk.n.b.q0 /* 12309 */:
                aVar.i0().c(bVar.n(), com.heytap.mcssdk.o.i.k(bVar.k()));
                break;
        }
    }

    public static void b(Context context, com.heytap.mcssdk.n.b bVar, c cVar) {
        if (context == null) {
            e.d("context is null , please check param of parseCommandMessage()");
        }
        if (bVar == null) {
            e.d("message is null , please check param of parseCommandMessage()");
            return;
        }
        if (cVar == null) {
            e.d("callback is null , please check param of parseCommandMessage()");
            return;
        }
        switch (bVar.j()) {
            case com.heytap.mcssdk.n.b.W /* 12289 */:
                if (bVar.n() == 0) {
                    a.c0().L(bVar.k());
                }
                cVar.n(bVar.n(), bVar.k());
                break;
            case com.heytap.mcssdk.n.b.X /* 12290 */:
                cVar.b(bVar.n());
                break;
            case com.heytap.mcssdk.n.b.Z /* 12292 */:
                cVar.a(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), com.heytap.mcssdk.n.b.M, "aliasId", "aliasName"));
                break;
            case com.heytap.mcssdk.n.b.a0 /* 12293 */:
                cVar.j(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), com.heytap.mcssdk.n.b.M, "aliasId", "aliasName"));
                break;
            case com.heytap.mcssdk.n.b.b0 /* 12294 */:
                cVar.k(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), com.heytap.mcssdk.n.b.M, "aliasId", "aliasName"));
                break;
            case com.heytap.mcssdk.n.b.c0 /* 12295 */:
                cVar.f(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), "tags", "tagId", "tagName"));
                break;
            case com.heytap.mcssdk.n.b.d0 /* 12296 */:
                cVar.m(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), "tags", "tagId", "tagName"));
                break;
            case com.heytap.mcssdk.n.b.e0 /* 12297 */:
                cVar.g(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), "tags", "tagId", "tagName"));
                break;
            case com.heytap.mcssdk.n.b.f0 /* 12298 */:
                cVar.l(bVar.n(), bVar.k());
                break;
            case com.heytap.mcssdk.n.b.i0 /* 12301 */:
                cVar.i(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), "tags", "accountId", "accountName"));
                break;
            case com.heytap.mcssdk.n.b.j0 /* 12302 */:
                cVar.e(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), "tags", "accountId", "accountName"));
                break;
            case com.heytap.mcssdk.n.b.k0 /* 12303 */:
                cVar.h(bVar.n(), com.heytap.mcssdk.n.b.r(bVar.k(), "tags", "accountId", "accountName"));
                break;
            case com.heytap.mcssdk.n.b.n0 /* 12306 */:
                cVar.d(bVar.n(), com.heytap.mcssdk.o.i.k(bVar.k()));
                break;
            case com.heytap.mcssdk.n.b.q0 /* 12309 */:
                cVar.c(bVar.n(), com.heytap.mcssdk.o.i.k(bVar.k()));
                break;
        }
    }

    public static void c(Context context, Intent intent, com.heytap.mcssdk.h.a aVar) {
        String str;
        if (context == null) {
            str = "context is null , please check param of parseIntent()";
        } else if (intent == null) {
            str = "intent is null , please check param of parseIntent()";
        } else {
            if (aVar != null) {
                for (com.heytap.mcssdk.n.d dVar : com.heytap.mcssdk.c.c.c(context, intent)) {
                    if (dVar != null) {
                        for (com.heytap.mcssdk.e.c cVar : a.c0().h0()) {
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
        e.d(str);
    }
}
