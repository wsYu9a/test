package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.lifecycle.MutableLiveData;
import ba.l;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.BookrackCategoryManager;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.yuewen.adapter.BookShelfCategoryAdapter;
import com.martian.mibook.mvvm.yuewen.fragment.ReadingRecordFragment;
import com.martian.mibook.mvvm.yuewen.repository.BookShelfRepository;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookShelfViewModel;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import xi.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookShelfViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/yuewen/repository/BookShelfRepository;", "<init>", "()V", t.f11211k, "()Lcom/martian/mibook/mvvm/yuewen/repository/BookShelfRepository;", "", "sourceStrings", "", "p", "(Ljava/lang/String;)V", "", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter$a;", "n", "()Ljava/util/List;", "Landroidx/lifecycle/MutableLiveData;", "", "h", "Landroidx/lifecycle/MutableLiveData;", "_mBooksUpdateInfo", "i", "q", "()Landroidx/lifecycle/MutableLiveData;", "mBooksUpdateInfo", "", "j", "Z", "s", "()Z", bt.aO, "(Z)V", ReadingRecordFragment.f15650t, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBookShelfViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BookShelfViewModel.kt\ncom/martian/mibook/mvvm/yuewen/viewmodel/BookShelfViewModel\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,69:1\n125#2:70\n152#2,3:71\n1747#3,3:74\n*S KotlinDebug\n*F\n+ 1 BookShelfViewModel.kt\ncom/martian/mibook/mvvm/yuewen/viewmodel/BookShelfViewModel\n*L\n47#1:70\n47#1:71,3\n58#1:74,3\n*E\n"})
/* loaded from: classes3.dex */
public final class BookShelfViewModel extends BaseViewModel<BookShelfRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Integer> _mBooksUpdateInfo;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Integer> mBooksUpdateInfo;

    /* renamed from: j, reason: from kotlin metadata */
    public boolean com.martian.mibook.mvvm.yuewen.fragment.ReadingRecordFragment.t java.lang.String;

    public BookShelfViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._mBooksUpdateInfo = mutableLiveData;
        this.mBooksUpdateInfo = mutableLiveData;
    }

    public static final int o(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    @k
    public final List<BookShelfCategoryAdapter.a> n() {
        Map<String, Integer> categoryCounter = MiConfigSingleton.b2().M1().T().r().getCategoryCounter();
        Intrinsics.checkNotNull(categoryCounter);
        ArrayList arrayList = new ArrayList(categoryCounter.size());
        for (Map.Entry<String, Integer> entry : categoryCounter.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            Intrinsics.checkNotNull(value);
            arrayList.add(new BookShelfCategoryAdapter.a(key, value.intValue()));
        }
        List<BookShelfCategoryAdapter.a> sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: xd.b
            public /* synthetic */ b() {
            }

            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int o10;
                o10 = BookShelfViewModel.o(Function2.this, obj, obj2);
                return o10;
            }
        });
        List<BookShelfCategoryAdapter.a> list = sortedWith;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (StringsKt.equals(BookrackCategoryManager.SECRETE_CATEGORY, ((BookShelfCategoryAdapter.a) it.next()).e(), true)) {
                    return sortedWith;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends BookShelfCategoryAdapter.a>) sortedWith, new BookShelfCategoryAdapter.a(BookrackCategoryManager.SECRETE_CATEGORY, 0));
    }

    public final void p(@k String sourceStrings) {
        Intrinsics.checkNotNullParameter(sourceStrings, "sourceStrings");
        if (l.q(sourceStrings)) {
            this._mBooksUpdateInfo.postValue(0);
        } else {
            j(new BookShelfViewModel$getBooksUpdateInfo$1(this, sourceStrings, null), new BookShelfViewModel$getBooksUpdateInfo$2(this, null), false);
        }
    }

    @k
    public final MutableLiveData<Integer> q() {
        return this.mBooksUpdateInfo;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: r */
    public BookShelfRepository i() {
        return new BookShelfRepository();
    }

    /* renamed from: s, reason: from getter */
    public final boolean getCom.martian.mibook.mvvm.yuewen.fragment.ReadingRecordFragment.t java.lang.String() {
        return this.com.martian.mibook.mvvm.yuewen.fragment.ReadingRecordFragment.t java.lang.String;
    }

    public final void t(boolean z10) {
        this.com.martian.mibook.mvvm.yuewen.fragment.ReadingRecordFragment.t java.lang.String = z10;
    }
}
