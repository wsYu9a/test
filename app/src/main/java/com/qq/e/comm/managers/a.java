package com.qq.e.comm.managers;

import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes4.dex */
class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ b f24008a;

    a(b bVar) {
        this.f24008a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PM pm;
        try {
            pm = this.f24008a.f24013d;
            pm.getPOFactory();
            this.f24008a.f24011b = true;
        } catch (e e2) {
            GDTLogger.e(e2.getMessage(), e2);
        }
    }
}
