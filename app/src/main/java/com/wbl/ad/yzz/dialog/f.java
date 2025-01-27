package com.wbl.ad.yzz.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.help.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: a */
    public com.wbl.ad.yzz.network.c.e.k f31886a;

    /* renamed from: b */
    public String f31887b;

    /* renamed from: c */
    public TextView f31888c;

    /* renamed from: d */
    public TextView f31889d;

    /* renamed from: e */
    public ImageView f31890e;

    /* renamed from: f */
    public TextView f31891f;

    /* renamed from: g */
    public TextView f31892g;

    /* renamed from: h */
    public TextView f31893h;

    /* renamed from: i */
    public View f31894i;

    /* renamed from: j */
    public TextView f31895j;
    public TextView k;
    public String l;

    @f.b.a.e
    public e.c m;

    @f.b.a.e
    public a n;
    public View.OnClickListener o;

    public interface a {
        void a(@f.b.a.e String str);

        void b(@f.b.a.e String str);
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14517, this, view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@f.b.a.d Context context, @f.b.a.d com.wbl.ad.yzz.network.c.e.k downloadHelper, @f.b.a.d com.wbl.ad.yzz.bean.b ad2, @f.b.a.e String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(downloadHelper, "downloadHelper");
        Intrinsics.checkNotNullParameter(ad2, "ad");
        this.o = new b();
        this.f31886a = downloadHelper;
        this.f31887b = ad2.j();
        this.l = str;
    }

    public static final /* synthetic */ View a(f fVar) {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14520, null, fVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.network.c.e.k b(f fVar) {
        return (com.wbl.ad.yzz.network.c.e.k) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14519, null, fVar);
    }

    public static final /* synthetic */ TextView c(f fVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14514, null, fVar);
    }

    public static final /* synthetic */ TextView d(f fVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14513, null, fVar);
    }

    public static final /* synthetic */ TextView e(f fVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14516, null, fVar);
    }

    public final a a() {
        return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14515, this, null);
    }

    public final void a(a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14478, this, aVar);
    }

    public final void a(e.c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14477, this, cVar);
    }

    public final void a(com.wbl.ad.yzz.network.c.e.k kVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14480, this, kVar);
    }

    public final void a(String str, ImageView imageView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14479, this, str, imageView);
    }

    public final e.c b() {
        return (e.c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14474, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14473, this, null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14476, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14475, this, bundle);
    }
}
