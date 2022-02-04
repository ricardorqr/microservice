package com.serviceDepartment.service.validation;

public abstract class Validator<T> {

    private Validator<T> next;

    public abstract ValidationResult validate(T toValidate);

    public Validator<T> validateNext(Validator<T> next) {
        this.next = next;
        return next;
    }

    protected ValidationResult checkNext(T toValidate) {
        if (next == null) {
            return ValidationResult.valid();
        }
        return next.checkNext(toValidate);
    }

}
