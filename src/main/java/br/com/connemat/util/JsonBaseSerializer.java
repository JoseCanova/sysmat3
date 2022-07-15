package br.com.connemat.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.connemat.Base;

public class JsonBaseSerializer<T extends Base<?>> extends StdSerializer<T> {

	private static final long serialVersionUID = 1L;

	public JsonBaseSerializer(){
		super(getClazz());
	}

	public JsonBaseSerializer(Class<T> clazz){
		super(clazz);
	}
	public static <T>  Class<T> getClazz() {
		return (Class<T>) Base.class;
	}

	@Override
	public void serialize(T value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		if (value !=null) {
			gen.writeObjectField( "id", value.getId());
		}else 
			gen.writeNull();
        gen.writeEndObject();

	}
}