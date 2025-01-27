package com.kuaishou.weapon.p0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/* loaded from: classes2.dex */
public class da {

    /* renamed from: b */
    private static volatile da f10999b;

    /* renamed from: a */
    private Context f11000a;

    /* renamed from: c */
    private Application.ActivityLifecycleCallbacks f11001c;

    /* renamed from: d */
    private boolean f11002d;

    /* renamed from: com.kuaishou.weapon.p0.da$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h a10 = h.a(da.this.f11000a, "re_po_rt");
                boolean e10 = a10.e("a1_p_s_p_s");
                boolean e11 = a10.e("a1_p_s_p_s_c_b");
                if ((e10 || e11) && !da.this.f11002d) {
                    da.this.f11002d = true;
                    da.this.b();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.da$2 */
    public class AnonymousClass2 implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a */
        final /* synthetic */ int[] f11004a;

        /* renamed from: b */
        final /* synthetic */ int[] f11005b;

        /* renamed from: com.kuaishou.weapon.p0.da$2$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                if (iArr[0] < 20 && iArr2[0] <= 0) {
                    ((Application) da.this.f11000a).unregisterActivityLifecycleCallbacks(da.this.f11001c);
                    return;
                }
                iArr2[0] = r1[0] - 1;
                cx.a(da.this.f11000a).a(106);
                dd.a(da.this.f11000a).a(106);
                db.a(da.this.f11000a).a(106, 0);
                cy.a(da.this.f11000a).a(106);
                cz.a(da.this.f11000a).a(106);
                de.a(da.this.f11000a).a(106);
            }
        }

        public AnonymousClass2(int[] iArr, int[] iArr2) {
            iArr = iArr;
            iArr2 = iArr2;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            try {
                int[] iArr = iArr;
                iArr[0] = iArr[0] + 1;
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.2.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (iArr[0] < 20 && iArr2[0] <= 0) {
                            ((Application) da.this.f11000a).unregisterActivityLifecycleCallbacks(da.this.f11001c);
                            return;
                        }
                        iArr2[0] = r1[0] - 1;
                        cx.a(da.this.f11000a).a(106);
                        dd.a(da.this.f11000a).a(106);
                        db.a(da.this.f11000a).a(106, 0);
                        cy.a(da.this.f11000a).a(106);
                        cz.a(da.this.f11000a).a(106);
                        de.a(da.this.f11000a).a(106);
                    }
                });
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    private da(Context context) {
        this.f11000a = context;
    }

    public void b() {
        try {
            Context context = this.f11000a;
            if (context == null) {
                return;
            }
            h a10 = h.a(context, "re_po_rt");
            if (a10.b(df.f11069w, 0) == 0) {
                return;
            }
            int[] iArr = {0};
            int[] iArr2 = {a10.b(df.f11057k, 1)};
            if (this.f11000a instanceof Application) {
                AnonymousClass2 anonymousClass2 = new Application.ActivityLifecycleCallbacks() { // from class: com.kuaishou.weapon.p0.da.2

                    /* renamed from: a */
                    final /* synthetic */ int[] f11004a;

                    /* renamed from: b */
                    final /* synthetic */ int[] f11005b;

                    /* renamed from: com.kuaishou.weapon.p0.da$2$1 */
                    public class AnonymousClass1 implements Runnable {
                        public AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (iArr[0] < 20 && iArr2[0] <= 0) {
                                ((Application) da.this.f11000a).unregisterActivityLifecycleCallbacks(da.this.f11001c);
                                return;
                            }
                            iArr2[0] = r1[0] - 1;
                            cx.a(da.this.f11000a).a(106);
                            dd.a(da.this.f11000a).a(106);
                            db.a(da.this.f11000a).a(106, 0);
                            cy.a(da.this.f11000a).a(106);
                            cz.a(da.this.f11000a).a(106);
                            de.a(da.this.f11000a).a(106);
                        }
                    }

                    public AnonymousClass2(int[] iArr3, int[] iArr22) {
                        iArr = iArr3;
                        iArr2 = iArr22;
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        try {
                            int[] iArr3 = iArr;
                            iArr3[0] = iArr3[0] + 1;
                            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.2.1
                                public AnonymousClass1() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    if (iArr[0] < 20 && iArr2[0] <= 0) {
                                        ((Application) da.this.f11000a).unregisterActivityLifecycleCallbacks(da.this.f11001c);
                                        return;
                                    }
                                    iArr2[0] = r1[0] - 1;
                                    cx.a(da.this.f11000a).a(106);
                                    dd.a(da.this.f11000a).a(106);
                                    db.a(da.this.f11000a).a(106, 0);
                                    cy.a(da.this.f11000a).a(106);
                                    cz.a(da.this.f11000a).a(106);
                                    de.a(da.this.f11000a).a(106);
                                }
                            });
                        } catch (Throwable unused) {
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }
                };
                this.f11001c = anonymousClass2;
                ((Application) this.f11000a).registerActivityLifecycleCallbacks(anonymousClass2);
            }
        } catch (Throwable unused) {
        }
    }

    public static da a(Context context) {
        if (f10999b == null) {
            synchronized (da.class) {
                try {
                    if (f10999b == null) {
                        f10999b = new da(context);
                    }
                } finally {
                }
            }
        }
        return f10999b;
    }

    public void a() {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        h a10 = h.a(da.this.f11000a, "re_po_rt");
                        boolean e10 = a10.e("a1_p_s_p_s");
                        boolean e11 = a10.e("a1_p_s_p_s_c_b");
                        if ((e10 || e11) && !da.this.f11002d) {
                            da.this.f11002d = true;
                            da.this.b();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
