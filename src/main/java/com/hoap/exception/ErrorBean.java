package com.hoap.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorBean {
    int errorCode;
    String errorDesc;

}
