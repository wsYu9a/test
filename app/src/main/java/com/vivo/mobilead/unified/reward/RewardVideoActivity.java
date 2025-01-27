package com.vivo.mobilead.unified.reward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.w0;

/* loaded from: classes4.dex */
public class RewardVideoActivity extends Activity {
    private com.vivo.ad.model.b adItemData;
    private String adType;
    private BackUrlInfo backUrlInfo;
    private MediaListener mediaListener;
    private String requestId;
    private UnifiedVivoRewardVideoAdListener rewardVideoAdListener;
    private com.vivo.mobilead.unified.base.view.t.c rewardVideoAdView;
    private String sourceAppend;

    private void initData() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(ContentProviderManager.PLUGIN_PROCESS_NAME);
        if (!TextUtils.isEmpty(stringExtra) && !stringExtra.equals(w0.a(this))) {
            finish();
            return;
        }
        this.adItemData = (com.vivo.ad.model.b) intent.getSerializableExtra("ad_data");
        this.sourceAppend = intent.getStringExtra("ad_source_append");
        this.adType = intent.getStringExtra("AD_TYPE");
        this.backUrlInfo = (BackUrlInfo) intent.getSerializableExtra("ad_backup_info");
        this.requestId = intent.getStringExtra("ad_request_id");
        this.rewardVideoAdListener = com.vivo.mobilead.m.a.a().d(this.requestId);
        this.mediaListener = com.vivo.mobilead.m.a.a().c(this.requestId);
        setOrientation();
        if (this.adItemData == null) {
            finish();
        } else {
            showAd();
        }
    }

    private void setOrientation() {
        com.vivo.ad.model.b bVar = this.adItemData;
        if (bVar == null || !(bVar.x() == 44 || this.adItemData.x() == 45)) {
            if (getResources().getConfiguration().orientation == 2) {
                setRequestedOrientation(0);
                return;
            } else {
                setRequestedOrientation(1);
                return;
            }
        }
        if (this.adItemData.t() == null || this.adItemData.t().b().intValue() != 2) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.vivo.mobilead.unified.base.view.t.c cVar = this.rewardVideoAdView;
        if (cVar != null) {
            cVar.d();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        super.onCreate(bundle);
        initData();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.vivo.mobilead.unified.base.view.t.c cVar = this.rewardVideoAdView;
        if (cVar != null) {
            cVar.c();
        }
        com.vivo.mobilead.m.a.a().a(this.requestId);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.vivo.mobilead.unified.base.view.t.c cVar = this.rewardVideoAdView;
        if (cVar != null) {
            cVar.e();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.vivo.mobilead.unified.base.view.t.c cVar = this.rewardVideoAdView;
        if (cVar != null) {
            cVar.f();
        }
    }

    public void showAd() {
        com.vivo.mobilead.unified.base.view.t.c a2 = com.vivo.mobilead.unified.base.view.t.e.a(this, this.adItemData, this.backUrlInfo, this.sourceAppend, 1, 1);
        this.rewardVideoAdView = a2;
        if (a2 != null) {
            a2.setMediaListener(this.mediaListener);
            this.rewardVideoAdView.setRewardVideoAdListener(this.rewardVideoAdListener);
            setContentView(this.rewardVideoAdView);
        } else {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.rewardVideoAdListener;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdFailed(new VivoAdError(402140, "激励视频渲染异常"));
            }
            finish();
        }
    }
}
