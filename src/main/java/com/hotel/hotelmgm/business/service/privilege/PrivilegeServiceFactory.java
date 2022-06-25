package com.hotel.hotelmgm.business.service.privilege;

public enum PrivilegeServiceFactory {

    SERVICE(new PrivilegeService());

    private final PrivilegeServiceLocal privilegeService;

    PrivilegeServiceFactory(PrivilegeServiceLocal privilegeService){
        this.privilegeService = privilegeService;
    }

    public PrivilegeServiceLocal get() {
        return privilegeService;
    }
}
