package androidx.media;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.umeng.commonsdk.stateless.b;
import java.util.Arrays;

/* loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a */
    int f2735a;

    /* renamed from: b */
    int f2736b;

    /* renamed from: c */
    int f2737c;

    /* renamed from: d */
    int f2738d;

    AudioAttributesImplBase() {
        this.f2735a = 0;
        this.f2736b = 0;
        this.f2737c = 0;
        this.f2738d = -1;
    }

    public static AudioAttributesImpl fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return new AudioAttributesImplBase(bundle.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), bundle.getInt("androidx.media.audio_attrs.FLAGS", 0), bundle.getInt("androidx.media.audio_attrs.USAGE", 0), bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f2736b == audioAttributesImplBase.getContentType() && this.f2737c == audioAttributesImplBase.getFlags() && this.f2735a == audioAttributesImplBase.getUsage() && this.f2738d == audioAttributesImplBase.f2738d;
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return null;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.f2736b;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        int i2 = this.f2737c;
        int legacyStreamType = getLegacyStreamType();
        if (legacyStreamType == 6) {
            i2 |= 4;
        } else if (legacyStreamType == 7) {
            i2 |= 1;
        }
        return i2 & b.f26259a;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int i2 = this.f2738d;
        return i2 != -1 ? i2 : AudioAttributesCompat.a(false, this.f2737c, this.f2735a);
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.f2738d;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.f2735a;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        return AudioAttributesCompat.a(true, this.f2737c, this.f2735a);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2736b), Integer.valueOf(this.f2737c), Integer.valueOf(this.f2735a), Integer.valueOf(this.f2738d)});
    }

    @Override // androidx.media.AudioAttributesImpl
    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("androidx.media.audio_attrs.USAGE", this.f2735a);
        bundle.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.f2736b);
        bundle.putInt("androidx.media.audio_attrs.FLAGS", this.f2737c);
        int i2 = this.f2738d;
        if (i2 != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i2);
        }
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f2738d != -1) {
            sb.append(" stream=");
            sb.append(this.f2738d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.d(this.f2735a));
        sb.append(" content=");
        sb.append(this.f2736b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f2737c).toUpperCase());
        return sb.toString();
    }

    AudioAttributesImplBase(int i2, int i3, int i4, int i5) {
        this.f2735a = 0;
        this.f2736b = 0;
        this.f2737c = 0;
        this.f2738d = -1;
        this.f2736b = i2;
        this.f2737c = i3;
        this.f2735a = i4;
        this.f2738d = i5;
    }
}
