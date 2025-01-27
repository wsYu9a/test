package com.wbl.ad.yzz.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.help.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class k extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: a */
    public ImageView f31934a;

    /* renamed from: b */
    public ProgressBar f31935b;

    /* renamed from: c */
    public TextView f31936c;

    /* renamed from: d */
    public View f31937d;

    /* renamed from: e */
    public View f31938e;

    /* renamed from: f */
    public TextView f31939f;

    /* renamed from: g */
    public TextView f31940g;

    /* renamed from: h */
    public FrameLayout f31941h;

    /* renamed from: i */
    public String f31942i;

    /* renamed from: j */
    public WebView f31943j;
    public boolean k;
    public String l;
    public String m;

    @f.b.a.e
    public e.c n;

    @f.b.a.e
    public DialogInterface.OnDismissListener o;
    public View.OnClickListener p;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"com/wbl/ad/yzz/dialog/k$a", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "view", "", "url", "", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "Landroid/webkit/WebResourceRequest;", "request", "Landroid/webkit/WebResourceError;", "error", "onReceivedError", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V", "<init>", "(Lcom/wbl/ad/yzz/dialog/k;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public final class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14536, this, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14535, this, view, request, error);
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14530, this, view);
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14529, this, dialogInterface);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@f.b.a.d Context context, @f.b.a.e String str, @f.b.a.e String str2, @f.b.a.e String str3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.p = new b();
        this.f31942i = str;
        this.l = str2;
        this.m = str3;
    }

    public static final /* synthetic */ View b(k kVar) {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14557, null, kVar);
    }

    public static final /* synthetic */ TextView d(k kVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14559, null, kVar);
    }

    public static final /* synthetic */ TextView e(k kVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14554, null, kVar);
    }

    public static final /* synthetic */ String f(k kVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14553, null, kVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14550, this, null);
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14549, this, onDismissListener);
    }

    public final void a(View view, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14552, this, view, Integer.valueOf(i2));
    }

    public final void a(e.c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14551, this, cVar);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14546, this, str);
    }

    public final void a(String str, ImageView imageView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14545, this, str, imageView);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14548, this, null);
    }

    public final DialogInterface.OnDismissListener c() {
        return (DialogInterface.OnDismissListener) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14547, this, null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14638, this, null);
    }

    public final e.c d() {
        return (e.c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14637, this, null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14640, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14639, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14634, this, null);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14633, this, null);
    }

    public final void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14636, this, null);
    }

    public final void i() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14635, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14630, this, bundle);
    }

    @Override // android.app.Dialog
    public void show() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14629, this, null);
    }
}
