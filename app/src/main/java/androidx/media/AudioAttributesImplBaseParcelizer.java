package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f2735a = versionedParcel.readInt(audioAttributesImplBase.f2735a, 1);
        audioAttributesImplBase.f2736b = versionedParcel.readInt(audioAttributesImplBase.f2736b, 2);
        audioAttributesImplBase.f2737c = versionedParcel.readInt(audioAttributesImplBase.f2737c, 3);
        audioAttributesImplBase.f2738d = versionedParcel.readInt(audioAttributesImplBase.f2738d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeInt(audioAttributesImplBase.f2735a, 1);
        versionedParcel.writeInt(audioAttributesImplBase.f2736b, 2);
        versionedParcel.writeInt(audioAttributesImplBase.f2737c, 3);
        versionedParcel.writeInt(audioAttributesImplBase.f2738d, 4);
    }
}
