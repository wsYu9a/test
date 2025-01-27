package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveRoomService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.live.base.api.callback.Callback;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.i;
import com.bytedance.sdk.openadsdk.api.plugin.gv;
import com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zx extends com.bytedance.sdk.openadsdk.downloadnew.j implements Bridge, Serializable {
    private ITTLiveTokenInjectionAuth k;
    private ITTLiveConfig lg = null;
    private JSONObject y = null;
    private static final zx zx = new zx();

    /* renamed from: i */
    private static final AtomicBoolean f6488i = new AtomicBoolean(false);

    /* renamed from: g */
    private static final AtomicBoolean f6487g = new AtomicBoolean(false);
    private static final AtomicBoolean q = new AtomicBoolean(false);
    private static final AtomicBoolean gv = new AtomicBoolean(false);

    /* renamed from: j */
    public static j f6489j = null;

    /* renamed from: com.bytedance.sdk.openadsdk.live.zx$1 */
    class AnonymousClass1 implements TTPluginListener {
        AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public Bundle config() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i2, ClassLoader classLoader, Resources resources, Bundle bundle) {
            if (1000 == i2) {
                com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "live PL install success ， try to init live sdk");
                zx.f6487g.set(true);
                zx.f6488i.set(false);
                zx.this.q();
            } else if (1001 == i2) {
                StringBuilder sb = new StringBuilder();
                sb.append("live PL install failed, errorCode: ");
                sb.append(bundle == null ? null : bundle.get("code"));
                com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", sb.toString());
                zx.f6487g.set(false);
                zx.f6488i.set(false);
            }
            zx.this.y();
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public String packageName() {
            return null;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.live.zx$2 */
    class AnonymousClass2 implements MethodChannelService {
        AnonymousClass2() {
        }

        @Override // com.bytedance.android.live.base.api.MethodChannelService
        public String identity() {
            return "pangle";
        }

        @Override // com.bytedance.android.live.base.api.MethodChannelService
        public Object invokeMethod(String str, Object... objArr) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str.hashCode();
            if (str.equals("getBiddingToken")) {
                return zx.this.j(objArr);
            }
            return null;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.live.zx$3 */
    class AnonymousClass3 implements ILiveInitCallback {
        AnonymousClass3() {
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public final void onLiveInitFinish() {
            com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "onLiveInitFinish - live sdk init succeed！");
            com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "execute commerce initLiveCommerce method start");
            com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "execute commerce initLiveCommerce end , result: " + com.bytedance.sdk.openadsdk.live.j.j());
            zx.gv.set(true);
            zx.this.y();
            if (zx.f6489j != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(TTLiveConstants.PARAMS_LIVE_SDK_INIT_STATUS, zx.gv.get());
                zx.f6489j.onEvent(2, bundle);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.live.zx$4 */
    class AnonymousClass4 implements Callback<Boolean> {

        /* renamed from: j */
        final /* synthetic */ j f6493j;

        AnonymousClass4(j jVar) {
            jVar = jVar;
        }

        @Override // com.bytedance.android.live.base.api.callback.Callback
        /* renamed from: j */
        public void invoke(Boolean bool) {
            if (jVar != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(TTLiveConstants.PARAMS_LIVE_ROOM_STATUS, bool.booleanValue());
                jVar.onEvent(0, bundle);
            }
        }
    }

    private static final class j implements TTAdEvent {

        /* renamed from: j */
        private TTAdEvent f6494j;
        private EventListener zx;

        /* synthetic */ j(EventListener eventListener, AnonymousClass1 anonymousClass1) {
            this(eventListener);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdEvent
        public void onEvent(int i2, Bundle bundle) {
            TTAdEvent tTAdEvent = this.f6494j;
            if (tTAdEvent != null) {
                tTAdEvent.onEvent(i2, bundle);
            }
            if (this.zx != null) {
                this.zx.onEvent(i2, com.bytedance.sdk.openadsdk.api.zx.j().j(0).j(true).j(i.j().j(0, bundle).zx()).zx());
            }
        }

        /* synthetic */ j(TTAdEvent tTAdEvent, AnonymousClass1 anonymousClass1) {
            this(tTAdEvent);
        }

        private j(TTAdEvent tTAdEvent) {
            this.f6494j = tTAdEvent;
        }

        private j(EventListener eventListener) {
            this.zx = eventListener;
        }
    }

    private zx() {
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    private Boolean gv() {
        try {
            Object callExpandMethod = LivePluginHelper.getLiveRoomService().callExpandMethod("hasAuthenticated", new Object[0]);
            if (callExpandMethod != null && (callExpandMethod instanceof Boolean)) {
                return (Boolean) callExpandMethod;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.j.j("TTLiveSDkBridge", th);
        }
        return Boolean.FALSE;
    }

    private void lg() {
        try {
            LivePluginHelper.getLiveRoomService().callExpandMethod("warmingUpBeforeEnter", new Object[0]);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.j.j("TTLiveSDkBridge", th);
        }
    }

    public void q() {
        String str;
        ITTLiveConfig iTTLiveConfig;
        Plugin plugin;
        StringBuilder sb = new StringBuilder();
        sb.append("hasLiveSDKInited：");
        AtomicBoolean atomicBoolean = gv;
        sb.append(atomicBoolean.get());
        sb.append(", hasLiveInstalled：");
        AtomicBoolean atomicBoolean2 = f6487g;
        sb.append(atomicBoolean2.get());
        com.bytedance.sdk.openadsdk.api.j.i("TTLiveSDkBridge", sb.toString());
        if (this.lg != null) {
            str = "GeneralAppId：" + this.lg.getGeneralAppId() + "，isValid：" + this.lg.isValid();
        } else {
            str = null;
        }
        com.bytedance.sdk.openadsdk.api.j.i("TTLiveSDkBridge", str);
        if (atomicBoolean.get() || !atomicBoolean2.get() || (iTTLiveConfig = this.lg) == null || !iTTLiveConfig.isValid() || (plugin = Zeus.getPlugin("com.byted.live.lite")) == null) {
            return;
        }
        AtomicBoolean atomicBoolean3 = q;
        if (atomicBoolean3.get()) {
            return;
        }
        atomicBoolean3.set(true);
        if (!com.bytedance.sdk.openadsdk.live.j.i(plugin.getVersion())) {
            com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "live sdk init crash more than consecutive 5 times , live plugin had uninstalled ! App cold start will request new live plugin ！");
            com.bytedance.sdk.openadsdk.live.j.g(plugin.getVersion());
            atomicBoolean3.set(false);
            return;
        }
        ILiveHostContextParam.Builder hostActionParam = new ILiveHostContextParam.Builder().setAppName(this.lg.getAppName()).setChannel(this.lg.getChannel()).setIsDebug(this.lg.isDebug()).setECHostAppId(this.lg.getECHostAppId()).setPartner(this.lg.getPartner()).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.zx.2
            AnonymousClass2() {
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return "pangle";
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str2, Object... objArr) {
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                str2.hashCode();
                if (str2.equals("getBiddingToken")) {
                    return zx.this.j(objArr);
                }
                return null;
            }
        }).setPartnerSecret(this.lg.getPartnerSecret()).setHostPermission(this.lg.getHostPermission()).setHostActionParam(new com.bytedance.sdk.openadsdk.live.core.j(this.lg.getLiveHostAction()));
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.k;
        if (iTTLiveTokenInjectionAuth != null) {
            hostActionParam.setInjectionAuth(new com.bytedance.sdk.openadsdk.live.core.zx(iTTLiveTokenInjectionAuth));
        }
        AnonymousClass3 anonymousClass3 = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.zx.3
            AnonymousClass3() {
            }

            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public final void onLiveInitFinish() {
                com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "onLiveInitFinish - live sdk init succeed！");
                com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "execute commerce initLiveCommerce method start");
                com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "execute commerce initLiveCommerce end , result: " + com.bytedance.sdk.openadsdk.live.j.j());
                zx.gv.set(true);
                zx.this.y();
                if (zx.f6489j != null) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(TTLiveConstants.PARAMS_LIVE_SDK_INIT_STATUS, zx.gv.get());
                    zx.f6489j.onEvent(2, bundle);
                }
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            hostActionParam.setContext((Application) TTAppContextHolder.getContext());
        }
        com.bytedance.sdk.openadsdk.live.j.j(plugin.getVersion());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("execute live sdk initLive method start, GeneralAppId:");
        ITTLiveConfig iTTLiveConfig2 = this.lg;
        sb2.append(iTTLiveConfig2 != null ? iTTLiveConfig2.getGeneralAppId() : null);
        com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", sb2.toString());
        Context context = TTAppContextHolder.getContext();
        ITTLiveConfig iTTLiveConfig3 = this.lg;
        com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: " + com.bytedance.sdk.openadsdk.live.j.j(context, iTTLiveConfig3 != null ? iTTLiveConfig3.getGeneralAppId() : null, hostActionParam, anonymousClass3));
        atomicBoolean3.set(false);
        com.bytedance.sdk.openadsdk.live.j.zx((long) plugin.getVersion());
    }

    public void y() {
        if (f6489j != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean("live_plugin_installed", f6487g.get());
                bundle.putBoolean("live_plugin_inited", gv.get());
                f6489j.onEvent(3, bundle);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 5) {
            init((Bundle) valueSet.objectValue(0, Bundle.class));
            return null;
        }
        if (i2 != 6) {
            return (T) callMethod(cls, i2, (Map) valueSet.objectValue(0, Map.class));
        }
        Object objectValue = valueSet.objectValue(0, Object.class);
        if (objectValue instanceof TTAdEvent) {
            subscribe((TTAdEvent) valueSet.objectValue(0, TTAdEvent.class));
        } else if (objectValue instanceof EventListener) {
            f6489j = new j((EventListener) objectValue);
            y();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.j, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i2, Map<String, Object> map) {
        if (i2 == 0) {
            return !gv.get() ? (T) 1 : !com.bytedance.sdk.openadsdk.live.j.j(getContext(map.get("context")), j(map.get(TTLiveConstants.BUNDLE_KEY))) ? (T) 2 : (T) 0;
        }
        if (i2 == 1) {
            return (T) gv;
        }
        if (i2 == 2) {
            i(map);
            return null;
        }
        if (i2 != 3) {
            return i2 != 4 ? i2 != 7 ? i2 != 8 ? (T) super.callMethod(cls, i2, map) : (T) j(map) : (T) zx(map) : (T) gv();
        }
        lg();
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.j, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i2, Map<String, Object> map) {
        return (T) super.getObj(cls, i2, map);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.j, com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
        super.init(bundle);
        ITTLiveConfig iTTLiveConfig = this.lg;
        if (iTTLiveConfig != null && iTTLiveConfig.isValid() && !TextUtils.isEmpty(this.lg.getGeneralAppId()) && !TextUtils.isEmpty(this.lg.getPartner()) && !TextUtils.isEmpty(this.lg.getPartnerSecret())) {
            com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "The configuration has been obtained. Do not repeat initialization");
            return;
        }
        Serializable serializable = bundle.getSerializable(TTLiveConstants.LIVE_INIT_CONFIG_KEY);
        if (serializable instanceof ITTLiveConfig) {
            this.lg = (ITTLiveConfig) serializable;
        }
        try {
            this.y = new JSONObject(bundle.getString(TTLiveConstants.LIVE_INIT_EXTRA_KEY));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        q();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.j, com.bytedance.sdk.openadsdk.TTAdBridge
    public void subscribe(TTAdEvent tTAdEvent) {
        f6489j = new j(tTAdEvent);
        y();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    private void i(Map<String, Object> map) {
        try {
            long longValue = ((Long) map.get(TTLiveConstants.ROOMID_KEY)).longValue();
            Object obj = map.get("event");
            j jVar = obj instanceof TTAdEvent ? new j((TTAdEvent) obj) : new j((EventListener) obj);
            IOuterLiveRoomService liveRoomService = LivePluginHelper.getLiveRoomService();
            System.currentTimeMillis();
            Object callExpandMethod = liveRoomService.callExpandMethod("checkRoomAlive", new Callback<Boolean>() { // from class: com.bytedance.sdk.openadsdk.live.zx.4

                /* renamed from: j */
                final /* synthetic */ j f6493j;

                AnonymousClass4(j jVar2) {
                    jVar = jVar2;
                }

                @Override // com.bytedance.android.live.base.api.callback.Callback
                /* renamed from: j */
                public void invoke(Boolean bool) {
                    if (jVar != null) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(TTLiveConstants.PARAMS_LIVE_ROOM_STATUS, bool.booleanValue());
                        jVar.onEvent(0, bundle);
                    }
                }
            }, Long.valueOf(longValue), 300);
            if (callExpandMethod == null) {
                synchronized (jVar2) {
                    try {
                        jVar2.notifyAll();
                    } catch (Throwable unused) {
                    }
                }
            }
            com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "has checkRoomAlive :" + callExpandMethod);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.j.j("TTLiveSDkBridge", "getRoomState: exception:", th);
        }
    }

    public static zx j() {
        return zx;
    }

    private Object zx(Map<String, Object> map) {
        try {
            String str = (String) map.get(TTLiveConstants.EXPAND_METHOD_NAME_KEY);
            Bundle bundle = (Bundle) map.get(TTLiveConstants.EXPAND_METHOD_PARAM_KEY);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return LivePluginHelper.getLiveRoomService().callExpandMethod(str, bundle);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.j.j("TTLiveSDkBridge", th);
            return null;
        }
    }

    public void j(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.k = iTTLiveTokenInjectionAuth;
    }

    public void j(gv gvVar, Bundle bundle) {
        AtomicBoolean atomicBoolean = f6488i;
        if (atomicBoolean.get()) {
            com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "live PL is loading...just wait");
            return;
        }
        AtomicBoolean atomicBoolean2 = f6487g;
        if (atomicBoolean2.get()) {
            com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "live PL already loaded, dont load again");
            return;
        }
        AnonymousClass1 anonymousClass1 = new TTPluginListener() { // from class: com.bytedance.sdk.openadsdk.live.zx.1
            AnonymousClass1() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTPluginListener
            public Bundle config() {
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.TTPluginListener
            public void onPluginListener(int i2, ClassLoader classLoader, Resources resources, Bundle bundle2) {
                if (1000 == i2) {
                    com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", "live PL install success ， try to init live sdk");
                    zx.f6487g.set(true);
                    zx.f6488i.set(false);
                    zx.this.q();
                } else if (1001 == i2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("live PL install failed, errorCode: ");
                    sb.append(bundle2 == null ? null : bundle2.get("code"));
                    com.bytedance.sdk.openadsdk.api.j.zx("TTLiveSDkBridge", sb.toString());
                    zx.f6487g.set(false);
                    zx.f6488i.set(false);
                }
                zx.this.y();
            }

            @Override // com.bytedance.sdk.openadsdk.TTPluginListener
            public String packageName() {
                return null;
            }
        };
        atomicBoolean.set(true);
        atomicBoolean2.set(false);
        com.bytedance.sdk.openadsdk.live.j.j(gvVar, bundle, anonymousClass1);
    }

    public Object j(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            try {
                Integer num = (Integer) objArr[0];
                TTAdManager adManager = TTAdSdk.getAdManager();
                if (adManager != null) {
                    return adManager.getBiddingToken(new AdSlot.Builder().setAdType(num.intValue()).build());
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private Boolean j(Map<String, Object> map) {
        try {
            String str = (String) map.get(TTLiveConstants.SCHEME_URI_KEY);
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get("context"));
            Uri parse = Uri.parse(str);
            if (parse != null && context != null) {
                return Boolean.valueOf(com.bytedance.sdk.openadsdk.live.j.j(context, parse));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.j.j("TTLiveSDkBridge", th);
            return Boolean.FALSE;
        }
    }

    private Bundle j(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }
}
