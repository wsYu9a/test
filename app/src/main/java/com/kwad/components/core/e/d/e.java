package com.kwad.components.core.e.d;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.commercial.smallApp.JumpFrom;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public final class e {
    private static boolean Nl = false;

    /* renamed from: com.kwad.components.core.e.d.e$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ JumpFrom Nm;
        final /* synthetic */ String Nn;
        final /* synthetic */ String No;
        final /* synthetic */ String Np;

        public AnonymousClass1(JumpFrom jumpFrom, String str, String str2, String str3) {
            jumpFrom = jumpFrom;
            str = str;
            str2 = str2;
            str3 = str3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.aB(false);
            com.kwad.sdk.core.c.b.Fi();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                return;
            }
            com.kwad.sdk.commercial.smallApp.a.a(AdTemplate.this, jumpFrom, str, str2, str3);
            com.kwad.sdk.core.adlog.c.c(AdTemplate.this, "wxsmallapp", 1);
        }
    }

    public static boolean E(AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo;
        return (adInfo == null || (smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo) == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.originId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl)) ? false : true;
    }

    public static int a(Context context, AdInfo.SmallAppJumpInfo smallAppJumpInfo, JumpFrom jumpFrom, AdTemplate adTemplate) {
        Throwable th2;
        Cursor cursor;
        if (!com.kwad.sdk.core.response.b.a.a(smallAppJumpInfo)) {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, "smallAppJumpInfo is invalid");
            com.kwad.sdk.core.adlog.c.j(adTemplate, 1);
            return 0;
        }
        try {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo);
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(launchIntentForPackage.getComponent());
            context.startActivity(intent);
            cursor = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, "0", ""}, null);
            if (cursor != null) {
                try {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, bt.t(th2));
                        com.kwad.sdk.core.adlog.c.j(adTemplate, 2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return -1;
                    } finally {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    }
                }
            }
            com.kwad.sdk.commercial.smallApp.a.b(adTemplate, jumpFrom, smallAppJumpInfo);
            com.kwad.sdk.core.adlog.c.a(adTemplate, "wxsmallapp", 1, (com.kwad.sdk.core.adlog.c.a) null);
            a(jumpFrom, smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, adTemplate);
            return 1;
        } catch (Throwable th4) {
            th2 = th4;
            cursor = null;
        }
    }

    public static void aB(boolean z10) {
        Nl = z10;
    }

    public static int e(Context context, AdTemplate adTemplate) {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        if (com.kwad.sdk.core.response.b.a.S(eb2)) {
            return 0;
        }
        return a(context, eb2.adConversionInfo.smallAppJumpInfo, JumpFrom.AD_PAGE, adTemplate);
    }

    private static boolean pe() {
        return Nl;
    }

    private static void a(JumpFrom jumpFrom, String str, String str2, String str3, AdTemplate adTemplate) {
        if (pe()) {
            return;
        }
        aB(true);
        int abs = Math.abs(com.kwad.sdk.core.config.d.Ds());
        if (abs > 0) {
            bt.a(new Runnable() { // from class: com.kwad.components.core.e.d.e.1
                final /* synthetic */ JumpFrom Nm;
                final /* synthetic */ String Nn;
                final /* synthetic */ String No;
                final /* synthetic */ String Np;

                public AnonymousClass1(JumpFrom jumpFrom2, String str4, String str22, String str32) {
                    jumpFrom = jumpFrom2;
                    str = str4;
                    str2 = str22;
                    str3 = str32;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e.aB(false);
                    com.kwad.sdk.core.c.b.Fi();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.commercial.smallApp.a.a(AdTemplate.this, jumpFrom, str, str2, str3);
                    com.kwad.sdk.core.adlog.c.c(AdTemplate.this, "wxsmallapp", 1);
                }
            }, null, abs * 1000);
        } else {
            aB(false);
        }
    }
}
