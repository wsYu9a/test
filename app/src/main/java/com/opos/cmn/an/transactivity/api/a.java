package com.opos.cmn.an.transactivity.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* loaded from: classes4.dex */
public class a {
    public static void a(Context context, b bVar) {
        try {
            if (bVar == null) {
                com.opos.cmn.an.f.a.b("TransActivityTool", "startTransActivity failed, transLifeCallback cannot be null");
                return;
            }
            Intent intent = new Intent(context, (Class<?>) TransActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            }
            intent.putExtra("extra_key_trans_life_callback", bVar);
            context.startActivity(intent);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("TransActivityTool", "startTransActivity failed", e2);
        }
    }
}
