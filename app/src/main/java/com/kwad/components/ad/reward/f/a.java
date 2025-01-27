package com.kwad.components.ad.reward.f;

import androidx.annotation.NonNull;
import com.kwad.components.core.video.g;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.l.a<g> {
    private IAdLivePlayModule go;

    /* renamed from: te */
    private List<g> f11671te;

    /* renamed from: tf */
    private long f11672tf;

    /* renamed from: tg */
    private AdLivePlayStateListener f11673tg;

    /* renamed from: com.kwad.components.ad.reward.f.a$1 */
    public class AnonymousClass1 implements AdLivePlayStateListener {

        /* renamed from: com.kwad.components.ad.reward.f.a$1$1 */
        public class C03951 implements com.kwad.sdk.f.a<g> {
            public C03951() {
            }

            private static void c(g gVar) {
                gVar.onMediaPrepared();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(g gVar) {
                c(gVar);
            }
        }

        /* renamed from: com.kwad.components.ad.reward.f.a$1$2 */
        public class AnonymousClass2 implements com.kwad.sdk.f.a<g> {

            /* renamed from: tj */
            final /* synthetic */ long f11677tj;

            public AnonymousClass2(long j10) {
                j10 = j10;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(g gVar) {
                gVar.onMediaPlayProgress(a.this.f11672tf, j10);
            }
        }

        /* renamed from: com.kwad.components.ad.reward.f.a$1$3 */
        public class AnonymousClass3 implements com.kwad.sdk.f.a<g> {
            public AnonymousClass3() {
            }

            private static void c(g gVar) {
                gVar.onMediaPlayStart();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(g gVar) {
                c(gVar);
            }
        }

        /* renamed from: com.kwad.components.ad.reward.f.a$1$4 */
        public class AnonymousClass4 implements com.kwad.sdk.f.a<g> {
            public AnonymousClass4() {
            }

            private static void c(g gVar) {
                gVar.onLivePlayResume();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(g gVar) {
                c(gVar);
            }
        }

        /* renamed from: com.kwad.components.ad.reward.f.a$1$5 */
        public class AnonymousClass5 implements com.kwad.sdk.f.a<g> {
            public AnonymousClass5() {
            }

            private static void c(g gVar) {
                gVar.onMediaPlayPaused();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(g gVar) {
                c(gVar);
            }
        }

        /* renamed from: com.kwad.components.ad.reward.f.a$1$6 */
        public class AnonymousClass6 implements com.kwad.sdk.f.a<g> {
            public AnonymousClass6() {
            }

            private static void c(g gVar) {
                gVar.onMediaPlayCompleted();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(g gVar) {
                c(gVar);
            }
        }

        /* renamed from: com.kwad.components.ad.reward.f.a$1$7 */
        public class AnonymousClass7 implements com.kwad.sdk.f.a<g> {
            public AnonymousClass7() {
            }

            private static void c(g gVar) {
                gVar.onLivePlayEnd();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(g gVar) {
                c(gVar);
            }
        }

        /* renamed from: com.kwad.components.ad.reward.f.a$1$8 */
        public class AnonymousClass8 implements com.kwad.sdk.f.a<g> {

            /* renamed from: tk */
            final /* synthetic */ boolean f11684tk;

            public AnonymousClass8(boolean z10) {
                z10 = z10;
            }

            @Override // com.kwad.sdk.f.a
            public final /* bridge */ /* synthetic */ void accept(g gVar) {
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLiveAudioEnableChange(boolean z10) {
            a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.8

                /* renamed from: tk */
                final /* synthetic */ boolean f11684tk;

                public AnonymousClass8(boolean z102) {
                    z10 = z102;
                }

                @Override // com.kwad.sdk.f.a
                public final /* bridge */ /* synthetic */ void accept(g gVar) {
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.6
                public AnonymousClass6() {
                }

                private static void c(g gVar) {
                    gVar.onMediaPlayCompleted();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(g gVar) {
                    c(gVar);
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.7
                public AnonymousClass7() {
                }

                private static void c(g gVar) {
                    gVar.onLivePlayEnd();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(g gVar) {
                    c(gVar);
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayPause() {
            a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.5
                public AnonymousClass5() {
                }

                private static void c(g gVar) {
                    gVar.onMediaPlayPaused();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(g gVar) {
                    c(gVar);
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j10) {
            a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.2

                /* renamed from: tj */
                final /* synthetic */ long f11677tj;

                public AnonymousClass2(long j102) {
                    j10 = j102;
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: c */
                public void accept(g gVar) {
                    gVar.onMediaPlayProgress(a.this.f11672tf, j10);
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.4
                public AnonymousClass4() {
                }

                private static void c(g gVar) {
                    gVar.onLivePlayResume();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(g gVar) {
                    c(gVar);
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.3
                public AnonymousClass3() {
                }

                private static void c(g gVar) {
                    gVar.onMediaPlayStart();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(g gVar) {
                    c(gVar);
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePrepared() {
            a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.1
                public C03951() {
                }

                private static void c(g gVar) {
                    gVar.onMediaPrepared();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(g gVar) {
                    c(gVar);
                }
            });
        }
    }

    public a(@NonNull AdTemplate adTemplate, IAdLivePlayModule iAdLivePlayModule) {
        super(adTemplate);
        this.f11671te = new CopyOnWriteArrayList();
        this.f11672tf = 30000L;
        this.f11673tg = new AdLivePlayStateListener() { // from class: com.kwad.components.ad.reward.f.a.1

            /* renamed from: com.kwad.components.ad.reward.f.a$1$1 */
            public class C03951 implements com.kwad.sdk.f.a<g> {
                public C03951() {
                }

                private static void c(g gVar) {
                    gVar.onMediaPrepared();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(g gVar) {
                    c(gVar);
                }
            }

            /* renamed from: com.kwad.components.ad.reward.f.a$1$2 */
            public class AnonymousClass2 implements com.kwad.sdk.f.a<g> {

                /* renamed from: tj */
                final /* synthetic */ long f11677tj;

                public AnonymousClass2(long j102) {
                    j10 = j102;
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: c */
                public void accept(g gVar) {
                    gVar.onMediaPlayProgress(a.this.f11672tf, j10);
                }
            }

            /* renamed from: com.kwad.components.ad.reward.f.a$1$3 */
            public class AnonymousClass3 implements com.kwad.sdk.f.a<g> {
                public AnonymousClass3() {
                }

                private static void c(g gVar) {
                    gVar.onMediaPlayStart();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(g gVar) {
                    c(gVar);
                }
            }

            /* renamed from: com.kwad.components.ad.reward.f.a$1$4 */
            public class AnonymousClass4 implements com.kwad.sdk.f.a<g> {
                public AnonymousClass4() {
                }

                private static void c(g gVar) {
                    gVar.onLivePlayResume();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(g gVar) {
                    c(gVar);
                }
            }

            /* renamed from: com.kwad.components.ad.reward.f.a$1$5 */
            public class AnonymousClass5 implements com.kwad.sdk.f.a<g> {
                public AnonymousClass5() {
                }

                private static void c(g gVar) {
                    gVar.onMediaPlayPaused();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(g gVar) {
                    c(gVar);
                }
            }

            /* renamed from: com.kwad.components.ad.reward.f.a$1$6 */
            public class AnonymousClass6 implements com.kwad.sdk.f.a<g> {
                public AnonymousClass6() {
                }

                private static void c(g gVar) {
                    gVar.onMediaPlayCompleted();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(g gVar) {
                    c(gVar);
                }
            }

            /* renamed from: com.kwad.components.ad.reward.f.a$1$7 */
            public class AnonymousClass7 implements com.kwad.sdk.f.a<g> {
                public AnonymousClass7() {
                }

                private static void c(g gVar) {
                    gVar.onLivePlayEnd();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(g gVar) {
                    c(gVar);
                }
            }

            /* renamed from: com.kwad.components.ad.reward.f.a$1$8 */
            public class AnonymousClass8 implements com.kwad.sdk.f.a<g> {

                /* renamed from: tk */
                final /* synthetic */ boolean f11684tk;

                public AnonymousClass8(boolean z102) {
                    z10 = z102;
                }

                @Override // com.kwad.sdk.f.a
                public final /* bridge */ /* synthetic */ void accept(g gVar) {
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLiveAudioEnableChange(boolean z102) {
                a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.8

                    /* renamed from: tk */
                    final /* synthetic */ boolean f11684tk;

                    public AnonymousClass8(boolean z1022) {
                        z10 = z1022;
                    }

                    @Override // com.kwad.sdk.f.a
                    public final /* bridge */ /* synthetic */ void accept(g gVar) {
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.6
                    public AnonymousClass6() {
                    }

                    private static void c(g gVar) {
                        gVar.onMediaPlayCompleted();
                    }

                    @Override // com.kwad.sdk.f.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.7
                    public AnonymousClass7() {
                    }

                    private static void c(g gVar) {
                        gVar.onLivePlayEnd();
                    }

                    @Override // com.kwad.sdk.f.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.5
                    public AnonymousClass5() {
                    }

                    private static void c(g gVar) {
                        gVar.onMediaPlayPaused();
                    }

                    @Override // com.kwad.sdk.f.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j102) {
                a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.2

                    /* renamed from: tj */
                    final /* synthetic */ long f11677tj;

                    public AnonymousClass2(long j1022) {
                        j10 = j1022;
                    }

                    @Override // com.kwad.sdk.f.a
                    /* renamed from: c */
                    public void accept(g gVar) {
                        gVar.onMediaPlayProgress(a.this.f11672tf, j10);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.4
                    public AnonymousClass4() {
                    }

                    private static void c(g gVar) {
                        gVar.onLivePlayResume();
                    }

                    @Override // com.kwad.sdk.f.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.3
                    public AnonymousClass3() {
                    }

                    private static void c(g gVar) {
                        gVar.onMediaPlayStart();
                    }

                    @Override // com.kwad.sdk.f.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                a.this.a(new com.kwad.sdk.f.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.1
                    public C03951() {
                    }

                    private static void c(g gVar) {
                        gVar.onMediaPrepared();
                    }

                    @Override // com.kwad.sdk.f.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }
        };
        this.go = iAdLivePlayModule;
        if (e.dV(adTemplate) == 2) {
            this.f11672tf = com.kwad.sdk.core.response.b.a.ag(e.eb(adTemplate));
        }
        this.go.registerAdLivePlayStateListener(this.f11673tg);
    }

    private void hp() {
        try {
            this.f11671te.clear();
            this.go.unRegisterAdLivePlayStateListener(this.f11673tg);
            this.go.onDestroy();
        } catch (Throwable th2) {
            c.printStackTraceOnly(th2);
        }
    }

    public final LiveShopItemInfo getCurrentShowShopItemInfo() {
        return this.go.getCurrentShowShopItemInfo();
    }

    @Override // com.kwad.components.ad.l.a
    public final long getPlayDuration() {
        return this.go.getPlayDuration();
    }

    public final void onPause() {
        this.go.onPause();
    }

    public final void onResume() {
        this.go.onResume();
    }

    @Override // com.kwad.components.ad.l.a
    public final void pause() {
        this.go.pause();
    }

    public final void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.go.registerAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    @Override // com.kwad.components.ad.l.a
    public final void release() {
        super.release();
        hp();
    }

    public final void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor) {
        this.go.removeInterceptor(onAdLiveResumeInterceptor);
    }

    @Override // com.kwad.components.ad.l.a
    public final void resume() {
        this.go.resume();
    }

    @Override // com.kwad.components.ad.l.a
    public final void setAudioEnabled(boolean z10, boolean z11) {
        this.go.setAudioEnabled(z10, z11);
    }

    @Override // com.kwad.components.ad.l.a
    public final void skipToEnd() {
        this.go.skipToEnd();
    }

    public final void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.go.unRegisterAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    @Override // com.kwad.components.ad.l.a
    /* renamed from: b */
    public void a(g gVar) {
        if (gVar != null) {
            this.f11671te.remove(gVar);
        }
    }

    public void a(com.kwad.sdk.f.a<g> aVar) {
        if (aVar != null) {
            Iterator<g> it = this.f11671te.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    @Override // com.kwad.components.ad.l.a
    /* renamed from: a */
    public void b(g gVar) {
        if (gVar != null) {
            this.f11671te.add(gVar);
        }
    }
}
