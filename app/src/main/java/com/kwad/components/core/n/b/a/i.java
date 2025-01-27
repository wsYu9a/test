package com.kwad.components.core.n.b.a;

import android.content.Context;
import com.kwad.components.offline.api.core.network.INetworkChangeListener;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bt;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class i implements INetworkManager {
    private List<INetworkChangeListener> OQ = new CopyOnWriteArrayList();
    private NetworkMonitor.a OR;

    /* renamed from: com.kwad.components.core.n.b.a.i$1 */
    public class AnonymousClass1 implements NetworkMonitor.a {
        final /* synthetic */ Context hB;

        /* renamed from: com.kwad.components.core.n.b.a.i$1$1 */
        public class RunnableC04351 implements Runnable {
            public RunnableC04351() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                int networkType = i.this.getNetworkType(context);
                Iterator it = i.this.OQ.iterator();
                while (it.hasNext()) {
                    ((INetworkChangeListener) it.next()).networkChange(networkType);
                }
            }
        }

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.n.b.a.i.1.1
                public RunnableC04351() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    int networkType = i.this.getNetworkType(context);
                    Iterator it = i.this.OQ.iterator();
                    while (it.hasNext()) {
                        ((INetworkChangeListener) it.next()).networkChange(networkType);
                    }
                }
            });
        }
    }

    private void ar(Context context) {
        if (this.OR != null) {
            return;
        }
        this.OR = new NetworkMonitor.a() { // from class: com.kwad.components.core.n.b.a.i.1
            final /* synthetic */ Context hB;

            /* renamed from: com.kwad.components.core.n.b.a.i$1$1 */
            public class RunnableC04351 implements Runnable {
                public RunnableC04351() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    int networkType = i.this.getNetworkType(context);
                    Iterator it = i.this.OQ.iterator();
                    while (it.hasNext()) {
                        ((INetworkChangeListener) it.next()).networkChange(networkType);
                    }
                }
            }

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.core.NetworkMonitor.a
            public final void a(NetworkMonitor.NetworkState networkState) {
                bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.n.b.a.i.1.1
                    public RunnableC04351() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        int networkType = i.this.getNetworkType(context);
                        Iterator it = i.this.OQ.iterator();
                        while (it.hasNext()) {
                            ((INetworkChangeListener) it.next()).networkChange(networkType);
                        }
                    }
                });
            }
        };
        NetworkMonitor.getInstance().a(context2, this.OR);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        if (iNetworkChangeListener != null) {
            ar(context);
            this.OQ.add(iNetworkChangeListener);
        }
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final int getNetworkType(Context context) {
        return al.cC(context);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        this.OQ.remove(iNetworkChangeListener);
    }
}
