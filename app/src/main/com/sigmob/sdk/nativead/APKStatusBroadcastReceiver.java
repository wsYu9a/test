package com.sigmob.sdk.nativead;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.IntentActions;

/* loaded from: classes4.dex */
public class APKStatusBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: b */
    public o.a f19884b;

    /* renamed from: c */
    public IntentFilter f19885c;

    public APKStatusBroadcastReceiver(o.a aVar, String str) {
        super(str);
        this.f19884b = aVar;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (this.f19885c == null) {
            IntentFilter intentFilter = new IntentFilter();
            this.f19885c = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
            this.f19885c.addAction(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE);
            this.f19885c.addAction(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
            this.f19885c.addAction(IntentActions.ACTION_INTERSTITIAL_INSTALL_START);
            this.f19885c.addAction(IntentActions.ACTION_INTERSTITIAL_INSTALL_END);
        }
        return this.f19885c;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.f19884b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean equalsIgnoreCase;
        long longExtra;
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.f19884b != null && a(intent)) {
            String action = intent.getAction();
            equalsIgnoreCase = "1".equalsIgnoreCase(intent.getStringExtra(p3.i.f29758c));
            longExtra = intent.getLongExtra("downloadId", -1L);
            action.hashCode();
            switch (action) {
                case "action.interstitial.download.end":
                    this.f19884b.c(equalsIgnoreCase, longExtra);
                    break;
                case "action.interstitial.download.pause":
                    this.f19884b.a(equalsIgnoreCase, longExtra);
                    break;
                case "action.interstitial.download.start":
                    this.f19884b.b(equalsIgnoreCase, longExtra);
                    break;
                case "action.interstitial.install.end":
                    this.f19884b.b(equalsIgnoreCase);
                    break;
                case "action.interstitial.install.start":
                    this.f19884b.a(equalsIgnoreCase);
                    break;
            }
        }
    }
}
