package com.kwad.sdk.core.imageloader.core.assist;

import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes2.dex */
public class ImageSize {
    private static final String SEPARATOR = "x";
    private static final int TO_STRING_MAX_LENGHT = 9;
    private final int height;
    private final int width;

    public ImageSize(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    public ImageSize(int i2, int i3, int i4) {
        if (i4 % TinkerReport.KEY_APPLIED_VERSION_CHECK == 0) {
            this.width = i2;
            this.height = i3;
        } else {
            this.width = i3;
            this.height = i2;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public ImageSize scale(float f2) {
        return new ImageSize((int) (this.width * f2), (int) (this.height * f2));
    }

    public ImageSize scaleDown(int i2) {
        return new ImageSize(this.width / i2, this.height / i2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.width);
        sb.append(SEPARATOR);
        sb.append(this.height);
        return sb.toString();
    }
}
