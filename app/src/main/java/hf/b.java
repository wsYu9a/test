package hf;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a */
    public static final int f26685a = 2048;

    /* renamed from: b */
    public static af.c f26686b;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f26687a;

        static {
            int[] iArr = new int[ViewScaleType.values().length];
            f26687a = iArr;
            try {
                iArr[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26687a[ViewScaleType.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        f26686b = new af.c(max, max);
    }

    public static int a(af.c cVar, af.c cVar2, ViewScaleType viewScaleType, boolean z10) {
        int max;
        int b10 = cVar.b();
        int a10 = cVar.a();
        int b11 = cVar2.b();
        int a11 = cVar2.a();
        int i10 = a.f26687a[viewScaleType.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                max = 1;
            } else if (z10) {
                int i11 = b10 / 2;
                int i12 = a10 / 2;
                max = 1;
                while (i11 / max > b11 && i12 / max > a11) {
                    max *= 2;
                }
            } else {
                max = Math.min(b10 / b11, a10 / a11);
            }
        } else if (z10) {
            int i13 = b10 / 2;
            int i14 = a10 / 2;
            max = 1;
            while (true) {
                if (i13 / max <= b11 && i14 / max <= a11) {
                    break;
                }
                max *= 2;
            }
        } else {
            max = Math.max(b10 / b11, a10 / a11);
        }
        return d(b10, a10, max >= 1 ? max : 1, z10);
    }

    public static float b(af.c cVar, af.c cVar2, ViewScaleType viewScaleType, boolean z10) {
        int b10 = cVar.b();
        int a10 = cVar.a();
        int b11 = cVar2.b();
        int a11 = cVar2.a();
        float f10 = b10;
        float f11 = f10 / b11;
        float f12 = a10;
        float f13 = f12 / a11;
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f11 < f13) && (viewScaleType != ViewScaleType.CROP || f11 >= f13)) {
            b11 = (int) (f10 / f13);
        } else {
            a11 = (int) (f12 / f11);
        }
        if ((z10 || b11 >= b10 || a11 >= a10) && (!z10 || b11 == b10 || a11 == a10)) {
            return 1.0f;
        }
        return b11 / f10;
    }

    public static int c(af.c cVar) {
        int b10 = cVar.b();
        int a10 = cVar.a();
        return Math.max((int) Math.ceil(b10 / f26686b.b()), (int) Math.ceil(a10 / f26686b.a()));
    }

    public static int d(int i10, int i11, int i12, boolean z10) {
        int b10 = f26686b.b();
        int a10 = f26686b.a();
        while (true) {
            if (i10 / i12 <= b10 && i11 / i12 <= a10) {
                return i12;
            }
            i12 = z10 ? i12 * 2 : i12 + 1;
        }
    }

    public static af.c e(ef.a aVar, af.c cVar) {
        int width = aVar.getWidth();
        if (width <= 0) {
            width = cVar.b();
        }
        int height = aVar.getHeight();
        if (height <= 0) {
            height = cVar.a();
        }
        return new af.c(width, height);
    }
}
