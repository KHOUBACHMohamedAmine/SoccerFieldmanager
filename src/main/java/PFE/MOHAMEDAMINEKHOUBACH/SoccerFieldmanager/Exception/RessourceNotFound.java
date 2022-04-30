package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFound extends RuntimeException{
    private String ressourceName;
    private String fieldName;
    private Object fieldValue;


    public RessourceNotFound() {
    }
    public RessourceNotFound(String ressourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : %s",ressourceName,fieldName,fieldValue));
        this.ressourceName = ressourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getRessourceName() {
        return ressourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
