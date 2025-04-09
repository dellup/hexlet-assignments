package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.NoArgsConstructor;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

// BEGIN
@Value
// END
class Car {
    Object obj = new Object();
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        return User;
    }
    public static Car deserialize(String str) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        Map<String, String> a;
        List<String> ad;
        ad.ge
        return mapper.readValue(str, Car.class);
    }
    // END
}
