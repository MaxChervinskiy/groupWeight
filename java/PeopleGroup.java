import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by maxch on 16-Sep-17.
 */
public class PeopleGroup {
    private int halfWeith;
    private Human[]humans;
    private List<Human> firstGroup;
    private List<Human> secondGroup;

    public void start() {
        CreateHumanGroup();
        groupDivision();
        System.out.println("first group:");
        firstGroup.forEach((Human human) -> System.out.println(human.toString()));
        System.out.println("second group:");
        secondGroup.forEach((Human human) -> System.out.println(human.toString()));
    }

    private void CreateHumanGroup() {
        humans = new Human[3]; // тестовая проверка на 3-х людях
        //humans = new Human[(int)(Math.random()*20)+10]; // гинирацияя случайного количества людей в диапазоне от 10 до 29 человек
        firstGroup = new LinkedList<Human>();
        secondGroup = new LinkedList<Human>();
        InitHumans();
    }

    private void InitHumans() {
        int weightSum =0;
        for (int i = 0; i < humans.length; i++) {
            humans[i]= new Human();
            //тестовый вывод всех людей
            //System.out.println(humans[i].toString());
            weightSum += humans[i].getWeight();
        }
        halfWeith = weightSum/2;
        System.out.println("half = "+ halfWeith);
    }
    private void groupDivision(){
        try{
        Arrays.sort(humans);
        }catch (ClassCastException e){
            e.getMessage();
        }
        int sumWeightFirstGroup = 0;
        int sumWeightSecondGroup = 0;
        for (int i = humans.length-1; i >=0 ; i--) {
            int currentHumanWeight = humans[i].getWeight();
            if(sumWeightFirstGroup<sumWeightSecondGroup) {
                firstGroup.add(humans[i]);
                sumWeightFirstGroup+=currentHumanWeight;
            }
            else {
                secondGroup.add(humans[i]);
                sumWeightSecondGroup+=currentHumanWeight;
            }
        }
        //      вывод веса каждой групы для проверки условия
        System.out.println("first: "+sumWeightFirstGroup+", second: "+sumWeightSecondGroup);
    }
}
