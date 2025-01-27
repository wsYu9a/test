package com.alimm.tanx.ui.image.glide.gifdecoder;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GifHeader {
    public static final int NETSCAPE_LOOP_COUNT_DOES_NOT_EXIST = -1;
    public static final int NETSCAPE_LOOP_COUNT_FOREVER = 0;
    int bgColor;
    int bgIndex;
    GifFrame currentFrame;
    boolean gctFlag;
    int gctSize;
    int height;
    int pixelAspect;
    int width;
    int[] gct = null;
    int status = 0;
    int frameCount = 0;
    List<GifFrame> frames = new ArrayList();
    int loopCount = -1;

    public int getHeight() {
        return this.height;
    }

    public int getNumFrames() {
        return this.frameCount;
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.width;
    }
}
