package w6;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import com.gyf.immersionbar.BarHide;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class a implements Cloneable {
    public View A;
    public View B;

    @ColorInt
    public int D;

    @ColorInt
    public int E;
    public q M;
    public r N;
    public p O;

    /* renamed from: b */
    @ColorInt
    public int f31601b = 0;

    /* renamed from: c */
    @ColorInt
    public int f31602c = -16777216;

    /* renamed from: d */
    public int f31603d = -16777216;

    /* renamed from: e */
    @FloatRange(from = l5.c.f27899e, to = 1.0d)
    public float f31604e = 0.0f;

    /* renamed from: f */
    @FloatRange(from = l5.c.f27899e, to = 1.0d)
    public float f31605f = 0.0f;

    /* renamed from: g */
    @FloatRange(from = l5.c.f27899e, to = 1.0d)
    public float f31606g = 0.0f;

    /* renamed from: h */
    @FloatRange(from = l5.c.f27899e, to = 1.0d)
    public float f31607h = 0.0f;

    /* renamed from: i */
    public boolean f31608i = false;

    /* renamed from: j */
    public boolean f31609j = false;

    /* renamed from: k */
    public BarHide f31610k = BarHide.FLAG_SHOW_BAR;

    /* renamed from: l */
    public boolean f31611l = false;

    /* renamed from: m */
    public boolean f31612m = false;

    /* renamed from: n */
    public boolean f31613n = false;

    /* renamed from: o */
    public boolean f31614o = false;

    /* renamed from: p */
    @FloatRange(from = l5.c.f27899e, to = 1.0d)
    public float f31615p = 0.0f;

    /* renamed from: q */
    @FloatRange(from = l5.c.f27899e, to = 1.0d)
    public float f31616q = 0.0f;

    /* renamed from: r */
    public boolean f31617r = true;

    /* renamed from: s */
    @ColorInt
    public int f31618s = -16777216;

    /* renamed from: t */
    @ColorInt
    public int f31619t = -16777216;

    /* renamed from: u */
    public Map<View, Map<Integer, Integer>> f31620u = new HashMap();

    /* renamed from: v */
    @FloatRange(from = l5.c.f27899e, to = 1.0d)
    public float f31621v = 0.0f;

    /* renamed from: w */
    @ColorInt
    public int f31622w = 0;

    /* renamed from: x */
    @ColorInt
    public int f31623x = -16777216;

    /* renamed from: y */
    @FloatRange(from = l5.c.f27899e, to = 1.0d)
    public float f31624y = 0.0f;

    /* renamed from: z */
    public boolean f31625z = false;
    public boolean C = true;
    public boolean F = false;
    public boolean G = false;
    public int H = 18;
    public boolean I = true;
    public boolean J = true;
    public boolean K = true;
    public boolean L = true;

    /* renamed from: a */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
