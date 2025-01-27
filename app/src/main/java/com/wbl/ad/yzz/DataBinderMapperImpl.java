package com.wbl.ad.yzz;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes5.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a */
    public static final SparseIntArray f31150a = new SparseIntArray(0);

    public static class a {

        /* renamed from: a */
        public static final SparseArray<String> f31151a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            f31151a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    public static class b {

        /* renamed from: a */
        public static final HashMap<String, Integer> f31152a = new HashMap<>(0);
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    public String convertBrIdToString(int i2) {
        return a.f31151a.get(i2);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        if (f31150a.get(i2) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f31152a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f31150a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
