package com.martian.mibook.mvvm.read.comment;

import java.util.List;
import kotlin.Metadata;
import xi.l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000eH&J\u0012\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000eH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/martian/mibook/mvvm/read/comment/ItemExpand;", "", "isExpand", "", "()Z", "setExpand", "(Z)V", "itemGroupPosition", "", "getItemGroupPosition", "()I", "setItemGroupPosition", "(I)V", "addDefaultExpandItemSubList", "", "getItemSublist", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ItemExpand {
    @l
    List<Object> addDefaultExpandItemSubList();

    int getItemGroupPosition();

    @l
    List<Object> getItemSublist();

    boolean isExpand();

    void setExpand(boolean z10);

    void setItemGroupPosition(int i10);
}
