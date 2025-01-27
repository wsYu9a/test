package com.sigmob.sdk.base.network;

import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.ModelBuilderCreator;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.ParseError;
import com.czhj.volley.Response;
import com.czhj.volley.toolbox.HttpHeaderParser;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.models.config.SigmobSdkConfigRequest;
import com.sigmob.sdk.base.models.config.SigmobSdkConfigResponse;
import java.util.Map;

/* loaded from: classes4.dex */
public class e extends SigmobRequest<SigmobSdkConfigResponse> {

    /* renamed from: a */
    public final a f18338a;

    /* renamed from: b */
    public final SigmobSdkConfigRequest.Builder f18339b;

    public interface a extends Response.ErrorListener {
        void a(SigmobSdkConfigResponse sigmobSdkConfigResponse);
    }

    public e(String str, a aVar) {
        super(str, 1, aVar);
        this.f18338a = aVar;
        setRetryPolicy(new DefaultRetryPolicy(5000, 2, 0.0f));
        setShouldCache(false);
        this.f18339b = a();
    }

    public static SigmobSdkConfigRequest.Builder a() {
        SigmobSdkConfigRequest.Builder builder = new SigmobSdkConfigRequest.Builder();
        if (ClientMetadata.getInstance() != null && ClientMetadata.getInstance().getDeviceLocale() != null) {
            builder.app(com.sigmob.sdk.base.network.a.a().build());
            builder.user(com.sigmob.sdk.base.network.a.c().build());
            builder.privacy(com.sigmob.sdk.base.network.a.b().build());
            builder.network(ModelBuilderCreator.createNetwork(com.sigmob.sdk.a.e()).build());
            builder.device(ModelBuilderCreator.createDevice(com.sigmob.sdk.a.e()).did(ModelBuilderCreator.createDeviceId(com.sigmob.sdk.a.e()).build()).build());
        }
        return builder;
    }

    public a b() {
        return this.f18338a;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public byte[] getBody() {
        SigmobSdkConfigRequest build = this.f18339b.build();
        SigmobLog.d("send SigmobSdkConfig Request: " + build.toString());
        try {
            byte[] Encrypt = AESUtil.Encrypt(build.encode(), "KGpfzbYsn4T9Jyuq");
            if (k.f18174f.booleanValue()) {
                SigmobLog.d("body base64 " + Base64.encodeToString(Encrypt, 2));
            }
            return Encrypt;
        } catch (Exception e10) {
            e10.printStackTrace();
            return build.encode();
        }
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public String getBodyContentType() {
        return "application/octet-stream";
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        try {
            headers.put("agn", Base64.encodeToString(AESUtil.generateNonce(), 2));
        } catch (NoSuchMethodError unused) {
            headers.put(com.kwad.sdk.m.e.TAG, "1");
        }
        return headers;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public Response<SigmobSdkConfigResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(SigmobSdkConfigResponse.ADAPTER.decode(networkResponse.data), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            return Response.error(new ParseError(th2));
        }
    }

    @Override // com.czhj.volley.Request
    /* renamed from: a */
    public void deliverResponse(SigmobSdkConfigResponse sigmobSdkConfigResponse) {
        this.f18338a.a(sigmobSdkConfigResponse);
    }
}
