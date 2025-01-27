package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(21)
/* loaded from: classes.dex */
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a */
    private static final String f2731a = "AudioAttributesCompat21";

    /* renamed from: b */
    static Method f2732b;

    /* renamed from: c */
    AudioAttributes f2733c;

    /* renamed from: d */
    int f2734d;

    AudioAttributesImplApi21() {
        this.f2734d = -1;
    }

    static Method a() {
        try {
            if (f2732b == null) {
                f2732b = AudioAttributes.class.getMethod("toLegacyStreamType", AudioAttributes.class);
            }
            return f2732b;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static AudioAttributesImpl fromBundle(Bundle bundle) {
        AudioAttributes audioAttributes;
        if (bundle == null || (audioAttributes = (AudioAttributes) bundle.getParcelable("androidx.media.audio_attrs.FRAMEWORKS")) == null) {
            return null;
        }
        return new AudioAttributesImplApi21(audioAttributes, bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f2733c.equals(((AudioAttributesImplApi21) obj).f2733c);
        }
        return false;
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return this.f2733c;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.f2733c.getContentType();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        return this.f2733c.getFlags();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int i2 = this.f2734d;
        if (i2 != -1) {
            return i2;
        }
        Method a2 = a();
        if (a2 == null) {
            Log.w(f2731a, "No AudioAttributes#toLegacyStreamType() on API: " + Build.VERSION.SDK_INT);
            return -1;
        }
        try {
            return ((Integer) a2.invoke(null, this.f2733c)).intValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            Log.w(f2731a, "getLegacyStreamType() failed on API: " + Build.VERSION.SDK_INT, e2);
            return -1;
        }
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.f2734d;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.f2733c.getUsage();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        return Build.VERSION.SDK_INT >= 26 ? this.f2733c.getVolumeControlStream() : AudioAttributesCompat.a(true, getFlags(), getUsage());
    }

    public int hashCode() {
        return this.f2733c.hashCode();
    }

    @Override // androidx.media.AudioAttributesImpl
    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.f2733c);
        int i2 = this.f2734d;
        if (i2 != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i2);
        }
        return bundle;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2733c;
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes, int i2) {
        this.f2734d = -1;
        this.f2733c = audioAttributes;
        this.f2734d = i2;
    }
}
