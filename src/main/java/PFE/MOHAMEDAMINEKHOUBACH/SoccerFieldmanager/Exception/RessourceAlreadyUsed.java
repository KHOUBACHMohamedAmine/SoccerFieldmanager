package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class RessourceAlreadyUsed extends RuntimeException {
    private String ressourceName;
    private String fieldName;
    private Object fieldValue;
    public RessourceAlreadyUsed() {
    }
    public RessourceAlreadyUsed(String ressourceName, String fieldName, Object fieldValue) {
        super(String.format("%s Already Exists With %s : %s",ressourceName,fieldName,fieldValue));
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

