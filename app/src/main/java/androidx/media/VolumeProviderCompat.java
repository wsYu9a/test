package androidx.media;

import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.media.VolumeProviderCompatApi21;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;

    /* renamed from: a */
    private final int f2870a;

    /* renamed from: b */
    private final int f2871b;

    /* renamed from: c */
    private int f2872c;

    /* renamed from: d */
    private Callback f2873d;

    /* renamed from: e */
    private Object f2874e;

    /* renamed from: androidx.media.VolumeProviderCompat$1 */
    class AnonymousClass1 implements VolumeProviderCompatApi21.Delegate {
        AnonymousClass1() {
        }

        @Override // androidx.media.VolumeProviderCompatApi21.Delegate
        public void onAdjustVolume(int i2) {
            VolumeProviderCompat.this.onAdjustVolume(i2);
        }

        @Override // androidx.media.VolumeProviderCompatApi21.Delegate
        public void onSetVolumeTo(int i2) {
            VolumeProviderCompat.this.onSetVolumeTo(i2);
        }
    }

    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i2, int i3, int i4) {
        this.f2870a = i2;
        this.f2871b = i3;
        this.f2872c = i4;
    }

    public final int getCurrentVolume() {
        return this.f2872c;
    }

    public final int getMaxVolume() {
        return this.f2871b;
    }

    public final int getVolumeControl() {
        return this.f2870a;
    }

    public Object getVolumeProvider() {
        if (this.f2874e == null && Build.VERSION.SDK_INT >= 21) {
            this.f2874e = VolumeProviderCompatApi21.createVolumeProvider(this.f2870a, this.f2871b, this.f2872c, new VolumeProviderCompatApi21.Delegate() { // from class: androidx.media.VolumeProviderCompat.1
                AnonymousClass1() {
                }

                @Override // androidx.media.VolumeProviderCompatApi21.Delegate
                public void onAdjustVolume(int i2) {
                    VolumeProviderCompat.this.onAdjustVolume(i2);
                }

                @Override // androidx.media.VolumeProviderCompatApi21.Delegate
                public void onSetVolumeTo(int i2) {
                    VolumeProviderCompat.this.onSetVolumeTo(i2);
                }
            });
        }
        return this.f2874e;
    }

    public void onAdjustVolume(int i2) {
    }

    public void onSetVolumeTo(int i2) {
    }

    public void setCallback(Callback callback) {
        this.f2873d = callback;
    }

    public final void setCurrentVolume(int i2) {
        this.f2872c = i2;
        Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null && Build.VERSION.SDK_INT >= 21) {
            VolumeProviderCompatApi21.setCurrentVolume(volumeProvider, i2);
        }
        Callback callback = this.f2873d;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }
}
