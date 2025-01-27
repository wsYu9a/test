package com.wbl.ad.yzz.bean;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiConfigSingleton;
import com.tencent.open.SocialConstants;
import com.wbl.ad.yzz.network.b.b.x;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b=\u0010>J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0005\u0010\f\"\u0004\b\u0005\u0010\rR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0005\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u0005\u0010\u001bR$\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u0007\u0010\u0015R$\u0010&\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b\u0005\u0010%R$\u0010(\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b!\u0010\u0015R$\u0010+\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0011\u001a\u0004\b*\u0010\u0013\"\u0004\b*\u0010\u0015R\u0018\u0010.\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R$\u00101\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0011\u001a\u0004\b)\u0010\u0013\"\u0004\b0\u0010\u0015R\u0019\u00107\u001a\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013\"\u0004\b#\u0010\u0015R$\u00109\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b3\u0010\u0013\"\u0004\b\u001e\u0010\u0015R$\u0010:\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b'\u0010\u0013\"\u0004\b)\u0010\u0015R$\u0010\u0003\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0011\u001a\u0004\b/\u0010\u0013\"\u0004\b/\u0010\u0015R$\u0010;\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u0014\u0010\u001bR$\u0010<\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b0\u0010\u0013\"\u0004\b3\u0010\u0015¨\u0006?"}, d2 = {"Lcom/wbl/ad/yzz/bean/r;", "", "Lcom/wbl/ad/yzz/bean/p;", "link", "", "a", "(Lcom/wbl/ad/yzz/bean/p;)V", OapsKey.KEY_GRADE, "()Lcom/wbl/ad/yzz/bean/p;", "", "o", "I", "()I", "(I)V", "app_Status", "", "btn_txt", "Ljava/lang/String;", "getBtn_txt", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "bookId", "getBookId", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "(Ljava/lang/Integer;)V", "type", "m", "h", "link_download_url", "Lcom/wbl/ad/yzz/network/b/b/x;", com.kwad.sdk.ranger.e.TAG, "Lcom/wbl/ad/yzz/network/b/b/x;", "c", "()Lcom/wbl/ad/yzz/network/b/b/x;", "(Lcom/wbl/ad/yzz/network/b/b/x;)V", MiConfigSingleton.u0, t.f9404d, "kpa_name", "k", "d", "kpa_mda5", "n", "Lcom/wbl/ad/yzz/bean/p;", "mLinkSkip", "f", com.opos.mobad.f.a.j.f20763a, "video", "Ljava/lang/Object;", "i", "Ljava/lang/Object;", "getLuck", "()Ljava/lang/Object;", "luck", SocialConstants.PARAM_APP_DESC, "scheme", "videoid", "is_dwlod", "title", "<init>", "()V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class r {

    /* renamed from: a, reason: from kotlin metadata */
    @f.b.a.e
    public Integer type;

    /* renamed from: b, reason: from kotlin metadata */
    @f.b.a.e
    public String title;

    /* renamed from: c, reason: from kotlin metadata */
    @f.b.a.e
    public String com.tencent.open.SocialConstants.PARAM_APP_DESC java.lang.String;

    /* renamed from: d, reason: from kotlin metadata */
    @f.b.a.e
    public String link;

    /* renamed from: e */
    @f.b.a.e
    public x image;

    /* renamed from: f, reason: from kotlin metadata */
    @f.b.a.e
    public String video;

    /* renamed from: g */
    @f.b.a.e
    public String scheme;

    /* renamed from: h, reason: from kotlin metadata */
    @f.b.a.e
    public String videoid;

    /* renamed from: i, reason: from kotlin metadata */
    @f.b.a.d
    public final Object luck = new Object();

    /* renamed from: j */
    @f.b.a.e
    public Integer is_dwlod = 0;

    /* renamed from: k, reason: from kotlin metadata */
    @f.b.a.e
    public String kpa_mda5;

    /* renamed from: l */
    @f.b.a.e
    public String kpa_name;

    /* renamed from: m, reason: from kotlin metadata */
    @f.b.a.e
    public String link_download_url;

    /* renamed from: n, reason: from kotlin metadata */
    public p mLinkSkip;

    /* renamed from: o, reason: from kotlin metadata */
    public int app_Status;

    public final int a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14929, this, null);
    }

    public final void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14932, this, Integer.valueOf(i2));
    }

    public final void a(p link) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14931, this, link);
    }

    public final void a(x xVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15022, this, xVar);
    }

    public final void a(Integer num) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15021, this, num);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15024, this, str);
    }

    public final String b() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15023, this, null);
    }

    public final void b(Integer num) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15018, this, num);
    }

    public final void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15017, this, str);
    }

    public final x c() {
        return (x) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15020, this, null);
    }

    public final void c(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15019, this, str);
    }

    public final String d() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15014, this, null);
    }

    public final void d(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15013, this, str);
    }

    public final String e() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15016, this, null);
    }

    public final void e(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15015, this, str);
    }

    public final String f() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15010, this, null);
    }

    public final void f(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15009, this, str);
    }

    public final p g() {
        return (p) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15012, this, null);
    }

    public final void g(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15011, this, str);
    }

    public final Integer getType() {
        return (Integer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15038, this, null);
    }

    public final String h() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15037, this, null);
    }

    public final void h(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15040, this, str);
    }

    public final String i() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15039, this, null);
    }

    public final void i(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15034, this, str);
    }

    public final String j() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15033, this, null);
    }

    public final void j(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15036, this, str);
    }

    public final String k() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15035, this, null);
    }

    public final void k(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15030, this, str);
    }

    public final String l() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15029, this, null);
    }

    public final Integer m() {
        return (Integer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15032, this, null);
    }
}
