package com.bytedance.pangle.download;

import android.app.Activity;
import com.bytedance.pangle.Zeus;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: b */
    private static volatile a f7540b;

    /* renamed from: a */
    public final List<String> f7541a = new CopyOnWriteArrayList();

    /* renamed from: com.bytedance.pangle.download.a$1 */
    public class AnonymousClass1 extends com.bytedance.pangle.a {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.pangle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            Iterator it = a.this.f7541a.iterator();
            while (it.hasNext()) {
                it.next();
                b.a();
            }
        }
    }

    public a() {
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(new com.bytedance.pangle.a() { // from class: com.bytedance.pangle.download.a.1
            public AnonymousClass1() {
            }

            @Override // com.bytedance.pangle.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                Iterator it = a.this.f7541a.iterator();
                while (it.hasNext()) {
                    it.next();
                    b.a();
                }
            }
        });
    }

    public static a a() {
        if (f7540b == null) {
            synchronized (a.class) {
                try {
                    if (f7540b == null) {
                        f7540b = new a();
                    }
                } finally {
                }
            }
        }
        return f7540b;
    }
}
