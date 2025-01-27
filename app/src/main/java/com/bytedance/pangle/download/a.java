package com.bytedance.pangle.download;

import android.app.Activity;
import com.bytedance.pangle.Zeus;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b */
    private static volatile a f6045b;

    /* renamed from: a */
    public final List<String> f6046a = new CopyOnWriteArrayList();

    /* renamed from: com.bytedance.pangle.download.a$1 */
    final class AnonymousClass1 extends com.bytedance.pangle.a {
        AnonymousClass1() {
        }

        @Override // com.bytedance.pangle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            Iterator it = a.this.f6046a.iterator();
            while (it.hasNext()) {
                it.next();
                b.a();
            }
        }
    }

    public a() {
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(new com.bytedance.pangle.a() { // from class: com.bytedance.pangle.download.a.1
            AnonymousClass1() {
            }

            @Override // com.bytedance.pangle.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                Iterator it = a.this.f6046a.iterator();
                while (it.hasNext()) {
                    it.next();
                    b.a();
                }
            }
        });
    }

    public static a a() {
        if (f6045b == null) {
            synchronized (a.class) {
                if (f6045b == null) {
                    f6045b = new a();
                }
            }
        }
        return f6045b;
    }
}
