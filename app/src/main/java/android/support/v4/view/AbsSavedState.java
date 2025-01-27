package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0007;

/* loaded from: classes7.dex */
public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR;
    public static final AbsSavedState EMPTY_STATE;

    /* renamed from: short */
    private static final short[] f22short;
    private final Parcelable mSuperState;

    /* renamed from: android.support.v4.view.AbsSavedState$1 */
    static final class AnonymousClass1 extends AbsSavedState {
        AnonymousClass1() {
        }
    }

    /* renamed from: android.support.v4.view.AbsSavedState$2 */
    static final class AnonymousClass2 implements Parcelable.ClassLoaderCreator<AbsSavedState> {

        /* renamed from: short */
        private static final short[] f23short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(927848)}[0]).intValue() ^ 927871];
            sArr[0] = 479;
            sArr[1] = 473;
            sArr[2] = 476;
            sArr[3] = 457;
            sArr[4] = 478;
            sArr[5] = 511;
            sArr[6] = 472;
            sArr[7] = 461;
            sArr[8] = 472;
            sArr[9] = 457;
            sArr[10] = 396;
            sArr[11] = 449;
            sArr[12] = 473;
            sArr[13] = 479;
            sArr[14] = 472;
            sArr[15] = 396;
            sArr[16] = 462;
            sArr[17] = 457;
            sArr[18] = 396;
            sArr[19] = 450;
            sArr[20] = 473;
            sArr[21] = 448;
            sArr[22] = 448;
            f23short = sArr;
        }

        AnonymousClass2() {
        }

        @Override // android.os.Parcelable.Creator
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.EMPTY_STATE;
            }
            throw new IllegalStateException(C0007.m23(f23short, 1747902 ^ C0008.m27((Object) "۠ۧۥ"), 1751698 ^ C0008.m27((Object) "ۤۥۦ"), C0008.m27((Object) "ۢۦۡ") ^ 1749681));
        }

        @Override // android.os.Parcelable.Creator
        public AbsSavedState[] newArray(int i2) {
            return new AbsSavedState[i2];
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(5506587)}[0]).intValue() ^ 5506560];
        sArr[0] = 2146;
        sArr[1] = 2148;
        sArr[2] = 2145;
        sArr[3] = 2164;
        sArr[4] = 2147;
        sArr[5] = 2114;
        sArr[6] = 2149;
        sArr[7] = 2160;
        sArr[8] = 2149;
        sArr[9] = 2164;
        sArr[10] = 2097;
        sArr[11] = 2172;
        sArr[12] = 2148;
        sArr[13] = 2146;
        sArr[14] = 2149;
        sArr[15] = 2097;
        sArr[16] = 2175;
        sArr[17] = 2174;
        sArr[18] = 2149;
        sArr[19] = 2097;
        sArr[20] = 2163;
        sArr[21] = 2164;
        sArr[22] = 2097;
        sArr[23] = 2175;
        sArr[24] = 2148;
        sArr[25] = 2173;
        sArr[26] = 2173;
        f22short = sArr;
        EMPTY_STATE = new AbsSavedState() { // from class: android.support.v4.view.AbsSavedState.1
            AnonymousClass1() {
            }
        };
        CREATOR = new Parcelable.ClassLoaderCreator<AbsSavedState>() { // from class: android.support.v4.view.AbsSavedState.2

            /* renamed from: short */
            private static final short[] f23short;

            static {
                short[] sArr2 = new short[((Integer) new Object[]{new Integer(927848)}[0]).intValue() ^ 927871];
                sArr2[0] = 479;
                sArr2[1] = 473;
                sArr2[2] = 476;
                sArr2[3] = 457;
                sArr2[4] = 478;
                sArr2[5] = 511;
                sArr2[6] = 472;
                sArr2[7] = 461;
                sArr2[8] = 472;
                sArr2[9] = 457;
                sArr2[10] = 396;
                sArr2[11] = 449;
                sArr2[12] = 473;
                sArr2[13] = 479;
                sArr2[14] = 472;
                sArr2[15] = 396;
                sArr2[16] = 462;
                sArr2[17] = 457;
                sArr2[18] = 396;
                sArr2[19] = 450;
                sArr2[20] = 473;
                sArr2[21] = 448;
                sArr2[22] = 448;
                f23short = sArr2;
            }

            AnonymousClass2() {
            }

            @Override // android.os.Parcelable.Creator
            public AbsSavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                if (parcel.readParcelable(classLoader) == null) {
                    return AbsSavedState.EMPTY_STATE;
                }
                throw new IllegalStateException(C0007.m23(f23short, 1747902 ^ C0008.m27((Object) "۠ۧۥ"), 1751698 ^ C0008.m27((Object) "ۤۥۦ"), C0008.m27((Object) "ۢۦۡ") ^ 1749681));
            }

            @Override // android.os.Parcelable.Creator
            public AbsSavedState[] newArray(int i2) {
                return new AbsSavedState[i2];
            }
        };
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(Parcel parcel) {
        this(parcel, null);
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.mSuperState = readParcelable == null ? EMPTY_STATE : readParcelable;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException(C0004.m13(f22short, 1747927 ^ C0008.m27((Object) "۠ۨ۟"), 1751774 ^ C0008.m27((Object) "ۤۧۨ"), C0008.m27((Object) "ۣۢ۠") ^ 1751726));
        }
        this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
    }

    /* synthetic */ AbsSavedState(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.mSuperState, i2);
    }
}
