package com.sigmob.sdk.videoAd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.videoAd.k;

/* loaded from: classes4.dex */
public class RewardVideoAdBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: d */
    public static IntentFilter f20404d;

    /* renamed from: b */
    public k.b f20405b;

    /* renamed from: c */
    public BaseAdUnit f20406c;

    public RewardVideoAdBroadcastReceiver(BaseAdUnit baseAdUnit, k.b bVar, String str) {
        super(str);
        this.f20406c = baseAdUnit;
        this.f20405b = bVar;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (f20404d == null) {
            IntentFilter intentFilter = new IntentFilter();
            f20404d = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
            f20404d.addAction(IntentActions.ACTION_REWARDED_VIDEO_SKIP);
            f20404d.addAction(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            f20404d.addAction(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
            f20404d.addAction(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
        }
        return f20404d;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.f20405b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.f20405b == null || this.f20406c == null || !a(intent)) {
            return;
        }
        String action = intent.getAction();
        action.hashCode();
        switch (action) {
            case "action.rewardedvideo.playFail":
                this.f20405b.c(this.f20406c, intent.getStringExtra("error"));
                break;
            case "action.rewardedvideo.play":
                this.f20405b.e(this.f20406c);
                return;
            case "action.rewardedvideo.skip":
                this.f20405b.c(this.f20406c);
                return;
            case "action.rewardedvideo.complete":
                this.f20405b.k(this.f20406c);
                return;
            case "action.rewardedvideo.Close":
                this.f20405b.f(this.f20406c);
                break;
            default:
                return;
        }
        b(this);
        this.f20406c = null;
    }
}
