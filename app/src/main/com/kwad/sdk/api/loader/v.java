package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.o;
import com.umeng.analytics.pro.bt;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class v {
    private static final AtomicBoolean aqF = new AtomicBoolean();

    /* renamed from: com.kwad.sdk.api.loader.v$1 */
    public class AnonymousClass1 extends com.kwad.sdk.api.a.b {
        final /* synthetic */ IKsAdSDK aqG;
        final /* synthetic */ Context hB;

        /* renamed from: com.kwad.sdk.api.loader.v$1$1 */
        public class C04781 implements w {
            public C04781() {
            }

            @Override // com.kwad.sdk.api.loader.w
            public final String BH() {
                return v.BG();
            }

            @Override // com.kwad.sdk.api.loader.w
            public final IKsAdSDK BI() {
                return iKsAdSDK;
            }

            @Override // com.kwad.sdk.api.loader.w
            public final Context getContext() {
                return context;
            }
        }

        /* renamed from: com.kwad.sdk.api.loader.v$1$2 */
        public class AnonymousClass2 implements o.c<Boolean> {
            public AnonymousClass2() {
            }

            private static void c(Boolean bool) {
            }

            @Override // com.kwad.sdk.api.loader.o.c
            public final /* synthetic */ void i(Boolean bool) {
                c(bool);
            }
        }

        public AnonymousClass1(Context context, IKsAdSDK iKsAdSDK) {
            context = context;
            iKsAdSDK = iKsAdSDK;
        }

        @Override // com.kwad.sdk.api.a.b
        public final void doTask() {
            try {
                if (Math.abs(System.currentTimeMillis() - b.n(context, "lastUpdateTime")) < b.n(context, bt.f23596ba) * 1000) {
                    return;
                }
                o.BF().a(new w() { // from class: com.kwad.sdk.api.loader.v.1.1
                    public C04781() {
                    }

                    @Override // com.kwad.sdk.api.loader.w
                    public final String BH() {
                        return v.BG();
                    }

                    @Override // com.kwad.sdk.api.loader.w
                    public final IKsAdSDK BI() {
                        return iKsAdSDK;
                    }

                    @Override // com.kwad.sdk.api.loader.w
                    public final Context getContext() {
                        return context;
                    }
                }, new o.c<Boolean>() { // from class: com.kwad.sdk.api.loader.v.1.2
                    public AnonymousClass2() {
                    }

                    private static void c(Boolean bool) {
                    }

                    @Override // com.kwad.sdk.api.loader.o.c
                    public final /* synthetic */ void i(Boolean bool) {
                        c(bool);
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static String BG() {
        String ch2 = com.kwad.sdk.api.c.ch("https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
        return !TextUtils.isEmpty(ch2) ? ch2 : "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
    }

    public static void a(Context context, IKsAdSDK iKsAdSDK) {
        if (com.kwad.sdk.api.c.Bq()) {
            return;
        }
        AtomicBoolean atomicBoolean = aqF;
        if (atomicBoolean.get() || context == null || iKsAdSDK == null) {
            return;
        }
        atomicBoolean.set(true);
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.v.1
            final /* synthetic */ IKsAdSDK aqG;
            final /* synthetic */ Context hB;

            /* renamed from: com.kwad.sdk.api.loader.v$1$1 */
            public class C04781 implements w {
                public C04781() {
                }

                @Override // com.kwad.sdk.api.loader.w
                public final String BH() {
                    return v.BG();
                }

                @Override // com.kwad.sdk.api.loader.w
                public final IKsAdSDK BI() {
                    return iKsAdSDK;
                }

                @Override // com.kwad.sdk.api.loader.w
                public final Context getContext() {
                    return context;
                }
            }

            /* renamed from: com.kwad.sdk.api.loader.v$1$2 */
            public class AnonymousClass2 implements o.c<Boolean> {
                public AnonymousClass2() {
                }

                private static void c(Boolean bool) {
                }

                @Override // com.kwad.sdk.api.loader.o.c
                public final /* synthetic */ void i(Boolean bool) {
                    c(bool);
                }
            }

            public AnonymousClass1(Context context2, IKsAdSDK iKsAdSDK2) {
                context = context2;
                iKsAdSDK = iKsAdSDK2;
            }

            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                try {
                    if (Math.abs(System.currentTimeMillis() - b.n(context, "lastUpdateTime")) < b.n(context, bt.f23596ba) * 1000) {
                        return;
                    }
                    o.BF().a(new w() { // from class: com.kwad.sdk.api.loader.v.1.1
                        public C04781() {
                        }

                        @Override // com.kwad.sdk.api.loader.w
                        public final String BH() {
                            return v.BG();
                        }

                        @Override // com.kwad.sdk.api.loader.w
                        public final IKsAdSDK BI() {
                            return iKsAdSDK;
                        }

                        @Override // com.kwad.sdk.api.loader.w
                        public final Context getContext() {
                            return context;
                        }
                    }, new o.c<Boolean>() { // from class: com.kwad.sdk.api.loader.v.1.2
                        public AnonymousClass2() {
                        }

                        private static void c(Boolean bool) {
                        }

                        @Override // com.kwad.sdk.api.loader.o.c
                        public final /* synthetic */ void i(Boolean bool) {
                            c(bool);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void aW(Context context) {
        i.o(context, "");
    }
}
