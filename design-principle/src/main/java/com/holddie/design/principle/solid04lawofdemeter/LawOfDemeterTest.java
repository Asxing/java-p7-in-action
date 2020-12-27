package com.holddie.design.principle.solid04lawofdemeter;

/**
 * Created by Tom
 */
public class LawOfDemeterTest {

    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNumber(teamLeader);
    }

}
