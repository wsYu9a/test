package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.common.CommonListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
final class j implements TTAdManager {

    /* renamed from: j */
    static final j f6388j = new j();
    private volatile TTAdManager zx;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$1 */
    class AnonymousClass1 implements zx<TTAdNative> {

        /* renamed from: j */
        TTAdNative f6390j;
        final /* synthetic */ WeakReference zx;

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$1$1 */
        class C00761 implements InterfaceC0077j<TTAdManager> {

            /* renamed from: j */
            final /* synthetic */ InterfaceC0077j f6391j;

            C00761(InterfaceC0077j interfaceC0077j) {
                interfaceC0077j = interfaceC0077j;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdManager tTAdManager) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                anonymousClass1.f6390j = tTAdManager.createAdNative((Context) anonymousClass1.zx.get());
                interfaceC0077j.j(AnonymousClass1.this.f6390j);
            }
        }

        AnonymousClass1(WeakReference weakReference) {
            this.zx = weakReference;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.j.zx
        public void j(InterfaceC0077j<TTAdNative> interfaceC0077j) {
            TTAdNative tTAdNative = this.f6390j;
            if (tTAdNative != null) {
                interfaceC0077j.j(tTAdNative);
            } else {
                j.this.call(new InterfaceC0077j<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.1.1

                    /* renamed from: j */
                    final /* synthetic */ InterfaceC0077j f6391j;

                    C00761(InterfaceC0077j interfaceC0077j2) {
                        interfaceC0077j = interfaceC0077j2;
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                    public void j(TTAdManager tTAdManager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.f6390j = tTAdManager.createAdNative((Context) anonymousClass1.zx.get());
                        interfaceC0077j.j(AnonymousClass1.this.f6390j);
                    }
                });
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$2 */
    class AnonymousClass2 implements InterfaceC0077j<TTAdManager> {

        /* renamed from: j */
        final /* synthetic */ Object f6393j;
        final /* synthetic */ Object zx;

        AnonymousClass2(Object obj, Object obj2) {
            obj2 = obj;
            obj = obj2;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
        public void j(TTAdManager tTAdManager) {
            tTAdManager.register(obj2);
            if (obj instanceof TTPluginListener) {
                gv.j(TTAppContextHolder.getContext()).j((TTPluginListener) obj);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$3 */
    class AnonymousClass3 implements InterfaceC0077j<TTAdManager> {

        /* renamed from: j */
        final /* synthetic */ Object f6394j;

        AnonymousClass3(Object obj) {
            obj = obj;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
        public void j(TTAdManager tTAdManager) {
            tTAdManager.unregister(obj);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$4 */
    class AnonymousClass4 implements i<TTAdManager> {

        /* renamed from: j */
        final /* synthetic */ Bundle f6396j;
        final /* synthetic */ Class zx;

        AnonymousClass4(Bundle bundle, Class cls) {
            bundle = bundle;
            cls = cls;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.j.i
        public void j() {
            com.bytedance.sdk.openadsdk.api.plugin.g.j(bundle);
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
        public void j(TTAdManager tTAdManager) {
            tTAdManager.getExtra(cls, bundle);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$5 */
    class AnonymousClass5 implements InterfaceC0077j<TTAdManager> {

        /* renamed from: j */
        final /* synthetic */ Class f6398j;
        final /* synthetic */ Bundle zx;

        AnonymousClass5(Class cls, Bundle bundle) {
            cls = cls;
            bundle = bundle;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
        public void j(TTAdManager tTAdManager) {
            tTAdManager.getExtra(cls, bundle);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$6 */
    class AnonymousClass6 implements InterfaceC0077j<TTAdManager> {

        /* renamed from: j */
        final /* synthetic */ Context f6399j;

        AnonymousClass6(Context context) {
            context = context;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
        public void j(TTAdManager tTAdManager) {
            tTAdManager.requestPermissionIfNecessary(context);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$7 */
    class AnonymousClass7 implements InterfaceC0077j<TTAdManager> {

        /* renamed from: j */
        final /* synthetic */ int f6400j;

        AnonymousClass7(int i2) {
            i2 = i2;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
        public void j(TTAdManager tTAdManager) {
            j.this.zx.setThemeStatus(i2);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$8 */
    class AnonymousClass8 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ InterfaceC0077j f6401j;

        AnonymousClass8(InterfaceC0077j interfaceC0077j) {
            interfaceC0077j = interfaceC0077j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (j.this.zx != null) {
                    interfaceC0077j.j(j.this.zx);
                    return;
                }
                InterfaceC0077j interfaceC0077j = interfaceC0077j;
                if (interfaceC0077j instanceof i) {
                    ((i) interfaceC0077j).j();
                }
                com.bytedance.sdk.openadsdk.api.j.g("PluginDefaultAdManager", "Not ready, no manager");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.j.g("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
                gv.j(th);
            }
        }
    }

    private static final class g implements TTAdNative {

        /* renamed from: j */
        private zx<TTAdNative> f6402j;

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$g$1 */
        class AnonymousClass1 implements InterfaceC0077j<TTAdNative> {

            /* renamed from: j */
            final /* synthetic */ AdSlot f6404j;
            final /* synthetic */ TTAdNative.FeedAdListener zx;

            AnonymousClass1(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
                adSlot = adSlot;
                feedAdListener = feedAdListener;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdNative tTAdNative) {
                tTAdNative.loadFeedAd(adSlot, feedAdListener);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$g$10 */
        class AnonymousClass10 implements InterfaceC0077j<TTAdNative> {

            /* renamed from: j */
            final /* synthetic */ AdSlot f6406j;
            final /* synthetic */ TTAdNative.SplashAdListener zx;

            AnonymousClass10(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
                adSlot = adSlot;
                splashAdListener = splashAdListener;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdNative tTAdNative) {
                tTAdNative.loadSplashAd(adSlot, splashAdListener);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$g$11 */
        class AnonymousClass11 implements InterfaceC0077j<TTAdNative> {

            /* renamed from: j */
            final /* synthetic */ AdSlot f6408j;
            final /* synthetic */ TTAdNative.RewardVideoAdListener zx;

            AnonymousClass11(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
                adSlot = adSlot;
                rewardVideoAdListener = rewardVideoAdListener;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdNative tTAdNative) {
                tTAdNative.loadRewardVideoAd(adSlot, rewardVideoAdListener);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$g$12 */
        class AnonymousClass12 implements InterfaceC0077j<TTAdNative> {

            /* renamed from: j */
            final /* synthetic */ AdSlot f6410j;
            final /* synthetic */ TTAdNative.FullScreenVideoAdListener zx;

            AnonymousClass12(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
                adSlot = adSlot;
                fullScreenVideoAdListener = fullScreenVideoAdListener;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdNative tTAdNative) {
                tTAdNative.loadFullScreenVideoAd(adSlot, fullScreenVideoAdListener);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$g$2 */
        class AnonymousClass2 implements InterfaceC0077j<TTAdNative> {

            /* renamed from: j */
            final /* synthetic */ AdSlot f6412j;
            final /* synthetic */ TTAdNative.NativeExpressAdListener zx;

            AnonymousClass2(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
                adSlot = adSlot;
                nativeExpressAdListener = nativeExpressAdListener;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdNative tTAdNative) {
                tTAdNative.loadNativeExpressAd(adSlot, nativeExpressAdListener);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$g$3 */
        class AnonymousClass3 implements InterfaceC0077j<TTAdNative> {

            /* renamed from: j */
            final /* synthetic */ AdSlot f6414j;
            final /* synthetic */ TTAdNative.NativeExpressAdListener zx;

            AnonymousClass3(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
                adSlot = adSlot;
                nativeExpressAdListener = nativeExpressAdListener;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdNative tTAdNative) {
                tTAdNative.loadExpressDrawFeedAd(adSlot, nativeExpressAdListener);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$g$4 */
        class AnonymousClass4 implements InterfaceC0077j<TTAdNative> {

            /* renamed from: j */
            final /* synthetic */ AdSlot f6416j;
            final /* synthetic */ TTAdNative.NativeExpressAdListener zx;

            AnonymousClass4(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
                adSlot = adSlot;
                nativeExpressAdListener = nativeExpressAdListener;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdNative tTAdNative) {
                tTAdNative.loadBannerExpressAd(adSlot, nativeExpressAdListener);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$g$5 */
        class AnonymousClass5 implements InterfaceC0077j<TTAdNative> {

            /* renamed from: j */
            final /* synthetic */ AdSlot f6418j;
            final /* synthetic */ TTAdNative.FeedAdListener zx;

            AnonymousClass5(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
                adSlot = adSlot;
                feedAdListener = feedAdListener;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdNative tTAdNative) {
                tTAdNative.loadStream(adSlot, feedAdListener);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$g$6 */
        class AnonymousClass6 implements InterfaceC0077j<TTAdNative> {

            /* renamed from: j */
            final /* synthetic */ AdSlot f6420j;
            final /* synthetic */ TTAdNative.DrawFeedAdListener zx;

            AnonymousClass6(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
                adSlot = adSlot;
                drawFeedAdListener = drawFeedAdListener;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdNative tTAdNative) {
                tTAdNative.loadDrawFeedAd(adSlot, drawFeedAdListener);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$g$7 */
        class AnonymousClass7 implements InterfaceC0077j<TTAdNative> {

            /* renamed from: j */
            final /* synthetic */ AdSlot f6422j;
            final /* synthetic */ TTAdNative.NativeAdListener zx;

            AnonymousClass7(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
                adSlot = adSlot;
                nativeAdListener = nativeAdListener;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdNative tTAdNative) {
                tTAdNative.loadNativeAd(adSlot, nativeAdListener);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$g$8 */
        class AnonymousClass8 implements InterfaceC0077j<TTAdNative> {

            /* renamed from: i */
            final /* synthetic */ int f6424i;

            /* renamed from: j */
            final /* synthetic */ AdSlot f6425j;
            final /* synthetic */ TTAdNative.SplashAdListener zx;

            AnonymousClass8(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i2) {
                adSlot = adSlot;
                splashAdListener = splashAdListener;
                i2 = i2;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdNative tTAdNative) {
                tTAdNative.loadSplashAd(adSlot, splashAdListener, i2);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$g$9 */
        class AnonymousClass9 implements InterfaceC0077j<TTAdNative> {

            /* renamed from: i */
            final /* synthetic */ int f6427i;

            /* renamed from: j */
            final /* synthetic */ AdSlot f6428j;
            final /* synthetic */ TTAdNative.CSJSplashAdListener zx;

            AnonymousClass9(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i2) {
                adSlot = adSlot;
                cSJSplashAdListener = cSJSplashAdListener;
                i2 = i2;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdNative tTAdNative) {
                tTAdNative.loadSplashAd(adSlot, cSJSplashAdListener, i2);
            }
        }

        public g(zx<TTAdNative> zxVar) {
            this.f6402j = zxVar;
        }

        private final void j(CommonListener commonListener, InterfaceC0077j<TTAdNative> interfaceC0077j) {
            try {
                this.f6402j.j(interfaceC0077j);
            } catch (Throwable th) {
                if (commonListener != null) {
                    commonListener.onError(4202, "Load ad failed: " + th.getMessage());
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            j(nativeExpressAdListener, new InterfaceC0077j<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.g.4

                /* renamed from: j */
                final /* synthetic */ AdSlot f6416j;
                final /* synthetic */ TTAdNative.NativeExpressAdListener zx;

                AnonymousClass4(AdSlot adSlot2, TTAdNative.NativeExpressAdListener nativeExpressAdListener2) {
                    adSlot = adSlot2;
                    nativeExpressAdListener = nativeExpressAdListener2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdNative tTAdNative) {
                    tTAdNative.loadBannerExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            j(drawFeedAdListener, new InterfaceC0077j<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.g.6

                /* renamed from: j */
                final /* synthetic */ AdSlot f6420j;
                final /* synthetic */ TTAdNative.DrawFeedAdListener zx;

                AnonymousClass6(AdSlot adSlot2, TTAdNative.DrawFeedAdListener drawFeedAdListener2) {
                    adSlot = adSlot2;
                    drawFeedAdListener = drawFeedAdListener2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdNative tTAdNative) {
                    tTAdNative.loadDrawFeedAd(adSlot, drawFeedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            j(nativeExpressAdListener, new InterfaceC0077j<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.g.3

                /* renamed from: j */
                final /* synthetic */ AdSlot f6414j;
                final /* synthetic */ TTAdNative.NativeExpressAdListener zx;

                AnonymousClass3(AdSlot adSlot2, TTAdNative.NativeExpressAdListener nativeExpressAdListener2) {
                    adSlot = adSlot2;
                    nativeExpressAdListener = nativeExpressAdListener2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdNative tTAdNative) {
                    tTAdNative.loadExpressDrawFeedAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            j(feedAdListener, new InterfaceC0077j<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.g.1

                /* renamed from: j */
                final /* synthetic */ AdSlot f6404j;
                final /* synthetic */ TTAdNative.FeedAdListener zx;

                AnonymousClass1(AdSlot adSlot2, TTAdNative.FeedAdListener feedAdListener2) {
                    adSlot = adSlot2;
                    feedAdListener = feedAdListener2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdNative tTAdNative) {
                    tTAdNative.loadFeedAd(adSlot, feedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            j(fullScreenVideoAdListener, new InterfaceC0077j<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.g.12

                /* renamed from: j */
                final /* synthetic */ AdSlot f6410j;
                final /* synthetic */ TTAdNative.FullScreenVideoAdListener zx;

                AnonymousClass12(AdSlot adSlot2, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2) {
                    adSlot = adSlot2;
                    fullScreenVideoAdListener = fullScreenVideoAdListener2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdNative tTAdNative) {
                    tTAdNative.loadFullScreenVideoAd(adSlot, fullScreenVideoAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            j(nativeAdListener, new InterfaceC0077j<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.g.7

                /* renamed from: j */
                final /* synthetic */ AdSlot f6422j;
                final /* synthetic */ TTAdNative.NativeAdListener zx;

                AnonymousClass7(AdSlot adSlot2, TTAdNative.NativeAdListener nativeAdListener2) {
                    adSlot = adSlot2;
                    nativeAdListener = nativeAdListener2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdNative tTAdNative) {
                    tTAdNative.loadNativeAd(adSlot, nativeAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            j(nativeExpressAdListener, new InterfaceC0077j<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.g.2

                /* renamed from: j */
                final /* synthetic */ AdSlot f6412j;
                final /* synthetic */ TTAdNative.NativeExpressAdListener zx;

                AnonymousClass2(AdSlot adSlot2, TTAdNative.NativeExpressAdListener nativeExpressAdListener2) {
                    adSlot = adSlot2;
                    nativeExpressAdListener = nativeExpressAdListener2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdNative tTAdNative) {
                    tTAdNative.loadNativeExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            j(rewardVideoAdListener, new InterfaceC0077j<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.g.11

                /* renamed from: j */
                final /* synthetic */ AdSlot f6408j;
                final /* synthetic */ TTAdNative.RewardVideoAdListener zx;

                AnonymousClass11(AdSlot adSlot2, TTAdNative.RewardVideoAdListener rewardVideoAdListener2) {
                    adSlot = adSlot2;
                    rewardVideoAdListener = rewardVideoAdListener2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdNative tTAdNative) {
                    tTAdNative.loadRewardVideoAd(adSlot, rewardVideoAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i2) {
            j(splashAdListener, new InterfaceC0077j<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.g.8

                /* renamed from: i */
                final /* synthetic */ int f6424i;

                /* renamed from: j */
                final /* synthetic */ AdSlot f6425j;
                final /* synthetic */ TTAdNative.SplashAdListener zx;

                AnonymousClass8(AdSlot adSlot2, TTAdNative.SplashAdListener splashAdListener2, int i22) {
                    adSlot = adSlot2;
                    splashAdListener = splashAdListener2;
                    i2 = i22;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, splashAdListener, i2);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            j(feedAdListener, new InterfaceC0077j<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.g.5

                /* renamed from: j */
                final /* synthetic */ AdSlot f6418j;
                final /* synthetic */ TTAdNative.FeedAdListener zx;

                AnonymousClass5(AdSlot adSlot2, TTAdNative.FeedAdListener feedAdListener2) {
                    adSlot = adSlot2;
                    feedAdListener = feedAdListener2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdNative tTAdNative) {
                    tTAdNative.loadStream(adSlot, feedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i2) {
            j(cSJSplashAdListener, new InterfaceC0077j<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.g.9

                /* renamed from: i */
                final /* synthetic */ int f6427i;

                /* renamed from: j */
                final /* synthetic */ AdSlot f6428j;
                final /* synthetic */ TTAdNative.CSJSplashAdListener zx;

                AnonymousClass9(AdSlot adSlot2, TTAdNative.CSJSplashAdListener cSJSplashAdListener2, int i22) {
                    adSlot = adSlot2;
                    cSJSplashAdListener = cSJSplashAdListener2;
                    i2 = i22;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, cSJSplashAdListener, i2);
                }
            });
        }

        private final void j(TTAdNative.CSJSplashAdListener cSJSplashAdListener, InterfaceC0077j<TTAdNative> interfaceC0077j) {
            try {
                this.f6402j.j(interfaceC0077j);
            } catch (Throwable th) {
                if (cSJSplashAdListener != null) {
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError(4202, "Load ad failed: " + th.getMessage()));
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
            j(splashAdListener, new InterfaceC0077j<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.g.10

                /* renamed from: j */
                final /* synthetic */ AdSlot f6406j;
                final /* synthetic */ TTAdNative.SplashAdListener zx;

                AnonymousClass10(AdSlot adSlot2, TTAdNative.SplashAdListener splashAdListener2) {
                    adSlot = adSlot2;
                    splashAdListener = splashAdListener2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, splashAdListener);
                }
            });
        }
    }

    private interface i<T> extends InterfaceC0077j<T> {
        void j();
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.j$j */
    private interface InterfaceC0077j<T> {
        void j(T t);
    }

    private interface zx<T> {
        void j(InterfaceC0077j<T> interfaceC0077j);
    }

    j() {
    }

    public final void call(InterfaceC0077j<TTAdManager> interfaceC0077j) {
        if (this.zx == null) {
            ScheduledExecutorService scheduledExecutorService = lg.f6435j;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.8

                    /* renamed from: j */
                    final /* synthetic */ InterfaceC0077j f6401j;

                    AnonymousClass8(InterfaceC0077j interfaceC0077j2) {
                        interfaceC0077j = interfaceC0077j2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (j.this.zx != null) {
                                interfaceC0077j.j(j.this.zx);
                                return;
                            }
                            InterfaceC0077j interfaceC0077j2 = interfaceC0077j;
                            if (interfaceC0077j2 instanceof i) {
                                ((i) interfaceC0077j2).j();
                            }
                            com.bytedance.sdk.openadsdk.api.j.g("PluginDefaultAdManager", "Not ready, no manager");
                        } catch (Throwable th) {
                            com.bytedance.sdk.openadsdk.api.j.g("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
                            gv.j(th);
                        }
                    }
                });
                return;
            } else {
                com.bytedance.sdk.openadsdk.api.j.g("PluginDefaultAdManager", "Not ready, no executor");
                return;
            }
        }
        try {
            interfaceC0077j2.j(this.zx);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.j.g("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
            gv.j(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        return new g(new AnonymousClass1(new WeakReference(context)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot) {
        if (this.zx != null) {
            return this.zx.getBiddingToken(adSlot);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public <T> T getExtra(Class<T> cls, Bundle bundle) {
        if (this.zx != null) {
            return (T) this.zx.getExtra(cls, bundle);
        }
        if (cls == Bundle.class && bundle != null && bundle.getInt("action", 0) == 1) {
            call(new i<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.4

                /* renamed from: j */
                final /* synthetic */ Bundle f6396j;
                final /* synthetic */ Class zx;

                AnonymousClass4(Bundle bundle2, Class cls2) {
                    bundle = bundle2;
                    cls = cls2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.i
                public void j() {
                    com.bytedance.sdk.openadsdk.api.plugin.g.j(bundle);
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
                public void j(TTAdManager tTAdManager) {
                    tTAdManager.getExtra(cls, bundle);
                }
            });
            return null;
        }
        call(new InterfaceC0077j<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.5

            /* renamed from: j */
            final /* synthetic */ Class f6398j;
            final /* synthetic */ Bundle zx;

            AnonymousClass5(Class cls2, Bundle bundle2) {
                cls = cls2;
                bundle = bundle2;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdManager tTAdManager) {
                tTAdManager.getExtra(cls, bundle);
            }
        });
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getPluginVersion() {
        return this.zx != null ? this.zx.getPluginVersion() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        return "5.2.0.5";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public int getThemeStatus() {
        if (this.zx != null) {
            return this.zx.getThemeStatus();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void register(Object obj) {
        Object obj2;
        if (obj instanceof TTPluginListener) {
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            obj2 = gv.j(TTAppContextHolder.getContext()).j(tTPluginListener.packageName(), tTPluginListener.config());
        } else {
            obj2 = obj;
        }
        call(new InterfaceC0077j<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.2

            /* renamed from: j */
            final /* synthetic */ Object f6393j;
            final /* synthetic */ Object zx;

            AnonymousClass2(Object obj22, Object obj3) {
                obj2 = obj22;
                obj = obj3;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdManager tTAdManager) {
                tTAdManager.register(obj2);
                if (obj instanceof TTPluginListener) {
                    gv.j(TTAppContextHolder.getContext()).j((TTPluginListener) obj);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(Context context) {
        call(new InterfaceC0077j<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.6

            /* renamed from: j */
            final /* synthetic */ Context f6399j;

            AnonymousClass6(Context context2) {
                context = context2;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdManager tTAdManager) {
                tTAdManager.requestPermissionIfNecessary(context);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void setThemeStatus(int i2) {
        call(new InterfaceC0077j<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.7

            /* renamed from: j */
            final /* synthetic */ int f6400j;

            AnonymousClass7(int i22) {
                i2 = i22;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdManager tTAdManager) {
                j.this.zx.setThemeStatus(i2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        return this.zx != null && this.zx.tryShowInstallDialogWhenExit(activity, exitInstallListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void unregister(Object obj) {
        call(new InterfaceC0077j<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.j.3

            /* renamed from: j */
            final /* synthetic */ Object f6394j;

            AnonymousClass3(Object obj2) {
                obj = obj2;
            }

            @Override // com.bytedance.sdk.openadsdk.api.plugin.j.InterfaceC0077j
            public void j(TTAdManager tTAdManager) {
                tTAdManager.unregister(obj);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot, boolean z, int i2) {
        if (this.zx != null) {
            return this.zx.getBiddingToken(adSlot, z, i2);
        }
        return null;
    }

    public void j(TTAdManager tTAdManager) {
        this.zx = tTAdManager;
    }
}
