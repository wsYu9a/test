package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.proguard.I;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.util.Map;

/* loaded from: classes4.dex */
class b extends Thread {

    /* renamed from: a */
    final /* synthetic */ c f24773a;

    b(c cVar) {
        this.f24773a = cVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        StrategyBean strategyBean;
        StrategyBean strategyBean2;
        String str;
        StrategyBean strategyBean3;
        StrategyBean strategyBean4;
        String str2;
        StrategyBean strategyBean5;
        String str3;
        StrategyBean strategyBean6;
        String str4;
        Context context;
        Context context2;
        try {
            Map<String, byte[]> a2 = J.a().a(c.f24774a, (I) null, true);
            if (a2 != null) {
                byte[] bArr = a2.get("device");
                byte[] bArr2 = a2.get("gateway");
                if (bArr != null) {
                    context2 = this.f24773a.f24781h;
                    com.tencent.bugly.crashreport.common.info.a.a(context2).f(new String(bArr));
                }
                if (bArr2 != null) {
                    context = this.f24773a.f24781h;
                    com.tencent.bugly.crashreport.common.info.a.a(context).e(new String(bArr2));
                }
            }
            c cVar = this.f24773a;
            cVar.f24780g = cVar.e();
            strategyBean2 = this.f24773a.f24780g;
            if (strategyBean2 != null) {
                str = c.f24776c;
                if (!ca.b(str)) {
                    str2 = c.f24776c;
                    if (ca.c(str2)) {
                        strategyBean5 = this.f24773a.f24780g;
                        str3 = c.f24776c;
                        strategyBean5.q = str3;
                        strategyBean6 = this.f24773a.f24780g;
                        str4 = c.f24776c;
                        strategyBean6.r = str4;
                    }
                }
                strategyBean3 = this.f24773a.f24780g;
                strategyBean3.q = StrategyBean.f24763a;
                strategyBean4 = this.f24773a.f24780g;
                strategyBean4.r = StrategyBean.f24764b;
            }
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
        c cVar2 = this.f24773a;
        strategyBean = cVar2.f24780g;
        cVar2.a(strategyBean, false);
    }
}
