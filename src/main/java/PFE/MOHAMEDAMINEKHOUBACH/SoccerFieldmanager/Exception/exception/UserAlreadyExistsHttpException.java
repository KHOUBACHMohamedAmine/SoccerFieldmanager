
package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.exception;


import org.springframework.http.HttpStatus;

public class UserAlreadyExistsHttpException extends HttpException {
    private static final long serialVersionUID = -5202433948475658078L;

    public UserAlreadyExistsHttpException(String email) {
        super("Email is invalid or already taken", HttpStatus.CONFLICT);
    }
}
