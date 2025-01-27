package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.c.a.a.i;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c implements Bridge {

    /* renamed from: a */
    private static final c f8233a = new c();

    /* renamed from: b */
    private ITTLiveTokenInjectionAuth f8234b;

    /* renamed from: c */
    private volatile Bridge f8235c;

    /* renamed from: d */
    private Map<String, String> f8236d;

    /* renamed from: e */
    private volatile b f8237e;

    /* renamed from: com.bytedance.sdk.openadsdk.live.c$1 */
    public class AnonymousClass1 implements MethodChannelService {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.android.live.base.api.MethodChannelService
        public String identity() {
            return MediationConstant.ADN_PANGLE;
        }

        @Override // com.bytedance.android.live.base.api.MethodChannelService
        public Object invokeMethod(String str, Map<String, String> map) {
            if (c.this.f8235c != null) {
                return c.this.f8235c.call(0, com.bykv.a.a.a.a.b.a().a(0, str).a(1, map).b(), Object.class);
            }
            return null;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.live.c$2 */
    public class AnonymousClass2 implements ILiveInitCallback {
        public AnonymousClass2() {
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFailed(String str) {
            com.bytedance.sdk.openadsdk.api.c.a("TTLiveSDkBridge", "onLiveInitFailed! ", str);
            if (c.this.f8237e != null) {
                c.this.f8237e.a(-3, str, false);
            }
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            com.bytedance.sdk.openadsdk.api.c.b("TTLiveSDkBridge", "onLiveInitFinish!");
            com.bytedance.sdk.openadsdk.live.b.a();
            if (c.this.f8237e != null) {
                c.this.f8237e.a(2, null, false);
            }
            c.this.f8236d = null;
            c.this.f8234b = null;
        }
    }

    public static final class a implements Bridge {

        /* renamed from: a */
        private ILiveAdCustomConfig f8240a;

        public a(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.f8240a = iLiveAdCustomConfig;
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
            if (i10 == 0) {
                return (T) Integer.valueOf(this.f8240a.openLR(valueSet.stringValue(0)));
            }
            if (i10 == 1) {
                return (T) this.f8240a.convertToEnterFromMerge(valueSet.intValue(0));
            }
            if (i10 == 2) {
                return (T) this.f8240a.convertToEnterMethod(valueSet.intValue(0), valueSet.booleanValue(1));
            }
            if (i10 == 3) {
                return (T) this.f8240a.invoke(valueSet.intValue(0), (Bundle) valueSet.objectValue(1, Bundle.class));
            }
            if (i10 != 4) {
                return null;
            }
            this.f8240a.onEventV3(valueSet.stringValue(0), (JSONObject) valueSet.objectValue(1, JSONObject.class));
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return com.bykv.a.a.a.a.b.a().a(10000, 1).b();
        }
    }

    public final class b implements TTPluginListener {

        /* renamed from: a */
        int f8241a;

        /* renamed from: b */
        String f8242b;

        private b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public Bundle config() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i10, ClassLoader classLoader, Resources resources, Bundle bundle) {
            a(i10, classLoader, resources, bundle, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public String packageName() {
            return "com.byted.live.lite";
        }

        public /* synthetic */ b(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(int i10, ClassLoader classLoader, Resources resources, Bundle bundle, boolean z10) {
            this.f8241a = i10;
            if (c.this.f8235c != null) {
                c.this.f8235c.call(3, com.bykv.a.a.a.a.b.a().a(0, i10).a(1, classLoader).a(2, resources).a(3, bundle).a(4, c.this.a(z10)).b(), null);
            }
        }

        public void a(int i10, String str, boolean z10) {
            this.f8241a = i10;
            this.f8242b = str;
            if (c.this.f8235c != null) {
                com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a().a(0, i10);
                if (str != null) {
                    a10.a(1, str);
                }
                a10.a(2, c.this.a(z10));
                c.this.f8235c.call(2, a10.b(), null);
            }
        }
    }

    private c() {
    }

    private void c(Map map) {
        ILiveHostContextParam.Builder addHostInitExtra = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get("channel"))).setIsDebug(Boolean.valueOf(String.valueOf(map.get("debug"))).booleanValue()).setECHostAppId(String.valueOf(map.get("ec_host_appid"))).setPartner(String.valueOf(map.get(x2.b.f31818z0))).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.c.1
            public AnonymousClass1() {
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return MediationConstant.ADN_PANGLE;
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                if (c.this.f8235c != null) {
                    return c.this.f8235c.call(0, com.bykv.a.a.a.a.b.a().a(0, str).a(1, map2).b(), Object.class);
                }
                return null;
            }
        }).setPartnerSecret("p_secret").setHostPermission(new com.bytedance.sdk.openadsdk.live.a.a(d(map))).setHostActionParam(new com.bytedance.sdk.openadsdk.live.a.b(this.f8235c)).addHostInitExtra(b(map));
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f8234b;
        if (iTTLiveTokenInjectionAuth != null) {
            addHostInitExtra.setInjectionAuth(new com.bytedance.sdk.openadsdk.live.a.c(iTTLiveTokenInjectionAuth));
        }
        Map<String, String> map2 = this.f8236d;
        if (map2 != null) {
            addHostInitExtra.addHostInitExtra(map2);
        }
        AnonymousClass2 anonymousClass2 = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.c.2
            public AnonymousClass2() {
            }

            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFailed(String str) {
                com.bytedance.sdk.openadsdk.api.c.a("TTLiveSDkBridge", "onLiveInitFailed! ", str);
                if (c.this.f8237e != null) {
                    c.this.f8237e.a(-3, str, false);
                }
            }

            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFinish() {
                com.bytedance.sdk.openadsdk.api.c.b("TTLiveSDkBridge", "onLiveInitFinish!");
                com.bytedance.sdk.openadsdk.live.b.a();
                if (c.this.f8237e != null) {
                    c.this.f8237e.a(2, null, false);
                }
                c.this.f8236d = null;
                c.this.f8234b = null;
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            addHostInitExtra.setContext((Application) TTAppContextHolder.getContext());
        }
        Boolean valueOf = Boolean.valueOf(String.valueOf(map.get("sub_process")));
        com.bytedance.sdk.openadsdk.api.c.a("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: ", Boolean.valueOf(com.bytedance.sdk.openadsdk.live.b.a(TTAppContextHolder.getContext(), String.valueOf(map.get("g_appid")), addHostInitExtra, anonymousClass2, valueOf.booleanValue())), " subProcess=", valueOf);
    }

    private TTCustomController d(Map map) {
        Object obj = map.get("c_control");
        if (obj instanceof Bridge) {
            return new i((Bridge) obj);
        }
        return null;
    }

    private Object e(Map<String, Object> map) {
        try {
            String str = (String) map.get("expand_method_name");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
            Object[] objArr = (Object[]) map.get("expand_method_param");
            if (objArr == null) {
                return liveRoomService.callExpandMethod(str, new Object[0]);
            }
            for (int i10 = 0; i10 < objArr.length; i10++) {
                Object obj = objArr[i10];
                if (obj instanceof Bridge) {
                    objArr[i10] = new com.bytedance.sdk.openadsdk.live.a((Bridge) obj);
                }
            }
            return liveRoomService.callExpandMethod(str, objArr);
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.c.b("TTLiveSDkBridge", th2);
            return null;
        }
    }

    private Boolean f(Map<String, Object> map) {
        try {
            String str = (String) map.get("scheme_uri");
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context a10 = a(map.get(f.X));
            Uri parse = Uri.parse(str);
            if (parse != null && a10 != null) {
                return Boolean.valueOf(com.bytedance.sdk.openadsdk.live.b.a(a10, parse));
            }
            return Boolean.FALSE;
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.c.b("TTLiveSDkBridge", th2);
            return Boolean.FALSE;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 == 5) {
            c((Map) valueSet.objectValue(0, Map.class));
            return null;
        }
        if (i10 != 9) {
            return (T) a(cls, i10, (Map) valueSet.objectValue(0, Map.class));
        }
        this.f8235c = (Bridge) valueSet.objectValue(0, Bridge.class);
        if (this.f8237e == null) {
            this.f8237e = new b();
            Bridge bridge = (Bridge) com.bytedance.sdk.openadsdk.a.c.a().call(10, com.bykv.a.a.a.a.b.a(1).a(0, 4).b(), Bridge.class);
            ValueSet b10 = com.bykv.a.a.a.a.b.a(1).a(0, this.f8237e).b();
            if (bridge != null) {
                bridge.call(106, b10, Void.class);
            }
        } else if (this.f8237e.f8241a == 2 || this.f8237e.f8241a == -3) {
            this.f8237e.a(this.f8237e.f8241a, this.f8237e.f8242b, true);
        } else if (this.f8237e.f8241a != 0) {
            this.f8237e.a(this.f8237e.f8241a, null, null, null, true);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.a.a.a.a.b.a().a(10000, 2).b();
    }

    private Map<String, String> b(Map map) {
        Map<String, Object> userPrivacyConfig;
        HashMap hashMap = new HashMap();
        TTCustomController d10 = d(map);
        if (d10 == null || (userPrivacyConfig = d10.userPrivacyConfig()) == null) {
            return hashMap;
        }
        Object obj = userPrivacyConfig.get("motion_info");
        if ((obj instanceof String) && TextUtils.equals((String) obj, "0")) {
            hashMap.put("can_use_sensor", "false");
        }
        return hashMap;
    }

    public static c a() {
        return f8233a;
    }

    public static Bridge a(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new a(iLiveAdCustomConfig);
    }

    public void a(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f8234b = iTTLiveTokenInjectionAuth;
    }

    private Bundle b(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }

    public void a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.f8236d = map;
    }

    public <T> T a(Class<T> cls, int i10, Map<String, Object> map) {
        if (i10 == 0) {
            if (!com.bytedance.sdk.openadsdk.live.b.a(a(map.get(f.X)), b(map.get("bundle")))) {
                return (T) 2;
            }
            return (T) 0;
        }
        if (i10 == 7) {
            return (T) e(map);
        }
        if (i10 != 8) {
            return null;
        }
        return (T) f(map);
    }

    private Context a(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    public Map a(boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("onlyUpdateState", Boolean.valueOf(z10));
        return hashMap;
    }
}
