package sample.controllers.controllersList.actions;

import sample.controllers.controllersList.items.views.Item;

import java.util.ArrayList;
import java.util.List;

public class ActionHandle {
    static Action actionHandle;
    static int flag = 0;

    public static List<Action> actionList = new ArrayList<>();


    static void delete(String name)
    {
        for (int a = 0 ; a < actionList.size() ; a++)
        {
            if(actionList.get(a).getName().equals(name))
            {
                actionList.remove(a);
                break;
            }
        }

    }

    static void  find (String name)
    {
        for (Action action: actionList)
        {
            if (action.getName().equals(name))
            {
                actionHandle = action;
            }
        }

    }



}
