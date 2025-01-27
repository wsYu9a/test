package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes.dex */
public final class GlTextureInfo {
    public static final GlTextureInfo UNSET = new GlTextureInfo(-1, -1, -1, -1, -1);
    private final int fboId;
    private final int height;
    private boolean isReleased;
    private final int rboId;
    private final int texId;
    private final int width;

    public GlTextureInfo(int i10, int i11, int i12, int i13, int i14) {
        this.texId = i10;
        this.fboId = i11;
        this.rboId = i12;
        this.width = i13;
        this.height = i14;
    }

    public int getFboId() {
        Assertions.checkState(!this.isReleased);
        return this.fboId;
    }

    public int getHeight() {
        Assertions.checkState(!this.isReleased);
        return this.height;
    }

    public int getRboId() {
        Assertions.checkState(!this.isReleased);
        return this.rboId;
    }

    public int getTexId() {
        Assertions.checkState(!this.isReleased);
        return this.texId;
    }

    public int getWidth() {
        Assertions.checkState(!this.isReleased);
        return this.width;
    }

    public void release() throws GlUtil.GlException {
        this.isReleased = true;
        int i10 = this.texId;
        if (i10 != -1) {
            GlUtil.deleteTexture(i10);
        }
        int i11 = this.fboId;
        if (i11 != -1) {
            GlUtil.deleteFbo(i11);
        }
        int i12 = this.rboId;
        if (i12 != -1) {
            GlUtil.deleteRbo(i12);
        }
    }
}
