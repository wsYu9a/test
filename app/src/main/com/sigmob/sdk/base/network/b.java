package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.h0;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.windad.WindAdRequest;

/* loaded from: classes4.dex */
public class b extends SigmobRequest<NetworkResponse> {

    /* renamed from: a */
    public final c f18327a;

    public class a implements c {

        /* renamed from: a */
        public final /* synthetic */ String f18328a;

        /* renamed from: b */
        public final /* synthetic */ String f18329b;

        /* renamed from: c */
        public final /* synthetic */ WindAdRequest f18330c;

        /* renamed from: d */
        public final /* synthetic */ String f18331d;

        public a(String str, String str2, WindAdRequest windAdRequest, String str3) {
            this.f18328a = str;
            this.f18329b = str2;
            this.f18330c = windAdRequest;
            this.f18331d = str3;
        }

        @Override // com.sigmob.sdk.base.network.b.c
        public void a(NetworkResponse networkResponse) {
            b.a(this.f18328a, this.f18329b, this.f18330c, networkResponse, this.f18331d);
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            b.a(this.f18328a, this.f18329b, this.f18330c, volleyError != null ? volleyError.networkResponse : null, this.f18331d);
        }
    }

    /* renamed from: com.sigmob.sdk.base.network.b$b */
    public class C0574b implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f18332a;

        /* renamed from: b */
        public final /* synthetic */ String f18333b;

        /* renamed from: c */
        public final /* synthetic */ String f18334c;

        /* renamed from: d */
        public final /* synthetic */ NetworkResponse f18335d;

        public C0574b(String str, String str2, String str3, NetworkResponse networkResponse) {
            this.f18332a = str;
            this.f18333b = str2;
            this.f18334c = str3;
            this.f18335d = networkResponse;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setUrl(this.f18332a);
                pointEntitySigmob.setTracking_type(this.f18333b);
                pointEntitySigmob.setRequest_id(this.f18334c);
                NetworkResponse networkResponse = this.f18335d;
                if (networkResponse != null) {
                    byte[] bArr = networkResponse.data;
                    pointEntitySigmob.setResponse(bArr != null ? Base64.encodeToString(bArr, 2) : null);
                    pointEntitySigmob.setHttp_code(String.valueOf(this.f18335d.statusCode));
                    pointEntitySigmob.setTime_spend(String.valueOf(this.f18335d.networkTimeMs));
                    pointEntitySigmob.setContent_type(this.f18335d.headers.get("Content-Type"));
                    pointEntitySigmob.setContent_length(this.f18335d.headers.get("Content-Length"));
                }
            }
        }
    }

    public interface c extends Response.ErrorListener {
        void a(NetworkResponse networkResponse);
    }

    public b(String str, int i10, c cVar) {
        super(str, 0, cVar);
        this.f18327a = cVar;
        setShouldRetryServerErrors(true);
        setRetryPolicy(new DefaultRetryPolicy(i10, 5000, 0, 0.0f));
        setShouldCache(false);
    }

    @Override // com.czhj.volley.Request
    /* renamed from: a */
    public void deliverResponse(NetworkResponse networkResponse) {
        c cVar;
        synchronized (this.mLock) {
            cVar = this.f18327a;
        }
        SigmobLog.i("send tracking: " + getUrl() + " success");
        if (cVar != null) {
            cVar.a(networkResponse);
        }
    }

    @Override // com.czhj.volley.Request
    public void deliverError(VolleyError volleyError) {
        SigmobLog.e("send tracking: " + getUrl() + " fail");
        super.deliverError(volleyError);
    }

    @Override // com.czhj.volley.Request
    public int getMaxLength() {
        return 100;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public Response<NetworkResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        return Response.success(networkResponse, null);
    }

    public b(String str, c cVar) {
        this(str, 5000, cVar);
    }

    public static void a(String str, String str2, WindAdRequest windAdRequest, NetworkResponse networkResponse, String str3) {
        h0.a(PointCategory.HB_TRACKING).a(windAdRequest).a(new C0574b(str, str2, str3, networkResponse)).a();
    }

    public static void a(String str, String str2, WindAdRequest windAdRequest, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b bVar = new b(str, new a(str, str2, windAdRequest, str3));
        if (Networking.getSigRequestQueue() != null) {
            Networking.getSigRequestQueue().add(bVar);
        }
    }
}
