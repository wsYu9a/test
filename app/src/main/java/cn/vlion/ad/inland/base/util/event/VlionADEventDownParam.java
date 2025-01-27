package cn.vlion.ad.inland.base.util.event;

/* loaded from: classes.dex */
public class VlionADEventDownParam {
    private String pkg;
    private String pkg_path;
    private int size;

    public VlionADEventDownParam(String str, String str2, int i10) {
        this.pkg_path = str;
        this.pkg = str2;
        this.size = i10;
    }

    public String getPkg() {
        return this.pkg;
    }

    public String getPkg_path() {
        return this.pkg_path;
    }

    public int getSize() {
        return this.size;
    }
}
