package com.opos.mobad.o.a;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.opos.mobad.o.a.b.c;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private Context f22944a;

    /* renamed from: b */
    private b f22945b;

    /* renamed from: c */
    private com.opos.mobad.o.a.b.a f22946c;

    /* renamed from: d */
    private com.opos.mobad.o.a.b.b f22947d;

    /* renamed from: e */
    private final String f22948e = "提交成功，感谢您的反馈！";

    /* renamed from: f */
    private c f22949f = new c() { // from class: com.opos.mobad.o.a.a.2
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.o.a.b.c
        public void a() {
            if (a.this.f22946c != null) {
                a.this.f22946c.dismiss();
            }
        }

        @Override // com.opos.mobad.o.a.b.c
        public void a(int i2) {
            if (a.this.f22946c != null) {
                a.this.f22946c.dismiss();
            }
            if (a.this.f22945b != null) {
                a.this.f22945b.a(i2);
            }
            Toast.makeText(a.this.f22944a, "提交成功，感谢您的反馈！", 1).show();
        }
    };

    /* renamed from: com.opos.mobad.o.a.a$1 */
    class AnonymousClass1 implements PopupWindow.OnDismissListener {
        AnonymousClass1() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (a.this.f22945b != null) {
                a.this.f22945b.a(false);
            }
        }
    }

    /* renamed from: com.opos.mobad.o.a.a$2 */
    class AnonymousClass2 implements c {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.o.a.b.c
        public void a() {
            if (a.this.f22946c != null) {
                a.this.f22946c.dismiss();
            }
        }

        @Override // com.opos.mobad.o.a.b.c
        public void a(int i2) {
            if (a.this.f22946c != null) {
                a.this.f22946c.dismiss();
            }
            if (a.this.f22945b != null) {
                a.this.f22945b.a(i2);
            }
            Toast.makeText(a.this.f22944a, "提交成功，感谢您的反馈！", 1).show();
        }
    }

    public a(Context context, b bVar) {
        this.f22944a = context.getApplicationContext();
        this.f22945b = bVar;
        com.opos.mobad.o.a.b.a aVar = new com.opos.mobad.o.a.b.a(context);
        this.f22946c = aVar;
        aVar.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.opos.mobad.o.a.a.1
            AnonymousClass1() {
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (a.this.f22945b != null) {
                    a.this.f22945b.a(false);
                }
            }
        });
    }

    public void a() {
        com.opos.cmn.an.f.a.b("FeedBackPresenter", "destroy mFeedBackPopWindow =" + this.f22946c);
        com.opos.mobad.o.a.b.a aVar = this.f22946c;
        if (aVar != null) {
            aVar.dismiss();
            this.f22946c.setOnDismissListener(null);
        }
        com.opos.mobad.o.a.b.b bVar = this.f22947d;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void a(View view) {
        if (view != null) {
            try {
                if (b(view.getRootView())) {
                    com.opos.mobad.o.a.b.b bVar = this.f22947d;
                    if (bVar != null) {
                        bVar.b();
                    }
                    com.opos.mobad.o.a.b.b bVar2 = new com.opos.mobad.o.a.b.b(this.f22944a, this.f22949f);
                    this.f22947d = bVar2;
                    this.f22946c.a(bVar2.a(), -1, -1, view);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        b bVar3 = this.f22945b;
        if (bVar3 != null) {
            bVar3.a(true);
        }
    }

    public void a(b bVar) {
        this.f22945b = bVar;
    }

    public boolean b(View view) {
        if (view != null) {
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);
            com.opos.cmn.an.f.a.b("FeedBackPresenter", "isMeetSize viewArea =" + rect.toString());
            if (rect.width() >= com.opos.cmn.an.h.f.a.a(view.getContext(), 320.0f) && rect.height() >= com.opos.cmn.an.h.f.a.a(view.getContext(), 320.0f)) {
                return true;
            }
        }
        com.opos.cmn.an.f.a.b("FeedBackPresenter", "decorView is not meet Size with FeedBackContent");
        return false;
    }
}
