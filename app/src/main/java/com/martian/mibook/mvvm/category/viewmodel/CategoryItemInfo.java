package com.martian.mibook.mvvm.category.viewmodel;

import com.martian.libmars.widget.linkage.BaseLinkageItem;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagItem;
import h3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import xi.l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B/\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB#\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/martian/mibook/mvvm/category/viewmodel/CategoryItemInfo;", "Lcom/martian/libmars/widget/linkage/BaseLinkageItem;", "title", "", "(Ljava/lang/String;)V", "group", e.f26408m, "Lcom/martian/mibook/lib/yuewen/response/TYCategoryTagItem;", "layoutType", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/martian/mibook/lib/yuewen/response/TYCategoryTagItem;I)V", "itemName", "parentName", "isGroup", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getData", "()Lcom/martian/mibook/lib/yuewen/response/TYCategoryTagItem;", "setData", "(Lcom/martian/mibook/lib/yuewen/response/TYCategoryTagItem;)V", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CategoryItemInfo extends BaseLinkageItem {

    @l
    private TYCategoryTagItem data;
    private int layoutType;

    public /* synthetic */ CategoryItemInfo(String str, String str2, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? false : z10);
    }

    @l
    public final TYCategoryTagItem getData() {
        return this.data;
    }

    public final void setData(@l TYCategoryTagItem tYCategoryTagItem) {
        this.data = tYCategoryTagItem;
    }

    public CategoryItemInfo(@l String str, @l String str2, boolean z10) {
        super(str, str2, z10);
        this.layoutType = 1;
    }

    public CategoryItemInfo(@l String str) {
        this("", str, true);
    }

    public CategoryItemInfo(@l String str, @l String str2, @l TYCategoryTagItem tYCategoryTagItem, int i10) {
        this(str, str2, false);
        this.data = tYCategoryTagItem;
        this.layoutType = i10;
    }

    public /* synthetic */ CategoryItemInfo(String str, String str2, TYCategoryTagItem tYCategoryTagItem, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, tYCategoryTagItem, (i11 & 8) != 0 ? 1 : i10);
    }
}
