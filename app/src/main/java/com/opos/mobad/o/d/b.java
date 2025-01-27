package com.opos.mobad.o.d;

import android.content.Context;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.RelativeLayout;
import com.opos.cmn.biz.web.b.a.b;
import com.opos.mobad.o.d.e;
import java.util.Map;

/* loaded from: classes4.dex */
public class b implements d {

    /* renamed from: a */
    private com.opos.cmn.biz.web.b.a.a f23094a;

    /* renamed from: b */
    private Context f23095b;

    /* renamed from: c */
    private e.b f23096c;

    /* renamed from: com.opos.mobad.o.d.b$1 */
    class AnonymousClass1 implements com.opos.cmn.biz.web.b.a.a.a {

        /* renamed from: com.opos.mobad.o.d.b$1$1 */
        class C04731 implements com.opos.cmn.e.a.b.c.a {

            /* renamed from: a */
            final /* synthetic */ SslErrorHandler f23098a;

            /* renamed from: b */
            final /* synthetic */ View f23099b;

            C04731(SslErrorHandler sslErrorHandler, View view) {
                sslErrorHandler = sslErrorHandler;
                b2 = view;
            }

            @Override // com.opos.cmn.e.a.b.c.a
            public void a(View view, int[] iArr) {
                ViewGroup viewGroup;
                sslErrorHandler.cancel();
                View b2 = b.this.f23094a.b();
                if (b2 != null && (viewGroup = (ViewGroup) b2.getParent()) != null && viewGroup.indexOfChild(b2) > 0) {
                    viewGroup.removeView(b2);
                }
                if (b.this.f23096c != null) {
                    b.this.f23096c.a();
                }
            }

            @Override // com.opos.cmn.e.a.b.c.a
            public void b(View view, int[] iArr) {
                ViewGroup viewGroup;
                sslErrorHandler.proceed();
                View b2 = b.this.f23094a.b();
                if (b2 == null || (viewGroup = (ViewGroup) b2.getParent()) == null || viewGroup.indexOfChild(b2) <= 0) {
                    return;
                }
                viewGroup.removeView(b2);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.opos.cmn.biz.web.b.a.a.a
        public void a(SslErrorHandler sslErrorHandler, SslError sslError) {
            com.opos.cmn.an.f.a.b("privacyTool", "onReceivedSslError");
            try {
                com.opos.cmn.e.a.b.b.c cVar = new com.opos.cmn.e.a.b.b.c(b.this.f23095b, 0.1f);
                View b2 = cVar.b();
                cVar.a((CharSequence) "SSL证书验证错误，是否继续？");
                cVar.b("取消");
                cVar.a("继续");
                cVar.a(new com.opos.cmn.e.a.b.c.a() { // from class: com.opos.mobad.o.d.b.1.1

                    /* renamed from: a */
                    final /* synthetic */ SslErrorHandler f23098a;

                    /* renamed from: b */
                    final /* synthetic */ View f23099b;

                    C04731(SslErrorHandler sslErrorHandler2, View b22) {
                        sslErrorHandler = sslErrorHandler2;
                        b2 = b22;
                    }

                    @Override // com.opos.cmn.e.a.b.c.a
                    public void a(View view, int[] iArr) {
                        ViewGroup viewGroup;
                        sslErrorHandler.cancel();
                        View b22 = b.this.f23094a.b();
                        if (b22 != null && (viewGroup = (ViewGroup) b22.getParent()) != null && viewGroup.indexOfChild(b2) > 0) {
                            viewGroup.removeView(b2);
                        }
                        if (b.this.f23096c != null) {
                            b.this.f23096c.a();
                        }
                    }

                    @Override // com.opos.cmn.e.a.b.c.a
                    public void b(View view, int[] iArr) {
                        ViewGroup viewGroup;
                        sslErrorHandler.proceed();
                        View b22 = b.this.f23094a.b();
                        if (b22 == null || (viewGroup = (ViewGroup) b22.getParent()) == null || viewGroup.indexOfChild(b2) <= 0) {
                            return;
                        }
                        viewGroup.removeView(b2);
                    }
                });
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                ((ViewGroup) b.this.f23094a.b().getParent()).addView(b22, layoutParams);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("ComplianceWebView", "", e2);
            }
        }
    }

    public b(Context context, e.b bVar) {
        Context a2 = com.opos.mobad.service.b.a(context);
        this.f23095b = a2;
        this.f23096c = bVar;
        this.f23094a = new com.opos.cmn.biz.web.b.a.a(a2, new b.a().a((com.opos.cmn.biz.web.b.a.a.b) null).a((Map<String, Object>) null).a(false).a(new com.opos.cmn.biz.web.b.a.a.a() { // from class: com.opos.mobad.o.d.b.1

            /* renamed from: com.opos.mobad.o.d.b$1$1 */
            class C04731 implements com.opos.cmn.e.a.b.c.a {

                /* renamed from: a */
                final /* synthetic */ SslErrorHandler f23098a;

                /* renamed from: b */
                final /* synthetic */ View f23099b;

                C04731(SslErrorHandler sslErrorHandler2, View b22) {
                    sslErrorHandler = sslErrorHandler2;
                    b2 = b22;
                }

                @Override // com.opos.cmn.e.a.b.c.a
                public void a(View view, int[] iArr) {
                    ViewGroup viewGroup;
                    sslErrorHandler.cancel();
                    View b22 = b.this.f23094a.b();
                    if (b22 != null && (viewGroup = (ViewGroup) b22.getParent()) != null && viewGroup.indexOfChild(b2) > 0) {
                        viewGroup.removeView(b2);
                    }
                    if (b.this.f23096c != null) {
                        b.this.f23096c.a();
                    }
                }

                @Override // com.opos.cmn.e.a.b.c.a
                public void b(View view, int[] iArr) {
                    ViewGroup viewGroup;
                    sslErrorHandler.proceed();
                    View b22 = b.this.f23094a.b();
                    if (b22 == null || (viewGroup = (ViewGroup) b22.getParent()) == null || viewGroup.indexOfChild(b2) <= 0) {
                        return;
                    }
                    viewGroup.removeView(b2);
                }
            }

            AnonymousClass1() {
            }

            @Override // com.opos.cmn.biz.web.b.a.a.a
            public void a(SslErrorHandler sslErrorHandler2, SslError sslError) {
                com.opos.cmn.an.f.a.b("privacyTool", "onReceivedSslError");
                try {
                    com.opos.cmn.e.a.b.b.c cVar = new com.opos.cmn.e.a.b.b.c(b.this.f23095b, 0.1f);
                    View b22 = cVar.b();
                    cVar.a((CharSequence) "SSL证书验证错误，是否继续？");
                    cVar.b("取消");
                    cVar.a("继续");
                    cVar.a(new com.opos.cmn.e.a.b.c.a() { // from class: com.opos.mobad.o.d.b.1.1

                        /* renamed from: a */
                        final /* synthetic */ SslErrorHandler f23098a;

                        /* renamed from: b */
                        final /* synthetic */ View f23099b;

                        C04731(SslErrorHandler sslErrorHandler22, View b222) {
                            sslErrorHandler = sslErrorHandler22;
                            b2 = b222;
                        }

                        @Override // com.opos.cmn.e.a.b.c.a
                        public void a(View view, int[] iArr) {
                            ViewGroup viewGroup;
                            sslErrorHandler.cancel();
                            View b222 = b.this.f23094a.b();
                            if (b222 != null && (viewGroup = (ViewGroup) b222.getParent()) != null && viewGroup.indexOfChild(b2) > 0) {
                                viewGroup.removeView(b2);
                            }
                            if (b.this.f23096c != null) {
                                b.this.f23096c.a();
                            }
                        }

                        @Override // com.opos.cmn.e.a.b.c.a
                        public void b(View view, int[] iArr) {
                            ViewGroup viewGroup;
                            sslErrorHandler.proceed();
                            View b222 = b.this.f23094a.b();
                            if (b222 == null || (viewGroup = (ViewGroup) b222.getParent()) == null || viewGroup.indexOfChild(b2) <= 0) {
                                return;
                            }
                            viewGroup.removeView(b2);
                        }
                    });
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    ((ViewGroup) b.this.f23094a.b().getParent()).addView(b222, layoutParams);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("ComplianceWebView", "", e2);
                }
            }
        }).a());
    }

    @Override // com.opos.mobad.o.d.d
    public int a() {
        return 0;
    }

    @Override // com.opos.mobad.o.d.d
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f23094a.a(str);
    }

    @Override // com.opos.mobad.o.d.d
    public void a(Map<String, String> map) {
    }

    @Override // com.opos.mobad.o.d.d
    public View b() {
        return this.f23094a.b();
    }

    @Override // com.opos.mobad.o.d.d
    public void c() {
        this.f23094a.a();
    }
}
