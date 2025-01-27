package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class AudioAttributesCompat implements VersionedParcelable {
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    public static final int FLAG_HW_AV_SYNC = 16;
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;

    /* renamed from: a */
    private static final String f2717a = "AudioAttributesCompat";

    /* renamed from: b */
    private static final int f2718b = 15;

    /* renamed from: c */
    private static final int f2719c = 1;

    /* renamed from: d */
    private static final int f2720d = 2;

    /* renamed from: e */
    private static final SparseIntArray f2721e;

    /* renamed from: f */
    static boolean f2722f = false;

    /* renamed from: g */
    private static final int[] f2723g;

    /* renamed from: h */
    static final int f2724h = 2;

    /* renamed from: i */
    static final int f2725i = 4;

    /* renamed from: j */
    static final int f2726j = 8;
    static final int k = 32;
    static final int l = 64;
    static final int m = 128;
    static final int n = 256;
    static final int o = 512;
    static final int p = 1023;
    static final int q = 273;
    static final int r = -1;
    static final String s = "androidx.media.audio_attrs.FRAMEWORKS";
    static final String t = "androidx.media.audio_attrs.USAGE";
    static final String u = "androidx.media.audio_attrs.CONTENT_TYPE";
    static final String v = "androidx.media.audio_attrs.FLAGS";
    static final String w = "androidx.media.audio_attrs.LEGACY_STREAM_TYPE";
    AudioAttributesImpl x;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AttributeUsage {
    }

    static abstract class AudioManagerHidden {
        public static final int STREAM_ACCESSIBILITY = 10;
        public static final int STREAM_BLUETOOTH_SCO = 6;
        public static final int STREAM_SYSTEM_ENFORCED = 7;
        public static final int STREAM_TTS = 9;

        private AudioManagerHidden() {
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2721e = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
        f2723g = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    AudioAttributesCompat() {
    }

    static int a(boolean z, int i2, int i3) {
        if ((i2 & 1) == 1) {
            return z ? 1 : 7;
        }
        if ((i2 & 4) == 4) {
            return z ? 0 : 6;
        }
        switch (i3) {
            case 0:
                return z ? Integer.MIN_VALUE : 3;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            case 15:
            default:
                if (!z) {
                    return 3;
                }
                throw new IllegalArgumentException("Unknown usage value " + i3 + " in audio attributes");
        }
    }

    static int b(boolean z, AudioAttributesCompat audioAttributesCompat) {
        return a(z, audioAttributesCompat.getFlags(), audioAttributesCompat.getUsage());
    }

    static int c(int i2) {
        switch (i2) {
        }
        return 2;
    }

    static String d(int i2) {
        switch (i2) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 15:
            default:
                return "unknown usage " + i2;
            case 16:
                return "USAGE_ASSISTANT";
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static AudioAttributesCompat fromBundle(Bundle bundle) {
        AudioAttributesImpl fromBundle = Build.VERSION.SDK_INT >= 21 ? AudioAttributesImplApi21.fromBundle(bundle) : AudioAttributesImplBase.fromBundle(bundle);
        if (fromBundle == null) {
            return null;
        }
        return new AudioAttributesCompat(fromBundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setForceLegacyBehavior(boolean z) {
        f2722f = z;
    }

    @Nullable
    public static AudioAttributesCompat wrap(@NonNull Object obj) {
        if (Build.VERSION.SDK_INT < 21 || f2722f) {
            return null;
        }
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21((AudioAttributes) obj);
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.x = audioAttributesImplApi21;
        return audioAttributesCompat;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.x;
        return audioAttributesImpl == null ? audioAttributesCompat.x == null : audioAttributesImpl.equals(audioAttributesCompat.x);
    }

    public int getContentType() {
        return this.x.getContentType();
    }

    public int getFlags() {
        return this.x.getFlags();
    }

    public int getLegacyStreamType() {
        return this.x.getLegacyStreamType();
    }

    int getRawLegacyStreamType() {
        return this.x.getRawLegacyStreamType();
    }

    public int getUsage() {
        return this.x.getUsage();
    }

    public int getVolumeControlStream() {
        return this.x.getVolumeControlStream();
    }

    public int hashCode() {
        return this.x.hashCode();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bundle toBundle() {
        return this.x.toBundle();
    }

    public String toString() {
        return this.x.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.x.getAudioAttributes();
    }

    AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.x = audioAttributesImpl;
    }

    public static class Builder {

        /* renamed from: a */
        private int f2727a;

        /* renamed from: b */
        private int f2728b;

        /* renamed from: c */
        private int f2729c;

        /* renamed from: d */
        private int f2730d;

        public Builder() {
            this.f2727a = 0;
            this.f2728b = 0;
            this.f2729c = 0;
            this.f2730d = -1;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        Builder a(int i2) {
            switch (i2) {
                case 0:
                    this.f2728b = 1;
                    break;
                case 1:
                    this.f2728b = 4;
                    break;
                case 2:
                    this.f2728b = 4;
                    break;
                case 3:
                    this.f2728b = 2;
                    break;
                case 4:
                    this.f2728b = 4;
                    break;
                case 5:
                    this.f2728b = 4;
                    break;
                case 6:
                    this.f2728b = 1;
                    this.f2729c |= 4;
                    break;
                case 7:
                    this.f2729c = 1 | this.f2729c;
                    this.f2728b = 4;
                    break;
                case 8:
                    this.f2728b = 4;
                    break;
                case 9:
                    this.f2728b = 4;
                    break;
                case 10:
                    this.f2728b = 1;
                    break;
                default:
                    Log.e(AudioAttributesCompat.f2717a, "Invalid stream type " + i2 + " for AudioAttributesCompat");
                    break;
            }
            this.f2727a = AudioAttributesCompat.c(i2);
            return this;
        }

        public AudioAttributesCompat build() {
            AudioAttributesImpl audioAttributesImplBase;
            if (AudioAttributesCompat.f2722f || Build.VERSION.SDK_INT < 21) {
                audioAttributesImplBase = new AudioAttributesImplBase(this.f2728b, this.f2729c, this.f2727a, this.f2730d);
            } else {
                AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f2728b).setFlags(this.f2729c).setUsage(this.f2727a);
                int i2 = this.f2730d;
                if (i2 != -1) {
                    usage.setLegacyStreamType(i2);
                }
                audioAttributesImplBase = new AudioAttributesImplApi21(usage.build(), this.f2730d);
            }
            return new AudioAttributesCompat(audioAttributesImplBase);
        }

        public Builder setContentType(int i2) {
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
                this.f2728b = i2;
            } else {
                this.f2727a = 0;
            }
            return this;
        }

        public Builder setFlags(int i2) {
            this.f2729c = (i2 & 1023) | this.f2729c;
            return this;
        }

        public Builder setLegacyStreamType(int i2) {
            if (i2 == 10) {
                throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
            }
            this.f2730d = i2;
            return Build.VERSION.SDK_INT >= 21 ? a(i2) : this;
        }

        public Builder setUsage(int i2) {
            switch (i2) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    this.f2727a = i2;
                    return this;
                case 16:
                    if (AudioAttributesCompat.f2722f || Build.VERSION.SDK_INT <= 25) {
                        this.f2727a = 12;
                    } else {
                        this.f2727a = i2;
                    }
                    return this;
                default:
                    this.f2727a = 0;
                    return this;
            }
        }

        public Builder(AudioAttributesCompat audioAttributesCompat) {
            this.f2727a = 0;
            this.f2728b = 0;
            this.f2729c = 0;
            this.f2730d = -1;
            this.f2727a = audioAttributesCompat.getUsage();
            this.f2728b = audioAttributesCompat.getContentType();
            this.f2729c = audioAttributesCompat.getFlags();
            this.f2730d = audioAttributesCompat.getRawLegacyStreamType();
        }
    }
}
