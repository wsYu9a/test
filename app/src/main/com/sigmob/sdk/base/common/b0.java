package com.sigmob.sdk.base.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.DownloadItem;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntityClick;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.mta.PointEntitySigmobRequest;
import com.sigmob.sdk.base.mta.PointEntitySigmobSuper;
import com.sigmob.sdk.base.mta.PointType;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b0 {

    public class a implements g {

        /* renamed from: a */
        public final /* synthetic */ g f17697a;

        public a(g gVar) {
            this.f17697a = gVar;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            g gVar = this.f17697a;
            if (gVar != null) {
                gVar.a(obj);
            }
        }
    }

    public class b implements g {

        /* renamed from: a */
        public final /* synthetic */ String f17698a;

        public b(String str) {
            this.f17698a = str;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(this.f17698a);
            }
        }
    }

    public class c implements g {

        /* renamed from: a */
        public final /* synthetic */ VolleyError f17699a;

        public c(VolleyError volleyError) {
            this.f17699a = volleyError;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setHttp_code("-1");
                VolleyError volleyError = this.f17699a;
                if (volleyError == null) {
                    pointEntitySigmob.setTime_spend("0");
                } else {
                    pointEntitySigmob.setTime_spend(String.valueOf(volleyError.getNetworkTimeMs()));
                    pointEntitySigmob.setError_message(this.f17699a.getMessage());
                }
            }
        }
    }

    public class d implements g {

        /* renamed from: a */
        public final /* synthetic */ String f17700a;

        /* renamed from: b */
        public final /* synthetic */ AdTracker f17701b;

        /* renamed from: c */
        public final /* synthetic */ NetworkResponse f17702c;

        /* renamed from: d */
        public final /* synthetic */ g f17703d;

        public d(String str, AdTracker adTracker, NetworkResponse networkResponse, g gVar) {
            this.f17700a = str;
            this.f17701b = adTracker;
            this.f17702c = networkResponse;
            this.f17703d = gVar;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setAc_type("13");
                pointEntitySigmob.setUrl(this.f17700a);
                AdTracker adTracker = this.f17701b;
                if (adTracker != null) {
                    pointEntitySigmob.setRetry(adTracker.getId() != null ? "1" : "0");
                    pointEntitySigmob.setCategory(this.f17701b.getEvent());
                    pointEntitySigmob.setRequest_id(this.f17701b.getRequest_id());
                    if (this.f17701b.getTimestamp() != 0) {
                        pointEntitySigmob.setTimestamp(String.valueOf(this.f17701b.getTimestamp()));
                    }
                    pointEntitySigmob.setSource(this.f17701b.getSource());
                    NetworkResponse networkResponse = this.f17702c;
                    if (networkResponse != null) {
                        byte[] bArr = networkResponse.data;
                        pointEntitySigmob.setResponse(bArr != null ? Base64.encodeToString(bArr, 2) : null);
                        pointEntitySigmob.setHttp_code(String.valueOf(this.f17702c.statusCode));
                        pointEntitySigmob.setTime_spend(String.valueOf(this.f17702c.networkTimeMs));
                        pointEntitySigmob.setContent_type(this.f17702c.headers.get("Content-Type"));
                        pointEntitySigmob.setContent_length(this.f17702c.headers.get("Content-Length"));
                    }
                }
            }
            g gVar = this.f17703d;
            if (gVar != null) {
                gVar.a(obj);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f17704a;

        /* renamed from: b */
        public final /* synthetic */ String f17705b;

        /* renamed from: c */
        public final /* synthetic */ BaseAdUnit f17706c;

        /* renamed from: d */
        public final /* synthetic */ PackageInfo f17707d;

        public class a implements g {
            public a() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                boolean canRequestPackageInstalls;
                Context d10 = com.sigmob.sdk.a.d();
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    HashMap hashMap = new HashMap();
                    if (Build.VERSION.SDK_INT >= 26) {
                        try {
                            canRequestPackageInstalls = d10.getPackageManager().canRequestPackageInstalls();
                            hashMap.put(com.sigmob.sdk.base.k.f18187s, canRequestPackageInstalls ? "1" : "0");
                        } catch (Throwable th2) {
                            SigmobLog.e(th2.getMessage());
                        }
                    }
                    PackageInfo packageInfo = e.this.f17707d;
                    if (packageInfo != null) {
                        try {
                            hashMap.put("app_name", d10.getPackageManager().getApplicationLabel(packageInfo.applicationInfo).toString());
                        } catch (Throwable unused) {
                        }
                        hashMap.put("package_name", e.this.f17707d.packageName);
                        hashMap.put(com.sigmob.sdk.base.k.f18185q, String.valueOf(e.this.f17707d.lastUpdateTime));
                        hashMap.put("app_version", e.this.f17707d.versionName);
                    }
                    pointEntitySigmob.setOptions(hashMap);
                }
            }
        }

        public e(String str, String str2, BaseAdUnit baseAdUnit, PackageInfo packageInfo) {
            this.f17704a = str;
            this.f17705b = str2;
            this.f17706c = baseAdUnit;
            this.f17707d = packageInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.a(this.f17704a, this.f17705b, this.f17706c, new a());
        }
    }

    public class f implements g {

        /* renamed from: a */
        public final /* synthetic */ BaseAdUnit f17709a;

        /* renamed from: b */
        public final /* synthetic */ String f17710b;

        /* renamed from: c */
        public final /* synthetic */ String f17711c;

        /* renamed from: d */
        public final /* synthetic */ String f17712d;

        /* renamed from: e */
        public final /* synthetic */ String f17713e;

        /* renamed from: f */
        public final /* synthetic */ long f17714f;

        /* renamed from: g */
        public final /* synthetic */ JSONObject f17715g;

        public f(BaseAdUnit baseAdUnit, String str, String str2, String str3, String str4, long j10, JSONObject jSONObject) {
            this.f17709a = baseAdUnit;
            this.f17710b = str;
            this.f17711c = str2;
            this.f17712d = str3;
            this.f17713e = str4;
            this.f17714f = j10;
            this.f17715g = jSONObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0148  */
        @Override // com.sigmob.sdk.base.common.b0.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(java.lang.Object r5) {
            /*
                Method dump skipped, instructions count: 454
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.b0.f.a(java.lang.Object):void");
        }
    }

    public interface g {
        void a(Object obj);
    }

    public static void a(String str, int i10, String str2, BaseAdUnit baseAdUnit) {
        a(str, i10, str2, baseAdUnit, (g) null);
    }

    public static void b(String str, String str2, BaseAdUnit baseAdUnit) {
        a(str, str2, baseAdUnit, (g) null);
    }

    public static void a(String str, int i10, String str2, BaseAdUnit baseAdUnit, g gVar) {
        PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError(str, i10, str2);
        if (gVar != null) {
            gVar.a(SigmobError);
        }
        a(str, str, baseAdUnit, SigmobError);
        SigmobError.commit();
    }

    public static void a(String str, WindAdError windAdError, BaseAdUnit baseAdUnit) {
        a(str, (String) null, windAdError.getErrorCode(), windAdError.getMessage(), (WindAdRequest) null, (LoadAdRequest) null, baseAdUnit, (g) null);
    }

    public static void a(String str, WindAdError windAdError, BaseAdUnit baseAdUnit, g gVar) {
        if (windAdError != null) {
            String message = windAdError.getMessage();
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError(str, windAdError.getErrorCode(), windAdError.getMessage());
            a(str, str, baseAdUnit, SigmobError);
            if (message != null && message.equals(WindAdError.ERROR_SIGMOB_VIDEO_FILE.getMessage()) && str != null && str.equals("load") && baseAdUnit != null) {
                SigmobError.getOptions().put("video_url", baseAdUnit.getVideo_url());
            }
            if (gVar != null) {
                gVar.a(SigmobError);
            }
            SigmobError.commit();
        }
    }

    public static void a(String str, WindAdError windAdError, BaseAdUnit baseAdUnit, LoadAdRequest loadAdRequest) {
        a(str, (String) null, windAdError.getErrorCode(), windAdError.getMessage(), (WindAdRequest) null, loadAdRequest, baseAdUnit, (g) null);
    }

    public static void a(String str, WindAdError windAdError, WindAdRequest windAdRequest) {
        a(str, (String) null, windAdError.getErrorCode(), windAdError.getMessage(), windAdRequest, (LoadAdRequest) null, (BaseAdUnit) null, (g) null);
    }

    public static void a(String str, String str2, int i10, String str3, LoadAdRequest loadAdRequest) {
        a(str, str2, i10, str3, (WindAdRequest) null, loadAdRequest, (BaseAdUnit) null, (g) null);
    }

    public static void a(String str, String str2, int i10, String str3, WindAdRequest windAdRequest, LoadAdRequest loadAdRequest, BaseAdUnit baseAdUnit, g gVar) {
        PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError(str, i10, str3);
        SigmobError.setSub_category(str2);
        a(str, str, SigmobError, windAdRequest);
        a(str, str, SigmobError, loadAdRequest);
        a(str, str, baseAdUnit, SigmobError);
        if (gVar != null) {
            gVar.a(SigmobError);
        }
        SigmobError.commit();
    }

    public static void a(String str, g gVar) {
        a0 a0Var = new a0();
        a0Var.setAc_type("1");
        a0Var.setCategory(str);
        a0Var.setAppinfo_switch(!com.sigmob.sdk.base.l.w().T() ? "1,1" : "0,0");
        DeviceContext e10 = com.sigmob.sdk.a.e();
        int i10 = (e10 != null ? e10.getLocation() : ClientMetadata.getInstance().getLocation()) != null ? 1 : 0;
        boolean U = com.sigmob.sdk.base.l.w().U();
        int i11 = U ? 0 : i10;
        a0Var.setLocation_switch((!U ? 1 : 0) + "," + i11);
        if (gVar != null) {
            gVar.a(a0Var);
        }
        WindAdOptions options = WindAds.sharedAds().getOptions();
        if (options == null || WindAds.sharedAds().getOptions().getCustomController() == null) {
            a0Var.b("0");
            a0Var.a("0");
            a0Var.c("0");
        } else {
            WindCustomController customController = options.getCustomController();
            a0Var.b(customController.isCanUsePhoneState() ? "0" : "1");
            a0Var.a(customController.isCanUseAndroidId() ? "0" : "1");
            a0Var.c(TextUtils.isEmpty(customController.getDevOaid()) ? "0" : "1");
        }
        a0Var.commit();
    }

    public static void a(String str, BaseAdUnit baseAdUnit, LoadAdRequest loadAdRequest, g gVar) {
        PointEntitySigmob pointEntitySigmob = new PointEntitySigmob();
        pointEntitySigmob.setAc_type(str);
        if (gVar != null) {
            gVar.a(pointEntitySigmob);
        }
        a(pointEntitySigmob.getCategory(), pointEntitySigmob.getSub_category(), baseAdUnit, pointEntitySigmob);
        if (loadAdRequest != null) {
            pointEntitySigmob.setLoad_id(loadAdRequest.getLoadId());
            pointEntitySigmob.setAdtype(String.valueOf(loadAdRequest.getAdType()));
            pointEntitySigmob.setScene_id(loadAdRequest.getAdSceneId());
            pointEntitySigmob.setScene_desc(loadAdRequest.getAdSceneDesc());
            pointEntitySigmob.setPlacement_id(loadAdRequest.getPlacementId());
        }
        pointEntitySigmob.commit();
    }

    public static void a(String str, String str2, WindAdRequest windAdRequest, LoadAdRequest loadAdRequest, g gVar) {
        PointEntitySigmobRequest pointEntitySigmobRequest = new PointEntitySigmobRequest();
        pointEntitySigmobRequest.setAc_type("5");
        pointEntitySigmobRequest.setCategory(str);
        pointEntitySigmobRequest.setSub_category(str2);
        a(str, str, pointEntitySigmobRequest, windAdRequest);
        a(str, str, pointEntitySigmobRequest, loadAdRequest);
        if (gVar != null) {
            gVar.a(pointEntitySigmobRequest);
        }
        a(pointEntitySigmobRequest);
        pointEntitySigmobRequest.commit();
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit) {
        a(str, str2, baseAdUnit, (g) null);
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, g gVar) {
        a(str, str2, baseAdUnit, (WindAdRequest) null, (LoadAdRequest) null, gVar);
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, LoadAdRequest loadAdRequest, g gVar) {
        a(str, str2, baseAdUnit, (WindAdRequest) null, loadAdRequest, gVar);
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, WindAdRequest windAdRequest, g gVar) {
        a(str, str2, baseAdUnit, windAdRequest, (LoadAdRequest) null, gVar);
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, WindAdRequest windAdRequest, LoadAdRequest loadAdRequest, g gVar) {
        h0.a(str).e(str2).a(baseAdUnit).a(windAdRequest).a(loadAdRequest).a(new a(gVar)).a();
    }

    public static void a(String str, String str2, LoadAdRequest loadAdRequest) {
        a(str, str2, (BaseAdUnit) null, (WindAdRequest) null, loadAdRequest, (g) null);
    }

    public static void a(String str) {
        PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
        pointEntitySigmobSuper.setAc_type(PointType.ANTI_SPAM_TOUCH);
        pointEntitySigmobSuper.setCategory(str);
        pointEntitySigmobSuper.setSha1(ClientMetadata.getInstance().getApkSha1());
        pointEntitySigmobSuper.setMd5(ClientMetadata.getInstance().getApkMd5());
        pointEntitySigmobSuper.commit();
    }

    public static void a(PackageInfo packageInfo, int i10) {
        if (packageInfo == null) {
            return;
        }
        PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
        pointEntitySigmobSuper.setAc_type("10");
        pointEntitySigmobSuper.setCategory(PointCategory.APP);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("app_name", String.valueOf(AppPackageUtil.getPackageManager(com.sigmob.sdk.a.d()).getApplicationLabel(packageInfo.applicationInfo)));
        } catch (Throwable unused) {
        }
        hashMap.put("package_name", packageInfo.packageName);
        hashMap.put(com.sigmob.sdk.base.k.f18185q, String.valueOf(packageInfo.lastUpdateTime));
        hashMap.put("app_version", packageInfo.versionName);
        hashMap.put("source_type", String.valueOf(i10));
        pointEntitySigmobSuper.setOptions(hashMap);
        pointEntitySigmobSuper.commit();
    }

    public static void a(String str, boolean z10) {
        PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
        pointEntitySigmobSuper.setAc_type(PointType.SIGMOB_CANOPEN_APP);
        pointEntitySigmobSuper.setCategory(PointCategory.OPEN_APP);
        HashMap hashMap = new HashMap();
        hashMap.put("app_pkg_name", str);
        hashMap.put("can_op", z10 ? "1" : "0");
        pointEntitySigmobSuper.setOptions(hashMap);
        pointEntitySigmobSuper.commit();
    }

    public static void a(DownloadItem downloadItem, BaseAdUnit baseAdUnit, String str, boolean z10) {
        PointEntitySigmob pointEntitySigmob = new PointEntitySigmob();
        pointEntitySigmob.setAc_type(PointType.DOWNLOAD_TRACKING);
        pointEntitySigmob.setIssuccess(String.valueOf(downloadItem.status));
        pointEntitySigmob.setIscached(z10 ? "1" : "0");
        pointEntitySigmob.setDuration(String.valueOf(downloadItem.networkMs));
        pointEntitySigmob.setFile_size(String.valueOf(downloadItem.size));
        pointEntitySigmob.setFile_name(Base64.encodeToString(downloadItem.url.getBytes(), 2));
        pointEntitySigmob.setError_message(str);
        pointEntitySigmob.setCategory(String.valueOf(downloadItem.type.getType()));
        a(pointEntitySigmob.getCategory(), pointEntitySigmob.getSub_category(), baseAdUnit, pointEntitySigmob);
        pointEntitySigmob.commit();
    }

    public static void a(com.sigmob.sdk.base.a aVar, String str, BaseAdUnit baseAdUnit, String str2, String str3, String str4) {
        a(aVar, str, baseAdUnit, str2, str3, str4, 0L);
    }

    public static void a(com.sigmob.sdk.base.a aVar, String str, BaseAdUnit baseAdUnit, String str2, String str3, String str4, long j10) {
        a(aVar, str, baseAdUnit, str2, str3, str4, j10, (JSONObject) null);
    }

    public static void a(com.sigmob.sdk.base.a aVar, String str, BaseAdUnit baseAdUnit, String str2, String str3, String str4, long j10, JSONObject jSONObject) {
        a(aVar == null ? str : aVar.name().toLowerCase(), str, baseAdUnit, new f(baseAdUnit, str, str2, str3, str4, j10, jSONObject));
    }

    public static void a(BaseAdUnit baseAdUnit, String str, PackageInfo packageInfo, String str2) {
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new e(str, str2, baseAdUnit, packageInfo));
    }

    public static void a(String str, BaseAdUnit baseAdUnit, String str2, String str3, String str4) {
        a(null, str, baseAdUnit, str2, str3, str4, 0L);
    }

    public static void a(BaseAdUnit baseAdUnit, String str, String str2) {
        a(PointCategory.TARGET_URL, (String) null, baseAdUnit, new b(str2));
    }

    public static void a(AdTracker adTracker, String str, BaseAdUnit baseAdUnit, NetworkResponse networkResponse, g gVar) {
        h0.a(adTracker.getEvent()).b("13").a(baseAdUnit).a(new d(str, adTracker, networkResponse, gVar)).a();
    }

    public static void a(AdTracker adTracker, String str, BaseAdUnit baseAdUnit, VolleyError volleyError) {
        NetworkResponse networkResponse = volleyError != null ? volleyError.networkResponse : null;
        a(adTracker, str, baseAdUnit, networkResponse, networkResponse == null ? new c(volleyError) : null);
    }

    public static void a(BaseAdUnit baseAdUnit, MotionEvent motionEvent, String str, boolean z10) {
        long eventTime = motionEvent.getEventTime() - motionEvent.getDownTime();
        PointEntityClick pointEntityClick = new PointEntityClick();
        pointEntityClick.setAc_type(PointType.ANTI_SPAM_TOUCH);
        pointEntityClick.setCategory(str);
        pointEntityClick.setLocation(String.format("{x:%f,y:%f}", Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY())));
        pointEntityClick.setClick_duration(String.valueOf(eventTime));
        pointEntityClick.setPressure(String.valueOf(motionEvent.getPressure()));
        pointEntityClick.setTouchSize(String.valueOf(motionEvent.getSize()));
        pointEntityClick.setTouchType(String.valueOf(motionEvent.getToolType(0)));
        pointEntityClick.setIs_valid_click(z10 ? "1" : "0");
        if (baseAdUnit != null) {
            pointEntityClick.setLoad_id(baseAdUnit.getLoad_id());
        }
        pointEntityClick.commit();
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, PointEntitySigmob pointEntitySigmob) {
        if (baseAdUnit != null) {
            try {
                pointEntitySigmob.setAdtype(String.valueOf(baseAdUnit.getAd_type()));
                pointEntitySigmob.setCampaign_id(baseAdUnit.getCamp_id());
                pointEntitySigmob.setCreative_id(baseAdUnit.getCrid());
                pointEntitySigmob.setRequest_id(baseAdUnit.getRequestId());
                pointEntitySigmob.setPlacement_id(baseAdUnit.getAdslot_id());
                pointEntitySigmob.setLoad_id(baseAdUnit.getLoad_id());
                pointEntitySigmob.setVid(baseAdUnit.getVid());
                pointEntitySigmob.setScene_id(baseAdUnit.getAd_scene_id());
                pointEntitySigmob.setScene_desc(baseAdUnit.getAd_scene_desc());
                pointEntitySigmob.setPlay_mode(String.valueOf(baseAdUnit.getPlayMode()));
                pointEntitySigmob.setCreative_type(String.valueOf(baseAdUnit.getCreativeType()));
                pointEntitySigmob.setBid_token(baseAdUnit.getBid_token());
                BiddingResponse biddingResponse = baseAdUnit.bidding_response;
                if (biddingResponse != null) {
                    pointEntitySigmob.setHb_price(biddingResponse.ecpm.intValue());
                }
                pointEntitySigmob.setPrice(baseAdUnit.getAd().settlement_price_enc);
                if (!TextUtils.isEmpty(baseAdUnit.getAd().product_id)) {
                    pointEntitySigmob.setProduct_id(baseAdUnit.getAd().product_id);
                }
                if (baseAdUnit.getAdx_id() != null) {
                    pointEntitySigmob.setAdx_id(baseAdUnit.getAdx_id());
                }
                pointEntitySigmob.setTemplate_id(String.valueOf(baseAdUnit.getTemplateId()));
                if (baseAdUnit.getMaterial() != null) {
                    pointEntitySigmob.setTemplate_type(baseAdUnit.getMaterial().template_type.intValue());
                }
                if (TextUtils.isEmpty(pointEntitySigmob.getTarget_url())) {
                    pointEntitySigmob.setTarget_url(baseAdUnit.getLanding_page());
                }
                if (baseAdUnit.getWXProgramRes() != null) {
                    if (!TextUtils.isEmpty(baseAdUnit.getWXProgramRes().wx_app_path)) {
                        pointEntitySigmob.setWx_app_path(URLEncoder.encode(baseAdUnit.getWXProgramRes().wx_app_path, "UTF-8"));
                    }
                    if (!TextUtils.isEmpty(baseAdUnit.getWXProgramRes().wx_app_username)) {
                        pointEntitySigmob.setWx_app_username(baseAdUnit.getWXProgramRes().wx_app_username);
                    }
                }
                pointEntitySigmob.getOptions().put("apk_md5", baseAdUnit.getApkMd5());
                pointEntitySigmob.setAd_source_channel(baseAdUnit.getAd_source_channel());
                if (!TextUtils.isEmpty(pointEntitySigmob.getShow_type()) || TextUtils.isEmpty(str)) {
                    return;
                }
                if ((str.equals("request") || str.equals(PointCategory.READY) || str.equals("start") || str.equals("endcard") || (!TextUtils.isEmpty(str2) && str2.equals("click"))) && baseAdUnit.getAd_type() == 4) {
                    pointEntitySigmob.setShow_type(baseAdUnit.isHalfInterstitial() ? "2" : "1");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2, PointEntitySigmob pointEntitySigmob, WindAdRequest windAdRequest) {
        if (pointEntitySigmob == null || windAdRequest == null) {
            return;
        }
        pointEntitySigmob.setPlacement_id(windAdRequest.getPlacementId());
        pointEntitySigmob.setLoad_id(windAdRequest.getLoadId());
        pointEntitySigmob.setAdx_id(windAdRequest.getAdxId());
        pointEntitySigmob.setAdtype(String.valueOf(windAdRequest.getAdType()));
        if (windAdRequest.hasOptions()) {
            try {
                pointEntitySigmob.setExtinfo(new JSONObject(windAdRequest.getOptions()).toString());
            } catch (Throwable unused) {
            }
        }
        if ((!(TextUtils.isEmpty(pointEntitySigmob.getShow_type()) && !TextUtils.isEmpty(str) && (str.equals("request") || str.equals(PointCategory.READY) || str.equals("start") || str.equals("endcard"))) && (TextUtils.isEmpty(str2) || !str2.equals("click"))) || windAdRequest.getAdType() != 4) {
            return;
        }
        pointEntitySigmob.setShow_type(windAdRequest.isHalfInterstitial() ? "2" : "1");
    }

    public static void a(String str, String str2, PointEntitySigmob pointEntitySigmob, LoadAdRequest loadAdRequest) {
        if (pointEntitySigmob == null || loadAdRequest == null) {
            return;
        }
        pointEntitySigmob.setPlacement_id(loadAdRequest.getPlacementId());
        if (!TextUtils.isEmpty(loadAdRequest.getBidToken())) {
            pointEntitySigmob.setBid_token(loadAdRequest.getBidToken());
        }
        if (!TextUtils.isEmpty(loadAdRequest.getLoadId())) {
            pointEntitySigmob.setLoad_id(loadAdRequest.getLoadId());
        }
        if (!TextUtils.isEmpty(loadAdRequest.getAdx_id())) {
            pointEntitySigmob.setAdx_id(loadAdRequest.getAdx_id());
        }
        pointEntitySigmob.setAdtype(String.valueOf(loadAdRequest.getAdType()));
        if (!TextUtils.isEmpty(loadAdRequest.getRequestId())) {
            pointEntitySigmob.setRequest_id(loadAdRequest.getRequestId());
        }
        if (loadAdRequest.getOptions() != null) {
            pointEntitySigmob.setExtinfo(new JSONObject(loadAdRequest.getOptions()).toString());
        }
        if ((!(TextUtils.isEmpty(pointEntitySigmob.getShow_type()) && !TextUtils.isEmpty(str) && (str.equals("request") || str.equals(PointCategory.READY) || str.equals("start") || str.equals("endcard"))) && (TextUtils.isEmpty(str2) || !str2.equals("click"))) || loadAdRequest.getAdType() != 4) {
            return;
        }
        pointEntitySigmob.setShow_type(loadAdRequest.isHalfInterstitial() ? "2" : "1");
    }

    public static void a(PointEntitySigmob pointEntitySigmob) {
        WindAdOptions options = WindAds.sharedAds().getOptions();
        String str = "0";
        if (options == null || WindAds.sharedAds().getOptions().getCustomController() == null) {
            pointEntitySigmob.setIs_custom_imei("0");
            pointEntitySigmob.setIs_custom_android_id("0");
        } else {
            WindCustomController customController = options.getCustomController();
            pointEntitySigmob.setIs_custom_imei(customController.isCanUsePhoneState() ? "0" : "1");
            pointEntitySigmob.setIs_custom_android_id(customController.isCanUseAndroidId() ? "0" : "1");
            if (!TextUtils.isEmpty(customController.getDevOaid())) {
                str = "1";
            }
        }
        pointEntitySigmob.setIs_custom_oaid(str);
    }
}
