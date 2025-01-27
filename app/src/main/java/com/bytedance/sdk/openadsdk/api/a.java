package com.bytedance.sdk.openadsdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.downloadnew.core.DownloadBridgeFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a */
    private TTAdSdk.InitCallback f7972a;

    /* renamed from: com.bytedance.sdk.openadsdk.api.a$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f7973a;

        /* renamed from: b */
        final /* synthetic */ com.bykv.a.a.a.a.b f7974b;

        public AnonymousClass1(Context context, com.bykv.a.a.a.a.b bVar) {
            context = context;
            a10 = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(context, a10);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.a$a */
    public static abstract class AbstractC0237a<T> {
        private AbstractC0237a() {
        }

        public abstract void a(b<T> bVar, int i10);

        public void a(Throwable th2) {
        }

        public /* synthetic */ AbstractC0237a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public interface b<T> {
        void a(T t10);
    }

    public static abstract class c implements TTAdManager {

        /* renamed from: a */
        private volatile Manager f7979a;

        /* renamed from: b */
        private volatile boolean f7980b;

        /* renamed from: c */
        private List<WeakReference<b<Manager>>> f7981c = new CopyOnWriteArrayList();

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$c$1 */
        public class AnonymousClass1 extends AbstractC0237a<Loader> {

            /* renamed from: a */
            Loader f7982a;

            /* renamed from: b */
            final b<Manager> f7983b;

            /* renamed from: c */
            final /* synthetic */ SoftReference f7984c;

            /* renamed from: com.bytedance.sdk.openadsdk.api.a$c$1$1 */
            public class C02381 implements b<Manager> {
                public C02381() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Manager manager) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    anonymousClass1.f7982a = manager.createLoader((Context) anonymousClass1.f7984c.get());
                }
            }

            /* renamed from: com.bytedance.sdk.openadsdk.api.a$c$1$2 */
            public class AnonymousClass2 implements b<Manager> {

                /* renamed from: a */
                final /* synthetic */ b f7987a;

                public AnonymousClass2(b bVar) {
                    bVar = bVar;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Manager manager) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    c.this.a(anonymousClass1.f7983b);
                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                    anonymousClass12.f7982a = manager.createLoader((Context) anonymousClass12.f7984c.get());
                    bVar.a(AnonymousClass1.this.f7982a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SoftReference softReference) {
                super();
                this.f7984c = softReference;
                this.f7983b = new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.1.1
                    public C02381() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.a.b
                    public void a(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.f7982a = manager.createLoader((Context) anonymousClass1.f7984c.get());
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.AbstractC0237a
            public void a(b<Loader> bVar, int i10) {
                Loader loader = this.f7982a;
                if (loader != null) {
                    bVar.a(loader);
                } else {
                    c.this.a(new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.1.2

                        /* renamed from: a */
                        final /* synthetic */ b f7987a;

                        public AnonymousClass2(b bVar2) {
                            bVar = bVar2;
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.a.b
                        public void a(Manager manager) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c.this.a(anonymousClass1.f7983b);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            anonymousClass12.f7982a = manager.createLoader((Context) anonymousClass12.f7984c.get());
                            bVar.a(AnonymousClass1.this.f7982a);
                        }
                    }, i10 + 10000);
                }
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$c$2 */
        public class AnonymousClass2 implements b<Manager> {

            /* renamed from: a */
            final /* synthetic */ Object f7989a;

            public AnonymousClass2(Object obj) {
                obj = obj;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Manager manager) {
                manager.getBridge(1).call(4, com.bykv.a.a.a.a.b.a(1).a(8, c.this.a(obj)).b(), Void.class);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$c$3 */
        public class AnonymousClass3 implements b<Manager> {

            /* renamed from: a */
            final /* synthetic */ Object f7991a;

            public AnonymousClass3(Object obj) {
                obj = obj;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Manager manager) {
                manager.getBridge(1).call(5, com.bykv.a.a.a.a.b.a(1).a(8, obj).b(), Void.class);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$c$4 */
        public class AnonymousClass4 implements b<Manager> {

            /* renamed from: a */
            final /* synthetic */ Class f7993a;

            /* renamed from: b */
            final /* synthetic */ Bundle f7994b;

            public AnonymousClass4(Class cls, Bundle bundle) {
                cls = cls;
                bundle = bundle;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Manager manager) {
                c.b(c.this.f7979a, cls, bundle);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$c$5 */
        public class AnonymousClass5 implements b<Manager> {

            /* renamed from: a */
            final /* synthetic */ Context f7996a;

            public AnonymousClass5(Context context) {
                context = context;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Manager manager) {
                manager.getBridge(1).call(3, com.bykv.a.a.a.a.b.a(1).a(7, context).b(), Void.class);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$c$6 */
        public class AnonymousClass6 implements b<Manager> {

            /* renamed from: a */
            final /* synthetic */ int f7998a;

            public AnonymousClass6(int i10) {
                i10 = i10;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Manager manager) {
                manager.getBridge(1).call(1, com.bykv.a.a.a.a.b.a().a(11, i10).b(), Void.class);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$c$7 */
        public class AnonymousClass7 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ b f8000a;

            /* renamed from: b */
            final /* synthetic */ int f8001b;

            public AnonymousClass7(b bVar, int i10) {
                bVar = bVar;
                i10 = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (c.this.f7979a != null) {
                        bVar.a(c.this.f7979a);
                    } else {
                        com.bytedance.sdk.openadsdk.api.c.d("_tt_ad_sdk_", "Not ready, no manager: " + i10);
                    }
                } catch (Throwable th2) {
                    com.bytedance.sdk.openadsdk.api.c.d("_tt_ad_sdk_", "Unexpected manager call error: " + th2.getMessage());
                    c.this.a(th2);
                }
            }
        }

        public static <T> T b(Manager manager, Class<T> cls, Bundle bundle) {
            return (T) manager.getBridge(1).call(6, com.bykv.a.a.a.a.b.a(2).a(9, cls).a(10, bundle).b(), cls);
        }

        public Object a(Object obj) {
            return obj;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            return new e(new AnonymousClass1(new SoftReference(context))).a();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(Class<T> cls, Bundle bundle) {
            if (this.f7979a != null) {
                return (T) b(this.f7979a, cls, bundle);
            }
            a(new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.4

                /* renamed from: a */
                final /* synthetic */ Class f7993a;

                /* renamed from: b */
                final /* synthetic */ Bundle f7994b;

                public AnonymousClass4(Class cls2, Bundle bundle2) {
                    cls = cls2;
                    bundle = bundle2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Manager manager) {
                    c.b(c.this.f7979a, cls, bundle);
                }
            }, 6);
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.f7979a != null ? this.f7979a.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "6.4.1.1";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.f7979a != null) {
                return this.f7979a.values().intValue(11);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(Object obj) {
            a(new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.2

                /* renamed from: a */
                final /* synthetic */ Object f7989a;

                public AnonymousClass2(Object obj2) {
                    obj = obj2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Manager manager) {
                    manager.getBridge(1).call(4, com.bykv.a.a.a.a.b.a(1).a(8, c.this.a(obj)).b(), Void.class);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(Context context) {
            a(new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.5

                /* renamed from: a */
                final /* synthetic */ Context f7996a;

                public AnonymousClass5(Context context2) {
                    context = context2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Manager manager) {
                    manager.getBridge(1).call(3, com.bykv.a.a.a.a.b.a(1).a(7, context).b(), Void.class);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(int i10) {
            a(new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.6

                /* renamed from: a */
                final /* synthetic */ int f7998a;

                public AnonymousClass6(int i102) {
                    i10 = i102;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Manager manager) {
                    manager.getBridge(1).call(1, com.bykv.a.a.a.a.b.a().a(11, i10).b(), Void.class);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            HashMap hashMap = new HashMap();
            hashMap.put(TTDownloadField.TT_ACTIVITY, activity);
            hashMap.put(TTDownloadField.TT_EXIT_INSTALL_LISTENER, exitInstallListener);
            return ((Boolean) DownloadBridgeFactory.getDownloadBridge(TTAppContextHolder.getContext()).call(0, com.bykv.a.a.a.a.b.a(1).a(0, hashMap).b(), Boolean.class)).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(Object obj) {
            a(new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.3

                /* renamed from: a */
                final /* synthetic */ Object f7991a;

                public AnonymousClass3(Object obj2) {
                    obj = obj2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Manager manager) {
                    manager.getBridge(1).call(5, com.bykv.a.a.a.a.b.a(1).a(8, obj).b(), Void.class);
                }
            }, 5);
        }

        public void a(Throwable th2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z10, int i10) {
            if (i10 <= 0) {
                i10 = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet b10 = com.bykv.a.a.a.a.b.a(com.bytedance.sdk.openadsdk.c.a.c.b.a(adSlot)).a(13, z10).a(14, i10).b();
            if (this.f7979a != null) {
                return (String) this.f7979a.getBridge(1).call(2, b10, String.class);
            }
            return null;
        }

        public void a(boolean z10) {
            this.f7980b = z10;
        }

        public void a(Manager manager) {
            this.f7979a = manager;
            if (this.f7979a != null) {
                Iterator<WeakReference<b<Manager>>> it = this.f7981c.iterator();
                while (it.hasNext()) {
                    WeakReference<b<Manager>> next = it.next();
                    b<Manager> bVar = next != null ? next.get() : null;
                    if (bVar != null) {
                        bVar.a(manager);
                    }
                }
            }
        }

        public void a(b<Manager> bVar) {
            this.f7981c.add(new WeakReference<>(bVar));
        }

        public void a(b<Manager> bVar, int i10) {
            if (this.f7979a != null) {
                try {
                    bVar.a(this.f7979a);
                    return;
                } catch (Throwable th2) {
                    com.bytedance.sdk.openadsdk.api.c.d("_tt_ad_sdk_", "Unexpected manager call error: " + th2.getMessage());
                    a(th2);
                    return;
                }
            }
            if (!this.f7980b && i10 > 10000) {
                throw new IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
            }
            com.bytedance.sdk.openadsdk.e.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.a.c.7

                /* renamed from: a */
                final /* synthetic */ b f8000a;

                /* renamed from: b */
                final /* synthetic */ int f8001b;

                public AnonymousClass7(b bVar2, int i102) {
                    bVar = bVar2;
                    i10 = i102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.this.f7979a != null) {
                            bVar.a(c.this.f7979a);
                        } else {
                            com.bytedance.sdk.openadsdk.api.c.d("_tt_ad_sdk_", "Not ready, no manager: " + i10);
                        }
                    } catch (Throwable th22) {
                        com.bytedance.sdk.openadsdk.api.c.d("_tt_ad_sdk_", "Unexpected manager call error: " + th22.getMessage());
                        c.this.a(th22);
                    }
                }
            });
        }
    }

    public class d implements EventListener {
        private d() {
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i10, Result result) {
            a.this.b(result);
            return null;
        }

        public /* synthetic */ d(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public void a(Result result) {
    }

    public abstract boolean a();

    public abstract boolean a(Context context, com.bykv.a.a.a.a.b bVar);

    public abstract c b();

    public abstract void b(Context context, com.bykv.a.a.a.a.b bVar);

    public boolean b(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    public abstract com.bytedance.sdk.openadsdk.a.b c();

    public void a(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        com.bytedance.sdk.openadsdk.a.c.a().a(c());
        if (b(context, adConfig, initCallback)) {
            this.f7972a = initCallback;
            com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(com.bytedance.sdk.openadsdk.c.a.c.a.a(adConfig));
            a10.a(1, SystemClock.elapsedRealtime());
            a10.a(5, "main");
            a10.a(4, true);
            a10.a(6, 999);
            a10.a(10, 6411);
            a10.a(11, "6.4.1.1");
            a10.a(12, "com.byted.pangle");
            a10.a(14, false);
            a10.a(16, com.bytedance.sdk.openadsdk.a.c.a());
            Thread currentThread = Thread.currentThread();
            a10.a(2, currentThread.getName());
            a10.a(3, currentThread.getPriority());
            a10.a(15, new d());
            if (!a(context, a10)) {
                com.bytedance.sdk.openadsdk.e.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.a.1

                    /* renamed from: a */
                    final /* synthetic */ Context f7973a;

                    /* renamed from: b */
                    final /* synthetic */ com.bykv.a.a.a.a.b f7974b;

                    public AnonymousClass1(Context context2, com.bykv.a.a.a.a.b a102) {
                        context = context2;
                        a10 = a102;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b(context, a10);
                    }
                });
            }
            b().a(true);
        }
    }

    public void b(Result result) {
        a(result);
        if (result.isSuccess()) {
            com.bytedance.sdk.openadsdk.api.c.b("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.f7972a;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            com.bytedance.sdk.openadsdk.api.c.e("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.f7972a;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.f7972a = null;
    }

    public static class e extends com.bytedance.sdk.openadsdk.c.a.a {

        /* renamed from: a */
        private AbstractC0237a<Loader> f8005a;

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$e$1 */
        public class AnonymousClass1 implements b<Loader> {

            /* renamed from: a */
            final /* synthetic */ ValueSet f8006a;

            /* renamed from: b */
            final /* synthetic */ Bridge f8007b;

            public AnonymousClass1(ValueSet valueSet, Bridge bridge) {
                valueSet = valueSet;
                bridge = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Loader loader) {
                loader.load(5, com.bykv.a.a.a.a.b.a(valueSet).a(1, bridge).b(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$e$10 */
        public class AnonymousClass10 implements b<Loader> {

            /* renamed from: a */
            final /* synthetic */ ValueSet f8009a;

            /* renamed from: b */
            final /* synthetic */ Bridge f8010b;

            public AnonymousClass10(ValueSet valueSet, Bridge bridge) {
                valueSet = valueSet;
                bridge = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Loader loader) {
                loader.load(9, com.bykv.a.a.a.a.b.a(valueSet).a(2, true).a(1, bridge).b(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$e$2 */
        public class AnonymousClass2 implements b<Loader> {

            /* renamed from: a */
            final /* synthetic */ ValueSet f8012a;

            /* renamed from: b */
            final /* synthetic */ Bridge f8013b;

            public AnonymousClass2(ValueSet valueSet, Bridge bridge) {
                valueSet = valueSet;
                bridge = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Loader loader) {
                loader.load(1, com.bykv.a.a.a.a.b.a(valueSet).a(2, true).a(1, bridge).b(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$e$3 */
        public class AnonymousClass3 implements b<Loader> {

            /* renamed from: a */
            final /* synthetic */ ValueSet f8015a;

            /* renamed from: b */
            final /* synthetic */ Bridge f8016b;

            public AnonymousClass3(ValueSet valueSet, Bridge bridge) {
                valueSet = valueSet;
                bridge = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Loader loader) {
                loader.load(6, com.bykv.a.a.a.a.b.a(valueSet).a(1, bridge).b(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$e$4 */
        public class AnonymousClass4 implements b<Loader> {

            /* renamed from: a */
            final /* synthetic */ ValueSet f8018a;

            /* renamed from: b */
            final /* synthetic */ Bridge f8019b;

            public AnonymousClass4(ValueSet valueSet, Bridge bridge) {
                valueSet = valueSet;
                bridge = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Loader loader) {
                loader.load(9, com.bykv.a.a.a.a.b.a(valueSet).a(1, bridge).b(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$e$5 */
        public class AnonymousClass5 implements b<Loader> {

            /* renamed from: a */
            final /* synthetic */ ValueSet f8021a;

            /* renamed from: b */
            final /* synthetic */ Bridge f8022b;

            public AnonymousClass5(ValueSet valueSet, Bridge bridge) {
                valueSet = valueSet;
                bridge = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Loader loader) {
                loader.load(1, com.bykv.a.a.a.a.b.a(valueSet).a(1, bridge).b(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$e$6 */
        public class AnonymousClass6 implements b<Loader> {

            /* renamed from: a */
            final /* synthetic */ ValueSet f8024a;

            /* renamed from: b */
            final /* synthetic */ int f8025b;

            /* renamed from: c */
            final /* synthetic */ Bridge f8026c;

            public AnonymousClass6(ValueSet valueSet, int i10, Bridge bridge) {
                valueSet = valueSet;
                i10 = i10;
                bridge = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Loader loader) {
                loader.load(3, com.bykv.a.a.a.a.b.a(valueSet).a(3, i10).a(1, bridge).b(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$e$7 */
        public class AnonymousClass7 implements b<Loader> {

            /* renamed from: a */
            final /* synthetic */ ValueSet f8028a;

            /* renamed from: b */
            final /* synthetic */ Bridge f8029b;

            public AnonymousClass7(ValueSet valueSet, Bridge bridge) {
                valueSet = valueSet;
                bridge = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Loader loader) {
                loader.load(7, com.bykv.a.a.a.a.b.a(valueSet).a(1, bridge).b(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$e$8 */
        public class AnonymousClass8 implements b<Loader> {

            /* renamed from: a */
            final /* synthetic */ ValueSet f8031a;

            /* renamed from: b */
            final /* synthetic */ Bridge f8032b;

            public AnonymousClass8(ValueSet valueSet, Bridge bridge) {
                valueSet = valueSet;
                bridge = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Loader loader) {
                loader.load(8, com.bykv.a.a.a.a.b.a(valueSet).a(1, bridge).b(), null);
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$e$9 */
        public class AnonymousClass9 implements b<Loader> {

            /* renamed from: a */
            final /* synthetic */ ValueSet f8034a;

            /* renamed from: b */
            final /* synthetic */ Bridge f8035b;

            public AnonymousClass9(ValueSet valueSet, Bridge bridge) {
                valueSet = valueSet;
                bridge = bridge;
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.b
            public void a(Loader loader) {
                loader.load(5, com.bykv.a.a.a.a.b.a(valueSet).a(2, true).a(1, bridge).b(), null);
            }
        }

        public e(AbstractC0237a<Loader> abstractC0237a) {
            this.f8005a = abstractC0237a;
        }

        private void a(b<Loader> bVar, int i10) {
            try {
                com.bytedance.sdk.openadsdk.api.c.b("_tt_ad_sdk_", "load ad slot type: " + i10);
                this.f8005a.a(bVar, i10);
            } catch (Throwable th2) {
                this.f8005a.a(th2);
                throw th2;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void b(ValueSet valueSet, Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.3

                /* renamed from: a */
                final /* synthetic */ ValueSet f8015a;

                /* renamed from: b */
                final /* synthetic */ Bridge f8016b;

                public AnonymousClass3(ValueSet valueSet2, Bridge bridge2) {
                    valueSet = valueSet2;
                    bridge = bridge2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(6, com.bykv.a.a.a.a.b.a(valueSet).a(1, bridge).b(), null);
                }
            }, 6);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void c(ValueSet valueSet, Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.4

                /* renamed from: a */
                final /* synthetic */ ValueSet f8018a;

                /* renamed from: b */
                final /* synthetic */ Bridge f8019b;

                public AnonymousClass4(ValueSet valueSet2, Bridge bridge2) {
                    valueSet = valueSet2;
                    bridge = bridge2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(9, com.bykv.a.a.a.a.b.a(valueSet).a(1, bridge).b(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void d(ValueSet valueSet, Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.5

                /* renamed from: a */
                final /* synthetic */ ValueSet f8021a;

                /* renamed from: b */
                final /* synthetic */ Bridge f8022b;

                public AnonymousClass5(ValueSet valueSet2, Bridge bridge2) {
                    valueSet = valueSet2;
                    bridge = bridge2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(1, com.bykv.a.a.a.a.b.a(valueSet).a(1, bridge).b(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void e(ValueSet valueSet, Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.7

                /* renamed from: a */
                final /* synthetic */ ValueSet f8028a;

                /* renamed from: b */
                final /* synthetic */ Bridge f8029b;

                public AnonymousClass7(ValueSet valueSet2, Bridge bridge2) {
                    valueSet = valueSet2;
                    bridge = bridge2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(7, com.bykv.a.a.a.a.b.a(valueSet).a(1, bridge).b(), null);
                }
            }, 7);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void f(ValueSet valueSet, Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.8

                /* renamed from: a */
                final /* synthetic */ ValueSet f8031a;

                /* renamed from: b */
                final /* synthetic */ Bridge f8032b;

                public AnonymousClass8(ValueSet valueSet2, Bridge bridge2) {
                    valueSet = valueSet2;
                    bridge = bridge2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(8, com.bykv.a.a.a.a.b.a(valueSet).a(1, bridge).b(), null);
                }
            }, 8);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void g(ValueSet valueSet, Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.9

                /* renamed from: a */
                final /* synthetic */ ValueSet f8034a;

                /* renamed from: b */
                final /* synthetic */ Bridge f8035b;

                public AnonymousClass9(ValueSet valueSet2, Bridge bridge2) {
                    valueSet = valueSet2;
                    bridge = bridge2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(5, com.bykv.a.a.a.a.b.a(valueSet).a(2, true).a(1, bridge).b(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void h(ValueSet valueSet, Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.10

                /* renamed from: a */
                final /* synthetic */ ValueSet f8009a;

                /* renamed from: b */
                final /* synthetic */ Bridge f8010b;

                public AnonymousClass10(ValueSet valueSet2, Bridge bridge2) {
                    valueSet = valueSet2;
                    bridge = bridge2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(9, com.bykv.a.a.a.a.b.a(valueSet).a(2, true).a(1, bridge).b(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void i(ValueSet valueSet, Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.2

                /* renamed from: a */
                final /* synthetic */ ValueSet f8012a;

                /* renamed from: b */
                final /* synthetic */ Bridge f8013b;

                public AnonymousClass2(ValueSet valueSet2, Bridge bridge2) {
                    valueSet = valueSet2;
                    bridge = bridge2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(1, com.bykv.a.a.a.a.b.a(valueSet).a(2, true).a(1, bridge).b(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void a(ValueSet valueSet, Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.1

                /* renamed from: a */
                final /* synthetic */ ValueSet f8006a;

                /* renamed from: b */
                final /* synthetic */ Bridge f8007b;

                public AnonymousClass1(ValueSet valueSet2, Bridge bridge2) {
                    valueSet = valueSet2;
                    bridge = bridge2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(5, com.bykv.a.a.a.a.b.a(valueSet).a(1, bridge).b(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void a(ValueSet valueSet, Bridge bridge, int i10) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.6

                /* renamed from: a */
                final /* synthetic */ ValueSet f8024a;

                /* renamed from: b */
                final /* synthetic */ int f8025b;

                /* renamed from: c */
                final /* synthetic */ Bridge f8026c;

                public AnonymousClass6(ValueSet valueSet2, int i102, Bridge bridge2) {
                    valueSet = valueSet2;
                    i10 = i102;
                    bridge = bridge2;
                }

                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(3, com.bykv.a.a.a.a.b.a(valueSet).a(3, i10).a(1, bridge).b(), null);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public Pair<Integer, String> a(Exception exc) {
            com.bytedance.sdk.openadsdk.api.c.d("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(Integer.valueOf(TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED), "Load ad failed: " + exc.getMessage());
        }
    }

    public void a(Manager manager) {
        com.bytedance.sdk.openadsdk.api.c.b("_tt_ad_sdk_", "update manager");
        b().a(manager);
        b().register(com.bytedance.sdk.openadsdk.a.c.a());
    }
}
