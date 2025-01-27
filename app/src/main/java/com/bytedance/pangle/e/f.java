package com.bytedance.pangle.e;

import android.os.SystemClock;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.l;
import java.util.Map;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: com.bytedance.pangle.e.f$1 */
    static class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
            f.b();
        }
    }

    /* renamed from: com.bytedance.pangle.e.f$2 */
    static class AnonymousClass2 implements a {
        AnonymousClass2() {
        }

        @Override // com.bytedance.pangle.e.f.a
        public final boolean a(String str, int i2) {
            return true;
        }
    }

    interface a {
        boolean a(String str, int i2);
    }

    public static void a() {
        if ((i.e() || i.g() || i.b()) && com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.e.f.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    f.b();
                }
            });
        }
    }

    public static synchronized void b() {
        synchronized (f.class) {
            Map<String, ?> all = b.a(Zeus.getAppApplication()).getAll();
            if (all.size() > 0) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                    if ((i.g() ? new e() : i.e() ? new d() : i.b() ? new c() : new a() { // from class: com.bytedance.pangle.e.f.2
                        AnonymousClass2() {
                        }

                        @Override // com.bytedance.pangle.e.f.a
                        public final boolean a(String str, int i2) {
                            return true;
                        }
                    }).a(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                        b.a(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                        l.a().b(entry.getKey(), ((Integer) entry.getValue()).intValue(), true);
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                    } else {
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                    }
                }
            }
        }
    }
}
