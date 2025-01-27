package com.opos.mobad.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.cmn.an.j.b;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.o.b.d;
import com.opos.mobad.o.b.h;
import com.opos.mobad.o.b.k;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends h {

    /* renamed from: a */
    protected InterfaceC0420a f19372a;

    /* renamed from: com.opos.mobad.activity.a$1 */
    class AnonymousClass1 implements InterfaceC0420a {

        /* renamed from: com.opos.mobad.activity.a$1$1 */
        class RunnableC04191 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f19374a;

            /* renamed from: b */
            final /* synthetic */ String f19375b;

            RunnableC04191(Bitmap bitmap, String str) {
                bitmap = bitmap;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((com.opos.mobad.o.b.a) a.this).l == null || bitmap.isRecycled() || TextUtils.isEmpty(str) || !str.equals(((com.opos.mobad.o.b.a) a.this).l.getTag())) {
                    return;
                }
                ((com.opos.mobad.o.b.a) a.this).l.setImageBitmap(bitmap);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.opos.mobad.activity.a.InterfaceC0420a
        public void a(Bitmap bitmap, String str) {
            if (((com.opos.mobad.o.b.a) a.this).l == null || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            ((com.opos.mobad.o.b.a) a.this).G.post(new Runnable() { // from class: com.opos.mobad.activity.a.1.1

                /* renamed from: a */
                final /* synthetic */ Bitmap f19374a;

                /* renamed from: b */
                final /* synthetic */ String f19375b;

                RunnableC04191(Bitmap bitmap2, String str2) {
                    bitmap = bitmap2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (((com.opos.mobad.o.b.a) a.this).l == null || bitmap.isRecycled() || TextUtils.isEmpty(str) || !str.equals(((com.opos.mobad.o.b.a) a.this).l.getTag())) {
                        return;
                    }
                    ((com.opos.mobad.o.b.a) a.this).l.setImageBitmap(bitmap);
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.activity.a$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f19377a;

        AnonymousClass2(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.opos.mobad.o.b.a) a.this).l.setTag(str);
            a aVar = a.this;
            ((com.opos.mobad.o.b.a) aVar).m = g.a(str, com.opos.cmn.an.h.f.a.b(((com.opos.mobad.o.b.a) aVar).f22992b), (com.opos.cmn.an.h.f.a.b(((com.opos.mobad.o.b.a) a.this).f22992b) * 9) / 16);
            if (((com.opos.mobad.o.b.a) a.this).m != null) {
                a aVar2 = a.this;
                aVar2.f19372a.a(((com.opos.mobad.o.b.a) aVar2).m, str);
            }
        }
    }

    /* renamed from: com.opos.mobad.activity.a$a */
    public interface InterfaceC0420a {
        void a(Bitmap bitmap, String str);
    }

    public a(Context context, d dVar, FrameLayout frameLayout) {
        super(context, dVar, frameLayout, true);
        this.f19372a = new InterfaceC0420a() { // from class: com.opos.mobad.activity.a.1

            /* renamed from: com.opos.mobad.activity.a$1$1 */
            class RunnableC04191 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f19374a;

                /* renamed from: b */
                final /* synthetic */ String f19375b;

                RunnableC04191(Bitmap bitmap2, String str2) {
                    bitmap = bitmap2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (((com.opos.mobad.o.b.a) a.this).l == null || bitmap.isRecycled() || TextUtils.isEmpty(str) || !str.equals(((com.opos.mobad.o.b.a) a.this).l.getTag())) {
                        return;
                    }
                    ((com.opos.mobad.o.b.a) a.this).l.setImageBitmap(bitmap);
                }
            }

            AnonymousClass1() {
            }

            @Override // com.opos.mobad.activity.a.InterfaceC0420a
            public void a(Bitmap bitmap2, String str2) {
                if (((com.opos.mobad.o.b.a) a.this).l == null || bitmap2 == null || bitmap2.isRecycled()) {
                    return;
                }
                ((com.opos.mobad.o.b.a) a.this).G.post(new Runnable() { // from class: com.opos.mobad.activity.a.1.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f19374a;

                    /* renamed from: b */
                    final /* synthetic */ String f19375b;

                    RunnableC04191(Bitmap bitmap22, String str22) {
                        bitmap = bitmap22;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.opos.mobad.o.b.a) a.this).l == null || bitmap.isRecycled() || TextUtils.isEmpty(str) || !str.equals(((com.opos.mobad.o.b.a) a.this).l.getTag())) {
                            return;
                        }
                        ((com.opos.mobad.o.b.a) a.this).l.setImageBitmap(bitmap);
                    }
                });
            }
        };
    }

    @Override // com.opos.mobad.o.b.a
    protected void a() {
        l();
    }

    @Override // com.opos.mobad.o.b.e
    public void a(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("MediaCreative", "onErrorRetryClick " + k.a().c(this.A));
        if (com.opos.cmn.an.h.c.a.d(this.f22992b)) {
            aa();
            if (k.a().c(this.A) == -1) {
                k a2 = k.a();
                Context context = this.f22992b;
                String str = this.A;
                AdItemData adItemData = this.f22993c;
                a2.c(context, str, adItemData != null ? adItemData.P() : 2, this.n, this, this.E);
                return;
            }
            k a3 = k.a();
            Context context2 = this.f22992b;
            String str2 = this.A;
            AdItemData adItemData2 = this.f22993c;
            a3.a(context2, str2, adItemData2 != null ? adItemData2.P() : 2, this.n, this, this.E);
        }
    }

    @Override // com.opos.mobad.o.b.a
    public void a(View view, int[] iArr, int i2) {
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3 && k.a().c(this.A) == 2) {
                U();
                k.a().b(this.A);
                return;
            }
            return;
        }
        if (k.a().c(this.A) == -1 || k.a().c(this.A) == 0 || k.a().c(this.A) == 5) {
            N();
            k a2 = k.a();
            Context context = this.f22992b;
            String str = this.A;
            AdItemData adItemData = this.f22993c;
            a2.a(context, str, adItemData != null ? adItemData.P() : 2, this.n, this, this.E);
        } else {
            k.a().a(this.A, this.n);
        }
        V();
    }

    public void a(AdItemData adItemData, String str) {
        if (adItemData != null) {
            this.f22993c = adItemData;
            this.A = str;
            if (this.D != null) {
                b(!adItemData.D());
            }
            com.opos.cmn.an.f.a.b("MediaCreative", "mAdItemData:" + this.f22993c);
            MaterialData materialData = adItemData.i().get(0);
            if (materialData != null) {
                List<MaterialFileData> f2 = materialData.f();
                if (f2 != null && f2.size() > 0 && f2.get(0) != null) {
                    String a2 = f2.get(0).a();
                    if (!TextUtils.isEmpty(a2) && (!a2.equals(this.l.getTag()) || this.m == null)) {
                        a(a2);
                    }
                }
                a(this.n, 4);
                if (!com.opos.cmn.an.h.c.a.d(this.f22992b)) {
                    ah();
                    d dVar = this.u;
                    if (dVar != null) {
                        dVar.a(10403, "no net,can't play video.");
                        return;
                    }
                    return;
                }
                if (!com.opos.cmn.an.h.c.a.e(this.f22992b) && !materialData.X()) {
                    Z();
                    return;
                }
                Y();
                k a3 = k.a();
                Context context = this.f22992b;
                AdItemData adItemData2 = this.f22993c;
                a3.b(context, str, adItemData2 != null ? adItemData2.P() : 2, this.n, this, this.E);
            }
        }
    }

    @Override // com.opos.mobad.o.b.h
    protected void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b.c(new Runnable() { // from class: com.opos.mobad.activity.a.2

            /* renamed from: a */
            final /* synthetic */ String f19377a;

            AnonymousClass2(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((com.opos.mobad.o.b.a) a.this).l.setTag(str);
                a aVar = a.this;
                ((com.opos.mobad.o.b.a) aVar).m = g.a(str, com.opos.cmn.an.h.f.a.b(((com.opos.mobad.o.b.a) aVar).f22992b), (com.opos.cmn.an.h.f.a.b(((com.opos.mobad.o.b.a) a.this).f22992b) * 9) / 16);
                if (((com.opos.mobad.o.b.a) a.this).m != null) {
                    a aVar2 = a.this;
                    aVar2.f19372a.a(((com.opos.mobad.o.b.a) aVar2).m, str);
                }
            }
        });
    }

    public void a(boolean z) {
        if (z) {
            try {
                if (com.opos.cmn.an.h.b.a.b(this.f22992b) == 0) {
                    c(false);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("MediaCreative", "", (Throwable) e2);
                return;
            }
        }
        c(true);
    }

    public void b() {
        this.u = null;
    }

    @Override // com.opos.mobad.o.b.e
    public void b(View view, int[] iArr) {
        if (k.a() != null) {
            aa();
            k a2 = k.a();
            Context context = this.f22992b;
            String str = this.A;
            AdItemData adItemData = this.f22993c;
            a2.a(context, str, adItemData != null ? adItemData.P() : 2, this.n, this, this.E);
        }
    }
}
