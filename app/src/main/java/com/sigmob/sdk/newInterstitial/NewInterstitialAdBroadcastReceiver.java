package com.sigmob.sdk.newInterstitial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.newInterstitial.e;

/* loaded from: classes4.dex */
public class NewInterstitialAdBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: d */
    public static IntentFilter f20140d;

    /* renamed from: b */
    public e.b f20141b;

    /* renamed from: c */
    public BaseAdUnit f20142c;

    public NewInterstitialAdBroadcastReceiver(BaseAdUnit baseAdUnit, e.b bVar, String str) {
        super(str);
        this.f20142c = baseAdUnit;
        this.f20141b = bVar;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (f20140d == null) {
            IntentFilter intentFilter = new IntentFilter();
            f20140d = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
            f20140d.addAction(IntentActions.ACTION_REWARDED_VIDEO_SKIP);
            f20140d.addAction(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            f20140d.addAction(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
            f20140d.addAction(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
        }
        return f20140d;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.f20141b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.f20141b == null || this.f20142c == null || !a(intent)) {
            return;
        }
        String action = intent.getAction();
        action.hashCode();
        switch (action) {
            case "action.rewardedvideo.playFail":
                this.f20141b.a(this.f20142c, intent.getStringExtra("error"));
                break;
            case "action.rewardedvideo.play":
                this.f20141b.b(this.f20142c);
                return;
            case "action.rewardedvideo.skip":
                this.f20141b.j(this.f20142c);
                return;
            case "action.rewardedvideo.Close":
                this.f20141b.h(this.f20142c);
                break;
            default:
                return;
        }
        b(this);
        this.f20142c = null;
    }
}
