package com.martian.libmars.widget.recyclerview.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class PageBean implements Parcelable {
    public static final Parcelable.Creator<PageBean> CREATOR = new Parcelable.Creator<PageBean>() { // from class: com.martian.libmars.widget.recyclerview.bean.PageBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageBean createFromParcel(Parcel source) {
            return new PageBean(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageBean[] newArray(int size) {
            return new PageBean[size];
        }
    };
    private int page;
    private boolean refresh;
    private int rows;
    private int totalCount;
    private int totalPage;

    public PageBean() {
        this.page = 0;
        this.rows = 10;
        this.refresh = true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getLoadPage() {
        if (this.refresh) {
            this.page = 0;
            return 0;
        }
        int i2 = this.page + 1;
        this.page = i2;
        return i2;
    }

    public int getPage() {
        return this.page;
    }

    public int getRows() {
        return this.rows;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public boolean isRefresh() {
        return this.refresh;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRefresh(boolean refresh) {
        this.refresh = refresh;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.page);
        parcel.writeInt(this.rows);
        parcel.writeInt(this.totalCount);
        parcel.writeInt(this.totalPage);
        parcel.writeByte(this.refresh ? (byte) 1 : (byte) 0);
    }

    protected PageBean(Parcel in) {
        this.page = 0;
        this.rows = 10;
        this.refresh = true;
        this.page = in.readInt();
        this.rows = in.readInt();
        this.totalCount = in.readInt();
        this.totalPage = in.readInt();
        this.refresh = in.readByte() != 0;
    }
}
