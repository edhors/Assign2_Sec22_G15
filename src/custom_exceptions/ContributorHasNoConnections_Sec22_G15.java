/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/
package src.custom_exceptions;
public class ContributorHasNoConnections_Sec22_G15 extends Exception {
    public ContributorHasNoConnections_Sec22_G15(String contributorName) {
        super("Contributor " + contributorName + " has no connections");
    }
}
