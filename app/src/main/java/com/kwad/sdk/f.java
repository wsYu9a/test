package com.kwad.sdk;

/* loaded from: classes3.dex */
public final class f {
    private volatile boolean anN = false;
    private com.kwad.sdk.f.a anO;

    /* renamed from: com.kwad.sdk.f$1 */
    public class AnonymousClass1 implements com.kwad.sdk.f.a {
        final /* synthetic */ long anP;

        public AnonymousClass1(long j10) {
            j10 = j10;
        }

        @Override // com.kwad.sdk.f.a
        public final void accept(Object obj) {
            m.ad(j10);
        }
    }

    /* renamed from: com.kwad.sdk.f$2 */
    public class AnonymousClass2 implements com.kwad.sdk.f.a {
        final /* synthetic */ long NU;

        public AnonymousClass2(long j10) {
            j10 = j10;
        }

        @Override // com.kwad.sdk.f.a
        public final void accept(Object obj) {
            m.ae(j10);
        }
    }

    /* renamed from: com.kwad.sdk.f$3 */
    public class AnonymousClass3 implements com.kwad.sdk.f.a {
        final /* synthetic */ long anP;

        public AnonymousClass3(long j10) {
            j10 = j10;
        }

        @Override // com.kwad.sdk.f.a
        public final void accept(Object obj) {
            m.ah(j10);
        }
    }

    /* renamed from: com.kwad.sdk.f$4 */
    public class AnonymousClass4 implements com.kwad.sdk.f.a {
        final /* synthetic */ long NU;

        public AnonymousClass4(long j10) {
            j10 = j10;
        }

        @Override // com.kwad.sdk.f.a
        public final void accept(Object obj) {
            m.ai(j10);
        }
    }

    private f(com.kwad.sdk.f.a aVar) {
        this.anO = aVar;
    }

    public static f X(long j10) {
        return d(new com.kwad.sdk.f.a() { // from class: com.kwad.sdk.f.1
            final /* synthetic */ long anP;

            public AnonymousClass1(long j102) {
                j10 = j102;
            }

            @Override // com.kwad.sdk.f.a
            public final void accept(Object obj) {
                m.ad(j10);
            }
        });
    }

    public static f Y(long j10) {
        return d(new com.kwad.sdk.f.a() { // from class: com.kwad.sdk.f.2
            final /* synthetic */ long NU;

            public AnonymousClass2(long j102) {
                j10 = j102;
            }

            @Override // com.kwad.sdk.f.a
            public final void accept(Object obj) {
                m.ae(j10);
            }
        });
    }

    public static f Z(long j10) {
        return d(new com.kwad.sdk.f.a() { // from class: com.kwad.sdk.f.3
            final /* synthetic */ long anP;

            public AnonymousClass3(long j102) {
                j10 = j102;
            }

            @Override // com.kwad.sdk.f.a
            public final void accept(Object obj) {
                m.ah(j10);
            }
        });
    }

    public static f aa(long j10) {
        return d(new com.kwad.sdk.f.a() { // from class: com.kwad.sdk.f.4
            final /* synthetic */ long NU;

            public AnonymousClass4(long j102) {
                j10 = j102;
            }

            @Override // com.kwad.sdk.f.a
            public final void accept(Object obj) {
                m.ai(j10);
            }
        });
    }

    private static f d(com.kwad.sdk.f.a aVar) {
        return new f(aVar);
    }

    public final synchronized void report() {
        if (this.anO != null && !this.anN) {
            this.anO.accept(null);
            this.anN = true;
        }
    }
}
