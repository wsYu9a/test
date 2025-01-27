package com.martian.mibook.mvvm.category.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagGroup;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.category.repository.CategoryRepository;
import java.util.List;
import kotlin.Metadata;
import xi.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R%\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u000bR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/martian/mibook/mvvm/category/viewmodel/CategoryViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/category/repository/CategoryRepository;", "<init>", "()V", "p", "()Lcom/martian/mibook/mvvm/category/repository/CategoryRepository;", "", "freeType", "", "n", "(I)V", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/martian/mibook/lib/yuewen/response/TYCategoryTagGroup;", "h", "Landroidx/lifecycle/MutableLiveData;", "_mCategoryTagListLiveData", "i", "o", "()Landroidx/lifecycle/MutableLiveData;", "mCategoryTagListLiveData", "j", "I", "m", "()I", t.f11211k, "cType", "", "k", "Z", "q", "()Z", "s", "(Z)V", "isHomepage", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class CategoryViewModel extends BaseViewModel<CategoryRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYCategoryTagGroup>> _mCategoryTagListLiveData;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYCategoryTagGroup>> mCategoryTagListLiveData;

    /* renamed from: j, reason: from kotlin metadata */
    public int cType;

    /* renamed from: k, reason: from kotlin metadata */
    public boolean isHomepage;

    public CategoryViewModel() {
        MutableLiveData<List<TYCategoryTagGroup>> mutableLiveData = new MutableLiveData<>();
        this._mCategoryTagListLiveData = mutableLiveData;
        this.mCategoryTagListLiveData = mutableLiveData;
        this.cType = 1;
    }

    /* renamed from: m, reason: from getter */
    public final int getCType() {
        return this.cType;
    }

    public final void n(int freeType) {
        j(new CategoryViewModel$getCategoryTagList$1(this, freeType, null), new CategoryViewModel$getCategoryTagList$2(this, null), true);
    }

    @k
    public final MutableLiveData<List<TYCategoryTagGroup>> o() {
        return this.mCategoryTagListLiveData;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: p */
    public CategoryRepository i() {
        return new CategoryRepository();
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsHomepage() {
        return this.isHomepage;
    }

    public final void r(int i10) {
        this.cType = i10;
    }

    public final void s(boolean z10) {
        this.isHomepage = z10;
    }
}
