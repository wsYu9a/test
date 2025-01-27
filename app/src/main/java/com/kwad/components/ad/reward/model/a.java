package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;

/* loaded from: classes2.dex */
public final class a {
    private String liveStartTime;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String originPrice;
    private int playableStyle;
    private String price;
    private String ry;
    private String rz;
    private List<String> tA;

    @Nullable
    private AdTemplate tB;
    private String title;
    private List<String> ts;
    private String tt;
    private String tu;
    private String tv;
    private boolean tw;
    private String tx;
    private String ty = "查看详情";
    private String tz = "立即预约";

    @Nullable
    public static a M(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo eb2 = e.eb(adTemplate);
        AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(eb2);
        a aVar = new a();
        String name = cW.getName();
        aVar.title = name;
        if (TextUtils.isEmpty(name)) {
            aVar.title = com.kwad.sdk.core.response.b.a.ax(eb2);
        }
        aVar.ry = cW.getIcon();
        aVar.rz = com.kwad.sdk.core.response.b.a.au(eb2);
        aVar.price = cW.getPrice();
        aVar.originPrice = cW.getOriginPrice();
        if (!cW.isCouponListEmpty() && (firstCouponList = cW.getFirstCouponList()) != null) {
            aVar.P(CouponInfo.jinniuFormatCoupon(firstCouponList));
            aVar.O(firstCouponList.getFormattedJinniuPrefix());
        }
        return aVar;
    }

    @Nullable
    public static a N(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo dk2 = com.kwad.sdk.core.response.b.b.dk(adTemplate);
        a aVar = new a();
        aVar.ry = dk2.userHeadUrl;
        aVar.liveStartTime = dk2.liveStartTime;
        aVar.title = dk2.title;
        aVar.tw = dk2.needShowSubscriberCount();
        aVar.tx = dk2.getFormattedLiveSubscribeCount();
        aVar.tA = dk2.bookUserUrlList;
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = dk2.playEndCard;
        aVar.ty = liveReservationPlayEndInfo.detailBtnTitle;
        aVar.tz = liveReservationPlayEndInfo.reservationBtnTitle;
        aVar.tB = adTemplate;
        return aVar;
    }

    private void O(String str) {
        this.tu = str;
    }

    private void P(String str) {
        this.tv = str;
    }

    @Nullable
    public static a a(r rVar, boolean z10) {
        AdTemplate adTemplate;
        if (rVar == null || (adTemplate = rVar.getAdTemplate()) == null) {
            return null;
        }
        AdInfo eb2 = e.eb(adTemplate);
        a aVar = new a();
        aVar.title = com.kwad.sdk.core.response.b.a.cj(eb2);
        aVar.ry = com.kwad.sdk.core.response.b.a.cm(eb2);
        aVar.rz = com.kwad.sdk.core.response.b.a.au(eb2);
        aVar.ts = com.kwad.sdk.core.response.b.d.dS(adTemplate);
        aVar.tt = com.kwad.sdk.core.response.b.a.aE(eb2);
        aVar.playableStyle = e.l(adTemplate, z10);
        aVar.tB = adTemplate;
        aVar.mApkDownloadHelper = rVar.hu();
        return aVar;
    }

    public final String gA() {
        return this.rz;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String gz() {
        return this.ry;
    }

    public final boolean hA() {
        return this.tw;
    }

    public final List<String> hB() {
        return this.tA;
    }

    public final String hC() {
        return this.liveStartTime;
    }

    public final String hr() {
        return this.tv;
    }

    public final String hs() {
        return this.tu;
    }

    @Nullable
    public final AdTemplate ht() {
        return this.tB;
    }

    @Nullable
    public final com.kwad.components.core.e.d.c hu() {
        return this.mApkDownloadHelper;
    }

    public final List<String> hv() {
        return this.ts;
    }

    public final boolean hw() {
        List<String> list = this.ts;
        return list == null || list.size() == 0;
    }

    public final int hx() {
        return this.playableStyle;
    }

    public final String hy() {
        return this.tx;
    }

    public final String hz() {
        return this.tz;
    }
}
