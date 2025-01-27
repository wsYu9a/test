package com.martian.mibook.lib.yuewen.response;

import com.martian.mibook.lib.model.data.TYBookItem;
import java.util.List;

/* loaded from: classes3.dex */
public class TYDiscount {
    private List<TYBookItem> books;
    private String desc;
    private Integer distType;
    private Long endTime;
    private String name;
    private Integer price;
    private Long startTime;

    public List<TYBookItem> getBooks() {
        return this.books;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getDistType() {
        Integer num = this.distType;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public long getEndTime() {
        return this.endTime.longValue();
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        Integer num = this.price;
        if (num == null) {
            return 100;
        }
        return num.intValue();
    }

    public long getStartTime() {
        return this.startTime.longValue();
    }

    public void setBooks(List<TYBookItem> list) {
        this.books = list;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDistType(Integer num) {
        this.distType = num;
    }

    public void setEndTime(Long l10) {
        this.endTime = l10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrice(Integer num) {
        this.price = num;
    }

    public void setStartTime(Long l10) {
        this.startTime = l10;
    }
}
