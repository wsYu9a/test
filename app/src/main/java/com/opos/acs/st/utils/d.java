package com.opos.acs.st.utils;

import android.content.Context;
import com.opos.cmn.an.f.b.b;
import com.opos.cmn.an.f.b.c;

/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a */
    public static volatile boolean f16307a = false;

    /* renamed from: com.opos.acs.st.utils.d$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        private /* synthetic */ Context f16308a;

        /* renamed from: com.opos.acs.st.utils.d$1$1 */
        final class C03671 implements com.opos.cmn.an.f.b.a {
            C03671() {
            }

            @Override // com.opos.cmn.an.f.b.a
            public final void onDontNeedUpload(String str) {
                com.opos.cmn.an.f.a.b("LogUtil", "onDontNeedUpload:".concat(String.valueOf(str)));
            }

            @Override // com.opos.cmn.an.f.b.a
            public final void onUploaderFailed(String str) {
                com.opos.cmn.an.f.a.b("LogUtil", "onUploaderFailed:".concat(String.valueOf(str)));
            }

            @Override // com.opos.cmn.an.f.b.a
            public final void onUploaderSuccess() {
                com.opos.cmn.an.f.a.b("LogUtil", "onUploaderSuccess:");
            }
        }

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.opos.cmn.an.f.a.a(new b.a().a("acs_st").a(context));
            com.opos.cmn.an.f.a.a(new c.a().a(true).a("ad_st").a(), new com.opos.cmn.an.f.b.a() { // from class: com.opos.acs.st.utils.d.1.1
                C03671() {
                }

                @Override // com.opos.cmn.an.f.b.a
                public final void onDontNeedUpload(String str) {
                    com.opos.cmn.an.f.a.b("LogUtil", "onDontNeedUpload:".concat(String.valueOf(str)));
                }

                @Override // com.opos.cmn.an.f.b.a
                public final void onUploaderFailed(String str) {
                    com.opos.cmn.an.f.a.b("LogUtil", "onUploaderFailed:".concat(String.valueOf(str)));
                }

                @Override // com.opos.cmn.an.f.b.a
                public final void onUploaderSuccess() {
                    com.opos.cmn.an.f.a.b("LogUtil", "onUploaderSuccess:");
                }
            });
        }
    }

    public static void a() {
        com.opos.cmn.an.f.a.a();
    }

    public static void a(Context context) {
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.acs.st.utils.d.1

            /* renamed from: a */
            private /* synthetic */ Context f16308a;

            /* renamed from: com.opos.acs.st.utils.d$1$1 */
            final class C03671 implements com.opos.cmn.an.f.b.a {
                C03671() {
                }

                @Override // com.opos.cmn.an.f.b.a
                public final void onDontNeedUpload(String str) {
                    com.opos.cmn.an.f.a.b("LogUtil", "onDontNeedUpload:".concat(String.valueOf(str)));
                }

                @Override // com.opos.cmn.an.f.b.a
                public final void onUploaderFailed(String str) {
                    com.opos.cmn.an.f.a.b("LogUtil", "onUploaderFailed:".concat(String.valueOf(str)));
                }

                @Override // com.opos.cmn.an.f.b.a
                public final void onUploaderSuccess() {
                    com.opos.cmn.an.f.a.b("LogUtil", "onUploaderSuccess:");
                }
            }

            AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.opos.cmn.an.f.a.a(new b.a().a("acs_st").a(context));
                com.opos.cmn.an.f.a.a(new c.a().a(true).a("ad_st").a(), new com.opos.cmn.an.f.b.a() { // from class: com.opos.acs.st.utils.d.1.1
                    C03671() {
                    }

                    @Override // com.opos.cmn.an.f.b.a
                    public final void onDontNeedUpload(String str) {
                        com.opos.cmn.an.f.a.b("LogUtil", "onDontNeedUpload:".concat(String.valueOf(str)));
                    }

                    @Override // com.opos.cmn.an.f.b.a
                    public final void onUploaderFailed(String str) {
                        com.opos.cmn.an.f.a.b("LogUtil", "onUploaderFailed:".concat(String.valueOf(str)));
                    }

                    @Override // com.opos.cmn.an.f.b.a
                    public final void onUploaderSuccess() {
                        com.opos.cmn.an.f.a.b("LogUtil", "onUploaderSuccess:");
                    }
                });
            }
        });
    }

    public static void a(String str, String str2) {
        com.opos.cmn.an.f.a.b(str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        com.opos.cmn.an.f.a.b(str, str2, th);
    }

    public static void b(String str, String str2) {
        com.opos.cmn.an.f.a.d(str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        com.opos.cmn.an.f.a.c(str, str2, th);
    }

    public static void c(String str, String str2, Throwable th) {
        com.opos.cmn.an.f.a.d(str, str2, th);
    }
}
