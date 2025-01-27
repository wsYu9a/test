package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class VersionedParcelParcel extends VersionedParcel {
    private static final boolean t = false;
    private static final String u = "VersionedParcelParcel";
    private int A;
    private int B;
    private int C;
    private final SparseIntArray v;
    private final Parcel w;
    private final int x;
    private final int y;
    private final String z;

    VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel b() {
        Parcel parcel = this.w;
        int dataPosition = parcel.dataPosition();
        int i2 = this.B;
        if (i2 == this.x) {
            i2 = this.y;
        }
        return new VersionedParcelParcel(parcel, dataPosition, i2, this.z + "  ", this.q, this.r, this.s);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        int i2 = this.A;
        if (i2 >= 0) {
            int i3 = this.v.get(i2);
            int dataPosition = this.w.dataPosition();
            this.w.setDataPosition(i3);
            this.w.writeInt(dataPosition - i3);
            this.w.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence i() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.w);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        return this.w.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        return this.w.readBundle(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        int readInt = this.w.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.w.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        return this.w.readDouble();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int i2) {
        while (this.B < this.y) {
            int i3 = this.C;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.w.setDataPosition(this.B);
            int readInt = this.w.readInt();
            this.C = this.w.readInt();
            this.B += readInt;
        }
        return this.C == i2;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        return this.w.readFloat();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        return this.w.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        return this.w.readLong();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return (T) this.w.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        return this.w.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return this.w.readStrongBinder();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int i2) {
        closeField();
        this.A = i2;
        this.v.put(i2, this.w.dataPosition());
        writeInt(0);
        writeInt(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void v(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.w, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean z) {
        this.w.writeInt(z ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle bundle) {
        this.w.writeBundle(bundle);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr) {
        if (bArr == null) {
            this.w.writeInt(-1);
        } else {
            this.w.writeInt(bArr.length);
            this.w.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double d2) {
        this.w.writeDouble(d2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float f2) {
        this.w.writeFloat(f2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int i2) {
        this.w.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long j2) {
        this.w.writeLong(j2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable parcelable) {
        this.w.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String str) {
        this.w.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder iBinder) {
        this.w.writeStrongBinder(iBinder);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface iInterface) {
        this.w.writeStrongInterface(iInterface);
    }

    private VersionedParcelParcel(Parcel parcel, int i2, int i3, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.v = new SparseIntArray();
        this.A = -1;
        this.B = 0;
        this.C = -1;
        this.w = parcel;
        this.x = i2;
        this.y = i3;
        this.B = i2;
        this.z = str;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            this.w.writeInt(bArr.length);
            this.w.writeByteArray(bArr, i2, i3);
        } else {
            this.w.writeInt(-1);
        }
    }
}
