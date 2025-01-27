package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class SavedStateHandle {

    /* renamed from: a */
    private static final String f2626a = "values";

    /* renamed from: b */
    private static final String f2627b = "keys";

    /* renamed from: c */
    private static final Class[] f2628c;

    /* renamed from: d */
    final Map<String, Object> f2629d;

    /* renamed from: e */
    private final Map<String, SavingStateLiveData<?>> f2630e;

    /* renamed from: f */
    private final SavedStateRegistry.SavedStateProvider f2631f;

    /* renamed from: androidx.lifecycle.SavedStateHandle$1 */
    class AnonymousClass1 implements SavedStateRegistry.SavedStateProvider {
        AnonymousClass1() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        @NonNull
        public Bundle saveState() {
            Set<String> keySet = SavedStateHandle.this.f2629d.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str : keySet) {
                arrayList.add(str);
                arrayList2.add(SavedStateHandle.this.f2629d.get(str));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(SavedStateHandle.f2627b, arrayList);
            bundle.putParcelableArrayList(SavedStateHandle.f2626a, arrayList2);
            return bundle;
        }
    }

    static {
        Class[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        Class<SizeF> cls = Integer.TYPE;
        clsArr[4] = cls;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        int i2 = Build.VERSION.SDK_INT;
        clsArr[27] = i2 >= 21 ? Size.class : cls;
        if (i2 >= 21) {
            cls = SizeF.class;
        }
        clsArr[28] = cls;
        f2628c = clsArr;
    }

    public SavedStateHandle(@NonNull Map<String, Object> map) {
        this.f2630e = new HashMap();
        this.f2631f = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.SavedStateHandle.1
            AnonymousClass1() {
            }

            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            @NonNull
            public Bundle saveState() {
                Set<String> keySet = SavedStateHandle.this.f2629d.keySet();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
                for (String str : keySet) {
                    arrayList.add(str);
                    arrayList2.add(SavedStateHandle.this.f2629d.get(str));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(SavedStateHandle.f2627b, arrayList);
                bundle.putParcelableArrayList(SavedStateHandle.f2626a, arrayList2);
                return bundle;
            }
        };
        this.f2629d = new HashMap(map);
    }

    static SavedStateHandle a(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new SavedStateHandle();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new SavedStateHandle(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f2627b);
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(f2626a);
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
            hashMap.put((String) parcelableArrayList.get(i2), parcelableArrayList2.get(i2));
        }
        return new SavedStateHandle(hashMap);
    }

    @NonNull
    private <T> MutableLiveData<T> b(@NonNull String str, boolean z, @Nullable T t) {
        SavingStateLiveData<?> savingStateLiveData = this.f2630e.get(str);
        if (savingStateLiveData != null) {
            return savingStateLiveData;
        }
        SavingStateLiveData<?> savingStateLiveData2 = this.f2629d.containsKey(str) ? new SavingStateLiveData<>(this, str, this.f2629d.get(str)) : z ? new SavingStateLiveData<>(this, str, t) : new SavingStateLiveData<>(this, str);
        this.f2630e.put(str, savingStateLiveData2);
        return savingStateLiveData2;
    }

    private static void d(Object obj) {
        if (obj == null) {
            return;
        }
        for (Class cls : f2628c) {
            if (cls.isInstance(obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
    }

    @NonNull
    SavedStateRegistry.SavedStateProvider c() {
        return this.f2631f;
    }

    @MainThread
    public boolean contains(@NonNull String str) {
        return this.f2629d.containsKey(str);
    }

    @Nullable
    @MainThread
    public <T> T get(@NonNull String str) {
        return (T) this.f2629d.get(str);
    }

    @NonNull
    @MainThread
    public <T> MutableLiveData<T> getLiveData(@NonNull String str) {
        return b(str, false, null);
    }

    @NonNull
    @MainThread
    public Set<String> keys() {
        return Collections.unmodifiableSet(this.f2629d.keySet());
    }

    @Nullable
    @MainThread
    public <T> T remove(@NonNull String str) {
        T t = (T) this.f2629d.remove(str);
        SavingStateLiveData<?> remove = this.f2630e.remove(str);
        if (remove != null) {
            remove.g();
        }
        return t;
    }

    @MainThread
    public <T> void set(@NonNull String str, @Nullable T t) {
        d(t);
        SavingStateLiveData<?> savingStateLiveData = this.f2630e.get(str);
        if (savingStateLiveData != null) {
            savingStateLiveData.setValue(t);
        } else {
            this.f2629d.put(str, t);
        }
    }

    @NonNull
    @MainThread
    public <T> MutableLiveData<T> getLiveData(@NonNull String str, @SuppressLint({"UnknownNullness"}) T t) {
        return b(str, true, t);
    }

    static class SavingStateLiveData<T> extends MutableLiveData<T> {
        private String l;
        private SavedStateHandle m;

        SavingStateLiveData(SavedStateHandle savedStateHandle, String str, T t) {
            super(t);
            this.l = str;
            this.m = savedStateHandle;
        }

        void g() {
            this.m = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T t) {
            SavedStateHandle savedStateHandle = this.m;
            if (savedStateHandle != null) {
                savedStateHandle.f2629d.put(this.l, t);
            }
            super.setValue(t);
        }

        SavingStateLiveData(SavedStateHandle savedStateHandle, String str) {
            this.l = str;
            this.m = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.f2630e = new HashMap();
        this.f2631f = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.SavedStateHandle.1
            AnonymousClass1() {
            }

            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            @NonNull
            public Bundle saveState() {
                Set<String> keySet = SavedStateHandle.this.f2629d.keySet();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
                for (String str : keySet) {
                    arrayList.add(str);
                    arrayList2.add(SavedStateHandle.this.f2629d.get(str));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(SavedStateHandle.f2627b, arrayList);
                bundle.putParcelableArrayList(SavedStateHandle.f2626a, arrayList2);
                return bundle;
            }
        };
        this.f2629d = new HashMap();
    }
}
