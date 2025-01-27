package com.kwad.components.core.n.b.a;

import android.app.Activity;
import android.os.Bundle;
import com.kwad.components.offline.api.core.api.ILifeCycle;
import com.kwad.components.offline.api.core.api.ILifeCycleListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class g implements ILifeCycle {
    private final AtomicInteger OM = new AtomicInteger(1);
    private final Map<Integer, com.kwad.sdk.core.c.d> ON = new HashMap();

    /* renamed from: com.kwad.components.core.n.b.a.g$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.c.d {
        final /* synthetic */ ILifeCycleListener OO;

        public AnonymousClass1(ILifeCycleListener iLifeCycleListener) {
            iLifeCycleListener = iLifeCycleListener;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityCreated */
        public final void a(Activity activity, Bundle bundle) {
            ILifeCycleListener iLifeCycleListener = iLifeCycleListener;
            if (iLifeCycleListener != null) {
                iLifeCycleListener.onActivityCreated(activity, bundle);
            }
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            ILifeCycleListener iLifeCycleListener = iLifeCycleListener;
            if (iLifeCycleListener != null) {
                iLifeCycleListener.onActivityDestroyed(activity);
            }
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            ILifeCycleListener iLifeCycleListener = iLifeCycleListener;
            if (iLifeCycleListener != null) {
                iLifeCycleListener.onActivityPaused(activity);
            }
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            ILifeCycleListener iLifeCycleListener = iLifeCycleListener;
            if (iLifeCycleListener != null) {
                iLifeCycleListener.onActivityResumed(activity);
            }
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            ILifeCycleListener iLifeCycleListener = iLifeCycleListener;
            if (iLifeCycleListener != null) {
                iLifeCycleListener.onBackToBackground();
            }
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            ILifeCycleListener iLifeCycleListener = iLifeCycleListener;
            if (iLifeCycleListener != null) {
                iLifeCycleListener.onBackToForeground();
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILifeCycle
    public final Activity getCurrentActivity() {
        com.kwad.sdk.core.c.b.Fi();
        return com.kwad.sdk.core.c.b.getCurrentActivity();
    }

    @Override // com.kwad.components.offline.api.core.api.ILifeCycle
    public final boolean isAppOnForeground() {
        com.kwad.sdk.core.c.b.Fi();
        return com.kwad.sdk.core.c.b.isAppOnForeground();
    }

    @Override // com.kwad.components.offline.api.core.api.ILifeCycle
    public final int registerLifeCycleListener(ILifeCycleListener iLifeCycleListener) {
        AnonymousClass1 anonymousClass1 = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.n.b.a.g.1
            final /* synthetic */ ILifeCycleListener OO;

            public AnonymousClass1(ILifeCycleListener iLifeCycleListener2) {
                iLifeCycleListener = iLifeCycleListener2;
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onActivityCreated(activity, bundle);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(Activity activity) {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onActivityDestroyed(activity);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityPaused */
            public final void c(Activity activity) {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onActivityPaused(activity);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityResumed */
            public final void d(Activity activity) {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onActivityResumed(activity);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onBackToBackground();
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onBackToForeground();
                }
            }
        };
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.a(anonymousClass1);
        int incrementAndGet = this.OM.incrementAndGet();
        this.ON.put(Integer.valueOf(incrementAndGet), anonymousClass1);
        return incrementAndGet;
    }

    @Override // com.kwad.components.offline.api.core.api.ILifeCycle
    public final void unregisterLifeCycleListener(int i10) {
        com.kwad.sdk.core.c.d dVar = this.ON.get(Integer.valueOf(i10));
        if (dVar != null) {
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) dVar);
        }
        this.ON.remove(Integer.valueOf(i10));
    }
}
