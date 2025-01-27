package com.alimm.tanx.core.bridge;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ut.bean.UtItemH5Bean;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.utils.NotConfused;
import com.qq.e.comm.constants.Constants;
import java.util.AbstractMap;
import java.util.HashMap;

/* loaded from: classes.dex */
public class JsBridgeUtil implements NotConfused {
    public static final String TAG = "JsBridgeUtil";
    private AdInterface adInterface;
    private BaseWebInterface baseWebInterface;
    private JsBridgeBean jsBridgeBean;

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$1 */
    public class AnonymousClass1 implements JsHandler {
        final /* synthetic */ boolean tanxc_do;

        public AnonymousClass1(boolean z10) {
            z10 = z10;
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            LogUtils.d(JsBridgeUtil.TAG, "WebAd.isShowWebBar");
            HashMap hashMap = new HashMap();
            hashMap.put("showWebBarSwitch", Boolean.valueOf(z10));
            callback.call(true, hashMap);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$10 */
    public class AnonymousClass10 implements JsHandler {
        public AnonymousClass10() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            LogUtils.d(JsBridgeUtil.TAG, "Reward.notifyError");
            Integer num = (Integer) abstractMap.get("cmd");
            JsBridgeUtil.this.baseWebInterface.webError(num == null ? -1 : num.intValue(), (String) abstractMap.get("msg"));
            callback.call(true, null);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$2 */
    public class AnonymousClass2 implements JsHandler {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            try {
                LogUtils.d(JsBridgeUtil.TAG, "RewardVideo.submitFeedback");
                String str = (String) abstractMap.get("interactType");
                String str2 = (String) abstractMap.get("interactDesc");
                if (JsBridgeUtil.this.jsBridgeBean != null) {
                    InteractionUpload.getInstance().uploadInteraction(5, JsBridgeUtil.this.jsBridgeBean.getEventTrack(), str, str2);
                }
                callback.call(true, null);
            } catch (Exception e10) {
                LogUtils.e(JsBridgeUtil.TAG, e10);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$3 */
    public class AnonymousClass3 implements JsHandler {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            LogUtils.d(JsBridgeUtil.TAG, "Core.getSDKInfo");
            HashMap hashMap = new HashMap();
            hashMap.put("version", SdkConstant.getSdkVersion());
            callback.call(true, hashMap);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$4 */
    public class AnonymousClass4 implements JsHandler {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            LogUtils.d(JsBridgeUtil.TAG, "WebAd.notifyWebDidMount");
            if (JsBridgeUtil.this.baseWebInterface != null) {
                LogUtils.d(JsBridgeUtil.TAG, "baseWebInterface!=null");
                JsBridgeUtil.this.baseWebInterface.h5NotifyDrawSuccess();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$5 */
    public class AnonymousClass5 implements JsHandler {
        public AnonymousClass5() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            JsBridgeUtil.this.track(abstractMap, callback);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$6 */
    public class AnonymousClass6 implements JsHandler {
        public AnonymousClass6() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = null;
            try {
                LogUtils.d(JsBridgeUtil.TAG, "RewardVideo.getAd");
                e = null;
                jSONObject = (JsBridgeUtil.this.jsBridgeBean == null || TextUtils.isEmpty(JsBridgeUtil.this.jsBridgeBean.getRawJsonStr())) ? null : JSON.parseObject(JsBridgeUtil.this.jsBridgeBean.getRawJsonStr());
            } catch (Exception e10) {
                e = e10;
                LogUtils.e(JsBridgeUtil.TAG, e);
            }
            if (jSONObject != null) {
                hashMap.put("ad", jSONObject);
            } else {
                hashMap.put("code", -1);
                String stackTraceMessage = LogUtils.getStackTraceMessage(e);
                if (JsBridgeUtil.this.jsBridgeBean != null) {
                    stackTraceMessage = stackTraceMessage + "  \n jsBridgeBean:" + JsBridgeUtil.this.jsBridgeBean.getRawJsonStr();
                }
                hashMap.put("msg", stackTraceMessage);
            }
            callback.call(true, hashMap);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$7 */
    public class AnonymousClass7 implements JsHandler {
        public AnonymousClass7() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            LogUtils.d(JsBridgeUtil.TAG, "Core.getNetType");
            HashMap hashMap = new HashMap();
            hashMap.put("netType", NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getMsg());
            LogUtils.d(JsBridgeUtil.TAG, JSON.toJSONString(hashMap));
            callback.call(true, hashMap);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$8 */
    public class AnonymousClass8 implements JsHandler {
        public AnonymousClass8() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            LogUtils.d(JsBridgeUtil.TAG, "RewardVideo.notifyClose");
            if (JsBridgeUtil.this.adInterface != null) {
                JsBridgeUtil.this.adInterface.adClose();
            }
            JsBridgeUtil.this.baseWebInterface.adClose();
            callback.call(true, null);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$9 */
    public class AnonymousClass9 implements JsHandler {
        public AnonymousClass9() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
            LogUtils.d(JsBridgeUtil.TAG, "RewardVideo.notifyAdSkip");
            Boolean bool = (Boolean) abstractMap.get("needClose");
            if (bool == null) {
                bool = Boolean.TRUE;
            }
            if (JsBridgeUtil.this.adInterface != null) {
                JsBridgeUtil.this.adInterface.adSkip(bool.booleanValue());
            }
            JsBridgeUtil.this.baseWebInterface.adSkip(bool.booleanValue());
            callback.call(true, null);
        }
    }

    public interface AdInterface {
        void adClose();

        void adSkip(boolean z10);
    }

    public interface BaseWebInterface {
        void adClose();

        void adSkip(boolean z10);

        void h5NotifyDrawSuccess();

        void webDrawStatus(boolean z10);

        void webError(int i10, String str);
    }

    public void track(AbstractMap<String, Object> abstractMap, Callback callback) {
        try {
            LogUtils.d(TAG, "RewardVideo.track");
            JSONObject jSONObject = (JSONObject) abstractMap.get(NotificationCompat.CATEGORY_EVENT);
            UtItemH5Bean utItemH5Bean = (UtItemH5Bean) JSON.parseObject(jSONObject != null ? jSONObject.toJSONString() : "", UtItemH5Bean.class);
            Boolean bool = (Boolean) abstractMap.get("needTemplateId");
            Boolean bool2 = (Boolean) abstractMap.get("needCreativeId");
            Boolean bool3 = (Boolean) abstractMap.get("needOpenType");
            Boolean bool4 = (Boolean) abstractMap.get("needClickUrl");
            if (utItemH5Bean != null) {
                JsBridgeBean jsBridgeBean = this.jsBridgeBean;
                if (jsBridgeBean != null) {
                    utItemH5Bean.pid = jsBridgeBean.getPid();
                    utItemH5Bean.reqId = this.jsBridgeBean.getReqId();
                }
                if (TextUtils.isEmpty(utItemH5Bean.page)) {
                    utItemH5Bean.page = utItemH5Bean.arg1;
                }
                if (this.jsBridgeBean != null) {
                    if (utItemH5Bean.args == null) {
                        utItemH5Bean.args = new HashMap();
                    }
                    if (bool == null || bool.booleanValue()) {
                        utItemH5Bean.args.put(ExposeManager.UtArgsNames.templateId, this.jsBridgeBean.getTemplateId());
                    }
                    if (bool2 == null || bool2.booleanValue()) {
                        utItemH5Bean.args.put(ExposeManager.UtArgsNames.creativeId, this.jsBridgeBean.getCreativeId());
                    }
                    if (bool3 != null && bool3.booleanValue()) {
                        utItemH5Bean.args.put("openType", Integer.valueOf(this.jsBridgeBean.getOpenType()));
                    }
                    if (bool4 != null && bool4.booleanValue()) {
                        utItemH5Bean.args.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, this.jsBridgeBean.getDeepLinkUrl());
                    }
                }
                TanxBaseUt.h5Ut(utItemH5Bean);
            } else {
                LogUtils.e(TAG, "Core.track  接收到H5埋点对象为空");
            }
            callback.call(true, null);
        } catch (Exception e10) {
            LogUtils.e(TAG, e10);
        }
    }

    public void initJsBridge(TanxJsBridge tanxJsBridge, JsBridgeBean jsBridgeBean, BaseWebInterface baseWebInterface, AdInterface adInterface) {
        if (tanxJsBridge == null) {
            LogUtils.d(TAG, "jsBridge注册失败，tanxJsBridge为空");
            return;
        }
        this.jsBridgeBean = jsBridgeBean;
        this.baseWebInterface = baseWebInterface;
        this.adInterface = adInterface;
        tanxJsBridge.register("Core.getSdkInfo", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.3
            public AnonymousClass3() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d(JsBridgeUtil.TAG, "Core.getSDKInfo");
                HashMap hashMap = new HashMap();
                hashMap.put("version", SdkConstant.getSdkVersion());
                callback.call(true, hashMap);
            }
        });
        tanxJsBridge.register("WebAd.notifyWebDidMount", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.4
            public AnonymousClass4() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d(JsBridgeUtil.TAG, "WebAd.notifyWebDidMount");
                if (JsBridgeUtil.this.baseWebInterface != null) {
                    LogUtils.d(JsBridgeUtil.TAG, "baseWebInterface!=null");
                    JsBridgeUtil.this.baseWebInterface.h5NotifyDrawSuccess();
                }
            }
        });
        tanxJsBridge.register("WebAd.track", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.5
            public AnonymousClass5() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                JsBridgeUtil.this.track(abstractMap, callback);
            }
        });
        tanxJsBridge.register("WebAd.getAd", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.6
            public AnonymousClass6() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = null;
                try {
                    LogUtils.d(JsBridgeUtil.TAG, "RewardVideo.getAd");
                    e = null;
                    jSONObject = (JsBridgeUtil.this.jsBridgeBean == null || TextUtils.isEmpty(JsBridgeUtil.this.jsBridgeBean.getRawJsonStr())) ? null : JSON.parseObject(JsBridgeUtil.this.jsBridgeBean.getRawJsonStr());
                } catch (Exception e10) {
                    e = e10;
                    LogUtils.e(JsBridgeUtil.TAG, e);
                }
                if (jSONObject != null) {
                    hashMap.put("ad", jSONObject);
                } else {
                    hashMap.put("code", -1);
                    String stackTraceMessage = LogUtils.getStackTraceMessage(e);
                    if (JsBridgeUtil.this.jsBridgeBean != null) {
                        stackTraceMessage = stackTraceMessage + "  \n jsBridgeBean:" + JsBridgeUtil.this.jsBridgeBean.getRawJsonStr();
                    }
                    hashMap.put("msg", stackTraceMessage);
                }
                callback.call(true, hashMap);
            }
        });
        tanxJsBridge.register("Core.getNetType", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.7
            public AnonymousClass7() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d(JsBridgeUtil.TAG, "Core.getNetType");
                HashMap hashMap = new HashMap();
                hashMap.put("netType", NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getMsg());
                LogUtils.d(JsBridgeUtil.TAG, JSON.toJSONString(hashMap));
                callback.call(true, hashMap);
            }
        });
        tanxJsBridge.register("WebAd.notifyClose", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.8
            public AnonymousClass8() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d(JsBridgeUtil.TAG, "RewardVideo.notifyClose");
                if (JsBridgeUtil.this.adInterface != null) {
                    JsBridgeUtil.this.adInterface.adClose();
                }
                JsBridgeUtil.this.baseWebInterface.adClose();
                callback.call(true, null);
            }
        });
        tanxJsBridge.register("WebAd.notifyAdSkip", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.9
            public AnonymousClass9() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d(JsBridgeUtil.TAG, "RewardVideo.notifyAdSkip");
                Boolean bool = (Boolean) abstractMap.get("needClose");
                if (bool == null) {
                    bool = Boolean.TRUE;
                }
                if (JsBridgeUtil.this.adInterface != null) {
                    JsBridgeUtil.this.adInterface.adSkip(bool.booleanValue());
                }
                JsBridgeUtil.this.baseWebInterface.adSkip(bool.booleanValue());
                callback.call(true, null);
            }
        });
        tanxJsBridge.register("WebAd.notifyError", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.10
            public AnonymousClass10() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d(JsBridgeUtil.TAG, "Reward.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                JsBridgeUtil.this.baseWebInterface.webError(num == null ? -1 : num.intValue(), (String) abstractMap.get("msg"));
                callback.call(true, null);
            }
        });
        tanxJsBridge.register("WebAd.submitFeedback", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.2
            public AnonymousClass2() {
            }

            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d(JsBridgeUtil.TAG, "RewardVideo.submitFeedback");
                    String str = (String) abstractMap.get("interactType");
                    String str2 = (String) abstractMap.get("interactDesc");
                    if (JsBridgeUtil.this.jsBridgeBean != null) {
                        InteractionUpload.getInstance().uploadInteraction(5, JsBridgeUtil.this.jsBridgeBean.getEventTrack(), str, str2);
                    }
                    callback.call(true, null);
                } catch (Exception e10) {
                    LogUtils.e(JsBridgeUtil.TAG, e10);
                }
            }
        });
    }

    public void setShowWebBar(TanxJsBridge tanxJsBridge, boolean z10) {
        if (tanxJsBridge == null) {
            LogUtils.d(TAG, "setShowWebBar过程jsBridge注册失败，tanxJsBridge为空");
        } else {
            tanxJsBridge.register("WebAd.isShowWebBar", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.1
                final /* synthetic */ boolean tanxc_do;

                public AnonymousClass1(boolean z102) {
                    z10 = z102;
                }

                @Override // com.alimm.tanx.core.bridge.JsHandler
                public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                    LogUtils.d(JsBridgeUtil.TAG, "WebAd.isShowWebBar");
                    HashMap hashMap = new HashMap();
                    hashMap.put("showWebBarSwitch", Boolean.valueOf(z10));
                    callback.call(true, hashMap);
                }
            });
        }
    }
}
