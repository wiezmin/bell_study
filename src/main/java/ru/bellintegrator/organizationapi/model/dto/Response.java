/*
 * Created by m.krasilnikov
 */

package ru.bellintegrator.organizationapi.model.dto;

import lombok.Data;

@Data
public class Response {

    private int status;
    private String message;

    public Response(int status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

}
