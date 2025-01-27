package com.ss.android.socialbase.downloader.network;

/* loaded from: classes4.dex */
class ExponentialGeometricAverage {
    private int mCount;
    private final int mCutover;
    private final double mDecayConstant;
    private double mValue = -1.0d;

    public ExponentialGeometricAverage(double d2) {
        this.mDecayConstant = d2;
        this.mCutover = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public void addMeasurement(double d2) {
        double d3 = 1.0d - this.mDecayConstant;
        int i2 = this.mCount;
        if (i2 > this.mCutover) {
            this.mValue = Math.exp((d3 * Math.log(this.mValue)) + (this.mDecayConstant * Math.log(d2)));
        } else if (i2 > 0) {
            double d4 = i2;
            Double.isNaN(d4);
            double d5 = i2;
            Double.isNaN(d5);
            double d6 = (d3 * d4) / (d5 + 1.0d);
            this.mValue = Math.exp((d6 * Math.log(this.mValue)) + ((1.0d - d6) * Math.log(d2)));
        } else {
            this.mValue = d2;
        }
        this.mCount++;
    }

    public double getAverage() {
        return this.mValue;
    }

    public void reset() {
        this.mValue = -1.0d;
        this.mCount = 0;
    }
}
