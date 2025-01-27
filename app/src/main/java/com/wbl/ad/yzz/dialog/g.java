package com.wbl.ad.yzz.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: a */
    public View f31897a;

    /* renamed from: b */
    public EditText f31898b;

    /* renamed from: c */
    public TextView f31899c;

    /* renamed from: d */
    public ImageView f31900d;

    /* renamed from: e */
    public a f31901e;

    public interface a {
        void a();

        void a(@f.b.a.e String str);

        void b(@f.b.a.d String str);
    }

    public static final class b implements TextView.OnEditorActionListener {
        public b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14470, this, textView, Integer.valueOf(i2), keyEvent);
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14469, this, view);
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14472, this, view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@f.b.a.d Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final /* synthetic */ a a(g gVar) {
        return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14471, null, gVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14465, this, null);
    }

    public final void a(View view, int i2, float f2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14468, this, view, Integer.valueOf(i2), Float.valueOf(f2));
    }

    public final void a(a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14467, this, aVar);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14494, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14493, this, null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14496, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14495, this, bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14490, this, null);
    }

    @Override // android.app.Dialog
    public void show() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14489, this, null);
    }
}
