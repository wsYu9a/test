package androidx.media3.common.audio;

import androidx.media3.common.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
final class Sonic {
    private static final int AMDF_FREQUENCY = 4000;
    private static final int BYTES_PER_SAMPLE = 2;
    private static final int MAXIMUM_PITCH = 400;
    private static final int MINIMUM_PITCH = 65;
    private final int channelCount;
    private final short[] downSampleBuffer;
    private short[] inputBuffer;
    private int inputFrameCount;
    private final int inputSampleRateHz;
    private int maxDiff;
    private final int maxPeriod;
    private final int maxRequiredFrameCount;
    private int minDiff;
    private final int minPeriod;
    private int newRatePosition;
    private int oldRatePosition;
    private short[] outputBuffer;
    private int outputFrameCount;
    private final float pitch;
    private short[] pitchBuffer;
    private int pitchFrameCount;
    private int prevMinDiff;
    private int prevPeriod;
    private final float rate;
    private int remainingInputToCopyFrameCount;
    private final float speed;

    public Sonic(int i10, int i11, float f10, float f11, int i12) {
        this.inputSampleRateHz = i10;
        this.channelCount = i11;
        this.speed = f10;
        this.pitch = f11;
        this.rate = i10 / i12;
        this.minPeriod = i10 / 400;
        int i13 = i10 / 65;
        this.maxPeriod = i13;
        int i14 = i13 * 2;
        this.maxRequiredFrameCount = i14;
        this.downSampleBuffer = new short[i14];
        this.inputBuffer = new short[i14 * i11];
        this.outputBuffer = new short[i14 * i11];
        this.pitchBuffer = new short[i14 * i11];
    }

    private void adjustRate(float f10, int i10) {
        int i11;
        int i12;
        if (this.outputFrameCount == i10) {
            return;
        }
        int i13 = this.inputSampleRateHz;
        int i14 = (int) (i13 / f10);
        while (true) {
            if (i14 <= 16384 && i13 <= 16384) {
                break;
            }
            i14 /= 2;
            i13 /= 2;
        }
        moveNewSamplesToPitchBuffer(i10);
        int i15 = 0;
        while (true) {
            int i16 = this.pitchFrameCount;
            if (i15 >= i16 - 1) {
                removePitchFrames(i16 - 1);
                return;
            }
            while (true) {
                i11 = this.oldRatePosition;
                int i17 = (i11 + 1) * i14;
                i12 = this.newRatePosition;
                if (i17 <= i12 * i13) {
                    break;
                }
                this.outputBuffer = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, 1);
                int i18 = 0;
                while (true) {
                    int i19 = this.channelCount;
                    if (i18 < i19) {
                        this.outputBuffer[(this.outputFrameCount * i19) + i18] = interpolate(this.pitchBuffer, (i19 * i15) + i18, i13, i14);
                        i18++;
                    }
                }
                this.newRatePosition++;
                this.outputFrameCount++;
            }
            int i20 = i11 + 1;
            this.oldRatePosition = i20;
            if (i20 == i13) {
                this.oldRatePosition = 0;
                Assertions.checkState(i12 == i14);
                this.newRatePosition = 0;
            }
            i15++;
        }
    }

    private void changeSpeed(float f10) {
        int skipPitchPeriod;
        int i10 = this.inputFrameCount;
        if (i10 < this.maxRequiredFrameCount) {
            return;
        }
        int i11 = 0;
        do {
            if (this.remainingInputToCopyFrameCount > 0) {
                skipPitchPeriod = copyInputToOutput(i11);
            } else {
                int findPitchPeriod = findPitchPeriod(this.inputBuffer, i11);
                skipPitchPeriod = ((double) f10) > 1.0d ? findPitchPeriod + skipPitchPeriod(this.inputBuffer, i11, f10, findPitchPeriod) : insertPitchPeriod(this.inputBuffer, i11, f10, findPitchPeriod);
            }
            i11 += skipPitchPeriod;
        } while (this.maxRequiredFrameCount + i11 <= i10);
        removeProcessedInputFrames(i11);
    }

    private int copyInputToOutput(int i10) {
        int min = Math.min(this.maxRequiredFrameCount, this.remainingInputToCopyFrameCount);
        copyToOutput(this.inputBuffer, i10, min);
        this.remainingInputToCopyFrameCount -= min;
        return min;
    }

    private void copyToOutput(short[] sArr, int i10, int i11) {
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i11);
        this.outputBuffer = ensureSpaceForAdditionalFrames;
        int i12 = this.channelCount;
        System.arraycopy(sArr, i10 * i12, ensureSpaceForAdditionalFrames, this.outputFrameCount * i12, i12 * i11);
        this.outputFrameCount += i11;
    }

    private void downSampleInput(short[] sArr, int i10, int i11) {
        int i12 = this.maxRequiredFrameCount / i11;
        int i13 = this.channelCount;
        int i14 = i11 * i13;
        int i15 = i10 * i13;
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = 0;
            for (int i18 = 0; i18 < i14; i18++) {
                i17 += sArr[(i16 * i14) + i15 + i18];
            }
            this.downSampleBuffer[i16] = (short) (i17 / i14);
        }
    }

    private short[] ensureSpaceForAdditionalFrames(short[] sArr, int i10, int i11) {
        int length = sArr.length;
        int i12 = this.channelCount;
        int i13 = length / i12;
        return i10 + i11 <= i13 ? sArr : Arrays.copyOf(sArr, (((i13 * 3) / 2) + i11) * i12);
    }

    private int findPitchPeriod(short[] sArr, int i10) {
        int i11;
        int i12 = this.inputSampleRateHz;
        int i13 = i12 > 4000 ? i12 / 4000 : 1;
        if (this.channelCount == 1 && i13 == 1) {
            i11 = findPitchPeriodInRange(sArr, i10, this.minPeriod, this.maxPeriod);
        } else {
            downSampleInput(sArr, i10, i13);
            int findPitchPeriodInRange = findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / i13, this.maxPeriod / i13);
            if (i13 != 1) {
                int i14 = findPitchPeriodInRange * i13;
                int i15 = i13 * 4;
                int i16 = i14 - i15;
                int i17 = i14 + i15;
                int i18 = this.minPeriod;
                if (i16 < i18) {
                    i16 = i18;
                }
                int i19 = this.maxPeriod;
                if (i17 > i19) {
                    i17 = i19;
                }
                if (this.channelCount == 1) {
                    i11 = findPitchPeriodInRange(sArr, i10, i16, i17);
                } else {
                    downSampleInput(sArr, i10, 1);
                    i11 = findPitchPeriodInRange(this.downSampleBuffer, 0, i16, i17);
                }
            } else {
                i11 = findPitchPeriodInRange;
            }
        }
        int i20 = previousPeriodBetter(this.minDiff, this.maxDiff) ? this.prevPeriod : i11;
        this.prevMinDiff = this.minDiff;
        this.prevPeriod = i11;
        return i20;
    }

    private int findPitchPeriodInRange(short[] sArr, int i10, int i11, int i12) {
        int i13 = i10 * this.channelCount;
        int i14 = 255;
        int i15 = 1;
        int i16 = 0;
        int i17 = 0;
        while (i11 <= i12) {
            int i18 = 0;
            for (int i19 = 0; i19 < i11; i19++) {
                i18 += Math.abs(sArr[i13 + i19] - sArr[(i13 + i11) + i19]);
            }
            if (i18 * i16 < i15 * i11) {
                i16 = i11;
                i15 = i18;
            }
            if (i18 * i14 > i17 * i11) {
                i14 = i11;
                i17 = i18;
            }
            i11++;
        }
        this.minDiff = i15 / i16;
        this.maxDiff = i17 / i14;
        return i16;
    }

    private int insertPitchPeriod(short[] sArr, int i10, float f10, int i11) {
        int i12;
        if (f10 < 0.5f) {
            i12 = (int) ((i11 * f10) / (1.0f - f10));
        } else {
            this.remainingInputToCopyFrameCount = (int) ((i11 * ((2.0f * f10) - 1.0f)) / (1.0f - f10));
            i12 = i11;
        }
        int i13 = i11 + i12;
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i13);
        this.outputBuffer = ensureSpaceForAdditionalFrames;
        int i14 = this.channelCount;
        System.arraycopy(sArr, i10 * i14, ensureSpaceForAdditionalFrames, this.outputFrameCount * i14, i14 * i11);
        overlapAdd(i12, this.channelCount, this.outputBuffer, this.outputFrameCount + i11, sArr, i10 + i11, sArr, i10);
        this.outputFrameCount += i13;
        return i12;
    }

    private short interpolate(short[] sArr, int i10, int i11, int i12) {
        short s10 = sArr[i10];
        short s11 = sArr[i10 + this.channelCount];
        int i13 = this.newRatePosition * i11;
        int i14 = this.oldRatePosition;
        int i15 = i14 * i12;
        int i16 = (i14 + 1) * i12;
        int i17 = i16 - i13;
        int i18 = i16 - i15;
        return (short) (((s10 * i17) + ((i18 - i17) * s11)) / i18);
    }

    private void moveNewSamplesToPitchBuffer(int i10) {
        int i11 = this.outputFrameCount - i10;
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.pitchBuffer, this.pitchFrameCount, i11);
        this.pitchBuffer = ensureSpaceForAdditionalFrames;
        short[] sArr = this.outputBuffer;
        int i12 = this.channelCount;
        System.arraycopy(sArr, i10 * i12, ensureSpaceForAdditionalFrames, this.pitchFrameCount * i12, i12 * i11);
        this.outputFrameCount = i10;
        this.pitchFrameCount += i11;
    }

    private static void overlapAdd(int i10, int i11, short[] sArr, int i12, short[] sArr2, int i13, short[] sArr3, int i14) {
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = (i12 * i11) + i15;
            int i17 = (i14 * i11) + i15;
            int i18 = (i13 * i11) + i15;
            for (int i19 = 0; i19 < i10; i19++) {
                sArr[i16] = (short) (((sArr2[i18] * (i10 - i19)) + (sArr3[i17] * i19)) / i10);
                i16 += i11;
                i18 += i11;
                i17 += i11;
            }
        }
    }

    private boolean previousPeriodBetter(int i10, int i11) {
        return i10 != 0 && this.prevPeriod != 0 && i11 <= i10 * 3 && i10 * 2 > this.prevMinDiff * 3;
    }

    private void processStreamInput() {
        int i10 = this.outputFrameCount;
        float f10 = this.speed;
        float f11 = this.pitch;
        float f12 = f10 / f11;
        float f13 = this.rate * f11;
        double d10 = f12;
        if (d10 > 1.00001d || d10 < 0.99999d) {
            changeSpeed(f12);
        } else {
            copyToOutput(this.inputBuffer, 0, this.inputFrameCount);
            this.inputFrameCount = 0;
        }
        if (f13 != 1.0f) {
            adjustRate(f13, i10);
        }
    }

    private void removePitchFrames(int i10) {
        if (i10 == 0) {
            return;
        }
        short[] sArr = this.pitchBuffer;
        int i11 = this.channelCount;
        System.arraycopy(sArr, i10 * i11, sArr, 0, (this.pitchFrameCount - i10) * i11);
        this.pitchFrameCount -= i10;
    }

    private void removeProcessedInputFrames(int i10) {
        int i11 = this.inputFrameCount - i10;
        short[] sArr = this.inputBuffer;
        int i12 = this.channelCount;
        System.arraycopy(sArr, i10 * i12, sArr, 0, i12 * i11);
        this.inputFrameCount = i11;
    }

    private int skipPitchPeriod(short[] sArr, int i10, float f10, int i11) {
        int i12;
        if (f10 >= 2.0f) {
            i12 = (int) (i11 / (f10 - 1.0f));
        } else {
            this.remainingInputToCopyFrameCount = (int) ((i11 * (2.0f - f10)) / (f10 - 1.0f));
            i12 = i11;
        }
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i12);
        this.outputBuffer = ensureSpaceForAdditionalFrames;
        overlapAdd(i12, this.channelCount, ensureSpaceForAdditionalFrames, this.outputFrameCount, sArr, i10, sArr, i10 + i11);
        this.outputFrameCount += i12;
        return i12;
    }

    public void flush() {
        this.inputFrameCount = 0;
        this.outputFrameCount = 0;
        this.pitchFrameCount = 0;
        this.oldRatePosition = 0;
        this.newRatePosition = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.prevPeriod = 0;
        this.prevMinDiff = 0;
        this.minDiff = 0;
        this.maxDiff = 0;
    }

    public void getOutput(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.channelCount, this.outputFrameCount);
        shortBuffer.put(this.outputBuffer, 0, this.channelCount * min);
        int i10 = this.outputFrameCount - min;
        this.outputFrameCount = i10;
        short[] sArr = this.outputBuffer;
        int i11 = this.channelCount;
        System.arraycopy(sArr, min * i11, sArr, 0, i10 * i11);
    }

    public int getOutputSize() {
        return this.outputFrameCount * this.channelCount * 2;
    }

    public int getPendingInputBytes() {
        return this.inputFrameCount * this.channelCount * 2;
    }

    public void queueEndOfStream() {
        int i10;
        int i11 = this.inputFrameCount;
        float f10 = this.speed;
        float f11 = this.pitch;
        int i12 = this.outputFrameCount + ((int) ((((i11 / (f10 / f11)) + this.pitchFrameCount) / (this.rate * f11)) + 0.5f));
        this.inputBuffer = ensureSpaceForAdditionalFrames(this.inputBuffer, i11, (this.maxRequiredFrameCount * 2) + i11);
        int i13 = 0;
        while (true) {
            i10 = this.maxRequiredFrameCount;
            int i14 = this.channelCount;
            if (i13 >= i10 * 2 * i14) {
                break;
            }
            this.inputBuffer[(i14 * i11) + i13] = 0;
            i13++;
        }
        this.inputFrameCount += i10 * 2;
        processStreamInput();
        if (this.outputFrameCount > i12) {
            this.outputFrameCount = i12;
        }
        this.inputFrameCount = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.pitchFrameCount = 0;
    }

    public void queueInput(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i10 = this.channelCount;
        int i11 = remaining / i10;
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.inputBuffer, this.inputFrameCount, i11);
        this.inputBuffer = ensureSpaceForAdditionalFrames;
        shortBuffer.get(ensureSpaceForAdditionalFrames, this.inputFrameCount * this.channelCount, ((i10 * i11) * 2) / 2);
        this.inputFrameCount += i11;
        processStreamInput();
    }
}
