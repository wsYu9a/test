package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYAuthoptParams;

/* loaded from: classes4.dex */
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

    public void setFreeType(Integer freeType) {
        this.freeType = freeType;
    }
}
