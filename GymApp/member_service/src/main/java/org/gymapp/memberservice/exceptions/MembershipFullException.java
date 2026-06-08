package org.gymapp.memberservice.exceptions;

public class MembershipFullException extends RuntimeException {
    public MembershipFullException(String message) {
        super(message);
    }
}
