package com.google.gason.internal.bind;

import com.google.gason.JsonSyntaxException;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;

/* loaded from: classes7.dex */
public final class BigDecimalTypeAdapter extends TypeAdapter<BigDecimal> {
    @Override // com.google.gason.internal.bind.TypeAdapter
    public BigDecimal read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new BigDecimal(jsonReader.nextString());
        } catch (NumberFormatException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
        jsonWriter.value(bigDecimal);
    }
}
