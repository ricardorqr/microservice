package com.serviceDepartment.service.validation;

import java.util.ArrayList;
import java.util.Arrays;

public class Validator<T> extends ArrayList<IValidator<T>> implements IValidator<T> {

    @SafeVarargs
    public Validator(IValidator<T>... chain) {
        addAll(Arrays.asList(chain));
    }

    @Override
    public Result validate() {
        for (IValidator<T> validation : this) {
            Result result = validation.validate();
            if (result.isCorrect()) {
                return result;
            }
        }
        return new Result(false, "");
    }

}
