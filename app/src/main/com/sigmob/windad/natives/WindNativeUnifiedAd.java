package com.sigmob.windad.natives;

import android.os.Handler;
import android.os.Looper;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.nativead.v;
import com.sigmob.sdk.nativead.x;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class WindNativeUnifiedAd extends j {

    /* renamed from: j */
    public WindNativeAdLoadListener f20890j;

    /* renamed from: k */
    public Handler f20891k;

    /* renamed from: l */
    public v f20892l;

    /* renamed from: com.sigmob.windad.natives.WindNativeUnifiedAd$1 */
    public class AnonymousClass1 implements x {

        /* renamed from: a */
        public final /* synthetic */ WindNativeAdRequest f20893a;

        /* renamed from: com.sigmob.windad.natives.WindNativeUnifiedAd$1$1 */
        public class RunnableC06281 implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ List f20895a;

            public RunnableC06281(List list) {
                list = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WindNativeUnifiedAd.this.f20890j != null) {
                    WindNativeUnifiedAd.this.f20890j.onAdLoad(list, WindNativeUnifiedAd.this.b());
                }
            }
        }

        /* renamed from: com.sigmob.windad.natives.WindNativeUnifiedAd$1$2 */
        public class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ int f20897a;

            /* renamed from: b */
            public final /* synthetic */ String f20898b;

            public AnonymousClass2(int i10, String str) {
                i10 = i10;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WindNativeUnifiedAd.this.f20890j != null) {
                    WindAdError windAdError = WindAdError.getWindAdError(i10);
                    if (windAdError == null) {
                        windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
                        windAdError.setErrorMessage(i10, str);
                        windAdError.setMessage(str);
                    }
                    WindNativeUnifiedAd.this.f20890j.onAdError(windAdError, windNativeAdRequest.getPlacementId());
                }
            }
        }

        public AnonymousClass1(WindNativeAdRequest windNativeAdRequest) {
            windNativeAdRequest = windNativeAdRequest;
        }

        @Override // com.sigmob.sdk.nativead.x
        public void onNativeAdLoadFail(int i10, String str) {
            WindNativeUnifiedAd windNativeUnifiedAd = WindNativeUnifiedAd.this;
            windNativeUnifiedAd.mADStatus = AdStatus.AdStatusNone;
            windNativeUnifiedAd.f20891k.post(new Runnable() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd.1.2

                /* renamed from: a */
                public final /* synthetic */ int f20897a;

                /* renamed from: b */
                public final /* synthetic */ String f20898b;

                public AnonymousClass2(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (WindNativeUnifiedAd.this.f20890j != null) {
                        WindAdError windAdError = WindAdError.getWindAdError(i10);
                        if (windAdError == null) {
                            windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
                            windAdError.setErrorMessage(i10, str);
                            windAdError.setMessage(str);
                        }
                        WindNativeUnifiedAd.this.f20890j.onAdError(windAdError, windNativeAdRequest.getPlacementId());
                    }
                }
            });
        }

        @Override // com.sigmob.sdk.nativead.x
        public void onNativeAdLoaded(List<WindNativeAdData> list) {
            WindNativeUnifiedAd windNativeUnifiedAd = WindNativeUnifiedAd.this;
            windNativeUnifiedAd.mADStatus = AdStatus.AdStatusNone;
            windNativeUnifiedAd.f20891k.post(new Runnable() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd.1.1

                /* renamed from: a */
                public final /* synthetic */ List f20895a;

                public RunnableC06281(List list2) {
                    list = list2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (WindNativeUnifiedAd.this.f20890j != null) {
                        WindNativeUnifiedAd.this.f20890j.onAdLoad(list, WindNativeUnifiedAd.this.b());
                    }
                }
            });
        }
    }

    /* renamed from: com.sigmob.windad.natives.WindNativeUnifiedAd$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ WindAdError f20900a;

        public AnonymousClass2(WindAdError windAdError) {
            windAdError = windAdError;
        }

        @Override // java.lang.Runnable
        public void run() {
            WindNativeUnifiedAd windNativeUnifiedAd = WindNativeUnifiedAd.this;
            windNativeUnifiedAd.mADStatus = AdStatus.AdStatusNone;
            if (windNativeUnifiedAd.f20890j != null) {
                SigmobLog.i("onVideoAdLoadFail " + windAdError.toString() + "|" + WindNativeUnifiedAd.this.b());
                WindNativeUnifiedAd.this.f20890j.onAdError(windAdError, WindNativeUnifiedAd.this.b());
            }
        }
    }

    public interface WindNativeAdLoadListener {
        void onAdError(WindAdError windAdError, String str);

        void onAdLoad(List<WindNativeAdData> list, String str);
    }

    public WindNativeUnifiedAd(WindNativeAdRequest windNativeAdRequest) {
        super(windNativeAdRequest, false);
        this.f20891k = new Handler(Looper.getMainLooper());
        this.f20892l = new v(windNativeAdRequest, new x() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd.1

            /* renamed from: a */
            public final /* synthetic */ WindNativeAdRequest f20893a;

            /* renamed from: com.sigmob.windad.natives.WindNativeUnifiedAd$1$1 */
            public class RunnableC06281 implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ List f20895a;

                public RunnableC06281(List list2) {
                    list = list2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (WindNativeUnifiedAd.this.f20890j != null) {
                        WindNativeUnifiedAd.this.f20890j.onAdLoad(list, WindNativeUnifiedAd.this.b());
                    }
                }
            }

            /* renamed from: com.sigmob.windad.natives.WindNativeUnifiedAd$1$2 */
            public class AnonymousClass2 implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ int f20897a;

                /* renamed from: b */
                public final /* synthetic */ String f20898b;

                public AnonymousClass2(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (WindNativeUnifiedAd.this.f20890j != null) {
                        WindAdError windAdError = WindAdError.getWindAdError(i10);
                        if (windAdError == null) {
                            windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
                            windAdError.setErrorMessage(i10, str);
                            windAdError.setMessage(str);
                        }
                        WindNativeUnifiedAd.this.f20890j.onAdError(windAdError, windNativeAdRequest.getPlacementId());
                    }
                }
            }

            public AnonymousClass1(WindNativeAdRequest windNativeAdRequest2) {
                windNativeAdRequest = windNativeAdRequest2;
            }

            @Override // com.sigmob.sdk.nativead.x
            public void onNativeAdLoadFail(int i102, String str2) {
                WindNativeUnifiedAd windNativeUnifiedAd = WindNativeUnifiedAd.this;
                windNativeUnifiedAd.mADStatus = AdStatus.AdStatusNone;
                windNativeUnifiedAd.f20891k.post(new Runnable() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd.1.2

                    /* renamed from: a */
                    public final /* synthetic */ int f20897a;

                    /* renamed from: b */
                    public final /* synthetic */ String f20898b;

                    public AnonymousClass2(int i1022, String str22) {
                        i10 = i1022;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (WindNativeUnifiedAd.this.f20890j != null) {
                            WindAdError windAdError = WindAdError.getWindAdError(i10);
                            if (windAdError == null) {
                                windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
                                windAdError.setErrorMessage(i10, str);
                                windAdError.setMessage(str);
                            }
                            WindNativeUnifiedAd.this.f20890j.onAdError(windAdError, windNativeAdRequest.getPlacementId());
                        }
                    }
                });
            }

            @Override // com.sigmob.sdk.nativead.x
            public void onNativeAdLoaded(List list2) {
                WindNativeUnifiedAd windNativeUnifiedAd = WindNativeUnifiedAd.this;
                windNativeUnifiedAd.mADStatus = AdStatus.AdStatusNone;
                windNativeUnifiedAd.f20891k.post(new Runnable() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd.1.1

                    /* renamed from: a */
                    public final /* synthetic */ List f20895a;

                    public RunnableC06281(List list22) {
                        list = list22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (WindNativeUnifiedAd.this.f20890j != null) {
                            WindNativeUnifiedAd.this.f20890j.onAdLoad(list, WindNativeUnifiedAd.this.b());
                        }
                    }
                });
            }
        });
    }

    public void destroy() {
        WindAdRequest windAdRequest = this.f18160e;
        SigmobLog.i(String.format("native ad  %s is Destroy", windAdRequest != null ? windAdRequest.getPlacementId() : "null"));
        this.f20890j = null;
    }

    @Override // com.sigmob.sdk.base.j
    public String getEcpm() {
        v vVar = this.f20892l;
        if (vVar != null) {
            return vVar.b();
        }
        return null;
    }

    @Override // com.sigmob.sdk.base.j
    @Deprecated
    public boolean loadAd() {
        try {
            super.loadAd();
            return a(this.f18160e.getAdCount());
        } catch (Throwable th2) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th2.getMessage());
            SigmobError.setAdtype(String.valueOf(5));
            SigmobError.setPlacement_id(b());
            SigmobError.commit();
            a(windAdError);
            return false;
        }
    }

    public void setNativeAdLoadListener(WindNativeAdLoadListener windNativeAdLoadListener) {
        this.f20890j = windNativeAdLoadListener;
    }

    @Override // com.sigmob.sdk.base.j
    public void a(String str, String str2) {
        v vVar = this.f20892l;
        if (vVar != null) {
            vVar.a(str, str2);
        }
    }

    public boolean loadAd(int i10) {
        try {
            super.loadAd();
            return a(i10);
        } catch (Throwable th2) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th2.getMessage());
            SigmobError.setAdtype(String.valueOf(5));
            SigmobError.setPlacement_id(b());
            SigmobError.commit();
            a(windAdError);
            return false;
        }
    }

    @Override // com.sigmob.sdk.base.j
    public Map<String, BiddingResponse> a() {
        v vVar = this.f20892l;
        if (vVar != null) {
            return vVar.a();
        }
        return null;
    }

    @Override // com.sigmob.sdk.base.j
    public boolean loadAd(String str) {
        try {
            super.loadAd(str);
            return a(this.f18160e.getAdCount() > 0 ? this.f18160e.getAdCount() : 1);
        } catch (Throwable th2) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th2.getMessage());
            SigmobError.setAdtype(String.valueOf(5));
            SigmobError.setPlacement_id(b());
            SigmobError.commit();
            a(windAdError);
            return false;
        }
    }

    @Override // com.sigmob.sdk.base.j
    public void a(WindAdError windAdError) {
        this.f20891k.post(new Runnable() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd.2

            /* renamed from: a */
            public final /* synthetic */ WindAdError f20900a;

            public AnonymousClass2(WindAdError windAdError2) {
                windAdError = windAdError2;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindNativeUnifiedAd windNativeUnifiedAd = WindNativeUnifiedAd.this;
                windNativeUnifiedAd.mADStatus = AdStatus.AdStatusNone;
                if (windNativeUnifiedAd.f20890j != null) {
                    SigmobLog.i("onVideoAdLoadFail " + windAdError.toString() + "|" + WindNativeUnifiedAd.this.b());
                    WindNativeUnifiedAd.this.f20890j.onAdError(windAdError, WindNativeUnifiedAd.this.b());
                }
            }
        });
    }

    public boolean loadAd(String str, int i10) {
        try {
            super.loadAd(str);
            return a(i10);
        } catch (Throwable th2) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th2.getMessage());
            SigmobError.setAdtype(String.valueOf(5));
            SigmobError.setPlacement_id(b());
            SigmobError.commit();
            a(windAdError);
            return false;
        }
    }

    public final boolean a(int i10) {
        try {
            if (!loadAdFilter()) {
                return false;
            }
            this.mADStatus = AdStatus.AdStatusLoading;
            this.f20892l.a(i10, getBid_token(), getBidFloor(), getCurrency());
            d();
            return true;
        } catch (Throwable th2) {
            SigmobLog.i(getClass().getSimpleName() + " catch throwable " + th2);
            if (this.f20890j != null) {
                WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
                windAdError.setMessage(th2.getMessage());
                this.f20890j.onAdError(windAdError, b());
            }
            return false;
        }
    }
}
