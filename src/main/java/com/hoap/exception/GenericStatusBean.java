package com.hoap.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericStatusBean {
    ErrorDetails errorDetails;
    Object data;

    public GenericStatusBean(ErrorDetails errorDetails) {
    }
}




