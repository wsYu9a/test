package b.g.a.b;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    private static final int f4910a = 2048;

    /* renamed from: b */
    private static com.nostra13.universalimageloader.core.assist.c f4911b;

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f4912a;

        static {
            int[] iArr = new int[ViewScaleType.values().length];
            f4912a = iArr;
            try {
                iArr[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4912a[ViewScaleType.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        f4911b = new com.nostra13.universalimageloader.core.assist.c(max, max);
    }

    private b() {
    }

    public static int a(com.nostra13.universalimageloader.core.assist.c cVar, com.nostra13.universalimageloader.core.assist.c cVar2, ViewScaleType viewScaleType, boolean z) {
        int max;
        int b2 = cVar.b();
        int a2 = cVar.a();
        int b3 = cVar2.b();
        int a3 = cVar2.a();
        int i2 = a.f4912a[viewScaleType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                max = 1;
            } else if (z) {
                int i3 = b2 / 2;
                int i4 = a2 / 2;
                max = 1;
                while (i3 / max > b3 && i4 / max > a3) {
                    max *= 2;
                }
            } else {
                max = Math.min(b2 / b3, a2 / a3);
            }
        } else if (z) {
            int i5 = b2 / 2;
            int i6 = a2 / 2;
            max = 1;
            while (true) {
                if (i5 / max <= b3 && i6 / max <= a3) {
                    break;
                }
                max *= 2;
            }
        } else {
            max = Math.max(b2 / b3, a2 / a3);
        }
        return d(b2, a2, max >= 1 ? max : 1, z);
    }

    public static float b(com.nostra13.universalimageloader.core.assist.c cVar, com.nostra13.universalimageloader.core.assist.c cVar2, ViewScaleType viewScaleType, boolean z) {
        int b2 = cVar.b();
        int a2 = cVar.a();
        int b3 = cVar2.b();
        int a3 = cVar2.a();
        float f2 = b2;
        float f3 = f2 / b3;
        float f4 = a2;
        float f5 = f4 / a3;
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f3 < f5) && (viewScaleType != ViewScaleType.CROP || f3 >= f5)) {
            b3 = (int) (f2 / f5);
        } else {
            a3 = (int) (f4 / f3);
        }
        if ((z || b3 >= b2 || a3 >= a2) && (!z || b3 == b2 || a3 == a2)) {
            return 1.0f;
        }
        return b3 / f2;
    }

    public static int c(com.nostra13.universalimageloader.core.assist.c cVar) {
        int b2 = cVar.b();
        int a2 = cVar.a();
        return Math.max((int) Math.ceil(b2 / f4911b.b()), (int) Math.ceil(a2 / f4911b.a()));
    }

    private static int d(int i2, int i3, int i4, boolean z) {
        int b2 = f4911b.b();
        int a2 = f4911b.a();
        while (true) {
            if (i2 / i4 <= b2 && i3 / i4 <= a2) {
                return i4;
            }
            i4 = z ? i4 * 2 : i4 + 1;
        }
    }

    public static com.nostra13.universalimageloader.core.assist.c e(com.nostra13.universalimageloader.core.j.a aVar, com.nostra13.universalimageloader.core.assist.c cVar) {
        int width = aVar.getWidth();
        if (width <= 0) {
            width = cVar.b();
        }
        int height = aVar.getHeight();
        if (height <= 0) {
            height = cVar.a();
        }
        return new com.nostra13.universalimageloader.core.assist.c(width, height);
    }
}
