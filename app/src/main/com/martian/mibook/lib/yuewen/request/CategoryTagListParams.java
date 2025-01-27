package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.TYAuthoptParams;
import v8.a;

/* loaded from: classes3.dex */
public class CategoryTagListParams extends TYAuthoptParams {

    @a
    private Integer freeType;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "category_tag_list";
    }

    public Integer getFreeType() {
        return this.freeType;
    }

    public void setFreeType(Integer num) {
        this.freeType = num;
    }
}
