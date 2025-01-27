package ge;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class q {

    /* renamed from: t */
    public static final int f26253t = 5;

    /* renamed from: u */
    public static final int f26254u = 0;

    /* renamed from: v */
    public static final int f26255v = 1;

    /* renamed from: w */
    public static final int f26256w = 2;

    /* renamed from: x */
    public static final int f26257x = 3;

    /* renamed from: y */
    public static final int f26258y = 4;

    /* renamed from: c */
    public final String f26261c;

    /* renamed from: d */
    public final TextPaint f26262d;

    /* renamed from: e */
    public int f26263e;

    /* renamed from: f */
    public int f26264f;

    /* renamed from: h */
    public View f26266h;

    /* renamed from: n */
    public final Paint f26272n;

    /* renamed from: o */
    public final Paint f26273o;

    /* renamed from: p */
    public List<a> f26274p;

    /* renamed from: q */
    public final Resources f26275q;

    /* renamed from: r */
    public int f26276r;

    /* renamed from: g */
    public boolean f26265g = false;

    /* renamed from: i */
    public int f26267i = -1;

    /* renamed from: j */
    public int f26268j = -1;

    /* renamed from: k */
    public int f26269k = -1;

    /* renamed from: l */
    public int f26270l = -1;

    /* renamed from: b */
    public final ArrayList<Number> f26260b = new ArrayList<>(16);

    /* renamed from: m */
    public List<RectF> f26271m = null;

    /* renamed from: a */
    public int f26259a = 0;

    /* renamed from: s */
    public final TreeMap<Integer, Integer> f26277s = new TreeMap<>();

    public static class a {

        /* renamed from: a */
        public int f26278a;

        /* renamed from: b */
        public int f26279b;

        public a(int i10, int i11) {
            this.f26278a = i10;
            this.f26279b = i11;
        }

        public boolean a(a aVar) {
            int i10 = this.f26278a;
            int i11 = aVar.f26278a;
            if (i10 == i11 && this.f26279b == aVar.f26279b) {
                return false;
            }
            this.f26278a = Math.min(i10, i11);
            this.f26279b = Math.max(this.f26279b, aVar.f26279b);
            return true;
        }

        public void b(int i10, int i11) {
            this.f26278a = i10;
            this.f26279b = i11;
        }
    }

    public q(String str, int i10, int i11, TextPaint textPaint, Paint paint, Paint paint2, Resources resources) {
        this.f26261c = str;
        this.f26263e = i10;
        this.f26264f = i11;
        this.f26262d = textPaint;
        this.f26272n = paint;
        this.f26273o = paint2;
        this.f26275q = resources;
        this.f26276r = ba.m.b(resources, 64.0f);
    }

    public int A(int i10, float f10) {
        int v10 = v(i10);
        int s10 = s(i10);
        int R = R(this.f26261c, v10, s10);
        int i11 = 0;
        float measureText = (R >= s10 + (-1) || !(s10 < this.f26261c.length() && this.f26261c.charAt(s10) != '\n')) ? 0.0f : (this.f26263e - this.f26262d.measureText(this.f26261c, v10, s10)) / ((s10 - R) - 1);
        while (v10 < s10) {
            int i12 = v10 + 1;
            float measureText2 = this.f26262d.measureText(this.f26261c, v10, i12);
            float f11 = i11;
            if (f10 <= (measureText2 / 2.0f) + f11) {
                return v10;
            }
            i11 = (int) (f11 + measureText2 + (v10 >= R ? measureText : 0.0f));
            v10 = i12;
        }
        return s10;
    }

    public int B() {
        return this.f26264f;
    }

    public int C() {
        return this.f26263e;
    }

    public int D() {
        return this.f26263e;
    }

    public Rect E(int i10, int i11) {
        Integer G = G(i10);
        if (G == null) {
            return null;
        }
        RectF f10 = f(G.intValue());
        if (f10 == null) {
            return new Rect(0, 0, i11, i11);
        }
        float f11 = f10.top;
        int i12 = (int) (f11 + (((f10.bottom - f11) - i11) / 2.0f));
        float f12 = f10.right;
        return new Rect(((int) f12) + 4, i12, ((int) f12) + 4 + i11, i11 + i12);
    }

    public int F(int i10) {
        int v10 = v(0);
        for (Map.Entry<Integer, Integer> entry : this.f26277s.entrySet()) {
            int s10 = s(entry.getValue().intValue());
            if (i10 > v10 && i10 <= s10) {
                return entry.getKey().intValue();
            }
            v10 = s10;
        }
        return -1;
    }

    public Integer G(int i10) {
        return this.f26277s.get(Integer.valueOf(i10));
    }

    public int H() {
        return this.f26268j;
    }

    public RectF I() {
        List<RectF> list = this.f26271m;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.f26271m.get(r0.size() - 1);
    }

    public int J() {
        return this.f26267i;
    }

    public RectF K() {
        List<RectF> list = this.f26271m;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.f26271m.get(0);
    }

    public String L() {
        int i10;
        int i11 = this.f26267i;
        if (i11 == -1 || (i10 = this.f26268j) == -1) {
            return null;
        }
        int R = R(this.f26261c, i11, i10);
        int y10 = y(this.f26261c, R, this.f26268j);
        return R >= y10 ? "" : this.f26261c.substring(R, y10);
    }

    public String M() {
        return this.f26261c;
    }

    public int N() {
        return this.f26261c.length();
    }

    public int O(float f10, float f11) {
        int t10 = t(f11);
        if (t10 == -1) {
            return -1;
        }
        return A(t10, f10);
    }

    public TextPaint P() {
        return this.f26262d;
    }

    public View Q() {
        return this.f26266h;
    }

    public final int R(String str, int i10, int i11) {
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            if (charAt != ' ' && charAt != 12288) {
                break;
            }
            i10 += 2;
        }
        return i10;
    }

    public boolean S() {
        return this.f26267i >= 0 && this.f26268j > 0;
    }

    public boolean T() {
        return this.f26265g;
    }

    public boolean U() {
        if (this.f26269k == -1 && this.f26270l == -1) {
            return false;
        }
        this.f26269k = -1;
        this.f26270l = -1;
        return true;
    }

    public boolean V() {
        if (this.f26267i == -1 && this.f26268j == -1) {
            return false;
        }
        this.f26267i = -1;
        this.f26268j = -1;
        this.f26271m = null;
        return true;
    }

    public boolean W(int i10, int i11) {
        List<a> list = this.f26274p;
        boolean z10 = false;
        if (list == null) {
            return false;
        }
        ListIterator<a> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            a next = listIterator.next();
            if (next.f26278a < i11 && next.f26279b > i10) {
                listIterator.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public boolean X(int i10, int i11) {
        if (i10 < v(0)) {
            i10 = v(0);
        }
        if (i11 > s(this.f26259a - 1)) {
            i11 = s(this.f26259a - 1);
        }
        if (i10 >= i11) {
            return false;
        }
        if (this.f26269k == i10 && this.f26270l == i11) {
            return false;
        }
        this.f26269k = i10;
        this.f26270l = i11;
        return true;
    }

    public void Y(int i10) {
        this.f26264f = i10;
    }

    public void Z(int i10) {
        this.f26263e = i10;
    }

    public void a(int i10, int i11, float f10, float f11, float f12) {
        this.f26259a++;
        this.f26260b.add(Integer.valueOf(i10));
        this.f26260b.add(Integer.valueOf(i11));
        this.f26260b.add(Float.valueOf(f10));
        this.f26260b.add(Float.valueOf(f11));
        this.f26260b.add(Float.valueOf(f12));
    }

    public boolean a0(float f10, float f11) {
        int t10 = t(f11);
        if (t10 == -1) {
            V();
            return false;
        }
        int v10 = v(t10);
        int s10 = s(t10);
        while (v10 > v(0) && this.f26261c.charAt(v10 - 1) != '\n') {
            v10--;
        }
        while (s10 < s(this.f26259a - 1) && this.f26261c.charAt(s10) != '\n') {
            s10++;
        }
        return b0(R(this.f26261c, v10, s10), s10);
    }

    public void b(int i10, int i11) {
        this.f26277s.put(Integer.valueOf(i10), Integer.valueOf(i11));
    }

    public boolean b0(int i10, int i11) {
        if (i10 < v(0)) {
            i10 = v(0);
        }
        if (i11 > s(this.f26259a - 1)) {
            i11 = s(this.f26259a - 1);
        }
        if (i10 >= i11) {
            return false;
        }
        if (this.f26267i == i10 && this.f26268j == i11) {
            return false;
        }
        this.f26267i = i10;
        this.f26268j = i11;
        this.f26271m = i(i10, i11);
        return true;
    }

    public boolean c(int i10, int i11) {
        if (i10 < v(0)) {
            i10 = v(0);
        }
        if (i11 > s(this.f26259a - 1)) {
            i11 = s(this.f26259a - 1);
        }
        if (i10 >= i11) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        a aVar = new a(i10, i11);
        if (this.f26274p == null) {
            this.f26274p = arrayList;
            arrayList.add(aVar);
            return true;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i12 = 0; i12 < this.f26274p.size(); i12++) {
            a aVar2 = this.f26274p.get(i12);
            if (aVar.f26278a >= aVar2.f26279b) {
                arrayList.add(aVar2);
            } else if (aVar.f26279b <= aVar2.f26278a) {
                if (!z10) {
                    arrayList.add(aVar);
                    z10 = true;
                }
                arrayList.add(aVar2);
            } else if (!z10) {
                boolean a10 = aVar.a(aVar2) | z11;
                arrayList.add(aVar);
                z11 = a10;
                z10 = true;
            }
        }
        if (!z10) {
            arrayList.add(aVar);
        }
        this.f26274p = arrayList;
        return z11;
    }

    public void c0(int i10) {
        this.f26262d.setColor(i10);
    }

    public void d() {
        this.f26274p = null;
    }

    public void d0(int i10) {
        this.f26273o.setColor(i10);
        this.f26273o.setAlpha(128);
    }

    public void e(float f10, float f11) {
        float r10 = r(this.f26259a - 1) - f10;
        this.f26260b.set(((this.f26259a - 1) * 5) + 3, Float.valueOf(r10));
        this.f26260b.set(((this.f26259a - 1) * 5) + 4, Float.valueOf(0.0f));
        this.f26260b.add(-1);
        this.f26260b.add(-1);
        this.f26260b.add(Float.valueOf(w(this.f26259a - 1) + f11));
        this.f26260b.add(Float.valueOf(r10));
        this.f26260b.add(Float.valueOf(f10));
    }

    public void e0(boolean z10) {
        this.f26265g = z10;
    }

    public RectF f(int i10) {
        return h(i10, v(i10), s(i10), x());
    }

    public void f0(View view) {
        this.f26266h = view;
    }

    public RectF g(int i10, int i11, int i12) {
        return h(i10, i11, i12, x());
    }

    public boolean g0() {
        if (!S()) {
            return true;
        }
        List<a> list = this.f26274p;
        if (list != null && !list.isEmpty()) {
            for (a aVar : this.f26274p) {
                if (this.f26267i >= aVar.f26278a && this.f26268j <= aVar.f26279b) {
                    return true;
                }
            }
        }
        return false;
    }

    public final RectF h(int i10, int i11, int i12, float f10) {
        int i13;
        int v10 = v(i10);
        int s10 = s(i10);
        int R = R(this.f26261c, v10, s10);
        boolean z10 = s10 < this.f26261c.length() && this.f26261c.charAt(s10) != '\n';
        if (R >= i12) {
            return null;
        }
        float measureText = (!z10 || (i13 = (s10 - R) - 1) <= 0) ? 0.0f : (this.f26263e - this.f26262d.measureText(this.f26261c, v10, s10)) / i13;
        if (i11 < R) {
            i11 = R;
        }
        float measureText2 = i11 > v10 ? this.f26262d.measureText(this.f26261c, v10, i11) + ((i11 - R) * measureText) : 0.0f;
        float f11 = this.f26263e;
        if (!z10 || i12 != s10) {
            f11 = this.f26262d.measureText(this.f26261c, v10, i12) + (measureText * (i12 - R));
        }
        float f12 = i10 * f10;
        return new RectF(measureText2, w(i10) + f12, f11, (w(i10 + 1) - u(i10)) + f12);
    }

    public final List<RectF> i(int i10, int i11) {
        int i12 = this.f26259a - 1;
        int i13 = 0;
        int i14 = -1;
        while (true) {
            if (i13 >= this.f26259a) {
                break;
            }
            int s10 = s(i13);
            if (s10 > i10) {
                if (i14 == -1) {
                    i14 = i13;
                }
                if (s10 >= i11) {
                    i12 = i13;
                    break;
                }
            }
            i13++;
        }
        if (i14 == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float x10 = x();
        int i15 = i14;
        while (i15 <= i12) {
            RectF h10 = h(i15, i15 == i14 ? i10 : v(i15), i15 == i12 ? i11 : s(i15), x10);
            if (h10 != null) {
                arrayList.add(h10);
            }
            i15++;
        }
        return arrayList;
    }

    public void j(Canvas canvas) {
        m(canvas);
        k(canvas);
        n(canvas);
        float x10 = x();
        float f10 = 0.0f;
        int i10 = 0;
        while (i10 < this.f26259a) {
            int v10 = v(i10);
            int s10 = s(i10);
            int i11 = i10 + 1;
            float w10 = (w(i11) - r(i10)) + f10;
            if (this.f26265g) {
                f10 += x10;
            }
            if (s10 >= this.f26261c.length() || this.f26261c.charAt(s10) == '\n' || !l(canvas, v10, s10, w10)) {
                canvas.drawText(this.f26261c, v10, s10, 0.0f, w10, (Paint) this.f26262d);
            }
            i10 = i11;
        }
    }

    public final void k(Canvas canvas) {
        int i10;
        List<RectF> i11;
        int i12 = this.f26269k;
        if (i12 < 0 || (i10 = this.f26270l) < 0 || i12 >= i10 || (i11 = i(i12, i10)) == null) {
            return;
        }
        Path path = new Path();
        Iterator<RectF> it = i11.iterator();
        while (it.hasNext()) {
            path.addRect(it.next(), Path.Direction.CCW);
        }
        canvas.drawPath(path, this.f26272n);
    }

    public final boolean l(Canvas canvas, int i10, int i11, float f10) {
        int i12 = i10;
        int R = R(this.f26261c, i12, i11);
        if (R >= i11 - 1) {
            return false;
        }
        float measureText = (this.f26263e - this.f26262d.measureText(this.f26261c, i12, i11)) / ((i11 - R) - 1);
        float f11 = 0.0f;
        while (i12 < i11) {
            int i13 = i12 + 1;
            float measureText2 = this.f26262d.measureText(this.f26261c, i12, i13);
            canvas.drawText(this.f26261c, i12, i13, f11, f10, (Paint) this.f26262d);
            f11 += measureText2 + (i12 >= R ? measureText : 0.0f);
            i12 = i13;
        }
        return true;
    }

    public final void m(Canvas canvas) {
        int i10;
        int i11 = this.f26267i;
        if (i11 < 0 || (i10 = this.f26268j) < 0 || i11 >= i10 || this.f26271m == null) {
            return;
        }
        Path path = new Path();
        Iterator<RectF> it = this.f26271m.iterator();
        while (it.hasNext()) {
            path.addRect(it.next(), Path.Direction.CCW);
        }
        canvas.drawPath(path, this.f26272n);
    }

    public final void n(Canvas canvas) {
        int i10;
        List<RectF> i11;
        List<a> list = this.f26274p;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (a aVar : this.f26274p) {
            int i12 = aVar.f26278a;
            if (i12 >= 0 && (i10 = aVar.f26279b) >= 0 && i12 < i10 && (i11 = i(i12, i10)) != null) {
                for (RectF rectF : i11) {
                    float f10 = rectF.left + 2.0f;
                    float f11 = rectF.bottom;
                    canvas.drawLine(f10, f11, rectF.right - 2.0f, f11, this.f26273o);
                }
            }
        }
    }

    public int o() {
        if (!this.f26265g) {
            return z();
        }
        View view = this.f26266h;
        return view == null ? this.f26264f : (view.getHeight() - this.f26266h.getPaddingTop()) - this.f26266h.getPaddingBottom();
    }

    public Paint p() {
        return this.f26272n;
    }

    public int q() {
        return this.f26259a;
    }

    public final float r(int i10) {
        return ((Float) this.f26260b.get((i10 * 5) + 3)).floatValue();
    }

    public int s(int i10) {
        return ((Integer) this.f26260b.get((i10 * 5) + 1)).intValue();
    }

    public int t(float f10) {
        float x10 = x();
        int i10 = 0;
        float f11 = 0.0f;
        while (i10 < this.f26259a) {
            float w10 = (w(i10) + f11) - (i10 == 0 ? 0.0f : u(i10 - 1) / 2.0f);
            int i11 = i10 + 1;
            float w11 = (w(i11) - (u(i10) / 2.0f)) + f11;
            if (f10 >= w10 && f10 <= w11) {
                return i10;
            }
            f11 += x10;
            i10 = i11;
        }
        return -1;
    }

    @NonNull
    public String toString() {
        return this.f26261c.substring(v(0), s(this.f26259a - 1));
    }

    public float u(int i10) {
        return ((Float) this.f26260b.get((i10 * 5) + 4)).floatValue();
    }

    public int v(int i10) {
        return ((Integer) this.f26260b.get(i10 * 5)).intValue();
    }

    public float w(int i10) {
        return ((Float) this.f26260b.get((i10 * 5) + 2)).floatValue();
    }

    public final float x() {
        if (!this.f26265g || this.f26259a == 1) {
            return 0.0f;
        }
        return (Math.min(this.f26276r, o() - z()) * 1.0f) / (this.f26259a - 1);
    }

    public final int y(String str, int i10, int i11) {
        while (i10 < i11 && str.charAt(i11 - 1) == '\n') {
            i11--;
        }
        return i11;
    }

    public int z() {
        return (int) w(q());
    }
}
