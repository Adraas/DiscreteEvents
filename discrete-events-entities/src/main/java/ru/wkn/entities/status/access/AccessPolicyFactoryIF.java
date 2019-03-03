package ru.wkn.entities.status.access;

import ru.wkn.entities.status.access.policy.AccessPolicy;

public interface AccessPolicyFactoryIF {

    AccessPolicy createAccessPolicy(TypeAccessPolicy typeAccessPolicy);
}
