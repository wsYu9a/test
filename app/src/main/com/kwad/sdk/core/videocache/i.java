package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.au;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
final class i extends ProxySelector {
    private static final List<Proxy> aGD = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector aGE;
    private final String aGF;
    private final int aGG;

    private i(ProxySelector proxySelector, String str, int i10) {
        this.aGE = (ProxySelector) au.checkNotNull(proxySelector);
        this.aGF = au.gV(str);
        this.aGG = i10;
    }

    public static void install(String str, int i10) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i10));
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.aGE.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return (this.aGF.equals(uri.getHost()) && this.aGG == uri.getPort()) ? aGD : this.aGE.select(uri);
    }
}
