package com.aggmoread.sdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Handler;
import android.util.Log;
import com.aggmoread.sdk.client.AMAdConfig;
import com.aggmoread.sdk.client.AMAdLoadSlot;
import com.aggmoread.sdk.client.AMAdType;
import com.aggmoread.sdk.client.AMChannelIdInfo;
import com.aggmoread.sdk.client.AMCustomController;
import com.aggmoread.sdk.client.AMError;
import com.aggmoread.sdk.client.AMRewardAdConfig;
import com.aggmoread.sdk.client.AMVideoConfigs;
import com.aggmoread.sdk.client.IAMAdInteractionListener;
import com.aggmoread.sdk.client.IAMAdLoadListener;
import com.aggmoread.sdk.t;
import com.aggmoread.sdk.z.d.a.a.c.g;
import com.aggmoread.sdk.z.d.a.a.c.t.b;
import com.aggmoread.sdk.z.d.a.a.d.b.h;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    private com.aggmoread.sdk.z.d.a.a.d.b.g f4096a;

    public class a extends com.aggmoread.sdk.z.d.a.a.c.j {

        /* renamed from: a */
        final /* synthetic */ AMCustomController f4097a;

        public a(e eVar, AMCustomController aMCustomController) {
            this.f4097a = aMCustomController;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public boolean a() {
            try {
                return this.f4097a.canReadInstalledPackages();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy can storage err : " + e10.getMessage());
                return super.a();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public boolean b() {
            try {
                return this.f4097a.canReadLocation();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy can loc err : " + e10.getMessage());
                return super.b();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public boolean c() {
            try {
                return this.f4097a.canUseMacAddress();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy use mac err : " + e10.getMessage());
                return super.c();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public boolean d() {
            try {
                return this.f4097a.canUseNetworkState();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy can net err : " + e10.getMessage());
                return super.d();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public boolean e() {
            return super.e();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public boolean f() {
            try {
                return this.f4097a.canUsePhoneState();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy use state err : " + e10.getMessage());
                return super.f();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public boolean g() {
            try {
                return this.f4097a.canUseStoragePermission();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy can storage err : " + e10.getMessage());
                return super.g();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public String h() {
            try {
                return this.f4097a.getAndroidId();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy id err : " + e10.getMessage());
                return super.h();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public String i() {
            try {
                return this.f4097a.getIMSI();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy imsi err : " + e10.getMessage());
                return super.i();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public String j() {
            try {
                return this.f4097a.getImei();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy imei err : " + e10.getMessage());
                return super.j();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public String[] k() {
            return super.k();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public List<PackageInfo> l() {
            try {
                return this.f4097a.getInstalledPackages();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy can storage err : " + e10.getMessage());
                return super.l();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public Location m() {
            try {
                return this.f4097a.getLocation();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy  loc err : " + e10.getMessage());
                return super.m();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public String n() {
            try {
                return this.f4097a.getMacAddress();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy get mac err : " + e10.getMessage());
                return super.n();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public String o() {
            try {
                Log.i(t.SDK_TAG, "getOaid " + this.f4097a.getDevOaid());
                return this.f4097a.getDevOaid();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy oaid err : " + e10.getMessage());
                return super.o();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.j
        public String p() {
            try {
                return this.f4097a.getSerialNumberInner();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("privacy serial err : " + e10.getMessage());
                return super.p();
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ List f4098b;

        /* renamed from: c */
        final /* synthetic */ Context f4099c;

        public b(List list, Context context) {
            this.f4098b = list;
            this.f4099c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i10 = 0; i10 < this.f4098b.size(); i10++) {
                AMChannelIdInfo aMChannelIdInfo = (AMChannelIdInfo) this.f4098b.get(i10);
                String str = aMChannelIdInfo.channelId;
                AMAdType aMAdType = aMChannelIdInfo.adType;
                AMAdLoadSlot aMAdLoadSlot = aMChannelIdInfo.amAdLoadSlot;
                if (aMAdLoadSlot == null) {
                    AMAdLoadSlot.Builder builder = new AMAdLoadSlot.Builder();
                    builder.setSlotId(str);
                    aMAdLoadSlot = builder.build();
                }
                g.a a10 = e.this.a(this.f4099c, aMAdType, aMAdLoadSlot);
                com.aggmoread.sdk.b.d dVar = new com.aggmoread.sdk.b.d(aMAdType);
                dVar.a((IAMAdLoadListener<?>) null);
                a10.a(dVar.a());
                a10.a(true);
                e.this.f4096a.a(a10.a());
            }
        }
    }

    public class c implements com.aggmoread.sdk.z.d.a.a.c.b {

        /* renamed from: a */
        final /* synthetic */ AMRewardAdConfig f4101a;

        public c(e eVar, AMRewardAdConfig aMRewardAdConfig) {
            this.f4101a = aMRewardAdConfig;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.b
        public void onReward(Map<String, Object> map) {
            if (this.f4101a.getRewardAdListener() != null) {
                this.f4101a.getRewardAdListener().onReward(map);
            }
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a */
        static final /* synthetic */ int[] f4102a;

        static {
            int[] iArr = new int[AMAdType.values().length];
            f4102a = iArr;
            try {
                iArr[AMAdType.EXPRESS_INFORMATION_FLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4102a[AMAdType.INFORMATION_FLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4102a[AMAdType.SPLASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4102a[AMAdType.REWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4102a[AMAdType.INTERSTITIAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4102a[AMAdType.FULLSCREEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4102a[AMAdType.BANNER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4102a[AMAdType.DRAW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4102a[AMAdType.MIX_INFORMATION_FLOW.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public e(Context context) {
        this.f4096a = new com.aggmoread.sdk.z.d.a.a.d.b.g(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.aggmoread.sdk.z.d.a.a.c.g.a a(android.content.Context r4, com.aggmoread.sdk.client.AMAdType r5, com.aggmoread.sdk.client.AMAdLoadSlot r6) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto Ld
            com.aggmoread.sdk.z.d.a.a.d.b.g r0 = r3.f4096a
            android.app.Activity r4 = (android.app.Activity) r4
            com.aggmoread.sdk.z.d.a.a.c.g$a r4 = r0.a(r4)
            goto L13
        Ld:
            com.aggmoread.sdk.z.d.a.a.d.b.g r0 = r3.f4096a
            com.aggmoread.sdk.z.d.a.a.c.g$a r4 = r0.a(r4)
        L13:
            com.aggmoread.sdk.z.d.a.a.c.i r0 = r3.a(r5)
            r4.a(r0)
            com.aggmoread.sdk.client.AMAdSize r0 = r6.adSize
            if (r0 == 0) goto L2c
            com.aggmoread.sdk.z.d.a.a.c.h r0 = new com.aggmoread.sdk.z.d.a.a.c.h
            com.aggmoread.sdk.client.AMAdSize r1 = r6.adSize
            int r2 = r1.adWidth
            int r1 = r1.adHeight
            r0.<init>(r2, r1)
            r4.a(r0)
        L2c:
            com.aggmoread.sdk.client.AMAdType r0 = com.aggmoread.sdk.client.AMAdType.EXPRESS_INFORMATION_FLOW
            if (r5 != r0) goto L36
            java.lang.String r5 = "1"
        L32:
            r4.a(r5)
            goto L3d
        L36:
            com.aggmoread.sdk.client.AMAdType r0 = com.aggmoread.sdk.client.AMAdType.INFORMATION_FLOW
            if (r5 != r0) goto L3d
            java.lang.String r5 = "2"
            goto L32
        L3d:
            java.lang.String r5 = r6.bidToken
            r4.c(r5)
            java.lang.String r5 = r6.adSlotId
            r4.b(r5)
            int r5 = r6.adCount
            r4.b(r5)
            android.view.ViewGroup r5 = r6.adContainer
            r4.a(r5)
            com.aggmoread.sdk.client.AMVideoConfigs r5 = r6.videoConfigs
            if (r5 == 0) goto L5c
            com.aggmoread.sdk.z.d.a.a.c.t.b r5 = r3.a(r5)
            r4.a(r5)
        L5c:
            com.aggmoread.sdk.client.AMRewardAdConfig r5 = r6.rewardAdConfig
            if (r5 == 0) goto L67
            com.aggmoread.sdk.z.d.a.a.c.r.c r5 = r3.a(r5)
            r4.a(r5)
        L67:
            int r5 = r6.fetchTimeOut
            r0 = -1
            if (r5 == r0) goto L6f
            r4.a(r5)
        L6f:
            int r5 = r6.refreshTime
            if (r5 == r0) goto L76
            r4.d(r5)
        L76:
            int r5 = r6.limitTime
            if (r5 == r0) goto L7d
            r4.c(r5)
        L7d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.b.e.a(android.content.Context, com.aggmoread.sdk.client.AMAdType, com.aggmoread.sdk.client.AMAdLoadSlot):com.aggmoread.sdk.z.d.a.a.c.g$a");
    }

    private com.aggmoread.sdk.z.d.a.a.c.i a(AMAdType aMAdType) {
        switch (d.f4102a[aMAdType.ordinal()]) {
            case 1:
            case 2:
                return com.aggmoread.sdk.z.d.a.a.c.i.INFORMATION_FLOW;
            case 3:
                return com.aggmoread.sdk.z.d.a.a.c.i.SPLASH;
            case 4:
                return com.aggmoread.sdk.z.d.a.a.c.i.REWARD_VIDEO;
            case 5:
                return com.aggmoread.sdk.z.d.a.a.c.i.INTERSTITIAL;
            case 6:
                return com.aggmoread.sdk.z.d.a.a.c.i.FULL_SCREEN_VIDEO;
            case 7:
                return com.aggmoread.sdk.z.d.a.a.c.i.BANNER;
            case 8:
                return com.aggmoread.sdk.z.d.a.a.c.i.DRAW;
            case 9:
                return com.aggmoread.sdk.z.d.a.a.c.i.MIX_INFORMATION_FLOW;
            default:
                return com.aggmoread.sdk.z.d.a.a.c.i.UNKNOWN;
        }
    }

    private com.aggmoread.sdk.z.d.a.a.c.r.c a(AMRewardAdConfig aMRewardAdConfig) {
        com.aggmoread.sdk.z.d.a.a.c.r.c cVar = new com.aggmoread.sdk.z.d.a.a.c.r.c();
        cVar.b(aMRewardAdConfig.getRewardName());
        cVar.a(aMRewardAdConfig.getRewardAmount());
        cVar.c(aMRewardAdConfig.getUserID());
        cVar.a(aMRewardAdConfig.getCustomData());
        cVar.a(new c(this, aMRewardAdConfig));
        return cVar;
    }

    private com.aggmoread.sdk.z.d.a.a.c.t.b a(AMVideoConfigs aMVideoConfigs) {
        b.C0115b c0115b = new b.C0115b();
        c0115b.b(aMVideoConfigs.isDetailPageMuted());
        c0115b.a(aMVideoConfigs.isAutoPlayMuted());
        c0115b.a(aMVideoConfigs.getAutoPlayPolicy());
        c0115b.d(aMVideoConfigs.isEnableUserControl());
        c0115b.e(aMVideoConfigs.isNeedCoverImage());
        c0115b.f(aMVideoConfigs.isNeedProgressBar());
        c0115b.c(aMVideoConfigs.isEnableDetailPage());
        return c0115b.a();
    }

    public void a(Context context, AMAdType aMAdType, AMAdLoadSlot aMAdLoadSlot, IAMAdLoadListener<?> iAMAdLoadListener) {
        if (aMAdLoadSlot == null) {
            if (iAMAdLoadListener != null) {
                iAMAdLoadListener.onAdLoadFail(new AMError(10000, "广告请求配置为空，广告请求失败!"));
            }
        } else {
            g.a a10 = a(context, aMAdType, aMAdLoadSlot);
            com.aggmoread.sdk.b.d dVar = new com.aggmoread.sdk.b.d(aMAdType);
            dVar.a(iAMAdLoadListener);
            a10.a(dVar.a());
            this.f4096a.a(a10.a());
        }
    }

    public void a(Context context, AMAdType aMAdType, AMAdLoadSlot aMAdLoadSlot, IAMAdLoadListener<?> iAMAdLoadListener, IAMAdInteractionListener iAMAdInteractionListener) {
        if (aMAdLoadSlot == null) {
            if (iAMAdLoadListener != null) {
                iAMAdLoadListener.onAdLoadFail(new AMError(10000, "广告请求配置为空，广告请求失败!"));
                return;
            }
            return;
        }
        g.a a10 = a(context, aMAdType, aMAdLoadSlot);
        com.aggmoread.sdk.b.d dVar = new com.aggmoread.sdk.b.d(aMAdType);
        dVar.a(false);
        dVar.a(iAMAdLoadListener);
        dVar.a(iAMAdInteractionListener);
        a10.a(dVar.a());
        this.f4096a.a(a10.a());
    }

    public void a(Context context, List<AMChannelIdInfo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.n.b(new b(list, context));
    }

    public void a(Handler.Callback callback, AMAdConfig aMAdConfig) {
        if (this.f4096a != null) {
            h.b bVar = new h.b();
            if (aMAdConfig != null) {
                AMCustomController customController = aMAdConfig.getCustomController();
                if (customController != null) {
                    bVar.a(new a(this, customController));
                }
                this.f4096a.a(callback, bVar.a());
                int isAgreePrivacyRecommend = aMAdConfig.isAgreePrivacyRecommend();
                com.aggmoread.sdk.z.b.d.b(t.SDK_TAG, "ap = " + isAgreePrivacyRecommend);
                if (isAgreePrivacyRecommend != -1) {
                    com.aggmoread.sdk.z.d.a.a.d.a.d.n.a(isAgreePrivacyRecommend == 1);
                }
                int isAgreeShake = aMAdConfig.isAgreeShake();
                com.aggmoread.sdk.z.b.d.b(t.SDK_TAG, "as = " + isAgreeShake);
                if (isAgreeShake != -1) {
                    if (isAgreeShake == 0 || isAgreeShake == 1) {
                        com.aggmoread.sdk.z.d.a.a.d.a.d.n.a(String.valueOf(isAgreeShake));
                    } else {
                        com.aggmoread.sdk.z.b.d.b(t.SDK_TAG, "shakable not valid,only 0 Or 1");
                    }
                }
            }
        }
    }

    public void a(AMAdConfig aMAdConfig) {
        a((Handler.Callback) null, aMAdConfig);
    }
}
