package br.com.connemat.sysmat;

import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

import br.com.connemat.model.entity.InstanceDataSourceConfig;

public class PojoToSchema {

	public PojoToSchema() {
	}

	public static void main(String[] args) throws Exception {
	    ObjectMapper mapper = new ObjectMapper();
	    JsonSchemaGenerator generator = new JsonSchemaGenerator(mapper);
	    JsonSchema jsonSchema = generator.generateSchema(InstanceDataSourceConfig.class);

	    StringWriter json = new StringWriter();
	    mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	    mapper.writeValue(json, jsonSchema);

	    System.out.println(json.toString());
	}

}
