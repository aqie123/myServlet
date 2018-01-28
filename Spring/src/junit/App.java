package junit;

import action.UserAction;

public class App {
    public void testApp(){
        UserAction action = new UserAction();
        action.execute();
    }
}
