package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.kwad.sdk.m.e;
import com.martian.ads.ad.AdConfig;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m5.c;
import m5.d;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.CipherSuite;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Timeout;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 {2\u00020\u00012\u00020\u0002:\u0001{B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u00105\u001a\u000206J\u0018\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u0002092\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J>\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ%\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020IH\u0000¢\u0006\u0002\bJJ(\u0010K\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010L\u001a\u0002062\u0006\u0010M\u001a\u00020NH\u0002J0\u0010O\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J*\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010R\u001a\u00020Q2\u0006\u00108\u001a\u000209H\u0002J\b\u0010S\u001a\u00020QH\u0002J(\u0010T\u001a\u0002062\u0006\u0010M\u001a\u00020N2\u0006\u0010>\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\r\u0010U\u001a\u000206H\u0000¢\u0006\u0002\bVJ%\u0010W\u001a\u00020\u001d2\u0006\u0010X\u001a\u00020Y2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010[H\u0000¢\u0006\u0002\b\\J\u000e\u0010]\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001dJ\u001d\u0010_\u001a\u00020`2\u0006\u0010E\u001a\u00020F2\u0006\u0010a\u001a\u00020bH\u0000¢\u0006\u0002\bcJ\u0015\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0000¢\u0006\u0002\bhJ\r\u0010 \u001a\u000206H\u0000¢\u0006\u0002\biJ\r\u0010!\u001a\u000206H\u0000¢\u0006\u0002\bjJ\u0018\u0010k\u001a\u0002062\u0006\u0010l\u001a\u00020\u00152\u0006\u0010m\u001a\u00020nH\u0016J\u0010\u0010o\u001a\u0002062\u0006\u0010p\u001a\u00020qH\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010r\u001a\u00020\u001d2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00060[H\u0002J\b\u00101\u001a\u00020(H\u0016J\u0010\u0010t\u001a\u0002062\u0006\u0010>\u001a\u00020\tH\u0002J\u0010\u0010u\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0002J\b\u0010v\u001a\u00020wH\u0016J\u001f\u0010x\u001a\u0002062\u0006\u0010@\u001a\u00020\r2\b\u0010y\u001a\u0004\u0018\u00010IH\u0000¢\u0006\u0002\bzR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/Connection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;)V", "allocationLimit", "", "calls", "", "Ljava/lang/ref/Reference;", "Lokhttp3/internal/connection/RealCall;", "getCalls", "()Ljava/util/List;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "handshake", "Lokhttp3/Handshake;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "idleAtNs", "", "getIdleAtNs$okhttp", "()J", "setIdleAtNs$okhttp", "(J)V", "isMultiplexed", "", "isMultiplexed$okhttp", "()Z", "noCoalescedConnections", "noNewExchanges", "getNoNewExchanges", "setNoNewExchanges", "(Z)V", "protocol", "Lokhttp3/Protocol;", "rawSocket", "Ljava/net/Socket;", "refusedStreamCount", "routeFailureCount", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "(I)V", "sink", "Lokio/BufferedSink;", "socket", "source", "Lokio/BufferedSource;", "successCount", "cancel", "", "certificateSupportHost", "url", "Lokhttp3/HttpUrl;", "connect", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "connectFailed", "client", "Lokhttp3/OkHttpClient;", "failedRoute", "failure", "Ljava/io/IOException;", "connectFailed$okhttp", "connectSocket", "connectTls", "connectionSpecSelector", "Lokhttp3/internal/connection/ConnectionSpecSelector;", "connectTunnel", "createTunnel", "Lokhttp3/Request;", "tunnelRequest", "createTunnelRequest", "establishProtocol", "incrementSuccessCount", "incrementSuccessCount$okhttp", "isEligible", "address", "Lokhttp3/Address;", "routes", "", "isEligible$okhttp", "isHealthy", "doExtensiveChecks", "newCodec", "Lokhttp3/internal/http/ExchangeCodec;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "newCodec$okhttp", "newWebSocketStreams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "exchange", "Lokhttp3/internal/connection/Exchange;", "newWebSocketStreams$okhttp", "noCoalescedConnections$okhttp", "noNewExchanges$okhttp", "onSettings", "connection", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", AdConfig.AdType.STREAM, "Lokhttp3/internal/http2/Http2Stream;", "routeMatchesAny", "candidates", "startHttp2", "supportsUrl", "toString", "", "trackFailure", e.TAG, "trackFailure$okhttp", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {

    /* renamed from: Companion, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;

    @k
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit;

    @k
    private final List<Reference<RealCall>> calls;

    @k
    private final RealConnectionPool connectionPool;

    @l
    private Handshake handshake;

    @l
    private Http2Connection http2Connection;
    private long idleAtNs;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;

    @l
    private Protocol protocol;

    @l
    private Socket rawSocket;
    private int refusedStreamCount;

    @k
    private final Route route;
    private int routeFailureCount;

    @l
    private BufferedSink sink;

    @l
    private Socket socket;

    @l
    private BufferedSource source;
    private int successCount;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/RealConnection$Companion;", "", "()V", "IDLE_CONNECTION_HEALTHY_NS", "", "MAX_TUNNEL_ATTEMPTS", "", "NPE_THROW_WITH_NULL", "", "newTestConnection", "Lokhttp3/internal/connection/RealConnection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "socket", "Ljava/net/Socket;", "idleAtNs", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @k
        public final RealConnection newTestConnection(@k RealConnectionPool connectionPool, @k Route route, @k Socket socket, long idleAtNs) {
            Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
            Intrinsics.checkNotNullParameter(route, "route");
            Intrinsics.checkNotNullParameter(socket, "socket");
            RealConnection realConnection = new RealConnection(connectionPool, route);
            realConnection.socket = socket;
            realConnection.setIdleAtNs$okhttp(idleAtNs);
            return realConnection;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RealConnection(@k RealConnectionPool connectionPool, @k Route route) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        this.connectionPool = connectionPool;
        this.route = route;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    private final boolean certificateSupportHost(HttpUrl url, Handshake handshake) {
        List<Certificate> peerCertificates = handshake.peerCertificates();
        return (peerCertificates.isEmpty() ^ true) && OkHostnameVerifier.INSTANCE.verify(url.host(), (X509Certificate) peerCertificates.get(0));
    }

    private final void connectSocket(int connectTimeout, int readTimeout, Call r72, EventListener eventListener) throws IOException {
        Socket createSocket;
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        Proxy.Type type = proxy.type();
        int i10 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i10 == 1 || i10 == 2) {
            createSocket = address.socketFactory().createSocket();
            Intrinsics.checkNotNull(createSocket);
        } else {
            createSocket = new Socket(proxy);
        }
        this.rawSocket = createSocket;
        eventListener.connectStart(r72, this.route.socketAddress(), proxy);
        createSocket.setSoTimeout(readTimeout);
        try {
            Platform.INSTANCE.get().connectSocket(createSocket, this.route.socketAddress(), connectTimeout);
            try {
                this.source = Okio.buffer(Okio.source(createSocket));
                this.sink = Okio.buffer(Okio.sink(createSocket));
            } catch (NullPointerException e10) {
                if (Intrinsics.areEqual(e10.getMessage(), NPE_THROW_WITH_NULL)) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException(Intrinsics.stringPlus("Failed to connect to ", this.route.socketAddress()));
            connectException.initCause(e11);
            throw connectException;
        }
    }

    private final void connectTls(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        Address address = this.route.address();
        SSLSocketFactory sslSocketFactory = address.sslSocketFactory();
        SSLSocket sSLSocket = null;
        try {
            Intrinsics.checkNotNull(sslSocketFactory);
            Socket createSocket = sslSocketFactory.createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            if (createSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) createSocket;
            try {
                ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket2);
                if (configureSecureSocket.supportsTlsExtensions()) {
                    Platform.INSTANCE.get().configureTlsExtensions(sSLSocket2, address.url().host(), address.protocols());
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                Handshake.Companion companion = Handshake.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(sslSocketSession, "sslSocketSession");
                Handshake handshake = companion.get(sslSocketSession);
                HostnameVerifier hostnameVerifier = address.hostnameVerifier();
                Intrinsics.checkNotNull(hostnameVerifier);
                if (hostnameVerifier.verify(address.url().host(), sslSocketSession)) {
                    CertificatePinner certificatePinner = address.certificatePinner();
                    Intrinsics.checkNotNull(certificatePinner);
                    this.handshake = new Handshake(handshake.tlsVersion(), handshake.cipherSuite(), handshake.localCertificates(), new Function0<List<? extends Certificate>>() { // from class: okhttp3.internal.connection.RealConnection$connectTls$1
                        final /* synthetic */ Address $address;
                        final /* synthetic */ Handshake $unverifiedHandshake;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public RealConnection$connectTls$1(Handshake handshake2, Address address2) {
                            super(0);
                            handshake = handshake2;
                            address = address2;
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @k
                        public final List<? extends Certificate> invoke() {
                            CertificateChainCleaner certificateChainCleaner = CertificatePinner.this.getCertificateChainCleaner();
                            Intrinsics.checkNotNull(certificateChainCleaner);
                            return certificateChainCleaner.clean(handshake.peerCertificates(), address.url().host());
                        }
                    });
                    certificatePinner.check$okhttp(address2.url().host(), new Function0<List<? extends X509Certificate>>() { // from class: okhttp3.internal.connection.RealConnection$connectTls$2
                        public RealConnection$connectTls$2() {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @k
                        public final List<? extends X509Certificate> invoke() {
                            Handshake handshake2;
                            handshake2 = RealConnection.this.handshake;
                            Intrinsics.checkNotNull(handshake2);
                            List<Certificate> peerCertificates = handshake2.peerCertificates();
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(peerCertificates, 10));
                            Iterator<T> it = peerCertificates.iterator();
                            while (it.hasNext()) {
                                arrayList.add((X509Certificate) ((Certificate) it.next()));
                            }
                            return arrayList;
                        }
                    });
                    String selectedProtocol = configureSecureSocket.supportsTlsExtensions() ? Platform.INSTANCE.get().getSelectedProtocol(sSLSocket2) : null;
                    this.socket = sSLSocket2;
                    this.source = Okio.buffer(Okio.source(sSLSocket2));
                    this.sink = Okio.buffer(Okio.sink(sSLSocket2));
                    this.protocol = selectedProtocol != null ? Protocol.INSTANCE.get(selectedProtocol) : Protocol.HTTP_1_1;
                    Platform.INSTANCE.get().afterHandshake(sSLSocket2);
                    return;
                }
                List<Certificate> peerCertificates = handshake2.peerCertificates();
                if (!(!peerCertificates.isEmpty())) {
                    throw new SSLPeerUnverifiedException("Hostname " + address2.url().host() + " not verified (no certificates)");
                }
                X509Certificate x509Certificate = (X509Certificate) peerCertificates.get(0);
                throw new SSLPeerUnverifiedException(StringsKt.trimMargin$default("\n              |Hostname " + address2.url().host() + " not verified:\n              |    certificate: " + CertificatePinner.INSTANCE.pin(x509Certificate) + "\n              |    DN: " + ((Object) x509Certificate.getSubjectDN().getName()) + "\n              |    subjectAltNames: " + OkHostnameVerifier.INSTANCE.allSubjectAltNames(x509Certificate) + "\n              ", null, 1, null));
            } catch (Throwable th2) {
                th = th2;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    Platform.INSTANCE.get().afterHandshake(sSLSocket);
                }
                if (sSLSocket != null) {
                    Util.closeQuietly((Socket) sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private final void connectTunnel(int connectTimeout, int readTimeout, int writeTimeout, Call r10, EventListener eventListener) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        int i10 = 0;
        while (i10 < 21) {
            i10++;
            connectSocket(connectTimeout, readTimeout, r10, eventListener);
            createTunnelRequest = createTunnel(readTimeout, writeTimeout, createTunnelRequest, url);
            if (createTunnelRequest == null) {
                return;
            }
            Socket socket = this.rawSocket;
            if (socket != null) {
                Util.closeQuietly(socket);
            }
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            eventListener.connectEnd(r10, this.route.socketAddress(), this.route.proxy(), null);
        }
    }

    private final Request createTunnel(int readTimeout, int writeTimeout, Request tunnelRequest, HttpUrl url) throws IOException {
        String str = "CONNECT " + Util.toHostHeader(url, true) + " HTTP/1.1";
        while (true) {
            BufferedSource bufferedSource = this.source;
            Intrinsics.checkNotNull(bufferedSource);
            BufferedSink bufferedSink = this.sink;
            Intrinsics.checkNotNull(bufferedSink);
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, bufferedSource, bufferedSink);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            bufferedSource.getTimeout().timeout(readTimeout, timeUnit);
            bufferedSink.getTimeout().timeout(writeTimeout, timeUnit);
            http1ExchangeCodec.writeRequest(tunnelRequest.headers(), str);
            http1ExchangeCodec.finishRequest();
            Response.Builder readResponseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders);
            Response build = readResponseHeaders.request(tunnelRequest).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code == 200) {
                if (bufferedSource.getBuffer().exhausted() && bufferedSink.getBuffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (code != 407) {
                throw new IOException(Intrinsics.stringPlus("Unexpected response code for CONNECT: ", Integer.valueOf(build.code())));
            }
            Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
            if (authenticate == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (StringsKt.equals("close", Response.header$default(build, c.f28331o, null, 2, null), true)) {
                return authenticate;
            }
            tunnelRequest = authenticate;
        }
    }

    private final Request createTunnelRequest() throws IOException {
        Request build = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header(c.f28355w, Util.toHostHeader(this.route.address().url(), true)).header("Proxy-Connection", c.f28350u0).header("User-Agent", Util.userAgent).build();
        Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header(c.f28359x0, "OkHttp-Preemptive").build());
        return authenticate == null ? build : authenticate;
    }

    private final void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int pingIntervalMillis, Call r42, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(r42);
            connectTls(connectionSpecSelector);
            eventListener.secureConnectEnd(r42, this.handshake);
            if (this.protocol == Protocol.HTTP_2) {
                startHttp2(pingIntervalMillis);
                return;
            }
            return;
        }
        List<Protocol> protocols = this.route.address().protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!protocols.contains(protocol)) {
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
        } else {
            this.socket = this.rawSocket;
            this.protocol = protocol;
            startHttp2(pingIntervalMillis);
        }
    }

    private final boolean routeMatchesAny(List<Route> candidates) {
        List<Route> list = candidates;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (Route route : list) {
            Proxy.Type type = route.proxy().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.route.proxy().type() == type2 && Intrinsics.areEqual(this.route.socketAddress(), route.socketAddress())) {
                return true;
            }
        }
        return false;
    }

    private final void startHttp2(int pingIntervalMillis) throws IOException {
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull(bufferedSink);
        socket.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true, TaskRunner.INSTANCE).socket(socket, this.route.address().url().host(), bufferedSource, bufferedSink).listener(this).pingIntervalMillis(pingIntervalMillis).build();
        this.http2Connection = build;
        this.allocationLimit = Http2Connection.INSTANCE.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(build, false, null, 3, null);
    }

    private final boolean supportsUrl(HttpUrl url) {
        Handshake handshake;
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        HttpUrl url2 = this.route.address().url();
        if (url.port() != url2.port()) {
            return false;
        }
        if (Intrinsics.areEqual(url.host(), url2.host())) {
            return true;
        }
        if (this.noCoalescedConnections || (handshake = this.handshake) == null) {
            return false;
        }
        Intrinsics.checkNotNull(handshake);
        return certificateSupportHost(url, handshake);
    }

    public final void cancel() {
        Socket socket = this.rawSocket;
        if (socket == null) {
            return;
        }
        Util.closeQuietly(socket);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void connect(int r17, int r18, int r19, int r20, boolean r21, @xi.k okhttp3.Call r22, @xi.k okhttp3.EventListener r23) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    public final void connectFailed$okhttp(@k OkHttpClient client, @k Route failedRoute, @k IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.proxy().type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.address();
            address.proxySelector().connectFailed(address.url().uri(), failedRoute.proxy().address(), failure);
        }
        client.getRouteDatabase().failed(failedRoute);
    }

    @k
    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    @k
    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    /* renamed from: getIdleAtNs$okhttp, reason: from getter */
    public final long getIdleAtNs() {
        return this.idleAtNs;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    /* renamed from: getRouteFailureCount$okhttp, reason: from getter */
    public final int getRouteFailureCount() {
        return this.routeFailureCount;
    }

    @Override // okhttp3.Connection
    @l
    /* renamed from: handshake, reason: from getter */
    public Handshake getHandshake() {
        return this.handshake;
    }

    public final synchronized void incrementSuccessCount$okhttp() {
        this.successCount++;
    }

    public final boolean isEligible$okhttp(@k Address address, @l List<Route> routes) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !this.route.address().equalsNonHost$okhttp(address)) {
            return false;
        }
        if (Intrinsics.areEqual(address.url().host(), getRoute().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || routes == null || !routeMatchesAny(routes) || address.hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            CertificatePinner certificatePinner = address.certificatePinner();
            Intrinsics.checkNotNull(certificatePinner);
            String host = address.url().host();
            Handshake handshake = getHandshake();
            Intrinsics.checkNotNull(handshake);
            certificatePinner.check(host, handshake.peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean isHealthy(boolean doExtensiveChecks) {
        long idleAtNs;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        long nanoTime = System.nanoTime();
        Socket socket = this.rawSocket;
        Intrinsics.checkNotNull(socket);
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull(bufferedSource);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return http2Connection.isHealthy(nanoTime);
        }
        synchronized (this) {
            idleAtNs = nanoTime - getIdleAtNs();
        }
        if (idleAtNs < IDLE_CONNECTION_HEALTHY_NS || !doExtensiveChecks) {
            return true;
        }
        return Util.isHealthy(socket2, bufferedSource);
    }

    public final boolean isMultiplexed$okhttp() {
        return this.http2Connection != null;
    }

    @k
    public final ExchangeCodec newCodec$okhttp(@k OkHttpClient client, @k RealInterceptorChain chain) throws SocketException {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull(bufferedSink);
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(client, this, chain, http2Connection);
        }
        socket.setSoTimeout(chain.readTimeoutMillis());
        Timeout timeout = bufferedSource.getTimeout();
        long readTimeoutMillis = chain.getReadTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(readTimeoutMillis, timeUnit);
        bufferedSink.getTimeout().timeout(chain.getWriteTimeoutMillis(), timeUnit);
        return new Http1ExchangeCodec(client, this, bufferedSource, bufferedSink);
    }

    @k
    public final RealWebSocket.Streams newWebSocketStreams$okhttp(@k Exchange exchange) throws SocketException {
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull(bufferedSink);
        socket.setSoTimeout(0);
        noNewExchanges$okhttp();
        return new RealWebSocket.Streams(bufferedSink, exchange) { // from class: okhttp3.internal.connection.RealConnection$newWebSocketStreams$1
            final /* synthetic */ Exchange $exchange;
            final /* synthetic */ BufferedSink $sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RealConnection$newWebSocketStreams$1(BufferedSink bufferedSink2, Exchange exchange2) {
                super(true, BufferedSource.this, bufferedSink2);
                this.$sink = bufferedSink2;
                this.$exchange = exchange2;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.$exchange.bodyComplete(-1L, true, true, null);
            }
        };
    }

    public final synchronized void noCoalescedConnections$okhttp() {
        this.noCoalescedConnections = true;
    }

    public final synchronized void noNewExchanges$okhttp() {
        this.noNewExchanges = true;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public synchronized void onSettings(@k Http2Connection connection, @k Settings settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.allocationLimit = settings.getMaxConcurrentStreams();
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(@k Http2Stream r32) throws IOException {
        Intrinsics.checkNotNullParameter(r32, "stream");
        r32.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.Connection
    @k
    public Protocol protocol() {
        Protocol protocol = this.protocol;
        Intrinsics.checkNotNull(protocol);
        return protocol;
    }

    @Override // okhttp3.Connection
    @k
    /* renamed from: route, reason: from getter */
    public Route getRoute() {
        return this.route;
    }

    public final void setIdleAtNs$okhttp(long j10) {
        this.idleAtNs = j10;
    }

    public final void setNoNewExchanges(boolean z10) {
        this.noNewExchanges = z10;
    }

    public final void setRouteFailureCount$okhttp(int i10) {
        this.routeFailureCount = i10;
    }

    @Override // okhttp3.Connection
    @k
    public Socket socket() {
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        return socket;
    }

    @k
    public String toString() {
        CipherSuite cipherSuite;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.route.address().url().host());
        sb2.append(d.f28378d);
        sb2.append(this.route.address().url().port());
        sb2.append(", proxy=");
        sb2.append(this.route.proxy());
        sb2.append(" hostAddress=");
        sb2.append(this.route.socketAddress());
        sb2.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        Object obj = "none";
        if (handshake != null && (cipherSuite = handshake.cipherSuite()) != null) {
            obj = cipherSuite;
        }
        sb2.append(obj);
        sb2.append(" protocol=");
        sb2.append(this.protocol);
        sb2.append('}');
        return sb2.toString();
    }

    public final synchronized void trackFailure$okhttp(@k RealCall r42, @l IOException r52) {
        try {
            Intrinsics.checkNotNullParameter(r42, "call");
            if (r52 instanceof StreamResetException) {
                if (((StreamResetException) r52).errorCode == ErrorCode.REFUSED_STREAM) {
                    int i10 = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i10;
                    if (i10 > 1) {
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                    }
                } else if (((StreamResetException) r52).errorCode != ErrorCode.CANCEL || !r42.getCanceled()) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (!isMultiplexed$okhttp() || (r52 instanceof ConnectionShutdownException)) {
                this.noNewExchanges = true;
                if (this.successCount == 0) {
                    if (r52 != null) {
                        connectFailed$okhttp(r42.getClient(), this.route, r52);
                    }
                    this.routeFailureCount++;
                }
            }
        } finally {
        }
    }
}
