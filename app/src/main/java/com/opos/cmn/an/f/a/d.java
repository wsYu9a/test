package com.opos.cmn.an.f.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes4.dex */
public class d extends Handler {

    /* renamed from: a */
    private com.opos.cmn.an.f.a.a.b f16445a;

    public d(Looper looper) {
        super(looper);
    }

    private void a(com.opos.cmn.an.f.a.b.c cVar) {
        if (cVar.f16421a.f16454e == 2 && a()) {
            this.f16445a = new com.opos.cmn.an.f.a.a.d();
            if (c.b()) {
                Log.d("LogHandler", "use NearLogImpl");
            }
        }
        if (this.f16445a == null) {
            this.f16445a = new com.opos.cmn.an.f.a.a.a();
            if (c.b()) {
                Log.d("LogHandler", "use BasicLogImpl");
            }
        }
    }

    private boolean a() {
        try {
            String canonicalName = b.h.a.c.class.getCanonicalName();
            if (!TextUtils.isEmpty(canonicalName) && c.b()) {
                Log.d("LogHandler", canonicalName + " exits");
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        com.opos.cmn.an.f.a.b.e eVar;
        if (message != null) {
            try {
                switch (message.what) {
                    case 1:
                        Object obj5 = message.obj;
                        if (obj5 != null) {
                            com.opos.cmn.an.f.a.b.c cVar = (com.opos.cmn.an.f.a.b.c) obj5;
                            a(cVar);
                            this.f16445a.a(cVar.f16421a);
                            break;
                        }
                        break;
                    case 2:
                        com.opos.cmn.an.f.a.a.b bVar = this.f16445a;
                        if (bVar != null && (obj = message.obj) != null) {
                            bVar.a((com.opos.cmn.an.f.a.b.d) obj);
                            break;
                        }
                        break;
                    case 3:
                        com.opos.cmn.an.f.a.a.b bVar2 = this.f16445a;
                        if (bVar2 != null && (obj2 = message.obj) != null) {
                            com.opos.cmn.an.f.a.b.f fVar = (com.opos.cmn.an.f.a.b.f) obj2;
                            bVar2.a(fVar.f16440a, fVar.f16441b);
                            break;
                        }
                        break;
                    case 4:
                        com.opos.cmn.an.f.a.a.b bVar3 = this.f16445a;
                        if (bVar3 != null && (obj3 = message.obj) != null) {
                            bVar3.a(((com.opos.cmn.an.f.a.b.b) obj3).f16420a);
                            break;
                        }
                        break;
                    case 5:
                        com.opos.cmn.an.f.a.a.b bVar4 = this.f16445a;
                        if (bVar4 != null && message.obj != null) {
                            bVar4.a();
                            break;
                        }
                        break;
                    case 6:
                        com.opos.cmn.an.f.a.a.b bVar5 = this.f16445a;
                        if (bVar5 != null && (obj4 = message.obj) != null && (eVar = (com.opos.cmn.an.f.a.b.e) obj4) != null) {
                            bVar5.a(eVar.f16439a);
                            break;
                        }
                        break;
                }
            } catch (Throwable unused) {
            }
        }
    }
}
