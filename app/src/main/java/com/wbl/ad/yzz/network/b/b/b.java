package com.wbl.ad.yzz.network.b.b;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.cdo.oaps.ad.OapsKey;
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.acs.st.utils.ErrorContants;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b$\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b]\u0010^J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\f\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR$\u0010)\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR$\u0010+\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b*\u0010\u001a\"\u0004\b\u0010\u0010\u001cR\"\u0010,\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b \u0010\u001a\"\u0004\b\f\u0010\u001cR\"\u00103\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00106\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u00102R$\u00107\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\b\u0010\u001a\"\u0004\b\u0005\u0010\u001cR$\u0010:\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b9\u0010\u001cR$\u0010@\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b\u0017\u0010>\"\u0004\b\f\u0010?R$\u0010D\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0018\u001a\u0004\bB\u0010\u001a\"\u0004\bC\u0010\u001cR$\u0010F\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\bE\u0010\u001cR$\u0010H\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0018\u001a\u0004\bA\u0010\u001a\"\u0004\bG\u0010\u001cR$\u0010N\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010R\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0018\u001a\u0004\bP\u0010\u001a\"\u0004\bQ\u0010\u001cR\"\u0010S\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010.\u001a\u0004\b&\u00100\"\u0004\b\f\u00102R\"\u0010U\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010.\u001a\u0004\b\"\u00100\"\u0004\bT\u00102R$\u0010V\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\bO\u0010\u001a\"\u0004\b\"\u0010\u001cR$\u0010Y\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010\u0018\u001a\u0004\bW\u0010\u001a\"\u0004\bX\u0010\u001cR$\u0010Z\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0018\u001a\u0004\b8\u0010\u001a\"\u0004\b'\u0010\u001cR$\u0010\\\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010\u0018\u001a\u0004\b<\u0010\u001a\"\u0004\b[\u0010\u001c¨\u0006_"}, d2 = {"Lcom/wbl/ad/yzz/network/b/b/b;", "Lcom/wbl/ad/yzz/network/b/b/y;", "Lorg/json/JSONObject;", "json", "", "b", "(Lorg/json/JSONObject;)V", "Lcom/wbl/ad/yzz/network/b/b/c;", "i", "Lcom/wbl/ad/yzz/network/b/b/c;", "h", "()Lcom/wbl/ad/yzz/network/b/b/c;", "a", "(Lcom/wbl/ad/yzz/network/b/b/c;)V", "conf", "Lcom/wbl/ad/yzz/network/b/b/x;", "c", "Lcom/wbl/ad/yzz/network/b/b/x;", com.opos.mobad.f.a.j.f20763a, "()Lcom/wbl/ad/yzz/network/b/b/x;", "(Lcom/wbl/ad/yzz/network/b/b/x;)V", MiConfigSingleton.u0, "", "v", "Ljava/lang/String;", com.kuaishou.weapon.p0.t.f9404d, "()Ljava/lang/String;", "setKpa_name", "(Ljava/lang/String;)V", "kpa_name", "x", "n", "d", "poly_id", OapsKey.KEY_GRADE, "t", "f", "title", com.kuaishou.weapon.p0.t.k, com.kwad.sdk.ranger.e.TAG, "setBookid", "bookid", "m", "link", "ad_id", "", "I", "getType", "()I", "setType", "(I)V", "type", am.aD, "set_infcol", "is_infcol", SocialConstants.PARAM_APP_DESC, "s", "setVideoid", "videoid", "Lcom/wbl/ad/yzz/innerconfig/d/e;", IAdInterListener.AdReqParam.WIDTH, "Lcom/wbl/ad/yzz/innerconfig/d/e;", "()Lcom/wbl/ad/yzz/innerconfig/d/e;", "(Lcom/wbl/ad/yzz/innerconfig/d/e;)V", "userScene", "p", "q", "setScheme", "scheme", "setBtn_txt", "btn_txt", "setRp_tip_icon", "rp_tip_icon", "Ljava/lang/Integer;", "y", "()Ljava/lang/Integer;", "set_dwlod", "(Ljava/lang/Integer;)V", "is_dwlod", "u", "k", "setKpa_mda5", "kpa_mda5", OapsKey.KEY_STYLE, "setCli_rpt_swt", "cli_rpt_swt", "uniq_id", "o", "setRp_tip", "rp_tip", "supplier", "setVideo", "video", "<init>", "()V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class b extends y {

    /* renamed from: b, reason: from kotlin metadata */
    @f.b.a.e
    public String com.tencent.open.SocialConstants.PARAM_APP_DESC java.lang.String;

    /* renamed from: c, reason: from kotlin metadata */
    @f.b.a.e
    public x com.martian.mibook.application.MiConfigSingleton.u0 java.lang.String;

    /* renamed from: d, reason: from kotlin metadata */
    @f.b.a.e
    public String link;

    /* renamed from: e */
    public int style;

    /* renamed from: f, reason: from kotlin metadata */
    @f.b.a.e
    public String supplier;

    /* renamed from: g */
    @f.b.a.e
    public String title;

    /* renamed from: h, reason: from kotlin metadata */
    @f.b.a.e
    public String uniq_id;

    /* renamed from: i, reason: from kotlin metadata */
    @f.b.a.e
    public c conf;

    /* renamed from: j */
    public int cli_rpt_swt;

    /* renamed from: k, reason: from kotlin metadata */
    @f.b.a.e
    public String rp_tip;

    /* renamed from: l */
    @f.b.a.e
    public String rp_tip_icon;

    /* renamed from: m, reason: from kotlin metadata */
    public int is_infcol;

    /* renamed from: n, reason: from kotlin metadata */
    public int type;

    /* renamed from: o, reason: from kotlin metadata */
    @f.b.a.e
    public String video;

    /* renamed from: p, reason: from kotlin metadata */
    @f.b.a.e
    public String scheme;

    /* renamed from: q, reason: from kotlin metadata */
    @f.b.a.e
    public String btn_txt;

    /* renamed from: r */
    @f.b.a.e
    public String bookid;

    /* renamed from: s, reason: from kotlin metadata */
    @f.b.a.e
    public String videoid;

    /* renamed from: u, reason: from kotlin metadata */
    @f.b.a.e
    public String kpa_mda5;

    /* renamed from: v, reason: from kotlin metadata */
    @f.b.a.e
    public String kpa_name;

    /* renamed from: w */
    @f.b.a.e
    public com.wbl.ad.yzz.innerconfig.d.e userScene;

    /* renamed from: a, reason: from kotlin metadata */
    @f.b.a.d
    public String ad_id = "";

    /* renamed from: t, reason: from kotlin metadata */
    @f.b.a.e
    public Integer is_dwlod = 0;

    /* renamed from: x, reason: from kotlin metadata */
    @f.b.a.d
    public String poly_id = ErrorContants.NET_ERROR;

    public final void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11696, this, Integer.valueOf(i2));
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.e eVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11695, this, eVar);
    }

    public final void a(c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11690, this, cVar);
    }

    public final void a(x xVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11689, this, xVar);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11692, this, str);
    }

    public final void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11691, this, str);
    }

    @Override // com.wbl.ad.yzz.network.b.b.y
    public void b(JSONObject json) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11686, this, json);
    }

    public final void c(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11685, this, str);
    }

    public final String d() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11688, this, null);
    }

    public final void d(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11687, this, str);
    }

    public final String e() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11682, this, null);
    }

    public final void e(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11681, this, str);
    }

    public final String f() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11684, this, null);
    }

    public final void f(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11683, this, str);
    }

    public final int g() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11710, this, null);
    }

    public final void g(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11709, this, str);
    }

    public final int getType() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11712, this, null);
    }

    public final c h() {
        return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11711, this, null);
    }

    public final String i() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11706, this, null);
    }

    public final x j() {
        return (x) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11705, this, null);
    }

    public final String k() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11708, this, null);
    }

    public final String l() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11707, this, null);
    }

    public final String m() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11702, this, null);
    }

    public final String n() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11701, this, null);
    }

    public final String o() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11704, this, null);
    }

    public final String p() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11703, this, null);
    }

    public final String q() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11698, this, null);
    }

    public final int r() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11697, this, null);
    }

    public final String s() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11700, this, null);
    }

    public final String t() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11699, this, null);
    }

    public final String u() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11662, this, null);
    }

    public final com.wbl.ad.yzz.innerconfig.d.e v() {
        return (com.wbl.ad.yzz.innerconfig.d.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11661, this, null);
    }

    public final String w() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11664, this, null);
    }

    public final String x() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11663, this, null);
    }

    public final Integer y() {
        return (Integer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11658, this, null);
    }

    public final int z() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11657, this, null);
    }
}
