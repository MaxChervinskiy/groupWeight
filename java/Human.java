import com.sun.xml.internal.ws.api.model.ExceptionType;

/**
 * Created by maxch on 16-Sep-17.
 */
public class Human implements Comparable{
    private String name;
    private int weight;
    static final int MIN_WEIGHT = 3;
    static final int MAX_WEIGHT = 98;
    static private String[]names = {"Vasul","Petro","Sasko","Sveta","Odarka","Marusya","Ostap","Motrya","Pulup"};
    public Human() {
        name = names[(int)(Math.random()*names.length)];
        weight = (int)(Math.random()*MAX_WEIGHT+MIN_WEIGHT);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        if (Double.compare(human.weight, weight) != 0) return false;
        if (name != null ? !name.equals(human.name) : human.name != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(Object o) throws ClassCastException{
        if(!(o instanceof Human))
           throw new ClassCastException("not a Human");
        Human human = (Human)o;
        if(this.weight==human.weight)
            return 0;
        else if(this.weight>human.weight)
            return  1;
        else
            return -1;
    }
}
