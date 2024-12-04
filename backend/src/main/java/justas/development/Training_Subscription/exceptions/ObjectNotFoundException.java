package justas.development.Training_Subscription.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {


    private String objectName;
    private final String id;

    public ObjectNotFoundException(String id) {
        super(String.format("Object with id '%s' not found", id));
        this.id = id;
    }

    public ObjectNotFoundException(String objectName, String id) {
        super(String.format("%s with id '%s' not found", objectName, id));
        this.objectName = objectName;
        this.id = id;
    }

    public ObjectNotFoundException(String objectName, Integer id) {
        super(String.format("%s with id '%s' not found", objectName, id));
        this.objectName = objectName;
        this.id = id.toString();
    }

    public String getObjectName() {
        return objectName;
    }

    public String getId() {
        return id;
    }
}
