/*
 * Copyright (c) Akveo 2019. All Rights Reserved.
 * Licensed under the Personal / Commercial License.
 * See LICENSE_PERSONAL / LICENSE_COMMERCIAL in the project root for license information on type of purchased license.
 */

package PFE.MOHAMEDAMINEKHOUBACH.SoccerFieldmanager.Exception.exception;


import org.springframework.http.HttpStatus;

public class UserNotFoundHttpException extends HttpException {
    private static final long serialVersionUID = 4770986620665158856L;

    public UserNotFoundHttpException(String message, HttpStatus status) {
        super(message, status);
    }

}
