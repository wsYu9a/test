package javax.net.ssl;

import java.net.ssl.DefaultSSLSocketFactory;
import java.security.SecureRandom;

/* loaded from: classes4.dex */
public class DefaultSSLContextSpi extends SSLContextSpi {
    private final SSLContextSpi mDelegate;

    public DefaultSSLContextSpi(SSLContextSpi sSLContextSpi) {
        this.mDelegate = sSLContextSpi;
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLEngine engineCreateSSLEngine() {
        return this.mDelegate.engineCreateSSLEngine();
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSessionContext engineGetClientSessionContext() {
        return this.mDelegate.engineGetClientSessionContext();
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLParameters engineGetDefaultSSLParameters() {
        return this.mDelegate.engineGetDefaultSSLParameters();
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSessionContext engineGetServerSessionContext() {
        return this.mDelegate.engineGetServerSessionContext();
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        return this.mDelegate.engineGetServerSocketFactory();
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSocketFactory engineGetSocketFactory() {
        return new DefaultSSLSocketFactory(this.mDelegate.engineGetSocketFactory());
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLParameters engineGetSupportedSSLParameters() {
        return this.mDelegate.engineGetSupportedSSLParameters();
    }

    @Override // javax.net.ssl.SSLContextSpi
    public void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) {
        this.mDelegate.engineInit(keyManagerArr, trustManagerArr, secureRandom);
    }

    public SSLContextSpi getDelegate() {
        return this.mDelegate;
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLEngine engineCreateSSLEngine(String str, int i10) {
        return this.mDelegate.engineCreateSSLEngine(str, i10);
    }
}
