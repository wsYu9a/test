package cn.vlion.ad.inland.base;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil;

/* loaded from: classes.dex */
public final class n5 extends ConnectivityManager.NetworkCallback {

    /* renamed from: a */
    public Application f3117a;

    public n5(Application application) {
        this.f3117a = application;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            LogVlion.e("VlionNetWorkCallback onAvailable: 网络已连接" + network);
            NetWorkTypeUtil.f3417d.add(network);
            NetWorkTypeUtil.a(this.f3117a);
            p6 a10 = p6.a();
            synchronized (a10) {
                try {
                    LogVlion.e("VlionTimerManager destroyTimer");
                    if (a10.f3296a != null && !a10.f3296a.isShutdown()) {
                        a10.f3296a.shutdown();
                    }
                } finally {
                    p6.a().b();
                }
            }
            p6.a().b();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onBlockedStatusChanged(Network network, boolean z10) {
        super.onBlockedStatusChanged(network, z10);
        LogVlion.e("VlionNetWorkCallback onBlockedStatusChanged");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities);
        try {
            LogVlion.e("VlionNetWorkCallback 网络状态变化 ");
            NetWorkTypeUtil.a(this.f3117a);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        super.onLinkPropertiesChanged(network, linkProperties);
        LogVlion.e("VlionNetWorkCallback onLinkPropertiesChanged");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        super.onLost(network);
        try {
            try {
                NetWorkTypeUtil.f3417d.remove(network);
                NetWorkTypeUtil.f3416c = network;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            LogVlion.e("VlionNetWorkCallback 网络类型已断开");
            NetWorkTypeUtil.a(this.f3117a);
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        super.onUnavailable();
        LogVlion.e("VlionNetWorkCallback onUnavailable");
    }
}
