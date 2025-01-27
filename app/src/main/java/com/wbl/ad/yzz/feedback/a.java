package com.wbl.ad.yzz.feedback;

import android.content.Context;
import android.os.Bundle;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.cdo.oaps.ad.OapsKey;
import com.wbl.ad.yzz.feedback.b;
import com.wbl.ad.yzz.innerconfig.d.d;
import com.wbl.ad.yzz.network.b.b.o;
import com.wbl.ad.yzz.network.bean.request.UploadFeedbackReq;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: a */
    public com.wbl.ad.yzz.feedback.b f32154a;

    /* renamed from: b */
    public final Context f32155b;

    /* renamed from: c */
    public b.a f32156c;

    /* renamed from: d */
    public final o f32157d;

    /* renamed from: e */
    public final int f32158e;

    /* renamed from: f */
    public boolean f32159f;

    /* renamed from: g */
    public int f32160g;

    /* renamed from: h */
    @e
    public d f32161h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0005\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0005\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0005\u0010\u0017J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0005\u0010\u0019R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001b\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u000f\u0010)\"\u0004\b*\u0010+R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010,\u001a\u0004\b\u001a\u0010-\"\u0004\b.\u0010/R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u00100\u001a\u0004\b'\u00101\"\u0004\b2\u00103R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006;"}, d2 = {"com/wbl/ad/yzz/feedback/a$a", "", "Landroid/content/Context;", "context", "Lcom/wbl/ad/yzz/feedback/a$a;", "a", "(Landroid/content/Context;)Lcom/wbl/ad/yzz/feedback/a$a;", "Lcom/wbl/ad/yzz/network/b/b/o;", "feedbackReportBean", "(Lcom/wbl/ad/yzz/network/b/b/o;)Lcom/wbl/ad/yzz/feedback/a$a;", "Lcom/wbl/ad/yzz/feedback/b$a;", "listener", "(Lcom/wbl/ad/yzz/feedback/b$a;)Lcom/wbl/ad/yzz/feedback/a$a;", "", "userId", "b", "(I)Lcom/wbl/ad/yzz/feedback/a$a;", "", "clickSendEvent", "(Z)Lcom/wbl/ad/yzz/feedback/a$a;", "startType", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "sceneCache", "(Lcom/wbl/ad/yzz/innerconfig/d/d;)Lcom/wbl/ad/yzz/feedback/a$a;", "Lcom/wbl/ad/yzz/feedback/a;", "()Lcom/wbl/ad/yzz/feedback/a;", "d", "I", OapsKey.KEY_GRADE, "()I", "setUserId", "(I)V", "Lcom/wbl/ad/yzz/network/b/b/o;", "c", "()Lcom/wbl/ad/yzz/network/b/b/o;", "setFeedbackReportBean", "(Lcom/wbl/ad/yzz/network/b/b/o;)V", "f", "setStartType", com.kwad.sdk.ranger.e.TAG, "Z", "()Z", "setClickSendEvent", "(Z)V", "Lcom/wbl/ad/yzz/feedback/b$a;", "()Lcom/wbl/ad/yzz/feedback/b$a;", "setListener", "(Lcom/wbl/ad/yzz/feedback/b$a;)V", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "()Lcom/wbl/ad/yzz/innerconfig/d/d;", "setSceneCache", "(Lcom/wbl/ad/yzz/innerconfig/d/d;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "<init>", "()V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.wbl.ad.yzz.feedback.a$a */
    public static final class C0721a {

        /* renamed from: a, reason: from kotlin metadata */
        @e
        public Context context;

        /* renamed from: b, reason: from kotlin metadata */
        @e
        public o feedbackReportBean;

        /* renamed from: c, reason: from kotlin metadata */
        @e
        public b.a listener;

        /* renamed from: d, reason: from kotlin metadata */
        public int userId;

        /* renamed from: e */
        public boolean clickSendEvent;

        /* renamed from: f, reason: from kotlin metadata */
        public int startType;

        /* renamed from: g */
        @e
        public d sceneCache;

        public final C0721a a(int startType) {
            return (C0721a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14068, this, Integer.valueOf(startType));
        }

        public final C0721a a(Context context) {
            return (C0721a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14067, this, context);
        }

        public final C0721a a(b.a listener) {
            return (C0721a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14030, this, listener);
        }

        public final C0721a a(d sceneCache) {
            return (C0721a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14029, this, sceneCache);
        }

        public final C0721a a(o feedbackReportBean) {
            return (C0721a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14032, this, feedbackReportBean);
        }

        public final C0721a a(boolean clickSendEvent) {
            return (C0721a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14031, this, Boolean.valueOf(clickSendEvent));
        }

        public final a a() {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14026, this, null);
        }

        public final C0721a b(int userId) {
            return (C0721a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14025, this, Integer.valueOf(userId));
        }

        public final boolean b() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14028, this, null);
        }

        public final o c() {
            return (o) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14027, this, null);
        }

        public final b.a d() {
            return (b.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14022, this, null);
        }

        public final d e() {
            return (d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14021, this, null);
        }

        public final int f() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14024, this, null);
        }

        public final int g() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14023, this, null);
        }

        public final Context getContext() {
            return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14018, this, null);
        }
    }

    public static final class b implements b.a {
        public b() {
        }

        @Override // com.wbl.ad.yzz.feedback.b.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14017, this, null);
        }

        @Override // com.wbl.ad.yzz.feedback.b.a
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14020, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.feedback.b.a
        public void a(UploadFeedbackReq uploadFeedbackReq) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14019, this, uploadFeedbackReq);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@f.b.a.d Context context, @f.b.a.d C0721a builder) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f32155b = builder.getContext();
        this.f32157d = builder.c();
        this.f32156c = builder.d();
        this.f32158e = builder.g();
        this.f32159f = builder.b();
        this.f32160g = builder.f();
        this.f32161h = builder.e();
    }

    public static final /* synthetic */ b.a a(a aVar) {
        return (b.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14046, null, aVar);
    }

    public final String a() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14048, this, null);
    }

    public final boolean a(UploadFeedbackReq uploadFeedbackReq) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14047, this, uploadFeedbackReq);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14042, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14041, this, bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14044, this, null);
    }

    @Override // android.app.Dialog
    public void show() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14043, this, null);
    }
}
