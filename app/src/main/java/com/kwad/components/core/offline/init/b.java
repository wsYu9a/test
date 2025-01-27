package com.kwad.components.core.offline.init;

import android.content.Context;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.offline.init.kwai.g;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.utils.aw;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class b {
    private static final AtomicBoolean Ip = new AtomicBoolean();

    /* renamed from: com.kwad.components.core.offline.init.b$1 */
    /* loaded from: classes2.dex */
    static class AnonymousClass1 extends aw {
        final /* synthetic */ Context jN;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            b.af(context);
        }
    }

    @ForInvoker(methodId = "initOC")
    public static void af(Context context) {
        com.kwad.components.offline.adLive.a.ak(context);
        com.kwad.components.offline.obiwan.a.ak(context);
        com.kwad.components.offline.tk.b.ak(context);
    }

    public static void init(Context context) {
        AtomicBoolean atomicBoolean = Ip;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        OfflineHostProvider.get().init(context, new g());
        com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.components.core.offline.init.b.1
            final /* synthetic */ Context jN;

            AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                b.af(context);
            }
        });
    }
}
