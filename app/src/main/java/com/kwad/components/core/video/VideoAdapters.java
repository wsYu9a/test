package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class VideoAdapters {

    /* renamed from: com.kwad.components.core.video.VideoAdapters$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Ry;

        static {
            int[] iArr = new int[AdaptType.values().length];
            Ry = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Ry[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Ry[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Ry[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    public static abstract class a implements com.kwad.components.core.video.c {
        private static boolean b(View view, View view2, int i2, int i3) {
            if (view == null || i2 == 0 || i3 == 0 || view2 == null) {
                return false;
            }
            return (view2.getWidth() == 0 || view2.getHeight() == 0) ? false : true;
        }

        @Override // com.kwad.components.core.video.c
        public final void a(View view, View view2, int i2, int i3) {
            if (!b(view, view2, i2, i3)) {
                com.kwad.sdk.core.d.b.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view2.getWidth(), view2.getHeight());
            d dVar2 = new d(i2, i3);
            boolean z = dVar2.getRatio() >= 1.0f;
            boolean z2 = dVar.getRatio() >= 1.0f;
            AdaptType adaptType = (z2 && z) ? AdaptType.PORTRAIT_VERTICAL : z2 ? AdaptType.PORTRAIT_HORIZONTAL : z ? AdaptType.LANDSCAPE_VERTICAL : AdaptType.LANDSCAPE_HORIZONTAL;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            view.setLayoutParams(layoutParams);
        }

        protected abstract void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2);
    }

    public static class b extends a {
        private float Rz = 0.8f;
        private float RA = 0.9375f;
        private float RB = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float qA;
            float f2;
            float qB = dVar.qB();
            float qB2 = dVar2.qB();
            float qA2 = dVar.qA();
            float qz = dVar.qz();
            com.kwad.sdk.core.d.b.d("FullHeightAdapter", "onAdaptVideo containerSize: " + qz + ", " + qA2);
            int i2 = AnonymousClass1.Ry[adaptType.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (qB > qB2) {
                    float qz2 = dVar.qz();
                    float f3 = qz2 / qB2;
                    float f4 = qA2 / f3;
                    float f5 = this.Rz;
                    if (f4 >= f5) {
                        f2 = qz2;
                        qA = f3;
                    } else {
                        qA = qA2 / f5;
                        f2 = qA * qB2;
                    }
                } else {
                    qA = dVar.qA();
                    f2 = qB2 * qA;
                    float f6 = qz / f2;
                    float f7 = this.RA;
                    if (f6 < f7) {
                        f2 = qz / f7;
                        qA = f2 / qB2;
                    }
                }
            } else if (i2 == 3 || i2 == 4) {
                f2 = qA2 * this.RB;
                qA = f2 / qB2;
            } else {
                qA = -2.1474836E9f;
                f2 = -2.1474836E9f;
            }
            com.kwad.sdk.core.d.b.d("FullHeightAdapter", "onAdaptVideo result: " + f2 + ", " + qA);
            if (f2 == -2.1474836E9f || qA == -2.1474836E9f) {
                return;
            }
            int i3 = (int) qA;
            if (dVar2.getHeight() >= dVar2.getWidth()) {
                layoutParams.width = i3;
                layoutParams.height = (int) f2;
            } else {
                layoutParams.height = i3;
                layoutParams.width = (int) f2;
            }
        }
    }

    public static class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float qz;
            float qA;
            float qB = dVar.qB();
            float qB2 = dVar2.qB();
            int i2 = AnonymousClass1.Ry[adaptType.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (qB >= qB2) {
                    qA = dVar.qA();
                    qz = qA * qB2;
                } else {
                    qz = dVar.qz();
                    qA = qz / qB2;
                }
            } else if (i2 == 3 || i2 == 4) {
                qz = dVar.qA();
                qA = qz / qB2;
            } else {
                qz = 0.0f;
                qA = -2.1474836E9f;
            }
            if (qA == -2.1474836E9f || qz == -2.1474836E9f) {
                return;
            }
            int i3 = (int) qA;
            if (dVar2.getHeight() > dVar2.getWidth()) {
                layoutParams.width = i3;
                layoutParams.height = (int) qz;
            } else {
                layoutParams.height = i3;
                layoutParams.width = (int) qz;
            }
        }
    }

    static class d {
        float RC;
        float height;
        float width;

        public d(float f2, float f3) {
            this.RC = -1.0f;
            this.width = f2;
            this.height = f3;
            if (f2 <= 0.0f || f3 <= 0.0f) {
                return;
            }
            this.RC = f3 / f2;
        }

        private boolean isValid() {
            return this.width > 0.0f && this.height > 0.0f;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.RC;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float qA() {
            if (isValid()) {
                return Math.min(this.width, this.height);
            }
            return -1.0f;
        }

        public final float qB() {
            if (!isValid()) {
                return -1.0f;
            }
            float f2 = this.height;
            float f3 = this.width;
            return f2 > f3 ? f2 / f3 : f3 / f2;
        }

        public final float qz() {
            if (isValid()) {
                return Math.max(this.width, this.height);
            }
            return -1.0f;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.RC + '}';
        }
    }
}
