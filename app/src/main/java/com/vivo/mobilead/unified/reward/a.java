package com.vivo.mobilead.unified.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.vivo.ad.model.AdError;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.w0;
import com.vivo.mobilead.util.y0;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends com.vivo.mobilead.unified.a {
    protected UnifiedVivoRewardVideoAdListener t;
    protected MediaListener u;

    public a(Context context, AdParams adParams) {
        super(context, adParams);
        this.n = 2;
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull List<com.vivo.ad.model.b> list, long j2) {
        super.a(list, j2);
    }

    @Override // com.vivo.mobilead.unified.a
    protected void c() {
        UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.t;
        if (unifiedVivoRewardVideoAdListener != null) {
            unifiedVivoRewardVideoAdListener.onAdFailed(new VivoAdError(402136, "二价计费广告位，未传入价格或传入值无效"));
        }
    }

    protected void d(@NonNull AdError adError) {
        UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.t;
        if (unifiedVivoRewardVideoAdListener != null) {
            unifiedVivoRewardVideoAdListener.onAdFailed(new VivoAdError(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    @Override // com.vivo.mobilead.unified.a
    protected int f() {
        return 9;
    }

    @Override // com.vivo.mobilead.unified.a
    protected String k() {
        return BaseWrapper.ENTER_ID_MESSAGE;
    }

    protected void o() {
        UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.t;
        if (unifiedVivoRewardVideoAdListener != null) {
            unifiedVivoRewardVideoAdListener.onAdReady();
        }
        MediaListener mediaListener = this.u;
        if (mediaListener != null) {
            mediaListener.onVideoCached();
        }
    }

    @Override // com.vivo.mobilead.unified.a
    protected boolean a(long j2) {
        e();
        y0.b(this.f29666f);
        n();
        o();
        return true;
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull AdError adError) {
        super.a(adError);
        d(adError);
    }

    public void a(Activity activity) {
        int i2;
        if (this.f29666f == null || d.c().b()) {
            return;
        }
        if (this.f29666f.m() == 2 && ((i2 = this.q) <= 0 || i2 > this.f29666f.D())) {
            com.vivo.mobilead.unified.base.h.a.a(this.t, new VivoAdError(402136, "二价计费广告位，未传入价格或传入值无效"));
            return;
        }
        d.c().a(true);
        String str = this.f29663c;
        com.vivo.mobilead.m.a.a().a(str, this.t);
        com.vivo.mobilead.m.a.a().a(str, this.u);
        Intent intent = new Intent(activity, (Class<?>) RewardVideoActivity.class);
        intent.putExtra("ad_data", this.f29666f);
        intent.putExtra("ad_source_append", this.f29662b.getSourceAppend());
        intent.putExtra("AD_TYPE", k());
        intent.putExtra("ad_backup_info", this.f29662b.getBackUrlInfo());
        intent.putExtra(ContentProviderManager.PLUGIN_PROCESS_NAME, w0.a(activity));
        intent.putExtra("ad_request_id", str);
        activity.startActivity(intent);
    }

    public void a(MediaListener mediaListener) {
        this.u = mediaListener;
    }

    public void a(UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener) {
        this.t = unifiedVivoRewardVideoAdListener;
    }
}
