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

/* loaded from: classes3.dex */
public final class NetworkMonitor {
    private static volatile boolean ast = false;
    private final List<a> asu;
    private boolean asv;
    private final BroadcastReceiver asw;

    /* renamed from: com.kwad.sdk.core.NetworkMonitor$1 */
    public class AnonymousClass1 extends BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(@NonNull Context context, Intent intent) {
            ConnectivityManager connectivityManager;
            try {
                if (ContextCompat.checkSelfPermission(context, g.f11101b) != 0 || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                    return;
                }
                if (1 == activeNetworkInfo.getType()) {
                    NetworkMonitor.this.b(NetworkState.NETWORK_WIFI);
                } else if (activeNetworkInfo.getType() == 0) {
                    NetworkMonitor.this.b(NetworkState.NETWORK_MOBILE);
                } else {
                    NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public enum Holder {
        INSTANCE;

        private final NetworkMonitor mInstance = new NetworkMonitor((byte) 0);

        Holder() {
        }

        public final NetworkMonitor getInstance() {
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

    public /* synthetic */ NetworkMonitor(byte b10) {
        this();
    }

    public void b(NetworkState networkState) {
        Iterator<a> it = this.asu.iterator();
        while (it.hasNext()) {
            it.next().a(networkState);
        }
    }

    private synchronized void bg(Context context) {
        if (ast || context == null) {
            return;
        }
        try {
            context.getApplicationContext().registerReceiver(this.asw, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            ast = true;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private NetworkMonitor() {
        this.asu = new CopyOnWriteArrayList();
        this.asv = false;
        this.asw = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            public AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(@NonNull Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                try {
                    if (ContextCompat.checkSelfPermission(context, g.f11101b) != 0 || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                        return;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                        NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                        return;
                    }
                    if (1 == activeNetworkInfo.getType()) {
                        NetworkMonitor.this.b(NetworkState.NETWORK_WIFI);
                    } else if (activeNetworkInfo.getType() == 0) {
                        NetworkMonitor.this.b(NetworkState.NETWORK_MOBILE);
                    } else {
                        NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        };
    }

    public final void a(Context context, @NonNull a aVar) {
        bg(context);
        if (this.asu.contains(aVar)) {
            return;
        }
        this.asu.add(aVar);
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.asu.remove(aVar);
    }
}
