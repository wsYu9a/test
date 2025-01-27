package com.kwad.components.core.n.b;

import android.content.Context;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.n.b.a.j;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.c.c;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class b {
    private static final AtomicBoolean LB = new AtomicBoolean();

    /* renamed from: com.kwad.components.core.n.b.b$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.aq(context);
        }
    }

    @ForInvoker(methodId = "initOC")
    public static void aq(Context context) {
        com.kwad.components.offline.a.b.ay(context);
        com.kwad.components.offline.b.b.ay(context);
        c.ay(context);
    }

    public static void init(Context context) {
        AtomicBoolean atomicBoolean = LB;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        OfflineHostProvider.get().init(context, new j());
        h.execute(new bd() { // from class: com.kwad.components.core.n.b.b.1
            final /* synthetic */ Context hB;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                b.aq(context);
            }
        });
    }
}
