package com.jd.ad.sdk.jad_qb;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_kv.jad_dq;
import com.jd.ad.sdk.jad_qb.jad_na;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

/* loaded from: classes2.dex */
public class jad_fs<Data> implements jad_na<File, Data> {
    public final jad_dq<Data> jad_an;

    public static class jad_an<Data> implements jad_ob<File, Data> {
        public final jad_dq<Data> jad_an;

        public jad_an(jad_dq<Data> jad_dqVar) {
            this.jad_an = jad_dqVar;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @NonNull
        public final jad_na<File, Data> jad_an(@NonNull jad_re jad_reVar) {
            return new jad_fs(this.jad_an);
        }
    }

    public static class jad_bo extends jad_an<ParcelFileDescriptor> {

        public class jad_an implements jad_dq<ParcelFileDescriptor> {
            @Override // com.jd.ad.sdk.jad_qb.jad_fs.jad_dq
            public Class<ParcelFileDescriptor> jad_an() {
                return ParcelFileDescriptor.class;
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_fs.jad_dq
            public void jad_an(ParcelFileDescriptor parcelFileDescriptor) {
                parcelFileDescriptor.close();
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_fs.jad_dq
            public ParcelFileDescriptor jad_an(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public jad_bo() {
            super(new jad_an());
        }
    }

    public static final class jad_cp<Data> implements com.jd.ad.sdk.jad_kv.jad_dq<Data> {
        public final File jad_an;
        public final jad_dq<Data> jad_bo;
        public Data jad_cp;

        public jad_cp(File file, jad_dq<Data> jad_dqVar) {
            this.jad_an = file;
            this.jad_bo = jad_dqVar;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @NonNull
        public Class<Data> jad_an() {
            return this.jad_bo.jad_an();
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_bo() {
            Data data = this.jad_cp;
            if (data != null) {
                try {
                    this.jad_bo.jad_an((jad_dq<Data>) data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @NonNull
        public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r5v3, types: [Data, java.lang.Object] */
        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(@NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @NonNull jad_dq.jad_an<? super Data> jad_anVar) {
            try {
                Data jad_an = this.jad_bo.jad_an(this.jad_an);
                this.jad_cp = jad_an;
                jad_anVar.jad_an((jad_dq.jad_an<? super Data>) jad_an);
            } catch (FileNotFoundException e10) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Logger.d("FileLoader", "Failed to open file", e10);
                }
                jad_anVar.jad_an((Exception) e10);
            }
        }
    }

    public interface jad_dq<Data> {
        Class<Data> jad_an();

        Data jad_an(File file);

        void jad_an(Data data);
    }

    public static class jad_er extends jad_an<InputStream> {

        public class jad_an implements jad_dq<InputStream> {
            @Override // com.jd.ad.sdk.jad_qb.jad_fs.jad_dq
            public Class<InputStream> jad_an() {
                return InputStream.class;
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_fs.jad_dq
            public void jad_an(InputStream inputStream) {
                inputStream.close();
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_fs.jad_dq
            public InputStream jad_an(File file) {
                return new FileInputStream(file);
            }
        }

        public jad_er() {
            super(new jad_an());
        }
    }

    public jad_fs(jad_dq<Data> jad_dqVar) {
        this.jad_an = jad_dqVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull File file) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an jad_an(@NonNull File file, int i10, int i11, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        File file2 = file;
        return new jad_na.jad_an(new com.jd.ad.sdk.jad_hq.jad_bo(file2), Collections.emptyList(), new jad_cp(file2, this.jad_an));
    }
}
