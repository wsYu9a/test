package com.ss.android.socialbase.downloader.exception;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: classes4.dex */
public class BaseException extends Exception implements Parcelable {
    public static final Parcelable.Creator<BaseException> CREATOR = new Parcelable.Creator<BaseException>() { // from class: com.ss.android.socialbase.downloader.exception.BaseException.1
        @Override // android.os.Parcelable.Creator
        public BaseException createFromParcel(Parcel parcel) {
            return new BaseException(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BaseException[] newArray(int i10) {
            return new BaseException[i10];
        }
    };
    private static final String TAG = "[d-ex]:";
    private int errorCode;
    private String errorMsg;
    private String extraInfo;

    /* renamed from: com.ss.android.socialbase.downloader.exception.BaseException$1 */
    public static class AnonymousClass1 implements Parcelable.Creator<BaseException> {
        @Override // android.os.Parcelable.Creator
        public BaseException createFromParcel(Parcel parcel) {
            return new BaseException(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BaseException[] newArray(int i10) {
            return new BaseException[i10];
        }
    }

    public BaseException() {
        this.extraInfo = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public void readFromParcel(Parcel parcel) {
        this.errorCode = parcel.readInt();
        this.errorMsg = parcel.readString();
        this.extraInfo = parcel.readString();
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorMsg);
        parcel.writeString(this.extraInfo);
    }

    public BaseException(int i10, String str) {
        super(TAG + str);
        this.extraInfo = "";
        this.errorMsg = TAG + str;
        this.errorCode = i10;
    }

    public BaseException(int i10, Throwable th2) {
        this(i10, DownloadUtils.getThrowableMsg(th2));
    }

    public BaseException(int i10, String str, Throwable th2) {
        super(TAG + str, th2);
        this.extraInfo = "";
        this.errorMsg = TAG + str;
        this.errorCode = i10;
    }

    public BaseException(Parcel parcel) {
        this.extraInfo = "";
        readFromParcel(parcel);
    }
}
