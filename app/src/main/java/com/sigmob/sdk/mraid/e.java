package com.sigmob.sdk.mraid;

import android.os.Bundle;
import android.text.TextUtils;
import com.czhj.wire.okio.ByteString;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.common.x;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class e extends x {
    public e(o.b bVar) {
        super(bVar);
    }

    public static boolean a(MaterialMeta materialMeta) {
        ByteString byteString;
        return materialMeta.creative_type.intValue() == com.sigmob.sdk.base.common.m.CreativeTypeMRAID.b() && (!TextUtils.isEmpty(materialMeta.html_url) || ((byteString = materialMeta.html_snippet) != null && byteString.size() > 10));
    }

    public static boolean c(BaseAdUnit baseAdUnit) {
        return (baseAdUnit.getMaterial() == null || TextUtils.isEmpty(baseAdUnit.getCrid())) ? false : true;
    }

    @Override // com.sigmob.sdk.base.common.x
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.x
    public boolean a(BaseAdUnit baseAdUnit) {
        return c(baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(Map<String, Object> map, BaseAdUnit baseAdUnit) {
        super.a(map, baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(o.b bVar) {
        this.f18041a = bVar;
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        List<BaseAdUnit> c10;
        if (baseAdUnit.getCreativeType() == com.sigmob.sdk.base.common.m.CreativeTypeMRAIDTWO.b() && (c10 = com.sigmob.sdk.base.common.h.c(baseAdUnit.getUuid())) == null) {
            com.sigmob.sdk.mraid2.b.a().a(baseAdUnit.getUuid(), new com.sigmob.sdk.mraid2.d(com.sigmob.sdk.a.d(), c10));
        }
        super.a(baseAdUnit, bundle);
    }
}
