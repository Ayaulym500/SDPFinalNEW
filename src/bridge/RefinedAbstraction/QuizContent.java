package bridge.RefinedAbstraction;

import bridge.abstraction.CourseContent;
import bridge.platform.Platform;

public class QuizContent extends CourseContent {
    public QuizContent(Platform platform){
        super(platform);
    }
    public void showContent(){
        platform.deliver("Interactive Quiz");
    }
}
