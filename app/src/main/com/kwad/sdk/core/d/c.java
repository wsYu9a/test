package com.kwad.sdk.core.d;

import com.ksad.annotation.invoker.ForInvoker;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import m5.d;

/* loaded from: classes3.dex */
public final class c {
    public static boolean azl = true;
    private static boolean azm = com.kwad.sdk.core.d.a.ns.booleanValue();
    private static final com.kwad.sdk.core.d.a.a azn = new b();
    private static final List<com.kwad.sdk.core.d.a.a> azo = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.sdk.core.d.c$1 */
    public class AnonymousClass1 implements a {
        final /* synthetic */ String azp;
        final /* synthetic */ String bX;

        public AnonymousClass1(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // com.kwad.sdk.core.d.c.a
        public final void b(com.kwad.sdk.core.d.a.a aVar) {
            aVar.d(str, str2);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.c$10 */
    public class AnonymousClass10 implements a {
        final /* synthetic */ String azp;
        final /* synthetic */ String azq;

        public AnonymousClass10(String str, String str2) {
            str = str;
            dZ = str2;
        }

        @Override // com.kwad.sdk.core.d.c.a
        public final void b(com.kwad.sdk.core.d.a.a aVar) {
            aVar.e(c.dY(str), dZ);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.c$2 */
    public class AnonymousClass2 implements a {
        final /* synthetic */ Throwable tN;

        public AnonymousClass2(Throwable th2) {
            th2 = th2;
        }

        @Override // com.kwad.sdk.core.d.c.a
        public final void b(com.kwad.sdk.core.d.a.a aVar) {
            aVar.printStackTraceOnly(th2);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.c$3 */
    public class AnonymousClass3 implements a {
        final /* synthetic */ Throwable tN;

        public AnonymousClass3(Throwable th2) {
            th2 = th2;
        }

        @Override // com.kwad.sdk.core.d.c.a
        public final void b(com.kwad.sdk.core.d.a.a aVar) {
            aVar.printStackTraceOnly(th2);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.c$4 */
    public class AnonymousClass4 implements a {
        final /* synthetic */ String azp;
        final /* synthetic */ String azq;

        public AnonymousClass4(String str, String str2) {
            str = str;
            dZ = str2;
        }

        @Override // com.kwad.sdk.core.d.c.a
        public final void b(com.kwad.sdk.core.d.a.a aVar) {
            aVar.v(c.dY(str), dZ);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.c$5 */
    public class AnonymousClass5 implements a {
        final /* synthetic */ String azp;
        final /* synthetic */ String azq;

        public AnonymousClass5(String str, String str2) {
            str = str;
            dZ = str2;
        }

        @Override // com.kwad.sdk.core.d.c.a
        public final void b(com.kwad.sdk.core.d.a.a aVar) {
            aVar.v(c.dY(str), dZ, true);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.c$6 */
    public class AnonymousClass6 implements a {
        final /* synthetic */ String azp;
        final /* synthetic */ String azq;

        public AnonymousClass6(String str, String str2) {
            str = str;
            dZ = str2;
        }

        @Override // com.kwad.sdk.core.d.c.a
        public final void b(com.kwad.sdk.core.d.a.a aVar) {
            aVar.i(c.dY(str), dZ);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.c$7 */
    public class AnonymousClass7 implements a {
        final /* synthetic */ String azp;
        final /* synthetic */ String azq;

        public AnonymousClass7(String str, String str2) {
            str = str;
            dZ = str2;
        }

        @Override // com.kwad.sdk.core.d.c.a
        public final void b(com.kwad.sdk.core.d.a.a aVar) {
            aVar.w(c.dY(str), dZ);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.c$8 */
    public class AnonymousClass8 implements a {
        final /* synthetic */ String azp;
        final /* synthetic */ String azq;

        public AnonymousClass8(String str, String str2) {
            str = str;
            dZ = str2;
        }

        @Override // com.kwad.sdk.core.d.c.a
        public final void b(com.kwad.sdk.core.d.a.a aVar) {
            aVar.w(c.dY(str), dZ, com.kwad.sdk.core.d.a.ns.booleanValue());
        }
    }

    /* renamed from: com.kwad.sdk.core.d.c$9 */
    public class AnonymousClass9 implements a {
        final /* synthetic */ String azp;
        final /* synthetic */ String azq;

        public AnonymousClass9(String str, String str2) {
            str = str;
            dZ = str2;
        }

        @Override // com.kwad.sdk.core.d.c.a
        public final void b(com.kwad.sdk.core.d.a.a aVar) {
            aVar.e(c.dY(str), dZ);
        }
    }

    public interface a {
        void b(com.kwad.sdk.core.d.a.a aVar);
    }

    @ForInvoker(methodId = "registerLogger")
    private static void Fq() {
        com.kwad.sdk.commercial.h.a.register();
    }

    private static void R(String str, String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.1
            final /* synthetic */ String azp;
            final /* synthetic */ String bX;

            public AnonymousClass1(String str3, String str22) {
                str = str3;
                str2 = str22;
            }

            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.d(str, str2);
            }
        });
    }

    private static void S(String str, String str2) {
        if (str2 == null || str2.length() <= 4000) {
            R(str, str2);
        } else {
            R(str, str2.substring(0, 4000));
            S(str, str2.substring(4000));
        }
    }

    public static void T(String str, String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.5
            final /* synthetic */ String azp;
            final /* synthetic */ String azq;

            public AnonymousClass5(String str3, String str22) {
                str = str3;
                dZ = str22;
            }

            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.v(c.dY(str), dZ, true);
            }
        });
    }

    public static void a(com.kwad.sdk.core.d.a.a aVar) {
        List<com.kwad.sdk.core.d.a.a> list = azo;
        if (list.contains(aVar)) {
            return;
        }
        list.add(aVar);
    }

    public static void d(String str, String str2) {
        S(dY(str), dZ(str2));
    }

    public static String dY(String str) {
        return "KSAd_" + str;
    }

    private static String dZ(String str) {
        return str + " " + yd();
    }

    public static void e(String str, String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.9
            final /* synthetic */ String azp;
            final /* synthetic */ String azq;

            public AnonymousClass9(String str3, String str22) {
                str = str3;
                dZ = str22;
            }

            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.dY(str), dZ);
            }
        });
    }

    public static void i(String str, String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.6
            final /* synthetic */ String azp;
            final /* synthetic */ String azq;

            public AnonymousClass6(String str3, String str22) {
                str = str3;
                dZ = str22;
            }

            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.i(c.dY(str), dZ);
            }
        });
    }

    public static void init(boolean z10) {
        azl = z10;
        List<com.kwad.sdk.core.d.a.a> list = azo;
        list.clear();
        list.add(azn);
        Fq();
    }

    public static void printStackTrace(Throwable th2) {
        if (th2 != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.c.2
                final /* synthetic */ Throwable tN;

                public AnonymousClass2(Throwable th22) {
                    th2 = th22;
                }

                @Override // com.kwad.sdk.core.d.c.a
                public final void b(com.kwad.sdk.core.d.a.a aVar) {
                    aVar.printStackTraceOnly(th2);
                }
            });
        }
        if (com.kwad.sdk.core.d.a.ns.booleanValue()) {
            throw new RuntimeException(th22);
        }
    }

    public static void printStackTraceOnly(Throwable th2) {
        if (th2 != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.c.3
                final /* synthetic */ Throwable tN;

                public AnonymousClass3(Throwable th22) {
                    th2 = th22;
                }

                @Override // com.kwad.sdk.core.d.c.a
                public final void b(com.kwad.sdk.core.d.a.a aVar) {
                    aVar.printStackTraceOnly(th2);
                }
            });
        }
    }

    public static void v(String str, String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.4
            final /* synthetic */ String azp;
            final /* synthetic */ String azq;

            public AnonymousClass4(String str3, String str22) {
                str = str3;
                dZ = str22;
            }

            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.v(c.dY(str), dZ);
            }
        });
    }

    public static void w(String str, String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.7
            final /* synthetic */ String azp;
            final /* synthetic */ String azq;

            public AnonymousClass7(String str3, String str22) {
                str = str3;
                dZ = str22;
            }

            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.w(c.dY(str), dZ);
            }
        });
    }

    private static String yd() {
        int i10;
        String str;
        if (!azm) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            str = stackTrace[3].getFileName();
            i10 = stackTrace[3].getLineNumber();
        } else {
            i10 = -1;
            str = "unknown";
        }
        return "(" + str + d.f28378d + i10 + ')';
    }

    private static void a(a aVar) {
        for (com.kwad.sdk.core.d.a.a aVar2 : azo) {
            if (aVar2 != null) {
                try {
                    aVar.b(aVar2);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.10
            final /* synthetic */ String azp;
            final /* synthetic */ String azq;

            public AnonymousClass10(String str3, String str22) {
                str = str3;
                dZ = str22;
            }

            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.dY(str), dZ);
            }
        });
    }

    public static void w(String str, Throwable th2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.8
            final /* synthetic */ String azp;
            final /* synthetic */ String azq;

            public AnonymousClass8(String str2, String str22) {
                str = str2;
                dZ = str22;
            }

            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.w(c.dY(str), dZ, com.kwad.sdk.core.d.a.ns.booleanValue());
            }
        });
    }
}
