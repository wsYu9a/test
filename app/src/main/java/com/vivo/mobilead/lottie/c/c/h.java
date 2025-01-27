package com.vivo.mobilead.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.vivo.mobilead.lottie.LottieComposition;
import com.vivo.mobilead.lottie.TextDelegate;
import com.vivo.mobilead.lottie.a.b.n;
import com.vivo.mobilead.lottie.c.a.k;
import com.vivo.mobilead.lottie.c.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class h extends a {

    /* renamed from: e */
    private final StringBuilder f29379e;

    /* renamed from: f */
    private final RectF f29380f;

    /* renamed from: g */
    private final Matrix f29381g;

    /* renamed from: h */
    private final Paint f29382h;

    /* renamed from: i */
    private final Paint f29383i;

    /* renamed from: j */
    private final Map<com.vivo.mobilead.lottie.c.d, List<com.vivo.mobilead.lottie.a.a.d>> f29384j;
    private final LongSparseArray<String> k;
    private final n l;
    private final com.vivo.mobilead.lottie.c m;
    private final LottieComposition n;
    private com.vivo.mobilead.lottie.a.b.a<Integer, Integer> o;
    private com.vivo.mobilead.lottie.a.b.a<Integer, Integer> p;
    private com.vivo.mobilead.lottie.a.b.a<Float, Float> q;
    private com.vivo.mobilead.lottie.a.b.a<Float, Float> r;

    /* renamed from: com.vivo.mobilead.lottie.c.c.h$1 */
    class AnonymousClass1 extends Paint {
        AnonymousClass1(int i2) {
            super(i2);
            setStyle(Paint.Style.FILL);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c.c.h$2 */
    class AnonymousClass2 extends Paint {
        AnonymousClass2(int i2) {
            super(i2);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c.c.h$3 */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a */
        static final /* synthetic */ int[] f29387a;

        static {
            int[] iArr = new int[b.a.values().length];
            f29387a = iArr;
            try {
                iArr[b.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29387a[b.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29387a[b.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    h(com.vivo.mobilead.lottie.c cVar, d dVar) {
        super(cVar, dVar);
        com.vivo.mobilead.lottie.c.a.b bVar;
        com.vivo.mobilead.lottie.c.a.b bVar2;
        com.vivo.mobilead.lottie.c.a.a aVar;
        com.vivo.mobilead.lottie.c.a.a aVar2;
        this.f29379e = new StringBuilder(2);
        this.f29380f = new RectF();
        this.f29381g = new Matrix();
        this.f29382h = new Paint(1) { // from class: com.vivo.mobilead.lottie.c.c.h.1
            AnonymousClass1(int i2) {
                super(i2);
                setStyle(Paint.Style.FILL);
            }
        };
        this.f29383i = new Paint(1) { // from class: com.vivo.mobilead.lottie.c.c.h.2
            AnonymousClass2(int i2) {
                super(i2);
                setStyle(Paint.Style.STROKE);
            }
        };
        this.f29384j = new HashMap();
        this.k = new LongSparseArray<>();
        this.m = cVar;
        this.n = dVar.a();
        n a2 = dVar.s().a();
        this.l = a2;
        a2.a(this);
        a(a2);
        k t = dVar.t();
        if (t != null && (aVar2 = t.f29176a) != null) {
            com.vivo.mobilead.lottie.a.b.a<Integer, Integer> a3 = aVar2.a();
            this.o = a3;
            a3.a(this);
            a(this.o);
        }
        if (t != null && (aVar = t.f29177b) != null) {
            com.vivo.mobilead.lottie.a.b.a<Integer, Integer> a4 = aVar.a();
            this.p = a4;
            a4.a(this);
            a(this.p);
        }
        if (t != null && (bVar2 = t.f29178c) != null) {
            com.vivo.mobilead.lottie.a.b.a<Float, Float> a5 = bVar2.a();
            this.q = a5;
            a5.a(this);
            a(this.q);
        }
        if (t == null || (bVar = t.f29179d) == null) {
            return;
        }
        com.vivo.mobilead.lottie.a.b.a<Float, Float> a6 = bVar.a();
        this.r = a6;
        a6.a(this);
        a(this.r);
    }

    private float a(String str, com.vivo.mobilead.lottie.c.c cVar, float f2, float f3) {
        float f4 = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.vivo.mobilead.lottie.c.d dVar = this.n.getCharacters().get(com.vivo.mobilead.lottie.c.d.a(str.charAt(i2), cVar.a(), cVar.c()));
            if (dVar != null) {
                double d2 = f4;
                double b2 = dVar.b();
                double d3 = f2;
                Double.isNaN(d3);
                double d4 = b2 * d3;
                double a2 = com.vivo.mobilead.lottie.f.h.a();
                Double.isNaN(a2);
                double d5 = d4 * a2;
                double d6 = f3;
                Double.isNaN(d6);
                Double.isNaN(d2);
                f4 = (float) (d2 + (d5 * d6));
            }
        }
        return f4;
    }

    private String a(String str, int i2) {
        int codePointAt = str.codePointAt(i2);
        int charCount = Character.charCount(codePointAt) + i2;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!a(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j2 = codePointAt;
        if (this.k.indexOfKey(j2) >= 0) {
            return this.k.get(j2);
        }
        this.f29379e.setLength(0);
        while (i2 < charCount) {
            int codePointAt3 = str.codePointAt(i2);
            this.f29379e.appendCodePoint(codePointAt3);
            i2 += Character.charCount(codePointAt3);
        }
        String sb = this.f29379e.toString();
        this.k.put(j2, sb);
        return sb;
    }

    private List<com.vivo.mobilead.lottie.a.a.d> a(com.vivo.mobilead.lottie.c.d dVar) {
        if (this.f29384j.containsKey(dVar)) {
            return this.f29384j.get(dVar);
        }
        List<com.vivo.mobilead.lottie.c.b.n> a2 = dVar.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new com.vivo.mobilead.lottie.a.a.d(this.m, this, a2.get(i2)));
        }
        this.f29384j.put(dVar, arrayList);
        return arrayList;
    }

    private List<String> a(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void a(b.a aVar, Canvas canvas, float f2) {
        float f3;
        int i2 = AnonymousClass3.f29387a[aVar.ordinal()];
        if (i2 == 2) {
            f3 = -f2;
        } else if (i2 != 3) {
            return;
        } else {
            f3 = (-f2) / 2.0f;
        }
        canvas.translate(f3, 0.0f);
    }

    private void a(com.vivo.mobilead.lottie.c.b bVar, Matrix matrix, com.vivo.mobilead.lottie.c.c cVar, Canvas canvas) {
        float f2 = ((float) bVar.f29192c) / 100.0f;
        float a2 = com.vivo.mobilead.lottie.f.h.a(matrix);
        String str = bVar.f29190a;
        float a3 = ((float) bVar.f29195f) * com.vivo.mobilead.lottie.f.h.a();
        List<String> a4 = a(str);
        int size = a4.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = a4.get(i2);
            float a5 = a(str2, cVar, f2, a2);
            canvas.save();
            a(bVar.f29193d, canvas, a5);
            canvas.translate(0.0f, (i2 * a3) - (((size - 1) * a3) / 2.0f));
            a(str2, bVar, matrix, cVar, canvas, a2, f2);
            canvas.restore();
        }
    }

    private void a(com.vivo.mobilead.lottie.c.b bVar, com.vivo.mobilead.lottie.c.c cVar, Matrix matrix, Canvas canvas) {
        float a2 = com.vivo.mobilead.lottie.f.h.a(matrix);
        Typeface a3 = this.m.a(cVar.a(), cVar.c());
        if (a3 == null) {
            return;
        }
        String str = bVar.f29190a;
        TextDelegate u = this.m.u();
        if (u != null) {
            str = u.getTextInternal(str);
        }
        this.f29382h.setTypeface(a3);
        Paint paint = this.f29382h;
        double d2 = bVar.f29192c;
        double a4 = com.vivo.mobilead.lottie.f.h.a();
        Double.isNaN(a4);
        paint.setTextSize((float) (d2 * a4));
        this.f29383i.setTypeface(this.f29382h.getTypeface());
        this.f29383i.setTextSize(this.f29382h.getTextSize());
        float a5 = ((float) bVar.f29195f) * com.vivo.mobilead.lottie.f.h.a();
        List<String> a6 = a(str);
        int size = a6.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = a6.get(i2);
            a(bVar.f29193d, canvas, this.f29383i.measureText(str2));
            canvas.translate(0.0f, (i2 * a5) - (((size - 1) * a5) / 2.0f));
            a(str2, bVar, canvas, a2);
            canvas.setMatrix(matrix);
        }
    }

    private void a(com.vivo.mobilead.lottie.c.d dVar, Matrix matrix, float f2, com.vivo.mobilead.lottie.c.b bVar, Canvas canvas) {
        Paint paint;
        List<com.vivo.mobilead.lottie.a.a.d> a2 = a(dVar);
        for (int i2 = 0; i2 < a2.size(); i2++) {
            Path e2 = a2.get(i2).e();
            e2.computeBounds(this.f29380f, false);
            this.f29381g.set(matrix);
            this.f29381g.preTranslate(0.0f, ((float) (-bVar.f29196g)) * com.vivo.mobilead.lottie.f.h.a());
            this.f29381g.preScale(f2, f2);
            e2.transform(this.f29381g);
            if (bVar.k) {
                a(e2, this.f29382h, canvas);
                paint = this.f29383i;
            } else {
                a(e2, this.f29383i, canvas);
                paint = this.f29382h;
            }
            a(e2, paint, canvas);
        }
    }

    private void a(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void a(String str, com.vivo.mobilead.lottie.c.b bVar, Canvas canvas) {
        Paint paint;
        if (bVar.k) {
            a(str, this.f29382h, canvas);
            paint = this.f29383i;
        } else {
            a(str, this.f29383i, canvas);
            paint = this.f29382h;
        }
        a(str, paint, canvas);
    }

    private void a(String str, com.vivo.mobilead.lottie.c.b bVar, Canvas canvas, float f2) {
        int i2 = 0;
        while (i2 < str.length()) {
            String a2 = a(str, i2);
            i2 += a2.length();
            a(a2, bVar, canvas);
            float measureText = this.f29382h.measureText(a2, 0, 1);
            float f3 = bVar.f29194e / 10.0f;
            com.vivo.mobilead.lottie.a.b.a<Float, Float> aVar = this.r;
            if (aVar != null) {
                f3 += aVar.g().floatValue();
            }
            canvas.translate(measureText + (f3 * f2), 0.0f);
        }
    }

    private void a(String str, com.vivo.mobilead.lottie.c.b bVar, Matrix matrix, com.vivo.mobilead.lottie.c.c cVar, Canvas canvas, float f2, float f3) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.vivo.mobilead.lottie.c.d dVar = this.n.getCharacters().get(com.vivo.mobilead.lottie.c.d.a(str.charAt(i2), cVar.a(), cVar.c()));
            if (dVar != null) {
                a(dVar, matrix, f3, bVar, canvas);
                float b2 = ((float) dVar.b()) * f3 * com.vivo.mobilead.lottie.f.h.a() * f2;
                float f4 = bVar.f29194e / 10.0f;
                com.vivo.mobilead.lottie.a.b.a<Float, Float> aVar = this.r;
                if (aVar != null) {
                    f4 += aVar.g().floatValue();
                }
                canvas.translate(b2 + (f4 * f2), 0.0f);
            }
        }
    }

    private boolean a(int i2) {
        return Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 19;
    }

    @Override // com.vivo.mobilead.lottie.c.c.a, com.vivo.mobilead.lottie.a.a.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.n.getBounds().width(), this.n.getBounds().height());
    }

    @Override // com.vivo.mobilead.lottie.c.c.a, com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        com.vivo.mobilead.lottie.a.b.a<Float, Float> aVar;
        com.vivo.mobilead.lottie.a.b.a aVar2;
        super.a((h) t, (com.vivo.mobilead.lottie.g.c<h>) cVar);
        if ((t == com.vivo.mobilead.lottie.g.f29453a && (aVar2 = this.o) != null) || ((t == com.vivo.mobilead.lottie.g.f29454b && (aVar2 = this.p) != null) || (t == com.vivo.mobilead.lottie.g.o && (aVar2 = this.q) != null))) {
            aVar2.a(cVar);
        } else {
            if (t != com.vivo.mobilead.lottie.g.p || (aVar = this.r) == null) {
                return;
            }
            aVar.a((com.vivo.mobilead.lottie.g.c<Float>) cVar);
        }
    }

    @Override // com.vivo.mobilead.lottie.c.c.a
    void b(Canvas canvas, Matrix matrix, int i2) {
        Paint paint;
        float f2;
        canvas.save();
        if (!this.m.v()) {
            canvas.setMatrix(matrix);
        }
        com.vivo.mobilead.lottie.c.b g2 = this.l.g();
        com.vivo.mobilead.lottie.c.c cVar = this.n.getFonts().get(g2.f29191b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        com.vivo.mobilead.lottie.a.b.a<Integer, Integer> aVar = this.o;
        if (aVar != null) {
            this.f29382h.setColor(aVar.g().intValue());
        } else {
            this.f29382h.setColor(g2.f29197h);
        }
        com.vivo.mobilead.lottie.a.b.a<Integer, Integer> aVar2 = this.p;
        if (aVar2 != null) {
            this.f29383i.setColor(aVar2.g().intValue());
        } else {
            this.f29383i.setColor(g2.f29198i);
        }
        int intValue = ((this.f29327d.a() == null ? 100 : this.f29327d.a().g().intValue()) * 255) / 100;
        this.f29382h.setAlpha(intValue);
        this.f29383i.setAlpha(intValue);
        com.vivo.mobilead.lottie.a.b.a<Float, Float> aVar3 = this.q;
        if (aVar3 != null) {
            paint = this.f29383i;
            f2 = aVar3.g().floatValue();
        } else {
            float a2 = com.vivo.mobilead.lottie.f.h.a(matrix);
            paint = this.f29383i;
            double d2 = g2.f29199j;
            double a3 = com.vivo.mobilead.lottie.f.h.a();
            Double.isNaN(a3);
            double d3 = d2 * a3;
            double d4 = a2;
            Double.isNaN(d4);
            f2 = (float) (d3 * d4);
        }
        paint.setStrokeWidth(f2);
        if (this.m.v()) {
            a(g2, matrix, cVar, canvas);
        } else {
            a(g2, cVar, matrix, canvas);
        }
        canvas.restore();
    }
}
