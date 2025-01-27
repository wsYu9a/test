package com.qq.e.comm.managers;

import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
class b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f16567a;

    /* renamed from: b */
    final /* synthetic */ a f16568b;

    public b(a aVar, boolean z10) {
        this.f16568b = aVar;
        this.f16567a = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f16568b.f16561d.getPOFactory(this.f16567a, true);
            this.f16568b.f16559b = true;
        } catch (e e10) {
            GDTLogger.e(e10.getMessage(), e10);
        }
    }
}
