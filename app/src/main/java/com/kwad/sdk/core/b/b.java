package com.kwad.sdk.core.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KSLifecycleListener;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.bj;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class b implements c<Activity> {
    private static volatile b afQ;
    private static final List<c> mListeners = new CopyOnWriteArrayList();
    private final AtomicBoolean Ip = new AtomicBoolean(false);

    @Nullable
    private Application mApplication;

    /* renamed from: com.kwad.sdk.core.b.b$1 */
    final class AnonymousClass1 implements KSLifecycleListener {

        /* renamed from: com.kwad.sdk.core.b.b$1$1 */
        final class C02081 implements com.kwad.sdk.e.a<c> {
            final /* synthetic */ Bundle afS;
            final /* synthetic */ Activity mW;

            C02081(Activity activity, Bundle bundle) {
                activity = activity;
                bundle = bundle;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityCreated(activity, bundle);
            }
        }

        /* renamed from: com.kwad.sdk.core.b.b$1$2 */
        final class AnonymousClass2 implements com.kwad.sdk.e.a<c> {
            final /* synthetic */ Activity mW;

            AnonymousClass2(Activity activity) {
                activity = activity;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityResumed(activity);
            }
        }

        /* renamed from: com.kwad.sdk.core.b.b$1$3 */
        final class AnonymousClass3 implements com.kwad.sdk.e.a<c> {
            final /* synthetic */ Activity mW;

            AnonymousClass3(Activity activity) {
                activity = activity;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityPaused(activity);
            }
        }

        /* renamed from: com.kwad.sdk.core.b.b$1$4 */
        final class AnonymousClass4 implements com.kwad.sdk.e.a<c> {
            final /* synthetic */ Activity mW;

            AnonymousClass4(Activity activity) {
                activity = activity;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityDestroyed(activity);
            }
        }

        /* renamed from: com.kwad.sdk.core.b.b$1$5 */
        final class AnonymousClass5 implements com.kwad.sdk.e.a<c> {
            AnonymousClass5() {
            }

            private static void c(c cVar) {
                cVar.onBackToForeground();
            }

            @Override // com.kwad.sdk.e.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        }

        /* renamed from: com.kwad.sdk.core.b.b$1$6 */
        final class AnonymousClass6 implements com.kwad.sdk.e.a<c> {
            AnonymousClass6() {
            }

            private static void c(c cVar) {
                cVar.onBackToBackground();
            }

            @Override // com.kwad.sdk.e.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.core.KSLifecycleListener
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            b bVar = b.this;
            b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.1
                final /* synthetic */ Bundle afS;
                final /* synthetic */ Activity mW;

                C02081(Activity activity2, Bundle bundle2) {
                    activity = activity2;
                    bundle = bundle2;
                }

                @Override // com.kwad.sdk.e.a
                /* renamed from: c */
                public void accept(c cVar) {
                    cVar.onActivityCreated(activity, bundle);
                }
            });
        }

        @Override // com.kwad.sdk.api.core.KSLifecycleListener
        public final void onActivityDestroyed(Activity activity) {
            b bVar = b.this;
            b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.4
                final /* synthetic */ Activity mW;

                AnonymousClass4(Activity activity2) {
                    activity = activity2;
                }

                @Override // com.kwad.sdk.e.a
                /* renamed from: c */
                public void accept(c cVar) {
                    cVar.onActivityDestroyed(activity);
                }
            });
        }

        @Override // com.kwad.sdk.api.core.KSLifecycleListener
        public final void onActivityPaused(Activity activity) {
            b bVar = b.this;
            b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.3
                final /* synthetic */ Activity mW;

                AnonymousClass3(Activity activity2) {
                    activity = activity2;
                }

                @Override // com.kwad.sdk.e.a
                /* renamed from: c */
                public void accept(c cVar) {
                    cVar.onActivityPaused(activity);
                }
            });
        }

        @Override // com.kwad.sdk.api.core.KSLifecycleListener
        public final void onActivityResumed(Activity activity) {
            b bVar = b.this;
            b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.2
                final /* synthetic */ Activity mW;

                AnonymousClass2(Activity activity2) {
                    activity = activity2;
                }

                @Override // com.kwad.sdk.e.a
                /* renamed from: c */
                public void accept(c cVar) {
                    cVar.onActivityResumed(activity);
                }
            });
        }

        @Override // com.kwad.sdk.api.core.KSLifecycleListener
        public final void onBackToBackground() {
            com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToBackground");
            b bVar = b.this;
            b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.6
                AnonymousClass6() {
                }

                private static void c(c cVar) {
                    cVar.onBackToBackground();
                }

                @Override // com.kwad.sdk.e.a
                public final /* synthetic */ void accept(c cVar) {
                    c(cVar);
                }
            });
        }

        @Override // com.kwad.sdk.api.core.KSLifecycleListener
        public final void onBackToForeground() {
            com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToForeground");
            b bVar = b.this;
            b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.5
                AnonymousClass5() {
                }

                private static void c(c cVar) {
                    cVar.onBackToForeground();
                }

                @Override // com.kwad.sdk.e.a
                public final /* synthetic */ void accept(c cVar) {
                    c(cVar);
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.core.b.b$2 */
    final class AnonymousClass2 implements com.kwad.sdk.e.a<c> {
        final /* synthetic */ Bundle afS;
        final /* synthetic */ Activity mW;

        AnonymousClass2(Activity activity, Bundle bundle) {
            activity = activity;
            bundle = bundle;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: c */
        public void accept(c cVar) {
            cVar.onActivityCreated(activity, bundle);
        }
    }

    /* renamed from: com.kwad.sdk.core.b.b$3 */
    final class AnonymousClass3 implements com.kwad.sdk.e.a<c> {
        final /* synthetic */ Activity mW;

        AnonymousClass3(Activity activity) {
            activity = activity;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: c */
        public void accept(c cVar) {
            cVar.onActivityResumed(activity);
        }
    }

    /* renamed from: com.kwad.sdk.core.b.b$4 */
    final class AnonymousClass4 implements com.kwad.sdk.e.a<c> {
        final /* synthetic */ Activity mW;

        AnonymousClass4(Activity activity) {
            activity = activity;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: c */
        public void accept(c cVar) {
            cVar.onActivityPaused(activity);
        }
    }

    /* renamed from: com.kwad.sdk.core.b.b$5 */
    final class AnonymousClass5 implements com.kwad.sdk.e.a<c> {
        final /* synthetic */ Activity mW;

        AnonymousClass5(Activity activity) {
            activity = activity;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: c */
        public void accept(c cVar) {
            cVar.onActivityDestroyed(activity);
        }
    }

    /* renamed from: com.kwad.sdk.core.b.b$6 */
    final class AnonymousClass6 implements com.kwad.sdk.e.a<c> {
        AnonymousClass6() {
        }

        private static void c(c cVar) {
            cVar.onBackToForeground();
        }

        @Override // com.kwad.sdk.e.a
        public final /* synthetic */ void accept(c cVar) {
            c(cVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.b.b$7 */
    final class AnonymousClass7 implements com.kwad.sdk.e.a<c> {
        AnonymousClass7() {
        }

        private static void c(c cVar) {
            cVar.onBackToBackground();
        }

        @Override // com.kwad.sdk.e.a
        public final /* synthetic */ void accept(c cVar) {
            c(cVar);
        }
    }

    private b() {
    }

    public static void a(c cVar) {
        mListeners.add(cVar);
    }

    public static <T> void a(com.kwad.sdk.e.a<c> aVar) {
        for (c cVar : mListeners) {
            if (cVar != null) {
                aVar.accept(cVar);
            }
        }
    }

    public static void b(c cVar) {
        mListeners.remove(cVar);
    }

    @Nullable
    public static Activity getCurrentActivity() {
        if (vT()) {
            return KSLifecycleObserver.getInstance().getCurrentActivity();
        }
        if (a.vQ().isEnable()) {
            return a.vQ().getCurrentActivity();
        }
        return null;
    }

    public static boolean isAppOnForeground() {
        if (vT()) {
            return KSLifecycleObserver.getInstance().isAppOnForeground();
        }
        if (a.vQ().isEnable()) {
            return a.vQ().isAppOnForeground();
        }
        return false;
    }

    public static boolean isEnable() {
        return vT() || a.vQ().isEnable();
    }

    @Override // com.kwad.sdk.core.b.c
    public void onActivityCreated(Activity activity, Bundle bundle) {
        a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.2
            final /* synthetic */ Bundle afS;
            final /* synthetic */ Activity mW;

            AnonymousClass2(Activity activity2, Bundle bundle2) {
                activity = activity2;
                bundle = bundle2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityCreated(activity, bundle);
            }
        });
    }

    @Override // com.kwad.sdk.core.b.c
    public void onActivityDestroyed(Activity activity) {
        a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.5
            final /* synthetic */ Activity mW;

            AnonymousClass5(Activity activity2) {
                activity = activity2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityDestroyed(activity);
            }
        });
    }

    @Override // com.kwad.sdk.core.b.c
    public void onActivityPaused(Activity activity) {
        a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.4
            final /* synthetic */ Activity mW;

            AnonymousClass4(Activity activity2) {
                activity = activity2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityPaused(activity);
            }
        });
    }

    @Override // com.kwad.sdk.core.b.c
    public void onActivityResumed(Activity activity) {
        a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.3
            final /* synthetic */ Activity mW;

            AnonymousClass3(Activity activity2) {
                activity = activity2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityResumed(activity);
            }
        });
    }

    public static b vS() {
        if (afQ == null) {
            synchronized (b.class) {
                if (afQ == null) {
                    afQ = new b();
                }
            }
        }
        return afQ;
    }

    public static boolean vT() {
        try {
            if (bj.aj(((e) ServiceProvider.get(e.class)).getApiVersion(), "3.3.26")) {
                return KSLifecycleObserver.getInstance().isEnable();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Nullable
    public final Application getApplication() {
        return this.mApplication;
    }

    public final void init(Context context) {
        if (this.Ip.get() || context == null) {
            return;
        }
        this.Ip.set(true);
        try {
            if (bj.aj(((e) ServiceProvider.get(e.class)).getApiVersion(), "3.3.26")) {
                this.mApplication = KSLifecycleObserver.getInstance().getApplication();
                KSLifecycleObserver.getInstance().registerLifecycleListener(new KSLifecycleListener() { // from class: com.kwad.sdk.core.b.b.1

                    /* renamed from: com.kwad.sdk.core.b.b$1$1 */
                    final class C02081 implements com.kwad.sdk.e.a<c> {
                        final /* synthetic */ Bundle afS;
                        final /* synthetic */ Activity mW;

                        C02081(Activity activity2, Bundle bundle2) {
                            activity = activity2;
                            bundle = bundle2;
                        }

                        @Override // com.kwad.sdk.e.a
                        /* renamed from: c */
                        public void accept(c cVar) {
                            cVar.onActivityCreated(activity, bundle);
                        }
                    }

                    /* renamed from: com.kwad.sdk.core.b.b$1$2 */
                    final class AnonymousClass2 implements com.kwad.sdk.e.a<c> {
                        final /* synthetic */ Activity mW;

                        AnonymousClass2(Activity activity2) {
                            activity = activity2;
                        }

                        @Override // com.kwad.sdk.e.a
                        /* renamed from: c */
                        public void accept(c cVar) {
                            cVar.onActivityResumed(activity);
                        }
                    }

                    /* renamed from: com.kwad.sdk.core.b.b$1$3 */
                    final class AnonymousClass3 implements com.kwad.sdk.e.a<c> {
                        final /* synthetic */ Activity mW;

                        AnonymousClass3(Activity activity2) {
                            activity = activity2;
                        }

                        @Override // com.kwad.sdk.e.a
                        /* renamed from: c */
                        public void accept(c cVar) {
                            cVar.onActivityPaused(activity);
                        }
                    }

                    /* renamed from: com.kwad.sdk.core.b.b$1$4 */
                    final class AnonymousClass4 implements com.kwad.sdk.e.a<c> {
                        final /* synthetic */ Activity mW;

                        AnonymousClass4(Activity activity2) {
                            activity = activity2;
                        }

                        @Override // com.kwad.sdk.e.a
                        /* renamed from: c */
                        public void accept(c cVar) {
                            cVar.onActivityDestroyed(activity);
                        }
                    }

                    /* renamed from: com.kwad.sdk.core.b.b$1$5 */
                    final class AnonymousClass5 implements com.kwad.sdk.e.a<c> {
                        AnonymousClass5() {
                        }

                        private static void c(c cVar) {
                            cVar.onBackToForeground();
                        }

                        @Override // com.kwad.sdk.e.a
                        public final /* synthetic */ void accept(c cVar) {
                            c(cVar);
                        }
                    }

                    /* renamed from: com.kwad.sdk.core.b.b$1$6 */
                    final class AnonymousClass6 implements com.kwad.sdk.e.a<c> {
                        AnonymousClass6() {
                        }

                        private static void c(c cVar) {
                            cVar.onBackToBackground();
                        }

                        @Override // com.kwad.sdk.e.a
                        public final /* synthetic */ void accept(c cVar) {
                            c(cVar);
                        }
                    }

                    AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityCreated(Activity activity2, Bundle bundle2) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.1
                            final /* synthetic */ Bundle afS;
                            final /* synthetic */ Activity mW;

                            C02081(Activity activity22, Bundle bundle22) {
                                activity = activity22;
                                bundle = bundle22;
                            }

                            @Override // com.kwad.sdk.e.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.onActivityCreated(activity, bundle);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityDestroyed(Activity activity2) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.4
                            final /* synthetic */ Activity mW;

                            AnonymousClass4(Activity activity22) {
                                activity = activity22;
                            }

                            @Override // com.kwad.sdk.e.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.onActivityDestroyed(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityPaused(Activity activity2) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.3
                            final /* synthetic */ Activity mW;

                            AnonymousClass3(Activity activity22) {
                                activity = activity22;
                            }

                            @Override // com.kwad.sdk.e.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.onActivityPaused(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityResumed(Activity activity2) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.2
                            final /* synthetic */ Activity mW;

                            AnonymousClass2(Activity activity22) {
                                activity = activity22;
                            }

                            @Override // com.kwad.sdk.e.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.onActivityResumed(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToBackground() {
                        com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToBackground");
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.6
                            AnonymousClass6() {
                            }

                            private static void c(c cVar) {
                                cVar.onBackToBackground();
                            }

                            @Override // com.kwad.sdk.e.a
                            public final /* synthetic */ void accept(c cVar) {
                                c(cVar);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToForeground() {
                        com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToForeground");
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.5
                            AnonymousClass5() {
                            }

                            private static void c(c cVar) {
                                cVar.onBackToForeground();
                            }

                            @Override // com.kwad.sdk.e.a
                            public final /* synthetic */ void accept(c cVar) {
                                c(cVar);
                            }
                        });
                    }
                });
            } else {
                com.kwad.sdk.core.d.b.z("LifecycleHolder", "init KSLifecycleObserver not support");
            }
        } catch (Throwable unused) {
        }
        Application FP = k.FP();
        if (FP != null) {
            this.mApplication = FP;
            a.vQ().init(this.mApplication);
            a.vQ().a(this);
        }
    }

    @Override // com.kwad.sdk.core.b.c
    public void onBackToBackground() {
        com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToBackground old");
        a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.7
            AnonymousClass7() {
            }

            private static void c(c cVar) {
                cVar.onBackToBackground();
            }

            @Override // com.kwad.sdk.e.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.b.c
    public void onBackToForeground() {
        com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToForeground old");
        a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.6
            AnonymousClass6() {
            }

            private static void c(c cVar) {
                cVar.onBackToForeground();
            }

            @Override // com.kwad.sdk.e.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }
}
