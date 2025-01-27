package b.b.a.e;

import android.os.Build;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public static final String f4267a = "msp";

    /* renamed from: b */
    private static b f4268b;

    /* renamed from: c */
    final DefaultHttpClient f4269c;

    private b(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.f4269c = new DefaultHttpClient(clientConnectionManager, httpParams);
    }

    private b(HttpParams httpParams) {
        this.f4269c = new DefaultHttpClient(httpParams);
    }

    public static b a() {
        if (f4268b == null) {
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, true);
            basicHttpParams.setBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false);
            ConnManagerParams.setMaxTotalConnections(basicHttpParams, 50);
            ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(30));
            ConnManagerParams.setTimeout(basicHttpParams, 1000L);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, 16384);
            HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
            HttpClientParams.setRedirecting(basicHttpParams, true);
            HttpClientParams.setAuthenticating(basicHttpParams, false);
            HttpProtocolParams.setUserAgent(basicHttpParams, f4267a);
            try {
                SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
                socketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                Scheme scheme = new Scheme(b.b.a.b.b.f4198a, socketFactory, 443);
                Scheme scheme2 = new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80);
                SchemeRegistry schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(scheme);
                schemeRegistry.register(scheme2);
                f4268b = new b(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
            } catch (Exception unused) {
                f4268b = new b(basicHttpParams);
            }
        }
        return f4268b;
    }

    private <T> T b(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws Exception {
        try {
            return (T) this.f4269c.execute(httpHost, httpRequest, responseHandler);
        } catch (Exception e2) {
            throw new Exception(e2);
        }
    }

    private <T> T c(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws Exception {
        try {
            return (T) this.f4269c.execute(httpHost, httpRequest, responseHandler, httpContext);
        } catch (Exception e2) {
            throw new Exception(e2);
        }
    }

    private <T> T d(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws Exception {
        try {
            return (T) this.f4269c.execute(httpUriRequest, responseHandler);
        } catch (Exception e2) {
            throw new Exception(e2);
        }
    }

    private <T> T e(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws Exception {
        try {
            return (T) this.f4269c.execute(httpUriRequest, responseHandler, httpContext);
        } catch (Exception e2) {
            throw new Exception(e2);
        }
    }

    private HttpResponse f(HttpHost httpHost, HttpRequest httpRequest) throws Exception {
        try {
            return this.f4269c.execute(httpHost, httpRequest);
        } catch (Exception e2) {
            throw new Exception(e2);
        }
    }

    private HttpResponse g(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws Exception {
        try {
            return this.f4269c.execute(httpHost, httpRequest, httpContext);
        } catch (Exception e2) {
            throw new Exception(e2);
        }
    }

    private HttpResponse i(HttpUriRequest httpUriRequest, HttpContext httpContext) throws Exception {
        try {
            return this.f4269c.execute(httpUriRequest, httpContext);
        } catch (Exception e2) {
            throw new Exception(e2);
        }
    }

    private static b k() {
        return f4268b;
    }

    private static void l() {
        f4268b = null;
    }

    private void m() {
        ClientConnectionManager connectionManager = this.f4269c.getConnectionManager();
        if (connectionManager != null) {
            connectionManager.closeExpiredConnections();
            if (Build.VERSION.SDK_INT >= 9) {
                connectionManager.closeIdleConnections(30L, TimeUnit.MINUTES);
            }
        }
    }

    private HttpParams n() {
        return this.f4269c.getParams();
    }

    private ClientConnectionManager o() {
        return this.f4269c.getConnectionManager();
    }

    public final HttpResponse h(HttpUriRequest httpUriRequest) throws Exception {
        try {
            return this.f4269c.execute(httpUriRequest);
        } catch (Exception e2) {
            throw new Exception(e2);
        }
    }

    public final void j() {
        ClientConnectionManager connectionManager = this.f4269c.getConnectionManager();
        if (connectionManager != null) {
            connectionManager.shutdown();
            f4268b = null;
        }
    }
}
