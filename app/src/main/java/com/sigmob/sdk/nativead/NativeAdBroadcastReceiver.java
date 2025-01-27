package com.sigmob.sdk.nativead;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.nativead.d;

/* loaded from: classes4.dex */
public class NativeAdBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: c */
    public static IntentFilter f19886c;

    /* renamed from: b */
    public d.b f19887b;

    public NativeAdBroadcastReceiver(d.b bVar, String str) {
        super(str);
        this.f19887b = bVar;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (f19886c == null) {
            IntentFilter intentFilter = new IntentFilter();
            f19886c = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_NATIVE_TEMPLIE_SHOW);
            f19886c.addAction(IntentActions.ACTION_NATIVE_TEMPLE_CLICK);
            f19886c.addAction(IntentActions.ACTION_NATIVE_TEMPLE_DISMISS);
            f19886c.addAction(IntentActions.ACTION_LANDPAGE_SHOW);
            f19886c.addAction(IntentActions.ACTION_LANDPAGE_DISMISS);
        }
        return f19886c;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.f19887b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.f19887b != null && a(intent)) {
            String action = intent.getAction();
            action.hashCode();
            switch (action) {
                case "action.native.temple.dismiss":
                    this.f19887b.onAdDetailDismiss();
                    break;
                case "action.native.temple.click":
                    this.f19887b.g();
                    break;
                case "action.native.temple.show":
                    this.f19887b.onAdDetailShow();
                    break;
                case "action.loadpage.show":
                    this.f19887b.m();
                    break;
                case "action.loadpage.dismiss":
                    this.f19887b.n();
                    break;
            }
        }
    }
}
