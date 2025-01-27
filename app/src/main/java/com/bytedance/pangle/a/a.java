package com.bytedance.pangle.a;

import com.bytedance.pangle.d.e;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    final CountDownLatch f5987a;

    /* renamed from: b */
    Throwable f5988b;

    /* renamed from: com.bytedance.pangle.a.a$1 */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ InterfaceC0067a f5989a;

        AnonymousClass1(InterfaceC0067a interfaceC0067a) {
            interfaceC0067a = interfaceC0067a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                interfaceC0067a.a();
            } catch (Throwable th) {
                a.this.f5988b = th;
            }
            a.this.f5987a.countDown();
        }
    }

    /* renamed from: com.bytedance.pangle.a.a$a */
    public interface InterfaceC0067a {
        void a();
    }

    private a(InterfaceC0067a[] interfaceC0067aArr) {
        this.f5987a = new CountDownLatch(interfaceC0067aArr.length);
        for (InterfaceC0067a interfaceC0067a : interfaceC0067aArr) {
            e.a(new Runnable() { // from class: com.bytedance.pangle.a.a.1

                /* renamed from: a */
                final /* synthetic */ InterfaceC0067a f5989a;

                AnonymousClass1(InterfaceC0067a interfaceC0067a2) {
                    interfaceC0067a = interfaceC0067a2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        interfaceC0067a.a();
                    } catch (Throwable th) {
                        a.this.f5988b = th;
                    }
                    a.this.f5987a.countDown();
                }
            });
        }
    }

    public static void a(InterfaceC0067a... interfaceC0067aArr) {
        a aVar = new a(interfaceC0067aArr);
        try {
            aVar.f5987a.await();
            Throwable th = aVar.f5988b;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
