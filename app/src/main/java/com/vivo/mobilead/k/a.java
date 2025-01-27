package com.vivo.mobilead.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.vivo.mobilead.manager.c;
import com.vivo.mobilead.util.h0;
import com.vivo.mobilead.util.x0;

/* loaded from: classes4.dex */
public class a extends BroadcastReceiver {

    /* renamed from: a */
    private boolean f28920a = false;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        x0.c("ReporterNetChangerReceiver", "onReceive net change");
        if (this.f28920a) {
            x0.e("ReporterNetChangerReceiver", "has deal, return");
        } else if (h0.K().l() != 0) {
            x0.c("ReporterNetChangerReceiver", "network connected");
            this.f28920a = true;
            c.d().b();
            c.d().a();
        }
    }
}
