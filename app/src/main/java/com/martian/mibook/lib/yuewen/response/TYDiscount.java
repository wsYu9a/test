package com.martian.mibook.lib.yuewen.response;

import com.martian.mibook.lib.model.data.TYBookItem;
import java.util.List;

/* loaded from: classes4.dex */
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

    public void setBooks(List<TYBookItem> books) {
        this.books = books;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDistType(Integer distType) {
        this.distType = distType;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
}
