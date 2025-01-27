package com.wbl.ad.yzz.wigdet.h;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.cdo.oaps.ad.OapsKey;
import com.wbl.ad.yzz.counttimer.b;
import com.wbl.ad.yzz.wigdet.i.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: a */
    public final Context f34468a;

    /* renamed from: b */
    public com.wbl.ad.yzz.wigdet.i.a f34469b;

    /* renamed from: c */
    public int f34470c;

    /* renamed from: d */
    public int f34471d;

    /* renamed from: e */
    public int f34472e;

    /* renamed from: f */
    public String f34473f;

    /* renamed from: g */
    public boolean f34474g;

    /* renamed from: h */
    public c f34475h;

    public static final class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8541, this, dialogInterface);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b4\u00105J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0005\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0005\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0005\u0010\u0016J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0005\u0010\u0018R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u000f\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010(\u001a\u0004\b\t\u0010*\"\u0004\b2\u0010,R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010(\u001a\u0004\b\u001d\u0010*\"\u0004\b3\u0010,¨\u00066"}, d2 = {"com/wbl/ad/yzz/wigdet/h/d$b", "", "Landroid/content/Context;", "context", "Lcom/wbl/ad/yzz/wigdet/h/d$b;", "a", "(Landroid/content/Context;)Lcom/wbl/ad/yzz/wigdet/h/d$b;", "", com.alipay.mobilesecuritysdk.deviceID.c.y, "c", "(I)Lcom/wbl/ad/yzz/wigdet/h/d$b;", "", "content", "(Ljava/lang/String;)Lcom/wbl/ad/yzz/wigdet/h/d$b;", "start", "b", "end", "Lcom/wbl/ad/yzz/wigdet/h/d$c;", "onDownloadTipsDialog", "(Lcom/wbl/ad/yzz/wigdet/h/d$c;)Lcom/wbl/ad/yzz/wigdet/h/d$b;", "", "isShowRedEnvelopesIcon", "(Z)Lcom/wbl/ad/yzz/wigdet/h/d$b;", "Lcom/wbl/ad/yzz/wigdet/h/d;", "()Lcom/wbl/ad/yzz/wigdet/h/d;", "Ljava/lang/String;", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "f", "Lcom/wbl/ad/yzz/wigdet/h/d$c;", "d", "()Lcom/wbl/ad/yzz/wigdet/h/d$c;", "setOnDownloadTipsDialog", "(Lcom/wbl/ad/yzz/wigdet/h/d$c;)V", OapsKey.KEY_GRADE, "Z", "()Z", "setShowRedEnvelopesIcon", "(Z)V", "I", com.kwad.sdk.ranger.e.TAG, "()I", "setStart", "(I)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "setEnd", "setTime", "<init>", "()V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class b {

        /* renamed from: a, reason: from kotlin metadata */
        @f.b.a.e
        public Context context;

        /* renamed from: b, reason: from kotlin metadata */
        public int com.alipay.mobilesecuritysdk.deviceID.c.y java.lang.String;

        /* renamed from: c, reason: from kotlin metadata */
        @f.b.a.e
        public String content;

        /* renamed from: d, reason: from kotlin metadata */
        public int start;

        /* renamed from: e */
        public int end;

        /* renamed from: f, reason: from kotlin metadata */
        @f.b.a.e
        public c onDownloadTipsDialog;

        /* renamed from: g */
        public boolean isShowRedEnvelopesIcon;

        public final b a(int end) {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8544, this, Integer.valueOf(end));
        }

        public final b a(Context context) {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8543, this, context);
        }

        public final b a(c onDownloadTipsDialog) {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8538, this, onDownloadTipsDialog);
        }

        public final b a(String content) {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8537, this, content);
        }

        public final b a(boolean isShowRedEnvelopesIcon) {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8540, this, Boolean.valueOf(isShowRedEnvelopesIcon));
        }

        public final d a() {
            return (d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8539, this, null);
        }

        public final b b(int start) {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8534, this, Integer.valueOf(start));
        }

        public final String b() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8533, this, null);
        }

        public final int c() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8536, this, null);
        }

        public final b c(int r3) {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8535, this, Integer.valueOf(r3));
        }

        public final c d() {
            return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8530, this, null);
        }

        public final int e() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8529, this, null);
        }

        public final int f() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8532, this, null);
        }

        public final boolean g() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8531, this, null);
        }

        public final Context getContext() {
            return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8622, this, null);
        }
    }

    public interface c {
        void a();

        void b();

        void c();
    }

    /* renamed from: com.wbl.ad.yzz.wigdet.h.d$d */
    public static final class C0799d implements a.InterfaceC0801a {
        public C0799d() {
        }

        @Override // com.wbl.ad.yzz.wigdet.i.a.InterfaceC0801a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8621, this, null);
        }
    }

    public static final class e implements b.a {
        public e() {
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void a(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8624, this, Long.valueOf(j2));
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8623, this, null);
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8618, this, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@f.b.a.d Context context, @f.b.a.d b build) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(build, "build");
        this.f34468a = build.getContext();
        this.f34470c = build.f();
        this.f34471d = build.e();
        this.f34472e = build.c();
        this.f34473f = build.b();
        this.f34474g = build.g();
        this.f34475h = build.d();
        setOnCancelListener(new a());
    }

    public static final /* synthetic */ c b(d dVar) {
        return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8620, null, dVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8619, this, null);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8614, this, null);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8613, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8616, this, bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8615, this, null);
    }

    @Override // android.app.Dialog
    public void show() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8610, this, null);
    }
}
