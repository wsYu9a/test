package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
final class n implements Comparable<n>, Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new a();

    /* renamed from: a */
    @NonNull
    private final Calendar f7071a;

    /* renamed from: b */
    @NonNull
    private final String f7072b;

    /* renamed from: c */
    final int f7073c;

    /* renamed from: d */
    final int f7074d;

    /* renamed from: e */
    final int f7075e;

    /* renamed from: f */
    final int f7076f;

    /* renamed from: g */
    final long f7077g;

    static class a implements Parcelable.Creator<n> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public n createFromParcel(@NonNull Parcel parcel) {
            return n.b(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public n[] newArray(int i2) {
            return new n[i2];
        }
    }

    private n(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar f2 = w.f(calendar);
        this.f7071a = f2;
        this.f7073c = f2.get(2);
        this.f7074d = f2.get(1);
        this.f7075e = f2.getMaximum(7);
        this.f7076f = f2.getActualMaximum(5);
        this.f7072b = w.z().format(f2.getTime());
        this.f7077g = f2.getTimeInMillis();
    }

    @NonNull
    static n b(int i2, int i3) {
        Calendar v = w.v();
        v.set(1, i2);
        v.set(2, i3);
        return new n(v);
    }

    @NonNull
    static n d(long j2) {
        Calendar v = w.v();
        v.setTimeInMillis(j2);
        return new n(v);
    }

    @NonNull
    static n e() {
        return new n(w.t());
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull n nVar) {
        return this.f7071a.compareTo(nVar.f7071a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f7073c == nVar.f7073c && this.f7074d == nVar.f7074d;
    }

    int f() {
        int firstDayOfWeek = this.f7071a.get(7) - this.f7071a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f7075e : firstDayOfWeek;
    }

    long g(int i2) {
        Calendar f2 = w.f(this.f7071a);
        f2.set(5, i2);
        return f2.getTimeInMillis();
    }

    @NonNull
    String h() {
        return this.f7072b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7073c), Integer.valueOf(this.f7074d)});
    }

    long i() {
        return this.f7071a.getTimeInMillis();
    }

    @NonNull
    n j(int i2) {
        Calendar f2 = w.f(this.f7071a);
        f2.add(2, i2);
        return new n(f2);
    }

    int k(@NonNull n nVar) {
        if (this.f7071a instanceof GregorianCalendar) {
            return ((nVar.f7074d - this.f7074d) * 12) + (nVar.f7073c - this.f7073c);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeInt(this.f7074d);
        parcel.writeInt(this.f7073c);
    }
}
