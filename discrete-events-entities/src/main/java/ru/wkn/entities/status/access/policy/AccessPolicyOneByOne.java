package ru.wkn.entities.status.access.policy;

public class AccessPolicyOneByOne implements AccessPolicy {

    private boolean hasSubscribers = false;

    @Override
    public void checkAccess() throws InterruptedException {
        synchronized (this) {
            if (hasSubscribers) {
                hasSubscribers = false;
                notify();
            }
        }

        synchronized (this) {
            if (!hasSubscribers) {
                hasSubscribers = true;
                wait();
            }
        }
    }
}
