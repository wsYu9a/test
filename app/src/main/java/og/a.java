package og;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public Context f29185a;

    /* renamed from: b */
    public List<c> f29186b;

    /* renamed from: c */
    public ConnectivityManager f29187c;

    /* renamed from: d */
    public int f29188d;

    /* renamed from: e */
    public int f29189e;

    /* renamed from: f */
    public final BroadcastReceiver f29190f;

    /* renamed from: g */
    @TargetApi(21)
    public ConnectivityManager.NetworkCallback f29191g;

    /* renamed from: og.a$a */
    public class C0754a extends BroadcastReceiver {
        public C0754a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (sg.a.f30663a) {
                sg.a.a("NetworkStateObserver", "onReceive: action = " + action);
            }
            if (TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE")) {
                a.this.d();
                a aVar = a.this;
                if (aVar.f29188d != aVar.f29189e) {
                    aVar.c();
                    a aVar2 = a.this;
                    aVar2.f29188d = aVar2.f29189e;
                }
            }
        }
    }

    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            if (networkCapabilities.hasCapability(16)) {
                if (networkCapabilities.hasTransport(1)) {
                    a.this.f29189e = 1;
                } else if (networkCapabilities.hasTransport(0)) {
                    a.this.d();
                } else if (networkCapabilities.hasTransport(3)) {
                    a.this.f29189e = 9;
                }
            }
            if (sg.a.f30663a) {
                sg.a.a("NetworkStateObserver", "onCapabilitiesChanged: cap = " + networkCapabilities + ", network = " + network + ", currentType = " + a.this.f29189e + ", prevType = " + a.this.f29188d);
            }
            a aVar = a.this;
            if (aVar.f29188d != aVar.f29189e) {
                aVar.c();
                a aVar2 = a.this;
                aVar2.f29188d = aVar2.f29189e;
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            if (sg.a.f30663a) {
                sg.a.a("NetworkStateObserver", "onLost: currentType = " + a.this.f29189e + ", prev = " + a.this.f29188d + ", network = " + network);
            }
            a.this.d();
            a aVar = a.this;
            if (aVar.f29188d != aVar.f29189e) {
                aVar.c();
                a aVar2 = a.this;
                aVar2.f29188d = aVar2.f29189e;
            }
        }
    }

    public interface c {
        void a(int i10);
    }

    public static class d {

        /* renamed from: a */
        public static final a f29194a = new a((byte) 0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public synchronized void a(c cVar) {
        try {
            if (sg.a.f30663a) {
                sg.a.a("NetworkStateObserver", "addNetworkChangeListener: listener = " + cVar);
            }
            this.f29186b.add(cVar);
            cVar.a(this.f29189e);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public boolean b() {
        return this.f29189e != -1;
    }

    public synchronized void c() {
        try {
            if (sg.a.f30663a) {
                sg.a.a("NetworkStateObserver", "notifyNetworkStateChanged: mPrevNetworkType = " + this.f29188d + ", mCurrentNetworkType = " + this.f29189e);
            }
            Iterator<c> it = this.f29186b.iterator();
            while (it.hasNext()) {
                it.next().a(this.f29189e);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void d() {
        NetworkInfo networkInfo;
        try {
            networkInfo = this.f29187c.getActiveNetworkInfo();
        } catch (Exception e10) {
            sg.a.b("NetworkStateObserver", "getActiveNetworkType exception.", e10);
            networkInfo = null;
        }
        if (networkInfo == null) {
            this.f29189e = -1;
            if (sg.a.f30663a) {
                sg.a.a("NetworkStateObserver", "getActiveNetworkType with null network info.");
                return;
            }
            return;
        }
        if (networkInfo.getType() == 1 && networkInfo.isConnected()) {
            this.f29189e = 1;
        } else if (networkInfo.getType() == 0 && networkInfo.isConnected()) {
            this.f29189e = 0;
        } else if (networkInfo.getType() == 9 && networkInfo.isConnected()) {
            this.f29189e = 9;
        } else {
            this.f29189e = -1;
        }
        if (sg.a.f30663a) {
            sg.a.a("NetworkStateObserver", "getActiveNetworkType: mPrevNetworkType = " + this.f29188d + ", mCurrentNetworkType = " + this.f29189e + ", networkInfo = " + networkInfo);
        }
    }

    public final void e() {
        try {
            if (Build.VERSION.SDK_INT < 23) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.f29185a.registerReceiver(this.f29190f, intentFilter);
            } else {
                NetworkRequest build = new NetworkRequest.Builder().build();
                if (this.f29191g == null) {
                    this.f29191g = new b();
                }
                this.f29187c.registerNetworkCallback(build, this.f29191g);
            }
        } catch (Throwable th2) {
            sg.a.b("NetworkStateObserver", "registerNetworkState exception.", th2);
        }
    }

    public a() {
        this.f29188d = -1;
        this.f29189e = -1;
        this.f29190f = new C0754a();
        this.f29185a = hg.c.c().e();
        this.f29186b = new LinkedList();
        try {
            this.f29187c = (ConnectivityManager) this.f29185a.getSystemService("connectivity");
        } catch (Exception e10) {
            sg.a.b("NetworkStateObserver", "get ConnectivityManager exception", e10);
        }
        e();
        d();
    }
}
