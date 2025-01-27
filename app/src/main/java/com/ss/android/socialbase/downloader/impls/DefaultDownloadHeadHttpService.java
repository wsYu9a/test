package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes4.dex */
public class DefaultDownloadHeadHttpService implements IDownloadHeadHttpService {

    /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadHeadHttpService$1 */
    class AnonymousClass1 implements IDownloadHeadHttpConnection {
        final /* synthetic */ Call val$requestCall;
        final /* synthetic */ Response val$response;

        AnonymousClass1(Response response, Call call) {
            execute = response;
            newCall = call;
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
        public void cancel() {
            Call call = newCall;
            if (call == null || call.isCanceled()) {
                return;
            }
            newCall.cancel();
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

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService
    public IDownloadHeadHttpConnection downloadWithConnection(String str, List<HttpHeader> list) throws IOException {
        OkHttpClient downloadClient = DownloadComponentManager.getDownloadClient();
        if (downloadClient == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder head = new Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                head.addHeader(httpHeader.getName(), DownloadUtils.getEncodedStr(httpHeader.getValue()));
            }
        }
        Call newCall = downloadClient.newCall(head.build());
        Response execute = newCall.execute();
        if (execute == null) {
            throw new IOException("can't get response");
        }
        if (DownloadExpSwitchCode.isSwitchEnable(2097152)) {
            execute.close();
        }
        return new IDownloadHeadHttpConnection() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadHeadHttpService.1
            final /* synthetic */ Call val$requestCall;
            final /* synthetic */ Response val$response;

            AnonymousClass1(Response execute2, Call newCall2) {
                execute = execute2;
                newCall = newCall2;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public void cancel() {
                Call call = newCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                newCall.cancel();
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public int getResponseCode() throws IOException {
                return execute.code();
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public String getResponseHeaderField(String str2) {
                return execute.header(str2);
            }
        };
    }
}
