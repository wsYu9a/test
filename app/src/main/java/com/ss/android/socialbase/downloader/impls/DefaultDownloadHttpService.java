package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDefaultDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public class DefaultDownloadHttpService implements IDownloadHttpService {
    private final LruCache<String, OkHttpClient> hostIpClientCache = new LruCache<>(4, 8);

    /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService$1 */
    class AnonymousClass1 extends IDefaultDownloadHttpConnection {
        final /* synthetic */ InputStream val$inputStream;
        final /* synthetic */ Call val$requestCall;
        final /* synthetic */ Response val$response;
        final /* synthetic */ ResponseBody val$responseBody;

        AnonymousClass1(InputStream inputStream, Response response, Call call, ResponseBody responseBody) {
            gZIPInputStream = inputStream;
            execute = response;
            newCall = call;
            body = responseBody;
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public void cancel() {
            Call call = newCall;
            if (call == null || call.isCanceled()) {
                return;
            }
            newCall.cancel();
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
        public void end() {
            try {
                ResponseBody responseBody = body;
                if (responseBody != null) {
                    responseBody.close();
                }
                Call call = newCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                newCall.cancel();
            } catch (Throwable unused) {
            }
        }

        @Override // com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection
        public String getHostIp() {
            return "";
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
        public InputStream getInputStream() throws IOException {
            return gZIPInputStream;
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public int getResponseCode() throws IOException {
            return execute.code();
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public String getResponseHeaderField(String str) {
            return execute.header(str);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService$2 */
    class AnonymousClass2 implements Dns {
        final /* synthetic */ String val$host;
        final /* synthetic */ String val$hostIp;

        AnonymousClass2(String str, String str2) {
            host = str;
            str2 = str2;
        }

        @Override // okhttp3.Dns
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            return TextUtils.equals(host, str) ? Collections.singletonList(InetAddress.getByName(str2)) : Dns.SYSTEM.lookup(str);
        }
    }

    private OkHttpClient createSpecialHostIpClient(String str, String str2) {
        try {
            String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.hostIpClientCache) {
                    OkHttpClient okHttpClient = this.hostIpClientCache.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder createDownloadClientBuilder = DownloadComponentManager.createDownloadClientBuilder();
                    createDownloadClientBuilder.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService.2
                        final /* synthetic */ String val$host;
                        final /* synthetic */ String val$hostIp;

                        AnonymousClass2(String host2, String str22) {
                            host = host2;
                            str2 = str22;
                        }

                        @Override // okhttp3.Dns
                        public List<InetAddress> lookup(String str4) throws UnknownHostException {
                            return TextUtils.equals(host, str4) ? Collections.singletonList(InetAddress.getByName(str2)) : Dns.SYSTEM.lookup(str4);
                        }
                    });
                    OkHttpClient build = createDownloadClientBuilder.build();
                    synchronized (this.hostIpClientCache) {
                        this.hostIpClientCache.put(str3, build);
                    }
                    return build;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return DownloadComponentManager.getDownloadClient();
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public IDownloadHttpConnection downloadWithConnection(int i2, String str, List<HttpHeader> list) throws IOException {
        String str2;
        Request.Builder url = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            str2 = null;
        } else {
            str2 = null;
            for (HttpHeader httpHeader : list) {
                String name = httpHeader.getName();
                if (str2 == null && DownloadConstants.EXTRA_REQUEST_HOST_IP.equals(name)) {
                    str2 = httpHeader.getValue();
                } else {
                    url.addHeader(name, DownloadUtils.getEncodedStr(httpHeader.getValue()));
                }
            }
        }
        OkHttpClient createSpecialHostIpClient = !TextUtils.isEmpty(str2) ? createSpecialHostIpClient(str, str2) : DownloadComponentManager.getDownloadClient();
        if (createSpecialHostIpClient == null) {
            throw new IOException("can't get httpClient");
        }
        Call newCall = createSpecialHostIpClient.newCall(url.build());
        Response execute = newCall.execute();
        if (execute == null) {
            throw new IOException("can't get response");
        }
        ResponseBody body = execute.body();
        if (body == null) {
            return null;
        }
        InputStream byteStream = body.byteStream();
        String header = execute.header("Content-Encoding");
        return new IDefaultDownloadHttpConnection() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService.1
            final /* synthetic */ InputStream val$inputStream;
            final /* synthetic */ Call val$requestCall;
            final /* synthetic */ Response val$response;
            final /* synthetic */ ResponseBody val$responseBody;

            AnonymousClass1(InputStream inputStream, Response execute2, Call newCall2, ResponseBody body2) {
                gZIPInputStream = inputStream;
                execute = execute2;
                newCall = newCall2;
                body = body2;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public void cancel() {
                Call call = newCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                newCall.cancel();
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
            public void end() {
                try {
                    ResponseBody responseBody = body;
                    if (responseBody != null) {
                        responseBody.close();
                    }
                    Call call = newCall;
                    if (call == null || call.isCanceled()) {
                        return;
                    }
                    newCall.cancel();
                } catch (Throwable unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection
            public String getHostIp() {
                return "";
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
            public InputStream getInputStream() throws IOException {
                return gZIPInputStream;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public int getResponseCode() throws IOException {
                return execute.code();
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public String getResponseHeaderField(String str3) {
                return execute.header(str3);
            }
        };
    }
}
