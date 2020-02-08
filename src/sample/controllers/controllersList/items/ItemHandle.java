package sample.controllers.controllersList.items;

import sample.controllers.controllersList.items.views.Item;

import java.util.ArrayList;
import java.util.List;

 class ItemHandle {

    static Item itemHandle;
    static int index;
    static String name;
    static int flag = 0;

    static List<Item> itemsList = new ArrayList<>();

    static void delete(String name)
    {
        for (int a = 0 ; a < itemsList.size() ; a++)
        {
            if(itemsList.get(a).getName().equals(name))
            {
                itemsList.remove(a);
                break;
            }
        }

    }

    static void  find (String name)
    {
        for (Item item: itemsList)
        {
            if (item.getName().equals(name))
            {
                itemHandle = item;
            }
        }

    }


}
