package com.vivo.mobilead.i;

import com.vivo.ad.model.AdError;
import com.vivo.mobilead.util.x0;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class q implements Callable<Integer> {

    /* renamed from: a */
    private String f28904a;

    /* renamed from: b */
    private m f28905b;

    public q(String str, String str2, m mVar) {
        this.f28904a = str2;
        this.f28905b = mVar;
    }

    @Override // java.util.concurrent.Callable
    public Integer call() throws Exception {
        if (this.f28904a == null) {
            m mVar = this.f28905b;
            if (mVar != null) {
                mVar.a(new AdError(402122, "没有logo数据", null, null));
            }
            return 1;
        }
        boolean f2 = com.vivo.mobilead.h.b.a().f(this.f28904a);
        x0.c("ADMarkLogoRequest", "ad mark logo is downloaded : " + f2);
        if (f2) {
            m mVar2 = this.f28905b;
            if (mVar2 != null) {
                mVar2.a();
            }
            return 0;
        }
        try {
            new b(new h(this.f28904a, null)).a(3);
            m mVar3 = this.f28905b;
            if (mVar3 != null) {
                mVar3.a();
            }
            return 0;
        } catch (c e2) {
            m mVar4 = this.f28905b;
            if (mVar4 != null) {
                mVar4.a(new AdError(e2.a(), e2.b(), null, null));
            }
            return 1;
        }
    }
}
