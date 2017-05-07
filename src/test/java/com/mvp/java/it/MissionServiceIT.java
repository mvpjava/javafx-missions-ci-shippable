package com.mvp.java.it;

import com.mvp.java.services.MissionsService;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MissionServiceIT {

    MissionsService missionsService;
    
    @Before
    public void before(){
        missionsService = new MissionsService();
    }

    @Test
    public void checkErrorForUnknownMissions() throws IOException {
        String missionInfo = missionsService.getMissionInfo("noSuchMission");
        Assert.assertTrue(missionInfo.contains("Unable to retrieve mission noSuchMission"));
    }

    @Test
    public void retrieveMissionSuccessfully() throws IOException {
        String missionInfo = missionsService.getMissionInfo("Apollo");
        Assert.assertTrue(missionInfo.contains("The Apollo spacecraft"));
    }
}
