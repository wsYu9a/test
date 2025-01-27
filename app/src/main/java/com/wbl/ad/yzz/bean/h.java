package com.wbl.ad.yzz.bean;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;

/* loaded from: classes5.dex */
public abstract class h implements TTAppDownloadListener, g {

    /* renamed from: a */
    public final TTAppDownloadListener f31575a;

    public h(@f.b.a.e TTAppDownloadListener tTAppDownloadListener) {
        this.f31575a = tTAppDownloadListener;
    }

    public final void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16245, this, Integer.valueOf(i2));
    }

    public abstract void a(@f.b.a.e String str, @f.b.a.e String str2);

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16248, this, null);
    }

    @f.b.a.d
    public abstract String c();

    public abstract boolean d();

    public abstract void e();

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j2, long j3, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16247, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j2, long j3, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16242, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j2, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16241, this, Long.valueOf(j2), str, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j2, long j3, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16244, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16243, this, null);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16206, this, str, str2);
    }
}
