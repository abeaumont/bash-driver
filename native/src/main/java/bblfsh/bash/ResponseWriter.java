package bblfsh.bash;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.intellij.lang.ASTNode;

import java.io.IOException;
import java.io.OutputStream;

public class ResponseWriter {

    private final OutputStream out;
    private final ObjectMapper mapper;

    public ResponseWriter(final OutputStream out) {
        this.out = out;
        this.mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        SimpleModule module = new SimpleModule();
        module.addSerializer(ASTNode.class, new ASTNodeSerializer());
        mapper.registerModule(module);
    }

    public void write(final Response response) throws IOException {
        mapper.writeValue(this.out, response);
        this.out.write('\n');
    }

}
