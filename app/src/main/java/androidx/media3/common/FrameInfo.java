package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
/* loaded from: classes.dex */
public class FrameInfo {
    public final int height;
    public final long offsetToAddUs;
    public final float pixelWidthHeightRatio;
    public final int width;

    public /* synthetic */ FrameInfo(int i10, int i11, float f10, long j10, AnonymousClass1 anonymousClass1) {
        this(i10, i11, f10, j10);
    }

    private FrameInfo(int i10, int i11, float f10, long j10) {
        Assertions.checkArgument(i10 > 0, "width must be positive, but is: " + i10);
        Assertions.checkArgument(i11 > 0, "height must be positive, but is: " + i11);
        this.width = i10;
        this.height = i11;
        this.pixelWidthHeightRatio = f10;
        this.offsetToAddUs = j10;
    }

    public static final class Builder {
        private int height;
        private long offsetToAddUs;
        private float pixelWidthHeightRatio;
        private int width;

        public Builder(int i10, int i11) {
            this.width = i10;
            this.height = i11;
            this.pixelWidthHeightRatio = 1.0f;
        }

        public FrameInfo build() {
            return new FrameInfo(this.width, this.height, this.pixelWidthHeightRatio, this.offsetToAddUs);
        }

        @CanIgnoreReturnValue
        public Builder setHeight(int i10) {
            this.height = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setOffsetToAddUs(long j10) {
            this.offsetToAddUs = j10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPixelWidthHeightRatio(float f10) {
            this.pixelWidthHeightRatio = f10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setWidth(int i10) {
            this.width = i10;
            return this;
        }

        public Builder(FrameInfo frameInfo) {
            this.width = frameInfo.width;
            this.height = frameInfo.height;
            this.pixelWidthHeightRatio = frameInfo.pixelWidthHeightRatio;
            this.offsetToAddUs = frameInfo.offsetToAddUs;
        }
    }
}
