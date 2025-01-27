package com.wbl.ad.yzz.ms.f.o;

import android.content.Context;
import android.webkit.DownloadListener;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class a implements DownloadListener {

    /* renamed from: a */
    public Context f33292a;

    public a(Context context) {
        this.f33292a = context;
    }

    public static a a(Context context) {
        return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11391, null, context);
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11386, this, str, str2, str3, str4, Long.valueOf(j2));
    }
}
