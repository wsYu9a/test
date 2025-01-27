package com.kwad.sdk.core.d;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class b {
    public static boolean afV = true;
    private static boolean afW = com.kwad.kwai.kwai.a.bI.booleanValue();
    private static final com.kwad.sdk.core.d.kwai.b afX = new com.kwad.sdk.core.d.a();
    private static final List<com.kwad.sdk.core.d.kwai.b> afY = new CopyOnWriteArrayList();
    private static com.kwad.sdk.core.d.kwai.a afZ;

    /* renamed from: com.kwad.sdk.core.d.b$1 */
    static class AnonymousClass1 implements a {
        final /* synthetic */ String aga;
        final /* synthetic */ String cl;

        AnonymousClass1(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // com.kwad.sdk.core.d.b.a
        public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
            bVar.d(str, str2);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.b$10 */
    static class AnonymousClass10 implements a {
        final /* synthetic */ String agb;

        AnonymousClass10(String str) {
            u = str;
        }

        @Override // com.kwad.sdk.core.d.b.a
        public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
            bVar.w(b.vZ(), u, com.kwad.kwai.kwai.a.bI.booleanValue());
        }
    }

    /* renamed from: com.kwad.sdk.core.d.b$11 */
    static class AnonymousClass11 implements a {
        final /* synthetic */ String agb;

        AnonymousClass11(String str) {
            u = str;
        }

        @Override // com.kwad.sdk.core.d.b.a
        public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
            bVar.e(b.vZ(), u);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.b$2 */
    static class AnonymousClass2 implements a {
        final /* synthetic */ String agb;

        AnonymousClass2(String str) {
            u = str;
        }

        @Override // com.kwad.sdk.core.d.b.a
        public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
            bVar.e(b.vZ(), u);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.b$3 */
    static class AnonymousClass3 implements a {
        final /* synthetic */ Throwable sa;

        AnonymousClass3(Throwable th) {
            th = th;
        }

        @Override // com.kwad.sdk.core.d.b.a
        public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
            bVar.printStackTraceOnly(th);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.b$4 */
    static class AnonymousClass4 implements a {
        final /* synthetic */ Throwable sa;

        AnonymousClass4(Throwable th) {
            th = th;
        }

        @Override // com.kwad.sdk.core.d.b.a
        public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
            bVar.printStackTraceOnly(th);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.b$5 */
    static class AnonymousClass5 implements a {
        final /* synthetic */ String agb;

        AnonymousClass5(String str) {
            u = str;
        }

        @Override // com.kwad.sdk.core.d.b.a
        public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
            bVar.v(b.vZ(), u);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.b$6 */
    static class AnonymousClass6 implements a {
        final /* synthetic */ String cl;

        AnonymousClass6(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.core.d.b.a
        public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
            bVar.v(b.vZ(), str, true);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.b$7 */
    static class AnonymousClass7 implements a {
        final /* synthetic */ String agb;

        AnonymousClass7(String str) {
            u = str;
        }

        @Override // com.kwad.sdk.core.d.b.a
        public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
            bVar.v(b.vZ(), u, true);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.b$8 */
    static class AnonymousClass8 implements a {
        final /* synthetic */ String agb;

        AnonymousClass8(String str) {
            u = str;
        }

        @Override // com.kwad.sdk.core.d.b.a
        public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
            bVar.i(b.vZ(), u);
        }
    }

    /* renamed from: com.kwad.sdk.core.d.b$9 */
    static class AnonymousClass9 implements a {
        final /* synthetic */ String agb;

        AnonymousClass9(String str) {
            u = str;
        }

        @Override // com.kwad.sdk.core.d.b.a
        public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
            bVar.w(b.vZ(), u);
        }
    }

    interface a {
        void b(com.kwad.sdk.core.d.kwai.b bVar);
    }

    private static void a(a aVar) {
        for (com.kwad.sdk.core.d.kwai.b bVar : afY) {
            if (bVar != null) {
                try {
                    aVar.b(bVar);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void a(com.kwad.sdk.core.d.kwai.b bVar) {
        List<com.kwad.sdk.core.d.kwai.b> list = afY;
        if (list.contains(bVar)) {
            return;
        }
        list.add(bVar);
    }

    public static void a(boolean z, com.kwad.sdk.core.d.kwai.a aVar) {
        afV = z;
        List<com.kwad.sdk.core.d.kwai.b> list = afY;
        list.clear();
        list.add(afX);
        afZ = aVar;
    }

    public static void cb(String str) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.6
            final /* synthetic */ String cl;

            AnonymousClass6(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.v(b.vZ(), str, true);
            }
        });
    }

    public static void d(String str, String str2) {
        y(vZ(), u(str, str2));
    }

    public static void e(String str, String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.11
            final /* synthetic */ String agb;

            AnonymousClass11(String str3) {
                u = str3;
            }

            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.e(b.vZ(), u);
            }
        });
        com.kwad.sdk.core.d.kwai.a aVar = afZ;
        if (aVar != null) {
            aVar.m(str2, str);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        a(new a() { // from class: com.kwad.sdk.core.d.b.2
            final /* synthetic */ String agb;

            AnonymousClass2(String str3) {
                u = str3;
            }

            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.e(b.vZ(), u);
            }
        });
        com.kwad.sdk.core.d.kwai.a aVar = afZ;
        if (aVar != null) {
            aVar.m(stackTraceString, str);
        }
    }

    public static void i(String str, String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.8
            final /* synthetic */ String agb;

            AnonymousClass8(String str3) {
                u = str3;
            }

            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.i(b.vZ(), u);
            }
        });
    }

    public static void printStackTrace(Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.b.3
                final /* synthetic */ Throwable sa;

                AnonymousClass3(Throwable th2) {
                    th = th2;
                }

                @Override // com.kwad.sdk.core.d.b.a
                public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                    bVar.printStackTraceOnly(th);
                }
            });
        }
        if (com.kwad.kwai.kwai.a.bI.booleanValue()) {
            throw new RuntimeException(th2);
        }
    }

    public static void printStackTraceOnly(Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.b.4
                final /* synthetic */ Throwable sa;

                AnonymousClass4(Throwable th2) {
                    th = th2;
                }

                @Override // com.kwad.sdk.core.d.b.a
                public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                    bVar.printStackTraceOnly(th);
                }
            });
        }
    }

    private static String u(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + wa();
    }

    public static void v(String str, String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.5
            final /* synthetic */ String agb;

            AnonymousClass5(String str3) {
                u = str3;
            }

            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.v(b.vZ(), u);
            }
        });
    }

    public static String vZ() {
        return "KSAdSDK";
    }

    public static void w(String str, String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.9
            final /* synthetic */ String agb;

            AnonymousClass9(String str3) {
                u = str3;
            }

            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.w(b.vZ(), u);
            }
        });
    }

    public static void w(String str, Throwable th) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.10
            final /* synthetic */ String agb;

            AnonymousClass10(String str2) {
                u = str2;
            }

            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.w(b.vZ(), u, com.kwad.kwai.kwai.a.bI.booleanValue());
            }
        });
    }

    private static String wa() {
        String str;
        int i2;
        if (!afW) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            str = stackTrace[3].getFileName();
            i2 = stackTrace[3].getLineNumber();
        } else {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
            i2 = -1;
        }
        return "(" + str + ':' + i2 + ')';
    }

    private static void x(String str, String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.1
            final /* synthetic */ String aga;
            final /* synthetic */ String cl;

            AnonymousClass1(String str3, String str22) {
                str = str3;
                str2 = str22;
            }

            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.d(str, str2);
            }
        });
    }

    private static void y(String str, String str2) {
        if (str2.length() <= 4000) {
            x(str, str2);
        } else {
            x(str, str2.substring(0, 4000));
            y(str, str2.substring(4000));
        }
    }

    public static void z(String str, String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.7
            final /* synthetic */ String agb;

            AnonymousClass7(String str3) {
                u = str3;
            }

            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.v(b.vZ(), u, true);
            }
        });
    }
}
