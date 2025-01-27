package com.bytedance.sdk.openadsdk.a;

import android.app.Application;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.a.a;

/* loaded from: classes2.dex */
public final class c implements Bridge {

    /* renamed from: a */
    private static volatile c f7967a;

    /* renamed from: b */
    private b f7968b;

    /* renamed from: c */
    private a f7969c = new a();

    /* renamed from: com.bytedance.sdk.openadsdk.a.c$1 */
    public class AnonymousClass1 implements a.InterfaceC0236a {

        /* renamed from: a */
        final /* synthetic */ EventListener f7970a;

        public AnonymousClass1(EventListener eventListener) {
            eventListener = eventListener;
        }

        @Override // com.bytedance.sdk.openadsdk.a.a.InterfaceC0236a
        public void a() {
            eventListener.onEvent(0, null);
        }

        @Override // com.bytedance.sdk.openadsdk.a.a.InterfaceC0236a
        public void b() {
            eventListener.onEvent(1, null);
        }
    }

    private c() {
    }

    public static c a() {
        if (f7967a == null) {
            synchronized (c.class) {
                try {
                    if (f7967a == null) {
                        f7967a = new c();
                    }
                } finally {
                }
            }
        }
        return f7967a;
    }

    public Application.ActivityLifecycleCallbacks b() {
        return this.f7969c;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        Bridge a10;
        switch (i10) {
            case 2:
                return (T) this.f7969c.a();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                b bVar = this.f7968b;
                if (bVar == null || (a10 = bVar.a(4)) == null) {
                    return null;
                }
                return (T) a10.call(i10, valueSet, cls);
            case 9:
                Object objectValue = valueSet.objectValue(0, Object.class);
                if (!(objectValue instanceof EventListener)) {
                    return null;
                }
                a((EventListener) objectValue);
                return null;
            case 10:
                b bVar2 = this.f7968b;
                if (bVar2 == null) {
                    return null;
                }
                return (T) bVar2.a(valueSet.intValue(0));
            default:
                return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.a.a.a.a.b.a().a(10000, 5).b();
    }

    public void a(b bVar) {
        this.f7968b = bVar;
    }

    private void a(EventListener eventListener) {
        this.f7969c.a(new a.InterfaceC0236a() { // from class: com.bytedance.sdk.openadsdk.a.c.1

            /* renamed from: a */
            final /* synthetic */ EventListener f7970a;

            public AnonymousClass1(EventListener eventListener2) {
                eventListener = eventListener2;
            }

            @Override // com.bytedance.sdk.openadsdk.a.a.InterfaceC0236a
            public void a() {
                eventListener.onEvent(0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.a.a.InterfaceC0236a
            public void b() {
                eventListener.onEvent(1, null);
            }
        });
    }
}
