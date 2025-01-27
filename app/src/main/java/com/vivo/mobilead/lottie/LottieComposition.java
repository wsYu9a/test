package com.vivo.mobilead.lottie;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class LottieComposition {
    private Rect bounds;
    private SparseArray<com.vivo.mobilead.lottie.c.d> characters;
    private float endFrame;
    private Map<String, com.vivo.mobilead.lottie.c.c> fonts;
    private float frameRate;
    private boolean hasDashPattern;
    private Map<String, d> images;
    private LongSparseArray<com.vivo.mobilead.lottie.c.c.d> layerMap;
    private List<com.vivo.mobilead.lottie.c.c.d> layers;
    private List<com.vivo.mobilead.lottie.c.h> markers;
    private Map<String, List<com.vivo.mobilead.lottie.c.c.d>> precomps;
    private float startFrame;
    private final i performanceTracker = new i();
    private final HashSet<String> warnings = new HashSet<>();
    private int maskAndMatteCount = 0;

    public void addWarning(String str) {
        com.vivo.mobilead.lottie.f.d.b(str);
        this.warnings.add(str);
    }

    public Rect getBounds() {
        return this.bounds;
    }

    public SparseArray<com.vivo.mobilead.lottie.c.d> getCharacters() {
        return this.characters;
    }

    public float getDuration() {
        return (long) ((getDurationFrames() / this.frameRate) * 1000.0f);
    }

    public float getDurationFrames() {
        return this.endFrame - this.startFrame;
    }

    public float getEndFrame() {
        return this.endFrame;
    }

    public Map<String, com.vivo.mobilead.lottie.c.c> getFonts() {
        return this.fonts;
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public Map<String, d> getImages() {
        return this.images;
    }

    public List<com.vivo.mobilead.lottie.c.c.d> getLayers() {
        return this.layers;
    }

    public com.vivo.mobilead.lottie.c.h getMarker(String str) {
        this.markers.size();
        for (int i2 = 0; i2 < this.markers.size(); i2++) {
            com.vivo.mobilead.lottie.c.h hVar = this.markers.get(i2);
            if (hVar.a(str)) {
                return hVar;
            }
        }
        return null;
    }

    public List<com.vivo.mobilead.lottie.c.h> getMarkers() {
        return this.markers;
    }

    public int getMaskAndMatteCount() {
        return this.maskAndMatteCount;
    }

    public i getPerformanceTracker() {
        return this.performanceTracker;
    }

    public List<com.vivo.mobilead.lottie.c.c.d> getPrecomps(String str) {
        return this.precomps.get(str);
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public ArrayList<String> getWarnings() {
        HashSet<String> hashSet = this.warnings;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    public boolean hasDashPattern() {
        return this.hasDashPattern;
    }

    public boolean hasImages() {
        return !this.images.isEmpty();
    }

    public void incrementMatteOrMaskCount(int i2) {
        this.maskAndMatteCount += i2;
    }

    public void init(Rect rect, float f2, float f3, float f4, List<com.vivo.mobilead.lottie.c.c.d> list, LongSparseArray<com.vivo.mobilead.lottie.c.c.d> longSparseArray, Map<String, List<com.vivo.mobilead.lottie.c.c.d>> map, Map<String, d> map2, SparseArray<com.vivo.mobilead.lottie.c.d> sparseArray, Map<String, com.vivo.mobilead.lottie.c.c> map3, List<com.vivo.mobilead.lottie.c.h> list2) {
        this.bounds = rect;
        this.startFrame = f2;
        this.endFrame = f3;
        this.frameRate = f4;
        this.layers = list;
        this.layerMap = longSparseArray;
        this.precomps = map;
        this.images = map2;
        this.characters = sparseArray;
        this.fonts = map3;
        this.markers = list2;
    }

    public com.vivo.mobilead.lottie.c.c.d layerModelForId(long j2) {
        return this.layerMap.get(j2);
    }

    public void setHasDashPattern(boolean z) {
        this.hasDashPattern = z;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.performanceTracker.a(z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.vivo.mobilead.lottie.c.c.d> it = this.layers.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a("\t"));
        }
        return sb.toString();
    }
}
