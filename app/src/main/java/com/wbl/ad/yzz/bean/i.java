package com.wbl.ad.yzz.bean;

import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;

/* loaded from: classes5.dex */
public abstract class i extends h {

    /* renamed from: b */
    public final h f31576b;

    /* renamed from: c */
    public final b f31577c;

    /* renamed from: d */
    public TextView f31578d;

    public i(@f.b.a.e b bVar, @f.b.a.e TextView textView, @f.b.a.e TTAppDownloadListener tTAppDownloadListener) {
        super(tTAppDownloadListener);
        this.f31577c = bVar;
        this.f31578d = textView;
        j L = bVar != null ? bVar.L() : null;
        if (L != null) {
            this.f31576b = new m(L, this, tTAppDownloadListener);
        } else {
            this.f31576b = new l(this, tTAppDownloadListener);
        }
    }

    @Override // com.wbl.ad.yzz.bean.g
    public boolean a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-16205, this, null);
    }

    @Override // com.wbl.ad.yzz.bean.h
    public String c() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16208, this, null);
    }

    @Override // com.wbl.ad.yzz.bean.h
    public void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16207, this, null);
    }

    @Override // com.wbl.ad.yzz.bean.h, com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j2, long j3, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16202, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
    }

    @Override // com.wbl.ad.yzz.bean.h, com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j2, long j3, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16201, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
    }

    @Override // com.wbl.ad.yzz.bean.h, com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j2, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16204, this, Long.valueOf(j2), str, str2);
    }

    @Override // com.wbl.ad.yzz.bean.h, com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j2, long j3, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16203, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
    }

    @Override // com.wbl.ad.yzz.bean.h, com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16198, this, null);
    }

    @Override // com.wbl.ad.yzz.bean.h, com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16197, this, str, str2);
    }
}
