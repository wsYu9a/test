package androidx.media3.common.audio;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes.dex */
public final class ChannelMixingMatrix {
    private final float[] coefficients;
    private final int inputChannelCount;
    private final boolean isDiagonal;
    private final boolean isIdentity;
    private final boolean isZero;
    private final int outputChannelCount;

    public ChannelMixingMatrix(int i10, int i11, float[] fArr) {
        boolean z10 = false;
        Assertions.checkArgument(i10 > 0, "Input channel count must be positive.");
        Assertions.checkArgument(i11 > 0, "Output channel count must be positive.");
        Assertions.checkArgument(fArr.length == i10 * i11, "Coefficient array length is invalid.");
        this.inputChannelCount = i10;
        this.outputChannelCount = i11;
        this.coefficients = checkCoefficientsValid(fArr);
        int i12 = 0;
        boolean z11 = true;
        boolean z12 = true;
        boolean z13 = true;
        while (i12 < i10) {
            int i13 = 0;
            while (i13 < i11) {
                float mixingCoefficient = getMixingCoefficient(i12, i13);
                boolean z14 = i12 == i13;
                if (mixingCoefficient != 1.0f && z14) {
                    z13 = false;
                }
                if (mixingCoefficient != 0.0f) {
                    z11 = false;
                    if (!z14) {
                        z12 = false;
                    }
                }
                i13++;
            }
            i12++;
        }
        this.isZero = z11;
        boolean z15 = isSquare() && z12;
        this.isDiagonal = z15;
        if (z15 && z13) {
            z10 = true;
        }
        this.isIdentity = z10;
    }

    private static float[] checkCoefficientsValid(float[] fArr) {
        for (int i10 = 0; i10 < fArr.length; i10++) {
            if (fArr[i10] < 0.0f) {
                throw new IllegalArgumentException("Coefficient at index " + i10 + " is negative.");
            }
        }
        return fArr;
    }

    public static ChannelMixingMatrix create(int i10, int i11) {
        return new ChannelMixingMatrix(i10, i11, createMixingCoefficients(i10, i11));
    }

    private static float[] createMixingCoefficients(int i10, int i11) {
        if (i10 == i11) {
            return initializeIdentityMatrix(i11);
        }
        if (i10 == 1 && i11 == 2) {
            return new float[]{1.0f, 1.0f};
        }
        if (i10 == 2 && i11 == 1) {
            return new float[]{0.5f, 0.5f};
        }
        throw new UnsupportedOperationException("Default channel mixing coefficients for " + i10 + "->" + i11 + " are not yet implemented.");
    }

    private static float[] initializeIdentityMatrix(int i10) {
        float[] fArr = new float[i10 * i10];
        for (int i11 = 0; i11 < i10; i11++) {
            fArr[(i10 * i11) + i11] = 1.0f;
        }
        return fArr;
    }

    public int getInputChannelCount() {
        return this.inputChannelCount;
    }

    public float getMixingCoefficient(int i10, int i11) {
        return this.coefficients[(i10 * this.outputChannelCount) + i11];
    }

    public int getOutputChannelCount() {
        return this.outputChannelCount;
    }

    public boolean isDiagonal() {
        return this.isDiagonal;
    }

    public boolean isIdentity() {
        return this.isIdentity;
    }

    public boolean isSquare() {
        return this.inputChannelCount == this.outputChannelCount;
    }

    public boolean isZero() {
        return this.isZero;
    }

    public ChannelMixingMatrix scaleBy(float f10) {
        float[] fArr = new float[this.coefficients.length];
        int i10 = 0;
        while (true) {
            float[] fArr2 = this.coefficients;
            if (i10 >= fArr2.length) {
                return new ChannelMixingMatrix(this.inputChannelCount, this.outputChannelCount, fArr);
            }
            fArr[i10] = fArr2[i10] * f10;
            i10++;
        }
    }
}
