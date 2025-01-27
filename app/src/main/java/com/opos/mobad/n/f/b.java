package com.opos.mobad.n.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class b implements com.opos.mobad.n.a {

    /* renamed from: a */
    private int f22145a;

    /* renamed from: b */
    private RelativeLayout f22146b;

    /* renamed from: c */
    private RelativeLayout f22147c;

    /* renamed from: d */
    private FrameLayout f22148d;

    /* renamed from: e */
    private d f22149e;

    /* renamed from: f */
    private a.InterfaceC0458a f22150f;

    /* renamed from: g */
    private int f22151g;

    /* renamed from: h */
    private Context f22152h;

    /* renamed from: i */
    private com.opos.mobad.n.d.d f22153i;

    /* renamed from: j */
    private a f22154j;
    private volatile boolean k = false;
    private com.opos.mobad.c.a l;
    private int m;

    /* renamed from: com.opos.mobad.n.f.b$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (b.this.f22150f != null) {
                b.this.f22150f.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.b$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (b.this.f22150f != null) {
                b.this.f22150f.f(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.b$3 */
    class AnonymousClass3 implements a.InterfaceC0426a {

        /* renamed from: com.opos.mobad.n.f.b$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22158a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (b.this.k || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                b.this.f22149e.a(bitmap);
            }
        }

        AnonymousClass3() {
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (b.this.k) {
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (b.this.f22150f != null) {
                    b.this.f22150f.c(i2);
                }
            } else {
                if (i2 == 1 && b.this.f22150f != null) {
                    b.this.f22150f.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.b.3.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22158a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (b.this.k || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        b.this.f22149e.a(bitmap);
                    }
                });
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.b$4 */
    class AnonymousClass4 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ List f22160a;

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.n.c.b f22161b;

        /* renamed from: com.opos.mobad.n.f.b$4$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22163a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.k) {
                    return;
                }
                arrayList.add(bitmap);
                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                bVar.a(arrayList);
            }
        }

        AnonymousClass4(List list, com.opos.mobad.n.c.b bVar) {
            arrayList = list;
            bVar = bVar;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (b.this.k) {
                return;
            }
            if (bitmap == null || bitmap.isRecycled()) {
                com.opos.cmn.an.f.a.a("imageInter", "null bitmap");
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (b.this.f22150f != null) {
                    b.this.f22150f.c(i2);
                }
            } else {
                if (i2 == 1 && b.this.f22150f != null) {
                    b.this.f22150f.c(i2);
                }
                com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.f.b.4.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22163a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.k) {
                            return;
                        }
                        arrayList.add(bitmap);
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        bVar.a(arrayList);
                    }
                });
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.b$5 */
    class AnonymousClass5 extends com.opos.mobad.n.c.g {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (b.this.f22150f != null) {
                b.this.f22150f.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.b$6 */
    class AnonymousClass6 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.c.c f22166a;

        /* renamed from: com.opos.mobad.n.f.b$6$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22168a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (b.this.k || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                b2.a(bitmap, 28);
            }
        }

        AnonymousClass6(com.opos.mobad.n.c.c cVar) {
            b2 = cVar;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (b.this.k) {
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (b.this.f22150f != null) {
                    b.this.f22150f.c(i2);
                }
            } else {
                if (i2 == 1 && b.this.f22150f != null) {
                    b.this.f22150f.c(i2);
                }
                com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.f.b.6.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22168a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (b.this.k || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        b2.a(bitmap, 28);
                    }
                });
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.b$7 */
    class AnonymousClass7 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ ImageView f22170a;

        /* renamed from: com.opos.mobad.n.f.b$7$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22172a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (b.this.k || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                imageView.setImageBitmap(bitmap);
            }
        }

        AnonymousClass7(ImageView imageView) {
            imageView = imageView;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (b.this.k) {
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (b.this.f22150f != null) {
                    b.this.f22150f.c(i2);
                }
            } else {
                if (i2 == 1 && b.this.f22150f != null) {
                    b.this.f22150f.c(i2);
                }
                com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.f.b.7.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22172a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (b.this.k || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.b$8 */
    static final class AnonymousClass8 implements a.InterfaceC0428a {

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.c.d.a f22175b;

        /* renamed from: com.opos.mobad.n.f.b$8$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.InterfaceC0458a interfaceC0458a = a.InterfaceC0458a.this;
                if (interfaceC0458a != null) {
                    interfaceC0458a.b();
                }
            }
        }

        AnonymousClass8(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (z) {
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.b.8.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.InterfaceC0458a interfaceC0458a = a.InterfaceC0458a.this;
                        if (interfaceC0458a != null) {
                            interfaceC0458a.b();
                        }
                    }
                });
                aVar.a((a.InterfaceC0428a) null);
            }
        }
    }

    public static class a {

        /* renamed from: a */
        public final int f22177a;

        /* renamed from: b */
        public final int f22178b;

        public a(int i2, int i3) {
            this.f22177a = i2;
            this.f22178b = i3;
        }
    }

    public b(Context context, int i2, int i3, a aVar, int i4, com.opos.mobad.c.a aVar2) {
        this.f22152h = context.getApplicationContext();
        this.f22151g = i2;
        this.f22154j = aVar;
        this.f22145a = i4;
        this.l = aVar2;
        this.m = i3;
        a(i3);
    }

    public static final com.opos.mobad.n.a a(Context context, int i2, com.opos.mobad.c.a aVar) {
        return new b(context, i2, 0, new a(258, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND), 1, aVar);
    }

    private void a(int i2) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22152h);
        this.f22146b = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.b.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.f22150f != null) {
                    b.this.f22150f.g(view, iArr);
                }
            }
        };
        this.f22146b.setOnClickListener(anonymousClass1);
        this.f22146b.setOnTouchListener(anonymousClass1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f22152h);
        this.f22147c = relativeLayout2;
        relativeLayout2.setId(View.generateViewId());
        this.f22146b.addView(this.f22147c, new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f22152h, this.f22154j.f22178b)));
        this.f22148d = new FrameLayout(this.f22152h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, this.f22147c.getId());
        this.f22146b.addView(this.f22148d, layoutParams);
        Context context = this.f22152h;
        this.f22149e = i2 == 1 ? d.a(context) : d.b(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22152h, i2 == 1 ? 220.0f : 248.0f), -2);
        layoutParams2.gravity = 17;
        this.f22148d.addView(this.f22149e, layoutParams2);
        this.f22149e.a(new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.b.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.f22150f != null) {
                    b.this.f22150f.f(view, iArr);
                }
            }
        });
    }

    public static void a(ViewGroup viewGroup, a.InterfaceC0458a interfaceC0458a) {
        if (viewGroup == null || interfaceC0458a == null) {
            return;
        }
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(viewGroup.getContext());
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.f.b.8

            /* renamed from: b */
            final /* synthetic */ com.opos.mobad.c.d.a f22175b;

            /* renamed from: com.opos.mobad.n.f.b$8$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.InterfaceC0458a interfaceC0458a = a.InterfaceC0458a.this;
                    if (interfaceC0458a != null) {
                        interfaceC0458a.b();
                    }
                }
            }

            AnonymousClass8(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (z) {
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.b.8.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            a.InterfaceC0458a interfaceC0458a2 = a.InterfaceC0458a.this;
                            if (interfaceC0458a2 != null) {
                                interfaceC0458a2.b();
                            }
                        }
                    });
                    aVar.a((a.InterfaceC0428a) null);
                }
            }
        });
        viewGroup.addView(aVar2, 0, 0);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        this.f22149e.a(dVar.f22074f, dVar.f22073e, dVar.x, dVar.y, dVar.l);
        if (this.f22153i != null) {
            return;
        }
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22152h, 60.0f);
        com.opos.mobad.n.d.g gVar = dVar.m;
        if (gVar == null || TextUtils.isEmpty(gVar.f22084a)) {
            this.f22149e.b();
        } else {
            com.opos.mobad.c.a aVar = this.l;
            com.opos.mobad.n.d.g gVar2 = dVar.m;
            aVar.a(gVar2.f22084a, gVar2.f22085b, a2, a2, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.f.b.3

                /* renamed from: com.opos.mobad.n.f.b$3$1 */
                class AnonymousClass1 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22158a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (b.this.k || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        b.this.f22149e.a(bitmap);
                    }
                }

                AnonymousClass3() {
                }

                @Override // com.opos.mobad.c.a.InterfaceC0426a
                public void a(int i2, Bitmap bitmap2) {
                    if (b.this.k) {
                        return;
                    }
                    if (i2 != 0 && i2 != 1) {
                        if (b.this.f22150f != null) {
                            b.this.f22150f.c(i2);
                        }
                    } else {
                        if (i2 == 1 && b.this.f22150f != null) {
                            b.this.f22150f.c(i2);
                        }
                        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.b.3.1

                            /* renamed from: a */
                            final /* synthetic */ Bitmap f22158a;

                            AnonymousClass1(Bitmap bitmap22) {
                                bitmap = bitmap22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap22;
                                if (b.this.k || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                    return;
                                }
                                b.this.f22149e.a(bitmap);
                            }
                        });
                    }
                }
            });
        }
        this.f22149e.a();
    }

    public static final com.opos.mobad.n.a b(Context context, int i2, com.opos.mobad.c.a aVar) {
        return new b(context, i2, 0, new a(258, 179), 2, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        if (this.f22153i != null) {
            return;
        }
        int i2 = this.f22145a;
        this.f22147c.addView((i2 == 1 || i2 == 2) ? e(dVar) : i2 == 3 ? c(dVar) : d(dVar), new RelativeLayout.LayoutParams(-1, -1));
    }

    private View c(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.n.c.b bVar = new com.opos.mobad.n.c.b(this.f22152h, 3);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22152h, this.f22154j.f22177a);
        int a3 = com.opos.cmn.an.h.f.a.a(this.f22152h, this.f22154j.f22178b);
        if (dVar != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < Math.min(dVar.f22075g.size(), 3); i2++) {
                com.opos.mobad.n.d.g gVar = dVar.f22075g.get(i2);
                if (gVar != null) {
                    this.l.a(gVar.f22084a, gVar.f22085b, a2, a3, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.f.b.4

                        /* renamed from: a */
                        final /* synthetic */ List f22160a;

                        /* renamed from: b */
                        final /* synthetic */ com.opos.mobad.n.c.b f22161b;

                        /* renamed from: com.opos.mobad.n.f.b$4$1 */
                        class AnonymousClass1 implements Runnable {

                            /* renamed from: a */
                            final /* synthetic */ Bitmap f22163a;

                            AnonymousClass1(Bitmap bitmap2) {
                                bitmap = bitmap2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.k) {
                                    return;
                                }
                                arrayList.add(bitmap);
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                bVar.a(arrayList);
                            }
                        }

                        AnonymousClass4(List arrayList2, com.opos.mobad.n.c.b bVar2) {
                            arrayList = arrayList2;
                            bVar = bVar2;
                        }

                        @Override // com.opos.mobad.c.a.InterfaceC0426a
                        public void a(int i22, Bitmap bitmap2) {
                            if (b.this.k) {
                                return;
                            }
                            if (bitmap2 == null || bitmap2.isRecycled()) {
                                com.opos.cmn.an.f.a.a("imageInter", "null bitmap");
                                return;
                            }
                            if (i22 != 0 && i22 != 1) {
                                if (b.this.f22150f != null) {
                                    b.this.f22150f.c(i22);
                                }
                            } else {
                                if (i22 == 1 && b.this.f22150f != null) {
                                    b.this.f22150f.c(i22);
                                }
                                com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.f.b.4.1

                                    /* renamed from: a */
                                    final /* synthetic */ Bitmap f22163a;

                                    AnonymousClass1(Bitmap bitmap22) {
                                        bitmap = bitmap22;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (b.this.k) {
                                            return;
                                        }
                                        arrayList.add(bitmap);
                                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                        bVar.a(arrayList);
                                    }
                                });
                            }
                        }
                    });
                }
            }
            bVar2.a(dVar.z);
            bVar2.a(new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.b.5
                AnonymousClass5() {
                }

                @Override // com.opos.mobad.n.c.g
                public void a(View view, int[] iArr) {
                    if (b.this.f22150f != null) {
                        b.this.f22150f.g(view, iArr);
                    }
                }
            });
        }
        return bVar2;
    }

    public static final com.opos.mobad.n.a c(Context context, int i2, com.opos.mobad.c.a aVar) {
        return new b(context, i2, 0, new a(258, 179), 3, aVar);
    }

    private View d(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.n.c.c b2 = this.m == 0 ? com.opos.mobad.n.c.c.b(this.f22152h) : com.opos.mobad.n.c.c.a(this.f22152h);
        com.opos.mobad.n.d.g gVar = dVar.m;
        if (gVar != null) {
            this.l.a(gVar.f22084a, gVar.f22085b, com.opos.cmn.an.h.f.a.a(this.f22152h, b2.f22011b), com.opos.cmn.an.h.f.a.a(this.f22152h, b2.f22011b), new a.InterfaceC0426a() { // from class: com.opos.mobad.n.f.b.6

                /* renamed from: a */
                final /* synthetic */ com.opos.mobad.n.c.c f22166a;

                /* renamed from: com.opos.mobad.n.f.b$6$1 */
                class AnonymousClass1 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22168a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (b.this.k || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        b2.a(bitmap, 28);
                    }
                }

                AnonymousClass6(com.opos.mobad.n.c.c b22) {
                    b2 = b22;
                }

                @Override // com.opos.mobad.c.a.InterfaceC0426a
                public void a(int i2, Bitmap bitmap2) {
                    if (b.this.k) {
                        return;
                    }
                    if (i2 != 0 && i2 != 1) {
                        if (b.this.f22150f != null) {
                            b.this.f22150f.c(i2);
                        }
                    } else {
                        if (i2 == 1 && b.this.f22150f != null) {
                            b.this.f22150f.c(i2);
                        }
                        com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.f.b.6.1

                            /* renamed from: a */
                            final /* synthetic */ Bitmap f22168a;

                            AnonymousClass1(Bitmap bitmap22) {
                                bitmap = bitmap22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap22;
                                if (b.this.k || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                    return;
                                }
                                b2.a(bitmap, 28);
                            }
                        });
                    }
                }
            });
        }
        return b22;
    }

    public static final com.opos.mobad.n.a d(Context context, int i2, com.opos.mobad.c.a aVar) {
        return new b(context, i2, 0, new a(258, 179), 0, aVar);
    }

    private View e(com.opos.mobad.n.d.d dVar) {
        ImageView imageView = new ImageView(this.f22152h);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list != null) {
            this.l.a(list.get(0).f22084a, dVar.f22075g.get(0).f22085b, com.opos.cmn.an.h.f.a.a(this.f22152h, this.f22154j.f22177a), com.opos.cmn.an.h.f.a.a(this.f22152h, this.f22154j.f22178b), new a.InterfaceC0426a() { // from class: com.opos.mobad.n.f.b.7

                /* renamed from: a */
                final /* synthetic */ ImageView f22170a;

                /* renamed from: com.opos.mobad.n.f.b$7$1 */
                class AnonymousClass1 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22172a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (b.this.k || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        imageView.setImageBitmap(bitmap);
                    }
                }

                AnonymousClass7(ImageView imageView2) {
                    imageView = imageView2;
                }

                @Override // com.opos.mobad.c.a.InterfaceC0426a
                public void a(int i2, Bitmap bitmap2) {
                    if (b.this.k) {
                        return;
                    }
                    if (i2 != 0 && i2 != 1) {
                        if (b.this.f22150f != null) {
                            b.this.f22150f.c(i2);
                        }
                    } else {
                        if (i2 == 1 && b.this.f22150f != null) {
                            b.this.f22150f.c(i2);
                        }
                        com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.f.b.7.1

                            /* renamed from: a */
                            final /* synthetic */ Bitmap f22172a;

                            AnonymousClass1(Bitmap bitmap22) {
                                bitmap = bitmap22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap22;
                                if (b.this.k || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                    return;
                                }
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
        return imageView2;
    }

    public static final com.opos.mobad.n.a e(Context context, int i2, com.opos.mobad.c.a aVar) {
        return new b(context, i2, 1, new a(272, 145), 1, aVar);
    }

    public static final com.opos.mobad.n.a f(Context context, int i2, com.opos.mobad.c.a aVar) {
        return new b(context, i2, 1, new a(272, 169), 2, aVar);
    }

    public static final com.opos.mobad.n.a g(Context context, int i2, com.opos.mobad.c.a aVar) {
        return new b(context, i2, 1, new a(272, 169), 3, aVar);
    }

    public static final com.opos.mobad.n.a h(Context context, int i2, com.opos.mobad.c.a aVar) {
        return new b(context, i2, 1, new a(272, 169), 0, aVar);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22150f = interfaceC0458a;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0458a interfaceC0458a;
        List<com.opos.mobad.n.d.g> list;
        a.InterfaceC0458a interfaceC0458a2;
        com.opos.mobad.n.d.g gVar;
        com.opos.mobad.n.d.d a2 = hVar.a();
        if (a2 == null) {
            com.opos.cmn.an.f.a.d("imageInter", "render with data null");
            interfaceC0458a2 = this.f22150f;
            if (interfaceC0458a2 == null) {
                return;
            }
        } else if (this.f22145a == 0 && ((gVar = a2.m) == null || TextUtils.isEmpty(gVar.f22084a))) {
            com.opos.cmn.an.f.a.d("", "render with iconUrl null");
            interfaceC0458a2 = this.f22150f;
            if (interfaceC0458a2 == null) {
                return;
            }
        } else {
            if (this.f22145a == 0 || ((list = a2.f22075g) != null && list.size() > 0)) {
                b(a2);
                a(a2);
                if (this.f22153i == null && (interfaceC0458a = this.f22150f) != null) {
                    interfaceC0458a.e();
                    a(this.f22146b, this.f22150f);
                }
                this.f22153i = a2;
                return;
            }
            com.opos.cmn.an.f.a.d("", "render with imgList null");
            interfaceC0458a2 = this.f22150f;
            if (interfaceC0458a2 == null) {
                return;
            }
        }
        interfaceC0458a2.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f22146b;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.k = true;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22151g;
    }
}
