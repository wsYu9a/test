package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.App;
import com.czhj.sdk.common.models.ModelBuilderCreator;
import com.czhj.sdk.common.models.Privacy;
import com.czhj.sdk.common.models.User;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.ParseError;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.HttpHeaderParser;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.network.d;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
public class a extends SigmobRequest<BidResponse> {

    /* renamed from: a */
    public final d.a f18321a;

    /* renamed from: b */
    public final LoadAdRequest f18322b;

    /* renamed from: com.sigmob.sdk.base.network.a$a */
    public class C0573a implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f18323a;

        /* renamed from: b */
        public final /* synthetic */ String f18324b;

        /* renamed from: c */
        public final /* synthetic */ int f18325c;

        public C0573a(String str, String str2, int i10) {
            this.f18323a = str;
            this.f18324b = str2;
            this.f18325c = i10;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                PointEntitySigmobError pointEntitySigmobError = (PointEntitySigmobError) obj;
                pointEntitySigmobError.setRequest_id(this.f18323a);
                pointEntitySigmobError.setPlacement_id(this.f18324b);
                pointEntitySigmobError.setAdtype(String.valueOf(this.f18325c));
            }
        }
    }

    public a(String str, LoadAdRequest loadAdRequest, d.a aVar) {
        super(str, 1, null);
        Preconditions.NoThrow.checkNotNull(aVar);
        this.f18321a = aVar;
        this.f18322b = loadAdRequest;
        setRetryPolicy(new DefaultRetryPolicy(5000, 0, 0.0f));
        setShouldCache(false);
    }

    public static App.Builder a() {
        App.Builder createApp = ModelBuilderCreator.createApp();
        if (!TextUtils.isEmpty(com.sigmob.sdk.a.f())) {
            createApp.sdk_ext_cap.add(4);
        }
        createApp.app_id(WindAds.sharedAds().getAppId());
        return createApp;
    }

    public static Privacy.Builder b() {
        int i10;
        Privacy.Builder builder = new Privacy.Builder();
        builder.age(Integer.valueOf(com.sigmob.sdk.base.f.f().h()));
        builder.child_protection(Integer.valueOf(com.sigmob.sdk.base.f.f().d()));
        try {
            i10 = com.sigmob.sdk.base.f.f().e();
        } catch (Throwable unused) {
            i10 = 0;
        }
        builder.gdpr_consent(Integer.valueOf(i10));
        return builder;
    }

    public static User.Builder c() {
        User.Builder builder = new User.Builder();
        builder.is_minor = Boolean.valueOf(!com.sigmob.sdk.base.f.f().i());
        builder.disable_personalized_recommendation = Boolean.valueOf(!com.sigmob.sdk.base.f.f().j());
        builder.change_recommendation_state = Boolean.valueOf(com.sigmob.sdk.base.f.f().c());
        return builder;
    }

    public d.a d() {
        return this.f18321a;
    }

    @Override // com.czhj.volley.Request
    public void deliverError(VolleyError volleyError) {
        d.a aVar;
        WindAdError windAdError;
        if (volleyError instanceof ParseError) {
            aVar = this.f18321a;
            windAdError = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
        } else {
            SigmobLog.e(this.f18322b.getPlacementId() + " ERROR_SIGMOB_NETWORK " + volleyError.getMessage());
            aVar = this.f18321a;
            windAdError = WindAdError.ERROR_SIGMOB_NETWORK;
        }
        aVar.a(windAdError.getErrorCode(), volleyError.getMessage(), null, this.f18322b);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] getBody() {
        /*
            r5 = this;
            r0 = 0
            com.sigmob.sdk.base.models.LoadAdRequest r1 = r5.f18322b     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L16
            com.czhj.sdk.common.models.BidRequest$Builder r1 = a(r1)     // Catch: java.lang.Throwable -> Le
            com.czhj.sdk.common.models.BidRequest r1 = r1.build()     // Catch: java.lang.Throwable -> Le
            goto L17
        Le:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r1)
        L16:
            r1 = r0
        L17:
            if (r1 != 0) goto L1f
            java.lang.String r1 = "builder Ads Post entry fail "
            com.czhj.sdk.logger.SigmobLog.e(r1)
            return r0
        L1f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.getUrl()
            r0.append(r2)
            java.lang.String r2 = " send Bid request: "
            r0.append(r2)
            java.lang.String r2 = r1.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.czhj.sdk.logger.SigmobLog.d(r0)
            byte[] r0 = r1.encode()     // Catch: java.lang.Exception -> L6a
            java.lang.String r2 = "KGpfzbYsn4T9Jyuq"
            byte[] r0 = com.czhj.sdk.common.utils.AESUtil.Encrypt(r0, r2)     // Catch: java.lang.Exception -> L6a
            java.lang.Boolean r2 = com.sigmob.sdk.base.k.f18174f     // Catch: java.lang.Exception -> L6a
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> L6a
            if (r2 == 0) goto L6c
            r2 = 2
            java.lang.String r2 = android.util.Base64.encodeToString(r0, r2)     // Catch: java.lang.Exception -> L6a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6a
            r3.<init>()     // Catch: java.lang.Exception -> L6a
            java.lang.String r4 = "body base64 "
            r3.append(r4)     // Catch: java.lang.Exception -> L6a
            r3.append(r2)     // Catch: java.lang.Exception -> L6a
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L6a
            com.czhj.sdk.logger.SigmobLog.d(r2)     // Catch: java.lang.Exception -> L6a
            goto L6c
        L6a:
            r0 = move-exception
            goto L6d
        L6c:
            return r0
        L6d:
            r0.printStackTrace()
            byte[] r0 = r1.encode()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.network.a.getBody():byte[]");
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
    public Response<BidResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            SigmobLog.d("ads Response start" + System.currentTimeMillis());
            BidResponse decode = BidResponse.ADAPTER.decode(networkResponse.data);
            return decode != null ? Response.success(decode, HttpHeaderParser.parseCacheHeaders(networkResponse)) : Response.error(new ParseError(networkResponse));
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            return Response.error(new ParseError(th2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0182 A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:3:0x0007, B:5:0x0035, B:6:0x0040, B:8:0x0047, B:10:0x0051, B:12:0x005b, B:18:0x0075, B:20:0x008b, B:22:0x009f, B:23:0x0185, B:25:0x01ac, B:26:0x01b3, B:28:0x01dd, B:29:0x01e4, B:31:0x0207, B:32:0x020e, B:34:0x0218, B:35:0x021f, B:37:0x0230, B:39:0x0234, B:40:0x023b, B:41:0x0312, B:43:0x0365, B:44:0x0370, B:48:0x00ec, B:50:0x00f2, B:53:0x00fa, B:55:0x0101, B:56:0x0118, B:57:0x0171, B:58:0x0174, B:60:0x0182, B:61:0x011d, B:62:0x0248), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.czhj.sdk.common.models.BidRequest.Builder a(com.sigmob.sdk.base.models.LoadAdRequest r11) {
        /*
            Method dump skipped, instructions count: 915
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.network.a.a(com.sigmob.sdk.base.models.LoadAdRequest):com.czhj.sdk.common.models.BidRequest$Builder");
    }

    @Override // com.czhj.volley.Request
    /* renamed from: a */
    public void deliverResponse(BidResponse bidResponse) {
        String DecryptString;
        if (bidResponse != null) {
            SigmobLog.d("ads Response: " + System.currentTimeMillis() + " [" + bidResponse + "]");
            String str = bidResponse.uid;
            if (!TextUtils.isEmpty(str)) {
                try {
                    DecryptString = AESUtil.DecryptStringServer(str, "KGpfzbYsn4T9Jyuq");
                } catch (NoSuchMethodError unused) {
                    DecryptString = AESUtil.DecryptString(str, "KGpfzbYsn4T9Jyuq");
                }
                ClientMetadata.getInstance().setUid(DecryptString);
            }
            if (!TextUtils.isEmpty(bidResponse.adx_id)) {
                this.f18322b.setAdx_id(bidResponse.adx_id);
            }
            this.f18322b.setRequestId(bidResponse.request_id);
            if (bidResponse.ads.size() <= 0) {
                a(this.f18322b.getAdType(), this.f18322b.getPlacementId(), bidResponse.request_id, bidResponse.error_code.intValue(), bidResponse.error_message);
                this.f18321a.a(bidResponse.error_code.intValue(), bidResponse.error_message, bidResponse.request_id, this.f18322b);
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < bidResponse.ads.size(); i10++) {
                    BaseAdUnit adUnit = BaseAdUnit.adUnit(bidResponse.ads.get(i10), bidResponse.request_id, this.f18322b, bidResponse.slot_ad_setting, bidResponse.scene, bidResponse.uid, bidResponse.expiration_time, bidResponse.bidding_response);
                    adUnit.setAd_type(this.f18322b.getAdType());
                    adUnit.setAdx_id(this.f18322b.getAdx_id());
                    adUnit.setAdslot_id(this.f18322b.getPlacementId());
                    adUnit.setHalfInterstitial(this.f18322b.isHalfInterstitial());
                    adUnit.setRvCallBackUrl(bidResponse.rv_callback_url);
                    arrayList.add(adUnit);
                }
                this.f18321a.a(arrayList, this.f18322b);
                int adType = this.f18322b.getAdType();
                if (adType == 6 || adType == 1 || adType == 4) {
                    h.a(bidResponse.request_id, bidResponse);
                    return;
                }
                return;
            } catch (Throwable th2) {
                SigmobLog.e("ads Response: error ", th2);
            }
        }
        this.f18321a.a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE.getErrorCode(), "bidResponse is null", null, this.f18322b);
    }

    public final void a(int i10, String str, String str2, int i11, String str3) {
        b0.a(PointCategory.SERVER_ERROR, i11, str3, (BaseAdUnit) null, new C0573a(str2, str, i10));
    }
}
