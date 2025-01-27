package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes2.dex */
class FadeModeEvaluators {
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f10, float f11, float f12) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f11, f12, f10));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f10, float f11, float f12) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f11, f12, f10), 255);
        }
    };
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f10, float f11, float f12) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f11, f12, f10), TransitionUtils.lerp(0, 255, f11, f12, f10));
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f10, float f11, float f12) {
            float f13 = ((f12 - f11) * 0.35f) + f11;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f11, f13, f10), TransitionUtils.lerp(0, 255, f13, f12, f10));
        }
    };

    /* renamed from: com.google.android.material.transition.platform.FadeModeEvaluators$1 */
    public static class AnonymousClass1 implements FadeModeEvaluator {
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f10, float f11, float f12) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f11, f12, f10));
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FadeModeEvaluators$2 */
    public static class AnonymousClass2 implements FadeModeEvaluator {
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f10, float f11, float f12) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f11, f12, f10), 255);
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FadeModeEvaluators$3 */
    public static class AnonymousClass3 implements FadeModeEvaluator {
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f10, float f11, float f12) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f11, f12, f10), TransitionUtils.lerp(0, 255, f11, f12, f10));
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FadeModeEvaluators$4 */
    public static class AnonymousClass4 implements FadeModeEvaluator {
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f10, float f11, float f12) {
            float f13 = ((f12 - f11) * 0.35f) + f11;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f11, f13, f10), TransitionUtils.lerp(0, 255, f13, f12, f10));
        }
    }

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int i10, boolean z10) {
        if (i10 == 0) {
            return z10 ? IN : OUT;
        }
        if (i10 == 1) {
            return z10 ? OUT : IN;
        }
        if (i10 == 2) {
            return CROSS;
        }
        if (i10 == 3) {
            return THROUGH;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i10);
    }
}
