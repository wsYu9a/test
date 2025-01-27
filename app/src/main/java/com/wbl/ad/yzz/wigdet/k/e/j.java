package com.wbl.ad.yzz.wigdet.k.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public class j extends ProxySelector {

    /* renamed from: d */
    public static final List<Proxy> f34611d = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: a */
    public final ProxySelector f34612a;

    /* renamed from: b */
    public final String f34613b;

    /* renamed from: c */
    public final int f34614c;

    public j(ProxySelector proxySelector, String str, int i2) {
        this.f34612a = (ProxySelector) m.a(proxySelector);
        this.f34613b = (String) m.a(str);
        this.f34614c = i2;
    }

    public static void a(String str, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7791, null, str, Integer.valueOf(i2));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7786, this, uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7785, this, uri);
    }
}
