package com.vivo.google.android.exoplayer3;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.vivo.google.android.exoplayer3.source.TrackGroupArray;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelection;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelectionArray;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelector;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class h5 extends TrackSelector {
    public a currentMappedTrackInfo;
    public final SparseArray<Map<TrackGroupArray, b>> selectionOverrides = new SparseArray<>();
    public final SparseBooleanArray rendererDisabledFlags = new SparseBooleanArray();
    public int tunnelingAudioSessionId = 0;

    public static final class a {
        public a(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            int length = trackGroupArrayArr.length;
        }
    }

    public static final class b {
    }

    public static int findRenderer(g[] gVarArr, s3 s3Var) {
        int length = gVarArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < gVarArr.length; i3++) {
            g gVar = gVarArr[i3];
            for (int i4 = 0; i4 < s3Var.f28044a; i4++) {
                int supportsFormat = gVar.supportsFormat(s3Var.f28045b[i4]) & 3;
                if (supportsFormat > i2) {
                    if (supportsFormat == 3) {
                        return i3;
                    }
                    length = i3;
                    i2 = supportsFormat;
                }
            }
        }
        return length;
    }

    public static int[] getFormatSupport(g gVar, s3 s3Var) {
        int[] iArr = new int[s3Var.f28044a];
        for (int i2 = 0; i2 < s3Var.f28044a; i2++) {
            iArr[i2] = gVar.supportsFormat(s3Var.f28045b[i2]);
        }
        return iArr;
    }

    public static int[] getMixedMimeTypeAdaptationSupport(g[] gVarArr) {
        int length = gVarArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = gVarArr[i2].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    public static void maybeConfigureRenderersForTunneling(g[] gVarArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr, h[] hVarArr, TrackSelection[] trackSelectionArr, int i2) {
        boolean z;
        if (i2 == 0) {
            return;
        }
        boolean z2 = false;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < gVarArr.length; i5++) {
            int trackType = gVarArr[i5].getTrackType();
            TrackSelection trackSelection = trackSelectionArr[i5];
            if ((trackType == 1 || trackType == 2) && trackSelection != null && rendererSupportsTunneling(iArr[i5], trackGroupArrayArr[i5], trackSelection)) {
                if (trackType == 1) {
                    if (i4 != -1) {
                        z = false;
                        break;
                    }
                    i4 = i5;
                } else {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i5;
                }
            }
        }
        z = true;
        if (i4 != -1 && i3 != -1) {
            z2 = true;
        }
        if (z && z2) {
            h hVar = new h(i2);
            hVarArr[i4] = hVar;
            hVarArr[i3] = hVar;
        }
    }

    public static boolean rendererSupportsTunneling(int[][] iArr, TrackGroupArray trackGroupArray, TrackSelection trackSelection) {
        if (trackSelection == null) {
            return false;
        }
        int indexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
        for (int i2 = 0; i2 < trackSelection.length(); i2++) {
            if ((iArr[indexOf][trackSelection.getIndexInTrackGroup(i2)] & 16) != 16) {
                return false;
            }
        }
        return true;
    }

    public final void clearSelectionOverride(int i2, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, b> map = this.selectionOverrides.get(i2);
        if (map == null || !map.containsKey(trackGroupArray)) {
            return;
        }
        map.remove(trackGroupArray);
        if (map.isEmpty()) {
            this.selectionOverrides.remove(i2);
        }
        invalidate();
    }

    public final void clearSelectionOverrides() {
        if (this.selectionOverrides.size() == 0) {
            return;
        }
        this.selectionOverrides.clear();
        invalidate();
    }

    public final void clearSelectionOverrides(int i2) {
        Map<TrackGroupArray, b> map = this.selectionOverrides.get(i2);
        if (map == null || map.isEmpty()) {
            return;
        }
        this.selectionOverrides.remove(i2);
        invalidate();
    }

    public final a getCurrentMappedTrackInfo() {
        return this.currentMappedTrackInfo;
    }

    public final boolean getRendererDisabled(int i2) {
        return this.rendererDisabledFlags.get(i2);
    }

    public final b getSelectionOverride(int i2, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, b> map = this.selectionOverrides.get(i2);
        if (map != null) {
            return map.get(trackGroupArray);
        }
        return null;
    }

    public final boolean hasSelectionOverride(int i2, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, b> map = this.selectionOverrides.get(i2);
        return map != null && map.containsKey(trackGroupArray);
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelector
    public final void onSelectionActivated(Object obj) {
        this.currentMappedTrackInfo = (a) obj;
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelector
    public final i5 selectTracks(g[] gVarArr, TrackGroupArray trackGroupArray) {
        int[] iArr = new int[gVarArr.length + 1];
        int length = gVarArr.length + 1;
        s3[][] s3VarArr = new s3[length][];
        int[][][] iArr2 = new int[gVarArr.length + 1][][];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = trackGroupArray.length;
            s3VarArr[i2] = new s3[i3];
            iArr2[i2] = new int[i3][];
        }
        int[] mixedMimeTypeAdaptationSupport = getMixedMimeTypeAdaptationSupport(gVarArr);
        for (int i4 = 0; i4 < trackGroupArray.length; i4++) {
            s3 s3Var = trackGroupArray.get(i4);
            int findRenderer = findRenderer(gVarArr, s3Var);
            int[] formatSupport = findRenderer == gVarArr.length ? new int[s3Var.f28044a] : getFormatSupport(gVarArr[findRenderer], s3Var);
            int i5 = iArr[findRenderer];
            s3VarArr[findRenderer][i5] = s3Var;
            iArr2[findRenderer][i5] = formatSupport;
            iArr[findRenderer] = iArr[findRenderer] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[gVarArr.length];
        int[] iArr3 = new int[gVarArr.length];
        for (int i6 = 0; i6 < gVarArr.length; i6++) {
            int i7 = iArr[i6];
            trackGroupArrayArr[i6] = new TrackGroupArray((s3[]) Arrays.copyOf(s3VarArr[i6], i7));
            iArr2[i6] = (int[][]) Arrays.copyOf(iArr2[i6], i7);
            iArr3[i6] = gVarArr[i6].getTrackType();
        }
        TrackGroupArray trackGroupArray2 = new TrackGroupArray((s3[]) Arrays.copyOf(s3VarArr[gVarArr.length], iArr[gVarArr.length]));
        TrackSelection[] selectTracks = selectTracks(gVarArr, trackGroupArrayArr, iArr2);
        for (int i8 = 0; i8 < gVarArr.length; i8++) {
            if (this.rendererDisabledFlags.get(i8)) {
                selectTracks[i8] = null;
            } else {
                TrackGroupArray trackGroupArray3 = trackGroupArrayArr[i8];
                if (!hasSelectionOverride(i8, trackGroupArray3)) {
                    continue;
                } else {
                    if (this.selectionOverrides.get(i8).get(trackGroupArray3) != null) {
                        trackGroupArray3.get(0);
                        throw null;
                    }
                    selectTracks[i8] = null;
                }
            }
        }
        a aVar = new a(iArr3, trackGroupArrayArr, mixedMimeTypeAdaptationSupport, iArr2, trackGroupArray2);
        h[] hVarArr = new h[gVarArr.length];
        for (int i9 = 0; i9 < gVarArr.length; i9++) {
            hVarArr[i9] = selectTracks[i9] != null ? h.f27448b : null;
        }
        maybeConfigureRenderersForTunneling(gVarArr, trackGroupArrayArr, iArr2, hVarArr, selectTracks, this.tunnelingAudioSessionId);
        return new i5(trackGroupArray, new TrackSelectionArray(selectTracks), aVar, hVarArr);
    }

    public abstract TrackSelection[] selectTracks(g[] gVarArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr);

    public final void setRendererDisabled(int i2, boolean z) {
        if (this.rendererDisabledFlags.get(i2) == z) {
            return;
        }
        this.rendererDisabledFlags.put(i2, z);
        invalidate();
    }

    public final void setSelectionOverride(int i2, TrackGroupArray trackGroupArray, b bVar) {
        Map<TrackGroupArray, b> map = this.selectionOverrides.get(i2);
        if (map == null) {
            map = new HashMap<>();
            this.selectionOverrides.put(i2, map);
        }
        if (map.containsKey(trackGroupArray) && Util.areEqual(map.get(trackGroupArray), bVar)) {
            return;
        }
        map.put(trackGroupArray, bVar);
        invalidate();
    }

    public void setTunnelingAudioSessionId(int i2) {
        if (this.tunnelingAudioSessionId != i2) {
            this.tunnelingAudioSessionId = i2;
            invalidate();
        }
    }
}
