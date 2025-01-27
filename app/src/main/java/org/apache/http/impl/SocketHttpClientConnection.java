package org.apache.http.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import org.apache.http.HttpInetConnection;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.io.SocketInputBuffer;
import org.apache.http.impl.io.SocketOutputBuffer;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

@NotThreadSafe
/* loaded from: classes5.dex */
public class SocketHttpClientConnection extends AbstractHttpClientConnection implements HttpInetConnection {
    private volatile boolean open;
    private volatile Socket socket = null;

    private static void formatAddress(StringBuilder sb, SocketAddress socketAddress) {
        if (!(socketAddress instanceof InetSocketAddress)) {
            sb.append(socketAddress);
            return;
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        sb.append(inetSocketAddress.getAddress() != null ? inetSocketAddress.getAddress().getHostAddress() : inetSocketAddress.getAddress());
        sb.append(':');
        sb.append(inetSocketAddress.getPort());
    }

    protected void assertNotOpen() {
        if (this.open) {
            throw new IllegalStateException("Connection is already open");
        }
    }

    @Override // org.apache.http.impl.AbstractHttpClientConnection
    protected void assertOpen() {
        if (!this.open) {
            throw new IllegalStateException("Connection is not open");
        }
    }

    protected void bind(Socket socket, HttpParams httpParams) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("Socket may not be null");
        }
        if (httpParams == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        this.socket = socket;
        int socketBufferSize = HttpConnectionParams.getSocketBufferSize(httpParams);
        init(createSessionInputBuffer(socket, socketBufferSize, httpParams), createSessionOutputBuffer(socket, socketBufferSize, httpParams), httpParams);
        this.open = true;
    }

    @Override // org.apache.http.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.open) {
            this.open = false;
            Socket socket = this.socket;
            try {
                doFlush();
                try {
                    try {
                        socket.shutdownOutput();
                    } catch (IOException | UnsupportedOperationException unused) {
                    }
                } catch (IOException unused2) {
                }
                socket.shutdownInput();
            } finally {
                socket.close();
            }
        }
    }

    protected SessionInputBuffer createSessionInputBuffer(Socket socket, int i2, HttpParams httpParams) throws IOException {
        return new SocketInputBuffer(socket, i2, httpParams);
    }

    protected SessionOutputBuffer createSessionOutputBuffer(Socket socket, int i2, HttpParams httpParams) throws IOException {
        return new SocketOutputBuffer(socket, i2, httpParams);
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        if (this.socket != null) {
            return this.socket.getLocalAddress();
        }
        return null;
    }

    @Override // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        if (this.socket != null) {
            return this.socket.getLocalPort();
        }
        return -1;
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        if (this.socket != null) {
            return this.socket.getInetAddress();
        }
        return null;
    }

    @Override // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        if (this.socket != null) {
            return this.socket.getPort();
        }
        return -1;
    }

    protected Socket getSocket() {
        return this.socket;
    }

    @Override // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        if (this.socket != null) {
            try {
                return this.socket.getSoTimeout();
            } catch (SocketException unused) {
            }
        }
        return -1;
    }

    @Override // org.apache.http.HttpConnection
    public boolean isOpen() {
        return this.open;
    }

    @Override // org.apache.http.HttpConnection
    public void setSocketTimeout(int i2) {
        assertOpen();
        if (this.socket != null) {
            try {
                this.socket.setSoTimeout(i2);
            } catch (SocketException unused) {
            }
        }
    }

    @Override // org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        this.open = false;
        Socket socket = this.socket;
        if (socket != null) {
            socket.close();
        }
    }

    public String toString() {
        if (this.socket == null) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        SocketAddress remoteSocketAddress = this.socket.getRemoteSocketAddress();
        SocketAddress localSocketAddress = this.socket.getLocalSocketAddress();
        if (remoteSocketAddress != null && localSocketAddress != null) {
            formatAddress(sb, localSocketAddress);
            sb.append("<->");
            formatAddress(sb, remoteSocketAddress);
        }
        return sb.toString();
    }
}
