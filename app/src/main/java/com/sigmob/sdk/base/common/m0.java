package com.sigmob.sdk.base.common;

import android.os.Bundle;
import android.text.TextUtils;
import com.czhj.wire.okio.ByteString;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;

/* loaded from: classes4.dex */
public abstract class m0 extends com.sigmob.sdk.mraid.e {
    public m0(o.b bVar) {
        super(bVar);
    }

    public static boolean b(MaterialMeta materialMeta) {
        ByteString byteString;
        return (materialMeta.creative_type.intValue() == m.CreativeTypeVideo_Html_Snippet.b() || materialMeta.creative_type.intValue() == m.CreativeTypeVideo_transparent_html.b()) && (byteString = materialMeta.html_snippet) != null && byteString.size() > 10 && !TextUtils.isEmpty(materialMeta.video_url);
    }

    public static boolean c(MaterialMeta materialMeta) {
        return (materialMeta.creative_type.intValue() != m.CreativeTypeVideo_EndCardURL.b() || TextUtils.isEmpty(materialMeta.html_url) || TextUtils.isEmpty(materialMeta.video_url)) ? false : true;
    }

    public static boolean d(BaseAdUnit baseAdUnit) {
        boolean c10 = com.sigmob.sdk.mraid.e.c(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return c10 && (baseAdUnit.getCreativeType() == m.CreativeTypeMRAID.b() ? com.sigmob.sdk.mraid.e.a(material) : d(material) || b(material) || c(material));
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public boolean a(BaseAdUnit baseAdUnit) {
        boolean a10 = super.a(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return a10 && (baseAdUnit.getCreativeType() == m.CreativeTypeMRAID.b() ? com.sigmob.sdk.mraid.e.a(material) : baseAdUnit.getCreativeType() == m.CreativeTypeMRAIDTWO.b() || d(material) || b(material) || c(material));
    }

    public static boolean d(MaterialMeta materialMeta) {
        return (materialMeta.creative_type.intValue() != m.CreativeTypeVideo_Tar.b() || TextUtils.isEmpty(materialMeta.endcard_md5) || TextUtils.isEmpty(materialMeta.endcard_url) || TextUtils.isEmpty(materialMeta.video_url)) ? false : true;
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void a(o.b bVar) {
        super.a(bVar);
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void b(BaseAdUnit baseAdUnit) {
        h.d(baseAdUnit);
        super.b(baseAdUnit);
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        h.g(baseAdUnit);
        super.a(baseAdUnit, bundle);
    }
}
