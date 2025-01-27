package com.kwad.sdk.core.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KSLifecycleListener;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.bu;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class b implements c<Activity> {
    private static volatile b azf;
    private static final List<c> mListeners = new CopyOnWriteArrayList();
    private final AtomicBoolean LB = new AtomicBoolean(false);

    @Nullable
    private Application mApplication;

    /* renamed from: com.kwad.sdk.core.c.b$1 */
    public class AnonymousClass1 implements KSLifecycleListener {

        /* renamed from: com.kwad.sdk.core.c.b$1$1 */
        public class C04861 implements com.kwad.sdk.f.a<c> {
            final /* synthetic */ Bundle azh;
            final /* synthetic */ Activity nS;

            public C04861(Activity activity, Bundle bundle) {
                activity = activity;
                bundle = bundle;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.a(activity, bundle);
            }
        }

        /* renamed from: com.kwad.sdk.core.c.b$1$2 */
        public class AnonymousClass2 implements com.kwad.sdk.f.a<c> {
            final /* synthetic */ Activity nS;

            public AnonymousClass2(Activity activity) {
                activity = activity;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.d(activity);
            }
        }

        /* renamed from: com.kwad.sdk.core.c.b$1$3 */
        public class AnonymousClass3 implements com.kwad.sdk.f.a<c> {
            final /* synthetic */ Activity nS;

            public AnonymousClass3(Activity activity) {
                activity = activity;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.c(activity);
            }
        }

        /* renamed from: com.kwad.sdk.core.c.b$1$4 */
        public class AnonymousClass4 implements com.kwad.sdk.f.a<c> {
            final /* synthetic */ Activity nS;

            public AnonymousClass4(Activity activity) {
                activity = activity;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.b(activity);
            }
        }

        /* renamed from: com.kwad.sdk.core.c.b$1$5 */
        public class AnonymousClass5 implements com.kwad.sdk.f.a<c> {
            public AnonymousClass5() {
            }

            private static void c(c cVar) {
                cVar.onBackToForeground();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        }

        /* renamed from: com.kwad.sdk.core.c.b$1$6 */
        public class AnonymousClass6 implements com.kwad.sdk.f.a<c> {
            public AnonymousClass6() {
            }

            private static void c(c cVar) {
                cVar.onBackToBackground();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.core.KSLifecycleListener
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            b bVar = b.this;
            b.c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.1
                final /* synthetic */ Bundle azh;
                final /* synthetic */ Activity nS;

                public C04861(Activity activity2, Bundle bundle2) {
                    activity = activity2;
                    bundle = bundle2;
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: c */
                public void accept(c cVar) {
                    cVar.a(activity, bundle);
                }
            });
        }

        @Override // com.kwad.sdk.api.core.KSLifecycleListener
        public final void onActivityDestroyed(Activity activity) {
            b bVar = b.this;
            b.c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.4
                final /* synthetic */ Activity nS;

                public AnonymousClass4(Activity activity2) {
                    activity = activity2;
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: c */
                public void accept(c cVar) {
                    cVar.b(activity);
                }
            });
        }

        @Override // com.kwad.sdk.api.core.KSLifecycleListener
        public final void onActivityPaused(Activity activity) {
            b bVar = b.this;
            b.c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.3
                final /* synthetic */ Activity nS;

                public AnonymousClass3(Activity activity2) {
                    activity = activity2;
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: c */
                public void accept(c cVar) {
                    cVar.c(activity);
                }
            });
        }

        @Override // com.kwad.sdk.api.core.KSLifecycleListener
        public final void onActivityResumed(Activity activity) {
            b bVar = b.this;
            b.c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.2
                final /* synthetic */ Activity nS;

                public AnonymousClass2(Activity activity2) {
                    activity = activity2;
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: c */
                public void accept(c cVar) {
                    cVar.d(activity);
                }
            });
        }

        @Override // com.kwad.sdk.api.core.KSLifecycleListener
        public final void onBackToBackground() {
            com.kwad.sdk.core.d.c.T("LifecycleHolder", "onBackToBackground");
            b bVar = b.this;
            b.c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.6
                public AnonymousClass6() {
                }

                private static void c(c cVar) {
                    cVar.onBackToBackground();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(c cVar) {
                    c(cVar);
                }
            });
        }

        @Override // com.kwad.sdk.api.core.KSLifecycleListener
        public final void onBackToForeground() {
            com.kwad.sdk.core.d.c.T("LifecycleHolder", "onBackToForeground");
            b bVar = b.this;
            b.c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.5
                public AnonymousClass5() {
                }

                private static void c(c cVar) {
                    cVar.onBackToForeground();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(c cVar) {
                    c(cVar);
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.core.c.b$2 */
    public class AnonymousClass2 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ Bundle azh;
        final /* synthetic */ Activity nS;

        public AnonymousClass2(Activity activity, Bundle bundle) {
            activity = activity;
            bundle = bundle;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(c cVar) {
            cVar.a(activity, bundle);
        }
    }

    /* renamed from: com.kwad.sdk.core.c.b$3 */
    public class AnonymousClass3 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ Activity nS;

        public AnonymousClass3(Activity activity) {
            activity = activity;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(c cVar) {
            cVar.d(activity);
        }
    }

    /* renamed from: com.kwad.sdk.core.c.b$4 */
    public class AnonymousClass4 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ Activity nS;

        public AnonymousClass4(Activity activity) {
            activity = activity;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(c cVar) {
            cVar.c(activity);
        }
    }

    /* renamed from: com.kwad.sdk.core.c.b$5 */
    public class AnonymousClass5 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ Activity nS;

        public AnonymousClass5(Activity activity) {
            activity = activity;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(c cVar) {
            cVar.b(activity);
        }
    }

    /* renamed from: com.kwad.sdk.core.c.b$6 */
    public class AnonymousClass6 implements com.kwad.sdk.f.a<c> {
        public AnonymousClass6() {
        }

        private static void c(c cVar) {
            cVar.onBackToForeground();
        }

        @Override // com.kwad.sdk.f.a
        public final /* synthetic */ void accept(c cVar) {
            c(cVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.c.b$7 */
    public class AnonymousClass7 implements com.kwad.sdk.f.a<c> {
        public AnonymousClass7() {
        }

        private static void c(c cVar) {
            cVar.onBackToBackground();
        }

        @Override // com.kwad.sdk.f.a
        public final /* synthetic */ void accept(c cVar) {
            c(cVar);
        }
    }

    private b() {
    }

    public static b Fi() {
        if (azf == null) {
            synchronized (b.class) {
                try {
                    if (azf == null) {
                        azf = new b();
                    }
                } finally {
                }
            }
        }
        return azf;
    }

    public static boolean Fj() {
        try {
            if (bu.ay(((f) ServiceProvider.get(f.class)).getApiVersion(), "3.3.26")) {
                return KSLifecycleObserver.getInstance().isEnable();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Nullable
    public static Activity getCurrentActivity() {
        if (Fj()) {
            return KSLifecycleObserver.getInstance().getCurrentActivity();
        }
        if (a.Fg().isEnable()) {
            return a.Fg().getCurrentActivity();
        }
        return null;
    }

    public static boolean isAppOnForeground() {
        if (Fj()) {
            return KSLifecycleObserver.getInstance().isAppOnForeground();
        }
        if (a.Fg().isEnable()) {
            return a.Fg().isAppOnForeground();
        }
        return false;
    }

    public static boolean isEnable() {
        return Fj() || a.Fg().isEnable();
    }

    @Override // com.kwad.sdk.core.c.c
    /* renamed from: onActivityCreated */
    public void a(Activity activity, Bundle bundle) {
        c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.2
            final /* synthetic */ Bundle azh;
            final /* synthetic */ Activity nS;

            public AnonymousClass2(Activity activity2, Bundle bundle2) {
                activity = activity2;
                bundle = bundle2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.a(activity, bundle);
            }
        });
    }

    @Override // com.kwad.sdk.core.c.c
    /* renamed from: onActivityDestroyed */
    public void b(Activity activity) {
        c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.5
            final /* synthetic */ Activity nS;

            public AnonymousClass5(Activity activity2) {
                activity = activity2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.b(activity);
            }
        });
    }

    @Override // com.kwad.sdk.core.c.c
    /* renamed from: onActivityPaused */
    public void c(Activity activity) {
        c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.4
            final /* synthetic */ Activity nS;

            public AnonymousClass4(Activity activity2) {
                activity = activity2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.c(activity);
            }
        });
    }

    @Override // com.kwad.sdk.core.c.c
    /* renamed from: onActivityResumed */
    public void d(Activity activity) {
        c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.3
            final /* synthetic */ Activity nS;

            public AnonymousClass3(Activity activity2) {
                activity = activity2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.d(activity);
            }
        });
    }

    @Nullable
    public final Application getApplication() {
        return this.mApplication;
    }

    public final void init(Context context) {
        if (this.LB.get() || context == null) {
            return;
        }
        this.LB.set(true);
        try {
            if (bu.ay(((f) ServiceProvider.get(f.class)).getApiVersion(), "3.3.26")) {
                this.mApplication = KSLifecycleObserver.getInstance().getApplication();
                KSLifecycleObserver.getInstance().registerLifecycleListener(new KSLifecycleListener() { // from class: com.kwad.sdk.core.c.b.1

                    /* renamed from: com.kwad.sdk.core.c.b$1$1 */
                    public class C04861 implements com.kwad.sdk.f.a<c> {
                        final /* synthetic */ Bundle azh;
                        final /* synthetic */ Activity nS;

                        public C04861(Activity activity2, Bundle bundle2) {
                            activity = activity2;
                            bundle = bundle2;
                        }

                        @Override // com.kwad.sdk.f.a
                        /* renamed from: c */
                        public void accept(c cVar) {
                            cVar.a(activity, bundle);
                        }
                    }

                    /* renamed from: com.kwad.sdk.core.c.b$1$2 */
                    public class AnonymousClass2 implements com.kwad.sdk.f.a<c> {
                        final /* synthetic */ Activity nS;

                        public AnonymousClass2(Activity activity2) {
                            activity = activity2;
                        }

                        @Override // com.kwad.sdk.f.a
                        /* renamed from: c */
                        public void accept(c cVar) {
                            cVar.d(activity);
                        }
                    }

                    /* renamed from: com.kwad.sdk.core.c.b$1$3 */
                    public class AnonymousClass3 implements com.kwad.sdk.f.a<c> {
                        final /* synthetic */ Activity nS;

                        public AnonymousClass3(Activity activity2) {
                            activity = activity2;
                        }

                        @Override // com.kwad.sdk.f.a
                        /* renamed from: c */
                        public void accept(c cVar) {
                            cVar.c(activity);
                        }
                    }

                    /* renamed from: com.kwad.sdk.core.c.b$1$4 */
                    public class AnonymousClass4 implements com.kwad.sdk.f.a<c> {
                        final /* synthetic */ Activity nS;

                        public AnonymousClass4(Activity activity2) {
                            activity = activity2;
                        }

                        @Override // com.kwad.sdk.f.a
                        /* renamed from: c */
                        public void accept(c cVar) {
                            cVar.b(activity);
                        }
                    }

                    /* renamed from: com.kwad.sdk.core.c.b$1$5 */
                    public class AnonymousClass5 implements com.kwad.sdk.f.a<c> {
                        public AnonymousClass5() {
                        }

                        private static void c(c cVar) {
                            cVar.onBackToForeground();
                        }

                        @Override // com.kwad.sdk.f.a
                        public final /* synthetic */ void accept(c cVar) {
                            c(cVar);
                        }
                    }

                    /* renamed from: com.kwad.sdk.core.c.b$1$6 */
                    public class AnonymousClass6 implements com.kwad.sdk.f.a<c> {
                        public AnonymousClass6() {
                        }

                        private static void c(c cVar) {
                            cVar.onBackToBackground();
                        }

                        @Override // com.kwad.sdk.f.a
                        public final /* synthetic */ void accept(c cVar) {
                            c(cVar);
                        }
                    }

                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityCreated(Activity activity2, Bundle bundle2) {
                        b bVar = b.this;
                        b.c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.1
                            final /* synthetic */ Bundle azh;
                            final /* synthetic */ Activity nS;

                            public C04861(Activity activity22, Bundle bundle22) {
                                activity = activity22;
                                bundle = bundle22;
                            }

                            @Override // com.kwad.sdk.f.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.a(activity, bundle);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityDestroyed(Activity activity2) {
                        b bVar = b.this;
                        b.c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.4
                            final /* synthetic */ Activity nS;

                            public AnonymousClass4(Activity activity22) {
                                activity = activity22;
                            }

                            @Override // com.kwad.sdk.f.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.b(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityPaused(Activity activity2) {
                        b bVar = b.this;
                        b.c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.3
                            final /* synthetic */ Activity nS;

                            public AnonymousClass3(Activity activity22) {
                                activity = activity22;
                            }

                            @Override // com.kwad.sdk.f.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.c(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityResumed(Activity activity2) {
                        b bVar = b.this;
                        b.c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.2
                            final /* synthetic */ Activity nS;

                            public AnonymousClass2(Activity activity22) {
                                activity = activity22;
                            }

                            @Override // com.kwad.sdk.f.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.d(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToBackground() {
                        com.kwad.sdk.core.d.c.T("LifecycleHolder", "onBackToBackground");
                        b bVar = b.this;
                        b.c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.6
                            public AnonymousClass6() {
                            }

                            private static void c(c cVar) {
                                cVar.onBackToBackground();
                            }

                            @Override // com.kwad.sdk.f.a
                            public final /* synthetic */ void accept(c cVar) {
                                c(cVar);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToForeground() {
                        com.kwad.sdk.core.d.c.T("LifecycleHolder", "onBackToForeground");
                        b bVar = b.this;
                        b.c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.1.5
                            public AnonymousClass5() {
                            }

                            private static void c(c cVar) {
                                cVar.onBackToForeground();
                            }

                            @Override // com.kwad.sdk.f.a
                            public final /* synthetic */ void accept(c cVar) {
                                c(cVar);
                            }
                        });
                    }
                });
            } else {
                com.kwad.sdk.core.d.c.T("LifecycleHolder", "init KSLifecycleObserver not support");
            }
        } catch (Throwable unused) {
        }
        Application Qa = m.Qa();
        if (Qa != null) {
            this.mApplication = Qa;
            a.Fg().init(this.mApplication);
            a.Fg().a(this);
        }
    }

    @Override // com.kwad.sdk.core.c.c
    public final void onBackToBackground() {
        com.kwad.sdk.core.d.c.T("LifecycleHolder", "onBackToBackground old");
        c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.7
            public AnonymousClass7() {
            }

            private static void c(c cVar) {
                cVar.onBackToBackground();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.c.c
    public final void onBackToForeground() {
        com.kwad.sdk.core.d.c.T("LifecycleHolder", "onBackToForeground old");
        c((com.kwad.sdk.f.a<c>) new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.c.b.6
            public AnonymousClass6() {
            }

            private static void c(c cVar) {
                cVar.onBackToForeground();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }

    public static void b(c cVar) {
        mListeners.remove(cVar);
    }

    public static <T> void c(com.kwad.sdk.f.a<c> aVar) {
        for (c cVar : mListeners) {
            if (cVar != null) {
                aVar.accept(cVar);
            }
        }
    }

    public static void a(c cVar) {
        mListeners.add(cVar);
    }
}
