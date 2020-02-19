package sample.controllers.RightClickContainer;

import sample.controllers.windows.AlertWindow;

import java.util.ArrayList;
import java.util.List;

public class ListOfObjects {

  public static List<RightClickObject> rightClickObjectList = new ArrayList<>();
  public static int a = 0;
  public static int b = 0;
  public static AlertWindow alertWindow = new AlertWindow();
  ;

  static public boolean checkAndAdd(RightClickObject rightClickObject) {
    if (rightClickObjectList.isEmpty()) {
      rightClickObjectList.add(rightClickObject);
      return true;
    } else {
      a = 0;
      for (RightClickObject r : rightClickObjectList) {
        if (r.mapIndex == rightClickObject.mapIndex
                && r.y == rightClickObject.y
                && r.x == rightClickObject.x) {
          a = 1;
          alertWindow.setAlert("Tile already used");
          return false;

        }
      }
      if (a == 0) {

        rightClickObjectList.add(rightClickObject);
        return true;
      }
    }
    return false;
  }

  static public void deleteItem(int mapIndex, int y, int x) {
    b =0;   if (!rightClickObjectList.isEmpty()) {
      for (RightClickObject r : rightClickObjectList) {
        if (r.mapIndex == mapIndex
                && r.y == y
                && r.x == x) {
          rightClickObjectList.remove(r);

          b = 1;
          break;
        }
      }


    }
  }
}