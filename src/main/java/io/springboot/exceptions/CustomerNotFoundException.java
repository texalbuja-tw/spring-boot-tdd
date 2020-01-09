package io.springboot.exceptions;

import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.ResponseEntity;

public class CustomerNotFoundException extends Exception {
    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    ResponseEntity<VndErrors> notFoundException() {
        return notFoundException();
    }
}
