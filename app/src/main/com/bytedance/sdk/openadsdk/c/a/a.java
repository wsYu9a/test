package com.bytedance.sdk.openadsdk.c.a;

import android.util.Pair;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.g.a.a.a.c;
import com.bytedance.sdk.openadsdk.g.a.a.a.d;
import com.bytedance.sdk.openadsdk.g.a.a.a.e;
import com.bytedance.sdk.openadsdk.g.a.a.a.f;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.a$a */
    public static class C0239a implements TTAdNative {

        /* renamed from: a */
        private final a f8096a;

        /* renamed from: com.bytedance.sdk.openadsdk.c.a.a$a$1 */
        public class AnonymousClass1 extends CSJAdError {

            /* renamed from: a */
            final /* synthetic */ Pair f8097a;

            public AnonymousClass1(Pair pair) {
                a10 = pair;
            }

            @Override // com.bytedance.sdk.openadsdk.CSJAdError
            public int getCode() {
                return ((Integer) a10.first).intValue();
            }

            @Override // com.bytedance.sdk.openadsdk.CSJAdError
            public String getMsg() {
                return (String) a10.second;
            }
        }

        public C0239a(a aVar) {
            this.f8096a = aVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f8096a.i(com.bytedance.sdk.openadsdk.c.a.c.b.a(adSlot), new e(nativeExpressAdListener));
            } catch (Exception e10) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> a10 = this.f8096a.a(e10);
                    nativeExpressAdListener.onError(((Integer) a10.first).intValue(), (String) a10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.f8096a.c(com.bytedance.sdk.openadsdk.c.a.c.b.a(adSlot), new com.bytedance.sdk.openadsdk.g.a.a.a.a(drawFeedAdListener));
            } catch (Exception e10) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> a10 = this.f8096a.a(e10);
                    drawFeedAdListener.onError(((Integer) a10.first).intValue(), (String) a10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f8096a.h(com.bytedance.sdk.openadsdk.c.a.c.b.a(adSlot), new e(nativeExpressAdListener));
            } catch (Exception e10) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> a10 = this.f8096a.a(e10);
                    nativeExpressAdListener.onError(((Integer) a10.first).intValue(), (String) a10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f8096a.a(com.bytedance.sdk.openadsdk.c.a.c.b.a(adSlot), new com.bytedance.sdk.openadsdk.g.a.a.a.b(feedAdListener));
            } catch (Exception e10) {
                if (feedAdListener != null) {
                    Pair<Integer, String> a10 = this.f8096a.a(e10);
                    feedAdListener.onError(((Integer) a10.first).intValue(), (String) a10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.f8096a.f(com.bytedance.sdk.openadsdk.c.a.c.b.a(adSlot), new c(fullScreenVideoAdListener));
            } catch (Exception e10) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> a10 = this.f8096a.a(e10);
                    fullScreenVideoAdListener.onError(((Integer) a10.first).intValue(), (String) a10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.f8096a.d(com.bytedance.sdk.openadsdk.c.a.c.b.a(adSlot), new d(nativeAdListener));
            } catch (Exception e10) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> a10 = this.f8096a.a(e10);
                    nativeAdListener.onError(((Integer) a10.first).intValue(), (String) a10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f8096a.g(com.bytedance.sdk.openadsdk.c.a.c.b.a(adSlot), new e(nativeExpressAdListener));
            } catch (Exception e10) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> a10 = this.f8096a.a(e10);
                    nativeExpressAdListener.onError(((Integer) a10.first).intValue(), (String) a10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.f8096a.e(com.bytedance.sdk.openadsdk.c.a.c.b.a(adSlot), new f(rewardVideoAdListener));
            } catch (Exception e10) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> a10 = this.f8096a.a(e10);
                    rewardVideoAdListener.onError(((Integer) a10.first).intValue(), (String) a10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i10) {
            try {
                this.f8096a.a(com.bytedance.sdk.openadsdk.c.a.c.b.a(adSlot), new b(cSJSplashAdListener), i10);
            } catch (Exception e10) {
                if (cSJSplashAdListener != null) {
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.bytedance.sdk.openadsdk.c.a.a.a.1

                        /* renamed from: a */
                        final /* synthetic */ Pair f8097a;

                        public AnonymousClass1(Pair pair) {
                            a10 = pair;
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) a10.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) a10.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f8096a.b(com.bytedance.sdk.openadsdk.c.a.c.b.a(adSlot), new com.bytedance.sdk.openadsdk.g.a.a.a.b(feedAdListener));
            } catch (Exception e10) {
                if (feedAdListener != null) {
                    Pair<Integer, String> a10 = this.f8096a.a(e10);
                    feedAdListener.onError(((Integer) a10.first).intValue(), (String) a10.second);
                }
            }
        }
    }

    public abstract Pair<Integer, String> a(Exception exc);

    public TTAdNative a() {
        return new C0239a(this);
    }

    public abstract void a(ValueSet valueSet, Bridge bridge);

    public abstract void a(ValueSet valueSet, Bridge bridge, int i10);

    public abstract void b(ValueSet valueSet, Bridge bridge);

    public abstract void c(ValueSet valueSet, Bridge bridge);

    public abstract void d(ValueSet valueSet, Bridge bridge);

    public abstract void e(ValueSet valueSet, Bridge bridge);

    public abstract void f(ValueSet valueSet, Bridge bridge);

    public abstract void g(ValueSet valueSet, Bridge bridge);

    public abstract void h(ValueSet valueSet, Bridge bridge);

    public abstract void i(ValueSet valueSet, Bridge bridge);
}
