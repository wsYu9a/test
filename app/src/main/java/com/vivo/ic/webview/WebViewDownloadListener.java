package com.vivo.ic.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import com.vivo.mobilead.web.c;

/* loaded from: classes4.dex */
public class WebViewDownloadListener implements DownloadListener {
    private boolean allowJumpNonClick;
    private long allowedMaxInterval;
    private c getDispatchTouch;
    private Context mContext;

    public WebViewDownloadListener(Context context) {
        this.allowJumpNonClick = true;
        this.allowedMaxInterval = 200L;
        this.mContext = context;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        if (this.getDispatchTouch == null || this.allowJumpNonClick || Math.abs(System.currentTimeMillis() - this.getDispatchTouch.getDispatchTouchTime()) <= this.allowedMaxInterval) {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            intent.setData(Uri.parse(str));
            try {
                this.mContext.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public WebViewDownloadListener(Context context, c cVar, long j2, boolean z) {
        this(context);
        this.getDispatchTouch = cVar;
        this.allowedMaxInterval = j2;
        this.allowJumpNonClick = z;
    }
}
