package b7;

/* loaded from: classes2.dex */
public class h extends d {
    public String L;
    public String M;
    public String N;
    public String O;

    @Override // b7.d
    public int getType() {
        return 4103;
    }

    public String h() {
        return this.O;
    }

    public String i() {
        return this.M;
    }

    public String j() {
        return this.N;
    }

    public String k() {
        return this.L;
    }

    public void l(String str) {
        this.O = str;
    }

    public void m(String str) {
        this.M = str;
    }

    public void n(String str) {
        this.N = str;
    }

    public void o(String str) {
        this.L = str;
    }

    public String toString() {
        return "SptDataMessage{mGlobalID='" + this.L + "', mContent='" + this.M + "', mDescription='" + this.N + "', mAppID='" + this.O + "'}";
    }
}
