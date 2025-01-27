package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class NetworkMonitor {
    private static volatile boolean abz = false;
    private final List<a> abA;
    private boolean abB;
    private final BroadcastReceiver abC;

    /* renamed from: com.kwad.sdk.core.NetworkMonitor$1 */
    final class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(@NonNull Context context, Intent intent) {
            ConnectivityManager connectivityManager;
            NetworkMonitor networkMonitor;
            NetworkState networkState;
            try {
                if ((ContextCompat.checkSelfPermission(context, g.f9317b) == 0) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                        NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                        return;
                    }
                    if (1 == activeNetworkInfo.getType()) {
                        networkMonitor = NetworkMonitor.this;
                        networkState = NetworkState.NETWORK_WIFI;
                    } else if (activeNetworkInfo.getType() == 0) {
                        networkMonitor = NetworkMonitor.this;
                        networkState = NetworkState.NETWORK_MOBILE;
                    } else {
                        networkMonitor = NetworkMonitor.this;
                        networkState = NetworkState.NETWORK_NONE;
                    }
                    networkMonitor.b(networkState);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    enum Holder {
        INSTANCE;

        private final NetworkMonitor mInstance = new NetworkMonitor((byte) 0);

        Holder() {
        }

        final NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }

    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    public interface a {
        void a(NetworkState networkState);
    }

    private NetworkMonitor() {
        this.abA = new CopyOnWriteArrayList();
        this.abB = false;
        this.abC = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(@NonNull Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                NetworkMonitor networkMonitor;
                NetworkState networkState;
                try {
                    if ((ContextCompat.checkSelfPermission(context, g.f9317b) == 0) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                            return;
                        }
                        if (1 == activeNetworkInfo.getType()) {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_WIFI;
                        } else if (activeNetworkInfo.getType() == 0) {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_MOBILE;
                        } else {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_NONE;
                        }
                        networkMonitor.b(networkState);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    /* synthetic */ NetworkMonitor(byte b2) {
        this();
    }

    private synchronized void aD(Context context) {
        if (abz || context == null) {
            return;
        }
        try {
            context.getApplicationContext().registerReceiver(this.abC, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            abz = true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    public void b(NetworkState networkState) {
        Iterator<a> it = this.abA.iterator();
        while (it.hasNext()) {
            it.next().a(networkState);
        }
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(Context context, @NonNull a aVar) {
        aD(context);
        this.abA.add(aVar);
    }

    public final void a(a aVar) {
        this.abA.remove(aVar);
    }
}
