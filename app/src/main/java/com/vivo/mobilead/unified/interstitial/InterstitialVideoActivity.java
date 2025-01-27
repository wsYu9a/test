package com.vivo.mobilead.unified.interstitial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.w0;

/* loaded from: classes4.dex */
public class InterstitialVideoActivity extends Activity {
    private com.vivo.ad.model.b adItemData;
    private String adType;
    private BackUrlInfo backUrlInfo;
    private UnifiedVivoInterstitialAdListener interstitialListener;
    private boolean isStart = false;
    private MediaListener mediaListener;
    private String requestId;
    private com.vivo.mobilead.unified.interstitial.l.b rewardVideoAdView;
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
        this.interstitialListener = com.vivo.mobilead.m.a.a().b(this.requestId);
        this.mediaListener = com.vivo.mobilead.m.a.a().c(this.requestId);
        showAd();
    }

    private void setOrientation() {
        if (getResources().getConfiguration().orientation == 2) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.vivo.mobilead.unified.interstitial.l.b bVar = this.rewardVideoAdView;
        if (bVar == null || !bVar.b()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        super.onCreate(bundle);
        setOrientation();
        initData();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.vivo.mobilead.unified.interstitial.l.b bVar = this.rewardVideoAdView;
        if (bVar != null) {
            bVar.d();
        }
        com.vivo.mobilead.m.a.a().a(this.requestId);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.vivo.mobilead.unified.interstitial.l.b bVar = this.rewardVideoAdView;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.vivo.mobilead.unified.interstitial.l.b bVar = this.rewardVideoAdView;
        if (bVar != null) {
            if (this.isStart) {
                bVar.e();
            } else {
                bVar.f();
                this.isStart = true;
            }
        }
    }

    public void showAd() {
        com.vivo.ad.model.b bVar = this.adItemData;
        if (bVar == null || bVar.Q() == null || TextUtils.isEmpty(this.adItemData.Q().g())) {
            finish();
            return;
        }
        if (this.rewardVideoAdView == null) {
            this.rewardVideoAdView = new com.vivo.mobilead.unified.interstitial.l.b(this, this.adItemData, this.sourceAppend, this.adType, this.backUrlInfo, 1, this.interstitialListener, this.mediaListener);
        }
        setContentView(this.rewardVideoAdView.a());
    }
}
