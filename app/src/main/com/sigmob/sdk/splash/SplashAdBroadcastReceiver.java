package com.sigmob.sdk.splash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.splash.f;

/* loaded from: classes4.dex */
public class SplashAdBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: c */
    public static IntentFilter f20297c;

    /* renamed from: b */
    public f.a f20298b;

    public SplashAdBroadcastReceiver(f.a aVar, String str) {
        super(str);
        this.f20298b = aVar;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (f20297c == null) {
            IntentFilter intentFilter = new IntentFilter();
            f20297c = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_SPLAH_STOP_TIME);
            f20297c.addAction(IntentActions.ACTION_SPLAH_PLAYFAIL);
            f20297c.addAction(IntentActions.ACTION_SPLAH_SKIP);
            f20297c.addAction(IntentActions.ACTION_LANDPAGE_SHOW);
            f20297c.addAction(IntentActions.ACTION_LANDPAGE_DISMISS);
        }
        return f20297c;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.f20298b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.f20298b != null && a(intent)) {
            String action = intent.getAction();
            action.hashCode();
            switch (action) {
                case "action.splash.playFail":
                    this.f20298b.c();
                    break;
                case "action.splash.play":
                    this.f20298b.e();
                    break;
                case "action.splash.skip":
                    this.f20298b.j();
                    break;
                case "action.loadpage.show":
                    this.f20298b.m();
                    break;
                case "action.splash.stoptime":
                    this.f20298b.f();
                    break;
                case "action.loadpage.dismiss":
                    this.f20298b.n();
                    break;
            }
        }
    }
}
