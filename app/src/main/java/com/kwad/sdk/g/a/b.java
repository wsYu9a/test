package com.kwad.sdk.g.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bm;
import hf.e;

@KsJson
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public String aMA;
    public long aMB;
    public boolean aMC;
    public String aMy;
    public String aMz;
    public String amT;
    public int loadType;
    public int packageType;
    public String packageUrl;
    public String version;

    public final long Kj() {
        return this.aMB;
    }

    public final void aI(long j10) {
        this.aMB = j10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (bm.isEquals(this.aMy, bVar.aMy) && bm.isEquals(this.amT, bVar.amT) && bm.isEquals(this.version, bVar.version)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.aMy);
        sb2.append(e.f26694a);
        sb2.append(this.amT);
        sb2.append(e.f26694a);
        sb2.append(this.version);
        return TextUtils.isEmpty(sb2.toString()) ? super.hashCode() : sb2.toString().hashCode();
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.aMy) || TextUtils.isEmpty(this.packageUrl) || TextUtils.isEmpty(this.version) || TextUtils.isEmpty(this.aMz)) ? false : true;
    }

    @Override // com.kwad.sdk.core.response.a.a
    @NonNull
    public String toString() {
        return "PackageInfoBean{packageId='" + this.aMy + "', zipFileName='" + this.aMz + "', zipPath='" + this.aMA + "', startDownloadTime=" + this.aMB + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.amT + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.aMC + '}';
    }
}
