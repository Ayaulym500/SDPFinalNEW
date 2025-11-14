package bridge.abstraction;

import bridge.platform.Platform;

public abstract class CourseContent {
    protected Platform platform;
    public CourseContent(Platform platform){
        this.platform = platform;
    }
    public abstract void showContent();
}
