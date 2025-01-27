package com.opos.mobad.activity.webview;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: classes4.dex */
public class WebDataHepler implements Parcelable {
    public static final Parcelable.Creator<WebDataHepler> CREATOR = new Parcelable.Creator<WebDataHepler>() { // from class: com.opos.mobad.activity.webview.WebDataHepler.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WebDataHepler createFromParcel(Parcel parcel) {
            return new WebDataHepler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WebDataHepler[] newArray(int i2) {
            return new WebDataHepler[i2];
        }
    };

    /* renamed from: a */
    private AdItemData f19379a;

    /* renamed from: b */
    private String f19380b;

    /* renamed from: c */
    private String f19381c;

    /* renamed from: d */
    private String f19382d;

    /* renamed from: e */
    private String f19383e;

    /* renamed from: f */
    private EventDescription f19384f;

    /* renamed from: g */
    private int f19385g;

    /* renamed from: h */
    private boolean f19386h;

    /* renamed from: i */
    private boolean f19387i;

    /* renamed from: j */
    private ComplianceInfo f19388j;

    /* renamed from: com.opos.mobad.activity.webview.WebDataHepler$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<WebDataHepler> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WebDataHepler createFromParcel(Parcel parcel) {
            return new WebDataHepler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WebDataHepler[] newArray(int i2) {
            return new WebDataHepler[i2];
        }
    }

    public WebDataHepler(Parcel parcel) {
        this.f19379a = (AdItemData) parcel.readParcelable(AdItemData.class.getClassLoader());
        this.f19380b = parcel.readString();
        this.f19381c = parcel.readString();
        this.f19382d = parcel.readString();
        this.f19384f = (EventDescription) parcel.readParcelable(EventDescription.class.getClassLoader());
        this.f19383e = parcel.readString();
        this.f19385g = parcel.readInt();
        this.f19386h = parcel.readInt() == 1;
        this.f19387i = parcel.readInt() == 1;
        this.f19388j = (ComplianceInfo) parcel.readParcelable(ComplianceInfo.class.getClassLoader());
    }

    public WebDataHepler(ComplianceInfo complianceInfo, EventDescription eventDescription, int i2) {
        this.f19388j = complianceInfo;
        this.f19384f = eventDescription;
        this.f19385g = i2;
    }

    public WebDataHepler(AdItemData adItemData, String str, String str2, String str3, String str4, EventDescription eventDescription, int i2) {
        this(adItemData, str, str2, str3, str4, eventDescription, i2, true, true);
    }

    public WebDataHepler(AdItemData adItemData, String str, String str2, String str3, String str4, EventDescription eventDescription, int i2, boolean z, boolean z2) {
        this.f19379a = adItemData;
        this.f19380b = str;
        this.f19381c = str2;
        this.f19382d = str3;
        this.f19383e = str4;
        this.f19384f = eventDescription;
        this.f19385g = i2;
        this.f19386h = z;
        this.f19387i = z2;
    }

    public AdItemData a() {
        return this.f19379a;
    }

    public String b() {
        return this.f19380b;
    }

    public String c() {
        return this.f19381c;
    }

    public String d() {
        return this.f19382d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f19383e;
    }

    public EventDescription f() {
        return this.f19384f;
    }

    public int g() {
        return this.f19385g;
    }

    public ComplianceInfo h() {
        return this.f19388j;
    }

    public boolean i() {
        return this.f19386h;
    }

    public boolean j() {
        return this.f19387i;
    }

    public String toString() {
        return "WebDataHepler{mAdItemData=" + this.f19379a + ", mPosId='" + this.f19380b + "', mJsSign='" + this.f19381c + "', mWebUrl='" + this.f19382d + "', mVideoUrl='" + this.f19383e + "', mLandingPageId='" + this.f19384f + "', mActionType=" + this.f19385g + ", mShowTitleBar=" + this.f19386h + ", mFitsSystemWindows=" + this.f19387i + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f19379a, i2);
        parcel.writeString(this.f19380b);
        parcel.writeString(this.f19381c);
        parcel.writeString(this.f19382d);
        parcel.writeParcelable(this.f19384f, i2);
        parcel.writeString(this.f19383e);
        parcel.writeInt(this.f19385g);
        parcel.writeInt(this.f19386h ? 1 : 0);
        parcel.writeInt(this.f19387i ? 1 : 0);
        parcel.writeParcelable(this.f19388j, i2);
    }
}
