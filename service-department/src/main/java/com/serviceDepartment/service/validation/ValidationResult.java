package com.serviceDepartment.service.validation;

import lombok.Value;

@Value
public class ValidationResult {

    boolean valid;
    String errorMessage;

    public static ValidationResult valid() {
        return new ValidationResult(true, null);
    }

    public static ValidationResult invalid(String message) {
        return new ValidationResult(false, message);
    }

    public boolean notValid() {
        return !valid;
    }

}
