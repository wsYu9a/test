package com.opos.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
class p extends ProxySelector {

    /* renamed from: a */
    private static final List<Proxy> f23840a = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: b */
    private final ProxySelector f23841b;

    /* renamed from: c */
    private final String f23842c;

    /* renamed from: d */
    private final int f23843d;

    p(ProxySelector proxySelector, String str, int i2) {
        this.f23841b = (ProxySelector) f.a(proxySelector);
        this.f23842c = (String) f.a(str);
        this.f23843d = i2;
    }

    static void a(String str, int i2) {
        ProxySelector.setDefault(new p(ProxySelector.getDefault(), str, i2));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f23841b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f23842c.equals(uri.getHost()) && this.f23843d == uri.getPort() ? f23840a : this.f23841b.select(uri);
    }
}
