package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.opos.mobad.c.a;
import com.opos.mobad.n.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class x extends RelativeLayout {

    /* renamed from: a */
    private int f22779a;

    /* renamed from: b */
    private int f22780b;

    /* renamed from: c */
    private com.opos.mobad.n.c.b f22781c;

    /* renamed from: d */
    private a.InterfaceC0458a f22782d;

    /* renamed from: com.opos.mobad.n.g.x$1 */
    class AnonymousClass1 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ boolean f22783a;

        /* renamed from: b */
        final /* synthetic */ List f22784b;

        /* renamed from: com.opos.mobad.n.g.x$1$1 */
        class RunnableC04651 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22786a;

            RunnableC04651(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (z || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                list.add(bitmap);
                x.this.f22781c.a(list);
            }
        }

        AnonymousClass1(boolean z, List list) {
            z = z;
            list = list;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (z) {
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (x.this.f22782d != null) {
                    x.this.f22782d.c(i2);
                }
            } else {
                if (i2 == 1 && x.this.f22782d != null) {
                    x.this.f22782d.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.x.1.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22786a;

                    RunnableC04651(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        list.add(bitmap);
                        x.this.f22781c.a(list);
                    }
                });
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.x$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (x.this.f22782d != null) {
                x.this.f22782d.g(view, iArr);
            }
        }
    }

    public x(Context context, int i2, int i3) {
        super(context);
        this.f22779a = i2 == 0 ? 256 : i2;
        this.f22780b = i3 == 0 ? 168 : i3;
        a();
    }

    public static x a(Context context, int i2, int i3) {
        return new x(context, i2, i3);
    }

    private void a() {
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), this.f22779a);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), this.f22780b);
        setLayoutParams(new ViewGroup.LayoutParams(a2, a3));
        this.f22781c = new com.opos.mobad.n.c.b(getContext(), 3);
        addView(this.f22781c, new RelativeLayout.LayoutParams(a2, a3));
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar, boolean z, List<Bitmap> list) {
        aVar.a(gVar.f22084a, gVar.f22085b, this.f22779a, this.f22780b, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.x.1

            /* renamed from: a */
            final /* synthetic */ boolean f22783a;

            /* renamed from: b */
            final /* synthetic */ List f22784b;

            /* renamed from: com.opos.mobad.n.g.x$1$1 */
            class RunnableC04651 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22786a;

                RunnableC04651(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    list.add(bitmap);
                    x.this.f22781c.a(list);
                }
            }

            AnonymousClass1(boolean z2, List list2) {
                z = z2;
                list = list2;
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (z) {
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (x.this.f22782d != null) {
                        x.this.f22782d.c(i2);
                    }
                } else {
                    if (i2 == 1 && x.this.f22782d != null) {
                        x.this.f22782d.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.x.1.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22786a;

                        RunnableC04651(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (z || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            list.add(bitmap);
                            x.this.f22781c.a(list);
                        }
                    });
                }
            }
        });
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("BlockListImgHorizontalView", "setListener " + interfaceC0458a);
        this.f22782d = interfaceC0458a;
        this.f22781c.a(new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.x.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (x.this.f22782d != null) {
                    x.this.f22782d.g(view, iArr);
                }
            }
        });
    }

    public void a(com.opos.mobad.n.d.d dVar, com.opos.mobad.c.a aVar, boolean z) {
        List<com.opos.mobad.n.d.g> list;
        if (dVar == null || (list = dVar.f22075g) == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < Math.min(dVar.f22075g.size(), 3); i2++) {
            com.opos.mobad.n.d.g gVar = dVar.f22075g.get(i2);
            if (gVar != null) {
                a(gVar, aVar, z, arrayList);
            }
        }
        this.f22781c.a(dVar.z);
    }
}
