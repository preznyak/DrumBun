package hu.drumbun.commons;

public interface Validator<T> {
    ValidatorResult validate(T toValidate);
}
