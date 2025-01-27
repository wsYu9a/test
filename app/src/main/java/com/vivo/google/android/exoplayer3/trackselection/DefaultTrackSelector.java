package com.vivo.google.android.exoplayer3.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import com.vivo.google.android.exoplayer3.Format;
import com.vivo.google.android.exoplayer3.g;
import com.vivo.google.android.exoplayer3.g5;
import com.vivo.google.android.exoplayer3.h5;
import com.vivo.google.android.exoplayer3.m5;
import com.vivo.google.android.exoplayer3.s3;
import com.vivo.google.android.exoplayer3.source.TrackGroupArray;
import com.vivo.google.android.exoplayer3.trackselection.AdaptiveTrackSelection;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelection;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public class DefaultTrackSelector extends h5 {
    public static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    public static final int[] NO_TRACKS = new int[0];
    public static final int WITHIN_RENDERER_CAPABILITIES_BONUS = 1000;
    public final TrackSelection.Factory adaptiveTrackSelectionFactory;
    public final AtomicReference<Parameters> paramsReference;

    public static final class Parameters {
        public final boolean allowMixedMimeAdaptiveness;
        public final boolean allowNonSeamlessAdaptiveness;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final int maxVideoBitrate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        public final boolean orientationMayChange;
        public final String preferredAudioLanguage;
        public final String preferredTextLanguage;
        public final int viewportHeight;
        public final int viewportWidth;

        public Parameters() {
            this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public Parameters(String str, String str2, boolean z, boolean z2, int i2, int i3, int i4, boolean z3, boolean z4, int i5, int i6, boolean z5) {
            this.preferredAudioLanguage = str;
            this.preferredTextLanguage = str2;
            this.allowMixedMimeAdaptiveness = z;
            this.allowNonSeamlessAdaptiveness = z2;
            this.maxVideoWidth = i2;
            this.maxVideoHeight = i3;
            this.maxVideoBitrate = i4;
            this.exceedVideoConstraintsIfNecessary = z3;
            this.exceedRendererCapabilitiesIfNecessary = z4;
            this.viewportWidth = i5;
            this.viewportHeight = i6;
            this.orientationMayChange = z5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return this.allowMixedMimeAdaptiveness == parameters.allowMixedMimeAdaptiveness && this.allowNonSeamlessAdaptiveness == parameters.allowNonSeamlessAdaptiveness && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.orientationMayChange == parameters.orientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxVideoBitrate == parameters.maxVideoBitrate && TextUtils.equals(this.preferredAudioLanguage, parameters.preferredAudioLanguage) && TextUtils.equals(this.preferredTextLanguage, parameters.preferredTextLanguage);
        }

        public int hashCode() {
            return (((((((((((((((((((((this.preferredAudioLanguage.hashCode() * 31) + this.preferredTextLanguage.hashCode()) * 31) + (this.allowMixedMimeAdaptiveness ? 1 : 0)) * 31) + (this.allowNonSeamlessAdaptiveness ? 1 : 0)) * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + this.maxVideoBitrate) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.orientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
        }

        public Parameters withAllowMixedMimeAdaptiveness(boolean z) {
            return z == this.allowMixedMimeAdaptiveness ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, z, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withAllowNonSeamlessAdaptiveness(boolean z) {
            return z == this.allowNonSeamlessAdaptiveness ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, z, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withExceedRendererCapabilitiesIfNecessary(boolean z) {
            return z == this.exceedRendererCapabilitiesIfNecessary ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, z, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withExceedVideoConstraintsIfNecessary(boolean z) {
            return z == this.exceedVideoConstraintsIfNecessary ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, z, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withMaxVideoBitrate(int i2) {
            return i2 == this.maxVideoBitrate ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, i2, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withMaxVideoSize(int i2, int i3) {
            if (i2 == this.maxVideoWidth && i3 == this.maxVideoHeight) {
                return this;
            }
            return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, i2, i3, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withMaxVideoSizeSd() {
            return withMaxVideoSize(1279, 719);
        }

        public Parameters withPreferredAudioLanguage(String str) {
            String normalizeLanguageCode = Util.normalizeLanguageCode(str);
            return TextUtils.equals(normalizeLanguageCode, this.preferredAudioLanguage) ? this : new Parameters(normalizeLanguageCode, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withPreferredTextLanguage(String str) {
            String normalizeLanguageCode = Util.normalizeLanguageCode(str);
            return TextUtils.equals(normalizeLanguageCode, this.preferredTextLanguage) ? this : new Parameters(this.preferredAudioLanguage, normalizeLanguageCode, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withViewportSize(int i2, int i3, boolean z) {
            if (i2 == this.viewportWidth && i3 == this.viewportHeight) {
                if (z == this.orientationMayChange) {
                    return this;
                }
                return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, i2, i3, z);
            }
            return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, i2, i3, z);
        }

        public Parameters withViewportSizeFromContext(Context context, boolean z) {
            Point physicalDisplaySize = Util.getPhysicalDisplaySize(context);
            return withViewportSize(physicalDisplaySize.x, physicalDisplaySize.y, z);
        }

        public Parameters withoutVideoSizeConstraints() {
            return withMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public Parameters withoutViewportSizeConstraints() {
            return withViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }
    }

    public static final class a {

        /* renamed from: a */
        public final int f28117a;

        /* renamed from: b */
        public final int f28118b;

        /* renamed from: c */
        public final String f28119c;

        public a(int i2, int i3, String str) {
            this.f28117a = i2;
            this.f28118b = i3;
            this.f28119c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f28117a == aVar.f28117a && this.f28118b == aVar.f28118b && TextUtils.equals(this.f28119c, aVar.f28119c);
        }

        public int hashCode() {
            int i2 = ((this.f28117a * 31) + this.f28118b) * 31;
            String str = this.f28119c;
            return i2 + (str != null ? str.hashCode() : 0);
        }
    }

    public DefaultTrackSelector() {
        this((TrackSelection.Factory) null);
    }

    public DefaultTrackSelector(m5 m5Var) {
        this(new AdaptiveTrackSelection.Factory(m5Var));
    }

    public DefaultTrackSelector(TrackSelection.Factory factory) {
        this.adaptiveTrackSelectionFactory = factory;
        this.paramsReference = new AtomicReference<>(new Parameters());
    }

    public static int compareFormatValues(int i2, int i3) {
        if (i2 == -1) {
            return i3 == -1 ? 0 : -1;
        }
        if (i3 == -1) {
            return 1;
        }
        return i2 - i3;
    }

    public static void filterAdaptiveVideoTrackCountForMimeType(s3 s3Var, int[] iArr, int i2, String str, int i3, int i4, int i5, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(s3Var.f28045b[intValue], str, iArr[intValue], i2, i3, i4, i5)) {
                list.remove(size);
            }
        }
    }

    public static boolean formatHasLanguage(Format format, String str) {
        return str != null && TextUtils.equals(str, Util.normalizeLanguageCode(format.language));
    }

    public static int getAdaptiveAudioTrackCount(s3 s3Var, int[] iArr, a aVar) {
        int i2 = 0;
        for (int i3 = 0; i3 < s3Var.f28044a; i3++) {
            if (isSupportedAdaptiveAudioTrack(s3Var.f28045b[i3], iArr[i3], aVar)) {
                i2++;
            }
        }
        return i2;
    }

    public static int[] getAdaptiveAudioTracks(s3 s3Var, int[] iArr, boolean z) {
        int adaptiveAudioTrackCount;
        HashSet hashSet = new HashSet();
        a aVar = null;
        int i2 = 0;
        for (int i3 = 0; i3 < s3Var.f28044a; i3++) {
            Format format = s3Var.f28045b[i3];
            a aVar2 = new a(format.channelCount, format.sampleRate, z ? null : format.sampleMimeType);
            if (hashSet.add(aVar2) && (adaptiveAudioTrackCount = getAdaptiveAudioTrackCount(s3Var, iArr, aVar2)) > i2) {
                i2 = adaptiveAudioTrackCount;
                aVar = aVar2;
            }
        }
        if (i2 <= 1) {
            return NO_TRACKS;
        }
        int[] iArr2 = new int[i2];
        int i4 = 0;
        for (int i5 = 0; i5 < s3Var.f28044a; i5++) {
            if (isSupportedAdaptiveAudioTrack(s3Var.f28045b[i5], iArr[i5], aVar)) {
                iArr2[i4] = i5;
                i4++;
            }
        }
        return iArr2;
    }

    public static int getAdaptiveVideoTrackCountForMimeType(s3 s3Var, int[] iArr, int i2, String str, int i3, int i4, int i5, List<Integer> list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            int intValue = list.get(i7).intValue();
            if (isSupportedAdaptiveVideoTrack(s3Var.f28045b[intValue], str, iArr[intValue], i2, i3, i4, i5)) {
                i6++;
            }
        }
        return i6;
    }

    public static int[] getAdaptiveVideoTracksForGroup(s3 s3Var, int[] iArr, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2) {
        String str;
        int adaptiveVideoTrackCountForMimeType;
        if (s3Var.f28044a < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(s3Var, i6, i7, z2);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        if (z) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i8 = 0;
            for (int i9 = 0; i9 < viewportFilteredTrackIndices.size(); i9++) {
                String str3 = s3Var.f28045b[viewportFilteredTrackIndices.get(i9).intValue()].sampleMimeType;
                if (hashSet.add(str3) && (adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(s3Var, iArr, i2, str3, i3, i4, i5, viewportFilteredTrackIndices)) > i8) {
                    i8 = adaptiveVideoTrackCountForMimeType;
                    str2 = str3;
                }
            }
            str = str2;
        }
        filterAdaptiveVideoTrackCountForMimeType(s3Var, iArr, i2, str, i3, i4, i5, viewportFilteredTrackIndices);
        return viewportFilteredTrackIndices.size() < 2 ? NO_TRACKS : Util.toArray(viewportFilteredTrackIndices);
    }

    public static int getAudioTrackScore(int i2, String str, Format format) {
        int i3 = 1;
        boolean z = (format.selectionFlags & 1) != 0;
        if (formatHasLanguage(format, str)) {
            i3 = z ? 4 : 3;
        } else if (z) {
            i3 = 2;
        }
        return isSupported(i2, false) ? i3 + 1000 : i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if ((r6 > r7) != (r4 > r5)) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Point getMaxVideoSizeInViewport(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L10
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L8
            r1 = 1
            goto L9
        L8:
            r1 = 0
        L9:
            if (r4 <= r5) goto Lc
            goto Ld
        Lc:
            r3 = 0
        Ld:
            if (r1 == r3) goto L10
            goto L13
        L10:
            r2 = r5
            r5 = r4
            r4 = r2
        L13:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L23
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.vivo.google.android.exoplayer3.util.Util.ceilDivide(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L23:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.vivo.google.android.exoplayer3.util.Util.ceilDivide(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.trackselection.DefaultTrackSelector.getMaxVideoSizeInViewport(boolean, int, int, int, int):android.graphics.Point");
    }

    public static List<Integer> getViewportFilteredTrackIndices(s3 s3Var, int i2, int i3, boolean z) {
        int i4;
        ArrayList arrayList = new ArrayList(s3Var.f28044a);
        for (int i5 = 0; i5 < s3Var.f28044a; i5++) {
            arrayList.add(Integer.valueOf(i5));
        }
        if (i2 != Integer.MAX_VALUE && i3 != Integer.MAX_VALUE) {
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < s3Var.f28044a; i7++) {
                Format format = s3Var.f28045b[i7];
                int i8 = format.width;
                if (i8 > 0 && (i4 = format.height) > 0) {
                    Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z, i2, i3, i8, i4);
                    int i9 = format.width;
                    int i10 = format.height;
                    int i11 = i9 * i10;
                    if (i9 >= ((int) (maxVideoSizeInViewport.x * 0.98f)) && i10 >= ((int) (maxVideoSizeInViewport.y * 0.98f)) && i11 < i6) {
                        i6 = i11;
                    }
                }
            }
            if (i6 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int pixelCount = s3Var.f28045b[((Integer) arrayList.get(size)).intValue()].getPixelCount();
                    if (pixelCount == -1 || pixelCount > i6) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean isSupported(int i2, boolean z) {
        int i3 = i2 & 3;
        return i3 == 3 || (z && i3 == 2);
    }

    public static boolean isSupportedAdaptiveAudioTrack(Format format, int i2, a aVar) {
        if (!isSupported(i2, false) || format.channelCount != aVar.f28117a || format.sampleRate != aVar.f28118b) {
            return false;
        }
        String str = aVar.f28119c;
        return str == null || TextUtils.equals(str, format.sampleMimeType);
    }

    public static boolean isSupportedAdaptiveVideoTrack(Format format, String str, int i2, int i3, int i4, int i5, int i6) {
        if (!isSupported(i2, false) || (i2 & i3) == 0) {
            return false;
        }
        if (str != null && !Util.areEqual(format.sampleMimeType, str)) {
            return false;
        }
        int i7 = format.width;
        if (i7 != -1 && i7 > i4) {
            return false;
        }
        int i8 = format.height;
        if (i8 != -1 && i8 > i5) {
            return false;
        }
        int i9 = format.bitrate;
        return i9 == -1 || i9 <= i6;
    }

    public static TrackSelection selectAdaptiveVideoTrack(g gVar, TrackGroupArray trackGroupArray, int[][] iArr, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, boolean z3, TrackSelection.Factory factory) {
        int i7 = z ? 12 : 8;
        boolean z4 = z2 && (gVar.supportsMixedMimeTypeAdaptation() & i7) != 0;
        for (int i8 = 0; i8 < trackGroupArray.length; i8++) {
            s3 s3Var = trackGroupArray.get(i8);
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(s3Var, iArr[i8], z4, i7, i2, i3, i4, i5, i6, z3);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return factory.createTrackSelection(s3Var, adaptiveVideoTracksForGroup);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (r0 <= r21) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        if (r0 > r22) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        if (r0 > r23) goto L105;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.google.android.exoplayer3.trackselection.TrackSelection selectFixedVideoTrack(com.vivo.google.android.exoplayer3.source.TrackGroupArray r19, int[][] r20, int r21, int r22, int r23, int r24, int r25, boolean r26, boolean r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.trackselection.DefaultTrackSelector.selectFixedVideoTrack(com.vivo.google.android.exoplayer3.source.TrackGroupArray, int[][], int, int, int, int, int, boolean, boolean, boolean):com.vivo.google.android.exoplayer3.trackselection.TrackSelection");
    }

    public Parameters getParameters() {
        return this.paramsReference.get();
    }

    public TrackSelection selectAudioTrack(TrackGroupArray trackGroupArray, int[][] iArr, String str, boolean z, boolean z2, TrackSelection.Factory factory) {
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < trackGroupArray.length; i5++) {
            s3 s3Var = trackGroupArray.get(i5);
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < s3Var.f28044a; i6++) {
                if (isSupported(iArr2[i6], z)) {
                    int audioTrackScore = getAudioTrackScore(iArr2[i6], str, s3Var.f28045b[i6]);
                    if (audioTrackScore > i4) {
                        i2 = i5;
                        i3 = i6;
                        i4 = audioTrackScore;
                    }
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        s3 s3Var2 = trackGroupArray.get(i2);
        if (factory != null) {
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(s3Var2, iArr[i2], z2);
            if (adaptiveAudioTracks.length > 0) {
                return factory.createTrackSelection(s3Var2, adaptiveAudioTracks);
            }
        }
        return new g5(s3Var2, i3);
    }

    public TrackSelection selectOtherTrack(int i2, TrackGroupArray trackGroupArray, int[][] iArr, boolean z) {
        s3 s3Var = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < trackGroupArray.length; i5++) {
            s3 s3Var2 = trackGroupArray.get(i5);
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < s3Var2.f28044a; i6++) {
                if (isSupported(iArr2[i6], z)) {
                    int i7 = (s3Var2.f28045b[i6].selectionFlags & 1) != 0 ? 2 : 1;
                    if (isSupported(iArr2[i6], false)) {
                        i7 += 1000;
                    }
                    if (i7 > i4) {
                        s3Var = s3Var2;
                        i3 = i6;
                        i4 = i7;
                    }
                }
            }
        }
        if (s3Var == null) {
            return null;
        }
        return new g5(s3Var, i3, 0, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.vivo.google.android.exoplayer3.trackselection.TrackSelection selectTextTrack(com.vivo.google.android.exoplayer3.source.TrackGroupArray r18, int[][] r19, java.lang.String r20, java.lang.String r21, boolean r22) {
        /*
            r17 = this;
            r0 = r18
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = 0
            r5 = 0
            r6 = 0
        L8:
            int r7 = r0.length
            if (r3 >= r7) goto L7b
            com.vivo.google.android.exoplayer3.s3 r7 = r0.get(r3)
            r8 = r19[r3]
            r9 = 0
        L13:
            int r10 = r7.f28044a
            if (r9 >= r10) goto L72
            r10 = r8[r9]
            r11 = r22
            boolean r10 = isSupported(r10, r11)
            if (r10 == 0) goto L6b
            com.vivo.google.android.exoplayer3.Format[] r10 = r7.f28045b
            r10 = r10[r9]
            int r12 = r10.selectionFlags
            r13 = r12 & 1
            r14 = 1
            if (r13 == 0) goto L2e
            r13 = 1
            goto L2f
        L2e:
            r13 = 0
        L2f:
            r12 = r12 & 2
            if (r12 == 0) goto L37
            r12 = r20
            r15 = 1
            goto L3a
        L37:
            r12 = r20
            r15 = 0
        L3a:
            boolean r16 = formatHasLanguage(r10, r12)
            if (r16 == 0) goto L4a
            if (r13 == 0) goto L44
            r14 = 6
            goto L4d
        L44:
            if (r15 != 0) goto L48
            r14 = 5
            goto L4d
        L48:
            r14 = 4
            goto L4d
        L4a:
            if (r13 == 0) goto L50
            r14 = 3
        L4d:
            r13 = r21
            goto L5b
        L50:
            r13 = r21
            if (r15 == 0) goto L6f
            boolean r10 = formatHasLanguage(r10, r13)
            if (r10 == 0) goto L5b
            r14 = 2
        L5b:
            r10 = r8[r9]
            boolean r10 = isSupported(r10, r2)
            if (r10 == 0) goto L65
            int r14 = r14 + 1000
        L65:
            if (r14 <= r6) goto L6f
            r4 = r7
            r5 = r9
            r6 = r14
            goto L6f
        L6b:
            r12 = r20
            r13 = r21
        L6f:
            int r9 = r9 + 1
            goto L13
        L72:
            r12 = r20
            r13 = r21
            r11 = r22
            int r3 = r3 + 1
            goto L8
        L7b:
            if (r4 != 0) goto L7e
            goto L84
        L7e:
            com.vivo.google.android.exoplayer3.g5 r0 = new com.vivo.google.android.exoplayer3.g5
            r0.<init>(r4, r5, r2, r1)
            r1 = r0
        L84:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.trackselection.DefaultTrackSelector.selectTextTrack(com.vivo.google.android.exoplayer3.source.TrackGroupArray, int[][], java.lang.String, java.lang.String, boolean):com.vivo.google.android.exoplayer3.trackselection.TrackSelection");
    }

    @Override // com.vivo.google.android.exoplayer3.h5
    public TrackSelection[] selectTracks(g[] gVarArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr) {
        Parameters parameters;
        int i2;
        Parameters parameters2;
        TrackSelection[] trackSelectionArr;
        int i3;
        DefaultTrackSelector defaultTrackSelector = this;
        g[] gVarArr2 = gVarArr;
        int length = gVarArr2.length;
        TrackSelection[] trackSelectionArr2 = new TrackSelection[length];
        Parameters parameters3 = defaultTrackSelector.paramsReference.get();
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        while (i4 < length) {
            if (2 == gVarArr2[i4].getTrackType()) {
                if (z) {
                    i2 = i4;
                    parameters2 = parameters3;
                    trackSelectionArr = trackSelectionArr2;
                    i3 = length;
                } else {
                    i2 = i4;
                    trackSelectionArr = trackSelectionArr2;
                    parameters2 = parameters3;
                    i3 = length;
                    trackSelectionArr[i2] = selectVideoTrack(gVarArr2[i4], trackGroupArrayArr[i4], iArr[i4], parameters3.maxVideoWidth, parameters3.maxVideoHeight, parameters3.maxVideoBitrate, parameters3.allowNonSeamlessAdaptiveness, parameters3.allowMixedMimeAdaptiveness, parameters3.viewportWidth, parameters3.viewportHeight, parameters3.orientationMayChange, defaultTrackSelector.adaptiveTrackSelectionFactory, parameters3.exceedVideoConstraintsIfNecessary, parameters3.exceedRendererCapabilitiesIfNecessary);
                    z = trackSelectionArr[i2] != null;
                }
                z2 |= trackGroupArrayArr[i2].length > 0;
            } else {
                i2 = i4;
                parameters2 = parameters3;
                trackSelectionArr = trackSelectionArr2;
                i3 = length;
            }
            i4 = i2 + 1;
            defaultTrackSelector = this;
            gVarArr2 = gVarArr;
            trackSelectionArr2 = trackSelectionArr;
            parameters3 = parameters2;
            length = i3;
        }
        Parameters parameters4 = parameters3;
        TrackSelection[] trackSelectionArr3 = trackSelectionArr2;
        int i5 = length;
        boolean z3 = false;
        boolean z4 = false;
        int i6 = 0;
        while (i6 < i5) {
            int trackType = gVarArr[i6].getTrackType();
            if (trackType == 1) {
                parameters = parameters4;
                if (!z4) {
                    trackSelectionArr3[i6] = selectAudioTrack(trackGroupArrayArr[i6], iArr[i6], parameters.preferredAudioLanguage, parameters.exceedRendererCapabilitiesIfNecessary, parameters.allowMixedMimeAdaptiveness, z2 ? null : this.adaptiveTrackSelectionFactory);
                    z4 = trackSelectionArr3[i6] != null;
                }
            } else if (trackType == 2) {
                parameters = parameters4;
            } else if (trackType != 3) {
                parameters = parameters4;
                trackSelectionArr3[i6] = selectOtherTrack(gVarArr[i6].getTrackType(), trackGroupArrayArr[i6], iArr[i6], parameters.exceedRendererCapabilitiesIfNecessary);
            } else {
                parameters = parameters4;
                if (!z3) {
                    trackSelectionArr3[i6] = selectTextTrack(trackGroupArrayArr[i6], iArr[i6], parameters.preferredTextLanguage, parameters.preferredAudioLanguage, parameters.exceedRendererCapabilitiesIfNecessary);
                    z3 = trackSelectionArr3[i6] != null;
                }
            }
            i6++;
            parameters4 = parameters;
        }
        return trackSelectionArr3;
    }

    public TrackSelection selectVideoTrack(g gVar, TrackGroupArray trackGroupArray, int[][] iArr, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, boolean z3, TrackSelection.Factory factory, boolean z4, boolean z5) {
        TrackSelection selectAdaptiveVideoTrack = factory != null ? selectAdaptiveVideoTrack(gVar, trackGroupArray, iArr, i2, i3, i4, z, z2, i5, i6, z3, factory) : null;
        return selectAdaptiveVideoTrack == null ? selectFixedVideoTrack(trackGroupArray, iArr, i2, i3, i4, i5, i6, z3, z4, z5) : selectAdaptiveVideoTrack;
    }

    public void setParameters(Parameters parameters) {
        parameters.getClass();
        if (this.paramsReference.getAndSet(parameters).equals(parameters)) {
            return;
        }
        invalidate();
    }
}
