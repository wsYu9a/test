package com.martian.mibook.mvvm.widget;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import id.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/martian/mibook/mvvm/widget/ScreenSlidePagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Landroidx/fragment/app/Fragment;", "fragmentList", "", "pageTitleList", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;Ljava/util/List;)V", "", "getCount", "()I", c.f26972i, "getItem", "(I)Landroidx/fragment/app/Fragment;", "", "getPageTitle", "(I)Ljava/lang/CharSequence;", "a", "Ljava/util/List;", "()Ljava/util/List;", "b", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ScreenSlidePagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a, reason: from kotlin metadata */
    @k
    public final List<Fragment> fragmentList;

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public final List<String> pageTitleList;

    public /* synthetic */ ScreenSlidePagerAdapter(FragmentManager fragmentManager, List list, List list2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentManager, list, (i10 & 4) != 0 ? null : list2);
    }

    @k
    public final List<Fragment> a() {
        return this.fragmentList;
    }

    @l
    public final List<String> b() {
        return this.pageTitleList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.fragmentList.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @k
    public Fragment getItem(int r22) {
        return this.fragmentList.get(r22);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @k
    public CharSequence getPageTitle(int r22) {
        List<String> list = this.pageTitleList;
        return list == null ? "" : list.get(r22);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ScreenSlidePagerAdapter(@k FragmentManager fragmentManager, @k List<? extends Fragment> fragmentList, @l List<String> list) {
        super(fragmentManager, 1);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragmentList, "fragmentList");
        this.fragmentList = fragmentList;
        this.pageTitleList = list;
    }
}
