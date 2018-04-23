package com.ourowproject.owproject.utilities;

public enum TeamEnum {

    LONDON_SPITFIRE(1555),
    SEOUL_DYNASTY(1554),
    SHANGHAI_DRAGONS(1553),
    FLORIDA_MAYHEM(1552),
    LOS_ANGELES_GLADIATORS(1551),
    LOS_ANGELES_VALIANTS(1550),
    SAN_FRANCISCO_SHOCK(1549),
    NEW_YORK_EXCELSIOR(1548),
    BOSTON_UPRISING(1547),
    HOUSTON_OUTLAWS(1546),
    PHILADELPHIA_FUSION(1545),
    DALLAS_FUEL(1544);


    private final Long teamId;

    TeamEnum(long teamId) {
        this.teamId = teamId;
    }

    public long getTeamId(){
        return teamId;
    }
}
