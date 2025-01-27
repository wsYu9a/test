package com.opos.cmn.biz.monitor.b;

import android.content.Context;
import android.os.Handler;
import com.opos.cmn.biz.monitor.b.a;
import com.opos.cmn.biz.monitor.b.c;
import com.opos.cmn.func.b.b.d;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class d implements a {

    /* renamed from: com.opos.cmn.biz.monitor.b.d$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ b f16734a;

        /* renamed from: b */
        final /* synthetic */ Context f16735b;

        /* renamed from: c */
        final /* synthetic */ Handler f16736c;

        /* renamed from: d */
        final /* synthetic */ a.InterfaceC0377a f16737d;

        /* renamed from: com.opos.cmn.biz.monitor.b.d$1$1 */
        class RunnableC03781 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ c f16739a;

            RunnableC03781(c cVar) {
                a2 = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = a2;
                if (cVar != null) {
                    interfaceC0377a.a(cVar);
                } else {
                    interfaceC0377a.a();
                }
            }
        }

        /* renamed from: com.opos.cmn.biz.monitor.b.d$1$2 */
        class AnonymousClass2 implements Runnable {
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                interfaceC0377a.a();
            }
        }

        AnonymousClass1(b bVar, Context context, Handler handler, a.InterfaceC0377a interfaceC0377a) {
            bVar = bVar;
            context = context;
            handler = handler;
            interfaceC0377a = interfaceC0377a;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.func.b.b.e eVar;
            com.opos.cmn.func.b.b.e eVar2 = null;
            c a2 = null;
            eVar2 = null;
            try {
                try {
                    Map<String, String> c2 = bVar.c();
                    if (c2 == null) {
                        c2 = new HashMap<>();
                    }
                    c2.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
                    com.opos.cmn.func.b.b.d a3 = new d.a().a(bVar.d()).a(c2).a(bVar.b()).b(bVar.a()).a();
                    com.opos.cmn.an.f.a.b("DefaultRequestResolver", "netRequest is = " + a3 + ". url = " + a3.f17154b);
                    eVar = com.opos.cmn.func.b.b.b.a().a(context, a3);
                    if (eVar != null) {
                        try {
                            a2 = new c.a(eVar.f17168a).a(eVar.f17172e).a(d.b(eVar, bVar.a())).a();
                        } catch (Exception e2) {
                            e = e2;
                            eVar2 = eVar;
                            com.opos.cmn.an.f.a.d("DefaultRequestResolver", "resolve fail," + e.toString());
                            handler.post(new Runnable() { // from class: com.opos.cmn.biz.monitor.b.d.1.2
                                AnonymousClass2() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    interfaceC0377a.a();
                                }
                            });
                            if (eVar2 != null) {
                                eVar2.a();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            if (eVar != null) {
                                eVar.a();
                            }
                            throw th;
                        }
                    }
                    com.opos.cmn.an.f.a.b("DefaultRequestResolver", "response is = " + a2);
                    handler.post(new Runnable() { // from class: com.opos.cmn.biz.monitor.b.d.1.1

                        /* renamed from: a */
                        final /* synthetic */ c f16739a;

                        RunnableC03781(c a22) {
                            a2 = a22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            c cVar = a2;
                            if (cVar != null) {
                                interfaceC0377a.a(cVar);
                            } else {
                                interfaceC0377a.a();
                            }
                        }
                    });
                    if (eVar != null) {
                        eVar.a();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    eVar = eVar2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
    }

    public static byte[] b(com.opos.cmn.func.b.b.e eVar, String str) {
        if (com.opos.cmn.biz.monitor.e.a(str) && eVar != null && 200 == eVar.f17168a && eVar.f17171d > 0 && eVar.f17170c != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                do {
                    int read = eVar.f17170c.read(bArr);
                    if (-1 == read) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } while (byteArrayOutputStream.size() <= 8192);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.d("DefaultRequestResolver", "getResponseBytes error,url" + str, th);
            }
        }
        return null;
    }

    @Override // com.opos.cmn.biz.monitor.b.a
    public void a(Context context, b bVar, a.InterfaceC0377a interfaceC0377a) {
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.b.d.1

            /* renamed from: a */
            final /* synthetic */ b f16734a;

            /* renamed from: b */
            final /* synthetic */ Context f16735b;

            /* renamed from: c */
            final /* synthetic */ Handler f16736c;

            /* renamed from: d */
            final /* synthetic */ a.InterfaceC0377a f16737d;

            /* renamed from: com.opos.cmn.biz.monitor.b.d$1$1 */
            class RunnableC03781 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ c f16739a;

                RunnableC03781(c a22) {
                    a2 = a22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar = a2;
                    if (cVar != null) {
                        interfaceC0377a.a(cVar);
                    } else {
                        interfaceC0377a.a();
                    }
                }
            }

            /* renamed from: com.opos.cmn.biz.monitor.b.d$1$2 */
            class AnonymousClass2 implements Runnable {
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    interfaceC0377a.a();
                }
            }

            AnonymousClass1(b bVar2, Context context2, Handler handler, a.InterfaceC0377a interfaceC0377a2) {
                bVar = bVar2;
                context = context2;
                handler = handler;
                interfaceC0377a = interfaceC0377a2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.func.b.b.e eVar;
                com.opos.cmn.func.b.b.e eVar2 = null;
                c a22 = null;
                eVar2 = null;
                try {
                    try {
                        Map<String, String> c2 = bVar.c();
                        if (c2 == null) {
                            c2 = new HashMap<>();
                        }
                        c2.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
                        com.opos.cmn.func.b.b.d a3 = new d.a().a(bVar.d()).a(c2).a(bVar.b()).b(bVar.a()).a();
                        com.opos.cmn.an.f.a.b("DefaultRequestResolver", "netRequest is = " + a3 + ". url = " + a3.f17154b);
                        eVar = com.opos.cmn.func.b.b.b.a().a(context, a3);
                        if (eVar != null) {
                            try {
                                a22 = new c.a(eVar.f17168a).a(eVar.f17172e).a(d.b(eVar, bVar.a())).a();
                            } catch (Exception e2) {
                                e = e2;
                                eVar2 = eVar;
                                com.opos.cmn.an.f.a.d("DefaultRequestResolver", "resolve fail," + e.toString());
                                handler.post(new Runnable() { // from class: com.opos.cmn.biz.monitor.b.d.1.2
                                    AnonymousClass2() {
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        interfaceC0377a.a();
                                    }
                                });
                                if (eVar2 != null) {
                                    eVar2.a();
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                if (eVar != null) {
                                    eVar.a();
                                }
                                throw th;
                            }
                        }
                        com.opos.cmn.an.f.a.b("DefaultRequestResolver", "response is = " + a22);
                        handler.post(new Runnable() { // from class: com.opos.cmn.biz.monitor.b.d.1.1

                            /* renamed from: a */
                            final /* synthetic */ c f16739a;

                            RunnableC03781(c a222) {
                                a2 = a222;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                c cVar = a2;
                                if (cVar != null) {
                                    interfaceC0377a.a(cVar);
                                } else {
                                    interfaceC0377a.a();
                                }
                            }
                        });
                        if (eVar != null) {
                            eVar.a();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        eVar = eVar2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
        });
    }
}
