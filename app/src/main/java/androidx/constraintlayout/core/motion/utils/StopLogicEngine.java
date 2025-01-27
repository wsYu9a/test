package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class StopLogicEngine implements StopEngine {
    private static final float EPSILON = 1.0E-5f;
    private boolean mBackwards = false;
    private boolean mDone = false;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f10) {
        this.mDone = false;
        float f11 = this.mStage1Duration;
        if (f10 <= f11) {
            float f12 = this.mStage1Velocity;
            return (f12 * f10) + ((((this.mStage2Velocity - f12) * f10) * f10) / (f11 * 2.0f));
        }
        int i10 = this.mNumberOfStages;
        if (i10 == 1) {
            return this.mStage1EndPosition;
        }
        float f13 = f10 - f11;
        float f14 = this.mStage2Duration;
        if (f13 < f14) {
            float f15 = this.mStage1EndPosition;
            float f16 = this.mStage2Velocity;
            return f15 + (f16 * f13) + ((((this.mStage3Velocity - f16) * f13) * f13) / (f14 * 2.0f));
        }
        if (i10 == 2) {
            return this.mStage2EndPosition;
        }
        float f17 = f13 - f14;
        float f18 = this.mStage3Duration;
        if (f17 > f18) {
            this.mDone = true;
            return this.mStage3EndPosition;
        }
        float f19 = this.mStage2EndPosition;
        float f20 = this.mStage3Velocity;
        return (f19 + (f20 * f17)) - (((f20 * f17) * f17) / (f18 * 2.0f));
    }

    private void setup(float f10, float f11, float f12, float f13, float f14) {
        this.mDone = false;
        if (f10 == 0.0f) {
            f10 = 1.0E-4f;
        }
        this.mStage1Velocity = f10;
        float f15 = f10 / f12;
        float f16 = (f15 * f10) / 2.0f;
        if (f10 < 0.0f) {
            float sqrt = (float) Math.sqrt((f11 - ((((-f10) / f12) * f10) / 2.0f)) * f12);
            if (sqrt < f13) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f10;
                this.mStage2Velocity = sqrt;
                this.mStage3Velocity = 0.0f;
                float f17 = (sqrt - f10) / f12;
                this.mStage1Duration = f17;
                this.mStage2Duration = sqrt / f12;
                this.mStage1EndPosition = ((f10 + sqrt) * f17) / 2.0f;
                this.mStage2EndPosition = f11;
                this.mStage3EndPosition = f11;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f10;
            this.mStage2Velocity = f13;
            this.mStage3Velocity = f13;
            float f18 = (f13 - f10) / f12;
            this.mStage1Duration = f18;
            float f19 = f13 / f12;
            this.mStage3Duration = f19;
            float f20 = ((f10 + f13) * f18) / 2.0f;
            float f21 = (f19 * f13) / 2.0f;
            this.mStage2Duration = ((f11 - f20) - f21) / f13;
            this.mStage1EndPosition = f20;
            this.mStage2EndPosition = f11 - f21;
            this.mStage3EndPosition = f11;
            return;
        }
        if (f16 >= f11) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f10;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f11;
            this.mStage1Duration = (2.0f * f11) / f10;
            return;
        }
        float f22 = f11 - f16;
        float f23 = f22 / f10;
        if (f23 + f15 < f14) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f10;
            this.mStage2Velocity = f10;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f22;
            this.mStage2EndPosition = f11;
            this.mStage1Duration = f23;
            this.mStage2Duration = f15;
            return;
        }
        float sqrt2 = (float) Math.sqrt((f12 * f11) + ((f10 * f10) / 2.0f));
        float f24 = (sqrt2 - f10) / f12;
        this.mStage1Duration = f24;
        float f25 = sqrt2 / f12;
        this.mStage2Duration = f25;
        if (sqrt2 < f13) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f10;
            this.mStage2Velocity = sqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f24;
            this.mStage2Duration = f25;
            this.mStage1EndPosition = ((f10 + sqrt2) * f24) / 2.0f;
            this.mStage2EndPosition = f11;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f10;
        this.mStage2Velocity = f13;
        this.mStage3Velocity = f13;
        float f26 = (f13 - f10) / f12;
        this.mStage1Duration = f26;
        float f27 = f13 / f12;
        this.mStage3Duration = f27;
        float f28 = ((f10 + f13) * f26) / 2.0f;
        float f29 = (f27 * f13) / 2.0f;
        this.mStage2Duration = ((f11 - f28) - f29) / f13;
        this.mStage1EndPosition = f28;
        this.mStage2EndPosition = f11 - f29;
        this.mStage3EndPosition = f11;
    }

    public void config(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.mDone = false;
        this.mStartPosition = f10;
        boolean z10 = f10 > f11;
        this.mBackwards = z10;
        if (z10) {
            setup(-f12, f10 - f11, f14, f15, f13);
        } else {
            setup(f12, f11 - f10, f14, f15, f13);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f10) {
        String str2 = str + " ===== " + this.mType + "\n";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        sb2.append(this.mBackwards ? "backwards" : "forward ");
        sb2.append(" time = ");
        sb2.append(f10);
        sb2.append("  stages ");
        sb2.append(this.mNumberOfStages);
        sb2.append("\n");
        String str3 = sb2.toString() + str + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition + "\n";
        if (this.mNumberOfStages > 1) {
            str3 = str3 + str + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition + "\n";
        }
        if (this.mNumberOfStages > 2) {
            str3 = str3 + str + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition + "\n";
        }
        float f11 = this.mStage1Duration;
        if (f10 <= f11) {
            return str3 + str + "stage 0\n";
        }
        int i10 = this.mNumberOfStages;
        if (i10 == 1) {
            return str3 + str + "end stage 0\n";
        }
        float f12 = f10 - f11;
        float f13 = this.mStage2Duration;
        if (f12 < f13) {
            return str3 + str + " stage 1\n";
        }
        if (i10 == 2) {
            return str3 + str + "end stage 1\n";
        }
        if (f12 - f13 < this.mStage3Duration) {
            return str3 + str + " stage 2\n";
        }
        return str3 + str + " end stage 2\n";
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f10) {
        float calcY = calcY(f10);
        this.mLastPosition = f10;
        return this.mBackwards ? this.mStartPosition - calcY : this.mStartPosition + calcY;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f10) {
        float f11 = this.mStage1Duration;
        if (f10 <= f11) {
            float f12 = this.mStage1Velocity;
            return f12 + (((this.mStage2Velocity - f12) * f10) / f11);
        }
        int i10 = this.mNumberOfStages;
        if (i10 == 1) {
            return 0.0f;
        }
        float f13 = f10 - f11;
        float f14 = this.mStage2Duration;
        if (f13 < f14) {
            float f15 = this.mStage2Velocity;
            return f15 + (((this.mStage3Velocity - f15) * f13) / f14);
        }
        if (i10 == 2) {
            return this.mStage2EndPosition;
        }
        float f16 = f13 - f14;
        float f17 = this.mStage3Duration;
        if (f16 >= f17) {
            return this.mStage3EndPosition;
        }
        float f18 = this.mStage3Velocity;
        return f18 - ((f16 * f18) / f17);
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        return getVelocity() < EPSILON && Math.abs(this.mStage3EndPosition - this.mLastPosition) < EPSILON;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastPosition) : getVelocity(this.mLastPosition);
    }
}
