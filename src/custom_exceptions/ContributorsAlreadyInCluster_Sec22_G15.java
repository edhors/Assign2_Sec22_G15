/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/
package src.custom_exceptions;

import src.vertices.Contributor_Sec22_G15;

public class ContributorsAlreadyInCluster_Sec22_G15 extends Exception {
    public ContributorsAlreadyInCluster_Sec22_G15(Contributor_Sec22_G15 start) {
        super("Contributors within reach of " + start.toString() + " already in a cluster");
    }
}
