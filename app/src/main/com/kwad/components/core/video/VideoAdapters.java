package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public final class VideoAdapters {

    /* renamed from: com.kwad.components.core.video.VideoAdapters$1 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Xw;

        static {
            int[] iArr = new int[AdaptType.values().length];
            Xw = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Xw[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Xw[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Xw[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    public static abstract class a implements com.kwad.components.core.video.c {

        /* renamed from: com.kwad.components.core.video.VideoAdapters$a$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ ViewGroup.LayoutParams Xm;
            final /* synthetic */ View Xx;

            public AnonymousClass1(View view, ViewGroup.LayoutParams layoutParams) {
                view = view;
                layoutParams = layoutParams;
            }

            @Override // java.lang.Runnable
            public final void run() {
                view.setLayoutParams(layoutParams);
            }
        }

        private static boolean A(View view) {
            return view.isInLayout() || view.isLayoutRequested();
        }

        private static boolean b(View view, View view2, int i10, int i11) {
            if (view == null || i10 == 0 || i11 == 0 || view2 == null) {
                return false;
            }
            return (view2.getWidth() == 0 || view2.getHeight() == 0) ? false : true;
        }

        @Override // com.kwad.components.core.video.c
        public final void a(View view, View view2, int i10, int i11) {
            if (!b(view, view2, i10, i11)) {
                com.kwad.sdk.core.d.c.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view2.getWidth(), view2.getHeight());
            d dVar2 = new d(i10, i11);
            boolean z10 = dVar2.getRatio() >= 1.0f;
            boolean z11 = dVar.getRatio() >= 1.0f;
            AdaptType adaptType = (z11 && z10) ? AdaptType.PORTRAIT_VERTICAL : z11 ? AdaptType.PORTRAIT_HORIZONTAL : z10 ? AdaptType.LANDSCAPE_VERTICAL : AdaptType.LANDSCAPE_HORIZONTAL;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            if (A(view)) {
                view.post(new Runnable() { // from class: com.kwad.components.core.video.VideoAdapters.a.1
                    final /* synthetic */ ViewGroup.LayoutParams Xm;
                    final /* synthetic */ View Xx;

                    public AnonymousClass1(View view3, ViewGroup.LayoutParams layoutParams2) {
                        view = view3;
                        layoutParams = layoutParams2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setLayoutParams(layoutParams);
                    }
                });
            } else {
                view3.setLayoutParams(layoutParams2);
            }
        }

        public abstract void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2);
    }

    public static class b extends a {
        private float Xz = 0.8f;
        private float XA = 0.9375f;
        private float XB = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        public final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float sR;
            float f10;
            float sS = dVar.sS();
            float sS2 = dVar2.sS();
            float sR2 = dVar.sR();
            float sQ = dVar.sQ();
            com.kwad.sdk.core.d.c.d("FullHeightAdapter", "onAdaptVideo containerSize: " + sQ + ", " + sR2);
            int i10 = AnonymousClass1.Xw[adaptType.ordinal()];
            if (i10 == 1 || i10 == 2) {
                if (sS > sS2) {
                    float sQ2 = dVar.sQ();
                    float f11 = sQ2 / sS2;
                    float f12 = sR2 / f11;
                    float f13 = this.Xz;
                    if (f12 >= f13) {
                        f10 = sQ2;
                        sR = f11;
                    } else {
                        sR = sR2 / f13;
                        f10 = sR * sS2;
                    }
                } else {
                    sR = dVar.sR();
                    f10 = sS2 * sR;
                    float f14 = sQ / f10;
                    float f15 = this.XA;
                    if (f14 < f15) {
                        f10 = sQ / f15;
                        sR = f10 / sS2;
                    }
                }
            } else if (i10 == 3 || i10 == 4) {
                f10 = sR2 * this.XB;
                sR = f10 / sS2;
            } else {
                sR = -2.1474836E9f;
                f10 = -2.1474836E9f;
            }
            com.kwad.sdk.core.d.c.d("FullHeightAdapter", "onAdaptVideo result: " + f10 + ", " + sR);
            if (f10 == -2.1474836E9f || sR == -2.1474836E9f) {
                return;
            }
            if (dVar2.getHeight() >= dVar2.getWidth()) {
                layoutParams.width = (int) sR;
                layoutParams.height = (int) f10;
            } else {
                layoutParams.height = (int) sR;
                layoutParams.width = (int) f10;
            }
        }
    }

    public static class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        public final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float sQ;
            float sR;
            float sS = dVar.sS();
            float sS2 = dVar2.sS();
            int i10 = AnonymousClass1.Xw[adaptType.ordinal()];
            if (i10 == 1 || i10 == 2) {
                if (sS >= sS2) {
                    sR = dVar.sR();
                    sQ = sR * sS2;
                } else {
                    sQ = dVar.sQ();
                    sR = sQ / sS2;
                }
            } else if (i10 == 3 || i10 == 4) {
                sQ = dVar.sR();
                sR = sQ / sS2;
            } else {
                sQ = 0.0f;
                sR = -2.1474836E9f;
            }
            if (sR == -2.1474836E9f || sQ == -2.1474836E9f) {
                return;
            }
            if (dVar2.getHeight() > dVar2.getWidth()) {
                layoutParams.width = (int) sR;
                layoutParams.height = (int) sQ;
            } else {
                layoutParams.height = (int) sR;
                layoutParams.width = (int) sQ;
            }
        }
    }

    public static class d {
        float XC;
        float height;
        float width;

        public d(float f10, float f11) {
            this.XC = -1.0f;
            this.width = f10;
            this.height = f11;
            if (f10 <= 0.0f || f11 <= 0.0f) {
                return;
            }
            this.XC = f11 / f10;
        }

        private boolean isValid() {
            return this.width > 0.0f && this.height > 0.0f;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.XC;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float sQ() {
            if (isValid()) {
                return Math.max(this.width, this.height);
            }
            return -1.0f;
        }

        public final float sR() {
            if (isValid()) {
                return Math.min(this.width, this.height);
            }
            return -1.0f;
        }

        public final float sS() {
            if (!isValid()) {
                return -1.0f;
            }
            float f10 = this.height;
            float f11 = this.width;
            return f10 > f11 ? f10 / f11 : f11 / f10;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.XC + '}';
        }
    }
}
