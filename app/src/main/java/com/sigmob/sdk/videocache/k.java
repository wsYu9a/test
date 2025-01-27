package com.sigmob.sdk.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class k extends ProxySelector {

    /* renamed from: d */
    public static final List<Proxy> f20642d = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: a */
    public final ProxySelector f20643a;

    /* renamed from: b */
    public final String f20644b;

    /* renamed from: c */
    public final int f20645c;

    public k(ProxySelector proxySelector, String str, int i10) {
        this.f20643a = (ProxySelector) o.a(proxySelector);
        this.f20644b = (String) o.a(str);
        this.f20645c = i10;
    }

    public static void a(String str, int i10) {
        ProxySelector.setDefault(new k(ProxySelector.getDefault(), str, i10));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f20643a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return (this.f20644b.equals(uri.getHost()) && this.f20645c == uri.getPort()) ? f20642d : this.f20643a.select(uri);
    }
}
