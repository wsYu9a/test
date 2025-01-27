package com.kwad.components.core.d.b;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* loaded from: classes2.dex */
public final class e {
    private static boolean Jn = false;

    /* renamed from: com.kwad.components.core.d.b.e$1 */
    static class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.az(false);
            com.kwad.sdk.core.b.b.vS();
            if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                return;
            }
            com.kwad.sdk.core.report.a.a(AdTemplate.this, "wxsmallapp", 1);
        }
    }

    private static void J(AdTemplate adTemplate) {
        if (nt()) {
            return;
        }
        az(true);
        int abs = Math.abs(com.kwad.sdk.core.config.d.uo());
        if (abs > 0) {
            bi.a(new Runnable() { // from class: com.kwad.components.core.d.b.e.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e.az(false);
                    com.kwad.sdk.core.b.b.vS();
                    if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.report.a.a(AdTemplate.this, "wxsmallapp", 1);
                }
            }, null, abs * 1000);
        } else {
            az(false);
        }
    }

    public static int a(Context context, String str, String str2, String str3, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            com.kwad.sdk.core.report.a.k(adTemplate, 1);
            return -1;
        }
        Cursor cursor = null;
        try {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                intent.setComponent(launchIntentForPackage.getComponent());
                context.startActivity(intent);
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{str, str2, str3, "0", ""}, null);
                if (query != null) {
                    try {
                        com.kwad.sdk.crash.utils.b.closeQuietly(query);
                    } catch (Exception unused) {
                        cursor = query;
                        com.kwad.sdk.core.report.a.k(adTemplate, 2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return -1;
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        throw th;
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(query);
                com.kwad.sdk.core.report.a.a(adTemplate, "wxsmallapp", 1, (y.b) null);
                J(adTemplate);
                return 1;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused2) {
        }
    }

    public static void az(boolean z) {
        Jn = z;
    }

    public static int f(Context context, AdTemplate adTemplate) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (com.kwad.sdk.core.response.a.a.L(cb) || com.kwad.sdk.core.response.a.a.M(cb)) {
            return 0;
        }
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = cb.adConversionInfo.smallAppJumpInfo;
        return a(context, smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, adTemplate);
    }

    private static boolean nt() {
        return Jn;
    }
}
