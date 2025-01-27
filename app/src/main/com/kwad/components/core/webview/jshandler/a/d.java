package com.kwad.components.core.webview.jshandler.a;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class d implements com.kwad.sdk.core.webview.c.a {
    private final WeakReference<Context> abo;

    public d(Context context) {
        this.abo = new WeakReference<>(context);
    }

    @SuppressLint({"WrongConstant"})
    private static boolean aw(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI"));
            intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            intent.setFlags(335544320);
            intent.setAction("android.intent.action.VIEW");
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.abo.get() != null) {
            boolean aw = aw(this.abo.get());
            if (cVar != null) {
                if (aw) {
                    cVar.a(null);
                } else {
                    cVar.onError(-1, "wechat launch error");
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "openWechatQRScan";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
