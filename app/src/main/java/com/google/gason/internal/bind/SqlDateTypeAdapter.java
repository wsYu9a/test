package com.google.gason.internal.bind;

import android.support.v4.view.C0008;
import com.google.gason.C0107;
import com.google.gason.JsonSyntaxException;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes7.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapter.Factory FACTORY;

    /* renamed from: short */
    private static final short[] f82short;
    private final DateFormat format = new SimpleDateFormat(C0107.m50(f82short, 56443 ^ C0008.m27((Object) "ۤ۟"), 1751527 ^ C0008.m27((Object) "ۤ۠ۨ"), C0008.m27((Object) "ۦۦ۟") ^ 1755427));

    /* renamed from: com.google.gason.internal.bind.SqlDateTypeAdapter$1 */
    static class AnonymousClass1 implements TypeAdapter.Factory {
        AnonymousClass1() {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(1053849)}[0]).intValue() ^ 1053842];
        sArr[0] = 2929;
        sArr[1] = 2929;
        sArr[2] = 2929;
        sArr[3] = 2844;
        sArr[4] = 2904;
        sArr[5] = 2832;
        sArr[6] = 2844;
        sArr[7] = 2885;
        sArr[8] = 2885;
        sArr[9] = 2885;
        sArr[10] = 2885;
        f82short = sArr;
        FACTORY = new TypeAdapter.Factory() { // from class: com.google.gason.internal.bind.SqlDateTypeAdapter.1
            AnonymousClass1() {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter.Factory
            public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == Date.class) {
                    return new SqlDateTypeAdapter();
                }
                return null;
            }
        };
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        synchronized (this) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new Date(this.format.parse(jsonReader.nextString()).getTime());
            } catch (ParseException e2) {
                throw new JsonSyntaxException(e2);
            }
        }
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        synchronized (this) {
            jsonWriter.value(date == null ? null : this.format.format((java.util.Date) date));
        }
    }
}
