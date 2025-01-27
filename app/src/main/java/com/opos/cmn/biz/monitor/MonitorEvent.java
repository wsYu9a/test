package com.opos.cmn.biz.monitor;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class MonitorEvent implements Parcelable {
    public static final Parcelable.Creator<MonitorEvent> CREATOR = new Parcelable.Creator<MonitorEvent>() { // from class: com.opos.cmn.biz.monitor.MonitorEvent.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MonitorEvent createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, AnonymousClass1.class.getClassLoader());
            return new MonitorEvent(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MonitorEvent[] newArray(int i2) {
            return new MonitorEvent[i2];
        }
    };

    /* renamed from: a */
    private int f16624a;

    /* renamed from: b */
    private int f16625b;

    /* renamed from: c */
    private int f16626c;

    /* renamed from: d */
    private int f16627d;

    /* renamed from: e */
    private int f16628e;

    /* renamed from: f */
    private String f16629f;

    /* renamed from: g */
    private String f16630g;

    /* renamed from: h */
    private int f16631h;

    /* renamed from: i */
    private String f16632i;

    /* renamed from: j */
    private String f16633j;
    private List<String> k;

    /* renamed from: com.opos.cmn.biz.monitor.MonitorEvent$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<MonitorEvent> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MonitorEvent createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, AnonymousClass1.class.getClassLoader());
            return new MonitorEvent(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MonitorEvent[] newArray(int i2) {
            return new MonitorEvent[i2];
        }
    }

    public enum a {
        BTN("1"),
        EXTRA("2");


        /* renamed from: c */
        private String f16637c;

        a(String str) {
            this.f16637c = "";
            this.f16637c = str;
        }

        public String a() {
            return this.f16637c;
        }
    }

    public static class b {

        /* renamed from: i */
        private a f16646i;

        /* renamed from: a */
        private int f16638a = -1;

        /* renamed from: b */
        private int f16639b = -999;

        /* renamed from: c */
        private int f16640c = -999;

        /* renamed from: d */
        private int f16641d = -999;

        /* renamed from: e */
        private int f16642e = -999;

        /* renamed from: f */
        private c f16643f = c.OTHER;

        /* renamed from: g */
        private d f16644g = d.OTHER;

        /* renamed from: h */
        private int f16645h = 1;

        /* renamed from: j */
        private String f16647j = "";
        private List<String> k = new ArrayList();

        public b a(int i2) {
            if (i2 >= 0) {
                this.f16638a = i2;
            }
            return this;
        }

        public b a(int i2, int i3, int i4, int i5) {
            if (i2 >= 0 && i3 >= 0 && i4 >= 0 && i5 >= 0) {
                this.f16639b = i2;
                this.f16640c = i3;
                this.f16641d = i4;
                this.f16642e = i5;
            }
            return this;
        }

        public b a(a aVar) {
            this.f16646i = aVar;
            return this;
        }

        public b a(c cVar) {
            if (cVar != null) {
                this.f16643f = cVar;
            }
            return this;
        }

        public b a(d dVar) {
            if (dVar != null) {
                this.f16644g = dVar;
            }
            return this;
        }

        public b a(String str) {
            this.f16647j = str;
            return this;
        }

        public MonitorEvent a() {
            a aVar = this.f16646i;
            return new MonitorEvent(this.f16638a, this.f16639b, this.f16640c, this.f16641d, this.f16642e, this.f16643f.a(), this.f16644g.a(), this.f16645h, aVar != null ? aVar.a() : "", this.f16647j, this.k);
        }
    }

    public enum c {
        IMAGE("1"),
        CLICK_BUTTON("2"),
        TEXT("3"),
        OPEN_BUTTON("4"),
        OTHER("0");


        /* renamed from: f */
        private String f16654f;

        c(String str) {
            this.f16654f = str;
        }

        public String a() {
            return this.f16654f;
        }
    }

    public enum d {
        WEB_URL("1"),
        DEEP_LINK("2"),
        APP_HOME("3"),
        QA("4"),
        APP_SHOP("5"),
        DOWNLOADER("6"),
        OTHER("0"),
        MINI_PROGRAM("7");


        /* renamed from: i */
        private String f16664i;

        d(String str) {
            this.f16664i = str;
        }

        public String a() {
            return this.f16664i;
        }
    }

    private MonitorEvent(int i2, int i3, int i4, int i5, int i6, String str, String str2, int i7, String str3, String str4, List<String> list) {
        this.f16624a = -1;
        this.f16624a = i2;
        this.f16625b = i3;
        this.f16626c = i4;
        this.f16627d = i5;
        this.f16628e = i6;
        this.f16629f = str;
        this.f16630g = str2;
        this.f16631h = i7;
        this.f16632i = str3;
        this.f16633j = str4;
        this.k = list;
    }

    /* synthetic */ MonitorEvent(int i2, int i3, int i4, int i5, int i6, String str, String str2, int i7, String str3, String str4, List list, AnonymousClass1 anonymousClass1) {
        this(i2, i3, i4, i5, i6, str, str2, i7, str3, str4, list);
    }

    public int a() {
        return this.f16624a;
    }

    public int b() {
        return this.f16625b;
    }

    public int c() {
        return this.f16626c;
    }

    public int d() {
        return this.f16627d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f16628e;
    }

    public String f() {
        return this.f16629f;
    }

    public String g() {
        return this.f16630g;
    }

    public int h() {
        return this.f16631h;
    }

    public String i() {
        return this.f16632i;
    }

    public String j() {
        return this.f16633j;
    }

    public String k() {
        StringBuilder sb = new StringBuilder();
        if (this.k != null) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                sb.append(this.k.get(i2).trim());
                if (i2 < this.k.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.k);
        parcel.writeInt(this.f16624a);
        parcel.writeInt(this.f16625b);
        parcel.writeInt(this.f16626c);
        parcel.writeInt(this.f16627d);
        parcel.writeInt(this.f16628e);
        parcel.writeString(this.f16629f);
        parcel.writeString(this.f16630g);
        parcel.writeInt(this.f16631h);
        parcel.writeString(this.f16632i);
        parcel.writeString(this.f16633j);
    }
}
