package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class FrameSequence implements Serializable {
    private static final AtomicBoolean ISLOADED;
    private int mDefaultLoopCount;
    private int mFrameCount;
    private int mHeight;
    private long mNativeFrameSequence;
    private boolean mOpaque;
    private int mWidth;

    static class State implements Serializable {
        private long mNativeState;

        public State(long j2) {
            this.mNativeState = j2;
        }

        public void destroy() {
            long j2 = this.mNativeState;
            if (j2 != 0) {
                FrameSequence.nativeDestroyState(j2);
                this.mNativeState = 0L;
            }
        }

        public long getFrame(int i2, Bitmap bitmap, int i3) {
            if (bitmap == null || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                throw new IllegalArgumentException("Bitmap passed must be non-null and ARGB_8888");
            }
            long j2 = this.mNativeState;
            if (j2 != 0) {
                return FrameSequence.nativeGetFrame(j2, i2, bitmap, i3);
            }
            throw new IllegalStateException("attempted to draw destroyed FrameSequenceState");
        }
    }

    static {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ISLOADED = atomicBoolean;
        try {
            System.loadLibrary("framesequencev2");
            atomicBoolean.set(true);
        } catch (Throwable unused) {
            ISLOADED.set(false);
        }
    }

    public FrameSequence() {
    }

    private FrameSequence(long j2, int i2, int i3, boolean z, int i4, int i5) {
        this.mNativeFrameSequence = j2;
        this.mWidth = i2;
        this.mHeight = i3;
        this.mOpaque = z;
        this.mFrameCount = i4;
        this.mDefaultLoopCount = i5;
    }

    @Nullable
    public static FrameSequence decodeByteArray(byte[] bArr) {
        if (ISLOADED.get()) {
            return decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    @Nullable
    public static FrameSequence decodeByteArray(byte[] bArr, int i2, int i3) {
        if (!ISLOADED.get()) {
            return null;
        }
        if (bArr == null) {
            throw new IllegalArgumentException();
        }
        if (i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
            throw new IllegalArgumentException("invalid offset/length parameters");
        }
        return nativeDecodeByteArray(bArr, i2, i3);
    }

    @Nullable
    public static FrameSequence decodeByteBuffer(ByteBuffer byteBuffer) {
        if (!ISLOADED.get()) {
            return null;
        }
        if (byteBuffer == null) {
            throw new IllegalArgumentException();
        }
        if (byteBuffer.isDirect()) {
            return nativeDecodeByteBuffer(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
        }
        if (byteBuffer.hasArray()) {
            return decodeByteArray(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
        }
        throw new IllegalArgumentException("Cannot have non-direct ByteBuffer with no byte array");
    }

    @Nullable
    public static FrameSequence decodeStream(InputStream inputStream) {
        if (!ISLOADED.get()) {
            return null;
        }
        if (inputStream != null) {
            return nativeDecodeStream(inputStream, new byte[16384]);
        }
        throw new IllegalArgumentException();
    }

    public static boolean isEnable() {
        return ISLOADED.get();
    }

    private static native long nativeCreateState(long j2);

    private static native FrameSequence nativeDecodeByteArray(byte[] bArr, int i2, int i3);

    private static native FrameSequence nativeDecodeByteBuffer(ByteBuffer byteBuffer, int i2, int i3);

    private static native FrameSequence nativeDecodeStream(InputStream inputStream, byte[] bArr);

    private static native void nativeDestroyFrameSequence(long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestroyState(long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeGetFrame(long j2, int i2, Bitmap bitmap, int i3);

    State createState() {
        long j2 = this.mNativeFrameSequence;
        if (j2 == 0) {
            throw new IllegalStateException("attempted to use incorrectly built FrameSequence");
        }
        long nativeCreateState = nativeCreateState(j2);
        if (nativeCreateState == 0) {
            return null;
        }
        return new State(nativeCreateState);
    }

    public void destroy() {
        long j2 = this.mNativeFrameSequence;
        if (j2 != 0) {
            nativeDestroyFrameSequence(j2);
        }
    }

    public int getDefaultLoopCount() {
        return this.mDefaultLoopCount;
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isOpaque() {
        return this.mOpaque;
    }
}
