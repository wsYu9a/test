package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.proguard.I;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import h3.e;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends Thread {

    /* renamed from: a */
    final /* synthetic */ c f22360a;

    public b(c cVar) {
        this.f22360a = cVar;
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
            Map<String, byte[]> a10 = J.a().a(c.f22361a, (I) null, true);
            if (a10 != null) {
                byte[] bArr = a10.get(e.f26411p);
                byte[] bArr2 = a10.get("gateway");
                if (bArr != null) {
                    context2 = this.f22360a.f22368h;
                    com.tencent.bugly.crashreport.common.info.a.a(context2).f(new String(bArr));
                }
                if (bArr2 != null) {
                    context = this.f22360a.f22368h;
                    com.tencent.bugly.crashreport.common.info.a.a(context).e(new String(bArr2));
                }
            }
            c cVar = this.f22360a;
            cVar.f22367g = cVar.e();
            strategyBean2 = this.f22360a.f22367g;
            if (strategyBean2 != null) {
                str = c.f22363c;
                if (!ca.b(str)) {
                    str2 = c.f22363c;
                    if (ca.c(str2)) {
                        strategyBean5 = this.f22360a.f22367g;
                        str3 = c.f22363c;
                        strategyBean5.f22353q = str3;
                        strategyBean6 = this.f22360a.f22367g;
                        str4 = c.f22363c;
                        strategyBean6.f22354r = str4;
                    }
                }
                strategyBean3 = this.f22360a.f22367g;
                strategyBean3.f22353q = StrategyBean.f22337a;
                strategyBean4 = this.f22360a.f22367g;
                strategyBean4.f22354r = StrategyBean.f22338b;
            }
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
        }
        c cVar2 = this.f22360a;
        strategyBean = cVar2.f22367g;
        cVar2.a(strategyBean, false);
    }
}
