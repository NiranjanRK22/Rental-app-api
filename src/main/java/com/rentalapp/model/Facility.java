package com.rentalapp.model;

public enum Facility {
    parking("CAR_PARKING"),
    gym("GYM"),
    pool("SWIMMINGPOOL"),
    sports("TENNIS_COURT"),
    hall("COMMUNITY_HALL"),
    play("PLAY AREA"),
    backup("POWER BACKUP"),
    lift("LIFT"),
    security("SECURITY");

    public final String facilityName;

    /**
     *
     * @param facilityName
     */
    Facility (String facilityName)  {
        this.facilityName = facilityName;
    }
}
