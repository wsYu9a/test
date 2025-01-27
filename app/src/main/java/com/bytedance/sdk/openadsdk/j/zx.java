package com.bytedance.sdk.openadsdk.j;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.TTAdBridge;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.api.plugin.gv;
import com.bytedance.sdk.openadsdk.j.j;
import java.util.Map;

/* loaded from: classes.dex */
public final class zx implements Bridge, TTAdBridge {

    /* renamed from: j */
    private static volatile zx f6473j;
    private j zx = new j();

    /* renamed from: com.bytedance.sdk.openadsdk.j.zx$1 */
    class AnonymousClass1 implements j.InterfaceC0079j {

        /* renamed from: j */
        final /* synthetic */ TTAdEvent f6474j;

        AnonymousClass1(TTAdEvent tTAdEvent) {
            tTAdEvent = tTAdEvent;
        }

        @Override // com.bytedance.sdk.openadsdk.j.j.InterfaceC0079j
        public void j() {
            tTAdEvent.onEvent(0, null);
        }

        @Override // com.bytedance.sdk.openadsdk.j.j.InterfaceC0079j
        public void zx() {
            tTAdEvent.onEvent(1, null);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.j.zx$2 */
    class AnonymousClass2 implements j.InterfaceC0079j {

        /* renamed from: j */
        final /* synthetic */ EventListener f6475j;

        AnonymousClass2(EventListener eventListener) {
            eventListener = eventListener;
        }

        @Override // com.bytedance.sdk.openadsdk.j.j.InterfaceC0079j
        public void j() {
            eventListener.onEvent(0, null);
        }

        @Override // com.bytedance.sdk.openadsdk.j.j.InterfaceC0079j
        public void zx() {
            eventListener.onEvent(1, null);
        }
    }

    private zx() {
    }

    public static final zx j() {
        if (f6473j == null) {
            synchronized (zx.class) {
                if (f6473j == null) {
                    f6473j = new zx();
                }
            }
        }
        return f6473j;
    }

    /* JADX WARN: Type inference failed for: r1v18, types: [T, java.lang.CharSequence, java.lang.String] */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        switch (i2) {
            case 2:
                return (T) this.zx.j();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
                return (T) Zeus.getPlugin(valueSet.stringValue(0)).mClassLoader;
            case 5:
                return (T) Boolean.valueOf(Zeus.loadPlugin(valueSet.stringValue(0)));
            case 6:
                return (T) Boolean.valueOf(Zeus.isPluginInstalled(valueSet.stringValue(0)));
            case 7:
                return (T) Boolean.valueOf(Zeus.isPluginLoaded(valueSet.stringValue(0)));
            case 8:
                ?? r1 = (T) gv.j(valueSet.stringValue(0));
                return TextUtils.isEmpty(r1) ? "0.0.0.0" : r1;
            case 9:
                Object objectValue = valueSet.objectValue(0, Object.class);
                if (objectValue instanceof TTAdEvent) {
                    subscribe((TTAdEvent) objectValue);
                    return null;
                }
                if (!(objectValue instanceof EventListener)) {
                    return null;
                }
                j((EventListener) objectValue);
                return null;
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public String call(int i2, Bundle bundle) {
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [T, java.lang.CharSequence, java.lang.String] */
    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i2, Map<String, Object> map) {
        switch (i2) {
            case 2:
                return (T) this.zx.j();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
                return (T) Zeus.getPlugin("com.byted.csj.ext").mClassLoader;
            case 5:
                return (T) Boolean.valueOf(Zeus.loadPlugin("com.byted.csj.ext"));
            case 6:
                return (T) Boolean.valueOf(Zeus.isPluginInstalled("com.byted.csj.ext"));
            case 7:
                return (T) Boolean.valueOf(Zeus.isPluginLoaded("com.byted.csj.ext"));
            case 8:
                ?? r1 = (T) gv.j("com.byted.csj.ext");
                return TextUtils.isEmpty(r1) ? "0.0.0.0" : r1;
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i2, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void removeObj(Object obj) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void setObj(Object obj) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void subscribe(TTAdEvent tTAdEvent) {
        this.zx.j(new j.InterfaceC0079j() { // from class: com.bytedance.sdk.openadsdk.j.zx.1

            /* renamed from: j */
            final /* synthetic */ TTAdEvent f6474j;

            AnonymousClass1(TTAdEvent tTAdEvent2) {
                tTAdEvent = tTAdEvent2;
            }

            @Override // com.bytedance.sdk.openadsdk.j.j.InterfaceC0079j
            public void j() {
                tTAdEvent.onEvent(0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.j.j.InterfaceC0079j
            public void zx() {
                tTAdEvent.onEvent(1, null);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void unsubscribe(TTAdEvent tTAdEvent) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public Application.ActivityLifecycleCallbacks zx() {
        return this.zx;
    }

    private void j(EventListener eventListener) {
        this.zx.j(new j.InterfaceC0079j() { // from class: com.bytedance.sdk.openadsdk.j.zx.2

            /* renamed from: j */
            final /* synthetic */ EventListener f6475j;

            AnonymousClass2(EventListener eventListener2) {
                eventListener = eventListener2;
            }

            @Override // com.bytedance.sdk.openadsdk.j.j.InterfaceC0079j
            public void j() {
                eventListener.onEvent(0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.j.j.InterfaceC0079j
            public void zx() {
                eventListener.onEvent(1, null);
            }
        });
    }
}
