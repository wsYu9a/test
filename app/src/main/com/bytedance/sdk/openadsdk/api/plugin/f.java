package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Result;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.a;
import com.bytedance.sdk.openadsdk.api.plugin.e;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class f extends com.bytedance.sdk.openadsdk.api.a {

    /* renamed from: a */
    private static final a f8084a = new a();

    /* renamed from: b */
    private volatile Initializer f8085b;

    /* renamed from: c */
    private d f8086c;

    /* renamed from: d */
    private com.bytedance.sdk.openadsdk.a.b f8087d = new com.bytedance.sdk.openadsdk.a.b() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.1
        public AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.a.b
        public Bridge a(int i10) {
            return f.this.a(i10);
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.f$1 */
    public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.a.b {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.a.b
        public Bridge a(int i10) {
            return f.this.a(i10);
        }
    }

    public static final class a extends a.c {
        private a() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.a.c
        public void a(Throwable th2) {
            e.a(th2);
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bytedance.sdk.openadsdk.api.a.c
        public Object a(Object obj) {
            boolean z10 = obj instanceof TTPluginListener;
            if (z10) {
                e.a(TTAppContextHolder.getContext()).a((TTPluginListener) obj);
            }
            if (!z10) {
                return obj instanceof ILiveAdCustomConfig ? com.bytedance.sdk.openadsdk.live.c.a((ILiveAdCustomConfig) obj) : obj;
            }
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            return e.a(TTAppContextHolder.getContext()).a(tTPluginListener.packageName(), tTPluginListener.config());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public boolean b(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.b(context, adConfig, initCallback);
        this.f8086c = d.a("duration");
        if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
            return false;
        }
        c.a(adConfig);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public com.bytedance.sdk.openadsdk.a.b c() {
        return this.f8087d;
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public void a(Result result) {
        if (!result.isSuccess()) {
            c.a(result.code(), result.message(), 0L);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        ExecutorService executorService = (ExecutorService) TTAdSdk.getAdManager().getExtra(ExecutorService.class, bundle);
        if (executorService != null) {
            com.bytedance.sdk.openadsdk.e.a.a().a(executorService);
        }
        c.a();
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public void b(Context context, com.bykv.a.a.a.a.b bVar) {
        d dVar = this.f8086c;
        if (dVar == null) {
            dVar = d.a("duration");
        }
        dVar.b("wait_asyn_cost");
        try {
            Initializer a10 = a(dVar);
            try {
                if (a10 == null) {
                    b(com.bykv.a.a.a.a.a.a().a(false).a(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED).a("Init error").b());
                    return;
                }
                a(a10.getManager());
                try {
                    dVar.a();
                    JSONObject jSONObject = new JSONObject();
                    dVar.a(jSONObject, 20L);
                    jSONObject.put("zeus", e.a(TTAppContextHolder.getContext()).a());
                    a10.init(context, bVar.a(9, jSONObject).b());
                    if (context != null) {
                        Zeus.hookHuaWeiVerifier((Application) context.getApplicationContext());
                    }
                } catch (Exception e10) {
                    Zeus.unInstallPlugin("com.byted.pangle");
                    b(com.bykv.a.a.a.a.a.a().a(false).a(4207).a("Init error").b());
                    throw e10;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                b(com.bykv.a.a.a.a.a.a().a(false).a(4203).a("UnExpected initializer error :" + th2.getMessage()).b());
            }
        } catch (com.bytedance.sdk.openadsdk.api.plugin.a e11) {
            e11.printStackTrace();
            b(com.bykv.a.a.a.a.a.a().a(false).a(e11.a()).a(e11.getMessage()).b());
        }
    }

    public Bridge a(int i10) {
        if (i10 == 2) {
            return com.bytedance.sdk.openadsdk.live.c.a();
        }
        if (i10 == 3) {
            return com.bytedance.sdk.openadsdk.downloadnew.d.a(TTAppContextHolder.getContext());
        }
        if (i10 != 4) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.api.plugin.a.a.a();
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public boolean a(Context context, com.bykv.a.a.a.a.b bVar) {
        if (this.f8085b == null) {
            return false;
        }
        this.f8085b.init(context, bVar.b());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public boolean a() {
        if (this.f8085b != null) {
            return this.f8085b.isInitSuccess();
        }
        return false;
    }

    private Initializer a(d dVar) throws com.bytedance.sdk.openadsdk.api.plugin.a {
        if (this.f8085b == null) {
            synchronized (this) {
                try {
                    if (this.f8085b == null) {
                        com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "Create initializer");
                        this.f8085b = b(dVar);
                    }
                } finally {
                }
            }
        }
        return this.f8085b;
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public a.c b() {
        return f8084a;
    }

    private static Initializer b(d dVar) throws com.bytedance.sdk.openadsdk.api.plugin.a {
        try {
            dVar.b("call_create_initializer");
            BaseDexClassLoader a10 = e.a(TTAppContextHolder.getContext()).a(dVar);
            if (a10 != null) {
                Class<?> loadClass = a10.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
                dVar.b("get_init_class_cost");
                Bundle bundle = new Bundle();
                bundle.putLong("call_init_time", dVar.b());
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new e.c());
                dVar.b("create_bundle_cost");
                Method declaredMethod = loadClass.getDeclaredMethod("getNewInstance", Bundle.class);
                dVar.b("get_init_method_cost");
                try {
                    Initializer initializer = (Initializer) declaredMethod.invoke(null, bundle);
                    dVar.b("get_init_instance_cost");
                    com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "Create initializer success");
                    return initializer;
                } catch (Throwable th2) {
                    Zeus.unInstallPlugin("com.byted.pangle");
                    throw th2;
                }
            }
            throw new com.bytedance.sdk.openadsdk.api.plugin.a(4205, "Get initializer failed");
        } catch (Throwable th3) {
            if (th3 instanceof com.bytedance.sdk.openadsdk.api.plugin.a) {
                throw new com.bytedance.sdk.openadsdk.api.plugin.a(4205, "(" + th3.a() + ", " + th3.getMessage() + ")");
            }
            throw new com.bytedance.sdk.openadsdk.api.plugin.a(4206, th3.getMessage());
        }
    }
}
