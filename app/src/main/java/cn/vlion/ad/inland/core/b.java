package cn.vlion.ad.inland.core;

import android.text.TextUtils;
import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionAdapterInitConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b */
    public int f3556b;

    /* renamed from: c */
    public String f3557c;

    /* renamed from: d */
    public BaseAdAdapter f3558d;

    /* renamed from: g */
    public VlionServiceConfig.DataBean.AdBean.PlacementBean.SourcesBean f3561g;

    /* renamed from: h */
    public VlionAdapterInitConfig f3562h;

    /* renamed from: i */
    public VlionAdapterADConfig f3563i;

    /* renamed from: j */
    public String f3564j;

    /* renamed from: k */
    public VlionNativeAdvert f3565k;

    /* renamed from: l */
    public double f3566l;

    /* renamed from: m */
    public int f3567m;

    /* renamed from: n */
    public String f3568n;

    /* renamed from: o */
    public int f3569o;

    /* renamed from: p */
    public boolean f3570p;

    /* renamed from: a */
    public int f3555a = 0;

    /* renamed from: e */
    public int f3559e = 0;

    /* renamed from: f */
    public double f3560f = l5.c.f27899e;

    public b(BaseAdAdapter baseAdAdapter, VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean, VlionServiceConfig.DataBean.AdBean.PlacementBean.SourcesBean sourcesBean, j0 j0Var, String str) {
        this.f3564j = "";
        this.f3566l = 1.0d;
        this.f3570p = false;
        try {
            this.f3558d = baseAdAdapter;
            this.f3561g = sourcesBean;
            VlionAdapterADConfig vlionAdapterADConfig = new VlionAdapterADConfig();
            this.f3563i = vlionAdapterADConfig;
            vlionAdapterADConfig.setTrace(str);
            int cacheNum = placementBean.getCacheNum();
            this.f3569o = cacheNum;
            if (cacheNum <= 0) {
                this.f3569o = 1;
            }
            if (j0Var != null) {
                this.f3567m = j0Var.a();
                this.f3568n = j0Var.e();
                this.f3563i.setWidth(j0Var.g());
                this.f3563i.setHeight(j0Var.b());
                this.f3563i.setImageScale(j0Var.c());
                this.f3563i.setHideSkip(j0Var.h());
                this.f3563i.setAdType(j0Var.a());
                this.f3563i.setTolerateTime(j0Var.f());
                this.f3563i.setCloseSec(j0Var.d() > 0 ? j0Var.d() : placementBean.getCloseSec());
            }
            this.f3570p = a(sourcesBean.getPlatformName());
            this.f3563i.setPlacementBean(placementBean);
            VlionServiceConfig.DataBean.AdBean.PlacementBean.SourcesBean.ConfigBean config = sourcesBean.getConfig();
            if (config != null) {
                this.f3562h = new VlionAdapterInitConfig(config.getApp_id(), config.getApp_key(), config.getApp_secret(), this.f3570p);
                this.f3563i.setSlotID(config.getTag_id());
                this.f3563i.setAppId(config.getApp_id());
                this.f3563i.setBid(config.getIs_bid().booleanValue());
                this.f3563i.setKdImage(config.getAdSourceType());
                this.f3563i.setAccelerate(config.getAccelerate());
                this.f3563i.setShakeDuration(config.getShakeDuration());
                this.f3563i.setAngle(config.getAngle());
            }
            a(sourcesBean.getBidfloor());
            this.f3563i.setBidfloor(sourcesBean.getBidfloor());
            this.f3564j = placementBean.getShowId();
            VlionServiceConfig.DataBean.AdBean.PlacementBean.SourcesBean.FrequencyStrategyBean frequencyStrategy = sourcesBean.getFrequencyStrategy();
            if (frequencyStrategy != null) {
                frequencyStrategy.getLimitNum();
                frequencyStrategy.getTimeSpan();
            }
            this.f3563i.setAgg(Long.valueOf(sourcesBean.getId()));
            this.f3563i.setPlatform(sourcesBean.getPlatformName());
            this.f3563i.setAccount(sourcesBean.getPlatformAccount());
            this.f3566l = sourcesBean.getShareRatio();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a() {
        try {
            BaseAdAdapter baseAdAdapter = this.f3558d;
            if (baseAdAdapter != null) {
                baseAdAdapter.destroy();
                this.f3558d = null;
            }
            if (this.f3561g != null) {
                this.f3561g = null;
            }
            if (this.f3563i != null) {
                this.f3563i = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final int b() {
        return this.f3567m;
    }

    public final BaseAdAdapter c() {
        return this.f3558d;
    }

    public final int d() {
        return this.f3569o;
    }

    public final int e() {
        return this.f3555a;
    }

    public final int f() {
        return this.f3556b;
    }

    public final String g() {
        return this.f3557c;
    }

    public final String h() {
        try {
            VlionServiceConfig.DataBean.AdBean.PlacementBean.SourcesBean sourcesBean = this.f3561g;
            if (sourcesBean == null) {
                return "";
            }
            String platformName = sourcesBean.getPlatformName();
            return !TextUtils.isEmpty(platformName) ? platformName : "";
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public final int i() {
        return this.f3559e;
    }

    public final double j() {
        return this.f3566l;
    }

    public final String k() {
        return this.f3564j;
    }

    public final String l() {
        return this.f3568n;
    }

    public final VlionServiceConfig.DataBean.AdBean.PlacementBean.SourcesBean m() {
        return this.f3561g;
    }

    public final VlionAdapterADConfig n() {
        return this.f3563i;
    }

    public final VlionAdapterInitConfig o() {
        return this.f3562h;
    }

    public final VlionNativeAdvert p() {
        return this.f3565k;
    }

    public final double q() {
        return this.f3560f;
    }

    public final String toString() {
        StringBuilder a10 = f.a("BaseAdSourceData{loadSuccessState=");
        a10.append(this.f3555a);
        a10.append(", platformCode=");
        a10.append(this.f3556b);
        a10.append(", platformMSG='");
        a10.append(this.f3557c);
        a10.append('\'');
        a10.append(", price=");
        a10.append(this.f3559e);
        a10.append(", sourcesBean=");
        VlionServiceConfig.DataBean.AdBean.PlacementBean.SourcesBean sourcesBean = this.f3561g;
        a10.append(sourcesBean != null ? sourcesBean.toString() : "");
        a10.append(", vlionAdapterADConfig=");
        VlionAdapterADConfig vlionAdapterADConfig = this.f3563i;
        a10.append(vlionAdapterADConfig != null ? vlionAdapterADConfig.toString() : "");
        a10.append('}');
        return a10.toString();
    }

    public final void a(double d10) {
        this.f3560f = d10;
        this.f3559e = (int) (d10 * this.f3566l);
    }

    public final void b(int i10) {
        this.f3556b = i10;
    }

    public final void a(int i10) {
        this.f3555a = i10;
    }

    public final void b(String str) {
        this.f3557c = str;
    }

    public final void a(VlionNativeAdvert vlionNativeAdvert) {
        this.f3565k = vlionNativeAdvert;
    }

    public static boolean a(String str) {
        if ("VK".equals(str)) {
            StringBuilder a10 = f.a("isInitPlatformEach KsInit=");
            a10.append(VlionServiceConfigParse.getInstance().isKsInit());
            LogVlion.e(a10.toString());
            return VlionServiceConfigParse.getInstance().isKsInit();
        }
        if (!"VGD".equals(str)) {
            return false;
        }
        StringBuilder a11 = f.a("isInitPlatformEach isGdInit=");
        a11.append(VlionServiceConfigParse.getInstance().isKsInit());
        LogVlion.e(a11.toString());
        return VlionServiceConfigParse.getInstance().isGdtInit();
    }
}
