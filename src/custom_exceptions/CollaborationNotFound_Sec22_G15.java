package src.custom_exceptions;

import src.edges.Collaboration_Sec22_G15;

public class CollaborationNotFound_Sec22_G15 extends Exception {
    public CollaborationNotFound_Sec22_G15(Collaboration_Sec22_G15 collaboration) {
        super("Collaboration " + collaboration.toString() + " not found");
    }
}