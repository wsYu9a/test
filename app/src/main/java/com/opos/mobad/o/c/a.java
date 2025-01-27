package com.opos.mobad.o.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.opos.mobad.cmn.a.b.g;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private InterfaceC0471a f23075a;

    /* renamed from: b */
    private FrameLayout f23076b;

    /* renamed from: c */
    private ImageView f23077c;

    /* renamed from: d */
    private int[] f23078d = new int[4];

    /* renamed from: e */
    private volatile boolean f23079e = false;

    /* renamed from: com.opos.mobad.o.c.a$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f23075a != null) {
                a.this.f23075a.a_(a.this.f23076b, a.this.f23078d);
            }
        }
    }

    /* renamed from: com.opos.mobad.o.c.a$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ b f23081a;

        AnonymousClass2(b bVar) {
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f23079e) {
                return;
            }
            b bVar = bVar;
            Bitmap a2 = g.a(bVar.f23083a, bVar.f23084b, bVar.f23085c);
            if (a2 != null) {
                a.this.f23077c.setImageBitmap(a2);
            }
        }
    }

    /* renamed from: com.opos.mobad.o.c.a$a */
    public interface InterfaceC0471a {
        void a_(View view, int[] iArr);
    }

    public static class b {

        /* renamed from: a */
        public final String f23083a;

        /* renamed from: b */
        public final int f23084b;

        /* renamed from: c */
        public final int f23085c;

        public b(String str, int i2, int i3) {
            this.f23083a = str;
            if (i2 <= 0) {
                this.f23084b = 75;
            } else {
                this.f23084b = i2;
            }
            if (i3 <= 0) {
                this.f23085c = 75;
            } else {
                this.f23085c = i3;
            }
        }
    }

    public a(Context context, InterfaceC0471a interfaceC0471a) {
        this.f23075a = interfaceC0471a;
        this.f23076b = new FrameLayout(context);
        ImageView imageView = new ImageView(context);
        this.f23077c = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f23077c.setVisibility(0);
        this.f23076b.addView(this.f23077c, new FrameLayout.LayoutParams(-1, -1));
        this.f23076b.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f23078d));
        this.f23076b.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.c.a.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f23075a != null) {
                    a.this.f23075a.a_(a.this.f23076b, a.this.f23078d);
                }
            }
        });
        this.f23076b.setClickable(true);
        this.f23076b.setVisibility(0);
    }

    public View a() {
        return this.f23076b;
    }

    public void a(b bVar) {
        if (this.f23079e || TextUtils.isEmpty(bVar.f23083a)) {
            com.opos.cmn.an.f.a.b("Pendant", "hasDestroy or empty img");
        } else {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.o.c.a.2

                /* renamed from: a */
                final /* synthetic */ b f23081a;

                AnonymousClass2(b bVar2) {
                    bVar = bVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f23079e) {
                        return;
                    }
                    b bVar2 = bVar;
                    Bitmap a2 = g.a(bVar2.f23083a, bVar2.f23084b, bVar2.f23085c);
                    if (a2 != null) {
                        a.this.f23077c.setImageBitmap(a2);
                    }
                }
            });
        }
    }

    public void b() {
        this.f23079e = true;
        this.f23075a = null;
        this.f23076b.removeAllViews();
    }
}
