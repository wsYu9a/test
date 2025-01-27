package org.apache.http.impl.pool;

import b.b.a.b.b;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.pool.ConnFactory;

@Immutable
/* loaded from: classes5.dex */
public class BasicConnFactory implements ConnFactory<HttpHost, HttpClientConnection> {
    private final HttpParams params;
    private final SSLSocketFactory sslfactory;

    public BasicConnFactory(SSLSocketFactory sSLSocketFactory, HttpParams httpParams) {
        if (httpParams == null) {
            throw new IllegalArgumentException("HTTP params may not be null");
        }
        this.sslfactory = sSLSocketFactory;
        this.params = httpParams;
    }

    protected HttpClientConnection create(Socket socket, HttpParams httpParams) throws IOException {
        DefaultHttpClientConnection defaultHttpClientConnection = new DefaultHttpClientConnection();
        defaultHttpClientConnection.bind(socket, httpParams);
        return defaultHttpClientConnection;
    }

    @Override // org.apache.http.pool.ConnFactory
    public HttpClientConnection create(HttpHost httpHost) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        String schemeName = httpHost.getSchemeName();
        Socket socket = HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(schemeName) ? new Socket() : null;
        if (b.f4198a.equalsIgnoreCase(schemeName) && (sSLSocketFactory = this.sslfactory) != null) {
            socket = sSLSocketFactory.createSocket();
        }
        if (socket != null) {
            int connectionTimeout = HttpConnectionParams.getConnectionTimeout(this.params);
            socket.setSoTimeout(HttpConnectionParams.getSoTimeout(this.params));
            socket.connect(new InetSocketAddress(httpHost.getHostName(), httpHost.getPort()), connectionTimeout);
            return create(socket, this.params);
        }
        throw new IOException(schemeName + " scheme is not supported");
    }

    public BasicConnFactory(HttpParams httpParams) {
        this(null, httpParams);
    }
}
