package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.core.os.BuildCompat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ParcelCompat {

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static final <T extends Parcelable> List<T> readParcelableList(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader) {
            return parcel.readParcelableList(list, classLoader);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static final Parcelable.Creator<?> readParcelableCreator(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            return parcel.readParcelableCreator(classLoader);
        }
    }

    @RequiresApi(33)
    public static class TiramisuImpl {
        private TiramisuImpl() {
        }

        @DoNotInline
        public static <T> T[] readArray(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            Object[] readArray;
            readArray = parcel.readArray(classLoader, cls);
            return (T[]) readArray;
        }

        @DoNotInline
        public static <T> ArrayList<T> readArrayList(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            ArrayList<T> readArrayList;
            readArrayList = parcel.readArrayList(classLoader, cls);
            return readArrayList;
        }

        @DoNotInline
        public static <V, K> HashMap<K, V> readHashMap(Parcel parcel, ClassLoader classLoader, Class<? extends K> cls, Class<? extends V> cls2) {
            HashMap<K, V> readHashMap;
            readHashMap = parcel.readHashMap(classLoader, cls, cls2);
            return readHashMap;
        }

        @DoNotInline
        public static <T> void readList(@NonNull Parcel parcel, @NonNull List<? super T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            parcel.readList(list, classLoader, cls);
        }

        @DoNotInline
        public static <K, V> void readMap(Parcel parcel, Map<? super K, ? super V> map, ClassLoader classLoader, Class<K> cls, Class<V> cls2) {
            parcel.readMap(map, classLoader, cls, cls2);
        }

        @DoNotInline
        public static <T extends Parcelable> T readParcelable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            Object readParcelable;
            readParcelable = parcel.readParcelable(classLoader, cls);
            return (T) readParcelable;
        }

        @DoNotInline
        public static <T> T[] readParcelableArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            Object[] readParcelableArray;
            readParcelableArray = parcel.readParcelableArray(classLoader, cls);
            return (T[]) readParcelableArray;
        }

        @DoNotInline
        public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            Parcelable.Creator<T> readParcelableCreator;
            readParcelableCreator = parcel.readParcelableCreator(classLoader, cls);
            return readParcelableCreator;
        }

        @DoNotInline
        public static <T> List<T> readParcelableList(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            List<T> readParcelableList;
            readParcelableList = parcel.readParcelableList(list, classLoader, cls);
            return readParcelableList;
        }

        @DoNotInline
        public static <T extends Serializable> T readSerializable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            Object readSerializable;
            readSerializable = parcel.readSerializable(classLoader, cls);
            return (T) readSerializable;
        }

        @DoNotInline
        public static <T> SparseArray<T> readSparseArray(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            SparseArray<T> readSparseArray;
            readSparseArray = parcel.readSparseArray(classLoader, cls);
            return readSparseArray;
        }
    }

    private ParcelCompat() {
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static <T> T[] readArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return BuildCompat.isAtLeastT() ? (T[]) TiramisuImpl.readArray(parcel, classLoader, cls) : (T[]) parcel.readArray(classLoader);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <T> ArrayList<T> readArrayList(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends T> cls) {
        return BuildCompat.isAtLeastT() ? TiramisuImpl.readArrayList(parcel, classLoader, cls) : parcel.readArrayList(classLoader);
    }

    public static boolean readBoolean(@NonNull Parcel parcel) {
        return parcel.readInt() != 0;
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <K, V> HashMap<K, V> readHashMap(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends K> cls, @NonNull Class<? extends V> cls2) {
        return BuildCompat.isAtLeastT() ? TiramisuImpl.readHashMap(parcel, classLoader, cls, cls2) : parcel.readHashMap(classLoader);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T> void readList(@NonNull Parcel parcel, @NonNull List<? super T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (BuildCompat.isAtLeastT()) {
            TiramisuImpl.readList(parcel, list, classLoader, cls);
        } else {
            parcel.readList(list, classLoader);
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <K, V> void readMap(@NonNull Parcel parcel, @NonNull Map<? super K, ? super V> map, @Nullable ClassLoader classLoader, @NonNull Class<K> cls, @NonNull Class<V> cls2) {
        if (BuildCompat.isAtLeastT()) {
            TiramisuImpl.readMap(parcel, map, classLoader, cls, cls2);
        } else {
            parcel.readMap(map, classLoader);
        }
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T extends Parcelable> T readParcelable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return BuildCompat.isAtLeastT() ? (T) TiramisuImpl.readParcelable(parcel, classLoader, cls) : (T) parcel.readParcelable(classLoader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static <T> T[] readParcelableArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return BuildCompat.isAtLeastT() ? (T[]) TiramisuImpl.readParcelableArray(parcel, classLoader, cls) : (T[]) parcel.readParcelableArray(classLoader);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @RequiresApi(30)
    public static <T> Parcelable.Creator<T> readParcelableCreator(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return BuildCompat.isAtLeastT() ? TiramisuImpl.readParcelableCreator(parcel, classLoader, cls) : (Parcelable.Creator<T>) Api30Impl.readParcelableCreator(parcel, classLoader);
    }

    @NonNull
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @RequiresApi(api = 29)
    public static <T> List<T> readParcelableList(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return BuildCompat.isAtLeastT() ? TiramisuImpl.readParcelableList(parcel, list, classLoader, cls) : Api29Impl.readParcelableList(parcel, list, classLoader);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T extends Serializable> T readSerializable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return BuildCompat.isAtLeastT() ? (T) TiramisuImpl.readSerializable(parcel, classLoader, cls) : (T) parcel.readSerializable();
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T> SparseArray<T> readSparseArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends T> cls) {
        return BuildCompat.isAtLeastT() ? TiramisuImpl.readSparseArray(parcel, classLoader, cls) : parcel.readSparseArray(classLoader);
    }

    public static void writeBoolean(@NonNull Parcel parcel, boolean z10) {
        parcel.writeInt(z10 ? 1 : 0);
    }
}
