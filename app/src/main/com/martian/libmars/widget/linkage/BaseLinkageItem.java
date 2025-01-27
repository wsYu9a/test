package com.martian.libmars.widget.linkage;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import xi.l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/martian/libmars/widget/linkage/BaseLinkageItem;", "Ljava/io/Serializable;", "itemName", "", "parentName", "isGroup", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setGroup", "(Z)V", "getItemName", "()Ljava/lang/String;", "setItemName", "(Ljava/lang/String;)V", "getParentName", "setParentName", "libmars_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BaseLinkageItem implements Serializable {
    private boolean isGroup;

    @l
    private String itemName;

    @l
    private String parentName;

    public BaseLinkageItem(@l String str, @l String str2, boolean z10) {
        this.itemName = str;
        this.parentName = str2;
        this.isGroup = z10;
    }

    @l
    public final String getItemName() {
        return this.itemName;
    }

    @l
    public final String getParentName() {
        return this.parentName;
    }

    /* renamed from: isGroup, reason: from getter */
    public final boolean getIsGroup() {
        return this.isGroup;
    }

    public final void setGroup(boolean z10) {
        this.isGroup = z10;
    }

    public final void setItemName(@l String str) {
        this.itemName = str;
    }

    public final void setParentName(@l String str) {
        this.parentName = str;
    }

    public /* synthetic */ BaseLinkageItem(String str, String str2, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? false : z10);
    }
}
