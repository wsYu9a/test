package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import l5.c;

/* loaded from: classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private boolean mExtrapolate = true;
    private final double[] mTime;

    public static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent = new double[91];
        boolean linear;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        public Arc(int i10, double d10, double d11, double d12, double d13, double d14, double d15) {
            this.linear = false;
            this.mVertical = i10 == 1;
            this.mTime1 = d10;
            this.mTime2 = d11;
            this.mOneOverDeltaTime = 1.0d / (d11 - d10);
            if (3 == i10) {
                this.linear = true;
            }
            double d16 = d14 - d12;
            double d17 = d15 - d13;
            if (!this.linear && Math.abs(d16) >= EPSILON && Math.abs(d17) >= EPSILON) {
                this.mLut = new double[101];
                boolean z10 = this.mVertical;
                this.mEllipseA = d16 * (z10 ? -1 : 1);
                this.mEllipseB = d17 * (z10 ? 1 : -1);
                this.mEllipseCenterX = z10 ? d14 : d12;
                this.mEllipseCenterY = z10 ? d13 : d15;
                buildTable(d12, d13, d14, d15);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.linear = true;
            this.mX1 = d12;
            this.mX2 = d14;
            this.mY1 = d13;
            this.mY2 = d15;
            double hypot = Math.hypot(d17, d16);
            this.mArcDistance = hypot;
            this.mArcVelocity = hypot * this.mOneOverDeltaTime;
            double d18 = this.mTime2;
            double d19 = this.mTime1;
            this.mEllipseCenterX = d16 / (d18 - d19);
            this.mEllipseCenterY = d17 / (d18 - d19);
        }

        private void buildTable(double d10, double d11, double d12, double d13) {
            double d14;
            double d15 = d12 - d10;
            double d16 = d11 - d13;
            int i10 = 0;
            double d17 = c.f27899e;
            double d18 = c.f27899e;
            double d19 = c.f27899e;
            while (true) {
                if (i10 >= ourPercent.length) {
                    break;
                }
                double d20 = d17;
                double radians = Math.toRadians((i10 * 90.0d) / (r15.length - 1));
                double sin = Math.sin(radians) * d15;
                double cos = Math.cos(radians) * d16;
                if (i10 > 0) {
                    d14 = Math.hypot(sin - d18, cos - d19) + d20;
                    ourPercent[i10] = d14;
                } else {
                    d14 = d20;
                }
                i10++;
                d19 = cos;
                d17 = d14;
                d18 = sin;
            }
            double d21 = d17;
            this.mArcDistance = d21;
            int i11 = 0;
            while (true) {
                double[] dArr = ourPercent;
                if (i11 >= dArr.length) {
                    break;
                }
                dArr[i11] = dArr[i11] / d21;
                i11++;
            }
            int i12 = 0;
            while (true) {
                if (i12 >= this.mLut.length) {
                    return;
                }
                double length = i12 / (r1.length - 1);
                int binarySearch = Arrays.binarySearch(ourPercent, length);
                if (binarySearch >= 0) {
                    this.mLut[i12] = binarySearch / (ourPercent.length - 1);
                } else if (binarySearch == -1) {
                    this.mLut[i12] = 0.0d;
                } else {
                    int i13 = -binarySearch;
                    int i14 = i13 - 2;
                    double[] dArr2 = ourPercent;
                    double d22 = dArr2[i14];
                    this.mLut[i12] = (i14 + ((length - d22) / (dArr2[i13 - 1] - d22))) / (dArr2.length - 1);
                }
                i12++;
            }
        }

        public double getDX() {
            double d10 = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d10, (-this.mEllipseB) * this.mTmpSinAngle);
            if (this.mVertical) {
                d10 = -d10;
            }
            return d10 * hypot;
        }

        public double getDY() {
            double d10 = this.mEllipseA * this.mTmpCosAngle;
            double d11 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d10, d11);
            return this.mVertical ? (-d11) * hypot : d11 * hypot;
        }

        public double getLinearDX(double d10) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d10) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d10) {
            double d11 = (d10 - this.mTime1) * this.mOneOverDeltaTime;
            double d12 = this.mX1;
            return d12 + (d11 * (this.mX2 - d12));
        }

        public double getLinearY(double d10) {
            double d11 = (d10 - this.mTime1) * this.mOneOverDeltaTime;
            double d12 = this.mY1;
            return d12 + (d11 * (this.mY2 - d12));
        }

        public double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        public double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        public double lookup(double d10) {
            if (d10 <= c.f27899e) {
                return c.f27899e;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d10 * (dArr.length - 1);
            int i10 = (int) length;
            double d11 = length - i10;
            double d12 = dArr[i10];
            return d12 + (d11 * (dArr[i10 + 1] - d12));
        }

        public void setPoint(double d10) {
            double lookup = lookup((this.mVertical ? this.mTime2 - d10 : d10 - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i10 = 0;
        int i11 = 1;
        int i12 = 1;
        while (true) {
            Arc[] arcArr = this.mArcs;
            if (i10 >= arcArr.length) {
                return;
            }
            int i13 = iArr[i10];
            if (i13 == 0) {
                i12 = 3;
            } else if (i13 == 1) {
                i11 = 1;
                i12 = 1;
            } else if (i13 == 2) {
                i11 = 2;
                i12 = 2;
            } else if (i13 == 3) {
                i11 = i11 == 1 ? 2 : 1;
                i12 = i11;
            }
            double d10 = dArr[i10];
            int i14 = i10 + 1;
            double d11 = dArr[i14];
            double[] dArr3 = dArr2[i10];
            double d12 = dArr3[0];
            double d13 = dArr3[1];
            double[] dArr4 = dArr2[i14];
            arcArr[i10] = new Arc(i12, d10, d11, d12, d13, dArr4[0], dArr4[1]);
            i10 = i14;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d10, double[] dArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d11 = arc.mTime1;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (arc.linear) {
                    dArr[0] = arc.getLinearX(d11) + (this.mArcs[0].getLinearDX(d11) * d12);
                    dArr[1] = this.mArcs[0].getLinearY(d11) + (d12 * this.mArcs[0].getLinearDY(d11));
                    return;
                } else {
                    arc.setPoint(d11);
                    dArr[0] = this.mArcs[0].getX() + (this.mArcs[0].getDX() * d12);
                    dArr[1] = this.mArcs[0].getY() + (d12 * this.mArcs[0].getDY());
                    return;
                }
            }
            if (d10 > arcArr[arcArr.length - 1].mTime2) {
                double d13 = arcArr[arcArr.length - 1].mTime2;
                double d14 = d10 - d13;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.linear) {
                    dArr[0] = arc2.getLinearX(d13) + (this.mArcs[length].getLinearDX(d13) * d14);
                    dArr[1] = this.mArcs[length].getLinearY(d13) + (d14 * this.mArcs[length].getLinearDY(d13));
                    return;
                } else {
                    arc2.setPoint(d10);
                    dArr[0] = this.mArcs[length].getX() + (this.mArcs[length].getDX() * d14);
                    dArr[1] = this.mArcs[length].getY() + (d14 * this.mArcs[length].getDY());
                    return;
                }
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d15 = arcArr2[0].mTime1;
            if (d10 < d15) {
                d10 = d15;
            }
            if (d10 > arcArr2[arcArr2.length - 1].mTime2) {
                d10 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i10 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i10 >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i10];
            if (d10 <= arc3.mTime2) {
                if (arc3.linear) {
                    dArr[0] = arc3.getLinearX(d10);
                    dArr[1] = this.mArcs[i10].getLinearY(d10);
                    return;
                } else {
                    arc3.setPoint(d10);
                    dArr[0] = this.mArcs[i10].getX();
                    dArr[1] = this.mArcs[i10].getY();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d10, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d11 = arcArr[0].mTime1;
        if (d10 < d11) {
            d10 = d11;
        } else if (d10 > arcArr[arcArr.length - 1].mTime2) {
            d10 = arcArr[arcArr.length - 1].mTime2;
        }
        int i10 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i10 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i10];
            if (d10 <= arc.mTime2) {
                if (arc.linear) {
                    dArr[0] = arc.getLinearDX(d10);
                    dArr[1] = this.mArcs[i10].getLinearDY(d10);
                    return;
                } else {
                    arc.setPoint(d10);
                    dArr[0] = this.mArcs[i10].getDX();
                    dArr[1] = this.mArcs[i10].getDY();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d10, int i10) {
        Arc[] arcArr = this.mArcs;
        int i11 = 0;
        double d11 = arcArr[0].mTime1;
        if (d10 < d11) {
            d10 = d11;
        }
        if (d10 > arcArr[arcArr.length - 1].mTime2) {
            d10 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i11 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i11];
            if (d10 <= arc.mTime2) {
                if (arc.linear) {
                    if (i10 == 0) {
                        return arc.getLinearDX(d10);
                    }
                    return arc.getLinearDY(d10);
                }
                arc.setPoint(d10);
                if (i10 == 0) {
                    return this.mArcs[i11].getDX();
                }
                return this.mArcs[i11].getDY();
            }
            i11++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d10, float[] fArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d11 = arc.mTime1;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (arc.linear) {
                    fArr[0] = (float) (arc.getLinearX(d11) + (this.mArcs[0].getLinearDX(d11) * d12));
                    fArr[1] = (float) (this.mArcs[0].getLinearY(d11) + (d12 * this.mArcs[0].getLinearDY(d11)));
                    return;
                } else {
                    arc.setPoint(d11);
                    fArr[0] = (float) (this.mArcs[0].getX() + (this.mArcs[0].getDX() * d12));
                    fArr[1] = (float) (this.mArcs[0].getY() + (d12 * this.mArcs[0].getDY()));
                    return;
                }
            }
            if (d10 > arcArr[arcArr.length - 1].mTime2) {
                double d13 = arcArr[arcArr.length - 1].mTime2;
                double d14 = d10 - d13;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.linear) {
                    fArr[0] = (float) (arc2.getLinearX(d13) + (this.mArcs[length].getLinearDX(d13) * d14));
                    fArr[1] = (float) (this.mArcs[length].getLinearY(d13) + (d14 * this.mArcs[length].getLinearDY(d13)));
                    return;
                } else {
                    arc2.setPoint(d10);
                    fArr[0] = (float) this.mArcs[length].getX();
                    fArr[1] = (float) this.mArcs[length].getY();
                    return;
                }
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d15 = arcArr2[0].mTime1;
            if (d10 < d15) {
                d10 = d15;
            } else if (d10 > arcArr2[arcArr2.length - 1].mTime2) {
                d10 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i10 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i10 >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i10];
            if (d10 <= arc3.mTime2) {
                if (arc3.linear) {
                    fArr[0] = (float) arc3.getLinearX(d10);
                    fArr[1] = (float) this.mArcs[i10].getLinearY(d10);
                    return;
                } else {
                    arc3.setPoint(d10);
                    fArr[0] = (float) this.mArcs[i10].getX();
                    fArr[1] = (float) this.mArcs[i10].getY();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d10, int i10) {
        double linearY;
        double linearDY;
        double y10;
        double dy;
        double linearY2;
        double linearDY2;
        int i11 = 0;
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d11 = arc.mTime1;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (arc.linear) {
                    if (i10 == 0) {
                        linearY2 = arc.getLinearX(d11);
                        linearDY2 = this.mArcs[0].getLinearDX(d11);
                    } else {
                        linearY2 = arc.getLinearY(d11);
                        linearDY2 = this.mArcs[0].getLinearDY(d11);
                    }
                    return linearY2 + (d12 * linearDY2);
                }
                arc.setPoint(d11);
                if (i10 == 0) {
                    y10 = this.mArcs[0].getX();
                    dy = this.mArcs[0].getDX();
                } else {
                    y10 = this.mArcs[0].getY();
                    dy = this.mArcs[0].getDY();
                }
                return y10 + (d12 * dy);
            }
            if (d10 > arcArr[arcArr.length - 1].mTime2) {
                double d13 = arcArr[arcArr.length - 1].mTime2;
                double d14 = d10 - d13;
                int length = arcArr.length - 1;
                if (i10 == 0) {
                    linearY = arcArr[length].getLinearX(d13);
                    linearDY = this.mArcs[length].getLinearDX(d13);
                } else {
                    linearY = arcArr[length].getLinearY(d13);
                    linearDY = this.mArcs[length].getLinearDY(d13);
                }
                return linearY + (d14 * linearDY);
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d15 = arcArr2[0].mTime1;
            if (d10 < d15) {
                d10 = d15;
            } else if (d10 > arcArr2[arcArr2.length - 1].mTime2) {
                d10 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i11 >= arcArr3.length) {
                return Double.NaN;
            }
            Arc arc2 = arcArr3[i11];
            if (d10 <= arc2.mTime2) {
                if (arc2.linear) {
                    if (i10 == 0) {
                        return arc2.getLinearX(d10);
                    }
                    return arc2.getLinearY(d10);
                }
                arc2.setPoint(d10);
                if (i10 == 0) {
                    return this.mArcs[i11].getX();
                }
                return this.mArcs[i11].getY();
            }
            i11++;
        }
    }
}
