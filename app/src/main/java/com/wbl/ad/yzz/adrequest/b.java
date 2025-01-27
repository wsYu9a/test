package com.wbl.ad.yzz.adrequest;

import android.content.Context;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.mobad.f.a.j;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.tencent.open.SocialConstants;
import com.wbl.ad.yzz.bean.r;
import com.wbl.ad.yzz.network.b.b.x;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a */
    @d
    public static final b f31528a = new b();

    public static final class a {

        /* renamed from: a */
        @e
        public String f31529a;

        /* renamed from: b */
        @e
        public String f31530b;

        /* renamed from: c */
        @e
        public String f31531c;

        /* renamed from: d */
        public int f31532d;

        /* renamed from: e */
        @e
        public com.wbl.ad.yzz.innerconfig.d.e f31533e;

        public final int a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15739, this, null);
        }

        public final a a(com.wbl.ad.yzz.innerconfig.d.e eVar) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15734, this, eVar);
        }

        public final a a(String str) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15733, this, str);
        }

        public final a b(String str) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15736, this, str);
        }

        public final com.wbl.ad.yzz.innerconfig.d.e b() {
            return (com.wbl.ad.yzz.innerconfig.d.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15735, this, null);
        }

        public final a c(String str) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15730, this, str);
        }

        public final String c() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15729, this, null);
        }

        public final String d() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15732, this, null);
        }

        public final String e() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15731, this, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\nR$\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0013\u001a\u0004\b\t\u0010\u0015\"\u0004\b\u0019\u0010\u0017R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R$\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0010\u0010\u0015\"\u0004\b\u001d\u0010\u0017R$\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R$\u0010'\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010#\u001a\u0004\b\f\u0010$\"\u0004\b%\u0010&R$\u0010*\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0013\u001a\u0004\b\u0005\u0010\u0015\"\u0004\b)\u0010\u0017R$\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R$\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b(\u0010\u0015\"\u0004\b.\u0010\u0017R$\u00100\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b/\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0013\u001a\u0004\b\u000e\u0010\u0015\"\u0004\b7\u0010\u0017R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u00101\u001a\u0004\b6\u00103\"\u0004\b8\u00105¨\u0006;"}, d2 = {"com/wbl/ad/yzz/adrequest/b$b", "", "", "type", "Lcom/wbl/ad/yzz/adrequest/b$b;", "b", "(Ljava/lang/Integer;)Lcom/wbl/ad/yzz/adrequest/b$b;", "", "link", "c", "(Ljava/lang/String;)Lcom/wbl/ad/yzz/adrequest/b$b;", "scheme", "d", "videoid", com.kwad.sdk.ranger.e.TAG, "is_dwlod", "a", "kpa_mda5", "kpa_name", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "setDesc", SocialConstants.PARAM_APP_DESC, OapsKey.KEY_GRADE, "setLink", "setBookId", "bookId", j.f20763a, "k", "setVideoid", "Lcom/wbl/ad/yzz/network/b/b/x;", "Lcom/wbl/ad/yzz/network/b/b/x;", "()Lcom/wbl/ad/yzz/network/b/b/x;", "setImage", "(Lcom/wbl/ad/yzz/network/b/b/x;)V", MiConfigSingleton.u0, "h", "setBtn_txt", "btn_txt", "m", "f", "setKpa_name", "setScheme", "setVideo", "video", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", t.f9404d, "setKpa_mda5", "set_dwlod", "<init>", "()V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.wbl.ad.yzz.adrequest.b$b */
    public static final class C0688b {

        /* renamed from: a, reason: from kotlin metadata */
        @e
        public Integer type;

        /* renamed from: b, reason: from kotlin metadata */
        @e
        public String title;

        /* renamed from: c, reason: from kotlin metadata */
        @e
        public String com.tencent.open.SocialConstants.PARAM_APP_DESC java.lang.String;

        /* renamed from: d, reason: from kotlin metadata */
        @e
        public String link;

        /* renamed from: e */
        @e
        public x image;

        /* renamed from: f, reason: from kotlin metadata */
        @e
        public String video;

        /* renamed from: g */
        @e
        public String scheme;

        /* renamed from: h, reason: from kotlin metadata */
        @e
        public String btn_txt;

        /* renamed from: i, reason: from kotlin metadata */
        @e
        public String bookId;

        /* renamed from: j */
        @e
        public String videoid;

        /* renamed from: k, reason: from kotlin metadata */
        @e
        public Integer is_dwlod = 0;

        /* renamed from: l */
        @e
        public String kpa_mda5;

        /* renamed from: m, reason: from kotlin metadata */
        @e
        public String kpa_name;

        public final C0688b a(Integer is_dwlod) {
            return (C0688b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15694, this, is_dwlod);
        }

        public final C0688b a(String kpa_mda5) {
            return (C0688b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15693, this, kpa_mda5);
        }

        public final String a() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15696, this, null);
        }

        public final C0688b b(Integer type) {
            return (C0688b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15695, this, type);
        }

        public final C0688b b(String kpa_name) {
            return (C0688b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15690, this, kpa_name);
        }

        public final String b() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15689, this, null);
        }

        public final C0688b c(String link) {
            return (C0688b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15692, this, link);
        }

        public final String c() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15691, this, null);
        }

        public final C0688b d(String scheme) {
            return (C0688b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15686, this, scheme);
        }

        public final x d() {
            return (x) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15685, this, null);
        }

        public final C0688b e(String str) {
            return (C0688b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15688, this, str);
        }

        public final String e() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15687, this, null);
        }

        public final String f() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15682, this, null);
        }

        public final String g() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15681, this, null);
        }

        public final Integer getType() {
            return (Integer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15684, this, null);
        }

        public final String h() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15683, this, null);
        }

        public final String i() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15710, this, null);
        }

        public final String j() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15709, this, null);
        }

        public final String k() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15712, this, null);
        }

        public final Integer l() {
            return (Integer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15711, this, null);
        }
    }

    public final com.wbl.ad.yzz.adapter.d.b a(NativeResponse nativeResponse, com.wbl.ad.yzz.network.b.b.b bVar) {
        return (com.wbl.ad.yzz.adapter.d.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15706, this, nativeResponse, bVar);
    }

    public final com.wbl.ad.yzz.adapter.d.b a(TTFeedAd tTFeedAd, com.wbl.ad.yzz.network.b.b.b bVar) {
        return (com.wbl.ad.yzz.adapter.d.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15705, this, tTFeedAd, bVar);
    }

    public final com.wbl.ad.yzz.adapter.d.b a(TTNativeExpressAd tTNativeExpressAd, com.wbl.ad.yzz.network.b.b.b bVar) {
        return (com.wbl.ad.yzz.adapter.d.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15708, this, tTNativeExpressAd, bVar);
    }

    public final com.wbl.ad.yzz.adapter.d.b a(NativeUnifiedADData nativeUnifiedADData, com.wbl.ad.yzz.network.b.b.b bVar) {
        return (com.wbl.ad.yzz.adapter.d.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15707, this, nativeUnifiedADData, bVar);
    }

    public final com.wbl.ad.yzz.adapter.d.b a(com.wbl.ad.yzz.ms.f.h.h.a aVar, com.wbl.ad.yzz.network.b.b.b bVar) {
        return (com.wbl.ad.yzz.adapter.d.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15702, this, aVar, bVar);
    }

    public final com.wbl.ad.yzz.bean.b a(a aVar) {
        return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15701, this, aVar);
    }

    public final com.wbl.ad.yzz.bean.b a(com.wbl.ad.yzz.network.b.b.b bVar) {
        return (com.wbl.ad.yzz.bean.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15704, this, bVar);
    }

    public final r a(C0688b c0688b) {
        return (r) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15703, this, c0688b);
    }

    public final com.wbl.ad.yzz.network.b.b.b a(String str, String str2, String str3, String str4, String str5, String str6) {
        return (com.wbl.ad.yzz.network.b.b.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15698, this, str, str2, str3, str4, str5, str6);
    }

    public final void a(Context context, com.wbl.ad.yzz.bean.b bVar, r rVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15697, this, context, bVar, rVar);
    }

    public final r b(com.wbl.ad.yzz.network.b.b.b bVar) {
        return (r) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15700, this, bVar);
    }

    public final com.wbl.ad.yzz.adapter.d.b c(com.wbl.ad.yzz.network.b.b.b bVar) {
        return (com.wbl.ad.yzz.adapter.d.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15699, this, bVar);
    }

    public final com.wbl.ad.yzz.adapter.d.b d(com.wbl.ad.yzz.network.b.b.b bVar) {
        return (com.wbl.ad.yzz.adapter.d.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15790, this, bVar);
    }
}
