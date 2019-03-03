package ru.wkn.entities.status.access.policy;

public interface AccessPolicy {

    void checkAccess() throws InterruptedException;
}
