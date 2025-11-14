package bridge.RefinedAbstraction;

import bridge.abstraction.CourseContent;
import bridge.platform.Platform;

public class VideoContent extends CourseContent {
    public VideoContent(Platform platform){
        super(platform);
    }
    public void showContent(){ platform.deliver("Video Lesson");
    }
}
