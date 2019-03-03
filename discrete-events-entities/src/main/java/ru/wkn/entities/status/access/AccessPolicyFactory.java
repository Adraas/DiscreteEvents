package ru.wkn.entities.status.access;

import ru.wkn.entities.status.access.policy.AccessPolicy;
import ru.wkn.entities.status.access.policy.AccessPolicyByChance;
import ru.wkn.entities.status.access.policy.AccessPolicyOneByOne;

public class AccessPolicyFactory implements AccessPolicyFactoryIF {

    @Override
    public AccessPolicy createAccessPolicy(TypeAccessPolicy typeAccessPolicy) {
        return typeAccessPolicy.equals(TypeAccessPolicy.ONE_BY_ONE) ? new AccessPolicyOneByOne()
                : typeAccessPolicy.equals(TypeAccessPolicy.BY_CHANCE) ? new AccessPolicyByChance()
                : null;
    }
}
