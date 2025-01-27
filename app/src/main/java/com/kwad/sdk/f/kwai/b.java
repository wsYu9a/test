package com.kwad.sdk.f.kwai;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bb;

@KsJson
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public String atm;
    public String atn;
    public String ato;
    public long atp;
    public String atq;
    public boolean atr;
    public int loadType;
    public int packageType;
    public String packageUrl;
    public String version;

    public final long Az() {
        return this.atp;
    }

    public final void aa(long j2) {
        this.atp = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (bb.isEquals(this.atm, bVar.atm) && bb.isEquals(this.atq, bVar.atq) && bb.isEquals(this.version, bVar.version)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.atm);
        sb.append("_");
        sb.append(this.atq);
        sb.append("_");
        sb.append(this.version);
        return TextUtils.isEmpty(sb.toString()) ? super.hashCode() : sb.toString().hashCode();
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.atm) || TextUtils.isEmpty(this.packageUrl) || TextUtils.isEmpty(this.version) || TextUtils.isEmpty(this.atn)) ? false : true;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    @NonNull
    public String toString() {
        return "PackageInfoBean{packageId='" + this.atm + "', zipFileName='" + this.atn + "', zipPath='" + this.ato + "', startDownloadTime=" + this.atp + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.atq + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.atr + '}';
    }
}
