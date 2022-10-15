package ir.ac.kntu;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ZooTest {
    @Test
    public void testRecords1(){
        Animal a1 = new Animal("happy1","black",0.5,30,5);
        Animal a2 = new Animal("happy2","black",0.5,60,5);
        Animal a3 = new Animal("happy3","black",0.8,50,7);
        Animal a4 =new Animal("happy4","black",0.5,40,12);
        ArrayList<Animal> animals = new ArrayList<>(Arrays.asList(a1,a2,a3,a4));
        Zoo zoo = new Zoo(animals);
        zoo.collectVulnerableAnimalRecords();
        int actual = zoo.getRecords().size();
        assertEquals(2,actual,0.000001);
    }

    @Test
    public void testRecords2(){
        Animal a1 = new Animal("happy1","black",0.5,30,5);
        Animal a2 = new Animal("happy2","black",0.5,60,5);
        Animal a3 = new Animal("happy3","black",0.8,50,7);
        Animal a4 =new Animal("happy4","black",0.5,40,12);
        ArrayList<Animal> animals = new ArrayList<>(Arrays.asList(a1, a2, a3, a4));
        Zoo zoo = new Zoo(animals);
        zoo.collectVulnerableAnimalRecords();
        ArrayList<String> records = zoo.getRecords();
        Boolean containsName = false;
        for (String i : records){
            if(i.contains("happy2")){
                containsName = true;
                break;
            }
        }
        Assert.assertTrue(containsName);
    }

    @Test
    public void testRecords3(){
        Animal a1 = new Animal("happy1","black",0.5,30,3);
        Animal a2 = new Animal("happy2","black",0.5,60,2);
        Animal a3 = new Animal("happy3","black",0.8,50,4);
        Animal a4 =new Animal("happy4","black",0.5,40,12);
        ArrayList<Animal> animals = new ArrayList<>(Arrays.asList(a1,a2,a3,a4));
        Zoo zoo = new Zoo(animals);
        zoo.collectVulnerableAnimalRecords();
        ArrayList<String> records = zoo.getRecords();
        Boolean containsName = false;
        for (String i : records){
            if(i.contains("happy4")){
                containsName = true;
                break;
            }
        }
        Assert.assertTrue(containsName);
    }
}
