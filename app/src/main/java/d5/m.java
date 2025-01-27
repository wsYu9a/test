package d5;

import b5.u;
import com.google.common.cache.RemovalNotification;
import java.util.concurrent.Executor;

@a5.c
@d
/* loaded from: classes2.dex */
public final class m {
    public static <K, V> j<K, V> c(j<K, V> jVar, Executor executor) {
        u.E(jVar);
        u.E(executor);
        return new j() { // from class: d5.l

            /* renamed from: b */
            public final /* synthetic */ Executor f25259b;

            /* renamed from: c */
            public final /* synthetic */ j f25260c;

            public /* synthetic */ l(Executor executor2, j jVar2) {
                executor = executor2;
                jVar = jVar2;
            }

            @Override // d5.j
            public final void onRemoval(RemovalNotification removalNotification) {
                m.e(executor, jVar, removalNotification);
            }
        };
    }

    public static /* synthetic */ void e(Executor executor, j jVar, RemovalNotification removalNotification) {
        executor.execute(new Runnable() { // from class: d5.k

            /* renamed from: c */
            public final /* synthetic */ RemovalNotification f25258c;

            public /* synthetic */ k(RemovalNotification removalNotification2) {
                removalNotification = removalNotification2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                j.this.onRemoval(removalNotification);
            }
        });
    }
}
