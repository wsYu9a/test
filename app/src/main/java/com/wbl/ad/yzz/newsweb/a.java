package com.wbl.ad.yzz.newsweb;

import android.webkit.JavascriptInterface;
import f.b.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u0004R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/wbl/ad/yzz/newsweb/a;", "", "", "onPageStart", "()V", "onPageStartOld", "onPageNewsReadLongEvent", "onPageNewReadShort", "onPageNewsReadBottom", "onPageNewsBannerShow", "onPageNewsBannerHide", "Lcom/wbl/ad/yzz/newsweb/a$a;", "callbacks", "Lcom/wbl/ad/yzz/newsweb/a$a;", "getCallbacks$wblsdk_release", "()Lcom/wbl/ad/yzz/newsweb/a$a;", "setCallbacks$wblsdk_release", "(Lcom/wbl/ad/yzz/newsweb/a$a;)V", "<init>", "a", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a {

    @e
    private InterfaceC0775a callbacks;

    /* renamed from: com.wbl.ad.yzz.newsweb.a$a */
    public interface InterfaceC0775a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    @e
    /* renamed from: getCallbacks$wblsdk_release, reason: from getter */
    public final InterfaceC0775a getCallbacks() {
        return this.callbacks;
    }

    @JavascriptInterface
    public final void onPageNewReadShort() {
        InterfaceC0775a interfaceC0775a = this.callbacks;
        if (interfaceC0775a != null) {
            interfaceC0775a.a();
        }
    }

    @JavascriptInterface
    public final void onPageNewsBannerHide() {
        InterfaceC0775a interfaceC0775a = this.callbacks;
        if (interfaceC0775a != null) {
            interfaceC0775a.b();
        }
    }

    @JavascriptInterface
    public final void onPageNewsBannerShow() {
        InterfaceC0775a interfaceC0775a = this.callbacks;
        if (interfaceC0775a != null) {
            interfaceC0775a.g();
        }
    }

    @JavascriptInterface
    public final void onPageNewsReadBottom() {
        InterfaceC0775a interfaceC0775a = this.callbacks;
        if (interfaceC0775a != null) {
            interfaceC0775a.c();
        }
    }

    @JavascriptInterface
    public final void onPageNewsReadLongEvent() {
        InterfaceC0775a interfaceC0775a = this.callbacks;
        if (interfaceC0775a != null) {
            interfaceC0775a.f();
        }
    }

    @JavascriptInterface
    public final void onPageStart() {
        InterfaceC0775a interfaceC0775a = this.callbacks;
        if (interfaceC0775a != null) {
            interfaceC0775a.d();
        }
    }

    @JavascriptInterface
    public final void onPageStartOld() {
        InterfaceC0775a interfaceC0775a = this.callbacks;
        if (interfaceC0775a != null) {
            interfaceC0775a.e();
        }
    }

    public final void setCallbacks$wblsdk_release(@e InterfaceC0775a interfaceC0775a) {
        this.callbacks = interfaceC0775a;
    }
}
