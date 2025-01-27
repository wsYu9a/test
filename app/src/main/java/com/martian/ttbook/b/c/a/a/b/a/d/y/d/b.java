package com.martian.ttbook.b.c.a.a.b.a.d.y.d;

import com.martian.ttbook.b.c.a.a.e.d;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class b implements InvocationHandler {

    /* renamed from: a */
    private a f15493a;

    public interface a {
        void a();

        void b();

        void onCancel();

        void onShow();
    }

    public b(a aVar) {
        this.f15493a = aVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        a aVar;
        try {
            d.g("CSJDISTAG", "M = " + method.getName());
            if ("onSelected".equals(method.getName())) {
                a aVar2 = this.f15493a;
                if (aVar2 != null) {
                    aVar2.b();
                }
            } else if ("onRefuse".equals(method.getName())) {
                a aVar3 = this.f15493a;
                if (aVar3 != null) {
                    aVar3.a();
                }
            } else if ("onCancel".equals(method.getName())) {
                a aVar4 = this.f15493a;
                if (aVar4 != null) {
                    aVar4.onCancel();
                }
            } else if ("onShow".equals(method.getName()) && (aVar = this.f15493a) != null) {
                aVar.onShow();
            }
            return null;
        } catch (Exception e2) {
            d.g("CSJDISTAG", "e = " + e2);
            return null;
        }
    }
}
