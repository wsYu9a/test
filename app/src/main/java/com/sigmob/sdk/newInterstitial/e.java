package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.os.Bundle;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.TransparentAdActivity;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.m;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: classes4.dex */
public class e extends com.sigmob.sdk.mraid.e {

    /* renamed from: d */
    public NewInterstitialAdBroadcastReceiver f20201d;

    public class a implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f20202a;

        public a(String str) {
            this.f20202a = str;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            Map<String, String> options;
            if (!(obj instanceof PointEntitySigmob) || (options = ((PointEntitySigmob) obj).getOptions()) == null) {
                return;
            }
            options.put("show_count", String.valueOf(com.sigmob.sdk.base.common.h.g(this.f20202a)));
            com.sigmob.sdk.base.common.h.b(this.f20202a);
        }
    }

    public interface b extends o.b {
        void a(BaseAdUnit baseAdUnit, String str);

        void b(BaseAdUnit baseAdUnit);

        void h(BaseAdUnit baseAdUnit);

        void j(BaseAdUnit baseAdUnit);
    }

    public e(o.b bVar) {
        super(bVar);
    }

    public static boolean b(MaterialMeta materialMeta) {
        return materialMeta.creative_type.intValue() == m.CreativeTypeMRAIDTWO.b();
    }

    public static boolean c(MaterialMeta materialMeta) {
        return materialMeta.creative_type.intValue() == m.CreativeTypeNewInterstitial.b() && materialMeta.template_id.intValue() != 0;
    }

    public static boolean d(BaseAdUnit baseAdUnit) {
        boolean c10 = com.sigmob.sdk.mraid.e.c(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return c10 && (b(material) || c(material));
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public boolean a(BaseAdUnit baseAdUnit) {
        boolean a10 = super.a(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return a10 && (b(material) || c(material));
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void a(o.b bVar) {
        super.a(bVar);
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void b(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.common.h.d(baseAdUnit);
        super.b(baseAdUnit);
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        Context d10;
        String uuid;
        Class cls;
        com.sigmob.sdk.base.common.h.g(baseAdUnit);
        super.a(baseAdUnit, bundle);
        if (this.f18041a instanceof b) {
            NewInterstitialAdBroadcastReceiver newInterstitialAdBroadcastReceiver = new NewInterstitialAdBroadcastReceiver(baseAdUnit, (b) this.f18041a, baseAdUnit.getUuid());
            this.f20201d = newInterstitialAdBroadcastReceiver;
            newInterstitialAdBroadcastReceiver.a(newInterstitialAdBroadcastReceiver);
        }
        int ad_type = baseAdUnit.getAd_type();
        String str = BaseAdActivity.f20403j;
        if (ad_type == 6) {
            if (baseAdUnit.getCreativeType() == m.CreativeTypeMRAIDTWO.b()) {
                str = BaseAdActivity.f20397d;
            } else {
                baseAdUnit.getCreativeType();
                m.CreativeTypeNewInterstitial.b();
            }
        }
        b0.a(PointCategory.VOPEN, (String) null, baseAdUnit, (WindAdRequest) null, (LoadAdRequest) null, new a(baseAdUnit.getAdslot_id()));
        if (baseAdUnit.getMaterial().theme_data.intValue() == 1 || baseAdUnit.getTemplateType() == 1) {
            d10 = com.sigmob.sdk.a.d();
            uuid = baseAdUnit.getUuid();
            cls = TransparentAdActivity.class;
        } else {
            d10 = com.sigmob.sdk.a.d();
            uuid = baseAdUnit.getUuid();
            cls = AdActivity.class;
        }
        BaseAdActivity.a(d10, cls, uuid, bundle, str);
    }
}
