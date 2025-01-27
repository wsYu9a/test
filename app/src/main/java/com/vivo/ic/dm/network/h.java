package com.vivo.ic.dm.network;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.vivo.ic.VLog;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a */
    private static final String f28539a = "MutiNetManager";

    /* renamed from: b */
    public static final int f28540b = -1;

    /* renamed from: c */
    public static final int f28541c = 0;

    /* renamed from: d */
    public static final int f28542d = 1;

    /* renamed from: e */
    public static final int f28543e = 2;

    /* renamed from: f */
    public static final int f28544f = 20;

    /* renamed from: g */
    public static final int f28545g = 21;

    /* renamed from: h */
    public static final int f28546h = 30;

    /* renamed from: i */
    public static final int f28547i = 31;

    /* renamed from: j */
    public static final int f28548j = 32;
    public static final int k = 33;
    public static final int l = 34;
    public static final int m = 35;
    private static h n = null;
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 2;
    private volatile Network r;
    private volatile Network s;
    ConnectivityManager.NetworkCallback t;
    ConnectivityManager.NetworkCallback u;

    class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            h.this.r = network;
            VLog.i(h.f28539a, "TRANSPORT_EXTWIFI " + h.this.r);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i2) {
            super.onLosing(network, i2);
            h.this.r = null;
            VLog.i(h.f28539a, "TRANSPORT_EXTWIFI onLosing " + h.this.r);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            h.this.r = null;
            VLog.i(h.f28539a, "TRANSPORT_EXTWIFI onLost " + h.this.r);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            h.this.r = null;
            VLog.i(h.f28539a, "TRANSPORT_EXTWIFI onUnavailable " + h.this.r);
        }
    }

    class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            h.this.s = network;
            VLog.i(h.f28539a, "TRANSPORT_WIFI onAvailable " + h.this.s);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i2) {
            super.onLosing(network, i2);
            h.this.s = null;
            VLog.i(h.f28539a, "TRANSPORT_WIFI onLosing " + h.this.s);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            h.this.s = null;
            VLog.i(h.f28539a, "TRANSPORT_WIFI onLost " + h.this.s);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            h.this.s = null;
            VLog.i(h.f28539a, "TRANSPORT_WIFI onUnavailable " + h.this.s);
        }
    }

    class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ConnectivityManager f28551a;

        /* renamed from: b */
        final /* synthetic */ ConnectivityManager.NetworkCallback f28552b;

        c(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
            this.f28551a = connectivityManager;
            this.f28552b = networkCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f28551a.unregisterNetworkCallback(this.f28552b);
                VLog.w(h.f28539a, "unregister net work success ");
            } catch (Exception e2) {
                VLog.w(h.f28539a, "unregister net work error", e2);
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ConnectivityManager f28554a;

        /* renamed from: b */
        final /* synthetic */ NetworkRequest f28555b;

        /* renamed from: c */
        final /* synthetic */ ConnectivityManager.NetworkCallback f28556c;

        /* renamed from: d */
        final /* synthetic */ String f28557d;

        d(ConnectivityManager connectivityManager, NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback, String str) {
            this.f28554a = connectivityManager;
            this.f28555b = networkRequest;
            this.f28556c = networkCallback;
            this.f28557d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f28554a.registerNetworkCallback(this.f28555b, this.f28556c);
            VLog.w(h.f28539a, "register net work success " + this.f28557d);
        }
    }

    static /* synthetic */ class e {

        /* renamed from: a */
        static final /* synthetic */ int[] f28559a;

        static {
            int[] iArr = new int[NetworkInfo.State.values().length];
            f28559a = iArr;
            try {
                iArr[NetworkInfo.State.CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28559a[NetworkInfo.State.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28559a[NetworkInfo.State.SUSPENDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28559a[NetworkInfo.State.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28559a[NetworkInfo.State.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f28559a[NetworkInfo.State.UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private h() {
    }

    public void c(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            VLog.i(f28539a, "Muti wifi not support");
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        a(connectivityManager, this.t);
        a(connectivityManager, this.u);
        this.r = null;
        this.s = null;
        a aVar = new a();
        this.u = aVar;
        a(connectivityManager, "TRANSPORT_EXTWIFI", aVar);
        b bVar = new b();
        this.t = bVar;
        a(connectivityManager, "TRANSPORT_WIFI", bVar);
    }

    public static h a() {
        if (n == null) {
            synchronized (h.class) {
                if (n == null) {
                    n = new h();
                }
            }
        }
        return n;
    }

    public boolean b(Context context) {
        return (this.r == null || com.vivo.ic.dm.p.a.a().f(context)) ? false : true;
    }

    public URLConnection b(URL url, Proxy proxy, int i2) throws IOException {
        Network network = this.r;
        Network network2 = this.s;
        if (i2 == 2) {
            if (network != null) {
                return a(network, url, proxy);
            }
            return null;
        }
        if (network2 != null) {
            return a(network2, url, proxy);
        }
        return a(url, proxy);
    }

    public URLConnection a(URL url, Proxy proxy, int i2) throws IOException {
        if (i2 == 0) {
            i2 = 1;
        }
        Network network = this.r;
        Network network2 = this.s;
        if (network == null || network2 == null || Build.VERSION.SDK_INT < 23) {
            return a(url, proxy);
        }
        if (i2 == 1) {
            return a(network2, url, proxy);
        }
        if (i2 == 2) {
            return a(network, url, proxy);
        }
        return a(url, proxy);
    }

    @SuppressLint({"NewApi"})
    private URLConnection a(Network network, URL url, Proxy proxy) throws IOException {
        if (proxy != null) {
            return network.openConnection(url, proxy);
        }
        return network.openConnection(url);
    }

    private URLConnection a(URL url, Proxy proxy) throws IOException {
        if (proxy != null) {
            return url.openConnection(proxy);
        }
        return url.openConnection();
    }

    private void a(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        if (networkCallback != null && Build.VERSION.SDK_INT >= 21) {
            com.vivo.ic.dm.q.e.b(new c(connectivityManager, networkCallback));
        }
    }

    private void a(ConnectivityManager connectivityManager, String str, ConnectivityManager.NetworkCallback networkCallback) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        try {
            Field declaredField = NetworkCapabilities.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addTransportType(declaredField.getInt(null));
            com.vivo.ic.dm.q.e.b(new d(connectivityManager, builder.build(), networkCallback, str));
        } catch (Exception e2) {
            VLog.w(f28539a, "register net work error", e2);
            if (Build.VERSION.SDK_INT >= 26) {
                networkCallback.onUnavailable();
            }
        }
    }

    public int a(Context context) {
        try {
        } catch (Throwable th) {
            VLog.w(f28539a, "getTypeByDuaWifi error -1", th);
        }
        if (b(context)) {
            return 0;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I);
        if (wifiManager == null) {
            return -1;
        }
        Method method = WifiManager.class.getMethod("supportDualWifi", new Class[0]);
        method.setAccessible(true);
        if (!((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue()) {
            return 1;
        }
        Method method2 = WifiManager.class.getMethod("getDualWifiEnabledState", new Class[0]);
        method2.setAccessible(true);
        if (((Integer) method2.invoke(wifiManager, new Object[0])).intValue() != 1) {
            return 2;
        }
        Method method3 = WifiManager.class.getMethod("getNetworkInfoForExtWifi", new Class[0]);
        method3.setAccessible(true);
        NetworkInfo networkInfo = (NetworkInfo) method3.invoke(wifiManager, new Object[0]);
        if (networkInfo == null) {
            return 20;
        }
        NetworkInfo.State state = networkInfo.getState();
        if (state == null) {
            return 21;
        }
        switch (e.f28559a[state.ordinal()]) {
            case 1:
                return 30;
            case 2:
                return 31;
            case 3:
                return 32;
            case 4:
                return 33;
            case 5:
                return 34;
            case 6:
                return 35;
            default:
                return -1;
        }
    }
}
