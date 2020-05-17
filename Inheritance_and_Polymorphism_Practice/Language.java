/* *****************************************************************************
 *  Name: Pei-Lun Hsu
 *  Date: 17.05.2020
 *  Description: Practice of Inheritance & Polymorphism "Language Family"
 **************************************************************************** */

import java.util.ArrayList;

public class Language {
    protected String name;
    protected int numSpeakers;
    protected String regionsSpoken;
    protected String wordOrder;

    public Language(String name, int numSpeakers, String regionsSpoken, String wordOrder) {
        this.name = name;
        this.numSpeakers = numSpeakers;
        this.regionsSpoken = regionsSpoken;
        this.wordOrder = wordOrder;
    }

    public void getInfo() {
        System.out.printf("%s is spoken by %d people mainly in %s.%n", name, numSpeakers,
                          regionsSpoken);
        System.out.printf("The language follows the word order: %s.%n", wordOrder);
    }

    public void setRegion(String specificRegion) {
        regionsSpoken = specificRegion;
    }

    public void changeNum(int num) {
        numSpeakers = num;
    }

    public void changeWordOrder(String newWordOrder) {
        wordOrder = newWordOrder;
    }

    public static void main(String[] args) {

        ArrayList<Language> lanList = new ArrayList<>();


        Language english = new Language("English", 2000000000, "world", "subject-verb-object");
        lanList.add(english);

        Mayan akatekk = new Mayan("Akatek", 45430);
        lanList.add(akatekk);

        SinoTibetan burmese = new SinoTibetan("Burmese", 100000);
        lanList.add(burmese);

        SinoTibetan chinese = new SinoTibetan("Mandarin Chinese", 1400000000);
        lanList.add(chinese);

        ComputerLanguage java = new ComputerLanguage("Java", 30003420, "world", "Male-Nutral");
        lanList.add(java);

        for (Language language : lanList) {
            language.getInfo();
        }

        System.out.println("");

        // test setRegion(), changeNum(), changeWordOrder()
        System.out.println("Set Akatek to Guatemala, 9999, Subject-Subject-Subject: ");
        akatekk.setRegion("Guatemala");
        akatekk.changeNum(9999);
        akatekk.changeWordOrder("S-S-S");
        akatekk.getInfo();


    }
}
