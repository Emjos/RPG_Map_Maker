package sample.controllers.controllersList.monster;

import sample.controllers.Controller;
import sample.controllers.helpClass.ListHanle;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

 public class  MonsterHandle {

    static  Monster monsterHandle;
    static int index;
    static String name;
    static int flag = 0;

    public static  List<Monster> monsterList = new ArrayList<>();

    static void find (String name) {

        for (Monster monster : monsterList) {

            if (monster.getName().equals(name)) {

                monsterHandle = monster;
            }

        }
    }
        static void delete (String name){

            for (int a = 0 ; a < monsterList.size() ; a++){
                if (monsterList.get(a).getName().equals(name)){
                    monsterList.remove(a);

                    break;
                }

            }
        }

    }


