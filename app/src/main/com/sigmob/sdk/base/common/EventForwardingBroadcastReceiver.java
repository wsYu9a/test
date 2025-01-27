package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;

/* loaded from: classes4.dex */
public class EventForwardingBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: d */
    public static IntentFilter f17629d;

    /* renamed from: b */
    public BaseAdUnit f17630b;

    /* renamed from: c */
    public o.b f17631c;

    public EventForwardingBroadcastReceiver(BaseAdUnit baseAdUnit, o.b bVar, String str) {
        super(str);
        this.f17630b = baseAdUnit;
        this.f17631c = bVar;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (f17629d == null) {
            IntentFilter intentFilter = new IntentFilter();
            f17629d = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_INTERSTITIAL_FAIL);
            f17629d.addAction(IntentActions.ACTION_INTERSTITIAL_SHOW);
            f17629d.addAction(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            f17629d.addAction(IntentActions.ACTION_INTERSTITIAL_CLICK);
            f17629d.addAction(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        }
        return f17629d;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.f17631c = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f17631c == null || this.f17630b == null || !a(intent)) {
        }
        String action = intent.getAction();
        action.hashCode();
        switch (action) {
            case "action.interstitial.dismiss":
                this.f17631c.l(this.f17630b);
                b(this);
                this.f17630b = null;
                break;
            case "action.interstitial.click":
                this.f17631c.g(this.f17630b);
                break;
            case "action.interstitial.vopen":
                this.f17631c.a(this.f17630b);
                break;
            case "action.interstitial.fail":
                this.f17631c.b(this.f17630b, intent.getStringExtra("error"));
                break;
            case "action.interstitial.show":
                this.f17631c.d(this.f17630b);
                break;
        }
    }
}
