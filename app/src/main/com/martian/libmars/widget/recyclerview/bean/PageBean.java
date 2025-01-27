package com.martian.libmars.widget.recyclerview.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class PageBean implements Parcelable {
    public static final Parcelable.Creator<PageBean> CREATOR = new Parcelable.Creator<PageBean>() { // from class: com.martian.libmars.widget.recyclerview.bean.PageBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageBean createFromParcel(Parcel parcel) {
            return new PageBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageBean[] newArray(int i10) {
            return new PageBean[i10];
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
        int i10 = this.page + 1;
        this.page = i10;
        return i10;
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

    public void setPage(int i10) {
        this.page = i10;
    }

    public void setRefresh(boolean z10) {
        this.refresh = z10;
    }

    public void setRows(int i10) {
        this.rows = i10;
    }

    public void setTotalCount(int i10) {
        this.totalCount = i10;
    }

    public void setTotalPage(int i10) {
        this.totalPage = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.page);
        parcel.writeInt(this.rows);
        parcel.writeInt(this.totalCount);
        parcel.writeInt(this.totalPage);
        parcel.writeByte(this.refresh ? (byte) 1 : (byte) 0);
    }

    public PageBean(Parcel parcel) {
        this.page = 0;
        this.rows = 10;
        this.refresh = true;
        this.page = parcel.readInt();
        this.rows = parcel.readInt();
        this.totalCount = parcel.readInt();
        this.totalPage = parcel.readInt();
        this.refresh = parcel.readByte() != 0;
    }
}
