package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.bridge.Callback;
import com.alimm.tanx.core.bridge.JsBridgeUtil;
import com.alimm.tanx.core.bridge.JsHandler;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.utils.LogUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.AbstractMap;

/* loaded from: classes.dex */
public class TableScreenWebViewUtil extends com.alimm.tanx.core.ad.base.tanxc_if {
    private tanxc_if tanxc_for;
    private TableScreenInterface tanxc_int;
    protected long tanxc_do = 0;
    protected final long tanxc_if = 500;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil$1 */
    public class AnonymousClass1 implements JsBridgeUtil.AdInterface {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
        public void adClose() {
            LogUtils.d("TableScreenWebViewUtil", "RewardVideo.notifyClose");
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
        public void adSkip(boolean z10) {
            LogUtils.d("TableScreenWebViewUtil", "RewardVideo.notifyAdSkip:" + z10);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil$2 */
    public class AnonymousClass2 implements JsHandler {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            try {
                LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyAdExpose");
                abstractMap.get("area");
                if (TableScreenWebViewUtil.this.tanxc_for != null && TableScreenWebViewUtil.this.tanxc_for.tanxc_do != null) {
                    TableScreenWebViewUtil.this.tanxc_for.tanxc_do.onResourceLoadSuccess();
                }
                callback.call(true, null);
            } catch (Exception e10) {
                LogUtils.e("TableScreenWebViewUtil", e10);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil$3 */
    public class AnonymousClass3 implements JsHandler {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            try {
                LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyAdClick");
                long currentTimeMillis = System.currentTimeMillis();
                TableScreenWebViewUtil tableScreenWebViewUtil = TableScreenWebViewUtil.this;
                if (currentTimeMillis - tableScreenWebViewUtil.tanxc_do < 500) {
                    LogUtils.d("TableScreenWebViewUtil", "mClickedOnce = true");
                    return;
                }
                tableScreenWebViewUtil.tanxc_do = System.currentTimeMillis();
                abstractMap.get("area");
                String str = (String) abstractMap.get("clickThroughUrl");
                String str2 = (String) abstractMap.get("deepLinkUrl");
                if (TableScreenWebViewUtil.this.tanxc_for != null && TableScreenWebViewUtil.this.tanxc_for.tanxc_do != null) {
                    TableScreenWebViewUtil.this.tanxc_for.tanxc_do.click(str, str2);
                    if (TableScreenWebViewUtil.this.tanxc_for.tanxc_for() != null) {
                        TableScreenWebViewUtil.this.tanxc_for.tanxc_for().onAdClicked(null, TableScreenWebViewUtil.this.tanxc_for.tanxc_do);
                    }
                }
                callback.call(true, null);
            } catch (Exception e10) {
                LogUtils.e("TableScreenWebViewUtil", e10);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil$4 */
    public class AnonymousClass4 implements JsHandler {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyError");
            Integer num = (Integer) abstractMap.get("cmd");
            TableScreenWebViewUtil.this.tanxc_int.webError(num == null ? -1 : num.intValue(), (String) abstractMap.get("msg"));
            callback.call(true, null);
        }
    }

    public interface TableScreenInterface extends JsBridgeUtil.BaseWebInterface {
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public boolean tanxc_do() {
        return true;
    }

    public void tanxc_do(LinearLayout linearLayout, BidInfo bidInfo, TanxAdSlot tanxAdSlot, tanxc_if tanxc_ifVar, TableScreenInterface tableScreenInterface) {
        LogUtils.d("TableScreenWebViewUtil", PointCategory.INIT);
        super.tanxc_do(linearLayout, true, bidInfo, tanxAdSlot, tableScreenInterface, new JsBridgeUtil.AdInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.1
            public AnonymousClass1() {
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
            public void adClose() {
                LogUtils.d("TableScreenWebViewUtil", "RewardVideo.notifyClose");
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
            public void adSkip(boolean z10) {
                LogUtils.d("TableScreenWebViewUtil", "RewardVideo.notifyAdSkip:" + z10);
            }
        });
        this.tanxc_for = tanxc_ifVar;
        this.tanxc_int = tableScreenInterface;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public void tanxc_do(WebView webView) {
        super.tanxc_do(webView);
        super.tanxc_do(true);
        this.tanxc_new.register("WebAd.notifyAdExpose", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.2
            public AnonymousClass2() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyAdExpose");
                    abstractMap.get("area");
                    if (TableScreenWebViewUtil.this.tanxc_for != null && TableScreenWebViewUtil.this.tanxc_for.tanxc_do != null) {
                        TableScreenWebViewUtil.this.tanxc_for.tanxc_do.onResourceLoadSuccess();
                    }
                    callback.call(true, null);
                } catch (Exception e10) {
                    LogUtils.e("TableScreenWebViewUtil", e10);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyAdClick", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.3
            public AnonymousClass3() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyAdClick");
                    long currentTimeMillis = System.currentTimeMillis();
                    TableScreenWebViewUtil tableScreenWebViewUtil = TableScreenWebViewUtil.this;
                    if (currentTimeMillis - tableScreenWebViewUtil.tanxc_do < 500) {
                        LogUtils.d("TableScreenWebViewUtil", "mClickedOnce = true");
                        return;
                    }
                    tableScreenWebViewUtil.tanxc_do = System.currentTimeMillis();
                    abstractMap.get("area");
                    String str = (String) abstractMap.get("clickThroughUrl");
                    String str2 = (String) abstractMap.get("deepLinkUrl");
                    if (TableScreenWebViewUtil.this.tanxc_for != null && TableScreenWebViewUtil.this.tanxc_for.tanxc_do != null) {
                        TableScreenWebViewUtil.this.tanxc_for.tanxc_do.click(str, str2);
                        if (TableScreenWebViewUtil.this.tanxc_for.tanxc_for() != null) {
                            TableScreenWebViewUtil.this.tanxc_for.tanxc_for().onAdClicked(null, TableScreenWebViewUtil.this.tanxc_for.tanxc_do);
                        }
                    }
                    callback.call(true, null);
                } catch (Exception e10) {
                    LogUtils.e("TableScreenWebViewUtil", e10);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyError", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.4
            public AnonymousClass4() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                TableScreenWebViewUtil.this.tanxc_int.webError(num == null ? -1 : num.intValue(), (String) abstractMap.get("msg"));
                callback.call(true, null);
            }
        });
    }
}
