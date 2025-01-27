package com.bytedance.pangle.a;

import com.bytedance.pangle.d.e;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    final CountDownLatch f7464a;

    /* renamed from: b */
    Throwable f7465b;

    /* renamed from: com.bytedance.pangle.a.a$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ InterfaceC0226a f7466a;

        public AnonymousClass1(InterfaceC0226a interfaceC0226a) {
            interfaceC0226a = interfaceC0226a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                interfaceC0226a.a();
            } catch (Throwable th2) {
                a.this.f7465b = th2;
            }
            a.this.f7464a.countDown();
        }
    }

    /* renamed from: com.bytedance.pangle.a.a$a */
    public interface InterfaceC0226a {
        void a();
    }

    private a(InterfaceC0226a[] interfaceC0226aArr) {
        this.f7464a = new CountDownLatch(interfaceC0226aArr.length);
        for (InterfaceC0226a interfaceC0226a : interfaceC0226aArr) {
            e.a(new Runnable() { // from class: com.bytedance.pangle.a.a.1

                /* renamed from: a */
                final /* synthetic */ InterfaceC0226a f7466a;

                public AnonymousClass1(InterfaceC0226a interfaceC0226a2) {
                    interfaceC0226a = interfaceC0226a2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        interfaceC0226a.a();
                    } catch (Throwable th2) {
                        a.this.f7465b = th2;
                    }
                    a.this.f7464a.countDown();
                }
            });
        }
    }

    public static void a(InterfaceC0226a... interfaceC0226aArr) {
        a aVar = new a(interfaceC0226aArr);
        try {
            aVar.f7464a.await();
            Throwable th2 = aVar.f7465b;
            if (th2 != null) {
                throw th2;
            }
        } catch (InterruptedException e10) {
            throw new RuntimeException(e10);
        }
    }
}
