package com.alimm.tanx.core.ad.ad.splash;

import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new;
import com.alimm.tanx.core.ad.base.tanxc_if;
import com.alimm.tanx.core.bridge.Callback;
import com.alimm.tanx.core.bridge.JsBridgeUtil;
import com.alimm.tanx.core.bridge.JsHandler;
import com.alimm.tanx.core.utils.LogUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.AbstractMap;

/* loaded from: classes.dex */
public class SplashWebViewUtil extends tanxc_if {
    protected ITanxSplashExpressAd tanxc_do;
    protected TanxSplashAdView tanxc_if;
    private SplashWebInterface tanxc_try;
    protected long tanxc_for = 0;
    protected final long tanxc_int = 500;

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil$1 */
    public class AnonymousClass1 implements JsBridgeUtil.AdInterface {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
        public void adClose() {
            LogUtils.d("SplashWebViewUtil", "RewardVideo.notifyClose");
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
        public void adSkip(boolean z10) {
            LogUtils.d("SplashWebViewUtil", "RewardVideo.notifyAdSkip:" + z10);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil$2 */
    public class AnonymousClass2 implements JsHandler {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            try {
                LogUtils.d("SplashWebViewUtil", "WebAd.notifyAdExpose");
                abstractMap.get("area");
                ITanxSplashExpressAd iTanxSplashExpressAd = SplashWebViewUtil.this.tanxc_do;
                if (iTanxSplashExpressAd != null) {
                    iTanxSplashExpressAd.onResourceLoadSuccess();
                }
                callback.call(true, null);
            } catch (Exception e10) {
                LogUtils.e("SplashWebViewUtil", e10);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil$3 */
    public class AnonymousClass3 implements JsHandler {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            try {
                LogUtils.d("SplashWebViewUtil", "WebAd.notifyAdClick");
                long currentTimeMillis = System.currentTimeMillis();
                SplashWebViewUtil splashWebViewUtil = SplashWebViewUtil.this;
                if (currentTimeMillis - splashWebViewUtil.tanxc_for < 500) {
                    LogUtils.d("SplashWebViewUtil", "mClickedOnce = true");
                    return;
                }
                splashWebViewUtil.tanxc_for = System.currentTimeMillis();
                abstractMap.get("area");
                String str = (String) abstractMap.get("clickThroughUrl");
                String str2 = (String) abstractMap.get("deepLinkUrl");
                ITanxSplashExpressAd iTanxSplashExpressAd = SplashWebViewUtil.this.tanxc_do;
                if (iTanxSplashExpressAd != null && (iTanxSplashExpressAd instanceof tanxc_new)) {
                    ((tanxc_new) iTanxSplashExpressAd).tanxc_do(str, str2, false);
                    if (SplashWebViewUtil.this.tanxc_do.getOnSplashAdListener() != null) {
                        SplashWebViewUtil.this.tanxc_do.getOnSplashAdListener().onAdClicked();
                    }
                }
                callback.call(true, null);
            } catch (Exception e10) {
                LogUtils.e("SplashWebViewUtil", e10);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil$4 */
    public class AnonymousClass4 implements JsHandler {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            LogUtils.d("SplashWebViewUtil", "WebAd.notifyError");
            Integer num = (Integer) abstractMap.get("cmd");
            SplashWebViewUtil.this.tanxc_try.webError(num == null ? -1 : num.intValue(), (String) abstractMap.get("msg"));
            callback.call(true, null);
        }
    }

    public interface SplashWebInterface extends JsBridgeUtil.BaseWebInterface {
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public boolean tanxc_do() {
        return true;
    }

    public void tanxc_do(LinearLayout linearLayout, ITanxSplashExpressAd iTanxSplashExpressAd, TanxSplashAdView tanxSplashAdView, SplashWebInterface splashWebInterface) {
        LogUtils.d("SplashWebViewUtil", PointCategory.INIT);
        if (iTanxSplashExpressAd == null) {
            return;
        }
        this.tanxc_if = tanxSplashAdView;
        this.tanxc_do = iTanxSplashExpressAd;
        super.tanxc_do(linearLayout, true, iTanxSplashExpressAd.getBidInfo(), iTanxSplashExpressAd.getAdSlot(), splashWebInterface, new JsBridgeUtil.AdInterface() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.1
            public AnonymousClass1() {
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
            public void adClose() {
                LogUtils.d("SplashWebViewUtil", "RewardVideo.notifyClose");
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
            public void adSkip(boolean z10) {
                LogUtils.d("SplashWebViewUtil", "RewardVideo.notifyAdSkip:" + z10);
            }
        });
        this.tanxc_try = splashWebInterface;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public void tanxc_do(WebView webView) {
        super.tanxc_do(webView);
        super.tanxc_do(false);
        this.tanxc_new.register("WebAd.notifyAdExpose", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.2
            public AnonymousClass2() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("SplashWebViewUtil", "WebAd.notifyAdExpose");
                    abstractMap.get("area");
                    ITanxSplashExpressAd iTanxSplashExpressAd = SplashWebViewUtil.this.tanxc_do;
                    if (iTanxSplashExpressAd != null) {
                        iTanxSplashExpressAd.onResourceLoadSuccess();
                    }
                    callback.call(true, null);
                } catch (Exception e10) {
                    LogUtils.e("SplashWebViewUtil", e10);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyAdClick", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.3
            public AnonymousClass3() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("SplashWebViewUtil", "WebAd.notifyAdClick");
                    long currentTimeMillis = System.currentTimeMillis();
                    SplashWebViewUtil splashWebViewUtil = SplashWebViewUtil.this;
                    if (currentTimeMillis - splashWebViewUtil.tanxc_for < 500) {
                        LogUtils.d("SplashWebViewUtil", "mClickedOnce = true");
                        return;
                    }
                    splashWebViewUtil.tanxc_for = System.currentTimeMillis();
                    abstractMap.get("area");
                    String str = (String) abstractMap.get("clickThroughUrl");
                    String str2 = (String) abstractMap.get("deepLinkUrl");
                    ITanxSplashExpressAd iTanxSplashExpressAd = SplashWebViewUtil.this.tanxc_do;
                    if (iTanxSplashExpressAd != null && (iTanxSplashExpressAd instanceof tanxc_new)) {
                        ((tanxc_new) iTanxSplashExpressAd).tanxc_do(str, str2, false);
                        if (SplashWebViewUtil.this.tanxc_do.getOnSplashAdListener() != null) {
                            SplashWebViewUtil.this.tanxc_do.getOnSplashAdListener().onAdClicked();
                        }
                    }
                    callback.call(true, null);
                } catch (Exception e10) {
                    LogUtils.e("SplashWebViewUtil", e10);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyError", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.4
            public AnonymousClass4() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("SplashWebViewUtil", "WebAd.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                SplashWebViewUtil.this.tanxc_try.webError(num == null ? -1 : num.intValue(), (String) abstractMap.get("msg"));
                callback.call(true, null);
            }
        });
    }
}
