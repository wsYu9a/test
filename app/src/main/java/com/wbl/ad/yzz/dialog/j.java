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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class j extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: a */
    public TextView f31921a;

    /* renamed from: b */
    public ImageView f31922b;

    /* renamed from: c */
    public ProgressBar f31923c;

    /* renamed from: d */
    public TextView f31924d;

    /* renamed from: e */
    public View f31925e;

    /* renamed from: f */
    public FrameLayout f31926f;

    /* renamed from: g */
    public String f31927g;

    /* renamed from: h */
    public String f31928h;

    /* renamed from: i */
    public WebView f31929i;

    /* renamed from: j */
    public boolean f31930j;

    @f.b.a.e
    public b k;

    @f.b.a.e
    public DialogInterface.OnDismissListener l;
    public View.OnClickListener m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"com/wbl/ad/yzz/dialog/j$a", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "view", "", "url", "", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "Landroid/webkit/WebResourceRequest;", "request", "Landroid/webkit/WebResourceError;", "error", "onReceivedError", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V", "<init>", "(Lcom/wbl/ad/yzz/dialog/j;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public final class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14562, this, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14561, this, view, request, error);
        }
    }

    public interface b {
        void a();
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14564, this, view);
        }
    }

    public static final class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14563, this, dialogInterface);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@f.b.a.d Context context, @f.b.a.e String str, @f.b.a.e String str2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.m = new c();
        this.f31927g = str;
        this.f31928h = str2;
    }

    public static final /* synthetic */ ImageView b(j jVar) {
        return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14591, null, jVar);
    }

    public static final /* synthetic */ TextView d(j jVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14585, null, jVar);
    }

    public static final /* synthetic */ String e(j jVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14588, null, jVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14581, this, null);
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14584, this, onDismissListener);
    }

    public final void a(View view, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14583, this, view, Integer.valueOf(i2));
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14578, this, str);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14577, this, null);
    }

    public final DialogInterface.OnDismissListener c() {
        return (DialogInterface.OnDismissListener) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14580, this, null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14579, this, null);
    }

    public final b d() {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14542, this, null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14541, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14544, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14543, this, null);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14538, this, null);
    }

    public final void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14537, this, null);
    }

    public final void i() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14540, this, null);
    }

    public final void j() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14539, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14534, this, bundle);
    }

    @Override // android.app.Dialog
    public void show() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14533, this, null);
    }
}
