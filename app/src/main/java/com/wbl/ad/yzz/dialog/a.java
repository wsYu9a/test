package com.wbl.ad.yzz.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.help.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: a */
    public NativeResponse f31861a;

    /* renamed from: b */
    public TextView f31862b;

    /* renamed from: c */
    public TextView f31863c;

    /* renamed from: d */
    public ImageView f31864d;

    /* renamed from: e */
    public TextView f31865e;

    /* renamed from: f */
    public TextView f31866f;

    /* renamed from: g */
    public TextView f31867g;

    /* renamed from: h */
    public View f31868h;

    /* renamed from: i */
    public TextView f31869i;

    /* renamed from: j */
    public TextView f31870j;
    public String k;

    @f.b.a.e
    public e.c l;

    @f.b.a.e
    public InterfaceC0711a m;
    public View.OnClickListener n;

    /* renamed from: com.wbl.ad.yzz.dialog.a$a */
    public interface InterfaceC0711a {
        void a(@f.b.a.e String str);

        void b(@f.b.a.e String str);
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14403, this, view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@f.b.a.d Context context, @f.b.a.e NativeResponse nativeResponse, @f.b.a.e String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.n = new b();
        this.f31861a = nativeResponse;
        this.k = str;
    }

    public static final /* synthetic */ View a(a aVar) {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14430, null, aVar);
    }

    public static final /* synthetic */ NativeResponse b(a aVar) {
        return (NativeResponse) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14429, null, aVar);
    }

    public static final /* synthetic */ TextView c(a aVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14432, null, aVar);
    }

    public static final /* synthetic */ TextView d(a aVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14431, null, aVar);
    }

    public static final /* synthetic */ TextView e(a aVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14426, null, aVar);
    }

    public final InterfaceC0711a a() {
        return (InterfaceC0711a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14425, this, null);
    }

    public final void a(NativeResponse nativeResponse) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14428, this, nativeResponse);
    }

    public final void a(InterfaceC0711a interfaceC0711a) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14427, this, interfaceC0711a);
    }

    public final void a(e.c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14422, this, cVar);
    }

    public final void a(String str, ImageView imageView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14421, this, str, imageView);
    }

    public final e.c b() {
        return (e.c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14424, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14423, this, null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14418, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14417, this, bundle);
    }
}
