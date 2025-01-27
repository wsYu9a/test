package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.m;
import com.umeng.analytics.pro.am;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class u {
    private static final AtomicBoolean aaE = new AtomicBoolean();

    /* renamed from: com.kwad.sdk.api.loader.u$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ IKsAdSDK aaF;
        final /* synthetic */ Context jN;

        /* renamed from: com.kwad.sdk.api.loader.u$1$1 */
        final class C02031 implements v {
            C02031() {
            }

            @Override // com.kwad.sdk.api.loader.v
            public final Context getContext() {
                return context;
            }

            @Override // com.kwad.sdk.api.loader.v
            public final String tx() {
                return u.tw();
            }

            @Override // com.kwad.sdk.api.loader.v
            public final IKsAdSDK ty() {
                return iKsAdSDK;
            }
        }

        /* renamed from: com.kwad.sdk.api.loader.u$1$2 */
        final class AnonymousClass2 implements m.c<Boolean> {
            AnonymousClass2() {
            }

            private static void a(Boolean bool) {
                new StringBuilder("onNewResult: ").append(bool);
            }

            @Override // com.kwad.sdk.api.loader.m.c
            public final /* synthetic */ void b(Boolean bool) {
                a(bool);
            }
        }

        AnonymousClass1(Context context, IKsAdSDK iKsAdSDK) {
            context = context;
            iKsAdSDK = iKsAdSDK;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (Math.abs(System.currentTimeMillis() - t.s(context, "lastUpdateTime")) < t.s(context, am.aU) * 1000) {
                    return;
                }
                m.tu().a(new v() { // from class: com.kwad.sdk.api.loader.u.1.1
                    C02031() {
                    }

                    @Override // com.kwad.sdk.api.loader.v
                    public final Context getContext() {
                        return context;
                    }

                    @Override // com.kwad.sdk.api.loader.v
                    public final String tx() {
                        return u.tw();
                    }

                    @Override // com.kwad.sdk.api.loader.v
                    public final IKsAdSDK ty() {
                        return iKsAdSDK;
                    }
                }, new m.c<Boolean>() { // from class: com.kwad.sdk.api.loader.u.1.2
                    AnonymousClass2() {
                    }

                    private static void a(Boolean bool) {
                        new StringBuilder("onNewResult: ").append(bool);
                    }

                    @Override // com.kwad.sdk.api.loader.m.c
                    public final /* synthetic */ void b(Boolean bool) {
                        a(bool);
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, IKsAdSDK iKsAdSDK) {
        if (com.kwad.sdk.api.c.tj()) {
            return;
        }
        AtomicBoolean atomicBoolean = aaE;
        if (atomicBoolean.get() || context == null || iKsAdSDK == null) {
            return;
        }
        atomicBoolean.set(true);
        com.kwad.sdk.api.kwai.a.submit(new Runnable() { // from class: com.kwad.sdk.api.loader.u.1
            final /* synthetic */ IKsAdSDK aaF;
            final /* synthetic */ Context jN;

            /* renamed from: com.kwad.sdk.api.loader.u$1$1 */
            final class C02031 implements v {
                C02031() {
                }

                @Override // com.kwad.sdk.api.loader.v
                public final Context getContext() {
                    return context;
                }

                @Override // com.kwad.sdk.api.loader.v
                public final String tx() {
                    return u.tw();
                }

                @Override // com.kwad.sdk.api.loader.v
                public final IKsAdSDK ty() {
                    return iKsAdSDK;
                }
            }

            /* renamed from: com.kwad.sdk.api.loader.u$1$2 */
            final class AnonymousClass2 implements m.c<Boolean> {
                AnonymousClass2() {
                }

                private static void a(Boolean bool) {
                    new StringBuilder("onNewResult: ").append(bool);
                }

                @Override // com.kwad.sdk.api.loader.m.c
                public final /* synthetic */ void b(Boolean bool) {
                    a(bool);
                }
            }

            AnonymousClass1(Context context2, IKsAdSDK iKsAdSDK2) {
                context = context2;
                iKsAdSDK = iKsAdSDK2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (Math.abs(System.currentTimeMillis() - t.s(context, "lastUpdateTime")) < t.s(context, am.aU) * 1000) {
                        return;
                    }
                    m.tu().a(new v() { // from class: com.kwad.sdk.api.loader.u.1.1
                        C02031() {
                        }

                        @Override // com.kwad.sdk.api.loader.v
                        public final Context getContext() {
                            return context;
                        }

                        @Override // com.kwad.sdk.api.loader.v
                        public final String tx() {
                            return u.tw();
                        }

                        @Override // com.kwad.sdk.api.loader.v
                        public final IKsAdSDK ty() {
                            return iKsAdSDK;
                        }
                    }, new m.c<Boolean>() { // from class: com.kwad.sdk.api.loader.u.1.2
                        AnonymousClass2() {
                        }

                        private static void a(Boolean bool) {
                            new StringBuilder("onNewResult: ").append(bool);
                        }

                        @Override // com.kwad.sdk.api.loader.m.c
                        public final /* synthetic */ void b(Boolean bool) {
                            a(bool);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void au(Context context) {
        g.h(context, "");
    }

    public static String tw() {
        String aZ = com.kwad.sdk.api.c.aZ("https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
        return !TextUtils.isEmpty(aZ) ? aZ : "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
    }
}
