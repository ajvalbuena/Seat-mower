package app.model;

public interface Movement {

    Mower applyVector (Mower mower, Point plateauUpperLimits) throws Exception;
}
