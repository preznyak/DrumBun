package hu.drumbun.commons;

public interface OfferAndNeedValidator<T> {
    ValidatorResult validate(T toValidate,String username);
}
