package com.sigmob.sdk.videoAd;

import android.content.Context;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.config.SigmobDialogSetting;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.RvAdSetting;
import com.sigmob.sdk.base.views.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends com.sigmob.sdk.base.common.i implements Serializable {
    protected static final long serialVersionUID = 2;
    public int F;
    public int I;
    public boolean J;

    /* renamed from: x */
    public i f20408x;

    /* renamed from: y */
    public i f20409y;
    public float A = 1.0f;
    public int B = -1000;
    public int C = 100;
    public boolean D = false;
    public int E = -1;
    public boolean G = false;
    public e H = null;

    /* renamed from: w */
    public final List<f> f20407w = new ArrayList();

    /* renamed from: z */
    public boolean f20410z = false;

    public static a f(BaseAdUnit baseAdUnit) {
        a aVar = new a();
        aVar.c(baseAdUnit.getAd_type() == 1);
        aVar.e(baseAdUnit.getMaterial().video_reciprocal_millisecond.intValue());
        aVar.b(baseAdUnit.getMaterial().creative_type.intValue() != com.sigmob.sdk.base.common.m.CreativeTypeVideo_transparent_html.b());
        RvAdSetting rvAdSetting = baseAdUnit.getRvAdSetting();
        SigmobDialogSetting p10 = com.sigmob.sdk.base.l.w().p();
        aVar.a(p10 != null ? new e((String) Wire.get(p10.title, ""), (String) Wire.get(p10.body_text, ""), (String) Wire.get(p10.cancel_button_text, ""), (String) Wire.get(p10.close_button_text, "")) : new e(com.sigmob.sdk.base.g.d(), com.sigmob.sdk.base.g.b(), com.sigmob.sdk.base.g.c(), com.sigmob.sdk.base.g.a()));
        if (rvAdSetting != null) {
            aVar.a(rvAdSetting.enable_exit_on_video_close.booleanValue());
            aVar.a(rvAdSetting.finished.floatValue());
            aVar.d(rvAdSetting.end_time.intValue());
        }
        aVar.b(baseAdUnit);
        return aVar;
    }

    public void a(boolean z10, int i10, int i11, BaseAdUnit baseAdUnit) {
    }

    public int b(int i10) {
        int i11;
        int i12 = this.I;
        return (i12 == 0 || (i11 = i12 * 1000) > i10) ? i10 : i11;
    }

    public int c(int i10) {
        return (int) (i10 * (this.C / 100.0f));
    }

    @Override // com.sigmob.sdk.base.common.i
    public String d() {
        return this.f17816h;
    }

    @Override // com.sigmob.sdk.base.common.i
    public String e() {
        return this.f17814f;
    }

    @Override // com.sigmob.sdk.base.common.i
    public String g() {
        return this.f17817i;
    }

    public e m() {
        return this.H;
    }

    public int n() {
        return this.I;
    }

    public int o() {
        return 0;
    }

    public int p() {
        return this.B;
    }

    public int q() {
        return this.E;
    }

    public float r() {
        return this.A;
    }

    public boolean s() {
        return this.D;
    }

    public boolean t() {
        return this.G;
    }

    public boolean u() {
        return this.f20410z;
    }

    public static i g(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return null;
        }
        MaterialMeta material = baseAdUnit.getMaterial();
        return new i(768, 1024, baseAdUnit.getInteractionType(), material.landing_page, material.deeplink_url, new com.sigmob.sdk.base.views.n(baseAdUnit.resourcePath(), baseAdUnit.getCreativeResourceType(), material.click_type.intValue() == 2 ? n.b.IMAGE : n.b.JAVASCRIPT, 720, 1024));
    }

    public void a(boolean z10) {
        this.G = z10;
    }

    public void b(Context context, int i10, int i11, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void c(Context context, int i10, int i11, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void d(String str) {
        if (str != null) {
            this.f17814f = str;
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public void e(String str) {
        if (str != null) {
            this.f17815g = str;
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public String f() {
        return this.f17815g;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Context context, int i10, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void b(Context context, int i10, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void c(String str) {
        if (str != null) {
            this.f17816h = str;
        }
    }

    public void d(int i10) {
        this.I = i10;
    }

    public void e(int i10) {
        if (i10 != 0) {
            this.B = i10;
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public void f(String str) {
        this.f17817i = str;
    }

    public void a(Context context, int i10, int i11, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void b(Context context, int i10) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public final void c(boolean z10) {
        this.f20410z = z10;
    }

    public void f(int i10) {
        this.E = i10;
    }

    public void a(Context context, int i10) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void b(boolean z10) {
        this.D = z10;
    }

    public void a(e eVar) {
        this.H = eVar;
    }

    public void a(float f10) {
        this.A = f10;
    }
}
