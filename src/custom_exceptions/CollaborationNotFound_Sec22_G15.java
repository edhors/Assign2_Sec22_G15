/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
Alexey Gorshkov 1090711
*/
package src.custom_exceptions;

import src.edges.Collaboration_Sec22_G15;

public class CollaborationNotFound_Sec22_G15 extends Exception {
    public CollaborationNotFound_Sec22_G15(Collaboration_Sec22_G15 collaboration) {
        super("Collaboration " + collaboration.toString() + " not found");
    }
}