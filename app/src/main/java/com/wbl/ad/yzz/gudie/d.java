package com.wbl.ad.yzz.gudie;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.cdo.oaps.ad.OapsKey;
import com.opos.mobad.f.a.j;
import com.wbl.ad.yzz.feedback.b;
import com.wbl.ad.yzz.gudie.g.d;
import com.wbl.ad.yzz.network.b.b.k;
import com.wbl.ad.yzz.network.b.b.o;
import com.wbl.ad.yzz.network.b.b.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: a */
    public com.wbl.ad.yzz.gudie.g.c f32540a;

    /* renamed from: b */
    public final Activity f32541b;

    /* renamed from: c */
    public final d.a f32542c;

    /* renamed from: d */
    public final a f32543d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bM\u0010NJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0005\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0005\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0005\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0005\u0010\u0019J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0005\u0010\u001dJ\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u0005\u0010\u001fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b\f\u00102\"\u0004\b3\u00104R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00105\u001a\u0004\b*\u00106\"\u0004\b7\u00108R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010&\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010F\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010B\u001a\u0004\b0\u0010C\"\u0004\bD\u0010ER\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010GR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\b9\u0010J\"\u0004\bK\u0010L¨\u0006O"}, d2 = {"com/wbl/ad/yzz/gudie/d$a", "", "Landroid/app/Activity;", "context", "Lcom/wbl/ad/yzz/gudie/d$a;", "a", "(Landroid/app/Activity;)Lcom/wbl/ad/yzz/gudie/d$a;", "Lcom/wbl/ad/yzz/network/b/b/k;", "confBean", "(Lcom/wbl/ad/yzz/network/b/b/k;)Lcom/wbl/ad/yzz/gudie/d$a;", "", "type", "b", "(I)Lcom/wbl/ad/yzz/gudie/d$a;", "Lcom/wbl/ad/yzz/network/b/b/u;", "pageMsgRes", "(Lcom/wbl/ad/yzz/network/b/b/u;)Lcom/wbl/ad/yzz/gudie/d$a;", "Lcom/wbl/ad/yzz/gudie/g/d$a;", "onGuideClickListener", "(Lcom/wbl/ad/yzz/gudie/g/d$a;)Lcom/wbl/ad/yzz/gudie/d$a;", "Lcom/wbl/ad/yzz/feedback/b$a;", "onFeedbackListener", "(Lcom/wbl/ad/yzz/feedback/b$a;)Lcom/wbl/ad/yzz/gudie/d$a;", "Lcom/wbl/ad/yzz/adapter/c/b;", "itemListener", "(Lcom/wbl/ad/yzz/adapter/c/b;)Lcom/wbl/ad/yzz/gudie/d$a;", "startType", "Lcom/wbl/ad/yzz/innerconfig/d/j;", "sceneDataInfoWrap", "(Lcom/wbl/ad/yzz/innerconfig/d/j;)Lcom/wbl/ad/yzz/gudie/d$a;", "Lcom/wbl/ad/yzz/gudie/d;", "()Lcom/wbl/ad/yzz/gudie/d;", "d", "Lcom/wbl/ad/yzz/adapter/c/b;", "()Lcom/wbl/ad/yzz/adapter/c/b;", "setItemListener", "(Lcom/wbl/ad/yzz/adapter/c/b;)V", "i", "I", "()I", "setStartType", "(I)V", OapsKey.KEY_GRADE, "Lcom/wbl/ad/yzz/gudie/g/d$a;", "f", "()Lcom/wbl/ad/yzz/gudie/g/d$a;", "setOnGuideClickListener", "(Lcom/wbl/ad/yzz/gudie/g/d$a;)V", "c", "Lcom/wbl/ad/yzz/network/b/b/k;", "()Lcom/wbl/ad/yzz/network/b/b/k;", "setConfBean", "(Lcom/wbl/ad/yzz/network/b/b/k;)V", "Lcom/wbl/ad/yzz/network/b/b/u;", "()Lcom/wbl/ad/yzz/network/b/b/u;", "setPageMsgRes", "(Lcom/wbl/ad/yzz/network/b/b/u;)V", "h", "getType", "setType", "Lcom/wbl/ad/yzz/feedback/b$a;", com.kwad.sdk.ranger.e.TAG, "()Lcom/wbl/ad/yzz/feedback/b$a;", "setOnFeedbackListener", "(Lcom/wbl/ad/yzz/feedback/b$a;)V", "Lcom/wbl/ad/yzz/network/b/b/o;", "Lcom/wbl/ad/yzz/network/b/b/o;", "()Lcom/wbl/ad/yzz/network/b/b/o;", "setFeedbackReportBean", "(Lcom/wbl/ad/yzz/network/b/b/o;)V", "feedbackReportBean", "Landroid/app/Activity;", j.f20763a, "Lcom/wbl/ad/yzz/innerconfig/d/j;", "()Lcom/wbl/ad/yzz/innerconfig/d/j;", "setSceneDataInfoWrap", "(Lcom/wbl/ad/yzz/innerconfig/d/j;)V", "<init>", "()V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* renamed from: a, reason: from kotlin metadata */
        public Activity context;

        /* renamed from: b, reason: from kotlin metadata */
        @f.b.a.e
        public u pageMsgRes;

        /* renamed from: c, reason: from kotlin metadata */
        @f.b.a.e
        public k confBean;

        /* renamed from: d, reason: from kotlin metadata */
        @f.b.a.e
        public com.wbl.ad.yzz.adapter.c.b itemListener;

        /* renamed from: e */
        @f.b.a.e
        public o feedbackReportBean;

        /* renamed from: f, reason: from kotlin metadata */
        @f.b.a.e
        public b.a onFeedbackListener;

        /* renamed from: g */
        @f.b.a.e
        public d.a onGuideClickListener;

        /* renamed from: h, reason: from kotlin metadata */
        public int type;

        /* renamed from: i, reason: from kotlin metadata */
        public int startType;

        /* renamed from: j */
        @f.b.a.e
        public com.wbl.ad.yzz.innerconfig.d.j sceneDataInfoWrap;

        public final a a(int startType) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13313, this, Integer.valueOf(startType));
        }

        public final a a(Activity context) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13316, this, context);
        }

        public final a a(com.wbl.ad.yzz.adapter.c.b itemListener) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13315, this, itemListener);
        }

        public final a a(b.a onFeedbackListener) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13342, this, onFeedbackListener);
        }

        public final a a(d.a onGuideClickListener) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13341, this, onGuideClickListener);
        }

        public final a a(com.wbl.ad.yzz.innerconfig.d.j sceneDataInfoWrap) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13344, this, sceneDataInfoWrap);
        }

        public final a a(k confBean) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13343, this, confBean);
        }

        public final a a(u pageMsgRes) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13338, this, pageMsgRes);
        }

        public final d a() {
            return (d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13337, this, null);
        }

        public final a b(int type) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13340, this, Integer.valueOf(type));
        }

        public final k b() {
            return (k) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13339, this, null);
        }

        public final o c() {
            return (o) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13334, this, null);
        }

        public final com.wbl.ad.yzz.adapter.c.b d() {
            return (com.wbl.ad.yzz.adapter.c.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13333, this, null);
        }

        public final b.a e() {
            return (b.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13336, this, null);
        }

        public final d.a f() {
            return (d.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13335, this, null);
        }

        public final u g() {
            return (u) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13330, this, null);
        }

        public final int getType() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13329, this, null);
        }

        public final com.wbl.ad.yzz.innerconfig.d.j h() {
            return (com.wbl.ad.yzz.innerconfig.d.j) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13332, this, null);
        }

        public final int i() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13331, this, null);
        }
    }

    public static final class b implements d.a {
        public b() {
        }

        @Override // com.wbl.ad.yzz.gudie.g.d.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13422, this, null);
        }

        @Override // com.wbl.ad.yzz.gudie.g.d.a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13421, this, null);
        }

        @Override // com.wbl.ad.yzz.gudie.g.d.a
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13424, this, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@f.b.a.d Activity context, @f.b.a.d a builder) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f32541b = context;
        this.f32543d = builder;
        this.f32542c = builder.f();
    }

    public static final /* synthetic */ d.a a(d dVar) {
        return (d.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13423, null, dVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13418, this, null);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13417, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13420, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13419, this, bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13414, this, null);
    }

    @Override // android.app.Dialog
    public void show() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13413, this, null);
    }
}
