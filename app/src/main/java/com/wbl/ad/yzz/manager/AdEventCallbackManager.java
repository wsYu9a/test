package com.wbl.ad.yzz.manager;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.config.IEventAd;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class AdEventCallbackManager {

    /* renamed from: e */
    public static boolean f32869e;

    /* renamed from: f */
    @f.b.a.d
    public static final AdEventCallbackManager f32870f = new AdEventCallbackManager();

    /* renamed from: a */
    public static List<com.wbl.ad.yzz.bean.b> f32865a = new ArrayList();

    /* renamed from: b */
    public static List<com.wbl.ad.yzz.bean.b> f32866b = new ArrayList();

    /* renamed from: c */
    public static List<com.wbl.ad.yzz.bean.b> f32867c = new ArrayList();

    /* renamed from: d */
    public static List<String> f32868d = new ArrayList();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/wbl/ad/yzz/manager/AdEventCallbackManager$EventAd;", "Lcom/wbl/ad/yzz/config/IEventAd;", "", "getAdId", "()Ljava/lang/String;", "getAdFrom", "a", "Ljava/lang/String;", "slotId", "b", "supplier", "Lcom/wbl/ad/yzz/bean/b;", "mAd", "<init>", "(Lcom/wbl/ad/yzz/bean/b;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class EventAd implements IEventAd {

        /* renamed from: a, reason: from kotlin metadata */
        public String slotId;

        /* renamed from: b, reason: from kotlin metadata */
        public String supplier;

        public EventAd(@f.b.a.d com.wbl.ad.yzz.bean.b mAd) {
            Intrinsics.checkNotNullParameter(mAd, "mAd");
            this.slotId = "";
            this.supplier = "";
            this.slotId = Intrinsics.stringPlus(mAd.J(), "");
            this.supplier = mAd.q() + "";
        }

        @Override // com.wbl.ad.yzz.config.IEventAd
        public String getAdFrom() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13258, this, null);
        }

        @Override // com.wbl.ad.yzz.config.IEventAd
        public String getAdId() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13257, this, null);
        }
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13260, this, bVar);
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13259, this, bVar, dVar);
    }

    public final void a(List<com.wbl.ad.yzz.adapter.d.b> list, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13254, this, list, dVar);
    }

    public final void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13253, this, Boolean.valueOf(z));
    }

    public final boolean a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13256, this, null);
    }

    public final boolean a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13255, this, dVar);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13250, this, null);
    }

    public final void b(com.wbl.ad.yzz.bean.b bVar, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13249, this, bVar, dVar);
    }

    public final void b(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13252, this, dVar);
    }

    public final void b(List<com.wbl.ad.yzz.adapter.d.b> list, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13251, this, list, dVar);
    }

    public final boolean b(com.wbl.ad.yzz.bean.b bVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13278, this, bVar);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13277, this, null);
    }

    public final void c(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13280, this, dVar);
    }

    public final void c(List<com.wbl.ad.yzz.adapter.d.b> list, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13279, this, list, dVar);
    }

    public final void d(List<com.wbl.ad.yzz.bean.b> list, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13274, this, list, dVar);
    }
}
