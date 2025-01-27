package com.opos.mobad.service.event;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class EventDescription implements Parcelable {
    public static final Parcelable.Creator<EventDescription> CREATOR = new Parcelable.Creator<EventDescription>() { // from class: com.opos.mobad.service.event.EventDescription.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventDescription createFromParcel(Parcel parcel) {
            return new EventDescription(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventDescription[] newArray(int i2) {
            return new EventDescription[i2];
        }
    };

    /* renamed from: a */
    private String f23598a;

    /* renamed from: com.opos.mobad.service.event.EventDescription$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<EventDescription> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventDescription createFromParcel(Parcel parcel) {
            return new EventDescription(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventDescription[] newArray(int i2) {
            return new EventDescription[i2];
        }
    }

    protected EventDescription(Parcel parcel) {
        this.f23598a = parcel.readString();
    }

    public EventDescription(String str) {
        this.f23598a = str;
    }

    public String a() {
        return this.f23598a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f23598a);
    }
}
