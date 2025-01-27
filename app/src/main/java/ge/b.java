package ge;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.model.data.MiBookMark;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    public int f26213a;

    /* renamed from: b */
    public int f26214b;

    /* renamed from: c */
    public final Resources f26215c;

    /* renamed from: d */
    public C0699b f26216d;

    /* renamed from: e */
    public final TextPaint f26217e;

    /* renamed from: f */
    public final TextPaint f26218f;

    /* renamed from: g */
    public final Paint f26219g;

    /* renamed from: h */
    public final Paint f26220h;

    public static class a {

        /* renamed from: a */
        public final b f26221a;

        public a(Resources resources) {
            this.f26221a = new b(resources);
        }

        public b a() {
            return this.f26221a;
        }

        public a b(float f10) {
            this.f26221a.f26216d.f26228g = f10;
            return this;
        }

        public a c(float f10) {
            this.f26221a.f26216d.f26227f = f10;
            return this;
        }

        public a d(int i10) {
            this.f26221a.f26216d.f26226e = i10;
            return this;
        }

        public a e(int i10) {
            this.f26221a.f26214b = i10;
            return this;
        }

        public a f(int i10) {
            this.f26221a.f26213a = i10;
            return this;
        }

        public a g(float f10) {
            this.f26221a.f26216d.f26230i = f10;
            return this;
        }

        public a h(float f10) {
            this.f26221a.f26216d.f26229h = f10;
            return this;
        }

        public a i(C0699b c0699b) {
            this.f26221a.f26216d = c0699b;
            return this;
        }

        public a j(int i10) {
            this.f26221a.f26216d.f26225d = i10;
            return this;
        }

        public a k(float f10) {
            this.f26221a.f26216d.f26223b = f10;
            return this;
        }

        public a l(float f10) {
            this.f26221a.f26216d.f26222a = f10;
            return this;
        }

        public a m(int i10) {
            this.f26221a.f26216d.f26224c = i10;
            return this;
        }
    }

    /* renamed from: ge.b$b */
    public static class C0699b {

        /* renamed from: c */
        public int f26224c;

        /* renamed from: e */
        public int f26226e;

        /* renamed from: a */
        public float f26222a = 1.0f;

        /* renamed from: b */
        public float f26223b = 0.0f;

        /* renamed from: d */
        public int f26225d = 0;

        /* renamed from: f */
        public float f26227f = 1.0f;

        /* renamed from: g */
        public float f26228g = 0.0f;

        /* renamed from: h */
        public float f26229h = 1.0f;

        /* renamed from: i */
        public float f26230i = 0.0f;

        public int A() {
            return this.f26224c;
        }

        public void B(float f10) {
            this.f26228g = f10;
        }

        public void C(float f10) {
            this.f26227f = f10;
        }

        public void D(int i10) {
            this.f26226e = i10;
        }

        public void E(float f10) {
            this.f26230i = f10;
        }

        public void F(float f10) {
            this.f26229h = f10;
        }

        public void G(int i10) {
            this.f26225d = i10;
        }

        public void H(float f10) {
            this.f26223b = f10;
        }

        public void I(float f10) {
            this.f26222a = f10;
        }

        public void J(int i10) {
            this.f26224c = i10;
        }

        public float s() {
            return this.f26228g;
        }

        public float t() {
            return this.f26227f;
        }

        public int u() {
            return this.f26226e;
        }

        public float v() {
            return this.f26230i;
        }

        public float w() {
            return this.f26229h;
        }

        public int x() {
            return this.f26225d;
        }

        public float y() {
            return this.f26223b;
        }

        public float z() {
            return this.f26222a;
        }
    }

    public /* synthetic */ b(Resources resources, c cVar) {
        this(resources);
    }

    public List<d> e(String str, String str2, Map<Integer, MiBookMark> map) {
        float f10;
        ArrayList arrayList;
        int i10;
        float f11;
        int i11;
        float d10;
        int b10;
        float f12;
        String str3;
        int i12;
        b bVar = this;
        Map<Integer, MiBookMark> map2 = map;
        String s10 = TextUtils.isEmpty(str) ? "" : ConfigSingleton.D().s(str);
        String s11 = TextUtils.isEmpty(str2) ? "" : ConfigSingleton.D().s(str2);
        ArrayList arrayList2 = new ArrayList();
        StaticLayout g10 = bVar.g(s10);
        ge.a aVar = new ge.a(bVar.f26216d.f26222a, bVar.f26216d.f26223b, g10.getPaint());
        float e10 = aVar.e();
        q qVar = null;
        float f13 = 0.0f;
        float f14 = 0.0f;
        int i13 = 0;
        while (i13 < g10.getLineCount() && !TextUtils.isEmpty(s10)) {
            int lineStart = g10.getLineStart(i13);
            int lineVisibleEnd = g10.getLineVisibleEnd(i13);
            if (f13 + e10 <= bVar.f26214b) {
                f12 = f13;
            } else if (qVar == null) {
                str3 = s10;
                i12 = i13;
                i13 = i12 + 1;
                s10 = str3;
            } else {
                qVar.e(f14, e10);
                d dVar = new d(qVar, null, bVar.f26213a, bVar.f26214b, bVar.f26217e, bVar.f26218f);
                dVar.Y(true);
                arrayList2.add(dVar);
                qVar = null;
                f12 = 0.0f;
            }
            if (qVar == null) {
                i12 = i13;
                str3 = s10;
                qVar = new q(s10, bVar.f26213a, bVar.f26214b, bVar.f26217e, bVar.f26219g, bVar.f26220h, bVar.f26215c);
            } else {
                str3 = s10;
                i12 = i13;
            }
            f14 = aVar.d();
            qVar.a(lineStart, lineVisibleEnd, f12, aVar.b(), f14);
            f13 = f12 + e10 + f14;
            i13 = i12 + 1;
            s10 = str3;
        }
        if (f13 > 0.0f) {
            f13 -= f14;
        }
        if (qVar != null) {
            qVar.e(f14, e10);
            qVar.b(0, qVar.q() - 1);
        }
        float b11 = f13 + ba.m.b(bVar.f26215c, bVar.f26216d.f26225d);
        int i14 = bVar.f26214b;
        if (b11 >= i14) {
            if (qVar != null) {
                arrayList2.add(new d(qVar, null, bVar.f26213a, i14, bVar.f26217e, bVar.f26218f));
                qVar = null;
            }
            b11 = 0.0f;
        }
        StaticLayout f15 = bVar.f(s11);
        ge.a aVar2 = new ge.a(bVar.f26216d.f26227f, bVar.f26216d.f26228g, f15.getPaint());
        ge.a aVar3 = new ge.a(bVar.f26216d.f26229h, bVar.f26216d.f26230i, f15.getPaint());
        float e11 = aVar2.e();
        q qVar2 = qVar;
        q qVar3 = null;
        float f16 = 0.0f;
        int i15 = 1;
        int i16 = 0;
        while (i16 < f15.getLineCount() && !TextUtils.isEmpty(s11)) {
            int lineStart2 = f15.getLineStart(i16);
            int lineVisibleEnd2 = f15.getLineVisibleEnd(i16);
            if (b11 + e11 > bVar.f26214b) {
                if (qVar3 != null) {
                    qVar3.e(f16, e11);
                } else if (qVar2 == null) {
                    i10 = i16;
                    f11 = e11;
                    arrayList = arrayList2;
                    i16 = i10 + 1;
                    map2 = map;
                    e11 = f11;
                    arrayList2 = arrayList;
                    bVar = this;
                }
                d dVar2 = new d(qVar2, qVar3, bVar.f26213a, bVar.f26214b, bVar.f26217e, bVar.f26218f);
                dVar2.Y(true);
                dVar2.O(bVar.h(map2, dVar2));
                arrayList2.add(dVar2);
                qVar3 = null;
                qVar2 = null;
                f10 = 0.0f;
            } else {
                f10 = b11;
            }
            if (qVar3 == null) {
                int i17 = bVar.f26213a;
                int i18 = bVar.f26214b;
                TextPaint textPaint = bVar.f26218f;
                Paint paint = bVar.f26219g;
                int i19 = i16;
                Paint paint2 = bVar.f26220h;
                float f17 = e11;
                Resources resources = bVar.f26215c;
                arrayList = arrayList2;
                i11 = i15;
                i10 = i19;
                f11 = f17;
                qVar3 = new q(s11, i17, i18, textPaint, paint, paint2, resources);
            } else {
                i10 = i16;
                f11 = e11;
                arrayList = arrayList2;
                i11 = i15;
            }
            if (s11.charAt(f15.getLineEnd(i10) - 1) != '\n') {
                d10 = (int) aVar2.d();
                b10 = (int) aVar2.b();
                i15 = i11;
            } else {
                d10 = (int) aVar3.d();
                b10 = (int) aVar3.b();
                qVar3.b(i11, qVar3.q());
                i15 = i11 + 1;
            }
            qVar3.a(lineStart2, lineVisibleEnd2, f10, b10, d10);
            f16 = d10;
            b11 = f10 + d10 + f11;
            i16 = i10 + 1;
            map2 = map;
            e11 = f11;
            arrayList2 = arrayList;
            bVar = this;
        }
        float f18 = e11;
        ArrayList arrayList3 = arrayList2;
        int i20 = i15;
        if (qVar3 == null) {
            return arrayList3;
        }
        qVar3.e(f16, f18);
        qVar3.b(i20, qVar3.q() - 1);
        d dVar3 = new d(qVar2, qVar3, this.f26213a, this.f26214b, this.f26217e, this.f26218f);
        dVar3.O(h(map, dVar3));
        dVar3.Y(false);
        arrayList3.add(dVar3);
        return arrayList3;
    }

    public final StaticLayout f(String str) {
        StaticLayout.Builder obtain;
        StaticLayout build;
        this.f26218f.setTextSize(ba.m.M(this.f26215c, this.f26216d.f26226e));
        if (Build.VERSION.SDK_INT < 23) {
            return new StaticLayout(str, this.f26218f, this.f26213a, Layout.Alignment.ALIGN_NORMAL, this.f26216d.f26227f, this.f26216d.f26228g, false);
        }
        obtain = StaticLayout.Builder.obtain(str, 0, str.length(), this.f26218f, this.f26213a);
        build = obtain.build();
        return build;
    }

    public final StaticLayout g(String str) {
        StaticLayout.Builder obtain;
        StaticLayout build;
        this.f26217e.setTextSize(ba.m.M(this.f26215c, this.f26216d.f26224c));
        this.f26217e.setFakeBoldText(true);
        if (Build.VERSION.SDK_INT < 23) {
            return new StaticLayout(str, this.f26217e, this.f26213a, Layout.Alignment.ALIGN_NORMAL, this.f26216d.f26222a, this.f26216d.f26223b, false);
        }
        obtain = StaticLayout.Builder.obtain(str, 0, str.length(), this.f26217e, this.f26213a);
        build = obtain.build();
        return build;
    }

    public boolean h(Map<Integer, MiBookMark> map, d dVar) {
        if (map != null && !map.isEmpty()) {
            int g10 = dVar.g();
            int d10 = dVar.d();
            Iterator<Map.Entry<Integer, MiBookMark>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().getKey().intValue();
                if (intValue >= g10 && intValue < d10) {
                    return true;
                }
            }
        }
        return false;
    }

    public C0699b i() {
        return this.f26216d;
    }

    public void j(int i10) {
        this.f26219g.setColor(i10);
    }

    public void k(int i10) {
        this.f26214b = i10;
    }

    public void l(int i10) {
        this.f26213a = i10;
    }

    public void m(int i10) {
        this.f26217e.setColor(i10);
        this.f26218f.setColor(i10);
    }

    public void n(C0699b c0699b) {
        this.f26216d = c0699b;
    }

    public void o(Typeface typeface) {
        this.f26217e.setTypeface(typeface);
        this.f26218f.setTypeface(typeface);
    }

    public void p(int i10) {
        this.f26220h.setColor(i10);
        this.f26220h.setAlpha(128);
    }

    public b(Resources resources) {
        this.f26216d = new C0699b();
        TextPaint textPaint = new TextPaint(1);
        this.f26218f = textPaint;
        textPaint.density = resources.getDisplayMetrics().density;
        TextPaint textPaint2 = new TextPaint(1);
        this.f26217e = textPaint2;
        textPaint2.density = resources.getDisplayMetrics().density;
        Paint paint = new Paint(1);
        this.f26219g = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f26220h = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(ba.m.b(resources, 2.0f));
        this.f26215c = resources;
    }
}
