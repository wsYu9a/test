package java.net.ssl;

import androidx.annotation.Keep;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes4.dex */
public class DefaultSSLSocketFactory extends SSLSocketFactory {
    private final SSLSocketFactory mSSLSocketFactory;

    @Keep
    private Object sslParameters;

    public DefaultSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslParameters = null;
        this.mSSLSocketFactory = sSLSocketFactory;
        try {
            this.sslParameters = Cif.f(sSLSocketFactory).j("sslParameters");
        } catch (Throwable th2) {
            SSLSocketLogger.handleException(th2);
        }
    }

    public static SocketFactory getDefault() {
        return SSLSocketFactory.getDefault();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        return SSLSocketLogger.onCreateSocket((SSLSocket) this.mSSLSocketFactory.createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.mSSLSocketFactory.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.mSSLSocketFactory.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) {
        return SSLSocketLogger.onCreateSocket((SSLSocket) this.mSSLSocketFactory.createSocket(str, i10));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) {
        return SSLSocketLogger.onCreateSocket((SSLSocket) this.mSSLSocketFactory.createSocket(str, i10, inetAddress, i11));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10) {
        return SSLSocketLogger.onCreateSocket((SSLSocket) this.mSSLSocketFactory.createSocket(inetAddress, i10));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) {
        return SSLSocketLogger.onCreateSocket((SSLSocket) this.mSSLSocketFactory.createSocket(inetAddress, i10, inetAddress2, i11));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) {
        return SSLSocketLogger.onCreateSocket((SSLSocket) this.mSSLSocketFactory.createSocket(socket, str, i10, z10));
    }
}
