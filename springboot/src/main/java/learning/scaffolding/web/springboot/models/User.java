package learning.scaffolding.web.springboot.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
public class User {

    @Id
    public int id;

    public String firstName;

    public String lastName;
}
